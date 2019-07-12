package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.api.endpoint.User;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.UserEndpoint;

public class UserProfileViewCommand extends AbstractCommand {
    @Override
    public String getName() {
        return "user-profile-view";
    }


    @Override
    public String getDescription() {
        return "View user profile.";
    }

    @Override
    public void execute() throws AuthenticationSecurityException_Exception {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        @Nullable final User currentUser = userEndpoint.getUserBySession(currentSession);
        System.out.println("Welcome to user: " + userEndpoint.getUserBySession(currentSession) + " profile ");
        System.out.println(currentUser);
    }

    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
