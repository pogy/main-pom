package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoodsBackup1;

import java.util.*;

public class DaifaGgoodsBackup1Example extends SgExample<DaifaGgoodsBackup1Example.Criteria> {
    public static final Class<DaifaGgoodsBackup1> beanClass = DaifaGgoodsBackup1.class;
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

    public DaifaGgoodsBackup1Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsBackup1Example.Criteria createCriteriaInternal() {
        return new DaifaGgoodsBackup1Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdIsNull() {
            return isNull(takeGoodsId);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdIsNotNull() {
            return isNotNull(takeGoodsId);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdEqualTo(Long value) {
            return equalTo(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdNotEqualTo(Long value) {
            return notEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdGreaterThan(Long value) {
            return greaterThan(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdLessThan(Long value) {
            return lessThan(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdLike(String value) {
            return like(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdNotLike(String value) {
            return notLike(takeGoodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdIn(List<Long> values) {
            return in(takeGoodsId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdNotIn(List<Long> values) {
            return notIn(takeGoodsId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdBetween(Long value1, Long value2) {
            return between(takeGoodsId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(takeGoodsId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateEqualTo(String value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateNotEqualTo(String value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateGreaterThan(String value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateLessThan(String value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateLike(String value) {
            return like(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateNotLike(String value) {
            return notLike(takeGoodsDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateIn(List<String> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateNotIn(List<String> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateBetween(String value1, String value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsDateNotBetween(String value1, String value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeIsNull() {
            return isNull(takeGoodsTime);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeIsNotNull() {
            return isNotNull(takeGoodsTime);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeEqualTo(Date value) {
            return equalTo(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeNotEqualTo(Date value) {
            return notEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeGreaterThan(Date value) {
            return greaterThan(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeLessThan(Date value) {
            return lessThan(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(takeGoodsTime, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeIn(List<Date> values) {
            return in(takeGoodsTime, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeNotIn(List<Date> values) {
            return notIn(takeGoodsTime, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeBetween(Date value1, Date value2) {
            return between(takeGoodsTime, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsTimeNotBetween(Date value1, Date value2) {
            return notBetween(takeGoodsTime, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceIsNull() {
            return isNull(realTakePrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceIsNotNull() {
            return isNotNull(realTakePrice);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceEqualTo(String value) {
            return equalTo(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceNotEqualTo(String value) {
            return notEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceGreaterThan(String value) {
            return greaterThan(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceLessThan(String value) {
            return lessThan(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceLike(String value) {
            return like(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceNotLike(String value) {
            return notLike(realTakePrice, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceIn(List<String> values) {
            return in(realTakePrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceNotIn(List<String> values) {
            return notIn(realTakePrice, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceBetween(String value1, String value2) {
            return between(realTakePrice, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRealTakePriceNotBetween(String value1, String value2) {
            return notBetween(realTakePrice, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andPrintBatchIsNull() {
            return isNull(printBatch);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchIsNotNull() {
            return isNotNull(printBatch);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchEqualTo(String value) {
            return equalTo(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchNotEqualTo(String value) {
            return notEqualTo(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchGreaterThan(String value) {
            return greaterThan(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchLessThan(String value) {
            return lessThan(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchLike(String value) {
            return like(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchNotLike(String value) {
            return notLike(printBatch, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchIn(List<String> values) {
            return in(printBatch, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchNotIn(List<String> values) {
            return notIn(printBatch, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchBetween(String value1, String value2) {
            return between(printBatch, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBatchNotBetween(String value1, String value2) {
            return notBetween(printBatch, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andOperateIsIsNull() {
            return isNull(operateIs);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsIsNotNull() {
            return isNotNull(operateIs);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsEqualTo(Integer value) {
            return equalTo(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsNotEqualTo(Integer value) {
            return notEqualTo(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsGreaterThan(Integer value) {
            return greaterThan(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsLessThan(Integer value) {
            return lessThan(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsIn(List<Integer> values) {
            return in(operateIs, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsNotIn(List<Integer> values) {
            return notIn(operateIs, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsBetween(Integer value1, Integer value2) {
            return between(operateIs, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andOperateIsNotBetween(Integer value1, Integer value2) {
            return notBetween(operateIs, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonIsNull() {
            return isNull(stockoutReason);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonIsNotNull() {
            return isNotNull(stockoutReason);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonEqualTo(String value) {
            return equalTo(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonNotEqualTo(String value) {
            return notEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonGreaterThan(String value) {
            return greaterThan(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonLessThan(String value) {
            return lessThan(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonLike(String value) {
            return like(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonNotLike(String value) {
            return notLike(stockoutReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonIn(List<String> values) {
            return in(stockoutReason, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonNotIn(List<String> values) {
            return notIn(stockoutReason, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonBetween(String value1, String value2) {
            return between(stockoutReason, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andStockoutReasonNotBetween(String value1, String value2) {
            return notBetween(stockoutReason, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRefundReasonIsNull() {
            return isNull(refundReason);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonIsNotNull() {
            return isNotNull(refundReason);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonEqualTo(String value) {
            return equalTo(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonNotEqualTo(String value) {
            return notEqualTo(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonGreaterThan(String value) {
            return greaterThan(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonLessThan(String value) {
            return lessThan(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonLike(String value) {
            return like(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonNotLike(String value) {
            return notLike(refundReason, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonIn(List<String> values) {
            return in(refundReason, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonNotIn(List<String> values) {
            return notIn(refundReason, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonBetween(String value1, String value2) {
            return between(refundReason, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundReasonNotBetween(String value1, String value2) {
            return notBetween(refundReason, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateIsNull() {
            return isNull(youhuoDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateIsNotNull() {
            return isNotNull(youhuoDate);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateEqualTo(String value) {
            return equalTo(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateNotEqualTo(String value) {
            return notEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateGreaterThan(String value) {
            return greaterThan(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateLessThan(String value) {
            return lessThan(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateLike(String value) {
            return like(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateNotLike(String value) {
            return notLike(youhuoDate, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateIn(List<String> values) {
            return in(youhuoDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateNotIn(List<String> values) {
            return notIn(youhuoDate, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateBetween(String value1, String value2) {
            return between(youhuoDate, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andYouhuoDateNotBetween(String value1, String value2) {
            return notBetween(youhuoDate, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaGgoodsBackup1Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaGgoodsBackup1Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}