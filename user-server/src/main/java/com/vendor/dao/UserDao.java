package com.vendor.dao;

import com.vendor.entity.UserOrganizations;
import com.vendor.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Long>,JpaSpecificationExecutor<Users> {

}
