package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoGoatPlace;

import java.util.*;
public class ShiguPhotoGoatPlaceExample extends SgExample<ShiguPhotoGoatPlaceExample.Criteria> {
    public static final Class<ShiguPhotoGoatPlace> beanClass = ShiguPhotoGoatPlace.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn worksId;
    public static EntityColumn goatId;
    public static EntityColumn place;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        worksId = listMap.get("worksId");
        goatId = listMap.get("goatId");
        place = listMap.get("place");
        }

    public ShiguPhotoGoatPlaceExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoGoatPlaceExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoGoatPlaceExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdIsNull() {
            return isNull(worksId);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdIsNotNull() {
            return isNotNull(worksId);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdEqualTo(Long value) {
            return equalTo(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdNotEqualTo(Long value) {
            return notEqualTo(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdGreaterThan(Long value) {
            return greaterThan(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdLessThan(Long value) {
            return lessThan(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdIn(List<Long> values) {
            return in(worksId, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdNotIn(List<Long> values) {
            return notIn(worksId, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdBetween(Long value1, Long value2) {
            return between(worksId, value1, value2);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andWorksIdNotBetween(Long value1, Long value2) {
            return notBetween(worksId, value1, value2);
        }
        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdIsNull() {
            return isNull(goatId);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdIsNotNull() {
            return isNotNull(goatId);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdEqualTo(Long value) {
            return equalTo(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdNotEqualTo(Long value) {
            return notEqualTo(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdGreaterThan(Long value) {
            return greaterThan(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdLessThan(Long value) {
            return lessThan(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goatId, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdIn(List<Long> values) {
            return in(goatId, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdNotIn(List<Long> values) {
            return notIn(goatId, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            return between(goatId, value1, value2);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            return notBetween(goatId, value1, value2);
        }
        public ShiguPhotoGoatPlaceExample.Criteria andPlaceIsNull() {
            return isNull(place);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceIsNotNull() {
            return isNotNull(place);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceEqualTo(Integer value) {
            return equalTo(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceNotEqualTo(Integer value) {
            return notEqualTo(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceGreaterThan(Integer value) {
            return greaterThan(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceLessThan(Integer value) {
            return lessThan(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(place, value);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceIn(List<Integer> values) {
            return in(place, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceNotIn(List<Integer> values) {
            return notIn(place, values);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceBetween(Integer value1, Integer value2) {
            return between(place, value1, value2);
        }

        public ShiguPhotoGoatPlaceExample.Criteria andPlaceNotBetween(Integer value1, Integer value2) {
            return notBetween(place, value1, value2);
        }
    }
}