package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStoreNumShow;

import java.util.*;
public class ShiguStoreNumShowExample extends SgExample<ShiguStoreNumShowExample.Criteria> {
    public static final Class<ShiguStoreNumShow> beanClass = ShiguStoreNumShow.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn displayMarket;
    public static EntityColumn marketId;
    public static EntityColumn webSite;
    public static EntityColumn recommendSort;
    public static EntityColumn storeNumDesc;
    public static EntityColumn visitUrl;
    public static EntityColumn dealDate;
    public static EntityColumn parentMarket;
    public static EntityColumn storeNumId;
    public static EntityColumn parentMarketId;
    public static EntityColumn services;
    public static EntityColumn storeId;
    public static EntityColumn mainType;
    public static EntityColumn useStatus;
    public static EntityColumn market;
    public static EntityColumn recommendIs;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn buycityId;
    public static EntityColumn sortOrder;
    public static EntityColumn lastModifyTime;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn storeNum;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        displayMarket = listMap.get("displayMarket");
        marketId = listMap.get("marketId");
        webSite = listMap.get("webSite");
        recommendSort = listMap.get("recommendSort");
        storeNumDesc = listMap.get("storeNumDesc");
        visitUrl = listMap.get("visitUrl");
        dealDate = listMap.get("dealDate");
        parentMarket = listMap.get("parentMarket");
        storeNumId = listMap.get("storeNumId");
        parentMarketId = listMap.get("parentMarketId");
        services = listMap.get("services");
        storeId = listMap.get("storeId");
        mainType = listMap.get("mainType");
        useStatus = listMap.get("useStatus");
        market = listMap.get("market");
        recommendIs = listMap.get("recommendIs");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        buycityId = listMap.get("buycityId");
        sortOrder = listMap.get("sortOrder");
        lastModifyTime = listMap.get("lastModifyTime");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        storeNum = listMap.get("storeNum");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguStoreNumShowExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStoreNumShowExample.Criteria createCriteriaInternal() {
        return new ShiguStoreNumShowExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketIsNull() {
            return isNull(displayMarket);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketIsNotNull() {
            return isNotNull(displayMarket);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketEqualTo(Integer value) {
            return equalTo(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotEqualTo(Integer value) {
            return notEqualTo(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketGreaterThan(Integer value) {
            return greaterThan(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketLessThan(Integer value) {
            return lessThan(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(displayMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketIn(List<Integer> values) {
            return in(displayMarket, values);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotIn(List<Integer> values) {
            return notIn(displayMarket, values);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketBetween(Integer value1, Integer value2) {
            return between(displayMarket, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotBetween(Integer value1, Integer value2) {
            return notBetween(displayMarket, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRecommendSortIsNull() {
            return isNull(recommendSort);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortIsNotNull() {
            return isNotNull(recommendSort);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortEqualTo(Integer value) {
            return equalTo(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotEqualTo(Integer value) {
            return notEqualTo(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortGreaterThan(Integer value) {
            return greaterThan(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortLessThan(Integer value) {
            return lessThan(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(recommendSort, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortIn(List<Integer> values) {
            return in(recommendSort, values);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotIn(List<Integer> values) {
            return notIn(recommendSort, values);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortBetween(Integer value1, Integer value2) {
            return between(recommendSort, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotBetween(Integer value1, Integer value2) {
            return notBetween(recommendSort, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andStoreNumDescIsNull() {
            return isNull(storeNumDesc);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescIsNotNull() {
            return isNotNull(storeNumDesc);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescEqualTo(String value) {
            return equalTo(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotEqualTo(String value) {
            return notEqualTo(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescGreaterThan(String value) {
            return greaterThan(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLessThan(String value) {
            return lessThan(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLike(String value) {
            return like(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotLike(String value) {
            return notLike(storeNumDesc, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescIn(List<String> values) {
            return in(storeNumDesc, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotIn(List<String> values) {
            return notIn(storeNumDesc, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescBetween(String value1, String value2) {
            return between(storeNumDesc, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotBetween(String value1, String value2) {
            return notBetween(storeNumDesc, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andVisitUrlIsNull() {
            return isNull(visitUrl);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlIsNotNull() {
            return isNotNull(visitUrl);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlEqualTo(String value) {
            return equalTo(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotEqualTo(String value) {
            return notEqualTo(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlGreaterThan(String value) {
            return greaterThan(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLessThan(String value) {
            return lessThan(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLike(String value) {
            return like(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotLike(String value) {
            return notLike(visitUrl, value);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlIn(List<String> values) {
            return in(visitUrl, values);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotIn(List<String> values) {
            return notIn(visitUrl, values);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlBetween(String value1, String value2) {
            return between(visitUrl, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotBetween(String value1, String value2) {
            return notBetween(visitUrl, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andDealDateIsNull() {
            return isNull(dealDate);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateIsNotNull() {
            return isNotNull(dealDate);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateEqualTo(Date value) {
            return equalTo(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotEqualTo(Date value) {
            return notEqualTo(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateGreaterThan(Date value) {
            return greaterThan(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateLessThan(Date value) {
            return lessThan(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(dealDate, value);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateIn(List<Date> values) {
            return in(dealDate, values);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotIn(List<Date> values) {
            return notIn(dealDate, values);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateBetween(Date value1, Date value2) {
            return between(dealDate, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotBetween(Date value1, Date value2) {
            return notBetween(dealDate, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andParentMarketIsNull() {
            return isNull(parentMarket);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIsNotNull() {
            return isNotNull(parentMarket);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketEqualTo(String value) {
            return equalTo(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotEqualTo(String value) {
            return notEqualTo(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketGreaterThan(String value) {
            return greaterThan(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLessThan(String value) {
            return lessThan(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLike(String value) {
            return like(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotLike(String value) {
            return notLike(parentMarket, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIn(List<String> values) {
            return in(parentMarket, values);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotIn(List<String> values) {
            return notIn(parentMarket, values);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketBetween(String value1, String value2) {
            return between(parentMarket, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotBetween(String value1, String value2) {
            return notBetween(parentMarket, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andStoreNumIdIsNull() {
            return isNull(storeNumId);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdIsNotNull() {
            return isNotNull(storeNumId);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdEqualTo(Long value) {
            return equalTo(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotEqualTo(Long value) {
            return notEqualTo(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdGreaterThan(Long value) {
            return greaterThan(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdLessThan(Long value) {
            return lessThan(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeNumId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdIn(List<Long> values) {
            return in(storeNumId, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotIn(List<Long> values) {
            return notIn(storeNumId, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdBetween(Long value1, Long value2) {
            return between(storeNumId, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotBetween(Long value1, Long value2) {
            return notBetween(storeNumId, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andParentMarketIdIsNull() {
            return isNull(parentMarketId);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdIsNotNull() {
            return isNotNull(parentMarketId);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdEqualTo(Long value) {
            return equalTo(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            return notEqualTo(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdGreaterThan(Long value) {
            return greaterThan(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdLessThan(Long value) {
            return lessThan(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentMarketId, value);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdIn(List<Long> values) {
            return in(parentMarketId, values);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            return notIn(parentMarketId, values);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            return between(parentMarketId, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(parentMarketId, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andServicesIsNull() {
            return isNull(services);
        }

        public ShiguStoreNumShowExample.Criteria andServicesIsNotNull() {
            return isNotNull(services);
        }

        public ShiguStoreNumShowExample.Criteria andServicesEqualTo(String value) {
            return equalTo(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotEqualTo(String value) {
            return notEqualTo(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesGreaterThan(String value) {
            return greaterThan(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesLessThan(String value) {
            return lessThan(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesLike(String value) {
            return like(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotLike(String value) {
            return notLike(services, value);
        }

        public ShiguStoreNumShowExample.Criteria andServicesIn(List<String> values) {
            return in(services, values);
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotIn(List<String> values) {
            return notIn(services, values);
        }

        public ShiguStoreNumShowExample.Criteria andServicesBetween(String value1, String value2) {
            return between(services, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotBetween(String value1, String value2) {
            return notBetween(services, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andMainTypeIsNull() {
            return isNull(mainType);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeIsNotNull() {
            return isNotNull(mainType);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeEqualTo(String value) {
            return equalTo(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotEqualTo(String value) {
            return notEqualTo(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeGreaterThan(String value) {
            return greaterThan(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLessThan(String value) {
            return lessThan(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLike(String value) {
            return like(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotLike(String value) {
            return notLike(mainType, value);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeIn(List<String> values) {
            return in(mainType, values);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotIn(List<String> values) {
            return notIn(mainType, values);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeBetween(String value1, String value2) {
            return between(mainType, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotBetween(String value1, String value2) {
            return notBetween(mainType, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andMarketIsNull() {
            return isNull(market);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIsNotNull() {
            return isNotNull(market);
        }

        public ShiguStoreNumShowExample.Criteria andMarketEqualTo(String value) {
            return equalTo(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotEqualTo(String value) {
            return notEqualTo(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketGreaterThan(String value) {
            return greaterThan(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketLessThan(String value) {
            return lessThan(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketLike(String value) {
            return like(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotLike(String value) {
            return notLike(market, value);
        }

        public ShiguStoreNumShowExample.Criteria andMarketIn(List<String> values) {
            return in(market, values);
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotIn(List<String> values) {
            return notIn(market, values);
        }

        public ShiguStoreNumShowExample.Criteria andMarketBetween(String value1, String value2) {
            return between(market, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotBetween(String value1, String value2) {
            return notBetween(market, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRecommendIsIsNull() {
            return isNull(recommendIs);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsIsNotNull() {
            return isNotNull(recommendIs);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsEqualTo(Integer value) {
            return equalTo(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotEqualTo(Integer value) {
            return notEqualTo(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsGreaterThan(Integer value) {
            return greaterThan(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsLessThan(Integer value) {
            return lessThan(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(recommendIs, value);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsIn(List<Integer> values) {
            return in(recommendIs, values);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotIn(List<Integer> values) {
            return notIn(recommendIs, values);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsBetween(Integer value1, Integer value2) {
            return between(recommendIs, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotBetween(Integer value1, Integer value2) {
            return notBetween(recommendIs, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdEqualTo(Long value) {
            return equalTo(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotEqualTo(Long value) {
            return notEqualTo(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdGreaterThan(Long value) {
            return greaterThan(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdLessThan(Long value) {
            return lessThan(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdIn(List<Long> values) {
            return in(buycityId, values);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotIn(List<Long> values) {
            return notIn(buycityId, values);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            return between(buycityId, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderEqualTo(String value) {
            return equalTo(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotEqualTo(String value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderGreaterThan(String value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLessThan(String value) {
            return lessThan(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLike(String value) {
            return like(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotLike(String value) {
            return notLike(sortOrder, value);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderIn(List<String> values) {
            return in(sortOrder, values);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotIn(List<String> values) {
            return notIn(sortOrder, values);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderBetween(String value1, String value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotBetween(String value1, String value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguStoreNumShowExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
