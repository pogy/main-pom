package com.shigu.main4.spread.bo;

import java.io.Serializable;

/**
 * 类名：TrademarkApplyBO
 * 类路径：com.shigu.main4.spread.bo.TrademarkApplyBO
 * 创建者：王浩翔
 * 创建时间：2017-10-13 17:22
 * 项目：main-pom
 * 描述：
 */
public class TrademarkApplyBO implements Serializable {

    //类型 1:商标普通注册,2:商标加急注册,3:商标担保注册,4:商标双享注册,5:普通登记,6:加急登记,7:外观专利,8:设计稿作品
    private String type;
    //联系人姓名
    private String name;
    //联系人手机号
    private String telephone;
    //说明
    private String detailText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }
}
