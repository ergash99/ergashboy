package uz.tiu.daily.common;


public class Constants {

    // constants for task progress status
    public static final byte TASK_STATUS_TYPE_SCHEDULED = 1;   // Тингловчига юборилган
    public static final byte TASK_STATUS_TYPE_IN_PROGRESS = 2; // Топшириш жараёнида
    public static final byte TASK_STATUS_TYPE_COMPLETED = 3;   // Текширишга юборилган
    public static final byte TASK_STATUS_TYPE_PASSED = 4;      // Муваффакиятли топширилган
    public static final byte TASK_STATUS_TYPE_FAILED = 5;      // Вазифа кайтарилган, кабул килинмаган
    public static final byte TASK_STATUS_TYPE_TIME_OUT = 6;    // Муддати утказиб юборилган

    // constants for test progress status
    public static final byte TEST_STATUS_TYPE_SCHEDULED = 1;
    public static final byte TEST_STATUS_TYPE_IN_PROGRESS = 2;
    public static final byte TEST_STATUS_TYPE_COMPLETED = 3;
    public static final byte TEST_STATUS_TYPE_PASSED = 4;
    public static final byte TEST_STATUS_TYPE_FAILED = 5;
    public static final byte TEST_STATUS_TYPE_TIME_OUT = 6;

    // constants for course subscribe and learning progress type
    public static final byte COURSE_STATUS_TYPE_PENDING = 1;
    public static final byte COURSE_STATUS_TYPE_PERMITTED = 2;
    public static final byte COURSE_STATUS_TYPE_REJECTED = 3;
    public static final byte COURSE_STATUS_TYPE_UNSUBSCRIBED = 4;
    public static final byte COURSE_STATUS_TYPE_SCHEDULED = 5;
    public static final byte COURSE_STATUS_TYPE_IN_PROGRESS = 6;
    public static final byte COURSE_STATUS_TYPE_COMPLETED = 7;
    public static final byte COURSE_STATUS_TYPE_FAILED = 8;
    public static final byte COURSE_STATUS_TYPE_DISQUALIFIED = 9;

    // constants for course moderation type
    public static final byte COURSE_MODERATION_TYPE_MODERATED = 1;
    public static final byte COURSE_MODERATION_TYPE_SELF_MODERATED = 2;

    // constants for test ask type
    public static final byte TEST_ASK_TYPE_CHECKBOX = 1;
    public static final byte TEST_ASK_TYPE_RADIO = 2;

    // constants for repository storage
    public static final byte STORAGE_TYPE_FILE = 1;
    public static final byte STORAGE_TYPE_DATABASE = 2;

    // constants for Persisitance.Folder.formType property
    public static final byte FORM_TYPE_NONE = 0;
    public static final byte FORM_TYPE_TEMPLATE = 1;
    public static final byte FORM_TYPE_REPORT = 2;
    public static final byte FORM_TYPE_REPOSITORY = 3;

    // constants for clipboard actions
    public static final byte CLIPBOARD_ACTION_NONE = 0;
    public static final byte CLIPBOARD_ACTION_CUT = 1;
    public static final byte CLIPBOARD_ACTION_COPY = 2;

    // constants for Persisitance.Security.defaultAccess and Persisitance.SecurityACL.accessType properties
    static final public byte SECURITY_ACCESS_ALLOW = 1;
    static final public byte SECURITY_ACCESS_DENY = 0;
    static final public byte SECURITY_ACCESS_UNDEFINED = -1;

    // constants for Persisitance.Security.defaultAccess and Persisitance.SecurityACL.accessType properties
    public static final byte SECURITY_ACCESS_NONE = 0;
    public static final byte SECURITY_ACCESS_BINARY_NONE = 0;
    public static final byte SECURITY_ACCESS_BINARY_LIST = 1;       // content (directory) listing only
    public static final byte SECURITY_ACCESS_BINARY_READ = 2;       // read only
    public static final byte SECURITY_ACCESS_BINARY_WRITE = 4;      // write only
    public static final byte SECURITY_ACCESS_BINARY_EXECUTE = 8;    // read - execute
    public static final byte SECURITY_ACCESS_BINARY_DELETE = 16;    // delete
    public static final byte SECURITY_ACCESS_LIST = 1;              // listing
    public static final byte SECURITY_ACCESS_READ = 3;              // listing-read
    public static final byte SECURITY_ACCESS_MODIFY = 7;            // listing-read-write 
    public static final byte SECURITY_ACCESS_EXECUTE = 9;           // listing-execute
    public static final byte SECURITY_ACCESS_DELETE = 17;           // listing-delete
    public static final byte SECURITY_ACCESS_FULL = 127;            // full access

