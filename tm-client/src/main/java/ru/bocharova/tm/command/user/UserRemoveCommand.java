package ru.bocharova.tm.command.user;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.ICommand;
import ru.bocharova.tm.endpoint.*;

import javax.inject.Inject;

@NoArgsConstructor
public class UserRemoveCommand implements ICommand {

    @Inject
    @NotNull
    UserEndpoint userEndpoint;

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
        return "user-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected user.";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        @Nullable final SessionDTO currentSession = sessionService.getCurrentSession();
        sessionEndpoint.validateAdminSession(currentSession);
        System.out.println("Please input user ID for remove: ");
        @Nullable final String id = terminalService.nextLine();
        userEndpoint.removeOneUser(currentSession, id);
        System.out.println("Project with id:" + id + " is remove!");
    }
}
