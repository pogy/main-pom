package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：StoreRefundDealBO
 * @文件路径：com.shigu.main4.daifa.bo.StoreRefundDealBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:42
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class StoreRefundDealBO implements Serializable{
    private Boolean refundSucceed;//是否退成功
    private Double money;//退得的金额
    private Long refundId;//退申请ID
}
