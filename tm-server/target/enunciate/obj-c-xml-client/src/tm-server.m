#import "tm-server.h"
#ifndef DEF_TM_SERVERNS2Status_M
#define DEF_TM_SERVERNS2Status_M

/**
 * Reads a Status from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Status, or NULL if unable to be read.
 */
static enum TM_SERVERNS2Status *xmlTextReaderReadTM_SERVERNS2StatusType(xmlTextReaderPtr reader)
{
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum TM_SERVERNS2Status *value = calloc(1, sizeof(enum TM_SERVERNS2Status));
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
    NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    NSLog(@"Attempt to read enum value failed: NULL value.");
  }
#endif

  return NULL;
}

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _status The string to format.
 * @return The enum value or NULL on error.
 */
enum TM_SERVERNS2Status *formatStringToTM_SERVERNS2StatusType(NSString *_status)
{
  enum TM_SERVERNS2Status *value = calloc(1, sizeof(enum TM_SERVERNS2Status));
  if ([@"PLANNED" isEqualToString:_status]) {
    *value = TM_SERVER_NS2_STATUS_PLANNED;
  }
  else if ([@"INPROCESS" isEqualToString:_status]) {
    *value = TM_SERVER_NS2_STATUS_INPROCESS;
  }
  else if ([@"DONE" isEqualToString:_status]) {
    *value = TM_SERVER_NS2_STATUS_DONE;
  }
  else{
#if DEBUG_ENUNCIATE
  NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", [_status UTF8String]);
#endif
    value = NULL;
  }
  return value;
}

/**
 * Writes a Status to XML.
 *
 * @param writer The XML writer.
 * @param _status The Status to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteTM_SERVERNS2StatusType(xmlTextWriterPtr writer, enum TM_SERVERNS2Status *_status)
{
  switch (*_status) {
    case TM_SERVER_NS2_STATUS_PLANNED:
      return xmlTextWriterWriteString(writer, BAD_CAST "PLANNED");
    case TM_SERVER_NS2_STATUS_INPROCESS:
      return xmlTextWriterWriteString(writer, BAD_CAST "INPROCESS");
    case TM_SERVER_NS2_STATUS_DONE:
      return xmlTextWriterWriteString(writer, BAD_CAST "DONE");
  }

#if DEBUG_ENUNCIATE
  NSLog(@"Unable to write enum value (no valid value found).");
#endif
  return -1;
}

/**
 * Utility method for getting the string value of Status.
 *
 * @param _status The Status to format.
 * @return The string value or NULL on error.
 */
static NSString *formatTM_SERVERNS2StatusTypeToString(enum TM_SERVERNS2Status *_status)
{
  switch (*_status) {
    case TM_SERVER_NS2_STATUS_PLANNED:
      return @"PLANNED";
    case TM_SERVER_NS2_STATUS_INPROCESS:
      return @"INPROCESS";
    case TM_SERVER_NS2_STATUS_DONE:
      return @"DONE";
    default:
      return NULL;
  }

  return NULL;
}
#endif /* DEF_TM_SERVERNS2Status_M */
#ifndef DEF_TM_SERVERNS2Role_M
#define DEF_TM_SERVERNS2Role_M

/**
 * Reads a Role from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Role, or NULL if unable to be read.
 */
static enum TM_SERVERNS2Role *xmlTextReaderReadTM_SERVERNS2RoleType(xmlTextReaderPtr reader)
{
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum TM_SERVERNS2Role *value = calloc(1, sizeof(enum TM_SERVERNS2Role));
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
    NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    NSLog(@"Attempt to read enum value failed: NULL value.");
  }
#endif

  return NULL;
}

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _role The string to format.
 * @return The enum value or NULL on error.
 */
enum TM_SERVERNS2Role *formatStringToTM_SERVERNS2RoleType(NSString *_role)
{
  enum TM_SERVERNS2Role *value = calloc(1, sizeof(enum TM_SERVERNS2Role));
  if ([@"USER" isEqualToString:_role]) {
    *value = TM_SERVER_NS2_ROLE_USER;
  }
  else if ([@"ADMINISTRATOR" isEqualToString:_role]) {
    *value = TM_SERVER_NS2_ROLE_ADMINISTRATOR;
  }
  else{
#if DEBUG_ENUNCIATE
  NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", [_role UTF8String]);
#endif
    value = NULL;
  }
  return value;
}

