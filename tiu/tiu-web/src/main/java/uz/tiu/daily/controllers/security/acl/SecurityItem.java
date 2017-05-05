package uz.tiu.daily.controllers.security.acl;

/**
 * @author Sheroz Khaydarov
 * @since 23.03.13 Time: 21:45
 */

public class SecurityItem {
    private Long id;
    private String name;

    public SecurityItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SecurityItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
