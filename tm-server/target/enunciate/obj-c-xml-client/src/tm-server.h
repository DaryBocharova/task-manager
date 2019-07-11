#import "enunciate-common.h"
#ifndef DEF_TM_SERVERNS2Status_H
#define DEF_TM_SERVERNS2Status_H

/**
 * (no documentation provided)
 */
enum TM_SERVERNS2Status
{

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
static enum TM_SERVERNS2Status *xmlTextReaderReadTM_SERVERNS2StatusType(xmlTextReaderPtr reader);

/**
 * Writes a Status to XML.
 *
 * @param writer The XML writer.
 * @param _status The Status to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteTM_SERVERNS2StatusType(xmlTextWriterPtr writer, enum TM_SERVERNS2Status *_status);

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _status The string to format.
 * @return The enum value or NULL on error.
 */
static enum TM_SERVERNS2Status *formatStringToTM_SERVERNS2StatusType(NSString *_status);

/**
 * Utility method for getting the string value of Status.
 *
 * @param _status The Status to format.
 * @return The string value or NULL on error.
 */
static NSString *formatTM_SERVERNS2StatusTypeToString(enum TM_SERVERNS2Status *_status);
#endif /* DEF_TM_SERVERNS2Status_H */
#ifndef DEF_TM_SERVERNS2Role_H
#define DEF_TM_SERVERNS2Role_H

/**
 * (no documentation provided)
 */
enum TM_SERVERNS2Role
{

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
static enum TM_SERVERNS2Role *xmlTextReaderReadTM_SERVERNS2RoleType(xmlTextReaderPtr reader);

/**
 * Writes a Role to XML.
 *
 * @param writer The XML writer.
 * @param _role The Role to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteTM_SERVERNS2RoleType(xmlTextWriterPtr writer, enum TM_SERVERNS2Role *_role);

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _role The string to format.
 * @return The enum value or NULL on error.
 */
static enum TM_SERVERNS2Role *formatStringToTM_SERVERNS2RoleType(NSString *_role);

/**
 * Utility method for getting the string value of Role.
 *
 * @param _role The Role to format.
 * @return The string value or NULL on error.
 */
static NSString *formatTM_SERVERNS2RoleTypeToString(enum TM_SERVERNS2Role *_role);
#endif /* DEF_TM_SERVERNS2Role_H */

@class TM_SERVERNS2AbstractEntity;
@class TM_SERVERNS2User;
@class TM_SERVERNS2Task;
@class TM_SERVERNS2Session;
@class TM_SERVERNS2Project;

#ifndef DEF_TM_SERVERNS2AbstractEntity_H
#define DEF_TM_SERVERNS2AbstractEntity_H

/**
 * (no documentation provided)
 */
@interface TM_SERVERNS2AbstractEntity : NSObject
{
  @private
}
@end /* interface TM_SERVERNS2AbstractEntity */

#endif /* DEF_TM_SERVERNS2AbstractEntity_H */
#ifndef DEF_TM_SERVERNS2User_H
#define DEF_TM_SERVERNS2User_H

/**
 * (no documentation provided)
 */
@interface TM_SERVERNS2User : TM_SERVERNS2AbstractEntity <EnunciateXML>
{
  @private
    NSString *_login;
    NSString *_password;
    enum TM_SERVERNS2Role *_role;
}

/**
 * (no documentation provided)
 */
- (NSString *) login;

/**
 * (no documentation provided)
 */
- (void) setLogin: (NSString *) newLogin;

/**
 * (no documentation provided)
 */
- (NSString *) password;

/**
 * (no documentation provided)
 */
- (void) setPassword: (NSString *) newPassword;

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Role *) role;

/**
 * (no documentation provided)
 */
- (void) setRole: (enum TM_SERVERNS2Role *) newRole;
@end /* interface TM_SERVERNS2User */

#endif /* DEF_TM_SERVERNS2User_H */
#ifndef DEF_TM_SERVERNS2Task_H
#define DEF_TM_SERVERNS2Task_H

/**
 * (no documentation provided)
 */
@interface TM_SERVERNS2Task : TM_SERVERNS2AbstractEntity <EnunciateXML>
{
  @private
    NSString *_projectID;
    NSDate *_dateStart;
    NSDate *_dateEnd;
    NSString *_userID;
    enum TM_SERVERNS2Status *_status;
}

/**
 * (no documentation provided)
 */
- (NSString *) projectID;

/**
 * (no documentation provided)
 */
- (void) setProjectID: (NSString *) newProjectID;

/**
 * (no documentation provided)
 */
- (NSDate *) dateStart;

/**
 * (no documentation provided)
 */
- (void) setDateStart: (NSDate *) newDateStart;

/**
 * (no documentation provided)
 */
- (NSDate *) dateEnd;

/**
 * (no documentation provided)
 */
- (void) setDateEnd: (NSDate *) newDateEnd;

/**
 * (no documentation provided)
 */
- (NSString *) userID;

/**
 * (no documentation provided)
 */
- (void) setUserID: (NSString *) newUserID;

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Status *) status;

/**
 * (no documentation provided)
 */
- (void) setStatus: (enum TM_SERVERNS2Status *) newStatus;
@end /* interface TM_SERVERNS2Task */

#endif /* DEF_TM_SERVERNS2Task_H */
#ifndef DEF_TM_SERVERNS2Session_H
#define DEF_TM_SERVERNS2Session_H

/**
 * (no documentation provided)
 */
@interface TM_SERVERNS2Session : TM_SERVERNS2AbstractEntity
{
  @private
}
@end /* interface TM_SERVERNS2Session */

#endif /* DEF_TM_SERVERNS2Session_H */
#ifndef DEF_TM_SERVERNS2Project_H
#define DEF_TM_SERVERNS2Project_H

/**
 * (no documentation provided)
 */
@interface TM_SERVERNS2Project : TM_SERVERNS2AbstractEntity <EnunciateXML>
{
  @private
    NSDate *_dateStart;
    NSDate *_dateEnd;
    NSString *_userID;
    enum TM_SERVERNS2Status *_status;
}

/**
 * (no documentation provided)
 */
- (NSDate *) dateStart;

/**
 * (no documentation provided)
 */
- (void) setDateStart: (NSDate *) newDateStart;

/**
 * (no documentation provided)
 */
- (NSDate *) dateEnd;

/**
 * (no documentation provided)
 */
- (void) setDateEnd: (NSDate *) newDateEnd;

/**
 * (no documentation provided)
 */
- (NSString *) userID;

/**
 * (no documentation provided)
 */
- (void) setUserID: (NSString *) newUserID;

/**
 * (no documentation provided)
 */
- (enum TM_SERVERNS2Status *) status;

/**
 * (no documentation provided)
 */
- (void) setStatus: (enum TM_SERVERNS2Status *) newStatus;
@end /* interface TM_SERVERNS2Project */

#endif /* DEF_TM_SERVERNS2Project_H */
