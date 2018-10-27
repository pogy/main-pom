package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaTradeBackup1;

import java.util.*;
public class DaifaTradeBackup1Example extends SgExample<DaifaTradeBackup1Example.Criteria> {
    public static final Class<DaifaTradeBackup1> beanClass = DaifaTradeBackup1.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn buyerNick;
    public static EntityColumn payTime;
    public static EntityColumn afterRemark;
    public static EntityColumn tradeDiscountFee;
    public static EntityColumn buyerId;
    public static EntityColumn expressFee;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerRemark;
    public static EntityColumn sellerId;
    public static EntityColumn receiverPhone;
    public static EntityColumn receiverQq;
    public static EntityColumn expressCode;
    public static EntityColumn lastDoTime;
    public static EntityColumn receiverZip;
    public static EntityColumn finishTime;
    public static EntityColumn daifaType;
    public static EntityColumn tradeCode;
    public static EntityColumn sendTime;
    public static EntityColumn dfTradeId;
    public static EntityColumn receiverAddress;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn barCodeKey;
    public static EntityColumn tradeStatus;
    public static EntityColumn realPayMoney;
    public static EntityColumn receiverState;
    public static EntityColumn remark1;
    public static EntityColumn expressId;
    public static EntityColumn remark2;
    public static EntityColumn buyerTelephone;
    public static EntityColumn sellerName;
    public static EntityColumn goodsWeight;
    public static EntityColumn buyerWw;
    public static EntityColumn servicesFee;
    public static EntityColumn buyerWx;
    public static EntityColumn closeTime;
    public static EntityColumn goodsNum;
    public static EntityColumn goodsFee;
    public static EntityColumn isOld;
    public static EntityColumn printExpressStatus;
    public static EntityColumn receiverName;
    public static EntityColumn receiverMobile;
    public static EntityColumn goodsVolume;
    public static EntityColumn buyerName;
    public static EntityColumn taobaoTid;
    public static EntityColumn expressName;
    public static EntityColumn money;
    public static EntityColumn totalFee;
    public static EntityColumn createTime;
    public static EntityColumn sendStatus;
    public static EntityColumn payStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buyerNick = listMap.get("buyerNick");
        payTime = listMap.get("payTime");
        afterRemark = listMap.get("afterRemark");
        tradeDiscountFee = listMap.get("tradeDiscountFee");
        buyerId = listMap.get("buyerId");
        expressFee = listMap.get("expressFee");
        buyerQq = listMap.get("buyerQq");
        buyerRemark = listMap.get("buyerRemark");
        sellerId = listMap.get("sellerId");
        receiverPhone = listMap.get("receiverPhone");
        receiverQq = listMap.get("receiverQq");
        expressCode = listMap.get("expressCode");
        lastDoTime = listMap.get("lastDoTime");
        receiverZip = listMap.get("receiverZip");
        finishTime = listMap.get("finishTime");
        daifaType = listMap.get("daifaType");
        tradeCode = listMap.get("tradeCode");
        sendTime = listMap.get("sendTime");
        dfTradeId = listMap.get("dfTradeId");
        receiverAddress = listMap.get("receiverAddress");
        taobaoUserNick = listMap.get("taobaoUserNick");
        barCodeKey = listMap.get("barCodeKey");
        tradeStatus = listMap.get("tradeStatus");
        realPayMoney = listMap.get("realPayMoney");
        receiverState = listMap.get("receiverState");
        remark1 = listMap.get("remark1");
        expressId = listMap.get("expressId");
        remark2 = listMap.get("remark2");
        buyerTelephone = listMap.get("buyerTelephone");
        sellerName = listMap.get("sellerName");
        goodsWeight = listMap.get("goodsWeight");
        buyerWw = listMap.get("buyerWw");
        servicesFee = listMap.get("servicesFee");
        buyerWx = listMap.get("buyerWx");
        closeTime = listMap.get("closeTime");
        goodsNum = listMap.get("goodsNum");
        goodsFee = listMap.get("goodsFee");
        isOld = listMap.get("isOld");
        printExpressStatus = listMap.get("printExpressStatus");
        receiverName = listMap.get("receiverName");
        receiverMobile = listMap.get("receiverMobile");
        goodsVolume = listMap.get("goodsVolume");
        buyerName = listMap.get("buyerName");
        taobaoTid = listMap.get("taobaoTid");
        expressName = listMap.get("expressName");
        money = listMap.get("money");
        totalFee = listMap.get("totalFee");
        createTime = listMap.get("createTime");
        sendStatus = listMap.get("sendStatus");
        payStatus = listMap.get("payStatus");
    }

    public DaifaTradeBackup1Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaTradeBackup1Example.Criteria createCriteriaInternal() {
        return new DaifaTradeBackup1Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickIsNull() {
            return isNull(buyerNick);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickIsNotNull() {
            return isNotNull(buyerNick);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickEqualTo(String value) {
            return equalTo(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickNotEqualTo(String value) {
            return notEqualTo(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickGreaterThan(String value) {
            return greaterThan(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickLessThan(String value) {
            return lessThan(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickLike(String value) {
            return like(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickNotLike(String value) {
            return notLike(buyerNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickIn(List<String> values) {
            return in(buyerNick, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickNotIn(List<String> values) {
            return notIn(buyerNick, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickBetween(String value1, String value2) {
            return between(buyerNick, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNickNotBetween(String value1, String value2) {
            return notBetween(buyerNick, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andPayTimeIsNull() {
            return isNull(payTime);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeIsNotNull() {
            return isNotNull(payTime);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeEqualTo(Date value) {
            return equalTo(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeNotEqualTo(Date value) {
            return notEqualTo(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeGreaterThan(Date value) {
            return greaterThan(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeLessThan(Date value) {
            return lessThan(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeIn(List<Date> values) {
            return in(payTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeNotIn(List<Date> values) {
            return notIn(payTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeBetween(Date value1, Date value2) {
            return between(payTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andPayTimeNotBetween(Date value1, Date value2) {
            return notBetween(payTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andAfterRemarkIsNull() {
            return isNull(afterRemark);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkIsNotNull() {
            return isNotNull(afterRemark);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkEqualTo(String value) {
            return equalTo(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkNotEqualTo(String value) {
            return notEqualTo(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkGreaterThan(String value) {
            return greaterThan(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkLessThan(String value) {
            return lessThan(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkLike(String value) {
            return like(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkNotLike(String value) {
            return notLike(afterRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkIn(List<String> values) {
            return in(afterRemark, values);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkNotIn(List<String> values) {
            return notIn(afterRemark, values);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkBetween(String value1, String value2) {
            return between(afterRemark, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andAfterRemarkNotBetween(String value1, String value2) {
            return notBetween(afterRemark, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeIsNull() {
            return isNull(tradeDiscountFee);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeIsNotNull() {
            return isNotNull(tradeDiscountFee);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeEqualTo(String value) {
            return equalTo(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeNotEqualTo(String value) {
            return notEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeGreaterThan(String value) {
            return greaterThan(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeLessThan(String value) {
            return lessThan(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeLike(String value) {
            return like(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeNotLike(String value) {
            return notLike(tradeDiscountFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeIn(List<String> values) {
            return in(tradeDiscountFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeNotIn(List<String> values) {
            return notIn(tradeDiscountFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeBetween(String value1, String value2) {
            return between(tradeDiscountFee, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTradeDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(tradeDiscountFee, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andFinishTimeIsNull() {
            return isNull(finishTime);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeIsNotNull() {
            return isNotNull(finishTime);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeEqualTo(Date value) {
            return equalTo(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeNotEqualTo(Date value) {
            return notEqualTo(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeGreaterThan(Date value) {
            return greaterThan(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeLessThan(Date value) {
            return lessThan(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(finishTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeIn(List<Date> values) {
            return in(finishTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeNotIn(List<Date> values) {
            return notIn(finishTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeBetween(Date value1, Date value2) {
            return between(finishTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(finishTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andDaifaTypeIsNull() {
            return isNull(daifaType);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeIsNotNull() {
            return isNotNull(daifaType);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeEqualTo(Integer value) {
            return equalTo(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeNotEqualTo(Integer value) {
            return notEqualTo(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeGreaterThan(Integer value) {
            return greaterThan(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeLessThan(Integer value) {
            return lessThan(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(daifaType, value);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeIn(List<Integer> values) {
            return in(daifaType, values);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeNotIn(List<Integer> values) {
            return notIn(daifaType, values);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeBetween(Integer value1, Integer value2) {
            return between(daifaType, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andDaifaTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(daifaType, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }
        public DaifaTradeBackup1Example.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }
        public DaifaTradeBackup1Example.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBarCodeKeyIsNull() {
            return isNull(barCodeKey);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyIsNotNull() {
            return isNotNull(barCodeKey);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyEqualTo(String value) {
            return equalTo(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyNotEqualTo(String value) {
            return notEqualTo(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyGreaterThan(String value) {
            return greaterThan(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyLessThan(String value) {
            return lessThan(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyLike(String value) {
            return like(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyNotLike(String value) {
            return notLike(barCodeKey, value);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyIn(List<String> values) {
            return in(barCodeKey, values);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyNotIn(List<String> values) {
            return notIn(barCodeKey, values);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyBetween(String value1, String value2) {
            return between(barCodeKey, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBarCodeKeyNotBetween(String value1, String value2) {
            return notBetween(barCodeKey, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTradeStatusIsNull() {
            return isNull(tradeStatus);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusIsNotNull() {
            return isNotNull(tradeStatus);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusEqualTo(Integer value) {
            return equalTo(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusNotEqualTo(Integer value) {
            return notEqualTo(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusGreaterThan(Integer value) {
            return greaterThan(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusLessThan(Integer value) {
            return lessThan(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(tradeStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusIn(List<Integer> values) {
            return in(tradeStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusNotIn(List<Integer> values) {
            return notIn(tradeStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusBetween(Integer value1, Integer value2) {
            return between(tradeStatus, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTradeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(tradeStatus, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andRealPayMoneyIsNull() {
            return isNull(realPayMoney);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyIsNotNull() {
            return isNotNull(realPayMoney);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyEqualTo(String value) {
            return equalTo(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyNotEqualTo(String value) {
            return notEqualTo(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyGreaterThan(String value) {
            return greaterThan(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyLessThan(String value) {
            return lessThan(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyLike(String value) {
            return like(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyNotLike(String value) {
            return notLike(realPayMoney, value);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyIn(List<String> values) {
            return in(realPayMoney, values);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyNotIn(List<String> values) {
            return notIn(realPayMoney, values);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyBetween(String value1, String value2) {
            return between(realPayMoney, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andRealPayMoneyNotBetween(String value1, String value2) {
            return notBetween(realPayMoney, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andSellerNameIsNull() {
            return isNull(sellerName);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameIsNotNull() {
            return isNotNull(sellerName);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameEqualTo(String value) {
            return equalTo(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameNotEqualTo(String value) {
            return notEqualTo(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameGreaterThan(String value) {
            return greaterThan(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameLessThan(String value) {
            return lessThan(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameLike(String value) {
            return like(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameNotLike(String value) {
            return notLike(sellerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameIn(List<String> values) {
            return in(sellerName, values);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameNotIn(List<String> values) {
            return notIn(sellerName, values);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameBetween(String value1, String value2) {
            return between(sellerName, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andSellerNameNotBetween(String value1, String value2) {
            return notBetween(sellerName, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightEqualTo(String value) {
            return equalTo(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightNotEqualTo(String value) {
            return notEqualTo(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightGreaterThan(String value) {
            return greaterThan(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightLessThan(String value) {
            return lessThan(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightLike(String value) {
            return like(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightNotLike(String value) {
            return notLike(goodsWeight, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightIn(List<String> values) {
            return in(goodsWeight, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightNotIn(List<String> values) {
            return notIn(goodsWeight, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightBetween(String value1, String value2) {
            return between(goodsWeight, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsWeightNotBetween(String value1, String value2) {
            return notBetween(goodsWeight, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andServicesFeeIsNull() {
            return isNull(servicesFee);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeIsNotNull() {
            return isNotNull(servicesFee);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeEqualTo(String value) {
            return equalTo(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeNotEqualTo(String value) {
            return notEqualTo(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeGreaterThan(String value) {
            return greaterThan(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeLessThan(String value) {
            return lessThan(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeLike(String value) {
            return like(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeNotLike(String value) {
            return notLike(servicesFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeIn(List<String> values) {
            return in(servicesFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeNotIn(List<String> values) {
            return notIn(servicesFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeBetween(String value1, String value2) {
            return between(servicesFee, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andServicesFeeNotBetween(String value1, String value2) {
            return notBetween(servicesFee, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerWxIsNull() {
            return isNull(buyerWx);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxIsNotNull() {
            return isNotNull(buyerWx);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxEqualTo(String value) {
            return equalTo(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxNotEqualTo(String value) {
            return notEqualTo(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxGreaterThan(String value) {
            return greaterThan(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxLessThan(String value) {
            return lessThan(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxLike(String value) {
            return like(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxNotLike(String value) {
            return notLike(buyerWx, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxIn(List<String> values) {
            return in(buyerWx, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxNotIn(List<String> values) {
            return notIn(buyerWx, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxBetween(String value1, String value2) {
            return between(buyerWx, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerWxNotBetween(String value1, String value2) {
            return notBetween(buyerWx, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andCloseTimeIsNull() {
            return isNull(closeTime);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeIsNotNull() {
            return isNotNull(closeTime);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeEqualTo(Date value) {
            return equalTo(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeNotEqualTo(Date value) {
            return notEqualTo(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeGreaterThan(Date value) {
            return greaterThan(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeLessThan(Date value) {
            return lessThan(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(closeTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeIn(List<Date> values) {
            return in(closeTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeNotIn(List<Date> values) {
            return notIn(closeTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeBetween(Date value1, Date value2) {
            return between(closeTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            return notBetween(closeTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andGoodsFeeIsNull() {
            return isNull(goodsFee);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeIsNotNull() {
            return isNotNull(goodsFee);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeEqualTo(String value) {
            return equalTo(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeNotEqualTo(String value) {
            return notEqualTo(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeGreaterThan(String value) {
            return greaterThan(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeLessThan(String value) {
            return lessThan(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeLike(String value) {
            return like(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeNotLike(String value) {
            return notLike(goodsFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeIn(List<String> values) {
            return in(goodsFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeNotIn(List<String> values) {
            return notIn(goodsFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeBetween(String value1, String value2) {
            return between(goodsFee, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(goodsFee, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andIsOldIsNull() {
            return isNull(isOld);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldIsNotNull() {
            return isNotNull(isOld);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldEqualTo(Integer value) {
            return equalTo(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldNotEqualTo(Integer value) {
            return notEqualTo(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldGreaterThan(Integer value) {
            return greaterThan(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldLessThan(Integer value) {
            return lessThan(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOld, value);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldIn(List<Integer> values) {
            return in(isOld, values);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldNotIn(List<Integer> values) {
            return notIn(isOld, values);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldBetween(Integer value1, Integer value2) {
            return between(isOld, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andIsOldNotBetween(Integer value1, Integer value2) {
            return notBetween(isOld, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusIsNull() {
            return isNull(printExpressStatus);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusIsNotNull() {
            return isNotNull(printExpressStatus);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusEqualTo(Integer value) {
            return equalTo(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusNotEqualTo(Integer value) {
            return notEqualTo(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusGreaterThan(Integer value) {
            return greaterThan(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusLessThan(Integer value) {
            return lessThan(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printExpressStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusIn(List<Integer> values) {
            return in(printExpressStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusNotIn(List<Integer> values) {
            return notIn(printExpressStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusBetween(Integer value1, Integer value2) {
            return between(printExpressStatus, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andPrintExpressStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printExpressStatus, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andReceiverMobileIsNull() {
            return isNull(receiverMobile);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileIsNotNull() {
            return isNotNull(receiverMobile);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileEqualTo(String value) {
            return equalTo(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileNotEqualTo(String value) {
            return notEqualTo(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileGreaterThan(String value) {
            return greaterThan(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileLessThan(String value) {
            return lessThan(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileLike(String value) {
            return like(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileNotLike(String value) {
            return notLike(receiverMobile, value);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileIn(List<String> values) {
            return in(receiverMobile, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileNotIn(List<String> values) {
            return notIn(receiverMobile, values);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileBetween(String value1, String value2) {
            return between(receiverMobile, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andReceiverMobileNotBetween(String value1, String value2) {
            return notBetween(receiverMobile, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andGoodsVolumeIsNull() {
            return isNull(goodsVolume);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeIsNotNull() {
            return isNotNull(goodsVolume);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeEqualTo(String value) {
            return equalTo(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeNotEqualTo(String value) {
            return notEqualTo(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeGreaterThan(String value) {
            return greaterThan(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeLessThan(String value) {
            return lessThan(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeLike(String value) {
            return like(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeNotLike(String value) {
            return notLike(goodsVolume, value);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeIn(List<String> values) {
            return in(goodsVolume, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeNotIn(List<String> values) {
            return notIn(goodsVolume, values);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeBetween(String value1, String value2) {
            return between(goodsVolume, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andGoodsVolumeNotBetween(String value1, String value2) {
            return notBetween(goodsVolume, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeEqualTo(String value) {
            return equalTo(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeNotEqualTo(String value) {
            return notEqualTo(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeGreaterThan(String value) {
            return greaterThan(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeLessThan(String value) {
            return lessThan(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeLike(String value) {
            return like(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeNotLike(String value) {
            return notLike(totalFee, value);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeIn(List<String> values) {
            return in(totalFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeNotIn(List<String> values) {
            return notIn(totalFee, values);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeBetween(String value1, String value2) {
            return between(totalFee, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andTotalFeeNotBetween(String value1, String value2) {
            return notBetween(totalFee, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andPayStatusIsNull() {
            return isNull(payStatus);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusIsNotNull() {
            return isNotNull(payStatus);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusEqualTo(Integer value) {
            return equalTo(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusNotEqualTo(Integer value) {
            return notEqualTo(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusGreaterThan(Integer value) {
            return greaterThan(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusLessThan(Integer value) {
            return lessThan(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(payStatus, value);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusIn(List<Integer> values) {
            return in(payStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusNotIn(List<Integer> values) {
            return notIn(payStatus, values);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusBetween(Integer value1, Integer value2) {
            return between(payStatus, value1, value2);
        }

        public DaifaTradeBackup1Example.Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(payStatus, value1, value2);
        }
        public DaifaTradeBackup1Example.Criteria andCustomSql(String sql){
            this.addCriterion(sql);
            return this;
        }
    }
}