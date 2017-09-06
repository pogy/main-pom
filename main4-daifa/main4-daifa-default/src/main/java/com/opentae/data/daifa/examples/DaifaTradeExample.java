package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaTrade;

import java.util.*;

public class DaifaTradeExample extends SgExample<DaifaTradeExample.Criteria> {
    public static final Class<DaifaTrade> beanClass = DaifaTrade.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dfTradeId;
    public static EntityColumn sellerId;
    public static EntityColumn goodsNum;
    public static EntityColumn goodsWeight;
    public static EntityColumn goodsVolume;
    public static EntityColumn receiverName;
    public static EntityColumn receiverPhone;
    public static EntityColumn receiverState;
    public static EntityColumn receiverAddress;
    public static EntityColumn daifaType;
    public static EntityColumn expressId;
    public static EntityColumn expressName;
    public static EntityColumn expressCode;
    public static EntityColumn tradeStatus;
    public static EntityColumn goodsFee;
    public static EntityColumn expressFee;
    public static EntityColumn servicesFee;
    public static EntityColumn tradeDiscountFee;
    public static EntityColumn totalFee;
    public static EntityColumn money;
    public static EntityColumn realPayMoney;
    public static EntityColumn barCodeKey;
    public static EntityColumn tradeCode;
    public static EntityColumn createTime;
    public static EntityColumn lastDoTime;
    public static EntityColumn sendTime;
    public static EntityColumn finishTime;
    public static EntityColumn sendStatus;
    public static EntityColumn closeTime;
    public static EntityColumn buyerRemark;
    public static EntityColumn buyerId;
    public static EntityColumn buyerName;
    public static EntityColumn buyerWw;
    public static EntityColumn printExpressStatus;
    public static EntityColumn receiverZip;
    public static EntityColumn receiverMobile;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn taobaoTid;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWx;
    public static EntityColumn buyerTelephone;
    public static EntityColumn sellerName;
    public static EntityColumn payStatus;
    public static EntityColumn payTime;
    public static EntityColumn receiverQq;
    public static EntityColumn buyerNick;
    public static EntityColumn isOld;

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfTradeId = listMap.get("dfTradeId");
        sellerId = listMap.get("sellerId");
        goodsNum = listMap.get("goodsNum");
        goodsWeight = listMap.get("goodsWeight");
        goodsVolume = listMap.get("goodsVolume");
        receiverName = listMap.get("receiverName");
        receiverPhone = listMap.get("receiverPhone");
        receiverState = listMap.get("receiverState");
        receiverAddress = listMap.get("receiverAddress");
        daifaType = listMap.get("daifaType");
        expressId = listMap.get("expressId");
        expressName = listMap.get("expressName");
        expressCode = listMap.get("expressCode");
        tradeStatus = listMap.get("tradeStatus");
        goodsFee = listMap.get("goodsFee");
        expressFee = listMap.get("expressFee");
        servicesFee = listMap.get("servicesFee");
        tradeDiscountFee = listMap.get("tradeDiscountFee");
        totalFee = listMap.get("totalFee");
        money = listMap.get("money");
        realPayMoney = listMap.get("realPayMoney");
        barCodeKey = listMap.get("barCodeKey");
        tradeCode = listMap.get("tradeCode");
        createTime = listMap.get("createTime");
        lastDoTime = listMap.get("lastDoTime");
        sendTime = listMap.get("sendTime");
        finishTime = listMap.get("finishTime");
        sendStatus = listMap.get("sendStatus");
        closeTime = listMap.get("closeTime");
        buyerRemark = listMap.get("buyerRemark");
        buyerId = listMap.get("buyerId");
        buyerName = listMap.get("buyerName");
        buyerWw = listMap.get("buyerWw");
        printExpressStatus = listMap.get("printExpressStatus");
        receiverZip = listMap.get("receiverZip");
        receiverMobile = listMap.get("receiverMobile");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        taobaoTid = listMap.get("taobaoTid");
        taobaoUserNick = listMap.get("taobaoUserNick");
        buyerQq = listMap.get("buyerQq");
        buyerWx = listMap.get("buyerWx");
        buyerTelephone = listMap.get("buyerTelephone");
        sellerName = listMap.get("sellerName");
        payStatus = listMap.get("payStatus");
        payTime = listMap.get("payTime");
        receiverQq = listMap.get("receiverQq");
        buyerNick = listMap.get("buyerNick");
        isOld=listMap.get ("isOld");
    }

    public DaifaTradeExample() {
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
        public Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public Criteria andGoodsNumEqualTo(Long value) {
            return equalTo(goodsNum, value);
        }

        public Criteria andGoodsNumNotEqualTo(Long value) {
            return notEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumGreaterThan(Long value) {
            return greaterThan(goodsNum, value);
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumLessThan(Long value) {
            return lessThan(goodsNum, value);
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public Criteria andGoodsNumLike(String value) {
            return like(goodsNum, value);
        }

        public Criteria andGoodsNumNotLike(String value) {
            return notLike(goodsNum, value);
        }

        public Criteria andGoodsNumIn(List<Long> values) {
            return in(goodsNum, values);
        }

        public Criteria andGoodsNumNotIn(List<Long> values) {
            return notIn(goodsNum, values);
        }

        public Criteria andGoodsNumBetween(Long value1, Long value2) {
            return between(goodsNum, value1, value2);
        }

        public Criteria andGoodsNumNotBetween(Long value1, Long value2) {
            return notBetween(goodsNum, value1, value2);
        }
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
        public Criteria andGoodsVolumeIsNull() {
            return isNull(goodsVolume);
        }

        public Criteria andGoodsVolumeIsNotNull() {
            return isNotNull(goodsVolume);
        }

        public Criteria andGoodsVolumeEqualTo(String value) {
            return equalTo(goodsVolume, value);
        }

        public Criteria andGoodsVolumeNotEqualTo(String value) {
            return notEqualTo(goodsVolume, value);
        }

        public Criteria andGoodsVolumeGreaterThan(String value) {
            return greaterThan(goodsVolume, value);
        }

        public Criteria andGoodsVolumeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsVolume, value);
        }

        public Criteria andGoodsVolumeLessThan(String value) {
            return lessThan(goodsVolume, value);
        }

        public Criteria andGoodsVolumeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsVolume, value);
        }

        public Criteria andGoodsVolumeLike(String value) {
            return like(goodsVolume, value);
        }

        public Criteria andGoodsVolumeNotLike(String value) {
            return notLike(goodsVolume, value);
        }

        public Criteria andGoodsVolumeIn(List<String> values) {
            return in(goodsVolume, values);
        }

        public Criteria andGoodsVolumeNotIn(List<String> values) {
            return notIn(goodsVolume, values);
        }

        public Criteria andGoodsVolumeBetween(String value1, String value2) {
            return between(goodsVolume, value1, value2);
        }

        public Criteria andGoodsVolumeNotBetween(String value1, String value2) {
            return notBetween(goodsVolume, value1, value2);
        }
        public Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public Criteria andDaifaTypeIsNull() {
            return isNull(daifaType);
        }

        public Criteria andDaifaTypeIsNotNull() {
            return isNotNull(daifaType);
        }

        public Criteria andDaifaTypeEqualTo(Integer value) {
            return equalTo(daifaType, value);
        }

        public Criteria andDaifaTypeNotEqualTo(Integer value) {
            return notEqualTo(daifaType, value);
        }

        public Criteria andDaifaTypeGreaterThan(Integer value) {
            return greaterThan(daifaType, value);
        }

        public Criteria andDaifaTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(daifaType, value);
        }

        public Criteria andDaifaTypeLessThan(Integer value) {
            return lessThan(daifaType, value);
        }

        public Criteria andDaifaTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(daifaType, value);
        }

        public Criteria andDaifaTypeIn(List<Integer> values) {
            return in(daifaType, values);
        }

        public Criteria andDaifaTypeNotIn(List<Integer> values) {
            return notIn(daifaType, values);
        }

        public Criteria andDaifaTypeBetween(Integer value1, Integer value2) {
            return between(daifaType, value1, value2);
        }

        public Criteria andDaifaTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(daifaType, value1, value2);
        }
        public Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdLike(String value) {
            return like(expressId, value);
        }

        public Criteria andExpressIdNotLike(String value) {
            return notLike(expressId, value);
        }

        public Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public Criteria andTradeStatusIsNull() {
            return isNull(tradeStatus);
        }

        public Criteria andTradeStatusIsNotNull() {
            return isNotNull(tradeStatus);
        }

        public Criteria andTradeStatusEqualTo(Integer value) {
            return equalTo(tradeStatus, value);
        }

        public Criteria andTradeStatusNotEqualTo(Integer value) {
            return notEqualTo(tradeStatus, value);
        }

        public Criteria andTradeStatusGreaterThan(Integer value) {
            return greaterThan(tradeStatus, value);
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(tradeStatus, value);
        }

        public Criteria andTradeStatusLessThan(Integer value) {
            return lessThan(tradeStatus, value);
        }

        public Criteria andTradeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(tradeStatus, value);
        }

        public Criteria andTradeStatusIn(List<Integer> values) {
            return in(tradeStatus, values);
        }

        public Criteria andTradeStatusNotIn(List<Integer> values) {
            return notIn(tradeStatus, values);
        }

        public Criteria andTradeStatusBetween(Integer value1, Integer value2) {
            return between(tradeStatus, value1, value2);
        }

        public Criteria andTradeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(tradeStatus, value1, value2);
        }
        public Criteria andGoodsFeeIsNull() {
            return isNull(goodsFee);
        }

        public Criteria andGoodsFeeIsNotNull() {
            return isNotNull(goodsFee);
        }

        public Criteria andGoodsFeeEqualTo(String value) {
            return equalTo(goodsFee, value);
        }

        public Criteria andGoodsFeeNotEqualTo(String value) {
            return notEqualTo(goodsFee, value);
        }

        public Criteria andGoodsFeeGreaterThan(String value) {
            return greaterThan(goodsFee, value);
        }

        public Criteria andGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsFee, value);
        }

        public Criteria andGoodsFeeLessThan(String value) {
            return lessThan(goodsFee, value);
        }

        public Criteria andGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsFee, value);
        }

        public Criteria andGoodsFeeLike(String value) {
            return like(goodsFee, value);
        }

        public Criteria andGoodsFeeNotLike(String value) {
            return notLike(goodsFee, value);
        }

        public Criteria andGoodsFeeIn(List<String> values) {
            return in(goodsFee, values);
        }

        public Criteria andGoodsFeeNotIn(List<String> values) {
            return notIn(goodsFee, values);
        }

        public Criteria andGoodsFeeBetween(String value1, String value2) {
            return between(goodsFee, value1, value2);
        }

        public Criteria andGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(goodsFee, value1, value2);
        }
        public Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public Criteria andServicesFeeIsNull() {
            return isNull(servicesFee);
        }

        public Criteria andServicesFeeIsNotNull() {
            return isNotNull(servicesFee);
        }

        public Criteria andServicesFeeEqualTo(String value) {
            return equalTo(servicesFee, value);
        }

        public Criteria andServicesFeeNotEqualTo(String value) {
            return notEqualTo(servicesFee, value);
        }

        public Criteria andServicesFeeGreaterThan(String value) {
            return greaterThan(servicesFee, value);
        }

        public Criteria andServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(servicesFee, value);
        }

        public Criteria andServicesFeeLessThan(String value) {
            return lessThan(servicesFee, value);
        }

        public Criteria andServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(servicesFee, value);
        }

        public Criteria andServicesFeeLike(String value) {
            return like(servicesFee, value);
        }

        public Criteria andServicesFeeNotLike(String value) {
            return notLike(servicesFee, value);
        }

        public Criteria andServicesFeeIn(List<String> values) {
            return in(servicesFee, values);
        }

        public Criteria andServicesFeeNotIn(List<String> values) {
            return notIn(servicesFee, values);
        }

        public Criteria andServicesFeeBetween(String value1, String value2) {
            return between(servicesFee, value1, value2);
        }

        public Criteria andServicesFeeNotBetween(String value1, String value2) {
            return notBetween(servicesFee, value1, value2);
        }
        public Criteria andTradeDiscountFeeIsNull() {
            return isNull(tradeDiscountFee);
        }

        public Criteria andTradeDiscountFeeIsNotNull() {
            return isNotNull(tradeDiscountFee);
        }

        public Criteria andTradeDiscountFeeEqualTo(String value) {
            return equalTo(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeNotEqualTo(String value) {
            return notEqualTo(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeGreaterThan(String value) {
            return greaterThan(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeLessThan(String value) {
            return lessThan(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeLike(String value) {
            return like(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeNotLike(String value) {
            return notLike(tradeDiscountFee, value);
        }

        public Criteria andTradeDiscountFeeIn(List<String> values) {
            return in(tradeDiscountFee, values);
        }

        public Criteria andTradeDiscountFeeNotIn(List<String> values) {
            return notIn(tradeDiscountFee, values);
        }

        public Criteria andTradeDiscountFeeBetween(String value1, String value2) {
            return between(tradeDiscountFee, value1, value2);
        }

        public Criteria andTradeDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(tradeDiscountFee, value1, value2);
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
        public Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public Criteria andRealPayMoneyIsNull() {
            return isNull(realPayMoney);
        }

        public Criteria andRealPayMoneyIsNotNull() {
            return isNotNull(realPayMoney);
        }

        public Criteria andRealPayMoneyEqualTo(String value) {
            return equalTo(realPayMoney, value);
        }

        public Criteria andRealPayMoneyNotEqualTo(String value) {
            return notEqualTo(realPayMoney, value);
        }

        public Criteria andRealPayMoneyGreaterThan(String value) {
            return greaterThan(realPayMoney, value);
        }

        public Criteria andRealPayMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realPayMoney, value);
        }

        public Criteria andRealPayMoneyLessThan(String value) {
            return lessThan(realPayMoney, value);
        }

        public Criteria andRealPayMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realPayMoney, value);
        }

        public Criteria andRealPayMoneyLike(String value) {
            return like(realPayMoney, value);
        }

        public Criteria andRealPayMoneyNotLike(String value) {
            return notLike(realPayMoney, value);
        }

        public Criteria andRealPayMoneyIn(List<String> values) {
            return in(realPayMoney, values);
        }

        public Criteria andRealPayMoneyNotIn(List<String> values) {
            return notIn(realPayMoney, values);
        }

        public Criteria andRealPayMoneyBetween(String value1, String value2) {
            return between(realPayMoney, value1, value2);
        }

        public Criteria andRealPayMoneyNotBetween(String value1, String value2) {
            return notBetween(realPayMoney, value1, value2);
        }
        public Criteria andBarCodeKeyIsNull() {
            return isNull(barCodeKey);
        }

        public Criteria andBarCodeKeyIsNotNull() {
            return isNotNull(barCodeKey);
        }

        public Criteria andBarCodeKeyEqualTo(String value) {
            return equalTo(barCodeKey, value);
        }

        public Criteria andBarCodeKeyNotEqualTo(String value) {
            return notEqualTo(barCodeKey, value);
        }

        public Criteria andBarCodeKeyGreaterThan(String value) {
            return greaterThan(barCodeKey, value);
        }

        public Criteria andBarCodeKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKey, value);
        }

        public Criteria andBarCodeKeyLessThan(String value) {
            return lessThan(barCodeKey, value);
        }

        public Criteria andBarCodeKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKey, value);
        }

        public Criteria andBarCodeKeyLike(String value) {
            return like(barCodeKey, value);
        }

        public Criteria andBarCodeKeyNotLike(String value) {
            return notLike(barCodeKey, value);
        }

        public Criteria andBarCodeKeyIn(List<String> values) {
            return in(barCodeKey, values);
        }

        public Criteria andBarCodeKeyNotIn(List<String> values) {
            return notIn(barCodeKey, values);
        }

        public Criteria andBarCodeKeyBetween(String value1, String value2) {
            return between(barCodeKey, value1, value2);
        }

        public Criteria andBarCodeKeyNotBetween(String value1, String value2) {
            return notBetween(barCodeKey, value1, value2);
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
        public Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public Criteria andFinishTimeIsNull() {
            return isNull(finishTime);
        }

        public Criteria andFinishTimeIsNotNull() {
            return isNotNull(finishTime);
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            return equalTo(finishTime, value);
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            return notEqualTo(finishTime, value);
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            return greaterThan(finishTime, value);
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(finishTime, value);
        }

        public Criteria andFinishTimeLessThan(Date value) {
            return lessThan(finishTime, value);
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(finishTime, value);
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            return in(finishTime, values);
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            return notIn(finishTime, values);
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            return between(finishTime, value1, value2);
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(finishTime, value1, value2);
        }
        public Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public Criteria andCloseTimeIsNull() {
            return isNull(closeTime);
        }

        public Criteria andCloseTimeIsNotNull() {
            return isNotNull(closeTime);
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            return equalTo(closeTime, value);
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            return notEqualTo(closeTime, value);
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            return greaterThan(closeTime, value);
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(closeTime, value);
        }

        public Criteria andCloseTimeLessThan(Date value) {
            return lessThan(closeTime, value);
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(closeTime, value);
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            return in(closeTime, values);
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            return notIn(closeTime, values);
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            return between(closeTime, value1, value2);
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            return notBetween(closeTime, value1, value2);
        }
        public Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLike(String value) {
            return like(buyerId, value);
        }

        public Criteria andBuyerIdNotLike(String value) {
            return notLike(buyerId, value);
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public Criteria andPrintExpressStatusIsNull() {
            return isNull(printExpressStatus);
        }

        public Criteria andPrintExpressStatusIsNotNull() {
            return isNotNull(printExpressStatus);
        }

        public Criteria andPrintExpressStatusEqualTo(Integer value) {
            return equalTo(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusNotEqualTo(Integer value) {
            return notEqualTo(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusGreaterThan(Integer value) {
            return greaterThan(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusLessThan(Integer value) {
            return lessThan(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printExpressStatus, value);
        }

        public Criteria andPrintExpressStatusIn(List<Integer> values) {
            return in(printExpressStatus, values);
        }

        public Criteria andPrintExpressStatusNotIn(List<Integer> values) {
            return notIn(printExpressStatus, values);
        }

        public Criteria andPrintExpressStatusBetween(Integer value1, Integer value2) {
            return between(printExpressStatus, value1, value2);
        }

        public Criteria andPrintExpressStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printExpressStatus, value1, value2);
        }
        public Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public Criteria andReceiverMobileIsNull() {
            return isNull(receiverMobile);
        }

        public Criteria andReceiverMobileIsNotNull() {
            return isNotNull(receiverMobile);
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            return equalTo(receiverMobile, value);
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            return notEqualTo(receiverMobile, value);
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            return greaterThan(receiverMobile, value);
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverMobile, value);
        }

        public Criteria andReceiverMobileLessThan(String value) {
            return lessThan(receiverMobile, value);
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverMobile, value);
        }

        public Criteria andReceiverMobileLike(String value) {
            return like(receiverMobile, value);
        }

        public Criteria andReceiverMobileNotLike(String value) {
            return notLike(receiverMobile, value);
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            return in(receiverMobile, values);
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            return notIn(receiverMobile, values);
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            return between(receiverMobile, value1, value2);
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            return notBetween(receiverMobile, value1, value2);
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
        public Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidLike(String value) {
            return like(taobaoTid, value);
        }

        public Criteria andTaobaoTidNotLike(String value) {
            return notLike(taobaoTid, value);
        }

        public Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public Criteria andBuyerWxIsNull() {
            return isNull(buyerWx);
        }

        public Criteria andBuyerWxIsNotNull() {
            return isNotNull(buyerWx);
        }

        public Criteria andBuyerWxEqualTo(String value) {
            return equalTo(buyerWx, value);
        }

        public Criteria andBuyerWxNotEqualTo(String value) {
            return notEqualTo(buyerWx, value);
        }

        public Criteria andBuyerWxGreaterThan(String value) {
            return greaterThan(buyerWx, value);
        }

        public Criteria andBuyerWxGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWx, value);
        }

        public Criteria andBuyerWxLessThan(String value) {
            return lessThan(buyerWx, value);
        }

        public Criteria andBuyerWxLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWx, value);
        }

        public Criteria andBuyerWxLike(String value) {
            return like(buyerWx, value);
        }

        public Criteria andBuyerWxNotLike(String value) {
            return notLike(buyerWx, value);
        }

        public Criteria andBuyerWxIn(List<String> values) {
            return in(buyerWx, values);
        }

        public Criteria andBuyerWxNotIn(List<String> values) {
            return notIn(buyerWx, values);
        }

        public Criteria andBuyerWxBetween(String value1, String value2) {
            return between(buyerWx, value1, value2);
        }

        public Criteria andBuyerWxNotBetween(String value1, String value2) {
            return notBetween(buyerWx, value1, value2);
        }
        public Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public Criteria andSellerNameIsNull() {
            return isNull(sellerName);
        }

        public Criteria andSellerNameIsNotNull() {
            return isNotNull(sellerName);
        }

        public Criteria andSellerNameEqualTo(String value) {
            return equalTo(sellerName, value);
        }

        public Criteria andSellerNameNotEqualTo(String value) {
            return notEqualTo(sellerName, value);
        }

        public Criteria andSellerNameGreaterThan(String value) {
            return greaterThan(sellerName, value);
        }

        public Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerName, value);
        }

        public Criteria andSellerNameLessThan(String value) {
            return lessThan(sellerName, value);
        }

        public Criteria andSellerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerName, value);
        }

        public Criteria andSellerNameLike(String value) {
            return like(sellerName, value);
        }

        public Criteria andSellerNameNotLike(String value) {
            return notLike(sellerName, value);
        }

        public Criteria andSellerNameIn(List<String> values) {
            return in(sellerName, values);
        }

        public Criteria andSellerNameNotIn(List<String> values) {
            return notIn(sellerName, values);
        }

        public Criteria andSellerNameBetween(String value1, String value2) {
            return between(sellerName, value1, value2);
        }

        public Criteria andSellerNameNotBetween(String value1, String value2) {
            return notBetween(sellerName, value1, value2);
        }
        public Criteria andPayStatusIsNull() {
            return isNull(payStatus);
        }

        public Criteria andPayStatusIsNotNull() {
            return isNotNull(payStatus);
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            return equalTo(payStatus, value);
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            return notEqualTo(payStatus, value);
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            return greaterThan(payStatus, value);
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(payStatus, value);
        }

        public Criteria andPayStatusLessThan(Integer value) {
            return lessThan(payStatus, value);
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(payStatus, value);
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            return in(payStatus, values);
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            return notIn(payStatus, values);
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            return between(payStatus, value1, value2);
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(payStatus, value1, value2);
        }
        public Criteria andPayTimeIsNull() {
            return isNull(payTime);
        }

        public Criteria andPayTimeIsNotNull() {
            return isNotNull(payTime);
        }

        public Criteria andPayTimeEqualTo(Date value) {
            return equalTo(payTime, value);
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            return notEqualTo(payTime, value);
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            return greaterThan(payTime, value);
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payTime, value);
        }

        public Criteria andPayTimeLessThan(Date value) {
            return lessThan(payTime, value);
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payTime, value);
        }

        public Criteria andPayTimeIn(List<Date> values) {
            return in(payTime, values);
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            return notIn(payTime, values);
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            return between(payTime, value1, value2);
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            return notBetween(payTime, value1, value2);
        }
        public Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public Criteria andBuyerNickIsNull() {
            return isNull(buyerNick);
        }

        public Criteria andBuyerNickIsNotNull() {
            return isNotNull(buyerNick);
        }

        public Criteria andBuyerNickEqualTo(String value) {
            return equalTo(buyerNick, value);
        }

        public Criteria andBuyerNickNotEqualTo(String value) {
            return notEqualTo(buyerNick, value);
        }

        public Criteria andBuyerNickGreaterThan(String value) {
            return greaterThan(buyerNick, value);
        }

        public Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerNick, value);
        }

        public Criteria andBuyerNickLessThan(String value) {
            return lessThan(buyerNick, value);
        }

        public Criteria andBuyerNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerNick, value);
        }

        public Criteria andBuyerNickLike(String value) {
            return like(buyerNick, value);
        }

        public Criteria andBuyerNickNotLike(String value) {
            return notLike(buyerNick, value);
        }

        public Criteria andBuyerNickIn(List<String> values) {
            return in(buyerNick, values);
        }

        public Criteria andBuyerNickNotIn(List<String> values) {
            return notIn(buyerNick, values);
        }

        public Criteria andBuyerNickBetween(String value1, String value2) {
            return between(buyerNick, value1, value2);
        }

        public Criteria andBuyerNickNotBetween(String value1, String value2) {
            return notBetween(buyerNick, value1, value2);
        }

        public Criteria andIsOldIsNull() {
            return isNull(isOld);
        }

        public Criteria andIsOldIsNotNull() {
            return isNotNull(isOld);
        }

        public Criteria andIsOldEqualTo(Integer value) {
            return equalTo(isOld, value);
        }

        public Criteria andIsOldNotEqualTo(Integer value) {
            return notEqualTo(isOld, value);
        }

        public Criteria andIsOldGreaterThan(Integer value) {
            return greaterThan(isOld, value);
        }

        public Criteria andIsOldGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOld, value);
        }

        public Criteria andIsOldLessThan(Integer value) {
            return lessThan(isOld, value);
        }

        public Criteria andIsOldLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOld, value);
        }

        public Criteria andIsOldIn(List<Integer> values) {
            return in(isOld, values);
        }

        public Criteria andIsOldNotIn(List<Integer> values) {
            return notIn(isOld, values);
        }

        public Criteria andIsOldetween(Integer value1, Integer value2) {
            return between(isOld, value1, value2);
        }

        public Criteria andIsOldNotBetween(Integer value1, Integer value2) {
            return notBetween(isOld, value1, value2);
        }
    }
}
