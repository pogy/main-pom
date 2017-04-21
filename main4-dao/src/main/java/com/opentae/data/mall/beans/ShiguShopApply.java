package com.opentae.data.mall.beans;

import org.springframework.util.StringUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguShopApply implements Serializable {
    @Transient
    private static final long serialVersionUID = -1988796710738243322L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long ruzhuId;

    /**
     * 星座网用户ID
     */
    private Long userId;

    /**
     * 主营类目
     */
    private String mainBus;

    /**
     * 档口号
     */
    private String shopNum;

    /**
     * 1表示可审核，0表示信息不齐不可审核，2表示审核完毕，不能再审核
     */
    private Integer canExamine;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 微信号
     */
    private String imWx;

    /**
     * QQ号
     */
    private String imQq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 分站标识
     */
    private String webSite;

    /**
     * 市场ID
     */
    private Long marketId;

    /**
     * 楼层ID
     */
    private Long floorId;

    /**
     * 退换服务标签
     */
    private String tags;

    /**
     * 申请者IP
     */
    private String ip;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 淘宝店铺ID
     */
    private String tbshopId;

    /**
     * 淘宝用户ID
     */
    private String tbuserId;

    /**
     * 淘宝昵称
     */
    private String tbNick;

    /**
     * 淘宝店链接
     */
    private String tbUrl;

    /**
     * 阿里旺旺
     */
    private String imAliww;
    /**
     * 0表示未处理，1表示审核通过，2表示拒绝
     */
    private Integer applyStatus;
    /**
     * 拒绝理由
     */
    private String refuseReason;

    @Transient
    private String parentMarketName;

    @Transient
    private String tagstr;


    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Long getRuzhuId() {
        return ruzhuId;
    }

    public void setRuzhuId(Long ruzhuId) {
        this.ruzhuId = ruzhuId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public Integer getCanExamine() {
        return canExamine;
    }

    public void setCanExamine(Integer canExamine) {
        this.canExamine = canExamine;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
        if(!StringUtils.isEmpty(tags)){
            String [] tagstrs = tags.split(",");
            String tagstr = "";
            for(int i = 0;i<tagstrs.length;i++){
                String tag = tagstrs[i];
                if(tag.equals("1")){
                    tagstr+="可退";
                }
                if(tag.equals("2")){
                    tagstr+="可换";
                }
                if(i != tagstrs.length-1){
                    tagstr+="，";
                }
            }
            this.tagstr = tagstr;
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getTbshopId() {
        return tbshopId;
    }

    public void setTbshopId(String tbshopId) {
        this.tbshopId = tbshopId;
    }

    public String getTbuserId() {
        return tbuserId;
    }

    public void setTbuserId(String tbuserId) {
        this.tbuserId = tbuserId;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getTbUrl() {
        return tbUrl;
    }

    public void setTbUrl(String tbUrl) {
        this.tbUrl = tbUrl;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public String getTagstr() {
        return tagstr;
    }

    public void setTagstr(String tagstr) {
        this.tagstr = tagstr;
    }
}
