package com.shigu.main4.order.model;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.vo.RefundProcessVO;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;

import java.util.List;

/**
 * 商品退单
 * Created by zhaohongbo on 17/7/20.
 */
public interface RefundItemOrder {
    /**
     * 退货系统
     * @return
     */
    RefundVO refundinfo();

    RefundStateEnum refundState();

    /**
     * 退货日志查询
     * @return
     */
    List<RefundProcessVO> refundLogs();

    /**
     * 查询修改当前退单状态
     * @param refundStateEnum
     */
    void refundState(RefundStateEnum refundStateEnum);
    /**
     * 退货申请
     * @param applyBO
     * @param fromUser
     * @return
     */
    Long apply(RefundApplyBO applyBO,Boolean fromUser);

    /**
     * 卖家受理
     */
    void sellerAgree();

    /**
     * 卖家拒绝受理
     * @param reason
     */
    void sellerRefuse(String reason);

    /**
     * 用户已发件
     * @param buyerCourier
     */
    void userSended(String buyerCourier);

    /**
     * 卖家收到货
     */
    void sellerCached();

    /**
     * 卖家议价
     * @param money
     */
    void sellerProposal(Long money, String msg);

    /**
     * 买家附议
     */
    void buyerReprice() throws Main4Exception;

    /**
     * 买家拒绝附议
     */
    void buyerNoReprice();

    /**
     * 修改期望金额
     * @param money
     */
    void modifyHopeMoney(Long money);

    /**
     * 退成功
     */
    void success() throws PayerException, RefundException;

    /**
     * 换货成功
     */
    void changeSuccess();
    /**
     * 退失败
     * @param reason
     */
    void error(String reason);

    Long getRefundId();

    /**
     * 退货失败
     * @param num 退失败数量
     */
    void shopRefuse(Integer num, String reason);

    /**
     * 已拿未发退款
     * @param psoid
     * @param money
     */
    void refundHasItem(Long psoid,Long money) throws PayerException, RefundException;

    /**
     * 换货完成，不进行款项操作
     */
    void finishExchange();
}
