package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.dto.*;
import ru.bocharova.tm.api.endpoint.ITaskEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.ITaskService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

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
    public void createTask(@WebParam(name = "task") @NotNull final TaskDTO taskDTO,
                           @WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        taskService.create(taskDTO);
    }

    @Override
    @WebMethod
    public void editTask(@WebParam(name = "task") @NotNull final TaskDTO taskDTO,
                         @WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        taskService.edit(taskDTO);
    }

    @Override
    @WebMethod
    public TaskDTO findOneTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                               @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return taskService.findOne(id, sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public void removeTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                           @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        taskService.remove(id, sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public Collection<TaskDTO> findAllTaskByProjectId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                                      @WebParam(name = "id") @NotNull final String id) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return taskService.findAllByProjectId(id, sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public Collection<TaskDTO> findAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return taskService.findAllByUserId(sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public void removeAllTaskByProjectId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                         @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        taskService.removeAllByProjectId(id, sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public void removeAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        taskService.removeAllByUserId(sessionDTO.getUserId());

    }

    @Override
    @WebMethod
    public Collection<TaskDTO> sortAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                                   @WebParam(name = "parameter") @NotNull final String parameter) throws
            AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return taskService.sortAllByUserId(sessionDTO.getUserId(), parameter);
    }

    @Override
    @WebMethod
    public Collection<TaskDTO> findAllTaskByPartOfNameOrDescription(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                                                    @WebParam(name = "name") @NotNull final String name,
                                                                    @WebParam(name = "description") @NotNull final String description)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return taskService.findAllByPartOfNameOrDescription(name, description, sessionDTO.getUserId());
    }
}