    static final public long SECURITY_KEY = 1525243;

    // constants for Persisitance.User User Type
    static final public long USER_TYPE_SUPERADMIN = 1;
    static final public long USER_TYPE_OPERATOR = 2;
    static final public long USER_TYPE_CUSTOMER = 3;
    static final public long USER_TYPE_CUSTOMER_USER = 4;

    // Trackers in warehouse
    /**
     * Minimum number of tracker in stock. If there is low trackers then this number, notification will work.
     */
    static final public long TRACKER_MIN_LIMIT = 50;

    // constants for Persisitance.User User Status
    static final public String USER_STATUS_ACTIVE = "A";
    static final public String USER_STATUS_DELETE = "D";

    // constants for Persisitance.User User Status
    static final public String USER_BLOCK_STATUS_UNBLOCK = "U";
    static final public String USER_BLOCK_TATUS_BLOCK = "B";

    // constants for Persisitance.Contract Contarct Max Value Setting
    static final public long CONTRACT_MAX_UNIT_COUNT_DEFAULT = 1;
    static final public long CONTRACT_MAX_USER_COUNT_DEFAULT = 1;
    static final public long CONTRACT_MAX_STAFF_COUNT_DEFAULT = 1;
    static final public long CONTRACT_MAX_POI_COUNT_DEFAULT = 10;
    static final public long CONTRACT_MAX_GEO_FANCE_COUNT_DEFAULT = 10;
    static final public long CONTRACT_MAX_REPORT_COUNT_DEFAULT = 10;
    static final public long CONTRACT_MAX_EMAIL_COUNT_DEFAULT = 10;
    static final public long CONTRACT_MAX_SMS_COUNT_DEFAULT = 0;
    static final public long CONTRACT_MAX_SMS_CMD_COUNT_DEFAULT = 0;

    static final public String CONTRACT_TYPE_ORGANIZATION = "O";
    static final public String CONTRACT_TYPE_INDIVIDUAL = "I";

    // constants for Persisitance.User User Status
    static final public String STATUS_ACTIVE = "A";
    static final public String STATUS_DELETE = "D";

    static final public String STATUS_UNBLOCK = "A";
    static final public String STATUS_BLOCK = "B";

    static final public int LIST_PER_PAGE = 20;

    /* Mobject Icons' IDs ON MAP */
    public static final long MAP_MOBJECT_ICON_CAR = 1;
    public static final long MAP_MOBJECT_ICON_MOBILE = 2;
    public static final long MAP_MOBJECT_ICON_DEFAULT = MAP_MOBJECT_ICON_CAR;

    /* User Access List ID */

    static final public Integer USER_ACCESS_NONE = 0;
    static final public Integer USER_ACCESS_VIEW = 1;
    static final public Integer USER_ACCESS_EDIT = 3;
    static final public Integer USER_ACCESS_DELETE = 4;
    static final public Integer USER_ACCESS_ADD = 8;
    static final public Integer USER_ACCESS_FULL = 15;

    /* Journal constants */
    static final public int JOURNAL_ACT_INSERT = 1;
    static final public int JOURNAL_ACT_UPDATE = 2;
    static final public int JOURNAL_ACT_DELETE = 3;
    static final public int JOURNAL_ACT_LOGIN = 4;
    static final public int JOURNAL_ACT_LOGOUT = 5;

    static final public int JOURNAL_REPORT = 100;
    static final public int JOURNAL_REPORT_INSERT = 101;
    static final public int JOURNAL_REPORT_UPDATED = 102;
    static final public int JOURNAL_REPORT_DELETED = 103;

    static final public int JOURNAL_POI = 200;
    static final public int JOURNAL_POI_INSERT = 201;
    static final public int JOURNAL_POI_UPDATED = 202;
    static final public int JOURNAL_POI_DELETED = 203;

    static final public int JOURNAL_ADMIN_USER = 300;
    static final public int JOURNAL_ADMIN_USER_INSERT = 301;
    static final public int JOURNAL_ADMIN_USER_UPDATED = 302;
    static final public int JOURNAL_ADMIN_USER_DELETED = 303;
    static final public int JOURNAL_ADMIN_USER_ROLE_INSERT = 311;
    static final public int JOURNAL_ADMIN_USER_ROLE_UPDATED = 312;
    static final public int JOURNAL_ADMIN_USER_ROLE_DELETED = 313;
    static final public int JOURNAL_ADMIN_PROFILE_INSERT = 321;
    static final public int JOURNAL_ADMIN_PROFILE_UPDATED = 322;
    static final public int JOURNAL_ADMIN_PROFILE_DELETED = 323;

