package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguFlickrShop;

import java.util.*;
public class ShiguFlickrShopExample extends SgExample<ShiguFlickrShopExample.Criteria> {
    public static final Class<ShiguFlickrShop> beanClass = ShiguFlickrShop.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn marketFloorId;
    public static EntityColumn webSite;
    public static EntityColumn relevancyShopId;
    public static EntityColumn creator;
    public static EntityColumn createTime;
    public static EntityColumn phone;
    public static EntityColumn flickrStoreId;
    public static EntityColumn sfsStatus;
    public static EntityColumn flickrStroeName;
    public static EntityColumn cId;
    public static EntityColumn marketId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        marketFloorId = listMap.get("marketFloorId");
        webSite = listMap.get("webSite");
        relevancyShopId = listMap.get("relevancyShopId");
        creator = listMap.get("creator");
        createTime = listMap.get("createTime");
        phone = listMap.get("phone");
        flickrStoreId = listMap.get("flickrStoreId");
        sfsStatus = listMap.get("sfsStatus");
        flickrStroeName = listMap.get("flickrStroeName");
        cId = listMap.get("cId");
        marketId = listMap.get("marketId");
        }

    public ShiguFlickrShopExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguFlickrShopExample.Criteria createCriteriaInternal() {
        return new ShiguFlickrShopExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdIsNull() {
            return isNull(marketFloorId);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdIsNotNull() {
            return isNotNull(marketFloorId);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdEqualTo(Long value) {
            return equalTo(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdNotEqualTo(Long value) {
            return notEqualTo(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdGreaterThan(Long value) {
            return greaterThan(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdLessThan(Long value) {
            return lessThan(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketFloorId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdIn(List<Long> values) {
            return in(marketFloorId, values);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdNotIn(List<Long> values) {
            return notIn(marketFloorId, values);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdBetween(Long value1, Long value2) {
            return between(marketFloorId, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andMarketFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(marketFloorId, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andRelevancyShopIdIsNull() {
            return isNull(relevancyShopId);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdIsNotNull() {
            return isNotNull(relevancyShopId);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdEqualTo(Long value) {
            return equalTo(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdNotEqualTo(Long value) {
            return notEqualTo(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdGreaterThan(Long value) {
            return greaterThan(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdLessThan(Long value) {
            return lessThan(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(relevancyShopId, value);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdIn(List<Long> values) {
            return in(relevancyShopId, values);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdNotIn(List<Long> values) {
            return notIn(relevancyShopId, values);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdBetween(Long value1, Long value2) {
            return between(relevancyShopId, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andRelevancyShopIdNotBetween(Long value1, Long value2) {
            return notBetween(relevancyShopId, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andCreatorIsNull() {
            return isNull(creator);
        }

        public ShiguFlickrShopExample.Criteria andCreatorIsNotNull() {
            return isNotNull(creator);
        }

        public ShiguFlickrShopExample.Criteria andCreatorEqualTo(Long value) {
            return equalTo(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorNotEqualTo(Long value) {
            return notEqualTo(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorGreaterThan(Long value) {
            return greaterThan(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorLessThan(Long value) {
            return lessThan(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(creator, value);
        }

        public ShiguFlickrShopExample.Criteria andCreatorIn(List<Long> values) {
            return in(creator, values);
        }

        public ShiguFlickrShopExample.Criteria andCreatorNotIn(List<Long> values) {
            return notIn(creator, values);
        }

        public ShiguFlickrShopExample.Criteria andCreatorBetween(Long value1, Long value2) {
            return between(creator, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andCreatorNotBetween(Long value1, Long value2) {
            return notBetween(creator, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public ShiguFlickrShopExample.Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public ShiguFlickrShopExample.Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public ShiguFlickrShopExample.Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public ShiguFlickrShopExample.Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public ShiguFlickrShopExample.Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andFlickrStoreIdIsNull() {
            return isNull(flickrStoreId);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdIsNotNull() {
            return isNotNull(flickrStoreId);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdEqualTo(Long value) {
            return equalTo(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdNotEqualTo(Long value) {
            return notEqualTo(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdGreaterThan(Long value) {
            return greaterThan(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdLessThan(Long value) {
            return lessThan(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(flickrStoreId, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdIn(List<Long> values) {
            return in(flickrStoreId, values);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdNotIn(List<Long> values) {
            return notIn(flickrStoreId, values);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdBetween(Long value1, Long value2) {
            return between(flickrStoreId, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(flickrStoreId, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andSfsStatusIsNull() {
            return isNull(sfsStatus);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusIsNotNull() {
            return isNotNull(sfsStatus);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusEqualTo(Integer value) {
            return equalTo(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusNotEqualTo(Integer value) {
            return notEqualTo(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusGreaterThan(Integer value) {
            return greaterThan(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusLessThan(Integer value) {
            return lessThan(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sfsStatus, value);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusIn(List<Integer> values) {
            return in(sfsStatus, values);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusNotIn(List<Integer> values) {
            return notIn(sfsStatus, values);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusBetween(Integer value1, Integer value2) {
            return between(sfsStatus, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andSfsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sfsStatus, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andFlickrStroeNameIsNull() {
            return isNull(flickrStroeName);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameIsNotNull() {
            return isNotNull(flickrStroeName);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameEqualTo(String value) {
            return equalTo(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameNotEqualTo(String value) {
            return notEqualTo(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameGreaterThan(String value) {
            return greaterThan(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameLessThan(String value) {
            return lessThan(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameLike(String value) {
            return like(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameNotLike(String value) {
            return notLike(flickrStroeName, value);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameIn(List<String> values) {
            return in(flickrStroeName, values);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameNotIn(List<String> values) {
            return notIn(flickrStroeName, values);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameBetween(String value1, String value2) {
            return between(flickrStroeName, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andFlickrStroeNameNotBetween(String value1, String value2) {
            return notBetween(flickrStroeName, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andCIdIsNull() {
            return isNull(cId);
        }

        public ShiguFlickrShopExample.Criteria andCIdIsNotNull() {
            return isNotNull(cId);
        }

        public ShiguFlickrShopExample.Criteria andCIdEqualTo(Long value) {
            return equalTo(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdNotEqualTo(Long value) {
            return notEqualTo(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdGreaterThan(Long value) {
            return greaterThan(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdLessThan(Long value) {
            return lessThan(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cId, value);
        }

        public ShiguFlickrShopExample.Criteria andCIdIn(List<Long> values) {
            return in(cId, values);
        }

        public ShiguFlickrShopExample.Criteria andCIdNotIn(List<Long> values) {
            return notIn(cId, values);
        }

        public ShiguFlickrShopExample.Criteria andCIdBetween(Long value1, Long value2) {
            return between(cId, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andCIdNotBetween(Long value1, Long value2) {
            return notBetween(cId, value1, value2);
        }
        public ShiguFlickrShopExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguFlickrShopExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
    }
}