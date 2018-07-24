package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsSingleSku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andColorNameIsNull() {
            return isNull(colorName);
        }

        public Criteria andColorNameIsNotNull() {
            return isNotNull(colorName);
        }

        public Criteria andColorNameEqualTo(String value) {
            return equalTo(colorName, value);
        }

        public Criteria andColorNameNotEqualTo(String value) {
            return notEqualTo(colorName, value);
        }

        public Criteria andColorNameGreaterThan(String value) {
            return greaterThan(colorName, value);
        }

        public Criteria andColorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorName, value);
        }

        public Criteria andColorNameLessThan(String value) {
            return lessThan(colorName, value);
        }

        public Criteria andColorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorName, value);
        }

        public Criteria andColorNameLike(String value) {
            return like(colorName, value);
        }

        public Criteria andColorNameNotLike(String value) {
            return notLike(colorName, value);
        }

        public Criteria andColorNameIn(List<String> values) {
            return in(colorName, values);
        }

        public Criteria andColorNameNotIn(List<String> values) {
            return notIn(colorName, values);
        }

        public Criteria andColorNameBetween(String value1, String value2) {
            return between(colorName, value1, value2);
        }

        public Criteria andColorNameNotBetween(String value1, String value2) {
            return notBetween(colorName, value1, value2);
        }
        public Criteria andPriceStringIsNull() {
            return isNull(priceString);
        }

        public Criteria andPriceStringIsNotNull() {
            return isNotNull(priceString);
        }

        public Criteria andPriceStringEqualTo(String value) {
            return equalTo(priceString, value);
        }

        public Criteria andPriceStringNotEqualTo(String value) {
            return notEqualTo(priceString, value);
        }

        public Criteria andPriceStringGreaterThan(String value) {
            return greaterThan(priceString, value);
        }

        public Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceString, value);
        }

        public Criteria andPriceStringLessThan(String value) {
            return lessThan(priceString, value);
        }

        public Criteria andPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceString, value);
        }

        public Criteria andPriceStringLike(String value) {
            return like(priceString, value);
        }

        public Criteria andPriceStringNotLike(String value) {
            return notLike(priceString, value);
        }

        public Criteria andPriceStringIn(List<String> values) {
            return in(priceString, values);
        }

        public Criteria andPriceStringNotIn(List<String> values) {
            return notIn(priceString, values);
        }

        public Criteria andPriceStringBetween(String value1, String value2) {
            return between(priceString, value1, value2);
        }

        public Criteria andPriceStringNotBetween(String value1, String value2) {
            return notBetween(priceString, value1, value2);
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
        public Criteria andColorVidIsNull() {
            return isNull(colorVid);
        }

        public Criteria andColorVidIsNotNull() {
            return isNotNull(colorVid);
        }

        public Criteria andColorVidEqualTo(Long value) {
            return equalTo(colorVid, value);
        }

        public Criteria andColorVidNotEqualTo(Long value) {
            return notEqualTo(colorVid, value);
        }

        public Criteria andColorVidGreaterThan(Long value) {
            return greaterThan(colorVid, value);
        }

        public Criteria andColorVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(colorVid, value);
        }

        public Criteria andColorVidLessThan(Long value) {
            return lessThan(colorVid, value);
        }

        public Criteria andColorVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(colorVid, value);
        }

        public Criteria andColorVidIn(List<Long> values) {
            return in(colorVid, values);
        }

        public Criteria andColorVidNotIn(List<Long> values) {
            return notIn(colorVid, values);
        }

        public Criteria andColorVidBetween(Long value1, Long value2) {
            return between(colorVid, value1, value2);
        }

        public Criteria andColorVidNotBetween(Long value1, Long value2) {
            return notBetween(colorVid, value1, value2);
        }
        public Criteria andSizeInputStrIsNull() {
            return isNull(sizeInputStr);
        }

        public Criteria andSizeInputStrIsNotNull() {
            return isNotNull(sizeInputStr);
        }

        public Criteria andSizeInputStrEqualTo(String value) {
            return equalTo(sizeInputStr, value);
        }

        public Criteria andSizeInputStrNotEqualTo(String value) {
            return notEqualTo(sizeInputStr, value);
        }

        public Criteria andSizeInputStrGreaterThan(String value) {
            return greaterThan(sizeInputStr, value);
        }

        public Criteria andSizeInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizeInputStr, value);
        }

        public Criteria andSizeInputStrLessThan(String value) {
            return lessThan(sizeInputStr, value);
        }

        public Criteria andSizeInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizeInputStr, value);
        }

        public Criteria andSizeInputStrLike(String value) {
            return like(sizeInputStr, value);
        }

        public Criteria andSizeInputStrNotLike(String value) {
            return notLike(sizeInputStr, value);
        }

        public Criteria andSizeInputStrIn(List<String> values) {
            return in(sizeInputStr, values);
        }

        public Criteria andSizeInputStrNotIn(List<String> values) {
            return notIn(sizeInputStr, values);
        }

        public Criteria andSizeInputStrBetween(String value1, String value2) {
            return between(sizeInputStr, value1, value2);
        }

        public Criteria andSizeInputStrNotBetween(String value1, String value2) {
            return notBetween(sizeInputStr, value1, value2);
        }
        public Criteria andColorPropertyAliasIsNull() {
            return isNull(colorPropertyAlias);
        }

        public Criteria andColorPropertyAliasIsNotNull() {
            return isNotNull(colorPropertyAlias);
        }

        public Criteria andColorPropertyAliasEqualTo(String value) {
            return equalTo(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasNotEqualTo(String value) {
            return notEqualTo(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasGreaterThan(String value) {
            return greaterThan(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasLessThan(String value) {
            return lessThan(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasLike(String value) {
            return like(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasNotLike(String value) {
            return notLike(colorPropertyAlias, value);
        }

        public Criteria andColorPropertyAliasIn(List<String> values) {
            return in(colorPropertyAlias, values);
        }

        public Criteria andColorPropertyAliasNotIn(List<String> values) {
            return notIn(colorPropertyAlias, values);
        }

        public Criteria andColorPropertyAliasBetween(String value1, String value2) {
            return between(colorPropertyAlias, value1, value2);
        }

        public Criteria andColorPropertyAliasNotBetween(String value1, String value2) {
            return notBetween(colorPropertyAlias, value1, value2);
        }
        public Criteria andColorPidIsNull() {
            return isNull(colorPid);
        }

        public Criteria andColorPidIsNotNull() {
            return isNotNull(colorPid);
        }

        public Criteria andColorPidEqualTo(Long value) {
            return equalTo(colorPid, value);
        }

        public Criteria andColorPidNotEqualTo(Long value) {
            return notEqualTo(colorPid, value);
        }

        public Criteria andColorPidGreaterThan(Long value) {
            return greaterThan(colorPid, value);
        }

        public Criteria andColorPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(colorPid, value);
        }

        public Criteria andColorPidLessThan(Long value) {
            return lessThan(colorPid, value);
        }

        public Criteria andColorPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(colorPid, value);
        }

        public Criteria andColorPidIn(List<Long> values) {
            return in(colorPid, values);
        }

        public Criteria andColorPidNotIn(List<Long> values) {
            return notIn(colorPid, values);
        }

        public Criteria andColorPidBetween(Long value1, Long value2) {
            return between(colorPid, value1, value2);
        }

        public Criteria andColorPidNotBetween(Long value1, Long value2) {
            return notBetween(colorPid, value1, value2);
        }
        public Criteria andColorInputStrIsNull() {
            return isNull(colorInputStr);
        }

        public Criteria andColorInputStrIsNotNull() {
            return isNotNull(colorInputStr);
        }

        public Criteria andColorInputStrEqualTo(String value) {
            return equalTo(colorInputStr, value);
        }

        public Criteria andColorInputStrNotEqualTo(String value) {
            return notEqualTo(colorInputStr, value);
        }

        public Criteria andColorInputStrGreaterThan(String value) {
            return greaterThan(colorInputStr, value);
        }

        public Criteria andColorInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(colorInputStr, value);
        }

        public Criteria andColorInputStrLessThan(String value) {
            return lessThan(colorInputStr, value);
        }

        public Criteria andColorInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(colorInputStr, value);
        }

        public Criteria andColorInputStrLike(String value) {
            return like(colorInputStr, value);
        }

        public Criteria andColorInputStrNotLike(String value) {
            return notLike(colorInputStr, value);
        }

        public Criteria andColorInputStrIn(List<String> values) {
            return in(colorInputStr, values);
        }

        public Criteria andColorInputStrNotIn(List<String> values) {
            return notIn(colorInputStr, values);
        }

        public Criteria andColorInputStrBetween(String value1, String value2) {
            return between(colorInputStr, value1, value2);
        }

        public Criteria andColorInputStrNotBetween(String value1, String value2) {
            return notBetween(colorInputStr, value1, value2);
        }
        public Criteria andSizeVidIsNull() {
            return isNull(sizeVid);
        }

        public Criteria andSizeVidIsNotNull() {
            return isNotNull(sizeVid);
        }

        public Criteria andSizeVidEqualTo(Long value) {
            return equalTo(sizeVid, value);
        }

        public Criteria andSizeVidNotEqualTo(Long value) {
            return notEqualTo(sizeVid, value);
        }

        public Criteria andSizeVidGreaterThan(Long value) {
            return greaterThan(sizeVid, value);
        }

        public Criteria andSizeVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sizeVid, value);
        }

        public Criteria andSizeVidLessThan(Long value) {
            return lessThan(sizeVid, value);
        }

        public Criteria andSizeVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sizeVid, value);
        }

        public Criteria andSizeVidIn(List<Long> values) {
            return in(sizeVid, values);
        }

        public Criteria andSizeVidNotIn(List<Long> values) {
            return notIn(sizeVid, values);
        }

        public Criteria andSizeVidBetween(Long value1, Long value2) {
            return between(sizeVid, value1, value2);
        }

        public Criteria andSizeVidNotBetween(Long value1, Long value2) {
            return notBetween(sizeVid, value1, value2);
        }
        public Criteria andSizeNameIsNull() {
            return isNull(sizeName);
        }

        public Criteria andSizeNameIsNotNull() {
            return isNotNull(sizeName);
        }

        public Criteria andSizeNameEqualTo(String value) {
            return equalTo(sizeName, value);
        }

        public Criteria andSizeNameNotEqualTo(String value) {
            return notEqualTo(sizeName, value);
        }

        public Criteria andSizeNameGreaterThan(String value) {
            return greaterThan(sizeName, value);
        }

        public Criteria andSizeNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizeName, value);
        }

        public Criteria andSizeNameLessThan(String value) {
            return lessThan(sizeName, value);
        }

        public Criteria andSizeNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizeName, value);
        }

        public Criteria andSizeNameLike(String value) {
            return like(sizeName, value);
        }

        public Criteria andSizeNameNotLike(String value) {
            return notLike(sizeName, value);
        }

        public Criteria andSizeNameIn(List<String> values) {
            return in(sizeName, values);
        }

        public Criteria andSizeNameNotIn(List<String> values) {
            return notIn(sizeName, values);
        }

        public Criteria andSizeNameBetween(String value1, String value2) {
            return between(sizeName, value1, value2);
        }

        public Criteria andSizeNameNotBetween(String value1, String value2) {
            return notBetween(sizeName, value1, value2);
        }
        public Criteria andSizePidIsNull() {
            return isNull(sizePid);
        }

        public Criteria andSizePidIsNotNull() {
            return isNotNull(sizePid);
        }

        public Criteria andSizePidEqualTo(Long value) {
            return equalTo(sizePid, value);
        }

        public Criteria andSizePidNotEqualTo(Long value) {
            return notEqualTo(sizePid, value);
        }

        public Criteria andSizePidGreaterThan(Long value) {
            return greaterThan(sizePid, value);
        }

        public Criteria andSizePidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sizePid, value);
        }

        public Criteria andSizePidLessThan(Long value) {
            return lessThan(sizePid, value);
        }

        public Criteria andSizePidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sizePid, value);
        }

        public Criteria andSizePidIn(List<Long> values) {
            return in(sizePid, values);
        }

        public Criteria andSizePidNotIn(List<Long> values) {
            return notIn(sizePid, values);
        }

        public Criteria andSizePidBetween(Long value1, Long value2) {
            return between(sizePid, value1, value2);
        }

        public Criteria andSizePidNotBetween(Long value1, Long value2) {
            return notBetween(sizePid, value1, value2);
        }
        public Criteria andStockNumIsNull() {
            return isNull(stockNum);
        }

        public Criteria andStockNumIsNotNull() {
            return isNotNull(stockNum);
        }

        public Criteria andStockNumEqualTo(Integer value) {
            return equalTo(stockNum, value);
        }

        public Criteria andStockNumNotEqualTo(Integer value) {
            return notEqualTo(stockNum, value);
        }

        public Criteria andStockNumGreaterThan(Integer value) {
            return greaterThan(stockNum, value);
        }

        public Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockNum, value);
        }

        public Criteria andStockNumLessThan(Integer value) {
            return lessThan(stockNum, value);
        }

        public Criteria andStockNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockNum, value);
        }

        public Criteria andStockNumIn(List<Integer> values) {
            return in(stockNum, values);
        }

        public Criteria andStockNumNotIn(List<Integer> values) {
            return notIn(stockNum, values);
        }

        public Criteria andStockNumBetween(Integer value1, Integer value2) {
            return between(stockNum, value1, value2);
        }

        public Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            return notBetween(stockNum, value1, value2);
        }
        public Criteria andSizePropertyAliasIsNull() {
            return isNull(sizePropertyAlias);
        }

        public Criteria andSizePropertyAliasIsNotNull() {
            return isNotNull(sizePropertyAlias);
        }

        public Criteria andSizePropertyAliasEqualTo(String value) {
            return equalTo(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasNotEqualTo(String value) {
            return notEqualTo(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasGreaterThan(String value) {
            return greaterThan(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasLessThan(String value) {
            return lessThan(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasLike(String value) {
            return like(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasNotLike(String value) {
            return notLike(sizePropertyAlias, value);
        }

        public Criteria andSizePropertyAliasIn(List<String> values) {
            return in(sizePropertyAlias, values);
        }

        public Criteria andSizePropertyAliasNotIn(List<String> values) {
            return notIn(sizePropertyAlias, values);
        }

        public Criteria andSizePropertyAliasBetween(String value1, String value2) {
            return between(sizePropertyAlias, value1, value2);
        }

        public Criteria andSizePropertyAliasNotBetween(String value1, String value2) {
            return notBetween(sizePropertyAlias, value1, value2);
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