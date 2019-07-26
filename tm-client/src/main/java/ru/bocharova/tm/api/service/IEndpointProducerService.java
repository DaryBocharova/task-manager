package ru.bocharova.tm.api.service;

import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;
import ru.bocharova.tm.endpoint.UserEndpoint;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IEndpointProducerService {
    ProjectEndpoint getProjectEndpoint();

    TaskEndpoint getTaskEndpoint();

    SessionEndpoint getSessionEndpoint();

    UserEndpoint getUserEndpoint();
}
