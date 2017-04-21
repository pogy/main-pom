package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 实名认证提交的数据
 * Created by zhaohongbo on 17/3/14.
 */
public class SafeRzBO implements Serializable{
    /**
     * 身份证号
     */
    @NotEmpty(message = "缺少必要数据cardid")
    @SafeHtml(message = "cardid包含非法页面标签")
    private String cardid;
    /**
     * 身份证图片
     */
    @NotEmpty(message = "缺少必要数据cardimg1")
    @SafeHtml(message = "cardimg1包含非法页面标签")
    private String cardimg1;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCardimg1() {
        return cardimg1;
    }

    public void setCardimg1(String cardimg1) {
        this.cardimg1 = cardimg1;
    }
}
