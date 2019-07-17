package ru.bocharova.tm.api.service;

public interface IServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IUserService getUserService();

    ISessionService getSessionService();
}
