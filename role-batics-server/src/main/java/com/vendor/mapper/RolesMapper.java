package com.vendor.mapper;

import com.vendor.model.Roles;
import com.vendor.model.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
    int countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExampleWithBLOBs(RolesExample example);

    List<Roles> selectByExample(RolesExample example);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExampleWithBLOBs(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);
}