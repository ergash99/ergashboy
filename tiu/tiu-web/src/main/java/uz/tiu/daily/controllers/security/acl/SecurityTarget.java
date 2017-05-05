package uz.tiu.daily.controllers.security.acl;

/**
 * @author Sheroz Khaydarov
 * @since 23.03.13 Time: 21:45
 */

public class SecurityTarget extends SecurityItem {

    private Class classType;
    private Boolean secured;

    public SecurityTarget(Long id, String name, Class classType, Boolean secured) {
        super(id, name);
        this.classType = classType;
        this.secured = secured;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public Boolean getSecured() {
        return secured;
    }

    public void setSecured(Boolean secured) {
        this.secured = secured;
    }
}
