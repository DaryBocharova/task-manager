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

@NoArgsConstructor
@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.IUserEndpoint")
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
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        return userService.create(login, password, role);
    }

    @Override
    @WebMethod
    public User changeUserPassword(@WebParam(name = "session") @NotNull final Session session,
                                   @WebParam(name = "id") @NotNull final String id,
                                   @WebParam(name = "login") @NotNull final String login,
                                   @WebParam(name = "password") @NotNull final String password,
                                   @WebParam(name = "role") @NotNull final String role) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        return userService.edit(id, login, password, role);
    }

    @Override
    @WebMethod
    public User editUserProfile(@WebParam(name = "session") @NotNull final Session session,
                                @WebParam(name = "login") @NotNull final String login,
                                @WebParam(name = "password") @NotNull final String password) throws AuthenticationSecurityException {
        if (!sessionService.validate(session)) throw new AuthenticationSecurityException("Сессия некорректная!");
        return userService.edit(session.getUserId(), login, password);
    }

    @Override
    @WebMethod
    public User findUserByLogin(@WebParam(name = "session") @NotNull final Session session,
                                @WebParam(name = "login") @NotNull final String login) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        return userService.findByLogin(login);
    }

    @Override
    @WebMethod
    public User getUserBySession(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        if (!sessionService.validate(session)) throw new AuthenticationSecurityException("Сессия некорректная!");
        return userService.findOne(session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<User> findAllUser(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        return userService.findAll();
    }

    @Override
    @WebMethod
    public void loadUserData(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.loadData();
    }

    @Override
    @WebMethod
    public void saveUserData(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.saveData();
    }

    @Override
    @WebMethod
    public void loadUserDataJaxbXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.loadDataJaxbXml();
    }

    @Override
    @WebMethod
    public void saveUserDataJaxbXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.saveDataJaxbXml();
    }

    @Override
    @WebMethod
    public void loadUserDataFasterXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.loadDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveUserDataFasterXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.saveDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadUserDataJaxbJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.loadDataJaxbJSON();
    }

    @Override
    @WebMethod
    public void saveUserDataJaxbJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.saveDataJaxbJSON();
    }

    @Override
    @WebMethod
    public void loadUserDataFasterJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.loadDataFasterJSON();
    }

    @Override
    @WebMethod
    public void saveUserDataFasterJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        if (!sessionService.validateAdmin(session))
            throw new AuthenticationSecurityException("Запрещенные действия для вашей роли!");
        userService.saveDataFasterJSON();
    }
}
