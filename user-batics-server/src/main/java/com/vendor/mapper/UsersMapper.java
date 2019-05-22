package com.vendor.mapper;

import com.vendor.model.UserRoleOrgQueryVo;
import com.vendor.model.UserRoleOrgs;
import com.vendor.model.Users;
import com.vendor.model.UsersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int countByExample(UsersCriteria example);

    int deleteByExample(UsersCriteria example);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersCriteria example);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersCriteria example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersCriteria example);

    List<UserRoleOrgs> getUserRole(UserRoleOrgQueryVo userRoleOrgQueryVo);
}