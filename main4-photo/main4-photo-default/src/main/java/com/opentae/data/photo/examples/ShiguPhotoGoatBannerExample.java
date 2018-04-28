package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoGoatBanner;

import java.util.*;
public class ShiguPhotoGoatBannerExample extends SgExample<ShiguPhotoGoatBannerExample.Criteria> {
    public static final Class<ShiguPhotoGoatBanner> beanClass = ShiguPhotoGoatBanner.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn banner;
    public static EntityColumn goatId;
    public static EntityColumn place;
    public static EntityColumn url;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        banner = listMap.get("banner");
        goatId = listMap.get("goatId");
        place = listMap.get("place");
        url = listMap.get("url");
        }

    public ShiguPhotoGoatBannerExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoGoatBannerExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoGoatBannerExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerIsNull() {
            return isNull(banner);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerIsNotNull() {
            return isNotNull(banner);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerEqualTo(String value) {
            return equalTo(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerNotEqualTo(String value) {
            return notEqualTo(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerGreaterThan(String value) {
            return greaterThan(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerLessThan(String value) {
            return lessThan(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerLike(String value) {
            return like(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerNotLike(String value) {
            return notLike(banner, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerIn(List<String> values) {
            return in(banner, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerNotIn(List<String> values) {
            return notIn(banner, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerBetween(String value1, String value2) {
            return between(banner, value1, value2);
        }

        public ShiguPhotoGoatBannerExample.Criteria andBannerNotBetween(String value1, String value2) {
            return notBetween(banner, value1, value2);
        }
        public ShiguPhotoGoatBannerExample.Criteria andGoatIdIsNull() {
            return isNull(goatId);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdIsNotNull() {
            return isNotNull(goatId);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdEqualTo(Long value) {
            return equalTo(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdNotEqualTo(Long value) {
            return notEqualTo(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdGreaterThan(Long value) {
            return greaterThan(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdLessThan(Long value) {
            return lessThan(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goatId, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdIn(List<Long> values) {
            return in(goatId, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdNotIn(List<Long> values) {
            return notIn(goatId, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            return between(goatId, value1, value2);
        }

        public ShiguPhotoGoatBannerExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            return notBetween(goatId, value1, value2);
        }
        public ShiguPhotoGoatBannerExample.Criteria andPlaceIsNull() {
            return isNull(place);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceIsNotNull() {
            return isNotNull(place);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceEqualTo(Integer value) {
            return equalTo(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceNotEqualTo(Integer value) {
            return notEqualTo(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceGreaterThan(Integer value) {
            return greaterThan(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceLessThan(Integer value) {
            return lessThan(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(place, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceIn(List<Integer> values) {
            return in(place, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceNotIn(List<Integer> values) {
            return notIn(place, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceBetween(Integer value1, Integer value2) {
            return between(place, value1, value2);
        }

        public ShiguPhotoGoatBannerExample.Criteria andPlaceNotBetween(Integer value1, Integer value2) {
            return notBetween(place, value1, value2);
        }
        public ShiguPhotoGoatBannerExample.Criteria andUrlIsNull() {
            return isNull(url);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlIsNotNull() {
            return isNotNull(url);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlEqualTo(String value) {
            return equalTo(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlNotEqualTo(String value) {
            return notEqualTo(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlGreaterThan(String value) {
            return greaterThan(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlLessThan(String value) {
            return lessThan(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlLike(String value) {
            return like(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlNotLike(String value) {
            return notLike(url, value);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlIn(List<String> values) {
            return in(url, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlNotIn(List<String> values) {
            return notIn(url, values);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlBetween(String value1, String value2) {
            return between(url, value1, value2);
        }

        public ShiguPhotoGoatBannerExample.Criteria andUrlNotBetween(String value1, String value2) {
            return notBetween(url, value1, value2);
        }
    }
}