    static final public int JOURNAL_ADMIN_CONTRACT = 400;
    static final public int JOURNAL_ADMIN_CONTRACT_INSERT = 401;
    static final public int JOURNAL_ADMIN_CONTRACT_UPDATED = 402;
    static final public int JOURNAL_ADMIN_CONTRACT_DELETED = 403;

    static final public int JOURNAL_ADMIN_CONTRACT_SETTINGS_INSERT = 421;
    static final public int JOURNAL_ADMIN_CONTRACT_SETTINGS_UPDATED = 422;
    static final public int JOURNAL_ADMIN_CONTRACT_SETTINGS_DELETED = 423;

    static final public int JOURNAL_ADMIN_GPSUNIT = 500;
    static final public int JOURNAL_ADMIN_GPSUNIT_INSERT = 501;
    static final public int JOURNAL_ADMIN_GPSUNIT_UPDATED = 502;
    static final public int JOURNAL_ADMIN_GPSUNIT_DELETED = 503;

    static final public int JOURNAL_ADMIN_GPSUNIT_TYPE_INSERT = 521;
    static final public int JOURNAL_ADMIN_GPSUNIT_TYPE_UPDATED = 522;
    static final public int JOURNAL_ADMIN_GPSUNIT_TYPE_DELETED = 523;

    static final public int JOURNAL_ADMIN_GPSUNIT_SIM_INSERT = 541;
    static final public int JOURNAL_ADMIN_GPSUNIT_SIM_UPDATED = 542;
    static final public int JOURNAL_ADMIN_GPSUNIT_SIM_DELETED = 543;

    static final public int JOURNAL_ADMIN_SIM_INSERT = 551;
    static final public int JOURNAL_ADMIN_SIM_UPDATED = 552;
    static final public int JOURNAL_ADMIN_SIM_DELETED = 553;

    static final public int JOURNAL_ADMIN_MOBJECT_INSERT = 561;
    static final public int JOURNAL_ADMIN_MOBJECT_UPDATED = 562;
    static final public int JOURNAL_ADMIN_MOBJECT_DELETED = 563;

    static final public int JOURNAL_ADMIN_MOBJECT_SETTINGS_INSERT = 571; // todo
    static final public int JOURNAL_ADMIN_MOBJECT_SETTINGS_UPDATED = 572; // todo
    static final public int JOURNAL_ADMIN_MOBJECT_SETTINGS_DELETED = 573; // todo

    static final public int JOURNAL_ADMIN_MOBJECT_GPSUNIT_INSERT = 581;
    static final public int JOURNAL_ADMIN_MOBJECT_GPSUNIT_UPDATED = 582;
    static final public int JOURNAL_ADMIN_MOBJECT_GPSUNIT_DELETED = 583;

    static final public int JOURNAL_ADMIN_MOBJECT_NOTIFICATION_INSERT = 591;  // todo
    static final public int JOURNAL_ADMIN_MOBJECT_NOTIFICATION_UPDATED = 592; // todo
    static final public int JOURNAL_ADMIN_MOBJECT_NOTIFICATION_DELETED = 593; // todo

    static final public int JOURNAL_ADMIN_COMPANY = 600;
    static final public int JOURNAL_ADMIN_COMPANY_INSERT = 601;
    static final public int JOURNAL_ADMIN_COMPANY_UPDATED = 602;
    static final public int JOURNAL_ADMIN_COMPANY_DELETED = 603;

    static final public int JOURNAL_ADMIN_MOBILE_TRACKER_SETTINGS_INSERT = 611;
    static final public int JOURNAL_ADMIN_MOBILE_TRACKER_SETTINGS_UPDATED = 612;
    static final public int JOURNAL_ADMIN_MOBILE_TRACKER_SETTINGS_DELETED = 613;

    static final public int JOURNAL_GEOFANCE = 700;
    static final public int JOURNAL_GEOFANCE_INSERT = 701;
    static final public int JOURNAL_GEOFANCE_UPDATED = 702;
    static final public int JOURNAL_GEOFANCE_DELETED = 703;

