package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoods;

import java.util.*;
public class DaifaGgoodsExample extends SgExample<DaifaGgoodsExample.Criteria> {
    public static final Class<DaifaGgoods> beanClass = DaifaGgoods.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn takeGoodsId;
    public static EntityColumn ggoodsCode;
    public static EntityColumn sellerId;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaWorker;
    public static EntityColumn createDate;
    public static EntityColumn createTime;
    public static EntityColumn takeGoodsDate;
    public static EntityColumn takeGoodsTime;
    public static EntityColumn dfTradeId;
    public static EntityColumn dfOrderId;
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
    public static EntityColumn realTakePrice;
    public static EntityColumn goodsNum;
    public static EntityColumn takeGoodsStatus;
    public static EntityColumn returnStatus;
    public static EntityColumn useStatus;
    public static EntityColumn printBatch;
    public static EntityColumn printBarcodeStatus;
    public static EntityColumn cdkey;
    public static EntityColumn remark;
    public static EntityColumn delistIs;
    public static EntityColumn operateIs;
    public static EntityColumn stockoutReason;
    public static EntityColumn refundReason;
    public static EntityColumn youhuoDate;
    public static EntityColumn giftCode;
    public static EntityColumn refundId;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        takeGoodsId = listMap.get("takeGoodsId");
        ggoodsCode = listMap.get("ggoodsCode");
        sellerId = listMap.get("sellerId");
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaWorker = listMap.get("daifaWorker");
        createDate = listMap.get("createDate");
        createTime = listMap.get("createTime");
        takeGoodsDate = listMap.get("takeGoodsDate");
        takeGoodsTime = listMap.get("takeGoodsTime");
        dfTradeId = listMap.get("dfTradeId");
        dfOrderId = listMap.get("dfOrderId");
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
        realTakePrice = listMap.get("realTakePrice");
        goodsNum = listMap.get("goodsNum");
        takeGoodsStatus = listMap.get("takeGoodsStatus");
        returnStatus = listMap.get("returnStatus");
        useStatus = listMap.get("useStatus");
        printBatch = listMap.get("printBatch");
        printBarcodeStatus = listMap.get("printBarcodeStatus");
        cdkey = listMap.get("cdkey");
        remark = listMap.get("remark");
        delistIs = listMap.get("delistIs");
        operateIs = listMap.get("operateIs");
        stockoutReason = listMap.get("stockoutReason");
        refundReason = listMap.get("refundReason");
        youhuoDate = listMap.get("youhuoDate");
        giftCode = listMap.get("giftCode");
        refundId = listMap.get("refundId");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
    }

    public DaifaGgoodsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsExample.Criteria createCriteriaInternal() {
        return new DaifaGgoodsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdIsNull() {
            return isNull(takeGoodsId);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdIsNotNull() {
            return isNotNull(takeGoodsId);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdEqualTo(Long value) {
            return equalTo(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdNotEqualTo(Long value) {
            return notEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdGreaterThan(Long value) {
            return greaterThan(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdLessThan(Long value) {
            return lessThan(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdLike(String value) {
            return like(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdNotLike(String value) {
            return notLike(takeGoodsId, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdIn(List<Long> values) {
            return in(takeGoodsId, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdNotIn(List<Long> values) {
            return notIn(takeGoodsId, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdBetween(Long value1, Long value2) {
            return between(takeGoodsId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(takeGoodsId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaGgoodsExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaGgoodsExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaGgoodsExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaGgoodsExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaGgoodsExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaGgoodsExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaGgoodsExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaGgoodsExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaGgoodsExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaGgoodsExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateEqualTo(String value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateNotEqualTo(String value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateGreaterThan(String value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateLessThan(String value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateLike(String value) {
            return like(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateNotLike(String value) {
            return notLike(takeGoodsDate, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateIn(List<String> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateNotIn(List<String> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateBetween(String value1, String value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsDateNotBetween(String value1, String value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andTakeGoodsTimeIsNull() {
            return isNull(takeGoodsTime);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeIsNotNull() {
            return isNotNull(takeGoodsTime);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeEqualTo(Date value) {
            return equalTo(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeNotEqualTo(Date value) {
            return notEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeGreaterThan(Date value) {
            return greaterThan(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeLessThan(Date value) {
            return lessThan(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeIn(List<Date> values) {
            return in(takeGoodsTime, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeNotIn(List<Date> values) {
            return notIn(takeGoodsTime, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeBetween(Date value1, Date value2) {
            return between(takeGoodsTime, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsTimeNotBetween(Date value1, Date value2) {
            return notBetween(takeGoodsTime, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaGgoodsExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaGgoodsExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaGgoodsExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaGgoodsExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaGgoodsExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaGgoodsExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaGgoodsExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaGgoodsExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaGgoodsExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaGgoodsExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaGgoodsExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaGgoodsExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaGgoodsExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaGgoodsExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaGgoodsExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaGgoodsExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaGgoodsExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaGgoodsExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaGgoodsExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaGgoodsExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaGgoodsExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaGgoodsExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaGgoodsExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaGgoodsExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaGgoodsExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaGgoodsExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaGgoodsExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaGgoodsExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaGgoodsExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaGgoodsExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaGgoodsExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaGgoodsExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaGgoodsExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaGgoodsExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaGgoodsExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaGgoodsExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaGgoodsExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaGgoodsExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaGgoodsExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaGgoodsExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaGgoodsExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaGgoodsExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaGgoodsExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaGgoodsExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaGgoodsExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaGgoodsExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaGgoodsExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaGgoodsExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaGgoodsExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaGgoodsExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRealTakePriceIsNull() {
            return isNull(realTakePrice);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceIsNotNull() {
            return isNotNull(realTakePrice);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceEqualTo(String value) {
            return equalTo(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceNotEqualTo(String value) {
            return notEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceGreaterThan(String value) {
            return greaterThan(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceLessThan(String value) {
            return lessThan(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceLike(String value) {
            return like(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceNotLike(String value) {
            return notLike(realTakePrice, value);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceIn(List<String> values) {
            return in(realTakePrice, values);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceNotIn(List<String> values) {
            return notIn(realTakePrice, values);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceBetween(String value1, String value2) {
            return between(realTakePrice, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRealTakePriceNotBetween(String value1, String value2) {
            return notBetween(realTakePrice, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaGgoodsExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaGgoodsExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaGgoodsExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaGgoodsExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andPrintBatchIsNull() {
            return isNull(printBatch);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchIsNotNull() {
            return isNotNull(printBatch);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchEqualTo(String value) {
            return equalTo(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchNotEqualTo(String value) {
            return notEqualTo(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchGreaterThan(String value) {
            return greaterThan(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchLessThan(String value) {
            return lessThan(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchLike(String value) {
            return like(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchNotLike(String value) {
            return notLike(printBatch, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchIn(List<String> values) {
            return in(printBatch, values);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchNotIn(List<String> values) {
            return notIn(printBatch, values);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchBetween(String value1, String value2) {
            return between(printBatch, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andPrintBatchNotBetween(String value1, String value2) {
            return notBetween(printBatch, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaGgoodsExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaGgoodsExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaGgoodsExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaGgoodsExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaGgoodsExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaGgoodsExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaGgoodsExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaGgoodsExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaGgoodsExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaGgoodsExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaGgoodsExample.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaGgoodsExample.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsExample.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaGgoodsExample.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaGgoodsExample.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andOperateIsIsNull() {
            return isNull(operateIs);
        }

        public DaifaGgoodsExample.Criteria andOperateIsIsNotNull() {
            return isNotNull(operateIs);
        }

        public DaifaGgoodsExample.Criteria andOperateIsEqualTo(Integer value) {
            return equalTo(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsNotEqualTo(Integer value) {
            return notEqualTo(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsGreaterThan(Integer value) {
            return greaterThan(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsLessThan(Integer value) {
            return lessThan(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsExample.Criteria andOperateIsIn(List<Integer> values) {
            return in(operateIs, values);
        }

        public DaifaGgoodsExample.Criteria andOperateIsNotIn(List<Integer> values) {
            return notIn(operateIs, values);
        }

        public DaifaGgoodsExample.Criteria andOperateIsBetween(Integer value1, Integer value2) {
            return between(operateIs, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andOperateIsNotBetween(Integer value1, Integer value2) {
            return notBetween(operateIs, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andStockoutReasonIsNull() {
            return isNull(stockoutReason);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonIsNotNull() {
            return isNotNull(stockoutReason);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonEqualTo(String value) {
            return equalTo(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonNotEqualTo(String value) {
            return notEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonGreaterThan(String value) {
            return greaterThan(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonLessThan(String value) {
            return lessThan(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonLike(String value) {
            return like(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonNotLike(String value) {
            return notLike(stockoutReason, value);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonIn(List<String> values) {
            return in(stockoutReason, values);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonNotIn(List<String> values) {
            return notIn(stockoutReason, values);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonBetween(String value1, String value2) {
            return between(stockoutReason, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andStockoutReasonNotBetween(String value1, String value2) {
            return notBetween(stockoutReason, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRefundReasonIsNull() {
            return isNull(refundReason);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonIsNotNull() {
            return isNotNull(refundReason);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonEqualTo(String value) {
            return equalTo(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonNotEqualTo(String value) {
            return notEqualTo(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonGreaterThan(String value) {
            return greaterThan(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonLessThan(String value) {
            return lessThan(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonLike(String value) {
            return like(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonNotLike(String value) {
            return notLike(refundReason, value);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonIn(List<String> values) {
            return in(refundReason, values);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonNotIn(List<String> values) {
            return notIn(refundReason, values);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonBetween(String value1, String value2) {
            return between(refundReason, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRefundReasonNotBetween(String value1, String value2) {
            return notBetween(refundReason, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andYouhuoDateIsNull() {
            return isNull(youhuoDate);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateIsNotNull() {
            return isNotNull(youhuoDate);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateEqualTo(String value) {
            return equalTo(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateNotEqualTo(String value) {
            return notEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateGreaterThan(String value) {
            return greaterThan(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateLessThan(String value) {
            return lessThan(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateLike(String value) {
            return like(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateNotLike(String value) {
            return notLike(youhuoDate, value);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateIn(List<String> values) {
            return in(youhuoDate, values);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateNotIn(List<String> values) {
            return notIn(youhuoDate, values);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateBetween(String value1, String value2) {
            return between(youhuoDate, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andYouhuoDateNotBetween(String value1, String value2) {
            return notBetween(youhuoDate, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaGgoodsExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaGgoodsExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaGgoodsExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaGgoodsExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaGgoodsExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaGgoodsExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaGgoodsExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaGgoodsExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaGgoodsExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaGgoodsExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaGgoodsExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaGgoodsExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaGgoodsExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaGgoodsExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaGgoodsExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaGgoodsExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaGgoodsExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}