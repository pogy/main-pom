package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberLoginRecord;

import java.util.*;
public class MemberLoginRecordExample extends SgExample<MemberLoginRecordExample.Criteria> {
    public static final Class<MemberLoginRecord> beanClass = MemberLoginRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn lastTime;
    public static EntityColumn subUserName;
    public static EntityColumn subUserPassword;
    public static EntityColumn lastIp;
    public static EntityColumn accountType;
    public static EntityColumn userId;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn loginRecordId;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn subUserId;
    public static EntityColumn remark1;
    public static EntityColumn subUserKey;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        lastTime = listMap.get("lastTime");
        subUserName = listMap.get("subUserName");
        subUserPassword = listMap.get("subUserPassword");
        lastIp = listMap.get("lastIp");
        accountType = listMap.get("accountType");
        userId = listMap.get("userId");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        loginRecordId = listMap.get("loginRecordId");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        subUserId = listMap.get("subUserId");
        remark1 = listMap.get("remark1");
        subUserKey = listMap.get("subUserKey");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public MemberLoginRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberLoginRecordExample.Criteria createCriteriaInternal() {
        return new MemberLoginRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberLoginRecordExample.Criteria andLastTimeIsNull() {
            return isNull(lastTime);
        }

        public MemberLoginRecordExample.Criteria andLastTimeIsNotNull() {
            return isNotNull(lastTime);
        }

        public MemberLoginRecordExample.Criteria andLastTimeEqualTo(Date value) {
            return equalTo(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotEqualTo(Date value) {
            return notEqualTo(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeGreaterThan(Date value) {
            return greaterThan(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeLessThan(Date value) {
            return lessThan(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastTime, value);
        }

        public MemberLoginRecordExample.Criteria andLastTimeIn(List<Date> values) {
            return in(lastTime, values);
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotIn(List<Date> values) {
            return notIn(lastTime, values);
        }

        public MemberLoginRecordExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            return between(lastTime, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastTime, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andSubUserNameIsNull() {
            return isNull(subUserName);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameIsNotNull() {
            return isNotNull(subUserName);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameEqualTo(String value) {
            return equalTo(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotEqualTo(String value) {
            return notEqualTo(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameGreaterThan(String value) {
            return greaterThan(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLessThan(String value) {
            return lessThan(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLike(String value) {
            return like(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotLike(String value) {
            return notLike(subUserName, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameIn(List<String> values) {
            return in(subUserName, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotIn(List<String> values) {
            return notIn(subUserName, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameBetween(String value1, String value2) {
            return between(subUserName, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotBetween(String value1, String value2) {
            return notBetween(subUserName, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andSubUserPasswordIsNull() {
            return isNull(subUserPassword);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordIsNotNull() {
            return isNotNull(subUserPassword);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordEqualTo(String value) {
            return equalTo(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotEqualTo(String value) {
            return notEqualTo(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordGreaterThan(String value) {
            return greaterThan(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLessThan(String value) {
            return lessThan(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLike(String value) {
            return like(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotLike(String value) {
            return notLike(subUserPassword, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordIn(List<String> values) {
            return in(subUserPassword, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotIn(List<String> values) {
            return notIn(subUserPassword, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordBetween(String value1, String value2) {
            return between(subUserPassword, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            return notBetween(subUserPassword, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andLastIpIsNull() {
            return isNull(lastIp);
        }

        public MemberLoginRecordExample.Criteria andLastIpIsNotNull() {
            return isNotNull(lastIp);
        }

        public MemberLoginRecordExample.Criteria andLastIpEqualTo(String value) {
            return equalTo(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpNotEqualTo(String value) {
            return notEqualTo(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpGreaterThan(String value) {
            return greaterThan(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpLessThan(String value) {
            return lessThan(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpLike(String value) {
            return like(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpNotLike(String value) {
            return notLike(lastIp, value);
        }

        public MemberLoginRecordExample.Criteria andLastIpIn(List<String> values) {
            return in(lastIp, values);
        }

        public MemberLoginRecordExample.Criteria andLastIpNotIn(List<String> values) {
            return notIn(lastIp, values);
        }

        public MemberLoginRecordExample.Criteria andLastIpBetween(String value1, String value2) {
            return between(lastIp, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andLastIpNotBetween(String value1, String value2) {
            return notBetween(lastIp, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberLoginRecordExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberLoginRecordExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberLoginRecordExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberLoginRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberLoginRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public MemberLoginRecordExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public MemberLoginRecordExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public MemberLoginRecordExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public MemberLoginRecordExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public MemberLoginRecordExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public MemberLoginRecordExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public MemberLoginRecordExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public MemberLoginRecordExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public MemberLoginRecordExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public MemberLoginRecordExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public MemberLoginRecordExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public MemberLoginRecordExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public MemberLoginRecordExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public MemberLoginRecordExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public MemberLoginRecordExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public MemberLoginRecordExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public MemberLoginRecordExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public MemberLoginRecordExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public MemberLoginRecordExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public MemberLoginRecordExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public MemberLoginRecordExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public MemberLoginRecordExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public MemberLoginRecordExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public MemberLoginRecordExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public MemberLoginRecordExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andLoginRecordIdIsNull() {
            return isNull(loginRecordId);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdIsNotNull() {
            return isNotNull(loginRecordId);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdEqualTo(Long value) {
            return equalTo(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotEqualTo(Long value) {
            return notEqualTo(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdGreaterThan(Long value) {
            return greaterThan(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdLessThan(Long value) {
            return lessThan(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(loginRecordId, value);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdIn(List<Long> values) {
            return in(loginRecordId, values);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotIn(List<Long> values) {
            return notIn(loginRecordId, values);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdBetween(Long value1, Long value2) {
            return between(loginRecordId, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotBetween(Long value1, Long value2) {
            return notBetween(loginRecordId, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public MemberLoginRecordExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public MemberLoginRecordExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public MemberLoginRecordExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public MemberLoginRecordExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public MemberLoginRecordExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public MemberLoginRecordExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public MemberLoginRecordExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public MemberLoginRecordExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public MemberLoginRecordExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public MemberLoginRecordExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andSubUserIdIsNull() {
            return isNull(subUserId);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdIsNotNull() {
            return isNotNull(subUserId);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdEqualTo(Long value) {
            return equalTo(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotEqualTo(Long value) {
            return notEqualTo(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdGreaterThan(Long value) {
            return greaterThan(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdLessThan(Long value) {
            return lessThan(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subUserId, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdIn(List<Long> values) {
            return in(subUserId, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotIn(List<Long> values) {
            return notIn(subUserId, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdBetween(Long value1, Long value2) {
            return between(subUserId, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            return notBetween(subUserId, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public MemberLoginRecordExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public MemberLoginRecordExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public MemberLoginRecordExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public MemberLoginRecordExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public MemberLoginRecordExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andSubUserKeyIsNull() {
            return isNull(subUserKey);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyIsNotNull() {
            return isNotNull(subUserKey);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyEqualTo(String value) {
            return equalTo(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotEqualTo(String value) {
            return notEqualTo(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyGreaterThan(String value) {
            return greaterThan(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLessThan(String value) {
            return lessThan(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLike(String value) {
            return like(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotLike(String value) {
            return notLike(subUserKey, value);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyIn(List<String> values) {
            return in(subUserKey, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotIn(List<String> values) {
            return notIn(subUserKey, values);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyBetween(String value1, String value2) {
            return between(subUserKey, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotBetween(String value1, String value2) {
            return notBetween(subUserKey, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public MemberLoginRecordExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public MemberLoginRecordExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public MemberLoginRecordExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public MemberLoginRecordExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public MemberLoginRecordExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public MemberLoginRecordExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public MemberLoginRecordExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public MemberLoginRecordExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public MemberLoginRecordExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public MemberLoginRecordExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public MemberLoginRecordExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public MemberLoginRecordExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
