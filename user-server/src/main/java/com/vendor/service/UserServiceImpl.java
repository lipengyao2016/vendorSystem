package com.vendor.service;

import com.vendor.dao.UserDao;
import com.vendor.dao.UserOrganizationDao;
import com.vendor.dao.UserRoleMemberShipDao;
import com.vendor.entity.UserOrganizations;
import com.vendor.entity.UserRoleMemberShips;
import com.vendor.entity.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.utils.BeanHelper;
import com.vendor.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl   implements  IUserService{

    @Autowired
    private UserDao UserDao;

    @Autowired
    private IUserOrganizationService userOrganizationService;

    @Autowired
    private IUserRoleMemberShipService userRoleMemberShipService;

    private IBaseService<Users,UserQueryVo> baseService;

    public  UserServiceImpl()
    {
        System.out.println("UserServiceImpl init");
    }

    @Autowired(required = true)
    public  UserServiceImpl(UserDao UserDao)
    {
        this.UserDao = UserDao;
        this.baseService = new BaseServiceImpl(UserDao,Users.class);
    }


    @Override
    public Users create(Users obj) {
        return this.baseService.create(obj);
    }

    @Override
    public Users get(String uuid) {
        return this.baseService.get(uuid);
    }

    @Override
    public List<Users> list(UserQueryVo queryObj) {
        return this.baseService.list(queryObj);
    }

    @Override
    public Users update(String uuid, Users updateObj) {
        return this.baseService.update(uuid,updateObj);
    }

    @Override
    public Users delete(String uuid) {
        return this.baseService.delete(uuid);
    }

    @Override
    public Users combinCreate(UserCreateVo obj) throws DataNotFoundException {
        UserOrganizations userOrganizations = userOrganizationService.findUserOrga(obj.getOwnerUUID());

        Users createUser = new Users();
        String[] excludeAtts ={"ownerUUID","roleUUID"};
        BeanHelper.copyPropertiesExcludeAttr(obj,createUser,excludeAtts);
        Users user = this.create(createUser);

        UserRoleMemberShips userRoleMemberShips = new UserRoleMemberShips();
        userRoleMemberShips.setUserUuid(createUser.getUuid());
        userRoleMemberShips.setRoleUuid(obj.getRoleUUID());

        UserRoleMemberShips newUserRoleShips = userRoleMemberShipService.create(userRoleMemberShips);

       // throw  new DataNotFoundException("5004","test");

        return  user;
    }
}
