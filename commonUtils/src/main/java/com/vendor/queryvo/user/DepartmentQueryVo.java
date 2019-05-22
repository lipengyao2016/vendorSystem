package com.vendor.queryvo.user;



public class DepartmentQueryVo {

    private String id;

    private String uuid;

    private String name;

    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpleveldepartmentuuid() {
        return upleveldepartmentuuid;
    }

    public void setUpleveldepartmentuuid(String upleveldepartmentuuid) {
        this.upleveldepartmentuuid = upleveldepartmentuuid;
    }

    public String getUserorganizationuuid() {
        return userorganizationuuid;
    }

    public void setUserorganizationuuid(String userorganizationuuid) {
        this.userorganizationuuid = userorganizationuuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getModifiedat() {
        return modifiedat;
    }

    public void setModifiedat(String modifiedat) {
        this.modifiedat = modifiedat;
    }

    private String upleveldepartmentuuid;

    private String userorganizationuuid;

    private String status;

    private String createdat;

    private String modifiedat;

}
