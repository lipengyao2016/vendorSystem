package com.vendor.bean.user;

import java.util.Date;

public class UserRoleMemberships {
    private Integer id;

    private String uuid;

    private String roleuuid;

    private String useruuid;

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

    public String getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(String roleuuid) {
        this.roleuuid = roleuuid == null ? null : roleuuid.trim();
    }

    public String getUseruuid() {
        return useruuid;
    }

    public void setUseruuid(String useruuid) {
        this.useruuid = useruuid == null ? null : useruuid.trim();
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