package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterSale;

import java.util.*;

public class DaifaAfterSaleExample extends SgExample<DaifaAfterSaleExample.Criteria> {
    public static final Class<DaifaAfterSale> beanClass = DaifaAfterSale.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn buyerTelephone;
    public static EntityColumn receiverName;
    public static EntityColumn receiverMobile;
    public static EntityColumn tradeCode;
    public static EntityColumn afterSaleId;
    public static EntityColumn buyerName;
    public static EntityColumn buyerId;
    public static EntityColumn dfTradeId;
    public static EntityColumn receiverAddress;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWw;
    public static EntityColumn buyerRemark;
    public static EntityColumn sellerId;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn receiverQq;
    public static EntityColumn receiverState;
    public static EntityColumn remark1;
    public static EntityColumn receiverZip;
    public static EntityColumn createDate;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buyerTelephone = listMap.get("buyerTelephone");
        receiverName = listMap.get("receiverName");
        receiverMobile = listMap.get("receiverMobile");
        tradeCode = listMap.get("tradeCode");
        afterSaleId = listMap.get("afterSaleId");
        buyerName = listMap.get("buyerName");
        buyerId = listMap.get("buyerId");
        dfTradeId = listMap.get("dfTradeId");
        receiverAddress = listMap.get("receiverAddress");
        buyerQq = listMap.get("buyerQq");
        buyerWw = listMap.get("buyerWw");
        buyerRemark = listMap.get("buyerRemark");
        sellerId = listMap.get("sellerId");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        receiverQq = listMap.get("receiverQq");
        receiverState = listMap.get("receiverState");
        remark1 = listMap.get("remark1");
        receiverZip = listMap.get("receiverZip");
        createDate = listMap.get("createDate");
        remark2 = listMap.get("remark2");
        }

    public DaifaAfterSaleExample() {
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
        public Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
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
        public Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public Criteria andBuyerIdEqualTo(Integer value) {
            return equalTo(buyerId, value);
        }

        public Criteria andBuyerIdNotEqualTo(Integer value) {
            return notEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThan(Integer value) {
            return greaterThan(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLessThan(Integer value) {
            return lessThan(buyerId, value);
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdIn(List<Integer> values) {
            return in(buyerId, values);
        }

        public Criteria andBuyerIdNotIn(List<Integer> values) {
            return notIn(buyerId, values);
        }

        public Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            return between(buyerId, value1, value2);
        }

        public Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            return notBetween(buyerId, value1, value2);
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
    }
}