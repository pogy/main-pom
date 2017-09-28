package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;

import java.util.*;

public class DaifaAfterMoneyConsultExample extends SgExample<DaifaAfterMoneyConsultExample.Criteria> {
    public static final Class<DaifaAfterMoneyConsult> beanClass = DaifaAfterMoneyConsult.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn consultType;
    public static EntityColumn consultMoney;
    public static EntityColumn createTime;
    public static EntityColumn consultBatch;
    public static EntityColumn remark1;
    public static EntityColumn afterConsultId;
    public static EntityColumn refundId;
    public static EntityColumn lastDoTime;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        consultType = listMap.get("consultType");
        consultMoney = listMap.get("consultMoney");
        createTime = listMap.get("createTime");
        consultBatch = listMap.get("consultBatch");
        remark1 = listMap.get("remark1");
        afterConsultId = listMap.get("afterConsultId");
        refundId = listMap.get("refundId");
        lastDoTime = listMap.get("lastDoTime");
        remark2 = listMap.get("remark2");
        }

    public DaifaAfterMoneyConsultExample() {
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

        public Criteria andConsultTypeIsNull() {
            return isNull(consultType);
        }

        public Criteria andConsultTypeIsNotNull() {
            return isNotNull(consultType);
        }

        public Criteria andConsultTypeEqualTo(Integer value) {
            return equalTo(consultType, value);
        }

        public Criteria andConsultTypeNotEqualTo(Integer value) {
            return notEqualTo(consultType, value);
        }

        public Criteria andConsultTypeGreaterThan(Integer value) {
            return greaterThan(consultType, value);
        }

        public Criteria andConsultTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(consultType, value);
        }

        public Criteria andConsultTypeLessThan(Integer value) {
            return lessThan(consultType, value);
        }

        public Criteria andConsultTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(consultType, value);
        }

        public Criteria andConsultTypeIn(List<Integer> values) {
            return in(consultType, values);
        }

        public Criteria andConsultTypeNotIn(List<Integer> values) {
            return notIn(consultType, values);
        }

        public Criteria andConsultTypeBetween(Integer value1, Integer value2) {
            return between(consultType, value1, value2);
        }

        public Criteria andConsultTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(consultType, value1, value2);
        }
        public Criteria andConsultMoneyIsNull() {
            return isNull(consultMoney);
        }

        public Criteria andConsultMoneyIsNotNull() {
            return isNotNull(consultMoney);
        }

        public Criteria andConsultMoneyEqualTo(String value) {
            return equalTo(consultMoney, value);
        }

        public Criteria andConsultMoneyNotEqualTo(String value) {
            return notEqualTo(consultMoney, value);
        }

        public Criteria andConsultMoneyGreaterThan(String value) {
            return greaterThan(consultMoney, value);
        }

        public Criteria andConsultMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(consultMoney, value);
        }

        public Criteria andConsultMoneyLessThan(String value) {
            return lessThan(consultMoney, value);
        }

        public Criteria andConsultMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(consultMoney, value);
        }

        public Criteria andConsultMoneyLike(String value) {
            return like(consultMoney, value);
        }

        public Criteria andConsultMoneyNotLike(String value) {
            return notLike(consultMoney, value);
        }

        public Criteria andConsultMoneyIn(List<String> values) {
            return in(consultMoney, values);
        }

        public Criteria andConsultMoneyNotIn(List<String> values) {
            return notIn(consultMoney, values);
        }

        public Criteria andConsultMoneyBetween(String value1, String value2) {
            return between(consultMoney, value1, value2);
        }

        public Criteria andConsultMoneyNotBetween(String value1, String value2) {
            return notBetween(consultMoney, value1, value2);
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
        public Criteria andConsultBatchIsNull() {
            return isNull(consultBatch);
        }

        public Criteria andConsultBatchIsNotNull() {
            return isNotNull(consultBatch);
        }

        public Criteria andConsultBatchEqualTo(Integer value) {
            return equalTo(consultBatch, value);
        }

        public Criteria andConsultBatchNotEqualTo(Integer value) {
            return notEqualTo(consultBatch, value);
        }

        public Criteria andConsultBatchGreaterThan(Integer value) {
            return greaterThan(consultBatch, value);
        }

        public Criteria andConsultBatchGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(consultBatch, value);
        }

        public Criteria andConsultBatchLessThan(Integer value) {
            return lessThan(consultBatch, value);
        }

        public Criteria andConsultBatchLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(consultBatch, value);
        }

        public Criteria andConsultBatchIn(List<Integer> values) {
            return in(consultBatch, values);
        }

        public Criteria andConsultBatchNotIn(List<Integer> values) {
            return notIn(consultBatch, values);
        }

        public Criteria andConsultBatchBetween(Integer value1, Integer value2) {
            return between(consultBatch, value1, value2);
        }

        public Criteria andConsultBatchNotBetween(Integer value1, Integer value2) {
            return notBetween(consultBatch, value1, value2);
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
        public Criteria andAfterConsultIdIsNull() {
            return isNull(afterConsultId);
        }

        public Criteria andAfterConsultIdIsNotNull() {
            return isNotNull(afterConsultId);
        }

        public Criteria andAfterConsultIdEqualTo(Long value) {
            return equalTo(afterConsultId, value);
        }

        public Criteria andAfterConsultIdNotEqualTo(Long value) {
            return notEqualTo(afterConsultId, value);
        }

        public Criteria andAfterConsultIdGreaterThan(Long value) {
            return greaterThan(afterConsultId, value);
        }

        public Criteria andAfterConsultIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterConsultId, value);
        }

        public Criteria andAfterConsultIdLessThan(Long value) {
            return lessThan(afterConsultId, value);
        }

        public Criteria andAfterConsultIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterConsultId, value);
        }

        public Criteria andAfterConsultIdIn(List<Long> values) {
            return in(afterConsultId, values);
        }

        public Criteria andAfterConsultIdNotIn(List<Long> values) {
            return notIn(afterConsultId, values);
        }

        public Criteria andAfterConsultIdBetween(Long value1, Long value2) {
            return between(afterConsultId, value1, value2);
        }

        public Criteria andAfterConsultIdNotBetween(Long value1, Long value2) {
            return notBetween(afterConsultId, value1, value2);
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