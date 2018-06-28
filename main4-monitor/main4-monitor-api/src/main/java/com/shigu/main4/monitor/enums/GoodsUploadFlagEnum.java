package com.shigu.main4.monitor.enums;


/**
 * Created by gtx on 2018/6/18.
 * 商品上传flag类型
 * @author gtx
 * @since
 */
public enum  GoodsUploadFlagEnum {

    WEB_TB("web-tb","上传到淘宝"),
    JD("jd","上传到京东"),
    PDD("pdd","上传到拼多多"),
    SN("sn","上传到苏宁"),

    ;


    GoodsUploadFlagEnum(String flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public static GoodsUploadFlagEnum valueOfFlag(String flag) {
        for (GoodsUploadFlagEnum item : GoodsUploadFlagEnum.values()) {
            if (item.getFlag().equals(flag)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 上传类型
     */
    private String flag;
    /**
     * 类型说明
     */
    private String desc;

    public String getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }
}
