package com.vendor.utils;

import java.util.Date;

public class DBEntityUtils {

    public  static  void preCreate(Object obj)
    {
        try {
            ReflectUtils.setField(obj, "uuid", UUIDUtils.createUUID(),false);
            ReflectUtils.setField(obj, "createdAt", new Date(),true);
            ReflectUtils.setField(obj, "modifiedAt", new Date(),true);
            ReflectUtils.setField(obj, "status", "enabled",false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public  static void preUpdate(Object obj)
    {
        try {
            ReflectUtils.setField(obj, "modifiedAt", new Date(),true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
