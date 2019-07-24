package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.SessionDTO;
import ru.bocharova.tm.endpoint.*;

public interface IEndpointServiceLocator {

    ProjectEndpoint getProjectEndpoint();

    TaskEndpoint getTaskEndpoint();

    UserEndpoint getUserEndpoint();

    SessionEndpoint getSessionEndpoint();

    ITerminalService getTerminalService();

    SessionDTO getSessionDTO();

    void setSessionDTO(@NotNull final SessionDTO sessionDTO);
}
