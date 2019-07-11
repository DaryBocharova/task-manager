package ru.bocharova.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.*;
import ru.bocharova.tm.api.service.IEndpointServiceLocator;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.endpoint.*;

@NoArgsConstructor
@Getter
public class EndpointServiceLocator implements IEndpointServiceLocator {

    @NotNull private IProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
    @NotNull private final ITaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
    @NotNull private IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    @NotNull private ISessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
    @NotNull private ITerminalService terminalService = new TerminalService();

    @Setter
    @Nullable
    private Session session;
}