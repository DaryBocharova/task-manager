package ru.bocharova.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IAdminEndpoint extends IEndPoint {

    @WebMethod
    void loadUserData(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void saveUserData(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void loadUserDataJaxbXml(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void saveUserDataJaxbXml(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void loadUserDataFasterXml(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void saveUserDataFasterXml(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void loadUserDataJaxbJSON(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void saveUserDataJaxbJSON(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void loadUserDataFasterJSON(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

    @WebMethod
    void saveUserDataFasterJSON(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AuthenticationSecurityException;

}

