package com.vendor.service;

import com.vendor.controller.UserRoleController;
import com.vendor.dao.UserRoleMemberShipDao;
import com.vendor.entity.ListResponse;
import com.vendor.entity.UserRoleMemberShips;
import com.vendor.entity.Users;
import com.vendor.queryvo.UserRoleQueryVO;
import com.vendor.utils.DataNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleMemberShipServiceImpl implements  IUserRoleMemberShipService{

    @Autowired
    private UserRoleMemberShipDao UserRoleMemberShipDao;

    private Log log = LogFactory.getLog(UserRoleMemberShipServiceImpl.class);
    
    private IBaseService<UserRoleMemberShips,UserRoleQueryVO> baseService;

    public UserRoleMemberShipServiceImpl()
    {
        System.out.println("UserRoleMemberShipServiceImpl init");
    }

    @Autowired(required = true)
    public UserRoleMemberShipServiceImpl(UserRoleMemberShipDao UserRoleMemberShipDao)
    {
        this.UserRoleMemberShipDao = UserRoleMemberShipDao;
        this.baseService = new BaseServiceImpl(UserRoleMemberShipDao,UserRoleMemberShips.class);
    }


    @Override
    public UserRoleMemberShips create(UserRoleMemberShips obj) {
        return this.baseService.create(obj);
    }

    @Override
    public UserRoleMemberShips get(String uuid) {

        UserRoleMemberShips userRoleMemberShips =  this.baseService.get(uuid);
        userRoleMemberShips.setUserUuid(userRoleMemberShips.getUsers().getUuid());
        return  userRoleMemberShips;
    }

    @Override
    public ListResponse<UserRoleMemberShips> list(UserRoleQueryVO queryObj) {
        ListResponse<UserRoleMemberShips> userRoleMemberShipsListResponse = this.baseService.list(queryObj);

        for (UserRoleMemberShips  userRoleMemberShips:userRoleMemberShipsListResponse.getItems())
        {
            userRoleMemberShips.setUserUuid(userRoleMemberShips.getUsers().getUuid());
        }
        return userRoleMemberShipsListResponse;
         /*  Specification<UserRoleMemberShips> specification = new Specification<UserRoleMemberShips>() {
            //toPredicate就是查询条件
            //root根对象表示实体类,要查询的类型,query所需要添加查询条件,cb构建Predicate

            @SuppressWarnings("unchecked")
            private <T, R> Path<R> getPath(Class<R> resultType, Path<T> root, String path) {
                String[] pathElements = path.split("\\.");
                Path<?> retVal = root;
                for (String pathEl : pathElements) {
                    retVal = (Path<R>) retVal.get(pathEl);
                }
                return (Path<R>) retVal;
            }

            @Override
            public Predicate toPredicate(Root<UserRoleMemberShips> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // TODO Auto-generated method stub


             List<Predicate> predicatesList = new ArrayList<>();

                Field[] fieldArray = queryObj.getClass().getDeclaredFields();

                Field userField = null;
                String userFieldName = "";
                for (Field f : fieldArray) {
                    log.info("userroleservice list fieldname:" + f.getName()
                    +",type:" + f.getType());
                    if(f.getType().getName().contains("com."))
                    {
                        userField = f;
                        userFieldName = f.getName();
                        break;
                    }
                }

                if(queryObj.getUsers() != null)
                {
                    Field[] subFireldArray = userField.getType().getDeclaredFields();

                    if(queryObj.getUsers().getUuid() !=null)
                    {
                        String uuidField="";
                        for (Field f : subFireldArray) {
                            if(f.getName().contains("uuid"))
                            {
                                uuidField = f.getName();
                                break;
                            }
                        }
                        uuidField = userFieldName + "."+uuidField;
                        predicatesList.add(cb.and(
                                cb.equal(this.getPath(String.class,root,uuidField), queryObj.getUsers().getUuid())));
                    }
                }

               *//* if (queryObj.getUserUuid() != null) {
                    predicatesList.add(cb.and(
                            cb.equal(this.getPath(String.class,root,"users.uuid"), queryObj.getUserUuid())));
                }*//*

                return cb.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
            }
        };
        List<UserRoleMemberShips> findRoles= ((BaseServiceImpl)this.baseService).getM_jpaSpecificationExecutor().findAll(specification);

        for (UserRoleMemberShips  userRoleMemberShips:findRoles)
        {
            userRoleMemberShips.setUserUuid(userRoleMemberShips.getUsers().getUuid());
        }

        ListResponse response = new ListResponse();
        response.setItems(findRoles);

        return response;*/
    }

    @Override
    public UserRoleMemberShips update(String uuid, UserRoleMemberShips updateObj) {
        return this.baseService.update(uuid,updateObj);
    }

    @Override
    public UserRoleMemberShips delete(String uuid) {
        return this.baseService.delete(uuid);
    }

    @Override
    public UserRoleMemberShips update(UserRoleMemberShips updateObj) throws DataNotFoundException {
        return null;
    }

}
