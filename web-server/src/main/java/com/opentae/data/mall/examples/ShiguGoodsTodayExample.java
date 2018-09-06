package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsToday;

import java.util.*;
public class ShiguGoodsTodayExample extends SgExample<ShiguGoodsTodayExample.Criteria> {
    public static final Class<ShiguGoodsToday> beanClass = ShiguGoodsToday.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn created;
    public static EntityColumn num;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        created = listMap.get("created");
        num = listMap.get("num");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        userId = listMap.get("userId");
        }

    public ShiguGoodsTodayExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsTodayExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsTodayExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedEqualTo(String value) {
            return equalTo(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedNotEqualTo(String value) {
            return notEqualTo(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedGreaterThan(String value) {
            return greaterThan(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedLessThan(String value) {
            return lessThan(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedLike(String value) {
            return like(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedNotLike(String value) {
            return notLike(created, value);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedIn(List<String> values) {
            return in(created, values);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedNotIn(List<String> values) {
            return notIn(created, values);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedBetween(String value1, String value2) {
            return between(created, value1, value2);
        }

        public ShiguGoodsTodayExample.Criteria andCreatedNotBetween(String value1, String value2) {
            return notBetween(created, value1, value2);
        }
        public ShiguGoodsTodayExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ShiguGoodsTodayExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ShiguGoodsTodayExample.Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public ShiguGoodsTodayExample.Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public ShiguGoodsTodayExample.Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public ShiguGoodsTodayExample.Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public ShiguGoodsTodayExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public ShiguGoodsTodayExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguGoodsTodayExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguGoodsTodayExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguGoodsTodayExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguGoodsTodayExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguGoodsTodayExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguGoodsTodayExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguGoodsTodayExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguGoodsTodayExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguGoodsTodayExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguGoodsTodayExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}