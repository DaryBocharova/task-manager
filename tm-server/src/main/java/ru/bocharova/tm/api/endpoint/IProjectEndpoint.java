package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.model.dto.ProjectDTO;
import ru.bocharova.tm.model.dto.SessionDTO;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    void createProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "project") @Nullable final ProjectDTO projectDTO
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void editProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "project") @Nullable final ProjectDTO projectDTO
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    ProjectDTO findOneProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "id") @Nullable final String id
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void removeProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "id") @Nullable final String id
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<ProjectDTO> findAllProjectByUserId(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void removeAllProjectByUserId(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<ProjectDTO> sortAllProjectByUserId(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "parameter") @Nullable final String parameter
    ) throws AuthenticationSecurityException, DataValidateException;

    @WebMethod
    Collection<ProjectDTO> findAllProjectByPartOfNameOrDescription(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "name") @Nullable final String name,
            @WebParam(name = "description") @Nullable final String description
    ) throws AuthenticationSecurityException, DataValidateException;
}
