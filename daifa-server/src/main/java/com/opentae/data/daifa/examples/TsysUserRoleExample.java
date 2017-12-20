package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.TsysUserRole;

import java.util.*;
public class TsysUserRoleExample extends SgExample<TsysUserRoleExample.Criteria> {
    public static final Class<TsysUserRole> beanClass = TsysUserRole.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn userRoleId;
    public static EntityColumn userId;
    public static EntityColumn roleId;
    public static EntityColumn createTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        userRoleId = listMap.get("userRoleId");
        userId = listMap.get("userId");
        roleId = listMap.get("roleId");
        createTime = listMap.get("createTime");
    }

    public TsysUserRoleExample() {
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

        public Criteria andUserRoleIdIsNull() {
            return isNull(userRoleId);
        }

        public Criteria andUserRoleIdIsNotNull() {
            return isNotNull(userRoleId);
        }

        public Criteria andUserRoleIdEqualTo(Long value) {
            return equalTo(userRoleId, value);
        }

        public Criteria andUserRoleIdNotEqualTo(Long value) {
            return notEqualTo(userRoleId, value);
        }

        public Criteria andUserRoleIdGreaterThan(Long value) {
            return greaterThan(userRoleId, value);
        }

        public Criteria andUserRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userRoleId, value);
        }

        public Criteria andUserRoleIdLessThan(Long value) {
            return lessThan(userRoleId, value);
        }

        public Criteria andUserRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userRoleId, value);
        }

        public Criteria andUserRoleIdIn(List<Long> values) {
            return in(userRoleId, values);
        }

        public Criteria andUserRoleIdNotIn(List<Long> values) {
            return notIn(userRoleId, values);
        }

        public Criteria andUserRoleIdBetween(Long value1, Long value2) {
            return between(userRoleId, value1, value2);
        }

        public Criteria andUserRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(userRoleId, value1, value2);
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
        public Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
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
    }
}