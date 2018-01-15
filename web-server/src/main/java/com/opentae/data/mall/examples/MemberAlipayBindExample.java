package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberAlipayBind;

import java.util.*;
public class MemberAlipayBindExample extends SgExample<MemberAlipayBindExample.Criteria> {
    public static final Class<MemberAlipayBind> beanClass = MemberAlipayBind.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModify;
    public static EntityColumn alipayName;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn userId;
    public static EntityColumn alipayId;
    public static EntityColumn isFailure;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModify = listMap.get("gmtModify");
        alipayName = listMap.get("alipayName");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        userId = listMap.get("userId");
        alipayId = listMap.get("alipayId");
        isFailure = listMap.get("isFailure");
        }

    public MemberAlipayBindExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberAlipayBindExample.Criteria createCriteriaInternal() {
        return new MemberAlipayBindExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andAlipayNameIsNull() {
            return isNull(alipayName);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameIsNotNull() {
            return isNotNull(alipayName);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameEqualTo(String value) {
            return equalTo(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameNotEqualTo(String value) {
            return notEqualTo(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameGreaterThan(String value) {
            return greaterThan(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameLessThan(String value) {
            return lessThan(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameLike(String value) {
            return like(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameNotLike(String value) {
            return notLike(alipayName, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameIn(List<String> values) {
            return in(alipayName, values);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameNotIn(List<String> values) {
            return notIn(alipayName, values);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameBetween(String value1, String value2) {
            return between(alipayName, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andAlipayNameNotBetween(String value1, String value2) {
            return notBetween(alipayName, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public MemberAlipayBindExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public MemberAlipayBindExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public MemberAlipayBindExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public MemberAlipayBindExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public MemberAlipayBindExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberAlipayBindExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberAlipayBindExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberAlipayBindExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberAlipayBindExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberAlipayBindExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andAlipayIdIsNull() {
            return isNull(alipayId);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdIsNotNull() {
            return isNotNull(alipayId);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdEqualTo(String value) {
            return equalTo(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdNotEqualTo(String value) {
            return notEqualTo(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdGreaterThan(String value) {
            return greaterThan(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdLessThan(String value) {
            return lessThan(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdLike(String value) {
            return like(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdNotLike(String value) {
            return notLike(alipayId, value);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdIn(List<String> values) {
            return in(alipayId, values);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdNotIn(List<String> values) {
            return notIn(alipayId, values);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdBetween(String value1, String value2) {
            return between(alipayId, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andAlipayIdNotBetween(String value1, String value2) {
            return notBetween(alipayId, value1, value2);
        }
        public MemberAlipayBindExample.Criteria andIsFailureIsNull() {
            return isNull(isFailure);
        }

        public MemberAlipayBindExample.Criteria andIsFailureIsNotNull() {
            return isNotNull(isFailure);
        }

        public MemberAlipayBindExample.Criteria andIsFailureEqualTo(Boolean value) {
            return equalTo(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureNotEqualTo(Boolean value) {
            return notEqualTo(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureGreaterThan(Boolean value) {
            return greaterThan(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureLessThan(Boolean value) {
            return lessThan(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isFailure, value);
        }

        public MemberAlipayBindExample.Criteria andIsFailureIn(List<Boolean> values) {
            return in(isFailure, values);
        }

        public MemberAlipayBindExample.Criteria andIsFailureNotIn(List<Boolean> values) {
            return notIn(isFailure, values);
        }

        public MemberAlipayBindExample.Criteria andIsFailureBetween(Boolean value1, Boolean value2) {
            return between(isFailure, value1, value2);
        }

        public MemberAlipayBindExample.Criteria andIsFailureNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isFailure, value1, value2);
        }
    }
}