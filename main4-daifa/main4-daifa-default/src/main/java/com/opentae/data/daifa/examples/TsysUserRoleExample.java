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
    protected TsysUserRoleExample.Criteria createCriteriaInternal() {
        return new TsysUserRoleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdIsNull() {
            return isNull(userRoleId);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdIsNotNull() {
            return isNotNull(userRoleId);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdEqualTo(Long value) {
            return equalTo(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdNotEqualTo(Long value) {
            return notEqualTo(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdGreaterThan(Long value) {
            return greaterThan(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdLessThan(Long value) {
            return lessThan(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userRoleId, value);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdIn(List<Long> values) {
            return in(userRoleId, values);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdNotIn(List<Long> values) {
            return notIn(userRoleId, values);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdBetween(Long value1, Long value2) {
            return between(userRoleId, value1, value2);
        }

        public TsysUserRoleExample.Criteria andUserRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(userRoleId, value1, value2);
        }
        public TsysUserRoleExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public TsysUserRoleExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public TsysUserRoleExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public TsysUserRoleExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public TsysUserRoleExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public TsysUserRoleExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public TsysUserRoleExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public TsysUserRoleExample.Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public TsysUserRoleExample.Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public TsysUserRoleExample.Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public TsysUserRoleExample.Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public TsysUserRoleExample.Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public TsysUserRoleExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public TsysUserRoleExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
        }
        public TsysUserRoleExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public TsysUserRoleExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public TsysUserRoleExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public TsysUserRoleExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public TsysUserRoleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public TsysUserRoleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public TsysUserRoleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
    }
}