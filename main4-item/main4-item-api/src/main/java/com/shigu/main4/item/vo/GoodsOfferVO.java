package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.List;

public class GoodsOfferVO implements Serializable {
    /**
     * 商品标题
     */
    private String goodsTitle;
    /**
     * 批发价
     */
    private String piPrice;

    /**
     * 最低零售价
     */
    private String lowestLiPrice;

    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 面料
     */
    private String fabric;
    /**
     * 里料
     */
    private String inFabric;

    /**
     * 商品属性数据
     */
    private FormAttribute formAttribute;

    /**
     *SKU列表
     */
    private SkuAttribute skuAttribute;

    /**
     * 首图
     */
    private String picPath;
    /**
     * 5张图,不包含首图 字符串数组
     */
    private List allimg;

    /**
      * 商品详情
      */
     private String deschtml;




     

    /**
     * 自定义的pid
     */
    private String inputPids;
    /**
     * 自定义的值
     */
    private String inputStr;
    /**
     * 所有属性ID串
     */
    private String paramstr;
    /**
     * 属性值重定义
     */
    private String propertyAlias;

    /**
     * 零售价
     */
    private String buynow;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 商品数量
     */
    private Long quantity;


    /**
     * 店内类目ID串
     */
    private String sellerids;
    /**
     * 淘宝类目ID
     */
    private Long cid;




}
