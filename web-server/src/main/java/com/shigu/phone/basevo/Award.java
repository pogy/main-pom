package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * 类名：Award
 * 类路径：com.shigu.phone.basevo.Award
 * 创建者：任真飞
 * 创建时间：2017-10-30 15:05
 * 项目：main-pom
 * 描述：奖品信息
 */
public class Award implements Serializable {
    //奖品图片对应的url
    private String icon;
    //奖品显示的文体，比如：一等奖：iphoneX
    private String text;
    //中奖状态，取值：1（等待中奖），2（未中奖），3（已中奖未领取）
    private Integer state;
    //奖品是否已领取，取值：true（已领取），false（未领取）
    private boolean hasReceived;
    //中奖领取码
    private String code;

    public Award() {
    }

    public Award( String icon, String text, Integer state, boolean hasReceived, String code ) {
        this.icon = icon;
        this.text = text;
        this.state = state;
        this.hasReceived = hasReceived;
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public Integer getState() {
        return state;
    }

    public void setState( Integer state ) {
        this.state = state;
    }

    public boolean isHasReceived() {
        return hasReceived;
    }

    public void setHasReceived( boolean hasReceived ) {
        this.hasReceived = hasReceived;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }
}