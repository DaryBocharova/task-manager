#include <enunciate-common.c>
#ifndef DEF_tm_server_ns2_project_H
#define DEF_tm_server_ns2_project_H

/**
 * (no documentation provided)
 */
struct tm_server_ns2_project {


  /**
   * (no documentation provided)
   */
  struct tm *dateStart;

  /**
   * (no documentation provided)
   */
  struct tm *dateEnd;

  /**
   * (no documentation provided)
   */
  xmlChar *userID;

  /**
   * (no documentation provided)
   */
  enum tm_server_ns2_status *status;
};

/**
 * Reads a Project element from XML. The element to be read is "project", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
struct tm_server_ns2_project *xml_read_tm_server_ns2_project(xmlTextReaderPtr reader);

/**
 * Writes a Project to XML under element name "project".
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_tm_server_ns2_project(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project);

/**
 * Frees a Project.
 *
 * @param _project The Project to free.
 */
void free_tm_server_ns2_project(struct tm_server_ns2_project *_project);

/**
 * Reads a Project element from XML. The element to be read is "project", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
struct tm_server_ns2_project *xmlTextReaderReadNs2ProjectElement(xmlTextReaderPtr reader);

/**
 * Writes a Project to XML under element name "project".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2ProjectElement(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project);

/**
 * Writes a Project to XML under element name "project".
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2ProjectElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project, int writeNamespaces);

/**
 * Frees the children of a Project.
 *
 * @param _project The Project whose children are to be free.
 */
static void freeNs2ProjectElement(struct tm_server_ns2_project *_project);

/**
 * Reads a Project from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
static struct tm_server_ns2_project *xmlTextReaderReadNs2ProjectType(xmlTextReaderPtr reader);

/**
 * Writes a Project to XML.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2ProjectType(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project);

/**
 * Frees the elements of a Project.
 *
 * @param _project The Project to free.
 */
static void freeNs2ProjectType(struct tm_server_ns2_project *_project);

#endif /* DEF_tm_server_ns2_project_H */
#ifndef DEF_tm_server_ns2_session_H
#define DEF_tm_server_ns2_session_H

/**
 * (no documentation provided)
 */
struct tm_server_ns2_session {

};

/**
 * Reads a Session from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Session, or NULL in case of error.
 */
static struct tm_server_ns2_session *xmlTextReaderReadNs2SessionType(xmlTextReaderPtr reader);

/**
 * Writes a Session to XML.
 *
 * @param writer The XML writer.
 * @param _session The Session to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2SessionType(xmlTextWriterPtr writer, struct tm_server_ns2_session *_session);

/**
 * Frees the elements of a Session.
 *
 * @param _session The Session to free.
 */
static void freeNs2SessionType(struct tm_server_ns2_session *_session);

#endif /* DEF_tm_server_ns2_session_H */
#ifndef DEF_tm_server_ns2_task_H
#define DEF_tm_server_ns2_task_H

/**
 * (no documentation provided)
 */
struct tm_server_ns2_task {


  /**
   * (no documentation provided)
   */
  xmlChar *projectID;

  /**
   * (no documentation provided)
   */
  struct tm *dateStart;

  /**
   * (no documentation provided)
   */
  struct tm *dateEnd;

  /**
   * (no documentation provided)
   */
  xmlChar *userID;

  /**
   * (no documentation provided)
   */
  enum tm_server_ns2_status *status;
};

/**
 * Reads a Task element from XML. The element to be read is "task", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
struct tm_server_ns2_task *xml_read_tm_server_ns2_task(xmlTextReaderPtr reader);

/**
 * Writes a Task to XML under element name "task".
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_tm_server_ns2_task(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task);

/**
 * Frees a Task.
 *
 * @param _task The Task to free.
 */
void free_tm_server_ns2_task(struct tm_server_ns2_task *_task);

