package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.UidOutIdReference;

import java.util.*;
public class UidOutIdReferenceExample extends SgExample<UidOutIdReferenceExample.Criteria> {
    public static final Class<UidOutIdReference> beanClass = UidOutIdReference.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn uid;
    public static EntityColumn gmtModify;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        uid = listMap.get("uid");
        gmtModify = listMap.get("gmtModify");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        }

    public UidOutIdReferenceExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected UidOutIdReferenceExample.Criteria createCriteriaInternal() {
        return new UidOutIdReferenceExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public UidOutIdReferenceExample.Criteria andUidIsNull() {
            return isNull(uid);
        }

        public UidOutIdReferenceExample.Criteria andUidIsNotNull() {
            return isNotNull(uid);
        }

        public UidOutIdReferenceExample.Criteria andUidEqualTo(Long value) {
            return equalTo(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidNotEqualTo(Long value) {
            return notEqualTo(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidGreaterThan(Long value) {
            return greaterThan(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidLessThan(Long value) {
            return lessThan(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(uid, value);
        }

        public UidOutIdReferenceExample.Criteria andUidIn(List<Long> values) {
            return in(uid, values);
        }

        public UidOutIdReferenceExample.Criteria andUidNotIn(List<Long> values) {
            return notIn(uid, values);
        }

        public UidOutIdReferenceExample.Criteria andUidBetween(Long value1, Long value2) {
            return between(uid, value1, value2);
        }

        public UidOutIdReferenceExample.Criteria andUidNotBetween(Long value1, Long value2) {
            return notBetween(uid, value1, value2);
        }
        public UidOutIdReferenceExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public UidOutIdReferenceExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public UidOutIdReferenceExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public UidOutIdReferenceExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public UidOutIdReferenceExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public UidOutIdReferenceExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public UidOutIdReferenceExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public UidOutIdReferenceExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public UidOutIdReferenceExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public UidOutIdReferenceExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public UidOutIdReferenceExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
    }
}