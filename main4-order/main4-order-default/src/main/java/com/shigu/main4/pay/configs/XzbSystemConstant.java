package com.shigu.main4.pay.configs;

/**
 * 类名：XzbSystemConstant
 * 类路径： com.shigu.main4.pay.configs.XzbSystemConstant
 * 创建者： whx
 * 创建时间： 8/8/18 5:12 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbSystemConstant {
    /********************************** 通用响应 *********************************/

    public final static String RESPONSE_INVALID_PARAMETER = "INVALID_PARAMETER";// 参数无效
    public final static String RESPONSE_SYSTEM_ERROR = "STSTEM_ERROR";// 系统错误

    /********************************** 临时秘钥超时时间（秒） *********************************/
    public final static Long TEMP_SECRET_TIME_OUT = 3l * 24 * 3600;

    /********************************** 公司淘宝昵称 *********************************/

    public final static String COMPANY_TAOBAO_NICK = "杭州石谷网络科技有限公司";

    /********************************** 公司支付宝 *********************************/

    public final static String COMPANY_ALIPAY_USER_ID = "web@571xz.com";
    public final static String COMPANY_ALIPAY_NICK = "杭州石谷网络科技有限公司";

    /********************************** 支付宝交易来源 *********************************/

    public final static String ALIPAY_SOURCE_TAOBAO = "TAOBAO";// 淘宝(TAOBAO)
    public final static String ALIPAY_SOURCE_ALIPAY = "ALIPAY";// 支付宝(ALIPAY)
    public final static String ALIPAY_SOURCE_OTHER = "OTHER";// 其它(OTHER)

    /********************************** 星座宝金额变动类别 *********************************/

    public final static Integer XZB_RECORD_TYPE_PAYMENT = 1;// 付款
    public final static Integer XZB_RECORD_TYPE_REFUND = 2;// 退款
    public final static Integer XZB_RECORD_TYPE_RECHARGE = 3;// 充值
    public final static Integer XZB_RECORD_TYPE_SYSTEMCHANGE = 4;// 系统调整

    /********************************** 交易记录类型 每增加一种需要到TypeEnum添加对应说明*********************************/

    public final static int PAY_TRADE_TYPE_RECHARGE = 1;// 充值
    public final static int PAY_TRADE_TYPE_BUYIN = 2;// 买入
    public final static int PAY_TRADE_TYPE_REFUND = 3;// 退款
    public final static int PAY_TRADE_TYPE_WITHDRAW = 4;// 提现
    public final static int PAY_TRADE_TYPE_SYSTEMKK = 5;// 系统扣款
    public final static int PAY_TRADE_TYPE_FIGHTGETMONEY = 6;// 打拿货款
    public final static int PAY_TRADE_TYPE_SHIPPING = 7;// 打邮费
    public final static int PAY_TRADE_TYPE_BEHALFOFFEES = 8;// 打代发货
    public final static int PAY_TRADE_TYPE_EXCHANGE = 9;// 卷兑换
    public final static int PAY_TRADE_TYPE_INVITE_REBATE = 10;// 返点


    /********************************** 交易记录扣款种类 每增加一种需要到DebitTypeEnum添加对应说明*********************************/

    public final static int PAY_TRADE_DEBIT_TYPE_ALIPAY = 1;// 支付宝扣款
    public final static int PAY_TRADE_DEBIT_TYPE_XZB = 2;// 星座宝扣款
    public final static int PAY_TRADE_DEBIT_TYPE_WEIXIN = 3;// 微信扣款
    public final static int PAY_TRADE_DEBIT_TYPE_COUPON = 4;// 抵价卷扣款
    public final static int PAY_TRADE_DEBIT_TYPE_XZBANDCOUPON = 5;// 星座宝、卷混合使用
    public final static int PAY_TRADE_DEBIT_TYPE_REDPACKCOUPON = 6;// 红包扣款
    public final static int PAY_TRADE_DEBIT_TYPE_ORDER_CASHBACK = 7;// 订单完成返现
    public final static int PAY_TRADE_DEBIT_TYPE_INVITE_REBATE = 8;// 返点


    /********************************** PAY_RECHARGE 充值类型 *********************************/

    public final static Integer PAY_RECHARGE_USER_TYPE = 1;// 用户充值
    public final static Integer PAY_RECHARGE_WEXIN_TYPE = 2;// 微信过款
    public final static Integer PAY_RECHARGE_REFUND_TYPE = 3;// 收退款
    public final static Integer PAY_RECHARGE_DFINNER_TYPE = 4;// 代发内部收款
    public final static Integer PAY_RECHARGE_VOLUMECASH_TYPE = 5;// 卷折现
    public final static Integer PAY_RECHARGE_REDPACK_TYPE = 6;// 红包充值
    public final static Integer PAY_RECHARGE_CASHBACK_TYPE = 7;// 返现
    public final static Integer PAY_RECHARGE_INVITE_REBATE_TYPE = 8;// 返点

    /********************************** work_type *********************************/
    public final static int WORK_TYPE_DAIFA_MANAGER = 1;// 代发管理
    public final static int WORK_TYPE_DAIFA_NAHUO = 2;// 代发拿货
    public final static int WORK_TYPE_STOCK = 3;// 代发仓库
    public final static int WORK_TYPE_NAHUO_ADMIN=4;//代发拿货主管
    public final static int WORK_TYPE_DAIFA_FEE=5;//代发费虚拟账户
    public final static int WORK_TYPE_POST_FEE=6;//快递费虚拟账户

    /********************************** 公司accountId *********************************/
    public static Long COMPANY_ACCOUNT_ID = 5L;// 公司accountId
    // public static Long STOCK_ACCOUNT_ID=6L;//仓库账户ID
    public static Long COMPANY_ALIPAY_ACCOUNT_ID = 4L;// 公司支付宝accountId
    public static Long COMPANY_WXPAY_ACCOUNT_ID = 11l;// 公司微信accountId
    public static Long COMPANY_VOLUME_POOL_ID=-1l;//折现池ID，取卷锁时用

    public static Long COMPANY_ALIPAY_PA_ID=3l;//公司支付宝，在PAYALIPAY里的ID



    /********************************** account 类型 *********************************/

    public final static Long ACCOUNT_TYPE_XZB = 1l;
    public final static Long ACCOUNT_TYPE_ALIPAY = 2l;
    public final static Long ACCOUNT_TYPE_WEIXIN = 3l;

    /********************************** 交易链接申请类别 *********************************/

    public final static Long PAY_TRADE_APPLY_TYPE_ALIPAY = 1L;// 支付宝
    public final static Long PAY_TRADE_APPLY_TYPE_WEIXIN = 2L;// 微信

    /********************************** 支付链接申请状态 *********************************/

    public final static Long PAY_TRADE_APPLY_INIT_STATUS = 1L;// 初始创建
    public final static Long PAY_TRADE_APPLY_ALREADY_CONSUMED_STATUS = 2L;// 已消费
    public final static Long PAY_TRADE_APPLY_ERROR_STATUS = 3L;

    /********************************** 事务相关 *********************************/
    public final static int TRANSACTION_TIMEOUT = 25;// 默认25秒

    /********************************** 支付宝支付回调交易状态 *********************************/

    public final static String ALIPAY_RESULT_TRADE_FINISHED_STATUS = "TRADE_FINISHED";// 交易完成
    public final static String ALIPAY_RESULT_TRADE_SUCCESS_STATUS = "TRADE_SUCCESS";// 交易成功

    /********************************** API命名空间 *********************************/
    public final static String URI_NAMESPACE_API = "/api/";
    public final static String URI_NAMESPACE_TESTAPI = "/testwebapi/";

    /********************************** 出账状态记录 *********************************/

    public final static Long REAL_MONEYTRADE_INIT_STATUS = 0L; // 还未调用分账
    public final static Long REAL_MONEYTRADE_WAIT_BACK_STATU = 1L;// 等待支付宝回应
    public final static Long REAL_MONEYTRADE_SUCCESS_STATUS = 2L;// 分账成功
    public final static Long REAL_MONEYTRADE_ERROR_STATUS = 3L;// 出现异常

    /********************************** 提现类型 *********************************/

    public final static String PAY_CASH_USERXZB_TYPE = "USERXZB";// 用户星座宝提现

    /********************************** 提现类型 *********************************/

    public final static String PAY_CASH_APPLY_STATUS = "CASH_APPLY";// 提现申请
    public final static String PAY_CASH_APPLY_TAKE_MONEY_STATUS = "TAKE_MONEY_APPLY";// 申请打拿货款

    /********************************** 抵价卷 状态 *********************************/

    public final static int OFFSET_VOLUME_NOT_CONSUMER_STATUS = 1;// 未消费
    public final static int OFFSET_VOLUME_ALREADY_CONSUMER_STATUS = 2;// 已消费
    public final static int OFFSET_VOLUME_TO_VOID_STATUS = 3;// 作废
    public final static int OFFSET_VOLUME_BLOCK_STATUS = 4;// 冻结

    public final static int OFFSET_VOLUME_DESTROY_STATUS=5;//销毁

    /********************************** 卷消费类型 *********************************/
    public final static Integer VOLUME_RECORD_TYPE_PAY=1;//下单
    public final static Integer VOLUME_RECORD_TYPE_ZHEREN=2;//折现给人
    public final static Integer VOLUME_RECORD_TYPE_ZHETRADE=3;//折现给订单

    /********************************** 卷状态变化类型 *********************************/
    public final static Integer VOLUME_CHANGE_TYPE_USE=1;//从未消费到消费
    public final static Integer VOLUME_CHANGE_TYPE_RESTORE=2;//从消费回到未消费

    /********************************** PayTrade的退款/货状态 *********************************/
    public final static Integer TRADE_REFUND_TYPE_REFUSE=1;//拒单
    public final static Integer TRADE_REFUND_TYPE_NOGOODS=2;//缺货
    public final static Integer TRADE_REFUND_TYPE_OWE=3;//欠货
    public final static Integer TRADE_REFUND_TYPE_CLEAR=4;//清货

    /********************************** 充值状态 *********************************/
    public final static Integer RECHARGE_SUCCESS=1;//充值完成
    public final static Integer RECHARGE_FAIL=2;//充值失败

    /********************************** 卷折现池变动记录 *********************************/
    public final static Integer VOLUME_POOL_CHANGE_IN=1;//入池
    public final static Integer VOLUME_POOL_CHANGE_OUT=2;//折现出池

    /********************************** 阿里云消息队列配置 *********************************/


    /********************************** 提现状态 *********************************/

    public final static String PAY_CASH_NORMAL_STATUS = "normal";// 一般
    public final static String PAY_CASH_ERROR_STATUS = "casherr";// 出错
    public final static String PAY_CASH_CASHED_STATUS = "cashed";// 一般

    /********************************** 收退款状态 *********************************/
    public static final Integer GET_REFUND_STATUS_READEY = 0;
    public static final Integer GET_REFUND_STATUS_ERROR = 1;
    public static final Integer GET_REFUND_STATUS_USED = 2;
