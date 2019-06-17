package com.vendor.controller;


import com.vendor.entity.Departments;
import com.vendor.service.IDepartmentsService;
import com.vendor.utils.DBEntityUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门。 前端控制器
 * </p>
 *
 * @author lpy
 * @since 2019-06-14
 */
@RestController
//@RequestMapping("/vendor/departments")
public class DepartmentsController {

    private Log log = LogFactory.getLog(DepartmentsController.class);
    //  @Autowired
    // departmentService departmentService;

    @Autowired
    IDepartmentsService departmentService;



    @RequestMapping(value = "/api/{ver}/departments", method = {RequestMethod.POST})
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public Departments createDepartment(@PathVariable("ver") String version, 
                                        @RequestBody Departments department) {

        log.info("department:" + department.getUuid() + " name:"
                + department.getName() + ",version:" + version);


        DBEntityUtils.preCreate(department);
        departmentService.save(department);
        return department;
        //return  null;
    }

}

