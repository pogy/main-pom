package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguCustomerStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguCustomerStyleExample extends SgExample<ShiguCustomerStyleExample.Criteria> {
    public static final Class<ShiguCustomerStyle> beanClass = ShiguCustomerStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn styleType;
    public static EntityColumn goodsId;
    public static EntityColumn styleId;
    public static EntityColumn sort;
    public static EntityColumn styleName;
    public static EntityColumn userId;
    public static EntityColumn cId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        styleType = listMap.get("styleType");
        goodsId = listMap.get("goodsId");
        styleId = listMap.get("styleId");
        sort = listMap.get("sort");
        styleName = listMap.get("styleName");
        userId = listMap.get("userId");
        cId = listMap.get("cId");
        }

    public ShiguCustomerStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguCustomerStyleExample.Criteria createCriteriaInternal() {
        return new ShiguCustomerStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeIsNull() {
            return isNull(styleType);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeIsNotNull() {
            return isNotNull(styleType);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeEqualTo(Integer value) {
            return equalTo(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeNotEqualTo(Integer value) {
            return notEqualTo(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeGreaterThan(Integer value) {
            return greaterThan(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeLessThan(Integer value) {
            return lessThan(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(styleType, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeIn(List<Integer> values) {
            return in(styleType, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeNotIn(List<Integer> values) {
            return notIn(styleType, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeBetween(Integer value1, Integer value2) {
            return between(styleType, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andStyleTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(styleType, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andStyleIdIsNull() {
            return isNull(styleId);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdIsNotNull() {
            return isNotNull(styleId);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdEqualTo(Long value) {
            return equalTo(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdNotEqualTo(Long value) {
            return notEqualTo(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdGreaterThan(Long value) {
            return greaterThan(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdLessThan(Long value) {
            return lessThan(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleId, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdIn(List<Long> values) {
            return in(styleId, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdNotIn(List<Long> values) {
            return notIn(styleId, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdBetween(Long value1, Long value2) {
            return between(styleId, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(styleId, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public ShiguCustomerStyleExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public ShiguCustomerStyleExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public ShiguCustomerStyleExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public ShiguCustomerStyleExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public ShiguCustomerStyleExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andStyleNameIsNull() {
            return isNull(styleName);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameIsNotNull() {
            return isNotNull(styleName);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameEqualTo(String value) {
            return equalTo(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameNotEqualTo(String value) {
            return notEqualTo(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameGreaterThan(String value) {
            return greaterThan(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameLessThan(String value) {
            return lessThan(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameLike(String value) {
            return like(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameNotLike(String value) {
            return notLike(styleName, value);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameIn(List<String> values) {
            return in(styleName, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameNotIn(List<String> values) {
            return notIn(styleName, values);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameBetween(String value1, String value2) {
            return between(styleName, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andStyleNameNotBetween(String value1, String value2) {
            return notBetween(styleName, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguCustomerStyleExample.Criteria andCIdIsNull() {
            return isNull(cId);
        }

        public ShiguCustomerStyleExample.Criteria andCIdIsNotNull() {
            return isNotNull(cId);
        }

        public ShiguCustomerStyleExample.Criteria andCIdEqualTo(Long value) {
            return equalTo(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdNotEqualTo(Long value) {
            return notEqualTo(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdGreaterThan(Long value) {
            return greaterThan(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdLessThan(Long value) {
            return lessThan(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cId, value);
        }

        public ShiguCustomerStyleExample.Criteria andCIdIn(List<Long> values) {
            return in(cId, values);
        }

        public ShiguCustomerStyleExample.Criteria andCIdNotIn(List<Long> values) {
            return notIn(cId, values);
        }

        public ShiguCustomerStyleExample.Criteria andCIdBetween(Long value1, Long value2) {
            return between(cId, value1, value2);
        }

        public ShiguCustomerStyleExample.Criteria andCIdNotBetween(Long value1, Long value2) {
            return notBetween(cId, value1, value2);
        }
    }
}