package com.shigu.main4.order.enums;

/**
 * Created by gtx on 2018/7/19.
 * 代金券/优惠券 类型枚举
 * @author gtx
 * @since
 */
public enum  ItemVoucherTypeEnum {

    INVITE("INVITE_VOUCHER_TAG","${userId}","邀请红包"),

            ;

    /**
     * 代金券识别标记
     */
    public String tag;
    /**
     * 唯一标记占位符
     */
    public String key;
    /**
     * 描述信息
     */
    public String desc;

    ItemVoucherTypeEnum(String tag, String key, String desc) {
        this.tag = tag;
        this.key = key;
        this.desc = desc;
    }

    public String voucherTag(String key){
        return this.tag.replace(this.key,String.valueOf(key));
    }
}
