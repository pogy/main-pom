package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopeeUserInfo;

import java.util.*;
public class ShopeeUserInfoExample extends SgExample<ShopeeUserInfoExample.Criteria> {
    public static final Class<ShopeeUserInfo> beanClass = ShopeeUserInfo.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn country;
    public static EntityColumn itemLimit;
    public static EntityColumn shopDescription;
    public static EntityColumn shopName;
    public static EntityColumn shopId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        country = listMap.get("country");
        itemLimit = listMap.get("itemLimit");
        shopDescription = listMap.get("shopDescription");
        shopName = listMap.get("shopName");
        shopId = listMap.get("shopId");
        }

    public ShopeeUserInfoExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopeeUserInfoExample.Criteria createCriteriaInternal() {
        return new ShopeeUserInfoExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopeeUserInfoExample.Criteria andCountryIsNull() {
            return isNull(country);
        }

        public ShopeeUserInfoExample.Criteria andCountryIsNotNull() {
            return isNotNull(country);
        }

        public ShopeeUserInfoExample.Criteria andCountryEqualTo(String value) {
            return equalTo(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryNotEqualTo(String value) {
            return notEqualTo(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryGreaterThan(String value) {
            return greaterThan(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryLessThan(String value) {
            return lessThan(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryLike(String value) {
            return like(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryNotLike(String value) {
            return notLike(country, value);
        }

        public ShopeeUserInfoExample.Criteria andCountryIn(List<String> values) {
            return in(country, values);
        }

        public ShopeeUserInfoExample.Criteria andCountryNotIn(List<String> values) {
            return notIn(country, values);
        }

        public ShopeeUserInfoExample.Criteria andCountryBetween(String value1, String value2) {
            return between(country, value1, value2);
        }

        public ShopeeUserInfoExample.Criteria andCountryNotBetween(String value1, String value2) {
            return notBetween(country, value1, value2);
        }
        public ShopeeUserInfoExample.Criteria andItemLimitIsNull() {
            return isNull(itemLimit);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitIsNotNull() {
            return isNotNull(itemLimit);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitEqualTo(Long value) {
            return equalTo(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitNotEqualTo(Long value) {
            return notEqualTo(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitGreaterThan(Long value) {
            return greaterThan(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitLessThan(Long value) {
            return lessThan(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemLimit, value);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitIn(List<Long> values) {
            return in(itemLimit, values);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitNotIn(List<Long> values) {
            return notIn(itemLimit, values);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitBetween(Long value1, Long value2) {
            return between(itemLimit, value1, value2);
        }

        public ShopeeUserInfoExample.Criteria andItemLimitNotBetween(Long value1, Long value2) {
            return notBetween(itemLimit, value1, value2);
        }
        public ShopeeUserInfoExample.Criteria andShopDescriptionIsNull() {
            return isNull(shopDescription);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionIsNotNull() {
            return isNotNull(shopDescription);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionEqualTo(String value) {
            return equalTo(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionNotEqualTo(String value) {
            return notEqualTo(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionGreaterThan(String value) {
            return greaterThan(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionLessThan(String value) {
            return lessThan(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionLike(String value) {
            return like(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionNotLike(String value) {
            return notLike(shopDescription, value);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionIn(List<String> values) {
            return in(shopDescription, values);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionNotIn(List<String> values) {
            return notIn(shopDescription, values);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionBetween(String value1, String value2) {
            return between(shopDescription, value1, value2);
        }

        public ShopeeUserInfoExample.Criteria andShopDescriptionNotBetween(String value1, String value2) {
            return notBetween(shopDescription, value1, value2);
        }
        public ShopeeUserInfoExample.Criteria andShopNameIsNull() {
            return isNull(shopName);
        }

        public ShopeeUserInfoExample.Criteria andShopNameIsNotNull() {
            return isNotNull(shopName);
        }

        public ShopeeUserInfoExample.Criteria andShopNameEqualTo(String value) {
            return equalTo(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameNotEqualTo(String value) {
            return notEqualTo(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameGreaterThan(String value) {
            return greaterThan(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameLessThan(String value) {
            return lessThan(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameLike(String value) {
            return like(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameNotLike(String value) {
            return notLike(shopName, value);
        }

        public ShopeeUserInfoExample.Criteria andShopNameIn(List<String> values) {
            return in(shopName, values);
        }

        public ShopeeUserInfoExample.Criteria andShopNameNotIn(List<String> values) {
            return notIn(shopName, values);
        }

        public ShopeeUserInfoExample.Criteria andShopNameBetween(String value1, String value2) {
            return between(shopName, value1, value2);
        }

        public ShopeeUserInfoExample.Criteria andShopNameNotBetween(String value1, String value2) {
            return notBetween(shopName, value1, value2);
        }
        public ShopeeUserInfoExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopeeUserInfoExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopeeUserInfoExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopeeUserInfoExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopeeUserInfoExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopeeUserInfoExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopeeUserInfoExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
    }
}