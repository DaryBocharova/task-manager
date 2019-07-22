package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.model.dto.SessionDTO;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface ISessionEndpoint extends IEndPoint {

    @WebMethod
    SessionDTO openSession(@WebParam(name = "login") @NotNull final String login,
                           @WebParam(name = "password") @NotNull final String password) throws
            AuthenticationSecurityException, IOException, DataValidateException;

    @WebMethod
    SessionDTO closeSession(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;

    @WebMethod
    void validateAdminSession(@WebParam(name = "session") @Nullable final SessionDTO sessionDTO) throws
            AuthenticationSecurityException, DataValidateException;
}
