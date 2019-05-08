package com.vendor.service;

import com.vendor.entity.UserOrganizations;
import com.vendor.entity.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;

public interface IUserOrganizationService extends IBaseService<UserOrganizations,UserOrganizations> {

    public  UserOrganizations findUserOrga(String ownerUUID);

}
