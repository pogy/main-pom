package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguFeedback;

import java.util.*;
public class ShiguFeedbackExample extends SgExample<ShiguFeedbackExample.Criteria> {
    public static final Class<ShiguFeedback> beanClass = ShiguFeedback.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn phoneModel;
    public static EntityColumn fcontents;
    public static EntityColumn osVersion;
    public static EntityColumn createTime;
    public static EntityColumn phoneBrand;
    public static EntityColumn openVersion;
    public static EntityColumn remark5;
    public static EntityColumn feedbackId;
    public static EntityColumn updateTime;
    public static EntityColumn userId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        phoneModel = listMap.get("phoneModel");
        fcontents = listMap.get("fcontents");
        osVersion = listMap.get("osVersion");
        createTime = listMap.get("createTime");
        phoneBrand = listMap.get("phoneBrand");
        openVersion = listMap.get("openVersion");
        remark5 = listMap.get("remark5");
        feedbackId = listMap.get("feedbackId");
        updateTime = listMap.get("updateTime");
        userId = listMap.get("userId");
        status = listMap.get("status");
        }

    public ShiguFeedbackExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguFeedbackExample.Criteria createCriteriaInternal() {
        return new ShiguFeedbackExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelIsNull() {
            return isNull(phoneModel);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelIsNotNull() {
            return isNotNull(phoneModel);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelEqualTo(String value) {
            return equalTo(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelNotEqualTo(String value) {
            return notEqualTo(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelGreaterThan(String value) {
            return greaterThan(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelLessThan(String value) {
            return lessThan(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelLike(String value) {
            return like(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelNotLike(String value) {
            return notLike(phoneModel, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelIn(List<String> values) {
            return in(phoneModel, values);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelNotIn(List<String> values) {
            return notIn(phoneModel, values);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelBetween(String value1, String value2) {
            return between(phoneModel, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andPhoneModelNotBetween(String value1, String value2) {
            return notBetween(phoneModel, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andFcontentsIsNull() {
            return isNull(fcontents);
        }

        public ShiguFeedbackExample.Criteria andFcontentsIsNotNull() {
            return isNotNull(fcontents);
        }

        public ShiguFeedbackExample.Criteria andFcontentsEqualTo(String value) {
            return equalTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotEqualTo(String value) {
            return notEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsGreaterThan(String value) {
            return greaterThan(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLessThan(String value) {
            return lessThan(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLike(String value) {
            return like(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotLike(String value) {
            return notLike(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsIn(List<String> values) {
            return in(fcontents, values);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotIn(List<String> values) {
            return notIn(fcontents, values);
        }

        public ShiguFeedbackExample.Criteria andFcontentsBetween(String value1, String value2) {
            return between(fcontents, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotBetween(String value1, String value2) {
            return notBetween(fcontents, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andOsVersionIsNull() {
            return isNull(osVersion);
        }

        public ShiguFeedbackExample.Criteria andOsVersionIsNotNull() {
            return isNotNull(osVersion);
        }

        public ShiguFeedbackExample.Criteria andOsVersionEqualTo(String value) {
            return equalTo(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionNotEqualTo(String value) {
            return notEqualTo(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionGreaterThan(String value) {
            return greaterThan(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionLessThan(String value) {
            return lessThan(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionLike(String value) {
            return like(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionNotLike(String value) {
            return notLike(osVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOsVersionIn(List<String> values) {
            return in(osVersion, values);
        }

        public ShiguFeedbackExample.Criteria andOsVersionNotIn(List<String> values) {
            return notIn(osVersion, values);
        }

        public ShiguFeedbackExample.Criteria andOsVersionBetween(String value1, String value2) {
            return between(osVersion, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andOsVersionNotBetween(String value1, String value2) {
            return notBetween(osVersion, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andPhoneBrandIsNull() {
            return isNull(phoneBrand);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandIsNotNull() {
            return isNotNull(phoneBrand);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandEqualTo(String value) {
            return equalTo(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandNotEqualTo(String value) {
            return notEqualTo(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandGreaterThan(String value) {
            return greaterThan(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandLessThan(String value) {
            return lessThan(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandLike(String value) {
            return like(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandNotLike(String value) {
            return notLike(phoneBrand, value);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandIn(List<String> values) {
            return in(phoneBrand, values);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandNotIn(List<String> values) {
            return notIn(phoneBrand, values);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandBetween(String value1, String value2) {
            return between(phoneBrand, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andPhoneBrandNotBetween(String value1, String value2) {
            return notBetween(phoneBrand, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andOpenVersionIsNull() {
            return isNull(openVersion);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionIsNotNull() {
            return isNotNull(openVersion);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionEqualTo(String value) {
            return equalTo(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionNotEqualTo(String value) {
            return notEqualTo(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionGreaterThan(String value) {
            return greaterThan(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionLessThan(String value) {
            return lessThan(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionLike(String value) {
            return like(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionNotLike(String value) {
            return notLike(openVersion, value);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionIn(List<String> values) {
            return in(openVersion, values);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionNotIn(List<String> values) {
            return notIn(openVersion, values);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionBetween(String value1, String value2) {
            return between(openVersion, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andOpenVersionNotBetween(String value1, String value2) {
            return notBetween(openVersion, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguFeedbackExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguFeedbackExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguFeedbackExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andFeedbackIdIsNull() {
            return isNull(feedbackId);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdIsNotNull() {
            return isNotNull(feedbackId);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdEqualTo(Long value) {
            return equalTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotEqualTo(Long value) {
            return notEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdGreaterThan(Long value) {
            return greaterThan(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdLessThan(Long value) {
            return lessThan(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdIn(List<Long> values) {
            return in(feedbackId, values);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotIn(List<Long> values) {
            return notIn(feedbackId, values);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdBetween(Long value1, Long value2) {
            return between(feedbackId, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotBetween(Long value1, Long value2) {
            return notBetween(feedbackId, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguFeedbackExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguFeedbackExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguFeedbackExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguFeedbackExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguFeedbackExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguFeedbackExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguFeedbackExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}