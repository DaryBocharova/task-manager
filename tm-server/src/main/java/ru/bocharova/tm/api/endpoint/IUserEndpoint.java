package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface IUserEndpoint extends IEndPoint {

    @WebMethod
    User createUser(@WebParam(name = "session") @NotNull final Session session,
                    @WebParam(name = "login") @NotNull final String login,
                    @WebParam(name = "password") @NotNull final String password,
                    @WebParam(name = "role") @NotNull final String role) throws AuthenticationSecurityException;

    @WebMethod
    User changeUserPassword(@WebParam(name = "session") @NotNull final Session session,
                            @WebParam(name = "id") @NotNull final String id,
                            @WebParam(name = "login") @NotNull final String login,
                            @WebParam(name = "password") @NotNull final String password,
                            @WebParam(name = "role") @NotNull final String role) throws AuthenticationSecurityException;

    @WebMethod
    User editUserProfile(@WebParam(name = "session") @NotNull final Session session,
                         @WebParam(name = "login") @NotNull final String login,
                         @WebParam(name = "password") @NotNull final String password) throws AuthenticationSecurityException;

    @WebMethod
    User findUserByLogin(@WebParam(name = "session") @NotNull final Session session,
                         @WebParam(name = "login") @NotNull final String login) throws AuthenticationSecurityException;

    @WebMethod
    User getUserBySession(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException;

    @WebMethod
    Collection<User> findAllUser(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException;
}