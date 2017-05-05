package uz.tiu.daily.persistence;

import uz.tiu.daily.common.TableName;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ERGASHBOY_JAVA on 20.04.17.
 */
@Entity
@Table(name = TableName.TASHABBUSCHI_TUZILMA)
public class Tashabbuschi_tuzilma implements Serializable {
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
