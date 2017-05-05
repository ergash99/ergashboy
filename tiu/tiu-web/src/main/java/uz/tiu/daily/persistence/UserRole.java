package uz.tiu.daily.persistence;
import uz.tiu.daily.common.TableName;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = TableName.USER_ROLE)
public class UserRole implements Serializable {
    public static final String sequenceName = "SEQ_UZGPS_USER_ROLE_ID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = sequenceName)
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
    private Long id;
    @Basic
    @Column(name = "user_id", nullable=false, insertable = false, updatable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Basic
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
