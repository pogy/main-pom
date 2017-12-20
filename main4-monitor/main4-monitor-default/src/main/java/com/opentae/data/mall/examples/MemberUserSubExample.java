package com.opentae.data.mall.examples;


import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberUserSub;

import java.util.*;

public class MemberUserSubExample extends SgExample<MemberUserSubExample.Criteria> {
    public static final Class<MemberUserSub> beanClass = MemberUserSub.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn subUserName;
    public static EntityColumn subUserPassword;
    public static EntityColumn accountType;
    public static EntityColumn userId;
    public static EntityColumn useStatus;
    public static EntityColumn isOpenStore;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn createTime;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn subUserId;
    public static EntityColumn remark1;
    public static EntityColumn logins;
    public static EntityColumn subUserKey;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        subUserName = listMap.get("subUserName");
        subUserPassword = listMap.get("subUserPassword");
        accountType = listMap.get("accountType");
        userId = listMap.get("userId");
        useStatus = listMap.get("useStatus");
        isOpenStore = listMap.get("isOpenStore");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        createTime = listMap.get("createTime");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        subUserId = listMap.get("subUserId");
        remark1 = listMap.get("remark1");
        logins = listMap.get("logins");
        subUserKey = listMap.get("subUserKey");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public MemberUserSubExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andSubUserNameIsNull() {
            return isNull(subUserName);
        }

        public Criteria andSubUserNameIsNotNull() {
            return isNotNull(subUserName);
        }

        public Criteria andSubUserNameEqualTo(String value) {
            return equalTo(subUserName, value);
        }

        public Criteria andSubUserNameNotEqualTo(String value) {
            return notEqualTo(subUserName, value);
        }

        public Criteria andSubUserNameGreaterThan(String value) {
            return greaterThan(subUserName, value);
        }