/**
 * Reads a Task element from XML. The element to be read is "task", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
struct tm_server_ns2_task *xmlTextReaderReadNs2TaskElement(xmlTextReaderPtr reader);

/**
 * Writes a Task to XML under element name "task".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2TaskElement(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task);

/**
 * Writes a Task to XML under element name "task".
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2TaskElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task, int writeNamespaces);

/**
 * Frees the children of a Task.
 *
 * @param _task The Task whose children are to be free.
 */
static void freeNs2TaskElement(struct tm_server_ns2_task *_task);

/**
 * Reads a Task from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
static struct tm_server_ns2_task *xmlTextReaderReadNs2TaskType(xmlTextReaderPtr reader);

/**
 * Writes a Task to XML.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2TaskType(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task);

/**
 * Frees the elements of a Task.
 *
 * @param _task The Task to free.
 */
static void freeNs2TaskType(struct tm_server_ns2_task *_task);

#endif /* DEF_tm_server_ns2_task_H */
#ifndef DEF_tm_server_ns2_user_H
#define DEF_tm_server_ns2_user_H

/**
 * (no documentation provided)
 */
struct tm_server_ns2_user {


  /**
   * (no documentation provided)
   */
  xmlChar *login;

  /**
   * (no documentation provided)
   */
  xmlChar *password;

  /**
   * (no documentation provided)
   */
  enum tm_server_ns2_role *role;
};

/**
 * Reads a User element from XML. The element to be read is "user", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
struct tm_server_ns2_user *xml_read_tm_server_ns2_user(xmlTextReaderPtr reader);

/**
 * Writes a User to XML under element name "user".
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_tm_server_ns2_user(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user);

/**
 * Frees a User.
 *
 * @param _user The User to free.
 */
void free_tm_server_ns2_user(struct tm_server_ns2_user *_user);

/**
 * Reads a User element from XML. The element to be read is "user", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
struct tm_server_ns2_user *xmlTextReaderReadNs2UserElement(xmlTextReaderPtr reader);

/**
 * Writes a User to XML under element name "user".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2UserElement(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user);

/**
 * Writes a User to XML under element name "user".
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2UserElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user, int writeNamespaces);

/**
 * Frees the children of a User.
 *
 * @param _user The User whose children are to be free.
 */
static void freeNs2UserElement(struct tm_server_ns2_user *_user);

/**
 * Reads a User from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
static struct tm_server_ns2_user *xmlTextReaderReadNs2UserType(xmlTextReaderPtr reader);

/**
 * Writes a User to XML.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2UserType(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user);

/**
 * Frees the elements of a User.
 *
 * @param _user The User to free.
 */
static void freeNs2UserType(struct tm_server_ns2_user *_user);

#endif /* DEF_tm_server_ns2_user_H */
#ifndef DEF_tm_server_ns2_role_H
#define DEF_tm_server_ns2_role_H

/**
 * (no documentation provided)
 */
enum tm_server_ns2_role {

  /**
   * (no documentation provided)
   */
  TM_SERVER_NS2_ROLE_USER,

  /**
   * (no documentation provided)
   */
  TM_SERVER_NS2_ROLE_ADMINISTRATOR
};

/**
 * Reads a Role from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Role, or NULL if unable to be read.
 */
static enum tm_server_ns2_role *xmlTextReaderReadNs2RoleType(xmlTextReaderPtr reader);

/**
 * Writes a Role to XML.
 *
 * @param writer The XML writer.
 * @param _role The Role to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2RoleType(xmlTextWriterPtr writer, enum tm_server_ns2_role *_role);

/**
 * Frees a Role.
 *
 * @param _role The Role to free.
 */
static void freeNs2RoleType(enum tm_server_ns2_role *_role);

#endif
#ifndef DEF_tm_server_ns2_status_H
#define DEF_tm_server_ns2_status_H

/**
 * (no documentation provided)
 */
enum tm_server_ns2_status {

  /**
   * (no documentation provided)
   */
  TM_SERVER_NS2_STATUS_PLANNED,

