package com.shigu.main4.pay.enums;

/**
 * 类名：XzbRefundError
 * 类路径： com.shigu.main4.pay.enums.XzbRefundError
 * 创建者： whx
 * 创建时间： 8/9/18 6:52 PM
 * 项目： main-pom
 * 描述：
 */
public enum XzbRefundError {
    NO_SUCH_TRADE("refund_001","外部交易ID对应的支付记录不存在"),NO_MONEY_TO_REFUND("refund_002","交易没有足够的金额，退款失败")
            ,NO_SUCH_VOLUME("refund_003","退款所涉及的卷已被退，退款失败"),HAS_REFUNDED("refund_004","提交的交易或子订单已经退过款"),
    VOLUME_MONEY_TOO_BIG("refund_005","子订单涉及卷金额超出传入的总金额"),VOLUME_IS_USED("refund_006","子订单涉及卷已经被退"),
    NO_MUSH_VOLUME("refund_007","没有足够的卷可退");
    private String code;
    private String msg;

    XzbRefundError(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
