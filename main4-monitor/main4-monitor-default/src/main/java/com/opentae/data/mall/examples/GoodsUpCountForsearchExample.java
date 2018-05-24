package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsUpCountForsearch;

import java.util.*;
public class GoodsUpCountForsearchExample extends SgExample<GoodsUpCountForsearchExample.Criteria> {
    public static final Class<GoodsUpCountForsearch> beanClass = GoodsUpCountForsearch.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remarker3;
    public static EntityColumn remarker4;
    public static EntityColumn remarker1;
    public static EntityColumn remarker2;
    public static EntityColumn goodsId;
    public static EntityColumn id;
    public static EntityColumn goodsUpNum;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        remarker3 = listMap.get("remarker3");
        remarker4 = listMap.get("remarker4");
        remarker1 = listMap.get("remarker1");
        remarker2 = listMap.get("remarker2");
        goodsId = listMap.get("goodsId");
        id = listMap.get("id");
        goodsUpNum = listMap.get("goodsUpNum");
        }

    public GoodsUpCountForsearchExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsUpCountForsearchExample.Criteria createCriteriaInternal() {
        return new GoodsUpCountForsearchExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3IsNull() {
            return isNull(remarker3);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3IsNotNull() {
            return isNotNull(remarker3);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3EqualTo(Long value) {
            return equalTo(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3NotEqualTo(Long value) {
            return notEqualTo(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3GreaterThan(Long value) {
            return greaterThan(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3GreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3LessThan(Long value) {
            return lessThan(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3LessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(remarker3, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3In(List<Long> values) {
            return in(remarker3, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3NotIn(List<Long> values) {
            return notIn(remarker3, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3Between(Long value1, Long value2) {
            return between(remarker3, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker3NotBetween(Long value1, Long value2) {
            return notBetween(remarker3, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andRemarker4IsNull() {
            return isNull(remarker4);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4IsNotNull() {
            return isNotNull(remarker4);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4EqualTo(Long value) {
            return equalTo(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4NotEqualTo(Long value) {
            return notEqualTo(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4GreaterThan(Long value) {
            return greaterThan(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4GreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4LessThan(Long value) {
            return lessThan(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4LessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(remarker4, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4In(List<Long> values) {
            return in(remarker4, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4NotIn(List<Long> values) {
            return notIn(remarker4, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4Between(Long value1, Long value2) {
            return between(remarker4, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker4NotBetween(Long value1, Long value2) {
            return notBetween(remarker4, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andRemarker1IsNull() {
            return isNull(remarker1);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1IsNotNull() {
            return isNotNull(remarker1);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1EqualTo(Long value) {
            return equalTo(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1NotEqualTo(Long value) {
            return notEqualTo(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1GreaterThan(Long value) {
            return greaterThan(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1GreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1LessThan(Long value) {
            return lessThan(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1LessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(remarker1, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1In(List<Long> values) {
            return in(remarker1, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1NotIn(List<Long> values) {
            return notIn(remarker1, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1Between(Long value1, Long value2) {
            return between(remarker1, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker1NotBetween(Long value1, Long value2) {
            return notBetween(remarker1, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andRemarker2IsNull() {
            return isNull(remarker2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2IsNotNull() {
            return isNotNull(remarker2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2EqualTo(Long value) {
            return equalTo(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2NotEqualTo(Long value) {
            return notEqualTo(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2GreaterThan(Long value) {
            return greaterThan(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2GreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2LessThan(Long value) {
            return lessThan(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2LessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(remarker2, value);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2In(List<Long> values) {
            return in(remarker2, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2NotIn(List<Long> values) {
            return notIn(remarker2, values);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2Between(Long value1, Long value2) {
            return between(remarker2, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andRemarker2NotBetween(Long value1, Long value2) {
            return notBetween(remarker2, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public GoodsUpCountForsearchExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public GoodsUpCountForsearchExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public GoodsUpCountForsearchExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public GoodsUpCountForsearchExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public GoodsUpCountForsearchExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumIsNull() {
            return isNull(goodsUpNum);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumIsNotNull() {
            return isNotNull(goodsUpNum);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumEqualTo(Long value) {
            return equalTo(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumNotEqualTo(Long value) {
            return notEqualTo(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumGreaterThan(Long value) {
            return greaterThan(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumLessThan(Long value) {
            return lessThan(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsUpNum, value);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumIn(List<Long> values) {
            return in(goodsUpNum, values);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumNotIn(List<Long> values) {
            return notIn(goodsUpNum, values);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumBetween(Long value1, Long value2) {
            return between(goodsUpNum, value1, value2);
        }

        public GoodsUpCountForsearchExample.Criteria andGoodsUpNumNotBetween(Long value1, Long value2) {
            return notBetween(goodsUpNum, value1, value2);
        }
    }
}