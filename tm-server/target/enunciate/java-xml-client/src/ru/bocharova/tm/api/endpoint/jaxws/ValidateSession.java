/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.api.endpoint.jaxws;

import javax.xml.namespace.QName;

/**
 * Request bean for the validateSession operation.
 */
@javax.xml.bind.annotation.XmlRootElement (
  name = "validateSession",
  namespace = "http://endpoint.api.tm.bocharova.ru/"
)
@javax.xml.bind.annotation.XmlType (
  name = "validateSession",
  namespace = "http://endpoint.api.tm.bocharova.ru/",
  propOrder = { "session" }
)
@javax.xml.bind.annotation.XmlAccessorType ( javax.xml.bind.annotation.XmlAccessType.FIELD )
public class ValidateSession {

  @javax.xml.bind.annotation.XmlElement (
    name = "session"
  )
  protected ru.bocharova.tm.entity.Session session;

  /**
   * 
   */
  public ru.bocharova.tm.entity.Session getSession() {
    return this.session;
  }

  /**
   * 
   */
  public void setSession(ru.bocharova.tm.entity.Session session) {
    this.session = session;
  }
}
