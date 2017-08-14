package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsExtends;

import java.util.*;
public class ShiguGoodsExtendsExample extends SgExample<ShiguGoodsExtendsExample.Criteria> {
    public static final Class<ShiguGoodsExtends> beanClass = ShiguGoodsExtends.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn approveStatus;
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn inputStr;
    public static EntityColumn is3d;
    public static EntityColumn templateId;
    public static EntityColumn isTiming;
    public static EntityColumn inputPids;
    public static EntityColumn hasWarranty;
    public static EntityColumn remark19;
    public static EntityColumn features;
    public static EntityColumn remark20;
    public static EntityColumn itemSize;
    public static EntityColumn barcode;
    public static EntityColumn goodsDesc;
    public static EntityColumn outerShopAuctionTemplateId;
    public static EntityColumn images;
    public static EntityColumn postageId;
    public static EntityColumn productId;
    public static EntityColumn customMadeTypeId;
    public static EntityColumn wapDetailUrl;
    public static EntityColumn props;
    public static EntityColumn auctionPoint;
    public static EntityColumn remark9;
    public static EntityColumn codPostageId;
    public static EntityColumn remark8;
    public static EntityColumn violation;
    public static EntityColumn sellPromise;
    public static EntityColumn subtitle;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn propsName;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn isVirtual;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn innerShopAuctionTemplateId;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    public static EntityColumn wapDesc;
    public static EntityColumn goodsId;
    public static EntityColumn sellerCids;
    public static EntityColumn hasInvoice;
    public static EntityColumn increment;
    public static EntityColumn afterSaleId;
    public static EntityColumn isEx;
    public static EntityColumn secondKill;
    public static EntityColumn loadDate;
    public static EntityColumn isTaobao;
    public static EntityColumn nolose;
    public static EntityColumn wirelessDesc;
    public static EntityColumn subStock;
    public static EntityColumn oneStation;
    public static EntityColumn itemWeight;
    public static EntityColumn propertyAlias;
    public static EntityColumn updateTime;
    public static EntityColumn withHoldQuantity;
    public static EntityColumn lastModifyTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        approveStatus = listMap.get("approveStatus");
        remark18 = listMap.get("remark18");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        inputStr = listMap.get("inputStr");
        is3d = listMap.get("is3d");
        templateId = listMap.get("templateId");
        isTiming = listMap.get("isTiming");
        inputPids = listMap.get("inputPids");
        hasWarranty = listMap.get("hasWarranty");
        remark19 = listMap.get("remark19");
        features = listMap.get("features");
        remark20 = listMap.get("remark20");
        itemSize = listMap.get("itemSize");
        barcode = listMap.get("barcode");
        goodsDesc = listMap.get("goodsDesc");
        outerShopAuctionTemplateId = listMap.get("outerShopAuctionTemplateId");
        images = listMap.get("images");
        postageId = listMap.get("postageId");
        productId = listMap.get("productId");
        customMadeTypeId = listMap.get("customMadeTypeId");
        wapDetailUrl = listMap.get("wapDetailUrl");
        props = listMap.get("props");
        auctionPoint = listMap.get("auctionPoint");
        remark9 = listMap.get("remark9");
        codPostageId = listMap.get("codPostageId");
        remark8 = listMap.get("remark8");
        violation = listMap.get("violation");
        sellPromise = listMap.get("sellPromise");
        subtitle = listMap.get("subtitle");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        propsName = listMap.get("propsName");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        isVirtual = listMap.get("isVirtual");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        innerShopAuctionTemplateId = listMap.get("innerShopAuctionTemplateId");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        wapDesc = listMap.get("wapDesc");
        goodsId = listMap.get("goodsId");
        sellerCids = listMap.get("sellerCids");
        hasInvoice = listMap.get("hasInvoice");
        increment = listMap.get("increment");
        afterSaleId = listMap.get("afterSaleId");
        isEx = listMap.get("isEx");
        secondKill = listMap.get("secondKill");
        loadDate = listMap.get("loadDate");
        isTaobao = listMap.get("isTaobao");
        nolose = listMap.get("nolose");
        wirelessDesc = listMap.get("wirelessDesc");
        subStock = listMap.get("subStock");
        oneStation = listMap.get("oneStation");
        itemWeight = listMap.get("itemWeight");
        propertyAlias = listMap.get("propertyAlias");
        updateTime = listMap.get("updateTime");
        withHoldQuantity = listMap.get("withHoldQuantity");
        lastModifyTime = listMap.get("lastModifyTime");
        }

    public ShiguGoodsExtendsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsExtendsExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsExtendsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusIsNull() {
            return isNull(approveStatus);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusIsNotNull() {
            return isNotNull(approveStatus);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusEqualTo(String value) {
            return equalTo(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotEqualTo(String value) {
            return notEqualTo(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusGreaterThan(String value) {
            return greaterThan(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLessThan(String value) {
            return lessThan(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLike(String value) {
            return like(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotLike(String value) {
            return notLike(approveStatus, value);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusIn(List<String> values) {
            return in(approveStatus, values);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotIn(List<String> values) {
            return notIn(approveStatus, values);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusBetween(String value1, String value2) {
            return between(approveStatus, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotBetween(String value1, String value2) {
            return notBetween(approveStatus, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andInputStrIsNull() {
            return isNull(inputStr);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrIsNotNull() {
            return isNotNull(inputStr);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrEqualTo(String value) {
            return equalTo(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotEqualTo(String value) {
            return notEqualTo(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrGreaterThan(String value) {
            return greaterThan(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLessThan(String value) {
            return lessThan(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLike(String value) {
            return like(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotLike(String value) {
            return notLike(inputStr, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrIn(List<String> values) {
            return in(inputStr, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotIn(List<String> values) {
            return notIn(inputStr, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrBetween(String value1, String value2) {
            return between(inputStr, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotBetween(String value1, String value2) {
            return notBetween(inputStr, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIs3dIsNull() {
            return isNull(is3d);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dIsNotNull() {
            return isNotNull(is3d);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dEqualTo(String value) {
            return equalTo(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotEqualTo(String value) {
            return notEqualTo(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dGreaterThan(String value) {
            return greaterThan(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLessThan(String value) {
            return lessThan(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLike(String value) {
            return like(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotLike(String value) {
            return notLike(is3d, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dIn(List<String> values) {
            return in(is3d, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotIn(List<String> values) {
            return notIn(is3d, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dBetween(String value1, String value2) {
            return between(is3d, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotBetween(String value1, String value2) {
            return notBetween(is3d, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdEqualTo(String value) {
            return equalTo(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotEqualTo(String value) {
            return notEqualTo(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdGreaterThan(String value) {
            return greaterThan(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLessThan(String value) {
            return lessThan(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLike(String value) {
            return like(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotLike(String value) {
            return notLike(templateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdIn(List<String> values) {
            return in(templateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotIn(List<String> values) {
            return notIn(templateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdBetween(String value1, String value2) {
            return between(templateId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotBetween(String value1, String value2) {
            return notBetween(templateId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIsTimingIsNull() {
            return isNull(isTiming);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingIsNotNull() {
            return isNotNull(isTiming);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingEqualTo(String value) {
            return equalTo(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotEqualTo(String value) {
            return notEqualTo(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingGreaterThan(String value) {
            return greaterThan(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLessThan(String value) {
            return lessThan(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLike(String value) {
            return like(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotLike(String value) {
            return notLike(isTiming, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingIn(List<String> values) {
            return in(isTiming, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotIn(List<String> values) {
            return notIn(isTiming, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingBetween(String value1, String value2) {
            return between(isTiming, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotBetween(String value1, String value2) {
            return notBetween(isTiming, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andInputPidsIsNull() {
            return isNull(inputPids);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsIsNotNull() {
            return isNotNull(inputPids);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsEqualTo(String value) {
            return equalTo(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotEqualTo(String value) {
            return notEqualTo(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsGreaterThan(String value) {
            return greaterThan(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLessThan(String value) {
            return lessThan(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLike(String value) {
            return like(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotLike(String value) {
            return notLike(inputPids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsIn(List<String> values) {
            return in(inputPids, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotIn(List<String> values) {
            return notIn(inputPids, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsBetween(String value1, String value2) {
            return between(inputPids, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotBetween(String value1, String value2) {
            return notBetween(inputPids, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIsNull() {
            return isNull(hasWarranty);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIsNotNull() {
            return isNotNull(hasWarranty);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyEqualTo(String value) {
            return equalTo(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotEqualTo(String value) {
            return notEqualTo(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyGreaterThan(String value) {
            return greaterThan(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLessThan(String value) {
            return lessThan(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLike(String value) {
            return like(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotLike(String value) {
            return notLike(hasWarranty, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIn(List<String> values) {
            return in(hasWarranty, values);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotIn(List<String> values) {
            return notIn(hasWarranty, values);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyBetween(String value1, String value2) {
            return between(hasWarranty, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotBetween(String value1, String value2) {
            return notBetween(hasWarranty, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andFeaturesIsNull() {
            return isNull(features);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesIsNotNull() {
            return isNotNull(features);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesEqualTo(String value) {
            return equalTo(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotEqualTo(String value) {
            return notEqualTo(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesGreaterThan(String value) {
            return greaterThan(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLessThan(String value) {
            return lessThan(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLike(String value) {
            return like(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotLike(String value) {
            return notLike(features, value);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesIn(List<String> values) {
            return in(features, values);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotIn(List<String> values) {
            return notIn(features, values);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesBetween(String value1, String value2) {
            return between(features, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotBetween(String value1, String value2) {
            return notBetween(features, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andItemSizeIsNull() {
            return isNull(itemSize);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeIsNotNull() {
            return isNotNull(itemSize);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeEqualTo(String value) {
            return equalTo(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotEqualTo(String value) {
            return notEqualTo(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeGreaterThan(String value) {
            return greaterThan(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLessThan(String value) {
            return lessThan(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLike(String value) {
            return like(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotLike(String value) {
            return notLike(itemSize, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeIn(List<String> values) {
            return in(itemSize, values);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotIn(List<String> values) {
            return notIn(itemSize, values);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeBetween(String value1, String value2) {
            return between(itemSize, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotBetween(String value1, String value2) {
            return notBetween(itemSize, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andBarcodeIsNull() {
            return isNull(barcode);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeIsNotNull() {
            return isNotNull(barcode);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeEqualTo(String value) {
            return equalTo(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotEqualTo(String value) {
            return notEqualTo(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeGreaterThan(String value) {
            return greaterThan(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLessThan(String value) {
            return lessThan(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLike(String value) {
            return like(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotLike(String value) {
            return notLike(barcode, value);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeIn(List<String> values) {
            return in(barcode, values);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotIn(List<String> values) {
            return notIn(barcode, values);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeBetween(String value1, String value2) {
            return between(barcode, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotBetween(String value1, String value2) {
            return notBetween(barcode, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andGoodsDescIsNull() {
            return isNull(goodsDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescIsNotNull() {
            return isNotNull(goodsDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescEqualTo(String value) {
            return equalTo(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotEqualTo(String value) {
            return notEqualTo(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescGreaterThan(String value) {
            return greaterThan(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLessThan(String value) {
            return lessThan(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLike(String value) {
            return like(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotLike(String value) {
            return notLike(goodsDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescIn(List<String> values) {
            return in(goodsDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotIn(List<String> values) {
            return notIn(goodsDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescBetween(String value1, String value2) {
            return between(goodsDesc, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotBetween(String value1, String value2) {
            return notBetween(goodsDesc, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIsNull() {
            return isNull(outerShopAuctionTemplateId);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIsNotNull() {
            return isNotNull(outerShopAuctionTemplateId);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdEqualTo(Long value) {
            return equalTo(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotEqualTo(Long value) {
            return notEqualTo(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdGreaterThan(Long value) {
            return greaterThan(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdLessThan(Long value) {
            return lessThan(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(outerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIn(List<Long> values) {
            return in(outerShopAuctionTemplateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotIn(List<Long> values) {
            return notIn(outerShopAuctionTemplateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdBetween(Long value1, Long value2) {
            return between(outerShopAuctionTemplateId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(outerShopAuctionTemplateId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andImagesIsNull() {
            return isNull(images);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesIsNotNull() {
            return isNotNull(images);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesEqualTo(String value) {
            return equalTo(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotEqualTo(String value) {
            return notEqualTo(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesGreaterThan(String value) {
            return greaterThan(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLessThan(String value) {
            return lessThan(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLike(String value) {
            return like(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotLike(String value) {
            return notLike(images, value);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesIn(List<String> values) {
            return in(images, values);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotIn(List<String> values) {
            return notIn(images, values);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesBetween(String value1, String value2) {
            return between(images, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotBetween(String value1, String value2) {
            return notBetween(images, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andPostageIdIsNull() {
            return isNull(postageId);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdIsNotNull() {
            return isNotNull(postageId);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdEqualTo(Long value) {
            return equalTo(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotEqualTo(Long value) {
            return notEqualTo(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdGreaterThan(Long value) {
            return greaterThan(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdLessThan(Long value) {
            return lessThan(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdIn(List<Long> values) {
            return in(postageId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotIn(List<Long> values) {
            return notIn(postageId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdBetween(Long value1, Long value2) {
            return between(postageId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotBetween(Long value1, Long value2) {
            return notBetween(postageId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andProductIdIsNull() {
            return isNull(productId);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdIsNotNull() {
            return isNotNull(productId);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdEqualTo(Long value) {
            return equalTo(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotEqualTo(Long value) {
            return notEqualTo(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdGreaterThan(Long value) {
            return greaterThan(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdLessThan(Long value) {
            return lessThan(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(productId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdIn(List<Long> values) {
            return in(productId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotIn(List<Long> values) {
            return notIn(productId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdBetween(Long value1, Long value2) {
            return between(productId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotBetween(Long value1, Long value2) {
            return notBetween(productId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIsNull() {
            return isNull(customMadeTypeId);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIsNotNull() {
            return isNotNull(customMadeTypeId);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdEqualTo(String value) {
            return equalTo(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotEqualTo(String value) {
            return notEqualTo(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdGreaterThan(String value) {
            return greaterThan(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLessThan(String value) {
            return lessThan(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLike(String value) {
            return like(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotLike(String value) {
            return notLike(customMadeTypeId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIn(List<String> values) {
            return in(customMadeTypeId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotIn(List<String> values) {
            return notIn(customMadeTypeId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdBetween(String value1, String value2) {
            return between(customMadeTypeId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotBetween(String value1, String value2) {
            return notBetween(customMadeTypeId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIsNull() {
            return isNull(wapDetailUrl);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIsNotNull() {
            return isNotNull(wapDetailUrl);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlEqualTo(String value) {
            return equalTo(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotEqualTo(String value) {
            return notEqualTo(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlGreaterThan(String value) {
            return greaterThan(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLessThan(String value) {
            return lessThan(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLike(String value) {
            return like(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotLike(String value) {
            return notLike(wapDetailUrl, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIn(List<String> values) {
            return in(wapDetailUrl, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotIn(List<String> values) {
            return notIn(wapDetailUrl, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlBetween(String value1, String value2) {
            return between(wapDetailUrl, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotBetween(String value1, String value2) {
            return notBetween(wapDetailUrl, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andPropsIsNull() {
            return isNull(props);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsIsNotNull() {
            return isNotNull(props);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsEqualTo(String value) {
            return equalTo(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotEqualTo(String value) {
            return notEqualTo(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsGreaterThan(String value) {
            return greaterThan(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLessThan(String value) {
            return lessThan(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLike(String value) {
            return like(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotLike(String value) {
            return notLike(props, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsIn(List<String> values) {
            return in(props, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotIn(List<String> values) {
            return notIn(props, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsBetween(String value1, String value2) {
            return between(props, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotBetween(String value1, String value2) {
            return notBetween(props, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andAuctionPointIsNull() {
            return isNull(auctionPoint);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointIsNotNull() {
            return isNotNull(auctionPoint);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointEqualTo(String value) {
            return equalTo(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotEqualTo(String value) {
            return notEqualTo(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointGreaterThan(String value) {
            return greaterThan(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLessThan(String value) {
            return lessThan(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLike(String value) {
            return like(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotLike(String value) {
            return notLike(auctionPoint, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointIn(List<String> values) {
            return in(auctionPoint, values);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotIn(List<String> values) {
            return notIn(auctionPoint, values);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointBetween(String value1, String value2) {
            return between(auctionPoint, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotBetween(String value1, String value2) {
            return notBetween(auctionPoint, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIsNull() {
            return isNull(codPostageId);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIsNotNull() {
            return isNotNull(codPostageId);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdEqualTo(Long value) {
            return equalTo(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotEqualTo(Long value) {
            return notEqualTo(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdGreaterThan(Long value) {
            return greaterThan(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdLessThan(Long value) {
            return lessThan(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(codPostageId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIn(List<Long> values) {
            return in(codPostageId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotIn(List<Long> values) {
            return notIn(codPostageId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdBetween(Long value1, Long value2) {
            return between(codPostageId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotBetween(Long value1, Long value2) {
            return notBetween(codPostageId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andViolationIsNull() {
            return isNull(violation);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationIsNotNull() {
            return isNotNull(violation);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationEqualTo(String value) {
            return equalTo(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotEqualTo(String value) {
            return notEqualTo(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationGreaterThan(String value) {
            return greaterThan(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLessThan(String value) {
            return lessThan(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLike(String value) {
            return like(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotLike(String value) {
            return notLike(violation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationIn(List<String> values) {
            return in(violation, values);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotIn(List<String> values) {
            return notIn(violation, values);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationBetween(String value1, String value2) {
            return between(violation, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotBetween(String value1, String value2) {
            return notBetween(violation, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andSellPromiseIsNull() {
            return isNull(sellPromise);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseIsNotNull() {
            return isNotNull(sellPromise);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseEqualTo(String value) {
            return equalTo(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotEqualTo(String value) {
            return notEqualTo(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseGreaterThan(String value) {
            return greaterThan(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLessThan(String value) {
            return lessThan(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLike(String value) {
            return like(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotLike(String value) {
            return notLike(sellPromise, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseIn(List<String> values) {
            return in(sellPromise, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotIn(List<String> values) {
            return notIn(sellPromise, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseBetween(String value1, String value2) {
            return between(sellPromise, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotBetween(String value1, String value2) {
            return notBetween(sellPromise, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andSubtitleIsNull() {
            return isNull(subtitle);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleIsNotNull() {
            return isNotNull(subtitle);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleEqualTo(String value) {
            return equalTo(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotEqualTo(String value) {
            return notEqualTo(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleGreaterThan(String value) {
            return greaterThan(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLessThan(String value) {
            return lessThan(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLike(String value) {
            return like(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotLike(String value) {
            return notLike(subtitle, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleIn(List<String> values) {
            return in(subtitle, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotIn(List<String> values) {
            return notIn(subtitle, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleBetween(String value1, String value2) {
            return between(subtitle, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotBetween(String value1, String value2) {
            return notBetween(subtitle, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andPropsNameIsNull() {
            return isNull(propsName);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameIsNotNull() {
            return isNotNull(propsName);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameEqualTo(String value) {
            return equalTo(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotEqualTo(String value) {
            return notEqualTo(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameGreaterThan(String value) {
            return greaterThan(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLessThan(String value) {
            return lessThan(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLike(String value) {
            return like(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotLike(String value) {
            return notLike(propsName, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameIn(List<String> values) {
            return in(propsName, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotIn(List<String> values) {
            return notIn(propsName, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameBetween(String value1, String value2) {
            return between(propsName, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotBetween(String value1, String value2) {
            return notBetween(propsName, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIsVirtualIsNull() {
            return isNull(isVirtual);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualIsNotNull() {
            return isNotNull(isVirtual);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualEqualTo(String value) {
            return equalTo(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotEqualTo(String value) {
            return notEqualTo(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualGreaterThan(String value) {
            return greaterThan(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLessThan(String value) {
            return lessThan(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLike(String value) {
            return like(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotLike(String value) {
            return notLike(isVirtual, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualIn(List<String> values) {
            return in(isVirtual, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotIn(List<String> values) {
            return notIn(isVirtual, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualBetween(String value1, String value2) {
            return between(isVirtual, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotBetween(String value1, String value2) {
            return notBetween(isVirtual, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIsNull() {
            return isNull(innerShopAuctionTemplateId);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIsNotNull() {
            return isNotNull(innerShopAuctionTemplateId);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdEqualTo(Long value) {
            return equalTo(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotEqualTo(Long value) {
            return notEqualTo(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdGreaterThan(Long value) {
            return greaterThan(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdLessThan(Long value) {
            return lessThan(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(innerShopAuctionTemplateId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIn(List<Long> values) {
            return in(innerShopAuctionTemplateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotIn(List<Long> values) {
            return notIn(innerShopAuctionTemplateId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdBetween(Long value1, Long value2) {
            return between(innerShopAuctionTemplateId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(innerShopAuctionTemplateId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andWapDescIsNull() {
            return isNull(wapDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescIsNotNull() {
            return isNotNull(wapDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescEqualTo(String value) {
            return equalTo(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotEqualTo(String value) {
            return notEqualTo(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescGreaterThan(String value) {
            return greaterThan(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLessThan(String value) {
            return lessThan(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLike(String value) {
            return like(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotLike(String value) {
            return notLike(wapDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescIn(List<String> values) {
            return in(wapDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotIn(List<String> values) {
            return notIn(wapDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescBetween(String value1, String value2) {
            return between(wapDesc, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotBetween(String value1, String value2) {
            return notBetween(wapDesc, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andSellerCidsIsNull() {
            return isNull(sellerCids);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsIsNotNull() {
            return isNotNull(sellerCids);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsEqualTo(String value) {
            return equalTo(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotEqualTo(String value) {
            return notEqualTo(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsGreaterThan(String value) {
            return greaterThan(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLessThan(String value) {
            return lessThan(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLike(String value) {
            return like(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotLike(String value) {
            return notLike(sellerCids, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsIn(List<String> values) {
            return in(sellerCids, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotIn(List<String> values) {
            return notIn(sellerCids, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsBetween(String value1, String value2) {
            return between(sellerCids, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotBetween(String value1, String value2) {
            return notBetween(sellerCids, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIsNull() {
            return isNull(hasInvoice);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIsNotNull() {
            return isNotNull(hasInvoice);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceEqualTo(String value) {
            return equalTo(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotEqualTo(String value) {
            return notEqualTo(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceGreaterThan(String value) {
            return greaterThan(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLessThan(String value) {
            return lessThan(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLike(String value) {
            return like(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotLike(String value) {
            return notLike(hasInvoice, value);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIn(List<String> values) {
            return in(hasInvoice, values);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotIn(List<String> values) {
            return notIn(hasInvoice, values);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceBetween(String value1, String value2) {
            return between(hasInvoice, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotBetween(String value1, String value2) {
            return notBetween(hasInvoice, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIncrementIsNull() {
            return isNull(increment);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementIsNotNull() {
            return isNotNull(increment);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementEqualTo(String value) {
            return equalTo(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotEqualTo(String value) {
            return notEqualTo(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementGreaterThan(String value) {
            return greaterThan(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLessThan(String value) {
            return lessThan(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLike(String value) {
            return like(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotLike(String value) {
            return notLike(increment, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementIn(List<String> values) {
            return in(increment, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotIn(List<String> values) {
            return notIn(increment, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementBetween(String value1, String value2) {
            return between(increment, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotBetween(String value1, String value2) {
            return notBetween(increment, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIsExIsNull() {
            return isNull(isEx);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExIsNotNull() {
            return isNotNull(isEx);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExEqualTo(String value) {
            return equalTo(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotEqualTo(String value) {
            return notEqualTo(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExGreaterThan(String value) {
            return greaterThan(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLessThan(String value) {
            return lessThan(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLike(String value) {
            return like(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotLike(String value) {
            return notLike(isEx, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExIn(List<String> values) {
            return in(isEx, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotIn(List<String> values) {
            return notIn(isEx, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExBetween(String value1, String value2) {
            return between(isEx, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotBetween(String value1, String value2) {
            return notBetween(isEx, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andSecondKillIsNull() {
            return isNull(secondKill);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillIsNotNull() {
            return isNotNull(secondKill);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillEqualTo(String value) {
            return equalTo(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotEqualTo(String value) {
            return notEqualTo(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillGreaterThan(String value) {
            return greaterThan(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLessThan(String value) {
            return lessThan(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLike(String value) {
            return like(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotLike(String value) {
            return notLike(secondKill, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillIn(List<String> values) {
            return in(secondKill, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotIn(List<String> values) {
            return notIn(secondKill, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillBetween(String value1, String value2) {
            return between(secondKill, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotBetween(String value1, String value2) {
            return notBetween(secondKill, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andLoadDateIsNull() {
            return isNull(loadDate);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateIsNotNull() {
            return isNotNull(loadDate);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateEqualTo(Date value) {
            return equalTo(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotEqualTo(Date value) {
            return notEqualTo(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateGreaterThan(Date value) {
            return greaterThan(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateLessThan(Date value) {
            return lessThan(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(loadDate, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateIn(List<Date> values) {
            return in(loadDate, values);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotIn(List<Date> values) {
            return notIn(loadDate, values);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateBetween(Date value1, Date value2) {
            return between(loadDate, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotBetween(Date value1, Date value2) {
            return notBetween(loadDate, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIsNull() {
            return isNull(isTaobao);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIsNotNull() {
            return isNotNull(isTaobao);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoEqualTo(String value) {
            return equalTo(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotEqualTo(String value) {
            return notEqualTo(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoGreaterThan(String value) {
            return greaterThan(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLessThan(String value) {
            return lessThan(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLike(String value) {
            return like(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotLike(String value) {
            return notLike(isTaobao, value);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIn(List<String> values) {
            return in(isTaobao, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotIn(List<String> values) {
            return notIn(isTaobao, values);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoBetween(String value1, String value2) {
            return between(isTaobao, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotBetween(String value1, String value2) {
            return notBetween(isTaobao, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andNoloseIsNull() {
            return isNull(nolose);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseIsNotNull() {
            return isNotNull(nolose);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseEqualTo(Long value) {
            return equalTo(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotEqualTo(Long value) {
            return notEqualTo(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseGreaterThan(Long value) {
            return greaterThan(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseLessThan(Long value) {
            return lessThan(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(nolose, value);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseIn(List<Long> values) {
            return in(nolose, values);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotIn(List<Long> values) {
            return notIn(nolose, values);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseBetween(Long value1, Long value2) {
            return between(nolose, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotBetween(Long value1, Long value2) {
            return notBetween(nolose, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andWirelessDescIsNull() {
            return isNull(wirelessDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescIsNotNull() {
            return isNotNull(wirelessDesc);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescEqualTo(String value) {
            return equalTo(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotEqualTo(String value) {
            return notEqualTo(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescGreaterThan(String value) {
            return greaterThan(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLessThan(String value) {
            return lessThan(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLike(String value) {
            return like(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotLike(String value) {
            return notLike(wirelessDesc, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescIn(List<String> values) {
            return in(wirelessDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotIn(List<String> values) {
            return notIn(wirelessDesc, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescBetween(String value1, String value2) {
            return between(wirelessDesc, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotBetween(String value1, String value2) {
            return notBetween(wirelessDesc, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andSubStockIsNull() {
            return isNull(subStock);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockIsNotNull() {
            return isNotNull(subStock);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockEqualTo(Long value) {
            return equalTo(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotEqualTo(Long value) {
            return notEqualTo(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockGreaterThan(Long value) {
            return greaterThan(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockLessThan(Long value) {
            return lessThan(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subStock, value);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockIn(List<Long> values) {
            return in(subStock, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotIn(List<Long> values) {
            return notIn(subStock, values);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockBetween(Long value1, Long value2) {
            return between(subStock, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotBetween(Long value1, Long value2) {
            return notBetween(subStock, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andOneStationIsNull() {
            return isNull(oneStation);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationIsNotNull() {
            return isNotNull(oneStation);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationEqualTo(String value) {
            return equalTo(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotEqualTo(String value) {
            return notEqualTo(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationGreaterThan(String value) {
            return greaterThan(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLessThan(String value) {
            return lessThan(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLike(String value) {
            return like(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotLike(String value) {
            return notLike(oneStation, value);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationIn(List<String> values) {
            return in(oneStation, values);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotIn(List<String> values) {
            return notIn(oneStation, values);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationBetween(String value1, String value2) {
            return between(oneStation, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotBetween(String value1, String value2) {
            return notBetween(oneStation, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andItemWeightIsNull() {
            return isNull(itemWeight);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightIsNotNull() {
            return isNotNull(itemWeight);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightEqualTo(String value) {
            return equalTo(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotEqualTo(String value) {
            return notEqualTo(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightGreaterThan(String value) {
            return greaterThan(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLessThan(String value) {
            return lessThan(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLike(String value) {
            return like(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotLike(String value) {
            return notLike(itemWeight, value);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightIn(List<String> values) {
            return in(itemWeight, values);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotIn(List<String> values) {
            return notIn(itemWeight, values);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightBetween(String value1, String value2) {
            return between(itemWeight, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotBetween(String value1, String value2) {
            return notBetween(itemWeight, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIsNull() {
            return isNull(propertyAlias);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIsNotNull() {
            return isNotNull(propertyAlias);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasEqualTo(String value) {
            return equalTo(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotEqualTo(String value) {
            return notEqualTo(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasGreaterThan(String value) {
            return greaterThan(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLessThan(String value) {
            return lessThan(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLike(String value) {
            return like(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotLike(String value) {
            return notLike(propertyAlias, value);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIn(List<String> values) {
            return in(propertyAlias, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotIn(List<String> values) {
            return notIn(propertyAlias, values);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasBetween(String value1, String value2) {
            return between(propertyAlias, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotBetween(String value1, String value2) {
            return notBetween(propertyAlias, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIsNull() {
            return isNull(withHoldQuantity);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIsNotNull() {
            return isNotNull(withHoldQuantity);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityEqualTo(Long value) {
            return equalTo(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotEqualTo(Long value) {
            return notEqualTo(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityGreaterThan(Long value) {
            return greaterThan(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityLessThan(Long value) {
            return lessThan(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(withHoldQuantity, value);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIn(List<Long> values) {
            return in(withHoldQuantity, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotIn(List<Long> values) {
            return notIn(withHoldQuantity, values);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityBetween(Long value1, Long value2) {
            return between(withHoldQuantity, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotBetween(Long value1, Long value2) {
            return notBetween(withHoldQuantity, value1, value2);
        }
        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
    }
}
