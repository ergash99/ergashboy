package uz.tiu.daily.persistence;

import uz.tiu.daily.common.TableName;
import uz.tiu.daily.persistence.share.DataBaseObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Entity
@Table(name= TableName.ADMIN)
public class Admin extends DataBaseObject{

}
