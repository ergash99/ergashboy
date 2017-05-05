package uz.tiu.daily.common.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uz.tiu.daily.common.Constants;

import javax.annotation.PostConstruct;
import java.io.Serializable;



public class ReportConfiguration implements Serializable {

    private String ConfigurationResource;
    private String ConfigurationResourceExt;

    private String reportType;
    private String storage;
    private String path;

    private byte storageType;
    private boolean ready;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void setConfigurationResource(String configurationResource) {
        ConfigurationResource = configurationResource;
    }

    public void setConfigurationResourceExt(String configurationResourceExt) {
        ConfigurationResourceExt = configurationResourceExt;
    }

    public String getReportType() {
        return reportType;
    }

    public String getStorage() {
        return storage;
    }

    public String getPath() {
        return path;
    }

    public byte getStorageType() {
        return storageType;
    }

    public boolean isReady() {
        return ready;
    }

    public ReportConfiguration()
    {
        reportType="";
        path="";
        storage="";
    }

    @PostConstruct
    public void loadConfiguration()
    {
        LoadConfAuth(ConfigurationResource, true);
        LoadConfAuth(ConfigurationResourceExt, false);

        if (storage==null)
            storage="";

        if (path==null)
            path="";

        storage = storage.trim();
        path= path.trim();

        if (storage.equals("database"))
            storageType= Constants.STORAGE_TYPE_DATABASE;
        else
        {
            storage="file";
            storageType= Constants.STORAGE_TYPE_FILE;
        }

        ready=true;

    }


    private void LoadConfAuth(String propFile, boolean logMissedFile)
    {
        try
        {
            Configuration config = new PropertiesConfiguration(propFile);

            reportType=config.getString("report.type", reportType);
            storage=config.getString("report.storage", storage);
            path=config.getString("report.path", path);

            if(logger.isDebugEnabled())
                logger.debug("Configuration file loaded successfully: "+propFile);
        }
        catch (ConfigurationException e)
        {
            if (logMissedFile)
                logger.error("Configuration file not found: "+propFile);
        }
    }
}

