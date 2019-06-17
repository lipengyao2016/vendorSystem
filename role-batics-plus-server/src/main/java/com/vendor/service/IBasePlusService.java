package com.vendor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vendor.entity.ListResponse;
import com.vendor.utils.DataNotFoundException;

import java.util.List;

public interface IBasePlusService<T,QY_T>  {
     public boolean create(T obj);
     public  T get(String uuid);
     public ListResponse<T> list(QY_T queryObj, Integer page, Integer rows);
     public  boolean update(String uuid, T updateObj) throws DataNotFoundException;
     public  boolean delete(String uuid);

     public  boolean update(T updateObj) throws DataNotFoundException;

     public boolean batchInsert(List<T> record);

     public boolean batchDelete(List<String> uuids);

     public  boolean batchUpdate(List<String> uuids, T updateObj) throws DataNotFoundException;
}
