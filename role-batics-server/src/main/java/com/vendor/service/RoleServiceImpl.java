package com.vendor.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vendor.entity.ListResponse;

import com.vendor.mapper.RolesMapper;
import com.vendor.model.Roles;
import com.vendor.model.RolesExample;
import com.vendor.queryvo.RoleQueryVo;
import com.vendor.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.Ref;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service
public class RoleServiceImpl   implements  IRoleService{

    private Log log = LogFactory.getLog(RoleServiceImpl.class);

    private RolesMapper roleDao;

    public  RoleServiceImpl()
    {
        System.out.println("RoleServiceImpl init");
    }

    @Autowired(required = true)
    public  RoleServiceImpl(RolesMapper roleDao)
    {
        Class mapperCls = roleDao.getClass();
        log.info(" roleDao:" + mapperCls.getName());
        this.roleDao = roleDao;
    }


    @Override
    public Roles create(Roles obj) {
        DBEntityUtils.preCreate(obj);
         this.roleDao.insert(obj);
         return this.get(obj.getUuid());
    }

    @Override
    public Roles get(String uuid) {
        RolesExample example = new RolesExample();
        RolesExample.Criteria criteria = example.createCriteria();
        criteria.andUuidEqualTo(uuid);
        List<Roles> roles = this.roleDao.selectByExample(example);
        if(roles.size() > 0)
        {
            return  roles.get(0);
        }
        else
        {
            return null;
        }
    }

    @Override
    public ListResponse<Roles> list(RoleQueryVo queryObj , Integer page, Integer rows) {

        PageHelper.startPage(page -1, rows);

        RolesExample example = new RolesExample();
        RolesExample.Criteria criteria = example.createCriteria();

        Field[] fieldArray = queryObj.getClass().getDeclaredFields();
        for (Field f : fieldArray) {

            if (f.getName().contentEquals("page") || f.getName().contentEquals("rows")) {
                continue;
            }
            if (f.getType().getName().contains("com.")) {
                try {
                    Object objVal = (Object) ReflectUtils.getField(queryObj, f.getName());
                    if (objVal != null) {
                        String objFieldName = f.getName();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    String value = null;
                    try {
                        value = (String) ReflectUtils.getField(queryObj, f.getName());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                   // log.info("field name:" + f.getName() + ",value:" + value);

                    Field curField = ReflectUtils.getFieldInfo(Roles.class,f.getName());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if (value != null && curField != null) {
                        String fieldName = f.getName();
                        if (value.contains("[")) {
                            List<Object> valueList = GsonUtils.ToObjectList(value);

                            Object firstValue = valueList.get(0);
                            StrUtils.emObjType objType = StrUtils.getObjectType(firstValue);
                            if (valueList.size() == 2 && objType == StrUtils.emObjType.Obj_Str
                                    && StrUtils.isValidDate((String) valueList.get(0))
                                    && StrUtils.isValidDate((String) valueList.get(1))) {

                                try
                                {
                                    String fieldLikeMethodName = "and" + f.getName() + "Between";
                                    if( curField.getType().getName().equals(Integer.class.getName()) )
                                    {
                                        int beginVal = Integer.parseInt((String) valueList.get(0));
                                        int endVal = Integer.parseInt((String) valueList.get(1));
                                        ReflectUtils.callMethod(criteria,fieldLikeMethodName,beginVal,endVal);
                                    }
                                    else if( curField.getType().getName().equals(Date.class.getName())  )
                                    {
                                        Date beginDate = sdf.parse((String) valueList.get(0));
                                        Date endDate = sdf.parse((String) valueList.get(1));
                                        ReflectUtils.callMethod(criteria,fieldLikeMethodName,beginDate,endDate);
                                    }
                                    else
                                    {
                                        String beginVal = (String) valueList.get(0);
                                        String endVal = (String) valueList.get(1);
                                        ReflectUtils.callMethod(criteria,fieldLikeMethodName,beginVal,endVal);
                                    }

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Type t1 = curField.getType();
                                String fieldLikeMethodName = "and" + f.getName() + "In";
                                log.info("field type:" + curField.getType() + ",class:"+
                                Integer.class.getName());

                                if( curField.getType().getName().equals(Integer.class.getName()))
                                {
                                    List<Integer> retList = new ArrayList();
                                    for (Object valSta : valueList) {
                                        log.info("int valSta  :" + valSta);
                                        retList.add(((Long)valSta).intValue());
                                    }
                                    ReflectUtils.callMethod(criteria,fieldLikeMethodName,retList);
                                }
                                else if(curField.getType().getName().equals(Date.class.getName()))
                                {
                                    List<Date> retList = new ArrayList();
                                    for (Object valSta : valueList) {
                                        log.info("date valSta  :" + valSta);
                                        retList.add(sdf.parse((String) valSta));
                                    }
                                    ReflectUtils.callMethod(criteria,fieldLikeMethodName,retList);
                                }
                                else
                                {
                                    List<String> retList = new ArrayList();
                                    for (Object valSta : valueList) {
                                        log.info("int valSta  :" + valSta);
                                        retList.add((String) valSta);
                                    }
                                    ReflectUtils.callMethod(criteria,fieldLikeMethodName,retList);
                                }

                            }
                        } else if (value.contains("*")) {
                            value = value.replace("*", "%");
                            String fieldLikeMethodName = "and" + f.getName() + "Like";
                            ReflectUtils.callMethod(criteria,fieldLikeMethodName,value);
                        } else {
                            String fieldEqualMethodName = "and" + f.getName() + "EqualTo";

                            Object realVal ;
                            if( curField.getType().getName().equals(Integer.class.getName()) )
                            {
                                realVal = Integer.parseInt(value);
                            }
                            else if( curField.getType().getName().equals(Date.class.getName()) )
                            {
                                realVal =  sdf.parse(value);
                            }
                            else
                            {
                                realVal = value;
                            }

                            ReflectUtils.callMethod(criteria,fieldEqualMethodName,realVal);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        List<Roles> roles = this.roleDao.selectByExample(example);

        PageInfo<Roles> pageInfo=new PageInfo<>(roles);
        ListResponse response = new ListResponse();
        response.setItems(pageInfo.getList());
        response.setTotalSize( ((Long) pageInfo.getTotal()).intValue() );
        response.setTotalPageCount(pageInfo.getPages());
        response.setPageSize(rows);
        response.setCurrentPage(page);

        return  response;

    }

    @Override
    public Roles update(String uuid, Roles updateObj) {
        RolesExample example = new RolesExample();
        RolesExample.Criteria criteria = example.createCriteria();
        criteria.andUuidEqualTo(uuid);
        DBEntityUtils.preUpdate(updateObj);
        this.roleDao.updateByExampleSelective(updateObj,example);

        return this.get(uuid);
    }

    @Override
    public Roles delete(String uuid) {
        RolesExample example = new RolesExample();
        RolesExample.Criteria criteria = example.createCriteria();
        criteria.andUuidEqualTo(uuid);
         this.roleDao.deleteByExample(example);
         return null;
    }

    @Override
    public Roles update(Roles updateObj) throws DataNotFoundException {
        return null;
    }

    @Override
    public int batchInsert(List<Roles> record) {
        return 0;
    }

    @Override
    public int batchDelete(List<String> uuids) {
        return 0;
    }

    @Override
    public Roles batchUpdate(List<String> uuids, Roles updateObj) throws DataNotFoundException {
        return null;
    }
}
