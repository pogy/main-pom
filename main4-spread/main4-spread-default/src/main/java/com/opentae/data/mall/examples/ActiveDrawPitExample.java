package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActiveDrawPit;

import java.util.*;
public class ActiveDrawPitExample extends SgExample<ActiveDrawPitExample.Criteria> {
    public static final Class<ActiveDrawPit> beanClass = ActiveDrawPit.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn num;
    public static EntityColumn id;
    public static EntityColumn type;
    public static EntityColumn goodsType;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        num = listMap.get("num");
        id = listMap.get("id");
        type = listMap.get("type");
        goodsType = listMap.get("goodsType");
        }

    public ActiveDrawPitExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActiveDrawPitExample.Criteria createCriteriaInternal() {
        return new ActiveDrawPitExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ActiveDrawPitExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ActiveDrawPitExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ActiveDrawPitExample.Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public ActiveDrawPitExample.Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public ActiveDrawPitExample.Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public ActiveDrawPitExample.Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public ActiveDrawPitExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public ActiveDrawPitExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ActiveDrawPitExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ActiveDrawPitExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ActiveDrawPitExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ActiveDrawPitExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ActiveDrawPitExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ActiveDrawPitExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ActiveDrawPitExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ActiveDrawPitExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ActiveDrawPitExample.Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public ActiveDrawPitExample.Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public ActiveDrawPitExample.Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public ActiveDrawPitExample.Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public ActiveDrawPitExample.Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public ActiveDrawPitExample.Criteria andGoodsTypeIsNull() {
            return isNull(goodsType);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeIsNotNull() {
            return isNotNull(goodsType);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeEqualTo(String value) {
            return equalTo(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotEqualTo(String value) {
            return notEqualTo(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeGreaterThan(String value) {
            return greaterThan(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLessThan(String value) {
            return lessThan(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLike(String value) {
            return like(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotLike(String value) {
            return notLike(goodsType, value);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeIn(List<String> values) {
            return in(goodsType, values);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotIn(List<String> values) {
            return notIn(goodsType, values);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeBetween(String value1, String value2) {
            return between(goodsType, value1, value2);
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotBetween(String value1, String value2) {
            return notBetween(goodsType, value1, value2);
        }
    }
}
