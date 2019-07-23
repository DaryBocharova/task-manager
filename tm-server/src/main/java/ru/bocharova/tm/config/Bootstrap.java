package ru.bocharova.tm.config;

import lombok.NoArgsConstructor;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.dto.*;
import ru.bocharova.tm.api.service.*;
import ru.bocharova.tm.model.entity.*;
import ru.bocharova.tm.service.*;

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Bootstrap {

    @NotNull
    final IPropertyService propertyService = new PropertyService();

    public void init(Class[] endpoints) throws IOException {
        @NotNull final EntityManagerFactory entityManagerFactory = factory();
        @NotNull final IProjectService projectService = new ProjectService(entityManagerFactory);
        @NotNull final ITaskService taskService = new TaskService(entityManagerFactory);
        @NotNull final IUserService userService = new UserService(entityManagerFactory);
        @NotNull final ISessionService sessionService = new SessionService(entityManagerFactory, propertyService);
        @NotNull final IServiceLocator serviceLocator = new ServiceLocator(projectService, taskService, userService, sessionService);

        generateTestData(serviceLocator);
        registryEndpoint(endpoints, serviceLocator);
    }

    private void registryEndpoint(Class[] endpoints, IServiceLocator serviceLocator) {

        for (Class endpoint : endpoints) {
            if (endpoint == null) continue;
            Constructor endpointConstructor = null;
            try {
                endpointConstructor = endpoint.getConstructor(IServiceLocator.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            String wsdl = "http://localhost:80/" + endpoint.getSimpleName() + "?wsdl";
            try {
                Endpoint.publish(wsdl, endpointConstructor.newInstance(serviceLocator));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(wsdl);
        }
    }

    private EntityManagerFactory factory() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, propertyService.getJdbcDriver());
        settings.put(Environment.URL, propertyService.getJdbcURL());
        settings.put(Environment.USER, propertyService.getJdbcUser());
        settings.put(Environment.PASS, propertyService.getJdbcPassword());
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.SHOW_SQL, "true");
        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Task.class);
        sources.addAnnotatedClass(Project.class);
        sources.addAnnotatedClass(User.class);
        sources.addAnnotatedClass(Session.class);
        sources.addAnnotatedClass(SessionDTO.class);
        sources.addAnnotatedClass(TaskDTO.class);
        sources.addAnnotatedClass(ProjectDTO.class);
        sources.addAnnotatedClass(UserDTO.class);
        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    private void generateTestData(IServiceLocator serviceLocator) {
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull final IUserService userService = serviceLocator.getUserService();
        @NotNull final ISessionService sessionService = serviceLocator.getSessionService();

        try {
            projectService.create(new ProjectDTO("My_project_1", "Description for my project 1", userService.findByLogin("admin").getId()));
            projectService.create(new ProjectDTO("My_project_2", "Description for my project 2", userService.findByLogin("admin").getId()));
            projectService.create(new ProjectDTO("My_project_3", "Description for my project 3", userService.findByLogin("user").getId()));
            projectService.create(new ProjectDTO("My_project_4", "Description for my project 4", userService.findByLogin("user").getId()));

            for (ProjectDTO project : projectService.findAllByUserId(userService.findByLogin("admin").getId())) {
                taskService.create(new TaskDTO("task_100", "Description for task 100", project.getId(), userService.findByLogin("admin").getId()));
                taskService.create(new TaskDTO("task_200", "Description for task 200", project.getId(), userService.findByLogin("admin").getId()));
                taskService.create(new TaskDTO("task_300", "Description for task 300", project.getId(), userService.findByLogin("admin").getId()));
                taskService.create(new TaskDTO("task_400", "Description for task 400", project.getId(), userService.findByLogin("admin").getId()));
            }

            for (ProjectDTO project : projectService.findAllByUserId(userService.findByLogin("user").getId())) {
                taskService.create(new TaskDTO("task_1", "Description for task 1", project.getId(), userService.findByLogin("user").getId()));
                taskService.create(new TaskDTO("task_2", "Description for task 2", project.getId(), userService.findByLogin("user").getId()));
                taskService.create(new TaskDTO("task_3", "Description for task 3", project.getId(), userService.findByLogin("user").getId()));
                taskService.create(new TaskDTO("task_4", "Description for task 4", project.getId(), userService.findByLogin("user").getId()));
            }
        } catch (DataValidateException e) {
            e.printStackTrace();
        }
    }
}