package com.vendor.service;


import com.vendor.entity.ListResponse;
import com.vendor.model.UserRoleOrgs;
import com.vendor.model.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.model.UserRoleOrgQueryVo;


public interface IUserService extends IBaseService<Users,UserQueryVo> {

    public Users create(UserCreateVo userCreateVo);

    public Users update(UserCreateVo userCreateVo);


    public ListResponse<UserRoleOrgs> getUserRole(UserRoleOrgQueryVo userRoleOrgQueryVo, Integer page, Integer rows);


}
