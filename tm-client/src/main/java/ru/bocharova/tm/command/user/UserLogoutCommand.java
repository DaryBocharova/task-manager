package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.endpoint.UserEndpoint;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class UserLogoutCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "user-logout";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Logout user";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        @NotNull final SessionEndpoint sessionEndpoint = endpointServiceLocator.getSessionEndpoint();
        sessionEndpoint.validateAdminSession(currentSession);
        @NotNull final String login = userEndpoint.getUserBySession(currentSession).getLogin();
        sessionEndpoint.closeSession(currentSession);
        System.out.println("Session id:" + currentSession.getId() + " was close!");
        System.out.println("User " + login + " logout!");
        endpointServiceLocator.setSession(null);
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return false;
    }
}
