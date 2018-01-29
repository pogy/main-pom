package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsPiPriceError;

import java.util.*;

public class GoodsPiPriceErrorExample extends SgExample<GoodsPiPriceErrorExample.Criteria> {
    public static final Class<GoodsPiPriceError> beanClass = GoodsPiPriceError.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsNo;
    public static EntityColumn otherId;
    public static EntityColumn goodsId;
    public static EntityColumn numIid;
    public static EntityColumn title;
    public static EntityColumn pipriceId;
    public static EntityColumn webSite;
    public static EntityColumn createTime;
    public static EntityColumn hasEnt;
    public static EntityColumn price;
    public static EntityColumn customPiPrice;
    public static EntityColumn lastModifyTime;
    public static EntityColumn errorPiPrice;
    public static EntityColumn sysPiPrice;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsNo = listMap.get("goodsNo");
        otherId = listMap.get("otherId");
        goodsId = listMap.get("goodsId");
        numIid = listMap.get("numIid");
        title = listMap.get("title");
        pipriceId = listMap.get("pipriceId");
        webSite = listMap.get("webSite");
        createTime = listMap.get("createTime");
        hasEnt = listMap.get("hasEnt");
        price = listMap.get("price");
        customPiPrice = listMap.get("customPiPrice");
        lastModifyTime = listMap.get("lastModifyTime");
        errorPiPrice = listMap.get("errorPiPrice");
        sysPiPrice = listMap.get("sysPiPrice");
        }

    public GoodsPiPriceErrorExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsPiPriceErrorExample.Criteria createCriteriaInternal() {
        return new GoodsPiPriceErrorExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andOtherIdIsNull() {
            return isNull(otherId);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdIsNotNull() {
            return isNotNull(otherId);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdEqualTo(String value) {
            return equalTo(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdNotEqualTo(String value) {
            return notEqualTo(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdGreaterThan(String value) {
            return greaterThan(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdLessThan(String value) {
            return lessThan(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdLike(String value) {
            return like(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdNotLike(String value) {
            return notLike(otherId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdIn(List<String> values) {
            return in(otherId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdNotIn(List<String> values) {
            return notIn(otherId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdBetween(String value1, String value2) {
            return between(otherId, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andOtherIdNotBetween(String value1, String value2) {
            return notBetween(otherId, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andPipriceIdIsNull() {
            return isNull(pipriceId);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdIsNotNull() {
            return isNotNull(pipriceId);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdEqualTo(Long value) {
            return equalTo(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdNotEqualTo(Long value) {
            return notEqualTo(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdGreaterThan(Long value) {
            return greaterThan(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdLessThan(Long value) {
            return lessThan(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pipriceId, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdIn(List<Long> values) {
            return in(pipriceId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdNotIn(List<Long> values) {
            return notIn(pipriceId, values);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdBetween(Long value1, Long value2) {
            return between(pipriceId, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andPipriceIdNotBetween(Long value1, Long value2) {
            return notBetween(pipriceId, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andHasEntIsNull() {
            return isNull(hasEnt);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntIsNotNull() {
            return isNotNull(hasEnt);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntEqualTo(Integer value) {
            return equalTo(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntNotEqualTo(Integer value) {
            return notEqualTo(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntGreaterThan(Integer value) {
            return greaterThan(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntLessThan(Integer value) {
            return lessThan(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasEnt, value);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntIn(List<Integer> values) {
            return in(hasEnt, values);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntNotIn(List<Integer> values) {
            return notIn(hasEnt, values);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntBetween(Integer value1, Integer value2) {
            return between(hasEnt, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andHasEntNotBetween(Integer value1, Integer value2) {
            return notBetween(hasEnt, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceIsNull() {
            return isNull(customPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceIsNotNull() {
            return isNotNull(customPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceEqualTo(Long value) {
            return equalTo(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceNotEqualTo(Long value) {
            return notEqualTo(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceGreaterThan(Long value) {
            return greaterThan(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceLessThan(Long value) {
            return lessThan(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(customPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceIn(List<Long> values) {
            return in(customPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceNotIn(List<Long> values) {
            return notIn(customPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceBetween(Long value1, Long value2) {
            return between(customPiPrice, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andCustomPiPriceNotBetween(Long value1, Long value2) {
            return notBetween(customPiPrice, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceIsNull() {
            return isNull(errorPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceIsNotNull() {
            return isNotNull(errorPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceEqualTo(String value) {
            return equalTo(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceNotEqualTo(String value) {
            return notEqualTo(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceGreaterThan(String value) {
            return greaterThan(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceLessThan(String value) {
            return lessThan(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceLike(String value) {
            return like(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceNotLike(String value) {
            return notLike(errorPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceIn(List<String> values) {
            return in(errorPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceNotIn(List<String> values) {
            return notIn(errorPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceBetween(String value1, String value2) {
            return between(errorPiPrice, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andErrorPiPriceNotBetween(String value1, String value2) {
            return notBetween(errorPiPrice, value1, value2);
        }
        public GoodsPiPriceErrorExample.Criteria andSysPiPriceIsNull() {
            return isNull(sysPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceIsNotNull() {
            return isNotNull(sysPiPrice);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceEqualTo(Long value) {
            return equalTo(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceNotEqualTo(Long value) {
            return notEqualTo(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceGreaterThan(Long value) {
            return greaterThan(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceLessThan(Long value) {
            return lessThan(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sysPiPrice, value);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceIn(List<Long> values) {
            return in(sysPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceNotIn(List<Long> values) {
            return notIn(sysPiPrice, values);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceBetween(Long value1, Long value2) {
            return between(sysPiPrice, value1, value2);
        }

        public GoodsPiPriceErrorExample.Criteria andSysPiPriceNotBetween(Long value1, Long value2) {
            return notBetween(sysPiPrice, value1, value2);
        }
    }
}