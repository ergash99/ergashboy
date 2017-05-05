package uz.tiu.daily.persistence;

import uz.tiu.daily.common.TableName;
import uz.tiu.daily.persistence.share.DataBaseObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Entity
@Table(name= TableName.SMETA_HOLATI)
public class Smeta_holati  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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
