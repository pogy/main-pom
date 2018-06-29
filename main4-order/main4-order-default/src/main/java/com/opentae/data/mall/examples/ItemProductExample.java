package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ItemProductExample extends SgExample<ItemProductExample.Criteria> {
    public static final Class<ItemProduct> beanClass = ItemProduct.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsNo;
    public static EntityColumn shopNum;
    public static EntityColumn goodsId;
    public static EntityColumn weight;
    public static EntityColumn pid;
    public static EntityColumn title;
    public static EntityColumn marketId;
    public static EntityColumn floorId;
    public static EntityColumn webSite;
    public static EntityColumn picUrl;
    public static EntityColumn marketName;
    public static EntityColumn price;
    public static EntityColumn shopId;
    public static EntityColumn floor;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsNo = listMap.get("goodsNo");
        shopNum = listMap.get("shopNum");
        goodsId = listMap.get("goodsId");
        weight = listMap.get("weight");
        pid = listMap.get("pid");
        title = listMap.get("title");
        marketId = listMap.get("marketId");
        floorId = listMap.get("floorId");
        webSite = listMap.get("webSite");
        picUrl = listMap.get("picUrl");
        marketName = listMap.get("marketName");
        price = listMap.get("price");
        shopId = listMap.get("shopId");
        floor = listMap.get("floor");
        }

    public ItemProductExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemProductExample.Criteria createCriteriaInternal() {
        return new ItemProductExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemProductExample.Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public ItemProductExample.Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public ItemProductExample.Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public ItemProductExample.Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public ItemProductExample.Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public ItemProductExample.Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public ItemProductExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public ItemProductExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ItemProductExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ItemProductExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ItemProductExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ItemProductExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ItemProductExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ItemProductExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ItemProductExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ItemProductExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ItemProductExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ItemProductExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ItemProductExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ItemProductExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ItemProductExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ItemProductExample.Criteria andWeightIsNull() {
            return isNull(weight);
        }

        public ItemProductExample.Criteria andWeightIsNotNull() {
            return isNotNull(weight);
        }

        public ItemProductExample.Criteria andWeightEqualTo(Long value) {
            return equalTo(weight, value);
        }

        public ItemProductExample.Criteria andWeightNotEqualTo(Long value) {
            return notEqualTo(weight, value);
        }

        public ItemProductExample.Criteria andWeightGreaterThan(Long value) {
            return greaterThan(weight, value);
        }

        public ItemProductExample.Criteria andWeightGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(weight, value);
        }

        public ItemProductExample.Criteria andWeightLessThan(Long value) {
            return lessThan(weight, value);
        }

        public ItemProductExample.Criteria andWeightLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(weight, value);
        }

        public ItemProductExample.Criteria andWeightIn(List<Long> values) {
            return in(weight, values);
        }

        public ItemProductExample.Criteria andWeightNotIn(List<Long> values) {
            return notIn(weight, values);
        }

        public ItemProductExample.Criteria andWeightBetween(Long value1, Long value2) {
            return between(weight, value1, value2);
        }

        public ItemProductExample.Criteria andWeightNotBetween(Long value1, Long value2) {
            return notBetween(weight, value1, value2);
        }
        public ItemProductExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ItemProductExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ItemProductExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public ItemProductExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public ItemProductExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public ItemProductExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ItemProductExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public ItemProductExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ItemProductExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public ItemProductExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public ItemProductExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public ItemProductExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public ItemProductExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ItemProductExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ItemProductExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ItemProductExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ItemProductExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ItemProductExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ItemProductExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ItemProductExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ItemProductExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ItemProductExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ItemProductExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ItemProductExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ItemProductExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ItemProductExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ItemProductExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ItemProductExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ItemProductExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ItemProductExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ItemProductExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ItemProductExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ItemProductExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ItemProductExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public ItemProductExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public ItemProductExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public ItemProductExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public ItemProductExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public ItemProductExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public ItemProductExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public ItemProductExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ItemProductExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ItemProductExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ItemProductExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ItemProductExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ItemProductExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ItemProductExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ItemProductExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ItemProductExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ItemProductExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ItemProductExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ItemProductExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ItemProductExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ItemProductExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ItemProductExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ItemProductExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ItemProductExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ItemProductExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ItemProductExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ItemProductExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ItemProductExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ItemProductExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ItemProductExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ItemProductExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ItemProductExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ItemProductExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ItemProductExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ItemProductExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ItemProductExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ItemProductExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ItemProductExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ItemProductExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ItemProductExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ItemProductExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ItemProductExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ItemProductExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ItemProductExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ItemProductExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ItemProductExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ItemProductExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ItemProductExample.Criteria andFloorIsNull() {
            return isNull(floor);
        }

        public ItemProductExample.Criteria andFloorIsNotNull() {
            return isNotNull(floor);
        }

        public ItemProductExample.Criteria andFloorEqualTo(String value) {
            return equalTo(floor, value);
        }

        public ItemProductExample.Criteria andFloorNotEqualTo(String value) {
            return notEqualTo(floor, value);
        }

        public ItemProductExample.Criteria andFloorGreaterThan(String value) {
            return greaterThan(floor, value);
        }

        public ItemProductExample.Criteria andFloorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floor, value);
        }

        public ItemProductExample.Criteria andFloorLessThan(String value) {
            return lessThan(floor, value);
        }

        public ItemProductExample.Criteria andFloorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floor, value);
        }

        public ItemProductExample.Criteria andFloorLike(String value) {
            return like(floor, value);
        }

        public ItemProductExample.Criteria andFloorNotLike(String value) {
            return notLike(floor, value);
        }

        public ItemProductExample.Criteria andFloorIn(List<String> values) {
            return in(floor, values);
        }

        public ItemProductExample.Criteria andFloorNotIn(List<String> values) {
            return notIn(floor, values);
        }

        public ItemProductExample.Criteria andFloorBetween(String value1, String value2) {
            return between(floor, value1, value2);
        }

        public ItemProductExample.Criteria andFloorNotBetween(String value1, String value2) {
            return notBetween(floor, value1, value2);
        }
    }
}