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
    protected TsysRolePermissionExample.Criteria createCriteriaInternal() {
        return new TsysRolePermissionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdIsNull() {
            return isNull(rolePermissionId);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdIsNotNull() {
            return isNotNull(rolePermissionId);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdEqualTo(Long value) {
            return equalTo(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdNotEqualTo(Long value) {
            return notEqualTo(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdGreaterThan(Long value) {
            return greaterThan(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdLessThan(Long value) {
            return lessThan(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rolePermissionId, value);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdIn(List<Long> values) {
            return in(rolePermissionId, values);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdNotIn(List<Long> values) {
            return notIn(rolePermissionId, values);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdBetween(Long value1, Long value2) {
            return between(rolePermissionId, value1, value2);
        }

        public TsysRolePermissionExample.Criteria andRolePermissionIdNotBetween(Long value1, Long value2) {
            return notBetween(rolePermissionId, value1, value2);
        }
        public TsysRolePermissionExample.Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public TsysRolePermissionExample.Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public TsysRolePermissionExample.Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public TsysRolePermissionExample.Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public TsysRolePermissionExample.Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public TsysRolePermissionExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public TsysRolePermissionExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
        }
        public TsysRolePermissionExample.Criteria andPermissionIdIsNull() {
            return isNull(permissionId);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdIsNotNull() {
            return isNotNull(permissionId);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdEqualTo(Long value) {
            return equalTo(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdNotEqualTo(Long value) {
            return notEqualTo(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdGreaterThan(Long value) {
            return greaterThan(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdLessThan(Long value) {
            return lessThan(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(permissionId, value);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdIn(List<Long> values) {
            return in(permissionId, values);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdNotIn(List<Long> values) {
            return notIn(permissionId, values);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdBetween(Long value1, Long value2) {
            return between(permissionId, value1, value2);
        }

        public TsysRolePermissionExample.Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            return notBetween(permissionId, value1, value2);
        }
        public TsysRolePermissionExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public TsysRolePermissionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public TsysRolePermissionExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public TsysRolePermissionExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
    }
}