package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.DTO.TaskDTO;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface ITaskEndpoint extends IEndPoint {

    @WebMethod
    void createTask(@WebParam(name = "task") @NotNull final TaskDTO taskDTO,
                       @WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void editTask(@WebParam(name = "task") @NotNull final TaskDTO taskDTO,
                     @WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    TaskDTO findOneTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                        @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    void removeTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                       @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    Collection<TaskDTO> findAllTaskByProjectId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                               @WebParam(name = "id") @NotNull final String id) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<TaskDTO> findAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void removeAllTaskByProjectId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                  @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    void removeAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<TaskDTO> sortAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                            @WebParam(name = "parameter") @NotNull final String parameter) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<TaskDTO> findAllTaskByPartOfNameOrDescription(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                                             @WebParam(name = "name") @NotNull final String name,
                                                             @WebParam(name = "description") @NotNull final String description)
            throws AuthenticationSecurityException, DataValidateException;
}
