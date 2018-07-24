package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberLicenseApply;

import java.util.*;
public class MemberLicenseApplyExample extends SgExample<MemberLicenseApplyExample.Criteria> {
    public static final Class<MemberLicenseApply> beanClass = MemberLicenseApply.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn applyId;
    public static EntityColumn licenseType;
    public static EntityColumn reason;
    public static EntityColumn createTime;
    public static EntityColumn context;
    public static EntityColumn loginPhone;
    public static EntityColumn userName;
    public static EntityColumn userId;
    public static EntityColumn applyStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        applyId = listMap.get("applyId");
        licenseType = listMap.get("licenseType");
        reason = listMap.get("reason");
        createTime = listMap.get("createTime");
        context = listMap.get("context");
        loginPhone = listMap.get("loginPhone");
        userName = listMap.get("userName");
        userId = listMap.get("userId");
        applyStatus = listMap.get("applyStatus");
        }

    public MemberLicenseApplyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberLicenseApplyExample.Criteria createCriteriaInternal() {
        return new MemberLicenseApplyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdIsNull() {
            return isNull(applyId);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdIsNotNull() {
            return isNotNull(applyId);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdEqualTo(Long value) {
            return equalTo(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotEqualTo(Long value) {
            return notEqualTo(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdGreaterThan(Long value) {
            return greaterThan(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdLessThan(Long value) {
            return lessThan(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(applyId, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdIn(List<Long> values) {
            return in(applyId, values);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotIn(List<Long> values) {
            return notIn(applyId, values);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            return between(applyId, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(applyId, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andLicenseTypeIsNull() {
            return isNull(licenseType);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeIsNotNull() {
            return isNotNull(licenseType);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeEqualTo(Integer value) {
            return equalTo(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            return notEqualTo(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            return greaterThan(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeLessThan(Integer value) {
            return lessThan(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(licenseType, value);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeIn(List<Integer> values) {
            return in(licenseType, values);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            return notIn(licenseType, values);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            return between(licenseType, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(licenseType, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andReasonIsNull() {
            return isNull(reason);
        }

        public MemberLicenseApplyExample.Criteria andReasonIsNotNull() {
            return isNotNull(reason);
        }

        public MemberLicenseApplyExample.Criteria andReasonEqualTo(String value) {
            return equalTo(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonNotEqualTo(String value) {
            return notEqualTo(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonGreaterThan(String value) {
            return greaterThan(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonLessThan(String value) {
            return lessThan(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonLike(String value) {
            return like(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonNotLike(String value) {
            return notLike(reason, value);
        }

        public MemberLicenseApplyExample.Criteria andReasonIn(List<String> values) {
            return in(reason, values);
        }

        public MemberLicenseApplyExample.Criteria andReasonNotIn(List<String> values) {
            return notIn(reason, values);
        }

        public MemberLicenseApplyExample.Criteria andReasonBetween(String value1, String value2) {
            return between(reason, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andReasonNotBetween(String value1, String value2) {
            return notBetween(reason, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public MemberLicenseApplyExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public MemberLicenseApplyExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public MemberLicenseApplyExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public MemberLicenseApplyExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public MemberLicenseApplyExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andLoginPhoneIsNull() {
            return isNull(loginPhone);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneIsNotNull() {
            return isNotNull(loginPhone);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneEqualTo(String value) {
            return equalTo(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneNotEqualTo(String value) {
            return notEqualTo(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneGreaterThan(String value) {
            return greaterThan(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneLessThan(String value) {
            return lessThan(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneLike(String value) {
            return like(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneNotLike(String value) {
            return notLike(loginPhone, value);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneIn(List<String> values) {
            return in(loginPhone, values);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneNotIn(List<String> values) {
            return notIn(loginPhone, values);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneBetween(String value1, String value2) {
            return between(loginPhone, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            return notBetween(loginPhone, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public MemberLicenseApplyExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public MemberLicenseApplyExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public MemberLicenseApplyExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public MemberLicenseApplyExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public MemberLicenseApplyExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberLicenseApplyExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberLicenseApplyExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberLicenseApplyExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberLicenseApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberLicenseApplyExample.Criteria andApplyStatusIsNull() {
            return isNull(applyStatus);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusIsNotNull() {
            return isNotNull(applyStatus);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusEqualTo(Integer value) {
            return equalTo(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotEqualTo(Integer value) {
            return notEqualTo(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusGreaterThan(Integer value) {
            return greaterThan(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusLessThan(Integer value) {
            return lessThan(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(applyStatus, value);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusIn(List<Integer> values) {
            return in(applyStatus, values);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotIn(List<Integer> values) {
            return notIn(applyStatus, values);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            return between(applyStatus, value1, value2);
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(applyStatus, value1, value2);
        }
    }
}
