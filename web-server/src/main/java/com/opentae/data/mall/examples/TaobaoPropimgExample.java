package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoPropimg;

import java.util.*;

public class TaobaoPropimgExample extends SgExample<TaobaoPropimgExample.Criteria> {
    public static final Class<TaobaoPropimg> beanClass = TaobaoPropimg.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn numIid;
    public static EntityColumn url;
    public static EntityColumn itemId;
    public static EntityColumn createTime;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn id;
    public static EntityColumn position;
    public static EntityColumn remark1;
    public static EntityColumn properties;
    public static EntityColumn remark3;
    public static EntityColumn tbPiId;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        numIid = listMap.get("numIid");
        url = listMap.get("url");
        itemId = listMap.get("itemId");
        createTime = listMap.get("createTime");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        id = listMap.get("id");
        position = listMap.get("position");
        remark1 = listMap.get("remark1");
        properties = listMap.get("properties");
        remark3 = listMap.get("remark3");
        tbPiId = listMap.get("tbPiId");
        remark2 = listMap.get("remark2");
        }

    public TaobaoPropimgExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TaobaoPropimgExample.Criteria createCriteriaInternal() {
        return new TaobaoPropimgExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TaobaoPropimgExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public TaobaoPropimgExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public TaobaoPropimgExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public TaobaoPropimgExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public TaobaoPropimgExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public TaobaoPropimgExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andUrlIsNull() {
            return isNull(url);
        }

        public TaobaoPropimgExample.Criteria andUrlIsNotNull() {
            return isNotNull(url);
        }

        public TaobaoPropimgExample.Criteria andUrlEqualTo(String value) {
            return equalTo(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlNotEqualTo(String value) {
            return notEqualTo(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlGreaterThan(String value) {
            return greaterThan(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlLessThan(String value) {
            return lessThan(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlLike(String value) {
            return like(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlNotLike(String value) {
            return notLike(url, value);
        }

        public TaobaoPropimgExample.Criteria andUrlIn(List<String> values) {
            return in(url, values);
        }

        public TaobaoPropimgExample.Criteria andUrlNotIn(List<String> values) {
            return notIn(url, values);
        }

        public TaobaoPropimgExample.Criteria andUrlBetween(String value1, String value2) {
            return between(url, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andUrlNotBetween(String value1, String value2) {
            return notBetween(url, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andItemIdIsNull() {
            return isNull(itemId);
        }

        public TaobaoPropimgExample.Criteria andItemIdIsNotNull() {
            return isNotNull(itemId);
        }

        public TaobaoPropimgExample.Criteria andItemIdEqualTo(Long value) {
            return equalTo(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdNotEqualTo(Long value) {
            return notEqualTo(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdGreaterThan(Long value) {
            return greaterThan(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdLessThan(Long value) {
            return lessThan(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemId, value);
        }

        public TaobaoPropimgExample.Criteria andItemIdIn(List<Long> values) {
            return in(itemId, values);
        }

        public TaobaoPropimgExample.Criteria andItemIdNotIn(List<Long> values) {
            return notIn(itemId, values);
        }

        public TaobaoPropimgExample.Criteria andItemIdBetween(Long value1, Long value2) {
            return between(itemId, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            return notBetween(itemId, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoPropimgExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoPropimgExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoPropimgExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public TaobaoPropimgExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public TaobaoPropimgExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoPropimgExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoPropimgExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoPropimgExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public TaobaoPropimgExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public TaobaoPropimgExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public TaobaoPropimgExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public TaobaoPropimgExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public TaobaoPropimgExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public TaobaoPropimgExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public TaobaoPropimgExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andPositionIsNull() {
            return isNull(position);
        }

        public TaobaoPropimgExample.Criteria andPositionIsNotNull() {
            return isNotNull(position);
        }

        public TaobaoPropimgExample.Criteria andPositionEqualTo(Integer value) {
            return equalTo(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionNotEqualTo(Integer value) {
            return notEqualTo(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionGreaterThan(Integer value) {
            return greaterThan(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionLessThan(Integer value) {
            return lessThan(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(position, value);
        }

        public TaobaoPropimgExample.Criteria andPositionIn(List<Integer> values) {
            return in(position, values);
        }

        public TaobaoPropimgExample.Criteria andPositionNotIn(List<Integer> values) {
            return notIn(position, values);
        }

        public TaobaoPropimgExample.Criteria andPositionBetween(Integer value1, Integer value2) {
            return between(position, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andPositionNotBetween(Integer value1, Integer value2) {
            return notBetween(position, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoPropimgExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoPropimgExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoPropimgExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TaobaoPropimgExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TaobaoPropimgExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andPropertiesIsNull() {
            return isNull(properties);
        }

        public TaobaoPropimgExample.Criteria andPropertiesIsNotNull() {
            return isNotNull(properties);
        }

        public TaobaoPropimgExample.Criteria andPropertiesEqualTo(String value) {
            return equalTo(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotEqualTo(String value) {
            return notEqualTo(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesGreaterThan(String value) {
            return greaterThan(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesLessThan(String value) {
            return lessThan(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesLike(String value) {
            return like(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotLike(String value) {
            return notLike(properties, value);
        }

        public TaobaoPropimgExample.Criteria andPropertiesIn(List<String> values) {
            return in(properties, values);
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotIn(List<String> values) {
            return notIn(properties, values);
        }

        public TaobaoPropimgExample.Criteria andPropertiesBetween(String value1, String value2) {
            return between(properties, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotBetween(String value1, String value2) {
            return notBetween(properties, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoPropimgExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoPropimgExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoPropimgExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public TaobaoPropimgExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public TaobaoPropimgExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andTbPiIdIsNull() {
            return isNull(tbPiId);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdIsNotNull() {
            return isNotNull(tbPiId);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdEqualTo(Long value) {
            return equalTo(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotEqualTo(Long value) {
            return notEqualTo(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdGreaterThan(Long value) {
            return greaterThan(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdLessThan(Long value) {
            return lessThan(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbPiId, value);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdIn(List<Long> values) {
            return in(tbPiId, values);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotIn(List<Long> values) {
            return notIn(tbPiId, values);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdBetween(Long value1, Long value2) {
            return between(tbPiId, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotBetween(Long value1, Long value2) {
            return notBetween(tbPiId, value1, value2);
        }
        public TaobaoPropimgExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoPropimgExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoPropimgExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TaobaoPropimgExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TaobaoPropimgExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TaobaoPropimgExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoPropimgExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}