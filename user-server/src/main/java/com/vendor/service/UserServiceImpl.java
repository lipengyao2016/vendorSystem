package com.vendor.service;

import com.vendor.dao.UserDao;
import com.vendor.dao.UserOrganizationDao;
import com.vendor.dao.UserRoleMemberShipDao;
import com.vendor.entity.UserOrganizations;
import com.vendor.entity.UserRoleMemberShips;
import com.vendor.entity.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
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

        Users oldUser = this.get(uuid);
        oldUser.getUserRoleMemberShips().clear();
        String[]  excludeAttrs = {"userRoleMemberShips"};
        if(oldUser != null)
        {
            BeanHelper.copyPropertiesExcludeSomeAndNullAttr(updateObj,oldUser,excludeAttrs);
        }
        else
        {
            throw new DataNotFoundException("5000","update db not found uuid:" + uuid);
        }
        
        if(updateObj.getUserRoleMemberShips().size() > 0)
        {
            for (UserRoleMemberShips userRoleMemberShips : updateObj.getUserRoleMemberShips())
            {
                DBEntityUtils.preCreate(userRoleMemberShips);
                userRoleMemberShips.setUsers(oldUser);
                oldUser.getUserRoleMemberShips().add(userRoleMemberShips);
            }
        }

        return this.baseService.update(oldUser);

    }

    @Override
    public Users delete(String uuid) {
        return this.baseService.delete(uuid);
    }

    @Override
    public Users update(Users updateObj) throws DataNotFoundException {
        return null;
    }

    @Override
    public Users combinCreate(UserCreateVo obj) throws DataNotFoundException {
        UserOrganizations userOrganizations = userOrganizationService.findUserOrga(obj.getOwnerUUID());
        Users createUser = new Users();
        String[] excludeAtts ={"ownerUUID","roleUUID","userRoleMemberShips"};
        BeanHelper.copyPropertiesExcludeAttr(obj,createUser,excludeAtts);
        DBEntityUtils.preCreate(createUser);

        for(UserRoleMemberShips userRoleMemberShips : obj.getUserRoleMemberShips())
        {
            DBEntityUtils.preCreate(userRoleMemberShips);
            userRoleMemberShips.setUsers(createUser);
        }
        createUser.setUserRoleMemberShips(obj.getUserRoleMemberShips());

        Users user = this.create(createUser);

       // throw  new DataNotFoundException("5004","test");

        return  user;
    }

    @Override
    public Users combinUpdate(Users obj) throws DataAccessException {

/*        if(obj.getUserRoleMemberShips().size() > 0)
        {
            for (UserRoleMemberShips userRoleMemberShips : obj.getUserRoleMemberShips())
            {
                userRoleMemberShips.setUsers(obj);
            }
        }


        return this.baseService.update(uuid,updateObj);*/

return  null;
    }
}
