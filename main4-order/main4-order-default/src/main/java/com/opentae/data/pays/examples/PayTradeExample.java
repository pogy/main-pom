package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayTrade;

import java.util.*;
public class PayTradeExample extends SgExample<PayTradeExample.Criteria> {
    public static final Class<PayTrade> beanClass = PayTrade.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn behalfAccountId;
    public static EntityColumn comments;
    public static EntityColumn toAccountId;
    public static EntityColumn debitType;
    public static EntityColumn type;
    public static EntityColumn outComments;
    public static EntityColumn rechargeId;
    public static EntityColumn povIds;
    public static EntityColumn refundType;
    public static EntityColumn serviceCharge;
    public static EntityColumn alipayNo;
    public static EntityColumn fromAccountId;
    public static EntityColumn createTime;
    public static EntityColumn wxNo;
    public static EntityColumn price;
    public static EntityColumn outSubTradeNo;
    public static EntityColumn outTradeNo;
    public static EntityColumn payId;
    public static EntityColumn tpFee;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        behalfAccountId = listMap.get("behalfAccountId");
        comments = listMap.get("comments");
        toAccountId = listMap.get("toAccountId");
        debitType = listMap.get("debitType");
        type = listMap.get("type");
        outComments = listMap.get("outComments");
        rechargeId = listMap.get("rechargeId");
        povIds = listMap.get("povIds");
        refundType = listMap.get("refundType");
        serviceCharge = listMap.get("serviceCharge");
        alipayNo = listMap.get("alipayNo");
        fromAccountId = listMap.get("fromAccountId");
        createTime = listMap.get("createTime");
        wxNo = listMap.get("wxNo");
        price = listMap.get("price");
        outSubTradeNo = listMap.get("outSubTradeNo");
        outTradeNo = listMap.get("outTradeNo");
        payId = listMap.get("payId");
        tpFee = listMap.get("tpFee");
        }

    public PayTradeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayTradeExample.Criteria createCriteriaInternal() {
        return new PayTradeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayTradeExample.Criteria andBehalfAccountIdIsNull() {
            return isNull(behalfAccountId);
        }

        public PayTradeExample.Criteria andBehalfAccountIdIsNotNull() {
            return isNotNull(behalfAccountId);
        }

        public PayTradeExample.Criteria andBehalfAccountIdEqualTo(Long value) {
            return equalTo(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdNotEqualTo(Long value) {
            return notEqualTo(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdGreaterThan(Long value) {
            return greaterThan(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdLessThan(Long value) {
            return lessThan(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(behalfAccountId, value);
        }

        public PayTradeExample.Criteria andBehalfAccountIdIn(List<Long> values) {
            return in(behalfAccountId, values);
        }

        public PayTradeExample.Criteria andBehalfAccountIdNotIn(List<Long> values) {
            return notIn(behalfAccountId, values);
        }

        public PayTradeExample.Criteria andBehalfAccountIdBetween(Long value1, Long value2) {
            return between(behalfAccountId, value1, value2);
        }

        public PayTradeExample.Criteria andBehalfAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(behalfAccountId, value1, value2);
        }
        public PayTradeExample.Criteria andCommentsIsNull() {
            return isNull(comments);
        }

        public PayTradeExample.Criteria andCommentsIsNotNull() {
            return isNotNull(comments);
        }

        public PayTradeExample.Criteria andCommentsEqualTo(String value) {
            return equalTo(comments, value);
        }

        public PayTradeExample.Criteria andCommentsNotEqualTo(String value) {
            return notEqualTo(comments, value);
        }

        public PayTradeExample.Criteria andCommentsGreaterThan(String value) {
            return greaterThan(comments, value);
        }

        public PayTradeExample.Criteria andCommentsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(comments, value);
        }

        public PayTradeExample.Criteria andCommentsLessThan(String value) {
            return lessThan(comments, value);
        }

        public PayTradeExample.Criteria andCommentsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(comments, value);
        }

        public PayTradeExample.Criteria andCommentsLike(String value) {
            return like(comments, value);
        }

        public PayTradeExample.Criteria andCommentsNotLike(String value) {
            return notLike(comments, value);
        }

        public PayTradeExample.Criteria andCommentsIn(List<String> values) {
            return in(comments, values);
        }

        public PayTradeExample.Criteria andCommentsNotIn(List<String> values) {
            return notIn(comments, values);
        }

        public PayTradeExample.Criteria andCommentsBetween(String value1, String value2) {
            return between(comments, value1, value2);
        }

        public PayTradeExample.Criteria andCommentsNotBetween(String value1, String value2) {
            return notBetween(comments, value1, value2);
        }
        public PayTradeExample.Criteria andToAccountIdIsNull() {
            return isNull(toAccountId);
        }

        public PayTradeExample.Criteria andToAccountIdIsNotNull() {
            return isNotNull(toAccountId);
        }

        public PayTradeExample.Criteria andToAccountIdEqualTo(Long value) {
            return equalTo(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdNotEqualTo(Long value) {
            return notEqualTo(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdGreaterThan(Long value) {
            return greaterThan(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdLessThan(Long value) {
            return lessThan(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(toAccountId, value);
        }

        public PayTradeExample.Criteria andToAccountIdIn(List<Long> values) {
            return in(toAccountId, values);
        }

        public PayTradeExample.Criteria andToAccountIdNotIn(List<Long> values) {
            return notIn(toAccountId, values);
        }

        public PayTradeExample.Criteria andToAccountIdBetween(Long value1, Long value2) {
            return between(toAccountId, value1, value2);
        }

        public PayTradeExample.Criteria andToAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(toAccountId, value1, value2);
        }
        public PayTradeExample.Criteria andDebitTypeIsNull() {
            return isNull(debitType);
        }

        public PayTradeExample.Criteria andDebitTypeIsNotNull() {
            return isNotNull(debitType);
        }

        public PayTradeExample.Criteria andDebitTypeEqualTo(Integer value) {
            return equalTo(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeNotEqualTo(Integer value) {
            return notEqualTo(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeGreaterThan(Integer value) {
            return greaterThan(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeLessThan(Integer value) {
            return lessThan(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(debitType, value);
        }

        public PayTradeExample.Criteria andDebitTypeIn(List<Integer> values) {
            return in(debitType, values);
        }

        public PayTradeExample.Criteria andDebitTypeNotIn(List<Integer> values) {
            return notIn(debitType, values);
        }

        public PayTradeExample.Criteria andDebitTypeBetween(Integer value1, Integer value2) {
            return between(debitType, value1, value2);
        }

        public PayTradeExample.Criteria andDebitTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(debitType, value1, value2);
        }
        public PayTradeExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public PayTradeExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public PayTradeExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public PayTradeExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public PayTradeExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public PayTradeExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public PayTradeExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public PayTradeExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public PayTradeExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public PayTradeExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public PayTradeExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public PayTradeExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public PayTradeExample.Criteria andOutCommentsIsNull() {
            return isNull(outComments);
        }

        public PayTradeExample.Criteria andOutCommentsIsNotNull() {
            return isNotNull(outComments);
        }

        public PayTradeExample.Criteria andOutCommentsEqualTo(String value) {
            return equalTo(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsNotEqualTo(String value) {
            return notEqualTo(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsGreaterThan(String value) {
            return greaterThan(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsLessThan(String value) {
            return lessThan(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsLike(String value) {
            return like(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsNotLike(String value) {
            return notLike(outComments, value);
        }

        public PayTradeExample.Criteria andOutCommentsIn(List<String> values) {
            return in(outComments, values);
        }

        public PayTradeExample.Criteria andOutCommentsNotIn(List<String> values) {
            return notIn(outComments, values);
        }

        public PayTradeExample.Criteria andOutCommentsBetween(String value1, String value2) {
            return between(outComments, value1, value2);
        }

        public PayTradeExample.Criteria andOutCommentsNotBetween(String value1, String value2) {
            return notBetween(outComments, value1, value2);
        }
        public PayTradeExample.Criteria andRechargeIdIsNull() {
            return isNull(rechargeId);
        }

        public PayTradeExample.Criteria andRechargeIdIsNotNull() {
            return isNotNull(rechargeId);
        }

        public PayTradeExample.Criteria andRechargeIdEqualTo(Long value) {
            return equalTo(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdNotEqualTo(Long value) {
            return notEqualTo(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdGreaterThan(Long value) {
            return greaterThan(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdLessThan(Long value) {
            return lessThan(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rechargeId, value);
        }

        public PayTradeExample.Criteria andRechargeIdIn(List<Long> values) {
            return in(rechargeId, values);
        }

        public PayTradeExample.Criteria andRechargeIdNotIn(List<Long> values) {
            return notIn(rechargeId, values);
        }

        public PayTradeExample.Criteria andRechargeIdBetween(Long value1, Long value2) {
            return between(rechargeId, value1, value2);
        }

        public PayTradeExample.Criteria andRechargeIdNotBetween(Long value1, Long value2) {
            return notBetween(rechargeId, value1, value2);
        }
        public PayTradeExample.Criteria andPovIdsIsNull() {
            return isNull(povIds);
        }

        public PayTradeExample.Criteria andPovIdsIsNotNull() {
            return isNotNull(povIds);
        }

        public PayTradeExample.Criteria andPovIdsEqualTo(String value) {
            return equalTo(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsNotEqualTo(String value) {
            return notEqualTo(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsGreaterThan(String value) {
            return greaterThan(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsLessThan(String value) {
            return lessThan(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsLike(String value) {
            return like(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsNotLike(String value) {
            return notLike(povIds, value);
        }

        public PayTradeExample.Criteria andPovIdsIn(List<String> values) {
            return in(povIds, values);
        }

        public PayTradeExample.Criteria andPovIdsNotIn(List<String> values) {
            return notIn(povIds, values);
        }

        public PayTradeExample.Criteria andPovIdsBetween(String value1, String value2) {
            return between(povIds, value1, value2);
        }

        public PayTradeExample.Criteria andPovIdsNotBetween(String value1, String value2) {
            return notBetween(povIds, value1, value2);
        }
        public PayTradeExample.Criteria andRefundTypeIsNull() {
            return isNull(refundType);
        }

        public PayTradeExample.Criteria andRefundTypeIsNotNull() {
            return isNotNull(refundType);
        }

        public PayTradeExample.Criteria andRefundTypeEqualTo(Integer value) {
            return equalTo(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeNotEqualTo(Integer value) {
            return notEqualTo(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeGreaterThan(Integer value) {
            return greaterThan(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeLessThan(Integer value) {
            return lessThan(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundType, value);
        }

        public PayTradeExample.Criteria andRefundTypeIn(List<Integer> values) {
            return in(refundType, values);
        }

        public PayTradeExample.Criteria andRefundTypeNotIn(List<Integer> values) {
            return notIn(refundType, values);
        }

        public PayTradeExample.Criteria andRefundTypeBetween(Integer value1, Integer value2) {
            return between(refundType, value1, value2);
        }

        public PayTradeExample.Criteria andRefundTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(refundType, value1, value2);
        }
        public PayTradeExample.Criteria andServiceChargeIsNull() {
            return isNull(serviceCharge);
        }

        public PayTradeExample.Criteria andServiceChargeIsNotNull() {
            return isNotNull(serviceCharge);
        }

        public PayTradeExample.Criteria andServiceChargeEqualTo(Long value) {
            return equalTo(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeNotEqualTo(Long value) {
            return notEqualTo(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeGreaterThan(Long value) {
            return greaterThan(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeLessThan(Long value) {
            return lessThan(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(serviceCharge, value);
        }

        public PayTradeExample.Criteria andServiceChargeIn(List<Long> values) {
            return in(serviceCharge, values);
        }

        public PayTradeExample.Criteria andServiceChargeNotIn(List<Long> values) {
            return notIn(serviceCharge, values);
        }

        public PayTradeExample.Criteria andServiceChargeBetween(Long value1, Long value2) {
            return between(serviceCharge, value1, value2);
        }

        public PayTradeExample.Criteria andServiceChargeNotBetween(Long value1, Long value2) {
            return notBetween(serviceCharge, value1, value2);
        }
        public PayTradeExample.Criteria andAlipayNoIsNull() {
            return isNull(alipayNo);
        }

        public PayTradeExample.Criteria andAlipayNoIsNotNull() {
            return isNotNull(alipayNo);
        }

        public PayTradeExample.Criteria andAlipayNoEqualTo(String value) {
            return equalTo(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoNotEqualTo(String value) {
            return notEqualTo(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoGreaterThan(String value) {
            return greaterThan(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoLessThan(String value) {
            return lessThan(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoLike(String value) {
            return like(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoNotLike(String value) {
            return notLike(alipayNo, value);
        }

        public PayTradeExample.Criteria andAlipayNoIn(List<String> values) {
            return in(alipayNo, values);
        }

        public PayTradeExample.Criteria andAlipayNoNotIn(List<String> values) {
            return notIn(alipayNo, values);
        }

        public PayTradeExample.Criteria andAlipayNoBetween(String value1, String value2) {
            return between(alipayNo, value1, value2);
        }

        public PayTradeExample.Criteria andAlipayNoNotBetween(String value1, String value2) {
            return notBetween(alipayNo, value1, value2);
        }
        public PayTradeExample.Criteria andFromAccountIdIsNull() {
            return isNull(fromAccountId);
        }

        public PayTradeExample.Criteria andFromAccountIdIsNotNull() {
            return isNotNull(fromAccountId);
        }

        public PayTradeExample.Criteria andFromAccountIdEqualTo(Long value) {
            return equalTo(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdNotEqualTo(Long value) {
            return notEqualTo(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdGreaterThan(Long value) {
            return greaterThan(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdLessThan(Long value) {
            return lessThan(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromAccountId, value);
        }

        public PayTradeExample.Criteria andFromAccountIdIn(List<Long> values) {
            return in(fromAccountId, values);
        }

        public PayTradeExample.Criteria andFromAccountIdNotIn(List<Long> values) {
            return notIn(fromAccountId, values);
        }

        public PayTradeExample.Criteria andFromAccountIdBetween(Long value1, Long value2) {
            return between(fromAccountId, value1, value2);
        }

        public PayTradeExample.Criteria andFromAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(fromAccountId, value1, value2);
        }
        public PayTradeExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayTradeExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayTradeExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayTradeExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayTradeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayTradeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayTradeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayTradeExample.Criteria andWxNoIsNull() {
            return isNull(wxNo);
        }

        public PayTradeExample.Criteria andWxNoIsNotNull() {
            return isNotNull(wxNo);
        }

        public PayTradeExample.Criteria andWxNoEqualTo(String value) {
            return equalTo(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoNotEqualTo(String value) {
            return notEqualTo(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoGreaterThan(String value) {
            return greaterThan(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoLessThan(String value) {
            return lessThan(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoLike(String value) {
            return like(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoNotLike(String value) {
            return notLike(wxNo, value);
        }

        public PayTradeExample.Criteria andWxNoIn(List<String> values) {
            return in(wxNo, values);
        }

        public PayTradeExample.Criteria andWxNoNotIn(List<String> values) {
            return notIn(wxNo, values);
        }

        public PayTradeExample.Criteria andWxNoBetween(String value1, String value2) {
            return between(wxNo, value1, value2);
        }

        public PayTradeExample.Criteria andWxNoNotBetween(String value1, String value2) {
            return notBetween(wxNo, value1, value2);
        }
        public PayTradeExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public PayTradeExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public PayTradeExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public PayTradeExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public PayTradeExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public PayTradeExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public PayTradeExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public PayTradeExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public PayTradeExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public PayTradeExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public PayTradeExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public PayTradeExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public PayTradeExample.Criteria andOutSubTradeNoIsNull() {
            return isNull(outSubTradeNo);
        }

        public PayTradeExample.Criteria andOutSubTradeNoIsNotNull() {
            return isNotNull(outSubTradeNo);
        }

        public PayTradeExample.Criteria andOutSubTradeNoEqualTo(String value) {
            return equalTo(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoNotEqualTo(String value) {
            return notEqualTo(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoGreaterThan(String value) {
            return greaterThan(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoLessThan(String value) {
            return lessThan(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoLike(String value) {
            return like(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoNotLike(String value) {
            return notLike(outSubTradeNo, value);
        }

        public PayTradeExample.Criteria andOutSubTradeNoIn(List<String> values) {
            return in(outSubTradeNo, values);
        }

        public PayTradeExample.Criteria andOutSubTradeNoNotIn(List<String> values) {
            return notIn(outSubTradeNo, values);
        }

        public PayTradeExample.Criteria andOutSubTradeNoBetween(String value1, String value2) {
            return between(outSubTradeNo, value1, value2);
        }

        public PayTradeExample.Criteria andOutSubTradeNoNotBetween(String value1, String value2) {
            return notBetween(outSubTradeNo, value1, value2);
        }
        public PayTradeExample.Criteria andOutTradeNoIsNull() {
            return isNull(outTradeNo);
        }

        public PayTradeExample.Criteria andOutTradeNoIsNotNull() {
            return isNotNull(outTradeNo);
        }

        public PayTradeExample.Criteria andOutTradeNoEqualTo(String value) {
            return equalTo(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoNotEqualTo(String value) {
            return notEqualTo(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoGreaterThan(String value) {
            return greaterThan(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoLessThan(String value) {
            return lessThan(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoLike(String value) {
            return like(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoNotLike(String value) {
            return notLike(outTradeNo, value);
        }

        public PayTradeExample.Criteria andOutTradeNoIn(List<String> values) {
            return in(outTradeNo, values);
        }

        public PayTradeExample.Criteria andOutTradeNoNotIn(List<String> values) {
            return notIn(outTradeNo, values);
        }

        public PayTradeExample.Criteria andOutTradeNoBetween(String value1, String value2) {
            return between(outTradeNo, value1, value2);
        }

        public PayTradeExample.Criteria andOutTradeNoNotBetween(String value1, String value2) {
            return notBetween(outTradeNo, value1, value2);
        }
        public PayTradeExample.Criteria andPayIdIsNull() {
            return isNull(payId);
        }

        public PayTradeExample.Criteria andPayIdIsNotNull() {
            return isNotNull(payId);
        }

        public PayTradeExample.Criteria andPayIdEqualTo(Long value) {
            return equalTo(payId, value);
        }

        public PayTradeExample.Criteria andPayIdNotEqualTo(Long value) {
            return notEqualTo(payId, value);
        }

        public PayTradeExample.Criteria andPayIdGreaterThan(Long value) {
            return greaterThan(payId, value);
        }

        public PayTradeExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payId, value);
        }

        public PayTradeExample.Criteria andPayIdLessThan(Long value) {
            return lessThan(payId, value);
        }

        public PayTradeExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payId, value);
        }

        public PayTradeExample.Criteria andPayIdIn(List<Long> values) {
            return in(payId, values);
        }

        public PayTradeExample.Criteria andPayIdNotIn(List<Long> values) {
            return notIn(payId, values);
        }

        public PayTradeExample.Criteria andPayIdBetween(Long value1, Long value2) {
            return between(payId, value1, value2);
        }

        public PayTradeExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            return notBetween(payId, value1, value2);
        }
        public PayTradeExample.Criteria andTpFeeIsNull() {
            return isNull(tpFee);
        }

        public PayTradeExample.Criteria andTpFeeIsNotNull() {
            return isNotNull(tpFee);
        }

        public PayTradeExample.Criteria andTpFeeEqualTo(Long value) {
            return equalTo(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeNotEqualTo(Long value) {
            return notEqualTo(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeGreaterThan(Long value) {
            return greaterThan(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeLessThan(Long value) {
            return lessThan(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tpFee, value);
        }

        public PayTradeExample.Criteria andTpFeeIn(List<Long> values) {
            return in(tpFee, values);
        }

        public PayTradeExample.Criteria andTpFeeNotIn(List<Long> values) {
            return notIn(tpFee, values);
        }

        public PayTradeExample.Criteria andTpFeeBetween(Long value1, Long value2) {
            return between(tpFee, value1, value2);
        }

        public PayTradeExample.Criteria andTpFeeNotBetween(Long value1, Long value2) {
            return notBetween(tpFee, value1, value2);
        }
    }
}