package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaOrder;

import java.util.*;
public class DaifaOrderExample extends SgExample<DaifaOrderExample.Criteria> {


    private Integer takegoodstatus;//
    private String startTime;//createTime
    private String endTime;//lastDoTime

    public static final Class<DaifaOrder> beanClass = DaifaOrder.class;
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

    public DaifaOrderExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaOrderExample.Criteria createCriteriaInternal() {
        return new DaifaOrderExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaOrderExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaOrderExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaOrderExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdLike(String value) {
            return like(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdNotLike(String value) {
            return notLike(dfOrderId, value);
        }

        public DaifaOrderExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaOrderExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaOrderExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaOrderExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
        public DaifaOrderExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaOrderExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaOrderExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaOrderExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaOrderExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaOrderExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaOrderExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaOrderExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public DaifaOrderExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public DaifaOrderExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdLike(String value) {
            return like(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdNotLike(String value) {
            return notLike(marketId, value);
        }

        public DaifaOrderExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public DaifaOrderExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public DaifaOrderExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public DaifaOrderExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public DaifaOrderExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public DaifaOrderExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public DaifaOrderExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public DaifaOrderExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public DaifaOrderExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public DaifaOrderExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public DaifaOrderExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public DaifaOrderExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public DaifaOrderExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public DaifaOrderExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdLike(String value) {
            return like(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdNotLike(String value) {
            return notLike(floorId, value);
        }

        public DaifaOrderExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public DaifaOrderExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public DaifaOrderExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public DaifaOrderExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public DaifaOrderExample.Criteria andFloorNameIsNull() {
            return isNull(floorName);
        }

        public DaifaOrderExample.Criteria andFloorNameIsNotNull() {
            return isNotNull(floorName);
        }

        public DaifaOrderExample.Criteria andFloorNameEqualTo(String value) {
            return equalTo(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameNotEqualTo(String value) {
            return notEqualTo(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameGreaterThan(String value) {
            return greaterThan(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameLessThan(String value) {
            return lessThan(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameLike(String value) {
            return like(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameNotLike(String value) {
            return notLike(floorName, value);
        }

        public DaifaOrderExample.Criteria andFloorNameIn(List<String> values) {
            return in(floorName, values);
        }

        public DaifaOrderExample.Criteria andFloorNameNotIn(List<String> values) {
            return notIn(floorName, values);
        }

        public DaifaOrderExample.Criteria andFloorNameBetween(String value1, String value2) {
            return between(floorName, value1, value2);
        }

        public DaifaOrderExample.Criteria andFloorNameNotBetween(String value1, String value2) {
            return notBetween(floorName, value1, value2);
        }
        public DaifaOrderExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DaifaOrderExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DaifaOrderExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdLike(String value) {
            return like(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdNotLike(String value) {
            return notLike(storeId, value);
        }

        public DaifaOrderExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DaifaOrderExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DaifaOrderExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DaifaOrderExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DaifaOrderExample.Criteria andStoreNumIsNull() {
            return isNull(storeNum);
        }

        public DaifaOrderExample.Criteria andStoreNumIsNotNull() {
            return isNotNull(storeNum);
        }

        public DaifaOrderExample.Criteria andStoreNumEqualTo(String value) {
            return equalTo(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumNotEqualTo(String value) {
            return notEqualTo(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumGreaterThan(String value) {
            return greaterThan(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumLessThan(String value) {
            return lessThan(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumLike(String value) {
            return like(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumNotLike(String value) {
            return notLike(storeNum, value);
        }

        public DaifaOrderExample.Criteria andStoreNumIn(List<String> values) {
            return in(storeNum, values);
        }

        public DaifaOrderExample.Criteria andStoreNumNotIn(List<String> values) {
            return notIn(storeNum, values);
        }

        public DaifaOrderExample.Criteria andStoreNumBetween(String value1, String value2) {
            return between(storeNum, value1, value2);
        }

        public DaifaOrderExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            return notBetween(storeNum, value1, value2);
        }
        public DaifaOrderExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public DaifaOrderExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public DaifaOrderExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdLike(String value) {
            return like(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdNotLike(String value) {
            return notLike(goodsId, value);
        }

        public DaifaOrderExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public DaifaOrderExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public DaifaOrderExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public DaifaOrderExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public DaifaOrderExample.Criteria andGoodsCodeIsNull() {
            return isNull(goodsCode);
        }

        public DaifaOrderExample.Criteria andGoodsCodeIsNotNull() {
            return isNotNull(goodsCode);
        }

        public DaifaOrderExample.Criteria andGoodsCodeEqualTo(String value) {
            return equalTo(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeNotEqualTo(String value) {
            return notEqualTo(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeGreaterThan(String value) {
            return greaterThan(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeLessThan(String value) {
            return lessThan(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeLike(String value) {
            return like(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeNotLike(String value) {
            return notLike(goodsCode, value);
        }

        public DaifaOrderExample.Criteria andGoodsCodeIn(List<String> values) {
            return in(goodsCode, values);
        }

        public DaifaOrderExample.Criteria andGoodsCodeNotIn(List<String> values) {
            return notIn(goodsCode, values);
        }

        public DaifaOrderExample.Criteria andGoodsCodeBetween(String value1, String value2) {
            return between(goodsCode, value1, value2);
        }

        public DaifaOrderExample.Criteria andGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(goodsCode, value1, value2);
        }
        public DaifaOrderExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DaifaOrderExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DaifaOrderExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DaifaOrderExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DaifaOrderExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DaifaOrderExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DaifaOrderExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DaifaOrderExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DaifaOrderExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DaifaOrderExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DaifaOrderExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DaifaOrderExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DaifaOrderExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DaifaOrderExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DaifaOrderExample.Criteria andPicPathIsNull() {
            return isNull(picPath);
        }

        public DaifaOrderExample.Criteria andPicPathIsNotNull() {
            return isNotNull(picPath);
        }

        public DaifaOrderExample.Criteria andPicPathEqualTo(String value) {
            return equalTo(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathNotEqualTo(String value) {
            return notEqualTo(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathGreaterThan(String value) {
            return greaterThan(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathLessThan(String value) {
            return lessThan(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathLike(String value) {
            return like(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathNotLike(String value) {
            return notLike(picPath, value);
        }

        public DaifaOrderExample.Criteria andPicPathIn(List<String> values) {
            return in(picPath, values);
        }

        public DaifaOrderExample.Criteria andPicPathNotIn(List<String> values) {
            return notIn(picPath, values);
        }

        public DaifaOrderExample.Criteria andPicPathBetween(String value1, String value2) {
            return between(picPath, value1, value2);
        }

        public DaifaOrderExample.Criteria andPicPathNotBetween(String value1, String value2) {
            return notBetween(picPath, value1, value2);
        }
        public DaifaOrderExample.Criteria andStoreGoodsCodeIsNull() {
            return isNull(storeGoodsCode);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeIsNotNull() {
            return isNotNull(storeGoodsCode);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeEqualTo(String value) {
            return equalTo(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeNotEqualTo(String value) {
            return notEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeGreaterThan(String value) {
            return greaterThan(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeLessThan(String value) {
            return lessThan(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeLike(String value) {
            return like(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeNotLike(String value) {
            return notLike(storeGoodsCode, value);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeIn(List<String> values) {
            return in(storeGoodsCode, values);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeNotIn(List<String> values) {
            return notIn(storeGoodsCode, values);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeBetween(String value1, String value2) {
            return between(storeGoodsCode, value1, value2);
        }

        public DaifaOrderExample.Criteria andStoreGoodsCodeNotBetween(String value1, String value2) {
            return notBetween(storeGoodsCode, value1, value2);
        }
        public DaifaOrderExample.Criteria andPropStrIsNull() {
            return isNull(propStr);
        }

        public DaifaOrderExample.Criteria andPropStrIsNotNull() {
            return isNotNull(propStr);
        }

        public DaifaOrderExample.Criteria andPropStrEqualTo(String value) {
            return equalTo(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrNotEqualTo(String value) {
            return notEqualTo(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrGreaterThan(String value) {
            return greaterThan(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrLessThan(String value) {
            return lessThan(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrLike(String value) {
            return like(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrNotLike(String value) {
            return notLike(propStr, value);
        }

        public DaifaOrderExample.Criteria andPropStrIn(List<String> values) {
            return in(propStr, values);
        }

        public DaifaOrderExample.Criteria andPropStrNotIn(List<String> values) {
            return notIn(propStr, values);
        }

        public DaifaOrderExample.Criteria andPropStrBetween(String value1, String value2) {
            return between(propStr, value1, value2);
        }

        public DaifaOrderExample.Criteria andPropStrNotBetween(String value1, String value2) {
            return notBetween(propStr, value1, value2);
        }
        public DaifaOrderExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaOrderExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaOrderExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaOrderExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaOrderExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaOrderExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaOrderExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaOrderExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public DaifaOrderExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public DaifaOrderExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public DaifaOrderExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public DaifaOrderExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public DaifaOrderExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public DaifaOrderExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public DaifaOrderExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public DaifaOrderExample.Criteria andCidLike(String value) {
            return like(cid, value);
        }

        public DaifaOrderExample.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public DaifaOrderExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public DaifaOrderExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public DaifaOrderExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public DaifaOrderExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public DaifaOrderExample.Criteria andSinglePiPriceIsNull() {
            return isNull(singlePiPrice);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceIsNotNull() {
            return isNotNull(singlePiPrice);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceEqualTo(String value) {
            return equalTo(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceNotEqualTo(String value) {
            return notEqualTo(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceGreaterThan(String value) {
            return greaterThan(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceLessThan(String value) {
            return lessThan(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceLike(String value) {
            return like(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceNotLike(String value) {
            return notLike(singlePiPrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceIn(List<String> values) {
            return in(singlePiPrice, values);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceNotIn(List<String> values) {
            return notIn(singlePiPrice, values);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceBetween(String value1, String value2) {
            return between(singlePiPrice, value1, value2);
        }

        public DaifaOrderExample.Criteria andSinglePiPriceNotBetween(String value1, String value2) {
            return notBetween(singlePiPrice, value1, value2);
        }
        public DaifaOrderExample.Criteria andSinglePayIsNull() {
            return isNull(singlePay);
        }

        public DaifaOrderExample.Criteria andSinglePayIsNotNull() {
            return isNotNull(singlePay);
        }

        public DaifaOrderExample.Criteria andSinglePayEqualTo(String value) {
            return equalTo(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayNotEqualTo(String value) {
            return notEqualTo(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayGreaterThan(String value) {
            return greaterThan(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayLessThan(String value) {
            return lessThan(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayLike(String value) {
            return like(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayNotLike(String value) {
            return notLike(singlePay, value);
        }

        public DaifaOrderExample.Criteria andSinglePayIn(List<String> values) {
            return in(singlePay, values);
        }

        public DaifaOrderExample.Criteria andSinglePayNotIn(List<String> values) {
            return notIn(singlePay, values);
        }

        public DaifaOrderExample.Criteria andSinglePayBetween(String value1, String value2) {
            return between(singlePay, value1, value2);
        }

        public DaifaOrderExample.Criteria andSinglePayNotBetween(String value1, String value2) {
            return notBetween(singlePay, value1, value2);
        }
        public DaifaOrderExample.Criteria andSinglePriceIsNull() {
            return isNull(singlePrice);
        }

        public DaifaOrderExample.Criteria andSinglePriceIsNotNull() {
            return isNotNull(singlePrice);
        }

        public DaifaOrderExample.Criteria andSinglePriceEqualTo(String value) {
            return equalTo(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceNotEqualTo(String value) {
            return notEqualTo(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceGreaterThan(String value) {
            return greaterThan(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceLessThan(String value) {
            return lessThan(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceLike(String value) {
            return like(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceNotLike(String value) {
            return notLike(singlePrice, value);
        }

        public DaifaOrderExample.Criteria andSinglePriceIn(List<String> values) {
            return in(singlePrice, values);
        }

        public DaifaOrderExample.Criteria andSinglePriceNotIn(List<String> values) {
            return notIn(singlePrice, values);
        }

        public DaifaOrderExample.Criteria andSinglePriceBetween(String value1, String value2) {
            return between(singlePrice, value1, value2);
        }

        public DaifaOrderExample.Criteria andSinglePriceNotBetween(String value1, String value2) {
            return notBetween(singlePrice, value1, value2);
        }
        public DaifaOrderExample.Criteria andOrderDiscountFeeIsNull() {
            return isNull(orderDiscountFee);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeIsNotNull() {
            return isNotNull(orderDiscountFee);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeEqualTo(String value) {
            return equalTo(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeNotEqualTo(String value) {
            return notEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeGreaterThan(String value) {
            return greaterThan(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeLessThan(String value) {
            return lessThan(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeLike(String value) {
            return like(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeNotLike(String value) {
            return notLike(orderDiscountFee, value);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeIn(List<String> values) {
            return in(orderDiscountFee, values);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeNotIn(List<String> values) {
            return notIn(orderDiscountFee, values);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeBetween(String value1, String value2) {
            return between(orderDiscountFee, value1, value2);
        }

        public DaifaOrderExample.Criteria andOrderDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(orderDiscountFee, value1, value2);
        }
        public DaifaOrderExample.Criteria andSingleServicesFeeIsNull() {
            return isNull(singleServicesFee);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeIsNotNull() {
            return isNotNull(singleServicesFee);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeEqualTo(String value) {
            return equalTo(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeNotEqualTo(String value) {
            return notEqualTo(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeGreaterThan(String value) {
            return greaterThan(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeLessThan(String value) {
            return lessThan(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeLike(String value) {
            return like(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeNotLike(String value) {
            return notLike(singleServicesFee, value);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeIn(List<String> values) {
            return in(singleServicesFee, values);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeNotIn(List<String> values) {
            return notIn(singleServicesFee, values);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeBetween(String value1, String value2) {
            return between(singleServicesFee, value1, value2);
        }

        public DaifaOrderExample.Criteria andSingleServicesFeeNotBetween(String value1, String value2) {
            return notBetween(singleServicesFee, value1, value2);
        }
        public DaifaOrderExample.Criteria andTotalServiceFeeIsNull() {
            return isNull(totalServiceFee);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeIsNotNull() {
            return isNotNull(totalServiceFee);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeEqualTo(String value) {
            return equalTo(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeNotEqualTo(String value) {
            return notEqualTo(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeGreaterThan(String value) {
            return greaterThan(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeLessThan(String value) {
            return lessThan(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeLike(String value) {
            return like(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeNotLike(String value) {
            return notLike(totalServiceFee, value);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeIn(List<String> values) {
            return in(totalServiceFee, values);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeNotIn(List<String> values) {
            return notIn(totalServiceFee, values);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeBetween(String value1, String value2) {
            return between(totalServiceFee, value1, value2);
        }

        public DaifaOrderExample.Criteria andTotalServiceFeeNotBetween(String value1, String value2) {
            return notBetween(totalServiceFee, value1, value2);
        }
        public DaifaOrderExample.Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public DaifaOrderExample.Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public DaifaOrderExample.Criteria andTotalFeeEqualTo(String value) {
            return equalTo(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeNotEqualTo(String value) {
            return notEqualTo(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeGreaterThan(String value) {
            return greaterThan(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeLessThan(String value) {
            return lessThan(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeLike(String value) {
            return like(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeNotLike(String value) {
            return notLike(totalFee, value);
        }

        public DaifaOrderExample.Criteria andTotalFeeIn(List<String> values) {
            return in(totalFee, values);
        }

        public DaifaOrderExample.Criteria andTotalFeeNotIn(List<String> values) {
            return notIn(totalFee, values);
        }

        public DaifaOrderExample.Criteria andTotalFeeBetween(String value1, String value2) {
            return between(totalFee, value1, value2);
        }

        public DaifaOrderExample.Criteria andTotalFeeNotBetween(String value1, String value2) {
            return notBetween(totalFee, value1, value2);
        }
        public DaifaOrderExample.Criteria andOrderStatusIsNull() {
            return isNull(orderStatus);
        }

        public DaifaOrderExample.Criteria andOrderStatusIsNotNull() {
            return isNotNull(orderStatus);
        }

        public DaifaOrderExample.Criteria andOrderStatusEqualTo(Long value) {
            return equalTo(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusNotEqualTo(Long value) {
            return notEqualTo(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusGreaterThan(Long value) {
            return greaterThan(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusLessThan(Long value) {
            return lessThan(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusLike(String value) {
            return like(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusNotLike(String value) {
            return notLike(orderStatus, value);
        }

        public DaifaOrderExample.Criteria andOrderStatusIn(List<Long> values) {
            return in(orderStatus, values);
        }

        public DaifaOrderExample.Criteria andOrderStatusNotIn(List<Long> values) {
            return notIn(orderStatus, values);
        }

        public DaifaOrderExample.Criteria andOrderStatusBetween(Long value1, Long value2) {
            return between(orderStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andOrderStatusNotBetween(Long value1, Long value2) {
            return notBetween(orderStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andAllocatStatusIsNull() {
            return isNull(allocatStatus);
        }

        public DaifaOrderExample.Criteria andAllocatStatusIsNotNull() {
            return isNotNull(allocatStatus);
        }

        public DaifaOrderExample.Criteria andAllocatStatusEqualTo(Integer value) {
            return equalTo(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusNotEqualTo(Integer value) {
            return notEqualTo(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusGreaterThan(Integer value) {
            return greaterThan(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusLessThan(Integer value) {
            return lessThan(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(allocatStatus, value);
        }

        public DaifaOrderExample.Criteria andAllocatStatusIn(List<Integer> values) {
            return in(allocatStatus, values);
        }

        public DaifaOrderExample.Criteria andAllocatStatusNotIn(List<Integer> values) {
            return notIn(allocatStatus, values);
        }

        public DaifaOrderExample.Criteria andAllocatStatusBetween(Integer value1, Integer value2) {
            return between(allocatStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andAllocatStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(allocatStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andAggrementIsNull() {
            return isNull(aggrement);
        }

        public DaifaOrderExample.Criteria andAggrementIsNotNull() {
            return isNotNull(aggrement);
        }

        public DaifaOrderExample.Criteria andAggrementEqualTo(Integer value) {
            return equalTo(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementNotEqualTo(Integer value) {
            return notEqualTo(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementGreaterThan(Integer value) {
            return greaterThan(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementLessThan(Integer value) {
            return lessThan(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(aggrement, value);
        }

        public DaifaOrderExample.Criteria andAggrementIn(List<Integer> values) {
            return in(aggrement, values);
        }

        public DaifaOrderExample.Criteria andAggrementNotIn(List<Integer> values) {
            return notIn(aggrement, values);
        }

        public DaifaOrderExample.Criteria andAggrementBetween(Integer value1, Integer value2) {
            return between(aggrement, value1, value2);
        }

        public DaifaOrderExample.Criteria andAggrementNotBetween(Integer value1, Integer value2) {
            return notBetween(aggrement, value1, value2);
        }
        public DaifaOrderExample.Criteria andPrintBarcodeStatusIsNull() {
            return isNull(printBarcodeStatus);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusIsNotNull() {
            return isNotNull(printBarcodeStatus);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusEqualTo(Integer value) {
            return equalTo(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusNotEqualTo(Integer value) {
            return notEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusGreaterThan(Integer value) {
            return greaterThan(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusLessThan(Integer value) {
            return lessThan(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printBarcodeStatus, value);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusIn(List<Integer> values) {
            return in(printBarcodeStatus, values);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusNotIn(List<Integer> values) {
            return notIn(printBarcodeStatus, values);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusBetween(Integer value1, Integer value2) {
            return between(printBarcodeStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andPrintBarcodeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printBarcodeStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andTakeGoodsStatusIsNull() {
            return isNull(takeGoodsStatus);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusIsNotNull() {
            return isNotNull(takeGoodsStatus);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusEqualTo(Integer value) {
            return equalTo(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusGreaterThan(Integer value) {
            return greaterThan(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusLessThan(Integer value) {
            return lessThan(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(takeGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusIn(List<Integer> values) {
            return in(takeGoodsStatus, values);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusNotIn(List<Integer> values) {
            return notIn(takeGoodsStatus, values);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusBetween(Integer value1, Integer value2) {
            return between(takeGoodsStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andTakeGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(takeGoodsStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andTakeGoodsDateIsNull() {
            return isNull(takeGoodsDate);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateIsNotNull() {
            return isNotNull(takeGoodsDate);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateEqualTo(Date value) {
            return equalTo(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateNotEqualTo(Date value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateGreaterThan(Date value) {
            return greaterThan(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateLessThan(Date value) {
            return lessThan(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateIn(List<Date> values) {
            return in(takeGoodsDate, values);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateNotIn(List<Date> values) {
            return notIn(takeGoodsDate, values);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateBetween(Date value1, Date value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public DaifaOrderExample.Criteria andTakeGoodsDateNotBetween(Date value1, Date value2) {
            return notBetween(takeGoodsDate, value1, value2);
        }
        public DaifaOrderExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaOrderExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaOrderExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaOrderExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaOrderExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaOrderExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaOrderExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaOrderExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaOrderExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaOrderExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaOrderExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaOrderExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaOrderExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaOrderExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaOrderExample.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaOrderExample.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaOrderExample.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaOrderExample.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andBarCodeKeyNumIsNull() {
            return isNull(barCodeKeyNum);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumIsNotNull() {
            return isNotNull(barCodeKeyNum);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumEqualTo(String value) {
            return equalTo(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumNotEqualTo(String value) {
            return notEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumGreaterThan(String value) {
            return greaterThan(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumLessThan(String value) {
            return lessThan(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumLike(String value) {
            return like(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumNotLike(String value) {
            return notLike(barCodeKeyNum, value);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumIn(List<String> values) {
            return in(barCodeKeyNum, values);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumNotIn(List<String> values) {
            return notIn(barCodeKeyNum, values);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumBetween(String value1, String value2) {
            return between(barCodeKeyNum, value1, value2);
        }

        public DaifaOrderExample.Criteria andBarCodeKeyNumNotBetween(String value1, String value2) {
            return notBetween(barCodeKeyNum, value1, value2);
        }
        public DaifaOrderExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaOrderExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaOrderExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaOrderExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaOrderExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaOrderExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaOrderExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaOrderExample.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaOrderExample.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaOrderExample.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaOrderExample.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaOrderExample.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaOrderExample.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaOrderExample.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public DaifaOrderExample.Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public DaifaOrderExample.Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public DaifaOrderExample.Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public DaifaOrderExample.Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public DaifaOrderExample.Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public DaifaOrderExample.Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public DaifaOrderExample.Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public DaifaOrderExample.Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andStockoutCycleStatusIsNull() {
            return isNull(stockoutCycleStatus);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusIsNotNull() {
            return isNotNull(stockoutCycleStatus);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusEqualTo(Integer value) {
            return equalTo(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusNotEqualTo(Integer value) {
            return notEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusGreaterThan(Integer value) {
            return greaterThan(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusLessThan(Integer value) {
            return lessThan(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockoutCycleStatus, value);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusIn(List<Integer> values) {
            return in(stockoutCycleStatus, values);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusNotIn(List<Integer> values) {
            return notIn(stockoutCycleStatus, values);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusBetween(Integer value1, Integer value2) {
            return between(stockoutCycleStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andStockoutCycleStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockoutCycleStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andOrderRemarkIsNull() {
            return isNull(orderRemark);
        }

        public DaifaOrderExample.Criteria andOrderRemarkIsNotNull() {
            return isNotNull(orderRemark);
        }

        public DaifaOrderExample.Criteria andOrderRemarkEqualTo(String value) {
            return equalTo(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkNotEqualTo(String value) {
            return notEqualTo(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkGreaterThan(String value) {
            return greaterThan(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkLessThan(String value) {
            return lessThan(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkLike(String value) {
            return like(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkNotLike(String value) {
            return notLike(orderRemark, value);
        }

        public DaifaOrderExample.Criteria andOrderRemarkIn(List<String> values) {
            return in(orderRemark, values);
        }

        public DaifaOrderExample.Criteria andOrderRemarkNotIn(List<String> values) {
            return notIn(orderRemark, values);
        }

        public DaifaOrderExample.Criteria andOrderRemarkBetween(String value1, String value2) {
            return between(orderRemark, value1, value2);
        }

        public DaifaOrderExample.Criteria andOrderRemarkNotBetween(String value1, String value2) {
            return notBetween(orderRemark, value1, value2);
        }
        public DaifaOrderExample.Criteria andGiftCodeIsNull() {
            return isNull(giftCode);
        }

        public DaifaOrderExample.Criteria andGiftCodeIsNotNull() {
            return isNotNull(giftCode);
        }

        public DaifaOrderExample.Criteria andGiftCodeEqualTo(String value) {
            return equalTo(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeNotEqualTo(String value) {
            return notEqualTo(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeGreaterThan(String value) {
            return greaterThan(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeLessThan(String value) {
            return lessThan(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeLike(String value) {
            return like(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeNotLike(String value) {
            return notLike(giftCode, value);
        }

        public DaifaOrderExample.Criteria andGiftCodeIn(List<String> values) {
            return in(giftCode, values);
        }

        public DaifaOrderExample.Criteria andGiftCodeNotIn(List<String> values) {
            return notIn(giftCode, values);
        }

        public DaifaOrderExample.Criteria andGiftCodeBetween(String value1, String value2) {
            return between(giftCode, value1, value2);
        }

        public DaifaOrderExample.Criteria andGiftCodeNotBetween(String value1, String value2) {
            return notBetween(giftCode, value1, value2);
        }
        public DaifaOrderExample.Criteria andHaveGoodsDateIsNull() {
            return isNull(haveGoodsDate);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateIsNotNull() {
            return isNotNull(haveGoodsDate);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateEqualTo(String value) {
            return equalTo(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateNotEqualTo(String value) {
            return notEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateGreaterThan(String value) {
            return greaterThan(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateLessThan(String value) {
            return lessThan(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateLike(String value) {
            return like(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateNotLike(String value) {
            return notLike(haveGoodsDate, value);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateIn(List<String> values) {
            return in(haveGoodsDate, values);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateNotIn(List<String> values) {
            return notIn(haveGoodsDate, values);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateBetween(String value1, String value2) {
            return between(haveGoodsDate, value1, value2);
        }

        public DaifaOrderExample.Criteria andHaveGoodsDateNotBetween(String value1, String value2) {
            return notBetween(haveGoodsDate, value1, value2);
        }
        public DaifaOrderExample.Criteria andDelistIsIsNull() {
            return isNull(delistIs);
        }

        public DaifaOrderExample.Criteria andDelistIsIsNotNull() {
            return isNotNull(delistIs);
        }

        public DaifaOrderExample.Criteria andDelistIsEqualTo(Integer value) {
            return equalTo(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsNotEqualTo(Integer value) {
            return notEqualTo(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsGreaterThan(Integer value) {
            return greaterThan(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsLessThan(Integer value) {
            return lessThan(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(delistIs, value);
        }

        public DaifaOrderExample.Criteria andDelistIsIn(List<Integer> values) {
            return in(delistIs, values);
        }

        public DaifaOrderExample.Criteria andDelistIsNotIn(List<Integer> values) {
            return notIn(delistIs, values);
        }

        public DaifaOrderExample.Criteria andDelistIsBetween(Integer value1, Integer value2) {
            return between(delistIs, value1, value2);
        }

        public DaifaOrderExample.Criteria andDelistIsNotBetween(Integer value1, Integer value2) {
            return notBetween(delistIs, value1, value2);
        }
        public DaifaOrderExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaOrderExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaOrderExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdLike(String value) {
            return like(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaOrderExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaOrderExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaOrderExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaOrderExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaOrderExample.Criteria andRefundStatusIsNull() {
            return isNull(refundStatus);
        }

        public DaifaOrderExample.Criteria andRefundStatusIsNotNull() {
            return isNotNull(refundStatus);
        }

        public DaifaOrderExample.Criteria andRefundStatusEqualTo(Integer value) {
            return equalTo(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusNotEqualTo(Integer value) {
            return notEqualTo(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusGreaterThan(Integer value) {
            return greaterThan(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusLessThan(Integer value) {
            return lessThan(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundStatus, value);
        }

        public DaifaOrderExample.Criteria andRefundStatusIn(List<Integer> values) {
            return in(refundStatus, values);
        }

        public DaifaOrderExample.Criteria andRefundStatusNotIn(List<Integer> values) {
            return notIn(refundStatus, values);
        }

        public DaifaOrderExample.Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            return between(refundStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(refundStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andRefundApplyTimeIsNull() {
            return isNull(refundApplyTime);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeIsNotNull() {
            return isNotNull(refundApplyTime);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeEqualTo(Date value) {
            return equalTo(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeNotEqualTo(Date value) {
            return notEqualTo(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeGreaterThan(Date value) {
            return greaterThan(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeLessThan(Date value) {
            return lessThan(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundApplyTime, value);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeIn(List<Date> values) {
            return in(refundApplyTime, values);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeNotIn(List<Date> values) {
            return notIn(refundApplyTime, values);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeBetween(Date value1, Date value2) {
            return between(refundApplyTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andRefundApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundApplyTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andReCauseIsNull() {
            return isNull(reCause);
        }

        public DaifaOrderExample.Criteria andReCauseIsNotNull() {
            return isNotNull(reCause);
        }

        public DaifaOrderExample.Criteria andReCauseEqualTo(String value) {
            return equalTo(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseNotEqualTo(String value) {
            return notEqualTo(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseGreaterThan(String value) {
            return greaterThan(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseLessThan(String value) {
            return lessThan(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseLike(String value) {
            return like(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseNotLike(String value) {
            return notLike(reCause, value);
        }

        public DaifaOrderExample.Criteria andReCauseIn(List<String> values) {
            return in(reCause, values);
        }

        public DaifaOrderExample.Criteria andReCauseNotIn(List<String> values) {
            return notIn(reCause, values);
        }

        public DaifaOrderExample.Criteria andReCauseBetween(String value1, String value2) {
            return between(reCause, value1, value2);
        }

        public DaifaOrderExample.Criteria andReCauseNotBetween(String value1, String value2) {
            return notBetween(reCause, value1, value2);
        }
        public DaifaOrderExample.Criteria andRefundFinishTimeIsNull() {
            return isNull(refundFinishTime);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeIsNotNull() {
            return isNotNull(refundFinishTime);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeEqualTo(Date value) {
            return equalTo(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeNotEqualTo(Date value) {
            return notEqualTo(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeGreaterThan(Date value) {
            return greaterThan(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeLessThan(Date value) {
            return lessThan(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundFinishTime, value);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeIn(List<Date> values) {
            return in(refundFinishTime, values);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeNotIn(List<Date> values) {
            return notIn(refundFinishTime, values);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeBetween(Date value1, Date value2) {
            return between(refundFinishTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andRefundFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundFinishTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andReturnGoodsStatusIsNull() {
            return isNull(returnGoodsStatus);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusIsNotNull() {
            return isNotNull(returnGoodsStatus);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusEqualTo(Integer value) {
            return equalTo(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusGreaterThan(Integer value) {
            return greaterThan(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusLessThan(Integer value) {
            return lessThan(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnGoodsStatus, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusIn(List<Integer> values) {
            return in(returnGoodsStatus, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusNotIn(List<Integer> values) {
            return notIn(returnGoodsStatus, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusBetween(Integer value1, Integer value2) {
            return between(returnGoodsStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andReturnGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnGoodsStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andReturnGoodsFeeIsNull() {
            return isNull(returnGoodsFee);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeIsNotNull() {
            return isNotNull(returnGoodsFee);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeEqualTo(String value) {
            return equalTo(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeNotEqualTo(String value) {
            return notEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeGreaterThan(String value) {
            return greaterThan(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeLessThan(String value) {
            return lessThan(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeLike(String value) {
            return like(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeNotLike(String value) {
            return notLike(returnGoodsFee, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeIn(List<String> values) {
            return in(returnGoodsFee, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeNotIn(List<String> values) {
            return notIn(returnGoodsFee, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeBetween(String value1, String value2) {
            return between(returnGoodsFee, value1, value2);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(returnGoodsFee, value1, value2);
        }
        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeIsNull() {
            return isNull(returnGoodsApplyTime);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeIsNotNull() {
            return isNotNull(returnGoodsApplyTime);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeEqualTo(Date value) {
            return equalTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeLessThan(Date value) {
            return lessThan(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeIn(List<Date> values) {
            return in(returnGoodsApplyTime, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeNotIn(List<Date> values) {
            return notIn(returnGoodsApplyTime, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeBetween(Date value1, Date value2) {
            return between(returnGoodsApplyTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andReturnGoodsApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsApplyTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeIsNull() {
            return isNull(returnGoodsFinishTime);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeIsNotNull() {
            return isNotNull(returnGoodsFinishTime);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeEqualTo(Date value) {
            return equalTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeLessThan(Date value) {
            return lessThan(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeIn(List<Date> values) {
            return in(returnGoodsFinishTime, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeNotIn(List<Date> values) {
            return notIn(returnGoodsFinishTime, values);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeBetween(Date value1, Date value2) {
            return between(returnGoodsFinishTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andReturnGoodsFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsFinishTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andChangeTimeIsNull() {
            return isNull(changeTime);
        }

        public DaifaOrderExample.Criteria andChangeTimeIsNotNull() {
            return isNotNull(changeTime);
        }

        public DaifaOrderExample.Criteria andChangeTimeEqualTo(Date value) {
            return equalTo(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeNotEqualTo(Date value) {
            return notEqualTo(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeGreaterThan(Date value) {
            return greaterThan(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeLessThan(Date value) {
            return lessThan(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(changeTime, value);
        }

        public DaifaOrderExample.Criteria andChangeTimeIn(List<Date> values) {
            return in(changeTime, values);
        }

        public DaifaOrderExample.Criteria andChangeTimeNotIn(List<Date> values) {
            return notIn(changeTime, values);
        }

        public DaifaOrderExample.Criteria andChangeTimeBetween(Date value1, Date value2) {
            return between(changeTime, value1, value2);
        }

        public DaifaOrderExample.Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            return notBetween(changeTime, value1, value2);
        }
        public DaifaOrderExample.Criteria andChangeStatusIsNull() {
            return isNull(changeStatus);
        }

        public DaifaOrderExample.Criteria andChangeStatusIsNotNull() {
            return isNotNull(changeStatus);
        }

        public DaifaOrderExample.Criteria andChangeStatusEqualTo(Integer value) {
            return equalTo(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusNotEqualTo(Integer value) {
            return notEqualTo(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusGreaterThan(Integer value) {
            return greaterThan(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusLessThan(Integer value) {
            return lessThan(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(changeStatus, value);
        }

        public DaifaOrderExample.Criteria andChangeStatusIn(List<Integer> values) {
            return in(changeStatus, values);
        }

        public DaifaOrderExample.Criteria andChangeStatusNotIn(List<Integer> values) {
            return notIn(changeStatus, values);
        }

        public DaifaOrderExample.Criteria andChangeStatusBetween(Integer value1, Integer value2) {
            return between(changeStatus, value1, value2);
        }

        public DaifaOrderExample.Criteria andChangeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(changeStatus, value1, value2);
        }
        public DaifaOrderExample.Criteria andChangeReasonIsNull() {
            return isNull(changeReason);
        }

        public DaifaOrderExample.Criteria andChangeReasonIsNotNull() {
            return isNotNull(changeReason);
        }

        public DaifaOrderExample.Criteria andChangeReasonEqualTo(String value) {
            return equalTo(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonNotEqualTo(String value) {
            return notEqualTo(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonGreaterThan(String value) {
            return greaterThan(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonLessThan(String value) {
            return lessThan(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonLike(String value) {
            return like(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonNotLike(String value) {
            return notLike(changeReason, value);
        }

        public DaifaOrderExample.Criteria andChangeReasonIn(List<String> values) {
            return in(changeReason, values);
        }

        public DaifaOrderExample.Criteria andChangeReasonNotIn(List<String> values) {
            return notIn(changeReason, values);
        }

        public DaifaOrderExample.Criteria andChangeReasonBetween(String value1, String value2) {
            return between(changeReason, value1, value2);
        }

        public DaifaOrderExample.Criteria andChangeReasonNotBetween(String value1, String value2) {
            return notBetween(changeReason, value1, value2);
        }
        public DaifaOrderExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaOrderExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaOrderExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaOrderExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaOrderExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaOrderExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaOrderExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaOrderExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaOrderExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaOrderExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaOrderExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaOrderExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaOrderExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaOrderExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }

        //////
        public DaifaOrderExample.Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public DaifaOrderExample.Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public DaifaOrderExample.Criteria andGoodsWeightEqualTo(String value) {
            return equalTo(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightNotEqualTo(String value) {
            return notEqualTo(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightGreaterThan(String value) {
            return greaterThan(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightLessThan(String value) {
            return lessThan(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightLike(String value) {
            return like(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightNotLike(String value) {
            return notLike(goodsWeight, value);
        }

        public DaifaOrderExample.Criteria andGoodsWeightIn(List<String> values) {
            return in(goodsWeight, values);
        }

        public DaifaOrderExample.Criteria andGoodsWeightNotIn(List<String> values) {
            return notIn(goodsWeight, values);
        }

        public DaifaOrderExample.Criteria andGoodsWeightBetween(String value1, String value2) {
            return between(goodsWeight, value1, value2);
        }

        public DaifaOrderExample.Criteria andGoodsWeightNotBetween(String value1, String value2) {
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