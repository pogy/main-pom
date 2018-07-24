package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopNumAndMarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShopNumAndMarketExample extends SgExample<ShopNumAndMarketExample.Criteria> {
    public static final Class<ShopNumAndMarket> beanClass = ShopNumAndMarket.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn market;
    public static EntityColumn shopNum;
    public static EntityColumn shopId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        market = listMap.get("market");
        shopNum = listMap.get("shopNum");
        shopId = listMap.get("shopId");
        }

    public ShopNumAndMarketExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopNumAndMarketExample.Criteria createCriteriaInternal() {
        return new ShopNumAndMarketExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopNumAndMarketExample.Criteria andMarketIsNull() {
            return isNull(market);
        }

        public ShopNumAndMarketExample.Criteria andMarketIsNotNull() {
            return isNotNull(market);
        }

        public ShopNumAndMarketExample.Criteria andMarketEqualTo(String value) {
            return equalTo(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketNotEqualTo(String value) {
            return notEqualTo(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketGreaterThan(String value) {
            return greaterThan(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketLessThan(String value) {
            return lessThan(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketLike(String value) {
            return like(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketNotLike(String value) {
            return notLike(market, value);
        }

        public ShopNumAndMarketExample.Criteria andMarketIn(List<String> values) {
            return in(market, values);
        }

        public ShopNumAndMarketExample.Criteria andMarketNotIn(List<String> values) {
            return notIn(market, values);
        }

        public ShopNumAndMarketExample.Criteria andMarketBetween(String value1, String value2) {
            return between(market, value1, value2);
        }

        public ShopNumAndMarketExample.Criteria andMarketNotBetween(String value1, String value2) {
            return notBetween(market, value1, value2);
        }
        public ShopNumAndMarketExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ShopNumAndMarketExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ShopNumAndMarketExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ShopNumAndMarketExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ShopNumAndMarketExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ShopNumAndMarketExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ShopNumAndMarketExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ShopNumAndMarketExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopNumAndMarketExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopNumAndMarketExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopNumAndMarketExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopNumAndMarketExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopNumAndMarketExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopNumAndMarketExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
    }
}
