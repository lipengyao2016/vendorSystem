package com.vendor.entity;
// Generated 2019-5-8 16:49:54 by Hibernate Tools 5.2.8.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * UserRoleMemberShips generated by hbm2java
 */
@Entity
@Table(name="UserRoleMemberShips"
    ,catalog="VD_UserServerDB"
    , uniqueConstraints = @UniqueConstraint(columnNames="uuid") 
)
public class UserRoleMemberShips  implements java.io.Serializable {


     private Integer id;
     private String uuid;
     private String roleUuid;
     private String userUuid;
     private Date createdAt;
     private Date modifiedAt;

    public UserRoleMemberShips() {
    }

    public UserRoleMemberShips(String uuid, String roleUuid, String userUuid, Date createdAt, Date modifiedAt) {
       this.uuid = uuid;
       this.roleUuid = roleUuid;
       this.userUuid = userUuid;
       this.createdAt = createdAt;
       this.modifiedAt = modifiedAt;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="uuid", unique=true, length=30)
    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    
    @Column(name="roleUUID", length=30)
    public String getRoleUuid() {
        return this.roleUuid;
    }
    
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    
    @Column(name="userUUID", length=30)
    public String getUserUuid() {
        return this.userUuid;
    }
    
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdAt", length=19)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifiedAt", length=19)
    public Date getModifiedAt() {
        return this.modifiedAt;
    }
    
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }




}


