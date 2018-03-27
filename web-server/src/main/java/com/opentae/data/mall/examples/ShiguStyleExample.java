package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStyle;

import java.util.*;
public class ShiguStyleExample extends SgExample<ShiguStyleExample.Criteria> {
    public static final Class<ShiguStyle> beanClass = ShiguStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn channelImgUrl;
    public static EntityColumn isParent;
    public static EntityColumn parentStyleId;
    public static EntityColumn gmtModify;
    public static EntityColumn description;
    public static EntityColumn id;
    public static EntityColumn sort;
    public static EntityColumn tag;
    public static EntityColumn styleName;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        channelImgUrl = listMap.get("channelImgUrl");
        isParent = listMap.get("isParent");
        parentStyleId = listMap.get("parentStyleId");
        gmtModify = listMap.get("gmtModify");
        description = listMap.get("description");
        id = listMap.get("id");
        sort = listMap.get("sort");
        tag = listMap.get("tag");
        styleName = listMap.get("styleName");
        gmtCreate = listMap.get("gmtCreate");
        }

    public ShiguStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStyleExample.Criteria createCriteriaInternal() {
        return new ShiguStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlIsNull() {
            return isNull(channelImgUrl);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlIsNotNull() {
            return isNotNull(channelImgUrl);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlEqualTo(String value) {
            return equalTo(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlNotEqualTo(String value) {
            return notEqualTo(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlGreaterThan(String value) {
            return greaterThan(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlLessThan(String value) {
            return lessThan(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlLike(String value) {
            return like(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlNotLike(String value) {
            return notLike(channelImgUrl, value);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlIn(List<String> values) {
            return in(channelImgUrl, values);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlNotIn(List<String> values) {
            return notIn(channelImgUrl, values);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlBetween(String value1, String value2) {
            return between(channelImgUrl, value1, value2);
        }

        public ShiguStyleExample.Criteria andChannelImgUrlNotBetween(String value1, String value2) {
            return notBetween(channelImgUrl, value1, value2);
        }
        public ShiguStyleExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguStyleExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguStyleExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguStyleExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public ShiguStyleExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public ShiguStyleExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public ShiguStyleExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguStyleExample.Criteria andParentStyleIdIsNull() {
            return isNull(parentStyleId);
        }

        public ShiguStyleExample.Criteria andParentStyleIdIsNotNull() {
            return isNotNull(parentStyleId);
        }

        public ShiguStyleExample.Criteria andParentStyleIdEqualTo(Long value) {
            return equalTo(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdNotEqualTo(Long value) {
            return notEqualTo(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdGreaterThan(Long value) {
            return greaterThan(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdLessThan(Long value) {
            return lessThan(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentStyleId, value);
        }

        public ShiguStyleExample.Criteria andParentStyleIdIn(List<Long> values) {
            return in(parentStyleId, values);
        }

        public ShiguStyleExample.Criteria andParentStyleIdNotIn(List<Long> values) {
            return notIn(parentStyleId, values);
        }

        public ShiguStyleExample.Criteria andParentStyleIdBetween(Long value1, Long value2) {
            return between(parentStyleId, value1, value2);
        }

        public ShiguStyleExample.Criteria andParentStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(parentStyleId, value1, value2);
        }
        public ShiguStyleExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguStyleExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguStyleExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguStyleExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguStyleExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguStyleExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguStyleExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguStyleExample.Criteria andDescriptionIsNull() {
            return isNull(description);
        }

        public ShiguStyleExample.Criteria andDescriptionIsNotNull() {
            return isNotNull(description);
        }

        public ShiguStyleExample.Criteria andDescriptionEqualTo(String value) {
            return equalTo(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionNotEqualTo(String value) {
            return notEqualTo(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionGreaterThan(String value) {
            return greaterThan(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionLessThan(String value) {
            return lessThan(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionLike(String value) {
            return like(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionNotLike(String value) {
            return notLike(description, value);
        }

        public ShiguStyleExample.Criteria andDescriptionIn(List<String> values) {
            return in(description, values);
        }

        public ShiguStyleExample.Criteria andDescriptionNotIn(List<String> values) {
            return notIn(description, values);
        }

        public ShiguStyleExample.Criteria andDescriptionBetween(String value1, String value2) {
            return between(description, value1, value2);
        }

        public ShiguStyleExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            return notBetween(description, value1, value2);
        }
        public ShiguStyleExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguStyleExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguStyleExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguStyleExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguStyleExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguStyleExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguStyleExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguStyleExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguStyleExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguStyleExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguStyleExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguStyleExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguStyleExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public ShiguStyleExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public ShiguStyleExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public ShiguStyleExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public ShiguStyleExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public ShiguStyleExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public ShiguStyleExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public ShiguStyleExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public ShiguStyleExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public ShiguStyleExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public ShiguStyleExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public ShiguStyleExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public ShiguStyleExample.Criteria andTagIsNull() {
            return isNull(tag);
        }

        public ShiguStyleExample.Criteria andTagIsNotNull() {
            return isNotNull(tag);
        }

        public ShiguStyleExample.Criteria andTagEqualTo(String value) {
            return equalTo(tag, value);
        }

        public ShiguStyleExample.Criteria andTagNotEqualTo(String value) {
            return notEqualTo(tag, value);
        }

        public ShiguStyleExample.Criteria andTagGreaterThan(String value) {
            return greaterThan(tag, value);
        }

        public ShiguStyleExample.Criteria andTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tag, value);
        }

        public ShiguStyleExample.Criteria andTagLessThan(String value) {
            return lessThan(tag, value);
        }

        public ShiguStyleExample.Criteria andTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tag, value);
        }

        public ShiguStyleExample.Criteria andTagLike(String value) {
            return like(tag, value);
        }

        public ShiguStyleExample.Criteria andTagNotLike(String value) {
            return notLike(tag, value);
        }

        public ShiguStyleExample.Criteria andTagIn(List<String> values) {
            return in(tag, values);
        }

        public ShiguStyleExample.Criteria andTagNotIn(List<String> values) {
            return notIn(tag, values);
        }

        public ShiguStyleExample.Criteria andTagBetween(String value1, String value2) {
            return between(tag, value1, value2);
        }

        public ShiguStyleExample.Criteria andTagNotBetween(String value1, String value2) {
            return notBetween(tag, value1, value2);
        }
        public ShiguStyleExample.Criteria andStyleNameIsNull() {
            return isNull(styleName);
        }

        public ShiguStyleExample.Criteria andStyleNameIsNotNull() {
            return isNotNull(styleName);
        }

        public ShiguStyleExample.Criteria andStyleNameEqualTo(String value) {
            return equalTo(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameNotEqualTo(String value) {
            return notEqualTo(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameGreaterThan(String value) {
            return greaterThan(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameLessThan(String value) {
            return lessThan(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameLike(String value) {
            return like(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameNotLike(String value) {
            return notLike(styleName, value);
        }

        public ShiguStyleExample.Criteria andStyleNameIn(List<String> values) {
            return in(styleName, values);
        }

        public ShiguStyleExample.Criteria andStyleNameNotIn(List<String> values) {
            return notIn(styleName, values);
        }

        public ShiguStyleExample.Criteria andStyleNameBetween(String value1, String value2) {
            return between(styleName, value1, value2);
        }

        public ShiguStyleExample.Criteria andStyleNameNotBetween(String value1, String value2) {
            return notBetween(styleName, value1, value2);
        }
        public ShiguStyleExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguStyleExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguStyleExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguStyleExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguStyleExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguStyleExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguStyleExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
    }
}