  /**
   * (no documentation provided)
   */
  TM_SERVER_NS2_STATUS_INPROCESS,

  /**
   * (no documentation provided)
   */
  TM_SERVER_NS2_STATUS_DONE
};

/**
 * Reads a Status from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Status, or NULL if unable to be read.
 */
static enum tm_server_ns2_status *xmlTextReaderReadNs2StatusType(xmlTextReaderPtr reader);

/**
 * Writes a Status to XML.
 *
 * @param writer The XML writer.
 * @param _status The Status to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2StatusType(xmlTextWriterPtr writer, enum tm_server_ns2_status *_status);

/**
 * Frees a Status.
 *
 * @param _status The Status to free.
 */
static void freeNs2StatusType(enum tm_server_ns2_status *_status);

#endif
#ifndef DEF_tm_server_ns2_project_M
#define DEF_tm_server_ns2_project_M

/**
 * Reads a Project element from XML. The element to be read is "project", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
struct tm_server_ns2_project *xml_read_tm_server_ns2_project(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs2ProjectElement(reader);
}

/**
 * Writes a Project to XML under element name "project".
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_tm_server_ns2_project(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project) {
  return xmlTextWriterWriteNs2ProjectElementNS(writer, _project, 1);
}

/**
 * Frees a Project.
 *
 * @param _project The Project to free.
 */
void free_tm_server_ns2_project(struct tm_server_ns2_project *_project) {
  freeNs2ProjectType(_project);
  free(_project);
}

/**
 * Reads a Project element from XML. The element to be read is "project", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
struct tm_server_ns2_project *xmlTextReaderReadNs2ProjectElement(xmlTextReaderPtr reader) {
  struct tm_server_ns2_project *_project = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "project", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}project.\n");
#endif
    _project = xmlTextReaderReadNs2ProjectType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_project == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}project failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}project failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _project;
}

/**
 * Writes a Project to XML under element name "project".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2ProjectElement(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project) {
  return xmlTextWriterWriteNs2ProjectElementNS(writer, _project, 0);
}

/**
 * Writes a Project to XML under element name "project".
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2ProjectElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "project", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}project. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}project for root element {}project...\n");
#endif
  status = xmlTextWriterWriteNs2ProjectType(writer, _project);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}project. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}project. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a Project.
 *
 * @param _project The Project whose children are to be free.
 */
static void freeNs2ProjectElement(struct tm_server_ns2_project *_project) {
  freeNs2ProjectType(_project);
}

/**
 * Reads a Project from XML. The reader is assumed to be at the start element.
 *
 * @return the Project, or NULL in case of error.
 */
static struct tm_server_ns2_project *xmlTextReaderReadNs2ProjectType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct tm_server_ns2_project *_project = calloc(1, sizeof(struct tm_server_ns2_project));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs2ProjectType(_project);
        free(_project);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "dateStart", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
        _child_accessor = xmlTextReaderReadXsDateTimeType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2ProjectType(_project);
          free(_project);
          return NULL;
        }

        _project->dateStart = ((struct tm*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "dateEnd", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
        _child_accessor = xmlTextReaderReadXsDateTimeType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2ProjectType(_project);
          free(_project);
          return NULL;
        }

        _project->dateEnd = ((struct tm*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "userID", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2ProjectType(_project);
          free(_project);
          return NULL;
        }

        _project->userID = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "status", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}status of type {}status.\n");
#endif
        _child_accessor = xmlTextReaderReadNs2StatusType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}status of type {}status.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2ProjectType(_project);
          free(_project);
          return NULL;
        }

        _project->status = ((enum tm_server_ns2_status*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}project.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}project. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _project;
}

