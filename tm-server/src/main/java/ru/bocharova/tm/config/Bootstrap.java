package ru.bocharova.tm.config;

import lombok.NoArgsConstructor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.repository.IProjectRepository;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.api.repository.ITaskRepository;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.api.service.*;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.service.*;


import javax.sql.DataSource;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@NoArgsConstructor
public class Bootstrap {

    @NotNull
    final IPropertyService propertyService = new PropertyService();
    @NotNull
    final SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    @NotNull
    final IProjectService projectService = new ProjectService(sqlSessionFactory);
    @NotNull
    final ITaskService taskService = new TaskService(sqlSessionFactory);
    @NotNull
    final IUserService userService = new UserService(sqlSessionFactory);
    @NotNull
    final ISessionService sessionService = new SessionService(sqlSessionFactory, propertyService);
    @NotNull
    final IServiceLocator serviceLocator = new ServiceLocator(projectService, taskService, userService, sessionService);

    public void init(Class[] endpoints) throws IOException {

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

    public SqlSessionFactory getSqlSessionFactory() {
        @Nullable final String user = propertyService.getJdbcUser();
        @Nullable final String password = propertyService.getJdbcPassword();
        @Nullable final String url = propertyService.getJdbcURL();
        @Nullable final String driver = propertyService.getJdbcDriver();
        final DataSource dataSource =
                new PooledDataSource(driver, url, user, password);
        final TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        final Environment environment =
                new Environment("development", transactionFactory, dataSource);
        final Configuration configuration = new Configuration(environment);
        configuration.addMapper(IUserRepository.class);
        configuration.addMapper(IProjectRepository.class);
        configuration.addMapper(ISessionRepository.class);
        configuration.addMapper(ITaskRepository.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    private void generateTestData(IServiceLocator serviceLocator) throws IOException {
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull final IUserService userService = serviceLocator.getUserService();
        @NotNull final ISessionService sessionService = serviceLocator.getSessionService();

        if (userService.findOne("d29e9b42-9b97-ab6f-bc0c-2c3f938d144e4") == null) {
            userService.create("d29e9b42-9b97-ab6f-bc0c-2c3f938d144e4", "admin", "123456", "admin");
            projectService.create("d29e9b42-9b97-ab6f-bc0c-2c3f938d144e4", "da", "dfae");
            for (Project project : projectService.findAllByUserId(userService.findByLogin("admin").getId())) {
                taskService.create("task_2", "Description for task 2", project.getId(), userService.findByLogin("admin").getId());
            }
        }

        if (userService.findOne("d29e9b42-9b97-ab6f-bc0c-2c3f938d444e4") == null) {
            userService.create("d29e9b42-9b97-ab6f-bc0c-2c3f938d444e4", "user", "123456", "user");
            projectService.create("d29e9b42-9b97-ab6f-bc0c-2c3f938d124e4", "daв", "dfaвe");
            for (Project project : projectService.findAllByUserId(userService.findByLogin("user").getId())) {
                taskService.create("task_1", "Description for task 1", project.getId(), userService.findByLogin("user").getId());
            }
        }
    }
}
