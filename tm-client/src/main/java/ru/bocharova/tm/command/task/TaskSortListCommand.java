package ru.bocharova.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.TaskEndpoint;
import ru.bocharova.tm.model.entity.Session;
import ru.bocharova.tm.model.entity.Task;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import java.util.Collection;

public class TaskSortListCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "task-sort";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Sorted list task by: order, dateStart, dateEnd or status";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final TaskEndpoint taskEndpoint = endpointServiceLocator.getTaskEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Please input how to sort list task(order, dateStart, dateEnd, status)");
        @NotNull final String comparator = terminalService.nextLine();
        Collection<Task> sortedTasks = taskEndpoint.sortAllTaskByUserId(currentSession, comparator);
        if (sortedTasks != null && !sortedTasks.isEmpty()) {
            System.out.println("List task's sorted by " + comparator + " :");
            sortedTasks.forEach(e -> System.out.println("id: " + e.getId() +
                    " name: " + e.getName() +
                    " description: " + e.getDescription() +
                    " data start: " + e.getDateStart() +
                    " data end: " + e.getDateEnd() +
                    " status: " + e.getStatus()));
        } else {
            System.out.println("Incorrect input parameter or task list is empty!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