/**
 * Writes a Project to XML.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2ProjectType(xmlTextWriterPtr writer, struct tm_server_ns2_project *_project) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_project->dateStart != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateStart", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateStart...\n");
#endif
    status = xmlTextWriterWriteXsDateTimeType(writer, (_project->dateStart));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_project->dateEnd != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateEnd", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateEnd...\n");
#endif
    status = xmlTextWriterWriteXsDateTimeType(writer, (_project->dateEnd));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_project->userID != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "userID", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}userID...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_project->userID));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_project->status != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "status", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {}status for element {}status...\n");
#endif
    status = xmlTextWriterWriteNs2StatusType(writer, (_project->status));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {}status for element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Project.
 *
 * @param _project The Project to free.
 */
static void freeNs2ProjectType(struct tm_server_ns2_project *_project) {
  int i;
  if (_project->dateStart != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor dateStart of type tm_server_ns2_project...\n");
#endif
    freeXsDateTimeType(_project->dateStart);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor dateStart of type tm_server_ns2_project...\n");
#endif
    free(_project->dateStart);
  }
  if (_project->dateEnd != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor dateEnd of type tm_server_ns2_project...\n");
#endif
    freeXsDateTimeType(_project->dateEnd);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor dateEnd of type tm_server_ns2_project...\n");
#endif
    free(_project->dateEnd);
  }
  if (_project->userID != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor userID of type tm_server_ns2_project...\n");
#endif
    freeXsStringType(_project->userID);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor userID of type tm_server_ns2_project...\n");
#endif
    free(_project->userID);
  }
  if (_project->status != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor status of type tm_server_ns2_project...\n");
#endif
    freeNs2StatusType(_project->status);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor status of type tm_server_ns2_project...\n");
#endif
    free(_project->status);
  }
}
#endif /* DEF_tm_server_ns2_project_M */
#ifndef DEF_tm_server_ns2_session_M
#define DEF_tm_server_ns2_session_M

/**
 * Reads a Session from XML. The reader is assumed to be at the start element.
 *
 * @return the Session, or NULL in case of error.
 */
static struct tm_server_ns2_session *xmlTextReaderReadNs2SessionType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct tm_server_ns2_session *_session = calloc(1, sizeof(struct tm_server_ns2_session));




  return _session;
}

/**
 * Writes a Session to XML.
 *
 * @param writer The XML writer.
 * @param _session The Session to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2SessionType(xmlTextWriterPtr writer, struct tm_server_ns2_session *_session) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a Session.
 *
 * @param _session The Session to free.
 */
static void freeNs2SessionType(struct tm_server_ns2_session *_session) {
  int i;
}
#endif /* DEF_tm_server_ns2_session_M */
#ifndef DEF_tm_server_ns2_task_M
#define DEF_tm_server_ns2_task_M

/**
 * Reads a Task element from XML. The element to be read is "task", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
struct tm_server_ns2_task *xml_read_tm_server_ns2_task(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs2TaskElement(reader);
}

/**
 * Writes a Task to XML under element name "task".
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_tm_server_ns2_task(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task) {
  return xmlTextWriterWriteNs2TaskElementNS(writer, _task, 1);
}

/**
 * Frees a Task.
 *
 * @param _task The Task to free.
 */
void free_tm_server_ns2_task(struct tm_server_ns2_task *_task) {
  freeNs2TaskType(_task);
  free(_task);
}

/**
 * Reads a Task element from XML. The element to be read is "task", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
struct tm_server_ns2_task *xmlTextReaderReadNs2TaskElement(xmlTextReaderPtr reader) {
  struct tm_server_ns2_task *_task = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "task", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}task.\n");
#endif
    _task = xmlTextReaderReadNs2TaskType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_task == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}task failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}task failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _task;
}

/**
 * Writes a Task to XML under element name "task".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2TaskElement(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task) {
  return xmlTextWriterWriteNs2TaskElementNS(writer, _task, 0);
}

/**
 * Writes a Task to XML under element name "task".
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2TaskElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "task", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}task. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}task for root element {}task...\n");
#endif
  status = xmlTextWriterWriteNs2TaskType(writer, _task);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}task. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}task. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a Task.
 *
 * @param _task The Task whose children are to be free.
 */
