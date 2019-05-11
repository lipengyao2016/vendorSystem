package com.vendor.controller;

import com.vendor.entity.ListResponse;
import com.vendor.entity.UserRoleMemberShips;
import com.vendor.queryvo.UserCreateVo;
import com.vendor.queryvo.UserQueryVo;
import com.vendor.queryvo.UserRoleQueryVO;
import com.vendor.service.IUserRoleMemberShipService;
import com.vendor.utils.DataNotFoundException;
import com.vendor.utils.GsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/order")
public class UserRoleController {

    private Log log = LogFactory.getLog(UserRoleController.class);
  //  @Autowired
   // userRoleMemberShipservice userRoleMemberShipservice;

    @Autowired
    IUserRoleMemberShipService userRoleMemberShipservice;





    @RequestMapping(value = "/api/{ver}/userRoleMemberShips/{userRoleMemberShipUUID}", method = {RequestMethod.GET})
    @ResponseBody
    public UserRoleMemberShips getuserRoleMemberShips(@PathVariable("ver") String version, @PathVariable("userRoleMemberShipUUID")
            String userRoleMemberShipUUID) throws  DataNotFoundException {
        log.info(",version:" + version);
        log.info("userRoleMemberShipUUID  :" + userRoleMemberShipUUID);

        return userRoleMemberShipservice.get(userRoleMemberShipUUID);
    }

    @RequestMapping(value = "/api/{ver}/userRoleMemberShips", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<UserRoleMemberShips> listuserRoleMemberShips(@PathVariable("ver") String version, UserRoleQueryVO userRoleQueryvo) {
        log.info(",version:" + version);
        log.info("User  :" + GsonUtils.ToJson(userRoleQueryvo, UserRoleQueryVO.class));
        return userRoleMemberShipservice.list(userRoleQueryvo);
    }


    @RequestMapping(value = "/api/{ver}/userRoleMemberShips/{userRoleMemberShipUUID}", method = {RequestMethod.DELETE})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public UserRoleMemberShips deleteuserRoleMemberShips(@PathVariable("ver") String version, @PathVariable("userRoleMemberShipUUID")
            String userRoleMemberShipUUID) {
        log.info(",version:" + version);
        log.info("userRoleMemberShipUUID  :" + userRoleMemberShipUUID);

        return userRoleMemberShipservice.delete(userRoleMemberShipUUID);
    }


}
