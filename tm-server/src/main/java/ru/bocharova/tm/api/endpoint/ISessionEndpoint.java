package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface ISessionEndpoint extends IEndPoint {

    @WebMethod
    Session openSession(@WebParam(name = "login") @NotNull final String login,
                        @WebParam(name = "password") @NotNull final String password) throws AuthenticationSecurityException, IOException;

    @WebMethod
    Session closeSession(@WebParam(name = "session") @NotNull final Session session) throws AuthenticationSecurityException;

    @WebMethod
    void validateAdminSession(@WebParam(name = "session") @Nullable final Session session) throws AuthenticationSecurityException;
}
