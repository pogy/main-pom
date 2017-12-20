package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;


import java.util.*;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaAfterMoneyConsultExample.java
 *@文件路径：com.opentae.data.main.examples.DaifaAfterMoneyConsultExample
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-09-15 03:55:15
 *@comments:
 *
 *=========================================================
 */
public class DaifaAfterMoneyConsultExample extends SgExample<DaifaAfterMoneyConsultExample.Criteria>{

    public static final Class<DaifaAfterMoneyConsult> beanClass = DaifaAfterMoneyConsult.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);

    public static EntityColumn afterConsultId;
    public static EntityColumn refundId;
    public static EntityColumn createTime;
    public static EntityColumn consultType;
    public static EntityColumn consultMoney;
    public static EntityColumn lastDoTime;
    public static EntityColumn consultBatch;
    public static EntityColumn remark1;
    public static EntityColumn remark2;

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }



        afterConsultId = listMap.get("afterConsultId");

        refundId = listMap.get("refundId");

        createTime = listMap.get("createTime");

        consultType = listMap.get("consultType");

        consultMoney = listMap.get("consultMoney");

        lastDoTime = listMap.get("lastDoTime");

        consultBatch = listMap.get("consultBatch");

        remark1 = listMap.get("remark1");

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
        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIsNull() {
            return isNull(afterConsultId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIsNotNull() {
            return isNotNull(afterConsultId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdEqualTo(java.lang.Long value) {
            return equalTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotEqualTo(java.lang.Long value) {
            return notEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdGreaterThan(java.lang.Long value) {
            return greaterThan(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdLessThan(java.lang.Long value) {
            return lessThan(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIn(List<java.lang.Long> values) {
            return in(afterConsultId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotIn(List<java.lang.Long> values) {
            return notIn(afterConsultId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(afterConsultId, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(afterConsultId, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdLike(String value) {return like(afterConsultId, value);}

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotLike(String value) {
            return notLike(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdEqualTo(java.lang.Long value) {
            return equalTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotEqualTo(java.lang.Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdGreaterThan(java.lang.Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdLessThan(java.lang.Long value) {
            return lessThan(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIn(List<java.lang.Long> values) {
            return in(refundId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotIn(List<java.lang.Long> values) {
            return notIn(refundId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRefundIdLike(String value) {return like(refundId, value);}

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotLike(String value) {
            return notLike(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeEqualTo(java.util.Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotEqualTo(java.util.Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeGreaterThan(java.util.Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeGreaterThanOrEqualTo(java.util.Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeLessThan(java.util.Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeLessThanOrEqualTo(java.util.Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIn(List<java.util.Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotIn(List<java.util.Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeBetween(java.util.Date value1, java.util.Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeLike(String value) {return like(createTime, value);}

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotLike(String value) {
            return notLike(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIsNull() {
            return isNull(consultType);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIsNotNull() {
            return isNotNull(consultType);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeEqualTo(java.lang.Integer value) {
            return equalTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotEqualTo(java.lang.Integer value) {
            return notEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeGreaterThan(java.lang.Integer value) {
            return greaterThan(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeGreaterThanOrEqualTo(java.lang.Integer value) {
            return greaterThanOrEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeLessThan(java.lang.Integer value) {
            return lessThan(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeLessThanOrEqualTo(java.lang.Integer value) {
            return lessThanOrEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIn(List<java.lang.Integer> values) {
            return in(consultType, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotIn(List<java.lang.Integer> values) {
            return notIn(consultType, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return between(consultType, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return notBetween(consultType, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeLike(String value) {return like(consultType, value);}

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotLike(String value) {
            return notLike(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIsNull() {
            return isNull(consultMoney);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIsNotNull() {
            return isNotNull(consultMoney);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyEqualTo(java.lang.String value) {
            return equalTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotEqualTo(java.lang.String value) {
            return notEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyGreaterThan(java.lang.String value) {
            return greaterThan(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLessThan(java.lang.String value) {
            return lessThan(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIn(List<java.lang.String> values) {
            return in(consultMoney, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotIn(List<java.lang.String> values) {
            return notIn(consultMoney, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyBetween(java.lang.String value1, java.lang.String value2) {
            return between(consultMoney, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(consultMoney, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLike(String value) {return like(consultMoney, value);}

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotLike(String value) {
            return notLike(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeEqualTo(java.util.Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotEqualTo(java.util.Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeGreaterThan(java.util.Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeGreaterThanOrEqualTo(java.util.Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeLessThan(java.util.Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeLessThanOrEqualTo(java.util.Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIn(List<java.util.Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotIn(List<java.util.Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeBetween(java.util.Date value1, java.util.Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeLike(String value) {return like(lastDoTime, value);}

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotLike(String value) {
            return notLike(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIsNull() {
            return isNull(consultBatch);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIsNotNull() {
            return isNotNull(consultBatch);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchEqualTo(java.lang.Integer value) {
            return equalTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotEqualTo(java.lang.Integer value) {
            return notEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchGreaterThan(java.lang.Integer value) {
            return greaterThan(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchGreaterThanOrEqualTo(java.lang.Integer value) {
            return greaterThanOrEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchLessThan(java.lang.Integer value) {
            return lessThan(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchLessThanOrEqualTo(java.lang.Integer value) {
            return lessThanOrEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIn(List<java.lang.Integer> values) {
            return in(consultBatch, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotIn(List<java.lang.Integer> values) {
            return notIn(consultBatch, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return between(consultBatch, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return notBetween(consultBatch, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchLike(String value) {return like(consultBatch, value);}

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotLike(String value) {
            return notLike(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1EqualTo(java.lang.String value) {
            return equalTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotEqualTo(java.lang.String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1GreaterThan(java.lang.String value) {
            return greaterThan(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1LessThan(java.lang.String value) {
            return lessThan(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1In(List<java.lang.String> values) {
            return in(remark1, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotIn(List<java.lang.String> values) {
            return notIn(remark1, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1Between(java.lang.String value1, java.lang.String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRemark1Like(String value) {return like(remark1, value);}

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2EqualTo(java.lang.String value) {
            return equalTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotEqualTo(java.lang.String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2GreaterThan(java.lang.String value) {
            return greaterThan(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2LessThan(java.lang.String value) {
            return lessThan(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2In(List<java.lang.String> values) {
            return in(remark2, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotIn(List<java.lang.String> values) {
            return notIn(remark2, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2Between(java.lang.String value1, java.lang.String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRemark2Like(String value) {return like(remark2, value);}

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

    }
}
