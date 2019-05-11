package com.vendor.service;

import com.vendor.dao.UserRoleMemberShipDao;
import com.vendor.entity.UserRoleMemberShips;
import com.vendor.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleMemberShipServiceImpl implements  IUserRoleMemberShipService{

    @Autowired
    private UserRoleMemberShipDao UserRoleMemberShipDao;

    
    private IBaseService<UserRoleMemberShips,UserRoleMemberShips> baseService;

    public UserRoleMemberShipServiceImpl()
    {
        System.out.println("UserRoleMemberShipServiceImpl init");
    }

    @Autowired(required = true)
    public UserRoleMemberShipServiceImpl(UserRoleMemberShipDao UserRoleMemberShipDao)
    {
        this.UserRoleMemberShipDao = UserRoleMemberShipDao;
        this.baseService = new BaseServiceImpl(UserRoleMemberShipDao,UserRoleMemberShips.class);
    }


    @Override
    public UserRoleMemberShips create(UserRoleMemberShips obj) {
        return this.baseService.create(obj);
    }

    @Override
    public UserRoleMemberShips get(String uuid) {
        return this.baseService.get(uuid);
    }

    @Override
    public List<UserRoleMemberShips> list(UserRoleMemberShips queryObj) {
        return this.baseService.list(queryObj);
    }

    @Override
    public UserRoleMemberShips update(String uuid, UserRoleMemberShips updateObj) {
        return this.baseService.update(uuid,updateObj);
    }

    @Override
    public UserRoleMemberShips delete(String uuid) {
        return this.baseService.delete(uuid);
    }

    @Override
    public UserRoleMemberShips update(UserRoleMemberShips updateObj) throws DataNotFoundException {
        return null;
    }

}
