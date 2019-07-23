package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.model.dto.*;
import ru.bocharova.tm.api.endpoint.ISessionEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@NoArgsConstructor
@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.ISessionEndpoint")
public class SessionEndpoint implements ISessionEndpoint {

    @NotNull
    private ISessionService sessionService;

    @NotNull
    private IUserService userService;

    public SessionEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.sessionService = serviceLocator.getSessionService();
        this.userService = serviceLocator.getUserService();
    }

    @Override
    @WebMethod
    public void validateAdminSession(@WebParam(name = "session") @Nullable final SessionDTO sessionDTO)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validateAdmin(sessionDTO);
    }

    @Override
    @WebMethod
    public SessionDTO openSession(@WebParam(name = "login") @NotNull final String login,
                                  @WebParam(name = "password") @NotNull final String password
    ) throws AuthenticationSecurityException, IOException, DataValidateException {
        @NotNull
        UserDTO loggedUser = userService.authenticationUser(login, password);
        return sessionService.create(loggedUser);
    }

    @Override
    @WebMethod
    public SessionDTO closeSession(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO)
            throws AuthenticationSecurityException, DataValidateException {
        sessionService.validate(sessionDTO);
        return sessionService.remove(sessionDTO.getId());
    }
}