    static final public int JOURNAL_GEOFANCE_POINT_INSERT = 721;
    static final public int JOURNAL_GEOFANCE_POINT_UPDATED = 722;
    static final public int JOURNAL_GEOFANCE_POINT_DELETED = 723;

    static final public int JOURNAL_NOTIFICATION = 800;
    static final public int JOURNAL_NOTIFICATION_IMEI_FOREIGN = 801;
    static final public int JOURNAL_NOTIFICATION_IMEI_BLOCKED = 802;
    static final public int JOURNAL_NOTIFICATION_TRACKER_LIMIT = 803;

    static final public int JOURNAL_LOGIN = 1000;
    static final public int JOURNAL_LOGIN_SUCCESS = 1001;
    static final public int JOURNAL_LOGIN_FAIL = 1009;
    static final public int JOURNAL_LOGIN_TRY_LIMIT = 1010;

    static final public int LOGIN_PASSWORD_SUCCESS = 100;
    static final public int LOGIN_PASSWORD_OLD_NONE = 101;
    static final public int LOGIN_PASSWORD_NEW_NONE = 102;
    static final public int LOGIN_PASSWORD_VERIFY_NONE = 103;
    static final public int LOGIN_PASSWORD_VERIFY_INCORRECT = 104;
    static final public int LOGIN_PASSWORD_OLD_INCORRECT = 105;

    static final public long MOBJECT_SPEED1_MIN = 1;
    static final public long MOBJECT_SPEED1_MAX = 120;
    static final public long MOBJECT_SPEED2_MIN = 1;
    static final public long MOBJECT_SPEED2_MAX = 120;
    static final public long MOBJECT_SPEED3_MIN = 1;
    static final public long MOBJECT_SPEED3_MAX = 120;
    static final public long MOBJECT_SPEED4_MIN = 1;
    static final public long MOBJECT_SPEED4_MAX = 120;
    static final public long MOBJECT_SPEED5_MIN = 1;
    static final public long MOBJECT_SPEED5_MAX = 120;
    static final public long MOBJECT_MIN_SPEED = 1;
    static final public long MOBJECT_MAX_SPEED = 400;
    static final public long MOBJECT_ONLINETIME_MAX = 7200;
    static final public long MOBJECT_ONLINETIME_MIN = 5;
    static final public long MOBJECT_PARKINGTIME_MIN = 1;
    static final public long MOBJECT_PARKINGTIME_MAX = 3600;

    static final public int NOTIFICATION_MIN_SPEED_MIN = 1;
    static final public int NOTIFICATION_MIN_SPEED_MAX = 20;
    static final public int NOTIFICATION_MAX_SPEED_MIN = 1;
    static final public int NOTIFICATION_MAX_SPEED_MAX = 120;

    static final public int MONITORING_REFRESHINTERVAL_MIN = 1;
    static final public int MONITORING_REFRESHINTERVAL_MAX = 3600;
    static final public long MONITORING_TOOLTIPISVIEWQUANTITY_MAX = 50;
    static final public long MONITORING_TOOLTIPISVIEWQUANTITY_MIN = 1;
    static final public long MONITORING_TRECKLENGHTVALUE1_MIN = 1;
    static final public long MONITORING_TRECKLENGHTVALUE1_MAX = 10;
    static final public long MONITORING_TRECKLENGHTVALUE2_MAX = 60;
    static final public long MONITORING_TRECKLENGHTVALUE2_MIN = 10;

    static final public int COSTOMER_TRACKER_TBIG_MIN = 1;
    static final public int COSTOMER_TRACKER_TBIG_MAX = 86400;
    static final public int COSTOMER_TRACKER_DMIN_MIN = 1;
    static final public int COSTOMER_TRACKER_DMIN_MAX = 100;
    static final public int COSTOMER_TRACKER_DBIG_MIN = 1;
    static final public int COSTOMER_TRACKER_DBIG_MAX = 1000;
    static final public int COSTOMER_TRACKER_TMAXBIG_MIN = 1;
    static final public int COSTOMER_TRAKER_TMAXBIG_MAX = 86400;
    static final public int COSTOMER_TRAKER_TLOST_MIN = 1;
    static final public int COSTOMER_TRAKER_TLOST_MAX = 86400;
    static final public int COSTOMER_DEFAULT_TRACKER_TIME_MIN = 10;
    static final public int COSTOMER_DEFAULT_TRACKER_TIME_BIG = 7200;
    static final public int COSTOMER_DEFAULT_TRACKER_TIME_LOST = 300;
    static final public int COSTOMER_DEFAULT_TRACKER_DISTANCE_MIN = 10;
    static final public int COSTOMER_DEFAULT_TRACKER_DISTANCE_BIG = 1000;

