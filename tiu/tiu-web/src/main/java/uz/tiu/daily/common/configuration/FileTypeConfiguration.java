package uz.tiu.daily.common.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uz.tiu.daily.common.FileTypeInfo;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FileTypeConfiguration implements Serializable{

    private String ConfigurationResource;
    private String ConfigurationResourceExt;

    private int fileTypeCount;
    private FileTypeInfo[] fileTypeInfo;
    private Map<String, FileTypeInfo> fileTypeInfoMapKeyId;
    private Map<String, FileTypeInfo> fileTypeInfoMapKeyMime;
    private Map<String, FileTypeInfo> fileTypeInfoMapKeyExt;
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

    public int getFileTypeCount() {
        return fileTypeCount;
    }

    public FileTypeInfo[] getFileTypeInfo() {
        return fileTypeInfo;
    }

    public Map<String, FileTypeInfo> getFileTypeInfoMapKeyId() {
        return fileTypeInfoMapKeyId;
    }

    public Map<String, FileTypeInfo> getFileTypeInfoMapKeyMime() {
        return fileTypeInfoMapKeyMime;
    }

    public Map<String, FileTypeInfo> getFileTypeInfoMapKeyExt() {
        return fileTypeInfoMapKeyExt;
    }

    public FileTypeConfiguration()
    {
        fileTypeCount = 0;
        fileTypeInfo =null;
        fileTypeInfoMapKeyId = new HashMap<String, FileTypeInfo>();
        fileTypeInfoMapKeyExt = new HashMap<String, FileTypeInfo>();
        fileTypeInfoMapKeyMime = new HashMap<String, FileTypeInfo>();
    }

    @PostConstruct
    public void loadConfiguration()
    {
        LoadConfFile(ConfigurationResource,true);
        LoadConfFile(ConfigurationResourceExt,false);
        ready = true;
    }

    private void LoadConfFile(String propFile, boolean logMissedFile)
    {
        try
        {
            XMLConfiguration config = new XMLConfiguration(propFile);

            // parse themes section
            List fields = config.configurationsAt("types.type");
            fileTypeCount =  fields.size();

            if (fileTypeCount>0)
            {
                fileTypeInfo = new FileTypeInfo[fileTypeCount];
                int nPos=0;
                for (Object field : fields) {
                    FileTypeInfo typeInfo = new FileTypeInfo();
                    typeInfo.setId("");

                    HierarchicalConfiguration sub = (HierarchicalConfiguration) field;
                    ConfigurationNode node = sub.getRootNode();
                    int attributeCount = node.getAttributeCount();
                    if (attributeCount>0)
                    {
                        for (int nAttrPos=0;nAttrPos<attributeCount;nAttrPos++)
                        {
                            String attrName= node.getAttribute(nAttrPos).getName();
                            if (attrName.equals("id"))
                                typeInfo.setId((String) node.getAttribute(nAttrPos).getValue());
                        }
                    }
                    typeInfo.setExtension(sub.getString("extension"));
                    typeInfo.setApplication(sub.getString("application"));
                    typeInfo.setMime(sub.getString("mime"));
                    typeInfo.setImage(sub.getString("image"));

                    fileTypeInfo[nPos] = typeInfo;
                    fileTypeInfoMapKeyId.put(typeInfo.getId(), typeInfo);
                    fileTypeInfoMapKeyExt.put(typeInfo.getExtension(), typeInfo);
                    fileTypeInfoMapKeyMime.put(typeInfo.getMime(), typeInfo);
                    nPos++;
                }

            }
            if (logger.isDebugEnabled())
                    logger.debug("Configuration file loaded successfully: "+propFile);
        }
        catch (ConfigurationException e)
        {
            if (logMissedFile)
                logger.error("Configuration file wrong or not found: "+propFile, e);
        }
    }

}