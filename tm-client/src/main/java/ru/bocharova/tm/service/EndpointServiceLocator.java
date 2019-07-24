package ru.bocharova.tm.service;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.endpoint.SessionDTO;
import ru.bocharova.tm.api.service.IEndpointServiceLocator;
import ru.bocharova.tm.api.service.ITerminalService;
import ru.bocharova.tm.endpoint.*;

@Getter
@NoArgsConstructor
public class EndpointServiceLocator implements IEndpointServiceLocator {

    @NotNull
    @Getter
    private final ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    @Getter
    @NotNull
    private final TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    @NotNull
    @Getter
    private final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    @Getter
    @NotNull
    private final SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    @Getter
    @NotNull
    private final ITerminalService terminalService = new TerminalService();

    @Setter
    @Nullable
    private SessionDTO sessionDTO;
}