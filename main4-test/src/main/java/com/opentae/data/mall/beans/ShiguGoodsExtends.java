package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguGoodsExtends extends MoreSiteBean {
    @Transient
    private static final long serialVersionUID = -8333016446807933667L;
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long goodsId;
    private String goodsDesc;
    private String propsName;
    private String auctionPoint;
    private String propertyAlias;
    private String templateId;
    private Long afterSaleId;
    private Long subStock;
    private Long innerShopAuctionTemplateId;
    private Long outerShopAuctionTemplateId;
    private String features;
    private String itemWeight;
    private String itemSize;
    private Long withHoldQuantity;
    private String customMadeTypeId;
    private String wirelessDesc;
    private String barcode;
    private String sellerCids;
    private String props;
    private String inputPids;
    private String inputStr;
    private String images;
    private String hasInvoice;
    private String hasWarranty;
    private String increment;
    private String approveStatus;
    private Long productId;
    private Long postageId;
    private String isVirtual;
    private String isTaobao;
    private String isEx;
    private String isTiming;
    @Column(
            name = "is_3d"
    )
    private String is3d;
    private String oneStation;
    private String secondKill;
    private String violation;
    private String wapDesc;
    private String wapDetailUrl;
    private Long codPostageId;
    private String sellPromise;
    private Long nolose;
    private Date loadDate;
    private Date updateTime;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;
    private String remark16;
    private String remark17;
    private String remark18;
    private String remark19;
    private String remark20;
    private Date lastModifyTime;
    private String subtitle;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getPropsName() {
        return propsName;
    }

    public void setPropsName(String propsName) {
        this.propsName = propsName;
    }

    public String getAuctionPoint() {
        return auctionPoint;
    }

    public void setAuctionPoint(String auctionPoint) {
        this.auctionPoint = auctionPoint;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Long getAfterSaleId() {
        return afterSaleId;
    }

    public void setAfterSaleId(Long afterSaleId) {
        this.afterSaleId = afterSaleId;
    }

    public Long getSubStock() {
        return subStock;
    }

    public void setSubStock(Long subStock) {
        this.subStock = subStock;
    }

    public Long getInnerShopAuctionTemplateId() {
        return innerShopAuctionTemplateId;
    }

    public void setInnerShopAuctionTemplateId(Long innerShopAuctionTemplateId) {
        this.innerShopAuctionTemplateId = innerShopAuctionTemplateId;
    }

    public Long getOuterShopAuctionTemplateId() {
        return outerShopAuctionTemplateId;
    }

    public void setOuterShopAuctionTemplateId(Long outerShopAuctionTemplateId) {
        this.outerShopAuctionTemplateId = outerShopAuctionTemplateId;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public Long getWithHoldQuantity() {
        return withHoldQuantity;
    }

    public void setWithHoldQuantity(Long withHoldQuantity) {
        this.withHoldQuantity = withHoldQuantity;
    }

    public String getCustomMadeTypeId() {
        return customMadeTypeId;
    }

    public void setCustomMadeTypeId(String customMadeTypeId) {
        this.customMadeTypeId = customMadeTypeId;
    }

    public String getWirelessDesc() {
        return wirelessDesc;
    }

    public void setWirelessDesc(String wirelessDesc) {
        this.wirelessDesc = wirelessDesc;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSellerCids() {
        return sellerCids;
    }

    public void setSellerCids(String sellerCids) {
        this.sellerCids = sellerCids;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(String hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public String getHasWarranty() {
        return hasWarranty;
    }

    public void setHasWarranty(String hasWarranty) {
        this.hasWarranty = hasWarranty;
    }

    public String getIncrement() {
        return increment;
    }

    public void setIncrement(String increment) {
        this.increment = increment;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPostageId() {
        return postageId;
    }

    public void setPostageId(Long postageId) {
        this.postageId = postageId;
    }

    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getIsTaobao() {
        return isTaobao;
    }

    public void setIsTaobao(String isTaobao) {
        this.isTaobao = isTaobao;
    }

    public String getIsEx() {
        return isEx;
    }

    public void setIsEx(String isEx) {
        this.isEx = isEx;
    }

    public String getIsTiming() {
        return isTiming;
    }

    public void setIsTiming(String isTiming) {
        this.isTiming = isTiming;
    }

    public String getIs3d() {
        return is3d;
    }

    public void setIs3d(String is3d) {
        this.is3d = is3d;
    }

    public String getOneStation() {
        return oneStation;
    }

    public void setOneStation(String oneStation) {
        this.oneStation = oneStation;
    }

    public String getSecondKill() {
        return secondKill;
    }

    public void setSecondKill(String secondKill) {
        this.secondKill = secondKill;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public String getWapDesc() {
        return wapDesc;
    }

    public void setWapDesc(String wapDesc) {
        this.wapDesc = wapDesc;
    }

    public String getWapDetailUrl() {
        return wapDetailUrl;
    }

    public void setWapDetailUrl(String wapDetailUrl) {
        this.wapDetailUrl = wapDetailUrl;
    }

    public Long getCodPostageId() {
        return codPostageId;
    }

    public void setCodPostageId(Long codPostageId) {
        this.codPostageId = codPostageId;
    }

    public String getSellPromise() {
        return sellPromise;
    }

    public void setSellPromise(String sellPromise) {
        this.sellPromise = sellPromise;
    }

    public Long getNolose() {
        return nolose;
    }

    public void setNolose(Long nolose) {
        this.nolose = nolose;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public String getRemark16() {
        return remark16;
    }

    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }

    public String getRemark17() {
        return remark17;
    }

    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }

    public String getRemark18() {
        return remark18;
    }

    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }

    public String getRemark19() {
        return remark19;
    }

    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }

    public String getRemark20() {
        return remark20;
    }

    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
