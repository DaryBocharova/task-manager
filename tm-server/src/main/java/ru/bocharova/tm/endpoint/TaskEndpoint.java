package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.ITaskEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITaskService;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.Task;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@NoArgsConstructor
@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.ITaskEndpoint")
public class TaskEndpoint implements ITaskEndpoint {

    @NotNull
    private ISessionService sessionService;

    @NotNull
    private ITaskService taskService;

    public TaskEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.sessionService = serviceLocator.getSessionService();
        this.taskService = serviceLocator.getTaskService();
    }

    @Override
    @WebMethod
    public Task createTask(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "name") @NotNull final String name,
                           @WebParam(name = "description") @NotNull final String description,
                           @WebParam(name = "projectId") @NotNull final String projectId) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.create(name, description, projectId, session.getUserId());
    }

    @Override
    @WebMethod
    public Task editTask(@WebParam(name = "session") @NotNull final Session session,
                         @WebParam(name = "Id") @NotNull final String id,
                         @WebParam(name = "name") @NotNull final String name,
                         @WebParam(name = "description") @NotNull final String description,
                         @WebParam(name = "status") @NotNull final String status) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.edit(id, name, description, status);
    }

    @Override
    @WebMethod
    public Task findOneTask(@WebParam(name = "session") @NotNull final Session session,
                            @WebParam(name = "Id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.findOne(id, session.getUserId());
    }

    @Override
    @WebMethod
    public Task removeTask(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "Id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.remove(id, session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<Task> findAllTaskByProjectId(@WebParam(name = "session") @NotNull final Session session,
                                                   @WebParam(name = "Id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.findAllByProjectId(id, session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<Task> findAllTaskByUserId(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.findAllByUserId(session.getUserId());
    }

    @Override
    @WebMethod
    public void removeAllTaskByProjectId(@WebParam(name = "session") @NotNull final Session session,
                                         @WebParam(name = "Id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        taskService.removeAllByProjectId(id, session.getUserId());
    }

    @Override
    @WebMethod
    public void removeAllTaskByUserId(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        taskService.removeAllByUserId(session.getUserId());

    }

    @Override
    @WebMethod
    public Collection<Task> sortAllTaskByUserId(@WebParam(name = "session") @NotNull final Session session,
                                                @WebParam(name = "comparator") @NotNull final String comparator) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.sortAllByUserId(session.getUserId(), comparator);
    }

    @Override
    @WebMethod
    public Collection<Task> findAllTaskByPartOfNameOrDescription(@WebParam(name = "session") @NotNull final Session session,
                                                                 @WebParam(name = "name") @NotNull final String name,
                                                                 @WebParam(name = "description") @NotNull final String description) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return taskService.findAllByPartOfNameOrDescription(name, description, session.getUserId());
    }
}
