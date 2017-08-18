package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderSub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ItemOrderSubExample extends SgExample<ItemOrderSubExample.Criteria> {
    public static final Class<ItemOrderSub> beanClass = ItemOrderSub.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn soid;
    public static EntityColumn logisticsId;
    public static EntityColumn color;
    public static EntityColumn shopNum;
    public static EntityColumn goodsId;
    public static EntityColumn num;
    public static EntityColumn distributionNum;
    public static EntityColumn pid;
    public static EntityColumn oid;
    public static EntityColumn title;
    public static EntityColumn marketId;
    public static EntityColumn floorId;
    public static EntityColumn webSite;
    public static EntityColumn picUrl;
    public static EntityColumn payMoney;
    public static EntityColumn price;
    public static EntityColumn shopId;
    public static EntityColumn floor;
    public static EntityColumn skuId;
    public static EntityColumn goodsNo;
    public static EntityColumn weight;
    public static EntityColumn refundMoney;
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
        distributionNum = listMap.get("distributionNum");
        pid = listMap.get("pid");
        oid = listMap.get("oid");
        title = listMap.get("title");
        marketId = listMap.get("marketId");
        floorId = listMap.get("floorId");
        webSite = listMap.get("webSite");
        picUrl = listMap.get("picUrl");
        payMoney = listMap.get("payMoney");
        price = listMap.get("price");
        shopId = listMap.get("shopId");
        floor = listMap.get("floor");
        skuId = listMap.get("skuId");
        goodsNo = listMap.get("goodsNo");
        weight = listMap.get("weight");
        refundMoney = listMap.get("refundMoney");
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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andSoidIsNull() {
            return isNull(soid);
        }

        public Criteria andSoidIsNotNull() {
            return isNotNull(soid);
        }

        public Criteria andSoidEqualTo(Long value) {
            return equalTo(soid, value);
        }

        public Criteria andSoidNotEqualTo(Long value) {
            return notEqualTo(soid, value);
        }

        public Criteria andSoidGreaterThan(Long value) {
            return greaterThan(soid, value);
        }

        public Criteria andSoidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soid, value);
        }

        public Criteria andSoidLessThan(Long value) {
            return lessThan(soid, value);
        }

        public Criteria andSoidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soid, value);
        }

        public Criteria andSoidIn(List<Long> values) {
            return in(soid, values);
        }

        public Criteria andSoidNotIn(List<Long> values) {
            return notIn(soid, values);
        }

        public Criteria andSoidBetween(Long value1, Long value2) {
            return between(soid, value1, value2);
        }

        public Criteria andSoidNotBetween(Long value1, Long value2) {
            return notBetween(soid, value1, value2);
        }
        public Criteria andLogisticsIdIsNull() {
            return isNull(logisticsId);
        }

        public Criteria andLogisticsIdIsNotNull() {
            return isNotNull(logisticsId);
        }

        public Criteria andLogisticsIdEqualTo(Long value) {
            return equalTo(logisticsId, value);
        }

        public Criteria andLogisticsIdNotEqualTo(Long value) {
            return notEqualTo(logisticsId, value);
        }

        public Criteria andLogisticsIdGreaterThan(Long value) {
            return greaterThan(logisticsId, value);
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(logisticsId, value);
        }

        public Criteria andLogisticsIdLessThan(Long value) {
            return lessThan(logisticsId, value);
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(logisticsId, value);
        }

        public Criteria andLogisticsIdIn(List<Long> values) {
            return in(logisticsId, values);
        }

        public Criteria andLogisticsIdNotIn(List<Long> values) {
            return notIn(logisticsId, values);
        }

        public Criteria andLogisticsIdBetween(Long value1, Long value2) {
            return between(logisticsId, value1, value2);
        }

        public Criteria andLogisticsIdNotBetween(Long value1, Long value2) {
            return notBetween(logisticsId, value1, value2);
        }
        public Criteria andColorIsNull() {
            return isNull(color);
        }

        public Criteria andColorIsNotNull() {
            return isNotNull(color);
        }

        public Criteria andColorEqualTo(String value) {
            return equalTo(color, value);
        }

        public Criteria andColorNotEqualTo(String value) {
            return notEqualTo(color, value);
        }

        public Criteria andColorGreaterThan(String value) {
            return greaterThan(color, value);
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(color, value);
        }

        public Criteria andColorLessThan(String value) {
            return lessThan(color, value);
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(color, value);
        }

        public Criteria andColorLike(String value) {
            return like(color, value);
        }

        public Criteria andColorNotLike(String value) {
            return notLike(color, value);
        }

        public Criteria andColorIn(List<String> values) {
            return in(color, values);
        }

        public Criteria andColorNotIn(List<String> values) {
            return notIn(color, values);
        }

        public Criteria andColorBetween(String value1, String value2) {
            return between(color, value1, value2);
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            return notBetween(color, value1, value2);
        }
        public Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public Criteria andNumIsNull() {
            return isNull(num);
        }

        public Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public Criteria andDistributionNumIsNull() {
            return isNull(distributionNum);
        }

        public Criteria andDistributionNumIsNotNull() {
            return isNotNull(distributionNum);
        }

        public Criteria andDistributionNumEqualTo(Integer value) {
            return equalTo(distributionNum, value);
        }

        public Criteria andDistributionNumNotEqualTo(Integer value) {
            return notEqualTo(distributionNum, value);
        }

        public Criteria andDistributionNumGreaterThan(Integer value) {
            return greaterThan(distributionNum, value);
        }

        public Criteria andDistributionNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(distributionNum, value);
        }

        public Criteria andDistributionNumLessThan(Integer value) {
            return lessThan(distributionNum, value);
        }

        public Criteria andDistributionNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(distributionNum, value);
        }

        public Criteria andDistributionNumIn(List<Integer> values) {
            return in(distributionNum, values);
        }

        public Criteria andDistributionNumNotIn(List<Integer> values) {
            return notIn(distributionNum, values);
        }

        public Criteria andDistributionNumBetween(Integer value1, Integer value2) {
            return between(distributionNum, value1, value2);
        }

        public Criteria andDistributionNumNotBetween(Integer value1, Integer value2) {
            return notBetween(distributionNum, value1, value2);
        }
        public Criteria andPidIsNull() {
            return isNull(pid);
        }

        public Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public Criteria andOidIsNull() {
            return isNull(oid);
        }

        public Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public Criteria andTitleIsNull() {
            return isNull(title);
        }

        public Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public Criteria andPayMoneyIsNull() {
            return isNull(payMoney);
        }

        public Criteria andPayMoneyIsNotNull() {
            return isNotNull(payMoney);
        }

        public Criteria andPayMoneyEqualTo(Long value) {
            return equalTo(payMoney, value);
        }

        public Criteria andPayMoneyNotEqualTo(Long value) {
            return notEqualTo(payMoney, value);
        }

        public Criteria andPayMoneyGreaterThan(Long value) {
            return greaterThan(payMoney, value);
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payMoney, value);
        }

        public Criteria andPayMoneyLessThan(Long value) {
            return lessThan(payMoney, value);
        }

        public Criteria andPayMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payMoney, value);
        }

        public Criteria andPayMoneyIn(List<Long> values) {
            return in(payMoney, values);
        }

        public Criteria andPayMoneyNotIn(List<Long> values) {
            return notIn(payMoney, values);
        }

        public Criteria andPayMoneyBetween(Long value1, Long value2) {
            return between(payMoney, value1, value2);
        }

        public Criteria andPayMoneyNotBetween(Long value1, Long value2) {
            return notBetween(payMoney, value1, value2);
        }
        public Criteria andPriceIsNull() {
            return isNull(price);
        }

        public Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public Criteria andFloorIsNull() {
            return isNull(floor);
        }

        public Criteria andFloorIsNotNull() {
            return isNotNull(floor);
        }

        public Criteria andFloorEqualTo(String value) {
            return equalTo(floor, value);
        }

        public Criteria andFloorNotEqualTo(String value) {
            return notEqualTo(floor, value);
        }

        public Criteria andFloorGreaterThan(String value) {
            return greaterThan(floor, value);
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floor, value);
        }

        public Criteria andFloorLessThan(String value) {
            return lessThan(floor, value);
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floor, value);
        }

        public Criteria andFloorLike(String value) {
            return like(floor, value);
        }

        public Criteria andFloorNotLike(String value) {
            return notLike(floor, value);
        }

        public Criteria andFloorIn(List<String> values) {
            return in(floor, values);
        }

        public Criteria andFloorNotIn(List<String> values) {
            return notIn(floor, values);
        }

        public Criteria andFloorBetween(String value1, String value2) {
            return between(floor, value1, value2);
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            return notBetween(floor, value1, value2);
        }
        public Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
        public Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public Criteria andWeightIsNull() {
            return isNull(weight);
        }

        public Criteria andWeightIsNotNull() {
            return isNotNull(weight);
        }

        public Criteria andWeightEqualTo(Long value) {
            return equalTo(weight, value);
        }

        public Criteria andWeightNotEqualTo(Long value) {
            return notEqualTo(weight, value);
        }

        public Criteria andWeightGreaterThan(Long value) {
            return greaterThan(weight, value);
        }

        public Criteria andWeightGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(weight, value);
        }

        public Criteria andWeightLessThan(Long value) {
            return lessThan(weight, value);
        }

        public Criteria andWeightLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(weight, value);
        }

        public Criteria andWeightIn(List<Long> values) {
            return in(weight, values);
        }

        public Criteria andWeightNotIn(List<Long> values) {
            return notIn(weight, values);
        }

        public Criteria andWeightBetween(Long value1, Long value2) {
            return between(weight, value1, value2);
        }

        public Criteria andWeightNotBetween(Long value1, Long value2) {
            return notBetween(weight, value1, value2);
        }
        public Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public Criteria andShouldPayMoneyIsNull() {
            return isNull(shouldPayMoney);
        }

        public Criteria andShouldPayMoneyIsNotNull() {
            return isNotNull(shouldPayMoney);
        }

        public Criteria andShouldPayMoneyEqualTo(Long value) {
            return equalTo(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyNotEqualTo(Long value) {
            return notEqualTo(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyGreaterThan(Long value) {
            return greaterThan(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyLessThan(Long value) {
            return lessThan(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shouldPayMoney, value);
        }

        public Criteria andShouldPayMoneyIn(List<Long> values) {
            return in(shouldPayMoney, values);
        }

        public Criteria andShouldPayMoneyNotIn(List<Long> values) {
            return notIn(shouldPayMoney, values);
        }

        public Criteria andShouldPayMoneyBetween(Long value1, Long value2) {
            return between(shouldPayMoney, value1, value2);
        }

        public Criteria andShouldPayMoneyNotBetween(Long value1, Long value2) {
            return notBetween(shouldPayMoney, value1, value2);
        }
        public Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public Criteria andSizeIsNull() {
            return isNull(size);
        }

        public Criteria andSizeIsNotNull() {
            return isNotNull(size);
        }

        public Criteria andSizeEqualTo(String value) {
            return equalTo(size, value);
        }

        public Criteria andSizeNotEqualTo(String value) {
            return notEqualTo(size, value);
        }

        public Criteria andSizeGreaterThan(String value) {
            return greaterThan(size, value);
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(size, value);
        }

        public Criteria andSizeLessThan(String value) {
            return lessThan(size, value);
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(size, value);
        }

        public Criteria andSizeLike(String value) {
            return like(size, value);
        }

        public Criteria andSizeNotLike(String value) {
            return notLike(size, value);
        }

        public Criteria andSizeIn(List<String> values) {
            return in(size, values);
        }

        public Criteria andSizeNotIn(List<String> values) {
            return notIn(size, values);
        }

        public Criteria andSizeBetween(String value1, String value2) {
            return between(size, value1, value2);
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            return notBetween(size, value1, value2);
        }
        public Criteria andMarkIsNull() {
            return isNull(mark);
        }

        public Criteria andMarkIsNotNull() {
            return isNotNull(mark);
        }

        public Criteria andMarkEqualTo(String value) {
            return equalTo(mark, value);
        }

        public Criteria andMarkNotEqualTo(String value) {
            return notEqualTo(mark, value);
        }

        public Criteria andMarkGreaterThan(String value) {
            return greaterThan(mark, value);
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mark, value);
        }

        public Criteria andMarkLessThan(String value) {
            return lessThan(mark, value);
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mark, value);
        }

        public Criteria andMarkLike(String value) {
            return like(mark, value);
        }

        public Criteria andMarkNotLike(String value) {
            return notLike(mark, value);
        }

        public Criteria andMarkIn(List<String> values) {
            return in(mark, values);
        }

        public Criteria andMarkNotIn(List<String> values) {
            return notIn(mark, values);
        }

        public Criteria andMarkBetween(String value1, String value2) {
            return between(mark, value1, value2);
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            return notBetween(mark, value1, value2);
        }
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}