package ru.bocharova.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Project;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.api.endpoint.Task;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;

import java.util.Collection;

public class TaskListCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "list-task";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "List task select project or all task";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final TaskEndpoint taskEndpoint = endpointServiceLocator.getTaskEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        System.out.print("Please input project id or press ENTER for print all tasks:");
        @Nullable final Collection<Task> findTasks;
        @NotNull final String id = terminalService.nextLine();
        if ("".equals(id)) {
            findTasks = taskEndpoint.findAllTaskByUserId(currentSession);
            if (findTasks == null || findTasks.isEmpty()) {
                System.out.println("List task is empty!");
                return;
            }
            findTasks.forEach(e -> System.out.println("id:" + e.getId() + " name:" + e.getName() + " project_id:" + e.getProjectID()));
            return;
        }

        @Nullable final Project project = projectEndpoint.findOneProject(currentSession, id);
        if (project != null) {
            findTasks = taskEndpoint.findAllTaskByProjectId(currentSession, id);
            if (findTasks == null || findTasks.isEmpty()) {
                System.out.println("List task for project id:" + id + " is empty!");
                return;
            }
            findTasks.forEach(e -> System.out.println("id:" + e.getId() + " name:" + e.getName()));
        } else {
            System.out.println("Project id: " + id + " does not found!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
