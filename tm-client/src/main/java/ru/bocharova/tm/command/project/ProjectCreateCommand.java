package ru.bocharova.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class ProjectCreateCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "create-project";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create new project";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Please input project name:");
        @NotNull final String name = terminalService.nextLine();
        System.out.println("Please input project description:");
        @NotNull final String description = terminalService.nextLine();
        if (projectEndpoint.createProject(currentSession, name, description) != null) {
            System.out.println("Project " + name + " is createProject!");
        } else {
            System.out.println("Project " + name + " does not createProject!");
            System.out.println("Project name or description does not empty");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
