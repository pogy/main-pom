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
    protected TsysRoleExample.Criteria createCriteriaInternal() {
        return new TsysRoleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TsysRoleExample.Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public TsysRoleExample.Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public TsysRoleExample.Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public TsysRoleExample.Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public TsysRoleExample.Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public TsysRoleExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public TsysRoleExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
        }
        public TsysRoleExample.Criteria andRoleNameIsNull() {
            return isNull(roleName);
        }

        public TsysRoleExample.Criteria andRoleNameIsNotNull() {
            return isNotNull(roleName);
        }

        public TsysRoleExample.Criteria andRoleNameEqualTo(String value) {
            return equalTo(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameNotEqualTo(String value) {
            return notEqualTo(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameGreaterThan(String value) {
            return greaterThan(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameLessThan(String value) {
            return lessThan(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameLike(String value) {
            return like(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameNotLike(String value) {
            return notLike(roleName, value);
        }

        public TsysRoleExample.Criteria andRoleNameIn(List<String> values) {
            return in(roleName, values);
        }

        public TsysRoleExample.Criteria andRoleNameNotIn(List<String> values) {
            return notIn(roleName, values);
        }

        public TsysRoleExample.Criteria andRoleNameBetween(String value1, String value2) {
            return between(roleName, value1, value2);
        }

        public TsysRoleExample.Criteria andRoleNameNotBetween(String value1, String value2) {
            return notBetween(roleName, value1, value2);
        }
        public TsysRoleExample.Criteria andRoleTagIsNull() {
            return isNull(roleTag);
        }

        public TsysRoleExample.Criteria andRoleTagIsNotNull() {
            return isNotNull(roleTag);
        }

        public TsysRoleExample.Criteria andRoleTagEqualTo(String value) {
            return equalTo(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagNotEqualTo(String value) {
            return notEqualTo(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagGreaterThan(String value) {
            return greaterThan(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagLessThan(String value) {
            return lessThan(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagLike(String value) {
            return like(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagNotLike(String value) {
            return notLike(roleTag, value);
        }

        public TsysRoleExample.Criteria andRoleTagIn(List<String> values) {
            return in(roleTag, values);
        }

        public TsysRoleExample.Criteria andRoleTagNotIn(List<String> values) {
            return notIn(roleTag, values);
        }

        public TsysRoleExample.Criteria andRoleTagBetween(String value1, String value2) {
            return between(roleTag, value1, value2);
        }

        public TsysRoleExample.Criteria andRoleTagNotBetween(String value1, String value2) {
            return notBetween(roleTag, value1, value2);
        }
        public TsysRoleExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public TsysRoleExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public TsysRoleExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public TsysRoleExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public TsysRoleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public TsysRoleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public TsysRoleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public TsysRoleExample.Criteria andRoleCommentIsNull() {
            return isNull(roleComment);
        }

        public TsysRoleExample.Criteria andRoleCommentIsNotNull() {
            return isNotNull(roleComment);
        }

        public TsysRoleExample.Criteria andRoleCommentEqualTo(String value) {
            return equalTo(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentNotEqualTo(String value) {
            return notEqualTo(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentGreaterThan(String value) {
            return greaterThan(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentLessThan(String value) {
            return lessThan(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentLike(String value) {
            return like(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentNotLike(String value) {
            return notLike(roleComment, value);
        }

        public TsysRoleExample.Criteria andRoleCommentIn(List<String> values) {
            return in(roleComment, values);
        }

        public TsysRoleExample.Criteria andRoleCommentNotIn(List<String> values) {
            return notIn(roleComment, values);
        }

        public TsysRoleExample.Criteria andRoleCommentBetween(String value1, String value2) {
            return between(roleComment, value1, value2);
        }

        public TsysRoleExample.Criteria andRoleCommentNotBetween(String value1, String value2) {
            return notBetween(roleComment, value1, value2);
        }
        public TsysRoleExample.Criteria andCreateUserIdIsNull() {
            return isNull(createUserId);
        }

        public TsysRoleExample.Criteria andCreateUserIdIsNotNull() {
            return isNotNull(createUserId);
        }

        public TsysRoleExample.Criteria andCreateUserIdEqualTo(Long value) {
            return equalTo(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdNotEqualTo(Long value) {
            return notEqualTo(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdGreaterThan(Long value) {
            return greaterThan(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdLessThan(Long value) {
            return lessThan(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(createUserId, value);
        }

        public TsysRoleExample.Criteria andCreateUserIdIn(List<Long> values) {
            return in(createUserId, values);
        }

        public TsysRoleExample.Criteria andCreateUserIdNotIn(List<Long> values) {
            return notIn(createUserId, values);
        }

        public TsysRoleExample.Criteria andCreateUserIdBetween(Long value1, Long value2) {
            return between(createUserId, value1, value2);
        }

        public TsysRoleExample.Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            return notBetween(createUserId, value1, value2);
        }
        public TsysRoleExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public TsysRoleExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public TsysRoleExample.Criteria andStatusEqualTo(Long value) {
            return equalTo(status, value);
        }

        public TsysRoleExample.Criteria andStatusNotEqualTo(Long value) {
            return notEqualTo(status, value);
        }

        public TsysRoleExample.Criteria andStatusGreaterThan(Long value) {
            return greaterThan(status, value);
        }

        public TsysRoleExample.Criteria andStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(status, value);
        }

        public TsysRoleExample.Criteria andStatusLessThan(Long value) {
            return lessThan(status, value);
        }

        public TsysRoleExample.Criteria andStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(status, value);
        }

        public TsysRoleExample.Criteria andStatusIn(List<Long> values) {
            return in(status, values);
        }

        public TsysRoleExample.Criteria andStatusNotIn(List<Long> values) {
            return notIn(status, values);
        }

        public TsysRoleExample.Criteria andStatusBetween(Long value1, Long value2) {
            return between(status, value1, value2);
        }

        public TsysRoleExample.Criteria andStatusNotBetween(Long value1, Long value2) {
            return notBetween(status, value1, value2);
        }
        public TsysRoleExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TsysRoleExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TsysRoleExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TsysRoleExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TsysRoleExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TsysRoleExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TsysRoleExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TsysRoleExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TsysRoleExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TsysRoleExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TsysRoleExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TsysRoleExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TsysRoleExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TsysRoleExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}