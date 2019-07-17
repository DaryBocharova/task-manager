package ru.bocharova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.UserEndpoint;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

public class UserProfileEditCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "user-profile-edit";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Edit user's profile.";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Welcome to editor user: " + userEndpoint.getUserBySession(currentSession) + "profile: ");
        System.out.println("Please input login: ");
        @NotNull
        String login = terminalService.nextLine();
        @Nullable
        User user = userEndpoint.findUserByLogin(currentSession, login);
        if (user == null) {
            System.out.println("Please input password:");
            @NotNull
            String password = terminalService.nextLine();
            if (userEndpoint.editUserProfile(currentSession, login, password) != null) {
                System.out.println("User profile had been changed!");
            } else {
                System.out.println("Incorrect input login or password!");
            }
        } else {
            System.out.println("Login already exist!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
