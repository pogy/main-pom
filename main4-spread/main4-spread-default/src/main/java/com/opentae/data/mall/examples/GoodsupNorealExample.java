package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsupNoreal;

import java.util.*;
public class GoodsupNorealExample extends SgExample<GoodsupNorealExample.Criteria> {
    public static final Class<GoodsupNoreal> beanClass = GoodsupNoreal.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn norealId;
    public static EntityColumn addNum;
    public static EntityColumn activeNum;
    public static EntityColumn itemId;
    public static EntityColumn realNum;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        norealId = listMap.get("norealId");
        addNum = listMap.get("addNum");
        activeNum = listMap.get("activeNum");
        itemId = listMap.get("itemId");
        realNum = listMap.get("realNum");
        }

    public GoodsupNorealExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsupNorealExample.Criteria createCriteriaInternal() {
        return new GoodsupNorealExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsupNorealExample.Criteria andNorealIdIsNull() {
            return isNull(norealId);
        }

        public GoodsupNorealExample.Criteria andNorealIdIsNotNull() {
            return isNotNull(norealId);
        }

        public GoodsupNorealExample.Criteria andNorealIdEqualTo(Long value) {
            return equalTo(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdNotEqualTo(Long value) {
            return notEqualTo(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdGreaterThan(Long value) {
            return greaterThan(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdLessThan(Long value) {
            return lessThan(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(norealId, value);
        }

        public GoodsupNorealExample.Criteria andNorealIdIn(List<Long> values) {
            return in(norealId, values);
        }

        public GoodsupNorealExample.Criteria andNorealIdNotIn(List<Long> values) {
            return notIn(norealId, values);
        }

        public GoodsupNorealExample.Criteria andNorealIdBetween(Long value1, Long value2) {
            return between(norealId, value1, value2);
        }

        public GoodsupNorealExample.Criteria andNorealIdNotBetween(Long value1, Long value2) {
            return notBetween(norealId, value1, value2);
        }
        public GoodsupNorealExample.Criteria andAddNumIsNull() {
            return isNull(addNum);
        }

        public GoodsupNorealExample.Criteria andAddNumIsNotNull() {
            return isNotNull(addNum);
        }

        public GoodsupNorealExample.Criteria andAddNumEqualTo(Integer value) {
            return equalTo(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumNotEqualTo(Integer value) {
            return notEqualTo(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumGreaterThan(Integer value) {
            return greaterThan(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumLessThan(Integer value) {
            return lessThan(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(addNum, value);
        }

        public GoodsupNorealExample.Criteria andAddNumIn(List<Integer> values) {
            return in(addNum, values);
        }

        public GoodsupNorealExample.Criteria andAddNumNotIn(List<Integer> values) {
            return notIn(addNum, values);
        }

        public GoodsupNorealExample.Criteria andAddNumBetween(Integer value1, Integer value2) {
            return between(addNum, value1, value2);
        }

        public GoodsupNorealExample.Criteria andAddNumNotBetween(Integer value1, Integer value2) {
            return notBetween(addNum, value1, value2);
        }
        public GoodsupNorealExample.Criteria andActiveNumIsNull() {
            return isNull(activeNum);
        }

        public GoodsupNorealExample.Criteria andActiveNumIsNotNull() {
            return isNotNull(activeNum);
        }

        public GoodsupNorealExample.Criteria andActiveNumEqualTo(Integer value) {
            return equalTo(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumNotEqualTo(Integer value) {
            return notEqualTo(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumGreaterThan(Integer value) {
            return greaterThan(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumLessThan(Integer value) {
            return lessThan(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(activeNum, value);
        }

        public GoodsupNorealExample.Criteria andActiveNumIn(List<Integer> values) {
            return in(activeNum, values);
        }

        public GoodsupNorealExample.Criteria andActiveNumNotIn(List<Integer> values) {
            return notIn(activeNum, values);
        }

        public GoodsupNorealExample.Criteria andActiveNumBetween(Integer value1, Integer value2) {
            return between(activeNum, value1, value2);
        }

        public GoodsupNorealExample.Criteria andActiveNumNotBetween(Integer value1, Integer value2) {
            return notBetween(activeNum, value1, value2);
        }
        public GoodsupNorealExample.Criteria andItemIdIsNull() {
            return isNull(itemId);
        }

        public GoodsupNorealExample.Criteria andItemIdIsNotNull() {
            return isNotNull(itemId);
        }

        public GoodsupNorealExample.Criteria andItemIdEqualTo(Long value) {
            return equalTo(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdNotEqualTo(Long value) {
            return notEqualTo(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdGreaterThan(Long value) {
            return greaterThan(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdLessThan(Long value) {
            return lessThan(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemId, value);
        }

        public GoodsupNorealExample.Criteria andItemIdIn(List<Long> values) {
            return in(itemId, values);
        }

        public GoodsupNorealExample.Criteria andItemIdNotIn(List<Long> values) {
            return notIn(itemId, values);
        }

        public GoodsupNorealExample.Criteria andItemIdBetween(Long value1, Long value2) {
            return between(itemId, value1, value2);
        }

        public GoodsupNorealExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            return notBetween(itemId, value1, value2);
        }
        public GoodsupNorealExample.Criteria andRealNumIsNull() {
            return isNull(realNum);
        }

        public GoodsupNorealExample.Criteria andRealNumIsNotNull() {
            return isNotNull(realNum);
        }

        public GoodsupNorealExample.Criteria andRealNumEqualTo(Integer value) {
            return equalTo(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumNotEqualTo(Integer value) {
            return notEqualTo(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumGreaterThan(Integer value) {
            return greaterThan(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumLessThan(Integer value) {
            return lessThan(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(realNum, value);
        }

        public GoodsupNorealExample.Criteria andRealNumIn(List<Integer> values) {
            return in(realNum, values);
        }

        public GoodsupNorealExample.Criteria andRealNumNotIn(List<Integer> values) {
            return notIn(realNum, values);
        }

        public GoodsupNorealExample.Criteria andRealNumBetween(Integer value1, Integer value2) {
            return between(realNum, value1, value2);
        }

        public GoodsupNorealExample.Criteria andRealNumNotBetween(Integer value1, Integer value2) {
            return notBetween(realNum, value1, value2);
        }
    }
}
