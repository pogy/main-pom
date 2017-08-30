package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsTiny;

import java.util.*;
public class ShiguGoodsTinyExample extends SgExample<ShiguGoodsTinyExample.Criteria> {
    public static final Class<ShiguGoodsTiny> beanClass = ShiguGoodsTiny.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn validThru;
    public static EntityColumn freightPayer;
    public static EntityColumn numIid;
    public static EntityColumn num;
    public static EntityColumn modeFirstTypeId;
    public static EntityColumn type;
    public static EntityColumn expressFee;
    public static EntityColumn imAliww;
    public static EntityColumn piPriceString;
    public static EntityColumn picUrl;
    public static EntityColumn modeSecondTypeId;
    public static EntityColumn priceRole;
    public static EntityColumn price;
    public static EntityColumn modified;
    public static EntityColumn modeTopType;
    public static EntityColumn isModPrice;
    public static EntityColumn isEfficacious;
    public static EntityColumn isModGoodsno;
    public static EntityColumn isModTitle;
    public static EntityColumn notNumberTradableGoods;
    public static EntityColumn isDataPackage;
    public static EntityColumn modeSecondType;
    public static EntityColumn isSetMode;
    public static EntityColumn created;
    public static EntityColumn isTaobaoSynchronization;
    public static EntityColumn modeFirstType;
    public static EntityColumn isFenxiao;
    public static EntityColumn goodsLevel;
    public static EntityColumn market;
    public static EntityColumn goodsServices;
    public static EntityColumn remark9;
    public static EntityColumn emsFee;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn isLightningConsignment;
    public static EntityColumn isSale;
    public static EntityColumn remark4;
    public static EntityColumn isAdminSetPiPrice;
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
    public static EntityColumn titleIndex;
    public static EntityColumn upDataPackageName;
    public static EntityColumn title;
    public static EntityColumn hasShowcase;
    public static EntityColumn isDown;
    public static EntityColumn loadDate;
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
    public static EntityColumn inStoreSortOrder;
    public static EntityColumn soldOutTime;
    public static EntityColumn upDataPackageUrl;
    public static EntityColumn modeTopTypeId;
    public static EntityColumn isUserSetPiPrice;
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
    public static EntityColumn lastModifyTime;
    public static EntityColumn relationLevelId;
    public static EntityColumn clicks;
    public static EntityColumn outerId;
    public static EntityColumn isShowcase;
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
        modeFirstTypeId = listMap.get("modeFirstTypeId");
        type = listMap.get("type");
        expressFee = listMap.get("expressFee");
        imAliww = listMap.get("imAliww");
        piPriceString = listMap.get("piPriceString");
        picUrl = listMap.get("picUrl");
        modeSecondTypeId = listMap.get("modeSecondTypeId");
        priceRole = listMap.get("priceRole");
        price = listMap.get("price");
        modified = listMap.get("modified");
        modeTopType = listMap.get("modeTopType");
        isModPrice = listMap.get("isModPrice");
        isEfficacious = listMap.get("isEfficacious");
        isModGoodsno = listMap.get("isModGoodsno");
        isModTitle = listMap.get("isModTitle");
        notNumberTradableGoods = listMap.get("notNumberTradableGoods");
        isDataPackage = listMap.get("isDataPackage");
        modeSecondType = listMap.get("modeSecondType");
        isSetMode = listMap.get("isSetMode");
        created = listMap.get("created");
        isTaobaoSynchronization = listMap.get("isTaobaoSynchronization");
        modeFirstType = listMap.get("modeFirstType");
        isFenxiao = listMap.get("isFenxiao");
        goodsLevel = listMap.get("goodsLevel");
        market = listMap.get("market");
        goodsServices = listMap.get("goodsServices");
        remark9 = listMap.get("remark9");
        emsFee = listMap.get("emsFee");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        isLightningConsignment = listMap.get("isLightningConsignment");
        isSale = listMap.get("isSale");
        remark4 = listMap.get("remark4");
        isAdminSetPiPrice = listMap.get("isAdminSetPiPrice");
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
        titleIndex = listMap.get("titleIndex");
        upDataPackageName = listMap.get("upDataPackageName");
        title = listMap.get("title");
        hasShowcase = listMap.get("hasShowcase");
        isDown = listMap.get("isDown");
        loadDate = listMap.get("loadDate");
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
        inStoreSortOrder = listMap.get("inStoreSortOrder");
        soldOutTime = listMap.get("soldOutTime");
        upDataPackageUrl = listMap.get("upDataPackageUrl");
        modeTopTypeId = listMap.get("modeTopTypeId");
        isUserSetPiPrice = listMap.get("isUserSetPiPrice");
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
        lastModifyTime = listMap.get("lastModifyTime");
        relationLevelId = listMap.get("relationLevelId");
        clicks = listMap.get("clicks");
        outerId = listMap.get("outerId");
        isShowcase = listMap.get("isShowcase");
        }

    public ShiguGoodsTinyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsTinyExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsTinyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruIsNull() {
            return isNull(validThru);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruIsNotNull() {
            return isNotNull(validThru);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruEqualTo(Long value) {
            return equalTo(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotEqualTo(Long value) {
            return notEqualTo(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruGreaterThan(Long value) {
            return greaterThan(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruLessThan(Long value) {
            return lessThan(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(validThru, value);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruIn(List<Long> values) {
            return in(validThru, values);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotIn(List<Long> values) {
            return notIn(validThru, values);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruBetween(Long value1, Long value2) {
            return between(validThru, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotBetween(Long value1, Long value2) {
            return notBetween(validThru, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andFreightPayerIsNull() {
            return isNull(freightPayer);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerIsNotNull() {
            return isNotNull(freightPayer);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerEqualTo(String value) {
            return equalTo(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotEqualTo(String value) {
            return notEqualTo(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerGreaterThan(String value) {
            return greaterThan(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLessThan(String value) {
            return lessThan(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLike(String value) {
            return like(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotLike(String value) {
            return notLike(freightPayer, value);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerIn(List<String> values) {
            return in(freightPayer, values);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotIn(List<String> values) {
            return notIn(freightPayer, values);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerBetween(String value1, String value2) {
            return between(freightPayer, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotBetween(String value1, String value2) {
            return notBetween(freightPayer, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ShiguGoodsTinyExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ShiguGoodsTinyExample.Criteria andNumEqualTo(Long value) {
            return equalTo(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumNotEqualTo(Long value) {
            return notEqualTo(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumGreaterThan(Long value) {
            return greaterThan(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumLessThan(Long value) {
            return lessThan(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(num, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumIn(List<Long> values) {
            return in(num, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumNotIn(List<Long> values) {
            return notIn(num, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumBetween(Long value1, Long value2) {
            return between(num, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andNumNotBetween(Long value1, Long value2) {
            return notBetween(num, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIsNull() {
            return isNull(modeFirstTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIsNotNull() {
            return isNotNull(modeFirstTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdEqualTo(Long value) {
            return equalTo(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotEqualTo(Long value) {
            return notEqualTo(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdGreaterThan(Long value) {
            return greaterThan(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdLessThan(Long value) {
            return lessThan(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(modeFirstTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIn(List<Long> values) {
            return in(modeFirstTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotIn(List<Long> values) {
            return notIn(modeFirstTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdBetween(Long value1, Long value2) {
            return between(modeFirstTypeId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotBetween(Long value1, Long value2) {
            return notBetween(modeFirstTypeId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguGoodsTinyExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguGoodsTinyExample.Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public ShiguGoodsTinyExample.Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public ShiguGoodsTinyExample.Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andImAliwwIsNull() {
            return isNull(imAliww);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwIsNotNull() {
            return isNotNull(imAliww);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwEqualTo(String value) {
            return equalTo(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotEqualTo(String value) {
            return notEqualTo(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwGreaterThan(String value) {
            return greaterThan(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLessThan(String value) {
            return lessThan(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLike(String value) {
            return like(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotLike(String value) {
            return notLike(imAliww, value);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwIn(List<String> values) {
            return in(imAliww, values);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotIn(List<String> values) {
            return notIn(imAliww, values);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwBetween(String value1, String value2) {
            return between(imAliww, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            return notBetween(imAliww, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPiPriceStringIsNull() {
            return isNull(piPriceString);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringIsNotNull() {
            return isNotNull(piPriceString);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringEqualTo(String value) {
            return equalTo(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotEqualTo(String value) {
            return notEqualTo(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringGreaterThan(String value) {
            return greaterThan(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLessThan(String value) {
            return lessThan(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLike(String value) {
            return like(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotLike(String value) {
            return notLike(piPriceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringIn(List<String> values) {
            return in(piPriceString, values);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotIn(List<String> values) {
            return notIn(piPriceString, values);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringBetween(String value1, String value2) {
            return between(piPriceString, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotBetween(String value1, String value2) {
            return notBetween(piPriceString, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIsNull() {
            return isNull(modeSecondTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIsNotNull() {
            return isNotNull(modeSecondTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdEqualTo(Long value) {
            return equalTo(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotEqualTo(Long value) {
            return notEqualTo(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdGreaterThan(Long value) {
            return greaterThan(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdLessThan(Long value) {
            return lessThan(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(modeSecondTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIn(List<Long> values) {
            return in(modeSecondTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotIn(List<Long> values) {
            return notIn(modeSecondTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdBetween(Long value1, Long value2) {
            return between(modeSecondTypeId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotBetween(Long value1, Long value2) {
            return notBetween(modeSecondTypeId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPriceRoleIsNull() {
            return isNull(priceRole);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleIsNotNull() {
            return isNotNull(priceRole);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleEqualTo(String value) {
            return equalTo(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotEqualTo(String value) {
            return notEqualTo(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleGreaterThan(String value) {
            return greaterThan(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLessThan(String value) {
            return lessThan(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLike(String value) {
            return like(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotLike(String value) {
            return notLike(priceRole, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleIn(List<String> values) {
            return in(priceRole, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotIn(List<String> values) {
            return notIn(priceRole, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleBetween(String value1, String value2) {
            return between(priceRole, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotBetween(String value1, String value2) {
            return notBetween(priceRole, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ShiguGoodsTinyExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ShiguGoodsTinyExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModifiedIsNull() {
            return isNull(modified);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedIsNotNull() {
            return isNotNull(modified);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedEqualTo(Date value) {
            return equalTo(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotEqualTo(Date value) {
            return notEqualTo(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedGreaterThan(Date value) {
            return greaterThan(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedLessThan(Date value) {
            return lessThan(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modified, value);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedIn(List<Date> values) {
            return in(modified, values);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotIn(List<Date> values) {
            return notIn(modified, values);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedBetween(Date value1, Date value2) {
            return between(modified, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            return notBetween(modified, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeTopTypeIsNull() {
            return isNull(modeTopType);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIsNotNull() {
            return isNotNull(modeTopType);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeEqualTo(String value) {
            return equalTo(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotEqualTo(String value) {
            return notEqualTo(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeGreaterThan(String value) {
            return greaterThan(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLessThan(String value) {
            return lessThan(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLike(String value) {
            return like(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotLike(String value) {
            return notLike(modeTopType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIn(List<String> values) {
            return in(modeTopType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotIn(List<String> values) {
            return notIn(modeTopType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeBetween(String value1, String value2) {
            return between(modeTopType, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotBetween(String value1, String value2) {
            return notBetween(modeTopType, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsModPriceIsNull() {
            return isNull(isModPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceIsNotNull() {
            return isNotNull(isModPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceEqualTo(Integer value) {
            return equalTo(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotEqualTo(Integer value) {
            return notEqualTo(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceGreaterThan(Integer value) {
            return greaterThan(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceLessThan(Integer value) {
            return lessThan(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isModPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceIn(List<Integer> values) {
            return in(isModPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotIn(List<Integer> values) {
            return notIn(isModPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceBetween(Integer value1, Integer value2) {
            return between(isModPrice, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotBetween(Integer value1, Integer value2) {
            return notBetween(isModPrice, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIsNull() {
            return isNull(isEfficacious);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIsNotNull() {
            return isNotNull(isEfficacious);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousEqualTo(Long value) {
            return equalTo(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotEqualTo(Long value) {
            return notEqualTo(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousGreaterThan(Long value) {
            return greaterThan(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousLessThan(Long value) {
            return lessThan(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isEfficacious, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIn(List<Long> values) {
            return in(isEfficacious, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotIn(List<Long> values) {
            return notIn(isEfficacious, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousBetween(Long value1, Long value2) {
            return between(isEfficacious, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotBetween(Long value1, Long value2) {
            return notBetween(isEfficacious, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIsNull() {
            return isNull(isModGoodsno);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIsNotNull() {
            return isNotNull(isModGoodsno);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoEqualTo(Integer value) {
            return equalTo(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotEqualTo(Integer value) {
            return notEqualTo(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoGreaterThan(Integer value) {
            return greaterThan(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoLessThan(Integer value) {
            return lessThan(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isModGoodsno, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIn(List<Integer> values) {
            return in(isModGoodsno, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotIn(List<Integer> values) {
            return notIn(isModGoodsno, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoBetween(Integer value1, Integer value2) {
            return between(isModGoodsno, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotBetween(Integer value1, Integer value2) {
            return notBetween(isModGoodsno, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsModTitleIsNull() {
            return isNull(isModTitle);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleIsNotNull() {
            return isNotNull(isModTitle);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleEqualTo(Integer value) {
            return equalTo(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotEqualTo(Integer value) {
            return notEqualTo(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleGreaterThan(Integer value) {
            return greaterThan(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleLessThan(Integer value) {
            return lessThan(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isModTitle, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleIn(List<Integer> values) {
            return in(isModTitle, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotIn(List<Integer> values) {
            return notIn(isModTitle, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleBetween(Integer value1, Integer value2) {
            return between(isModTitle, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotBetween(Integer value1, Integer value2) {
            return notBetween(isModTitle, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIsNull() {
            return isNull(notNumberTradableGoods);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIsNotNull() {
            return isNotNull(notNumberTradableGoods);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsEqualTo(Long value) {
            return equalTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotEqualTo(Long value) {
            return notEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsGreaterThan(Long value) {
            return greaterThan(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsLessThan(Long value) {
            return lessThan(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(notNumberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIn(List<Long> values) {
            return in(notNumberTradableGoods, values);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotIn(List<Long> values) {
            return notIn(notNumberTradableGoods, values);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsBetween(Long value1, Long value2) {
            return between(notNumberTradableGoods, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotBetween(Long value1, Long value2) {
            return notBetween(notNumberTradableGoods, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsDataPackageIsNull() {
            return isNull(isDataPackage);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageIsNotNull() {
            return isNotNull(isDataPackage);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageEqualTo(Integer value) {
            return equalTo(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotEqualTo(Integer value) {
            return notEqualTo(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageGreaterThan(Integer value) {
            return greaterThan(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageLessThan(Integer value) {
            return lessThan(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isDataPackage, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageIn(List<Integer> values) {
            return in(isDataPackage, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotIn(List<Integer> values) {
            return notIn(isDataPackage, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageBetween(Integer value1, Integer value2) {
            return between(isDataPackage, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotBetween(Integer value1, Integer value2) {
            return notBetween(isDataPackage, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIsNull() {
            return isNull(modeSecondType);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIsNotNull() {
            return isNotNull(modeSecondType);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeEqualTo(String value) {
            return equalTo(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotEqualTo(String value) {
            return notEqualTo(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeGreaterThan(String value) {
            return greaterThan(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLessThan(String value) {
            return lessThan(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLike(String value) {
            return like(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotLike(String value) {
            return notLike(modeSecondType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIn(List<String> values) {
            return in(modeSecondType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotIn(List<String> values) {
            return notIn(modeSecondType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeBetween(String value1, String value2) {
            return between(modeSecondType, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotBetween(String value1, String value2) {
            return notBetween(modeSecondType, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsSetModeIsNull() {
            return isNull(isSetMode);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeIsNotNull() {
            return isNotNull(isSetMode);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeEqualTo(Integer value) {
            return equalTo(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotEqualTo(Integer value) {
            return notEqualTo(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeGreaterThan(Integer value) {
            return greaterThan(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeLessThan(Integer value) {
            return lessThan(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isSetMode, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeIn(List<Integer> values) {
            return in(isSetMode, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotIn(List<Integer> values) {
            return notIn(isSetMode, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeBetween(Integer value1, Integer value2) {
            return between(isSetMode, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotBetween(Integer value1, Integer value2) {
            return notBetween(isSetMode, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedEqualTo(Date value) {
            return equalTo(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotEqualTo(Date value) {
            return notEqualTo(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedGreaterThan(Date value) {
            return greaterThan(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedLessThan(Date value) {
            return lessThan(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(created, value);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedIn(List<Date> values) {
            return in(created, values);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotIn(List<Date> values) {
            return notIn(created, values);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedBetween(Date value1, Date value2) {
            return between(created, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            return notBetween(created, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIsNull() {
            return isNull(isTaobaoSynchronization);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIsNotNull() {
            return isNotNull(isTaobaoSynchronization);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationEqualTo(Long value) {
            return equalTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotEqualTo(Long value) {
            return notEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationGreaterThan(Long value) {
            return greaterThan(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationLessThan(Long value) {
            return lessThan(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isTaobaoSynchronization, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIn(List<Long> values) {
            return in(isTaobaoSynchronization, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotIn(List<Long> values) {
            return notIn(isTaobaoSynchronization, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationBetween(Long value1, Long value2) {
            return between(isTaobaoSynchronization, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotBetween(Long value1, Long value2) {
            return notBetween(isTaobaoSynchronization, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIsNull() {
            return isNull(modeFirstType);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIsNotNull() {
            return isNotNull(modeFirstType);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeEqualTo(String value) {
            return equalTo(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotEqualTo(String value) {
            return notEqualTo(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeGreaterThan(String value) {
            return greaterThan(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLessThan(String value) {
            return lessThan(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLike(String value) {
            return like(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotLike(String value) {
            return notLike(modeFirstType, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIn(List<String> values) {
            return in(modeFirstType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotIn(List<String> values) {
            return notIn(modeFirstType, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeBetween(String value1, String value2) {
            return between(modeFirstType, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotBetween(String value1, String value2) {
            return notBetween(modeFirstType, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIsNull() {
            return isNull(isFenxiao);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIsNotNull() {
            return isNotNull(isFenxiao);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoEqualTo(Long value) {
            return equalTo(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotEqualTo(Long value) {
            return notEqualTo(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoGreaterThan(Long value) {
            return greaterThan(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoLessThan(Long value) {
            return lessThan(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isFenxiao, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIn(List<Long> values) {
            return in(isFenxiao, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotIn(List<Long> values) {
            return notIn(isFenxiao, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoBetween(Long value1, Long value2) {
            return between(isFenxiao, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotBetween(Long value1, Long value2) {
            return notBetween(isFenxiao, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andGoodsLevelIsNull() {
            return isNull(goodsLevel);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelIsNotNull() {
            return isNotNull(goodsLevel);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelEqualTo(String value) {
            return equalTo(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotEqualTo(String value) {
            return notEqualTo(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelGreaterThan(String value) {
            return greaterThan(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLessThan(String value) {
            return lessThan(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLike(String value) {
            return like(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotLike(String value) {
            return notLike(goodsLevel, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelIn(List<String> values) {
            return in(goodsLevel, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotIn(List<String> values) {
            return notIn(goodsLevel, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelBetween(String value1, String value2) {
            return between(goodsLevel, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotBetween(String value1, String value2) {
            return notBetween(goodsLevel, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andMarketIsNull() {
            return isNull(market);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIsNotNull() {
            return isNotNull(market);
        }

        public ShiguGoodsTinyExample.Criteria andMarketEqualTo(String value) {
            return equalTo(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotEqualTo(String value) {
            return notEqualTo(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketGreaterThan(String value) {
            return greaterThan(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketLessThan(String value) {
            return lessThan(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketLike(String value) {
            return like(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotLike(String value) {
            return notLike(market, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIn(List<String> values) {
            return in(market, values);
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotIn(List<String> values) {
            return notIn(market, values);
        }

        public ShiguGoodsTinyExample.Criteria andMarketBetween(String value1, String value2) {
            return between(market, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotBetween(String value1, String value2) {
            return notBetween(market, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andGoodsServicesIsNull() {
            return isNull(goodsServices);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesIsNotNull() {
            return isNotNull(goodsServices);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesEqualTo(String value) {
            return equalTo(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotEqualTo(String value) {
            return notEqualTo(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesGreaterThan(String value) {
            return greaterThan(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLessThan(String value) {
            return lessThan(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLike(String value) {
            return like(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotLike(String value) {
            return notLike(goodsServices, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesIn(List<String> values) {
            return in(goodsServices, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotIn(List<String> values) {
            return notIn(goodsServices, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesBetween(String value1, String value2) {
            return between(goodsServices, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotBetween(String value1, String value2) {
            return notBetween(goodsServices, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andEmsFeeIsNull() {
            return isNull(emsFee);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeIsNotNull() {
            return isNotNull(emsFee);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeEqualTo(String value) {
            return equalTo(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotEqualTo(String value) {
            return notEqualTo(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeGreaterThan(String value) {
            return greaterThan(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLessThan(String value) {
            return lessThan(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLike(String value) {
            return like(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotLike(String value) {
            return notLike(emsFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeIn(List<String> values) {
            return in(emsFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotIn(List<String> values) {
            return notIn(emsFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeBetween(String value1, String value2) {
            return between(emsFee, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotBetween(String value1, String value2) {
            return notBetween(emsFee, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIsNull() {
            return isNull(isLightningConsignment);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIsNotNull() {
            return isNotNull(isLightningConsignment);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentEqualTo(String value) {
            return equalTo(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotEqualTo(String value) {
            return notEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentGreaterThan(String value) {
            return greaterThan(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLessThan(String value) {
            return lessThan(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLike(String value) {
            return like(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotLike(String value) {
            return notLike(isLightningConsignment, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIn(List<String> values) {
            return in(isLightningConsignment, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotIn(List<String> values) {
            return notIn(isLightningConsignment, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentBetween(String value1, String value2) {
            return between(isLightningConsignment, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotBetween(String value1, String value2) {
            return notBetween(isLightningConsignment, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsSaleIsNull() {
            return isNull(isSale);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleIsNotNull() {
            return isNotNull(isSale);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleEqualTo(Long value) {
            return equalTo(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotEqualTo(Long value) {
            return notEqualTo(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleGreaterThan(Long value) {
            return greaterThan(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleLessThan(Long value) {
            return lessThan(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isSale, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleIn(List<Long> values) {
            return in(isSale, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotIn(List<Long> values) {
            return notIn(isSale, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleBetween(Long value1, Long value2) {
            return between(isSale, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotBetween(Long value1, Long value2) {
            return notBetween(isSale, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIsNull() {
            return isNull(isAdminSetPiPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIsNotNull() {
            return isNotNull(isAdminSetPiPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceEqualTo(Integer value) {
            return equalTo(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotEqualTo(Integer value) {
            return notEqualTo(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceGreaterThan(Integer value) {
            return greaterThan(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceLessThan(Integer value) {
            return lessThan(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isAdminSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIn(List<Integer> values) {
            return in(isAdminSetPiPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotIn(List<Integer> values) {
            return notIn(isAdminSetPiPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceBetween(Integer value1, Integer value2) {
            return between(isAdminSetPiPrice, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotBetween(Integer value1, Integer value2) {
            return notBetween(isAdminSetPiPrice, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andDetailUrlIsNull() {
            return isNull(detailUrl);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlIsNotNull() {
            return isNotNull(detailUrl);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlEqualTo(String value) {
            return equalTo(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotEqualTo(String value) {
            return notEqualTo(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlGreaterThan(String value) {
            return greaterThan(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLessThan(String value) {
            return lessThan(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLike(String value) {
            return like(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotLike(String value) {
            return notLike(detailUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlIn(List<String> values) {
            return in(detailUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotIn(List<String> values) {
            return notIn(detailUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlBetween(String value1, String value2) {
            return between(detailUrl, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotBetween(String value1, String value2) {
            return notBetween(detailUrl, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguGoodsTinyExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguGoodsTinyExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguGoodsTinyExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguGoodsTinyExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andListTimeIsNull() {
            return isNull(listTime);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeIsNotNull() {
            return isNotNull(listTime);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeEqualTo(Date value) {
            return equalTo(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotEqualTo(Date value) {
            return notEqualTo(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeGreaterThan(Date value) {
            return greaterThan(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeLessThan(Date value) {
            return lessThan(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(listTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeIn(List<Date> values) {
            return in(listTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotIn(List<Date> values) {
            return notIn(listTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeBetween(Date value1, Date value2) {
            return between(listTime, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotBetween(Date value1, Date value2) {
            return notBetween(listTime, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPriceStringIsNull() {
            return isNull(priceString);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringIsNotNull() {
            return isNotNull(priceString);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringEqualTo(String value) {
            return equalTo(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotEqualTo(String value) {
            return notEqualTo(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringGreaterThan(String value) {
            return greaterThan(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLessThan(String value) {
            return lessThan(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLike(String value) {
            return like(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotLike(String value) {
            return notLike(priceString, value);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringIn(List<String> values) {
            return in(priceString, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotIn(List<String> values) {
            return notIn(priceString, values);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringBetween(String value1, String value2) {
            return between(priceString, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotBetween(String value1, String value2) {
            return notBetween(priceString, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andCityIsNull() {
            return isNull(city);
        }

        public ShiguGoodsTinyExample.Criteria andCityIsNotNull() {
            return isNotNull(city);
        }

        public ShiguGoodsTinyExample.Criteria andCityEqualTo(String value) {
            return equalTo(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityNotEqualTo(String value) {
            return notEqualTo(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityGreaterThan(String value) {
            return greaterThan(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityLessThan(String value) {
            return lessThan(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityLike(String value) {
            return like(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityNotLike(String value) {
            return notLike(city, value);
        }

        public ShiguGoodsTinyExample.Criteria andCityIn(List<String> values) {
            return in(city, values);
        }

        public ShiguGoodsTinyExample.Criteria andCityNotIn(List<String> values) {
            return notIn(city, values);
        }

        public ShiguGoodsTinyExample.Criteria andCityBetween(String value1, String value2) {
            return between(city, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andCityNotBetween(String value1, String value2) {
            return notBetween(city, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andTitleIndexIsNull() {
            return isNull(titleIndex);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexIsNotNull() {
            return isNotNull(titleIndex);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexEqualTo(String value) {
            return equalTo(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotEqualTo(String value) {
            return notEqualTo(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexGreaterThan(String value) {
            return greaterThan(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLessThan(String value) {
            return lessThan(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLike(String value) {
            return like(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotLike(String value) {
            return notLike(titleIndex, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexIn(List<String> values) {
            return in(titleIndex, values);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotIn(List<String> values) {
            return notIn(titleIndex, values);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexBetween(String value1, String value2) {
            return between(titleIndex, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotBetween(String value1, String value2) {
            return notBetween(titleIndex, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIsNull() {
            return isNull(upDataPackageName);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIsNotNull() {
            return isNotNull(upDataPackageName);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameEqualTo(String value) {
            return equalTo(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotEqualTo(String value) {
            return notEqualTo(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameGreaterThan(String value) {
            return greaterThan(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLessThan(String value) {
            return lessThan(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLike(String value) {
            return like(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotLike(String value) {
            return notLike(upDataPackageName, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIn(List<String> values) {
            return in(upDataPackageName, values);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotIn(List<String> values) {
            return notIn(upDataPackageName, values);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameBetween(String value1, String value2) {
            return between(upDataPackageName, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotBetween(String value1, String value2) {
            return notBetween(upDataPackageName, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguGoodsTinyExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguGoodsTinyExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguGoodsTinyExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andHasShowcaseIsNull() {
            return isNull(hasShowcase);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseIsNotNull() {
            return isNotNull(hasShowcase);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseEqualTo(String value) {
            return equalTo(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotEqualTo(String value) {
            return notEqualTo(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseGreaterThan(String value) {
            return greaterThan(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLessThan(String value) {
            return lessThan(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLike(String value) {
            return like(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotLike(String value) {
            return notLike(hasShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseIn(List<String> values) {
            return in(hasShowcase, values);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotIn(List<String> values) {
            return notIn(hasShowcase, values);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseBetween(String value1, String value2) {
            return between(hasShowcase, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotBetween(String value1, String value2) {
            return notBetween(hasShowcase, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsDownIsNull() {
            return isNull(isDown);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownIsNotNull() {
            return isNotNull(isDown);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownEqualTo(Long value) {
            return equalTo(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotEqualTo(Long value) {
            return notEqualTo(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownGreaterThan(Long value) {
            return greaterThan(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownLessThan(Long value) {
            return lessThan(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isDown, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownIn(List<Long> values) {
            return in(isDown, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotIn(List<Long> values) {
            return notIn(isDown, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownBetween(Long value1, Long value2) {
            return between(isDown, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotBetween(Long value1, Long value2) {
            return notBetween(isDown, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andLoadDateIsNull() {
            return isNull(loadDate);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateIsNotNull() {
            return isNotNull(loadDate);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateEqualTo(Date value) {
            return equalTo(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotEqualTo(Date value) {
            return notEqualTo(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateGreaterThan(Date value) {
            return greaterThan(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateLessThan(Date value) {
            return lessThan(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(loadDate, value);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateIn(List<Date> values) {
            return in(loadDate, values);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotIn(List<Date> values) {
            return notIn(loadDate, values);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateBetween(Date value1, Date value2) {
            return between(loadDate, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotBetween(Date value1, Date value2) {
            return notBetween(loadDate, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsXinpinIsNull() {
            return isNull(isXinpin);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinIsNotNull() {
            return isNotNull(isXinpin);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinEqualTo(String value) {
            return equalTo(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotEqualTo(String value) {
            return notEqualTo(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinGreaterThan(String value) {
            return greaterThan(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLessThan(String value) {
            return lessThan(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLike(String value) {
            return like(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotLike(String value) {
            return notLike(isXinpin, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinIn(List<String> values) {
            return in(isXinpin, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotIn(List<String> values) {
            return notIn(isXinpin, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinBetween(String value1, String value2) {
            return between(isXinpin, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotBetween(String value1, String value2) {
            return notBetween(isXinpin, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andNickIsNull() {
            return isNull(nick);
        }

        public ShiguGoodsTinyExample.Criteria andNickIsNotNull() {
            return isNotNull(nick);
        }

        public ShiguGoodsTinyExample.Criteria andNickEqualTo(String value) {
            return equalTo(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickNotEqualTo(String value) {
            return notEqualTo(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickGreaterThan(String value) {
            return greaterThan(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickLessThan(String value) {
            return lessThan(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickLike(String value) {
            return like(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickNotLike(String value) {
            return notLike(nick, value);
        }

        public ShiguGoodsTinyExample.Criteria andNickIn(List<String> values) {
            return in(nick, values);
        }

        public ShiguGoodsTinyExample.Criteria andNickNotIn(List<String> values) {
            return notIn(nick, values);
        }

        public ShiguGoodsTinyExample.Criteria andNickBetween(String value1, String value2) {
            return between(nick, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andNickNotBetween(String value1, String value2) {
            return notBetween(nick, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIsNull() {
            return isNull(isAkeyToUpload);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIsNotNull() {
            return isNotNull(isAkeyToUpload);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadEqualTo(Long value) {
            return equalTo(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotEqualTo(Long value) {
            return notEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadGreaterThan(Long value) {
            return greaterThan(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadLessThan(Long value) {
            return lessThan(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isAkeyToUpload, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIn(List<Long> values) {
            return in(isAkeyToUpload, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotIn(List<Long> values) {
            return notIn(isAkeyToUpload, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadBetween(Long value1, Long value2) {
            return between(isAkeyToUpload, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotBetween(Long value1, Long value2) {
            return notBetween(isAkeyToUpload, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPiPriceIsNull() {
            return isNull(piPrice);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceIsNotNull() {
            return isNotNull(piPrice);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceEqualTo(Long value) {
            return equalTo(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotEqualTo(Long value) {
            return notEqualTo(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceGreaterThan(Long value) {
            return greaterThan(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceLessThan(Long value) {
            return lessThan(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(piPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceIn(List<Long> values) {
            return in(piPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotIn(List<Long> values) {
            return notIn(piPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceBetween(Long value1, Long value2) {
            return between(piPrice, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotBetween(Long value1, Long value2) {
            return notBetween(piPrice, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIsNull() {
            return isNull(numberTradableGoods);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIsNotNull() {
            return isNotNull(numberTradableGoods);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsEqualTo(Long value) {
            return equalTo(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotEqualTo(Long value) {
            return notEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsGreaterThan(Long value) {
            return greaterThan(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsLessThan(Long value) {
            return lessThan(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numberTradableGoods, value);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIn(List<Long> values) {
            return in(numberTradableGoods, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotIn(List<Long> values) {
            return notIn(numberTradableGoods, values);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsBetween(Long value1, Long value2) {
            return between(numberTradableGoods, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotBetween(Long value1, Long value2) {
            return notBetween(numberTradableGoods, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsTradeIsNull() {
            return isNull(isTrade);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeIsNotNull() {
            return isNotNull(isTrade);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeEqualTo(Long value) {
            return equalTo(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotEqualTo(Long value) {
            return notEqualTo(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeGreaterThan(Long value) {
            return greaterThan(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeLessThan(Long value) {
            return lessThan(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isTrade, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeIn(List<Long> values) {
            return in(isTrade, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotIn(List<Long> values) {
            return notIn(isTrade, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeBetween(Long value1, Long value2) {
            return between(isTrade, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotBetween(Long value1, Long value2) {
            return notBetween(isTrade, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andProvIsNull() {
            return isNull(prov);
        }

        public ShiguGoodsTinyExample.Criteria andProvIsNotNull() {
            return isNotNull(prov);
        }

        public ShiguGoodsTinyExample.Criteria andProvEqualTo(String value) {
            return equalTo(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvNotEqualTo(String value) {
            return notEqualTo(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvGreaterThan(String value) {
            return greaterThan(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvLessThan(String value) {
            return lessThan(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvLike(String value) {
            return like(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvNotLike(String value) {
            return notLike(prov, value);
        }

        public ShiguGoodsTinyExample.Criteria andProvIn(List<String> values) {
            return in(prov, values);
        }

        public ShiguGoodsTinyExample.Criteria andProvNotIn(List<String> values) {
            return notIn(prov, values);
        }

        public ShiguGoodsTinyExample.Criteria andProvBetween(String value1, String value2) {
            return between(prov, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andProvNotBetween(String value1, String value2) {
            return notBetween(prov, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andGoodsNoIsNull() {
            return isNull(goodsNo);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoIsNotNull() {
            return isNotNull(goodsNo);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoEqualTo(String value) {
            return equalTo(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotEqualTo(String value) {
            return notEqualTo(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoGreaterThan(String value) {
            return greaterThan(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLessThan(String value) {
            return lessThan(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLike(String value) {
            return like(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotLike(String value) {
            return notLike(goodsNo, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoIn(List<String> values) {
            return in(goodsNo, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotIn(List<String> values) {
            return notIn(goodsNo, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoBetween(String value1, String value2) {
            return between(goodsNo, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            return notBetween(goodsNo, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIsNull() {
            return isNull(inStoreSortOrder);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIsNotNull() {
            return isNotNull(inStoreSortOrder);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderEqualTo(Long value) {
            return equalTo(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotEqualTo(Long value) {
            return notEqualTo(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderGreaterThan(Long value) {
            return greaterThan(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderLessThan(Long value) {
            return lessThan(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(inStoreSortOrder, value);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIn(List<Long> values) {
            return in(inStoreSortOrder, values);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotIn(List<Long> values) {
            return notIn(inStoreSortOrder, values);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderBetween(Long value1, Long value2) {
            return between(inStoreSortOrder, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(inStoreSortOrder, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIsNull() {
            return isNull(soldOutTime);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIsNotNull() {
            return isNotNull(soldOutTime);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeEqualTo(Date value) {
            return equalTo(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotEqualTo(Date value) {
            return notEqualTo(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeGreaterThan(Date value) {
            return greaterThan(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeLessThan(Date value) {
            return lessThan(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(soldOutTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIn(List<Date> values) {
            return in(soldOutTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotIn(List<Date> values) {
            return notIn(soldOutTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeBetween(Date value1, Date value2) {
            return between(soldOutTime, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotBetween(Date value1, Date value2) {
            return notBetween(soldOutTime, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIsNull() {
            return isNull(upDataPackageUrl);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIsNotNull() {
            return isNotNull(upDataPackageUrl);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlEqualTo(String value) {
            return equalTo(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotEqualTo(String value) {
            return notEqualTo(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlGreaterThan(String value) {
            return greaterThan(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLessThan(String value) {
            return lessThan(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLike(String value) {
            return like(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotLike(String value) {
            return notLike(upDataPackageUrl, value);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIn(List<String> values) {
            return in(upDataPackageUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotIn(List<String> values) {
            return notIn(upDataPackageUrl, values);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlBetween(String value1, String value2) {
            return between(upDataPackageUrl, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotBetween(String value1, String value2) {
            return notBetween(upDataPackageUrl, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIsNull() {
            return isNull(modeTopTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIsNotNull() {
            return isNotNull(modeTopTypeId);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdEqualTo(Long value) {
            return equalTo(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotEqualTo(Long value) {
            return notEqualTo(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdGreaterThan(Long value) {
            return greaterThan(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdLessThan(Long value) {
            return lessThan(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(modeTopTypeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIn(List<Long> values) {
            return in(modeTopTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotIn(List<Long> values) {
            return notIn(modeTopTypeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdBetween(Long value1, Long value2) {
            return between(modeTopTypeId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotBetween(Long value1, Long value2) {
            return notBetween(modeTopTypeId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIsNull() {
            return isNull(isUserSetPiPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIsNotNull() {
            return isNotNull(isUserSetPiPrice);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceEqualTo(Integer value) {
            return equalTo(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotEqualTo(Integer value) {
            return notEqualTo(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceGreaterThan(Integer value) {
            return greaterThan(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceLessThan(Integer value) {
            return lessThan(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isUserSetPiPrice, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIn(List<Integer> values) {
            return in(isUserSetPiPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotIn(List<Integer> values) {
            return notIn(isUserSetPiPrice, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceBetween(Integer value1, Integer value2) {
            return between(isUserSetPiPrice, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotBetween(Integer value1, Integer value2) {
            return notBetween(isUserSetPiPrice, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andCidAllIsNull() {
            return isNull(cidAll);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllIsNotNull() {
            return isNotNull(cidAll);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllEqualTo(String value) {
            return equalTo(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotEqualTo(String value) {
            return notEqualTo(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllGreaterThan(String value) {
            return greaterThan(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLessThan(String value) {
            return lessThan(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLike(String value) {
            return like(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotLike(String value) {
            return notLike(cidAll, value);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllIn(List<String> values) {
            return in(cidAll, values);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotIn(List<String> values) {
            return notIn(cidAll, values);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllBetween(String value1, String value2) {
            return between(cidAll, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotBetween(String value1, String value2) {
            return notBetween(cidAll, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andHasDiscountIsNull() {
            return isNull(hasDiscount);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountIsNotNull() {
            return isNotNull(hasDiscount);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountEqualTo(String value) {
            return equalTo(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotEqualTo(String value) {
            return notEqualTo(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountGreaterThan(String value) {
            return greaterThan(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLessThan(String value) {
            return lessThan(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLike(String value) {
            return like(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotLike(String value) {
            return notLike(hasDiscount, value);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountIn(List<String> values) {
            return in(hasDiscount, values);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotIn(List<String> values) {
            return notIn(hasDiscount, values);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountBetween(String value1, String value2) {
            return between(hasDiscount, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotBetween(String value1, String value2) {
            return notBetween(hasDiscount, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andParentMarketIdIsNull() {
            return isNull(parentMarketId);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdIsNotNull() {
            return isNotNull(parentMarketId);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdEqualTo(Long value) {
            return equalTo(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            return notEqualTo(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdGreaterThan(Long value) {
            return greaterThan(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdLessThan(Long value) {
            return lessThan(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentMarketId, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdIn(List<Long> values) {
            return in(parentMarketId, values);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            return notIn(parentMarketId, values);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            return between(parentMarketId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(parentMarketId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andDelistTimeIsNull() {
            return isNull(delistTime);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeIsNotNull() {
            return isNotNull(delistTime);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeEqualTo(Date value) {
            return equalTo(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotEqualTo(Date value) {
            return notEqualTo(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeGreaterThan(Date value) {
            return greaterThan(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeLessThan(Date value) {
            return lessThan(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(delistTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeIn(List<Date> values) {
            return in(delistTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotIn(List<Date> values) {
            return notIn(delistTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeBetween(Date value1, Date value2) {
            return between(delistTime, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            return notBetween(delistTime, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andPostFeeIsNull() {
            return isNull(postFee);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeIsNotNull() {
            return isNotNull(postFee);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeEqualTo(String value) {
            return equalTo(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotEqualTo(String value) {
            return notEqualTo(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeGreaterThan(String value) {
            return greaterThan(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLessThan(String value) {
            return lessThan(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLike(String value) {
            return like(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotLike(String value) {
            return notLike(postFee, value);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeIn(List<String> values) {
            return in(postFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotIn(List<String> values) {
            return notIn(postFee, values);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeBetween(String value1, String value2) {
            return between(postFee, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotBetween(String value1, String value2) {
            return notBetween(postFee, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsStandardIsNull() {
            return isNull(isStandard);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardIsNotNull() {
            return isNotNull(isStandard);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardEqualTo(Integer value) {
            return equalTo(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotEqualTo(Integer value) {
            return notEqualTo(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardGreaterThan(Integer value) {
            return greaterThan(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardLessThan(Integer value) {
            return lessThan(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isStandard, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardIn(List<Integer> values) {
            return in(isStandard, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotIn(List<Integer> values) {
            return notIn(isStandard, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardBetween(Integer value1, Integer value2) {
            return between(isStandard, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotBetween(Integer value1, Integer value2) {
            return notBetween(isStandard, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsClosedIsNull() {
            return isNull(isClosed);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedIsNotNull() {
            return isNotNull(isClosed);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedEqualTo(Long value) {
            return equalTo(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotEqualTo(Long value) {
            return notEqualTo(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedGreaterThan(Long value) {
            return greaterThan(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedLessThan(Long value) {
            return lessThan(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isClosed, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedIn(List<Long> values) {
            return in(isClosed, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotIn(List<Long> values) {
            return notIn(isClosed, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedBetween(Long value1, Long value2) {
            return between(isClosed, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotBetween(Long value1, Long value2) {
            return notBetween(isClosed, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andGoodsStatusIsNull() {
            return isNull(goodsStatus);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusIsNotNull() {
            return isNotNull(goodsStatus);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusEqualTo(Integer value) {
            return equalTo(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusGreaterThan(Integer value) {
            return greaterThan(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusLessThan(Integer value) {
            return lessThan(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusIn(List<Integer> values) {
            return in(goodsStatus, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotIn(List<Integer> values) {
            return notIn(goodsStatus, values);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            return between(goodsStatus, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsStatus, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsExcelImpIsNull() {
            return isNull(isExcelImp);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpIsNotNull() {
            return isNotNull(isExcelImp);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpEqualTo(Integer value) {
            return equalTo(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotEqualTo(Integer value) {
            return notEqualTo(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpGreaterThan(Integer value) {
            return greaterThan(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpLessThan(Integer value) {
            return lessThan(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isExcelImp, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpIn(List<Integer> values) {
            return in(isExcelImp, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotIn(List<Integer> values) {
            return notIn(isExcelImp, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpBetween(Integer value1, Integer value2) {
            return between(isExcelImp, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotBetween(Integer value1, Integer value2) {
            return notBetween(isExcelImp, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andStuffStatusIsNull() {
            return isNull(stuffStatus);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusIsNotNull() {
            return isNotNull(stuffStatus);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusEqualTo(String value) {
            return equalTo(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotEqualTo(String value) {
            return notEqualTo(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusGreaterThan(String value) {
            return greaterThan(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLessThan(String value) {
            return lessThan(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLike(String value) {
            return like(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotLike(String value) {
            return notLike(stuffStatus, value);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusIn(List<String> values) {
            return in(stuffStatus, values);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotIn(List<String> values) {
            return notIn(stuffStatus, values);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusBetween(String value1, String value2) {
            return between(stuffStatus, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotBetween(String value1, String value2) {
            return notBetween(stuffStatus, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andParentMarketNameIsNull() {
            return isNull(parentMarketName);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameIsNotNull() {
            return isNotNull(parentMarketName);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameEqualTo(String value) {
            return equalTo(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotEqualTo(String value) {
            return notEqualTo(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameGreaterThan(String value) {
            return greaterThan(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLessThan(String value) {
            return lessThan(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLike(String value) {
            return like(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotLike(String value) {
            return notLike(parentMarketName, value);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameIn(List<String> values) {
            return in(parentMarketName, values);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotIn(List<String> values) {
            return notIn(parentMarketName, values);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            return between(parentMarketName, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            return notBetween(parentMarketName, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIsNull() {
            return isNull(relationLevelId);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIsNotNull() {
            return isNotNull(relationLevelId);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdEqualTo(Long value) {
            return equalTo(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotEqualTo(Long value) {
            return notEqualTo(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdGreaterThan(Long value) {
            return greaterThan(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdLessThan(Long value) {
            return lessThan(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(relationLevelId, value);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIn(List<Long> values) {
            return in(relationLevelId, values);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotIn(List<Long> values) {
            return notIn(relationLevelId, values);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdBetween(Long value1, Long value2) {
            return between(relationLevelId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotBetween(Long value1, Long value2) {
            return notBetween(relationLevelId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andClicksIsNull() {
            return isNull(clicks);
        }

        public ShiguGoodsTinyExample.Criteria andClicksIsNotNull() {
            return isNotNull(clicks);
        }

        public ShiguGoodsTinyExample.Criteria andClicksEqualTo(Long value) {
            return equalTo(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotEqualTo(Long value) {
            return notEqualTo(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksGreaterThan(Long value) {
            return greaterThan(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksLessThan(Long value) {
            return lessThan(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicks, value);
        }

        public ShiguGoodsTinyExample.Criteria andClicksIn(List<Long> values) {
            return in(clicks, values);
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotIn(List<Long> values) {
            return notIn(clicks, values);
        }

        public ShiguGoodsTinyExample.Criteria andClicksBetween(Long value1, Long value2) {
            return between(clicks, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            return notBetween(clicks, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andOuterIdIsNull() {
            return isNull(outerId);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdIsNotNull() {
            return isNotNull(outerId);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdEqualTo(String value) {
            return equalTo(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotEqualTo(String value) {
            return notEqualTo(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdGreaterThan(String value) {
            return greaterThan(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLessThan(String value) {
            return lessThan(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLike(String value) {
            return like(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotLike(String value) {
            return notLike(outerId, value);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdIn(List<String> values) {
            return in(outerId, values);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotIn(List<String> values) {
            return notIn(outerId, values);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdBetween(String value1, String value2) {
            return between(outerId, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            return notBetween(outerId, value1, value2);
        }
        public ShiguGoodsTinyExample.Criteria andIsShowcaseIsNull() {
            return isNull(isShowcase);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseIsNotNull() {
            return isNotNull(isShowcase);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseEqualTo(Integer value) {
            return equalTo(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotEqualTo(Integer value) {
            return notEqualTo(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseGreaterThan(Integer value) {
            return greaterThan(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseLessThan(Integer value) {
            return lessThan(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isShowcase, value);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseIn(List<Integer> values) {
            return in(isShowcase, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotIn(List<Integer> values) {
            return notIn(isShowcase, values);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseBetween(Integer value1, Integer value2) {
            return between(isShowcase, value1, value2);
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotBetween(Integer value1, Integer value2) {
            return notBetween(isShowcase, value1, value2);
        }
    }
}
