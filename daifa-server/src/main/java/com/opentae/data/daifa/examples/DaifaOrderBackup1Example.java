package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaOrderBackup1;

import java.util.*;

public class DaifaOrderBackup1Example extends SgExample<DaifaOrderBackup1Example.Criteria> {


    private Integer takegoodstatus;//
    private String startTime;//createTime
    private String endTime;//lastDoTime

    public static final Class<DaifaOrderBackup1> beanClass = DaifaOrderBackup1.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dfOrderId;
    public static EntityColumn dfTradeId;
    public static EntityColumn marketId;
    public static EntityColumn marketName;
    public static EntityColumn floorId;
    public static EntityColumn floorName;
    public static EntityColumn storeId;
    public static EntityColumn storeNum;
    public static EntityColumn goodsId;
    public static EntityColumn goodsCode;
    public static EntityColumn title;
    public static EntityColumn picPath;
    public static EntityColumn storeGoodsCode;
    public static EntityColumn propStr;
    public static EntityColumn goodsNum;
    public static EntityColumn cid;
    public static EntityColumn singlePiPrice;
    public static EntityColumn singlePay;
    public static EntityColumn singlePrice;
    public static EntityColumn orderDiscountFee;
    public static EntityColumn singleServicesFee;
    public static EntityColumn totalServiceFee;
    public static EntityColumn totalFee;
    public static EntityColumn orderStatus;
    public static EntityColumn allocatStatus;
    public static EntityColumn aggrement;
    public static EntityColumn printBarcodeStatus;
    public static EntityColumn takeGoodsStatus;
    public static EntityColumn takeGoodsDate;
    public static EntityColumn cdkey;
    public static EntityColumn createTime;
    public static EntityColumn lastDoTime;
    public static EntityColumn barCodeKeyNum;
    public static EntityColumn tradeCode;
    public static EntityColumn orderCode;
    public static EntityColumn orderPartitionId;
    public static EntityColumn stockStatus;
    public static EntityColumn stockoutCycleStatus;
    public static EntityColumn orderRemark;
    public static EntityColumn giftCode;
    public static EntityColumn haveGoodsDate;
    public static EntityColumn delistIs;
    public static EntityColumn refundId;
    public static EntityColumn refundStatus;
    public static EntityColumn refundApplyTime;
    public static EntityColumn reCause;
    public static EntityColumn refundFinishTime;
    public static EntityColumn returnGoodsStatus;
    public static EntityColumn returnGoodsFee;
    public static EntityColumn returnGoodsApplyTime;
    public static EntityColumn returnGoodsFinishTime;
    public static EntityColumn changeTime;
    public static EntityColumn changeStatus;
    public static EntityColumn changeReason;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn goodsWeight;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfOrderId = listMap.get("dfOrderId");
        dfTradeId = listMap.get("dfTradeId");
        marketId = listMap.get("marketId");
        marketName = listMap.get("marketName");
        floorId = listMap.get("floorId");
        floorName = listMap.get("floorName");
        storeId = listMap.get("storeId");
        storeNum = listMap.get("storeNum");
        goodsId = listMap.get("goodsId");
        goodsCode = listMap.get("goodsCode");
        title = listMap.get("title");
        picPath = listMap.get("picPath");
        storeGoodsCode = listMap.get("storeGoodsCode");
        propStr = listMap.get("propStr");
        goodsNum = listMap.get("goodsNum");
        cid = listMap.get("cid");
        singlePiPrice = listMap.get("singlePiPrice");
        singlePay = listMap.get("singlePay");
        singlePrice = listMap.get("singlePrice");
        orderDiscountFee = listMap.get("orderDiscountFee");
        singleServicesFee = listMap.get("singleServicesFee");
        totalServiceFee = listMap.get("totalServiceFee");
        totalFee = listMap.get("totalFee");
        orderStatus = listMap.get("orderStatus");
        allocatStatus = listMap.get("allocatStatus");
        aggrement = listMap.get("aggrement");
        printBarcodeStatus = listMap.get("printBarcodeStatus");
        takeGoodsStatus = listMap.get("takeGoodsStatus");
        takeGoodsDate = listMap.get("takeGoodsDate");
        cdkey = listMap.get("cdkey");
        createTime = listMap.get("createTime");
        lastDoTime = listMap.get("lastDoTime");
        barCodeKeyNum = listMap.get("barCodeKeyNum");
        tradeCode = listMap.get("tradeCode");
        orderCode = listMap.get("orderCode");
        orderPartitionId = listMap.get("orderPartitionId");
        stockStatus = listMap.get("stockStatus");
        stockoutCycleStatus = listMap.get("stockoutCycleStatus");
        orderRemark = listMap.get("orderRemark");
        giftCode = listMap.get("giftCode");
        haveGoodsDate = listMap.get("haveGoodsDate");
        delistIs = listMap.get("delistIs");
        refundId = listMap.get("refundId");
        refundStatus = listMap.get("refundStatus");
        refundApplyTime = listMap.get("refundApplyTime");
        reCause = listMap.get("reCause");
        refundFinishTime = listMap.get("refundFinishTime");
        returnGoodsStatus = listMap.get("returnGoodsStatus");
        returnGoodsFee = listMap.get("returnGoodsFee");
        returnGoodsApplyTime = listMap.get("returnGoodsApplyTime");
        returnGoodsFinishTime = listMap.get("returnGoodsFinishTime");
        changeTime = listMap.get("changeTime");
        changeStatus = listMap.get("changeStatus");
        changeReason = listMap.get("changeReason");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        goodsWeight = listMap.get("goodsWeight");

    }

    public DaifaOrderBackup1Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaOrderBackup1Example.Criteria createCriteriaInternal() {
        return new DaifaOrderBackup1Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaOrderBackup1Example.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaOrderBackup1Example.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaOrderBackup1Example.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaOrderBackup1Example.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaOrderBackup1Example.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public DaifaOrderBackup1Example.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public DaifaOrderBackup1Example.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidLike(String value) {
            return like(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public DaifaOrderBackup1Example.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public DaifaOrderBackup1Example.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public DaifaOrderBackup1Example.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andSinglePayIsNull() {
            return isNull(singlePay);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayIsNotNull() {
            return isNotNull(singlePay);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayEqualTo(String value) {
            return equalTo(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayNotEqualTo(String value) {
            return notEqualTo(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayGreaterThan(String value) {
            return greaterThan(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayLessThan(String value) {
            return lessThan(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayLike(String value) {
            return like(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayNotLike(String value) {
            return notLike(singlePay, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayIn(List<String> values) {
            return in(singlePay, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayNotIn(List<String> values) {
            return notIn(singlePay, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayBetween(String value1, String value2) {
            return between(singlePay, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePayNotBetween(String value1, String value2) {
            return notBetween(singlePay, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeIsNull() {
            return isNull(orderDiscountFee);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeIsNotNull() {
            return isNotNull(orderDiscountFee);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeEqualTo(String value) {
            return equalTo(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeNotEqualTo(String value) {
            return notEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeGreaterThan(String value) {
            return greaterThan(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeLessThan(String value) {
            return lessThan(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeLike(String value) {
            return like(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeNotLike(String value) {
            return notLike(orderDiscountFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeIn(List<String> values) {
            return in(orderDiscountFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeNotIn(List<String> values) {
            return notIn(orderDiscountFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeBetween(String value1, String value2) {
            return between(orderDiscountFee, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andOrderDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(orderDiscountFee, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeIsNull() {
            return isNull(singleServicesFee);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeIsNotNull() {
            return isNotNull(singleServicesFee);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeEqualTo(String value) {
            return equalTo(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeNotEqualTo(String value) {
            return notEqualTo(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeGreaterThan(String value) {
            return greaterThan(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeLessThan(String value) {
            return lessThan(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeLike(String value) {
            return like(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeNotLike(String value) {
            return notLike(singleServicesFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeIn(List<String> values) {
            return in(singleServicesFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeNotIn(List<String> values) {
            return notIn(singleServicesFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeBetween(String value1, String value2) {
            return between(singleServicesFee, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andSingleServicesFeeNotBetween(String value1, String value2) {
            return notBetween(singleServicesFee, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeIsNull() {
            return isNull(totalServiceFee);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeIsNotNull() {
            return isNotNull(totalServiceFee);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeEqualTo(String value) {
            return equalTo(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeNotEqualTo(String value) {
            return notEqualTo(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeGreaterThan(String value) {
            return greaterThan(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeLessThan(String value) {
            return lessThan(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeLike(String value) {
            return like(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeNotLike(String value) {
            return notLike(totalServiceFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeIn(List<String> values) {
            return in(totalServiceFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeNotIn(List<String> values) {
            return notIn(totalServiceFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeBetween(String value1, String value2) {
            return between(totalServiceFee, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTotalServiceFeeNotBetween(String value1, String value2) {
            return notBetween(totalServiceFee, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeEqualTo(String value) {
            return equalTo(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeNotEqualTo(String value) {
            return notEqualTo(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeGreaterThan(String value) {
            return greaterThan(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeLessThan(String value) {
            return lessThan(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeLike(String value) {
            return like(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeNotLike(String value) {
            return notLike(totalFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeIn(List<String> values) {
            return in(totalFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeNotIn(List<String> values) {
            return notIn(totalFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeBetween(String value1, String value2) {
            return between(totalFee, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTotalFeeNotBetween(String value1, String value2) {
            return notBetween(totalFee, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andOrderStatusIsNull() {
            return isNull(orderStatus);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusIsNotNull() {
            return isNotNull(orderStatus);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusEqualTo(Long value) {
            return equalTo(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusNotEqualTo(Long value) {
            return notEqualTo(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusGreaterThan(Long value) {
            return greaterThan(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusLessThan(Long value) {
            return lessThan(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusLike(String value) {
            return like(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusNotLike(String value) {
            return notLike(orderStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusIn(List<Long> values) {
            return in(orderStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusNotIn(List<Long> values) {
            return notIn(orderStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusBetween(Long value1, Long value2) {
            return between(orderStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andOrderStatusNotBetween(Long value1, Long value2) {
            return notBetween(orderStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andAllocatStatusIsNull() {
            return isNull(allocatStatus);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusIsNotNull() {
            return isNotNull(allocatStatus);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusEqualTo(Integer value) {
            return equalTo(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusNotEqualTo(Integer value) {
            return notEqualTo(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusGreaterThan(Integer value) {
            return greaterThan(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusLessThan(Integer value) {
            return lessThan(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(allocatStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusIn(List<Integer> values) {
            return in(allocatStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusNotIn(List<Integer> values) {
            return notIn(allocatStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusBetween(Integer value1, Integer value2) {
            return between(allocatStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andAllocatStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(allocatStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateEqualTo(Date value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateNotEqualTo(Date value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateGreaterThan(Date value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateLessThan(Date value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateIn(List<Date> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateNotIn(List<Date> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateBetween(Date value1, Date value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTakeGoodsDateNotBetween(Date value1, Date value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumIsNull() {
            return isNull(barCodeKeyNum);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumIsNotNull() {
            return isNotNull(barCodeKeyNum);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumEqualTo(String value) {
            return equalTo(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumNotEqualTo(String value) {
            return notEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumGreaterThan(String value) {
            return greaterThan(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumLessThan(String value) {
            return lessThan(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumLike(String value) {
            return like(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumNotLike(String value) {
            return notLike(barCodeKeyNum, value);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumIn(List<String> values) {
            return in(barCodeKeyNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumNotIn(List<String> values) {
            return notIn(barCodeKeyNum, values);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumBetween(String value1, String value2) {
            return between(barCodeKeyNum, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andBarCodeKeyNumNotBetween(String value1, String value2) {
            return notBetween(barCodeKeyNum, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusIsNull() {
            return isNull(stockoutCycleStatus);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusIsNotNull() {
            return isNotNull(stockoutCycleStatus);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusEqualTo(Integer value) {
            return equalTo(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusNotEqualTo(Integer value) {
            return notEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusGreaterThan(Integer value) {
            return greaterThan(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusLessThan(Integer value) {
            return lessThan(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusIn(List<Integer> values) {
            return in(stockoutCycleStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusNotIn(List<Integer> values) {
            return notIn(stockoutCycleStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusBetween(Integer value1, Integer value2) {
            return between(stockoutCycleStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andStockoutCycleStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockoutCycleStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andOrderRemarkIsNull() {
            return isNull(orderRemark);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkIsNotNull() {
            return isNotNull(orderRemark);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkEqualTo(String value) {
            return equalTo(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkNotEqualTo(String value) {
            return notEqualTo(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkGreaterThan(String value) {
            return greaterThan(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkLessThan(String value) {
            return lessThan(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkLike(String value) {
            return like(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkNotLike(String value) {
            return notLike(orderRemark, value);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkIn(List<String> values) {
            return in(orderRemark, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkNotIn(List<String> values) {
            return notIn(orderRemark, values);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkBetween(String value1, String value2) {
            return between(orderRemark, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andOrderRemarkNotBetween(String value1, String value2) {
            return notBetween(orderRemark, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateIsNull() {
            return isNull(haveGoodsDate);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateIsNotNull() {
            return isNotNull(haveGoodsDate);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateEqualTo(String value) {
            return equalTo(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateNotEqualTo(String value) {
            return notEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateGreaterThan(String value) {
            return greaterThan(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateLessThan(String value) {
            return lessThan(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateLike(String value) {
            return like(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateNotLike(String value) {
            return notLike(haveGoodsDate, value);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateIn(List<String> values) {
            return in(haveGoodsDate, values);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateNotIn(List<String> values) {
            return notIn(haveGoodsDate, values);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateBetween(String value1, String value2) {
            return between(haveGoodsDate, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andHaveGoodsDateNotBetween(String value1, String value2) {
            return notBetween(haveGoodsDate, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRefundStatusIsNull() {
            return isNull(refundStatus);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusIsNotNull() {
            return isNotNull(refundStatus);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusEqualTo(Integer value) {
            return equalTo(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusNotEqualTo(Integer value) {
            return notEqualTo(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusGreaterThan(Integer value) {
            return greaterThan(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusLessThan(Integer value) {
            return lessThan(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusIn(List<Integer> values) {
            return in(refundStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusNotIn(List<Integer> values) {
            return notIn(refundStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            return between(refundStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(refundStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeIsNull() {
            return isNull(refundApplyTime);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeIsNotNull() {
            return isNotNull(refundApplyTime);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeEqualTo(Date value) {
            return equalTo(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeNotEqualTo(Date value) {
            return notEqualTo(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeGreaterThan(Date value) {
            return greaterThan(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeLessThan(Date value) {
            return lessThan(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeIn(List<Date> values) {
            return in(refundApplyTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeNotIn(List<Date> values) {
            return notIn(refundApplyTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeBetween(Date value1, Date value2) {
            return between(refundApplyTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRefundApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundApplyTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andReCauseIsNull() {
            return isNull(reCause);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseIsNotNull() {
            return isNotNull(reCause);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseEqualTo(String value) {
            return equalTo(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseNotEqualTo(String value) {
            return notEqualTo(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseGreaterThan(String value) {
            return greaterThan(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseLessThan(String value) {
            return lessThan(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseLike(String value) {
            return like(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseNotLike(String value) {
            return notLike(reCause, value);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseIn(List<String> values) {
            return in(reCause, values);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseNotIn(List<String> values) {
            return notIn(reCause, values);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseBetween(String value1, String value2) {
            return between(reCause, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andReCauseNotBetween(String value1, String value2) {
            return notBetween(reCause, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeIsNull() {
            return isNull(refundFinishTime);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeIsNotNull() {
            return isNotNull(refundFinishTime);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeEqualTo(Date value) {
            return equalTo(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeNotEqualTo(Date value) {
            return notEqualTo(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeGreaterThan(Date value) {
            return greaterThan(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeLessThan(Date value) {
            return lessThan(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeIn(List<Date> values) {
            return in(refundFinishTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeNotIn(List<Date> values) {
            return notIn(refundFinishTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeBetween(Date value1, Date value2) {
            return between(refundFinishTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRefundFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundFinishTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusIsNull() {
            return isNull(returnGoodsStatus);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusIsNotNull() {
            return isNotNull(returnGoodsStatus);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusEqualTo(Integer value) {
            return equalTo(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusGreaterThan(Integer value) {
            return greaterThan(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusLessThan(Integer value) {
            return lessThan(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusIn(List<Integer> values) {
            return in(returnGoodsStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusNotIn(List<Integer> values) {
            return notIn(returnGoodsStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusBetween(Integer value1, Integer value2) {
            return between(returnGoodsStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnGoodsStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeIsNull() {
            return isNull(returnGoodsFee);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeIsNotNull() {
            return isNotNull(returnGoodsFee);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeEqualTo(String value) {
            return equalTo(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeNotEqualTo(String value) {
            return notEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeGreaterThan(String value) {
            return greaterThan(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeLessThan(String value) {
            return lessThan(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeLike(String value) {
            return like(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeNotLike(String value) {
            return notLike(returnGoodsFee, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeIn(List<String> values) {
            return in(returnGoodsFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeNotIn(List<String> values) {
            return notIn(returnGoodsFee, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeBetween(String value1, String value2) {
            return between(returnGoodsFee, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(returnGoodsFee, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeIsNull() {
            return isNull(returnGoodsApplyTime);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeIsNotNull() {
            return isNotNull(returnGoodsApplyTime);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeEqualTo(Date value) {
            return equalTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeLessThan(Date value) {
            return lessThan(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeIn(List<Date> values) {
            return in(returnGoodsApplyTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeNotIn(List<Date> values) {
            return notIn(returnGoodsApplyTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeBetween(Date value1, Date value2) {
            return between(returnGoodsApplyTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsApplyTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeIsNull() {
            return isNull(returnGoodsFinishTime);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeIsNotNull() {
            return isNotNull(returnGoodsFinishTime);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeEqualTo(Date value) {
            return equalTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeLessThan(Date value) {
            return lessThan(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeIn(List<Date> values) {
            return in(returnGoodsFinishTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeNotIn(List<Date> values) {
            return notIn(returnGoodsFinishTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeBetween(Date value1, Date value2) {
            return between(returnGoodsFinishTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andReturnGoodsFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsFinishTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andChangeTimeIsNull() {
            return isNull(changeTime);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeIsNotNull() {
            return isNotNull(changeTime);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeEqualTo(Date value) {
            return equalTo(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeNotEqualTo(Date value) {
            return notEqualTo(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeGreaterThan(Date value) {
            return greaterThan(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeLessThan(Date value) {
            return lessThan(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(changeTime, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeIn(List<Date> values) {
            return in(changeTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeNotIn(List<Date> values) {
            return notIn(changeTime, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeBetween(Date value1, Date value2) {
            return between(changeTime, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            return notBetween(changeTime, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andChangeStatusIsNull() {
            return isNull(changeStatus);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusIsNotNull() {
            return isNotNull(changeStatus);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusEqualTo(Integer value) {
            return equalTo(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusNotEqualTo(Integer value) {
            return notEqualTo(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusGreaterThan(Integer value) {
            return greaterThan(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusLessThan(Integer value) {
            return lessThan(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(changeStatus, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusIn(List<Integer> values) {
            return in(changeStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusNotIn(List<Integer> values) {
            return notIn(changeStatus, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusBetween(Integer value1, Integer value2) {
            return between(changeStatus, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andChangeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(changeStatus, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andChangeReasonIsNull() {
            return isNull(changeReason);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonIsNotNull() {
            return isNotNull(changeReason);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonEqualTo(String value) {
            return equalTo(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonNotEqualTo(String value) {
            return notEqualTo(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonGreaterThan(String value) {
            return greaterThan(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonLessThan(String value) {
            return lessThan(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonLike(String value) {
            return like(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonNotLike(String value) {
            return notLike(changeReason, value);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonIn(List<String> values) {
            return in(changeReason, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonNotIn(List<String> values) {
            return notIn(changeReason, values);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonBetween(String value1, String value2) {
            return between(changeReason, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andChangeReasonNotBetween(String value1, String value2) {
            return notBetween(changeReason, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaOrderBackup1Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }

        //////
        public DaifaOrderBackup1Example.Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightEqualTo(String value) {
            return equalTo(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightNotEqualTo(String value) {
            return notEqualTo(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightGreaterThan(String value) {
            return greaterThan(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightLessThan(String value) {
            return lessThan(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightLike(String value) {
            return like(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightNotLike(String value) {
            return notLike(goodsWeight, value);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightIn(List<String> values) {
            return in(goodsWeight, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightNotIn(List<String> values) {
            return notIn(goodsWeight, values);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightBetween(String value1, String value2) {
            return between(goodsWeight, value1, value2);
        }

        public DaifaOrderBackup1Example.Criteria andGoodsWeightNotBetween(String value1, String value2) {
            return notBetween(goodsWeight, value1, value2);
        }
    }

    public Integer getTakegoodstatus () {
        return takegoodstatus;
    }

    public void setTakegoodstatus (Integer takegoodstatus) {
        this.takegoodstatus = takegoodstatus;
    }

    public String getStartTime () {
        return startTime;
    }

    public void setStartTime (String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime () {
        return endTime;
    }

    public void setEndTime (String endTime) {
        this.endTime = endTime;
    }

}