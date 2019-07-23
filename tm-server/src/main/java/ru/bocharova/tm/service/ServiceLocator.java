package ru.bocharova.tm.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.service.*;

public final class ServiceLocator implements IServiceLocator {

    @Getter
    @NotNull
    final private IProjectService projectService;
    @Getter
    @NotNull
    final private ITaskService taskService;

    @Getter
    @NotNull
    final private IUserService userService;

    @Getter
    @NotNull
    final private ISessionService sessionService;

    public ServiceLocator(@NotNull IProjectService projectService,@NotNull ITaskService taskService,
                          @NotNull IUserService userService, @NotNull ISessionService sessionService
    ) {
        this.projectService = projectService;
        this.sessionService = sessionService;
        this.taskService = taskService;
        this.userService = userService;
    }
}
