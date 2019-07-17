package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.UserEndpoint;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class UserRegisterCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "register-user";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Registration new user";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Please input user name:");
        @NotNull
        String login = terminalService.nextLine();
        if (userEndpoint.findUserByLogin(currentSession, login) == null) {
            System.out.println("Please input password:");
            @NotNull
            String password = terminalService.nextLine();
            System.out.println("Please input user role(admin or user):");
            @NotNull
            String role = terminalService.nextLine();
            if (userEndpoint.createUser(currentSession, login, password, role) != null) {
                System.out.println("User " + login + " created!");
            } else {
                System.out.println("User " + login + " is not created!");
            }
        } else {
            System.out.println("User name already exist!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return false;
    }
}
