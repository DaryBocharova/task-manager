/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.tm.api.endpoint.impl;

import ru.bocharova.tm.tm.api.endpoint.ITaskEndpoint;

/**
 * Implementation of the {@link ITaskEndpoint}.
 */
public class ITaskEndpointImpl implements ITaskEndpoint {

  private final ITaskEndpoint proxy;

  /**
   * Construct a ITaskEndpoint that points to the endpoint at the specified host and port.
   *
   * @param host The host.
   * @param port The port.
   * @param features The features (e.g. MTOM).
   */
  public ITaskEndpointImpl(String host, int port, javax.xml.ws.WebServiceFeature... features) {
    this.proxy = javax.xml.ws.spi.Provider.provider().createServiceDelegate(getClass().getResource("/ns3.wsdl"), new javax.xml.namespace.QName("http://endpoint.api.tm.tm.bocharova.ru/", "ITaskEndpointService"), javax.xml.ws.Service.class).getPort(ITaskEndpoint.class, features);
    try {
      java.net.URL baseUrl = new java.net.URL("http://localhost:8080/ITaskEndpointService");
      _getBindingProvider().getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, new java.net.URL(baseUrl.getProtocol(), host, port, baseUrl.getFile()).toString());
    }
    catch (java.net.MalformedURLException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Construct a ITaskEndpoint that points to the specified endpoint.
   *
   * @param endpoint The endpoint to point to.
   * @param features The features (e.g. MTOM).
   */
  public ITaskEndpointImpl(String endpoint, javax.xml.ws.WebServiceFeature... features) {
    this.proxy = javax.xml.ws.spi.Provider.provider().createServiceDelegate(getClass().getResource("/ns3.wsdl"), new javax.xml.namespace.QName("http://endpoint.api.tm.tm.bocharova.ru/", "ITaskEndpointService"), javax.xml.ws.Service.class).getPort(ITaskEndpoint.class, features);
    _getBindingProvider().getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
  }

  /**
   * Get the binding provider supporting this service.
   */
  public javax.xml.ws.BindingProvider _getBindingProvider() {
    return (javax.xml.ws.BindingProvider) this.proxy;
  }


  // Inherited.
  public ru.bocharova.tm.entity.Task createTask(ru.bocharova.tm.entity.Session session, java.lang.String name, java.lang.String description, java.lang.String projectId) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.createTask(session, name, description, projectId); 
  }

  // Inherited.
  public ru.bocharova.tm.entity.Task editTask(ru.bocharova.tm.entity.Session session, java.lang.String id, java.lang.String name, java.lang.String description, java.lang.String status) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.editTask(session, id, name, description, status); 
  }

  // Inherited.
  public ru.bocharova.tm.entity.Task findOneTask(ru.bocharova.tm.entity.Session session, java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.findOneTask(session, id); 
  }

  // Inherited.
  public ru.bocharova.tm.entity.Task removeTask(ru.bocharova.tm.entity.Session session, java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.removeTask(session, id); 
  }

  // Inherited.
  public java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByProjectId(ru.bocharova.tm.entity.Session session, java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.findAllTaskByProjectId(session, id); 
  }

  // Inherited.
  public java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByUserId(ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.findAllTaskByUserId(session); 
  }

  // Inherited.
  public void removeAllTaskByProjectId(ru.bocharova.tm.entity.Session session, java.lang.String id) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    proxy.removeAllTaskByProjectId(session, id); 
  }

  // Inherited.
  public void removeAllTaskByUserId(ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    proxy.removeAllTaskByUserId(session); 
  }

  // Inherited.
  public java.util.Collection<ru.bocharova.tm.entity.Task> sortAllTaskByUserId(ru.bocharova.tm.entity.Session session, java.lang.String comparator) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.sortAllTaskByUserId(session, comparator); 
  }

  // Inherited.
  public java.util.Collection<ru.bocharova.tm.entity.Task> findAllTaskByPartOfNameOrDescription(ru.bocharova.tm.entity.Session session, java.lang.String name, java.lang.String description) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.findAllTaskByPartOfNameOrDescription(session, name, description); 
  }
}
