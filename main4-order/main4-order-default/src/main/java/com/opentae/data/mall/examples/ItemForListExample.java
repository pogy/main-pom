package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemForList;

import java.util.*;
public class ItemForListExample extends SgExample<ItemForListExample.Criteria> {
    public static final Class<ItemForList> beanClass = ItemForList.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn piPriceString;
    public static EntityColumn market;
    public static EntityColumn picUrl;
    public static EntityColumn goodsId;
    public static EntityColumn storeNum;
    public static EntityColumn title;
    public static EntityColumn storeId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        piPriceString = listMap.get("piPriceString");
        market = listMap.get("market");
        picUrl = listMap.get("picUrl");
        goodsId = listMap.get("goodsId");
        storeNum = listMap.get("storeNum");
        title = listMap.get("title");
        storeId = listMap.get("storeId");
        }

    public ItemForListExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemForListExample.Criteria createCriteriaInternal() {
        return new ItemForListExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemForListExample.Criteria andPiPriceStringIsNull() {
            return isNull(piPriceString);
        }

        public ItemForListExample.Criteria andPiPriceStringIsNotNull() {
            return isNotNull(piPriceString);
        }

        public ItemForListExample.Criteria andPiPriceStringEqualTo(String value) {
            return equalTo(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringNotEqualTo(String value) {
            return notEqualTo(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringGreaterThan(String value) {
            return greaterThan(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringLessThan(String value) {
            return lessThan(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringLike(String value) {
            return like(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringNotLike(String value) {
            return notLike(piPriceString, value);
        }

        public ItemForListExample.Criteria andPiPriceStringIn(List<String> values) {
            return in(piPriceString, values);
        }

        public ItemForListExample.Criteria andPiPriceStringNotIn(List<String> values) {
            return notIn(piPriceString, values);
        }

        public ItemForListExample.Criteria andPiPriceStringBetween(String value1, String value2) {
            return between(piPriceString, value1, value2);
        }

        public ItemForListExample.Criteria andPiPriceStringNotBetween(String value1, String value2) {
            return notBetween(piPriceString, value1, value2);
        }
        public ItemForListExample.Criteria andMarketIsNull() {
            return isNull(market);
        }

        public ItemForListExample.Criteria andMarketIsNotNull() {
            return isNotNull(market);
        }

        public ItemForListExample.Criteria andMarketEqualTo(String value) {
            return equalTo(market, value);
        }

        public ItemForListExample.Criteria andMarketNotEqualTo(String value) {
            return notEqualTo(market, value);
        }

        public ItemForListExample.Criteria andMarketGreaterThan(String value) {
            return greaterThan(market, value);
        }

        public ItemForListExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(market, value);
        }

        public ItemForListExample.Criteria andMarketLessThan(String value) {
            return lessThan(market, value);
        }

        public ItemForListExample.Criteria andMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(market, value);
        }

        public ItemForListExample.Criteria andMarketLike(String value) {
            return like(market, value);
        }

        public ItemForListExample.Criteria andMarketNotLike(String value) {
            return notLike(market, value);
        }

        public ItemForListExample.Criteria andMarketIn(List<String> values) {
            return in(market, values);
        }

        public ItemForListExample.Criteria andMarketNotIn(List<String> values) {
            return notIn(market, values);
        }

        public ItemForListExample.Criteria andMarketBetween(String value1, String value2) {
            return between(market, value1, value2);
        }

        public ItemForListExample.Criteria andMarketNotBetween(String value1, String value2) {
            return notBetween(market, value1, value2);
        }
        public ItemForListExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ItemForListExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ItemForListExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ItemForListExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ItemForListExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ItemForListExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ItemForListExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ItemForListExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ItemForListExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ItemForListExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ItemForListExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ItemForListExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ItemForListExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ItemForListExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ItemForListExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public ItemForListExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public ItemForListExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public ItemForListExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public ItemForListExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public ItemForListExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public ItemForListExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public ItemForListExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ItemForListExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ItemForListExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ItemForListExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ItemForListExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ItemForListExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ItemForListExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ItemForListExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ItemForListExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ItemForListExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ItemForListExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ItemForListExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ItemForListExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ItemForListExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ItemForListExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ItemForListExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ItemForListExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ItemForListExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ItemForListExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ItemForListExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ItemForListExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
    }
}
