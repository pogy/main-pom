package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberInvite;

import java.util.*;
public class MemberInviteExample extends SgExample<MemberInviteExample.Criteria> {
    public static final Class<MemberInvite> beanClass = MemberInvite.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn valid;
    public static EntityColumn inviteUserId;
    public static EntityColumn inviteId;
    public static EntityColumn userId;
    public static EntityColumn inviteCreateTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        valid = listMap.get("valid");
        inviteUserId = listMap.get("inviteUserId");
        inviteId = listMap.get("inviteId");
        userId = listMap.get("userId");
        inviteCreateTime = listMap.get("inviteCreateTime");
        }

    public MemberInviteExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberInviteExample.Criteria createCriteriaInternal() {
        return new MemberInviteExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberInviteExample.Criteria andValidIsNull() {
            return isNull(valid);
        }

        public MemberInviteExample.Criteria andValidIsNotNull() {
            return isNotNull(valid);
        }

        public MemberInviteExample.Criteria andValidEqualTo(Integer value) {
            return equalTo(valid, value);
        }

        public MemberInviteExample.Criteria andValidNotEqualTo(Integer value) {
            return notEqualTo(valid, value);
        }

        public MemberInviteExample.Criteria andValidGreaterThan(Integer value) {
            return greaterThan(valid, value);
        }

        public MemberInviteExample.Criteria andValidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(valid, value);
        }

        public MemberInviteExample.Criteria andValidLessThan(Integer value) {
            return lessThan(valid, value);
        }

        public MemberInviteExample.Criteria andValidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(valid, value);
        }

        public MemberInviteExample.Criteria andValidIn(List<Integer> values) {
            return in(valid, values);
        }

        public MemberInviteExample.Criteria andValidNotIn(List<Integer> values) {
            return notIn(valid, values);
        }

        public MemberInviteExample.Criteria andValidBetween(Integer value1, Integer value2) {
            return between(valid, value1, value2);
        }

        public MemberInviteExample.Criteria andValidNotBetween(Integer value1, Integer value2) {
            return notBetween(valid, value1, value2);
        }
        public MemberInviteExample.Criteria andInviteUserIdIsNull() {
            return isNull(inviteUserId);
        }

        public MemberInviteExample.Criteria andInviteUserIdIsNotNull() {
            return isNotNull(inviteUserId);
        }

        public MemberInviteExample.Criteria andInviteUserIdEqualTo(Long value) {
            return equalTo(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdNotEqualTo(Long value) {
            return notEqualTo(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdGreaterThan(Long value) {
            return greaterThan(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdLessThan(Long value) {
            return lessThan(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(inviteUserId, value);
        }

        public MemberInviteExample.Criteria andInviteUserIdIn(List<Long> values) {
            return in(inviteUserId, values);
        }

        public MemberInviteExample.Criteria andInviteUserIdNotIn(List<Long> values) {
            return notIn(inviteUserId, values);
        }

        public MemberInviteExample.Criteria andInviteUserIdBetween(Long value1, Long value2) {
            return between(inviteUserId, value1, value2);
        }

        public MemberInviteExample.Criteria andInviteUserIdNotBetween(Long value1, Long value2) {
            return notBetween(inviteUserId, value1, value2);
        }
        public MemberInviteExample.Criteria andInviteIdIsNull() {
            return isNull(inviteId);
        }

        public MemberInviteExample.Criteria andInviteIdIsNotNull() {
            return isNotNull(inviteId);
        }

        public MemberInviteExample.Criteria andInviteIdEqualTo(Long value) {
            return equalTo(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdNotEqualTo(Long value) {
            return notEqualTo(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdGreaterThan(Long value) {
            return greaterThan(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdLessThan(Long value) {
            return lessThan(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(inviteId, value);
        }

        public MemberInviteExample.Criteria andInviteIdIn(List<Long> values) {
            return in(inviteId, values);
        }

        public MemberInviteExample.Criteria andInviteIdNotIn(List<Long> values) {
            return notIn(inviteId, values);
        }

        public MemberInviteExample.Criteria andInviteIdBetween(Long value1, Long value2) {
            return between(inviteId, value1, value2);
        }

        public MemberInviteExample.Criteria andInviteIdNotBetween(Long value1, Long value2) {
            return notBetween(inviteId, value1, value2);
        }
        public MemberInviteExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberInviteExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberInviteExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberInviteExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberInviteExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberInviteExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberInviteExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberInviteExample.Criteria andInviteCreateTimeIsNull() {
            return isNull(inviteCreateTime);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeIsNotNull() {
            return isNotNull(inviteCreateTime);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeEqualTo(Date value) {
            return equalTo(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeNotEqualTo(Date value) {
            return notEqualTo(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeGreaterThan(Date value) {
            return greaterThan(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeLessThan(Date value) {
            return lessThan(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(inviteCreateTime, value);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeIn(List<Date> values) {
            return in(inviteCreateTime, values);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeNotIn(List<Date> values) {
            return notIn(inviteCreateTime, values);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeBetween(Date value1, Date value2) {
            return between(inviteCreateTime, value1, value2);
        }

        public MemberInviteExample.Criteria andInviteCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(inviteCreateTime, value1, value2);
        }
    }
}