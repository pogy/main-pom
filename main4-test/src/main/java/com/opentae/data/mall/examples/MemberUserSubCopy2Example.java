package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberUserSubCopy2;

import java.util.*;
public class MemberUserSubCopy2Example extends SgExample<MemberUserSubCopy2Example.Criteria> {
    public static final Class<MemberUserSubCopy2> beanClass = MemberUserSubCopy2.class;
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

    public MemberUserSubCopy2Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberUserSubCopy2Example.Criteria createCriteriaInternal() {
        return new MemberUserSubCopy2Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameIsNull() {
            return isNull(subUserName);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameIsNotNull() {
            return isNotNull(subUserName);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameEqualTo(String value) {
            return equalTo(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotEqualTo(String value) {
            return notEqualTo(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameGreaterThan(String value) {
            return greaterThan(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLessThan(String value) {
            return lessThan(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLike(String value) {
            return like(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotLike(String value) {
            return notLike(subUserName, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameIn(List<String> values) {
            return in(subUserName, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotIn(List<String> values) {
            return notIn(subUserName, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameBetween(String value1, String value2) {
            return between(subUserName, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotBetween(String value1, String value2) {
            return notBetween(subUserName, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIsNull() {
            return isNull(subUserPassword);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIsNotNull() {
            return isNotNull(subUserPassword);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordEqualTo(String value) {
            return equalTo(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotEqualTo(String value) {
            return notEqualTo(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordGreaterThan(String value) {
            return greaterThan(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLessThan(String value) {
            return lessThan(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLike(String value) {
            return like(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotLike(String value) {
            return notLike(subUserPassword, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIn(List<String> values) {
            return in(subUserPassword, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotIn(List<String> values) {
            return notIn(subUserPassword, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordBetween(String value1, String value2) {
            return between(subUserPassword, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            return notBetween(subUserPassword, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusEqualTo(Long value) {
            return equalTo(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotEqualTo(Long value) {
            return notEqualTo(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusGreaterThan(Long value) {
            return greaterThan(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusLessThan(Long value) {
            return lessThan(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusIn(List<Long> values) {
            return in(useStatus, values);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotIn(List<Long> values) {
            return notIn(useStatus, values);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusBetween(Long value1, Long value2) {
            return between(useStatus, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            return notBetween(useStatus, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIsNull() {
            return isNull(isOpenStore);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIsNotNull() {
            return isNotNull(isOpenStore);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreEqualTo(Integer value) {
            return equalTo(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            return notEqualTo(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreGreaterThan(Integer value) {
            return greaterThan(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreLessThan(Integer value) {
            return lessThan(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIn(List<Integer> values) {
            return in(isOpenStore, values);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            return notIn(isOpenStore, values);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            return between(isOpenStore, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            return notBetween(isOpenStore, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andSubUserIdIsNull() {
            return isNull(subUserId);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdIsNotNull() {
            return isNotNull(subUserId);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdEqualTo(Long value) {
            return equalTo(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotEqualTo(Long value) {
            return notEqualTo(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdGreaterThan(Long value) {
            return greaterThan(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdLessThan(Long value) {
            return lessThan(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subUserId, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdIn(List<Long> values) {
            return in(subUserId, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotIn(List<Long> values) {
            return notIn(subUserId, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdBetween(Long value1, Long value2) {
            return between(subUserId, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            return notBetween(subUserId, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andLoginsIsNull() {
            return isNull(logins);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsIsNotNull() {
            return isNotNull(logins);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsEqualTo(Long value) {
            return equalTo(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotEqualTo(Long value) {
            return notEqualTo(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsGreaterThan(Long value) {
            return greaterThan(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsLessThan(Long value) {
            return lessThan(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(logins, value);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsIn(List<Long> values) {
            return in(logins, values);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotIn(List<Long> values) {
            return notIn(logins, values);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsBetween(Long value1, Long value2) {
            return between(logins, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotBetween(Long value1, Long value2) {
            return notBetween(logins, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andSubUserKeyIsNull() {
            return isNull(subUserKey);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyIsNotNull() {
            return isNotNull(subUserKey);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyEqualTo(String value) {
            return equalTo(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotEqualTo(String value) {
            return notEqualTo(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyGreaterThan(String value) {
            return greaterThan(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLessThan(String value) {
            return lessThan(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLike(String value) {
            return like(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotLike(String value) {
            return notLike(subUserKey, value);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyIn(List<String> values) {
            return in(subUserKey, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotIn(List<String> values) {
            return notIn(subUserKey, values);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyBetween(String value1, String value2) {
            return between(subUserKey, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotBetween(String value1, String value2) {
            return notBetween(subUserKey, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public MemberUserSubCopy2Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
