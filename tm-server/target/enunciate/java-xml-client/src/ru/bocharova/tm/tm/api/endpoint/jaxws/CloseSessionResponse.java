/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.tm.api.endpoint.jaxws;

import javax.xml.namespace.QName;

/**
 * Response bean for the closeSessionResponse operation.
 */
@javax.xml.bind.annotation.XmlRootElement (
  name = "closeSessionResponse",
  namespace = "http://endpoint.api.tm.tm.bocharova.ru/"
)
@javax.xml.bind.annotation.XmlType (
  name = "closeSessionResponse",
  namespace = "http://endpoint.api.tm.tm.bocharova.ru/",
  propOrder = { "_retval" }
)
 @javax.xml.bind.annotation.XmlAccessorType ( javax.xml.bind.annotation.XmlAccessType.FIELD )
public class CloseSessionResponse {

  @javax.xml.bind.annotation.XmlElement (
    name = "return"
  )
  protected ru.bocharova.tm.entity.Session _retval;

  /**
   * 
   */
  public ru.bocharova.tm.entity.Session getReturn() {
    return this._retval;
  }

  /**
   * 
   */
  public void setReturn(ru.bocharova.tm.entity.Session value) {
    this._retval = value;
  }

}
