package ru.bocharova.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import java.util.Collection;

public class ProjectFindPartCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "project-find";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Search project on name part or description part";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Enter part of the name of the project: ");
        String namePart = terminalService.nextLine();
        System.out.println("Enter part of the description of the project: ");
        String descPart = terminalService.nextLine();
        @NotNull final Collection<Project> findProjects = projectEndpoint.findAllProjectByPartOfNameOrDescription(currentSession, namePart, descPart);
        if (findProjects != null && !findProjects.isEmpty()) {
            System.out.println("Find projects by part of name '" + namePart + "' or part of description '" + descPart + "' :");
            findProjects.forEach(e -> System.out.println("id: " + e.getId() +
                    " name: " + e.getName() +
                    " description: " + e.getDescription() +
                    " data start: " + e.getDateStart() +
                    " data end: " + e.getDateEnd() +
                    " status: " + e.getStatus()));
        } else {
            System.out.println("Projects does not found!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
