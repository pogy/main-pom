package com.opentae.data.mana.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mana.beans.UserAction;

import java.util.*;
public class UserActionExample extends SgExample<UserActionExample.Criteria> {
    public static final Class<UserAction> beanClass = UserAction.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModif;
    public static EntityColumn ip;
    public static EntityColumn action;
    public static EntityColumn id;
    public static EntityColumn time;
    public static EntityColumn gmtCreate;
    public static EntityColumn params;
    public static EntityColumn userId;
    public static EntityColumn url;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModif = listMap.get("gmtModif");
        ip = listMap.get("ip");
        action = listMap.get("action");
        id = listMap.get("id");
        time = listMap.get("time");
        gmtCreate = listMap.get("gmtCreate");
        params = listMap.get("params");
        userId = listMap.get("userId");
        url = listMap.get("url");
        }

    public UserActionExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected UserActionExample.Criteria createCriteriaInternal() {
        return new UserActionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public UserActionExample.Criteria andGmtModifIsNull() {
            return isNull(gmtModif);
        }

        public UserActionExample.Criteria andGmtModifIsNotNull() {
            return isNotNull(gmtModif);
        }

        public UserActionExample.Criteria andGmtModifEqualTo(Date value) {
            return equalTo(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifNotEqualTo(Date value) {
            return notEqualTo(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifGreaterThan(Date value) {
            return greaterThan(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifLessThan(Date value) {
            return lessThan(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModif, value);
        }

        public UserActionExample.Criteria andGmtModifIn(List<Date> values) {
            return in(gmtModif, values);
        }

        public UserActionExample.Criteria andGmtModifNotIn(List<Date> values) {
            return notIn(gmtModif, values);
        }

        public UserActionExample.Criteria andGmtModifBetween(Date value1, Date value2) {
            return between(gmtModif, value1, value2);
        }

        public UserActionExample.Criteria andGmtModifNotBetween(Date value1, Date value2) {
            return notBetween(gmtModif, value1, value2);
        }
        public UserActionExample.Criteria andIpIsNull() {
            return isNull(ip);
        }

        public UserActionExample.Criteria andIpIsNotNull() {
            return isNotNull(ip);
        }

        public UserActionExample.Criteria andIpEqualTo(String value) {
            return equalTo(ip, value);
        }

        public UserActionExample.Criteria andIpNotEqualTo(String value) {
            return notEqualTo(ip, value);
        }

        public UserActionExample.Criteria andIpGreaterThan(String value) {
            return greaterThan(ip, value);
        }

        public UserActionExample.Criteria andIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ip, value);
        }

        public UserActionExample.Criteria andIpLessThan(String value) {
            return lessThan(ip, value);
        }

        public UserActionExample.Criteria andIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ip, value);
        }

        public UserActionExample.Criteria andIpLike(String value) {
            return like(ip, value);
        }

        public UserActionExample.Criteria andIpNotLike(String value) {
            return notLike(ip, value);
        }

        public UserActionExample.Criteria andIpIn(List<String> values) {
            return in(ip, values);
        }

        public UserActionExample.Criteria andIpNotIn(List<String> values) {
            return notIn(ip, values);
        }

        public UserActionExample.Criteria andIpBetween(String value1, String value2) {
            return between(ip, value1, value2);
        }

        public UserActionExample.Criteria andIpNotBetween(String value1, String value2) {
            return notBetween(ip, value1, value2);
        }
        public UserActionExample.Criteria andActionIsNull() {
            return isNull(action);
        }

        public UserActionExample.Criteria andActionIsNotNull() {
            return isNotNull(action);
        }

        public UserActionExample.Criteria andActionEqualTo(String value) {
            return equalTo(action, value);
        }

        public UserActionExample.Criteria andActionNotEqualTo(String value) {
            return notEqualTo(action, value);
        }

        public UserActionExample.Criteria andActionGreaterThan(String value) {
            return greaterThan(action, value);
        }

        public UserActionExample.Criteria andActionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(action, value);
        }

        public UserActionExample.Criteria andActionLessThan(String value) {
            return lessThan(action, value);
        }

        public UserActionExample.Criteria andActionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(action, value);
        }

        public UserActionExample.Criteria andActionLike(String value) {
            return like(action, value);
        }

        public UserActionExample.Criteria andActionNotLike(String value) {
            return notLike(action, value);
        }

        public UserActionExample.Criteria andActionIn(List<String> values) {
            return in(action, values);
        }

        public UserActionExample.Criteria andActionNotIn(List<String> values) {
            return notIn(action, values);
        }

        public UserActionExample.Criteria andActionBetween(String value1, String value2) {
            return between(action, value1, value2);
        }

        public UserActionExample.Criteria andActionNotBetween(String value1, String value2) {
            return notBetween(action, value1, value2);
        }
        public UserActionExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public UserActionExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public UserActionExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public UserActionExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public UserActionExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public UserActionExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public UserActionExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public UserActionExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public UserActionExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public UserActionExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public UserActionExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public UserActionExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public UserActionExample.Criteria andTimeIsNull() {
            return isNull(time);
        }

        public UserActionExample.Criteria andTimeIsNotNull() {
            return isNotNull(time);
        }

        public UserActionExample.Criteria andTimeEqualTo(Integer value) {
            return equalTo(time, value);
        }

        public UserActionExample.Criteria andTimeNotEqualTo(Integer value) {
            return notEqualTo(time, value);
        }

        public UserActionExample.Criteria andTimeGreaterThan(Integer value) {
            return greaterThan(time, value);
        }

        public UserActionExample.Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(time, value);
        }

        public UserActionExample.Criteria andTimeLessThan(Integer value) {
            return lessThan(time, value);
        }

        public UserActionExample.Criteria andTimeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(time, value);
        }

        public UserActionExample.Criteria andTimeIn(List<Integer> values) {
            return in(time, values);
        }

        public UserActionExample.Criteria andTimeNotIn(List<Integer> values) {
            return notIn(time, values);
        }

        public UserActionExample.Criteria andTimeBetween(Integer value1, Integer value2) {
            return between(time, value1, value2);
        }

        public UserActionExample.Criteria andTimeNotBetween(Integer value1, Integer value2) {
            return notBetween(time, value1, value2);
        }
        public UserActionExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public UserActionExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public UserActionExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public UserActionExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public UserActionExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public UserActionExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public UserActionExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public UserActionExample.Criteria andParamsIsNull() {
            return isNull(params);
        }

        public UserActionExample.Criteria andParamsIsNotNull() {
            return isNotNull(params);
        }

        public UserActionExample.Criteria andParamsEqualTo(String value) {
            return equalTo(params, value);
        }

        public UserActionExample.Criteria andParamsNotEqualTo(String value) {
            return notEqualTo(params, value);
        }

        public UserActionExample.Criteria andParamsGreaterThan(String value) {
            return greaterThan(params, value);
        }

        public UserActionExample.Criteria andParamsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(params, value);
        }

        public UserActionExample.Criteria andParamsLessThan(String value) {
            return lessThan(params, value);
        }

        public UserActionExample.Criteria andParamsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(params, value);
        }

        public UserActionExample.Criteria andParamsLike(String value) {
            return like(params, value);
        }

        public UserActionExample.Criteria andParamsNotLike(String value) {
            return notLike(params, value);
        }

        public UserActionExample.Criteria andParamsIn(List<String> values) {
            return in(params, values);
        }

        public UserActionExample.Criteria andParamsNotIn(List<String> values) {
            return notIn(params, values);
        }

        public UserActionExample.Criteria andParamsBetween(String value1, String value2) {
            return between(params, value1, value2);
        }

        public UserActionExample.Criteria andParamsNotBetween(String value1, String value2) {
            return notBetween(params, value1, value2);
        }
        public UserActionExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public UserActionExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public UserActionExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public UserActionExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public UserActionExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public UserActionExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public UserActionExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public UserActionExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public UserActionExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public UserActionExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public UserActionExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public UserActionExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public UserActionExample.Criteria andUrlIsNull() {
            return isNull(url);
        }

        public UserActionExample.Criteria andUrlIsNotNull() {
            return isNotNull(url);
        }

        public UserActionExample.Criteria andUrlEqualTo(String value) {
            return equalTo(url, value);
        }

        public UserActionExample.Criteria andUrlNotEqualTo(String value) {
            return notEqualTo(url, value);
        }

        public UserActionExample.Criteria andUrlGreaterThan(String value) {
            return greaterThan(url, value);
        }

        public UserActionExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(url, value);
        }

        public UserActionExample.Criteria andUrlLessThan(String value) {
            return lessThan(url, value);
        }

        public UserActionExample.Criteria andUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(url, value);
        }

        public UserActionExample.Criteria andUrlLike(String value) {
            return like(url, value);
        }

        public UserActionExample.Criteria andUrlNotLike(String value) {
            return notLike(url, value);
        }

        public UserActionExample.Criteria andUrlIn(List<String> values) {
            return in(url, values);
        }

        public UserActionExample.Criteria andUrlNotIn(List<String> values) {
            return notIn(url, values);
        }

        public UserActionExample.Criteria andUrlBetween(String value1, String value2) {
            return between(url, value1, value2);
        }

        public UserActionExample.Criteria andUrlNotBetween(String value1, String value2) {
            return notBetween(url, value1, value2);
        }
    }
}