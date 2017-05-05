package uz.tiu.daily.persistence;

import uz.tiu.daily.common.TableName;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Entity
@Table(name = TableName.USER)
public class User implements Serializable {
    public static final String sequenceName = "SEQ_UZGPS_USER_ID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = sequenceName)
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
    private Long id;
    @Column(name = "login", unique = false, nullable = false, length = 128)
    private String login;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "surname", nullable = false, length = 32)
    private String surName;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "middlename", nullable = false, length = 32)
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "managers_id")
    private Managers  managers;

    @Column(name = "photo_id", nullable = true, insertable = false, updatable = false)
    private Long photoId;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private FileStorage photo;


    @Column(name = "last_logged_in")
    private Timestamp lastLoggedIn;

    @Column(name = "u_recovery_key")
    private String recoveryKey;

    @Column(name = "u_recovery_exp")
    private Timestamp recoveryExp;

    @Column(name = "u_block", nullable = false, length = 1)
    private String block;

    @Column(name = "u_login_attemp", nullable = true)
    private Integer loginAttemp;

    public String getRecoveryKey() {
        return recoveryKey;
    }

    public void setRecoveryKey(String recoveryKey) {
        this.recoveryKey = recoveryKey;
    }

    public Timestamp getRecoveryExp() {
        return recoveryExp;
    }

    public void setRecoveryExp(Timestamp recoveryExp) {
        this.recoveryExp = recoveryExp;
    }

    @Column(name = "u_status", nullable = false, length = 1)
    private String status;

    @Column(name = "u_reg_date")
    private Timestamp regDate;

    @Column(name = "u_mod_date", nullable = true)
    private Timestamp modDate;

    @Column(name = "u_exp_date", nullable = true)
    private Timestamp expDate;

    @Transient
    private String operatorLogin;

    @Transient
    private Long interfaceUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInterfaceUserId() {
        if (this.interfaceUserId == null)
            return this.id;

        return this.interfaceUserId;
    }

    public void setInterfaceUserId(Long interfaceUserId) {
        this.interfaceUserId = interfaceUserId;
    }




    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public FileStorage getPhoto() {
        return photo;
    }

    public void setPhoto(FileStorage photo) {
        this.photo = photo;
    }

   public Timestamp getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Timestamp lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public Timestamp getModDate() {
        return modDate;
    }

    public void setModDate(Timestamp modDate) {
        this.modDate = modDate;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public Integer getLoginAttemp() {
        return loginAttemp;
    }

    public void setLoginAttemp(Integer loginAttemp) {
        this.loginAttemp = loginAttemp;
    }

    public String getOperatorLogin() {
        return operatorLogin;
    }

    public void setOperatorLogin(String operatorLogin) {
        this.operatorLogin = operatorLogin;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", managers=" + managers +
                ", photoId=" + photoId +
                ", photo=" + photo +
                ", lastLoggedIn=" + lastLoggedIn +
                ", recoveryKey='" + recoveryKey + '\'' +
                ", recoveryExp=" + recoveryExp +
                ", block='" + block + '\'' +
                ", loginAttemp=" + loginAttemp +
                ", status='" + status + '\'' +
                ", regDate=" + regDate +
                ", modDate=" + modDate +
                ", expDate=" + expDate +
                ", operatorLogin='" + operatorLogin + '\'' +
                ", interfaceUserId=" + interfaceUserId +
                '}';
    }
}
