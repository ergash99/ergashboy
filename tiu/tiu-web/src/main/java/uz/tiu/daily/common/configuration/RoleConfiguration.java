package uz.tiu.daily.common.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uz.tiu.daily.common.RoleInfo;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;



public class RoleConfiguration implements Serializable {

    private String ConfigurationResource;
    private String ConfigurationResourceExt;
    private RoleInfo[] roleInfo;
    private boolean ready;

    public boolean isReady() {
        return ready;
    }

    public RoleInfo[] getRoleInfo() {
        return roleInfo;
    }

    public void setConfigurationResource(String configurationResource) {
        ConfigurationResource = configurationResource;
    }

    public void setConfigurationResourceExt(String configurationResourceExt) {
        ConfigurationResourceExt = configurationResourceExt;
    }

    public RoleConfiguration()
    {
        roleInfo = null;
        ready = false;
    }

    @PostConstruct
    public void loadConfiguration()
    {
        LoadConfRoles(ConfigurationResource,true);
        LoadConfRoles(ConfigurationResourceExt,false);
        ready = true;
    }

    private void LoadConfRoles(String propFile, boolean logMissedFile)
    {
        Logger logger = LoggerFactory.getLogger(this.getClass().getName());

        try {
                XMLConfiguration config = new XMLConfiguration(propFile);
                List fields = config.configurationsAt("roles.role");
                int roleCount = fields.size();
                if (roleCount > 0) {
                    roleInfo = new RoleInfo[roleCount];
                    int nPos = 0;
                    for (Object field : fields) {
                        HierarchicalConfiguration sub = (HierarchicalConfiguration) field;
                        ConfigurationNode node = sub.getRootNode();
                        if (node.getAttributeCount() > 0) {
                            if (node.getAttribute(0).getName().equals("id")) {
                                RoleInfo role = new RoleInfo();
                                String strID= (String)  node.getAttribute(0).getValue(); 
                                role.setId(Integer.parseInt(strID));
                                role.setType(sub.getString("type"));
                                role.setName(sub.getString("name"));
                                role.setDescription(sub.getString("description"));
                                roleInfo[nPos] = role;
                                nPos++;
                            }
                        }
                    }
                    logger.debug("Configuration file loaded successfully: " + propFile);
                }
                else
                    logger.warn("No roles found in configuration: " + propFile);
        }
        catch (ConfigurationException e) {
            if (logMissedFile) {
                logger.error("Configuration file not found: " + propFile, e);
            }
        }
    }

}