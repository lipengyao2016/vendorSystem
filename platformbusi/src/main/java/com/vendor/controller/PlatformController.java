package com.vendor.controller;


import com.vendor.bean.role.Roles;
import com.vendor.bean.user.UserRoleMemberships;
import com.vendor.bean.user.Users;
import com.vendor.client.RoleFeignClient;
import com.vendor.client.UserFeignClient;
import com.vendor.queryvo.user.UserRoleCreateVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/order")
public class PlatformController {

    private Log log = LogFactory.getLog(PlatformController.class);


    @Autowired
    private RoleFeignClient roleFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/api/{ver}/roles", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public Users createRole(@PathVariable("ver") String version, @RequestBody UserRoleCreateVo userRoleCreateVo) {

        log.info("userRoleCreateVo:" + userRoleCreateVo.getRole().getName()  + ",version:" + version);


        //  Roles newRole = (Roles) this.getRoleService().create(role);

        //return  null;

        Roles role =   roleFeignClient.createRole(version,userRoleCreateVo.getRole());
        List<UserRoleMemberships> userRoleMembershipsList = new ArrayList<>();
        UserRoleMemberships userRoleMemberships = new UserRoleMemberships();
        userRoleMemberships.setRoleuuid(role.getUuid());
        userRoleMembershipsList.add(userRoleMemberships);


        userRoleCreateVo.getUser().setUserRoleMemberShips(userRoleMembershipsList);
        Users user =  userFeignClient.createUser(version,userRoleCreateVo.getUser());
        return  user;
    }


   /* @RequestMapping(value = "/api/{ver}/Platforms/{PlatformUUID}", method = {RequestMethod.GET})
    @ResponseBody
    public Platforms getPlatforms(@PathVariable("ver") String version, @PathVariable("PlatformUUID") String PlatformUUID) throws  DataNotFoundException {
        log.info(",version:" + version);
        log.info("PlatformUUID  :" + PlatformUUID);
        if(PlatformUUID.contentEquals("2") )
        {
            throw  new DataNotFoundException("5003","dd");
        }

        return PlatformService.get(PlatformUUID);
    }

    @RequestMapping(value = "/api/{ver}/Platforms", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<Platforms> listPlatforms(@PathVariable("ver") String version, PlatformQueryVo Platform) {
        log.info(",version:" + version);
        log.info("Platform  :" + GsonUtils.ToJson(Platform, PlatformQueryVo.class));
        return PlatformService.list(Platform,Platform.getPage(),Platform.getRows());
    }

    @RequestMapping(value = "/api/{ver}/Platforms/{PlatformUUID}", method = {RequestMethod.POST})
    @ResponseBody
    public Platforms updatePlatforms(@PathVariable("ver") String version, @PathVariable("PlatformUUID") String PlatformUUID,
                             @RequestBody PlatformCreateVo updatePlatform   ) {
        log.info(",version:" + version);
        log.info("PlatformUUID  :" + PlatformUUID);
        updatePlatform.setUuid(PlatformUUID);
        return PlatformService.update(updatePlatform);
    }

    @RequestMapping(value = "/api/{ver}/Platforms/{PlatformUUID}", method = {RequestMethod.DELETE})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public Platforms deletePlatforms(@PathVariable("ver") String version, @PathVariable("PlatformUUID") String PlatformUUID) {
        log.info(",version:" + version);
        log.info("PlatformUUID22  :" + PlatformUUID);

        return PlatformService.delete(PlatformUUID);
    }

    @RequestMapping(value = "/api/{ver}/PlatformRoleOrgs", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<PlatformRoleOrgs> findPlatformListByOrgaUUID(@PathVariable("ver") String version, PlatformRoleOrgQueryVo PlatformRoleOrgQueryVo
            , Integer page, Integer rows) {
        log.info(",version:" + version);
        return PlatformService.getPlatformRole(PlatformRoleOrgQueryVo,page,rows);
    }*/


/*    @RequestMapping(value = "/api/{ver}/PlatformRoleOrgs", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<PlatformRoleOrgs> findPlatformListByOrgaUUID(@PathVariable("ver") String version, String orgaUUID, Integer page, Integer rows) {
        log.info(",version:" + version);
        return PlatformService.findPlatformListByOrgaUUID(orgaUUID,page,rows);
    }*/

}
