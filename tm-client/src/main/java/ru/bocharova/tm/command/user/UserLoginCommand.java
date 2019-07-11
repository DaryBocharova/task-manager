package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import java.io.IOException;

public class UserLoginCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "user-login";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "User login";
    }

    @NotNull
    @Override
    public void execute() throws IOException, AuthenticationSecurityException {
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        @NotNull final SessionEndpoint sessionEndpoint = endpointServiceLocator.getSessionEndpoint();
        System.out.println("Please input user name:");
        @NotNull final String login = terminalService.nextLine();
        System.out.println("Please input password:");
        @NotNull final String password = terminalService.nextLine();
        endpointServiceLocator.setSession(sessionEndpoint.openSession(login,password));
        System.out.println("User '" + login + "' login in application!");
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return false;
    }
}