/**
 * Writes a Role to XML.
 *
 * @param writer The XML writer.
 * @param _role The Role to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteTM_SERVERNS2RoleType(xmlTextWriterPtr writer, enum TM_SERVERNS2Role *_role)
{
  switch (*_role) {
    case TM_SERVER_NS2_ROLE_USER:
      return xmlTextWriterWriteString(writer, BAD_CAST "USER");
    case TM_SERVER_NS2_ROLE_ADMINISTRATOR:
      return xmlTextWriterWriteString(writer, BAD_CAST "ADMINISTRATOR");
  }

#if DEBUG_ENUNCIATE
  NSLog(@"Unable to write enum value (no valid value found).");
#endif
  return -1;
}

/**
 * Utility method for getting the string value of Role.
 *
 * @param _role The Role to format.
 * @return The string value or NULL on error.
 */
static NSString *formatTM_SERVERNS2RoleTypeToString(enum TM_SERVERNS2Role *_role)
{
  switch (*_role) {
    case TM_SERVER_NS2_ROLE_USER:
      return @"USER";
    case TM_SERVER_NS2_ROLE_ADMINISTRATOR:
      return @"ADMINISTRATOR";
    default:
      return NULL;
  }

  return NULL;
}
#endif /* DEF_TM_SERVERNS2Role_M */
#ifndef DEF_TM_SERVERNS2AbstractEntity_M
#define DEF_TM_SERVERNS2AbstractEntity_M

/**
 * (no documentation provided)
 */
