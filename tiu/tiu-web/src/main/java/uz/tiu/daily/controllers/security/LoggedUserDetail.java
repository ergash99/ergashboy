package uz.tiu.daily.controllers.security;


import uz.tiu.daily.common.RoleInfo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * User: Sheroz Khaydarov
 * since 24.07.2008 18:51:57
 */
public class LoggedUserDetail implements Serializable {
    public long id;
    public String login;
    public String password;
    private List<RoleInfo> assignedRoles;

    private String firstname;
    private String surname;
    private String lastname;
    private String fullname;
    private String sex;
    private Date birthDate;
    private String homeAddress;
    private String homePhone;
    private String email;
    private String otherContacts;
    private byte[] photo;
    private String photoType;

    public long PersonalID;
    public long staffID;
    public long departmentID;
    public long postID;
    public String departmentName;
    public String postName;
    private Long organizationID;
    private String organizationName;


    private byte [] certificate;
    private String certificateType;

    private String connectIP;
    private String connectMAC;

    private String jsessionID;
    private Timestamp sessionStartDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<RoleInfo> getAssignedRoles() {
        return assignedRoles;
    }

    public void setAssignedRoles(List<RoleInfo> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }

    public long getPersonalID() {
        return PersonalID;
    }

    public void setPersonalID(long personalID) {
        PersonalID = personalID;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtherContacts() {
        return otherContacts;
    }

    public void setOtherContacts(String otherContacts) {
        this.otherContacts = otherContacts;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getConnectIP() {
        return connectIP;
    }

    public void setConnectIP(String connectIP) {
        this.connectIP = connectIP;
    }

    public String getConnectMAC() {
        return connectMAC;
    }

    public void setConnectMAC(String connectMAC) {
        this.connectMAC = connectMAC;
    }

    public String getJsessionID() {
        return jsessionID;
    }

    public void setJsessionID(String jsessionID) {
        this.jsessionID = jsessionID;
    }

    public Timestamp getSessionStartDate() {
        return sessionStartDate;
    }

    public void setSessionStartDate(Timestamp sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }
}
