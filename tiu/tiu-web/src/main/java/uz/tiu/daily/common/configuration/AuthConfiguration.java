package uz.tiu.daily.common.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.Serializable;



public class AuthConfiguration implements Serializable {

    public static final byte AUTHENTICATION_TYPE_SYSADMIN = 1;
    public static final byte AUTHENTICATION_TYPE_PLAIN = 2;
    public static final byte AUTHENTICATION_TYPE_X509 = 3;
    public static final byte AUTHENTICATION_TYPE_LDAP = 4;
    public static final byte AUTHENTICATION_TYPE_OPENID = 5;

    public static final byte PASSPHRASE_TYPE_STATIC = 0;
    public static final byte PASSPHRASE_TYPE_RANDOM = 1;

    public static final String PASSPHRASE_PREFIX_STATIC = "static";
    public static final String PASSPHRASE_PREFIX_RANDOM = "random";

    private String  ConfigurationResource;
    private String  ConfigurationResourceExt;

    private String  authTypeString;
    private byte    authType;

    private String  sysAdminPassphrase;
    private String  ldapServer;
    private String  ldapDomain;
    private String  openidServer;

    private boolean defaultAdminEnabled;
    private String defaultAdminLogin;
    private String defaultPassphraseGenerationMode;
    private byte defaultPassphraseType;
    private byte defaultPassphraseLength;
    private String defaultPassphraseValue;


    private boolean ready;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public boolean isReady() {
        return ready;
    }

    public void setConfigurationResource(String configurationResource) {
        ConfigurationResource = configurationResource;
    }

    public void setConfigurationResourceExt(String configurationResourceExt) {
        ConfigurationResourceExt = configurationResourceExt;
    }

    public String getSysAdminPassphrase() {
        return sysAdminPassphrase;
    }


    public String getLdapServer() {
        return ldapServer;
    }

    public String getLdapDomain() {
        return ldapDomain;
    }


    public String getOpenidServer() {
        return openidServer;
    }

    public String getAuthTypeString() {
        return authTypeString;
    }

    public byte getAuthType() {
        return authType;
    }

    public boolean isDefaultAdminEnabled() {
        return defaultAdminEnabled;
    }

    public String getDefaultAdminLogin() {
        return defaultAdminLogin;
    }

    public String getDefaultPassphraseValue() {
        return defaultPassphraseValue;
    }

    public byte getDefaultPassphraseType() {
        return defaultPassphraseType;
    }

    public byte getDefaultPassphraseLength() {
        return defaultPassphraseLength;
    }

    public void setDefaultAdminEnabled(boolean defaultAdminEnabled) {
        this.defaultAdminEnabled = defaultAdminEnabled;
    }

    public void setDefaultAdminLogin(String defaultAdminLogin) {
        this.defaultAdminLogin = defaultAdminLogin;
    }

    public void setDefaultPassphraseType(byte defaultPassphraseType) {
        this.defaultPassphraseType = defaultPassphraseType;
    }

    public void setDefaultPassphraseLength(byte defaultPassphraseLength) {
        this.defaultPassphraseLength = defaultPassphraseLength;
    }

    public void setDefaultPassphraseValue(String defaultPassphraseValue) {
        this.defaultPassphraseValue = defaultPassphraseValue;
    }

    public String getDefaultPassphraseGenerationMode() {
        return defaultPassphraseGenerationMode;
    }

    public void setDefaultPassphraseGenerationMode(String defaultPassphraseGenerationMode) {
        this.defaultPassphraseGenerationMode = defaultPassphraseGenerationMode;
    }

    public AuthConfiguration()
    {
        ready = false;
        authTypeString = "";
        sysAdminPassphrase="";

        ldapServer="";
        ldapDomain="";

        defaultAdminEnabled=false;
        defaultAdminLogin="admin";
        defaultPassphraseLength=12;
        defaultPassphraseValue="1";
        defaultPassphraseType=PASSPHRASE_TYPE_RANDOM;
        defaultPassphraseGenerationMode = PASSPHRASE_PREFIX_RANDOM + Byte.toString(defaultPassphraseLength);

    }

    @PostConstruct
    public void loadConfiguration()
    {
        LoadConfAuth(ConfigurationResource,true);
        LoadConfAuth(ConfigurationResourceExt,false);
        authType = -1;
        if (authTypeString!=null)
        {
            authTypeString = authTypeString.toLowerCase();

            if (authTypeString.equals("sysadmin"))
                authType = AUTHENTICATION_TYPE_SYSADMIN;
            else if (authTypeString.equals("plain"))
                authType = AUTHENTICATION_TYPE_PLAIN;
            else if (authTypeString.equals("x509"))
                authType = AUTHENTICATION_TYPE_X509;
            else if (authTypeString.equals("ldap"))
                authType = AUTHENTICATION_TYPE_LDAP;
            else if (authTypeString.equals("openid"))
                authType = AUTHENTICATION_TYPE_OPENID;
            else
                logger.error("Authentication type is not valid : {}", authTypeString);
        } else {
            logger.error("Authentication type is null");
        }
        ready = true;
    }

    private void LoadConfAuth(String propFile, boolean logMissedFile)
    {
        // todo: needs to convert to spring based implementation
        try
        {
            Configuration config = new PropertiesConfiguration(propFile);


            authTypeString=config.getString("auth.type", authTypeString);

            sysAdminPassphrase=config.getString("auth.sysadmin.passphrase", sysAdminPassphrase);

            ldapServer=config.getString("auth.ldap.server", ldapServer);
            ldapDomain = config.getString("auth.ldap.domain", ldapDomain);

            openidServer = config.getString("auth.openid.server", openidServer);

            defaultAdminEnabled = config.getBoolean("auth.default.admin.enabled", defaultAdminEnabled);
            defaultAdminLogin   = config.getString("auth.default.admin.login", defaultAdminLogin);
            defaultPassphraseValue = config.getString("auth.default.passphrase.value", defaultPassphraseValue);

            String passphraseGenerationMode = config.getString("auth.default.passphrase.generation.mode", defaultPassphraseGenerationMode);
            if (passphraseGenerationMode==null)
                passphraseGenerationMode = defaultPassphraseGenerationMode;
            if (passphraseGenerationMode.equalsIgnoreCase(PASSPHRASE_PREFIX_STATIC))
            {
                defaultPassphraseType = PASSPHRASE_TYPE_STATIC;
                defaultPassphraseLength = (byte) defaultPassphraseValue.length();
                defaultPassphraseGenerationMode = passphraseGenerationMode;
            } else
            if (passphraseGenerationMode.toLowerCase().startsWith(PASSPHRASE_PREFIX_RANDOM))
            {
                defaultPassphraseType = PASSPHRASE_TYPE_RANDOM;
                String pLength = passphraseGenerationMode.substring(PASSPHRASE_PREFIX_RANDOM.length());
                if (pLength.length()>0) {
                    try {
                        defaultPassphraseLength = Byte.parseByte(pLength);
                    } catch (NumberFormatException e) {
                        logger.error("Invalid random passphrase generation length: {} " + pLength);
                    }
                }
                defaultPassphraseGenerationMode = passphraseGenerationMode;
            }

            if(logger.isDebugEnabled())
                logger.debug("Configuration file loaded successfully: "+propFile);
        }
        catch (ConfigurationException e)
        {
            if (logMissedFile)
                logger.error("Configuration file not found: "+propFile, e);
        }
    }

}
