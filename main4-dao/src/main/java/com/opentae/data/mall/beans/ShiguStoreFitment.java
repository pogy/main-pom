package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Deprecated
public class ShiguStoreFitment extends MoreSiteBean {

    @Transient
    private static final long serialVersionUID = 7718194560284552892L;

    /**
     * 装修ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long fitmentId;

    /**
     * 店铺ID
     */
    private Long storeId;

    /**
     * 店铺名
     */
    private String storeName;

    /**
     * 装修日期
     */
    private Date fitmentDate;

    /**
     * 主题
     */
    private String theme;

    /**
     * store_banner
     */
    private String storeBanner;

    /**
     *
     */
    private String storeBanner2;

    /**
     *
     */
    private String storeBanner3;

    /**
     *
     */
    private String storeBanner4;

    /**
     *
     */
    private String storeBanner5;

    /**
     * 店铺标志
     */
    private String storeLogo;

    /**
     * 店铺描述
     */
    private String description;

    /**
     * 图片1
     */
    @Column(name = "image_1")
    private String image1;

    /**
     * 图片2
     */
    @Column(name = "image_2")
    private String image2;

    /**
     * 图片3
     */
    @Column(name = "image_3")
    private String image3;

    /**
     * 备用1
     */
    private String remark1;

    /**
     * 备用2
     */
    private String remark2;

    /**
     * 备用3
     */
    private String remark3;

    /**
     * 备用4
     */
    private String remark4;

    /**
     * 备用5
     */
    private String remark5;

    /**
     * 备用6
     */
    private String remark6;

    /**
     * 备用7
     */
    private String remark7;

    /**
     * 备用8
     */
    private String remark8;

    /**
     * 备用9
     */
    private String remark9;

    /**
     * 备用10
     */
    private String remark10;

    /**
     * 备用11
     */
    private String remark11;

    /**
     * 备用12
     */
    private String remark12;

    /**
     * 备用13
     */
    private String remark13;

    /**
     * 备用14
     */
    private String remark14;

    /**
     * 备用15
     */
    private String remark15;

    /**
     * 备用16
     */
    private String remark16;

    /**
     * 备用17
     */
    private String remark17;

    /**
     * 备用18
     */
    private String remark18;

    /**
     * 备用19
     */
    private String remark19;

    /**
     * 0:无效  1:有效
     */
    private Integer status;

    /**
     * 备用20
     */
    private String remark20;

    private Date lastModifyTime;

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public ShiguStoreFitment() {
    }

    public Long getFitmentId() {
        return this.fitmentId;
    }

    public void setFitmentId(Long fitmentId) {
        this.fitmentId = fitmentId;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getFitmentDate() {
        return this.fitmentDate;
    }

    public void setFitmentDate(Date fitmentDate) {
        this.fitmentDate = fitmentDate;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStoreBanner() {
        return this.storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner;
    }

    public String getStoreBanner2() {
        return this.storeBanner2;
    }

    public void setStoreBanner2(String storeBanner2) {
        this.storeBanner2 = storeBanner2;
    }

    public String getStoreBanner3() {
        return this.storeBanner3;
    }

    public void setStoreBanner3(String storeBanner3) {
        this.storeBanner3 = storeBanner3;
    }

    public String getStoreBanner4() {
        return this.storeBanner4;
    }

    public void setStoreBanner4(String storeBanner4) {
        this.storeBanner4 = storeBanner4;
    }

    public String getStoreBanner5() {
        return this.storeBanner5;
    }

    public void setStoreBanner5(String storeBanner5) {
        this.storeBanner5 = storeBanner5;
    }

    public String getStoreLogo() {
        return this.storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return this.image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return this.image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return this.image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getRemark1() {
        return this.remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return this.remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return this.remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return this.remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return this.remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return this.remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return this.remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return this.remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return this.remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return this.remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return this.remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return this.remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return this.remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return this.remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public String getRemark16() {
        return this.remark16;
    }

    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }

    public String getRemark17() {
        return this.remark17;
    }

    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }

    public String getRemark18() {
        return this.remark18;
    }

    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }

    public String getRemark19() {
        return this.remark19;
    }

    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark20() {
        return this.remark20;
    }

    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }

}