//	public static final Integer GET_REFUND_STATUS_ = 0;

    /********************************** 支付宝进入类型 *********************************/

    public static final String ALIPAY_TRADE_IN_TYPE = "in";// 进账
    public static final String ALIPAY_TRADE_OUT_TYPE = "out";// 出账

    /********************************** 支付宝账户鉴权需要 *********************************/
    public static final Integer ALIPAY_NEED_AUTH = 1;
    public static final Integer ALIPAY_NEEDNT_AUTH = 0;

    /********************************** 阿里余额宝对应的账户ID值 *********************************/
    public static final String YUEBAO_ID = "2088701406502100";// == 天弘基金支付宝账号ID值，todo：换基要换值

    /********************************** 入库操作异常状态 *********************************/
    public static final Integer INSTOCK_ERROR_NOTDEAL=0;//未处理的
    public static final Integer INSTOCK_ERROR_HASDEAL=1;//代表已处理

    /********************************** 支付宝、微信即时充值标识 *********************************/

    public static final String PAY_TRADE_COMMONT_ONLINE_ALIPAY = "online_alipay";
    public static final String PAY_TRADE_COMMONT_ONLINE_WXPAY = "online_wx";

    /********************************** 支付宝、微信即时充值标识 *********************************/
    public static final String RECHARGE_METHOD_WXPAY = "微信支付";
    public static final String RECHARGE_METHOD_ALIPAY = "支付宝";

    /**********************************   对账表FROM  *******************************/
    public static String RECON_HUOFEE_CASH = "HUOFEE_CASH";
    public static String RECON_DANAHUO = "DANAHUO";

    /**********************************   税率产生类型  *******************************/
    public static int TAX_DF_BU_FEE=1;//代发补款
    public static int TAX_USER_CASH=2;//用户提现
    public static int TAX_DF_RATE=20;//代发补款利率0.2%


    /**********************************   每月用户提现免手续费部分处理数据前缀  *******************************/
    public static final String USER_CASH_UNPROCESSED_INDEX_PRIFIX = "user_cash_apply_unprocessed_prifix_"; //每月用户提现未处理部分
}
