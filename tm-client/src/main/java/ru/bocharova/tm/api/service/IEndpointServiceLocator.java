package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;
import ru.bocharova.tm.endpoint.UserEndpoint;


public interface IEndpointServiceLocator {
    ProjectEndpoint getProjectEndpoint();
    TaskEndpoint getTaskEndpoint();
    UserEndpoint getUserEndpoint();
    SessionEndpoint getSessionEndpoint();
    ITerminalService getTerminalService();
    Session getSession();
    void setSession(@NotNull final Session session);
}
