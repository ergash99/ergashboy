package uz.tiu.daily.persistence;
import uz.tiu.daily.common.TableName;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = TableName.ROLE)
public class Role implements Serializable {
    public static final String sequenceName = "SEQ_ROLE_ID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = sequenceName)
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "role_id")
    private Integer roleId;

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}