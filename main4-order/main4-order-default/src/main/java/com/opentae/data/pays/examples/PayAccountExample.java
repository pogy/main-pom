package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayAccount;

import java.util.*;
public class PayAccountExample extends SgExample<PayAccountExample.Criteria> {
    public static final Class<PayAccount> beanClass = PayAccount.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn wxUserId;
    public static EntityColumn accountType;
    public static EntityColumn groupId;
    public static EntityColumn xzUserName;
    public static EntityColumn statue;
    public static EntityColumn accountId;
    public static EntityColumn password;
    public static EntityColumn createTime;
    public static EntityColumn workType;
    public static EntityColumn wxUserName;
    public static EntityColumn alipayUserName;
    public static EntityColumn xzUserId;
    public static EntityColumn alipayUserId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        wxUserId = listMap.get("wxUserId");
        accountType = listMap.get("accountType");
        groupId = listMap.get("groupId");
        xzUserName = listMap.get("xzUserName");
        statue = listMap.get("statue");
        accountId = listMap.get("accountId");
        password = listMap.get("password");
        createTime = listMap.get("createTime");
        workType = listMap.get("workType");
        wxUserName = listMap.get("wxUserName");
        alipayUserName = listMap.get("alipayUserName");
        xzUserId = listMap.get("xzUserId");
        alipayUserId = listMap.get("alipayUserId");
        }

    public PayAccountExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayAccountExample.Criteria createCriteriaInternal() {
        return new PayAccountExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayAccountExample.Criteria andWxUserIdIsNull() {
            return isNull(wxUserId);
        }

        public PayAccountExample.Criteria andWxUserIdIsNotNull() {
            return isNotNull(wxUserId);
        }

        public PayAccountExample.Criteria andWxUserIdEqualTo(String value) {
            return equalTo(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdNotEqualTo(String value) {
            return notEqualTo(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdGreaterThan(String value) {
            return greaterThan(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdLessThan(String value) {
            return lessThan(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdLike(String value) {
            return like(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdNotLike(String value) {
            return notLike(wxUserId, value);
        }

        public PayAccountExample.Criteria andWxUserIdIn(List<String> values) {
            return in(wxUserId, values);
        }

        public PayAccountExample.Criteria andWxUserIdNotIn(List<String> values) {
            return notIn(wxUserId, values);
        }

        public PayAccountExample.Criteria andWxUserIdBetween(String value1, String value2) {
            return between(wxUserId, value1, value2);
        }

        public PayAccountExample.Criteria andWxUserIdNotBetween(String value1, String value2) {
            return notBetween(wxUserId, value1, value2);
        }
        public PayAccountExample.Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public PayAccountExample.Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public PayAccountExample.Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public PayAccountExample.Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public PayAccountExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public PayAccountExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public PayAccountExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public PayAccountExample.Criteria andGroupIdIsNull() {
            return isNull(groupId);
        }

        public PayAccountExample.Criteria andGroupIdIsNotNull() {
            return isNotNull(groupId);
        }

        public PayAccountExample.Criteria andGroupIdEqualTo(Long value) {
            return equalTo(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdNotEqualTo(Long value) {
            return notEqualTo(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdGreaterThan(Long value) {
            return greaterThan(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdLessThan(Long value) {
            return lessThan(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(groupId, value);
        }

        public PayAccountExample.Criteria andGroupIdIn(List<Long> values) {
            return in(groupId, values);
        }

        public PayAccountExample.Criteria andGroupIdNotIn(List<Long> values) {
            return notIn(groupId, values);
        }

        public PayAccountExample.Criteria andGroupIdBetween(Long value1, Long value2) {
            return between(groupId, value1, value2);
        }

        public PayAccountExample.Criteria andGroupIdNotBetween(Long value1, Long value2) {
            return notBetween(groupId, value1, value2);
        }
        public PayAccountExample.Criteria andXzUserNameIsNull() {
            return isNull(xzUserName);
        }

        public PayAccountExample.Criteria andXzUserNameIsNotNull() {
            return isNotNull(xzUserName);
        }

        public PayAccountExample.Criteria andXzUserNameEqualTo(String value) {
            return equalTo(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameNotEqualTo(String value) {
            return notEqualTo(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameGreaterThan(String value) {
            return greaterThan(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameLessThan(String value) {
            return lessThan(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameLike(String value) {
            return like(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameNotLike(String value) {
            return notLike(xzUserName, value);
        }

        public PayAccountExample.Criteria andXzUserNameIn(List<String> values) {
            return in(xzUserName, values);
        }

        public PayAccountExample.Criteria andXzUserNameNotIn(List<String> values) {
            return notIn(xzUserName, values);
        }

        public PayAccountExample.Criteria andXzUserNameBetween(String value1, String value2) {
            return between(xzUserName, value1, value2);
        }

        public PayAccountExample.Criteria andXzUserNameNotBetween(String value1, String value2) {
            return notBetween(xzUserName, value1, value2);
        }
        public PayAccountExample.Criteria andStatueIsNull() {
            return isNull(statue);
        }

        public PayAccountExample.Criteria andStatueIsNotNull() {
            return isNotNull(statue);
        }

        public PayAccountExample.Criteria andStatueEqualTo(Integer value) {
            return equalTo(statue, value);
        }

        public PayAccountExample.Criteria andStatueNotEqualTo(Integer value) {
            return notEqualTo(statue, value);
        }

        public PayAccountExample.Criteria andStatueGreaterThan(Integer value) {
            return greaterThan(statue, value);
        }

        public PayAccountExample.Criteria andStatueGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(statue, value);
        }

        public PayAccountExample.Criteria andStatueLessThan(Integer value) {
            return lessThan(statue, value);
        }

        public PayAccountExample.Criteria andStatueLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(statue, value);
        }

        public PayAccountExample.Criteria andStatueIn(List<Integer> values) {
            return in(statue, values);
        }

        public PayAccountExample.Criteria andStatueNotIn(List<Integer> values) {
            return notIn(statue, values);
        }

        public PayAccountExample.Criteria andStatueBetween(Integer value1, Integer value2) {
            return between(statue, value1, value2);
        }

        public PayAccountExample.Criteria andStatueNotBetween(Integer value1, Integer value2) {
            return notBetween(statue, value1, value2);
        }
        public PayAccountExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public PayAccountExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public PayAccountExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public PayAccountExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public PayAccountExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public PayAccountExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public PayAccountExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public PayAccountExample.Criteria andPasswordIsNull() {
            return isNull(password);
        }

        public PayAccountExample.Criteria andPasswordIsNotNull() {
            return isNotNull(password);
        }

        public PayAccountExample.Criteria andPasswordEqualTo(String value) {
            return equalTo(password, value);
        }

        public PayAccountExample.Criteria andPasswordNotEqualTo(String value) {
            return notEqualTo(password, value);
        }

        public PayAccountExample.Criteria andPasswordGreaterThan(String value) {
            return greaterThan(password, value);
        }

        public PayAccountExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(password, value);
        }

        public PayAccountExample.Criteria andPasswordLessThan(String value) {
            return lessThan(password, value);
        }

        public PayAccountExample.Criteria andPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(password, value);
        }

        public PayAccountExample.Criteria andPasswordLike(String value) {
            return like(password, value);
        }

        public PayAccountExample.Criteria andPasswordNotLike(String value) {
            return notLike(password, value);
        }

        public PayAccountExample.Criteria andPasswordIn(List<String> values) {
            return in(password, values);
        }

        public PayAccountExample.Criteria andPasswordNotIn(List<String> values) {
            return notIn(password, values);
        }

        public PayAccountExample.Criteria andPasswordBetween(String value1, String value2) {
            return between(password, value1, value2);
        }

        public PayAccountExample.Criteria andPasswordNotBetween(String value1, String value2) {
            return notBetween(password, value1, value2);
        }
        public PayAccountExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayAccountExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayAccountExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayAccountExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayAccountExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayAccountExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayAccountExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayAccountExample.Criteria andWorkTypeIsNull() {
            return isNull(workType);
        }

        public PayAccountExample.Criteria andWorkTypeIsNotNull() {
            return isNotNull(workType);
        }

        public PayAccountExample.Criteria andWorkTypeEqualTo(Integer value) {
            return equalTo(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeNotEqualTo(Integer value) {
            return notEqualTo(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeGreaterThan(Integer value) {
            return greaterThan(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeLessThan(Integer value) {
            return lessThan(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(workType, value);
        }

        public PayAccountExample.Criteria andWorkTypeIn(List<Integer> values) {
            return in(workType, values);
        }

        public PayAccountExample.Criteria andWorkTypeNotIn(List<Integer> values) {
            return notIn(workType, values);
        }

        public PayAccountExample.Criteria andWorkTypeBetween(Integer value1, Integer value2) {
            return between(workType, value1, value2);
        }

        public PayAccountExample.Criteria andWorkTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(workType, value1, value2);
        }
        public PayAccountExample.Criteria andWxUserNameIsNull() {
            return isNull(wxUserName);
        }

        public PayAccountExample.Criteria andWxUserNameIsNotNull() {
            return isNotNull(wxUserName);
        }

        public PayAccountExample.Criteria andWxUserNameEqualTo(String value) {
            return equalTo(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameNotEqualTo(String value) {
            return notEqualTo(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameGreaterThan(String value) {
            return greaterThan(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameLessThan(String value) {
            return lessThan(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameLike(String value) {
            return like(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameNotLike(String value) {
            return notLike(wxUserName, value);
        }

        public PayAccountExample.Criteria andWxUserNameIn(List<String> values) {
            return in(wxUserName, values);
        }

        public PayAccountExample.Criteria andWxUserNameNotIn(List<String> values) {
            return notIn(wxUserName, values);
        }

        public PayAccountExample.Criteria andWxUserNameBetween(String value1, String value2) {
            return between(wxUserName, value1, value2);
        }

        public PayAccountExample.Criteria andWxUserNameNotBetween(String value1, String value2) {
            return notBetween(wxUserName, value1, value2);
        }
        public PayAccountExample.Criteria andAlipayUserNameIsNull() {
            return isNull(alipayUserName);
        }

        public PayAccountExample.Criteria andAlipayUserNameIsNotNull() {
            return isNotNull(alipayUserName);
        }

        public PayAccountExample.Criteria andAlipayUserNameEqualTo(String value) {
            return equalTo(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameNotEqualTo(String value) {
            return notEqualTo(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameGreaterThan(String value) {
            return greaterThan(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameLessThan(String value) {
            return lessThan(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameLike(String value) {
            return like(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameNotLike(String value) {
            return notLike(alipayUserName, value);
        }

        public PayAccountExample.Criteria andAlipayUserNameIn(List<String> values) {
            return in(alipayUserName, values);
        }

        public PayAccountExample.Criteria andAlipayUserNameNotIn(List<String> values) {
            return notIn(alipayUserName, values);
        }

        public PayAccountExample.Criteria andAlipayUserNameBetween(String value1, String value2) {
            return between(alipayUserName, value1, value2);
        }

        public PayAccountExample.Criteria andAlipayUserNameNotBetween(String value1, String value2) {
            return notBetween(alipayUserName, value1, value2);
        }
        public PayAccountExample.Criteria andXzUserIdIsNull() {
            return isNull(xzUserId);
        }

        public PayAccountExample.Criteria andXzUserIdIsNotNull() {
            return isNotNull(xzUserId);
        }

        public PayAccountExample.Criteria andXzUserIdEqualTo(Long value) {
            return equalTo(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdNotEqualTo(Long value) {
            return notEqualTo(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdGreaterThan(Long value) {
            return greaterThan(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdLessThan(Long value) {
            return lessThan(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(xzUserId, value);
        }

        public PayAccountExample.Criteria andXzUserIdIn(List<Long> values) {
            return in(xzUserId, values);
        }

        public PayAccountExample.Criteria andXzUserIdNotIn(List<Long> values) {
            return notIn(xzUserId, values);
        }

        public PayAccountExample.Criteria andXzUserIdBetween(Long value1, Long value2) {
            return between(xzUserId, value1, value2);
        }

        public PayAccountExample.Criteria andXzUserIdNotBetween(Long value1, Long value2) {
            return notBetween(xzUserId, value1, value2);
        }
        public PayAccountExample.Criteria andAlipayUserIdIsNull() {
            return isNull(alipayUserId);
        }

        public PayAccountExample.Criteria andAlipayUserIdIsNotNull() {
            return isNotNull(alipayUserId);
        }

        public PayAccountExample.Criteria andAlipayUserIdEqualTo(String value) {
            return equalTo(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdNotEqualTo(String value) {
            return notEqualTo(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdGreaterThan(String value) {
            return greaterThan(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdLessThan(String value) {
            return lessThan(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdLike(String value) {
            return like(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdNotLike(String value) {
            return notLike(alipayUserId, value);
        }

        public PayAccountExample.Criteria andAlipayUserIdIn(List<String> values) {
            return in(alipayUserId, values);
        }

        public PayAccountExample.Criteria andAlipayUserIdNotIn(List<String> values) {
            return notIn(alipayUserId, values);
        }

        public PayAccountExample.Criteria andAlipayUserIdBetween(String value1, String value2) {
            return between(alipayUserId, value1, value2);
        }

        public PayAccountExample.Criteria andAlipayUserIdNotBetween(String value1, String value2) {
            return notBetween(alipayUserId, value1, value2);
        }
    }
}