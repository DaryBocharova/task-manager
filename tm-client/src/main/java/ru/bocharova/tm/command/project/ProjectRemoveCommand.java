package ru.bocharova.tm.command.project;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.command.ICommand;
import ru.bocharova.tm.endpoint.*;

import javax.inject.Inject;

@NoArgsConstructor
public final class ProjectRemoveCommand implements ICommand {

    @Inject
    @NotNull
    ProjectEndpoint projectEndpoint;

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
        return "project-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected project.";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        @Nullable final SessionDTO currentSession = sessionService.getCurrentSession();
        sessionEndpoint.validateSession(currentSession);
        System.out.println("Please input project ID for remove: ");
        @Nullable final String id = terminalService.nextLine();
        projectEndpoint.removeProject(currentSession, id);
        System.out.println("Project with id:" + id + " is remove!");
    }
}
