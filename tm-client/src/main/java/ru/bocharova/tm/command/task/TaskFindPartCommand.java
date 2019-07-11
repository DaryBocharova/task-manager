package ru.bocharova.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.api.endpoint.Task;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;

import java.util.Collection;

public class TaskFindPartCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "find-task";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Search task on name part or description part";
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
        System.out.println("Enter part of the name of the task: ");
        String namePart = terminalService.nextLine();
        System.out.println("Enter part of the description of the task: ");
        String descPart = terminalService.nextLine();
        @NotNull final Collection<Task> findTasks = taskEndpoint.findAllTaskByPartOfNameOrDescription(currentSession, namePart, descPart);
        if (findTasks != null && !findTasks.isEmpty()) {
            System.out.println("Find tasks by part of name '" + namePart + "' or part of description '" + descPart + "' :");
            findTasks.forEach(e -> System.out.println("id: " + e.getId() +
                    " name: " + e.getName() +
                    " description: " + e.getDescription() +
                    " data start: " + e.getDateStart() +
                    " data end: " + e.getDateEnd() +
                    " status: " + e.getStatus()));
        } else {
            System.out.println("Tasks does not found!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
