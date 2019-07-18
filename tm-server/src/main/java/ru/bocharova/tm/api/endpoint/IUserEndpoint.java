package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.DTO.UserDTO;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface IUserEndpoint extends IEndPoint {

    @WebMethod
    UserDTO createUser(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                       @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    UserDTO changeUserPassword(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                               @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    UserDTO editUserProfile(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                            @WebParam(name = "user") @NotNull final UserDTO userDTO) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    UserDTO findUserByLogin(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                            @WebParam(name = "login") @NotNull final String login) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    UserDTO getUserBySession(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException,
            DataValidateException;

    @WebMethod
    Collection<UserDTO> findAllUser(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException,
            DataValidateException;
}