package com.shigu.main4.ucenter.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguGoodsExtendsVO implements Serializable {

    private Long goodsId;
    private String goodsDesc;
    private String propsName;
    private String auctionPoint;
    private String propertyAlias;
    private Long subStock;
    private String features;
    private String itemWeight;
    private String itemSize;
    private Long withHoldQuantity;
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
    private Long postageId;
    private String isVirtual;
    private String isEx;
    private String isTiming;
    private String is3d;
    private String oneStation;
    private String violation;
    private String wapDesc;
    private String wapDetailUrl;
    private Long codPostageId;
    private String sellPromise;
    private Date loadDate;
    private Date updateTime;
    private Date lastModifyTime;
    private String subtitle;
    private String inputCustomCpv;//自定义属性值

    private List<ShiguPropImg> list_spi=new ArrayList<> ();
    

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

    public Long getSubStock() {
        return subStock;
    }

    public void setSubStock(Long subStock) {
        this.subStock = subStock;
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

    public List<ShiguPropImg> getList_spi () {
        return list_spi;
    }

    public void setList_spi (List<ShiguPropImg> list_spi) {
        this.list_spi = list_spi;
    }

    public String getInputCustomCpv () {
        return inputCustomCpv;
    }

    public void setInputCustomCpv (String inputCustomCpv) {
        this.inputCustomCpv = inputCustomCpv;
    }
}
