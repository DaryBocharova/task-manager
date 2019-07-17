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

public class ProjectListCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "list-project";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all project or selected project.";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("List of projects:");
        @NotNull final Collection<Project> findProjects = projectEndpoint.findAllProjectByUserId(currentSession);
        if (findProjects != null && !findProjects.isEmpty()) {
            findProjects.forEach(e -> System.out.println("id: " + e.getId() + " name: " + e.getName()));
        } else {
            System.out.println("List of project is empty!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}

