package com.vendor.bean.user;

import java.util.Date;

public class Departments {
    private Integer id;

    private String uuid;

    private String name;

    private String description;

    private String upleveldepartmentuuid;

    private String userorganizationuuid;

    private String status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUpleveldepartmentuuid() {
        return upleveldepartmentuuid;
    }

    public void setUpleveldepartmentuuid(String upleveldepartmentuuid) {
        this.upleveldepartmentuuid = upleveldepartmentuuid == null ? null : upleveldepartmentuuid.trim();
    }

    public String getUserorganizationuuid() {
        return userorganizationuuid;
    }

    public void setUserorganizationuuid(String userorganizationuuid) {
        this.userorganizationuuid = userorganizationuuid == null ? null : userorganizationuuid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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