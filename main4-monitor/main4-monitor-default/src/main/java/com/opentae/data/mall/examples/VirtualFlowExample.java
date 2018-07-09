package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.VirtualFlow;

import java.util.*;

public class VirtualFlowExample extends SgExample<VirtualFlowExample.Criteria> {
    public static final Class<VirtualFlow> beanClass = VirtualFlow.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModif;
    public static EntityColumn virtualUploadNum;
    public static EntityColumn virtualClicks;
    public static EntityColumn clicksScale;
    public static EntityColumn goodsId;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModif = listMap.get("gmtModif");
        virtualUploadNum = listMap.get("virtualUploadNum");
        virtualClicks = listMap.get("virtualClicks");
        clicksScale = listMap.get("clicksScale");
        goodsId = listMap.get("goodsId");
        gmtCreate = listMap.get("gmtCreate");
        }

    public VirtualFlowExample() {
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

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andGmtModifIsNull() {
            return isNull(gmtModif);
        }

        public Criteria andGmtModifIsNotNull() {
            return isNotNull(gmtModif);
        }

        public Criteria andGmtModifEqualTo(Date value) {
            return equalTo(gmtModif, value);
        }

        public Criteria andGmtModifNotEqualTo(Date value) {
            return notEqualTo(gmtModif, value);
        }

        public Criteria andGmtModifGreaterThan(Date value) {
            return greaterThan(gmtModif, value);
        }

        public Criteria andGmtModifGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModif, value);
        }

        public Criteria andGmtModifLessThan(Date value) {
            return lessThan(gmtModif, value);
        }

        public Criteria andGmtModifLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModif, value);
        }

        public Criteria andGmtModifIn(List<Date> values) {
            return in(gmtModif, values);
        }

        public Criteria andGmtModifNotIn(List<Date> values) {
            return notIn(gmtModif, values);
        }

        public Criteria andGmtModifBetween(Date value1, Date value2) {
            return between(gmtModif, value1, value2);
        }

        public Criteria andGmtModifNotBetween(Date value1, Date value2) {
            return notBetween(gmtModif, value1, value2);
        }
        public Criteria andVirtualUploadNumIsNull() {
            return isNull(virtualUploadNum);
        }

        public Criteria andVirtualUploadNumIsNotNull() {
            return isNotNull(virtualUploadNum);
        }

        public Criteria andVirtualUploadNumEqualTo(Long value) {
            return equalTo(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumNotEqualTo(Long value) {
            return notEqualTo(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumGreaterThan(Long value) {
            return greaterThan(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumLessThan(Long value) {
            return lessThan(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(virtualUploadNum, value);
        }

        public Criteria andVirtualUploadNumIn(List<Long> values) {
            return in(virtualUploadNum, values);
        }

        public Criteria andVirtualUploadNumNotIn(List<Long> values) {
            return notIn(virtualUploadNum, values);
        }

        public Criteria andVirtualUploadNumBetween(Long value1, Long value2) {
            return between(virtualUploadNum, value1, value2);
        }

        public Criteria andVirtualUploadNumNotBetween(Long value1, Long value2) {
            return notBetween(virtualUploadNum, value1, value2);
        }
        public Criteria andVirtualClicksIsNull() {
            return isNull(virtualClicks);
        }

        public Criteria andVirtualClicksIsNotNull() {
            return isNotNull(virtualClicks);
        }

        public Criteria andVirtualClicksEqualTo(Long value) {
            return equalTo(virtualClicks, value);
        }

        public Criteria andVirtualClicksNotEqualTo(Long value) {
            return notEqualTo(virtualClicks, value);
        }

        public Criteria andVirtualClicksGreaterThan(Long value) {
            return greaterThan(virtualClicks, value);
        }

        public Criteria andVirtualClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(virtualClicks, value);
        }

        public Criteria andVirtualClicksLessThan(Long value) {
            return lessThan(virtualClicks, value);
        }

        public Criteria andVirtualClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(virtualClicks, value);
        }

        public Criteria andVirtualClicksIn(List<Long> values) {
            return in(virtualClicks, values);
        }

        public Criteria andVirtualClicksNotIn(List<Long> values) {
            return notIn(virtualClicks, values);
        }

        public Criteria andVirtualClicksBetween(Long value1, Long value2) {
            return between(virtualClicks, value1, value2);
        }

        public Criteria andVirtualClicksNotBetween(Long value1, Long value2) {
            return notBetween(virtualClicks, value1, value2);
        }
        public Criteria andClicksScaleIsNull() {
            return isNull(clicksScale);
        }

        public Criteria andClicksScaleIsNotNull() {
            return isNotNull(clicksScale);
        }

        public Criteria andClicksScaleEqualTo(Long value) {
            return equalTo(clicksScale, value);
        }

        public Criteria andClicksScaleNotEqualTo(Long value) {
            return notEqualTo(clicksScale, value);
        }

        public Criteria andClicksScaleGreaterThan(Long value) {
            return greaterThan(clicksScale, value);
        }

        public Criteria andClicksScaleGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicksScale, value);
        }

        public Criteria andClicksScaleLessThan(Long value) {
            return lessThan(clicksScale, value);
        }

        public Criteria andClicksScaleLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicksScale, value);
        }

        public Criteria andClicksScaleIn(List<Long> values) {
            return in(clicksScale, values);
        }

        public Criteria andClicksScaleNotIn(List<Long> values) {
            return notIn(clicksScale, values);
        }

        public Criteria andClicksScaleBetween(Long value1, Long value2) {
            return between(clicksScale, value1, value2);
        }

        public Criteria andClicksScaleNotBetween(Long value1, Long value2) {
            return notBetween(clicksScale, value1, value2);
        }
        public Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
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
    }
}