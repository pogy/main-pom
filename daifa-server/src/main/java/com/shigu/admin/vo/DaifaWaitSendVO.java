package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：DaifaWaitSendVO
 * @文件路径：com.shigu.admin.vo.DaifaWaitSendVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/16 13:18
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class DaifaWaitSendVO implements Serializable{


    private Long dwsId;
    /**待发Id*/
    private Long dfTradeId;
    /**交易编号（订单系统订单ID）*/
    private String tradeCode;
    /**代发机构ID*/
    private Long sellerId;
    /**发货状态@1待发货2已发货3转未发退货*/
    private Integer sendStatus;
    /**创建日期@ YYYYMMDD*/
    private String createDate;
    /**创建时间*/
    private java.util.Date createTime;
    /**总钱数@单位元*/
    private String money;
    /**买家ID@可为空*/
    private Long buyerId;
    /**快递名*/
    private String expressName;
    /**收件人省*/
    private String receiverState;
    /**收件人详细地址*/
    private String receiverAddress;
    /**收件人姓名*/
    private String receiverName;
    /**收件人手机号*/
    private String receiverPhone;
    /**买家姓名@可为空*/
    private String buyerName;
    /**买家电话@可为空*/
    private String buyerTelephone;
    /**买家QQ@可为空*/
    private String buyerQq;
    /**买家旺旺@可为空*/
    private String buyerWw;
    /**收件人邮编*/
    private String receiverZip;
    /**待发订单是否显示0不显示1显示*/
    private Integer orderDisplay;//

    public Long getDwsId () {
        return dwsId;
    }

    public void setDwsId (Long dwsId) {
        this.dwsId = dwsId;
    }
}
