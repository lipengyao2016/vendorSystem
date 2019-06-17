package com.vendor.entity;

public class UserRoles {
    private String name;
    private  String mobile;
    private  String userUUID;
    private  String ownerUUID;
    private  String roleUUID;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(String ownerUUID) {
        this.ownerUUID = ownerUUID;
    }

    public String getRoleUUID() {
        return roleUUID;
    }

    public void setRoleUUID(String roleUUID) {
        this.roleUUID = roleUUID;
    }
}
