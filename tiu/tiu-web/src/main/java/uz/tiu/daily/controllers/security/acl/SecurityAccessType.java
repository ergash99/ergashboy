package uz.tiu.daily.controllers.security.acl;

/**
 * @author Sheroz Khaydarov
 * @since 23.03.13 22:11
 */

public class SecurityAccessType{

    final static public byte PERMISSION_MASK_ALLOW = 1;
    final static public byte PERMISSION_MASK_DENY = 2;

    boolean allow;
    boolean deny;
    byte permission;

    public SecurityAccessType() {
        clear();
    }

    public SecurityAccessType(boolean allow, boolean deny) {
        setAllow(allow);
        setDeny(deny);
    }

    public boolean isAllow() {
        return allow;
    }

    public void setAllow(boolean allow) {
        this.allow = allow;
    }

    public boolean isDeny() {
        return deny;
    }

    public void setDeny(boolean deny) {
        this.deny = deny;
    }

    public void clear()
    {
        setAllow(false);
        setDeny(false);
    }

    public byte getPermission() {

        permission = 0;

        if (allow)
            permission |= PERMISSION_MASK_ALLOW;

        if (deny)
            permission |= PERMISSION_MASK_DENY;

        return permission;
    }
}
