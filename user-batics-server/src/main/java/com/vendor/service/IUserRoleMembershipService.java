package com.vendor.service;


import com.vendor.model.UserRoleMemberships;

import java.util.List;


public interface IUserRoleMembershipService extends IBaseService<UserRoleMemberships,UserRoleMemberships> {

    public List<UserRoleMemberships> getUserRoles(String userUUID);
}
