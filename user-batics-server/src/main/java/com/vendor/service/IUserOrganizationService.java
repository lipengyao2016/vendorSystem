package com.vendor.service;


import com.vendor.model.UserOrganizations;

public interface IUserOrganizationService extends IBaseService<UserOrganizations,UserOrganizations> {

   public UserOrganizations getOrCreateUserOrganization(String ownerUUID);
}
