package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：淘宝标准sku信息
 * 项目：main-pom
 * 路径：com.shigu.main4.item.vo.Sku
 * 创建人：wanghaoxiang
 * 时间：17-12-28 下午2:13
 */
public class Sku implements Serializable {

    //商品级别的条形码
    private String barcode;
    //基础色数据
    private String changeProp;
    //sku创建日期 时间格式：yyyy-MM-dd HH:mm:ss
    private String created;
    //sku所属商品id(要废弃的，使用num_iid)
    private String iid;
    //sku最后修改日期 时间格式：yyyy-MM-dd HH:mm:ss
    private String modified;
    //淘宝商品id
    private Long numIid;
    //外部编号(货号)
    private String outerId;
    //属于这个sku的商品的价格 取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分。
    private String price;
    //sku的销售属性组合字符串（颜色，大小，等等，可通过类目API获取某类目下的销售属性）,格式是p1:v1;p2:v2
    private String properties;
    //sku所对应的销售属性的中文名字串，格式如：pid1:vid1:pid_name1:vid_name1;pid2:vid2:pid_name2:vid_name2……
    private String propertiesName;
    //属于这个sku的商品的数量，
    private Long quantity;
    //sku级别发货时间
    private String skuDeliveryTime;
    //skuFeature
    private String skuFeature;
    //sku的id
    private Long skuId;
    //表示SKu上的产品规格信息
    private Long skuSpecId;
    //sku状态。 normal:正常 ；delete:删除
    private String status;
    
    private Long extraId;
    
    private Date gmtModified;
    
    private String memo;
    
    private Long withHoldQuantity;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getChangeProp() {
        return changeProp;
    }

    public void setChangeProp(String changeProp) {
        this.changeProp = changeProp;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getExtraId() {
        return extraId;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getSkuDeliveryTime() {
        return skuDeliveryTime;
    }

    public void setSkuDeliveryTime(String skuDeliveryTime) {
        this.skuDeliveryTime = skuDeliveryTime;
    }

    public String getSkuFeature() {
        return skuFeature;
    }

    public void setSkuFeature(String skuFeature) {
        this.skuFeature = skuFeature;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuSpecId() {
        return skuSpecId;
    }

    public void setSkuSpecId(Long skuSpecId) {
        this.skuSpecId = skuSpecId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getWithHoldQuantity() {
        return withHoldQuantity;
    }

    public void setWithHoldQuantity(Long withHoldQuantity) {
        this.withHoldQuantity = withHoldQuantity;
    }
}
