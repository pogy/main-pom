package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaSendOrder;

import java.util.*;
public class DaifaSendOrderExample extends SgExample<DaifaSendOrderExample.Criteria> {
    public static final Class<DaifaSendOrder> beanClass = DaifaSendOrder.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sendoId;
    public static EntityColumn sendId;
    public static EntityColumn ggoodsCode;
    public static EntityColumn dfTradeId;
    public static EntityColumn dfOrderId;
    public static EntityColumn sellerId;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaWorker;
    public static EntityColumn sendStatus;
    public static EntityColumn refundStatus;
    public static EntityColumn takeGoodsStatus;
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
    public static EntityColumn cdkey;
    public static EntityColumn orderCode;
    public static EntityColumn giftCode;
    public static EntityColumn refundId;
    public static EntityColumn remark;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn hasNum;
    public static EntityColumn cid;
    public static EntityColumn goodsNummiid;
    public static EntityColumn aggrement;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sendoId = listMap.get("sendoId");
        sendId = listMap.get("sendId");
        ggoodsCode = listMap.get("ggoodsCode");
        dfTradeId = listMap.get("dfTradeId");
        dfOrderId = listMap.get("dfOrderId");
        sellerId = listMap.get("sellerId");
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaWorker = listMap.get("daifaWorker");
        sendStatus = listMap.get("sendStatus");
        refundStatus = listMap.get("refundStatus");
        takeGoodsStatus = listMap.get("takeGoodsStatus");
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
        cdkey = listMap.get("cdkey");
        orderCode = listMap.get("orderCode");
        giftCode = listMap.get("giftCode");
        refundId = listMap.get("refundId");
        remark = listMap.get("remark");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        hasNum = listMap.get("hasNum");
        cid = listMap.get("cid");
        goodsNummiid = listMap.get("goodsNummiid");
        aggrement = listMap.get("aggrement");
    }

    public DaifaSendOrderExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaSendOrderExample.Criteria createCriteriaInternal() {
        return new DaifaSendOrderExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaSendOrderExample.Criteria andSendoIdIsNull() {
            return isNull(sendoId);
        }

        public DaifaSendOrderExample.Criteria andSendoIdIsNotNull() {
            return isNotNull(sendoId);
        }

        public DaifaSendOrderExample.Criteria andSendoIdEqualTo(Long value) {
            return equalTo(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdNotEqualTo(Long value) {
            return notEqualTo(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdGreaterThan(Long value) {
            return greaterThan(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdLessThan(Long value) {
            return lessThan(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdLike(String value) {
            return like(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdNotLike(String value) {
            return notLike(sendoId, value);
        }

        public DaifaSendOrderExample.Criteria andSendoIdIn(List<Long> values) {
            return in(sendoId, values);
        }

        public DaifaSendOrderExample.Criteria andSendoIdNotIn(List<Long> values) {
            return notIn(sendoId, values);
        }

        public DaifaSendOrderExample.Criteria andSendoIdBetween(Long value1, Long value2) {
            return between(sendoId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSendoIdNotBetween(Long value1, Long value2) {
            return notBetween(sendoId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andSendIdIsNull() {
            return isNull(sendId);
        }

        public DaifaSendOrderExample.Criteria andSendIdIsNotNull() {
            return isNotNull(sendId);
        }

        public DaifaSendOrderExample.Criteria andSendIdEqualTo(Long value) {
            return equalTo(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdNotEqualTo(Long value) {
            return notEqualTo(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdGreaterThan(Long value) {
            return greaterThan(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdLessThan(Long value) {
            return lessThan(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdLike(String value) {
            return like(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdNotLike(String value) {
            return notLike(sendId, value);
        }

        public DaifaSendOrderExample.Criteria andSendIdIn(List<Long> values) {
            return in(sendId, values);
        }

        public DaifaSendOrderExample.Criteria andSendIdNotIn(List<Long> values) {
            return notIn(sendId, values);
        }

        public DaifaSendOrderExample.Criteria andSendIdBetween(Long value1, Long value2) {
            return between(sendId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSendIdNotBetween(Long value1, Long value2) {
            return notBetween(sendId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaSendOrderExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaSendOrderExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaSendOrderExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaSendOrderExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaSendOrderExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaSendOrderExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaSendOrderExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaSendOrderExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaSendOrderExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaSendOrderExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andRefundStatusIsNull() {
            return isNull(refundStatus);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusIsNotNull() {
            return isNotNull(refundStatus);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusEqualTo(Integer value) {
            return equalTo(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusNotEqualTo(Integer value) {
            return notEqualTo(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusGreaterThan(Integer value) {
            return greaterThan(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusLessThan(Integer value) {
            return lessThan(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundStatus, value);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusIn(List<Integer> values) {
            return in(refundStatus, values);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusNotIn(List<Integer> values) {
            return notIn(refundStatus, values);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            return between(refundStatus, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(refundStatus, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaSendOrderExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaSendOrderExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaSendOrderExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaSendOrderExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaSendOrderExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaSendOrderExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaSendOrderExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaSendOrderExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaSendOrderExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaSendOrderExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaSendOrderExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaSendOrderExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaSendOrderExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaSendOrderExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaSendOrderExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaSendOrderExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaSendOrderExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaSendOrderExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaSendOrderExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaSendOrderExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaSendOrderExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaSendOrderExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaSendOrderExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaSendOrderExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaSendOrderExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaSendOrderExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaSendOrderExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaSendOrderExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaSendOrderExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaSendOrderExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaSendOrderExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaSendOrderExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaSendOrderExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaSendOrderExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaSendOrderExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaSendOrderExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaSendOrderExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaSendOrderExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaSendOrderExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaSendOrderExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaSendOrderExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaSendOrderExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaSendOrderExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaSendOrderExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaSendOrderExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaSendOrderExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaSendOrderExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaSendOrderExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaSendOrderExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaSendOrderExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaSendOrderExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaSendOrderExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaSendOrderExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaSendOrderExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaSendOrderExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaSendOrderExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaSendOrderExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaSendOrderExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaSendOrderExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaSendOrderExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaSendOrderExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaSendOrderExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaSendOrderExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaSendOrderExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaSendOrderExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaSendOrderExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaSendOrderExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaSendOrderExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaSendOrderExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaSendOrderExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaSendOrderExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaSendOrderExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaSendOrderExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaSendOrderExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaSendOrderExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaSendOrderExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaSendOrderExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaSendOrderExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaSendOrderExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaSendOrderExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andHasNumIsNull() {
            return isNull(hasNum);
        }

        public DaifaSendOrderExample.Criteria andHasNumIsNotNull() {
            return isNotNull(hasNum);
        }

        public DaifaSendOrderExample.Criteria andHasNumEqualTo(Integer value) {
            return equalTo(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumNotEqualTo(Integer value) {
            return notEqualTo(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumGreaterThan(Integer value) {
            return greaterThan(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumLessThan(Integer value) {
            return lessThan(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasNum, value);
        }

        public DaifaSendOrderExample.Criteria andHasNumIn(List<Integer> values) {
            return in(hasNum, values);
        }

        public DaifaSendOrderExample.Criteria andHasNumNotIn(List<Integer> values) {
            return notIn(hasNum, values);
        }

        public DaifaSendOrderExample.Criteria andHasNumBetween(Integer value1, Integer value2) {
            return between(hasNum, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andHasNumNotBetween(Integer value1, Integer value2) {
            return notBetween(hasNum, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public DaifaSendOrderExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public DaifaSendOrderExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidLike(String value) {
            return like(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public DaifaSendOrderExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public DaifaSendOrderExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public DaifaSendOrderExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andGoodsNummiidIsNull() {
            return isNull(goodsNummiid);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidIsNotNull() {
            return isNotNull(goodsNummiid);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidEqualTo(Long value) {
            return equalTo(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidNotEqualTo(Long value) {
            return notEqualTo(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidGreaterThan(Long value) {
            return greaterThan(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidLessThan(Long value) {
            return lessThan(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidLike(String value) {
            return like(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidNotLike(String value) {
            return notLike(goodsNummiid, value);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidIn(List<Long> values) {
            return in(goodsNummiid, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidNotIn(List<Long> values) {
            return notIn(goodsNummiid, values);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidBetween(Long value1, Long value2) {
            return between(goodsNummiid, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andGoodsNummiidNotBetween(Long value1, Long value2) {
            return notBetween(goodsNummiid, value1, value2);
        }
        public DaifaSendOrderExample.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaSendOrderExample.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaSendOrderExample.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaSendOrderExample.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaSendOrderExample.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaSendOrderExample.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaSendOrderExample.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
    }
}