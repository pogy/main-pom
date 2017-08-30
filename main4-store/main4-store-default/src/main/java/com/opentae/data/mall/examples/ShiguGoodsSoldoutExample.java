package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;

import java.util.*;
public class ShiguGoodsSoldoutExample extends SgExample<ShiguGoodsSoldoutExample.Criteria> {
    public static final Class<ShiguGoodsSoldout> beanClass = ShiguGoodsSoldout.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn validThru;
    public static EntityColumn freightPayer;
    public static EntityColumn numIid;
    public static EntityColumn num;
    public static EntityColumn soldoutTime;
    public static EntityColumn type;
    public static EntityColumn expressFee;
    public static EntityColumn piPriceString;
    public static EntityColumn picUrl;
    public static EntityColumn soldUserId;
    public static EntityColumn priceRole;
    public static EntityColumn price;
    public static EntityColumn modified;
    public static EntityColumn isEfficacious;
    public static EntityColumn notNumberTradableGoods;
    public static EntityColumn created;
    public static EntityColumn isTaobaoSynchronization;
    public static EntityColumn isFenxiao;
    public static EntityColumn market;
    public static EntityColumn remark9;
    public static EntityColumn emsFee;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn isLightningConsignment;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn detailUrl;
    public static EntityColumn remark6;
    public static EntityColumn storeNum;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn cid;
    public static EntityColumn listTime;
    public static EntityColumn remark2;
    public static EntityColumn priceString;
    public static EntityColumn city;
    public static EntityColumn goodsId;
    public static EntityColumn title;
    public static EntityColumn hasShowcase;
    public static EntityColumn isXinpin;
    public static EntityColumn marketId;
    public static EntityColumn nick;
    public static EntityColumn webSite;
    public static EntityColumn isAkeyToUpload;
    public static EntityColumn piPrice;
    public static EntityColumn numberTradableGoods;
    public static EntityColumn isTrade;
    public static EntityColumn prov;
    public static EntityColumn goodsNo;
    public static EntityColumn soldOutTime;
    public static EntityColumn cidAll;
    public static EntityColumn hasDiscount;
    public static EntityColumn parentMarketId;
    public static EntityColumn delistTime;
    public static EntityColumn postFee;
    public static EntityColumn storeId;
    public static EntityColumn isStandard;
    public static EntityColumn isClosed;
    public static EntityColumn goodsStatus;
    public static EntityColumn isExcelImp;
    public static EntityColumn stuffStatus;
    public static EntityColumn parentMarketName;
    public static EntityColumn clicks;
    public static EntityColumn outerId;
    public static EntityColumn soldoutReason;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        validThru = listMap.get("validThru");
        freightPayer = listMap.get("freightPayer");
        numIid = listMap.get("numIid");
        num = listMap.get("num");
        soldoutTime = listMap.get("soldoutTime");
        type = listMap.get("type");
        expressFee = listMap.get("expressFee");
        piPriceString = listMap.get("piPriceString");
        picUrl = listMap.get("picUrl");
        soldUserId = listMap.get("soldUserId");
        priceRole = listMap.get("priceRole");
        price = listMap.get("price");
        modified = listMap.get("modified");
        isEfficacious = listMap.get("isEfficacious");
        notNumberTradableGoods = listMap.get("notNumberTradableGoods");
        created = listMap.get("created");
        isTaobaoSynchronization = listMap.get("isTaobaoSynchronization");
        isFenxiao = listMap.get("isFenxiao");
        market = listMap.get("market");
        remark9 = listMap.get("remark9");
        emsFee = listMap.get("emsFee");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        isLightningConsignment = listMap.get("isLightningConsignment");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        detailUrl = listMap.get("detailUrl");
        remark6 = listMap.get("remark6");
        storeNum = listMap.get("storeNum");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        cid = listMap.get("cid");
        listTime = listMap.get("listTime");
        remark2 = listMap.get("remark2");
        priceString = listMap.get("priceString");
        city = listMap.get("city");
        goodsId = listMap.get("goodsId");
        title = listMap.get("title");
        hasShowcase = listMap.get("hasShowcase");
        isXinpin = listMap.get("isXinpin");
        marketId = listMap.get("marketId");
        nick = listMap.get("nick");
        webSite = listMap.get("webSite");
        isAkeyToUpload = listMap.get("isAkeyToUpload");
        piPrice = listMap.get("piPrice");
        numberTradableGoods = listMap.get("numberTradableGoods");
        isTrade = listMap.get("isTrade");
        prov = listMap.get("prov");
        goodsNo = listMap.get("goodsNo");
        soldOutTime = listMap.get("soldOutTime");
        cidAll = listMap.get("cidAll");
        hasDiscount = listMap.get("hasDiscount");
        parentMarketId = listMap.get("parentMarketId");
        delistTime = listMap.get("delistTime");
        postFee = listMap.get("postFee");
        storeId = listMap.get("storeId");
        isStandard = listMap.get("isStandard");
        isClosed = listMap.get("isClosed");
        goodsStatus = listMap.get("goodsStatus");
        isExcelImp = listMap.get("isExcelImp");
        stuffStatus = listMap.get("stuffStatus");
        parentMarketName = listMap.get("parentMarketName");
        clicks = listMap.get("clicks");
        outerId = listMap.get("outerId");
        soldoutReason = listMap.get("soldoutReason");
        }

    public ShiguGoodsSoldoutExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsSoldoutExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsSoldoutExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruIsNull() {
            return isNull(validThru);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruIsNotNull() {
            return isNotNull(validThru);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruEqualTo(Long value) {
            return equalTo(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotEqualTo(Long value) {
            return notEqualTo(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruGreaterThan(Long value) {
            return greaterThan(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruLessThan(Long value) {
            return lessThan(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(validThru, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruIn(List<Long> values) {
            return in(validThru, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotIn(List<Long> values) {
            return notIn(validThru, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruBetween(Long value1, Long value2) {
            return between(validThru, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotBetween(Long value1, Long value2) {
            return notBetween(validThru, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIsNull() {
            return isNull(freightPayer);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIsNotNull() {
            return isNotNull(freightPayer);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerEqualTo(String value) {
            return equalTo(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotEqualTo(String value) {
            return notEqualTo(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerGreaterThan(String value) {
            return greaterThan(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLessThan(String value) {
            return lessThan(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLike(String value) {
            return like(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotLike(String value) {
            return notLike(freightPayer, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIn(List<String> values) {
            return in(freightPayer, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotIn(List<String> values) {
            return notIn(freightPayer, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerBetween(String value1, String value2) {
            return between(freightPayer, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotBetween(String value1, String value2) {
            return notBetween(freightPayer, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumEqualTo(Long value) {
            return equalTo(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotEqualTo(Long value) {
            return notEqualTo(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumGreaterThan(Long value) {
            return greaterThan(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumLessThan(Long value) {
            return lessThan(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(num, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIn(List<Long> values) {
            return in(num, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotIn(List<Long> values) {
            return notIn(num, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumBetween(Long value1, Long value2) {
            return between(num, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotBetween(Long value1, Long value2) {
            return notBetween(num, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIsNull() {
            return isNull(soldoutTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIsNotNull() {
            return isNotNull(soldoutTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeEqualTo(Date value) {
            return equalTo(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotEqualTo(Date value) {
            return notEqualTo(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeGreaterThan(Date value) {
            return greaterThan(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeLessThan(Date value) {
            return lessThan(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(soldoutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIn(List<Date> values) {
            return in(soldoutTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotIn(List<Date> values) {
            return notIn(soldoutTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeBetween(Date value1, Date value2) {
            return between(soldoutTime, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotBetween(Date value1, Date value2) {
            return notBetween(soldoutTime, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIsNull() {
            return isNull(piPriceString);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIsNotNull() {
            return isNotNull(piPriceString);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringEqualTo(String value) {
            return equalTo(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotEqualTo(String value) {
            return notEqualTo(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringGreaterThan(String value) {
            return greaterThan(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLessThan(String value) {
            return lessThan(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLike(String value) {
            return like(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotLike(String value) {
            return notLike(piPriceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIn(List<String> values) {
            return in(piPriceString, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotIn(List<String> values) {
            return notIn(piPriceString, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringBetween(String value1, String value2) {
            return between(piPriceString, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotBetween(String value1, String value2) {
            return notBetween(piPriceString, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIsNull() {
            return isNull(soldUserId);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIsNotNull() {
            return isNotNull(soldUserId);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdEqualTo(Long value) {
            return equalTo(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotEqualTo(Long value) {
            return notEqualTo(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdGreaterThan(Long value) {
            return greaterThan(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdLessThan(Long value) {
            return lessThan(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soldUserId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIn(List<Long> values) {
            return in(soldUserId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotIn(List<Long> values) {
            return notIn(soldUserId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdBetween(Long value1, Long value2) {
            return between(soldUserId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotBetween(Long value1, Long value2) {
            return notBetween(soldUserId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIsNull() {
            return isNull(priceRole);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIsNotNull() {
            return isNotNull(priceRole);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleEqualTo(String value) {
            return equalTo(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotEqualTo(String value) {
            return notEqualTo(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleGreaterThan(String value) {
            return greaterThan(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLessThan(String value) {
            return lessThan(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLike(String value) {
            return like(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotLike(String value) {
            return notLike(priceRole, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIn(List<String> values) {
            return in(priceRole, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotIn(List<String> values) {
            return notIn(priceRole, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleBetween(String value1, String value2) {
            return between(priceRole, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotBetween(String value1, String value2) {
            return notBetween(priceRole, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andModifiedIsNull() {
            return isNull(modified);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedIsNotNull() {
            return isNotNull(modified);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedEqualTo(Date value) {
            return equalTo(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotEqualTo(Date value) {
            return notEqualTo(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedGreaterThan(Date value) {
            return greaterThan(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedLessThan(Date value) {
            return lessThan(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modified, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedIn(List<Date> values) {
            return in(modified, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotIn(List<Date> values) {
            return notIn(modified, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedBetween(Date value1, Date value2) {
            return between(modified, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            return notBetween(modified, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIsNull() {
            return isNull(isEfficacious);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIsNotNull() {
            return isNotNull(isEfficacious);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousEqualTo(Long value) {
            return equalTo(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotEqualTo(Long value) {
            return notEqualTo(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousGreaterThan(Long value) {
            return greaterThan(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousLessThan(Long value) {
            return lessThan(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isEfficacious, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIn(List<Long> values) {
            return in(isEfficacious, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotIn(List<Long> values) {
            return notIn(isEfficacious, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousBetween(Long value1, Long value2) {
            return between(isEfficacious, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotBetween(Long value1, Long value2) {
            return notBetween(isEfficacious, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIsNull() {
            return isNull(notNumberTradableGoods);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIsNotNull() {
            return isNotNull(notNumberTradableGoods);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsEqualTo(Long value) {
            return equalTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotEqualTo(Long value) {
            return notEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsGreaterThan(Long value) {
            return greaterThan(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsLessThan(Long value) {
            return lessThan(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIn(List<Long> values) {
            return in(notNumberTradableGoods, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotIn(List<Long> values) {
            return notIn(notNumberTradableGoods, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsBetween(Long value1, Long value2) {
            return between(notNumberTradableGoods, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotBetween(Long value1, Long value2) {
            return notBetween(notNumberTradableGoods, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedEqualTo(Date value) {
            return equalTo(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotEqualTo(Date value) {
            return notEqualTo(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedGreaterThan(Date value) {
            return greaterThan(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedLessThan(Date value) {
            return lessThan(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(created, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedIn(List<Date> values) {
            return in(created, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotIn(List<Date> values) {
            return notIn(created, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedBetween(Date value1, Date value2) {
            return between(created, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            return notBetween(created, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIsNull() {
            return isNull(isTaobaoSynchronization);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIsNotNull() {
            return isNotNull(isTaobaoSynchronization);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationEqualTo(Long value) {
            return equalTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotEqualTo(Long value) {
            return notEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationGreaterThan(Long value) {
            return greaterThan(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationLessThan(Long value) {
            return lessThan(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIn(List<Long> values) {
            return in(isTaobaoSynchronization, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotIn(List<Long> values) {
            return notIn(isTaobaoSynchronization, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationBetween(Long value1, Long value2) {
            return between(isTaobaoSynchronization, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotBetween(Long value1, Long value2) {
            return notBetween(isTaobaoSynchronization, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIsNull() {
            return isNull(isFenxiao);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIsNotNull() {
            return isNotNull(isFenxiao);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoEqualTo(Long value) {
            return equalTo(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotEqualTo(Long value) {
            return notEqualTo(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoGreaterThan(Long value) {
            return greaterThan(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoLessThan(Long value) {
            return lessThan(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isFenxiao, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIn(List<Long> values) {
            return in(isFenxiao, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotIn(List<Long> values) {
            return notIn(isFenxiao, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoBetween(Long value1, Long value2) {
            return between(isFenxiao, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotBetween(Long value1, Long value2) {
            return notBetween(isFenxiao, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andMarketIsNull() {
            return isNull(market);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIsNotNull() {
            return isNotNull(market);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketEqualTo(String value) {
            return equalTo(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotEqualTo(String value) {
            return notEqualTo(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketGreaterThan(String value) {
            return greaterThan(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLessThan(String value) {
            return lessThan(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLike(String value) {
            return like(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotLike(String value) {
            return notLike(market, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIn(List<String> values) {
            return in(market, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotIn(List<String> values) {
            return notIn(market, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketBetween(String value1, String value2) {
            return between(market, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotBetween(String value1, String value2) {
            return notBetween(market, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIsNull() {
            return isNull(emsFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIsNotNull() {
            return isNotNull(emsFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeEqualTo(String value) {
            return equalTo(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotEqualTo(String value) {
            return notEqualTo(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeGreaterThan(String value) {
            return greaterThan(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLessThan(String value) {
            return lessThan(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLike(String value) {
            return like(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotLike(String value) {
            return notLike(emsFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIn(List<String> values) {
            return in(emsFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotIn(List<String> values) {
            return notIn(emsFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeBetween(String value1, String value2) {
            return between(emsFee, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotBetween(String value1, String value2) {
            return notBetween(emsFee, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIsNull() {
            return isNull(isLightningConsignment);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIsNotNull() {
            return isNotNull(isLightningConsignment);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentEqualTo(String value) {
            return equalTo(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotEqualTo(String value) {
            return notEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentGreaterThan(String value) {
            return greaterThan(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLessThan(String value) {
            return lessThan(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLike(String value) {
            return like(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotLike(String value) {
            return notLike(isLightningConsignment, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIn(List<String> values) {
            return in(isLightningConsignment, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotIn(List<String> values) {
            return notIn(isLightningConsignment, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentBetween(String value1, String value2) {
            return between(isLightningConsignment, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotBetween(String value1, String value2) {
            return notBetween(isLightningConsignment, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIsNull() {
            return isNull(detailUrl);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIsNotNull() {
            return isNotNull(detailUrl);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlEqualTo(String value) {
            return equalTo(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotEqualTo(String value) {
            return notEqualTo(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlGreaterThan(String value) {
            return greaterThan(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLessThan(String value) {
            return lessThan(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLike(String value) {
            return like(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotLike(String value) {
            return notLike(detailUrl, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIn(List<String> values) {
            return in(detailUrl, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotIn(List<String> values) {
            return notIn(detailUrl, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlBetween(String value1, String value2) {
            return between(detailUrl, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotBetween(String value1, String value2) {
            return notBetween(detailUrl, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andListTimeIsNull() {
            return isNull(listTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeIsNotNull() {
            return isNotNull(listTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeEqualTo(Date value) {
            return equalTo(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotEqualTo(Date value) {
            return notEqualTo(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeGreaterThan(Date value) {
            return greaterThan(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeLessThan(Date value) {
            return lessThan(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(listTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeIn(List<Date> values) {
            return in(listTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotIn(List<Date> values) {
            return notIn(listTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeBetween(Date value1, Date value2) {
            return between(listTime, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotBetween(Date value1, Date value2) {
            return notBetween(listTime, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPriceStringIsNull() {
            return isNull(priceString);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringIsNotNull() {
            return isNotNull(priceString);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringEqualTo(String value) {
            return equalTo(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotEqualTo(String value) {
            return notEqualTo(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringGreaterThan(String value) {
            return greaterThan(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLessThan(String value) {
            return lessThan(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLike(String value) {
            return like(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotLike(String value) {
            return notLike(priceString, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringIn(List<String> values) {
            return in(priceString, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotIn(List<String> values) {
            return notIn(priceString, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringBetween(String value1, String value2) {
            return between(priceString, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotBetween(String value1, String value2) {
            return notBetween(priceString, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andCityIsNull() {
            return isNull(city);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityIsNotNull() {
            return isNotNull(city);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityEqualTo(String value) {
            return equalTo(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotEqualTo(String value) {
            return notEqualTo(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityGreaterThan(String value) {
            return greaterThan(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLessThan(String value) {
            return lessThan(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLike(String value) {
            return like(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotLike(String value) {
            return notLike(city, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityIn(List<String> values) {
            return in(city, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotIn(List<String> values) {
            return notIn(city, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityBetween(String value1, String value2) {
            return between(city, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotBetween(String value1, String value2) {
            return notBetween(city, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIsNull() {
            return isNull(hasShowcase);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIsNotNull() {
            return isNotNull(hasShowcase);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseEqualTo(String value) {
            return equalTo(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotEqualTo(String value) {
            return notEqualTo(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseGreaterThan(String value) {
            return greaterThan(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLessThan(String value) {
            return lessThan(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLike(String value) {
            return like(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotLike(String value) {
            return notLike(hasShowcase, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIn(List<String> values) {
            return in(hasShowcase, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotIn(List<String> values) {
            return notIn(hasShowcase, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseBetween(String value1, String value2) {
            return between(hasShowcase, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotBetween(String value1, String value2) {
            return notBetween(hasShowcase, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIsNull() {
            return isNull(isXinpin);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIsNotNull() {
            return isNotNull(isXinpin);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinEqualTo(String value) {
            return equalTo(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotEqualTo(String value) {
            return notEqualTo(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinGreaterThan(String value) {
            return greaterThan(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLessThan(String value) {
            return lessThan(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLike(String value) {
            return like(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotLike(String value) {
            return notLike(isXinpin, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIn(List<String> values) {
            return in(isXinpin, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotIn(List<String> values) {
            return notIn(isXinpin, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinBetween(String value1, String value2) {
            return between(isXinpin, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotBetween(String value1, String value2) {
            return notBetween(isXinpin, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andNickIsNull() {
            return isNull(nick);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickIsNotNull() {
            return isNotNull(nick);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickEqualTo(String value) {
            return equalTo(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotEqualTo(String value) {
            return notEqualTo(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickGreaterThan(String value) {
            return greaterThan(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLessThan(String value) {
            return lessThan(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLike(String value) {
            return like(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotLike(String value) {
            return notLike(nick, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickIn(List<String> values) {
            return in(nick, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotIn(List<String> values) {
            return notIn(nick, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickBetween(String value1, String value2) {
            return between(nick, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotBetween(String value1, String value2) {
            return notBetween(nick, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIsNull() {
            return isNull(isAkeyToUpload);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIsNotNull() {
            return isNotNull(isAkeyToUpload);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadEqualTo(Long value) {
            return equalTo(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotEqualTo(Long value) {
            return notEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadGreaterThan(Long value) {
            return greaterThan(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadLessThan(Long value) {
            return lessThan(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIn(List<Long> values) {
            return in(isAkeyToUpload, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotIn(List<Long> values) {
            return notIn(isAkeyToUpload, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadBetween(Long value1, Long value2) {
            return between(isAkeyToUpload, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotBetween(Long value1, Long value2) {
            return notBetween(isAkeyToUpload, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPiPriceIsNull() {
            return isNull(piPrice);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceIsNotNull() {
            return isNotNull(piPrice);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceEqualTo(Long value) {
            return equalTo(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotEqualTo(Long value) {
            return notEqualTo(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceGreaterThan(Long value) {
            return greaterThan(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceLessThan(Long value) {
            return lessThan(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(piPrice, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceIn(List<Long> values) {
            return in(piPrice, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotIn(List<Long> values) {
            return notIn(piPrice, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceBetween(Long value1, Long value2) {
            return between(piPrice, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotBetween(Long value1, Long value2) {
            return notBetween(piPrice, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIsNull() {
            return isNull(numberTradableGoods);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIsNotNull() {
            return isNotNull(numberTradableGoods);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsEqualTo(Long value) {
            return equalTo(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotEqualTo(Long value) {
            return notEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsGreaterThan(Long value) {
            return greaterThan(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsLessThan(Long value) {
            return lessThan(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIn(List<Long> values) {
            return in(numberTradableGoods, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotIn(List<Long> values) {
            return notIn(numberTradableGoods, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsBetween(Long value1, Long value2) {
            return between(numberTradableGoods, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotBetween(Long value1, Long value2) {
            return notBetween(numberTradableGoods, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsTradeIsNull() {
            return isNull(isTrade);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeIsNotNull() {
            return isNotNull(isTrade);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeEqualTo(Long value) {
            return equalTo(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotEqualTo(Long value) {
            return notEqualTo(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeGreaterThan(Long value) {
            return greaterThan(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeLessThan(Long value) {
            return lessThan(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isTrade, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeIn(List<Long> values) {
            return in(isTrade, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotIn(List<Long> values) {
            return notIn(isTrade, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeBetween(Long value1, Long value2) {
            return between(isTrade, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotBetween(Long value1, Long value2) {
            return notBetween(isTrade, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andProvIsNull() {
            return isNull(prov);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvIsNotNull() {
            return isNotNull(prov);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvEqualTo(String value) {
            return equalTo(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotEqualTo(String value) {
            return notEqualTo(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvGreaterThan(String value) {
            return greaterThan(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLessThan(String value) {
            return lessThan(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLike(String value) {
            return like(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotLike(String value) {
            return notLike(prov, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvIn(List<String> values) {
            return in(prov, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotIn(List<String> values) {
            return notIn(prov, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvBetween(String value1, String value2) {
            return between(prov, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotBetween(String value1, String value2) {
            return notBetween(prov, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIsNull() {
            return isNull(soldOutTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIsNotNull() {
            return isNotNull(soldOutTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeEqualTo(Date value) {
            return equalTo(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotEqualTo(Date value) {
            return notEqualTo(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeGreaterThan(Date value) {
            return greaterThan(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeLessThan(Date value) {
            return lessThan(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(soldOutTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIn(List<Date> values) {
            return in(soldOutTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotIn(List<Date> values) {
            return notIn(soldOutTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeBetween(Date value1, Date value2) {
            return between(soldOutTime, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotBetween(Date value1, Date value2) {
            return notBetween(soldOutTime, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andCidAllIsNull() {
            return isNull(cidAll);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllIsNotNull() {
            return isNotNull(cidAll);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllEqualTo(String value) {
            return equalTo(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotEqualTo(String value) {
            return notEqualTo(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllGreaterThan(String value) {
            return greaterThan(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLessThan(String value) {
            return lessThan(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLike(String value) {
            return like(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotLike(String value) {
            return notLike(cidAll, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllIn(List<String> values) {
            return in(cidAll, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotIn(List<String> values) {
            return notIn(cidAll, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllBetween(String value1, String value2) {
            return between(cidAll, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotBetween(String value1, String value2) {
            return notBetween(cidAll, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIsNull() {
            return isNull(hasDiscount);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIsNotNull() {
            return isNotNull(hasDiscount);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountEqualTo(String value) {
            return equalTo(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotEqualTo(String value) {
            return notEqualTo(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountGreaterThan(String value) {
            return greaterThan(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLessThan(String value) {
            return lessThan(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLike(String value) {
            return like(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotLike(String value) {
            return notLike(hasDiscount, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIn(List<String> values) {
            return in(hasDiscount, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotIn(List<String> values) {
            return notIn(hasDiscount, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountBetween(String value1, String value2) {
            return between(hasDiscount, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotBetween(String value1, String value2) {
            return notBetween(hasDiscount, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIsNull() {
            return isNull(parentMarketId);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIsNotNull() {
            return isNotNull(parentMarketId);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdEqualTo(Long value) {
            return equalTo(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            return notEqualTo(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdGreaterThan(Long value) {
            return greaterThan(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdLessThan(Long value) {
            return lessThan(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentMarketId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIn(List<Long> values) {
            return in(parentMarketId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            return notIn(parentMarketId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            return between(parentMarketId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(parentMarketId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIsNull() {
            return isNull(delistTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIsNotNull() {
            return isNotNull(delistTime);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeEqualTo(Date value) {
            return equalTo(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotEqualTo(Date value) {
            return notEqualTo(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeGreaterThan(Date value) {
            return greaterThan(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeLessThan(Date value) {
            return lessThan(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(delistTime, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIn(List<Date> values) {
            return in(delistTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotIn(List<Date> values) {
            return notIn(delistTime, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeBetween(Date value1, Date value2) {
            return between(delistTime, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            return notBetween(delistTime, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andPostFeeIsNull() {
            return isNull(postFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeIsNotNull() {
            return isNotNull(postFee);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeEqualTo(String value) {
            return equalTo(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotEqualTo(String value) {
            return notEqualTo(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeGreaterThan(String value) {
            return greaterThan(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLessThan(String value) {
            return lessThan(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLike(String value) {
            return like(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotLike(String value) {
            return notLike(postFee, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeIn(List<String> values) {
            return in(postFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotIn(List<String> values) {
            return notIn(postFee, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeBetween(String value1, String value2) {
            return between(postFee, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotBetween(String value1, String value2) {
            return notBetween(postFee, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsStandardIsNull() {
            return isNull(isStandard);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardIsNotNull() {
            return isNotNull(isStandard);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardEqualTo(Integer value) {
            return equalTo(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotEqualTo(Integer value) {
            return notEqualTo(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardGreaterThan(Integer value) {
            return greaterThan(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardLessThan(Integer value) {
            return lessThan(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isStandard, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardIn(List<Integer> values) {
            return in(isStandard, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotIn(List<Integer> values) {
            return notIn(isStandard, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardBetween(Integer value1, Integer value2) {
            return between(isStandard, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotBetween(Integer value1, Integer value2) {
            return notBetween(isStandard, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsClosedIsNull() {
            return isNull(isClosed);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedIsNotNull() {
            return isNotNull(isClosed);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedEqualTo(Long value) {
            return equalTo(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotEqualTo(Long value) {
            return notEqualTo(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedGreaterThan(Long value) {
            return greaterThan(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedLessThan(Long value) {
            return lessThan(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isClosed, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedIn(List<Long> values) {
            return in(isClosed, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotIn(List<Long> values) {
            return notIn(isClosed, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedBetween(Long value1, Long value2) {
            return between(isClosed, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotBetween(Long value1, Long value2) {
            return notBetween(isClosed, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIsNull() {
            return isNull(goodsStatus);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIsNotNull() {
            return isNotNull(goodsStatus);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusEqualTo(Integer value) {
            return equalTo(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusGreaterThan(Integer value) {
            return greaterThan(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusLessThan(Integer value) {
            return lessThan(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIn(List<Integer> values) {
            return in(goodsStatus, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotIn(List<Integer> values) {
            return notIn(goodsStatus, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            return between(goodsStatus, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsStatus, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIsNull() {
            return isNull(isExcelImp);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIsNotNull() {
            return isNotNull(isExcelImp);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpEqualTo(Integer value) {
            return equalTo(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotEqualTo(Integer value) {
            return notEqualTo(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpGreaterThan(Integer value) {
            return greaterThan(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpLessThan(Integer value) {
            return lessThan(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isExcelImp, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIn(List<Integer> values) {
            return in(isExcelImp, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotIn(List<Integer> values) {
            return notIn(isExcelImp, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpBetween(Integer value1, Integer value2) {
            return between(isExcelImp, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotBetween(Integer value1, Integer value2) {
            return notBetween(isExcelImp, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIsNull() {
            return isNull(stuffStatus);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIsNotNull() {
            return isNotNull(stuffStatus);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusEqualTo(String value) {
            return equalTo(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotEqualTo(String value) {
            return notEqualTo(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusGreaterThan(String value) {
            return greaterThan(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLessThan(String value) {
            return lessThan(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLike(String value) {
            return like(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotLike(String value) {
            return notLike(stuffStatus, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIn(List<String> values) {
            return in(stuffStatus, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotIn(List<String> values) {
            return notIn(stuffStatus, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusBetween(String value1, String value2) {
            return between(stuffStatus, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotBetween(String value1, String value2) {
            return notBetween(stuffStatus, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIsNull() {
            return isNull(parentMarketName);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIsNotNull() {
            return isNotNull(parentMarketName);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameEqualTo(String value) {
            return equalTo(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotEqualTo(String value) {
            return notEqualTo(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameGreaterThan(String value) {
            return greaterThan(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLessThan(String value) {
            return lessThan(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLike(String value) {
            return like(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotLike(String value) {
            return notLike(parentMarketName, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIn(List<String> values) {
            return in(parentMarketName, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotIn(List<String> values) {
            return notIn(parentMarketName, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            return between(parentMarketName, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            return notBetween(parentMarketName, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andClicksIsNull() {
            return isNull(clicks);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksIsNotNull() {
            return isNotNull(clicks);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksEqualTo(Long value) {
            return equalTo(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotEqualTo(Long value) {
            return notEqualTo(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksGreaterThan(Long value) {
            return greaterThan(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksLessThan(Long value) {
            return lessThan(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicks, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksIn(List<Long> values) {
            return in(clicks, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotIn(List<Long> values) {
            return notIn(clicks, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksBetween(Long value1, Long value2) {
            return between(clicks, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            return notBetween(clicks, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andOuterIdIsNull() {
            return isNull(outerId);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdIsNotNull() {
            return isNotNull(outerId);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdEqualTo(String value) {
            return equalTo(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotEqualTo(String value) {
            return notEqualTo(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdGreaterThan(String value) {
            return greaterThan(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLessThan(String value) {
            return lessThan(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLike(String value) {
            return like(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotLike(String value) {
            return notLike(outerId, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdIn(List<String> values) {
            return in(outerId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotIn(List<String> values) {
            return notIn(outerId, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdBetween(String value1, String value2) {
            return between(outerId, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            return notBetween(outerId, value1, value2);
        }
        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIsNull() {
            return isNull(soldoutReason);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIsNotNull() {
            return isNotNull(soldoutReason);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonEqualTo(String value) {
            return equalTo(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotEqualTo(String value) {
            return notEqualTo(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonGreaterThan(String value) {
            return greaterThan(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLessThan(String value) {
            return lessThan(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLike(String value) {
            return like(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotLike(String value) {
            return notLike(soldoutReason, value);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIn(List<String> values) {
            return in(soldoutReason, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotIn(List<String> values) {
            return notIn(soldoutReason, values);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonBetween(String value1, String value2) {
            return between(soldoutReason, value1, value2);
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotBetween(String value1, String value2) {
            return notBetween(soldoutReason, value1, value2);
        }
    }
}
