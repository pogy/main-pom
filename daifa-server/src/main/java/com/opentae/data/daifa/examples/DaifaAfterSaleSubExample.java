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
    public static EntityColumn afterSaleSubId;
    public static EntityColumn hasNum;
    public static EntityColumn buyerId;
    public static EntityColumn floorId;
    public static EntityColumn applyExpressName;
    public static EntityColumn storeReturnMoney;
    public static EntityColumn buyerQq;
    public static EntityColumn afterStatus;
    public static EntityColumn singlePrice;
    public static EntityColumn singlePiPrice;
    public static EntityColumn sellerId;
    public static EntityColumn inStock;
    public static EntityColumn applyTime;
    public static EntityColumn lastDoTime;
    public static EntityColumn dfOrderId;
    public static EntityColumn storeDealTime;
    public static EntityColumn tradeCode;
    public static EntityColumn storeRefuseReason;
    public static EntityColumn dfTradeId;
    public static EntityColumn picPath;
    public static EntityColumn returnExpressName;
    public static EntityColumn remark1;
    public static EntityColumn applyDealStatus;
    public static EntityColumn storeNum;
    public static EntityColumn remark2;
    public static EntityColumn buyerTelephone;
    public static EntityColumn stockLocation;
    public static EntityColumn goodsId;
    public static EntityColumn sendReturnTime;
    public static EntityColumn remark;
    public static EntityColumn afterSaleId;
    public static EntityColumn title;
    public static EntityColumn marketId;
    public static EntityColumn changeExpressName;
    public static EntityColumn webSite;
    public static EntityColumn buyerWw;
    public static EntityColumn changeExpressCode;
    public static EntityColumn returnExpressCode;
    public static EntityColumn sendReturnDate;
    public static EntityColumn floorName;
    public static EntityColumn propStr;
    public static EntityColumn goodsNum;
    public static EntityColumn createDate;
    public static EntityColumn storeGoodsCode;
    public static EntityColumn storeDealStatus;
    public static EntityColumn applyDealTime;
    public static EntityColumn buyerName;
    public static EntityColumn storeId;
    public static EntityColumn marketName;
    public static EntityColumn createTime;
    public static EntityColumn afterType;
    public static EntityColumn applyExpressCode;
    public static EntityColumn receivedTime;
    public static EntityColumn applyRefuseReason;
    public static EntityColumn orderPartitionId;
    public static EntityColumn orderCode;
    public static EntityColumn goodsCode;
    public static EntityColumn refundId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        afterSaleSubId = listMap.get("afterSaleSubId");
        hasNum = listMap.get("hasNum");
        buyerId = listMap.get("buyerId");
        floorId = listMap.get("floorId");
        applyExpressName = listMap.get("applyExpressName");
        storeReturnMoney = listMap.get("storeReturnMoney");
        buyerQq = listMap.get("buyerQq");
        afterStatus = listMap.get("afterStatus");
        singlePrice = listMap.get("singlePrice");
        singlePiPrice = listMap.get("singlePiPrice");
        sellerId = listMap.get("sellerId");
        inStock = listMap.get("inStock");
        applyTime = listMap.get("applyTime");
        lastDoTime = listMap.get("lastDoTime");
        dfOrderId = listMap.get("dfOrderId");
        storeDealTime = listMap.get("storeDealTime");
        tradeCode = listMap.get("tradeCode");
        storeRefuseReason = listMap.get("storeRefuseReason");
        dfTradeId = listMap.get("dfTradeId");
        picPath = listMap.get("picPath");
        returnExpressName = listMap.get("returnExpressName");
        remark1 = listMap.get("remark1");
        applyDealStatus = listMap.get("applyDealStatus");
        storeNum = listMap.get("storeNum");
        remark2 = listMap.get("remark2");
        buyerTelephone = listMap.get("buyerTelephone");
        stockLocation = listMap.get("stockLocation");
        goodsId = listMap.get("goodsId");
        sendReturnTime = listMap.get("sendReturnTime");
        remark = listMap.get("remark");
        afterSaleId = listMap.get("afterSaleId");
        title = listMap.get("title");
        marketId = listMap.get("marketId");
        changeExpressName = listMap.get("changeExpressName");
        webSite = listMap.get("webSite");
        buyerWw = listMap.get("buyerWw");
        changeExpressCode = listMap.get("changeExpressCode");
        returnExpressCode = listMap.get("returnExpressCode");
        sendReturnDate = listMap.get("sendReturnDate");
        floorName = listMap.get("floorName");
        propStr = listMap.get("propStr");
        goodsNum = listMap.get("goodsNum");
        createDate = listMap.get("createDate");
        storeGoodsCode = listMap.get("storeGoodsCode");
        storeDealStatus = listMap.get("storeDealStatus");
        applyDealTime = listMap.get("applyDealTime");
        buyerName = listMap.get("buyerName");
        storeId = listMap.get("storeId");
        marketName = listMap.get("marketName");
        createTime = listMap.get("createTime");
        afterType = listMap.get("afterType");
        applyExpressCode = listMap.get("applyExpressCode");
        receivedTime = listMap.get("receivedTime");
        applyRefuseReason = listMap.get("applyRefuseReason");
        orderPartitionId = listMap.get("orderPartitionId");
        orderCode = listMap.get("orderCode");
        goodsCode = listMap.get("goodsCode");
        refundId = listMap.get("refundId");
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
        public DaifaAfterSaleSubExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameIsNull() {
            return isNull(applyExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameIsNotNull() {
            return isNotNull(applyExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameEqualTo(String value) {
            return equalTo(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameNotEqualTo(String value) {
            return notEqualTo(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameGreaterThan(String value) {
            return greaterThan(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameLessThan(String value) {
            return lessThan(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameLike(String value) {
            return like(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameNotLike(String value) {
            return notLike(applyExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameIn(List<String> values) {
            return in(applyExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameNotIn(List<String> values) {
            return notIn(applyExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameBetween(String value1, String value2) {
            return between(applyExpressName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressNameNotBetween(String value1, String value2) {
            return notBetween(applyExpressName, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyIsNull() {
            return isNull(storeReturnMoney);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyIsNotNull() {
            return isNotNull(storeReturnMoney);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyEqualTo(String value) {
            return equalTo(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyNotEqualTo(String value) {
            return notEqualTo(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyGreaterThan(String value) {
            return greaterThan(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyLessThan(String value) {
            return lessThan(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyLike(String value) {
            return like(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyNotLike(String value) {
            return notLike(storeReturnMoney, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyIn(List<String> values) {
            return in(storeReturnMoney, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyNotIn(List<String> values) {
            return notIn(storeReturnMoney, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyBetween(String value1, String value2) {
            return between(storeReturnMoney, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreReturnMoneyNotBetween(String value1, String value2) {
            return notBetween(storeReturnMoney, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andAfterStatusIsNull() {
            return isNull(afterStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusIsNotNull() {
            return isNotNull(afterStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusEqualTo(Integer value) {
            return equalTo(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusNotEqualTo(Integer value) {
            return notEqualTo(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusGreaterThan(Integer value) {
            return greaterThan(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusLessThan(Integer value) {
            return lessThan(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(afterStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusIn(List<Integer> values) {
            return in(afterStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusNotIn(List<Integer> values) {
            return notIn(afterStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusBetween(Integer value1, Integer value2) {
            return between(afterStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(afterStatus, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andInStockIsNull() {
            return isNull(inStock);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockIsNotNull() {
            return isNotNull(inStock);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockEqualTo(Integer value) {
            return equalTo(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockNotEqualTo(Integer value) {
            return notEqualTo(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockGreaterThan(Integer value) {
            return greaterThan(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockLessThan(Integer value) {
            return lessThan(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inStock, value);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockIn(List<Integer> values) {
            return in(inStock, values);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockNotIn(List<Integer> values) {
            return notIn(inStock, values);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockBetween(Integer value1, Integer value2) {
            return between(inStock, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andInStockNotBetween(Integer value1, Integer value2) {
            return notBetween(inStock, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andApplyTimeIsNull() {
            return isNull(applyTime);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeIsNotNull() {
            return isNotNull(applyTime);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeEqualTo(Date value) {
            return equalTo(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeNotEqualTo(Date value) {
            return notEqualTo(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeGreaterThan(Date value) {
            return greaterThan(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeLessThan(Date value) {
            return lessThan(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeIn(List<Date> values) {
            return in(applyTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeNotIn(List<Date> values) {
            return notIn(applyTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeBetween(Date value1, Date value2) {
            return between(applyTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyTime, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeIsNull() {
            return isNull(storeDealTime);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeIsNotNull() {
            return isNotNull(storeDealTime);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeEqualTo(Date value) {
            return equalTo(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeNotEqualTo(Date value) {
            return notEqualTo(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeGreaterThan(Date value) {
            return greaterThan(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeLessThan(Date value) {
            return lessThan(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(storeDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeIn(List<Date> values) {
            return in(storeDealTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeNotIn(List<Date> values) {
            return notIn(storeDealTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeBetween(Date value1, Date value2) {
            return between(storeDealTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealTimeNotBetween(Date value1, Date value2) {
            return notBetween(storeDealTime, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonIsNull() {
            return isNull(storeRefuseReason);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonIsNotNull() {
            return isNotNull(storeRefuseReason);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonEqualTo(String value) {
            return equalTo(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonNotEqualTo(String value) {
            return notEqualTo(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonGreaterThan(String value) {
            return greaterThan(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonLessThan(String value) {
            return lessThan(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonLike(String value) {
            return like(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonNotLike(String value) {
            return notLike(storeRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonIn(List<String> values) {
            return in(storeRefuseReason, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonNotIn(List<String> values) {
            return notIn(storeRefuseReason, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonBetween(String value1, String value2) {
            return between(storeRefuseReason, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreRefuseReasonNotBetween(String value1, String value2) {
            return notBetween(storeRefuseReason, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameIsNull() {
            return isNull(returnExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameIsNotNull() {
            return isNotNull(returnExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameEqualTo(String value) {
            return equalTo(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameNotEqualTo(String value) {
            return notEqualTo(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameGreaterThan(String value) {
            return greaterThan(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameLessThan(String value) {
            return lessThan(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameLike(String value) {
            return like(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameNotLike(String value) {
            return notLike(returnExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameIn(List<String> values) {
            return in(returnExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameNotIn(List<String> values) {
            return notIn(returnExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameBetween(String value1, String value2) {
            return between(returnExpressName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressNameNotBetween(String value1, String value2) {
            return notBetween(returnExpressName, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusIsNull() {
            return isNull(applyDealStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusIsNotNull() {
            return isNotNull(applyDealStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusEqualTo(Integer value) {
            return equalTo(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusNotEqualTo(Integer value) {
            return notEqualTo(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusGreaterThan(Integer value) {
            return greaterThan(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusLessThan(Integer value) {
            return lessThan(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(applyDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusIn(List<Integer> values) {
            return in(applyDealStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusNotIn(List<Integer> values) {
            return notIn(applyDealStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusBetween(Integer value1, Integer value2) {
            return between(applyDealStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(applyDealStatus, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andStockLocationIsNull() {
            return isNull(stockLocation);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationIsNotNull() {
            return isNotNull(stockLocation);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationEqualTo(String value) {
            return equalTo(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationNotEqualTo(String value) {
            return notEqualTo(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationGreaterThan(String value) {
            return greaterThan(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationLessThan(String value) {
            return lessThan(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationLike(String value) {
            return like(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationNotLike(String value) {
            return notLike(stockLocation, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationIn(List<String> values) {
            return in(stockLocation, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationNotIn(List<String> values) {
            return notIn(stockLocation, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationBetween(String value1, String value2) {
            return between(stockLocation, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStockLocationNotBetween(String value1, String value2) {
            return notBetween(stockLocation, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeIsNull() {
            return isNull(sendReturnTime);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeIsNotNull() {
            return isNotNull(sendReturnTime);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeEqualTo(Date value) {
            return equalTo(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeNotEqualTo(Date value) {
            return notEqualTo(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeGreaterThan(Date value) {
            return greaterThan(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeLessThan(Date value) {
            return lessThan(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendReturnTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeIn(List<Date> values) {
            return in(sendReturnTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeNotIn(List<Date> values) {
            return notIn(sendReturnTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeBetween(Date value1, Date value2) {
            return between(sendReturnTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendReturnTime, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameIsNull() {
            return isNull(changeExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameIsNotNull() {
            return isNotNull(changeExpressName);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameEqualTo(String value) {
            return equalTo(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameNotEqualTo(String value) {
            return notEqualTo(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameGreaterThan(String value) {
            return greaterThan(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameLessThan(String value) {
            return lessThan(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameLike(String value) {
            return like(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameNotLike(String value) {
            return notLike(changeExpressName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameIn(List<String> values) {
            return in(changeExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameNotIn(List<String> values) {
            return notIn(changeExpressName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameBetween(String value1, String value2) {
            return between(changeExpressName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressNameNotBetween(String value1, String value2) {
            return notBetween(changeExpressName, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeIsNull() {
            return isNull(changeExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeIsNotNull() {
            return isNotNull(changeExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeEqualTo(String value) {
            return equalTo(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeNotEqualTo(String value) {
            return notEqualTo(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeGreaterThan(String value) {
            return greaterThan(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeLessThan(String value) {
            return lessThan(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeLike(String value) {
            return like(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeNotLike(String value) {
            return notLike(changeExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeIn(List<String> values) {
            return in(changeExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeNotIn(List<String> values) {
            return notIn(changeExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeBetween(String value1, String value2) {
            return between(changeExpressCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andChangeExpressCodeNotBetween(String value1, String value2) {
            return notBetween(changeExpressCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeIsNull() {
            return isNull(returnExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeIsNotNull() {
            return isNotNull(returnExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeEqualTo(String value) {
            return equalTo(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeNotEqualTo(String value) {
            return notEqualTo(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeGreaterThan(String value) {
            return greaterThan(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeLessThan(String value) {
            return lessThan(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeLike(String value) {
            return like(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeNotLike(String value) {
            return notLike(returnExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeIn(List<String> values) {
            return in(returnExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeNotIn(List<String> values) {
            return notIn(returnExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeBetween(String value1, String value2) {
            return between(returnExpressCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReturnExpressCodeNotBetween(String value1, String value2) {
            return notBetween(returnExpressCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andSendReturnDateIsNull() {
            return isNull(sendReturnDate);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateIsNotNull() {
            return isNotNull(sendReturnDate);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateEqualTo(String value) {
            return equalTo(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateNotEqualTo(String value) {
            return notEqualTo(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateGreaterThan(String value) {
            return greaterThan(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateLessThan(String value) {
            return lessThan(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateLike(String value) {
            return like(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateNotLike(String value) {
            return notLike(sendReturnDate, value);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateIn(List<String> values) {
            return in(sendReturnDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateNotIn(List<String> values) {
            return notIn(sendReturnDate, values);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateBetween(String value1, String value2) {
            return between(sendReturnDate, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andSendReturnDateNotBetween(String value1, String value2) {
            return notBetween(sendReturnDate, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusIsNull() {
            return isNull(storeDealStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusIsNotNull() {
            return isNotNull(storeDealStatus);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusEqualTo(Integer value) {
            return equalTo(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusNotEqualTo(Integer value) {
            return notEqualTo(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusGreaterThan(Integer value) {
            return greaterThan(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusLessThan(Integer value) {
            return lessThan(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(storeDealStatus, value);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusIn(List<Integer> values) {
            return in(storeDealStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusNotIn(List<Integer> values) {
            return notIn(storeDealStatus, values);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusBetween(Integer value1, Integer value2) {
            return between(storeDealStatus, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andStoreDealStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(storeDealStatus, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeIsNull() {
            return isNull(applyDealTime);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeIsNotNull() {
            return isNotNull(applyDealTime);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeEqualTo(Date value) {
            return equalTo(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeNotEqualTo(Date value) {
            return notEqualTo(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeGreaterThan(Date value) {
            return greaterThan(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeLessThan(Date value) {
            return lessThan(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyDealTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeIn(List<Date> values) {
            return in(applyDealTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeNotIn(List<Date> values) {
            return notIn(applyDealTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeBetween(Date value1, Date value2) {
            return between(applyDealTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyDealTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyDealTime, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andAfterTypeIsNull() {
            return isNull(afterType);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeIsNotNull() {
            return isNotNull(afterType);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeEqualTo(Integer value) {
            return equalTo(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeNotEqualTo(Integer value) {
            return notEqualTo(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeGreaterThan(Integer value) {
            return greaterThan(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeLessThan(Integer value) {
            return lessThan(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(afterType, value);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeIn(List<Integer> values) {
            return in(afterType, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeNotIn(List<Integer> values) {
            return notIn(afterType, values);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeBetween(Integer value1, Integer value2) {
            return between(afterType, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andAfterTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(afterType, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeIsNull() {
            return isNull(applyExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeIsNotNull() {
            return isNotNull(applyExpressCode);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeEqualTo(String value) {
            return equalTo(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeNotEqualTo(String value) {
            return notEqualTo(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeGreaterThan(String value) {
            return greaterThan(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeLessThan(String value) {
            return lessThan(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeLike(String value) {
            return like(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeNotLike(String value) {
            return notLike(applyExpressCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeIn(List<String> values) {
            return in(applyExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeNotIn(List<String> values) {
            return notIn(applyExpressCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeBetween(String value1, String value2) {
            return between(applyExpressCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyExpressCodeNotBetween(String value1, String value2) {
            return notBetween(applyExpressCode, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andReceivedTimeIsNull() {
            return isNull(receivedTime);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeIsNotNull() {
            return isNotNull(receivedTime);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeEqualTo(Date value) {
            return equalTo(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeNotEqualTo(Date value) {
            return notEqualTo(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeGreaterThan(Date value) {
            return greaterThan(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeLessThan(Date value) {
            return lessThan(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(receivedTime, value);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeIn(List<Date> values) {
            return in(receivedTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeNotIn(List<Date> values) {
            return notIn(receivedTime, values);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeBetween(Date value1, Date value2) {
            return between(receivedTime, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andReceivedTimeNotBetween(Date value1, Date value2) {
            return notBetween(receivedTime, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonIsNull() {
            return isNull(applyRefuseReason);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonIsNotNull() {
            return isNotNull(applyRefuseReason);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonEqualTo(String value) {
            return equalTo(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonNotEqualTo(String value) {
            return notEqualTo(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonGreaterThan(String value) {
            return greaterThan(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonLessThan(String value) {
            return lessThan(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonLike(String value) {
            return like(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonNotLike(String value) {
            return notLike(applyRefuseReason, value);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonIn(List<String> values) {
            return in(applyRefuseReason, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonNotIn(List<String> values) {
            return notIn(applyRefuseReason, values);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonBetween(String value1, String value2) {
            return between(applyRefuseReason, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andApplyRefuseReasonNotBetween(String value1, String value2) {
            return notBetween(applyRefuseReason, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public DaifaAfterSaleSubExample.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
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
        public DaifaAfterSaleSubExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaAfterSaleSubExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
    }
}