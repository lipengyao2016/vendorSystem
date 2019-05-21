package com.vendor.service;


import com.vendor.model.Departments;
import com.vendor.model.Users;
import com.vendor.queryvo.DepartmentQueryVo;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;


public interface IUserService extends IBaseService<Users,UserQueryVo> {

    public Users create(UserCreateVo userCreateVo);


}
