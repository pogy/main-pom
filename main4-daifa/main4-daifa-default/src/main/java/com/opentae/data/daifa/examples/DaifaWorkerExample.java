package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaWorker;

import java.util.*;
public class DaifaWorkerExample extends SgExample<DaifaWorkerExample.Criteria> {
    public static final Class<DaifaWorker> beanClass = DaifaWorker.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaSellerId;
    public static EntityColumn dfGroupId;
    public static EntityColumn daifaWorker;
    public static EntityColumn password;
    public static EntityColumn userName;
    public static EntityColumn phone;
    public static EntityColumn workType;
    public static EntityColumn payBaoAccount;
    public static EntityColumn workerId;
    public static EntityColumn roleId;
    public static EntityColumn accountId;
    public static EntityColumn useStatus;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaSellerId = listMap.get("daifaSellerId");
        dfGroupId = listMap.get("dfGroupId");
        daifaWorker = listMap.get("daifaWorker");
        password = listMap.get("password");
        userName = listMap.get("userName");
        phone = listMap.get("phone");
        workType = listMap.get("workType");
        payBaoAccount = listMap.get("payBaoAccount");
        workerId = listMap.get("workerId");
        roleId = listMap.get("roleId");
        accountId = listMap.get("accountId");
        useStatus = listMap.get("useStatus");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
    }

    public DaifaWorkerExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaWorkerExample.Criteria createCriteriaInternal() {
        return new DaifaWorkerExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andDaifaSellerIdIsNull() {
            return isNull(daifaSellerId);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdIsNotNull() {
            return isNotNull(daifaSellerId);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdEqualTo(Long value) {
            return equalTo(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdNotEqualTo(Long value) {
            return notEqualTo(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdGreaterThan(Long value) {
            return greaterThan(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdLessThan(Long value) {
            return lessThan(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaSellerId, value);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdIn(List<Long> values) {
            return in(daifaSellerId, values);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdNotIn(List<Long> values) {
            return notIn(daifaSellerId, values);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdBetween(Long value1, Long value2) {
            return between(daifaSellerId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andDaifaSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaSellerId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andDfGroupIdIsNull() {
            return isNull(dfGroupId);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdIsNotNull() {
            return isNotNull(dfGroupId);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdEqualTo(Long value) {
            return equalTo(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdNotEqualTo(Long value) {
            return notEqualTo(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdGreaterThan(Long value) {
            return greaterThan(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdLessThan(Long value) {
            return lessThan(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfGroupId, value);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdIn(List<Long> values) {
            return in(dfGroupId, values);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdNotIn(List<Long> values) {
            return notIn(dfGroupId, values);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdBetween(Long value1, Long value2) {
            return between(dfGroupId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andDfGroupIdNotBetween(Long value1, Long value2) {
            return notBetween(dfGroupId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaWorkerExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaWorkerExample.Criteria andPasswordIsNull() {
            return isNull(password);
        }

        public DaifaWorkerExample.Criteria andPasswordIsNotNull() {
            return isNotNull(password);
        }

        public DaifaWorkerExample.Criteria andPasswordEqualTo(String value) {
            return equalTo(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordNotEqualTo(String value) {
            return notEqualTo(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordGreaterThan(String value) {
            return greaterThan(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordLessThan(String value) {
            return lessThan(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordLike(String value) {
            return like(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordNotLike(String value) {
            return notLike(password, value);
        }

        public DaifaWorkerExample.Criteria andPasswordIn(List<String> values) {
            return in(password, values);
        }

        public DaifaWorkerExample.Criteria andPasswordNotIn(List<String> values) {
            return notIn(password, values);
        }

        public DaifaWorkerExample.Criteria andPasswordBetween(String value1, String value2) {
            return between(password, value1, value2);
        }

        public DaifaWorkerExample.Criteria andPasswordNotBetween(String value1, String value2) {
            return notBetween(password, value1, value2);
        }
        public DaifaWorkerExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public DaifaWorkerExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public DaifaWorkerExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public DaifaWorkerExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public DaifaWorkerExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public DaifaWorkerExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public DaifaWorkerExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public DaifaWorkerExample.Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public DaifaWorkerExample.Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public DaifaWorkerExample.Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public DaifaWorkerExample.Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public DaifaWorkerExample.Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public DaifaWorkerExample.Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public DaifaWorkerExample.Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public DaifaWorkerExample.Criteria andWorkTypeIsNull() {
            return isNull(workType);
        }

        public DaifaWorkerExample.Criteria andWorkTypeIsNotNull() {
            return isNotNull(workType);
        }

        public DaifaWorkerExample.Criteria andWorkTypeEqualTo(Integer value) {
            return equalTo(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeNotEqualTo(Integer value) {
            return notEqualTo(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeGreaterThan(Integer value) {
            return greaterThan(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeLessThan(Integer value) {
            return lessThan(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(workType, value);
        }

        public DaifaWorkerExample.Criteria andWorkTypeIn(List<Integer> values) {
            return in(workType, values);
        }

        public DaifaWorkerExample.Criteria andWorkTypeNotIn(List<Integer> values) {
            return notIn(workType, values);
        }

        public DaifaWorkerExample.Criteria andWorkTypeBetween(Integer value1, Integer value2) {
            return between(workType, value1, value2);
        }

        public DaifaWorkerExample.Criteria andWorkTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(workType, value1, value2);
        }
        public DaifaWorkerExample.Criteria andPayBaoAccountIsNull() {
            return isNull(payBaoAccount);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountIsNotNull() {
            return isNotNull(payBaoAccount);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountEqualTo(String value) {
            return equalTo(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountNotEqualTo(String value) {
            return notEqualTo(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountGreaterThan(String value) {
            return greaterThan(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountLessThan(String value) {
            return lessThan(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountLike(String value) {
            return like(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountNotLike(String value) {
            return notLike(payBaoAccount, value);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountIn(List<String> values) {
            return in(payBaoAccount, values);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountNotIn(List<String> values) {
            return notIn(payBaoAccount, values);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountBetween(String value1, String value2) {
            return between(payBaoAccount, value1, value2);
        }

        public DaifaWorkerExample.Criteria andPayBaoAccountNotBetween(String value1, String value2) {
            return notBetween(payBaoAccount, value1, value2);
        }
        public DaifaWorkerExample.Criteria andWorkerIdIsNull() {
            return isNull(workerId);
        }

        public DaifaWorkerExample.Criteria andWorkerIdIsNotNull() {
            return isNotNull(workerId);
        }

        public DaifaWorkerExample.Criteria andWorkerIdEqualTo(Long value) {
            return equalTo(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdNotEqualTo(Long value) {
            return notEqualTo(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdGreaterThan(Long value) {
            return greaterThan(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdLessThan(Long value) {
            return lessThan(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(workerId, value);
        }

        public DaifaWorkerExample.Criteria andWorkerIdIn(List<Long> values) {
            return in(workerId, values);
        }

        public DaifaWorkerExample.Criteria andWorkerIdNotIn(List<Long> values) {
            return notIn(workerId, values);
        }

        public DaifaWorkerExample.Criteria andWorkerIdBetween(Long value1, Long value2) {
            return between(workerId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(workerId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public DaifaWorkerExample.Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public DaifaWorkerExample.Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public DaifaWorkerExample.Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public DaifaWorkerExample.Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public DaifaWorkerExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public DaifaWorkerExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public DaifaWorkerExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public DaifaWorkerExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public DaifaWorkerExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public DaifaWorkerExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public DaifaWorkerExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public DaifaWorkerExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaWorkerExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaWorkerExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaWorkerExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaWorkerExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaWorkerExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaWorkerExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaWorkerExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaWorkerExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaWorkerExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaWorkerExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaWorkerExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaWorkerExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaWorkerExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaWorkerExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaWorkerExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaWorkerExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaWorkerExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaWorkerExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaWorkerExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaWorkerExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}