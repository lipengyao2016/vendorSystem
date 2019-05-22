package com.vendor.queryvo.user;



import com.vendor.bean.user.UserRoleMemberships;

import java.util.List;

public class UserCreateVo {
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
    private String headImgHref;
    private String accountUuid;
    private String ownerUUID;
    private String departmentUuid;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeadImgHref() {
        return headImgHref;
    }

    public void setHeadImgHref(String headImgHref) {
        this.headImgHref = headImgHref;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(String ownerUUID) {
        this.ownerUUID = ownerUUID;
    }

    public String getDepartmentUuid() {
        return departmentUuid;
    }

    public void setDepartmentUuid(String departmentUuid) {
        this.departmentUuid = departmentUuid;
    }

/*    public String getRoleUUID() {
        return roleUUID;
    }

    public void setRoleUUID(String roleUUID) {
        this.roleUUID = roleUUID;
    }

    private String roleUUID;*/

    public List<UserRoleMemberships> getUserRoleMemberShips() {
        return userRoleMemberShips;
    }

    public void setUserRoleMemberShips(List<UserRoleMemberships> userRoleMemberShips) {
        this.userRoleMemberShips = userRoleMemberShips;
    }


    private List<UserRoleMemberships> userRoleMemberShips ;
}
