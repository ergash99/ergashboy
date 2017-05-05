package uz.tiu.daily.persistence;
import uz.tiu.daily.common.TableName;
import uz.tiu.daily.persistence.share.DataBaseObject;
import javax.persistence.*;
@Entity
@Table(name = TableName.MANAGERS)
public class Managers  extends DataBaseObject{
    @Column(name = "name")
    private String name;
    @Column(name = "user_type_id")
    private Integer userTypeId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getUserTypeId() {
        return userTypeId;
    }
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}
