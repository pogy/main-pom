package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguSellerAppMsg;

import java.util.*;
public class ShiguSellerAppMsgExample extends SgExample<ShiguSellerAppMsgExample.Criteria> {
    public static final Class<ShiguSellerAppMsg> beanClass = ShiguSellerAppMsg.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn msg;
    public static EntityColumn msgType;
    public static EntityColumn gmtModify;
    public static EntityColumn extend2;
    public static EntityColumn msgTitle;
    public static EntityColumn extend1;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn userId;
    public static EntityColumn msgStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        msg = listMap.get("msg");
        msgType = listMap.get("msgType");
        gmtModify = listMap.get("gmtModify");
        extend2 = listMap.get("extend2");
        msgTitle = listMap.get("msgTitle");
        extend1 = listMap.get("extend1");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        userId = listMap.get("userId");
        msgStatus = listMap.get("msgStatus");
        }

    public ShiguSellerAppMsgExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguSellerAppMsgExample.Criteria createCriteriaInternal() {
        return new ShiguSellerAppMsgExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgIsNull() {
            return isNull(msg);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgIsNotNull() {
            return isNotNull(msg);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgEqualTo(String value) {
            return equalTo(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgNotEqualTo(String value) {
            return notEqualTo(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgGreaterThan(String value) {
            return greaterThan(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgLessThan(String value) {
            return lessThan(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgLike(String value) {
            return like(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgNotLike(String value) {
            return notLike(msg, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgIn(List<String> values) {
            return in(msg, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgNotIn(List<String> values) {
            return notIn(msg, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgBetween(String value1, String value2) {
            return between(msg, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgNotBetween(String value1, String value2) {
            return notBetween(msg, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andMsgTypeIsNull() {
            return isNull(msgType);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeIsNotNull() {
            return isNotNull(msgType);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeEqualTo(Integer value) {
            return equalTo(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeNotEqualTo(Integer value) {
            return notEqualTo(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeGreaterThan(Integer value) {
            return greaterThan(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeLessThan(Integer value) {
            return lessThan(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(msgType, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeIn(List<Integer> values) {
            return in(msgType, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeNotIn(List<Integer> values) {
            return notIn(msgType, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeBetween(Integer value1, Integer value2) {
            return between(msgType, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(msgType, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andExtend2IsNull() {
            return isNull(extend2);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2IsNotNull() {
            return isNotNull(extend2);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2EqualTo(String value) {
            return equalTo(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2NotEqualTo(String value) {
            return notEqualTo(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2GreaterThan(String value) {
            return greaterThan(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2LessThan(String value) {
            return lessThan(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2Like(String value) {
            return like(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2NotLike(String value) {
            return notLike(extend2, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2In(List<String> values) {
            return in(extend2, values);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2NotIn(List<String> values) {
            return notIn(extend2, values);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2Between(String value1, String value2) {
            return between(extend2, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend2NotBetween(String value1, String value2) {
            return notBetween(extend2, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andMsgTitleIsNull() {
            return isNull(msgTitle);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleIsNotNull() {
            return isNotNull(msgTitle);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleEqualTo(String value) {
            return equalTo(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleNotEqualTo(String value) {
            return notEqualTo(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleGreaterThan(String value) {
            return greaterThan(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleLessThan(String value) {
            return lessThan(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleLike(String value) {
            return like(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleNotLike(String value) {
            return notLike(msgTitle, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleIn(List<String> values) {
            return in(msgTitle, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleNotIn(List<String> values) {
            return notIn(msgTitle, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleBetween(String value1, String value2) {
            return between(msgTitle, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgTitleNotBetween(String value1, String value2) {
            return notBetween(msgTitle, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andExtend1IsNull() {
            return isNull(extend1);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1IsNotNull() {
            return isNotNull(extend1);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1EqualTo(String value) {
            return equalTo(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1NotEqualTo(String value) {
            return notEqualTo(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1GreaterThan(String value) {
            return greaterThan(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1LessThan(String value) {
            return lessThan(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1Like(String value) {
            return like(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1NotLike(String value) {
            return notLike(extend1, value);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1In(List<String> values) {
            return in(extend1, values);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1NotIn(List<String> values) {
            return notIn(extend1, values);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1Between(String value1, String value2) {
            return between(extend1, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andExtend1NotBetween(String value1, String value2) {
            return notBetween(extend1, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguSellerAppMsgExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguSellerAppMsgExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguSellerAppMsgExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguSellerAppMsgExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguSellerAppMsgExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguSellerAppMsgExample.Criteria andMsgStatusIsNull() {
            return isNull(msgStatus);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusIsNotNull() {
            return isNotNull(msgStatus);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusEqualTo(Integer value) {
            return equalTo(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusNotEqualTo(Integer value) {
            return notEqualTo(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusGreaterThan(Integer value) {
            return greaterThan(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusLessThan(Integer value) {
            return lessThan(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(msgStatus, value);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusIn(List<Integer> values) {
            return in(msgStatus, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusNotIn(List<Integer> values) {
            return notIn(msgStatus, values);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusBetween(Integer value1, Integer value2) {
            return between(msgStatus, value1, value2);
        }

        public ShiguSellerAppMsgExample.Criteria andMsgStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(msgStatus, value1, value2);
        }
    }
}