    static final public boolean MTRACKER_DEFAULT_SETTINGS_HAS_PASSWORD = false;
    static final public int MTRACKER_DEFAULT_SETTINGS_PASSWORD = 1111;
    static final public int MTRACKER_DEFAULT_LOCATION_UPDATE_TIME = 300;
    static final public int MTRACKER_DEFAULT_LOCATION_UPDATE_DISTANCE = 50;
    static final public int MTRACKER_DEFAULT_LOCATION_UPDATE_ANGLE = 15;
    static final public int MTRACKER_DEFAULT_LOCATION_UPDATE_ACCURACY = 3;
    static final public boolean MTRACKER_DEFAULT_SHOULD_STATUS_CHANGE = true;
    static final public int MTRACKER_DEFAULT_RECORD_LIMIT = 10;
    static final public int MTRACKER_DEFAULT_LOCATION_SEND_TIME = 300;
    static final public boolean MTRACKER_DEFAULT_SHOULD_SEND_3G = true;
    static final public boolean MTRACKER_DEFAULT_SHOULD_SEND_WIFI = true;
    static final public int MTRACKER_DEFAULT_TRACK_LENGTH = 7;
    static final public int MTRACKER_DEFAULT_MAP_TYPE = 1;

    static final public int TRACKER_TYPE_MOBILE = 1;
    static final public int TRACKER_TYPE_GPS = 0;

    static final public int LOCATION_UPDATE_TIME_MIN = 1;
    static final public int LOCATION_UPDATE_TIME_MAX = 86400;
    static final public int LOCATION_UPDATE_DICTANSE_MIN = 0;
    static final public int LOCATION_UPDATE_DICTANSE_MAX = 1000;
    static final public int LOCATION_UPDATE_ANGLE_MIN = 0;
    static final public int LOCATION_UPDATE_ANGLE_MAX = 360;
    static final public int RECORD_LIMIT_MIN = 1;
    static final public int RECORD_LIMIT_MAX = 100;
    static final public int LOCATION_UPDATE_SEND_TIME_MIN = 1;
    static final public int LOCATION_UPDATE_SEND_TIME_MAX = 86400;
    static final public int TRACK_LENGTH_MIN = 0;
    static final public int TRACK_LENGTH_MAX = 7;

    static final public int ROUTE_ROAD_WIDTH_MIN = 0; //in meters
    static final public int ROUTE_ROAD_WIDTH_MAX = 1000; //in meters

    static final public int ROUTE_NAME_FONT_SIZE_MIN = 6;
    static final public int ROUTE_NAME_FONT_SIZE_MAX = 15;

    static final public int STATION_WIDTH_MIN = 0; //in meters
    static final public int STATION_WIDTH_MAX = 1000; //in meters

    static final public int STATION_RADIUS_MIN = 0; //in meters
    static final public int STATION_RADIUS_MAX = 1000 * 1000; //in meters

    static final public int STATION_NAME_FONT_SIZE_MIN = 6;
    static final public int STATION_NAME_FONT_SIZE_MAX = 15;


    static final public String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public enum ROLE {
        ADMIN(1),
        GUIDES(2),
        DOCUMENT_REGISTRATION(3),
        APPLICATION_REGISTRATION(4),
        DOCUMENT_RESOLUTION(5);

        private final Integer value;

        private ROLE(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public enum DOC_CATEGORY {
        INCOMING(new Short("1")),
        OUTGOING(new Short("2")),
        INTERNAL(new Short("3")),
        APPLICATION(new Short("4"));

        private final Short value;

        private DOC_CATEGORY(Short value) {
            this.value = value;
        }

        public Short getValue() {
            return value;
        }
    }

    public enum AUTHENTICATION_METHOD {
        SIMPLE(1),                               // uses http form based login/password method
        OPENID(2),                               // uses OPENID method
        LDAP(4),                                 // uses LDAP method
        REQUIRE_CERTIFICATE(8),                  // requires certificate and digital signature on authorization digitally signed hash of (login+password+sessionID+salt)
        INCLUDE_PASSWORD_PREFACE(16),            // received password string includes preface as NNXXXXXX, where NN - 2 digit decimal length of original password, XXXXX original password characters
        INCLUDE_CRYPTED_PASSWORD_PREFACE(32);    // crypt password preface with the given pubic key

        private final int value;

        private AUTHENTICATION_METHOD(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
