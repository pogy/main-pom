package com.shigu.main4.monitor.vo;

import java.util.Date;

/**
 * Created by wxc on 2017/1/13.
 * 一键上传记录值
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class OnekeyRecoreVO implements java.io.Serializable {

    private Long id;
    private String onekeyId;
    private String title;
    private String imgsrc;
    private String piprice;
    private String liprice;
    private String webSite;
    private Date createDate;
    private String createtime;
    /** 上传到 */
    private String flag;
    /** true/false 淘宝已/未下架 */
    private boolean tbSoldout;
    /** true/false 档口已/未下架 */
    private boolean shopSoldout;




    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isTbSoldout() {
        return tbSoldout;
    }

    public void setTbSoldout(boolean tbSoldout) {
        this.tbSoldout = tbSoldout;
    }

    public boolean isShopSoldout() {
        return shopSoldout;
    }

    public void setShopSoldout(boolean shopSoldout) {
        this.shopSoldout = shopSoldout;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOnekeyId() {
        return onekeyId;
    }

    public void setOnekeyId(String onekeyId) {
        this.onekeyId = onekeyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getLiprice() {
        return liprice;
    }

    public void setLiprice(String liprice) {
        this.liprice = liprice;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCreatetime() {
        return createtime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


}
