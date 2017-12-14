package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.BugFeedback;

import java.util.*;
public class BugFeedbackExample extends SgExample<BugFeedbackExample.Criteria> {
    public static final Class<BugFeedback> beanClass = BugFeedback.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn bugs;
    public static EntityColumn osVersion;
    public static EntityColumn createTime;
    public static EntityColumn mobileModel;
    public static EntityColumn openVersion;
    public static EntityColumn feedbackId;
    public static EntityColumn userId;
    public static EntityColumn brand;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        bugs = listMap.get("bugs");
        osVersion = listMap.get("osVersion");
        createTime = listMap.get("createTime");
        mobileModel = listMap.get("mobileModel");
        openVersion = listMap.get("openVersion");
        feedbackId = listMap.get("feedbackId");
        userId = listMap.get("userId");
        brand = listMap.get("brand");
        }

    public BugFeedbackExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected BugFeedbackExample.Criteria createCriteriaInternal() {
        return new BugFeedbackExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public BugFeedbackExample.Criteria andBugsIsNull() {
            return isNull(bugs);
        }

        public BugFeedbackExample.Criteria andBugsIsNotNull() {
            return isNotNull(bugs);
        }

        public BugFeedbackExample.Criteria andBugsEqualTo(String value) {
            return equalTo(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsNotEqualTo(String value) {
            return notEqualTo(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsGreaterThan(String value) {
            return greaterThan(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsLessThan(String value) {
            return lessThan(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsLike(String value) {
            return like(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsNotLike(String value) {
            return notLike(bugs, value);
        }

        public BugFeedbackExample.Criteria andBugsIn(List<String> values) {
            return in(bugs, values);
        }

        public BugFeedbackExample.Criteria andBugsNotIn(List<String> values) {
            return notIn(bugs, values);
        }

        public BugFeedbackExample.Criteria andBugsBetween(String value1, String value2) {
            return between(bugs, value1, value2);
        }

        public BugFeedbackExample.Criteria andBugsNotBetween(String value1, String value2) {
            return notBetween(bugs, value1, value2);
        }
        public BugFeedbackExample.Criteria andOsVersionIsNull() {
            return isNull(osVersion);
        }

        public BugFeedbackExample.Criteria andOsVersionIsNotNull() {
            return isNotNull(osVersion);
        }

        public BugFeedbackExample.Criteria andOsVersionEqualTo(String value) {
            return equalTo(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionNotEqualTo(String value) {
            return notEqualTo(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionGreaterThan(String value) {
            return greaterThan(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionLessThan(String value) {
            return lessThan(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionLike(String value) {
            return like(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionNotLike(String value) {
            return notLike(osVersion, value);
        }

        public BugFeedbackExample.Criteria andOsVersionIn(List<String> values) {
            return in(osVersion, values);
        }

        public BugFeedbackExample.Criteria andOsVersionNotIn(List<String> values) {
            return notIn(osVersion, values);
        }

        public BugFeedbackExample.Criteria andOsVersionBetween(String value1, String value2) {
            return between(osVersion, value1, value2);
        }

        public BugFeedbackExample.Criteria andOsVersionNotBetween(String value1, String value2) {
            return notBetween(osVersion, value1, value2);
        }
        public BugFeedbackExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public BugFeedbackExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public BugFeedbackExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public BugFeedbackExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public BugFeedbackExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public BugFeedbackExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public BugFeedbackExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public BugFeedbackExample.Criteria andMobileModelIsNull() {
            return isNull(mobileModel);
        }

        public BugFeedbackExample.Criteria andMobileModelIsNotNull() {
            return isNotNull(mobileModel);
        }

        public BugFeedbackExample.Criteria andMobileModelEqualTo(String value) {
            return equalTo(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelNotEqualTo(String value) {
            return notEqualTo(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelGreaterThan(String value) {
            return greaterThan(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelLessThan(String value) {
            return lessThan(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelLike(String value) {
            return like(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelNotLike(String value) {
            return notLike(mobileModel, value);
        }

        public BugFeedbackExample.Criteria andMobileModelIn(List<String> values) {
            return in(mobileModel, values);
        }

        public BugFeedbackExample.Criteria andMobileModelNotIn(List<String> values) {
            return notIn(mobileModel, values);
        }

        public BugFeedbackExample.Criteria andMobileModelBetween(String value1, String value2) {
            return between(mobileModel, value1, value2);
        }

        public BugFeedbackExample.Criteria andMobileModelNotBetween(String value1, String value2) {
            return notBetween(mobileModel, value1, value2);
        }
        public BugFeedbackExample.Criteria andOpenVersionIsNull() {
            return isNull(openVersion);
        }

        public BugFeedbackExample.Criteria andOpenVersionIsNotNull() {
            return isNotNull(openVersion);
        }

        public BugFeedbackExample.Criteria andOpenVersionEqualTo(String value) {
            return equalTo(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionNotEqualTo(String value) {
            return notEqualTo(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionGreaterThan(String value) {
            return greaterThan(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionLessThan(String value) {
            return lessThan(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionLike(String value) {
            return like(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionNotLike(String value) {
            return notLike(openVersion, value);
        }

        public BugFeedbackExample.Criteria andOpenVersionIn(List<String> values) {
            return in(openVersion, values);
        }

        public BugFeedbackExample.Criteria andOpenVersionNotIn(List<String> values) {
            return notIn(openVersion, values);
        }

        public BugFeedbackExample.Criteria andOpenVersionBetween(String value1, String value2) {
            return between(openVersion, value1, value2);
        }

        public BugFeedbackExample.Criteria andOpenVersionNotBetween(String value1, String value2) {
            return notBetween(openVersion, value1, value2);
        }
        public BugFeedbackExample.Criteria andFeedbackIdIsNull() {
            return isNull(feedbackId);
        }

        public BugFeedbackExample.Criteria andFeedbackIdIsNotNull() {
            return isNotNull(feedbackId);
        }

        public BugFeedbackExample.Criteria andFeedbackIdEqualTo(Long value) {
            return equalTo(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdNotEqualTo(Long value) {
            return notEqualTo(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdGreaterThan(Long value) {
            return greaterThan(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdLessThan(Long value) {
            return lessThan(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(feedbackId, value);
        }

        public BugFeedbackExample.Criteria andFeedbackIdIn(List<Long> values) {
            return in(feedbackId, values);
        }

        public BugFeedbackExample.Criteria andFeedbackIdNotIn(List<Long> values) {
            return notIn(feedbackId, values);
        }

        public BugFeedbackExample.Criteria andFeedbackIdBetween(Long value1, Long value2) {
            return between(feedbackId, value1, value2);
        }

        public BugFeedbackExample.Criteria andFeedbackIdNotBetween(Long value1, Long value2) {
            return notBetween(feedbackId, value1, value2);
        }
        public BugFeedbackExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public BugFeedbackExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public BugFeedbackExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public BugFeedbackExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public BugFeedbackExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public BugFeedbackExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public BugFeedbackExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public BugFeedbackExample.Criteria andBrandIsNull() {
            return isNull(brand);
        }

        public BugFeedbackExample.Criteria andBrandIsNotNull() {
            return isNotNull(brand);
        }

        public BugFeedbackExample.Criteria andBrandEqualTo(String value) {
            return equalTo(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandNotEqualTo(String value) {
            return notEqualTo(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandGreaterThan(String value) {
            return greaterThan(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandLessThan(String value) {
            return lessThan(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandLike(String value) {
            return like(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandNotLike(String value) {
            return notLike(brand, value);
        }

        public BugFeedbackExample.Criteria andBrandIn(List<String> values) {
            return in(brand, values);
        }

        public BugFeedbackExample.Criteria andBrandNotIn(List<String> values) {
            return notIn(brand, values);
        }

        public BugFeedbackExample.Criteria andBrandBetween(String value1, String value2) {
            return between(brand, value1, value2);
        }

        public BugFeedbackExample.Criteria andBrandNotBetween(String value1, String value2) {
            return notBetween(brand, value1, value2);
        }
    }
}