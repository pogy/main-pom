package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguFlickrPicture;

import java.util.*;
public class ShiguFlickrPictureExample extends SgExample<ShiguFlickrPictureExample.Criteria> {
    public static final Class<ShiguFlickrPicture> beanClass = ShiguFlickrPicture.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn fId;
    public static EntityColumn picUrl;
    public static EntityColumn createTime;
    public static EntityColumn sortOrder;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn picStatus;
    public static EntityColumn remark1;
    public static EntityColumn picId;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        fId = listMap.get("fId");
        picUrl = listMap.get("picUrl");
        createTime = listMap.get("createTime");
        sortOrder = listMap.get("sortOrder");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        picStatus = listMap.get("picStatus");
        remark1 = listMap.get("remark1");
        picId = listMap.get("picId");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguFlickrPictureExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguFlickrPictureExample.Criteria createCriteriaInternal() {
        return new ShiguFlickrPictureExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguFlickrPictureExample.Criteria andFIdIsNull() {
            return isNull(fId);
        }

        public ShiguFlickrPictureExample.Criteria andFIdIsNotNull() {
            return isNotNull(fId);
        }

        public ShiguFlickrPictureExample.Criteria andFIdEqualTo(Long value) {
            return equalTo(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdNotEqualTo(Long value) {
            return notEqualTo(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdGreaterThan(Long value) {
            return greaterThan(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdLessThan(Long value) {
            return lessThan(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fId, value);
        }

        public ShiguFlickrPictureExample.Criteria andFIdIn(List<Long> values) {
            return in(fId, values);
        }

        public ShiguFlickrPictureExample.Criteria andFIdNotIn(List<Long> values) {
            return notIn(fId, values);
        }

        public ShiguFlickrPictureExample.Criteria andFIdBetween(Long value1, Long value2) {
            return between(fId, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andFIdNotBetween(Long value1, Long value2) {
            return notBetween(fId, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andPicStatusIsNull() {
            return isNull(picStatus);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusIsNotNull() {
            return isNotNull(picStatus);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusEqualTo(Integer value) {
            return equalTo(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusNotEqualTo(Integer value) {
            return notEqualTo(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusGreaterThan(Integer value) {
            return greaterThan(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusLessThan(Integer value) {
            return lessThan(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(picStatus, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusIn(List<Integer> values) {
            return in(picStatus, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusNotIn(List<Integer> values) {
            return notIn(picStatus, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusBetween(Integer value1, Integer value2) {
            return between(picStatus, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andPicStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(picStatus, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andPicIdIsNull() {
            return isNull(picId);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdIsNotNull() {
            return isNotNull(picId);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdEqualTo(Long value) {
            return equalTo(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdNotEqualTo(Long value) {
            return notEqualTo(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdGreaterThan(Long value) {
            return greaterThan(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdLessThan(Long value) {
            return lessThan(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(picId, value);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdIn(List<Long> values) {
            return in(picId, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdNotIn(List<Long> values) {
            return notIn(picId, values);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdBetween(Long value1, Long value2) {
            return between(picId, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andPicIdNotBetween(Long value1, Long value2) {
            return notBetween(picId, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguFlickrPictureExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguFlickrPictureExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}