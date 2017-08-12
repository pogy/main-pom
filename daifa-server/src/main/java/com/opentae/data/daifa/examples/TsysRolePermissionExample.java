package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.TsysRolePermission;

import java.util.*;
public class TsysRolePermissionExample extends SgExample<TsysRolePermissionExample.Criteria> {
    public static final Class<TsysRolePermission> beanClass = TsysRolePermission.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn rolePermissionId;
    public static EntityColumn roleId;
    public static EntityColumn permissionId;
    public static EntityColumn createTime;
    public static EntityColumn lastModifyTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        rolePermissionId = listMap.get("rolePermissionId");
        roleId = listMap.get("roleId");
        permissionId = listMap.get("permissionId");
        createTime = listMap.get("createTime");
        lastModifyTime = listMap.get("lastModifyTime");
    }

    public TsysRolePermissionExample() {
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

        public Criteria andRolePermissionIdIsNull() {
            return isNull(rolePermissionId);
        }

        public Criteria andRolePermissionIdIsNotNull() {
            return isNotNull(rolePermissionId);
        }

        public Criteria andRolePermissionIdEqualTo(Long value) {
            return equalTo(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdNotEqualTo(Long value) {
            return notEqualTo(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdGreaterThan(Long value) {
            return greaterThan(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdLessThan(Long value) {
            return lessThan(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rolePermissionId, value);
        }

        public Criteria andRolePermissionIdIn(List<Long> values) {
            return in(rolePermissionId, values);
        }

        public Criteria andRolePermissionIdNotIn(List<Long> values) {
            return notIn(rolePermissionId, values);
        }

        public Criteria andRolePermissionIdBetween(Long value1, Long value2) {
            return between(rolePermissionId, value1, value2);
        }

        public Criteria andRolePermissionIdNotBetween(Long value1, Long value2) {
            return notBetween(rolePermissionId, value1, value2);
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
        public Criteria andPermissionIdIsNull() {
            return isNull(permissionId);
        }

        public Criteria andPermissionIdIsNotNull() {
            return isNotNull(permissionId);
        }

        public Criteria andPermissionIdEqualTo(Long value) {
            return equalTo(permissionId, value);
        }

        public Criteria andPermissionIdNotEqualTo(Long value) {
            return notEqualTo(permissionId, value);
        }

        public Criteria andPermissionIdGreaterThan(Long value) {
            return greaterThan(permissionId, value);
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(permissionId, value);
        }

        public Criteria andPermissionIdLessThan(Long value) {
            return lessThan(permissionId, value);
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(permissionId, value);
        }

        public Criteria andPermissionIdIn(List<Long> values) {
            return in(permissionId, values);
        }

        public Criteria andPermissionIdNotIn(List<Long> values) {
            return notIn(permissionId, values);
        }

        public Criteria andPermissionIdBetween(Long value1, Long value2) {
            return between(permissionId, value1, value2);
        }

        public Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            return notBetween(permissionId, value1, value2);
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
        public Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
    }
}