static void freeNs2TaskElement(struct tm_server_ns2_task *_task) {
  freeNs2TaskType(_task);
}

/**
 * Reads a Task from XML. The reader is assumed to be at the start element.
 *
 * @return the Task, or NULL in case of error.
 */
static struct tm_server_ns2_task *xmlTextReaderReadNs2TaskType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct tm_server_ns2_task *_task = calloc(1, sizeof(struct tm_server_ns2_task));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs2TaskType(_task);
        free(_task);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "projectID", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}projectID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}projectID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2TaskType(_task);
          free(_task);
          return NULL;
        }

        _task->projectID = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "dateStart", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
        _child_accessor = xmlTextReaderReadXsDateTimeType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2TaskType(_task);
          free(_task);
          return NULL;
        }

        _task->dateStart = ((struct tm*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "dateEnd", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
        _child_accessor = xmlTextReaderReadXsDateTimeType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2TaskType(_task);
          free(_task);
          return NULL;
        }

        _task->dateEnd = ((struct tm*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "userID", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2TaskType(_task);
          free(_task);
          return NULL;
        }

        _task->userID = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "status", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}status of type {}status.\n");
#endif
        _child_accessor = xmlTextReaderReadNs2StatusType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}status of type {}status.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2TaskType(_task);
          free(_task);
          return NULL;
        }

        _task->status = ((enum tm_server_ns2_status*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}task.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}task. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _task;
}

/**
 * Writes a Task to XML.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2TaskType(xmlTextWriterPtr writer, struct tm_server_ns2_task *_task) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_task->projectID != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "projectID", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}projectID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}projectID...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_task->projectID));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}projectID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}projectID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_task->dateStart != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateStart", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateStart...\n");
#endif
    status = xmlTextWriterWriteXsDateTimeType(writer, (_task->dateStart));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}dateStart. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_task->dateEnd != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateEnd", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateEnd...\n");
#endif
    status = xmlTextWriterWriteXsDateTimeType(writer, (_task->dateEnd));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}dateTime for element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}dateEnd. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_task->userID != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "userID", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}userID...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_task->userID));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}userID. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_task->status != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "status", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {}status for element {}status...\n");
#endif
    status = xmlTextWriterWriteNs2StatusType(writer, (_task->status));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {}status for element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}status. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Task.
 *
 * @param _task The Task to free.
 */
static void freeNs2TaskType(struct tm_server_ns2_task *_task) {
  int i;
  if (_task->projectID != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor projectID of type tm_server_ns2_task...\n");
#endif
    freeXsStringType(_task->projectID);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor projectID of type tm_server_ns2_task...\n");
#endif
    free(_task->projectID);
  }
  if (_task->dateStart != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor dateStart of type tm_server_ns2_task...\n");
#endif
    freeXsDateTimeType(_task->dateStart);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor dateStart of type tm_server_ns2_task...\n");
#endif
    free(_task->dateStart);
  }
  if (_task->dateEnd != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor dateEnd of type tm_server_ns2_task...\n");
#endif
    freeXsDateTimeType(_task->dateEnd);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor dateEnd of type tm_server_ns2_task...\n");
#endif
    free(_task->dateEnd);
  }
  if (_task->userID != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor userID of type tm_server_ns2_task...\n");
#endif
    freeXsStringType(_task->userID);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor userID of type tm_server_ns2_task...\n");
#endif
    free(_task->userID);
  }
  if (_task->status != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor status of type tm_server_ns2_task...\n");
#endif
    freeNs2StatusType(_task->status);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor status of type tm_server_ns2_task...\n");
#endif
    free(_task->status);
  }
}
#endif /* DEF_tm_server_ns2_task_M */
#ifndef DEF_tm_server_ns2_user_M
#define DEF_tm_server_ns2_user_M

