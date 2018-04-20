package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/4/10.
 *
 * @author gtx
 * @description
 * @since
 */
public class BonusBtnInfo implements Serializable {
    /**
     * 是否显示按钮， true为显示
     */
    private Boolean display;
    /**
     * 按钮跳转链接
     */
    private String href;
    /**
     * 按钮文字
     */
    private String btnText;
    /**
     * 红包提示信息
     */
    private String bonusTips;

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public String getBonusTips() {
        return bonusTips;
    }

    public void setBonusTips(String bonusTips) {
        this.bonusTips = bonusTips;
    }
}
