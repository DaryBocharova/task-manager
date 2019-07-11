package ru.bocharova.tm.service;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.api.repository.ITaskRepository;
import ru.bocharova.tm.api.service.*;
import ru.bocharova.tm.repository.ProjectRepository;
import ru.bocharova.tm.repository.SessionRepository;
import ru.bocharova.tm.repository.TaskRepository;
import ru.bocharova.tm.repository.UserRepository;
import ru.bocharova.tm.api.repository.IProjectRepository;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.entity.Session;

import javax.xml.ws.Endpoint;

public final class ServiceLocator implements IServiceLocator {

    @Getter
    @Setter
    @NotNull
    private Session session = new Session();

    @NotNull
    final private IProjectRepository projectRepository = new ProjectRepository();
    @NotNull
    final private ITaskRepository taskRepository = new TaskRepository();
    @NotNull
    final private IUserRepository userRepository = new UserRepository();
    @NotNull
    final private ISessionRepository sessionRepository = new SessionRepository();

    @Getter
    @NotNull
    final private IProjectService projectService = new ProjectService(projectRepository);

    @Getter
    @NotNull
    final private ITaskService taskService = new TaskService(taskRepository);

    @Getter
    @NotNull
    final private IUserService userService = new UserService(userRepository, projectRepository, taskRepository);

    @Getter
    @NotNull
    final private ISessionService sessionService = new SessionService(sessionRepository, userRepository);
}
