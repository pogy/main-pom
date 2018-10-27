package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoodsTasksBackup1;

import java.util.*;

public class DaifaGgoodsTasksBackup1Example extends SgExample<DaifaGgoodsTasksBackup1Example.Criteria> {
    public static final Class<DaifaGgoodsTasksBackup1> beanClass = DaifaGgoodsTasksBackup1.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn tasksId;
    public static EntityColumn ggoodsCode;
    public static EntityColumn dfTradeId;
    public static EntityColumn dfOrderId;
    public static EntityColumn sellerId;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaWorker;
    public static EntityColumn createDate;
    public static EntityColumn createTime;
    public static EntityColumn allocatDate;
    public static EntityColumn allocatTime;
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
    public static EntityColumn allocatStatus;
    public static EntityColumn printBarcodeStatus;
    public static EntityColumn printGoodsStatus;
    public static EntityColumn printBatch;
    public static EntityColumn takeGoodsStatus;
    public static EntityColumn takeGoodsDate;
    public static EntityColumn returnStatus;
    public static EntityColumn cdkey;
    public static EntityColumn remark;
    public static EntityColumn delistIs;
    public static EntityColumn operateIs;
    public static EntityColumn useStatus;
    public static EntityColumn youhuoDate;
    public static EntityColumn giftCode;
    public static EntityColumn aggrement;
    public static EntityColumn refundId;
    public static EntityColumn endStatus;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        tasksId = listMap.get("tasksId");
        ggoodsCode = listMap.get("ggoodsCode");
        dfTradeId = listMap.get("dfTradeId");
        dfOrderId = listMap.get("dfOrderId");
        sellerId = listMap.get("sellerId");
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaWorker = listMap.get("daifaWorker");
        createDate = listMap.get("createDate");
        createTime = listMap.get("createTime");
        allocatDate = listMap.get("allocatDate");
        allocatTime = listMap.get("allocatTime");
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
        allocatStatus = listMap.get("allocatStatus");
        printBarcodeStatus = listMap.get("printBarcodeStatus");
        printGoodsStatus = listMap.get("printGoodsStatus");
        printBatch = listMap.get("printBatch");
        takeGoodsStatus = listMap.get("takeGoodsStatus");
        takeGoodsDate = listMap.get("takeGoodsDate");
        returnStatus = listMap.get("returnStatus");
        cdkey = listMap.get("cdkey");
        remark = listMap.get("remark");
        delistIs = listMap.get("delistIs");
        operateIs = listMap.get("operateIs");
        useStatus = listMap.get("useStatus");
        youhuoDate = listMap.get("youhuoDate");
        giftCode = listMap.get("giftCode");
        aggrement = listMap.get("aggrement");
        refundId = listMap.get("refundId");
        endStatus = listMap.get("endStatus");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
    }

    public DaifaGgoodsTasksBackup1Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsTasksBackup1Example.Criteria createCriteriaInternal() {
        return new DaifaGgoodsTasksBackup1Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdIsNull() {
            return isNull(tasksId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdIsNotNull() {
            return isNotNull(tasksId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdEqualTo(Long value) {
            return equalTo(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdNotEqualTo(Long value) {
            return notEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdGreaterThan(Long value) {
            return greaterThan(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdLessThan(Long value) {
            return lessThan(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdLike(String value) {
            return like(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdNotLike(String value) {
            return notLike(tasksId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdIn(List<Long> values) {
            return in(tasksId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdNotIn(List<Long> values) {
            return notIn(tasksId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdBetween(Long value1, Long value2) {
            return between(tasksId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTasksIdNotBetween(Long value1, Long value2) {
            return notBetween(tasksId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateIsNull() {
            return isNull(allocatDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateIsNotNull() {
            return isNotNull(allocatDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateEqualTo(String value) {
            return equalTo(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateNotEqualTo(String value) {
            return notEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateGreaterThan(String value) {
            return greaterThan(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateLessThan(String value) {
            return lessThan(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateLike(String value) {
            return like(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateNotLike(String value) {
            return notLike(allocatDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateIn(List<String> values) {
            return in(allocatDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateNotIn(List<String> values) {
            return notIn(allocatDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateBetween(String value1, String value2) {
            return between(allocatDate, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatDateNotBetween(String value1, String value2) {
            return notBetween(allocatDate, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeIsNull() {
            return isNull(allocatTime);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeIsNotNull() {
            return isNotNull(allocatTime);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeEqualTo(Date value) {
            return equalTo(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeNotEqualTo(Date value) {
            return notEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeGreaterThan(Date value) {
            return greaterThan(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeLessThan(Date value) {
            return lessThan(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeIn(List<Date> values) {
            return in(allocatTime, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeNotIn(List<Date> values) {
            return notIn(allocatTime, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeBetween(Date value1, Date value2) {
            return between(allocatTime, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatTimeNotBetween(Date value1, Date value2) {
            return notBetween(allocatTime, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusIsNull() {
            return isNull(allocatStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusIsNotNull() {
            return isNotNull(allocatStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusEqualTo(Integer value) {
            return equalTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusNotEqualTo(Integer value) {
            return notEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusGreaterThan(Integer value) {
            return greaterThan(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusLessThan(Integer value) {
            return lessThan(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusIn(List<Integer> values) {
            return in(allocatStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusNotIn(List<Integer> values) {
            return notIn(allocatStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusBetween(Integer value1, Integer value2) {
            return between(allocatStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAllocatStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(allocatStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusIsNull() {
            return isNull(printGoodsStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusIsNotNull() {
            return isNotNull(printGoodsStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusEqualTo(Integer value) {
            return equalTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusGreaterThan(Integer value) {
            return greaterThan(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusLessThan(Integer value) {
            return lessThan(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusIn(List<Integer> values) {
            return in(printGoodsStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusNotIn(List<Integer> values) {
            return notIn(printGoodsStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusBetween(Integer value1, Integer value2) {
            return between(printGoodsStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printGoodsStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchIsNull() {
            return isNull(printBatch);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchIsNotNull() {
            return isNotNull(printBatch);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchEqualTo(String value) {
            return equalTo(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchNotEqualTo(String value) {
            return notEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchGreaterThan(String value) {
            return greaterThan(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchLessThan(String value) {
            return lessThan(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchLike(String value) {
            return like(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchNotLike(String value) {
            return notLike(printBatch, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchIn(List<String> values) {
            return in(printBatch, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchNotIn(List<String> values) {
            return notIn(printBatch, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchBetween(String value1, String value2) {
            return between(printBatch, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andPrintBatchNotBetween(String value1, String value2) {
            return notBetween(printBatch, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateEqualTo(String value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateNotEqualTo(String value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateGreaterThan(String value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateLessThan(String value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateLike(String value) {
            return like(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateNotLike(String value) {
            return notLike(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateIn(List<String> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateNotIn(List<String> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateBetween(String value1, String value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andTakeGoodsDateNotBetween(String value1, String value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsIsNull() {
            return isNull(operateIs);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsIsNotNull() {
            return isNotNull(operateIs);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsEqualTo(Integer value) {
            return equalTo(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsNotEqualTo(Integer value) {
            return notEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsGreaterThan(Integer value) {
            return greaterThan(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsLessThan(Integer value) {
            return lessThan(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsIn(List<Integer> values) {
            return in(operateIs, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsNotIn(List<Integer> values) {
            return notIn(operateIs, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsBetween(Integer value1, Integer value2) {
            return between(operateIs, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andOperateIsNotBetween(Integer value1, Integer value2) {
            return notBetween(operateIs, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateIsNull() {
            return isNull(youhuoDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateIsNotNull() {
            return isNotNull(youhuoDate);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateEqualTo(Date value) {
            return equalTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateNotEqualTo(Date value) {
            return notEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateGreaterThan(Date value) {
            return greaterThan(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateLessThan(Date value) {
            return lessThan(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateIn(List<Date> values) {
            return in(youhuoDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateNotIn(List<Date> values) {
            return notIn(youhuoDate, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateBetween(Date value1, Date value2) {
            return between(youhuoDate, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andYouhuoDateNotBetween(Date value1, Date value2) {
            return notBetween(youhuoDate, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusIsNull() {
            return isNull(endStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusIsNotNull() {
            return isNotNull(endStatus);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusEqualTo(Integer value) {
            return equalTo(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusNotEqualTo(Integer value) {
            return notEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusGreaterThan(Integer value) {
            return greaterThan(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusLessThan(Integer value) {
            return lessThan(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusIn(List<Integer> values) {
            return in(endStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusNotIn(List<Integer> values) {
            return notIn(endStatus, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusBetween(Integer value1, Integer value2) {
            return between(endStatus, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andEndStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(endStatus, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaGgoodsTasksBackup1Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaGgoodsTasksBackup1Example.Criteria andCustomSql(String sql){
            this.addCriterion(sql);
            return this;
        }

    }
}