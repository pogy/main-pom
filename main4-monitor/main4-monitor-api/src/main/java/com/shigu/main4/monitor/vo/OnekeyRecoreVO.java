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
    private String target;
    /** true/false 已/未下架 */
    private boolean unShelve;

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean getUnShelve() {
        return unShelve;
    }

    public void setUnShelve(boolean unShelve) {
        this.unShelve = unShelve;
    }
}
