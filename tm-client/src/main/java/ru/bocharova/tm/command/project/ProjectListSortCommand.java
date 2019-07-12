package ru.bocharova.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Project;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;

import java.util.Collection;

public class ProjectListSortCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "project-list-sort";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Sorted list project by: order, dateStart, dateEnd or status";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        System.out.println("Please input how to sort list project(order, dateStart, dateEnd, status)");
        @NotNull final String comparator = terminalService.nextLine();
        Collection<Project> sortedProjects = projectEndpoint.sortAllProjectByUserId(currentSession, comparator);
        if (sortedProjects != null && !sortedProjects.isEmpty()) {
            System.out.println("Project list sorted by " + comparator + " :");
            sortedProjects.forEach(e -> System.out.println("id: " + e.getId() +
                    " name: " + e.getName() +
                    " description: " + e.getDescription() +
                    " data start: " + e.getDateStart() +
                    " data end: " + e.getDateEnd() +
                    " status: " + e.getStatus()));
        } else {
            System.out.println("Incorrect input parameter or empty list of projects!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
