package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.TsysRole;

import java.util.*;
public class TsysRoleExample extends SgExample<TsysRoleExample.Criteria> {
    public static final Class<TsysRole> beanClass = TsysRole.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn roleId;
    public static EntityColumn roleName;
    public static EntityColumn roleTag;
    public static EntityColumn createTime;
    public static EntityColumn roleComment;
    public static EntityColumn createUserId;
    public static EntityColumn status;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        roleId = listMap.get("roleId");
        roleName = listMap.get("roleName");
        roleTag = listMap.get("roleTag");
        createTime = listMap.get("createTime");
        roleComment = listMap.get("roleComment");
        createUserId = listMap.get("createUserId");
        status = listMap.get("status");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
    }

    public TsysRoleExample() {
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
        public Criteria andRoleNameIsNull() {
            return isNull(roleName);
        }

        public Criteria andRoleNameIsNotNull() {
            return isNotNull(roleName);
        }

        public Criteria andRoleNameEqualTo(String value) {
            return equalTo(roleName, value);
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            return notEqualTo(roleName, value);
        }

        public Criteria andRoleNameGreaterThan(String value) {
            return greaterThan(roleName, value);
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleName, value);
        }

        public Criteria andRoleNameLessThan(String value) {
            return lessThan(roleName, value);
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleName, value);
        }

        public Criteria andRoleNameLike(String value) {
            return like(roleName, value);
        }

        public Criteria andRoleNameNotLike(String value) {
            return notLike(roleName, value);
        }

        public Criteria andRoleNameIn(List<String> values) {
            return in(roleName, values);
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            return notIn(roleName, values);
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            return between(roleName, value1, value2);
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            return notBetween(roleName, value1, value2);
        }
        public Criteria andRoleTagIsNull() {
            return isNull(roleTag);
        }

        public Criteria andRoleTagIsNotNull() {
            return isNotNull(roleTag);
        }

        public Criteria andRoleTagEqualTo(String value) {
            return equalTo(roleTag, value);
        }

        public Criteria andRoleTagNotEqualTo(String value) {
            return notEqualTo(roleTag, value);
        }

        public Criteria andRoleTagGreaterThan(String value) {
            return greaterThan(roleTag, value);
        }

        public Criteria andRoleTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleTag, value);
        }

        public Criteria andRoleTagLessThan(String value) {
            return lessThan(roleTag, value);
        }

        public Criteria andRoleTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleTag, value);
        }

        public Criteria andRoleTagLike(String value) {
            return like(roleTag, value);
        }

        public Criteria andRoleTagNotLike(String value) {
            return notLike(roleTag, value);
        }

        public Criteria andRoleTagIn(List<String> values) {
            return in(roleTag, values);
        }

        public Criteria andRoleTagNotIn(List<String> values) {
            return notIn(roleTag, values);
        }

        public Criteria andRoleTagBetween(String value1, String value2) {
            return between(roleTag, value1, value2);
        }

        public Criteria andRoleTagNotBetween(String value1, String value2) {
            return notBetween(roleTag, value1, value2);
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
        public Criteria andRoleCommentIsNull() {
            return isNull(roleComment);
        }

        public Criteria andRoleCommentIsNotNull() {
            return isNotNull(roleComment);
        }

        public Criteria andRoleCommentEqualTo(String value) {
            return equalTo(roleComment, value);
        }

        public Criteria andRoleCommentNotEqualTo(String value) {
            return notEqualTo(roleComment, value);
        }

        public Criteria andRoleCommentGreaterThan(String value) {
            return greaterThan(roleComment, value);
        }

        public Criteria andRoleCommentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleComment, value);
        }

        public Criteria andRoleCommentLessThan(String value) {
            return lessThan(roleComment, value);
        }

        public Criteria andRoleCommentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleComment, value);
        }

        public Criteria andRoleCommentLike(String value) {
            return like(roleComment, value);
        }

        public Criteria andRoleCommentNotLike(String value) {
            return notLike(roleComment, value);
        }

        public Criteria andRoleCommentIn(List<String> values) {
            return in(roleComment, values);
        }

        public Criteria andRoleCommentNotIn(List<String> values) {
            return notIn(roleComment, values);
        }

        public Criteria andRoleCommentBetween(String value1, String value2) {
            return between(roleComment, value1, value2);
        }

        public Criteria andRoleCommentNotBetween(String value1, String value2) {
            return notBetween(roleComment, value1, value2);
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
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}