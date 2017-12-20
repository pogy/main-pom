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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public Criteria andDaifaSellerIdIsNull() {
            return isNull(daifaSellerId);
        }

        public Criteria andDaifaSellerIdIsNotNull() {
            return isNotNull(daifaSellerId);
        }

        public Criteria andDaifaSellerIdEqualTo(Long value) {
            return equalTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdNotEqualTo(Long value) {
            return notEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdGreaterThan(Long value) {
            return greaterThan(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdLessThan(Long value) {
            return lessThan(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdIn(List<Long> values) {
            return in(daifaSellerId, values);
        }

        public Criteria andDaifaSellerIdNotIn(List<Long> values) {
            return notIn(daifaSellerId, values);
        }

        public Criteria andDaifaSellerIdBetween(Long value1, Long value2) {
            return between(daifaSellerId, value1, value2);
        }

        public Criteria andDaifaSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaSellerId, value1, value2);
        }
        public Criteria andDfGroupIdIsNull() {
            return isNull(dfGroupId);
        }

        public Criteria andDfGroupIdIsNotNull() {
            return isNotNull(dfGroupId);
        }

        public Criteria andDfGroupIdEqualTo(Long value) {
            return equalTo(dfGroupId, value);
        }

        public Criteria andDfGroupIdNotEqualTo(Long value) {
            return notEqualTo(dfGroupId, value);
        }

        public Criteria andDfGroupIdGreaterThan(Long value) {
            return greaterThan(dfGroupId, value);
        }

        public Criteria andDfGroupIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfGroupId, value);
        }

        public Criteria andDfGroupIdLessThan(Long value) {
            return lessThan(dfGroupId, value);
        }

        public Criteria andDfGroupIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfGroupId, value);
        }

        public Criteria andDfGroupIdIn(List<Long> values) {
            return in(dfGroupId, values);
        }

        public Criteria andDfGroupIdNotIn(List<Long> values) {
            return notIn(dfGroupId, values);
        }

        public Criteria andDfGroupIdBetween(Long value1, Long value2) {
            return between(dfGroupId, value1, value2);
        }

        public Criteria andDfGroupIdNotBetween(Long value1, Long value2) {
            return notBetween(dfGroupId, value1, value2);
        }
        public Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public Criteria andPasswordIsNull() {
            return isNull(password);
        }

        public Criteria andPasswordIsNotNull() {
            return isNotNull(password);
        }

        public Criteria andPasswordEqualTo(String value) {
            return equalTo(password, value);
        }

        public Criteria andPasswordNotEqualTo(String value) {
            return notEqualTo(password, value);
        }

        public Criteria andPasswordGreaterThan(String value) {
            return greaterThan(password, value);
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(password, value);
        }

        public Criteria andPasswordLessThan(String value) {
            return lessThan(password, value);
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(password, value);
        }

        public Criteria andPasswordLike(String value) {
            return like(password, value);
        }

        public Criteria andPasswordNotLike(String value) {
            return notLike(password, value);
        }

        public Criteria andPasswordIn(List<String> values) {
            return in(password, values);
        }

        public Criteria andPasswordNotIn(List<String> values) {
            return notIn(password, values);
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            return between(password, value1, value2);
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            return notBetween(password, value1, value2);
        }
        public Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public Criteria andWorkTypeIsNull() {
            return isNull(workType);
        }

        public Criteria andWorkTypeIsNotNull() {
            return isNotNull(workType);
        }

        public Criteria andWorkTypeEqualTo(Integer value) {
            return equalTo(workType, value);
        }

        public Criteria andWorkTypeNotEqualTo(Integer value) {
            return notEqualTo(workType, value);
        }

        public Criteria andWorkTypeGreaterThan(Integer value) {
            return greaterThan(workType, value);
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(workType, value);
        }

        public Criteria andWorkTypeLessThan(Integer value) {
            return lessThan(workType, value);
        }

        public Criteria andWorkTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(workType, value);
        }

        public Criteria andWorkTypeIn(List<Integer> values) {
            return in(workType, values);
        }

        public Criteria andWorkTypeNotIn(List<Integer> values) {
            return notIn(workType, values);
        }

        public Criteria andWorkTypeBetween(Integer value1, Integer value2) {
            return between(workType, value1, value2);
        }

        public Criteria andWorkTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(workType, value1, value2);
        }
        public Criteria andPayBaoAccountIsNull() {
            return isNull(payBaoAccount);
        }

        public Criteria andPayBaoAccountIsNotNull() {
            return isNotNull(payBaoAccount);
        }

        public Criteria andPayBaoAccountEqualTo(String value) {
            return equalTo(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountNotEqualTo(String value) {
            return notEqualTo(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountGreaterThan(String value) {
            return greaterThan(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountLessThan(String value) {
            return lessThan(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountLike(String value) {
            return like(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountNotLike(String value) {
            return notLike(payBaoAccount, value);
        }

        public Criteria andPayBaoAccountIn(List<String> values) {
            return in(payBaoAccount, values);
        }

        public Criteria andPayBaoAccountNotIn(List<String> values) {
            return notIn(payBaoAccount, values);
        }

        public Criteria andPayBaoAccountBetween(String value1, String value2) {
            return between(payBaoAccount, value1, value2);
        }

        public Criteria andPayBaoAccountNotBetween(String value1, String value2) {
            return notBetween(payBaoAccount, value1, value2);
        }
        public Criteria andWorkerIdIsNull() {
            return isNull(workerId);
        }

        public Criteria andWorkerIdIsNotNull() {
            return isNotNull(workerId);
        }

        public Criteria andWorkerIdEqualTo(Long value) {
            return equalTo(workerId, value);
        }

        public Criteria andWorkerIdNotEqualTo(Long value) {
            return notEqualTo(workerId, value);
        }

        public Criteria andWorkerIdGreaterThan(Long value) {
            return greaterThan(workerId, value);
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(workerId, value);
        }

        public Criteria andWorkerIdLessThan(Long value) {
            return lessThan(workerId, value);
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(workerId, value);
        }

        public Criteria andWorkerIdIn(List<Long> values) {
            return in(workerId, values);
        }

        public Criteria andWorkerIdNotIn(List<Long> values) {
            return notIn(workerId, values);
        }

        public Criteria andWorkerIdBetween(Long value1, Long value2) {
            return between(workerId, value1, value2);
        }

        public Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(workerId, value1, value2);
        }
        public Criteria andRoleIdIsNull() {
            return isNull(roleId);
        }

        public Criteria andRoleIdIsNotNull() {
            return isNotNull(roleId);
        }

        public Criteria andRoleIdEqualTo(Long value) {
            return equalTo(roleId, value);
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            return notEqualTo(roleId, value);
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            return greaterThan(roleId, value);
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(roleId, value);
        }

        public Criteria andRoleIdLessThan(Long value) {
            return lessThan(roleId, value);
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(roleId, value);
        }

        public Criteria andRoleIdIn(List<Long> values) {
            return in(roleId, values);
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            return notIn(roleId, values);
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            return between(roleId, value1, value2);
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            return notBetween(roleId, value1, value2);
        }
        public Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
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