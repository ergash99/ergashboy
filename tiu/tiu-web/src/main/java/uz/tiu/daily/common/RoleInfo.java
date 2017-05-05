package uz.tiu.daily.common;

import java.io.Serializable;


public class RoleInfo implements Serializable {
    private int id;
    private String type;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleInfo()
    {
        id=-1;
        type="";
        name="";
        description="";
    }
}
