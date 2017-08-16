package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaWaitSendOrder;

import java.util.*;
public class DaifaWaitSendOrderExample extends SgExample<DaifaWaitSendOrderExample.Criteria> {
    public static final Class<DaifaWaitSendOrder> beanClass = DaifaWaitSendOrder.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dwsoId;
    public static EntityColumn dwsId;
    public static EntityColumn ggoodsCode;
    public static EntityColumn dfTradeId;
    public static EntityColumn dfOrderId;
    public static EntityColumn orderCode;
    public static EntityColumn sellerId;
    public static EntityColumn sendStatus;
    public static EntityColumn stockStatus;
    public static EntityColumn takeGoodsStatus;
    public static EntityColumn refundStatus;
    public static EntityColumn refundDate;
    public static EntityColumn refundTime;
    public static EntityColumn createDate;
    public static EntityColumn createTime;
    public static EntityColumn marketId;
    public static EntityColumn marketName;
    public static EntityColumn floorId;
    public static EntityColumn floorName;
    public static EntityColumn storeId;
    public static EntityColumn storeNum;
    public static EntityColumn goodsId;
    public static EntityColumn goodsCode;
    public static EntityColumn storeGoodsCode;
    public static EntityColumn title;
    public static EntityColumn webSite;
    public static EntityColumn propStr;
    public static EntityColumn picPath;
    public static EntityColumn singlePiPrice;
    public static EntityColumn singlePrice;
    public static EntityColumn goodsNum;
    public static EntityColumn inStockFlag;
    public static EntityColumn cdkey;
    public static EntityColumn remark;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaWorker;
    public static EntityColumn lastScanDate;
    public static EntityColumn giftCode;
    public static EntityColumn refundId;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn aggrement;
    public static EntityColumn cid;
    public static EntityColumn goodsNummiid;
    public static EntityColumn hasNum;
    public static EntityColumn stockNum;
    public static EntityColumn stockId;
    public static EntityColumn printAddrStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dwsoId = listMap.get("dwsoId");
        dwsId = listMap.get("dwsId");
        ggoodsCode = listMap.get("ggoodsCode");
        dfTradeId = listMap.get("dfTradeId");
        dfOrderId = listMap.get("dfOrderId");
        orderCode = listMap.get("orderCode");
        sellerId = listMap.get("sellerId");
        sendStatus = listMap.get("sendStatus");
        stockStatus = listMap.get("stockStatus");
        takeGoodsStatus = listMap.get("takeGoodsStatus");
        refundStatus = listMap.get("refundStatus");
        refundDate = listMap.get("refundDate");
        refundTime = listMap.get("refundTime");
        createDate = listMap.get("createDate");
        createTime = listMap.get("createTime");
        marketId = listMap.get("marketId");
        marketName = listMap.get("marketName");
        floorId = listMap.get("floorId");
        floorName = listMap.get("floorName");
        storeId = listMap.get("storeId");
        storeNum = listMap.get("storeNum");
        goodsId = listMap.get("goodsId");
        goodsCode = listMap.get("goodsCode");
        storeGoodsCode = listMap.get("storeGoodsCode");
        title = listMap.get("title");
        webSite = listMap.get("webSite");
        propStr = listMap.get("propStr");
        picPath = listMap.get("picPath");
        singlePiPrice = listMap.get("singlePiPrice");
        singlePrice = listMap.get("singlePrice");
        goodsNum = listMap.get("goodsNum");
        inStockFlag = listMap.get("inStockFlag");
        cdkey = listMap.get("cdkey");
        remark = listMap.get("remark");
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaWorker = listMap.get("daifaWorker");
        lastScanDate = listMap.get("lastScanDate");
        giftCode = listMap.get("giftCode");
        refundId = listMap.get("refundId");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        aggrement = listMap.get("aggrement");
        cid = listMap.get("cid");
        goodsNummiid = listMap.get("goodsNummiid");
        hasNum = listMap.get("hasNum");
        stockNum = listMap.get("stockNum");
        stockId = listMap.get("stockId");
        printAddrStatus = listMap.get("printAddrStatus");
    }

    public DaifaWaitSendOrderExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaWaitSendOrderExample.Criteria createCriteriaInternal() {
        return new DaifaWaitSendOrderExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdIsNull() {
            return isNull(dwsoId);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdIsNotNull() {
            return isNotNull(dwsoId);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdEqualTo(Long value) {
            return equalTo(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdNotEqualTo(Long value) {
            return notEqualTo(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdGreaterThan(Long value) {
            return greaterThan(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdLessThan(Long value) {
            return lessThan(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdLike(String value) {
            return like(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdNotLike(String value) {
            return notLike(dwsoId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdIn(List<Long> values) {
            return in(dwsoId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdNotIn(List<Long> values) {
            return notIn(dwsoId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdBetween(Long value1, Long value2) {
            return between(dwsoId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsoIdNotBetween(Long value1, Long value2) {
            return notBetween(dwsoId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andDwsIdIsNull() {
            return isNull(dwsId);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdIsNotNull() {
            return isNotNull(dwsId);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdEqualTo(Long value) {
            return equalTo(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdNotEqualTo(Long value) {
            return notEqualTo(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdGreaterThan(Long value) {
            return greaterThan(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdLessThan(Long value) {
            return lessThan(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdLike(String value) {
            return like(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdNotLike(String value) {
            return notLike(dwsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdIn(List<Long> values) {
            return in(dwsId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdNotIn(List<Long> values) {
            return notIn(dwsId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdBetween(Long value1, Long value2) {
            return between(dwsId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDwsIdNotBetween(Long value1, Long value2) {
            return notBetween(dwsId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRefundStatusIsNull() {
            return isNull(refundStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusIsNotNull() {
            return isNotNull(refundStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusEqualTo(Integer value) {
            return equalTo(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusNotEqualTo(Integer value) {
            return notEqualTo(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusGreaterThan(Integer value) {
            return greaterThan(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusLessThan(Integer value) {
            return lessThan(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusIn(List<Integer> values) {
            return in(refundStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusNotIn(List<Integer> values) {
            return notIn(refundStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            return between(refundStatus, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(refundStatus, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRefundDateIsNull() {
            return isNull(refundDate);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateIsNotNull() {
            return isNotNull(refundDate);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateEqualTo(String value) {
            return equalTo(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateNotEqualTo(String value) {
            return notEqualTo(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateGreaterThan(String value) {
            return greaterThan(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateLessThan(String value) {
            return lessThan(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateLike(String value) {
            return like(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateNotLike(String value) {
            return notLike(refundDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateIn(List<String> values) {
            return in(refundDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateNotIn(List<String> values) {
            return notIn(refundDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateBetween(String value1, String value2) {
            return between(refundDate, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundDateNotBetween(String value1, String value2) {
            return notBetween(refundDate, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRefundTimeIsNull() {
            return isNull(refundTime);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeIsNotNull() {
            return isNotNull(refundTime);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeEqualTo(Date value) {
            return equalTo(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeNotEqualTo(Date value) {
            return notEqualTo(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeGreaterThan(Date value) {
            return greaterThan(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeLessThan(Date value) {
            return lessThan(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeIn(List<Date> values) {
            return in(refundTime, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeNotIn(List<Date> values) {
            return notIn(refundTime, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeBetween(Date value1, Date value2) {
            return between(refundTime, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundTime, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andInStockFlagIsNull() {
            return isNull(inStockFlag);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagIsNotNull() {
            return isNotNull(inStockFlag);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagEqualTo(Integer value) {
            return equalTo(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagNotEqualTo(Integer value) {
            return notEqualTo(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagGreaterThan(Integer value) {
            return greaterThan(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagLessThan(Integer value) {
            return lessThan(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inStockFlag, value);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagIn(List<Integer> values) {
            return in(inStockFlag, values);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagNotIn(List<Integer> values) {
            return notIn(inStockFlag, values);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagBetween(Integer value1, Integer value2) {
            return between(inStockFlag, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andInStockFlagNotBetween(Integer value1, Integer value2) {
            return notBetween(inStockFlag, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andLastScanDateIsNull() {
            return isNull(lastScanDate);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateIsNotNull() {
            return isNotNull(lastScanDate);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateEqualTo(String value) {
            return equalTo(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateNotEqualTo(String value) {
            return notEqualTo(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateGreaterThan(String value) {
            return greaterThan(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateLessThan(String value) {
            return lessThan(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateLike(String value) {
            return like(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateNotLike(String value) {
            return notLike(lastScanDate, value);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateIn(List<String> values) {
            return in(lastScanDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateNotIn(List<String> values) {
            return notIn(lastScanDate, values);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateBetween(String value1, String value2) {
            return between(lastScanDate, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andLastScanDateNotBetween(String value1, String value2) {
            return notBetween(lastScanDate, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public DaifaWaitSendOrderExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public DaifaWaitSendOrderExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidLike(String value) {
            return like(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public DaifaWaitSendOrderExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidIsNull() {
            return isNull(goodsNummiid);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidIsNotNull() {
            return isNotNull(goodsNummiid);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidEqualTo(Long value) {
            return equalTo(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidNotEqualTo(Long value) {
            return notEqualTo(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidGreaterThan(Long value) {
            return greaterThan(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidLessThan(Long value) {
            return lessThan(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidLike(String value) {
            return like(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidNotLike(String value) {
            return notLike(goodsNummiid, value);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidIn(List<Long> values) {
            return in(goodsNummiid, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidNotIn(List<Long> values) {
            return notIn(goodsNummiid, values);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidBetween(Long value1, Long value2) {
            return between(goodsNummiid, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andGoodsNummiidNotBetween(Long value1, Long value2) {
            return notBetween(goodsNummiid, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andHasNumIsNull() {
            return isNull(hasNum);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumIsNotNull() {
            return isNotNull(hasNum);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumEqualTo(Integer value) {
            return equalTo(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumNotEqualTo(Integer value) {
            return notEqualTo(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumGreaterThan(Integer value) {
            return greaterThan(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumLessThan(Integer value) {
            return lessThan(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumIn(List<Integer> values) {
            return in(hasNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumNotIn(List<Integer> values) {
            return notIn(hasNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumBetween(Integer value1, Integer value2) {
            return between(hasNum, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andHasNumNotBetween(Integer value1, Integer value2) {
            return notBetween(hasNum, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStockNumIsNull() {
            return isNull(stockNum);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumIsNotNull() {
            return isNotNull(stockNum);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumEqualTo(Integer value) {
            return equalTo(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumNotEqualTo(Integer value) {
            return notEqualTo(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumGreaterThan(Integer value) {
            return greaterThan(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumLessThan(Integer value) {
            return lessThan(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockNum, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumIn(List<Integer> values) {
            return in(stockNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumNotIn(List<Integer> values) {
            return notIn(stockNum, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumBetween(Integer value1, Integer value2) {
            return between(stockNum, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            return notBetween(stockNum, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andStockIdIsNull() {
            return isNull(stockId);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdIsNotNull() {
            return isNotNull(stockId);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdEqualTo(Long value) {
            return equalTo(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdNotEqualTo(Long value) {
            return notEqualTo(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdGreaterThan(Long value) {
            return greaterThan(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdLessThan(Long value) {
            return lessThan(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdLike(String value) {
            return like(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdNotLike(String value) {
            return notLike(stockId, value);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdIn(List<Long> values) {
            return in(stockId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdNotIn(List<Long> values) {
            return notIn(stockId, values);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdBetween(Long value1, Long value2) {
            return between(stockId, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andStockIdNotBetween(Long value1, Long value2) {
            return notBetween(stockId, value1, value2);
        }
        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusIsNull() {
            return isNull(printAddrStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusIsNotNull() {
            return isNotNull(printAddrStatus);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusEqualTo(Integer value) {
            return equalTo(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusNotEqualTo(Integer value) {
            return notEqualTo(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusGreaterThan(Integer value) {
            return greaterThan(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusLessThan(Integer value) {
            return lessThan(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printAddrStatus, value);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusIn(List<Integer> values) {
            return in(printAddrStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusNotIn(List<Integer> values) {
            return notIn(printAddrStatus, values);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusBetween(Integer value1, Integer value2) {
            return between(printAddrStatus, value1, value2);
        }

        public DaifaWaitSendOrderExample.Criteria andPrintAddrStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printAddrStatus, value1, value2);
        }
    }
}