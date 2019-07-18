package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.IUserEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;


@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.IUserEndpoint")
@NoArgsConstructor
public class UserEndpoint implements IUserEndpoint {

    @NotNull
    private IUserService userService;

    @NotNull
    private ISessionService sessionService;

    public UserEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.userService = serviceLocator.getUserService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public User createUser(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "login") @NotNull final String login,
                           @WebParam(name = "password") @NotNull final String password,
                           @WebParam(name = "role") @NotNull final String role) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.create(login, password, role);
    }

    @Override
    @WebMethod
    public User changeUserPassword(@WebParam(name = "session") @NotNull final Session session,
                                   @WebParam(name = "id") @NotNull final String id,
                                   @WebParam(name = "login") @NotNull final String login,
                                   @WebParam(name = "password") @NotNull final String password,
                                   @WebParam(name = "role") @NotNull final String role) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.edit(id, login, password, role);
    }

    @Override
    @WebMethod
    public User editUserProfile(@WebParam(name = "session") @NotNull final Session session,
                                @WebParam(name = "login") @NotNull final String login,
                                @WebParam(name = "password") @NotNull final String password) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.edit(session.getUserId(), login, password);
    }

    @Override
    @WebMethod
    public User findUserByLogin(@WebParam(name = "session") @NotNull final Session session,
                                @WebParam(name = "login") @NotNull final String login) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.findByLogin(login);
    }

    @Override
    @WebMethod
    public User getUserBySession(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.findOne(session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<User> findAllUser(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        return userService.findAll();
    }
}
