package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.endpoint.*;
import ru.bocharova.tm.entity.Session;


public interface IEndpointServiceLocator {
    ProjectEndpoint getProjectEndpoint();
    TaskEndpoint getTaskEndpoint();
    UserEndpoint getUserEndpoint();
    SessionEndpoint getSessionEndpoint();
    AdminEndpoint getAdminEndpoint();
    ITerminalService getTerminalService();
    Session getSession();
    void setSession(@NotNull final Session session);
}
