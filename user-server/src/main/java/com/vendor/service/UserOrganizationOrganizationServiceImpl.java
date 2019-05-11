package com.vendor.service;

import com.vendor.dao.UserOrganizationDao;
import com.vendor.entity.ListResponse;
import com.vendor.entity.UserOrganizations;
import com.vendor.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrganizationOrganizationServiceImpl implements  IUserOrganizationService{

    @Autowired
    private UserOrganizationDao UserOrganizationDao;

    
    private IBaseService<UserOrganizations,UserOrganizations> baseService;

    public UserOrganizationOrganizationServiceImpl()
    {
        System.out.println("UserOrganizationServiceImpl init");
    }

    @Autowired(required = true)
    public UserOrganizationOrganizationServiceImpl(UserOrganizationDao UserOrganizationDao)
    {
        this.UserOrganizationDao = UserOrganizationDao;
        this.baseService = new BaseServiceImpl(UserOrganizationDao,UserOrganizations.class);
    }


    @Override
    public UserOrganizations create(UserOrganizations obj) {
        return this.baseService.create(obj);
    }

    @Override
    public UserOrganizations get(String uuid) {
        return this.baseService.get(uuid);
    }

    @Override
    public ListResponse<UserOrganizations> list(UserOrganizations queryObj) {
        return this.baseService.list(queryObj);
    }

    @Override
    public UserOrganizations update(String uuid, UserOrganizations updateObj) {
        return this.baseService.update(uuid,updateObj);
    }

    @Override
    public UserOrganizations delete(String uuid) {
        return this.baseService.delete(uuid);
    }

    @Override
    public UserOrganizations update(UserOrganizations updateObj) throws DataNotFoundException {
        return null;
    }


    @Override
    public UserOrganizations findUserOrga(String ownerUUID) {

        UserOrganizations userOrganizationQuery = new UserOrganizations();
        userOrganizationQuery.setOwnerUuid(ownerUUID);
        List<UserOrganizations> userOrganizations = this.list(userOrganizationQuery).getItems();
        if(userOrganizations.size() > 0)
        {
            return  userOrganizations.get(0);
        }
        else
        {
            UserOrganizations newUserOrga = new UserOrganizations();
            newUserOrga.setOwnerUuid(ownerUUID);
            return  this.create(newUserOrga);
        }

    }
}
