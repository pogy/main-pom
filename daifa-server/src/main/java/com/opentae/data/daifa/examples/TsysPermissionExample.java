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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
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
        public Criteria andNamespaceIsNull() {
            return isNull(namespace);
        }

        public Criteria andNamespaceIsNotNull() {
            return isNotNull(namespace);
        }

        public Criteria andNamespaceEqualTo(String value) {
            return equalTo(namespace, value);
        }

        public Criteria andNamespaceNotEqualTo(String value) {
            return notEqualTo(namespace, value);
        }

        public Criteria andNamespaceGreaterThan(String value) {
            return greaterThan(namespace, value);
        }

        public Criteria andNamespaceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(namespace, value);
        }

        public Criteria andNamespaceLessThan(String value) {
            return lessThan(namespace, value);
        }

        public Criteria andNamespaceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(namespace, value);
        }

        public Criteria andNamespaceLike(String value) {
            return like(namespace, value);
        }

        public Criteria andNamespaceNotLike(String value) {
            return notLike(namespace, value);
        }

        public Criteria andNamespaceIn(List<String> values) {
            return in(namespace, values);
        }

        public Criteria andNamespaceNotIn(List<String> values) {
            return notIn(namespace, values);
        }

        public Criteria andNamespaceBetween(String value1, String value2) {
            return between(namespace, value1, value2);
        }

        public Criteria andNamespaceNotBetween(String value1, String value2) {
            return notBetween(namespace, value1, value2);
        }
        public Criteria andPermissionTagIsNull() {
            return isNull(permissionTag);
        }

        public Criteria andPermissionTagIsNotNull() {
            return isNotNull(permissionTag);
        }

        public Criteria andPermissionTagEqualTo(String value) {
            return equalTo(permissionTag, value);
        }

        public Criteria andPermissionTagNotEqualTo(String value) {
            return notEqualTo(permissionTag, value);
        }

        public Criteria andPermissionTagGreaterThan(String value) {
            return greaterThan(permissionTag, value);
        }

        public Criteria andPermissionTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(permissionTag, value);
        }

        public Criteria andPermissionTagLessThan(String value) {
            return lessThan(permissionTag, value);
        }

        public Criteria andPermissionTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(permissionTag, value);
        }

        public Criteria andPermissionTagLike(String value) {
            return like(permissionTag, value);
        }

        public Criteria andPermissionTagNotLike(String value) {
            return notLike(permissionTag, value);
        }

        public Criteria andPermissionTagIn(List<String> values) {
            return in(permissionTag, values);
        }

        public Criteria andPermissionTagNotIn(List<String> values) {
            return notIn(permissionTag, values);
        }

        public Criteria andPermissionTagBetween(String value1, String value2) {
            return between(permissionTag, value1, value2);
        }

        public Criteria andPermissionTagNotBetween(String value1, String value2) {
            return notBetween(permissionTag, value1, value2);
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
        public Criteria andCreateUserIdIsNull() {
            return isNull(createUserId);
        }

        public Criteria andCreateUserIdIsNotNull() {
            return isNotNull(createUserId);
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            return equalTo(createUserId, value);
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            return notEqualTo(createUserId, value);
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            return greaterThan(createUserId, value);
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(createUserId, value);
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            return lessThan(createUserId, value);
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(createUserId, value);
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            return in(createUserId, values);
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            return notIn(createUserId, values);
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            return between(createUserId, value1, value2);
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            return notBetween(createUserId, value1, value2);
        }
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(Long value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(Long value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(Long value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(Long value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusIn(List<Long> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<Long> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(Long value1, Long value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(Long value1, Long value2) {
            return notBetween(status, value1, value2);
        }
        public Criteria andPermissionCommentIsNull() {
            return isNull(permissionComment);
        }

        public Criteria andPermissionCommentIsNotNull() {
            return isNotNull(permissionComment);
        }

        public Criteria andPermissionCommentEqualTo(String value) {
            return equalTo(permissionComment, value);
        }

        public Criteria andPermissionCommentNotEqualTo(String value) {
            return notEqualTo(permissionComment, value);
        }

        public Criteria andPermissionCommentGreaterThan(String value) {
            return greaterThan(permissionComment, value);
        }

        public Criteria andPermissionCommentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(permissionComment, value);
        }

        public Criteria andPermissionCommentLessThan(String value) {
            return lessThan(permissionComment, value);
        }

        public Criteria andPermissionCommentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(permissionComment, value);
        }

        public Criteria andPermissionCommentLike(String value) {
            return like(permissionComment, value);
        }

        public Criteria andPermissionCommentNotLike(String value) {
            return notLike(permissionComment, value);
        }

        public Criteria andPermissionCommentIn(List<String> values) {
            return in(permissionComment, values);
        }

        public Criteria andPermissionCommentNotIn(List<String> values) {
            return notIn(permissionComment, values);
        }

        public Criteria andPermissionCommentBetween(String value1, String value2) {
            return between(permissionComment, value1, value2);
        }

        public Criteria andPermissionCommentNotBetween(String value1, String value2) {
            return notBetween(permissionComment, value1, value2);
        }
        public Criteria andParentPidIsNull() {
            return isNull(parentPid);
        }

        public Criteria andParentPidIsNotNull() {
            return isNotNull(parentPid);
        }

        public Criteria andParentPidEqualTo(Long value) {
            return equalTo(parentPid, value);
        }

        public Criteria andParentPidNotEqualTo(Long value) {
            return notEqualTo(parentPid, value);
        }

        public Criteria andParentPidGreaterThan(Long value) {
            return greaterThan(parentPid, value);
        }

        public Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentPid, value);
        }

        public Criteria andParentPidLessThan(Long value) {
            return lessThan(parentPid, value);
        }

        public Criteria andParentPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentPid, value);
        }

        public Criteria andParentPidIn(List<Long> values) {
            return in(parentPid, values);
        }

        public Criteria andParentPidNotIn(List<Long> values) {
            return notIn(parentPid, values);
        }

        public Criteria andParentPidBetween(Long value1, Long value2) {
            return between(parentPid, value1, value2);
        }

        public Criteria andParentPidNotBetween(Long value1, Long value2) {
            return notBetween(parentPid, value1, value2);
        }
    }
}