/**
 * Reads a User element from XML. The element to be read is "user", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
struct tm_server_ns2_user *xml_read_tm_server_ns2_user(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs2UserElement(reader);
}

/**
 * Writes a User to XML under element name "user".
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_tm_server_ns2_user(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user) {
  return xmlTextWriterWriteNs2UserElementNS(writer, _user, 1);
}

/**
 * Frees a User.
 *
 * @param _user The User to free.
 */
void free_tm_server_ns2_user(struct tm_server_ns2_user *_user) {
  freeNs2UserType(_user);
  free(_user);
}

/**
 * Reads a User element from XML. The element to be read is "user", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
struct tm_server_ns2_user *xmlTextReaderReadNs2UserElement(xmlTextReaderPtr reader) {
  struct tm_server_ns2_user *_user = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "user", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}user.\n");
#endif
    _user = xmlTextReaderReadNs2UserType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_user == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}user failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}user failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _user;
}

/**
 * Writes a User to XML under element name "user".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2UserElement(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user) {
  return xmlTextWriterWriteNs2UserElementNS(writer, _user, 0);
}

/**
 * Writes a User to XML under element name "user".
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs2UserElementNS(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "user", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}user. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}user for root element {}user...\n");
#endif
  status = xmlTextWriterWriteNs2UserType(writer, _user);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}user. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}user. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a User.
 *
 * @param _user The User whose children are to be free.
 */
static void freeNs2UserElement(struct tm_server_ns2_user *_user) {
  freeNs2UserType(_user);
}

/**
 * Reads a User from XML. The reader is assumed to be at the start element.
 *
 * @return the User, or NULL in case of error.
 */
static struct tm_server_ns2_user *xmlTextReaderReadNs2UserType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct tm_server_ns2_user *_user = calloc(1, sizeof(struct tm_server_ns2_user));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs2UserType(_user);
        free(_user);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "login", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}login of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}login of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2UserType(_user);
          free(_user);
          return NULL;
        }

        _user->login = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "password", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}password of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}password of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2UserType(_user);
          free(_user);
          return NULL;
        }

        _user->password = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "role", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}role of type {}role.\n");
#endif
        _child_accessor = xmlTextReaderReadNs2RoleType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}role of type {}role.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs2UserType(_user);
          free(_user);
          return NULL;
        }

        _user->role = ((enum tm_server_ns2_role*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}user.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}user. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _user;
}

/**
 * Writes a User to XML.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2UserType(xmlTextWriterPtr writer, struct tm_server_ns2_user *_user) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_user->login != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "login", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}login. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}login...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_user->login));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}login. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}login. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_user->password != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "password", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}password. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}password...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_user->password));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}password. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}password. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_user->role != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "role", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}role. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {}role for element {}role...\n");
#endif
    status = xmlTextWriterWriteNs2RoleType(writer, (_user->role));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {}role for element {}role. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}role. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a User.
 *
 * @param _user The User to free.
 */
static void freeNs2UserType(struct tm_server_ns2_user *_user) {
  int i;
  if (_user->login != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor login of type tm_server_ns2_user...\n");
#endif
    freeXsStringType(_user->login);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor login of type tm_server_ns2_user...\n");
#endif
    free(_user->login);
  }
  if (_user->password != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor password of type tm_server_ns2_user...\n");
#endif
    freeXsStringType(_user->password);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor password of type tm_server_ns2_user...\n");
#endif
    free(_user->password);
  }
  if (_user->role != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor role of type tm_server_ns2_user...\n");
#endif
    freeNs2RoleType(_user->role);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor role of type tm_server_ns2_user...\n");
#endif
    free(_user->role);
  }
}
#endif /* DEF_tm_server_ns2_user_M */
#ifndef DEF_tm_server_ns2_role_M
#define DEF_tm_server_ns2_role_M

