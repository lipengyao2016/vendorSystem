package com.vendor.dao;

import com.vendor.entity.UserRoleMemberShips;
import com.vendor.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMemberShipDao extends JpaRepository<UserRoleMemberShips, Long>,JpaSpecificationExecutor<UserRoleMemberShips> {

}
