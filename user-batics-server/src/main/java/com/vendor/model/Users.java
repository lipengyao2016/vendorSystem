package com.vendor.model;

import java.util.Date;

public class Users {
    private Integer id;

    private String uuid;

    private String name;

    private String email;

    private String sex;

    private String mobile;

    private String address;

    private Integer age;

    private String description;

    private String status;

    private String type;

    private String headimghref;

    private String accountuuid;

    private String userorganizationuuid;

    private String departmentuuid;

    private Date createdat;

    private Date modifiedat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHeadimghref() {
        return headimghref;
    }

    public void setHeadimghref(String headimghref) {
        this.headimghref = headimghref == null ? null : headimghref.trim();
    }

    public String getAccountuuid() {
        return accountuuid;
    }

    public void setAccountuuid(String accountuuid) {
        this.accountuuid = accountuuid == null ? null : accountuuid.trim();
    }

    public String getUserorganizationuuid() {
        return userorganizationuuid;
    }

    public void setUserorganizationuuid(String userorganizationuuid) {
        this.userorganizationuuid = userorganizationuuid == null ? null : userorganizationuuid.trim();
    }

    public String getDepartmentuuid() {
        return departmentuuid;
    }

    public void setDepartmentuuid(String departmentuuid) {
        this.departmentuuid = departmentuuid == null ? null : departmentuuid.trim();
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getModifiedat() {
        return modifiedat;
    }

    public void setModifiedat(Date modifiedat) {
        this.modifiedat = modifiedat;
    }
}