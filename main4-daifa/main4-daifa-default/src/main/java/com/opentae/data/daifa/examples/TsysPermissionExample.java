package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.TsysPermission;

import java.util.*;
public class TsysPermissionExample extends SgExample<TsysPermissionExample.Criteria> {
    public static final Class<TsysPermission> beanClass = TsysPermission.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn permissionId;
    public static EntityColumn namespace;
    public static EntityColumn permissionTag;
    public static EntityColumn createTime;
    public static EntityColumn createUserId;
    public static EntityColumn status;
    public static EntityColumn permissionComment;
    public static EntityColumn parentPid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        permissionId = listMap.get("permissionId");
        namespace = listMap.get("namespace");
        permissionTag = listMap.get("permissionTag");
        createTime = listMap.get("createTime");
        createUserId = listMap.get("createUserId");
        status = listMap.get("status");
        permissionComment = listMap.get("permissionComment");
        parentPid = listMap.get("parentPid");
    }

    public TsysPermissionExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TsysPermissionExample.Criteria createCriteriaInternal() {
        return new TsysPermissionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TsysPermissionExample.Criteria andPermissionIdIsNull() {
            return isNull(permissionId);
        }

        public TsysPermissionExample.Criteria andPermissionIdIsNotNull() {
            return isNotNull(permissionId);
        }

        public TsysPermissionExample.Criteria andPermissionIdEqualTo(Long value) {
            return equalTo(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdNotEqualTo(Long value) {
            return notEqualTo(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdGreaterThan(Long value) {
            return greaterThan(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdLessThan(Long value) {
            return lessThan(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(permissionId, value);
        }

        public TsysPermissionExample.Criteria andPermissionIdIn(List<Long> values) {
            return in(permissionId, values);
        }

        public TsysPermissionExample.Criteria andPermissionIdNotIn(List<Long> values) {
            return notIn(permissionId, values);
        }

        public TsysPermissionExample.Criteria andPermissionIdBetween(Long value1, Long value2) {
            return between(permissionId, value1, value2);
        }

        public TsysPermissionExample.Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            return notBetween(permissionId, value1, value2);
        }
        public TsysPermissionExample.Criteria andNamespaceIsNull() {
            return isNull(namespace);
        }

        public TsysPermissionExample.Criteria andNamespaceIsNotNull() {
            return isNotNull(namespace);
        }

        public TsysPermissionExample.Criteria andNamespaceEqualTo(String value) {
            return equalTo(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceNotEqualTo(String value) {
            return notEqualTo(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceGreaterThan(String value) {
            return greaterThan(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceLessThan(String value) {
            return lessThan(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceLike(String value) {
            return like(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceNotLike(String value) {
            return notLike(namespace, value);
        }

        public TsysPermissionExample.Criteria andNamespaceIn(List<String> values) {
            return in(namespace, values);
        }

        public TsysPermissionExample.Criteria andNamespaceNotIn(List<String> values) {
            return notIn(namespace, values);
        }

        public TsysPermissionExample.Criteria andNamespaceBetween(String value1, String value2) {
            return between(namespace, value1, value2);
        }

        public TsysPermissionExample.Criteria andNamespaceNotBetween(String value1, String value2) {
            return notBetween(namespace, value1, value2);
        }
        public TsysPermissionExample.Criteria andPermissionTagIsNull() {
            return isNull(permissionTag);
        }

        public TsysPermissionExample.Criteria andPermissionTagIsNotNull() {
            return isNotNull(permissionTag);
        }

        public TsysPermissionExample.Criteria andPermissionTagEqualTo(String value) {
            return equalTo(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagNotEqualTo(String value) {
            return notEqualTo(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagGreaterThan(String value) {
            return greaterThan(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagLessThan(String value) {
            return lessThan(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagLike(String value) {
            return like(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagNotLike(String value) {
            return notLike(permissionTag, value);
        }

        public TsysPermissionExample.Criteria andPermissionTagIn(List<String> values) {
            return in(permissionTag, values);
        }

        public TsysPermissionExample.Criteria andPermissionTagNotIn(List<String> values) {
            return notIn(permissionTag, values);
        }

        public TsysPermissionExample.Criteria andPermissionTagBetween(String value1, String value2) {
            return between(permissionTag, value1, value2);
        }

        public TsysPermissionExample.Criteria andPermissionTagNotBetween(String value1, String value2) {
            return notBetween(permissionTag, value1, value2);
        }
        public TsysPermissionExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public TsysPermissionExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public TsysPermissionExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public TsysPermissionExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public TsysPermissionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public TsysPermissionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public TsysPermissionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public TsysPermissionExample.Criteria andCreateUserIdIsNull() {
            return isNull(createUserId);
        }

        public TsysPermissionExample.Criteria andCreateUserIdIsNotNull() {
            return isNotNull(createUserId);
        }

        public TsysPermissionExample.Criteria andCreateUserIdEqualTo(Long value) {
            return equalTo(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdNotEqualTo(Long value) {
            return notEqualTo(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdGreaterThan(Long value) {
            return greaterThan(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdLessThan(Long value) {
            return lessThan(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(createUserId, value);
        }

        public TsysPermissionExample.Criteria andCreateUserIdIn(List<Long> values) {
            return in(createUserId, values);
        }

        public TsysPermissionExample.Criteria andCreateUserIdNotIn(List<Long> values) {
            return notIn(createUserId, values);
        }

        public TsysPermissionExample.Criteria andCreateUserIdBetween(Long value1, Long value2) {
            return between(createUserId, value1, value2);
        }

        public TsysPermissionExample.Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            return notBetween(createUserId, value1, value2);
        }
        public TsysPermissionExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public TsysPermissionExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public TsysPermissionExample.Criteria andStatusEqualTo(Long value) {
            return equalTo(status, value);
        }

        public TsysPermissionExample.Criteria andStatusNotEqualTo(Long value) {
            return notEqualTo(status, value);
        }

        public TsysPermissionExample.Criteria andStatusGreaterThan(Long value) {
            return greaterThan(status, value);
        }

        public TsysPermissionExample.Criteria andStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(status, value);
        }

        public TsysPermissionExample.Criteria andStatusLessThan(Long value) {
            return lessThan(status, value);
        }

        public TsysPermissionExample.Criteria andStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(status, value);
        }

        public TsysPermissionExample.Criteria andStatusIn(List<Long> values) {
            return in(status, values);
        }

        public TsysPermissionExample.Criteria andStatusNotIn(List<Long> values) {
            return notIn(status, values);
        }

        public TsysPermissionExample.Criteria andStatusBetween(Long value1, Long value2) {
            return between(status, value1, value2);
        }

        public TsysPermissionExample.Criteria andStatusNotBetween(Long value1, Long value2) {
            return notBetween(status, value1, value2);
        }
        public TsysPermissionExample.Criteria andPermissionCommentIsNull() {
            return isNull(permissionComment);
        }

        public TsysPermissionExample.Criteria andPermissionCommentIsNotNull() {
            return isNotNull(permissionComment);
        }

        public TsysPermissionExample.Criteria andPermissionCommentEqualTo(String value) {
            return equalTo(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentNotEqualTo(String value) {
            return notEqualTo(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentGreaterThan(String value) {
            return greaterThan(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentLessThan(String value) {
            return lessThan(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentLike(String value) {
            return like(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentNotLike(String value) {
            return notLike(permissionComment, value);
        }

        public TsysPermissionExample.Criteria andPermissionCommentIn(List<String> values) {
            return in(permissionComment, values);
        }

        public TsysPermissionExample.Criteria andPermissionCommentNotIn(List<String> values) {
            return notIn(permissionComment, values);
        }

        public TsysPermissionExample.Criteria andPermissionCommentBetween(String value1, String value2) {
            return between(permissionComment, value1, value2);
        }

        public TsysPermissionExample.Criteria andPermissionCommentNotBetween(String value1, String value2) {
            return notBetween(permissionComment, value1, value2);
        }
        public TsysPermissionExample.Criteria andParentPidIsNull() {
            return isNull(parentPid);
        }

        public TsysPermissionExample.Criteria andParentPidIsNotNull() {
            return isNotNull(parentPid);
        }

        public TsysPermissionExample.Criteria andParentPidEqualTo(Long value) {
            return equalTo(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidNotEqualTo(Long value) {
            return notEqualTo(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidGreaterThan(Long value) {
            return greaterThan(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidLessThan(Long value) {
            return lessThan(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentPid, value);
        }

        public TsysPermissionExample.Criteria andParentPidIn(List<Long> values) {
            return in(parentPid, values);
        }

        public TsysPermissionExample.Criteria andParentPidNotIn(List<Long> values) {
            return notIn(parentPid, values);
        }

        public TsysPermissionExample.Criteria andParentPidBetween(Long value1, Long value2) {
            return between(parentPid, value1, value2);
        }

        public TsysPermissionExample.Criteria andParentPidNotBetween(Long value1, Long value2) {
            return notBetween(parentPid, value1, value2);
        }
    }
}