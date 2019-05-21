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
import com.vendor.utils.GsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
        return this.baseService.update(updateObj);
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

    @Transactional()
    @Override
    public Users create(UserCreateVo userCreateVo) {
        Users newUser = new Users();
        if(userCreateVo.getOwnerUUID() != null)
        {
            UserOrganizations userOrganizations = userOrganizationService.getOrCreateUserOrganization(userCreateVo.getOwnerUUID());
            newUser.setUserorganizationuuid(userOrganizations.getUuid());

            log.info("userOrganizations:" + GsonUtils.ToJson(userOrganizations,UserOrganizations.class));
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
            log.info("getUserRoleMemberShips:" + GsonUtils.ToJson(userCreateVo.getUserRoleMemberShips(),List.class));
            this.userRoleMembershipService.batchInsert(userCreateVo.getUserRoleMemberShips());
        }

      //   throw new DataNotFoundException("7010","insert Test");

        Users user = this.create(newUser);
        return user;
    }

    @Override
    public Users update(UserCreateVo userCreateVo) {
        Users user;
        try {
            Users updateUser = new Users();

            UserRoleMemberships queryUserRole = new UserRoleMemberships();
            queryUserRole.setUseruuid(userCreateVo.getUuid());
            ListResponse<UserRoleMemberships> userRoleMembershipsList = userRoleMembershipService.list(queryUserRole,1,10);

            List<String> userRoleUUIDs = new ArrayList<>();
            for(UserRoleMemberships tempUserRole :userRoleMembershipsList.getItems() )
            {
                userRoleUUIDs.add(tempUserRole.getUuid());
            }

            userRoleMembershipService.batchDelete(userRoleUUIDs);

            String[] excludeAtts ={"roleUUID","userRoleMemberShips"};
            BeanHelper.copyPropertiesExcludeAttr(userCreateVo,updateUser,excludeAtts);
            DBEntityUtils.preUpdate(updateUser);

            for(UserRoleMemberships userRoleMemberShips : userCreateVo.getUserRoleMemberShips())
            {
                DBEntityUtils.preCreate(userRoleMemberShips);
                userRoleMemberShips.setUseruuid(updateUser.getUuid());
            }

            if(userCreateVo.getUserRoleMemberShips().size() > 0)
            {
                log.info("getUserRoleMemberShips:" + GsonUtils.ToJson(userCreateVo.getUserRoleMemberShips(),List.class));
                this.userRoleMembershipService.batchInsert(userCreateVo.getUserRoleMemberShips());
            }

            log.info("updateUser:" + GsonUtils.ToJson(updateUser,Users.class));
             user = this.update(updateUser);

        }
        catch (Exception e)
        {
            throw  new DataNotFoundException("7001","create error");
        }
        return user;

    }
}
