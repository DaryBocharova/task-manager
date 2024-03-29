/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.api.endpoint;

/**
 * (no documentation provided)
 */
 @javax.jws.WebService (
   name = "IUserEndpoint",
   targetNamespace = "http://endpoint.api.tm.bocharova.ru/"
 )
 @javax.xml.bind.annotation.XmlSeeAlso ( {
  ru.bocharova.tm.api.endpoint.jaxws.ChangeUserPassword.class,
  ru.bocharova.tm.api.endpoint.jaxws.ChangeUserPasswordResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.CloseSession.class,
  ru.bocharova.tm.api.endpoint.jaxws.CloseSessionResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateProject.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateProjectResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateTask.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateTaskResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateUser.class,
  ru.bocharova.tm.api.endpoint.jaxws.CreateUserResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditProject.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditProjectResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditTask.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditTaskResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditUserProfile.class,
  ru.bocharova.tm.api.endpoint.jaxws.EditUserProfileResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllProjectByPartOfNameOrDescription.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllProjectByPartOfNameOrDescriptionResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllProjectByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllProjectByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByPartOfNameOrDescription.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByPartOfNameOrDescriptionResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByProjectId.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByProjectIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllUser.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindAllUserResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindOneProject.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindOneProjectResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindOneTask.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindOneTaskResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindUserByLogin.class,
  ru.bocharova.tm.api.endpoint.jaxws.FindUserByLoginResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.GetUserBySession.class,
  ru.bocharova.tm.api.endpoint.jaxws.GetUserBySessionResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserData.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterJSON.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterJSONResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterXml.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterXmlResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbJSON.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbJSONResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbXml.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbXmlResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.OpenSession.class,
  ru.bocharova.tm.api.endpoint.jaxws.OpenSessionResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllProjectByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllProjectByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByProjectId.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByProjectIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveProject.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveProjectResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveTask.class,
  ru.bocharova.tm.api.endpoint.jaxws.RemoveTaskResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserData.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterJSON.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterJSONResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterXml.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterXmlResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbJSON.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbJSONResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbXml.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbXmlResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SortAllProjectByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.SortAllProjectByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.SortAllTaskByUserId.class,
  ru.bocharova.tm.api.endpoint.jaxws.SortAllTaskByUserIdResponse.class,
  ru.bocharova.tm.api.endpoint.jaxws.ValidateSession.class,
  ru.bocharova.tm.api.endpoint.jaxws.ValidateSessionResponse.class,
  ru.bocharova.tm.exception.jaxws.AuthenticationSecurityExceptionBean.class
 } )
public interface IUserEndpoint {

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "createUser",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "createUser",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.CreateUser"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "createUserResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.CreateUserResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.User createUser(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "login", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String login, @javax.jws.WebParam( name = "password", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String password, @javax.jws.WebParam( name = "role", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg3" ) java.lang.String role) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "changeUserPassword",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "changeUserPassword",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.ChangeUserPassword"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "changeUserPasswordResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.ChangeUserPasswordResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.User changeUserPassword(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id, @javax.jws.WebParam( name = "login", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String login, @javax.jws.WebParam( name = "password", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg3" ) java.lang.String password, @javax.jws.WebParam( name = "role", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg4" ) java.lang.String role) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "editUserProfile",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "editUserProfile",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.EditUserProfile"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "editUserProfileResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.EditUserProfileResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.User editUserProfile(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "login", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String login, @javax.jws.WebParam( name = "password", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String password) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findUserByLogin",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findUserByLogin",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindUserByLogin"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findUserByLoginResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindUserByLoginResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.User findUserByLogin(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "login", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String login) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "getUserBySession",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "getUserBySession",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.GetUserBySession"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "getUserBySessionResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.GetUserBySessionResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.User getUserBySession(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findAllUser",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findAllUser",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllUser"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findAllUserResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllUserResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  java.util.Collection<ru.bocharova.tm.entity.User> findAllUser(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "loadUserData",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "loadUserData",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserData"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "loadUserDataResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void loadUserData(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "saveUserData",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "saveUserData",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserData"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "saveUserDataResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void saveUserData(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "loadUserDataJaxbXml",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "loadUserDataJaxbXml",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbXml"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "loadUserDataJaxbXmlResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbXmlResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void loadUserDataJaxbXml(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "saveUserDataJaxbXml",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "saveUserDataJaxbXml",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbXml"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "saveUserDataJaxbXmlResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbXmlResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void saveUserDataJaxbXml(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "loadUserDataFasterXml",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "loadUserDataFasterXml",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterXml"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "loadUserDataFasterXmlResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterXmlResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void loadUserDataFasterXml(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "saveUserDataFasterXml",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "saveUserDataFasterXml",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterXml"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "saveUserDataFasterXmlResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterXmlResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void saveUserDataFasterXml(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "loadUserDataJaxbJSON",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "loadUserDataJaxbJSON",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbJSON"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "loadUserDataJaxbJSONResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataJaxbJSONResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void loadUserDataJaxbJSON(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "saveUserDataJaxbJSON",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "saveUserDataJaxbJSON",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbJSON"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "saveUserDataJaxbJSONResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataJaxbJSONResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void saveUserDataJaxbJSON(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "loadUserDataFasterJSON",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "loadUserDataFasterJSON",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterJSON"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "loadUserDataFasterJSONResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.LoadUserDataFasterJSONResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void loadUserDataFasterJSON(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "saveUserDataFasterJSON",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "saveUserDataFasterJSON",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterJSON"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "saveUserDataFasterJSONResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SaveUserDataFasterJSONResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void saveUserDataFasterJSON(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

}
