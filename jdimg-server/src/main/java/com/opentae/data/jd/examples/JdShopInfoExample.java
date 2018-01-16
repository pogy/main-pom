package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdShopInfo;

import java.util.*;

public class JdShopInfoExample extends SgExample<JdShopInfoExample.Criteria> {
    public static final Class<JdShopInfo> beanClass = JdShopInfo.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn brief;
    public static EntityColumn jdShopId;
    public static EntityColumn categoryMainName;
    public static EntityColumn jdUid;
    public static EntityColumn categoryMain;
    public static EntityColumn gmtModify;
    public static EntityColumn jdShopLogoUrl;
    public static EntityColumn venderId;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn openTime;
    public static EntityColumn jdShopName;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        brief = listMap.get("brief");
        jdShopId = listMap.get("jdShopId");
        categoryMainName = listMap.get("categoryMainName");
        jdUid = listMap.get("jdUid");
        categoryMain = listMap.get("categoryMain");
        gmtModify = listMap.get("gmtModify");
        jdShopLogoUrl = listMap.get("jdShopLogoUrl");
        venderId = listMap.get("venderId");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        openTime = listMap.get("openTime");
        jdShopName = listMap.get("jdShopName");
        }

    public JdShopInfoExample() {
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

    public static class Criteria extends GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andBriefIsNull() {
            return isNull(brief);
        }

        public Criteria andBriefIsNotNull() {
            return isNotNull(brief);
        }

        public Criteria andBriefEqualTo(String value) {
            return equalTo(brief, value);
        }

        public Criteria andBriefNotEqualTo(String value) {
            return notEqualTo(brief, value);
        }

        public Criteria andBriefGreaterThan(String value) {
            return greaterThan(brief, value);
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(brief, value);
        }

        public Criteria andBriefLessThan(String value) {
            return lessThan(brief, value);
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(brief, value);
        }

        public Criteria andBriefLike(String value) {
            return like(brief, value);
        }

        public Criteria andBriefNotLike(String value) {
            return notLike(brief, value);
        }

        public Criteria andBriefIn(List<String> values) {
            return in(brief, values);
        }

        public Criteria andBriefNotIn(List<String> values) {
            return notIn(brief, values);
        }

        public Criteria andBriefBetween(String value1, String value2) {
            return between(brief, value1, value2);
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            return notBetween(brief, value1, value2);
        }
        public Criteria andJdShopIdIsNull() {
            return isNull(jdShopId);
        }

        public Criteria andJdShopIdIsNotNull() {
            return isNotNull(jdShopId);
        }

        public Criteria andJdShopIdEqualTo(Long value) {
            return equalTo(jdShopId, value);
        }

        public Criteria andJdShopIdNotEqualTo(Long value) {
            return notEqualTo(jdShopId, value);
        }

        public Criteria andJdShopIdGreaterThan(Long value) {
            return greaterThan(jdShopId, value);
        }

        public Criteria andJdShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdShopId, value);
        }

        public Criteria andJdShopIdLessThan(Long value) {
            return lessThan(jdShopId, value);
        }

        public Criteria andJdShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdShopId, value);
        }

        public Criteria andJdShopIdIn(List<Long> values) {
            return in(jdShopId, values);
        }

        public Criteria andJdShopIdNotIn(List<Long> values) {
            return notIn(jdShopId, values);
        }

        public Criteria andJdShopIdBetween(Long value1, Long value2) {
            return between(jdShopId, value1, value2);
        }

        public Criteria andJdShopIdNotBetween(Long value1, Long value2) {
            return notBetween(jdShopId, value1, value2);
        }
        public Criteria andCategoryMainNameIsNull() {
            return isNull(categoryMainName);
        }

        public Criteria andCategoryMainNameIsNotNull() {
            return isNotNull(categoryMainName);
        }

        public Criteria andCategoryMainNameEqualTo(String value) {
            return equalTo(categoryMainName, value);
        }

        public Criteria andCategoryMainNameNotEqualTo(String value) {
            return notEqualTo(categoryMainName, value);
        }

        public Criteria andCategoryMainNameGreaterThan(String value) {
            return greaterThan(categoryMainName, value);
        }

        public Criteria andCategoryMainNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(categoryMainName, value);
        }

        public Criteria andCategoryMainNameLessThan(String value) {
            return lessThan(categoryMainName, value);
        }

        public Criteria andCategoryMainNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(categoryMainName, value);
        }

        public Criteria andCategoryMainNameLike(String value) {
            return like(categoryMainName, value);
        }

        public Criteria andCategoryMainNameNotLike(String value) {
            return notLike(categoryMainName, value);
        }

        public Criteria andCategoryMainNameIn(List<String> values) {
            return in(categoryMainName, values);
        }

        public Criteria andCategoryMainNameNotIn(List<String> values) {
            return notIn(categoryMainName, values);
        }

        public Criteria andCategoryMainNameBetween(String value1, String value2) {
            return between(categoryMainName, value1, value2);
        }

        public Criteria andCategoryMainNameNotBetween(String value1, String value2) {
            return notBetween(categoryMainName, value1, value2);
        }
        public Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public Criteria andCategoryMainIsNull() {
            return isNull(categoryMain);
        }

        public Criteria andCategoryMainIsNotNull() {
            return isNotNull(categoryMain);
        }

        public Criteria andCategoryMainEqualTo(Long value) {
            return equalTo(categoryMain, value);
        }

        public Criteria andCategoryMainNotEqualTo(Long value) {
            return notEqualTo(categoryMain, value);
        }

        public Criteria andCategoryMainGreaterThan(Long value) {
            return greaterThan(categoryMain, value);
        }

        public Criteria andCategoryMainGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(categoryMain, value);
        }

        public Criteria andCategoryMainLessThan(Long value) {
            return lessThan(categoryMain, value);
        }

        public Criteria andCategoryMainLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(categoryMain, value);
        }

        public Criteria andCategoryMainIn(List<Long> values) {
            return in(categoryMain, values);
        }

        public Criteria andCategoryMainNotIn(List<Long> values) {
            return notIn(categoryMain, values);
        }

        public Criteria andCategoryMainBetween(Long value1, Long value2) {
            return between(categoryMain, value1, value2);
        }

        public Criteria andCategoryMainNotBetween(Long value1, Long value2) {
            return notBetween(categoryMain, value1, value2);
        }
        public Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public Criteria andJdShopLogoUrlIsNull() {
            return isNull(jdShopLogoUrl);
        }

        public Criteria andJdShopLogoUrlIsNotNull() {
            return isNotNull(jdShopLogoUrl);
        }

        public Criteria andJdShopLogoUrlEqualTo(String value) {
            return equalTo(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlNotEqualTo(String value) {
            return notEqualTo(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlGreaterThan(String value) {
            return greaterThan(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlLessThan(String value) {
            return lessThan(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlLike(String value) {
            return like(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlNotLike(String value) {
            return notLike(jdShopLogoUrl, value);
        }

        public Criteria andJdShopLogoUrlIn(List<String> values) {
            return in(jdShopLogoUrl, values);
        }

        public Criteria andJdShopLogoUrlNotIn(List<String> values) {
            return notIn(jdShopLogoUrl, values);
        }

        public Criteria andJdShopLogoUrlBetween(String value1, String value2) {
            return between(jdShopLogoUrl, value1, value2);
        }

        public Criteria andJdShopLogoUrlNotBetween(String value1, String value2) {
            return notBetween(jdShopLogoUrl, value1, value2);
        }
        public Criteria andVenderIdIsNull() {
            return isNull(venderId);
        }

        public Criteria andVenderIdIsNotNull() {
            return isNotNull(venderId);
        }

        public Criteria andVenderIdEqualTo(Long value) {
            return equalTo(venderId, value);
        }

        public Criteria andVenderIdNotEqualTo(Long value) {
            return notEqualTo(venderId, value);
        }

        public Criteria andVenderIdGreaterThan(Long value) {
            return greaterThan(venderId, value);
        }

        public Criteria andVenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(venderId, value);
        }

        public Criteria andVenderIdLessThan(Long value) {
            return lessThan(venderId, value);
        }

        public Criteria andVenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(venderId, value);
        }

        public Criteria andVenderIdIn(List<Long> values) {
            return in(venderId, values);
        }

        public Criteria andVenderIdNotIn(List<Long> values) {
            return notIn(venderId, values);
        }

        public Criteria andVenderIdBetween(Long value1, Long value2) {
            return between(venderId, value1, value2);
        }

        public Criteria andVenderIdNotBetween(Long value1, Long value2) {
            return notBetween(venderId, value1, value2);
        }
        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public Criteria andOpenTimeIsNull() {
            return isNull(openTime);
        }

        public Criteria andOpenTimeIsNotNull() {
            return isNotNull(openTime);
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            return equalTo(openTime, value);
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            return notEqualTo(openTime, value);
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            return greaterThan(openTime, value);
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(openTime, value);
        }

        public Criteria andOpenTimeLessThan(Date value) {
            return lessThan(openTime, value);
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(openTime, value);
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            return in(openTime, values);
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            return notIn(openTime, values);
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            return between(openTime, value1, value2);
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            return notBetween(openTime, value1, value2);
        }
        public Criteria andJdShopNameIsNull() {
            return isNull(jdShopName);
        }

        public Criteria andJdShopNameIsNotNull() {
            return isNotNull(jdShopName);
        }

        public Criteria andJdShopNameEqualTo(String value) {
            return equalTo(jdShopName, value);
        }

        public Criteria andJdShopNameNotEqualTo(String value) {
            return notEqualTo(jdShopName, value);
        }

        public Criteria andJdShopNameGreaterThan(String value) {
            return greaterThan(jdShopName, value);
        }

        public Criteria andJdShopNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdShopName, value);
        }

        public Criteria andJdShopNameLessThan(String value) {
            return lessThan(jdShopName, value);
        }

        public Criteria andJdShopNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdShopName, value);
        }

        public Criteria andJdShopNameLike(String value) {
            return like(jdShopName, value);
        }

        public Criteria andJdShopNameNotLike(String value) {
            return notLike(jdShopName, value);
        }

        public Criteria andJdShopNameIn(List<String> values) {
            return in(jdShopName, values);
        }

        public Criteria andJdShopNameNotIn(List<String> values) {
            return notIn(jdShopName, values);
        }

        public Criteria andJdShopNameBetween(String value1, String value2) {
            return between(jdShopName, value1, value2);
        }

        public Criteria andJdShopNameNotBetween(String value1, String value2) {
            return notBetween(jdShopName, value1, value2);
        }
    }
}