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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
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
        public Criteria andCidIsNull() {
            return isNull(cid);
        }

        public Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public Criteria andCidLike(String value) {
            return like(cid, value);
        }

        public Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
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
        public Criteria andSinglePayIsNull() {
            return isNull(singlePay);
        }

        public Criteria andSinglePayIsNotNull() {
            return isNotNull(singlePay);
        }

        public Criteria andSinglePayEqualTo(String value) {
            return equalTo(singlePay, value);
        }

        public Criteria andSinglePayNotEqualTo(String value) {
            return notEqualTo(singlePay, value);
        }

        public Criteria andSinglePayGreaterThan(String value) {
            return greaterThan(singlePay, value);
        }

        public Criteria andSinglePayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singlePay, value);
        }

        public Criteria andSinglePayLessThan(String value) {
            return lessThan(singlePay, value);
        }

        public Criteria andSinglePayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singlePay, value);
        }

        public Criteria andSinglePayLike(String value) {
            return like(singlePay, value);
        }

        public Criteria andSinglePayNotLike(String value) {
            return notLike(singlePay, value);
        }

        public Criteria andSinglePayIn(List<String> values) {
            return in(singlePay, values);
        }

        public Criteria andSinglePayNotIn(List<String> values) {
            return notIn(singlePay, values);
        }

        public Criteria andSinglePayBetween(String value1, String value2) {
            return between(singlePay, value1, value2);
        }

        public Criteria andSinglePayNotBetween(String value1, String value2) {
            return notBetween(singlePay, value1, value2);
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
        public Criteria andOrderDiscountFeeIsNull() {
            return isNull(orderDiscountFee);
        }

        public Criteria andOrderDiscountFeeIsNotNull() {
            return isNotNull(orderDiscountFee);
        }

        public Criteria andOrderDiscountFeeEqualTo(String value) {
            return equalTo(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeNotEqualTo(String value) {
            return notEqualTo(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeGreaterThan(String value) {
            return greaterThan(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeLessThan(String value) {
            return lessThan(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeLike(String value) {
            return like(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeNotLike(String value) {
            return notLike(orderDiscountFee, value);
        }

        public Criteria andOrderDiscountFeeIn(List<String> values) {
            return in(orderDiscountFee, values);
        }

        public Criteria andOrderDiscountFeeNotIn(List<String> values) {
            return notIn(orderDiscountFee, values);
        }

        public Criteria andOrderDiscountFeeBetween(String value1, String value2) {
            return between(orderDiscountFee, value1, value2);
        }

        public Criteria andOrderDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(orderDiscountFee, value1, value2);
        }
        public Criteria andSingleServicesFeeIsNull() {
            return isNull(singleServicesFee);
        }

        public Criteria andSingleServicesFeeIsNotNull() {
            return isNotNull(singleServicesFee);
        }

        public Criteria andSingleServicesFeeEqualTo(String value) {
            return equalTo(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeNotEqualTo(String value) {
            return notEqualTo(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeGreaterThan(String value) {
            return greaterThan(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeLessThan(String value) {
            return lessThan(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeLike(String value) {
            return like(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeNotLike(String value) {
            return notLike(singleServicesFee, value);
        }

        public Criteria andSingleServicesFeeIn(List<String> values) {
            return in(singleServicesFee, values);
        }

        public Criteria andSingleServicesFeeNotIn(List<String> values) {
            return notIn(singleServicesFee, values);
        }

        public Criteria andSingleServicesFeeBetween(String value1, String value2) {
            return between(singleServicesFee, value1, value2);
        }

        public Criteria andSingleServicesFeeNotBetween(String value1, String value2) {
            return notBetween(singleServicesFee, value1, value2);
        }
        public Criteria andTotalServiceFeeIsNull() {
            return isNull(totalServiceFee);
        }

        public Criteria andTotalServiceFeeIsNotNull() {
            return isNotNull(totalServiceFee);
        }

        public Criteria andTotalServiceFeeEqualTo(String value) {
            return equalTo(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeNotEqualTo(String value) {
            return notEqualTo(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeGreaterThan(String value) {
            return greaterThan(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeLessThan(String value) {
            return lessThan(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeLike(String value) {
            return like(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeNotLike(String value) {
            return notLike(totalServiceFee, value);
        }

        public Criteria andTotalServiceFeeIn(List<String> values) {
            return in(totalServiceFee, values);
        }

        public Criteria andTotalServiceFeeNotIn(List<String> values) {
            return notIn(totalServiceFee, values);
        }

        public Criteria andTotalServiceFeeBetween(String value1, String value2) {
            return between(totalServiceFee, value1, value2);
        }

        public Criteria andTotalServiceFeeNotBetween(String value1, String value2) {
            return notBetween(totalServiceFee, value1, value2);
        }
        public Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public Criteria andTotalFeeEqualTo(String value) {
            return equalTo(totalFee, value);
        }

        public Criteria andTotalFeeNotEqualTo(String value) {
            return notEqualTo(totalFee, value);
        }

        public Criteria andTotalFeeGreaterThan(String value) {
            return greaterThan(totalFee, value);
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public Criteria andTotalFeeLessThan(String value) {
            return lessThan(totalFee, value);
        }

        public Criteria andTotalFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public Criteria andTotalFeeLike(String value) {
            return like(totalFee, value);
        }

        public Criteria andTotalFeeNotLike(String value) {
            return notLike(totalFee, value);
        }

        public Criteria andTotalFeeIn(List<String> values) {
            return in(totalFee, values);
        }

        public Criteria andTotalFeeNotIn(List<String> values) {
            return notIn(totalFee, values);
        }

        public Criteria andTotalFeeBetween(String value1, String value2) {
            return between(totalFee, value1, value2);
        }

        public Criteria andTotalFeeNotBetween(String value1, String value2) {
            return notBetween(totalFee, value1, value2);
        }
        public Criteria andOrderStatusIsNull() {
            return isNull(orderStatus);
        }

        public Criteria andOrderStatusIsNotNull() {
            return isNotNull(orderStatus);
        }

        public Criteria andOrderStatusEqualTo(Long value) {
            return equalTo(orderStatus, value);
        }

        public Criteria andOrderStatusNotEqualTo(Long value) {
            return notEqualTo(orderStatus, value);
        }

        public Criteria andOrderStatusGreaterThan(Long value) {
            return greaterThan(orderStatus, value);
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(orderStatus, value);
        }

        public Criteria andOrderStatusLessThan(Long value) {
            return lessThan(orderStatus, value);
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(orderStatus, value);
        }

        public Criteria andOrderStatusLike(String value) {
            return like(orderStatus, value);
        }

        public Criteria andOrderStatusNotLike(String value) {
            return notLike(orderStatus, value);
        }

        public Criteria andOrderStatusIn(List<Long> values) {
            return in(orderStatus, values);
        }

        public Criteria andOrderStatusNotIn(List<Long> values) {
            return notIn(orderStatus, values);
        }

        public Criteria andOrderStatusBetween(Long value1, Long value2) {
            return between(orderStatus, value1, value2);
        }

        public Criteria andOrderStatusNotBetween(Long value1, Long value2) {
            return notBetween(orderStatus, value1, value2);
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

        public Criteria andTakeGoodsDateEqualTo(Date value) {
            return equalTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateNotEqualTo(Date value) {
            return notEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateGreaterThan(Date value) {
            return greaterThan(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateLessThan(Date value) {
            return lessThan(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(takeGoodsDate, value);
        }

        public Criteria andTakeGoodsDateIn(List<Date> values) {
            return in(takeGoodsDate, values);
        }

        public Criteria andTakeGoodsDateNotIn(List<Date> values) {
            return notIn(takeGoodsDate, values);
        }

        public Criteria andTakeGoodsDateBetween(Date value1, Date value2) {
            return between(takeGoodsDate, value1, value2);
        }

        public Criteria andTakeGoodsDateNotBetween(Date value1, Date value2) {
            return notBetween(takeGoodsDate, value1, value2);
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
        public Criteria andBarCodeKeyNumIsNull() {
            return isNull(barCodeKeyNum);
        }

        public Criteria andBarCodeKeyNumIsNotNull() {
            return isNotNull(barCodeKeyNum);
        }

        public Criteria andBarCodeKeyNumEqualTo(String value) {
            return equalTo(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumNotEqualTo(String value) {
            return notEqualTo(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumGreaterThan(String value) {
            return greaterThan(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumLessThan(String value) {
            return lessThan(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumLike(String value) {
            return like(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumNotLike(String value) {
            return notLike(barCodeKeyNum, value);
        }

        public Criteria andBarCodeKeyNumIn(List<String> values) {
            return in(barCodeKeyNum, values);
        }

        public Criteria andBarCodeKeyNumNotIn(List<String> values) {
            return notIn(barCodeKeyNum, values);
        }

        public Criteria andBarCodeKeyNumBetween(String value1, String value2) {
            return between(barCodeKeyNum, value1, value2);
        }

        public Criteria andBarCodeKeyNumNotBetween(String value1, String value2) {
            return notBetween(barCodeKeyNum, value1, value2);
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
        public Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public Criteria andStockoutCycleStatusIsNull() {
            return isNull(stockoutCycleStatus);
        }

        public Criteria andStockoutCycleStatusIsNotNull() {
            return isNotNull(stockoutCycleStatus);
        }

        public Criteria andStockoutCycleStatusEqualTo(Integer value) {
            return equalTo(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusNotEqualTo(Integer value) {
            return notEqualTo(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusGreaterThan(Integer value) {
            return greaterThan(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusLessThan(Integer value) {
            return lessThan(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockoutCycleStatus, value);
        }

        public Criteria andStockoutCycleStatusIn(List<Integer> values) {
            return in(stockoutCycleStatus, values);
        }

        public Criteria andStockoutCycleStatusNotIn(List<Integer> values) {
            return notIn(stockoutCycleStatus, values);
        }

        public Criteria andStockoutCycleStatusBetween(Integer value1, Integer value2) {
            return between(stockoutCycleStatus, value1, value2);
        }

        public Criteria andStockoutCycleStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockoutCycleStatus, value1, value2);
        }
        public Criteria andOrderRemarkIsNull() {
            return isNull(orderRemark);
        }

        public Criteria andOrderRemarkIsNotNull() {
            return isNotNull(orderRemark);
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            return equalTo(orderRemark, value);
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            return notEqualTo(orderRemark, value);
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            return greaterThan(orderRemark, value);
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderRemark, value);
        }

        public Criteria andOrderRemarkLessThan(String value) {
            return lessThan(orderRemark, value);
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderRemark, value);
        }

        public Criteria andOrderRemarkLike(String value) {
            return like(orderRemark, value);
        }

        public Criteria andOrderRemarkNotLike(String value) {
            return notLike(orderRemark, value);
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            return in(orderRemark, values);
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            return notIn(orderRemark, values);
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            return between(orderRemark, value1, value2);
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            return notBetween(orderRemark, value1, value2);
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
        public Criteria andHaveGoodsDateIsNull() {
            return isNull(haveGoodsDate);
        }

        public Criteria andHaveGoodsDateIsNotNull() {
            return isNotNull(haveGoodsDate);
        }

        public Criteria andHaveGoodsDateEqualTo(String value) {
            return equalTo(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateNotEqualTo(String value) {
            return notEqualTo(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateGreaterThan(String value) {
            return greaterThan(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateLessThan(String value) {
            return lessThan(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateLike(String value) {
            return like(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateNotLike(String value) {
            return notLike(haveGoodsDate, value);
        }

        public Criteria andHaveGoodsDateIn(List<String> values) {
            return in(haveGoodsDate, values);
        }

        public Criteria andHaveGoodsDateNotIn(List<String> values) {
            return notIn(haveGoodsDate, values);
        }

        public Criteria andHaveGoodsDateBetween(String value1, String value2) {
            return between(haveGoodsDate, value1, value2);
        }

        public Criteria andHaveGoodsDateNotBetween(String value1, String value2) {
            return notBetween(haveGoodsDate, value1, value2);
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
        public Criteria andRefundStatusIsNull() {
            return isNull(refundStatus);
        }

        public Criteria andRefundStatusIsNotNull() {
            return isNotNull(refundStatus);
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            return equalTo(refundStatus, value);
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            return notEqualTo(refundStatus, value);
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            return greaterThan(refundStatus, value);
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundStatus, value);
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            return lessThan(refundStatus, value);
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundStatus, value);
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            return in(refundStatus, values);
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            return notIn(refundStatus, values);
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            return between(refundStatus, value1, value2);
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(refundStatus, value1, value2);
        }
        public Criteria andRefundApplyTimeIsNull() {
            return isNull(refundApplyTime);
        }

        public Criteria andRefundApplyTimeIsNotNull() {
            return isNotNull(refundApplyTime);
        }

        public Criteria andRefundApplyTimeEqualTo(Date value) {
            return equalTo(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeNotEqualTo(Date value) {
            return notEqualTo(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeGreaterThan(Date value) {
            return greaterThan(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeLessThan(Date value) {
            return lessThan(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundApplyTime, value);
        }

        public Criteria andRefundApplyTimeIn(List<Date> values) {
            return in(refundApplyTime, values);
        }

        public Criteria andRefundApplyTimeNotIn(List<Date> values) {
            return notIn(refundApplyTime, values);
        }

        public Criteria andRefundApplyTimeBetween(Date value1, Date value2) {
            return between(refundApplyTime, value1, value2);
        }

        public Criteria andRefundApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundApplyTime, value1, value2);
        }
        public Criteria andReCauseIsNull() {
            return isNull(reCause);
        }

        public Criteria andReCauseIsNotNull() {
            return isNotNull(reCause);
        }

        public Criteria andReCauseEqualTo(String value) {
            return equalTo(reCause, value);
        }

        public Criteria andReCauseNotEqualTo(String value) {
            return notEqualTo(reCause, value);
        }

        public Criteria andReCauseGreaterThan(String value) {
            return greaterThan(reCause, value);
        }

        public Criteria andReCauseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reCause, value);
        }

        public Criteria andReCauseLessThan(String value) {
            return lessThan(reCause, value);
        }

        public Criteria andReCauseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reCause, value);
        }

        public Criteria andReCauseLike(String value) {
            return like(reCause, value);
        }

        public Criteria andReCauseNotLike(String value) {
            return notLike(reCause, value);
        }

        public Criteria andReCauseIn(List<String> values) {
            return in(reCause, values);
        }

        public Criteria andReCauseNotIn(List<String> values) {
            return notIn(reCause, values);
        }

        public Criteria andReCauseBetween(String value1, String value2) {
            return between(reCause, value1, value2);
        }

        public Criteria andReCauseNotBetween(String value1, String value2) {
            return notBetween(reCause, value1, value2);
        }
        public Criteria andRefundFinishTimeIsNull() {
            return isNull(refundFinishTime);
        }

        public Criteria andRefundFinishTimeIsNotNull() {
            return isNotNull(refundFinishTime);
        }

        public Criteria andRefundFinishTimeEqualTo(Date value) {
            return equalTo(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeNotEqualTo(Date value) {
            return notEqualTo(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeGreaterThan(Date value) {
            return greaterThan(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeLessThan(Date value) {
            return lessThan(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refundFinishTime, value);
        }

        public Criteria andRefundFinishTimeIn(List<Date> values) {
            return in(refundFinishTime, values);
        }

        public Criteria andRefundFinishTimeNotIn(List<Date> values) {
            return notIn(refundFinishTime, values);
        }

        public Criteria andRefundFinishTimeBetween(Date value1, Date value2) {
            return between(refundFinishTime, value1, value2);
        }

        public Criteria andRefundFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(refundFinishTime, value1, value2);
        }
        public Criteria andReturnGoodsStatusIsNull() {
            return isNull(returnGoodsStatus);
        }

        public Criteria andReturnGoodsStatusIsNotNull() {
            return isNotNull(returnGoodsStatus);
        }

        public Criteria andReturnGoodsStatusEqualTo(Integer value) {
            return equalTo(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusGreaterThan(Integer value) {
            return greaterThan(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusLessThan(Integer value) {
            return lessThan(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(returnGoodsStatus, value);
        }

        public Criteria andReturnGoodsStatusIn(List<Integer> values) {
            return in(returnGoodsStatus, values);
        }

        public Criteria andReturnGoodsStatusNotIn(List<Integer> values) {
            return notIn(returnGoodsStatus, values);
        }

        public Criteria andReturnGoodsStatusBetween(Integer value1, Integer value2) {
            return between(returnGoodsStatus, value1, value2);
        }

        public Criteria andReturnGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(returnGoodsStatus, value1, value2);
        }
        public Criteria andReturnGoodsFeeIsNull() {
            return isNull(returnGoodsFee);
        }

        public Criteria andReturnGoodsFeeIsNotNull() {
            return isNotNull(returnGoodsFee);
        }

        public Criteria andReturnGoodsFeeEqualTo(String value) {
            return equalTo(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeNotEqualTo(String value) {
            return notEqualTo(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeGreaterThan(String value) {
            return greaterThan(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeLessThan(String value) {
            return lessThan(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeLike(String value) {
            return like(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeNotLike(String value) {
            return notLike(returnGoodsFee, value);
        }

        public Criteria andReturnGoodsFeeIn(List<String> values) {
            return in(returnGoodsFee, values);
        }

        public Criteria andReturnGoodsFeeNotIn(List<String> values) {
            return notIn(returnGoodsFee, values);
        }

        public Criteria andReturnGoodsFeeBetween(String value1, String value2) {
            return between(returnGoodsFee, value1, value2);
        }

        public Criteria andReturnGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(returnGoodsFee, value1, value2);
        }
        public Criteria andReturnGoodsApplyTimeIsNull() {
            return isNull(returnGoodsApplyTime);
        }

        public Criteria andReturnGoodsApplyTimeIsNotNull() {
            return isNotNull(returnGoodsApplyTime);
        }

        public Criteria andReturnGoodsApplyTimeEqualTo(Date value) {
            return equalTo(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeLessThan(Date value) {
            return lessThan(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsApplyTime, value);
        }

        public Criteria andReturnGoodsApplyTimeIn(List<Date> values) {
            return in(returnGoodsApplyTime, values);
        }

        public Criteria andReturnGoodsApplyTimeNotIn(List<Date> values) {
            return notIn(returnGoodsApplyTime, values);
        }

        public Criteria andReturnGoodsApplyTimeBetween(Date value1, Date value2) {
            return between(returnGoodsApplyTime, value1, value2);
        }

        public Criteria andReturnGoodsApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsApplyTime, value1, value2);
        }
        public Criteria andReturnGoodsFinishTimeIsNull() {
            return isNull(returnGoodsFinishTime);
        }

        public Criteria andReturnGoodsFinishTimeIsNotNull() {
            return isNotNull(returnGoodsFinishTime);
        }

        public Criteria andReturnGoodsFinishTimeEqualTo(Date value) {
            return equalTo(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeNotEqualTo(Date value) {
            return notEqualTo(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeGreaterThan(Date value) {
            return greaterThan(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeLessThan(Date value) {
            return lessThan(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnGoodsFinishTime, value);
        }

        public Criteria andReturnGoodsFinishTimeIn(List<Date> values) {
            return in(returnGoodsFinishTime, values);
        }

        public Criteria andReturnGoodsFinishTimeNotIn(List<Date> values) {
            return notIn(returnGoodsFinishTime, values);
        }

        public Criteria andReturnGoodsFinishTimeBetween(Date value1, Date value2) {
            return between(returnGoodsFinishTime, value1, value2);
        }

        public Criteria andReturnGoodsFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnGoodsFinishTime, value1, value2);
        }
        public Criteria andChangeTimeIsNull() {
            return isNull(changeTime);
        }

        public Criteria andChangeTimeIsNotNull() {
            return isNotNull(changeTime);
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            return equalTo(changeTime, value);
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            return notEqualTo(changeTime, value);
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            return greaterThan(changeTime, value);
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(changeTime, value);
        }

        public Criteria andChangeTimeLessThan(Date value) {
            return lessThan(changeTime, value);
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(changeTime, value);
        }

        public Criteria andChangeTimeIn(List<Date> values) {
            return in(changeTime, values);
        }

        public Criteria andChangeTimeNotIn(List<Date> values) {
            return notIn(changeTime, values);
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            return between(changeTime, value1, value2);
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            return notBetween(changeTime, value1, value2);
        }
        public Criteria andChangeStatusIsNull() {
            return isNull(changeStatus);
        }

        public Criteria andChangeStatusIsNotNull() {
            return isNotNull(changeStatus);
        }

        public Criteria andChangeStatusEqualTo(Integer value) {
            return equalTo(changeStatus, value);
        }

        public Criteria andChangeStatusNotEqualTo(Integer value) {
            return notEqualTo(changeStatus, value);
        }

        public Criteria andChangeStatusGreaterThan(Integer value) {
            return greaterThan(changeStatus, value);
        }

        public Criteria andChangeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(changeStatus, value);
        }

        public Criteria andChangeStatusLessThan(Integer value) {
            return lessThan(changeStatus, value);
        }

        public Criteria andChangeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(changeStatus, value);
        }

        public Criteria andChangeStatusIn(List<Integer> values) {
            return in(changeStatus, values);
        }

        public Criteria andChangeStatusNotIn(List<Integer> values) {
            return notIn(changeStatus, values);
        }

        public Criteria andChangeStatusBetween(Integer value1, Integer value2) {
            return between(changeStatus, value1, value2);
        }

        public Criteria andChangeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(changeStatus, value1, value2);
        }
        public Criteria andChangeReasonIsNull() {
            return isNull(changeReason);
        }

        public Criteria andChangeReasonIsNotNull() {
            return isNotNull(changeReason);
        }

        public Criteria andChangeReasonEqualTo(String value) {
            return equalTo(changeReason, value);
        }

        public Criteria andChangeReasonNotEqualTo(String value) {
            return notEqualTo(changeReason, value);
        }

        public Criteria andChangeReasonGreaterThan(String value) {
            return greaterThan(changeReason, value);
        }

        public Criteria andChangeReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(changeReason, value);
        }

        public Criteria andChangeReasonLessThan(String value) {
            return lessThan(changeReason, value);
        }

        public Criteria andChangeReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(changeReason, value);
        }

        public Criteria andChangeReasonLike(String value) {
            return like(changeReason, value);
        }

        public Criteria andChangeReasonNotLike(String value) {
            return notLike(changeReason, value);
        }

        public Criteria andChangeReasonIn(List<String> values) {
            return in(changeReason, values);
        }

        public Criteria andChangeReasonNotIn(List<String> values) {
            return notIn(changeReason, values);
        }

        public Criteria andChangeReasonBetween(String value1, String value2) {
            return between(changeReason, value1, value2);
        }

        public Criteria andChangeReasonNotBetween(String value1, String value2) {
            return notBetween(changeReason, value1, value2);
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

        //////
        public Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public Criteria andGoodsWeightEqualTo(String value) {
            return equalTo(goodsWeight, value);
        }

        public Criteria andGoodsWeightNotEqualTo(String value) {
            return notEqualTo(goodsWeight, value);
        }

        public Criteria andGoodsWeightGreaterThan(String value) {
            return greaterThan(goodsWeight, value);
        }

        public Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public Criteria andGoodsWeightLessThan(String value) {
            return lessThan(goodsWeight, value);
        }

        public Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public Criteria andGoodsWeightLike(String value) {
            return like(goodsWeight, value);
        }

        public Criteria andGoodsWeightNotLike(String value) {
            return notLike(goodsWeight, value);
        }

        public Criteria andGoodsWeightIn(List<String> values) {
            return in(goodsWeight, values);
        }

        public Criteria andGoodsWeightNotIn(List<String> values) {
            return notIn(goodsWeight, values);
        }

        public Criteria andGoodsWeightBetween(String value1, String value2) {
            return between(goodsWeight, value1, value2);
        }

        public Criteria andGoodsWeightNotBetween(String value1, String value2) {
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