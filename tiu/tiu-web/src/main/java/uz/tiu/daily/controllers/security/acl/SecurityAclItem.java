package uz.tiu.daily.controllers.security.acl;

/**
 * @author Sheroz Khaydarov
 * @since 23.03.13 21:47
 */

public class SecurityAclItem extends SecurityItem {

    private boolean removed;
    private String sid;
    private SecurityAccessType read;
    private SecurityAccessType write;
    private SecurityAccessType delete;

    public SecurityAclItem(Long id, String name) {
        super(id, name);
    }

    public SecurityAclItem() {
    }

    public SecurityAccessType getRead() {
        return read;
    }

    public void setRead(SecurityAccessType read) {
        this.read = read;
    }

    public SecurityAccessType getWrite() {
        return write;
    }

    public void setWrite(SecurityAccessType write) {
        this.write = write;
    }

    public SecurityAccessType getDelete() {
        return delete;
    }

    public void setDelete(SecurityAccessType delete) {
        this.delete = delete;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}
