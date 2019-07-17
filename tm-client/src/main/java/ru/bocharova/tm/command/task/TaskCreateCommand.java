package ru.bocharova.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class TaskCreateCommand extends AbstractCommand {
    @Override
    public String getName() {
        return "create-task";
    }

    @Override
    public String getDescription() {
        return "Create new task";
    }

    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final TaskEndpoint taskEndpoint = endpointServiceLocator.getTaskEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Please input id project:");
        @NotNull final String id = terminalService.nextLine();
        @Nullable final Project project = projectEndpoint.findOneProject(currentSession, id);
        if (project != null) {
            System.out.println("Please input task name:");
            @NotNull final String name = terminalService.nextLine();
            System.out.println("Please input task description:");
            @NotNull final String description = terminalService.nextLine();
            if (taskEndpoint.createTask(currentSession, name, description, id) != null) {
                System.out.println("Task " + name + " is create!");
            } else {
                System.out.println("Task " + name + " does not create!");
                System.out.println("Task name or description can't be empty!");
            }
        } else {
            System.out.println("Project id: " + id + " does not found!");
        }
    }

    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
