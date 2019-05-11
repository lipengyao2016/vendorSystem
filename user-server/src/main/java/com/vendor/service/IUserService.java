package com.vendor.service;

import com.vendor.entity.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import org.springframework.dao.DataAccessException;

public interface IUserService extends IBaseService<Users,UserQueryVo> {
    public Users combinCreate(UserCreateVo obj) throws DataAccessException;

    public Users combinUpdate(Users obj) throws DataAccessException;

}
