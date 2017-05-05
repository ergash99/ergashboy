package uz.tiu.daily.common.configuration;


import java.io.Serializable;


public class SmsConfiguration implements Serializable {

    private boolean enabled;
    private String  sender;
    private String  smsc;
    private String  modemId;
    private String  modemComPort;
    private int     modemBaudRate;
    private String  modemManufacturer;
    private String  modemModel;
    private String  modemSimPin;

    public SmsConfiguration()
    {
        enabled=false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSmsc() {
        return smsc;
    }

    public void setSmsc(String smsc) {
        this.smsc = smsc;
    }

    public String getModemId() {
        return modemId;
    }

    public void setModemId(String modemId) {
        this.modemId = modemId;
    }

    public String getModemComPort() {
        return modemComPort;
    }

    public void setModemComPort(String modemComPort) {
        this.modemComPort = modemComPort;
    }

    public int getModemBaudRate() {
        return modemBaudRate;
    }

    public void setModemBaudRate(int modemBaudRate) {
        this.modemBaudRate = modemBaudRate;
    }

    public String getModemManufacturer() {
        return modemManufacturer;
    }

    public void setModemManufacturer(String modemManufacturer) {
        this.modemManufacturer = modemManufacturer;
    }

    public String getModemModel() {
        return modemModel;
    }

    public void setModemModel(String modemModel) {
        this.modemModel = modemModel;
    }

    public String getModemSimPin() {
        return modemSimPin;
    }

    public void setModemSimPin(String modemSimPin) {
        this.modemSimPin = modemSimPin;
    }

    public String getConfigString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SMS Configuration:");
        stringBuilder.append("[ enabled:").append(isEnabled());
        stringBuilder.append(", sender:").append(getSender());
        stringBuilder.append(", smsc:").append(getSmsc());
        stringBuilder.append(", modemId:").append(getModemId());
        stringBuilder.append(", modemComPort:").append(getModemComPort());
        stringBuilder.append(", modemBaudRate:").append(getModemBaudRate());
        stringBuilder.append(", modemManufacturer:").append(getModemManufacturer());
        stringBuilder.append(", modemModel:").append(getModemModel());
        stringBuilder.append(", modemSimPin:").append(getModemSimPin());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
