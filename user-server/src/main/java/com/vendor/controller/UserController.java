package com.vendor.controller;

import com.vendor.dao.UserDao;
import com.vendor.entity.ListResponse;
import com.vendor.entity.UserRoleOrgs;
import com.vendor.entity.Users;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.service.IUserService;
import com.vendor.service.UserServiceImpl;
import com.vendor.utils.DataNotFoundException;
import com.vendor.utils.GsonUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.List;
import java.util.*;

@RestController
//@RequestMapping("/order")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);
  //  @Autowired
   // UserService UserService;

    @Autowired
    IUserService UserService;


    @RequestMapping(value = "/api/{ver}/users", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public Users createUser(@PathVariable("ver") String version, @RequestBody UserCreateVo User) {

        log.info("User:" + User.getUuid() + " name:" + User.getName() + ",version:" + version);
        System.out.println(User.getName());

       Users newUser = (Users) UserService.combinCreate(User);
       return newUser;
        //return  null;
    }


    @RequestMapping(value = "/api/{ver}/users/{UserUUID}", method = {RequestMethod.GET})
    @ResponseBody
    public Users getUsers(@PathVariable("ver") String version, @PathVariable("UserUUID") String UserUUID) throws  DataNotFoundException {
        log.info(",version:" + version);
        log.info("UserUUID  :" + UserUUID);
        if(UserUUID.contentEquals("2") )
        {
            throw  new DataNotFoundException("5003","dd");
        }

        return UserService.get(UserUUID);
    }

    @RequestMapping(value = "/api/{ver}/users", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<Users> listUsers(@PathVariable("ver") String version, UserQueryVo User) {
        log.info(",version:" + version);
        log.info("User  :" + GsonUtils.ToJson(User, UserQueryVo.class));
        return UserService.list(User);
    }

    @RequestMapping(value = "/api/{ver}/users/{UserUUID}", method = {RequestMethod.POST})
    @ResponseBody
    public Users updateUsers(@PathVariable("ver") String version, @PathVariable("UserUUID") String UserUUID,
                             @RequestBody Users updateUser   ) {
        log.info(",version:" + version);
        log.info("UserUUID  :" + UserUUID);


        return UserService.update(UserUUID,updateUser);
    }

    @RequestMapping(value = "/api/{ver}/users/{UserUUID}", method = {RequestMethod.DELETE})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public Users deleteUsers(@PathVariable("ver") String version, @PathVariable("UserUUID") String UserUUID) {
        log.info(",version:" + version);
        log.info("UserUUID22  :" + UserUUID);

        return UserService.delete(UserUUID);
    }


    @RequestMapping(value = "/api/{ver}/userRoleOrgs", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<UserRoleOrgs> findUserListByOrgaUUID(@PathVariable("ver") String version, String orgaUUID, Integer page, Integer rows) {
        log.info(",version:" + version);
        return UserService.findUserListByOrgaUUID(orgaUUID,page,rows);
    }

}
