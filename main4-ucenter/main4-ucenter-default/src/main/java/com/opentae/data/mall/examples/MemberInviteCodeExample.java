package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberInviteCode;

import java.util.*;
public class MemberInviteCodeExample extends SgExample<MemberInviteCodeExample.Criteria> {
    public static final Class<MemberInviteCode> beanClass = MemberInviteCode.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn userInviteCodeId;
    public static EntityColumn userInviteCode;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        userInviteCodeId = listMap.get("userInviteCodeId");
        userInviteCode = listMap.get("userInviteCode");
        userId = listMap.get("userId");
        }

    public MemberInviteCodeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberInviteCodeExample.Criteria createCriteriaInternal() {
        return new MemberInviteCodeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public MemberInviteCodeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public MemberInviteCodeExample.Criteria andUserInviteCodeIdIsNull() {
            return isNull(userInviteCodeId);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdIsNotNull() {
            return isNotNull(userInviteCodeId);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdEqualTo(Integer value) {
            return equalTo(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdNotEqualTo(Integer value) {
            return notEqualTo(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdGreaterThan(Integer value) {
            return greaterThan(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdLessThan(Integer value) {
            return lessThan(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(userInviteCodeId, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdIn(List<Integer> values) {
            return in(userInviteCodeId, values);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdNotIn(List<Integer> values) {
            return notIn(userInviteCodeId, values);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdBetween(Integer value1, Integer value2) {
            return between(userInviteCodeId, value1, value2);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIdNotBetween(Integer value1, Integer value2) {
            return notBetween(userInviteCodeId, value1, value2);
        }
        public MemberInviteCodeExample.Criteria andUserInviteCodeIsNull() {
            return isNull(userInviteCode);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIsNotNull() {
            return isNotNull(userInviteCode);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeEqualTo(String value) {
            return equalTo(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeNotEqualTo(String value) {
            return notEqualTo(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeGreaterThan(String value) {
            return greaterThan(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeLessThan(String value) {
            return lessThan(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeLike(String value) {
            return like(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeNotLike(String value) {
            return notLike(userInviteCode, value);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeIn(List<String> values) {
            return in(userInviteCode, values);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeNotIn(List<String> values) {
            return notIn(userInviteCode, values);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeBetween(String value1, String value2) {
            return between(userInviteCode, value1, value2);
        }

        public MemberInviteCodeExample.Criteria andUserInviteCodeNotBetween(String value1, String value2) {
            return notBetween(userInviteCode, value1, value2);
        }
        public MemberInviteCodeExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberInviteCodeExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberInviteCodeExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberInviteCodeExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberInviteCodeExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberInviteCodeExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberInviteCodeExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}