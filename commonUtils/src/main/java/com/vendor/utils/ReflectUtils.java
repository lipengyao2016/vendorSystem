package com.vendor.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectUtils {

    public static void setField(Object obj,String fieldName,Object value,boolean bOverWrite)
            throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();
        Field f = null;
        f = cls.getDeclaredField(fieldName);
        System.out.println(f);
        if(f!= null)
        {
            f.setAccessible(true);

            if(!bOverWrite)
            {
               Object   oldObj = f.get(obj);
               if(oldObj == null)
               {
                   f.set(obj, value);
               }
            }
            else
            {
                f.set(obj, value);
            }


        }

    }

    public static Object  createInstance(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor con = cls.getConstructor(null);
        return con.newInstance();
    }

    public static Object getField(Object obj,String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();
        Field f = null;
        f = cls.getDeclaredField(fieldName);
        System.out.println(f);
        f.setAccessible(true);
        return f.get(obj);
    }
}
