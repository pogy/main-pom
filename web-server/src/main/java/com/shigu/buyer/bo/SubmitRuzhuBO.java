package com.shigu.buyer.bo;

import com.shigu.main4.common.vo.ShiguTags;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 提交入驻数据
 * Created by zhaohongbo on 17/3/3.
 */
public class SubmitRuzhuBO implements Serializable{
    /**
     * 主营类目
     */
    @NotEmpty(message = "请选择主营商品")
    @SafeHtml(message = "mainCate含非法页面标签")
    private String mainCate;
    /**
     * 档口号
     */
    @NotEmpty(message = "请填写档口号")
    @SafeHtml(message = "storeNum含非法页面标签")
    private String storeNum;
    /**
     * 是否有淘宝店,0没有   1有
     */
//    @NotNull(message = "请选择是否有淘宝店")
//    private Integer hasTaobaoStore;
    /**
     * 淘宝昵称
     */
    private String tbNick;
    /**
     * 手机号
     */
    @NotEmpty(message = "请填写手机号")
    @SafeHtml(message = "tel含非法页面标签")
    private String tel;
    /**
     * 微信
     */
    @NotEmpty(message = "请填写微信号")
    @SafeHtml(message = "wx含非法页面标签")
    private String wx;
    /**
     * qq
     */
    @NotEmpty(message = "请填写QQ号")
    @SafeHtml(message = "qq含非法页面标签")
    private String qq;

    /**
     * 阿里旺旺
     */
    @NotEmpty(message = "请填写旺旺号")
    @SafeHtml(message = "aliWw含非法页面标签")
    private String aliWw;
    /**
     * 邮箱
     */
    @SafeHtml(message = "含非法页面标签")
    private String email;
    /**
     * 城市标识
     */
    @NotEmpty(message = "请选择店铺所在城市")
    @SafeHtml(message = "cityId含非法页面标签")
    private String cityId;
    /**
     * 市场ID
     */
    @NotNull(message = "请选择市场")
    private Long marketId;
    /**
     * 楼层ID
     */
    @NotNull(message = "请选择楼层")
    private Long marketFloor;
    /**
     * 服务级别,0代表没服务,1可退,2可换,3可退可换
     */
    @NotEmpty(message = "需要传入服务类别")
    @SafeHtml(message = "serverLevel含非法页面标签")
    private String serverLevel;

    public String getMainCate() {
        return mainCate;
    }

    public void setMainCate(String mainCate) {
        this.mainCate = mainCate;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getMarketFloor() {
        return marketFloor;
    }

    public void setMarketFloor(Long marketFloor) {
        this.marketFloor = marketFloor;
    }

    public String getServerLevel() {
        return serverLevel;
    }

    public void setServerLevel(String serverLevel) {
        this.serverLevel = serverLevel;
    }

    public String getAliWw() {
        return aliWw;
    }

    public void setAliWw(String aliWw) {
        this.aliWw = aliWw;
    }

    /**
     * 0代表没服务,1可退,2可换,3可退可换
     */
    public String parseServerLevel() {
        serverLevel=serverLevel==null?"":serverLevel;
        if(serverLevel.equals("1")){
            serverLevel = ShiguTags.CAN_RETREAT.getValue();
        }else if(serverLevel.equals("2")){
            serverLevel = ShiguTags.CAN_CHANGE.getValue();
        }else if(serverLevel.equals("3")){
            serverLevel = ShiguTags.CAN_RETREAT.getValue()+","+ShiguTags.CAN_CHANGE.getValue();
        }
        return serverLevel;
    }
}
