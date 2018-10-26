package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguBonus;

import java.util.*;
public class ShiguBonusExample extends SgExample<ShiguBonusExample.Criteria> {
    public static final Class<ShiguBonus> beanClass = ShiguBonus.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn jdThirdId;
    public static EntityColumn balance;
    public static EntityColumn thirdId;
    public static EntityColumn createTime;
    public static EntityColumn updateTime;
    public static EntityColumn id;
    public static EntityColumn type;
    public static EntityColumn userId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        jdThirdId = listMap.get("jdThirdId");
        balance = listMap.get("balance");
        thirdId = listMap.get("thirdId");
        createTime = listMap.get("createTime");
        updateTime = listMap.get("updateTime");
        id = listMap.get("id");
        type = listMap.get("type");
        userId = listMap.get("userId");
        status = listMap.get("status");
        }

    public ShiguBonusExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguBonusExample.Criteria createCriteriaInternal() {
        return new ShiguBonusExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguBonusExample.Criteria andJdThirdIdIsNull() {
            return isNull(jdThirdId);
        }

        public ShiguBonusExample.Criteria andJdThirdIdIsNotNull() {
            return isNotNull(jdThirdId);
        }

        public ShiguBonusExample.Criteria andJdThirdIdEqualTo(String value) {
            return equalTo(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdNotEqualTo(String value) {
            return notEqualTo(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdGreaterThan(String value) {
            return greaterThan(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdLessThan(String value) {
            return lessThan(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdLike(String value) {
            return like(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdNotLike(String value) {
            return notLike(jdThirdId, value);
        }

        public ShiguBonusExample.Criteria andJdThirdIdIn(List<String> values) {
            return in(jdThirdId, values);
        }

        public ShiguBonusExample.Criteria andJdThirdIdNotIn(List<String> values) {
            return notIn(jdThirdId, values);
        }

        public ShiguBonusExample.Criteria andJdThirdIdBetween(String value1, String value2) {
            return between(jdThirdId, value1, value2);
        }

        public ShiguBonusExample.Criteria andJdThirdIdNotBetween(String value1, String value2) {
            return notBetween(jdThirdId, value1, value2);
        }
        public ShiguBonusExample.Criteria andBalanceIsNull() {
            return isNull(balance);
        }

        public ShiguBonusExample.Criteria andBalanceIsNotNull() {
            return isNotNull(balance);
        }

        public ShiguBonusExample.Criteria andBalanceEqualTo(Long value) {
            return equalTo(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceNotEqualTo(Long value) {
            return notEqualTo(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceGreaterThan(Long value) {
            return greaterThan(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceLessThan(Long value) {
            return lessThan(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(balance, value);
        }

        public ShiguBonusExample.Criteria andBalanceIn(List<Long> values) {
            return in(balance, values);
        }

        public ShiguBonusExample.Criteria andBalanceNotIn(List<Long> values) {
            return notIn(balance, values);
        }

        public ShiguBonusExample.Criteria andBalanceBetween(Long value1, Long value2) {
            return between(balance, value1, value2);
        }

        public ShiguBonusExample.Criteria andBalanceNotBetween(Long value1, Long value2) {
            return notBetween(balance, value1, value2);
        }
        public ShiguBonusExample.Criteria andThirdIdIsNull() {
            return isNull(thirdId);
        }

        public ShiguBonusExample.Criteria andThirdIdIsNotNull() {
            return isNotNull(thirdId);
        }

        public ShiguBonusExample.Criteria andThirdIdEqualTo(String value) {
            return equalTo(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdNotEqualTo(String value) {
            return notEqualTo(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdGreaterThan(String value) {
            return greaterThan(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdLessThan(String value) {
            return lessThan(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdLike(String value) {
            return like(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdNotLike(String value) {
            return notLike(thirdId, value);
        }

        public ShiguBonusExample.Criteria andThirdIdIn(List<String> values) {
            return in(thirdId, values);
        }

        public ShiguBonusExample.Criteria andThirdIdNotIn(List<String> values) {
            return notIn(thirdId, values);
        }

        public ShiguBonusExample.Criteria andThirdIdBetween(String value1, String value2) {
            return between(thirdId, value1, value2);
        }

        public ShiguBonusExample.Criteria andThirdIdNotBetween(String value1, String value2) {
            return notBetween(thirdId, value1, value2);
        }
        public ShiguBonusExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguBonusExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguBonusExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguBonusExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguBonusExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguBonusExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguBonusExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguBonusExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public ShiguBonusExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public ShiguBonusExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public ShiguBonusExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public ShiguBonusExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public ShiguBonusExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public ShiguBonusExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public ShiguBonusExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguBonusExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguBonusExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguBonusExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguBonusExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguBonusExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguBonusExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguBonusExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguBonusExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguBonusExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguBonusExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguBonusExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguBonusExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguBonusExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguBonusExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShiguBonusExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShiguBonusExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShiguBonusExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguBonusExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShiguBonusExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguBonusExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShiguBonusExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShiguBonusExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShiguBonusExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguBonusExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguBonusExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguBonusExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguBonusExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguBonusExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguBonusExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguBonusExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguBonusExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguBonusExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguBonusExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguBonusExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguBonusExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguBonusExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguBonusExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguBonusExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguBonusExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguBonusExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguBonusExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguBonusExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}