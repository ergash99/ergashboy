package uz.tiu.daily.common.configuration;


import java.io.Serializable;



public class EMailConfiguration implements Serializable {

    private boolean enabled;
    private String  host;
    private int     port;
    private String  username;
    private String  password;
    private boolean smtpAuth;
    private boolean smtpStartTlsEnable;
    private String  defaultSender;

    public EMailConfiguration()
    {
        enabled=false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public boolean isSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(boolean smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    public String getDefaultSender() {
        return defaultSender;
    }

    public void setDefaultSender(String defaultSender) {
        this.defaultSender = defaultSender;
    }

    public String getConfigString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EMail Configuration:");
        stringBuilder.append("[ enabled:").append(isEnabled());
        stringBuilder.append(", host:").append(host);
        stringBuilder.append(", port:").append(port);
        stringBuilder.append(", username:").append(username);
        stringBuilder.append(", password:").append("***:))");
        stringBuilder.append(", defaultSender:").append(defaultSender);
        stringBuilder.append(", smtpAuth:").append(smtpAuth);
        stringBuilder.append(", smtpStartTlsEnable:").append(smtpStartTlsEnable);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
