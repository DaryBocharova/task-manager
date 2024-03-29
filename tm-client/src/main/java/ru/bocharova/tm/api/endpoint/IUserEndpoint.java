package ru.bocharova.tm.api.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-07-11T16:26:48.913+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.bocharova.ru/", name = "IUserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface IUserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterXmlRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterXmlResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterXml/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "saveUserDataFasterXml", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataFasterXml")
    @ResponseWrapper(localName = "saveUserDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataFasterXmlResponse")
    public void saveUserDataFasterXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/changeUserPasswordRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/changeUserPasswordResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/changeUserPassword/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "changeUserPassword", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.ChangeUserPassword")
    @ResponseWrapper(localName = "changeUserPasswordResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.ChangeUserPasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.bocharova.tm.api.endpoint.User changeUserPassword(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserData/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "loadUserData", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserData")
    @ResponseWrapper(localName = "loadUserDataResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataResponse")
    public void loadUserData(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/getUserBySessionRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/getUserBySessionResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/getUserBySession/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "getUserBySession", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.GetUserBySession")
    @ResponseWrapper(localName = "getUserBySessionResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.GetUserBySessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.bocharova.tm.api.endpoint.User getUserBySession(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findAllUserRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findAllUserResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findAllUser/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "findAllUser", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.FindAllUser")
    @ResponseWrapper(localName = "findAllUserResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.FindAllUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.bocharova.tm.api.endpoint.User> findAllUser(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbJSONRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbJSONResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbJSON/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "loadUserDataJaxbJSON", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataJaxbJSON")
    @ResponseWrapper(localName = "loadUserDataJaxbJSONResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataJaxbJSONResponse")
    public void loadUserDataJaxbJSON(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findUserByLoginRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findUserByLoginResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/findUserByLogin/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "findUserByLogin", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.FindUserByLogin")
    @ResponseWrapper(localName = "findUserByLoginResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.FindUserByLoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.bocharova.tm.api.endpoint.User findUserByLogin(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session,
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterJSONRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterJSONResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataFasterJSON/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "saveUserDataFasterJSON", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataFasterJSON")
    @ResponseWrapper(localName = "saveUserDataFasterJSONResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataFasterJSONResponse")
    public void saveUserDataFasterJSON(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserData/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "saveUserData", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserData")
    @ResponseWrapper(localName = "saveUserDataResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataResponse")
    public void saveUserData(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterXmlRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterXmlResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterXml/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "loadUserDataFasterXml", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataFasterXml")
    @ResponseWrapper(localName = "loadUserDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataFasterXmlResponse")
    public void loadUserDataFasterXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbXmlRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbXmlResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbXml/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "saveUserDataJaxbXml", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataJaxbXml")
    @ResponseWrapper(localName = "saveUserDataJaxbXmlResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataJaxbXmlResponse")
    public void saveUserDataJaxbXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbJSONRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbJSONResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/saveUserDataJaxbJSON/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "saveUserDataJaxbJSON", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataJaxbJSON")
    @ResponseWrapper(localName = "saveUserDataJaxbJSONResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.SaveUserDataJaxbJSONResponse")
    public void saveUserDataJaxbJSON(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/createUserRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/createUserResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/createUser/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "createUser", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.bocharova.tm.api.endpoint.User createUser(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session,
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/editUserProfileRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/editUserProfileResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/editUserProfile/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "editUserProfile", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.EditUserProfile")
    @ResponseWrapper(localName = "editUserProfileResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.EditUserProfileResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.bocharova.tm.api.endpoint.User editUserProfile(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session,
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterJSONRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterJSONResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataFasterJSON/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "loadUserDataFasterJSON", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataFasterJSON")
    @ResponseWrapper(localName = "loadUserDataFasterJSONResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataFasterJSONResponse")
    public void loadUserDataFasterJSON(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbXmlRequest", output = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbXmlResponse", fault = {@FaultAction(className = AuthenticationSecurityException_Exception.class, value = "http://endpoint.api.tm.bocharova.ru/IUserEndpoint/loadUserDataJaxbXml/Fault/AuthenticationSecurityException")})
    @RequestWrapper(localName = "loadUserDataJaxbXml", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataJaxbXml")
    @ResponseWrapper(localName = "loadUserDataJaxbXmlResponse", targetNamespace = "http://endpoint.api.tm.bocharova.ru/", className = "ru.bocharova.tm.api.endpoint.LoadUserDataJaxbXmlResponse")
    public void loadUserDataJaxbXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.bocharova.tm.api.endpoint.Session session
    ) throws AuthenticationSecurityException_Exception;
}
