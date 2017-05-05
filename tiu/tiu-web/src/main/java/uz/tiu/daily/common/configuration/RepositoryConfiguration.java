package uz.tiu.daily.common.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uz.tiu.daily.common.Constants;

import javax.annotation.PostConstruct;
import java.io.Serializable;


public class RepositoryConfiguration implements Serializable {

    private String ConfigurationResource;
    private String ConfigurationResourceExt;

    private String storage;
    private String path;
    private byte storageType;
    private boolean ready;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public boolean isReady() {
        return ready;
    }

    public void setConfigurationResource(String configurationResource) {
        ConfigurationResource = configurationResource;
    }

    public void setConfigurationResourceExt(String configurationResourceExt) {
        ConfigurationResourceExt = configurationResourceExt;
    }

    public byte getStorageType() {
        return storageType;
    }

    public String getStorage() {
        return storage;
    }


    public String getPath() {
        return path;
    }


    public RepositoryConfiguration()
    {
        storage = "";
        path="";
    }

    @PostConstruct
    public void loadConfiguration()
    {
        LoadConfAuth(ConfigurationResource,true);
        LoadConfAuth(ConfigurationResourceExt,false);

        if (storage==null)
            storage="";

        if (path==null)
            path="";

        storage = storage.trim();
        path= path.trim();

        if (storage.equals("database"))
            storageType= Constants.STORAGE_TYPE_DATABASE;
        else if (storage.equals("file"))
            storageType= Constants.STORAGE_TYPE_FILE;
        else
        {
            storage="database";
            storageType= Constants.STORAGE_TYPE_DATABASE;
        }

        ready=true;
    }

    private void LoadConfAuth(String propFile, boolean logMissedFile)
    {
        try
        {
            Configuration config = new PropertiesConfiguration(propFile);

            storage = config.getString("repository.storage", storage);
            path = config.getString("repository.path", path);

            if (logger.isDebugEnabled())
                logger.debug("Configuration file loaded successfully: "+propFile);
        }
        catch (ConfigurationException e)
        {
            if (logMissedFile)
                logger.error("Configuration file not found: "+propFile, e);
        }
    }

}