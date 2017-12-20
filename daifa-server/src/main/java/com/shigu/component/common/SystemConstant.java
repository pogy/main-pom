package com.shigu.component.common;

/**
 * 系统常量
 * @author shigu_zjb
 * @version 1.0
 * @time 2016/7/4 15:25
 *
 */
public class SystemConstant {
	
	/************************************** 程序响应状态 ******************************************/
	
	public final static String RESPONSE_STATUS_SUCCESS = "SUCCESS";// 成功
	public final static String RESPONSE_STATUS_FAILED = "FAILED";// 失败
	public final static String RESPONSE_STATUS_ERROR = "ERROR";// 系统错误/运行时异常
	
	
	/*************************************** 库存表入库状态 **************************************/
	
	public final static int STOCK_NOT_SENNT_IN_STORAGE_INTSTATUS = 1;// 未发入库
	public final static int STOCK_RERURN_WAREHOUSING_INTSTATUS = 2;// 退货入库
	public final static int STOCK_RETURN_FAILED_IN_STORAGE_INTSTATUS = 3;// 退货失败入库
	public final static int STOCK_REPLACEMENT_OF_STORAGE_INTSTATUS = 4;// 换货入库
	public final static int STOCK_REPLACEMENT_OF_STORAGE_SUCCESSINT_STATUS = 5;// 换货成功入库
	public final static int STOCK_REPLACEMENT_OF_STORAGE_FAILED_INTSTATUS = 6;// 换货失败入库
	public final static int STOCK_RETURN_VOUCHERS_STORAGE_INTSTATUS = 7;// 退货代金券入库
	
	/*************************************** 代发子订单库存标识 **************************************/
	
	public final static Long ORDER_STOCK_INT_FLAG = 1L;// 入库
	public final static Long ORDER_STOCK_OUT_FLAG = 2L;// 出库

	/*************************************** 库存表出库状态 **************************************/
	
	public final static int STOCK_NORMAL_OUTSTATUS = 1;// 正常发货出库
	public final static int STOCK_RETURN_GOODS_OUTSTATUS = 2;// 退货退件出库
	public final static int STOCK_RETURN_GOODS_FAILUED_OUTSTATUS = 3;// 退货失败发回客户出库
	public final static int STOCK_CHANGE_GOODS_OUTSTATUS = 4;// 换货换件出库
	public final static int STOCK_CHANGE_GOODS_SUCCESS_OUTSTATUS = 5;// 换货成功发回客户出库
	public final static int STOCK_CHANGE_GOODS_FAILED_OUTSTATUS = 6;// 换货失败发回客户出库
	public final static int STOCK_CASH_COUPON_OUTSTATUS = 7;// 代金券拿货出库
	public final static int STOCK_RETURN_GOODS_SUCCESS = 8;// 退货成功
	public final static int STOCK_REPLACE_GOODS_SUCCESS = 9;// 换货成功
	
	/********************************** 事务相关 *********************************/
	
	public final static int TRANSACTION_TIMEOUT = 25;// 默认25秒

	/************************************订单长度处理*******************************/
	
	public final static int EZINT=7;//截取单号长度
	
	/************************************ 工作用户类型 *******************************/
	
	public final static int WORK_GET_TYPE = 1;// 拿货人
	public final static int WORK_RERUND_GOODS_TYPE = 2;// 退货人
	public final static int WORK_REPLACE_GOODS_TYPE = 3;// 换货人
	public final static int WORK_STOCK_MAN_TYPE = 4;// 库存管理员
	
	/************************************** 售后状态 ******************************************/
	
	public final static int AFTER_SALE_WAIT_HANDLE_STATUS = 0;// 等待处理
	public final static int AFTER_SALE_FINISHED_HANDLE_STATUS = 2;// 处理完成
	
	/************************************** 售后子表退货状态 ******************************************/
	
	public final static int AFTER_SALE_SUB_APPLY_REFUND_RETURN_STATUS = 1;// 申请退款
	public final static int AFTER_SALE_SUB_GOOD_REFUND_STROAGE_IN_RETURN_STATUS = 2;// 退货入库
	public final static int AFTER_SALE_SUB_GOOD_REFUND_SUCCESS_RETURN_STATUS = 3;// 退货成功
	public final static int AFTER_SALE_SUB_SETTLED_RETURN_STATUS = 4;// 已结算
	public final static int AFTER_SALE_SUB_GOOD_REFUND_FAILED_RETURN_STATUS = 5;// 退货失败
	public final static int AFTER_SALE_SUB_GOOD_REFUND_FAILED_SEND_KH_RETURN_STATUS = 6;// 退货失败发货给客户
	public final static int AFTER_SALE_SUB_APPLYLD_REFUND_RETURN_STATUS = 7;// 已退款
	
	
	/************************************** 售后子表换货状态 ******************************************/
	
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_CHANGE_STATUS = 1;// 申请换货
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_STORAGE_IN_CHANGE_STATUS = 2;// 换货入库
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_SUCCESS_CHANGE_STATUS = 3;// 换货成功
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_SUCCESS_SEND_KH_CHANGE_STATUS = 4;// 换货成功发货给客户
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_FAILED_CHANGE_STATUS = 5;// 换货失败
	public final static int AFTER_SALE_SUB_APPLY_REPLACE_GOODS_FAILED_SEND_KH_CHANGE_STATUS = 6;// 换货失败发货给客户
	public final static int AFTER_SALE_SUB_APPLYLD_REFUND_CHANGE_STATUS = 6;// 已退款
	
	/************************************** 代发会员是否是黑名单 ******************************************/
	
	public final static int MEMBER_USER_IS_BLACK = 1;// 黑名单
	public final static int MEMBER_USER_IS_NOT_BLACK = 0;// 不是黑名单
	
	/************************************** 代发会员等级 ******************************************/
	
	public final static Long MEMBER_USER_VIP_LEVEL_ONE = 1L;
	public final static Long MEMBER_USER_VIP_LEVEL_TWO = 2L;
	public final static Long MEMBER_USER_VIP_LEVEL_THREE = 3L;
	public final static Long MEMBER_USER_VIP_LEVEL_FOUR = 4L;
	public final static Long MEMBER_USER_VIP_LEVEL_FIVE = 5L;
}
