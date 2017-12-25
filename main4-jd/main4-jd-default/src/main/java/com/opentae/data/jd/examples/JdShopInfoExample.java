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
    protected JdShopInfoExample.Criteria createCriteriaInternal() {
        return new JdShopInfoExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdShopInfoExample.Criteria andBriefIsNull() {
            return isNull(brief);
        }

        public JdShopInfoExample.Criteria andBriefIsNotNull() {
            return isNotNull(brief);
        }

        public JdShopInfoExample.Criteria andBriefEqualTo(String value) {
            return equalTo(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefNotEqualTo(String value) {
            return notEqualTo(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefGreaterThan(String value) {
            return greaterThan(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefLessThan(String value) {
            return lessThan(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefLike(String value) {
            return like(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefNotLike(String value) {
            return notLike(brief, value);
        }

        public JdShopInfoExample.Criteria andBriefIn(List<String> values) {
            return in(brief, values);
        }

        public JdShopInfoExample.Criteria andBriefNotIn(List<String> values) {
            return notIn(brief, values);
        }

        public JdShopInfoExample.Criteria andBriefBetween(String value1, String value2) {
            return between(brief, value1, value2);
        }

        public JdShopInfoExample.Criteria andBriefNotBetween(String value1, String value2) {
            return notBetween(brief, value1, value2);
        }
        public JdShopInfoExample.Criteria andJdShopIdIsNull() {
            return isNull(jdShopId);
        }

        public JdShopInfoExample.Criteria andJdShopIdIsNotNull() {
            return isNotNull(jdShopId);
        }

        public JdShopInfoExample.Criteria andJdShopIdEqualTo(Long value) {
            return equalTo(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdNotEqualTo(Long value) {
            return notEqualTo(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdGreaterThan(Long value) {
            return greaterThan(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdLessThan(Long value) {
            return lessThan(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdShopId, value);
        }

        public JdShopInfoExample.Criteria andJdShopIdIn(List<Long> values) {
            return in(jdShopId, values);
        }

        public JdShopInfoExample.Criteria andJdShopIdNotIn(List<Long> values) {
            return notIn(jdShopId, values);
        }

        public JdShopInfoExample.Criteria andJdShopIdBetween(Long value1, Long value2) {
            return between(jdShopId, value1, value2);
        }

        public JdShopInfoExample.Criteria andJdShopIdNotBetween(Long value1, Long value2) {
            return notBetween(jdShopId, value1, value2);
        }
        public JdShopInfoExample.Criteria andCategoryMainNameIsNull() {
            return isNull(categoryMainName);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameIsNotNull() {
            return isNotNull(categoryMainName);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameEqualTo(String value) {
            return equalTo(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameNotEqualTo(String value) {
            return notEqualTo(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameGreaterThan(String value) {
            return greaterThan(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameLessThan(String value) {
            return lessThan(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameLike(String value) {
            return like(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameNotLike(String value) {
            return notLike(categoryMainName, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameIn(List<String> values) {
            return in(categoryMainName, values);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameNotIn(List<String> values) {
            return notIn(categoryMainName, values);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameBetween(String value1, String value2) {
            return between(categoryMainName, value1, value2);
        }

        public JdShopInfoExample.Criteria andCategoryMainNameNotBetween(String value1, String value2) {
            return notBetween(categoryMainName, value1, value2);
        }
        public JdShopInfoExample.Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public JdShopInfoExample.Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public JdShopInfoExample.Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public JdShopInfoExample.Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public JdShopInfoExample.Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public JdShopInfoExample.Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public JdShopInfoExample.Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public JdShopInfoExample.Criteria andCategoryMainIsNull() {
            return isNull(categoryMain);
        }

        public JdShopInfoExample.Criteria andCategoryMainIsNotNull() {
            return isNotNull(categoryMain);
        }

        public JdShopInfoExample.Criteria andCategoryMainEqualTo(Long value) {
            return equalTo(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainNotEqualTo(Long value) {
            return notEqualTo(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainGreaterThan(Long value) {
            return greaterThan(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainLessThan(Long value) {
            return lessThan(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(categoryMain, value);
        }

        public JdShopInfoExample.Criteria andCategoryMainIn(List<Long> values) {
            return in(categoryMain, values);
        }

        public JdShopInfoExample.Criteria andCategoryMainNotIn(List<Long> values) {
            return notIn(categoryMain, values);
        }

        public JdShopInfoExample.Criteria andCategoryMainBetween(Long value1, Long value2) {
            return between(categoryMain, value1, value2);
        }

        public JdShopInfoExample.Criteria andCategoryMainNotBetween(Long value1, Long value2) {
            return notBetween(categoryMain, value1, value2);
        }
        public JdShopInfoExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public JdShopInfoExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public JdShopInfoExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public JdShopInfoExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public JdShopInfoExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public JdShopInfoExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public JdShopInfoExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public JdShopInfoExample.Criteria andJdShopLogoUrlIsNull() {
            return isNull(jdShopLogoUrl);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlIsNotNull() {
            return isNotNull(jdShopLogoUrl);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlEqualTo(String value) {
            return equalTo(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlNotEqualTo(String value) {
            return notEqualTo(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlGreaterThan(String value) {
            return greaterThan(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlLessThan(String value) {
            return lessThan(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlLike(String value) {
            return like(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlNotLike(String value) {
            return notLike(jdShopLogoUrl, value);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlIn(List<String> values) {
            return in(jdShopLogoUrl, values);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlNotIn(List<String> values) {
            return notIn(jdShopLogoUrl, values);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlBetween(String value1, String value2) {
            return between(jdShopLogoUrl, value1, value2);
        }

        public JdShopInfoExample.Criteria andJdShopLogoUrlNotBetween(String value1, String value2) {
            return notBetween(jdShopLogoUrl, value1, value2);
        }
        public JdShopInfoExample.Criteria andVenderIdIsNull() {
            return isNull(venderId);
        }

        public JdShopInfoExample.Criteria andVenderIdIsNotNull() {
            return isNotNull(venderId);
        }

        public JdShopInfoExample.Criteria andVenderIdEqualTo(Long value) {
            return equalTo(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdNotEqualTo(Long value) {
            return notEqualTo(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdGreaterThan(Long value) {
            return greaterThan(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdLessThan(Long value) {
            return lessThan(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(venderId, value);
        }

        public JdShopInfoExample.Criteria andVenderIdIn(List<Long> values) {
            return in(venderId, values);
        }

        public JdShopInfoExample.Criteria andVenderIdNotIn(List<Long> values) {
            return notIn(venderId, values);
        }

        public JdShopInfoExample.Criteria andVenderIdBetween(Long value1, Long value2) {
            return between(venderId, value1, value2);
        }

        public JdShopInfoExample.Criteria andVenderIdNotBetween(Long value1, Long value2) {
            return notBetween(venderId, value1, value2);
        }
        public JdShopInfoExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public JdShopInfoExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public JdShopInfoExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public JdShopInfoExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public JdShopInfoExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public JdShopInfoExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public JdShopInfoExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public JdShopInfoExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public JdShopInfoExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public JdShopInfoExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public JdShopInfoExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public JdShopInfoExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public JdShopInfoExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public JdShopInfoExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public JdShopInfoExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public JdShopInfoExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public JdShopInfoExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public JdShopInfoExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public JdShopInfoExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public JdShopInfoExample.Criteria andOpenTimeIsNull() {
            return isNull(openTime);
        }

        public JdShopInfoExample.Criteria andOpenTimeIsNotNull() {
            return isNotNull(openTime);
        }

        public JdShopInfoExample.Criteria andOpenTimeEqualTo(Date value) {
            return equalTo(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeNotEqualTo(Date value) {
            return notEqualTo(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeGreaterThan(Date value) {
            return greaterThan(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeLessThan(Date value) {
            return lessThan(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(openTime, value);
        }

        public JdShopInfoExample.Criteria andOpenTimeIn(List<Date> values) {
            return in(openTime, values);
        }

        public JdShopInfoExample.Criteria andOpenTimeNotIn(List<Date> values) {
            return notIn(openTime, values);
        }

        public JdShopInfoExample.Criteria andOpenTimeBetween(Date value1, Date value2) {
            return between(openTime, value1, value2);
        }

        public JdShopInfoExample.Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            return notBetween(openTime, value1, value2);
        }
        public JdShopInfoExample.Criteria andJdShopNameIsNull() {
            return isNull(jdShopName);
        }

        public JdShopInfoExample.Criteria andJdShopNameIsNotNull() {
            return isNotNull(jdShopName);
        }

        public JdShopInfoExample.Criteria andJdShopNameEqualTo(String value) {
            return equalTo(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameNotEqualTo(String value) {
            return notEqualTo(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameGreaterThan(String value) {
            return greaterThan(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameLessThan(String value) {
            return lessThan(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameLike(String value) {
            return like(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameNotLike(String value) {
            return notLike(jdShopName, value);
        }

        public JdShopInfoExample.Criteria andJdShopNameIn(List<String> values) {
            return in(jdShopName, values);
        }

        public JdShopInfoExample.Criteria andJdShopNameNotIn(List<String> values) {
            return notIn(jdShopName, values);
        }

        public JdShopInfoExample.Criteria andJdShopNameBetween(String value1, String value2) {
            return between(jdShopName, value1, value2);
        }

        public JdShopInfoExample.Criteria andJdShopNameNotBetween(String value1, String value2) {
            return notBetween(jdShopName, value1, value2);
        }
    }
}