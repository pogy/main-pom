package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopFitmentPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShopFitmentPageExample extends SgExample<ShopFitmentPageExample.Criteria> {
    public static final Class<ShopFitmentPage> beanClass = ShopFitmentPage.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn code;
    public static EntityColumn name;
    public static EntityColumn shopId;
    public static EntityColumn pageId;
    public static EntityColumn type;
    public static EntityColumn backgroundPic;
    public static EntityColumn backgroundType;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        code = listMap.get("code");
        name = listMap.get("name");
        shopId = listMap.get("shopId");
        pageId = listMap.get("pageId");
        type = listMap.get("type");
        backgroundPic = listMap.get("backgroundPic");
        backgroundType = listMap.get("backgroundType");
        }

    public ShopFitmentPageExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopFitmentPageExample.Criteria createCriteriaInternal() {
        return new ShopFitmentPageExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopFitmentPageExample.Criteria andCodeIsNull() {
            return isNull(code);
        }

        public ShopFitmentPageExample.Criteria andCodeIsNotNull() {
            return isNotNull(code);
        }

        public ShopFitmentPageExample.Criteria andCodeEqualTo(Long value) {
            return equalTo(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeNotEqualTo(Long value) {
            return notEqualTo(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeGreaterThan(Long value) {
            return greaterThan(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeLessThan(Long value) {
            return lessThan(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(code, value);
        }

        public ShopFitmentPageExample.Criteria andCodeIn(List<Long> values) {
            return in(code, values);
        }

        public ShopFitmentPageExample.Criteria andCodeNotIn(List<Long> values) {
            return notIn(code, values);
        }

        public ShopFitmentPageExample.Criteria andCodeBetween(Long value1, Long value2) {
            return between(code, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andCodeNotBetween(Long value1, Long value2) {
            return notBetween(code, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ShopFitmentPageExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ShopFitmentPageExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ShopFitmentPageExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ShopFitmentPageExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ShopFitmentPageExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopFitmentPageExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopFitmentPageExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopFitmentPageExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopFitmentPageExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopFitmentPageExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andPageIdIsNull() {
            return isNull(pageId);
        }

        public ShopFitmentPageExample.Criteria andPageIdIsNotNull() {
            return isNotNull(pageId);
        }

        public ShopFitmentPageExample.Criteria andPageIdEqualTo(Long value) {
            return equalTo(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdNotEqualTo(Long value) {
            return notEqualTo(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdGreaterThan(Long value) {
            return greaterThan(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdLessThan(Long value) {
            return lessThan(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pageId, value);
        }

        public ShopFitmentPageExample.Criteria andPageIdIn(List<Long> values) {
            return in(pageId, values);
        }

        public ShopFitmentPageExample.Criteria andPageIdNotIn(List<Long> values) {
            return notIn(pageId, values);
        }

        public ShopFitmentPageExample.Criteria andPageIdBetween(Long value1, Long value2) {
            return between(pageId, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            return notBetween(pageId, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShopFitmentPageExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShopFitmentPageExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShopFitmentPageExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShopFitmentPageExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShopFitmentPageExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andBackgroundPicIsNull() {
            return isNull(backgroundPic);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicIsNotNull() {
            return isNotNull(backgroundPic);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicEqualTo(String value) {
            return equalTo(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotEqualTo(String value) {
            return notEqualTo(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicGreaterThan(String value) {
            return greaterThan(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLessThan(String value) {
            return lessThan(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLike(String value) {
            return like(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotLike(String value) {
            return notLike(backgroundPic, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicIn(List<String> values) {
            return in(backgroundPic, values);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotIn(List<String> values) {
            return notIn(backgroundPic, values);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicBetween(String value1, String value2) {
            return between(backgroundPic, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotBetween(String value1, String value2) {
            return notBetween(backgroundPic, value1, value2);
        }
        public ShopFitmentPageExample.Criteria andBackgroundTypeIsNull() {
            return isNull(backgroundType);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeIsNotNull() {
            return isNotNull(backgroundType);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeEqualTo(Integer value) {
            return equalTo(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotEqualTo(Integer value) {
            return notEqualTo(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeGreaterThan(Integer value) {
            return greaterThan(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeLessThan(Integer value) {
            return lessThan(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(backgroundType, value);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeIn(List<Integer> values) {
            return in(backgroundType, values);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotIn(List<Integer> values) {
            return notIn(backgroundType, values);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeBetween(Integer value1, Integer value2) {
            return between(backgroundType, value1, value2);
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(backgroundType, value1, value2);
        }
    }
}
