package ru.bocharova.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.IAdminEndpoint;
import ru.bocharova.tm.api.service.IServiceLocator;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@NoArgsConstructor
@WebService
        (endpointInterface = "ru.bocharova.tm.api.endpoint.IAdminEndpoint")
public class AdminEndpoint implements IAdminEndpoint {

    @NotNull
    private IUserService userService;

    @NotNull
    private ISessionService sessionService;

    public AdminEndpoint(@NotNull final IServiceLocator serviceLocator) {

        this.userService = serviceLocator.getUserService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public void loadUserData(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.loadData();
    }

    @Override
    @WebMethod
    public void saveUserData(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {
        sessionService.validateAdmin(session);
        userService.saveData();
    }

    @Override
    @WebMethod
    public void loadUserDataJaxbXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.loadDataJaxbXml();
    }

    @Override
    @WebMethod
    public void saveUserDataJaxbXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.saveDataJaxbXml();
    }

    @Override
    @WebMethod
    public void loadUserDataFasterXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.loadDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveUserDataFasterXml(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.saveDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadUserDataJaxbJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.loadDataJaxbJSON();
    }

    @Override
    @WebMethod
    public void saveUserDataJaxbJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.saveDataJaxbJSON();
    }

    @Override
    @WebMethod
    public void loadUserDataFasterJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.loadDataFasterJSON();
    }

    @Override
    @WebMethod
    public void saveUserDataFasterJSON(@WebParam(name = "session") @NotNull Session session) throws AuthenticationSecurityException {

        sessionService.validateAdmin(session);
        userService.saveDataFasterJSON();
    }
}
