package com.vendor.queryvo;
// Generated 2019-5-8 16:49:54 by Hibernate Tools 5.2.8.Final


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vendor.entity.Users;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * UserRoleMemberShips generated by hbm2java
 */

public class UserRoleQueryVO {


     private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    private String uuid;
     private String roleUuid;
     private String userUuid;
     private String createdAt;
     private String modifiedAt;

    public UserQueryVo getUsers() {
        return users;
    }

    public void setUsers(UserQueryVo users) {
        this.users = users;
    }

    private  UserQueryVo users;






}

