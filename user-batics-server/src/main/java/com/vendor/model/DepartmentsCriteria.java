package com.vendor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentsCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidIsNull() {
            addCriterion("upLevelDepartmentUUID is null");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidIsNotNull() {
            addCriterion("upLevelDepartmentUUID is not null");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidEqualTo(String value) {
            addCriterion("upLevelDepartmentUUID =", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidNotEqualTo(String value) {
            addCriterion("upLevelDepartmentUUID <>", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidGreaterThan(String value) {
            addCriterion("upLevelDepartmentUUID >", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidGreaterThanOrEqualTo(String value) {
            addCriterion("upLevelDepartmentUUID >=", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidLessThan(String value) {
            addCriterion("upLevelDepartmentUUID <", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidLessThanOrEqualTo(String value) {
            addCriterion("upLevelDepartmentUUID <=", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidLike(String value) {
            addCriterion("upLevelDepartmentUUID like", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidNotLike(String value) {
            addCriterion("upLevelDepartmentUUID not like", value, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidIn(List<String> values) {
            addCriterion("upLevelDepartmentUUID in", values, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidNotIn(List<String> values) {
            addCriterion("upLevelDepartmentUUID not in", values, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidBetween(String value1, String value2) {
            addCriterion("upLevelDepartmentUUID between", value1, value2, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUpleveldepartmentuuidNotBetween(String value1, String value2) {
            addCriterion("upLevelDepartmentUUID not between", value1, value2, "upleveldepartmentuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidIsNull() {
            addCriterion("userOrganizationUUID is null");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidIsNotNull() {
            addCriterion("userOrganizationUUID is not null");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidEqualTo(String value) {
            addCriterion("userOrganizationUUID =", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidNotEqualTo(String value) {
            addCriterion("userOrganizationUUID <>", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidGreaterThan(String value) {
            addCriterion("userOrganizationUUID >", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidGreaterThanOrEqualTo(String value) {
            addCriterion("userOrganizationUUID >=", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidLessThan(String value) {
            addCriterion("userOrganizationUUID <", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidLessThanOrEqualTo(String value) {
            addCriterion("userOrganizationUUID <=", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidLike(String value) {
            addCriterion("userOrganizationUUID like", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidNotLike(String value) {
            addCriterion("userOrganizationUUID not like", value, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidIn(List<String> values) {
            addCriterion("userOrganizationUUID in", values, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidNotIn(List<String> values) {
            addCriterion("userOrganizationUUID not in", values, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidBetween(String value1, String value2) {
            addCriterion("userOrganizationUUID between", value1, value2, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andUserorganizationuuidNotBetween(String value1, String value2) {
            addCriterion("userOrganizationUUID not between", value1, value2, "userorganizationuuid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNull() {
            addCriterion("createdAt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNotNull() {
            addCriterion("createdAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedatEqualTo(Date value) {
            addCriterion("createdAt =", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotEqualTo(Date value) {
            addCriterion("createdAt <>", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThan(Date value) {
            addCriterion("createdAt >", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("createdAt >=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThan(Date value) {
            addCriterion("createdAt <", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThanOrEqualTo(Date value) {
            addCriterion("createdAt <=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatIn(List<Date> values) {
            addCriterion("createdAt in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotIn(List<Date> values) {
            addCriterion("createdAt not in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatBetween(Date value1, Date value2) {
            addCriterion("createdAt between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotBetween(Date value1, Date value2) {
            addCriterion("createdAt not between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andModifiedatIsNull() {
            addCriterion("modifiedAt is null");
            return (Criteria) this;
        }

        public Criteria andModifiedatIsNotNull() {
            addCriterion("modifiedAt is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedatEqualTo(Date value) {
            addCriterion("modifiedAt =", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatNotEqualTo(Date value) {
            addCriterion("modifiedAt <>", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatGreaterThan(Date value) {
            addCriterion("modifiedAt >", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatGreaterThanOrEqualTo(Date value) {
            addCriterion("modifiedAt >=", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatLessThan(Date value) {
            addCriterion("modifiedAt <", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatLessThanOrEqualTo(Date value) {
            addCriterion("modifiedAt <=", value, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatIn(List<Date> values) {
            addCriterion("modifiedAt in", values, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatNotIn(List<Date> values) {
            addCriterion("modifiedAt not in", values, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatBetween(Date value1, Date value2) {
            addCriterion("modifiedAt between", value1, value2, "modifiedat");
            return (Criteria) this;
        }

        public Criteria andModifiedatNotBetween(Date value1, Date value2) {
            addCriterion("modifiedAt not between", value1, value2, "modifiedat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}