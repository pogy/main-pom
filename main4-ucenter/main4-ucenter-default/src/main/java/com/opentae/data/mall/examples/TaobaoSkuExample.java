package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoSku;

import java.util.*;
public class TaobaoSkuExample extends SgExample<TaobaoSkuExample.Criteria> {
    public static final Class<TaobaoSku> beanClass = TaobaoSku.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn quantity;
    public static EntityColumn iid;
    public static EntityColumn numIid;
    public static EntityColumn created;
    public static EntityColumn propertiesName;
    public static EntityColumn withHoldQuantity;
    public static EntityColumn price;
    public static EntityColumn remark5;
    public static EntityColumn modified;
    public static EntityColumn remark4;
    public static EntityColumn outerId;
    public static EntityColumn tbSkuId;
    public static EntityColumn remark1;
    public static EntityColumn barcode;
    public static EntityColumn skuId;
    public static EntityColumn properties;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        quantity = listMap.get("quantity");
        iid = listMap.get("iid");
        numIid = listMap.get("numIid");
        created = listMap.get("created");
        propertiesName = listMap.get("propertiesName");
        withHoldQuantity = listMap.get("withHoldQuantity");
        price = listMap.get("price");
        remark5 = listMap.get("remark5");
        modified = listMap.get("modified");
        remark4 = listMap.get("remark4");
        outerId = listMap.get("outerId");
        tbSkuId = listMap.get("tbSkuId");
        remark1 = listMap.get("remark1");
        barcode = listMap.get("barcode");
        skuId = listMap.get("skuId");
        properties = listMap.get("properties");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public TaobaoSkuExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TaobaoSkuExample.Criteria createCriteriaInternal() {
        return new TaobaoSkuExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TaobaoSkuExample.Criteria andQuantityIsNull() {
            return isNull(quantity);
        }

        public TaobaoSkuExample.Criteria andQuantityIsNotNull() {
            return isNotNull(quantity);
        }

        public TaobaoSkuExample.Criteria andQuantityEqualTo(Long value) {
            return equalTo(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityNotEqualTo(Long value) {
            return notEqualTo(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityGreaterThan(Long value) {
            return greaterThan(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityLessThan(Long value) {
            return lessThan(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(quantity, value);
        }

        public TaobaoSkuExample.Criteria andQuantityIn(List<Long> values) {
            return in(quantity, values);
        }

        public TaobaoSkuExample.Criteria andQuantityNotIn(List<Long> values) {
            return notIn(quantity, values);
        }

        public TaobaoSkuExample.Criteria andQuantityBetween(Long value1, Long value2) {
            return between(quantity, value1, value2);
        }

        public TaobaoSkuExample.Criteria andQuantityNotBetween(Long value1, Long value2) {
            return notBetween(quantity, value1, value2);
        }
        public TaobaoSkuExample.Criteria andIidIsNull() {
            return isNull(iid);
        }

        public TaobaoSkuExample.Criteria andIidIsNotNull() {
            return isNotNull(iid);
        }

        public TaobaoSkuExample.Criteria andIidEqualTo(String value) {
            return equalTo(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidNotEqualTo(String value) {
            return notEqualTo(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidGreaterThan(String value) {
            return greaterThan(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidLessThan(String value) {
            return lessThan(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidLike(String value) {
            return like(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidNotLike(String value) {
            return notLike(iid, value);
        }

        public TaobaoSkuExample.Criteria andIidIn(List<String> values) {
            return in(iid, values);
        }

        public TaobaoSkuExample.Criteria andIidNotIn(List<String> values) {
            return notIn(iid, values);
        }

        public TaobaoSkuExample.Criteria andIidBetween(String value1, String value2) {
            return between(iid, value1, value2);
        }

        public TaobaoSkuExample.Criteria andIidNotBetween(String value1, String value2) {
            return notBetween(iid, value1, value2);
        }
        public TaobaoSkuExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public TaobaoSkuExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public TaobaoSkuExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public TaobaoSkuExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public TaobaoSkuExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public TaobaoSkuExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public TaobaoSkuExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public TaobaoSkuExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public TaobaoSkuExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public TaobaoSkuExample.Criteria andCreatedEqualTo(String value) {
            return equalTo(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedNotEqualTo(String value) {
            return notEqualTo(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedGreaterThan(String value) {
            return greaterThan(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedLessThan(String value) {
            return lessThan(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedLike(String value) {
            return like(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedNotLike(String value) {
            return notLike(created, value);
        }

        public TaobaoSkuExample.Criteria andCreatedIn(List<String> values) {
            return in(created, values);
        }

        public TaobaoSkuExample.Criteria andCreatedNotIn(List<String> values) {
            return notIn(created, values);
        }

        public TaobaoSkuExample.Criteria andCreatedBetween(String value1, String value2) {
            return between(created, value1, value2);
        }

        public TaobaoSkuExample.Criteria andCreatedNotBetween(String value1, String value2) {
            return notBetween(created, value1, value2);
        }
        public TaobaoSkuExample.Criteria andPropertiesNameIsNull() {
            return isNull(propertiesName);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameIsNotNull() {
            return isNotNull(propertiesName);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameEqualTo(String value) {
            return equalTo(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotEqualTo(String value) {
            return notEqualTo(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameGreaterThan(String value) {
            return greaterThan(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLessThan(String value) {
            return lessThan(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLike(String value) {
            return like(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotLike(String value) {
            return notLike(propertiesName, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameIn(List<String> values) {
            return in(propertiesName, values);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotIn(List<String> values) {
            return notIn(propertiesName, values);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameBetween(String value1, String value2) {
            return between(propertiesName, value1, value2);
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotBetween(String value1, String value2) {
            return notBetween(propertiesName, value1, value2);
        }
        public TaobaoSkuExample.Criteria andWithHoldQuantityIsNull() {
            return isNull(withHoldQuantity);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityIsNotNull() {
            return isNotNull(withHoldQuantity);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityEqualTo(Long value) {
            return equalTo(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotEqualTo(Long value) {
            return notEqualTo(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityGreaterThan(Long value) {
            return greaterThan(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityLessThan(Long value) {
            return lessThan(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(withHoldQuantity, value);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityIn(List<Long> values) {
            return in(withHoldQuantity, values);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotIn(List<Long> values) {
            return notIn(withHoldQuantity, values);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityBetween(Long value1, Long value2) {
            return between(withHoldQuantity, value1, value2);
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotBetween(Long value1, Long value2) {
            return notBetween(withHoldQuantity, value1, value2);
        }
        public TaobaoSkuExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public TaobaoSkuExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public TaobaoSkuExample.Criteria andPriceEqualTo(String value) {
            return equalTo(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceNotEqualTo(String value) {
            return notEqualTo(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceGreaterThan(String value) {
            return greaterThan(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceLessThan(String value) {
            return lessThan(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceLike(String value) {
            return like(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceNotLike(String value) {
            return notLike(price, value);
        }

        public TaobaoSkuExample.Criteria andPriceIn(List<String> values) {
            return in(price, values);
        }

        public TaobaoSkuExample.Criteria andPriceNotIn(List<String> values) {
            return notIn(price, values);
        }

        public TaobaoSkuExample.Criteria andPriceBetween(String value1, String value2) {
            return between(price, value1, value2);
        }

        public TaobaoSkuExample.Criteria andPriceNotBetween(String value1, String value2) {
            return notBetween(price, value1, value2);
        }
        public TaobaoSkuExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoSkuExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoSkuExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoSkuExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public TaobaoSkuExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public TaobaoSkuExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoSkuExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoSkuExample.Criteria andModifiedIsNull() {
            return isNull(modified);
        }

        public TaobaoSkuExample.Criteria andModifiedIsNotNull() {
            return isNotNull(modified);
        }

        public TaobaoSkuExample.Criteria andModifiedEqualTo(String value) {
            return equalTo(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedNotEqualTo(String value) {
            return notEqualTo(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedGreaterThan(String value) {
            return greaterThan(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedLessThan(String value) {
            return lessThan(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedLike(String value) {
            return like(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedNotLike(String value) {
            return notLike(modified, value);
        }

        public TaobaoSkuExample.Criteria andModifiedIn(List<String> values) {
            return in(modified, values);
        }

        public TaobaoSkuExample.Criteria andModifiedNotIn(List<String> values) {
            return notIn(modified, values);
        }

        public TaobaoSkuExample.Criteria andModifiedBetween(String value1, String value2) {
            return between(modified, value1, value2);
        }

        public TaobaoSkuExample.Criteria andModifiedNotBetween(String value1, String value2) {
            return notBetween(modified, value1, value2);
        }
        public TaobaoSkuExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoSkuExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoSkuExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoSkuExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public TaobaoSkuExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public TaobaoSkuExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoSkuExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoSkuExample.Criteria andOuterIdIsNull() {
            return isNull(outerId);
        }

        public TaobaoSkuExample.Criteria andOuterIdIsNotNull() {
            return isNotNull(outerId);
        }

        public TaobaoSkuExample.Criteria andOuterIdEqualTo(String value) {
            return equalTo(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdNotEqualTo(String value) {
            return notEqualTo(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdGreaterThan(String value) {
            return greaterThan(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdLessThan(String value) {
            return lessThan(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdLike(String value) {
            return like(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdNotLike(String value) {
            return notLike(outerId, value);
        }

        public TaobaoSkuExample.Criteria andOuterIdIn(List<String> values) {
            return in(outerId, values);
        }

        public TaobaoSkuExample.Criteria andOuterIdNotIn(List<String> values) {
            return notIn(outerId, values);
        }

        public TaobaoSkuExample.Criteria andOuterIdBetween(String value1, String value2) {
            return between(outerId, value1, value2);
        }

        public TaobaoSkuExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            return notBetween(outerId, value1, value2);
        }
        public TaobaoSkuExample.Criteria andTbSkuIdIsNull() {
            return isNull(tbSkuId);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdIsNotNull() {
            return isNotNull(tbSkuId);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdEqualTo(Long value) {
            return equalTo(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotEqualTo(Long value) {
            return notEqualTo(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdGreaterThan(Long value) {
            return greaterThan(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdLessThan(Long value) {
            return lessThan(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbSkuId, value);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdIn(List<Long> values) {
            return in(tbSkuId, values);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotIn(List<Long> values) {
            return notIn(tbSkuId, values);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdBetween(Long value1, Long value2) {
            return between(tbSkuId, value1, value2);
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(tbSkuId, value1, value2);
        }
        public TaobaoSkuExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoSkuExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoSkuExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoSkuExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TaobaoSkuExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TaobaoSkuExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoSkuExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoSkuExample.Criteria andBarcodeIsNull() {
            return isNull(barcode);
        }

        public TaobaoSkuExample.Criteria andBarcodeIsNotNull() {
            return isNotNull(barcode);
        }

        public TaobaoSkuExample.Criteria andBarcodeEqualTo(String value) {
            return equalTo(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeNotEqualTo(String value) {
            return notEqualTo(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeGreaterThan(String value) {
            return greaterThan(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeLessThan(String value) {
            return lessThan(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeLike(String value) {
            return like(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeNotLike(String value) {
            return notLike(barcode, value);
        }

        public TaobaoSkuExample.Criteria andBarcodeIn(List<String> values) {
            return in(barcode, values);
        }

        public TaobaoSkuExample.Criteria andBarcodeNotIn(List<String> values) {
            return notIn(barcode, values);
        }

        public TaobaoSkuExample.Criteria andBarcodeBetween(String value1, String value2) {
            return between(barcode, value1, value2);
        }

        public TaobaoSkuExample.Criteria andBarcodeNotBetween(String value1, String value2) {
            return notBetween(barcode, value1, value2);
        }
        public TaobaoSkuExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public TaobaoSkuExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public TaobaoSkuExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public TaobaoSkuExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public TaobaoSkuExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public TaobaoSkuExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public TaobaoSkuExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
        public TaobaoSkuExample.Criteria andPropertiesIsNull() {
            return isNull(properties);
        }

        public TaobaoSkuExample.Criteria andPropertiesIsNotNull() {
            return isNotNull(properties);
        }

        public TaobaoSkuExample.Criteria andPropertiesEqualTo(String value) {
            return equalTo(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNotEqualTo(String value) {
            return notEqualTo(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesGreaterThan(String value) {
            return greaterThan(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesLessThan(String value) {
            return lessThan(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesLike(String value) {
            return like(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesNotLike(String value) {
            return notLike(properties, value);
        }

        public TaobaoSkuExample.Criteria andPropertiesIn(List<String> values) {
            return in(properties, values);
        }

        public TaobaoSkuExample.Criteria andPropertiesNotIn(List<String> values) {
            return notIn(properties, values);
        }

        public TaobaoSkuExample.Criteria andPropertiesBetween(String value1, String value2) {
            return between(properties, value1, value2);
        }

        public TaobaoSkuExample.Criteria andPropertiesNotBetween(String value1, String value2) {
            return notBetween(properties, value1, value2);
        }
        public TaobaoSkuExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoSkuExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoSkuExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoSkuExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public TaobaoSkuExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public TaobaoSkuExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoSkuExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoSkuExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoSkuExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoSkuExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TaobaoSkuExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TaobaoSkuExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TaobaoSkuExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoSkuExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
