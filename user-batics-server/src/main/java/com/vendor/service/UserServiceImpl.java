package com.vendor.service;


import com.vendor.config.DataSourceProperties;
import com.vendor.entity.ListResponse;
import com.vendor.mapper.UsersMapper;
import com.vendor.model.*;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.utils.BeanHelper;
import com.vendor.utils.DBEntityUtils;
import com.vendor.utils.DataNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  IUserService{

    private Log log = LogFactory.getLog(UserServiceImpl.class);

    private UsersMapper UserDao;
    private IBaseService<Users,UserQueryVo> baseService;

    @Autowired
    private IUserOrganizationService userOrganizationService;

    @Autowired
    private IUserRoleMembershipService userRoleMembershipService;


   // @Autowired
    private SqlSessionFactory sqlSessionFactory;


    private DataSourceProperties dataSourceProperties;

    public UserServiceImpl()
    {
        System.out.println("UserServiceImpl init");
    }

    @Autowired(required = true)
    public UserServiceImpl(UsersMapper UserDao,
                           SqlSessionFactory sqlSessionFactory, DataSourceProperties dataSourceProperties)
    {
        this.UserDao = UserDao;
        this.baseService = new BaseMyBaticsServiceImpl<>(this.UserDao,Users.class
                ,UsersCriteria.class);
        this.sqlSessionFactory = sqlSessionFactory;


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
    public ListResponse<Users> list(UserQueryVo queryObj , Integer page, Integer rows) {
        return this.baseService.list(queryObj,page,rows);
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
    public Users update(Users updateObj) throws DataNotFoundException {
        return null;
    }

    @Override
    public int batchInsert(List<Users> record) {
        return this.baseService.batchInsert(record);
    }

    @Override
    public int batchDelete(List<String> uuids) {
        return this.baseService.batchDelete(uuids);
    }

    @Override
    public Users batchUpdate(List<String> uuids, Users updateObj) throws DataNotFoundException {
        return this.baseService.batchUpdate(uuids,updateObj);
    }

    @Override
    public Users create(UserCreateVo userCreateVo) {
        Users newUser = new Users();
        if(userCreateVo.getOwnerUUID() != null)
        {
            UserOrganizations userOrganizations = userOrganizationService.getOrCreateUserOrganization(userCreateVo.getOwnerUUID());
            newUser.setUserorganizationuuid(userOrganizations.getUuid());
        }

        String[] excludeAtts ={"ownerUUID","roleUUID","userRoleMemberShips"};
        BeanHelper.copyPropertiesExcludeAttr(userCreateVo,newUser,excludeAtts);
        DBEntityUtils.preCreate(newUser);

        for(UserRoleMemberships userRoleMemberShips : userCreateVo.getUserRoleMemberShips())
        {
            DBEntityUtils.preCreate(userRoleMemberShips);
            userRoleMemberShips.setUseruuid(newUser.getUuid());
        }

        if(userCreateVo.getUserRoleMemberShips().size() > 0)
        {
            this.userRoleMembershipService.batchInsert(userCreateVo.getUserRoleMemberShips());
        }

        Users user = this.create(newUser);
        return user;
    }
}
