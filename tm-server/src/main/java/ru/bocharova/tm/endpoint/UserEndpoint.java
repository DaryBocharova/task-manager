package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.dto.*;
import ru.bocharova.tm.api.endpoint.IUserEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

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
    public void createUser(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                           @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        userService.create(userDTO);
    }

    @Override
    @WebMethod
    public void changeUserPassword(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                   @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException{
        sessionService.validateAdmin(sessionDTO);
        userService.edit(userDTO);
    }

    @Override
    @WebMethod
    public void editUserProfile(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException{
        sessionService.validateAdmin(sessionDTO);
        userService.edit(userDTO);
    }

    @Override
    @WebMethod
    public UserDTO findUserByLogin(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                                @WebParam(name = "login") @NotNull final String login) throws AuthenticationSecurityException,
            DataValidateException{
        sessionService.validateAdmin(sessionDTO);
        return userService.findByLogin(login);
    }

    @Override
    @WebMethod
    public UserDTO getUserBySession(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return userService.findOne(sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public Collection<UserDTO> findAllUser(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException,
            DataValidateException {
        sessionService.validateAdmin(sessionDTO);
        return userService.findAll();
    }
}
