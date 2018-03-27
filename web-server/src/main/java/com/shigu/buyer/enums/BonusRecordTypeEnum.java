package com.shigu.buyer.enums;

import com.opentae.data.mall.beans.ShiguBonusRecord;
import com.shigu.buyer.vo.BonusRecordVo;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 红包使用类型枚举
 * Created By admin on 2018/3/22/9:07
 */
public enum  BonusRecordTypeEnum {
    RECHARGE(1,"充值编号:","四季星座网平台赠送","+"),
    USED(2,"交易编号:","充值到余额","-"),
    WX(3,"交易编号:","微信转账","-"),
    XX(4,null,"线下发券","-"),

    ;

    /** 流水号文本：充值编号、交易编号等 */
    private String payCodeText;
    /**消费金额符号 + - */
    private String moneyPre;
    /** 流水记录的类型：1=系统充值，2=用户使用 3=微信转账 4=线下发券*/
    private int payState;

    /** 红包类型描述文字：四季星座网平台赠送、用户使用、微信转账、线下发券 等*/
    private String payText;

    BonusRecordTypeEnum(int payState,String payCodeText, String payText,String moneyPre) {
        this.payState = payState;
        this.payCodeText = payCodeText;
        this.payText = payText;
        this.moneyPre = moneyPre;
    }

    public static BonusRecordTypeEnum getEnumByType(int type){
        BonusRecordTypeEnum bonusRecordTypeEnum = null;
        for (BonusRecordTypeEnum item : BonusRecordTypeEnum.values()){
            if (item.payState == type) {
                bonusRecordTypeEnum = item;
            }
        }
        return bonusRecordTypeEnum;
    }

    public static BonusRecordVo fillBonusRecordVo(BonusRecordVo bonusRecordVo, ShiguBonusRecord bonusRecord){
        BonusRecordTypeEnum enumByType = getEnumByType(bonusRecord.getType());
        if (enumByType == null) {
            return null;
        }
        bonusRecordVo.setMoney(enumByType.getMoneyPre()+String.format("%.2f", bonusRecord.getAmount() * 0.01));
        bonusRecordVo.setPayText(enumByType.getPayText());
        bonusRecordVo.setPayCodeText(enumByType.getPayCodeText());
        bonusRecordVo.setPayState(bonusRecord.getType());
        if (enumByType.payCodeText != null) {
            bonusRecordVo.setPayCode(bonusRecord.getSerialNumber());
        }
        bonusRecordVo.setTime(DateFormatUtils.format(bonusRecord.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        return bonusRecordVo;
    }



    public String getPayCodeText() {
        return payCodeText;
    }

    public int getPayState() {
        return payState;
    }

    public String getPayText() {
        return payText;
    }

    public String getMoneyPre() {
        return moneyPre;
    }
}
