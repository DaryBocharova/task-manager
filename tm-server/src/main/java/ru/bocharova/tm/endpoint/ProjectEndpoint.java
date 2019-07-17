package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.IProjectEndpoint;
import ru.bocharova.tm.api.service.IProjectService;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
@NoArgsConstructor
public class ProjectEndpoint implements IProjectEndpoint {

    @NotNull
    private IProjectService projectService;

    @NotNull
    private ISessionService sessionService;

    public ProjectEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.projectService = serviceLocator.getProjectService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public Project createProject(@WebParam(name = "session") @NotNull final Session session,
                                 @WebParam(name = "name") @NotNull final String name,
                                 @WebParam(name = "description") @NotNull final String description) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.create(name, description, session.getUserId());
    }

    @Override
    @WebMethod
    public Project editProject(@WebParam(name = "session") @NotNull final Session session,
                               @WebParam(name = "id") @NotNull final String id,
                               @WebParam(name = "name") @NotNull final String name,
                               @WebParam(name = "description") @NotNull final String description,
                               @WebParam(name = "status") @NotNull final String status) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.edit(id, name, description, status, session.getUserId());
    }

    @Override
    @WebMethod
    public Project findOneProject(@WebParam(name = "session") @NotNull final Session session,
                                  @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findOne(id, session.getUserId());
    }

    @Override
    @WebMethod
    public Project removeProject(@WebParam(name = "session") @NotNull final Session session,
                                 @WebParam(name = "id") @NotNull final String id) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.remove(id, session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<Project> findAllProjectByUserId(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findAllByUserId(session.getUserId());
    }

    @Override
    @WebMethod
    public void removeAllProjectByUserId(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validate(session);
        projectService.removeAllByUserId(session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<Project> sortAllProjectByUserId(@WebParam(name = "session") @NotNull final Session session,
                                                      @WebParam(name = "comparator") @NotNull final String comparator) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.sortAllByUserId(session.getUserId(), comparator);
    }

    @Override
    @WebMethod
    public Collection<Project> findAllProjectByPartOfNameOrDescription(@WebParam(name = "session") @NotNull final Session session,
                                                                       @WebParam(name = "name") @NotNull final String name,
                                                                       @WebParam(name = "description") @NotNull final String description) throws AuthenticationSecurityException {
        sessionService.validate(session);
        return projectService.findAllByPartOfNameOrDescription(name, description, session.getUserId());
    }
}