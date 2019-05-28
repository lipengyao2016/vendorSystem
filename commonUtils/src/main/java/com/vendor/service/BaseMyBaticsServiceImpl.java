package com.vendor.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vendor.entity.ListResponse;
import com.vendor.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BaseMyBaticsServiceImpl<T, QY_T> implements  IBaseService{


    private Object dbProxy;

    private Log log = LogFactory.getLog(BaseServiceImpl.class);
    private Class entityClass;
    private Class dbExampleCls;

    public BaseMyBaticsServiceImpl()
    {
        System.out.println("RoleServiceImpl init");
    }

    @Autowired(required = true)
    public BaseMyBaticsServiceImpl(Object dbProxy, Class entityClass,Class dbExampleCls)
    {
        this.dbProxy = dbProxy;
        this.entityClass = entityClass;
        this.dbExampleCls =dbExampleCls;
    }


    @Override
    public Object create(Object obj) {
        DBEntityUtils.preCreate(obj);
        ReflectUtils.callMethod(this.dbProxy,"insert",obj);
        try {
            String uuid = (String) ReflectUtils.getField(obj,"uuid");
            return  this.get(uuid);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public Object createExample() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       return   ReflectUtils.createInstance(this.dbExampleCls);
    }

    public Object createCriteria(Object example)
    {
        return  ReflectUtils.callMethod(example,"createCriteria");
    }

    public void addQuery(Object criteria,String methodName, Object... args)
    {
        ReflectUtils.callMethod(criteria,methodName,args);
    }

    public Object executeDBQuery(String methodName, Object... args)
    {
       return ReflectUtils.callMethod(this.dbProxy,methodName,args);
    }

    @Override
    public Object get(String uuid) {
        try {
            Object example = this.createExample();
            Object criteria = this.createCriteria(example);
            this.addQuery(criteria,"andUuidEqualTo",uuid);

            List roles = (List) this.executeDBQuery("selectByExample",example);
            if(roles.size() > 0)
            {
                return  roles.get(0);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ListResponse list(Object queryObj, Integer page, Integer rows) {

        if(page == null)
        {
            page = 1;
        }
        if(rows == null)
        {
            rows = 10000;
        }

        PageHelper.startPage(page, rows);

        Object example = null;
        try {
            example = this.createExample();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Object criteria = this.createCriteria(example);

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

                    Field curField = ReflectUtils.getFieldInfo(this.entityClass,f.getName());
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

        List roles = (List) this.executeDBQuery("selectByExample",example);

        PageInfo pageInfo=new PageInfo<>(roles);
        ListResponse response = new ListResponse();
        response.setItems(pageInfo.getList());
        response.setTotalSize( ((Long) pageInfo.getTotal()).intValue() );
        response.setTotalPageCount(pageInfo.getPages());
        response.setPageSize(rows);
        response.setCurrentPage(page);

        return  response;
    }

    @Override
    public Object update(String uuid, Object updateObj) throws DataNotFoundException {

        try {
            Object example = this.createExample();
            Object criteria = this.createCriteria(example);
            this.addQuery(criteria,"andUuidEqualTo",uuid);
            DBEntityUtils.preUpdate(updateObj);
            this.executeDBQuery("updateByExampleSelective",updateObj,example);
            return this.get(uuid);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
        //this.roleDao.updateByExampleSelective(updateObj,example);
    }

    @Override
    public Object delete(String uuid) {

        Object example = null;
        try {
            example = this.createExample();
            Object criteria = this.createCriteria(example);
            this.addQuery(criteria,"andUuidEqualTo",uuid);
            this.executeDBQuery("deleteByExample",example);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Object update(Object updateObj) throws DataNotFoundException {
        String uuid = "";
        try {
             uuid = (String) ReflectUtils.getField(updateObj,"uuid");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this.update(uuid,updateObj);
    }

    @Override
    public int batchInsert(List record) {
       // List<Object> newRecords = new ArrayList();
        for(Object obj:record)
        {
            DBEntityUtils.preCreate(obj);
           // newRecords.add(obj);
        }
        int nRet = (int) ReflectUtils.callMethod(this.dbProxy,"batchInsert",record);
        return  nRet;
    }

    @Override
    public Object batchUpdate(List uuids, Object updateObj) throws DataNotFoundException {
        try {
            Object example = this.createExample();
            Object criteria = this.createCriteria(example);
            this.addQuery(criteria,"andUuidIn",uuids);
            DBEntityUtils.preUpdate(updateObj);
            this.executeDBQuery("updateByExampleSelective",updateObj,example);
           return updateObj;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public int batchDelete(List uuids) {
        Object example = null;
        try {
            example = this.createExample();
            Object criteria = this.createCriteria(example);
            this.addQuery(criteria,"andUuidIn",uuids);
            this.executeDBQuery("deleteByExample",example);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  0;
    }
}
