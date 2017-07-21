package com.shigu.main4.order.model.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.vo.RefundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;


/**
 * 退单
 * Created by zhaohongbo on 17/7/20.
 */
@Repository
@Scope("prototype")
public class RefundItemOrderImpl implements RefundItemOrder {

    private Long refundId;

    /**
     * 用于RefundItemOrderImpl(RefundApplyBO apply, Boolean fromUser)形式构建
     */
    private RefundApplyBO refundApplyBO;

    /**
     * 用于RefundItemOrderImpl(RefundApplyBO apply, Boolean fromUser)形式构建
     */
    private Boolean fromUser;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    public RefundItemOrderImpl(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * 退单
     * @param apply
     */
    public RefundItemOrderImpl(RefundApplyBO apply, Boolean fromUser) {
        refundApplyBO = apply;
        this.fromUser = fromUser;

    }

    @PostConstruct
    public void init() {
        if (refundApplyBO != null || fromUser != null) {
            apply(refundApplyBO,fromUser);
        }
    }

    @Override
    public RefundVO refundinfo() {
        return null;
    }

    /**
     * 退货申请
     * @param applyBO
     * @param fromUser
     * @return
     */
    @Override
    public Long apply(RefundApplyBO applyBO, Boolean fromUser) {
        ItemOrderRefund itemOrderRefund = BeanMapper.map(applyBO,ItemOrderRefund.class);
        itemOrderRefund.setUserApply(fromUser);
        itemOrderRefundMapper.insertSelective(itemOrderRefund);
        refundId = itemOrderRefund.getRefundId();
        return refundId;
    }

    /**
     * 卖家受理
     */
    @Override
    public void sellerAgree() {

    }

    /**
     * 卖家拒绝受理
     * @param reason
     */
    @Override
    public void sellerRefuse(String reason) {

    }

    /**
     * 用户已发件
     * @param buyerCourier
     */
    @Override
    public void userSended(String buyerCourier) {

    }

    /**
     * 卖家收到货
     */
    @Override
    public void sellerCached() {

    }

    /**
     * 卖家议价
     * @param money
     */
    @Override
    public void sellerProposal(Long money) {

    }

    /**
     * 买家附议
     */
    @Override
    public void buyerReprice() {

    }

    /**
     * 买家拒绝附议
     */
    @Override
    public void buyerNoReprice() {

    }

    /**
     * 修改期望金额
     * @param money
     */
    @Override
    public void modifyHopeMoney(Long money) {

    }

    /**
     * 退成功
     */
    @Override
    public void success() {

    }

    /**
     * 退失败
     * @param reason
     */
    @Override
    public void error(String reason) {

    }

    public Long getRefundId() {
        return refundId;
    }
}
