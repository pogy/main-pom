package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguActivity;

import java.util.*;
public class ShiguActivityExample extends SgExample<ShiguActivityExample.Criteria> {
    public static final Class<ShiguActivity> beanClass = ShiguActivity.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn image;
    public static EntityColumn descInfo;
    public static EntityColumn endApply;
    public static EntityColumn banner;
    public static EntityColumn services;
    public static EntityColumn title;
    public static EntityColumn webSite;
    public static EntityColumn activityId;
    public static EntityColumn locationId;
    public static EntityColumn costDesc;
    public static EntityColumn ruleInfo;
    public static EntityColumn bkcolor;
    public static EntityColumn startTime;
    public static EntityColumn endTime;
    public static EntityColumn nums;
    public static EntityColumn startApply;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        image = listMap.get("image");
        descInfo = listMap.get("descInfo");
        endApply = listMap.get("endApply");
        banner = listMap.get("banner");
        services = listMap.get("services");
        title = listMap.get("title");
        webSite = listMap.get("webSite");
        activityId = listMap.get("activityId");
        locationId = listMap.get("locationId");
        costDesc = listMap.get("costDesc");
        ruleInfo = listMap.get("ruleInfo");
        bkcolor = listMap.get("bkcolor");
        startTime = listMap.get("startTime");
        endTime = listMap.get("endTime");
        nums = listMap.get("nums");
        startApply = listMap.get("startApply");
        }

    public ShiguActivityExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguActivityExample.Criteria createCriteriaInternal() {
        return new ShiguActivityExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguActivityExample.Criteria andImageIsNull() {
            return isNull(image);
        }

        public ShiguActivityExample.Criteria andImageIsNotNull() {
            return isNotNull(image);
        }

        public ShiguActivityExample.Criteria andImageEqualTo(String value) {
            return equalTo(image, value);
        }

        public ShiguActivityExample.Criteria andImageNotEqualTo(String value) {
            return notEqualTo(image, value);
        }

        public ShiguActivityExample.Criteria andImageGreaterThan(String value) {
            return greaterThan(image, value);
        }

        public ShiguActivityExample.Criteria andImageGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(image, value);
        }

        public ShiguActivityExample.Criteria andImageLessThan(String value) {
            return lessThan(image, value);
        }

        public ShiguActivityExample.Criteria andImageLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(image, value);
        }

        public ShiguActivityExample.Criteria andImageLike(String value) {
            return like(image, value);
        }

        public ShiguActivityExample.Criteria andImageNotLike(String value) {
            return notLike(image, value);
        }

        public ShiguActivityExample.Criteria andImageIn(List<String> values) {
            return in(image, values);
        }

        public ShiguActivityExample.Criteria andImageNotIn(List<String> values) {
            return notIn(image, values);
        }

        public ShiguActivityExample.Criteria andImageBetween(String value1, String value2) {
            return between(image, value1, value2);
        }

        public ShiguActivityExample.Criteria andImageNotBetween(String value1, String value2) {
            return notBetween(image, value1, value2);
        }
        public ShiguActivityExample.Criteria andDescInfoIsNull() {
            return isNull(descInfo);
        }

        public ShiguActivityExample.Criteria andDescInfoIsNotNull() {
            return isNotNull(descInfo);
        }

        public ShiguActivityExample.Criteria andDescInfoEqualTo(String value) {
            return equalTo(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoNotEqualTo(String value) {
            return notEqualTo(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoGreaterThan(String value) {
            return greaterThan(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoLessThan(String value) {
            return lessThan(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoLike(String value) {
            return like(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoNotLike(String value) {
            return notLike(descInfo, value);
        }

        public ShiguActivityExample.Criteria andDescInfoIn(List<String> values) {
            return in(descInfo, values);
        }

        public ShiguActivityExample.Criteria andDescInfoNotIn(List<String> values) {
            return notIn(descInfo, values);
        }

        public ShiguActivityExample.Criteria andDescInfoBetween(String value1, String value2) {
            return between(descInfo, value1, value2);
        }

        public ShiguActivityExample.Criteria andDescInfoNotBetween(String value1, String value2) {
            return notBetween(descInfo, value1, value2);
        }
        public ShiguActivityExample.Criteria andEndApplyIsNull() {
            return isNull(endApply);
        }

        public ShiguActivityExample.Criteria andEndApplyIsNotNull() {
            return isNotNull(endApply);
        }

        public ShiguActivityExample.Criteria andEndApplyEqualTo(Date value) {
            return equalTo(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyNotEqualTo(Date value) {
            return notEqualTo(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyGreaterThan(Date value) {
            return greaterThan(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyLessThan(Date value) {
            return lessThan(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endApply, value);
        }

        public ShiguActivityExample.Criteria andEndApplyIn(List<Date> values) {
            return in(endApply, values);
        }

        public ShiguActivityExample.Criteria andEndApplyNotIn(List<Date> values) {
            return notIn(endApply, values);
        }

        public ShiguActivityExample.Criteria andEndApplyBetween(Date value1, Date value2) {
            return between(endApply, value1, value2);
        }

        public ShiguActivityExample.Criteria andEndApplyNotBetween(Date value1, Date value2) {
            return notBetween(endApply, value1, value2);
        }
        public ShiguActivityExample.Criteria andBannerIsNull() {
            return isNull(banner);
        }

        public ShiguActivityExample.Criteria andBannerIsNotNull() {
            return isNotNull(banner);
        }

        public ShiguActivityExample.Criteria andBannerEqualTo(String value) {
            return equalTo(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerNotEqualTo(String value) {
            return notEqualTo(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerGreaterThan(String value) {
            return greaterThan(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerLessThan(String value) {
            return lessThan(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerLike(String value) {
            return like(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerNotLike(String value) {
            return notLike(banner, value);
        }

        public ShiguActivityExample.Criteria andBannerIn(List<String> values) {
            return in(banner, values);
        }

        public ShiguActivityExample.Criteria andBannerNotIn(List<String> values) {
            return notIn(banner, values);
        }

        public ShiguActivityExample.Criteria andBannerBetween(String value1, String value2) {
            return between(banner, value1, value2);
        }

        public ShiguActivityExample.Criteria andBannerNotBetween(String value1, String value2) {
            return notBetween(banner, value1, value2);
        }
        public ShiguActivityExample.Criteria andServicesIsNull() {
            return isNull(services);
        }

        public ShiguActivityExample.Criteria andServicesIsNotNull() {
            return isNotNull(services);
        }

        public ShiguActivityExample.Criteria andServicesEqualTo(String value) {
            return equalTo(services, value);
        }

        public ShiguActivityExample.Criteria andServicesNotEqualTo(String value) {
            return notEqualTo(services, value);
        }

        public ShiguActivityExample.Criteria andServicesGreaterThan(String value) {
            return greaterThan(services, value);
        }

        public ShiguActivityExample.Criteria andServicesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(services, value);
        }

        public ShiguActivityExample.Criteria andServicesLessThan(String value) {
            return lessThan(services, value);
        }

        public ShiguActivityExample.Criteria andServicesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(services, value);
        }

        public ShiguActivityExample.Criteria andServicesLike(String value) {
            return like(services, value);
        }

        public ShiguActivityExample.Criteria andServicesNotLike(String value) {
            return notLike(services, value);
        }

        public ShiguActivityExample.Criteria andServicesIn(List<String> values) {
            return in(services, values);
        }

        public ShiguActivityExample.Criteria andServicesNotIn(List<String> values) {
            return notIn(services, values);
        }

        public ShiguActivityExample.Criteria andServicesBetween(String value1, String value2) {
            return between(services, value1, value2);
        }

        public ShiguActivityExample.Criteria andServicesNotBetween(String value1, String value2) {
            return notBetween(services, value1, value2);
        }
        public ShiguActivityExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguActivityExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguActivityExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguActivityExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguActivityExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguActivityExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguActivityExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguActivityExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguActivityExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguActivityExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguActivityExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguActivityExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguActivityExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguActivityExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguActivityExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguActivityExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguActivityExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguActivityExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguActivityExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguActivityExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguActivityExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguActivityExample.Criteria andActivityIdIsNull() {
            return isNull(activityId);
        }

        public ShiguActivityExample.Criteria andActivityIdIsNotNull() {
            return isNotNull(activityId);
        }

        public ShiguActivityExample.Criteria andActivityIdEqualTo(Long value) {
            return equalTo(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdNotEqualTo(Long value) {
            return notEqualTo(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdGreaterThan(Long value) {
            return greaterThan(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdLessThan(Long value) {
            return lessThan(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activityId, value);
        }

        public ShiguActivityExample.Criteria andActivityIdIn(List<Long> values) {
            return in(activityId, values);
        }

        public ShiguActivityExample.Criteria andActivityIdNotIn(List<Long> values) {
            return notIn(activityId, values);
        }

        public ShiguActivityExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            return between(activityId, value1, value2);
        }

        public ShiguActivityExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            return notBetween(activityId, value1, value2);
        }
        public ShiguActivityExample.Criteria andLocationIdIsNull() {
            return isNull(locationId);
        }

        public ShiguActivityExample.Criteria andLocationIdIsNotNull() {
            return isNotNull(locationId);
        }

        public ShiguActivityExample.Criteria andLocationIdEqualTo(Long value) {
            return equalTo(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdNotEqualTo(Long value) {
            return notEqualTo(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdGreaterThan(Long value) {
            return greaterThan(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdLessThan(Long value) {
            return lessThan(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(locationId, value);
        }

        public ShiguActivityExample.Criteria andLocationIdIn(List<Long> values) {
            return in(locationId, values);
        }

        public ShiguActivityExample.Criteria andLocationIdNotIn(List<Long> values) {
            return notIn(locationId, values);
        }

        public ShiguActivityExample.Criteria andLocationIdBetween(Long value1, Long value2) {
            return between(locationId, value1, value2);
        }

        public ShiguActivityExample.Criteria andLocationIdNotBetween(Long value1, Long value2) {
            return notBetween(locationId, value1, value2);
        }
        public ShiguActivityExample.Criteria andCostDescIsNull() {
            return isNull(costDesc);
        }

        public ShiguActivityExample.Criteria andCostDescIsNotNull() {
            return isNotNull(costDesc);
        }

        public ShiguActivityExample.Criteria andCostDescEqualTo(String value) {
            return equalTo(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescNotEqualTo(String value) {
            return notEqualTo(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescGreaterThan(String value) {
            return greaterThan(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescLessThan(String value) {
            return lessThan(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescLike(String value) {
            return like(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescNotLike(String value) {
            return notLike(costDesc, value);
        }

        public ShiguActivityExample.Criteria andCostDescIn(List<String> values) {
            return in(costDesc, values);
        }

        public ShiguActivityExample.Criteria andCostDescNotIn(List<String> values) {
            return notIn(costDesc, values);
        }

        public ShiguActivityExample.Criteria andCostDescBetween(String value1, String value2) {
            return between(costDesc, value1, value2);
        }

        public ShiguActivityExample.Criteria andCostDescNotBetween(String value1, String value2) {
            return notBetween(costDesc, value1, value2);
        }
        public ShiguActivityExample.Criteria andRuleInfoIsNull() {
            return isNull(ruleInfo);
        }

        public ShiguActivityExample.Criteria andRuleInfoIsNotNull() {
            return isNotNull(ruleInfo);
        }

        public ShiguActivityExample.Criteria andRuleInfoEqualTo(String value) {
            return equalTo(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoNotEqualTo(String value) {
            return notEqualTo(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoGreaterThan(String value) {
            return greaterThan(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoLessThan(String value) {
            return lessThan(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoLike(String value) {
            return like(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoNotLike(String value) {
            return notLike(ruleInfo, value);
        }

        public ShiguActivityExample.Criteria andRuleInfoIn(List<String> values) {
            return in(ruleInfo, values);
        }

        public ShiguActivityExample.Criteria andRuleInfoNotIn(List<String> values) {
            return notIn(ruleInfo, values);
        }

        public ShiguActivityExample.Criteria andRuleInfoBetween(String value1, String value2) {
            return between(ruleInfo, value1, value2);
        }

        public ShiguActivityExample.Criteria andRuleInfoNotBetween(String value1, String value2) {
            return notBetween(ruleInfo, value1, value2);
        }
        public ShiguActivityExample.Criteria andBkcolorIsNull() {
            return isNull(bkcolor);
        }

        public ShiguActivityExample.Criteria andBkcolorIsNotNull() {
            return isNotNull(bkcolor);
        }

        public ShiguActivityExample.Criteria andBkcolorEqualTo(String value) {
            return equalTo(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorNotEqualTo(String value) {
            return notEqualTo(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorGreaterThan(String value) {
            return greaterThan(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorLessThan(String value) {
            return lessThan(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorLike(String value) {
            return like(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorNotLike(String value) {
            return notLike(bkcolor, value);
        }

        public ShiguActivityExample.Criteria andBkcolorIn(List<String> values) {
            return in(bkcolor, values);
        }

        public ShiguActivityExample.Criteria andBkcolorNotIn(List<String> values) {
            return notIn(bkcolor, values);
        }

        public ShiguActivityExample.Criteria andBkcolorBetween(String value1, String value2) {
            return between(bkcolor, value1, value2);
        }

        public ShiguActivityExample.Criteria andBkcolorNotBetween(String value1, String value2) {
            return notBetween(bkcolor, value1, value2);
        }
        public ShiguActivityExample.Criteria andStartTimeIsNull() {
            return isNull(startTime);
        }

        public ShiguActivityExample.Criteria andStartTimeIsNotNull() {
            return isNotNull(startTime);
        }

        public ShiguActivityExample.Criteria andStartTimeEqualTo(Date value) {
            return equalTo(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeNotEqualTo(Date value) {
            return notEqualTo(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeGreaterThan(Date value) {
            return greaterThan(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeLessThan(Date value) {
            return lessThan(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startTime, value);
        }

        public ShiguActivityExample.Criteria andStartTimeIn(List<Date> values) {
            return in(startTime, values);
        }

        public ShiguActivityExample.Criteria andStartTimeNotIn(List<Date> values) {
            return notIn(startTime, values);
        }

        public ShiguActivityExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            return between(startTime, value1, value2);
        }

        public ShiguActivityExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            return notBetween(startTime, value1, value2);
        }
        public ShiguActivityExample.Criteria andEndTimeIsNull() {
            return isNull(endTime);
        }

        public ShiguActivityExample.Criteria andEndTimeIsNotNull() {
            return isNotNull(endTime);
        }

        public ShiguActivityExample.Criteria andEndTimeEqualTo(Date value) {
            return equalTo(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeNotEqualTo(Date value) {
            return notEqualTo(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeGreaterThan(Date value) {
            return greaterThan(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeLessThan(Date value) {
            return lessThan(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endTime, value);
        }

        public ShiguActivityExample.Criteria andEndTimeIn(List<Date> values) {
            return in(endTime, values);
        }

        public ShiguActivityExample.Criteria andEndTimeNotIn(List<Date> values) {
            return notIn(endTime, values);
        }

        public ShiguActivityExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            return between(endTime, value1, value2);
        }

        public ShiguActivityExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            return notBetween(endTime, value1, value2);
        }
        public ShiguActivityExample.Criteria andNumsIsNull() {
            return isNull(nums);
        }

        public ShiguActivityExample.Criteria andNumsIsNotNull() {
            return isNotNull(nums);
        }

        public ShiguActivityExample.Criteria andNumsEqualTo(String value) {
            return equalTo(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsNotEqualTo(String value) {
            return notEqualTo(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsGreaterThan(String value) {
            return greaterThan(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsLessThan(String value) {
            return lessThan(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsLike(String value) {
            return like(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsNotLike(String value) {
            return notLike(nums, value);
        }

        public ShiguActivityExample.Criteria andNumsIn(List<String> values) {
            return in(nums, values);
        }

        public ShiguActivityExample.Criteria andNumsNotIn(List<String> values) {
            return notIn(nums, values);
        }

        public ShiguActivityExample.Criteria andNumsBetween(String value1, String value2) {
            return between(nums, value1, value2);
        }

        public ShiguActivityExample.Criteria andNumsNotBetween(String value1, String value2) {
            return notBetween(nums, value1, value2);
        }
        public ShiguActivityExample.Criteria andStartApplyIsNull() {
            return isNull(startApply);
        }

        public ShiguActivityExample.Criteria andStartApplyIsNotNull() {
            return isNotNull(startApply);
        }

        public ShiguActivityExample.Criteria andStartApplyEqualTo(Date value) {
            return equalTo(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyNotEqualTo(Date value) {
            return notEqualTo(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyGreaterThan(Date value) {
            return greaterThan(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyLessThan(Date value) {
            return lessThan(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startApply, value);
        }

        public ShiguActivityExample.Criteria andStartApplyIn(List<Date> values) {
            return in(startApply, values);
        }

        public ShiguActivityExample.Criteria andStartApplyNotIn(List<Date> values) {
            return notIn(startApply, values);
        }

        public ShiguActivityExample.Criteria andStartApplyBetween(Date value1, Date value2) {
            return between(startApply, value1, value2);
        }

        public ShiguActivityExample.Criteria andStartApplyNotBetween(Date value1, Date value2) {
            return notBetween(startApply, value1, value2);
        }
    }
}
