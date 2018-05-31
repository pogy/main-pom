package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoWorks;

import java.util.*;
public class ShiguPhotoWorksExample extends SgExample<ShiguPhotoWorksExample.Criteria> {
    public static final Class<ShiguPhotoWorks> beanClass = ShiguPhotoWorks.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn removeIs;
    public static EntityColumn images;
    public static EntityColumn title;
    public static EntityColumn authorId;
    public static EntityColumn content;
    public static EntityColumn picUrl;
    public static EntityColumn createTime;
    public static EntityColumn havePrice;
    public static EntityColumn worksId;
    public static EntityColumn price;
    public static EntityColumn searchOpen;
    public static EntityColumn clicks;
    public static EntityColumn forbidSave;
    public static EntityColumn worksCid;
    public static EntityColumn lastModifyTme;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        removeIs = listMap.get("removeIs");
        images = listMap.get("images");
        title = listMap.get("title");
        authorId = listMap.get("authorId");
        content = listMap.get("content");
        picUrl = listMap.get("picUrl");
        createTime = listMap.get("createTime");
        havePrice = listMap.get("havePrice");
        worksId = listMap.get("worksId");
        price = listMap.get("price");
        searchOpen = listMap.get("searchOpen");
        clicks = listMap.get("clicks");
        forbidSave = listMap.get("forbidSave");
        worksCid = listMap.get("worksCid");
        lastModifyTme = listMap.get("lastModifyTme");
        }

    public ShiguPhotoWorksExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoWorksExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoWorksExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsIsNull() {
            return isNull(removeIs);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsIsNotNull() {
            return isNotNull(removeIs);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsEqualTo(Boolean value) {
            return equalTo(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsNotEqualTo(Boolean value) {
            return notEqualTo(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsGreaterThan(Boolean value) {
            return greaterThan(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsLessThan(Boolean value) {
            return lessThan(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(removeIs, value);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsIn(List<Boolean> values) {
            return in(removeIs, values);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsNotIn(List<Boolean> values) {
            return notIn(removeIs, values);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsBetween(Boolean value1, Boolean value2) {
            return between(removeIs, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andRemoveIsNotBetween(Boolean value1, Boolean value2) {
            return notBetween(removeIs, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andImagesIsNull() {
            return isNull(images);
        }

        public ShiguPhotoWorksExample.Criteria andImagesIsNotNull() {
            return isNotNull(images);
        }

        public ShiguPhotoWorksExample.Criteria andImagesEqualTo(String value) {
            return equalTo(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesNotEqualTo(String value) {
            return notEqualTo(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesGreaterThan(String value) {
            return greaterThan(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesLessThan(String value) {
            return lessThan(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesLike(String value) {
            return like(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesNotLike(String value) {
            return notLike(images, value);
        }

        public ShiguPhotoWorksExample.Criteria andImagesIn(List<String> values) {
            return in(images, values);
        }

        public ShiguPhotoWorksExample.Criteria andImagesNotIn(List<String> values) {
            return notIn(images, values);
        }

        public ShiguPhotoWorksExample.Criteria andImagesBetween(String value1, String value2) {
            return between(images, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andImagesNotBetween(String value1, String value2) {
            return notBetween(images, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguPhotoWorksExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguPhotoWorksExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguPhotoWorksExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguPhotoWorksExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguPhotoWorksExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andAuthorIdIsNull() {
            return isNull(authorId);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdIsNotNull() {
            return isNotNull(authorId);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdEqualTo(Long value) {
            return equalTo(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdNotEqualTo(Long value) {
            return notEqualTo(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdGreaterThan(Long value) {
            return greaterThan(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdLessThan(Long value) {
            return lessThan(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdIn(List<Long> values) {
            return in(authorId, values);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdNotIn(List<Long> values) {
            return notIn(authorId, values);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdBetween(Long value1, Long value2) {
            return between(authorId, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(authorId, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andContentIsNull() {
            return isNull(content);
        }

        public ShiguPhotoWorksExample.Criteria andContentIsNotNull() {
            return isNotNull(content);
        }

        public ShiguPhotoWorksExample.Criteria andContentEqualTo(String value) {
            return equalTo(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentNotEqualTo(String value) {
            return notEqualTo(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentGreaterThan(String value) {
            return greaterThan(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentLessThan(String value) {
            return lessThan(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentLike(String value) {
            return like(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentNotLike(String value) {
            return notLike(content, value);
        }

        public ShiguPhotoWorksExample.Criteria andContentIn(List<String> values) {
            return in(content, values);
        }

        public ShiguPhotoWorksExample.Criteria andContentNotIn(List<String> values) {
            return notIn(content, values);
        }

        public ShiguPhotoWorksExample.Criteria andContentBetween(String value1, String value2) {
            return between(content, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andContentNotBetween(String value1, String value2) {
            return notBetween(content, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andHavePriceIsNull() {
            return isNull(havePrice);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceIsNotNull() {
            return isNotNull(havePrice);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceEqualTo(Boolean value) {
            return equalTo(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceNotEqualTo(Boolean value) {
            return notEqualTo(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceGreaterThan(Boolean value) {
            return greaterThan(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceLessThan(Boolean value) {
            return lessThan(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(havePrice, value);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceIn(List<Boolean> values) {
            return in(havePrice, values);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceNotIn(List<Boolean> values) {
            return notIn(havePrice, values);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceBetween(Boolean value1, Boolean value2) {
            return between(havePrice, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andHavePriceNotBetween(Boolean value1, Boolean value2) {
            return notBetween(havePrice, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andWorksIdIsNull() {
            return isNull(worksId);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdIsNotNull() {
            return isNotNull(worksId);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdEqualTo(Long value) {
            return equalTo(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdNotEqualTo(Long value) {
            return notEqualTo(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdGreaterThan(Long value) {
            return greaterThan(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdLessThan(Long value) {
            return lessThan(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdIn(List<Long> values) {
            return in(worksId, values);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdNotIn(List<Long> values) {
            return notIn(worksId, values);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdBetween(Long value1, Long value2) {
            return between(worksId, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andWorksIdNotBetween(Long value1, Long value2) {
            return notBetween(worksId, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ShiguPhotoWorksExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ShiguPhotoWorksExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ShiguPhotoWorksExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ShiguPhotoWorksExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ShiguPhotoWorksExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andSearchOpenIsNull() {
            return isNull(searchOpen);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenIsNotNull() {
            return isNotNull(searchOpen);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenEqualTo(Integer value) {
            return equalTo(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenNotEqualTo(Integer value) {
            return notEqualTo(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenGreaterThan(Integer value) {
            return greaterThan(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenLessThan(Integer value) {
            return lessThan(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(searchOpen, value);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenIn(List<Integer> values) {
            return in(searchOpen, values);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenNotIn(List<Integer> values) {
            return notIn(searchOpen, values);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenBetween(Integer value1, Integer value2) {
            return between(searchOpen, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andSearchOpenNotBetween(Integer value1, Integer value2) {
            return notBetween(searchOpen, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andClicksIsNull() {
            return isNull(clicks);
        }

        public ShiguPhotoWorksExample.Criteria andClicksIsNotNull() {
            return isNotNull(clicks);
        }

        public ShiguPhotoWorksExample.Criteria andClicksEqualTo(Long value) {
            return equalTo(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksNotEqualTo(Long value) {
            return notEqualTo(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksGreaterThan(Long value) {
            return greaterThan(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksLessThan(Long value) {
            return lessThan(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicks, value);
        }

        public ShiguPhotoWorksExample.Criteria andClicksIn(List<Long> values) {
            return in(clicks, values);
        }

        public ShiguPhotoWorksExample.Criteria andClicksNotIn(List<Long> values) {
            return notIn(clicks, values);
        }

        public ShiguPhotoWorksExample.Criteria andClicksBetween(Long value1, Long value2) {
            return between(clicks, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            return notBetween(clicks, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andForbidSaveIsNull() {
            return isNull(forbidSave);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveIsNotNull() {
            return isNotNull(forbidSave);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveEqualTo(Boolean value) {
            return equalTo(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveNotEqualTo(Boolean value) {
            return notEqualTo(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveGreaterThan(Boolean value) {
            return greaterThan(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveLessThan(Boolean value) {
            return lessThan(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(forbidSave, value);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveIn(List<Boolean> values) {
            return in(forbidSave, values);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveNotIn(List<Boolean> values) {
            return notIn(forbidSave, values);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveBetween(Boolean value1, Boolean value2) {
            return between(forbidSave, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andForbidSaveNotBetween(Boolean value1, Boolean value2) {
            return notBetween(forbidSave, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andWorksCidIsNull() {
            return isNull(worksCid);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidIsNotNull() {
            return isNotNull(worksCid);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidEqualTo(Long value) {
            return equalTo(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidNotEqualTo(Long value) {
            return notEqualTo(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidGreaterThan(Long value) {
            return greaterThan(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidLessThan(Long value) {
            return lessThan(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksCid, value);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidIn(List<Long> values) {
            return in(worksCid, values);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidNotIn(List<Long> values) {
            return notIn(worksCid, values);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidBetween(Long value1, Long value2) {
            return between(worksCid, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andWorksCidNotBetween(Long value1, Long value2) {
            return notBetween(worksCid, value1, value2);
        }
        public ShiguPhotoWorksExample.Criteria andLastModifyTmeIsNull() {
            return isNull(lastModifyTme);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeIsNotNull() {
            return isNotNull(lastModifyTme);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeEqualTo(Date value) {
            return equalTo(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeGreaterThan(Date value) {
            return greaterThan(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeLessThan(Date value) {
            return lessThan(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTme, value);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeIn(List<Date> values) {
            return in(lastModifyTme, values);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeNotIn(List<Date> values) {
            return notIn(lastModifyTme, values);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeBetween(Date value1, Date value2) {
            return between(lastModifyTme, value1, value2);
        }

        public ShiguPhotoWorksExample.Criteria andLastModifyTmeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTme, value1, value2);
        }
    }
}