        public Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserName, value);
        }

        public Criteria andSubUserNameLessThan(String value) {
            return lessThan(subUserName, value);
        }

        public Criteria andSubUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserName, value);
        }

        public Criteria andSubUserNameLike(String value) {
            return like(subUserName, value);
        }

        public Criteria andSubUserNameNotLike(String value) {
            return notLike(subUserName, value);
        }

        public Criteria andSubUserNameIn(List<String> values) {
            return in(subUserName, values);
        }

        public Criteria andSubUserNameNotIn(List<String> values) {
            return notIn(subUserName, values);
        }

        public Criteria andSubUserNameBetween(String value1, String value2) {
            return between(subUserName, value1, value2);
        }

        public Criteria andSubUserNameNotBetween(String value1, String value2) {
            return notBetween(subUserName, value1, value2);
        }
        public Criteria andSubUserPasswordIsNull() {
            return isNull(subUserPassword);
        }

        public Criteria andSubUserPasswordIsNotNull() {
            return isNotNull(subUserPassword);
        }

        public Criteria andSubUserPasswordEqualTo(String value) {
            return equalTo(subUserPassword, value);
        }

        public Criteria andSubUserPasswordNotEqualTo(String value) {
            return notEqualTo(subUserPassword, value);
        }

        public Criteria andSubUserPasswordGreaterThan(String value) {
            return greaterThan(subUserPassword, value);
        }

        public Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserPassword, value);
        }

        public Criteria andSubUserPasswordLessThan(String value) {
            return lessThan(subUserPassword, value);
        }

        public Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserPassword, value);
        }

        public Criteria andSubUserPasswordLike(String value) {
            return like(subUserPassword, value);
        }

        public Criteria andSubUserPasswordNotLike(String value) {
            return notLike(subUserPassword, value);
        }

        public Criteria andSubUserPasswordIn(List<String> values) {
            return in(subUserPassword, values);
        }

        public Criteria andSubUserPasswordNotIn(List<String> values) {
            return notIn(subUserPassword, values);
        }

        public Criteria andSubUserPasswordBetween(String value1, String value2) {
            return between(subUserPassword, value1, value2);
        }

        public Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            return notBetween(subUserPassword, value1, value2);
        }
        public Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public Criteria andIsOpenStoreIsNull() {
            return isNull(isOpenStore);
        }

        public Criteria andIsOpenStoreIsNotNull() {
            return isNotNull(isOpenStore);
        }

        public Criteria andIsOpenStoreEqualTo(Integer value) {
            return equalTo(isOpenStore, value);
        }

        public Criteria andIsOpenStoreNotEqualTo(Integer value) {
            return notEqualTo(isOpenStore, value);
        }

        public Criteria andIsOpenStoreGreaterThan(Integer value) {
            return greaterThan(isOpenStore, value);
        }

        public Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOpenStore, value);
        }

        public Criteria andIsOpenStoreLessThan(Integer value) {
            return lessThan(isOpenStore, value);
        }

        public Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOpenStore, value);
        }

        public Criteria andIsOpenStoreIn(List<Integer> values) {
            return in(isOpenStore, values);
        }

        public Criteria andIsOpenStoreNotIn(List<Integer> values) {
            return notIn(isOpenStore, values);
        }

        public Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            return between(isOpenStore, value1, value2);
        }

        public Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            return notBetween(isOpenStore, value1, value2);
        }
        public Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public Criteria andSubUserIdIsNull() {
            return isNull(subUserId);
        }

        public Criteria andSubUserIdIsNotNull() {
            return isNotNull(subUserId);
        }

        public Criteria andSubUserIdEqualTo(Long value) {
            return equalTo(subUserId, value);
        }

        public Criteria andSubUserIdNotEqualTo(Long value) {
            return notEqualTo(subUserId, value);
        }

        public Criteria andSubUserIdGreaterThan(Long value) {
            return greaterThan(subUserId, value);
        }

        public Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subUserId, value);
        }

        public Criteria andSubUserIdLessThan(Long value) {
            return lessThan(subUserId, value);
        }

        public Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subUserId, value);
        }

        public Criteria andSubUserIdIn(List<Long> values) {
            return in(subUserId, values);
        }

        public Criteria andSubUserIdNotIn(List<Long> values) {
            return notIn(subUserId, values);
        }

        public Criteria andSubUserIdBetween(Long value1, Long value2) {
            return between(subUserId, value1, value2);
        }

        public Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            return notBetween(subUserId, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andLoginsIsNull() {
            return isNull(logins);
        }

        public Criteria andLoginsIsNotNull() {
            return isNotNull(logins);
        }

        public Criteria andLoginsEqualTo(Integer value) {
            return equalTo(logins, value);
        }

        public Criteria andLoginsNotEqualTo(Integer value) {
            return notEqualTo(logins, value);
        }

        public Criteria andLoginsGreaterThan(Integer value) {
            return greaterThan(logins, value);
        }

        public Criteria andLoginsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(logins, value);
        }

        public Criteria andLoginsLessThan(Integer value) {
            return lessThan(logins, value);
        }

        public Criteria andLoginsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(logins, value);
        }

        public Criteria andLoginsIn(List<Integer> values) {
            return in(logins, values);
        }

        public Criteria andLoginsNotIn(List<Integer> values) {
            return notIn(logins, values);
        }

        public Criteria andLoginsBetween(Integer value1, Integer value2) {
            return between(logins, value1, value2);
        }

        public Criteria andLoginsNotBetween(Integer value1, Integer value2) {
            return notBetween(logins, value1, value2);
        }
        public Criteria andSubUserKeyIsNull() {
            return isNull(subUserKey);
        }

        public Criteria andSubUserKeyIsNotNull() {
            return isNotNull(subUserKey);
        }

        public Criteria andSubUserKeyEqualTo(String value) {
            return equalTo(subUserKey, value);
        }

        public Criteria andSubUserKeyNotEqualTo(String value) {
            return notEqualTo(subUserKey, value);
        }

        public Criteria andSubUserKeyGreaterThan(String value) {
            return greaterThan(subUserKey, value);
        }

        public Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserKey, value);
        }

        public Criteria andSubUserKeyLessThan(String value) {
            return lessThan(subUserKey, value);
        }

        public Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserKey, value);
        }

        public Criteria andSubUserKeyLike(String value) {
            return like(subUserKey, value);
        }

        public Criteria andSubUserKeyNotLike(String value) {
            return notLike(subUserKey, value);
        }

        public Criteria andSubUserKeyIn(List<String> values) {
            return in(subUserKey, values);
        }

        public Criteria andSubUserKeyNotIn(List<String> values) {
            return notIn(subUserKey, values);
        }

        public Criteria andSubUserKeyBetween(String value1, String value2) {
            return between(subUserKey, value1, value2);
        }

        public Criteria andSubUserKeyNotBetween(String value1, String value2) {
            return notBetween(subUserKey, value1, value2);
        }
        public Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
