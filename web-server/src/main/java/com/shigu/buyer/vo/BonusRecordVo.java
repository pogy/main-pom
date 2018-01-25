package com.shigu.buyer.vo;

/**
 * 红包收支明细
 *
 * @author wangbo 2018-01-18 15:52
 */
public class BonusRecordVo {

    /** 流水号 */
    private String payCode;

    /** 流水号文本：充值编号、交易编号等 */
    private String payCodeText;

    /** 流水记录的类型：1=充值，2=使用 */
    private int payState;

    /** 红包类型描述文字：四季星座网平台赠送、用户使用等*/
    private String payText;

    /** 红包金额，前面要带上+或- */
    private String money;

    /** 记录创建时间 */
    private String time;

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayCodeText() {
        return payCodeText;
    }

    public void setPayCodeText(String payCodeText) {
        this.payCodeText = payCodeText;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public String getPayText() {
        return payText;
    }

    public void setPayText(String payText) {
        this.payText = payText;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
