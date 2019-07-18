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
    public void editProject(@WebParam(name = "session") @NotNull final SessionDTO session,
                                  @WebParam(name = "id") @NotNull final String id,
                                  @WebParam(name = "name") @NotNull final String name,
                                  @WebParam(name = "description") @NotNull final String description,
                                  @WebParam(name = "status") @NotNull final String status) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.edit(id, name, description, status, session.getUserId());
    }

    @Override
    public ProjectDTO findOneProject(@WebParam(name = "session") @NotNull final SessionDTO session,
                                     @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findOne(id, session.getUserId());
    }

    @Override
    public ProjectDTO removeProject(@WebParam(name = "session") @NotNull final SessionDTO session,
                                    @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.remove(id, session.getUserId());
    }

    @Override
    public Collection<ProjectDTO> findAllProjectByUserId(@WebParam(name = "session") @NotNull final SessionDTO session) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findAllByUserId(session.getUserId());
    }

    @Override
    public void removeAllProjectByUserId(@WebParam(name = "session") @NotNull final SessionDTO session) throws AuthenticationSecurityException {
        sessionService.validate(session);
        projectService.removeAllByUserId(session.getUserId());
    }

    @Override
    public Collection<ProjectDTO> sortAllProjectByUserId(@WebParam(name = "session") @NotNull final SessionDTO session,
                                                         @WebParam(name = "comparator") @NotNull final String comparator) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.sortAllByUserId(session.getUserId(), comparator);
    }

    @Override
    public Collection<ProjectDTO> findAllProjectByPartOfNameOrDescription(@WebParam(name = "session") @NotNull final SessionDTO session,
                                                                          @WebParam(name = "name") @NotNull final String name,
                                                                          @WebParam(name = "description") @NotNull final String description) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findAllByPartOfNameOrDescription(name, description, session.getUserId());
    }
}