package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.UserEndpoint;

public class UserListCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "user-list";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Print list of users.";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        userEndpoint.findAllUser(currentSession).forEach(e -> System.out.println("id: " + e.getId() +
                " login: " + e.getLogin() +
                " role: " + e.getRole()));
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
