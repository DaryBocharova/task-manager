/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package ru.bocharova.tm.entity;

/**
 * (no documentation provided)
 */
@javax.xml.bind.annotation.XmlType (
  name = "project",
  namespace = ""
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "project",
  namespace = ""
)
public class Project extends ru.bocharova.tm.entity.AbstractEntity {

  private java.util.Date _dateStart;
  private java.util.Date _dateEnd;
  private java.lang.String _userID;
  private ru.bocharova.tm.enumerate.Status _status;

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "dateStart",
    namespace = ""
  )
  public java.util.Date getDateStart() {
    return this._dateStart;
  }

  /**
   * (no documentation provided)
   */
  public void setDateStart(java.util.Date _dateStart) {
    this._dateStart = _dateStart;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "dateEnd",
    namespace = ""
  )
  public java.util.Date getDateEnd() {
    return this._dateEnd;
  }

  /**
   * (no documentation provided)
   */
  public void setDateEnd(java.util.Date _dateEnd) {
    this._dateEnd = _dateEnd;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "userID",
    namespace = ""
  )
  public java.lang.String getUserID() {
    return this._userID;
  }

  /**
   * (no documentation provided)
   */
  public void setUserID(java.lang.String _userID) {
    this._userID = _userID;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "status",
    namespace = ""
  )
  public ru.bocharova.tm.enumerate.Status getStatus() {
    return this._status;
  }

  /**
   * (no documentation provided)
   */
  public void setStatus(ru.bocharova.tm.enumerate.Status _status) {
    this._status = _status;
  }

}
