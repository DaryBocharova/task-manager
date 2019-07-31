package ru.bocharova.tm.command.user;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.command.ICommand;
import ru.bocharova.tm.endpoint.*;

import javax.inject.Inject;

@NoArgsConstructor
public final class UserLogoutCommand implements ICommand {

    @Inject
    @NotNull
    UserEndpoint userEndpoint;

    @Inject
    @NotNull
    SessionEndpoint sessionEndpoint;

    @Inject
    @NotNull
    ISessionService sessionService;

    @Override
    public String getName() {
        return "user-logout";
    }

    @Override
    public String getDescription() {
        return "Logout user";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        @NotNull final SessionDTO currentSession = sessionService.getCurrentSession();
        sessionEndpoint.validateSession(currentSession);
        @Nullable final String login = userEndpoint.getUserBySession(currentSession).getLogin();
        sessionEndpoint.closeSession(currentSession);
        System.out.println("Session id:" + currentSession.getId() + " was close!");
        System.out.println("User " + login + " logout!");
        sessionService.setCurrentSession(null);
    }
}
