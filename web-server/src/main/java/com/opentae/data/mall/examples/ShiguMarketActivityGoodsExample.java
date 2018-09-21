package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguMarketActivityGoods;

import java.util.*;
public class ShiguMarketActivityGoodsExample extends SgExample<ShiguMarketActivityGoodsExample.Criteria> {
    public static final Class<ShiguMarketActivityGoods> beanClass = ShiguMarketActivityGoods.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn magId;
    public static EntityColumn goodsId;
    public static EntityColumn sort;
    public static EntityColumn magStatus;
    public static EntityColumn maId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        magId = listMap.get("magId");
        goodsId = listMap.get("goodsId");
        sort = listMap.get("sort");
        magStatus = listMap.get("magStatus");
        maId = listMap.get("maId");
        }

    public ShiguMarketActivityGoodsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguMarketActivityGoodsExample.Criteria createCriteriaInternal() {
        return new ShiguMarketActivityGoodsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdIsNull() {
            return isNull(magId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdIsNotNull() {
            return isNotNull(magId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdEqualTo(Long value) {
            return equalTo(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdNotEqualTo(Long value) {
            return notEqualTo(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdGreaterThan(Long value) {
            return greaterThan(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdLessThan(Long value) {
            return lessThan(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(magId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdIn(List<Long> values) {
            return in(magId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdNotIn(List<Long> values) {
            return notIn(magId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdBetween(Long value1, Long value2) {
            return between(magId, value1, value2);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagIdNotBetween(Long value1, Long value2) {
            return notBetween(magId, value1, value2);
        }
        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguMarketActivityGoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguMarketActivityGoodsExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public ShiguMarketActivityGoodsExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public ShiguMarketActivityGoodsExample.Criteria andMagStatusIsNull() {
            return isNull(magStatus);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusIsNotNull() {
            return isNotNull(magStatus);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusEqualTo(Integer value) {
            return equalTo(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusNotEqualTo(Integer value) {
            return notEqualTo(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusGreaterThan(Integer value) {
            return greaterThan(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusLessThan(Integer value) {
            return lessThan(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(magStatus, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusIn(List<Integer> values) {
            return in(magStatus, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusNotIn(List<Integer> values) {
            return notIn(magStatus, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusBetween(Integer value1, Integer value2) {
            return between(magStatus, value1, value2);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMagStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(magStatus, value1, value2);
        }
        public ShiguMarketActivityGoodsExample.Criteria andMaIdIsNull() {
            return isNull(maId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdIsNotNull() {
            return isNotNull(maId);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdEqualTo(Long value) {
            return equalTo(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdNotEqualTo(Long value) {
            return notEqualTo(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdGreaterThan(Long value) {
            return greaterThan(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdLessThan(Long value) {
            return lessThan(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(maId, value);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdIn(List<Long> values) {
            return in(maId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdNotIn(List<Long> values) {
            return notIn(maId, values);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdBetween(Long value1, Long value2) {
            return between(maId, value1, value2);
        }

        public ShiguMarketActivityGoodsExample.Criteria andMaIdNotBetween(Long value1, Long value2) {
            return notBetween(maId, value1, value2);
        }
    }
}