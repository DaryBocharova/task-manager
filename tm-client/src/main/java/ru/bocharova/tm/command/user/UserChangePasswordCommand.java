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

public class UserChangePasswordCommand extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "user-change-pass";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Change user password.";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception, AuthenticationSecurityException {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final ITerminalService terminalService = endpointServiceLocator.getTerminalService();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateAdminSession(currentSession);
        System.out.println("Please input user name:");
        @NotNull final String login = terminalService.nextLine();
        @Nullable final User user = userEndpoint.findUserByLogin(currentSession, login);
        if (user != null) {
            System.out.println("Please input password:");
            @NotNull
            String password = terminalService.nextLine();
            if (userEndpoint.changeUserPassword(currentSession, user.getId(), user.getLogin(), password, user.getRole().toString()) != null) {
                System.out.println("User " + login + " password changed!");
            } else {
                System.out.println("Password does not change!!");
            }
        } else {
            System.out.println("User does not found!");
        }
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}
