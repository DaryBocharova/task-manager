package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.*;
import ru.bocharova.tm.api.endpoint.IProjectEndpoint;
import ru.bocharova.tm.api.service.IProjectService;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.IProjectEndpoint")
@NoArgsConstructor
public class ProjectEndpoint implements IProjectEndpoint {

    @NotNull
    private IProjectService projectService;

    @NotNull
    private ISessionService sessionService;

    public ProjectEndpoint(
            @NotNull final IServiceLocator serviceLocator) {
        this.projectService = serviceLocator.getProjectService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public void createProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "project") @Nullable final ProjectDTO projectDTO)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        projectService.create(projectDTO);
    }

    @Override
    public void editProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "project") @Nullable final ProjectDTO projectDTO)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        projectService.edit(projectDTO);
    }

    @Override
    public ProjectDTO findOneProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "id") @Nullable final String id)
            throws AuthenticationSecurityException, DataValidateException{
        sessionService.validate(sessionDTO);
        return projectService.findOne(id, sessionDTO.getUserId());
    }

    @Override
    public void removeProject(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "id") @Nullable final String id)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        projectService.remove(id, sessionDTO.getUserId());
    }

    @Override
    public Collection<ProjectDTO> findAllProjectByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        return projectService.findAllByUserId(sessionDTO.getUserId());
    }

    @Override
    public void removeAllProjectByUserId(@WebParam(name = "session") @Nullable final SessionDTO sessionDTO)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        projectService.removeAllByUserId(sessionDTO.getUserId());
    }

    @Override
    public Collection<ProjectDTO> sortAllProjectByUserId(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "parameter") @Nullable final String parameter)
            throws AuthenticationSecurityException, DataValidateException{
        sessionService.validate(sessionDTO);
        return projectService.sortAllByUserId(sessionDTO.getUserId(), parameter);
    }

    @Override
    public Collection<ProjectDTO> findAllProjectByPartOfNameOrDescription(
            @WebParam(name = "session") @Nullable final SessionDTO sessionDTO,
            @WebParam(name = "name") @Nullable final String name,
            @WebParam(name = "description") @Nullable final String description)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        return projectService.findAllByPartOfNameOrDescription(name, description, sessionDTO.getUserId());
    }
}