package ru.bocharova.tm.command.task;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.endpoint.*;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.api.command.AbstractCommand;

import javax.inject.Inject;

@NoArgsConstructor
public class TaskPrintCommand implements AbstractCommand {

    @Inject
    @NotNull
    TaskEndpoint taskEndpoint;

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
        return "task-print";
    }

    @Override
    public String getDescription() {
        return "Print task by id.";
    }

    @Override
    public void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception {
        @Nullable final SessionDTO currentSession = sessionService.getCurrentSession();
        sessionEndpoint.validateAdminSession(currentSession);
        System.out.println("Input task id for print: ");
        @Nullable final String id = terminalService.nextLine();
        @Nullable TaskDTO task = taskEndpoint.findOneTask(currentSession, id);
        System.out.println("id: " + task.getId() +
                "\nname: " + task.getName() +
                "\ndescription: " + task.getDescription() +
                "\ndata start: " + task.getDateBegin() +
                "\ndata end: " + task.getDateEnd() +
                "\nstatus: " + task.getStatus());
    }
}