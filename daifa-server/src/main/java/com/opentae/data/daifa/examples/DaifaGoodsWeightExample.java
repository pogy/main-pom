package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGoodsWeight;

import java.util.*;
public class DaifaGoodsWeightExample extends SgExample<DaifaGoodsWeightExample.Criteria> {
    public static final Class<DaifaGoodsWeight> beanClass = DaifaGoodsWeight.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sellerId;
    public static EntityColumn createTime;
    public static EntityColumn goodsId;
    public static EntityColumn goodsWeight;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sellerId = listMap.get("sellerId");
        createTime = listMap.get("createTime");
        goodsId = listMap.get("goodsId");
        goodsWeight = listMap.get("goodsWeight");
        }

    public DaifaGoodsWeightExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGoodsWeightExample.Criteria createCriteriaInternal() {
        return new DaifaGoodsWeightExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaGoodsWeightExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaGoodsWeightExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGoodsWeightExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGoodsWeightExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaGoodsWeightExample.Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightEqualTo(Long value) {
            return equalTo(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightNotEqualTo(Long value) {
            return notEqualTo(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightGreaterThan(Long value) {
            return greaterThan(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightLessThan(Long value) {
            return lessThan(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightIn(List<Long> values) {
            return in(goodsWeight, values);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightNotIn(List<Long> values) {
            return notIn(goodsWeight, values);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightBetween(Long value1, Long value2) {
            return between(goodsWeight, value1, value2);
        }

        public DaifaGoodsWeightExample.Criteria andGoodsWeightNotBetween(Long value1, Long value2) {
            return notBetween(goodsWeight, value1, value2);
        }
    }
}