package com.shigu.main4.spread.vo;

import java.io.Serializable;

/**
 * 类名：UserPrizeForShowVO
 * 类路径：com.shigu.main4.spread.vo.UserPrizeForShowVO
 * 创建者：王浩翔
 * 创建时间：2017-11-20 17:37
 * 项目：main-pom
 * 描述：前端显示我的奖品需要信息
 */
public class UserPrizeForShowVO implements Serializable {
    //中奖名称，比如一等奖，二等奖
    private String name;
    //奖品名称
    private String prize;
    //奖品图片地址
    private String img;
    //中奖状态，1等待抽奖 2未中奖 3已中奖
    private Integer state;
    //是否已领取
    private Boolean takedIs;
    //领取码,不存在则为null
    private String takeCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getTakedIs() {
        return takedIs;
    }

    public void setTakedIs(Boolean takedIs) {
        this.takedIs = takedIs;
    }

    public String getTakeCode() {
        return takeCode;
    }

    public void setTakeCode(String takeCode) {
        this.takeCode = takeCode;
    }
}
