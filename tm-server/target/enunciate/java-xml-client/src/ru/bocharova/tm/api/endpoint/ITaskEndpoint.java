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
   name = "ITaskEndpoint",
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
public interface ITaskEndpoint {

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "createTask",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "createTask",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.CreateTask"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "createTaskResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.CreateTaskResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.Task createTask(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "name", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String name, @javax.jws.WebParam( name = "description", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String description, @javax.jws.WebParam( name = "projectId", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg3" ) java.lang.String projectId) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "editTask",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "editTask",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.EditTask"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "editTaskResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.EditTaskResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.Task editTask(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id, @javax.jws.WebParam( name = "name", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String name, @javax.jws.WebParam( name = "description", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg3" ) java.lang.String description, @javax.jws.WebParam( name = "status", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg4" ) java.lang.String status) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findOneTask",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findOneTask",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindOneTask"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findOneTaskResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindOneTaskResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.Task findOneTask(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "removeTask",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "removeTask",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveTask"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "removeTaskResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveTaskResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  ru.bocharova.tm.entity.Task removeTask(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findAllTaskByProjectId",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findAllTaskByProjectId",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByProjectId"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findAllTaskByProjectIdResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByProjectIdResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByProjectId(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findAllTaskByUserId",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findAllTaskByUserId",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByUserId"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findAllTaskByUserIdResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByUserIdResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByUserId(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "removeAllTaskByProjectId",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "removeAllTaskByProjectId",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByProjectId"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "removeAllTaskByProjectIdResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByProjectIdResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void removeAllTaskByProjectId(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "id", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "removeAllTaskByUserId",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "removeAllTaskByUserId",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByUserId"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "removeAllTaskByUserIdResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.RemoveAllTaskByUserIdResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  void removeAllTaskByUserId(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "sortAllTaskByUserId",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "sortAllTaskByUserId",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SortAllTaskByUserId"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "sortAllTaskByUserIdResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.SortAllTaskByUserIdResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  java.util.Collection<ru.bocharova.tm.entity.Task> sortAllTaskByUserId(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "comparator", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String comparator) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

  /**
   * (no documentation provided)
   */
  @javax.jws.WebMethod (
    operationName = "findAllTaskByPartOfNameOrDescription",
    action = ""
  )
  @javax.jws.WebResult (
    name = "return",
    targetNamespace = "",
    header = false,
    partName = "return"
  )
  @javax.xml.ws.RequestWrapper (
    localName = "findAllTaskByPartOfNameOrDescription",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByPartOfNameOrDescription"
  )
  @javax.xml.ws.ResponseWrapper (
    localName = "findAllTaskByPartOfNameOrDescriptionResponse",
    targetNamespace = "http://endpoint.api.tm.bocharova.ru/",
    className = "ru.bocharova.tm.api.endpoint.jaxws.FindAllTaskByPartOfNameOrDescriptionResponse"
  )
  @javax.jws.soap.SOAPBinding (
    style = javax.jws.soap.SOAPBinding.Style.DOCUMENT,
    use = javax.jws.soap.SOAPBinding.Use.LITERAL,
    parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED
  )
  java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByPartOfNameOrDescription(@javax.jws.WebParam( name = "session", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg0" ) ru.bocharova.tm.entity.Session session, @javax.jws.WebParam( name = "name", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg1" ) java.lang.String name, @javax.jws.WebParam( name = "description", targetNamespace="", mode = javax.jws.WebParam.Mode.IN , header = false, partName = "arg2" ) java.lang.String description) throws ru.bocharova.tm.exception.AuthenticationSecurityException;

}
