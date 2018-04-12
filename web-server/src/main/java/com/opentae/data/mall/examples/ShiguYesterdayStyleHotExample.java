package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguYesterdayStyleHot;

import java.util.*;
public class ShiguYesterdayStyleHotExample extends SgExample<ShiguYesterdayStyleHotExample.Criteria> {
    public static final Class<ShiguYesterdayStyleHot> beanClass = ShiguYesterdayStyleHot.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn picPath;
    public static EntityColumn marketName;
    public static EntityColumn piPrice;
    public static EntityColumn parentStyleId;
    public static EntityColumn shopNum;
    public static EntityColumn goodsId;
    public static EntityColumn showDay;
    public static EntityColumn shopId;
    public static EntityColumn id;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        picPath = listMap.get("picPath");
        marketName = listMap.get("marketName");
        piPrice = listMap.get("piPrice");
        parentStyleId = listMap.get("parentStyleId");
        shopNum = listMap.get("shopNum");
        goodsId = listMap.get("goodsId");
        showDay = listMap.get("showDay");
        shopId = listMap.get("shopId");
        id = listMap.get("id");
        }

    public ShiguYesterdayStyleHotExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguYesterdayStyleHotExample.Criteria createCriteriaInternal() {
        return new ShiguYesterdayStyleHotExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andPiPriceIsNull() {
            return isNull(piPrice);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceIsNotNull() {
            return isNotNull(piPrice);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceEqualTo(String value) {
            return equalTo(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceNotEqualTo(String value) {
            return notEqualTo(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceGreaterThan(String value) {
            return greaterThan(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceLessThan(String value) {
            return lessThan(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceLike(String value) {
            return like(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceNotLike(String value) {
            return notLike(piPrice, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceIn(List<String> values) {
            return in(piPrice, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceNotIn(List<String> values) {
            return notIn(piPrice, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceBetween(String value1, String value2) {
            return between(piPrice, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andPiPriceNotBetween(String value1, String value2) {
            return notBetween(piPrice, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdIsNull() {
            return isNull(parentStyleId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdIsNotNull() {
            return isNotNull(parentStyleId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdEqualTo(Long value) {
            return equalTo(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdNotEqualTo(Long value) {
            return notEqualTo(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdGreaterThan(Long value) {
            return greaterThan(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdLessThan(Long value) {
            return lessThan(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentStyleId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdIn(List<Long> values) {
            return in(parentStyleId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdNotIn(List<Long> values) {
            return notIn(parentStyleId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdBetween(Long value1, Long value2) {
            return between(parentStyleId, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andParentStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(parentStyleId, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andShowDayIsNull() {
            return isNull(showDay);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayIsNotNull() {
            return isNotNull(showDay);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayEqualTo(String value) {
            return equalTo(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayNotEqualTo(String value) {
            return notEqualTo(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayGreaterThan(String value) {
            return greaterThan(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayLessThan(String value) {
            return lessThan(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayLike(String value) {
            return like(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayNotLike(String value) {
            return notLike(showDay, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayIn(List<String> values) {
            return in(showDay, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayNotIn(List<String> values) {
            return notIn(showDay, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayBetween(String value1, String value2) {
            return between(showDay, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShowDayNotBetween(String value1, String value2) {
            return notBetween(showDay, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguYesterdayStyleHotExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguYesterdayStyleHotExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
    }
}