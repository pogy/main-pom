package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoItemProp;

import java.util.*;
public class TaobaoItemPropExample extends SgExample<TaobaoItemPropExample.Criteria> {
    public static final Class<TaobaoItemProp> beanClass = TaobaoItemProp.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isItemProp;
    public static EntityColumn isEnumProp;
    public static EntityColumn childTemplate;
    public static EntityColumn isSaleProp;
    public static EntityColumn pid;
    public static EntityColumn isKeyProp;
    public static EntityColumn multi;
    public static EntityColumn isColorProp;
    public static EntityColumn isAllowAlias;
    public static EntityColumn parentVid;
    public static EntityColumn tipid;
    public static EntityColumn parentPid;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn name;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn isInputProp;
    public static EntityColumn must;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn status;
    public static EntityColumn cid;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isItemProp = listMap.get("isItemProp");
        isEnumProp = listMap.get("isEnumProp");
        childTemplate = listMap.get("childTemplate");
        isSaleProp = listMap.get("isSaleProp");
        pid = listMap.get("pid");
        isKeyProp = listMap.get("isKeyProp");
        multi = listMap.get("multi");
        isColorProp = listMap.get("isColorProp");
        isAllowAlias = listMap.get("isAllowAlias");
        parentVid = listMap.get("parentVid");
        tipid = listMap.get("tipid");
        parentPid = listMap.get("parentPid");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        name = listMap.get("name");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        isInputProp = listMap.get("isInputProp");
        must = listMap.get("must");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        status = listMap.get("status");
        cid = listMap.get("cid");
        remark2 = listMap.get("remark2");
        }

    public TaobaoItemPropExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TaobaoItemPropExample.Criteria createCriteriaInternal() {
        return new TaobaoItemPropExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropIsNull() {
            return isNull(isItemProp);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropIsNotNull() {
            return isNotNull(isItemProp);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropEqualTo(Integer value) {
            return equalTo(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropNotEqualTo(Integer value) {
            return notEqualTo(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropGreaterThan(Integer value) {
            return greaterThan(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropLessThan(Integer value) {
            return lessThan(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isItemProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropIn(List<Integer> values) {
            return in(isItemProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropNotIn(List<Integer> values) {
            return notIn(isItemProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropBetween(Integer value1, Integer value2) {
            return between(isItemProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsItemPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isItemProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsEnumPropIsNull() {
            return isNull(isEnumProp);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropIsNotNull() {
            return isNotNull(isEnumProp);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropEqualTo(Integer value) {
            return equalTo(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropNotEqualTo(Integer value) {
            return notEqualTo(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropGreaterThan(Integer value) {
            return greaterThan(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropLessThan(Integer value) {
            return lessThan(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isEnumProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropIn(List<Integer> values) {
            return in(isEnumProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropNotIn(List<Integer> values) {
            return notIn(isEnumProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropBetween(Integer value1, Integer value2) {
            return between(isEnumProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsEnumPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isEnumProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andChildTemplateIsNull() {
            return isNull(childTemplate);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateIsNotNull() {
            return isNotNull(childTemplate);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateEqualTo(String value) {
            return equalTo(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateNotEqualTo(String value) {
            return notEqualTo(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateGreaterThan(String value) {
            return greaterThan(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateLessThan(String value) {
            return lessThan(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateLike(String value) {
            return like(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateNotLike(String value) {
            return notLike(childTemplate, value);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateIn(List<String> values) {
            return in(childTemplate, values);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateNotIn(List<String> values) {
            return notIn(childTemplate, values);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateBetween(String value1, String value2) {
            return between(childTemplate, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andChildTemplateNotBetween(String value1, String value2) {
            return notBetween(childTemplate, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsSalePropIsNull() {
            return isNull(isSaleProp);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropIsNotNull() {
            return isNotNull(isSaleProp);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropEqualTo(Integer value) {
            return equalTo(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropNotEqualTo(Integer value) {
            return notEqualTo(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropGreaterThan(Integer value) {
            return greaterThan(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropLessThan(Integer value) {
            return lessThan(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isSaleProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropIn(List<Integer> values) {
            return in(isSaleProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropNotIn(List<Integer> values) {
            return notIn(isSaleProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropBetween(Integer value1, Integer value2) {
            return between(isSaleProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsSalePropNotBetween(Integer value1, Integer value2) {
            return notBetween(isSaleProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public TaobaoItemPropExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public TaobaoItemPropExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public TaobaoItemPropExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public TaobaoItemPropExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public TaobaoItemPropExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsKeyPropIsNull() {
            return isNull(isKeyProp);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropIsNotNull() {
            return isNotNull(isKeyProp);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropEqualTo(Integer value) {
            return equalTo(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropNotEqualTo(Integer value) {
            return notEqualTo(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropGreaterThan(Integer value) {
            return greaterThan(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropLessThan(Integer value) {
            return lessThan(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isKeyProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropIn(List<Integer> values) {
            return in(isKeyProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropNotIn(List<Integer> values) {
            return notIn(isKeyProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropBetween(Integer value1, Integer value2) {
            return between(isKeyProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsKeyPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isKeyProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andMultiIsNull() {
            return isNull(multi);
        }

        public TaobaoItemPropExample.Criteria andMultiIsNotNull() {
            return isNotNull(multi);
        }

        public TaobaoItemPropExample.Criteria andMultiEqualTo(Integer value) {
            return equalTo(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiNotEqualTo(Integer value) {
            return notEqualTo(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiGreaterThan(Integer value) {
            return greaterThan(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiLessThan(Integer value) {
            return lessThan(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(multi, value);
        }

        public TaobaoItemPropExample.Criteria andMultiIn(List<Integer> values) {
            return in(multi, values);
        }

        public TaobaoItemPropExample.Criteria andMultiNotIn(List<Integer> values) {
            return notIn(multi, values);
        }

        public TaobaoItemPropExample.Criteria andMultiBetween(Integer value1, Integer value2) {
            return between(multi, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andMultiNotBetween(Integer value1, Integer value2) {
            return notBetween(multi, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsColorPropIsNull() {
            return isNull(isColorProp);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropIsNotNull() {
            return isNotNull(isColorProp);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropEqualTo(Integer value) {
            return equalTo(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropNotEqualTo(Integer value) {
            return notEqualTo(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropGreaterThan(Integer value) {
            return greaterThan(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropLessThan(Integer value) {
            return lessThan(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isColorProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropIn(List<Integer> values) {
            return in(isColorProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropNotIn(List<Integer> values) {
            return notIn(isColorProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropBetween(Integer value1, Integer value2) {
            return between(isColorProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsColorPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isColorProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsAllowAliasIsNull() {
            return isNull(isAllowAlias);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasIsNotNull() {
            return isNotNull(isAllowAlias);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasEqualTo(Integer value) {
            return equalTo(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasNotEqualTo(Integer value) {
            return notEqualTo(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasGreaterThan(Integer value) {
            return greaterThan(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasLessThan(Integer value) {
            return lessThan(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isAllowAlias, value);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasIn(List<Integer> values) {
            return in(isAllowAlias, values);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasNotIn(List<Integer> values) {
            return notIn(isAllowAlias, values);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasBetween(Integer value1, Integer value2) {
            return between(isAllowAlias, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsAllowAliasNotBetween(Integer value1, Integer value2) {
            return notBetween(isAllowAlias, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andParentVidIsNull() {
            return isNull(parentVid);
        }

        public TaobaoItemPropExample.Criteria andParentVidIsNotNull() {
            return isNotNull(parentVid);
        }

        public TaobaoItemPropExample.Criteria andParentVidEqualTo(Long value) {
            return equalTo(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidNotEqualTo(Long value) {
            return notEqualTo(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidGreaterThan(Long value) {
            return greaterThan(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidLessThan(Long value) {
            return lessThan(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentVid, value);
        }

        public TaobaoItemPropExample.Criteria andParentVidIn(List<Long> values) {
            return in(parentVid, values);
        }

        public TaobaoItemPropExample.Criteria andParentVidNotIn(List<Long> values) {
            return notIn(parentVid, values);
        }

        public TaobaoItemPropExample.Criteria andParentVidBetween(Long value1, Long value2) {
            return between(parentVid, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andParentVidNotBetween(Long value1, Long value2) {
            return notBetween(parentVid, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andTipidIsNull() {
            return isNull(tipid);
        }

        public TaobaoItemPropExample.Criteria andTipidIsNotNull() {
            return isNotNull(tipid);
        }

        public TaobaoItemPropExample.Criteria andTipidEqualTo(Long value) {
            return equalTo(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidNotEqualTo(Long value) {
            return notEqualTo(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidGreaterThan(Long value) {
            return greaterThan(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidLessThan(Long value) {
            return lessThan(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tipid, value);
        }

        public TaobaoItemPropExample.Criteria andTipidIn(List<Long> values) {
            return in(tipid, values);
        }

        public TaobaoItemPropExample.Criteria andTipidNotIn(List<Long> values) {
            return notIn(tipid, values);
        }

        public TaobaoItemPropExample.Criteria andTipidBetween(Long value1, Long value2) {
            return between(tipid, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andTipidNotBetween(Long value1, Long value2) {
            return notBetween(tipid, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andParentPidIsNull() {
            return isNull(parentPid);
        }

        public TaobaoItemPropExample.Criteria andParentPidIsNotNull() {
            return isNotNull(parentPid);
        }

        public TaobaoItemPropExample.Criteria andParentPidEqualTo(Long value) {
            return equalTo(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidNotEqualTo(Long value) {
            return notEqualTo(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidGreaterThan(Long value) {
            return greaterThan(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidLessThan(Long value) {
            return lessThan(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentPid, value);
        }

        public TaobaoItemPropExample.Criteria andParentPidIn(List<Long> values) {
            return in(parentPid, values);
        }

        public TaobaoItemPropExample.Criteria andParentPidNotIn(List<Long> values) {
            return notIn(parentPid, values);
        }

        public TaobaoItemPropExample.Criteria andParentPidBetween(Long value1, Long value2) {
            return between(parentPid, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andParentPidNotBetween(Long value1, Long value2) {
            return notBetween(parentPid, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public TaobaoItemPropExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public TaobaoItemPropExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public TaobaoItemPropExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public TaobaoItemPropExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public TaobaoItemPropExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public TaobaoItemPropExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public TaobaoItemPropExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public TaobaoItemPropExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public TaobaoItemPropExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public TaobaoItemPropExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public TaobaoItemPropExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public TaobaoItemPropExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public TaobaoItemPropExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public TaobaoItemPropExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public TaobaoItemPropExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public TaobaoItemPropExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public TaobaoItemPropExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public TaobaoItemPropExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public TaobaoItemPropExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public TaobaoItemPropExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public TaobaoItemPropExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public TaobaoItemPropExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public TaobaoItemPropExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public TaobaoItemPropExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public TaobaoItemPropExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoItemPropExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoItemPropExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoItemPropExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public TaobaoItemPropExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public TaobaoItemPropExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoItemPropExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoItemPropExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoItemPropExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public TaobaoItemPropExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public TaobaoItemPropExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andIsInputPropIsNull() {
            return isNull(isInputProp);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropIsNotNull() {
            return isNotNull(isInputProp);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropEqualTo(Integer value) {
            return equalTo(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropNotEqualTo(Integer value) {
            return notEqualTo(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropGreaterThan(Integer value) {
            return greaterThan(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropLessThan(Integer value) {
            return lessThan(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isInputProp, value);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropIn(List<Integer> values) {
            return in(isInputProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropNotIn(List<Integer> values) {
            return notIn(isInputProp, values);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropBetween(Integer value1, Integer value2) {
            return between(isInputProp, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andIsInputPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isInputProp, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andMustIsNull() {
            return isNull(must);
        }

        public TaobaoItemPropExample.Criteria andMustIsNotNull() {
            return isNotNull(must);
        }

        public TaobaoItemPropExample.Criteria andMustEqualTo(Integer value) {
            return equalTo(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustNotEqualTo(Integer value) {
            return notEqualTo(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustGreaterThan(Integer value) {
            return greaterThan(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustLessThan(Integer value) {
            return lessThan(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(must, value);
        }

        public TaobaoItemPropExample.Criteria andMustIn(List<Integer> values) {
            return in(must, values);
        }

        public TaobaoItemPropExample.Criteria andMustNotIn(List<Integer> values) {
            return notIn(must, values);
        }

        public TaobaoItemPropExample.Criteria andMustBetween(Integer value1, Integer value2) {
            return between(must, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andMustNotBetween(Integer value1, Integer value2) {
            return notBetween(must, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public TaobaoItemPropExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public TaobaoItemPropExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public TaobaoItemPropExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public TaobaoItemPropExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public TaobaoItemPropExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public TaobaoItemPropExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public TaobaoItemPropExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public TaobaoItemPropExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public TaobaoItemPropExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public TaobaoItemPropExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoItemPropExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoItemPropExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoItemPropExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TaobaoItemPropExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TaobaoItemPropExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoItemPropExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoItemPropExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoItemPropExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public TaobaoItemPropExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public TaobaoItemPropExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public TaobaoItemPropExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public TaobaoItemPropExample.Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public TaobaoItemPropExample.Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public TaobaoItemPropExample.Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public TaobaoItemPropExample.Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public TaobaoItemPropExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public TaobaoItemPropExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public TaobaoItemPropExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public TaobaoItemPropExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public TaobaoItemPropExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public TaobaoItemPropExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoItemPropExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoItemPropExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TaobaoItemPropExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TaobaoItemPropExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TaobaoItemPropExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoItemPropExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}