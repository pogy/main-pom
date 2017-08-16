package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;

import java.util.*;
public class DaifaGgoodsTasksExample extends SgExample<DaifaGgoodsTasksExample.Criteria> {
    public static final Class<DaifaGgoodsTasks> beanClass = DaifaGgoodsTasks.class;
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

    public DaifaGgoodsTasksExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsTasksExample.Criteria createCriteriaInternal() {
        return new DaifaGgoodsTasksExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdIsNull() {
            return isNull(tasksId);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdIsNotNull() {
            return isNotNull(tasksId);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdEqualTo(Long value) {
            return equalTo(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdNotEqualTo(Long value) {
            return notEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdGreaterThan(Long value) {
            return greaterThan(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdLessThan(Long value) {
            return lessThan(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdLike(String value) {
            return like(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdNotLike(String value) {
            return notLike(tasksId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdIn(List<Long> values) {
            return in(tasksId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdNotIn(List<Long> values) {
            return notIn(tasksId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdBetween(Long value1, Long value2) {
            return between(tasksId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andTasksIdNotBetween(Long value1, Long value2) {
            return notBetween(tasksId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andAllocatDateIsNull() {
            return isNull(allocatDate);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateIsNotNull() {
            return isNotNull(allocatDate);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateEqualTo(String value) {
            return equalTo(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateNotEqualTo(String value) {
            return notEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateGreaterThan(String value) {
            return greaterThan(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateLessThan(String value) {
            return lessThan(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateLike(String value) {
            return like(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateNotLike(String value) {
            return notLike(allocatDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateIn(List<String> values) {
            return in(allocatDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateNotIn(List<String> values) {
            return notIn(allocatDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateBetween(String value1, String value2) {
            return between(allocatDate, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatDateNotBetween(String value1, String value2) {
            return notBetween(allocatDate, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andAllocatTimeIsNull() {
            return isNull(allocatTime);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeIsNotNull() {
            return isNotNull(allocatTime);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeEqualTo(Date value) {
            return equalTo(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeNotEqualTo(Date value) {
            return notEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeGreaterThan(Date value) {
            return greaterThan(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeLessThan(Date value) {
            return lessThan(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(allocatTime, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeIn(List<Date> values) {
            return in(allocatTime, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeNotIn(List<Date> values) {
            return notIn(allocatTime, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeBetween(Date value1, Date value2) {
            return between(allocatTime, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatTimeNotBetween(Date value1, Date value2) {
            return notBetween(allocatTime, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andAllocatStatusIsNull() {
            return isNull(allocatStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusIsNotNull() {
            return isNotNull(allocatStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusEqualTo(Integer value) {
            return equalTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusNotEqualTo(Integer value) {
            return notEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusGreaterThan(Integer value) {
            return greaterThan(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusLessThan(Integer value) {
            return lessThan(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(allocatStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusIn(List<Integer> values) {
            return in(allocatStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusNotIn(List<Integer> values) {
            return notIn(allocatStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusBetween(Integer value1, Integer value2) {
            return between(allocatStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andAllocatStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(allocatStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusIsNull() {
            return isNull(printGoodsStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusIsNotNull() {
            return isNotNull(printGoodsStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusEqualTo(Integer value) {
            return equalTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusGreaterThan(Integer value) {
            return greaterThan(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusLessThan(Integer value) {
            return lessThan(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusIn(List<Integer> values) {
            return in(printGoodsStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusNotIn(List<Integer> values) {
            return notIn(printGoodsStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusBetween(Integer value1, Integer value2) {
            return between(printGoodsStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printGoodsStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andPrintBatchIsNull() {
            return isNull(printBatch);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchIsNotNull() {
            return isNotNull(printBatch);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchEqualTo(String value) {
            return equalTo(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchNotEqualTo(String value) {
            return notEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchGreaterThan(String value) {
            return greaterThan(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchLessThan(String value) {
            return lessThan(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchLike(String value) {
            return like(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchNotLike(String value) {
            return notLike(printBatch, value);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchIn(List<String> values) {
            return in(printBatch, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchNotIn(List<String> values) {
            return notIn(printBatch, values);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchBetween(String value1, String value2) {
            return between(printBatch, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andPrintBatchNotBetween(String value1, String value2) {
            return notBetween(printBatch, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateEqualTo(String value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateNotEqualTo(String value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateGreaterThan(String value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateLessThan(String value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateLike(String value) {
            return like(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateNotLike(String value) {
            return notLike(takeGoodsDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateIn(List<String> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateNotIn(List<String> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateBetween(String value1, String value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andTakeGoodsDateNotBetween(String value1, String value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andOperateIsIsNull() {
            return isNull(operateIs);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsIsNotNull() {
            return isNotNull(operateIs);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsEqualTo(Integer value) {
            return equalTo(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsNotEqualTo(Integer value) {
            return notEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsGreaterThan(Integer value) {
            return greaterThan(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsLessThan(Integer value) {
            return lessThan(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(operateIs, value);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsIn(List<Integer> values) {
            return in(operateIs, values);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsNotIn(List<Integer> values) {
            return notIn(operateIs, values);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsBetween(Integer value1, Integer value2) {
            return between(operateIs, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andOperateIsNotBetween(Integer value1, Integer value2) {
            return notBetween(operateIs, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andYouhuoDateIsNull() {
            return isNull(youhuoDate);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateIsNotNull() {
            return isNotNull(youhuoDate);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateEqualTo(Date value) {
            return equalTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateNotEqualTo(Date value) {
            return notEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateGreaterThan(Date value) {
            return greaterThan(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateLessThan(Date value) {
            return lessThan(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(youhuoDate, value);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateIn(List<Date> values) {
            return in(youhuoDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateNotIn(List<Date> values) {
            return notIn(youhuoDate, values);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateBetween(Date value1, Date value2) {
            return between(youhuoDate, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andYouhuoDateNotBetween(Date value1, Date value2) {
            return notBetween(youhuoDate, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andEndStatusIsNull() {
            return isNull(endStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusIsNotNull() {
            return isNotNull(endStatus);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusEqualTo(Integer value) {
            return equalTo(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusNotEqualTo(Integer value) {
            return notEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusGreaterThan(Integer value) {
            return greaterThan(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusLessThan(Integer value) {
            return lessThan(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(endStatus, value);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusIn(List<Integer> values) {
            return in(endStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusNotIn(List<Integer> values) {
            return notIn(endStatus, values);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusBetween(Integer value1, Integer value2) {
            return between(endStatus, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andEndStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(endStatus, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaGgoodsTasksExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaGgoodsTasksExample.Criteria andCustomSql(String sql){
            this.addCriterion(sql);
            return this;
        }

    }
}