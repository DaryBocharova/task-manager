/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.tm.api.endpoint.jaxws;

import javax.xml.namespace.QName;

/**
 * Request bean for the createUser operation.
 */
@javax.xml.bind.annotation.XmlRootElement (
  name = "createUser",
  namespace = "http://endpoint.api.tm.tm.bocharova.ru/"
)
@javax.xml.bind.annotation.XmlType (
  name = "createUser",
  namespace = "http://endpoint.api.tm.tm.bocharova.ru/",
  propOrder = { "session", "login", "password", "role" }
)
@javax.xml.bind.annotation.XmlAccessorType ( javax.xml.bind.annotation.XmlAccessType.FIELD )
public class CreateUser {

  @javax.xml.bind.annotation.XmlElement (
    name = "session"
  )
  protected ru.bocharova.tm.entity.Session session;
  @javax.xml.bind.annotation.XmlElement (
    name = "login"
  )
  protected java.lang.String login;
  @javax.xml.bind.annotation.XmlElement (
    name = "password"
  )
  protected java.lang.String password;
  @javax.xml.bind.annotation.XmlElement (
    name = "role"
  )
  protected java.lang.String role;

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

  /**
   * 
   */
  public java.lang.String getLogin() {
    return this.login;
  }

  /**
   * 
   */
  public void setLogin(java.lang.String login) {
    this.login = login;
  }

  /**
   * 
   */
  public java.lang.String getPassword() {
    return this.password;
  }

  /**
   * 
   */
  public void setPassword(java.lang.String password) {
    this.password = password;
  }

  /**
   * 
   */
  public java.lang.String getRole() {
    return this.role;
  }

  /**
   * 
   */
  public void setRole(java.lang.String role) {
    this.role = role;
  }
}
