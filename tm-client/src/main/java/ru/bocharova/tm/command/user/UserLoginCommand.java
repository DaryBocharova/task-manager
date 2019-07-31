package ru.bocharova.tm.command.user;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.ICommand;
import ru.bocharova.tm.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.endpoint.DataValidateException_Exception;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.util.HashUtil;

import javax.inject.Inject;

@NoArgsConstructor
public final class UserLoginCommand implements ICommand {

    @Inject
    @NotNull
    SessionEndpoint sessionEndpoint;

    @Inject
    @NotNull
    ISessionService sessionService;

    @Inject
    @NotNull
    ITerminalService terminalService;

    @Override
    public String getName() {
        return "user-login";
    }

    @Override
    public String getDescription() {
        return "User login";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        System.out.println("Please input user name:");
        @Nullable final String login = terminalService.nextLine();
        System.out.println("Please input password:");
        @Nullable final String password = terminalService.nextLine();
        sessionService.setCurrentSession(sessionEndpoint.openSession(login, HashUtil.md5(password)));
        System.out.println("User '" + login + "' login in application!");
    }
}
