package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Session;

import javax.xml.ws.Endpoint;

public interface IServiceLocator {

    IProjectService getProjectService();
    ITaskService getTaskService();
    IUserService getUserService();
    ISessionService getSessionService();
    Session getSession();
    void setSession(@NotNull final Session session);
}
