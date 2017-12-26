package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdItemProp;

import java.util.*;
public class JdItemPropExample extends SgExample<JdItemPropExample.Criteria> {
    public static final Class<JdItemProp> beanClass = JdItemProp.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn parentVid;
    public static EntityColumn isItemProp;
    public static EntityColumn isEnumProp;
    public static EntityColumn childTemplate;
    public static EntityColumn parentPid;
    public static EntityColumn isSaleProp;
    public static EntityColumn pid;
    public static EntityColumn jipid;
    public static EntityColumn isKeyProp;
    public static EntityColumn multi;
    public static EntityColumn isColorProp;
    public static EntityColumn isAllowAlias;
    public static EntityColumn sortOrder;
    public static EntityColumn name;
    public static EntityColumn isInputProp;
    public static EntityColumn must;
    public static EntityColumn isBrand;
    public static EntityColumn status;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        parentVid = listMap.get("parentVid");
        isItemProp = listMap.get("isItemProp");
        isEnumProp = listMap.get("isEnumProp");
        childTemplate = listMap.get("childTemplate");
        parentPid = listMap.get("parentPid");
        isSaleProp = listMap.get("isSaleProp");
        pid = listMap.get("pid");
        jipid = listMap.get("jipid");
        isKeyProp = listMap.get("isKeyProp");
        multi = listMap.get("multi");
        isColorProp = listMap.get("isColorProp");
        isAllowAlias = listMap.get("isAllowAlias");
        sortOrder = listMap.get("sortOrder");
        name = listMap.get("name");
        isInputProp = listMap.get("isInputProp");
        must = listMap.get("must");
        isBrand = listMap.get("isBrand");
        status = listMap.get("status");
        cid = listMap.get("cid");
        }

    public JdItemPropExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected JdItemPropExample.Criteria createCriteriaInternal() {
        return new JdItemPropExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdItemPropExample.Criteria andParentVidIsNull() {
            return isNull(parentVid);
        }

        public JdItemPropExample.Criteria andParentVidIsNotNull() {
            return isNotNull(parentVid);
        }

        public JdItemPropExample.Criteria andParentVidEqualTo(Long value) {
            return equalTo(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidNotEqualTo(Long value) {
            return notEqualTo(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidGreaterThan(Long value) {
            return greaterThan(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidLessThan(Long value) {
            return lessThan(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentVid, value);
        }

        public JdItemPropExample.Criteria andParentVidIn(List<Long> values) {
            return in(parentVid, values);
        }

        public JdItemPropExample.Criteria andParentVidNotIn(List<Long> values) {
            return notIn(parentVid, values);
        }

        public JdItemPropExample.Criteria andParentVidBetween(Long value1, Long value2) {
            return between(parentVid, value1, value2);
        }

        public JdItemPropExample.Criteria andParentVidNotBetween(Long value1, Long value2) {
            return notBetween(parentVid, value1, value2);
        }
        public JdItemPropExample.Criteria andIsItemPropIsNull() {
            return isNull(isItemProp);
        }

        public JdItemPropExample.Criteria andIsItemPropIsNotNull() {
            return isNotNull(isItemProp);
        }

        public JdItemPropExample.Criteria andIsItemPropEqualTo(Integer value) {
            return equalTo(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropNotEqualTo(Integer value) {
            return notEqualTo(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropGreaterThan(Integer value) {
            return greaterThan(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropLessThan(Integer value) {
            return lessThan(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isItemProp, value);
        }

        public JdItemPropExample.Criteria andIsItemPropIn(List<Integer> values) {
            return in(isItemProp, values);
        }

        public JdItemPropExample.Criteria andIsItemPropNotIn(List<Integer> values) {
            return notIn(isItemProp, values);
        }

        public JdItemPropExample.Criteria andIsItemPropBetween(Integer value1, Integer value2) {
            return between(isItemProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsItemPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isItemProp, value1, value2);
        }
        public JdItemPropExample.Criteria andIsEnumPropIsNull() {
            return isNull(isEnumProp);
        }

        public JdItemPropExample.Criteria andIsEnumPropIsNotNull() {
            return isNotNull(isEnumProp);
        }

        public JdItemPropExample.Criteria andIsEnumPropEqualTo(Integer value) {
            return equalTo(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropNotEqualTo(Integer value) {
            return notEqualTo(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropGreaterThan(Integer value) {
            return greaterThan(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropLessThan(Integer value) {
            return lessThan(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isEnumProp, value);
        }

        public JdItemPropExample.Criteria andIsEnumPropIn(List<Integer> values) {
            return in(isEnumProp, values);
        }

        public JdItemPropExample.Criteria andIsEnumPropNotIn(List<Integer> values) {
            return notIn(isEnumProp, values);
        }

        public JdItemPropExample.Criteria andIsEnumPropBetween(Integer value1, Integer value2) {
            return between(isEnumProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsEnumPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isEnumProp, value1, value2);
        }
        public JdItemPropExample.Criteria andChildTemplateIsNull() {
            return isNull(childTemplate);
        }

        public JdItemPropExample.Criteria andChildTemplateIsNotNull() {
            return isNotNull(childTemplate);
        }

        public JdItemPropExample.Criteria andChildTemplateEqualTo(String value) {
            return equalTo(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateNotEqualTo(String value) {
            return notEqualTo(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateGreaterThan(String value) {
            return greaterThan(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateLessThan(String value) {
            return lessThan(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateLike(String value) {
            return like(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateNotLike(String value) {
            return notLike(childTemplate, value);
        }

        public JdItemPropExample.Criteria andChildTemplateIn(List<String> values) {
            return in(childTemplate, values);
        }

        public JdItemPropExample.Criteria andChildTemplateNotIn(List<String> values) {
            return notIn(childTemplate, values);
        }

        public JdItemPropExample.Criteria andChildTemplateBetween(String value1, String value2) {
            return between(childTemplate, value1, value2);
        }

        public JdItemPropExample.Criteria andChildTemplateNotBetween(String value1, String value2) {
            return notBetween(childTemplate, value1, value2);
        }
        public JdItemPropExample.Criteria andParentPidIsNull() {
            return isNull(parentPid);
        }

        public JdItemPropExample.Criteria andParentPidIsNotNull() {
            return isNotNull(parentPid);
        }

        public JdItemPropExample.Criteria andParentPidEqualTo(Long value) {
            return equalTo(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidNotEqualTo(Long value) {
            return notEqualTo(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidGreaterThan(Long value) {
            return greaterThan(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidLessThan(Long value) {
            return lessThan(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentPid, value);
        }

        public JdItemPropExample.Criteria andParentPidIn(List<Long> values) {
            return in(parentPid, values);
        }

        public JdItemPropExample.Criteria andParentPidNotIn(List<Long> values) {
            return notIn(parentPid, values);
        }

        public JdItemPropExample.Criteria andParentPidBetween(Long value1, Long value2) {
            return between(parentPid, value1, value2);
        }

        public JdItemPropExample.Criteria andParentPidNotBetween(Long value1, Long value2) {
            return notBetween(parentPid, value1, value2);
        }
        public JdItemPropExample.Criteria andIsSalePropIsNull() {
            return isNull(isSaleProp);
        }

        public JdItemPropExample.Criteria andIsSalePropIsNotNull() {
            return isNotNull(isSaleProp);
        }

        public JdItemPropExample.Criteria andIsSalePropEqualTo(Integer value) {
            return equalTo(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropNotEqualTo(Integer value) {
            return notEqualTo(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropGreaterThan(Integer value) {
            return greaterThan(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropLessThan(Integer value) {
            return lessThan(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isSaleProp, value);
        }

        public JdItemPropExample.Criteria andIsSalePropIn(List<Integer> values) {
            return in(isSaleProp, values);
        }

        public JdItemPropExample.Criteria andIsSalePropNotIn(List<Integer> values) {
            return notIn(isSaleProp, values);
        }

        public JdItemPropExample.Criteria andIsSalePropBetween(Integer value1, Integer value2) {
            return between(isSaleProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsSalePropNotBetween(Integer value1, Integer value2) {
            return notBetween(isSaleProp, value1, value2);
        }
        public JdItemPropExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public JdItemPropExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public JdItemPropExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public JdItemPropExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public JdItemPropExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public JdItemPropExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public JdItemPropExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public JdItemPropExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public JdItemPropExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public JdItemPropExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public JdItemPropExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public JdItemPropExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public JdItemPropExample.Criteria andJipidIsNull() {
            return isNull(jipid);
        }

        public JdItemPropExample.Criteria andJipidIsNotNull() {
            return isNotNull(jipid);
        }

        public JdItemPropExample.Criteria andJipidEqualTo(Long value) {
            return equalTo(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidNotEqualTo(Long value) {
            return notEqualTo(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidGreaterThan(Long value) {
            return greaterThan(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidLessThan(Long value) {
            return lessThan(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jipid, value);
        }

        public JdItemPropExample.Criteria andJipidIn(List<Long> values) {
            return in(jipid, values);
        }

        public JdItemPropExample.Criteria andJipidNotIn(List<Long> values) {
            return notIn(jipid, values);
        }

        public JdItemPropExample.Criteria andJipidBetween(Long value1, Long value2) {
            return between(jipid, value1, value2);
        }

        public JdItemPropExample.Criteria andJipidNotBetween(Long value1, Long value2) {
            return notBetween(jipid, value1, value2);
        }
        public JdItemPropExample.Criteria andIsKeyPropIsNull() {
            return isNull(isKeyProp);
        }

        public JdItemPropExample.Criteria andIsKeyPropIsNotNull() {
            return isNotNull(isKeyProp);
        }

        public JdItemPropExample.Criteria andIsKeyPropEqualTo(Integer value) {
            return equalTo(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropNotEqualTo(Integer value) {
            return notEqualTo(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropGreaterThan(Integer value) {
            return greaterThan(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropLessThan(Integer value) {
            return lessThan(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isKeyProp, value);
        }

        public JdItemPropExample.Criteria andIsKeyPropIn(List<Integer> values) {
            return in(isKeyProp, values);
        }

        public JdItemPropExample.Criteria andIsKeyPropNotIn(List<Integer> values) {
            return notIn(isKeyProp, values);
        }

        public JdItemPropExample.Criteria andIsKeyPropBetween(Integer value1, Integer value2) {
            return between(isKeyProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsKeyPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isKeyProp, value1, value2);
        }
        public JdItemPropExample.Criteria andMultiIsNull() {
            return isNull(multi);
        }

        public JdItemPropExample.Criteria andMultiIsNotNull() {
            return isNotNull(multi);
        }

        public JdItemPropExample.Criteria andMultiEqualTo(Integer value) {
            return equalTo(multi, value);
        }

        public JdItemPropExample.Criteria andMultiNotEqualTo(Integer value) {
            return notEqualTo(multi, value);
        }

        public JdItemPropExample.Criteria andMultiGreaterThan(Integer value) {
            return greaterThan(multi, value);
        }

        public JdItemPropExample.Criteria andMultiGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(multi, value);
        }

        public JdItemPropExample.Criteria andMultiLessThan(Integer value) {
            return lessThan(multi, value);
        }

        public JdItemPropExample.Criteria andMultiLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(multi, value);
        }

        public JdItemPropExample.Criteria andMultiIn(List<Integer> values) {
            return in(multi, values);
        }

        public JdItemPropExample.Criteria andMultiNotIn(List<Integer> values) {
            return notIn(multi, values);
        }

        public JdItemPropExample.Criteria andMultiBetween(Integer value1, Integer value2) {
            return between(multi, value1, value2);
        }

        public JdItemPropExample.Criteria andMultiNotBetween(Integer value1, Integer value2) {
            return notBetween(multi, value1, value2);
        }
        public JdItemPropExample.Criteria andIsColorPropIsNull() {
            return isNull(isColorProp);
        }

        public JdItemPropExample.Criteria andIsColorPropIsNotNull() {
            return isNotNull(isColorProp);
        }

        public JdItemPropExample.Criteria andIsColorPropEqualTo(Integer value) {
            return equalTo(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropNotEqualTo(Integer value) {
            return notEqualTo(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropGreaterThan(Integer value) {
            return greaterThan(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropLessThan(Integer value) {
            return lessThan(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isColorProp, value);
        }

        public JdItemPropExample.Criteria andIsColorPropIn(List<Integer> values) {
            return in(isColorProp, values);
        }

        public JdItemPropExample.Criteria andIsColorPropNotIn(List<Integer> values) {
            return notIn(isColorProp, values);
        }

        public JdItemPropExample.Criteria andIsColorPropBetween(Integer value1, Integer value2) {
            return between(isColorProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsColorPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isColorProp, value1, value2);
        }
        public JdItemPropExample.Criteria andIsAllowAliasIsNull() {
            return isNull(isAllowAlias);
        }

        public JdItemPropExample.Criteria andIsAllowAliasIsNotNull() {
            return isNotNull(isAllowAlias);
        }

        public JdItemPropExample.Criteria andIsAllowAliasEqualTo(Integer value) {
            return equalTo(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasNotEqualTo(Integer value) {
            return notEqualTo(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasGreaterThan(Integer value) {
            return greaterThan(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasLessThan(Integer value) {
            return lessThan(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isAllowAlias, value);
        }

        public JdItemPropExample.Criteria andIsAllowAliasIn(List<Integer> values) {
            return in(isAllowAlias, values);
        }

        public JdItemPropExample.Criteria andIsAllowAliasNotIn(List<Integer> values) {
            return notIn(isAllowAlias, values);
        }

        public JdItemPropExample.Criteria andIsAllowAliasBetween(Integer value1, Integer value2) {
            return between(isAllowAlias, value1, value2);
        }

        public JdItemPropExample.Criteria andIsAllowAliasNotBetween(Integer value1, Integer value2) {
            return notBetween(isAllowAlias, value1, value2);
        }
        public JdItemPropExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public JdItemPropExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public JdItemPropExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public JdItemPropExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public JdItemPropExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public JdItemPropExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public JdItemPropExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public JdItemPropExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public JdItemPropExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public JdItemPropExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public JdItemPropExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public JdItemPropExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public JdItemPropExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public JdItemPropExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public JdItemPropExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public JdItemPropExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public JdItemPropExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public JdItemPropExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public JdItemPropExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public JdItemPropExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public JdItemPropExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public JdItemPropExample.Criteria andIsInputPropIsNull() {
            return isNull(isInputProp);
        }

        public JdItemPropExample.Criteria andIsInputPropIsNotNull() {
            return isNotNull(isInputProp);
        }

        public JdItemPropExample.Criteria andIsInputPropEqualTo(Integer value) {
            return equalTo(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropNotEqualTo(Integer value) {
            return notEqualTo(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropGreaterThan(Integer value) {
            return greaterThan(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropLessThan(Integer value) {
            return lessThan(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isInputProp, value);
        }

        public JdItemPropExample.Criteria andIsInputPropIn(List<Integer> values) {
            return in(isInputProp, values);
        }

        public JdItemPropExample.Criteria andIsInputPropNotIn(List<Integer> values) {
            return notIn(isInputProp, values);
        }

        public JdItemPropExample.Criteria andIsInputPropBetween(Integer value1, Integer value2) {
            return between(isInputProp, value1, value2);
        }

        public JdItemPropExample.Criteria andIsInputPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isInputProp, value1, value2);
        }
        public JdItemPropExample.Criteria andMustIsNull() {
            return isNull(must);
        }

        public JdItemPropExample.Criteria andMustIsNotNull() {
            return isNotNull(must);
        }

        public JdItemPropExample.Criteria andMustEqualTo(Integer value) {
            return equalTo(must, value);
        }

        public JdItemPropExample.Criteria andMustNotEqualTo(Integer value) {
            return notEqualTo(must, value);
        }

        public JdItemPropExample.Criteria andMustGreaterThan(Integer value) {
            return greaterThan(must, value);
        }

        public JdItemPropExample.Criteria andMustGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(must, value);
        }

        public JdItemPropExample.Criteria andMustLessThan(Integer value) {
            return lessThan(must, value);
        }

        public JdItemPropExample.Criteria andMustLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(must, value);
        }

        public JdItemPropExample.Criteria andMustIn(List<Integer> values) {
            return in(must, values);
        }

        public JdItemPropExample.Criteria andMustNotIn(List<Integer> values) {
            return notIn(must, values);
        }

        public JdItemPropExample.Criteria andMustBetween(Integer value1, Integer value2) {
            return between(must, value1, value2);
        }

        public JdItemPropExample.Criteria andMustNotBetween(Integer value1, Integer value2) {
            return notBetween(must, value1, value2);
        }
        public JdItemPropExample.Criteria andIsBrandIsNull() {
            return isNull(isBrand);
        }

        public JdItemPropExample.Criteria andIsBrandIsNotNull() {
            return isNotNull(isBrand);
        }

        public JdItemPropExample.Criteria andIsBrandEqualTo(Integer value) {
            return equalTo(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandNotEqualTo(Integer value) {
            return notEqualTo(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandGreaterThan(Integer value) {
            return greaterThan(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandLessThan(Integer value) {
            return lessThan(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isBrand, value);
        }

        public JdItemPropExample.Criteria andIsBrandIn(List<Integer> values) {
            return in(isBrand, values);
        }

        public JdItemPropExample.Criteria andIsBrandNotIn(List<Integer> values) {
            return notIn(isBrand, values);
        }

        public JdItemPropExample.Criteria andIsBrandBetween(Integer value1, Integer value2) {
            return between(isBrand, value1, value2);
        }

        public JdItemPropExample.Criteria andIsBrandNotBetween(Integer value1, Integer value2) {
            return notBetween(isBrand, value1, value2);
        }
        public JdItemPropExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public JdItemPropExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public JdItemPropExample.Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public JdItemPropExample.Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public JdItemPropExample.Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public JdItemPropExample.Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public JdItemPropExample.Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public JdItemPropExample.Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public JdItemPropExample.Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public JdItemPropExample.Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public JdItemPropExample.Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public JdItemPropExample.Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public JdItemPropExample.Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public JdItemPropExample.Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
        }
        public JdItemPropExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public JdItemPropExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public JdItemPropExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public JdItemPropExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public JdItemPropExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public JdItemPropExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public JdItemPropExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public JdItemPropExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public JdItemPropExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public JdItemPropExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public JdItemPropExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public JdItemPropExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}