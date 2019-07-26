package ru.bocharova.tm.command.project;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.endpoint.*;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.api.command.AbstractCommand;

import javax.inject.Inject;

@NoArgsConstructor
public class ProjectPrintCommand implements AbstractCommand {
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
        return "project-print";
    }

    @Override
    public String getDescription() {
        return "Print project by id.";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        @Nullable final SessionDTO currentSession = sessionService.getCurrentSession();
        sessionEndpoint.validateAdminSession(currentSession);
        System.out.println("Please input project ID for print: ");
        @Nullable final String id = terminalService.nextLine();
        @NotNull final ProjectDTO findProject = projectEndpoint.findOneProject(currentSession, id);
        System.out.println("id: " + findProject.getId() +
                "\nname: " + findProject.getName() +
                "\ndescription: " + findProject.getDescription() +
                "\ndata start: " + findProject.getDateBegin() +
                "\ndata end: " + findProject.getDateEnd() +
                "\nstatus: " + findProject.getStatus());

    }
}
