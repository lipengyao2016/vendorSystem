package com.vendor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vendor.entity.ListResponse;
import com.vendor.model.Roles;
import com.vendor.queryvo.RoleQueryVo;
import com.vendor.service.IRoleService;
import com.vendor.service.RoleServiceImpl;
import com.vendor.utils.DataNotFoundException;
import com.vendor.utils.GsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/order")
public class RoleController {

    private Log log = LogFactory.getLog(RoleController.class);
  //  @Autowired
   // roleService roleService;

    @Autowired
    IRoleService rolexxService;



    @RequestMapping(value = "/api/{ver}/roles", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public Roles createRole(@PathVariable("ver") String version, @RequestBody Roles role) {

        log.info("role:" + role.getUuid() + " name:" + role.getName() + ",version:" + version);

        System.out.println(role.getName());
      //  Roles newRole = (Roles) this.getRoleService().create(role);

       Roles newRole = (Roles) rolexxService.create(role);
       return newRole;
        //return  null;
    }

    @RequestMapping(value = "/api/{ver}/roles/batchCreate", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public Integer batchCreateRole(@PathVariable("ver") String version, @RequestBody List<Roles> roles) {

        log.info( ",version:" + version);

        //  Roles newRole = (Roles) this.getRoleService().create(role);

       return  rolexxService.batchInsert(roles);
    }


    @RequestMapping(value = "/api/{ver}/roles/{roleUUID}", method = {RequestMethod.GET})
    @ResponseBody
    public Roles getRoles(@PathVariable("ver") String version, @PathVariable("roleUUID") String roleUUID) throws  DataNotFoundException {
        log.info(",version:" + version);
        log.info("roleUUID  :" + roleUUID);
        if(roleUUID.contentEquals("2") )
        {
            throw  new DataNotFoundException("5003","dd");
        }

        return rolexxService.get(roleUUID);
    }

    @RequestMapping(value = "/api/{ver}/roles", method = {RequestMethod.GET})
    @ResponseBody
    public ListResponse<Roles> listRoles(@PathVariable("ver") String version, RoleQueryVo role
    , Integer page, Integer rows) {
        log.info(",version:" + version);
        log.info("role  :" + GsonUtils.ToJson(role, RoleQueryVo.class));

        ListResponse<Roles> t1 = rolexxService.list(role,page,rows);
        return t1;
    }

    @RequestMapping(value = "/api/{ver}/roles/{roleUUID}", method = {RequestMethod.POST})
    @ResponseBody
    public Roles updateRoles(@PathVariable("ver") String version, @PathVariable("roleUUID") String roleUUID,
                             @RequestBody Roles updateRole   ) {
        log.info(",version:" + version);
        log.info("roleUUID  :" + roleUUID);


        return rolexxService.update(roleUUID,updateRole);
    }

    @RequestMapping(value = "/api/{ver}/roles/{roleUUID}", method = {RequestMethod.DELETE})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public Roles deleteRoles(@PathVariable("ver") String version, @PathVariable("roleUUID") String roleUUID) {
        log.info(",version:" + version);
        log.info("roleUUID22  :" + roleUUID);

        return rolexxService.delete(roleUUID);
    }


    @RequestMapping(value = "/api/{ver}/roles/batchDelete", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public Integer batchDeleteRoles(@PathVariable("ver") String version, @RequestBody List<String> roleUUIDs) {
        log.info(",version:" + version);
        log.info("roleUUIDs  :" + roleUUIDs);

        return rolexxService.batchDelete(roleUUIDs);
    }

}