/**
 * Reads a Role from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Role, or NULL if unable to be read.
 */
static enum tm_server_ns2_role *xmlTextReaderReadNs2RoleType(xmlTextReaderPtr reader) {
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum tm_server_ns2_role *value = calloc(1, sizeof(enum tm_server_ns2_role));
  if (enumValue != NULL) {
    if (xmlStrcmp(enumValue, BAD_CAST "USER") == 0) {
      *value = TM_SERVER_NS2_ROLE_USER;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "ADMINISTRATOR") == 0) {
      *value = TM_SERVER_NS2_ROLE_ADMINISTRATOR;
      free(enumValue);
      return value;
    }
#if DEBUG_ENUNCIATE
    printf("Attempt to read enum value failed: %s doesn't match an enum value.\n", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    printf("Attempt to read enum value failed: NULL value.\n");
  }
#endif

  return NULL;
}

/**
 * Writes a Role to XML.
 *
 * @param writer The XML writer.
 * @param _role The Role to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2RoleType(xmlTextWriterPtr writer, enum tm_server_ns2_role *_role) {
  switch (*_role) {
    case TM_SERVER_NS2_ROLE_USER:
      return xmlTextWriterWriteString(writer, BAD_CAST "USER");
    case TM_SERVER_NS2_ROLE_ADMINISTRATOR:
      return xmlTextWriterWriteString(writer, BAD_CAST "ADMINISTRATOR");
  }

#if DEBUG_ENUNCIATE
  printf("Unable to write enum value (no valid value found).\n");
#endif
  return -1;
}

/**
 * Frees a Role.
 *
 * @param _role The Role to free.
 */
static void freeNs2RoleType(enum tm_server_ns2_role *_role) {
  //no-op
}
#endif /* DEF_tm_server_ns2_role_M */
#ifndef DEF_tm_server_ns2_status_M
#define DEF_tm_server_ns2_status_M

/**
 * Reads a Status from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Status, or NULL if unable to be read.
 */
static enum tm_server_ns2_status *xmlTextReaderReadNs2StatusType(xmlTextReaderPtr reader) {
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum tm_server_ns2_status *value = calloc(1, sizeof(enum tm_server_ns2_status));
  if (enumValue != NULL) {
    if (xmlStrcmp(enumValue, BAD_CAST "PLANNED") == 0) {
      *value = TM_SERVER_NS2_STATUS_PLANNED;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "INPROCESS") == 0) {
      *value = TM_SERVER_NS2_STATUS_INPROCESS;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "DONE") == 0) {
      *value = TM_SERVER_NS2_STATUS_DONE;
      free(enumValue);
      return value;
    }
#if DEBUG_ENUNCIATE
    printf("Attempt to read enum value failed: %s doesn't match an enum value.\n", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    printf("Attempt to read enum value failed: NULL value.\n");
  }
#endif

  return NULL;
}

/**
 * Writes a Status to XML.
 *
 * @param writer The XML writer.
 * @param _status The Status to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2StatusType(xmlTextWriterPtr writer, enum tm_server_ns2_status *_status) {
  switch (*_status) {
    case TM_SERVER_NS2_STATUS_PLANNED:
      return xmlTextWriterWriteString(writer, BAD_CAST "PLANNED");
    case TM_SERVER_NS2_STATUS_INPROCESS:
      return xmlTextWriterWriteString(writer, BAD_CAST "INPROCESS");
    case TM_SERVER_NS2_STATUS_DONE:
      return xmlTextWriterWriteString(writer, BAD_CAST "DONE");
  }

#if DEBUG_ENUNCIATE
  printf("Unable to write enum value (no valid value found).\n");
#endif
  return -1;
}

/**
 * Frees a Status.
 *
 * @param _status The Status to free.
 */
static void freeNs2StatusType(enum tm_server_ns2_status *_status) {
  //no-op
}
#endif /* DEF_tm_server_ns2_status_M */
