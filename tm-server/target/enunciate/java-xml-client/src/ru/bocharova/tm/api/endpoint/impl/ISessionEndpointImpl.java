/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.api.endpoint.impl;

import ru.bocharova.tm.api.endpoint.ISessionEndpoint;

/**
 * Implementation of the {@link ISessionEndpoint}.
 */
public class ISessionEndpointImpl implements ISessionEndpoint {

  private final ISessionEndpoint proxy;

  /**
   * Construct a ISessionEndpoint that points to the endpoint at the specified host and port.
   *
   * @param host The host.
   * @param port The port.
   * @param features The features (e.g. MTOM).
   */
  public ISessionEndpointImpl(String host, int port, javax.xml.ws.WebServiceFeature... features) {
    this.proxy = javax.xml.ws.spi.Provider.provider().createServiceDelegate(getClass().getResource("/ns0.wsdl"), new javax.xml.namespace.QName("http://endpoint.api.tm.bocharova.ru/", "ISessionEndpointService"), javax.xml.ws.Service.class).getPort(ISessionEndpoint.class, features);
    try {
      java.net.URL baseUrl = new java.net.URL("http://localhost:8080/ISessionEndpointService");
      _getBindingProvider().getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, new java.net.URL(baseUrl.getProtocol(), host, port, baseUrl.getFile()).toString());
    }
    catch (java.net.MalformedURLException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Construct a ISessionEndpoint that points to the specified endpoint.
   *
   * @param endpoint The endpoint to point to.
   * @param features The features (e.g. MTOM).
   */
  public ISessionEndpointImpl(String endpoint, javax.xml.ws.WebServiceFeature... features) {
    this.proxy = javax.xml.ws.spi.Provider.provider().createServiceDelegate(getClass().getResource("/ns0.wsdl"), new javax.xml.namespace.QName("http://endpoint.api.tm.bocharova.ru/", "ISessionEndpointService"), javax.xml.ws.Service.class).getPort(ISessionEndpoint.class, features);
    _getBindingProvider().getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
  }

  /**
   * Get the binding provider supporting this service.
   */
  public javax.xml.ws.BindingProvider _getBindingProvider() {
    return (javax.xml.ws.BindingProvider) this.proxy;
  }


  // Inherited.
  public ru.bocharova.tm.entity.Session openSession(java.lang.String login, java.lang.String password) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.openSession(login, password); 
  }

  // Inherited.
  public boolean validateSession(ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.validateSession(session); 
  }

  // Inherited.
  public ru.bocharova.tm.entity.Session closeSession(ru.bocharova.tm.entity.Session session) throws ru.bocharova.tm.exception.AuthenticationSecurityException {
    return proxy.closeSession(session); 
  }
}
