package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsSingleSku;

import java.util.*;
public class ShiguGoodsSingleSkuExample extends SgExample<ShiguGoodsSingleSkuExample.Criteria> {
    public static final Class<ShiguGoodsSingleSku> beanClass = ShiguGoodsSingleSku.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn colorName;
    public static EntityColumn priceString;
    public static EntityColumn goodsId;
    public static EntityColumn colorVid;
    public static EntityColumn sizeInputStr;
    public static EntityColumn colorPropertyAlias;
    public static EntityColumn colorPid;
    public static EntityColumn colorInputStr;
    public static EntityColumn sizeVid;
    public static EntityColumn sizeName;
    public static EntityColumn sizePid;
    public static EntityColumn stockNum;
    public static EntityColumn sizePropertyAlias;
    public static EntityColumn skuId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        colorName = listMap.get("colorName");
        priceString = listMap.get("priceString");
        goodsId = listMap.get("goodsId");
        colorVid = listMap.get("colorVid");
        sizeInputStr = listMap.get("sizeInputStr");
        colorPropertyAlias = listMap.get("colorPropertyAlias");
        colorPid = listMap.get("colorPid");
        colorInputStr = listMap.get("colorInputStr");
        sizeVid = listMap.get("sizeVid");
        sizeName = listMap.get("sizeName");
        sizePid = listMap.get("sizePid");
        stockNum = listMap.get("stockNum");
        sizePropertyAlias = listMap.get("sizePropertyAlias");
        skuId = listMap.get("skuId");
        status = listMap.get("status");
        }

    public ShiguGoodsSingleSkuExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsSingleSkuExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsSingleSkuExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameIsNull() {
            return isNull(colorName);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameIsNotNull() {
            return isNotNull(colorName);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameEqualTo(String value) {
            return equalTo(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameNotEqualTo(String value) {
            return notEqualTo(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameGreaterThan(String value) {
            return greaterThan(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameLessThan(String value) {
            return lessThan(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameLike(String value) {
            return like(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameNotLike(String value) {
            return notLike(colorName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameIn(List<String> values) {
            return in(colorName, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameNotIn(List<String> values) {
            return notIn(colorName, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameBetween(String value1, String value2) {
            return between(colorName, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorNameNotBetween(String value1, String value2) {
            return notBetween(colorName, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andPriceStringIsNull() {
            return isNull(priceString);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringIsNotNull() {
            return isNotNull(priceString);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringEqualTo(String value) {
            return equalTo(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringNotEqualTo(String value) {
            return notEqualTo(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringGreaterThan(String value) {
            return greaterThan(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringLessThan(String value) {
            return lessThan(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringLike(String value) {
            return like(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringNotLike(String value) {
            return notLike(priceString, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringIn(List<String> values) {
            return in(priceString, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringNotIn(List<String> values) {
            return notIn(priceString, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringBetween(String value1, String value2) {
            return between(priceString, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andPriceStringNotBetween(String value1, String value2) {
            return notBetween(priceString, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andColorVidIsNull() {
            return isNull(colorVid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidIsNotNull() {
            return isNotNull(colorVid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidEqualTo(Long value) {
            return equalTo(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidNotEqualTo(Long value) {
            return notEqualTo(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidGreaterThan(Long value) {
            return greaterThan(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidLessThan(Long value) {
            return lessThan(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(colorVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidIn(List<Long> values) {
            return in(colorVid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidNotIn(List<Long> values) {
            return notIn(colorVid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidBetween(Long value1, Long value2) {
            return between(colorVid, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorVidNotBetween(Long value1, Long value2) {
            return notBetween(colorVid, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrIsNull() {
            return isNull(sizeInputStr);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrIsNotNull() {
            return isNotNull(sizeInputStr);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrEqualTo(String value) {
            return equalTo(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrNotEqualTo(String value) {
            return notEqualTo(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrGreaterThan(String value) {
            return greaterThan(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrLessThan(String value) {
            return lessThan(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrLike(String value) {
            return like(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrNotLike(String value) {
            return notLike(sizeInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrIn(List<String> values) {
            return in(sizeInputStr, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrNotIn(List<String> values) {
            return notIn(sizeInputStr, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrBetween(String value1, String value2) {
            return between(sizeInputStr, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeInputStrNotBetween(String value1, String value2) {
            return notBetween(sizeInputStr, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasIsNull() {
            return isNull(colorPropertyAlias);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasIsNotNull() {
            return isNotNull(colorPropertyAlias);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasEqualTo(String value) {
            return equalTo(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasNotEqualTo(String value) {
            return notEqualTo(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasGreaterThan(String value) {
            return greaterThan(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasLessThan(String value) {
            return lessThan(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasLike(String value) {
            return like(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasNotLike(String value) {
            return notLike(colorPropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasIn(List<String> values) {
            return in(colorPropertyAlias, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasNotIn(List<String> values) {
            return notIn(colorPropertyAlias, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasBetween(String value1, String value2) {
            return between(colorPropertyAlias, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPropertyAliasNotBetween(String value1, String value2) {
            return notBetween(colorPropertyAlias, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andColorPidIsNull() {
            return isNull(colorPid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidIsNotNull() {
            return isNotNull(colorPid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidEqualTo(Long value) {
            return equalTo(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidNotEqualTo(Long value) {
            return notEqualTo(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidGreaterThan(Long value) {
            return greaterThan(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidLessThan(Long value) {
            return lessThan(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(colorPid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidIn(List<Long> values) {
            return in(colorPid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidNotIn(List<Long> values) {
            return notIn(colorPid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidBetween(Long value1, Long value2) {
            return between(colorPid, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorPidNotBetween(Long value1, Long value2) {
            return notBetween(colorPid, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrIsNull() {
            return isNull(colorInputStr);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrIsNotNull() {
            return isNotNull(colorInputStr);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrEqualTo(String value) {
            return equalTo(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrNotEqualTo(String value) {
            return notEqualTo(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrGreaterThan(String value) {
            return greaterThan(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrLessThan(String value) {
            return lessThan(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrLike(String value) {
            return like(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrNotLike(String value) {
            return notLike(colorInputStr, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrIn(List<String> values) {
            return in(colorInputStr, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrNotIn(List<String> values) {
            return notIn(colorInputStr, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrBetween(String value1, String value2) {
            return between(colorInputStr, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andColorInputStrNotBetween(String value1, String value2) {
            return notBetween(colorInputStr, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSizeVidIsNull() {
            return isNull(sizeVid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidIsNotNull() {
            return isNotNull(sizeVid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidEqualTo(Long value) {
            return equalTo(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidNotEqualTo(Long value) {
            return notEqualTo(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidGreaterThan(Long value) {
            return greaterThan(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidLessThan(Long value) {
            return lessThan(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sizeVid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidIn(List<Long> values) {
            return in(sizeVid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidNotIn(List<Long> values) {
            return notIn(sizeVid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidBetween(Long value1, Long value2) {
            return between(sizeVid, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeVidNotBetween(Long value1, Long value2) {
            return notBetween(sizeVid, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSizeNameIsNull() {
            return isNull(sizeName);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameIsNotNull() {
            return isNotNull(sizeName);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameEqualTo(String value) {
            return equalTo(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameNotEqualTo(String value) {
            return notEqualTo(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameGreaterThan(String value) {
            return greaterThan(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameLessThan(String value) {
            return lessThan(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameLike(String value) {
            return like(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameNotLike(String value) {
            return notLike(sizeName, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameIn(List<String> values) {
            return in(sizeName, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameNotIn(List<String> values) {
            return notIn(sizeName, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameBetween(String value1, String value2) {
            return between(sizeName, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizeNameNotBetween(String value1, String value2) {
            return notBetween(sizeName, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSizePidIsNull() {
            return isNull(sizePid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidIsNotNull() {
            return isNotNull(sizePid);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidEqualTo(Long value) {
            return equalTo(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidNotEqualTo(Long value) {
            return notEqualTo(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidGreaterThan(Long value) {
            return greaterThan(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidLessThan(Long value) {
            return lessThan(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sizePid, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidIn(List<Long> values) {
            return in(sizePid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidNotIn(List<Long> values) {
            return notIn(sizePid, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidBetween(Long value1, Long value2) {
            return between(sizePid, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePidNotBetween(Long value1, Long value2) {
            return notBetween(sizePid, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andStockNumIsNull() {
            return isNull(stockNum);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumIsNotNull() {
            return isNotNull(stockNum);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumEqualTo(Integer value) {
            return equalTo(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumNotEqualTo(Integer value) {
            return notEqualTo(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumGreaterThan(Integer value) {
            return greaterThan(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumLessThan(Integer value) {
            return lessThan(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockNum, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumIn(List<Integer> values) {
            return in(stockNum, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumNotIn(List<Integer> values) {
            return notIn(stockNum, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumBetween(Integer value1, Integer value2) {
            return between(stockNum, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            return notBetween(stockNum, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasIsNull() {
            return isNull(sizePropertyAlias);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasIsNotNull() {
            return isNotNull(sizePropertyAlias);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasEqualTo(String value) {
            return equalTo(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasNotEqualTo(String value) {
            return notEqualTo(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasGreaterThan(String value) {
            return greaterThan(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasLessThan(String value) {
            return lessThan(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasLike(String value) {
            return like(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasNotLike(String value) {
            return notLike(sizePropertyAlias, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasIn(List<String> values) {
            return in(sizePropertyAlias, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasNotIn(List<String> values) {
            return notIn(sizePropertyAlias, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasBetween(String value1, String value2) {
            return between(sizePropertyAlias, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSizePropertyAliasNotBetween(String value1, String value2) {
            return notBetween(sizePropertyAlias, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
        public ShiguGoodsSingleSkuExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguGoodsSingleSkuExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}