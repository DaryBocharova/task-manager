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
import ru.bocharova.tm.entity.Session;

@NoArgsConstructor
@Getter
public class EndpointServiceLocator implements IEndpointServiceLocator {

    @NotNull private ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
    @NotNull private final TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
    @NotNull private UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    @NotNull private SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
    @NotNull private ITerminalService terminalService = new TerminalService();

    @Setter
    @Nullable
    private Session session;

    @Override
    public AdminEndpoint getAdminEndpoint() {
        return null;
    }

    @Override
    public void setSession(@NotNull Session session) {
    }
}