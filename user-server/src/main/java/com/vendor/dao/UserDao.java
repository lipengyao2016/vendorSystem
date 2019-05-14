package com.vendor.dao;

import com.vendor.entity.UserOrganizations;
import com.vendor.entity.UserRoleOrgs;
import com.vendor.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users, Long>,JpaSpecificationExecutor<Users> {

    //Declare a native query at the query method using @Query
    @Query(value = "SELECT u.name,ug.ownerUUID,u.mobile,ur.roleUuid,u.uuid as userUuid\n" +
            " FROM users u,userrolememberships ur ,userorganizations ug WHERE\n" +
            "u.userOrganizationUUID = ug.uuid and ur.userUuid = u.uuid and ug.ownerUUID  = ?1", nativeQuery = true)
    List<UserRoleOrgs> findUserListByOrgaUUID(String orgaUUID);
}
