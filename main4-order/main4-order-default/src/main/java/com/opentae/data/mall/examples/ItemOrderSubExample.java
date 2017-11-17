package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderSub;

import java.util.*;
public class ItemOrderSubExample extends SgExample<ItemOrderSubExample.Criteria> {
    public static final Class<ItemOrderSub> beanClass = ItemOrderSub.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn soid;
    public static EntityColumn logisticsId;
    public static EntityColumn color;
    public static EntityColumn shopNum;
    public static EntityColumn goodsId;
    public static EntityColumn num;
    public static EntityColumn pid;
    public static EntityColumn oid;
    public static EntityColumn title;
    public static EntityColumn marketId;
    public static EntityColumn floorId;
    public static EntityColumn webSite;
    public static EntityColumn picUrl;
    public static EntityColumn price;
    public static EntityColumn shopId;
    public static EntityColumn floor;
    public static EntityColumn skuId;
    public static EntityColumn outOfStok;
    public static EntityColumn inStok;
    public static EntityColumn goodsNo;
    public static EntityColumn weight;
    public static EntityColumn refundMoney;
    public static EntityColumn outOfStokReason;
    public static EntityColumn shouldPayMoney;
    public static EntityColumn marketName;
    public static EntityColumn size;
    public static EntityColumn mark;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        soid = listMap.get("soid");
        logisticsId = listMap.get("logisticsId");
        color = listMap.get("color");
        shopNum = listMap.get("shopNum");
        goodsId = listMap.get("goodsId");
        num = listMap.get("num");
        pid = listMap.get("pid");
        oid = listMap.get("oid");
        title = listMap.get("title");
        marketId = listMap.get("marketId");
        floorId = listMap.get("floorId");
        webSite = listMap.get("webSite");
        picUrl = listMap.get("picUrl");
        price = listMap.get("price");
        shopId = listMap.get("shopId");
        floor = listMap.get("floor");
        skuId = listMap.get("skuId");
        outOfStok = listMap.get("outOfStok");
        inStok = listMap.get("inStok");
        goodsNo = listMap.get("goodsNo");
        weight = listMap.get("weight");
        refundMoney = listMap.get("refundMoney");
        outOfStokReason = listMap.get("outOfStokReason");
        shouldPayMoney = listMap.get("shouldPayMoney");
        marketName = listMap.get("marketName");
        size = listMap.get("size");
        mark = listMap.get("mark");
        status = listMap.get("status");
        }

    public ItemOrderSubExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderSubExample.Criteria createCriteriaInternal() {
        return new ItemOrderSubExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderSubExample.Criteria andSoidIsNull() {
            return isNull(soid);
        }

        public ItemOrderSubExample.Criteria andSoidIsNotNull() {
            return isNotNull(soid);
        }

        public ItemOrderSubExample.Criteria andSoidEqualTo(Long value) {
            return equalTo(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidNotEqualTo(Long value) {
            return notEqualTo(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThan(Long value) {
            return greaterThan(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidLessThan(Long value) {
            return lessThan(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soid, value);
        }

        public ItemOrderSubExample.Criteria andSoidIn(List<Long> values) {
            return in(soid, values);
        }

        public ItemOrderSubExample.Criteria andSoidNotIn(List<Long> values) {
            return notIn(soid, values);
        }

        public ItemOrderSubExample.Criteria andSoidBetween(Long value1, Long value2) {
            return between(soid, value1, value2);
        }

        public ItemOrderSubExample.Criteria andSoidNotBetween(Long value1, Long value2) {
            return notBetween(soid, value1, value2);
        }
        public ItemOrderSubExample.Criteria andLogisticsIdIsNull() {
            return isNull(logisticsId);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIsNotNull() {
            return isNotNull(logisticsId);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdEqualTo(Long value) {
            return equalTo(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotEqualTo(Long value) {
            return notEqualTo(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThan(Long value) {
            return greaterThan(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThan(Long value) {
            return lessThan(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(logisticsId, value);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIn(List<Long> values) {
            return in(logisticsId, values);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotIn(List<Long> values) {
            return notIn(logisticsId, values);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdBetween(Long value1, Long value2) {
            return between(logisticsId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotBetween(Long value1, Long value2) {
            return notBetween(logisticsId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andColorIsNull() {
            return isNull(color);
        }

        public ItemOrderSubExample.Criteria andColorIsNotNull() {
            return isNotNull(color);
        }

        public ItemOrderSubExample.Criteria andColorEqualTo(String value) {
            return equalTo(color, value);
        }

        public ItemOrderSubExample.Criteria andColorNotEqualTo(String value) {
            return notEqualTo(color, value);
        }

        public ItemOrderSubExample.Criteria andColorGreaterThan(String value) {
            return greaterThan(color, value);
        }

        public ItemOrderSubExample.Criteria andColorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(color, value);
        }

        public ItemOrderSubExample.Criteria andColorLessThan(String value) {
            return lessThan(color, value);
        }

        public ItemOrderSubExample.Criteria andColorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(color, value);
        }

        public ItemOrderSubExample.Criteria andColorLike(String value) {
            return like(color, value);
        }

        public ItemOrderSubExample.Criteria andColorNotLike(String value) {
            return notLike(color, value);
        }

        public ItemOrderSubExample.Criteria andColorIn(List<String> values) {
            return in(color, values);
        }

        public ItemOrderSubExample.Criteria andColorNotIn(List<String> values) {
            return notIn(color, values);
        }

        public ItemOrderSubExample.Criteria andColorBetween(String value1, String value2) {
            return between(color, value1, value2);
        }

        public ItemOrderSubExample.Criteria andColorNotBetween(String value1, String value2) {
            return notBetween(color, value1, value2);
        }
        public ItemOrderSubExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ItemOrderSubExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ItemOrderSubExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ItemOrderSubExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ItemOrderSubExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ItemOrderSubExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ItemOrderSubExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ItemOrderSubExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ItemOrderSubExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ItemOrderSubExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ItemOrderSubExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ItemOrderSubExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ItemOrderSubExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ItemOrderSubExample.Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public ItemOrderSubExample.Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public ItemOrderSubExample.Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public ItemOrderSubExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ItemOrderSubExample.Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public ItemOrderSubExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public ItemOrderSubExample.Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public ItemOrderSubExample.Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public ItemOrderSubExample.Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public ItemOrderSubExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public ItemOrderSubExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ItemOrderSubExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ItemOrderSubExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ItemOrderSubExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public ItemOrderSubExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public ItemOrderSubExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public ItemOrderSubExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public ItemOrderSubExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderSubExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderSubExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderSubExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderSubExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderSubExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderSubExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public ItemOrderSubExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ItemOrderSubExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ItemOrderSubExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ItemOrderSubExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ItemOrderSubExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ItemOrderSubExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ItemOrderSubExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ItemOrderSubExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ItemOrderSubExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ItemOrderSubExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ItemOrderSubExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ItemOrderSubExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ItemOrderSubExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public ItemOrderSubExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public ItemOrderSubExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public ItemOrderSubExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public ItemOrderSubExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public ItemOrderSubExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ItemOrderSubExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ItemOrderSubExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ItemOrderSubExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ItemOrderSubExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ItemOrderSubExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ItemOrderSubExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ItemOrderSubExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ItemOrderSubExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ItemOrderSubExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ItemOrderSubExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ItemOrderSubExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ItemOrderSubExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ItemOrderSubExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ItemOrderSubExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ItemOrderSubExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ItemOrderSubExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ItemOrderSubExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ItemOrderSubExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ItemOrderSubExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ItemOrderSubExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ItemOrderSubExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ItemOrderSubExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ItemOrderSubExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ItemOrderSubExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ItemOrderSubExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ItemOrderSubExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andFloorIsNull() {
            return isNull(floor);
        }

        public ItemOrderSubExample.Criteria andFloorIsNotNull() {
            return isNotNull(floor);
        }

        public ItemOrderSubExample.Criteria andFloorEqualTo(String value) {
            return equalTo(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorNotEqualTo(String value) {
            return notEqualTo(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorGreaterThan(String value) {
            return greaterThan(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorLessThan(String value) {
            return lessThan(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorLike(String value) {
            return like(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorNotLike(String value) {
            return notLike(floor, value);
        }

        public ItemOrderSubExample.Criteria andFloorIn(List<String> values) {
            return in(floor, values);
        }

        public ItemOrderSubExample.Criteria andFloorNotIn(List<String> values) {
            return notIn(floor, values);
        }

        public ItemOrderSubExample.Criteria andFloorBetween(String value1, String value2) {
            return between(floor, value1, value2);
        }

        public ItemOrderSubExample.Criteria andFloorNotBetween(String value1, String value2) {
            return notBetween(floor, value1, value2);
        }
        public ItemOrderSubExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public ItemOrderSubExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public ItemOrderSubExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public ItemOrderSubExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public ItemOrderSubExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public ItemOrderSubExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public ItemOrderSubExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
        public ItemOrderSubExample.Criteria andOutOfStokIsNull() {
            return isNull(outOfStok);
        }

        public ItemOrderSubExample.Criteria andOutOfStokIsNotNull() {
            return isNotNull(outOfStok);
        }

        public ItemOrderSubExample.Criteria andOutOfStokEqualTo(Integer value) {
            return equalTo(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokNotEqualTo(Integer value) {
            return notEqualTo(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokGreaterThan(Integer value) {
            return greaterThan(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokLessThan(Integer value) {
            return lessThan(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(outOfStok, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokIn(List<Integer> values) {
            return in(outOfStok, values);
        }

        public ItemOrderSubExample.Criteria andOutOfStokNotIn(List<Integer> values) {
            return notIn(outOfStok, values);
        }

        public ItemOrderSubExample.Criteria andOutOfStokBetween(Integer value1, Integer value2) {
            return between(outOfStok, value1, value2);
        }

        public ItemOrderSubExample.Criteria andOutOfStokNotBetween(Integer value1, Integer value2) {
            return notBetween(outOfStok, value1, value2);
        }
        public ItemOrderSubExample.Criteria andInStokIsNull() {
            return isNull(inStok);
        }

        public ItemOrderSubExample.Criteria andInStokIsNotNull() {
            return isNotNull(inStok);
        }

        public ItemOrderSubExample.Criteria andInStokEqualTo(Integer value) {
            return equalTo(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokNotEqualTo(Integer value) {
            return notEqualTo(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokGreaterThan(Integer value) {
            return greaterThan(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokLessThan(Integer value) {
            return lessThan(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inStok, value);
        }

        public ItemOrderSubExample.Criteria andInStokIn(List<Integer> values) {
            return in(inStok, values);
        }

        public ItemOrderSubExample.Criteria andInStokNotIn(List<Integer> values) {
            return notIn(inStok, values);
        }

        public ItemOrderSubExample.Criteria andInStokBetween(Integer value1, Integer value2) {
            return between(inStok, value1, value2);
        }

        public ItemOrderSubExample.Criteria andInStokNotBetween(Integer value1, Integer value2) {
            return notBetween(inStok, value1, value2);
        }
        public ItemOrderSubExample.Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public ItemOrderSubExample.Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public ItemOrderSubExample.Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public ItemOrderSubExample.Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public ItemOrderSubExample.Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public ItemOrderSubExample.Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public ItemOrderSubExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public ItemOrderSubExample.Criteria andWeightIsNull() {
            return isNull(weight);
        }

        public ItemOrderSubExample.Criteria andWeightIsNotNull() {
            return isNotNull(weight);
        }

        public ItemOrderSubExample.Criteria andWeightEqualTo(Long value) {
            return equalTo(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightNotEqualTo(Long value) {
            return notEqualTo(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightGreaterThan(Long value) {
            return greaterThan(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightLessThan(Long value) {
            return lessThan(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(weight, value);
        }

        public ItemOrderSubExample.Criteria andWeightIn(List<Long> values) {
            return in(weight, values);
        }

        public ItemOrderSubExample.Criteria andWeightNotIn(List<Long> values) {
            return notIn(weight, values);
        }

        public ItemOrderSubExample.Criteria andWeightBetween(Long value1, Long value2) {
            return between(weight, value1, value2);
        }

        public ItemOrderSubExample.Criteria andWeightNotBetween(Long value1, Long value2) {
            return notBetween(weight, value1, value2);
        }
        public ItemOrderSubExample.Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public ItemOrderSubExample.Criteria andOutOfStokReasonIsNull() {
            return isNull(outOfStokReason);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonIsNotNull() {
            return isNotNull(outOfStokReason);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonEqualTo(String value) {
            return equalTo(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonNotEqualTo(String value) {
            return notEqualTo(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonGreaterThan(String value) {
            return greaterThan(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonLessThan(String value) {
            return lessThan(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonLike(String value) {
            return like(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonNotLike(String value) {
            return notLike(outOfStokReason, value);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonIn(List<String> values) {
            return in(outOfStokReason, values);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonNotIn(List<String> values) {
            return notIn(outOfStokReason, values);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonBetween(String value1, String value2) {
            return between(outOfStokReason, value1, value2);
        }

        public ItemOrderSubExample.Criteria andOutOfStokReasonNotBetween(String value1, String value2) {
            return notBetween(outOfStokReason, value1, value2);
        }
        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNull() {
            return isNull(shouldPayMoney);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNotNull() {
            return isNotNull(shouldPayMoney);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyEqualTo(Long value) {
            return equalTo(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotEqualTo(Long value) {
            return notEqualTo(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThan(Long value) {
            return greaterThan(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThan(Long value) {
            return lessThan(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shouldPayMoney, value);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIn(List<Long> values) {
            return in(shouldPayMoney, values);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotIn(List<Long> values) {
            return notIn(shouldPayMoney, values);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyBetween(Long value1, Long value2) {
            return between(shouldPayMoney, value1, value2);
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotBetween(Long value1, Long value2) {
            return notBetween(shouldPayMoney, value1, value2);
        }
        public ItemOrderSubExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ItemOrderSubExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ItemOrderSubExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ItemOrderSubExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ItemOrderSubExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ItemOrderSubExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ItemOrderSubExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ItemOrderSubExample.Criteria andSizeIsNull() {
            return isNull(size);
        }

        public ItemOrderSubExample.Criteria andSizeIsNotNull() {
            return isNotNull(size);
        }

        public ItemOrderSubExample.Criteria andSizeEqualTo(String value) {
            return equalTo(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeNotEqualTo(String value) {
            return notEqualTo(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeGreaterThan(String value) {
            return greaterThan(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeLessThan(String value) {
            return lessThan(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeLike(String value) {
            return like(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeNotLike(String value) {
            return notLike(size, value);
        }

        public ItemOrderSubExample.Criteria andSizeIn(List<String> values) {
            return in(size, values);
        }

        public ItemOrderSubExample.Criteria andSizeNotIn(List<String> values) {
            return notIn(size, values);
        }

        public ItemOrderSubExample.Criteria andSizeBetween(String value1, String value2) {
            return between(size, value1, value2);
        }

        public ItemOrderSubExample.Criteria andSizeNotBetween(String value1, String value2) {
            return notBetween(size, value1, value2);
        }
        public ItemOrderSubExample.Criteria andMarkIsNull() {
            return isNull(mark);
        }

        public ItemOrderSubExample.Criteria andMarkIsNotNull() {
            return isNotNull(mark);
        }

        public ItemOrderSubExample.Criteria andMarkEqualTo(String value) {
            return equalTo(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkNotEqualTo(String value) {
            return notEqualTo(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThan(String value) {
            return greaterThan(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkLessThan(String value) {
            return lessThan(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkLike(String value) {
            return like(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkNotLike(String value) {
            return notLike(mark, value);
        }

        public ItemOrderSubExample.Criteria andMarkIn(List<String> values) {
            return in(mark, values);
        }

        public ItemOrderSubExample.Criteria andMarkNotIn(List<String> values) {
            return notIn(mark, values);
        }

        public ItemOrderSubExample.Criteria andMarkBetween(String value1, String value2) {
            return between(mark, value1, value2);
        }

        public ItemOrderSubExample.Criteria andMarkNotBetween(String value1, String value2) {
            return notBetween(mark, value1, value2);
        }
        public ItemOrderSubExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ItemOrderSubExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ItemOrderSubExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ItemOrderSubExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ItemOrderSubExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ItemOrderSubExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ItemOrderSubExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}