package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrder;

import java.util.*;
public class ItemOrderExample extends SgExample<ItemOrderExample.Criteria> {
    public static final Class<ItemOrder> beanClass = ItemOrder.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn refundFee;
    public static EntityColumn finishTime;
    public static EntityColumn payTime;
    public static EntityColumn payedFee;
    public static EntityColumn tbSend;
    public static EntityColumn disenable;
    public static EntityColumn orderStatus;
    public static EntityColumn oid;
    public static EntityColumn type;
    public static EntityColumn title;
    public static EntityColumn userId;
    public static EntityColumn sendTime;
    public static EntityColumn webSite;
    public static EntityColumn senderId;
    public static EntityColumn createTime;
    public static EntityColumn totalFee;
    public static EntityColumn outerId;
    public static EntityColumn orderFrom;
    public static EntityColumn mark;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        refundFee = listMap.get("refundFee");
        finishTime = listMap.get("finishTime");
        payTime = listMap.get("payTime");
        payedFee = listMap.get("payedFee");
        tbSend = listMap.get("tbSend");
        disenable = listMap.get("disenable");
        orderStatus = listMap.get("orderStatus");
        oid = listMap.get("oid");
        type = listMap.get("type");
        title = listMap.get("title");
        userId = listMap.get("userId");
        sendTime = listMap.get("sendTime");
        webSite = listMap.get("webSite");
        senderId = listMap.get("senderId");
        createTime = listMap.get("createTime");
        totalFee = listMap.get("totalFee");
        outerId = listMap.get("outerId");
        orderFrom = listMap.get("orderFrom");
        mark = listMap.get("mark");
        }

    public ItemOrderExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderExample.Criteria createCriteriaInternal() {
        return new ItemOrderExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderExample.Criteria andRefundFeeIsNull() {
            return isNull(refundFee);
        }

        public ItemOrderExample.Criteria andRefundFeeIsNotNull() {
            return isNotNull(refundFee);
        }

        public ItemOrderExample.Criteria andRefundFeeEqualTo(Long value) {
            return equalTo(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeNotEqualTo(Long value) {
            return notEqualTo(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThan(Long value) {
            return greaterThan(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeLessThan(Long value) {
            return lessThan(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundFee, value);
        }

        public ItemOrderExample.Criteria andRefundFeeIn(List<Long> values) {
            return in(refundFee, values);
        }

        public ItemOrderExample.Criteria andRefundFeeNotIn(List<Long> values) {
            return notIn(refundFee, values);
        }

        public ItemOrderExample.Criteria andRefundFeeBetween(Long value1, Long value2) {
            return between(refundFee, value1, value2);
        }

        public ItemOrderExample.Criteria andRefundFeeNotBetween(Long value1, Long value2) {
            return notBetween(refundFee, value1, value2);
        }
        public ItemOrderExample.Criteria andFinishTimeIsNull() {
            return isNull(finishTime);
        }

        public ItemOrderExample.Criteria andFinishTimeIsNotNull() {
            return isNotNull(finishTime);
        }

        public ItemOrderExample.Criteria andFinishTimeEqualTo(Date value) {
            return equalTo(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeNotEqualTo(Date value) {
            return notEqualTo(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeGreaterThan(Date value) {
            return greaterThan(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeLessThan(Date value) {
            return lessThan(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(finishTime, value);
        }

        public ItemOrderExample.Criteria andFinishTimeIn(List<Date> values) {
            return in(finishTime, values);
        }

        public ItemOrderExample.Criteria andFinishTimeNotIn(List<Date> values) {
            return notIn(finishTime, values);
        }

        public ItemOrderExample.Criteria andFinishTimeBetween(Date value1, Date value2) {
            return between(finishTime, value1, value2);
        }

        public ItemOrderExample.Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(finishTime, value1, value2);
        }
        public ItemOrderExample.Criteria andPayTimeIsNull() {
            return isNull(payTime);
        }

        public ItemOrderExample.Criteria andPayTimeIsNotNull() {
            return isNotNull(payTime);
        }

        public ItemOrderExample.Criteria andPayTimeEqualTo(Date value) {
            return equalTo(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeNotEqualTo(Date value) {
            return notEqualTo(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeGreaterThan(Date value) {
            return greaterThan(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeLessThan(Date value) {
            return lessThan(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payTime, value);
        }

        public ItemOrderExample.Criteria andPayTimeIn(List<Date> values) {
            return in(payTime, values);
        }

        public ItemOrderExample.Criteria andPayTimeNotIn(List<Date> values) {
            return notIn(payTime, values);
        }

        public ItemOrderExample.Criteria andPayTimeBetween(Date value1, Date value2) {
            return between(payTime, value1, value2);
        }

        public ItemOrderExample.Criteria andPayTimeNotBetween(Date value1, Date value2) {
            return notBetween(payTime, value1, value2);
        }
        public ItemOrderExample.Criteria andPayedFeeIsNull() {
            return isNull(payedFee);
        }

        public ItemOrderExample.Criteria andPayedFeeIsNotNull() {
            return isNotNull(payedFee);
        }

        public ItemOrderExample.Criteria andPayedFeeEqualTo(Long value) {
            return equalTo(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeNotEqualTo(Long value) {
            return notEqualTo(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThan(Long value) {
            return greaterThan(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeLessThan(Long value) {
            return lessThan(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payedFee, value);
        }

        public ItemOrderExample.Criteria andPayedFeeIn(List<Long> values) {
            return in(payedFee, values);
        }

        public ItemOrderExample.Criteria andPayedFeeNotIn(List<Long> values) {
            return notIn(payedFee, values);
        }

        public ItemOrderExample.Criteria andPayedFeeBetween(Long value1, Long value2) {
            return between(payedFee, value1, value2);
        }

        public ItemOrderExample.Criteria andPayedFeeNotBetween(Long value1, Long value2) {
            return notBetween(payedFee, value1, value2);
        }
        public ItemOrderExample.Criteria andTbSendIsNull() {
            return isNull(tbSend);
        }

        public ItemOrderExample.Criteria andTbSendIsNotNull() {
            return isNotNull(tbSend);
        }

        public ItemOrderExample.Criteria andTbSendEqualTo(Boolean value) {
            return equalTo(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendNotEqualTo(Boolean value) {
            return notEqualTo(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendGreaterThan(Boolean value) {
            return greaterThan(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendLessThan(Boolean value) {
            return lessThan(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(tbSend, value);
        }

        public ItemOrderExample.Criteria andTbSendIn(List<Boolean> values) {
            return in(tbSend, values);
        }

        public ItemOrderExample.Criteria andTbSendNotIn(List<Boolean> values) {
            return notIn(tbSend, values);
        }

        public ItemOrderExample.Criteria andTbSendBetween(Boolean value1, Boolean value2) {
            return between(tbSend, value1, value2);
        }

        public ItemOrderExample.Criteria andTbSendNotBetween(Boolean value1, Boolean value2) {
            return notBetween(tbSend, value1, value2);
        }
        public ItemOrderExample.Criteria andDisenableIsNull() {
            return isNull(disenable);
        }

        public ItemOrderExample.Criteria andDisenableIsNotNull() {
            return isNotNull(disenable);
        }

        public ItemOrderExample.Criteria andDisenableEqualTo(Boolean value) {
            return equalTo(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableNotEqualTo(Boolean value) {
            return notEqualTo(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableGreaterThan(Boolean value) {
            return greaterThan(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableLessThan(Boolean value) {
            return lessThan(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(disenable, value);
        }

        public ItemOrderExample.Criteria andDisenableIn(List<Boolean> values) {
            return in(disenable, values);
        }

        public ItemOrderExample.Criteria andDisenableNotIn(List<Boolean> values) {
            return notIn(disenable, values);
        }

        public ItemOrderExample.Criteria andDisenableBetween(Boolean value1, Boolean value2) {
            return between(disenable, value1, value2);
        }

        public ItemOrderExample.Criteria andDisenableNotBetween(Boolean value1, Boolean value2) {
            return notBetween(disenable, value1, value2);
        }
        public ItemOrderExample.Criteria andOrderStatusIsNull() {
            return isNull(orderStatus);
        }

        public ItemOrderExample.Criteria andOrderStatusIsNotNull() {
            return isNotNull(orderStatus);
        }

        public ItemOrderExample.Criteria andOrderStatusEqualTo(Integer value) {
            return equalTo(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusNotEqualTo(Integer value) {
            return notEqualTo(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThan(Integer value) {
            return greaterThan(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusLessThan(Integer value) {
            return lessThan(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(orderStatus, value);
        }

        public ItemOrderExample.Criteria andOrderStatusIn(List<Integer> values) {
            return in(orderStatus, values);
        }

        public ItemOrderExample.Criteria andOrderStatusNotIn(List<Integer> values) {
            return notIn(orderStatus, values);
        }

        public ItemOrderExample.Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            return between(orderStatus, value1, value2);
        }

        public ItemOrderExample.Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(orderStatus, value1, value2);
        }
        public ItemOrderExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public ItemOrderExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ItemOrderExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ItemOrderExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ItemOrderExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ItemOrderExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ItemOrderExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ItemOrderExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ItemOrderExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ItemOrderExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ItemOrderExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ItemOrderExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ItemOrderExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ItemOrderExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ItemOrderExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ItemOrderExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ItemOrderExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ItemOrderExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ItemOrderExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ItemOrderExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ItemOrderExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ItemOrderExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ItemOrderExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ItemOrderExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ItemOrderExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ItemOrderExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ItemOrderExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ItemOrderExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ItemOrderExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ItemOrderExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ItemOrderExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ItemOrderExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ItemOrderExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ItemOrderExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ItemOrderExample.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public ItemOrderExample.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public ItemOrderExample.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public ItemOrderExample.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public ItemOrderExample.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public ItemOrderExample.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public ItemOrderExample.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public ItemOrderExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ItemOrderExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ItemOrderExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ItemOrderExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ItemOrderExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ItemOrderExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ItemOrderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ItemOrderExample.Criteria andSenderIdIsNull() {
            return isNull(senderId);
        }

        public ItemOrderExample.Criteria andSenderIdIsNotNull() {
            return isNotNull(senderId);
        }

        public ItemOrderExample.Criteria andSenderIdEqualTo(Long value) {
            return equalTo(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdNotEqualTo(Long value) {
            return notEqualTo(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThan(Long value) {
            return greaterThan(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdLessThan(Long value) {
            return lessThan(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(senderId, value);
        }

        public ItemOrderExample.Criteria andSenderIdIn(List<Long> values) {
            return in(senderId, values);
        }

        public ItemOrderExample.Criteria andSenderIdNotIn(List<Long> values) {
            return notIn(senderId, values);
        }

        public ItemOrderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            return between(senderId, value1, value2);
        }

        public ItemOrderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            return notBetween(senderId, value1, value2);
        }
        public ItemOrderExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ItemOrderExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ItemOrderExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ItemOrderExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ItemOrderExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ItemOrderExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ItemOrderExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ItemOrderExample.Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public ItemOrderExample.Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public ItemOrderExample.Criteria andTotalFeeEqualTo(Long value) {
            return equalTo(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeNotEqualTo(Long value) {
            return notEqualTo(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThan(Long value) {
            return greaterThan(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeLessThan(Long value) {
            return lessThan(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public ItemOrderExample.Criteria andTotalFeeIn(List<Long> values) {
            return in(totalFee, values);
        }

        public ItemOrderExample.Criteria andTotalFeeNotIn(List<Long> values) {
            return notIn(totalFee, values);
        }

        public ItemOrderExample.Criteria andTotalFeeBetween(Long value1, Long value2) {
            return between(totalFee, value1, value2);
        }

        public ItemOrderExample.Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            return notBetween(totalFee, value1, value2);
        }
        public ItemOrderExample.Criteria andOuterIdIsNull() {
            return isNull(outerId);
        }

        public ItemOrderExample.Criteria andOuterIdIsNotNull() {
            return isNotNull(outerId);
        }

        public ItemOrderExample.Criteria andOuterIdEqualTo(String value) {
            return equalTo(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdNotEqualTo(String value) {
            return notEqualTo(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdGreaterThan(String value) {
            return greaterThan(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdLessThan(String value) {
            return lessThan(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdLike(String value) {
            return like(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdNotLike(String value) {
            return notLike(outerId, value);
        }

        public ItemOrderExample.Criteria andOuterIdIn(List<String> values) {
            return in(outerId, values);
        }

        public ItemOrderExample.Criteria andOuterIdNotIn(List<String> values) {
            return notIn(outerId, values);
        }

        public ItemOrderExample.Criteria andOuterIdBetween(String value1, String value2) {
            return between(outerId, value1, value2);
        }

        public ItemOrderExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            return notBetween(outerId, value1, value2);
        }
        public ItemOrderExample.Criteria andOrderFromIsNull() {
            return isNull(orderFrom);
        }

        public ItemOrderExample.Criteria andOrderFromIsNotNull() {
            return isNotNull(orderFrom);
        }

        public ItemOrderExample.Criteria andOrderFromEqualTo(Integer value) {
            return equalTo(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromNotEqualTo(Integer value) {
            return notEqualTo(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromGreaterThan(Integer value) {
            return greaterThan(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromLessThan(Integer value) {
            return lessThan(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(orderFrom, value);
        }

        public ItemOrderExample.Criteria andOrderFromIn(List<Integer> values) {
            return in(orderFrom, values);
        }

        public ItemOrderExample.Criteria andOrderFromNotIn(List<Integer> values) {
            return notIn(orderFrom, values);
        }

        public ItemOrderExample.Criteria andOrderFromBetween(Integer value1, Integer value2) {
            return between(orderFrom, value1, value2);
        }

        public ItemOrderExample.Criteria andOrderFromNotBetween(Integer value1, Integer value2) {
            return notBetween(orderFrom, value1, value2);
        }
        public ItemOrderExample.Criteria andMarkIsNull() {
            return isNull(mark);
        }

        public ItemOrderExample.Criteria andMarkIsNotNull() {
            return isNotNull(mark);
        }

        public ItemOrderExample.Criteria andMarkEqualTo(String value) {
            return equalTo(mark, value);
        }

        public ItemOrderExample.Criteria andMarkNotEqualTo(String value) {
            return notEqualTo(mark, value);
        }

        public ItemOrderExample.Criteria andMarkGreaterThan(String value) {
            return greaterThan(mark, value);
        }

        public ItemOrderExample.Criteria andMarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mark, value);
        }

        public ItemOrderExample.Criteria andMarkLessThan(String value) {
            return lessThan(mark, value);
        }

        public ItemOrderExample.Criteria andMarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mark, value);
        }

        public ItemOrderExample.Criteria andMarkLike(String value) {
            return like(mark, value);
        }

        public ItemOrderExample.Criteria andMarkNotLike(String value) {
            return notLike(mark, value);
        }

        public ItemOrderExample.Criteria andMarkIn(List<String> values) {
            return in(mark, values);
        }

        public ItemOrderExample.Criteria andMarkNotIn(List<String> values) {
            return notIn(mark, values);
        }

        public ItemOrderExample.Criteria andMarkBetween(String value1, String value2) {
            return between(mark, value1, value2);
        }

        public ItemOrderExample.Criteria andMarkNotBetween(String value1, String value2) {
            return notBetween(mark, value1, value2);
        }
    }
}