@implementation TM_SERVERNS2AbstractEntity

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation TM_SERVERNS2AbstractEntity */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface TM_SERVERNS2AbstractEntity (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface TM_SERVERNS2AbstractEntity (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation TM_SERVERNS2AbstractEntity (JAXB)

/**
 * Read an instance of TM_SERVERNS2AbstractEntity from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of TM_SERVERNS2AbstractEntity defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  TM_SERVERNS2AbstractEntity *_tM_SERVERNS2AbstractEntity = [[TM_SERVERNS2AbstractEntity alloc] init];
  NS_DURING
  {
    [_tM_SERVERNS2AbstractEntity initWithReader: reader];
  }
  NS_HANDLER
  {
    _tM_SERVERNS2AbstractEntity = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_tM_SERVERNS2AbstractEntity autorelease];
  return _tM_SERVERNS2AbstractEntity;
}

/**
 * Initialize this instance of TM_SERVERNS2AbstractEntity according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of TM_SERVERNS2AbstractEntity to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation TM_SERVERNS2AbstractEntity (JAXB) */

#endif /* DEF_TM_SERVERNS2AbstractEntity_M */
#ifndef DEF_TM_SERVERNS2User_M
#define DEF_TM_SERVERNS2User_M

/**
 * (no documentation provided)
 */
@implementation TM_SERVERNS2User

/**
 * (no documentation provided)
 */
- (NSString *) login
{
  return _login;
}

/**
 * (no documentation provided)
 */
- (void) setLogin: (NSString *) newLogin
{
  [newLogin retain];
  [_login release];
  _login = newLogin;
}

/**
 * (no documentation provided)
 */
- (NSString *) password
{
  return _password;
}

/**
 * (no documentation provided)
 */
- (void) setPassword: (NSString *) newPassword
{
  [newPassword retain];
  [_password release];
  _password = newPassword;
}

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Role *) role
{
  return _role;
}

/**
 * (no documentation provided)
 */
- (void) setRole: (enum TM_SERVERNS2Role *) newRole
{
  if (_role != NULL) {
    free(_role);
  }
  _role = newRole;
}

- (void) dealloc
{
  [self setLogin: nil];
  [self setPassword: nil];
  [self setRole: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  TM_SERVERNS2User *_tM_SERVERNS2User;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _tM_SERVERNS2User = (TM_SERVERNS2User *) [TM_SERVERNS2User readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _tM_SERVERNS2User;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation TM_SERVERNS2User */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface TM_SERVERNS2User (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface TM_SERVERNS2User (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation TM_SERVERNS2User (JAXB)

/**
 * Read an instance of TM_SERVERNS2User from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of TM_SERVERNS2User defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  TM_SERVERNS2User *_tM_SERVERNS2User = [[TM_SERVERNS2User alloc] init];
  NS_DURING
  {
    [_tM_SERVERNS2User initWithReader: reader];
  }
  NS_HANDLER
  {
    _tM_SERVERNS2User = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_tM_SERVERNS2User autorelease];
  return _tM_SERVERNS2User;
}

/**
 * Initialize this instance of TM_SERVERNS2User according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of TM_SERVERNS2User to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a TM_SERVERNS2User from an XML reader. The element to be read is
 * "user".
 *
 * @param reader The XML reader.
 * @return The TM_SERVERNS2User.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  TM_SERVERNS2User *_user = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element user."];
    }
  }

  if (xmlStrcmp(BAD_CAST "user", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}user.");
#endif
    _user = (TM_SERVERNS2User *)[TM_SERVERNS2User readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}user.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2User. Expected element user. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2User. Expected element user. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _user;
}

/**
 * Writes this TM_SERVERNS2User to XML under element name "user".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this TM_SERVERNS2User to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "user", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}user. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}user for root element {}user...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}user for root element {}user...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}user. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "login", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}login of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}login of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setLogin: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "password", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}password of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}password of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setPassword: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "role", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadTM_SERVERNS2RoleType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setRole: ((enum TM_SERVERNS2Role*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self login]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "login", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}login."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}login...");
#endif
    [[self login] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}login...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}login."];
    }
  }
  if ([self password]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "password", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}password."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}password...");
#endif
    [[self password] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}password...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}password."];
    }
  }
  if ([self role] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "role", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}role."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}role...");
#endif
    status = xmlTextWriterWriteTM_SERVERNS2RoleType(writer, [self role]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}role...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}role."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}role."];
    }
  }
}
@end /* implementation TM_SERVERNS2User (JAXB) */

#endif /* DEF_TM_SERVERNS2User_M */
#ifndef DEF_TM_SERVERNS2Task_M
#define DEF_TM_SERVERNS2Task_M

/**
 * (no documentation provided)
 */
@implementation TM_SERVERNS2Task

/**
 * (no documentation provided)
 */
- (NSString *) projectID
{
  return _projectID;
}

/**
 * (no documentation provided)
 */
- (void) setProjectID: (NSString *) newProjectID
{
  [newProjectID retain];
  [_projectID release];
  _projectID = newProjectID;
}

/**
 * (no documentation provided)
 */
- (NSDate *) dateStart
{
  return _dateStart;
}

/**
 * (no documentation provided)
 */
- (void) setDateStart: (NSDate *) newDateStart
{
  [newDateStart retain];
  [_dateStart release];
  _dateStart = newDateStart;
}

/**
 * (no documentation provided)
 */
- (NSDate *) dateEnd
{
  return _dateEnd;
}

/**
 * (no documentation provided)
 */
- (void) setDateEnd: (NSDate *) newDateEnd
{
  [newDateEnd retain];
  [_dateEnd release];
  _dateEnd = newDateEnd;
}

/**
 * (no documentation provided)
 */
- (NSString *) userID
{
  return _userID;
}

/**
 * (no documentation provided)
 */
- (void) setUserID: (NSString *) newUserID
{
  [newUserID retain];
  [_userID release];
  _userID = newUserID;
}

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Status *) status
{
  return _status;
}

/**
 * (no documentation provided)
 */
- (void) setStatus: (enum TM_SERVERNS2Status *) newStatus
{
  if (_status != NULL) {
    free(_status);
  }
  _status = newStatus;
}

- (void) dealloc
{
  [self setProjectID: nil];
  [self setDateStart: nil];
  [self setDateEnd: nil];
  [self setUserID: nil];
  [self setStatus: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  TM_SERVERNS2Task *_tM_SERVERNS2Task;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _tM_SERVERNS2Task = (TM_SERVERNS2Task *) [TM_SERVERNS2Task readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _tM_SERVERNS2Task;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation TM_SERVERNS2Task */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface TM_SERVERNS2Task (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface TM_SERVERNS2Task (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation TM_SERVERNS2Task (JAXB)

/**
 * Read an instance of TM_SERVERNS2Task from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of TM_SERVERNS2Task defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  TM_SERVERNS2Task *_tM_SERVERNS2Task = [[TM_SERVERNS2Task alloc] init];
  NS_DURING
  {
    [_tM_SERVERNS2Task initWithReader: reader];
  }
  NS_HANDLER
  {
    _tM_SERVERNS2Task = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_tM_SERVERNS2Task autorelease];
  return _tM_SERVERNS2Task;
}

/**
 * Initialize this instance of TM_SERVERNS2Task according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of TM_SERVERNS2Task to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a TM_SERVERNS2Task from an XML reader. The element to be read is
 * "task".
 *
 * @param reader The XML reader.
 * @return The TM_SERVERNS2Task.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  TM_SERVERNS2Task *_task = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element task."];
    }
  }

  if (xmlStrcmp(BAD_CAST "task", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}task.");
#endif
    _task = (TM_SERVERNS2Task *)[TM_SERVERNS2Task readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}task.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2Task. Expected element task. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2Task. Expected element task. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _task;
}

/**
 * Writes this TM_SERVERNS2Task to XML under element name "task".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this TM_SERVERNS2Task to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "task", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}task. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}task for root element {}task...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}task for root element {}task...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}task. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "projectID", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}projectID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}projectID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setProjectID: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "dateStart", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setDateStart: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "dateEnd", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setDateEnd: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "userID", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setUserID: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "status", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadTM_SERVERNS2StatusType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setStatus: ((enum TM_SERVERNS2Status*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self projectID]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "projectID", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}projectID."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}projectID...");
#endif
    [[self projectID] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}projectID...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}projectID."];
    }
  }
  if ([self dateStart]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateStart", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}dateStart."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}dateStart...");
#endif
    [[self dateStart] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}dateStart...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}dateStart."];
    }
  }
  if ([self dateEnd]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateEnd", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}dateEnd."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}dateEnd...");
#endif
    [[self dateEnd] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}dateEnd...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}dateEnd."];
    }
  }
  if ([self userID]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "userID", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}userID."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}userID...");
#endif
    [[self userID] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}userID...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}userID."];
    }
  }
  if ([self status] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "status", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}status."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}status...");
#endif
    status = xmlTextWriterWriteTM_SERVERNS2StatusType(writer, [self status]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}status...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}status."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}status."];
    }
  }
}
@end /* implementation TM_SERVERNS2Task (JAXB) */

#endif /* DEF_TM_SERVERNS2Task_M */
#ifndef DEF_TM_SERVERNS2Session_M
#define DEF_TM_SERVERNS2Session_M

/**
 * (no documentation provided)
 */
@implementation TM_SERVERNS2Session

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation TM_SERVERNS2Session */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface TM_SERVERNS2Session (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface TM_SERVERNS2Session (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation TM_SERVERNS2Session (JAXB)

/**
 * Read an instance of TM_SERVERNS2Session from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of TM_SERVERNS2Session defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  TM_SERVERNS2Session *_tM_SERVERNS2Session = [[TM_SERVERNS2Session alloc] init];
  NS_DURING
  {
    [_tM_SERVERNS2Session initWithReader: reader];
  }
  NS_HANDLER
  {
    _tM_SERVERNS2Session = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_tM_SERVERNS2Session autorelease];
  return _tM_SERVERNS2Session;
}

/**
 * Initialize this instance of TM_SERVERNS2Session according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of TM_SERVERNS2Session to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation TM_SERVERNS2Session (JAXB) */

#endif /* DEF_TM_SERVERNS2Session_M */
#ifndef DEF_TM_SERVERNS2Project_M
#define DEF_TM_SERVERNS2Project_M

/**
 * (no documentation provided)
 */
@implementation TM_SERVERNS2Project

/**
 * (no documentation provided)
 */
- (NSDate *) dateStart
{
  return _dateStart;
}

/**
 * (no documentation provided)
 */
- (void) setDateStart: (NSDate *) newDateStart
{
  [newDateStart retain];
  [_dateStart release];
  _dateStart = newDateStart;
}

/**
 * (no documentation provided)
 */
- (NSDate *) dateEnd
{
  return _dateEnd;
}

/**
 * (no documentation provided)
 */
- (void) setDateEnd: (NSDate *) newDateEnd
{
  [newDateEnd retain];
  [_dateEnd release];
  _dateEnd = newDateEnd;
}

/**
 * (no documentation provided)
 */
- (NSString *) userID
{
  return _userID;
}

/**
 * (no documentation provided)
 */
- (void) setUserID: (NSString *) newUserID
{
  [newUserID retain];
  [_userID release];
  _userID = newUserID;
}

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Status *) status
{
  return _status;
}

/**
 * (no documentation provided)
 */
- (void) setStatus: (enum TM_SERVERNS2Status *) newStatus
{
  if (_status != NULL) {
    free(_status);
  }
  _status = newStatus;
}

- (void) dealloc
{
  [self setDateStart: nil];
  [self setDateEnd: nil];
  [self setUserID: nil];
  [self setStatus: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  TM_SERVERNS2Project *_tM_SERVERNS2Project;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _tM_SERVERNS2Project = (TM_SERVERNS2Project *) [TM_SERVERNS2Project readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _tM_SERVERNS2Project;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation TM_SERVERNS2Project */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface TM_SERVERNS2Project (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface TM_SERVERNS2Project (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation TM_SERVERNS2Project (JAXB)

/**
 * Read an instance of TM_SERVERNS2Project from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of TM_SERVERNS2Project defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  TM_SERVERNS2Project *_tM_SERVERNS2Project = [[TM_SERVERNS2Project alloc] init];
  NS_DURING
  {
    [_tM_SERVERNS2Project initWithReader: reader];
  }
  NS_HANDLER
  {
    _tM_SERVERNS2Project = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_tM_SERVERNS2Project autorelease];
  return _tM_SERVERNS2Project;
}

/**
 * Initialize this instance of TM_SERVERNS2Project according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of TM_SERVERNS2Project to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a TM_SERVERNS2Project from an XML reader. The element to be read is
 * "project".
 *
 * @param reader The XML reader.
 * @return The TM_SERVERNS2Project.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  TM_SERVERNS2Project *_project = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element project."];
    }
  }

  if (xmlStrcmp(BAD_CAST "project", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}project.");
#endif
    _project = (TM_SERVERNS2Project *)[TM_SERVERNS2Project readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}project.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2Project. Expected element project. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read TM_SERVERNS2Project. Expected element project. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _project;
}

/**
 * Writes this TM_SERVERNS2Project to XML under element name "project".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this TM_SERVERNS2Project to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "project", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}project. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}project for root element {}project...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}project for root element {}project...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}project. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "dateStart", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}dateStart of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setDateStart: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "dateEnd", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}dateEnd of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setDateEnd: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "userID", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}userID of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setUserID: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "status", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadTM_SERVERNS2StatusType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setStatus: ((enum TM_SERVERNS2Status*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self dateStart]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateStart", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}dateStart."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}dateStart...");
#endif
    [[self dateStart] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}dateStart...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}dateStart."];
    }
  }
  if ([self dateEnd]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "dateEnd", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}dateEnd."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}dateEnd...");
#endif
    [[self dateEnd] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}dateEnd...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}dateEnd."];
    }
  }
  if ([self userID]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "userID", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}userID."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}userID...");
#endif
    [[self userID] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}userID...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}userID."];
    }
  }
  if ([self status] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "status", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}status."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}status...");
#endif
    status = xmlTextWriterWriteTM_SERVERNS2StatusType(writer, [self status]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}status...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}status."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}status."];
    }
  }
}
@end /* implementation TM_SERVERNS2Project (JAXB) */

#endif /* DEF_TM_SERVERNS2Project_M */
