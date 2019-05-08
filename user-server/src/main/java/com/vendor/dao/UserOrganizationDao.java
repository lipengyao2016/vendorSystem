package com.vendor.dao;

import com.vendor.entity.UserOrganizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserOrganizationDao  extends JpaRepository<UserOrganizations, Long>,JpaSpecificationExecutor<UserOrganizations> {

}
