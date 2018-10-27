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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andTasksIdIsNull() {
            return isNull(tasksId);
        }

        public Criteria andTasksIdIsNotNull() {
            return isNotNull(tasksId);
        }

        public Criteria andTasksIdEqualTo(Long value) {
            return equalTo(tasksId, value);
        }

        public Criteria andTasksIdNotEqualTo(Long value) {
            return notEqualTo(tasksId, value);
        }

        public Criteria andTasksIdGreaterThan(Long value) {
            return greaterThan(tasksId, value);
        }

        public Criteria andTasksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tasksId, value);
        }

        public Criteria andTasksIdLessThan(Long value) {
            return lessThan(tasksId, value);
        }

        public Criteria andTasksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tasksId, value);
        }

        public Criteria andTasksIdLike(String value) {
            return like(tasksId, value);
        }

        public Criteria andTasksIdNotLike(String value) {
            return notLike(tasksId, value);
        }

        public Criteria andTasksIdIn(List<Long> values) {
            return in(tasksId, values);
        }

        public Criteria andTasksIdNotIn(List<Long> values) {
            return notIn(tasksId, values);
        }

        public Criteria andTasksIdBetween(Long value1, Long value2) {
            return between(tasksId, value1, value2);
        }

        public Criteria andTasksIdNotBetween(Long value1, Long value2) {
            return notBetween(tasksId, value1, value2);
        }
        public Criteria andGgoodsCodeIsNull() {
            return isNull(ggoodsCode);
        }

        public Criteria andGgoodsCodeIsNotNull() {
            return isNotNull(ggoodsCode);
        }

        public Criteria andGgoodsCodeEqualTo(String value) {
            return equalTo(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeNotEqualTo(String value) {
            return notEqualTo(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeGreaterThan(String value) {
            return greaterThan(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeLessThan(String value) {
            return lessThan(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeLike(String value) {
            return like(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeNotLike(String value) {
            return notLike(ggoodsCode, value);
        }

        public Criteria andGgoodsCodeIn(List<String> values) {
            return in(ggoodsCode, values);
        }

        public Criteria andGgoodsCodeNotIn(List<String> values) {
            return notIn(ggoodsCode, values);
        }

        public Criteria andGgoodsCodeBetween(String value1, String value2) {
            return between(ggoodsCode, value1, value2);
        }

        public Criteria andGgoodsCodeNotBetween(String value1, String value2) {
            return notBetween(ggoodsCode, value1, value2);
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

        public Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
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

        public Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
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

        public Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
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
        public Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLike(String value) {
            return like(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdNotLike(String value) {
            return notLike(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
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
        public Criteria andAllocatDateIsNull() {
            return isNull(allocatDate);
        }

        public Criteria andAllocatDateIsNotNull() {
            return isNotNull(allocatDate);
        }

        public Criteria andAllocatDateEqualTo(String value) {
            return equalTo(allocatDate, value);
        }

        public Criteria andAllocatDateNotEqualTo(String value) {
            return notEqualTo(allocatDate, value);
        }

        public Criteria andAllocatDateGreaterThan(String value) {
            return greaterThan(allocatDate, value);
        }

        public Criteria andAllocatDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(allocatDate, value);
        }

        public Criteria andAllocatDateLessThan(String value) {
            return lessThan(allocatDate, value);
        }

        public Criteria andAllocatDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(allocatDate, value);
        }

        public Criteria andAllocatDateLike(String value) {
            return like(allocatDate, value);
        }

        public Criteria andAllocatDateNotLike(String value) {
            return notLike(allocatDate, value);
        }

        public Criteria andAllocatDateIn(List<String> values) {
            return in(allocatDate, values);
        }

        public Criteria andAllocatDateNotIn(List<String> values) {
            return notIn(allocatDate, values);
        }

        public Criteria andAllocatDateBetween(String value1, String value2) {
            return between(allocatDate, value1, value2);
        }

        public Criteria andAllocatDateNotBetween(String value1, String value2) {
            return notBetween(allocatDate, value1, value2);
        }
        public Criteria andAllocatTimeIsNull() {
            return isNull(allocatTime);
        }

        public Criteria andAllocatTimeIsNotNull() {
            return isNotNull(allocatTime);
        }

        public Criteria andAllocatTimeEqualTo(Date value) {
            return equalTo(allocatTime, value);
        }

        public Criteria andAllocatTimeNotEqualTo(Date value) {
            return notEqualTo(allocatTime, value);
        }

        public Criteria andAllocatTimeGreaterThan(Date value) {
            return greaterThan(allocatTime, value);
        }

        public Criteria andAllocatTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(allocatTime, value);
        }

        public Criteria andAllocatTimeLessThan(Date value) {
            return lessThan(allocatTime, value);
        }

        public Criteria andAllocatTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(allocatTime, value);
        }

        public Criteria andAllocatTimeIn(List<Date> values) {
            return in(allocatTime, values);
        }

        public Criteria andAllocatTimeNotIn(List<Date> values) {
            return notIn(allocatTime, values);
        }

        public Criteria andAllocatTimeBetween(Date value1, Date value2) {
            return between(allocatTime, value1, value2);
        }

        public Criteria andAllocatTimeNotBetween(Date value1, Date value2) {
            return notBetween(allocatTime, value1, value2);
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

        public Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
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

        public Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
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

        public Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
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

        public Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
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
        public Criteria andAllocatStatusIsNull() {
            return isNull(allocatStatus);
        }

        public Criteria andAllocatStatusIsNotNull() {
            return isNotNull(allocatStatus);
        }

        public Criteria andAllocatStatusEqualTo(Integer value) {
            return equalTo(allocatStatus, value);
        }

        public Criteria andAllocatStatusNotEqualTo(Integer value) {
            return notEqualTo(allocatStatus, value);
        }

        public Criteria andAllocatStatusGreaterThan(Integer value) {
            return greaterThan(allocatStatus, value);
        }

        public Criteria andAllocatStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(allocatStatus, value);
        }

        public Criteria andAllocatStatusLessThan(Integer value) {
            return lessThan(allocatStatus, value);
        }

        public Criteria andAllocatStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(allocatStatus, value);
        }

        public Criteria andAllocatStatusIn(List<Integer> values) {
            return in(allocatStatus, values);
        }

        public Criteria andAllocatStatusNotIn(List<Integer> values) {
            return notIn(allocatStatus, values);
        }

        public Criteria andAllocatStatusBetween(Integer value1, Integer value2) {
            return between(allocatStatus, value1, value2);
        }

        public Criteria andAllocatStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(allocatStatus, value1, value2);
        }
        public Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public Criteria andPrintGoodsStatusIsNull() {
            return isNull(printGoodsStatus);
        }

        public Criteria andPrintGoodsStatusIsNotNull() {
            return isNotNull(printGoodsStatus);
        }

        public Criteria andPrintGoodsStatusEqualTo(Integer value) {
            return equalTo(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusGreaterThan(Integer value) {
            return greaterThan(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusLessThan(Integer value) {
            return lessThan(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printGoodsStatus, value);
        }

        public Criteria andPrintGoodsStatusIn(List<Integer> values) {
            return in(printGoodsStatus, values);
        }

        public Criteria andPrintGoodsStatusNotIn(List<Integer> values) {
            return notIn(printGoodsStatus, values);
        }

        public Criteria andPrintGoodsStatusBetween(Integer value1, Integer value2) {
            return between(printGoodsStatus, value1, value2);
        }

        public Criteria andPrintGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printGoodsStatus, value1, value2);
        }
        public Criteria andPrintBatchIsNull() {
            return isNull(printBatch);
        }

        public Criteria andPrintBatchIsNotNull() {
            return isNotNull(printBatch);
        }

        public Criteria andPrintBatchEqualTo(String value) {
            return equalTo(printBatch, value);
        }

        public Criteria andPrintBatchNotEqualTo(String value) {
            return notEqualTo(printBatch, value);
        }

        public Criteria andPrintBatchGreaterThan(String value) {
            return greaterThan(printBatch, value);
        }

        public Criteria andPrintBatchGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(printBatch, value);
        }

        public Criteria andPrintBatchLessThan(String value) {
            return lessThan(printBatch, value);
        }

        public Criteria andPrintBatchLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(printBatch, value);
        }

        public Criteria andPrintBatchLike(String value) {
            return like(printBatch, value);
        }

        public Criteria andPrintBatchNotLike(String value) {
            return notLike(printBatch, value);
        }

        public Criteria andPrintBatchIn(List<String> values) {
            return in(printBatch, values);
        }

        public Criteria andPrintBatchNotIn(List<String> values) {
            return notIn(printBatch, values);
        }

        public Criteria andPrintBatchBetween(String value1, String value2) {
            return between(printBatch, value1, value2);
        }

        public Criteria andPrintBatchNotBetween(String value1, String value2) {
            return notBetween(printBatch, value1, value2);
        }
        public Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public Criteria andTakeGoodsDateEqualTo(String value) {
            return equalTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateNotEqualTo(String value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateGreaterThan(String value) {
            return greaterThan(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateLessThan(String value) {
            return lessThan(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateLike(String value) {
            return like(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateNotLike(String value) {
            return notLike(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateIn(List<String> values) {
            return in(takeGoodsDate, values);
        }

        public Criteria andTakeGoodsDateNotIn(List<String> values) {
            return notIn(takeGoodsDate, values);
        }

        public Criteria andTakeGoodsDateBetween(String value1, String value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public Criteria andTakeGoodsDateNotBetween(String value1, String value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public Criteria andReturnStatusIsNull() {
            return isNull(returnStatus);
        }

        public Criteria andReturnStatusIsNotNull() {
            return isNotNull(returnStatus);
        }

        public Criteria andReturnStatusEqualTo(Integer value) {
            return equalTo(returnStatus, value);
        }

        public Criteria andReturnStatusNotEqualTo(Integer value) {
            return notEqualTo(returnStatus, value);
        }

        public Criteria andReturnStatusGreaterThan(Integer value) {
            return greaterThan(returnStatus, value);
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnStatus, value);
        }

        public Criteria andReturnStatusLessThan(Integer value) {
            return lessThan(returnStatus, value);
        }

        public Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnStatus, value);
        }

        public Criteria andReturnStatusIn(List<Integer> values) {
            return in(returnStatus, values);
        }

        public Criteria andReturnStatusNotIn(List<Integer> values) {
            return notIn(returnStatus, values);
        }

        public Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            return between(returnStatus, value1, value2);
        }

        public Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnStatus, value1, value2);
        }
        public Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
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
        public Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public Criteria andOperateIsIsNull() {
            return isNull(operateIs);
        }

        public Criteria andOperateIsIsNotNull() {
            return isNotNull(operateIs);
        }

        public Criteria andOperateIsEqualTo(Integer value) {
            return equalTo(operateIs, value);
        }

        public Criteria andOperateIsNotEqualTo(Integer value) {
            return notEqualTo(operateIs, value);
        }

        public Criteria andOperateIsGreaterThan(Integer value) {
            return greaterThan(operateIs, value);
        }

        public Criteria andOperateIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(operateIs, value);
        }

        public Criteria andOperateIsLessThan(Integer value) {
            return lessThan(operateIs, value);
        }

        public Criteria andOperateIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(operateIs, value);
        }

        public Criteria andOperateIsIn(List<Integer> values) {
            return in(operateIs, values);
        }

        public Criteria andOperateIsNotIn(List<Integer> values) {
            return notIn(operateIs, values);
        }

        public Criteria andOperateIsBetween(Integer value1, Integer value2) {
            return between(operateIs, value1, value2);
        }

        public Criteria andOperateIsNotBetween(Integer value1, Integer value2) {
            return notBetween(operateIs, value1, value2);
        }
        public Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public Criteria andYouhuoDateIsNull() {
            return isNull(youhuoDate);
        }

        public Criteria andYouhuoDateIsNotNull() {
            return isNotNull(youhuoDate);
        }

        public Criteria andYouhuoDateEqualTo(Date value) {
            return equalTo(youhuoDate, value);
        }

        public Criteria andYouhuoDateNotEqualTo(Date value) {
            return notEqualTo(youhuoDate, value);
        }

        public Criteria andYouhuoDateGreaterThan(Date value) {
            return greaterThan(youhuoDate, value);
        }

        public Criteria andYouhuoDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(youhuoDate, value);
        }

        public Criteria andYouhuoDateLessThan(Date value) {
            return lessThan(youhuoDate, value);
        }

        public Criteria andYouhuoDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(youhuoDate, value);
        }

        public Criteria andYouhuoDateIn(List<Date> values) {
            return in(youhuoDate, values);
        }

        public Criteria andYouhuoDateNotIn(List<Date> values) {
            return notIn(youhuoDate, values);
        }

        public Criteria andYouhuoDateBetween(Date value1, Date value2) {
            return between(youhuoDate, value1, value2);
        }

        public Criteria andYouhuoDateNotBetween(Date value1, Date value2) {
            return notBetween(youhuoDate, value1, value2);
        }
        public Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
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

        public Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
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
        public Criteria andEndStatusIsNull() {
            return isNull(endStatus);
        }

        public Criteria andEndStatusIsNotNull() {
            return isNotNull(endStatus);
        }

        public Criteria andEndStatusEqualTo(Integer value) {
            return equalTo(endStatus, value);
        }

        public Criteria andEndStatusNotEqualTo(Integer value) {
            return notEqualTo(endStatus, value);
        }

        public Criteria andEndStatusGreaterThan(Integer value) {
            return greaterThan(endStatus, value);
        }

        public Criteria andEndStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(endStatus, value);
        }

        public Criteria andEndStatusLessThan(Integer value) {
            return lessThan(endStatus, value);
        }

        public Criteria andEndStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(endStatus, value);
        }

        public Criteria andEndStatusIn(List<Integer> values) {
            return in(endStatus, values);
        }

        public Criteria andEndStatusNotIn(List<Integer> values) {
            return notIn(endStatus, values);
        }

        public Criteria andEndStatusBetween(Integer value1, Integer value2) {
            return between(endStatus, value1, value2);
        }

        public Criteria andEndStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(endStatus, value1, value2);
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
        public Criteria andCustomSql(String sql){
            this.addCriterion(sql);
            return this;
        }

    }
}