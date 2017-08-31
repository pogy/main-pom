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
    public static EntityColumn payTime;
    public static EntityColumn sellerName;
    public static EntityColumn afterSaleId;
    public static EntityColumn buyerId;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWw;
    public static EntityColumn buyerRemark;
    public static EntityColumn sellerId;
    public static EntityColumn receiverQq;
    public static EntityColumn receiverZip;
    public static EntityColumn createDate;
    public static EntityColumn receiverName;
    public static EntityColumn receiverMobile;
    public static EntityColumn buyerName;
    public static EntityColumn taobaoTid;
    public static EntityColumn dfTradeId;
    public static EntityColumn receiverAddress;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn money;
    public static EntityColumn remark9;
    public static EntityColumn createTime;
    public static EntityColumn remark8;
    public static EntityColumn afterType;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn receiverState;
    public static EntityColumn remark4;
    public static EntityColumn saleAfterStatus;
    public static EntityColumn sendStatus;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buyerTelephone = listMap.get("buyerTelephone");
        payTime = listMap.get("payTime");
        sellerName = listMap.get("sellerName");
        afterSaleId = listMap.get("afterSaleId");
        buyerId = listMap.get("buyerId");
        buyerQq = listMap.get("buyerQq");
        buyerWw = listMap.get("buyerWw");
        buyerRemark = listMap.get("buyerRemark");
        sellerId = listMap.get("sellerId");
        receiverQq = listMap.get("receiverQq");
        receiverZip = listMap.get("receiverZip");
        createDate = listMap.get("createDate");
        receiverName = listMap.get("receiverName");
        receiverMobile = listMap.get("receiverMobile");
        buyerName = listMap.get("buyerName");
        taobaoTid = listMap.get("taobaoTid");
        dfTradeId = listMap.get("dfTradeId");
        receiverAddress = listMap.get("receiverAddress");
        taobaoUserNick = listMap.get("taobaoUserNick");
        money = listMap.get("money");
        remark9 = listMap.get("remark9");
        createTime = listMap.get("createTime");
        remark8 = listMap.get("remark8");
        afterType = listMap.get("afterType");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        receiverState = listMap.get("receiverState");
        remark4 = listMap.get("remark4");
        saleAfterStatus = listMap.get("saleAfterStatus");
        sendStatus = listMap.get("sendStatus");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
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
    protected DaifaAfterSaleExample.Criteria createCriteriaInternal() {
        return new DaifaAfterSaleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andPayTimeIsNull() {
            return isNull(payTime);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeIsNotNull() {
            return isNotNull(payTime);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeEqualTo(Date value) {
            return equalTo(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeNotEqualTo(Date value) {
            return notEqualTo(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeGreaterThan(Date value) {
            return greaterThan(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeLessThan(Date value) {
            return lessThan(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payTime, value);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeIn(List<Date> values) {
            return in(payTime, values);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeNotIn(List<Date> values) {
            return notIn(payTime, values);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeBetween(Date value1, Date value2) {
            return between(payTime, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andPayTimeNotBetween(Date value1, Date value2) {
            return notBetween(payTime, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andSellerNameIsNull() {
            return isNull(sellerName);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameIsNotNull() {
            return isNotNull(sellerName);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameEqualTo(String value) {
            return equalTo(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameNotEqualTo(String value) {
            return notEqualTo(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameGreaterThan(String value) {
            return greaterThan(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameLessThan(String value) {
            return lessThan(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameLike(String value) {
            return like(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameNotLike(String value) {
            return notLike(sellerName, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameIn(List<String> values) {
            return in(sellerName, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameNotIn(List<String> values) {
            return notIn(sellerName, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameBetween(String value1, String value2) {
            return between(sellerName, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andSellerNameNotBetween(String value1, String value2) {
            return notBetween(sellerName, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdEqualTo(Integer value) {
            return equalTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotEqualTo(Integer value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdGreaterThan(Integer value) {
            return greaterThan(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdLessThan(Integer value) {
            return lessThan(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdIn(List<Integer> values) {
            return in(buyerId, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotIn(List<Integer> values) {
            return notIn(buyerId, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverMobileIsNull() {
            return isNull(receiverMobile);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileIsNotNull() {
            return isNotNull(receiverMobile);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileEqualTo(String value) {
            return equalTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotEqualTo(String value) {
            return notEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileGreaterThan(String value) {
            return greaterThan(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLessThan(String value) {
            return lessThan(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLike(String value) {
            return like(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotLike(String value) {
            return notLike(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileIn(List<String> values) {
            return in(receiverMobile, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotIn(List<String> values) {
            return notIn(receiverMobile, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileBetween(String value1, String value2) {
            return between(receiverMobile, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotBetween(String value1, String value2) {
            return notBetween(receiverMobile, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaAfterSaleExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaAfterSaleExample.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaAfterSaleExample.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public DaifaAfterSaleExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public DaifaAfterSaleExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public DaifaAfterSaleExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public DaifaAfterSaleExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andAfterTypeIsNull() {
            return isNull(afterType);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeIsNotNull() {
            return isNotNull(afterType);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeEqualTo(Integer value) {
            return equalTo(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeNotEqualTo(Integer value) {
            return notEqualTo(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeGreaterThan(Integer value) {
            return greaterThan(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeLessThan(Integer value) {
            return lessThan(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(afterType, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeIn(List<Integer> values) {
            return in(afterType, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeNotIn(List<Integer> values) {
            return notIn(afterType, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeBetween(Integer value1, Integer value2) {
            return between(afterType, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andAfterTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(afterType, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public DaifaAfterSaleExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public DaifaAfterSaleExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public DaifaAfterSaleExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public DaifaAfterSaleExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public DaifaAfterSaleExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public DaifaAfterSaleExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andSaleAfterStatusIsNull() {
            return isNull(saleAfterStatus);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusIsNotNull() {
            return isNotNull(saleAfterStatus);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusEqualTo(Integer value) {
            return equalTo(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusNotEqualTo(Integer value) {
            return notEqualTo(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusGreaterThan(Integer value) {
            return greaterThan(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusLessThan(Integer value) {
            return lessThan(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(saleAfterStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusIn(List<Integer> values) {
            return in(saleAfterStatus, values);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusNotIn(List<Integer> values) {
            return notIn(saleAfterStatus, values);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusBetween(Integer value1, Integer value2) {
            return between(saleAfterStatus, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andSaleAfterStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(saleAfterStatus, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public DaifaAfterSaleExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public DaifaAfterSaleExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public DaifaAfterSaleExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public DaifaAfterSaleExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaAfterSaleExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaAfterSaleExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public DaifaAfterSaleExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public DaifaAfterSaleExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}