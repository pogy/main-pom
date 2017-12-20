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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andAfterSaleSubIdIsNull() {
            return isNull(afterSaleSubId);
        }

        public Criteria andAfterSaleSubIdIsNotNull() {
            return isNotNull(afterSaleSubId);
        }

        public Criteria andAfterSaleSubIdEqualTo(Long value) {
            return equalTo(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdGreaterThan(Long value) {
            return greaterThan(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdLessThan(Long value) {
            return lessThan(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleSubId, value);
        }

        public Criteria andAfterSaleSubIdIn(List<Long> values) {
            return in(afterSaleSubId, values);
        }

        public Criteria andAfterSaleSubIdNotIn(List<Long> values) {
            return notIn(afterSaleSubId, values);
        }

        public Criteria andAfterSaleSubIdBetween(Long value1, Long value2) {
            return between(afterSaleSubId, value1, value2);
        }

        public Criteria andAfterSaleSubIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleSubId, value1, value2);
        }
        public Criteria andHasNumIsNull() {
            return isNull(hasNum);
        }

        public Criteria andHasNumIsNotNull() {
            return isNotNull(hasNum);
        }

        public Criteria andHasNumEqualTo(Integer value) {
            return equalTo(hasNum, value);
        }

        public Criteria andHasNumNotEqualTo(Integer value) {
            return notEqualTo(hasNum, value);
        }

        public Criteria andHasNumGreaterThan(Integer value) {
            return greaterThan(hasNum, value);
        }

        public Criteria andHasNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasNum, value);
        }

        public Criteria andHasNumLessThan(Integer value) {
            return lessThan(hasNum, value);
        }

        public Criteria andHasNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasNum, value);
        }

        public Criteria andHasNumIn(List<Integer> values) {
            return in(hasNum, values);
        }

        public Criteria andHasNumNotIn(List<Integer> values) {
            return notIn(hasNum, values);
        }

        public Criteria andHasNumBetween(Integer value1, Integer value2) {
            return between(hasNum, value1, value2);
        }

        public Criteria andHasNumNotBetween(Integer value1, Integer value2) {
            return notBetween(hasNum, value1, value2);
        }
        public Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public Criteria andBuyerIdEqualTo(Integer value) {
            return equalTo(buyerId, value);
        }

        public Criteria andBuyerIdNotEqualTo(Integer value) {
            return notEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThan(Integer value) {
            return greaterThan(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLessThan(Integer value) {
            return lessThan(buyerId, value);
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdIn(List<Integer> values) {
            return in(buyerId, values);
        }

        public Criteria andBuyerIdNotIn(List<Integer> values) {
            return notIn(buyerId, values);
        }

        public Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            return between(buyerId, value1, value2);
        }

        public Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            return notBetween(buyerId, value1, value2);
        }
        public Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public Criteria andApplyExpressNameIsNull() {
            return isNull(applyExpressName);
        }

        public Criteria andApplyExpressNameIsNotNull() {
            return isNotNull(applyExpressName);
        }

        public Criteria andApplyExpressNameEqualTo(String value) {
            return equalTo(applyExpressName, value);
        }

        public Criteria andApplyExpressNameNotEqualTo(String value) {
            return notEqualTo(applyExpressName, value);
        }

        public Criteria andApplyExpressNameGreaterThan(String value) {
            return greaterThan(applyExpressName, value);
        }

        public Criteria andApplyExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyExpressName, value);
        }

        public Criteria andApplyExpressNameLessThan(String value) {
            return lessThan(applyExpressName, value);
        }

        public Criteria andApplyExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyExpressName, value);
        }

        public Criteria andApplyExpressNameLike(String value) {
            return like(applyExpressName, value);
        }

        public Criteria andApplyExpressNameNotLike(String value) {
            return notLike(applyExpressName, value);
        }

        public Criteria andApplyExpressNameIn(List<String> values) {
            return in(applyExpressName, values);
        }

        public Criteria andApplyExpressNameNotIn(List<String> values) {
            return notIn(applyExpressName, values);
        }

        public Criteria andApplyExpressNameBetween(String value1, String value2) {
            return between(applyExpressName, value1, value2);
        }

        public Criteria andApplyExpressNameNotBetween(String value1, String value2) {
            return notBetween(applyExpressName, value1, value2);
        }
        public Criteria andStoreReturnMoneyIsNull() {
            return isNull(storeReturnMoney);
        }

        public Criteria andStoreReturnMoneyIsNotNull() {
            return isNotNull(storeReturnMoney);
        }

        public Criteria andStoreReturnMoneyEqualTo(String value) {
            return equalTo(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyNotEqualTo(String value) {
            return notEqualTo(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyGreaterThan(String value) {
            return greaterThan(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyLessThan(String value) {
            return lessThan(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyLike(String value) {
            return like(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyNotLike(String value) {
            return notLike(storeReturnMoney, value);
        }

        public Criteria andStoreReturnMoneyIn(List<String> values) {
            return in(storeReturnMoney, values);
        }

        public Criteria andStoreReturnMoneyNotIn(List<String> values) {
            return notIn(storeReturnMoney, values);
        }

        public Criteria andStoreReturnMoneyBetween(String value1, String value2) {
            return between(storeReturnMoney, value1, value2);
        }

        public Criteria andStoreReturnMoneyNotBetween(String value1, String value2) {
            return notBetween(storeReturnMoney, value1, value2);
        }
        public Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public Criteria andAfterStatusIsNull() {
            return isNull(afterStatus);
        }

        public Criteria andAfterStatusIsNotNull() {
            return isNotNull(afterStatus);
        }

        public Criteria andAfterStatusEqualTo(Integer value) {
            return equalTo(afterStatus, value);
        }

        public Criteria andAfterStatusNotEqualTo(Integer value) {
            return notEqualTo(afterStatus, value);
        }

        public Criteria andAfterStatusGreaterThan(Integer value) {
            return greaterThan(afterStatus, value);
        }

        public Criteria andAfterStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(afterStatus, value);
        }

        public Criteria andAfterStatusLessThan(Integer value) {
            return lessThan(afterStatus, value);
        }

        public Criteria andAfterStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(afterStatus, value);
        }

        public Criteria andAfterStatusIn(List<Integer> values) {
            return in(afterStatus, values);
        }

        public Criteria andAfterStatusNotIn(List<Integer> values) {
            return notIn(afterStatus, values);
        }

        public Criteria andAfterStatusBetween(Integer value1, Integer value2) {
            return between(afterStatus, value1, value2);
        }

        public Criteria andAfterStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(afterStatus, value1, value2);
        }
        public Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public Criteria andInStockIsNull() {
            return isNull(inStock);
        }

        public Criteria andInStockIsNotNull() {
            return isNotNull(inStock);
        }

        public Criteria andInStockEqualTo(Integer value) {
            return equalTo(inStock, value);
        }

        public Criteria andInStockNotEqualTo(Integer value) {
            return notEqualTo(inStock, value);
        }

        public Criteria andInStockGreaterThan(Integer value) {
            return greaterThan(inStock, value);
        }

        public Criteria andInStockGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inStock, value);
        }

        public Criteria andInStockLessThan(Integer value) {
            return lessThan(inStock, value);
        }

        public Criteria andInStockLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inStock, value);
        }

        public Criteria andInStockIn(List<Integer> values) {
            return in(inStock, values);
        }

        public Criteria andInStockNotIn(List<Integer> values) {
            return notIn(inStock, values);
        }

        public Criteria andInStockBetween(Integer value1, Integer value2) {
            return between(inStock, value1, value2);
        }

        public Criteria andInStockNotBetween(Integer value1, Integer value2) {
            return notBetween(inStock, value1, value2);
        }
        public Criteria andApplyTimeIsNull() {
            return isNull(applyTime);
        }

        public Criteria andApplyTimeIsNotNull() {
            return isNotNull(applyTime);
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            return equalTo(applyTime, value);
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            return notEqualTo(applyTime, value);
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            return greaterThan(applyTime, value);
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyTime, value);
        }

        public Criteria andApplyTimeLessThan(Date value) {
            return lessThan(applyTime, value);
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyTime, value);
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            return in(applyTime, values);
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            return notIn(applyTime, values);
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            return between(applyTime, value1, value2);
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyTime, value1, value2);
        }
        public Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public Criteria andStoreDealTimeIsNull() {
            return isNull(storeDealTime);
        }

        public Criteria andStoreDealTimeIsNotNull() {
            return isNotNull(storeDealTime);
        }

        public Criteria andStoreDealTimeEqualTo(Date value) {
            return equalTo(storeDealTime, value);
        }

        public Criteria andStoreDealTimeNotEqualTo(Date value) {
            return notEqualTo(storeDealTime, value);
        }

        public Criteria andStoreDealTimeGreaterThan(Date value) {
            return greaterThan(storeDealTime, value);
        }

        public Criteria andStoreDealTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(storeDealTime, value);
        }

        public Criteria andStoreDealTimeLessThan(Date value) {
            return lessThan(storeDealTime, value);
        }

        public Criteria andStoreDealTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(storeDealTime, value);
        }

        public Criteria andStoreDealTimeIn(List<Date> values) {
            return in(storeDealTime, values);
        }

        public Criteria andStoreDealTimeNotIn(List<Date> values) {
            return notIn(storeDealTime, values);
        }

        public Criteria andStoreDealTimeBetween(Date value1, Date value2) {
            return between(storeDealTime, value1, value2);
        }

        public Criteria andStoreDealTimeNotBetween(Date value1, Date value2) {
            return notBetween(storeDealTime, value1, value2);
        }
        public Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public Criteria andStoreRefuseReasonIsNull() {
            return isNull(storeRefuseReason);
        }

        public Criteria andStoreRefuseReasonIsNotNull() {
            return isNotNull(storeRefuseReason);
        }

        public Criteria andStoreRefuseReasonEqualTo(String value) {
            return equalTo(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonNotEqualTo(String value) {
            return notEqualTo(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonGreaterThan(String value) {
            return greaterThan(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonLessThan(String value) {
            return lessThan(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonLike(String value) {
            return like(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonNotLike(String value) {
            return notLike(storeRefuseReason, value);
        }

        public Criteria andStoreRefuseReasonIn(List<String> values) {
            return in(storeRefuseReason, values);
        }

        public Criteria andStoreRefuseReasonNotIn(List<String> values) {
            return notIn(storeRefuseReason, values);
        }

        public Criteria andStoreRefuseReasonBetween(String value1, String value2) {
            return between(storeRefuseReason, value1, value2);
        }

        public Criteria andStoreRefuseReasonNotBetween(String value1, String value2) {
            return notBetween(storeRefuseReason, value1, value2);
        }
        public Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public Criteria andReturnExpressNameIsNull() {
            return isNull(returnExpressName);
        }

        public Criteria andReturnExpressNameIsNotNull() {
            return isNotNull(returnExpressName);
        }

        public Criteria andReturnExpressNameEqualTo(String value) {
            return equalTo(returnExpressName, value);
        }

        public Criteria andReturnExpressNameNotEqualTo(String value) {
            return notEqualTo(returnExpressName, value);
        }

        public Criteria andReturnExpressNameGreaterThan(String value) {
            return greaterThan(returnExpressName, value);
        }

        public Criteria andReturnExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnExpressName, value);
        }

        public Criteria andReturnExpressNameLessThan(String value) {
            return lessThan(returnExpressName, value);
        }

        public Criteria andReturnExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnExpressName, value);
        }

        public Criteria andReturnExpressNameLike(String value) {
            return like(returnExpressName, value);
        }

        public Criteria andReturnExpressNameNotLike(String value) {
            return notLike(returnExpressName, value);
        }

        public Criteria andReturnExpressNameIn(List<String> values) {
            return in(returnExpressName, values);
        }

        public Criteria andReturnExpressNameNotIn(List<String> values) {
            return notIn(returnExpressName, values);
        }

        public Criteria andReturnExpressNameBetween(String value1, String value2) {
            return between(returnExpressName, value1, value2);
        }

        public Criteria andReturnExpressNameNotBetween(String value1, String value2) {
            return notBetween(returnExpressName, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andApplyDealStatusIsNull() {
            return isNull(applyDealStatus);
        }

        public Criteria andApplyDealStatusIsNotNull() {
            return isNotNull(applyDealStatus);
        }

        public Criteria andApplyDealStatusEqualTo(Integer value) {
            return equalTo(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusNotEqualTo(Integer value) {
            return notEqualTo(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusGreaterThan(Integer value) {
            return greaterThan(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusLessThan(Integer value) {
            return lessThan(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(applyDealStatus, value);
        }

        public Criteria andApplyDealStatusIn(List<Integer> values) {
            return in(applyDealStatus, values);
        }

        public Criteria andApplyDealStatusNotIn(List<Integer> values) {
            return notIn(applyDealStatus, values);
        }

        public Criteria andApplyDealStatusBetween(Integer value1, Integer value2) {
            return between(applyDealStatus, value1, value2);
        }

        public Criteria andApplyDealStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(applyDealStatus, value1, value2);
        }
        public Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public Criteria andStockLocationIsNull() {
            return isNull(stockLocation);
        }

        public Criteria andStockLocationIsNotNull() {
            return isNotNull(stockLocation);
        }

        public Criteria andStockLocationEqualTo(String value) {
            return equalTo(stockLocation, value);
        }

        public Criteria andStockLocationNotEqualTo(String value) {
            return notEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationGreaterThan(String value) {
            return greaterThan(stockLocation, value);
        }

        public Criteria andStockLocationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationLessThan(String value) {
            return lessThan(stockLocation, value);
        }

        public Criteria andStockLocationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationLike(String value) {
            return like(stockLocation, value);
        }

        public Criteria andStockLocationNotLike(String value) {
            return notLike(stockLocation, value);
        }

        public Criteria andStockLocationIn(List<String> values) {
            return in(stockLocation, values);
        }

        public Criteria andStockLocationNotIn(List<String> values) {
            return notIn(stockLocation, values);
        }

        public Criteria andStockLocationBetween(String value1, String value2) {
            return between(stockLocation, value1, value2);
        }

        public Criteria andStockLocationNotBetween(String value1, String value2) {
            return notBetween(stockLocation, value1, value2);
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
        public Criteria andSendReturnTimeIsNull() {
            return isNull(sendReturnTime);
        }

        public Criteria andSendReturnTimeIsNotNull() {
            return isNotNull(sendReturnTime);
        }

        public Criteria andSendReturnTimeEqualTo(Date value) {
            return equalTo(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeNotEqualTo(Date value) {
            return notEqualTo(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeGreaterThan(Date value) {
            return greaterThan(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeLessThan(Date value) {
            return lessThan(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendReturnTime, value);
        }

        public Criteria andSendReturnTimeIn(List<Date> values) {
            return in(sendReturnTime, values);
        }

        public Criteria andSendReturnTimeNotIn(List<Date> values) {
            return notIn(sendReturnTime, values);
        }

        public Criteria andSendReturnTimeBetween(Date value1, Date value2) {
            return between(sendReturnTime, value1, value2);
        }

        public Criteria andSendReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendReturnTime, value1, value2);
        }
        public Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public Criteria andTitleIsNull() {
            return isNull(title);
        }

        public Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public Criteria andChangeExpressNameIsNull() {
            return isNull(changeExpressName);
        }

        public Criteria andChangeExpressNameIsNotNull() {
            return isNotNull(changeExpressName);
        }

        public Criteria andChangeExpressNameEqualTo(String value) {
            return equalTo(changeExpressName, value);
        }

        public Criteria andChangeExpressNameNotEqualTo(String value) {
            return notEqualTo(changeExpressName, value);
        }

        public Criteria andChangeExpressNameGreaterThan(String value) {
            return greaterThan(changeExpressName, value);
        }

        public Criteria andChangeExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeExpressName, value);
        }

        public Criteria andChangeExpressNameLessThan(String value) {
            return lessThan(changeExpressName, value);
        }

        public Criteria andChangeExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeExpressName, value);
        }

        public Criteria andChangeExpressNameLike(String value) {
            return like(changeExpressName, value);
        }

        public Criteria andChangeExpressNameNotLike(String value) {
            return notLike(changeExpressName, value);
        }

        public Criteria andChangeExpressNameIn(List<String> values) {
            return in(changeExpressName, values);
        }

        public Criteria andChangeExpressNameNotIn(List<String> values) {
            return notIn(changeExpressName, values);
        }

        public Criteria andChangeExpressNameBetween(String value1, String value2) {
            return between(changeExpressName, value1, value2);
        }

        public Criteria andChangeExpressNameNotBetween(String value1, String value2) {
            return notBetween(changeExpressName, value1, value2);
        }
        public Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public Criteria andChangeExpressCodeIsNull() {
            return isNull(changeExpressCode);
        }

        public Criteria andChangeExpressCodeIsNotNull() {
            return isNotNull(changeExpressCode);
        }

        public Criteria andChangeExpressCodeEqualTo(String value) {
            return equalTo(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeNotEqualTo(String value) {
            return notEqualTo(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeGreaterThan(String value) {
            return greaterThan(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeLessThan(String value) {
            return lessThan(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeLike(String value) {
            return like(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeNotLike(String value) {
            return notLike(changeExpressCode, value);
        }

        public Criteria andChangeExpressCodeIn(List<String> values) {
            return in(changeExpressCode, values);
        }

        public Criteria andChangeExpressCodeNotIn(List<String> values) {
            return notIn(changeExpressCode, values);
        }

        public Criteria andChangeExpressCodeBetween(String value1, String value2) {
            return between(changeExpressCode, value1, value2);
        }

        public Criteria andChangeExpressCodeNotBetween(String value1, String value2) {
            return notBetween(changeExpressCode, value1, value2);
        }
        public Criteria andReturnExpressCodeIsNull() {
            return isNull(returnExpressCode);
        }

        public Criteria andReturnExpressCodeIsNotNull() {
            return isNotNull(returnExpressCode);
        }

        public Criteria andReturnExpressCodeEqualTo(String value) {
            return equalTo(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeNotEqualTo(String value) {
            return notEqualTo(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeGreaterThan(String value) {
            return greaterThan(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeLessThan(String value) {
            return lessThan(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeLike(String value) {
            return like(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeNotLike(String value) {
            return notLike(returnExpressCode, value);
        }

        public Criteria andReturnExpressCodeIn(List<String> values) {
            return in(returnExpressCode, values);
        }

        public Criteria andReturnExpressCodeNotIn(List<String> values) {
            return notIn(returnExpressCode, values);
        }

        public Criteria andReturnExpressCodeBetween(String value1, String value2) {
            return between(returnExpressCode, value1, value2);
        }

        public Criteria andReturnExpressCodeNotBetween(String value1, String value2) {
            return notBetween(returnExpressCode, value1, value2);
        }
        public Criteria andSendReturnDateIsNull() {
            return isNull(sendReturnDate);
        }

        public Criteria andSendReturnDateIsNotNull() {
            return isNotNull(sendReturnDate);
        }

        public Criteria andSendReturnDateEqualTo(String value) {
            return equalTo(sendReturnDate, value);
        }

        public Criteria andSendReturnDateNotEqualTo(String value) {
            return notEqualTo(sendReturnDate, value);
        }

        public Criteria andSendReturnDateGreaterThan(String value) {
            return greaterThan(sendReturnDate, value);
        }

        public Criteria andSendReturnDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendReturnDate, value);
        }

        public Criteria andSendReturnDateLessThan(String value) {
            return lessThan(sendReturnDate, value);
        }

        public Criteria andSendReturnDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendReturnDate, value);
        }

        public Criteria andSendReturnDateLike(String value) {
            return like(sendReturnDate, value);
        }

        public Criteria andSendReturnDateNotLike(String value) {
            return notLike(sendReturnDate, value);
        }

        public Criteria andSendReturnDateIn(List<String> values) {
            return in(sendReturnDate, values);
        }

        public Criteria andSendReturnDateNotIn(List<String> values) {
            return notIn(sendReturnDate, values);
        }

        public Criteria andSendReturnDateBetween(String value1, String value2) {
            return between(sendReturnDate, value1, value2);
        }

        public Criteria andSendReturnDateNotBetween(String value1, String value2) {
            return notBetween(sendReturnDate, value1, value2);
        }
        public Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public Criteria andStoreDealStatusIsNull() {
            return isNull(storeDealStatus);
        }

        public Criteria andStoreDealStatusIsNotNull() {
            return isNotNull(storeDealStatus);
        }

        public Criteria andStoreDealStatusEqualTo(Integer value) {
            return equalTo(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusNotEqualTo(Integer value) {
            return notEqualTo(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusGreaterThan(Integer value) {
            return greaterThan(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusLessThan(Integer value) {
            return lessThan(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(storeDealStatus, value);
        }

        public Criteria andStoreDealStatusIn(List<Integer> values) {
            return in(storeDealStatus, values);
        }

        public Criteria andStoreDealStatusNotIn(List<Integer> values) {
            return notIn(storeDealStatus, values);
        }

        public Criteria andStoreDealStatusBetween(Integer value1, Integer value2) {
            return between(storeDealStatus, value1, value2);
        }

        public Criteria andStoreDealStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(storeDealStatus, value1, value2);
        }
        public Criteria andApplyDealTimeIsNull() {
            return isNull(applyDealTime);
        }

        public Criteria andApplyDealTimeIsNotNull() {
            return isNotNull(applyDealTime);
        }

        public Criteria andApplyDealTimeEqualTo(Date value) {
            return equalTo(applyDealTime, value);
        }

        public Criteria andApplyDealTimeNotEqualTo(Date value) {
            return notEqualTo(applyDealTime, value);
        }

        public Criteria andApplyDealTimeGreaterThan(Date value) {
            return greaterThan(applyDealTime, value);
        }

        public Criteria andApplyDealTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyDealTime, value);
        }

        public Criteria andApplyDealTimeLessThan(Date value) {
            return lessThan(applyDealTime, value);
        }

        public Criteria andApplyDealTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyDealTime, value);
        }

        public Criteria andApplyDealTimeIn(List<Date> values) {
            return in(applyDealTime, values);
        }

        public Criteria andApplyDealTimeNotIn(List<Date> values) {
            return notIn(applyDealTime, values);
        }

        public Criteria andApplyDealTimeBetween(Date value1, Date value2) {
            return between(applyDealTime, value1, value2);
        }

        public Criteria andApplyDealTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyDealTime, value1, value2);
        }
        public Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public Criteria andAfterTypeIsNull() {
            return isNull(afterType);
        }

        public Criteria andAfterTypeIsNotNull() {
            return isNotNull(afterType);
        }

        public Criteria andAfterTypeEqualTo(Integer value) {
            return equalTo(afterType, value);
        }

        public Criteria andAfterTypeNotEqualTo(Integer value) {
            return notEqualTo(afterType, value);
        }

        public Criteria andAfterTypeGreaterThan(Integer value) {
            return greaterThan(afterType, value);
        }

        public Criteria andAfterTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(afterType, value);
        }

        public Criteria andAfterTypeLessThan(Integer value) {
            return lessThan(afterType, value);
        }

        public Criteria andAfterTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(afterType, value);
        }

        public Criteria andAfterTypeIn(List<Integer> values) {
            return in(afterType, values);
        }

        public Criteria andAfterTypeNotIn(List<Integer> values) {
            return notIn(afterType, values);
        }

        public Criteria andAfterTypeBetween(Integer value1, Integer value2) {
            return between(afterType, value1, value2);
        }

        public Criteria andAfterTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(afterType, value1, value2);
        }
        public Criteria andApplyExpressCodeIsNull() {
            return isNull(applyExpressCode);
        }

        public Criteria andApplyExpressCodeIsNotNull() {
            return isNotNull(applyExpressCode);
        }

        public Criteria andApplyExpressCodeEqualTo(String value) {
            return equalTo(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeNotEqualTo(String value) {
            return notEqualTo(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeGreaterThan(String value) {
            return greaterThan(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeLessThan(String value) {
            return lessThan(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeLike(String value) {
            return like(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeNotLike(String value) {
            return notLike(applyExpressCode, value);
        }

        public Criteria andApplyExpressCodeIn(List<String> values) {
            return in(applyExpressCode, values);
        }

        public Criteria andApplyExpressCodeNotIn(List<String> values) {
            return notIn(applyExpressCode, values);
        }

        public Criteria andApplyExpressCodeBetween(String value1, String value2) {
            return between(applyExpressCode, value1, value2);
        }

        public Criteria andApplyExpressCodeNotBetween(String value1, String value2) {
            return notBetween(applyExpressCode, value1, value2);
        }
        public Criteria andReceivedTimeIsNull() {
            return isNull(receivedTime);
        }

        public Criteria andReceivedTimeIsNotNull() {
            return isNotNull(receivedTime);
        }

        public Criteria andReceivedTimeEqualTo(Date value) {
            return equalTo(receivedTime, value);
        }

        public Criteria andReceivedTimeNotEqualTo(Date value) {
            return notEqualTo(receivedTime, value);
        }

        public Criteria andReceivedTimeGreaterThan(Date value) {
            return greaterThan(receivedTime, value);
        }

        public Criteria andReceivedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(receivedTime, value);
        }

        public Criteria andReceivedTimeLessThan(Date value) {
            return lessThan(receivedTime, value);
        }

        public Criteria andReceivedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(receivedTime, value);
        }

        public Criteria andReceivedTimeIn(List<Date> values) {
            return in(receivedTime, values);
        }

        public Criteria andReceivedTimeNotIn(List<Date> values) {
            return notIn(receivedTime, values);
        }

        public Criteria andReceivedTimeBetween(Date value1, Date value2) {
            return between(receivedTime, value1, value2);
        }

        public Criteria andReceivedTimeNotBetween(Date value1, Date value2) {
            return notBetween(receivedTime, value1, value2);
        }
        public Criteria andApplyRefuseReasonIsNull() {
            return isNull(applyRefuseReason);
        }

        public Criteria andApplyRefuseReasonIsNotNull() {
            return isNotNull(applyRefuseReason);
        }

        public Criteria andApplyRefuseReasonEqualTo(String value) {
            return equalTo(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonNotEqualTo(String value) {
            return notEqualTo(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonGreaterThan(String value) {
            return greaterThan(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonLessThan(String value) {
            return lessThan(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonLike(String value) {
            return like(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonNotLike(String value) {
            return notLike(applyRefuseReason, value);
        }

        public Criteria andApplyRefuseReasonIn(List<String> values) {
            return in(applyRefuseReason, values);
        }

        public Criteria andApplyRefuseReasonNotIn(List<String> values) {
            return notIn(applyRefuseReason, values);
        }

        public Criteria andApplyRefuseReasonBetween(String value1, String value2) {
            return between(applyRefuseReason, value1, value2);
        }

        public Criteria andApplyRefuseReasonNotBetween(String value1, String value2) {
            return notBetween(applyRefuseReason, value1, value2);
        }
        public Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
    }
}