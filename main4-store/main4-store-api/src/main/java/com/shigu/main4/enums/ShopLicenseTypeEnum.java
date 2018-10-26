package com.shigu.main4.enums;

/**
 * Created by wxc on 2017/2/22.
 *
 *  店铺权益类型枚举
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public enum ShopLicenseTypeEnum {

    // 0、
    NONE("没有权益",0),
    /**
     * 1、身份证认证，内容为身份证图片
     */
    IDENTITY("身份证认证，内容为身份证图片",1),
    /**
     * 2、工商认证，内容为营业执照
     */
    BUSINESS("工商认证，内容为营业执照",2),
    /**
     * 3、实体认证，内容为店面照片
     */
    ENTITY("实体认证，内容为店面照片",3),
    /**
     * 4、合同认证，内容为租赁合同
     */
    CONTRACT("合同认证，内容为租赁合同",4),
    /**
     * 5、标签授予，内容为标签种类ID
     */
    TAGS("标签授予，内容为标签种类ID",5),
    /**
     * 6、星星数，内容为星星的数量
     */
    STAR("星星数，内容为星星的数量",6),

    SHOPDATA("用户数据盘",8),

    /**
     * 沧州显示微信同号
     */
    WEIXIN("微信同号",9),
    ZIXUN("咨询",10),
    ;

    private String title;
    private Integer value;

    ShopLicenseTypeEnum(String title, Integer value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
