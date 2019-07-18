package ru.bocharova.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class ProjectEditCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "edit-project";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Edit project";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final ProjectEndpoint projectEndpoint = endpointServiceLocator.getProjectEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.print("Please input project ID for edit: ");
        @NotNull final String id = terminalService.nextLine();
        if (projectEndpoint.findOneProject(currentSession, id) != null) {
            System.out.println("Input new project's name: ");
            @NotNull final String name = terminalService.nextLine();
            System.out.println("Input new project's description: ");
            @NotNull final String description = terminalService.nextLine();
            System.out.println("Input project's status(planned, in process, done): ");
            @NotNull final String status = terminalService.nextLine();
            if (projectEndpoint.editProject(currentSession, id, name, description, status) != null) {
                System.out.println("Project " + name + " is update!");
            } else {
                System.out.println("Project name, description or status can't be empty!");
            }
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
