package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;

import java.util.*;
public class DaifaAfterSaleSubExample extends SgExample<DaifaAfterSaleSubExample.Criteria> {
    public static final Class<DaifaAfterSaleSub> beanClass = DaifaAfterSaleSub.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sendDate;
    public static EntityColumn afterSaleSubId;
    public static EntityColumn hasNum;
    public static EntityColumn returnStatus;
    public static EntityColumn buyerId;
    public static EntityColumn buyerQq;
    public static EntityColumn singlePrice;
    public static EntityColumn singlePiPrice;
    public static EntityColumn sellerId;
    public static EntityColumn returnPostNama;
    public static EntityColumn dfOrderId;
    public static EntityColumn postId;
    public static EntityColumn sendTime;
    public static EntityColumn dfTradeId;
    public static EntityColumn picPath;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn goodsNummIid;
    public static EntityColumn remark7;
    public static EntityColumn changeStatus;
    public static EntityColumn postCode;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn storeNum;
    public static EntityColumn remark3;
    public static EntityColumn cid;
    public static EntityColumn remark2;
    public static EntityColumn buyerTelephone;
    public static EntityColumn goodsId;
    public static EntityColumn sellerName;
    public static EntityColumn remark;
    public static EntityColumn afterSaleId;
    public static EntityColumn title;
    public static EntityColumn marketId;
    public static EntityColumn webSite;
    public static EntityColumn buyerWw;
    public static EntityColumn postName;
    public static EntityColumn propStr;
    public static EntityColumn goodsNum;
    public static EntityColumn createDate;
    public static EntityColumn storeGoodsCode;
    public static EntityColumn parentMarketId;
    public static EntityColumn buyerName;
    public static EntityColumn storeId;
    public static EntityColumn marketName;
    public static EntityColumn createTime;
    public static EntityColumn parentMarketName;
    public static EntityColumn returnPostCode;
    public static EntityColumn sendStatus;
    public static EntityColumn goodsCode;
    public static EntityColumn cdkey;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sendDate = listMap.get("sendDate");
        afterSaleSubId = listMap.get("afterSaleSubId");
        hasNum = listMap.get("hasNum");
        returnStatus = listMap.get("returnStatus");
        buyerId = listMap.get("buyerId");
        buyerQq = listMap.get("buyerQq");
        singlePrice = listMap.get("singlePrice");
        singlePiPrice = listMap.get("singlePiPrice");
        sellerId = listMap.get("sellerId");
        returnPostNama = listMap.get("returnPostNama");
        dfOrderId = listMap.get("dfOrderId");
        postId = listMap.get("postId");
        sendTime = listMap.get("sendTime");
        dfTradeId = listMap.get("dfTradeId");
        picPath = listMap.get("picPath");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        goodsNummIid = listMap.get("goodsNummIid");
        remark7 = listMap.get("remark7");
        changeStatus = listMap.get("changeStatus");
        postCode = listMap.get("postCode");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        storeNum = listMap.get("storeNum");
        remark3 = listMap.get("remark3");
        cid = listMap.get("cid");
        remark2 = listMap.get("remark2");
        buyerTelephone = listMap.get("buyerTelephone");
        goodsId = listMap.get("goodsId");
        sellerName = listMap.get("sellerName");
        remark = listMap.get("remark");
        afterSaleId = listMap.get("afterSaleId");
        title = listMap.get("title");
        marketId = listMap.get("marketId");
        webSite = listMap.get("webSite");
        buyerWw = listMap.get("buyerWw");
        postName = listMap.get("postName");
        propStr = listMap.get("propStr");
        goodsNum = listMap.get("goodsNum");
        createDate = listMap.get("createDate");
        storeGoodsCode = listMap.get("storeGoodsCode");
        parentMarketId = listMap.get("parentMarketId");
        buyerName = listMap.get("buyerName");
        storeId = listMap.get("storeId");
        marketName = listMap.get("marketName");
        createTime = listMap.get("createTime");
        parentMarketName = listMap.get("parentMarketName");
        returnPostCode = listMap.get("returnPostCode");
        sendStatus = listMap.get("sendStatus");
        goodsCode = listMap.get("goodsCode");
        cdkey = listMap.get("cdkey");
        }

    public DaifaAfterSaleSubExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaAfterSaleSubExample.Criteria createCriteriaInternal() {
        return new DaifaAfterSaleSubExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateIsNull() {
            return isNull(sendDate);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateIsNotNull() {
            return isNotNull(sendDate);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateEqualTo(String value) {
            return equalTo(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateNotEqualTo(String value) {
            return notEqualTo(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateGreaterThan(String value) {
            return greaterThan(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateLessThan(String value) {
            return lessThan(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateLike(String value) {
            return like(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateNotLike(String value) {
            return notLike(sendDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateIn(List<String> values) {
            return in(sendDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateNotIn(List<String> values) {
            return notIn(sendDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateBetween(String value1, String value2) {
            return between(sendDate, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSendDateNotBetween(String value1, String value2) {
            return notBetween(sendDate, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdIsNull() {
            return isNull(afterSaleSubId);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdIsNotNull() {
            return isNotNull(afterSaleSubId);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdEqualTo(Long value) {
            return equalTo(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdGreaterThan(Long value) {
            return greaterThan(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdLessThan(Long value) {
            return lessThan(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdIn(List<Long> values) {
            return in(afterSaleSubId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdNotIn(List<Long> values) {
            return notIn(afterSaleSubId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdBetween(Long value1, Long value2) {
            return between(afterSaleSubId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleSubIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleSubId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andHasNumIsNull() {
            return isNull(hasNum);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumIsNotNull() {
            return isNotNull(hasNum);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumEqualTo(Integer value) {
            return equalTo(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumNotEqualTo(Integer value) {
            return notEqualTo(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumGreaterThan(Integer value) {
            return greaterThan(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumLessThan(Integer value) {
            return lessThan(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumIn(List<Integer> values) {
            return in(hasNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumNotIn(List<Integer> values) {
            return notIn(hasNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumBetween(Integer value1, Integer value2) {
            return between(hasNum, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andHasNumNotBetween(Integer value1, Integer value2) {
            return notBetween(hasNum, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdEqualTo(Integer value) {
            return equalTo(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdNotEqualTo(Integer value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdGreaterThan(Integer value) {
            return greaterThan(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdLessThan(Integer value) {
            return lessThan(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdIn(List<Integer> values) {
            return in(buyerId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdNotIn(List<Integer> values) {
            return notIn(buyerId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaIsNull() {
            return isNull(returnPostNama);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaIsNotNull() {
            return isNotNull(returnPostNama);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaEqualTo(String value) {
            return equalTo(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaNotEqualTo(String value) {
            return notEqualTo(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaGreaterThan(String value) {
            return greaterThan(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaLessThan(String value) {
            return lessThan(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaLike(String value) {
            return like(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaNotLike(String value) {
            return notLike(returnPostNama, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaIn(List<String> values) {
            return in(returnPostNama, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaNotIn(List<String> values) {
            return notIn(returnPostNama, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaBetween(String value1, String value2) {
            return between(returnPostNama, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostNamaNotBetween(String value1, String value2) {
            return notBetween(returnPostNama, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andPostIdIsNull() {
            return isNull(postId);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdIsNotNull() {
            return isNotNull(postId);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdEqualTo(Long value) {
            return equalTo(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdNotEqualTo(Long value) {
            return notEqualTo(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdGreaterThan(Long value) {
            return greaterThan(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdLessThan(Long value) {
            return lessThan(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdIn(List<Long> values) {
            return in(postId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdNotIn(List<Long> values) {
            return notIn(postId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdBetween(Long value1, Long value2) {
            return between(postId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andPostIdNotBetween(Long value1, Long value2) {
            return notBetween(postId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidIsNull() {
            return isNull(goodsNummIid);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidIsNotNull() {
            return isNotNull(goodsNummIid);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidEqualTo(Long value) {
            return equalTo(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidNotEqualTo(Long value) {
            return notEqualTo(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidGreaterThan(Long value) {
            return greaterThan(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidLessThan(Long value) {
            return lessThan(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsNummIid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidIn(List<Long> values) {
            return in(goodsNummIid, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidNotIn(List<Long> values) {
            return notIn(goodsNummIid, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidBetween(Long value1, Long value2) {
            return between(goodsNummIid, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNummIidNotBetween(Long value1, Long value2) {
            return notBetween(goodsNummIid, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andChangeStatusIsNull() {
            return isNull(changeStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusIsNotNull() {
            return isNotNull(changeStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusEqualTo(Integer value) {
            return equalTo(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusNotEqualTo(Integer value) {
            return notEqualTo(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusGreaterThan(Integer value) {
            return greaterThan(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusLessThan(Integer value) {
            return lessThan(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(changeStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusIn(List<Integer> values) {
            return in(changeStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusNotIn(List<Integer> values) {
            return notIn(changeStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusBetween(Integer value1, Integer value2) {
            return between(changeStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(changeStatus, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andPostCodeIsNull() {
            return isNull(postCode);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeIsNotNull() {
            return isNotNull(postCode);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeEqualTo(String value) {
            return equalTo(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeNotEqualTo(String value) {
            return notEqualTo(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeGreaterThan(String value) {
            return greaterThan(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeLessThan(String value) {
            return lessThan(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeLike(String value) {
            return like(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeNotLike(String value) {
            return notLike(postCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeIn(List<String> values) {
            return in(postCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeNotIn(List<String> values) {
            return notIn(postCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeBetween(String value1, String value2) {
            return between(postCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andPostCodeNotBetween(String value1, String value2) {
            return notBetween(postCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public DaifaAfterSaleSubExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public DaifaAfterSaleSubExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSellerNameIsNull() {
            return isNull(sellerName);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameIsNotNull() {
            return isNotNull(sellerName);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameEqualTo(String value) {
            return equalTo(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameNotEqualTo(String value) {
            return notEqualTo(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameGreaterThan(String value) {
            return greaterThan(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameLessThan(String value) {
            return lessThan(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameLike(String value) {
            return like(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameNotLike(String value) {
            return notLike(sellerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameIn(List<String> values) {
            return in(sellerName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameNotIn(List<String> values) {
            return notIn(sellerName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameBetween(String value1, String value2) {
            return between(sellerName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSellerNameNotBetween(String value1, String value2) {
            return notBetween(sellerName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andPostNameIsNull() {
            return isNull(postName);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameIsNotNull() {
            return isNotNull(postName);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameEqualTo(String value) {
            return equalTo(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameNotEqualTo(String value) {
            return notEqualTo(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameGreaterThan(String value) {
            return greaterThan(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameLessThan(String value) {
            return lessThan(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameLike(String value) {
            return like(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameNotLike(String value) {
            return notLike(postName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameIn(List<String> values) {
            return in(postName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameNotIn(List<String> values) {
            return notIn(postName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameBetween(String value1, String value2) {
            return between(postName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andPostNameNotBetween(String value1, String value2) {
            return notBetween(postName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andParentMarketIdIsNull() {
            return isNull(parentMarketId);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdIsNotNull() {
            return isNotNull(parentMarketId);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdEqualTo(Long value) {
            return equalTo(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            return notEqualTo(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdGreaterThan(Long value) {
            return greaterThan(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdLessThan(Long value) {
            return lessThan(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentMarketId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdIn(List<Long> values) {
            return in(parentMarketId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            return notIn(parentMarketId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            return between(parentMarketId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(parentMarketId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andParentMarketNameIsNull() {
            return isNull(parentMarketName);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameIsNotNull() {
            return isNotNull(parentMarketName);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameEqualTo(String value) {
            return equalTo(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameNotEqualTo(String value) {
            return notEqualTo(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameGreaterThan(String value) {
            return greaterThan(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameLessThan(String value) {
            return lessThan(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameLike(String value) {
            return like(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameNotLike(String value) {
            return notLike(parentMarketName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameIn(List<String> values) {
            return in(parentMarketName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameNotIn(List<String> values) {
            return notIn(parentMarketName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            return between(parentMarketName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            return notBetween(parentMarketName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeIsNull() {
            return isNull(returnPostCode);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeIsNotNull() {
            return isNotNull(returnPostCode);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeEqualTo(String value) {
            return equalTo(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeNotEqualTo(String value) {
            return notEqualTo(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeGreaterThan(String value) {
            return greaterThan(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeLessThan(String value) {
            return lessThan(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeLike(String value) {
            return like(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeNotLike(String value) {
            return notLike(returnPostCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeIn(List<String> values) {
            return in(returnPostCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeNotIn(List<String> values) {
            return notIn(returnPostCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeBetween(String value1, String value2) {
            return between(returnPostCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnPostCodeNotBetween(String value1, String value2) {
            return notBetween(returnPostCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
    }
}