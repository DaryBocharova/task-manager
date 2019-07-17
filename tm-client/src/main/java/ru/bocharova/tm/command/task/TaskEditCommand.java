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
import ru.bocharova.tm.entity.Task;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class TaskEditCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "edit-task";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Edit select task";
    }

    @NotNull
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
            System.out.println("Please input id task:");
            @NotNull final String taskId = terminalService.nextLine();
            @Nullable final Task task = taskEndpoint.findOneTask(currentSession, taskId);
            System.out.println("Please input name: ");
            @NotNull final String name = terminalService.nextLine();
            System.out.println("Please input description: ");
            @NotNull final String description = terminalService.nextLine();
            System.out.println("Please input status (planned, done, in process): ");
            @NotNull final String status = terminalService.nextLine();
            if (taskEndpoint.editTask(currentSession, taskId, name, description, status) != null) {
                System.out.println("Task id: " + id + "edit is complete!");
            } else {
                System.out.println("Task name or description can't be empty!");
            }
        } else {
            System.out.println("Task id: " + id + " is not found!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
