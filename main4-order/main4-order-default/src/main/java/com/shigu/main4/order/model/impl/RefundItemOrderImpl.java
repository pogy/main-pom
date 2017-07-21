package com.shigu.main4.order.model.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemRefundLog;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemRefundLogMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.enums.RefundStateEnum;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.enums.RefundMsgEnum;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


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

    @Autowired
    private ItemRefundLogMapper itemRefundLogMapper;

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
        ItemOrderRefund refund = itemOrderRefundMapper.selectByPrimaryKey(refundId);
        RefundVO refundVO = BeanMapper.map(refund, RefundVO.class);
        refundVO.setRefundState(RefundStateEnum.statusOf(refund.getStatus()));
        return refundVO;
    }

    @Override
    public RefundStateEnum refundState() {
        return refundinfo().getRefundState();
    }

    /**
     * 查询修改当前退单状态
     *
     * @param refundStateEnum
     */
    @Override
    public void refundState(RefundStateEnum refundStateEnum) {
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setRefundId(refundId);
        refund.setStatus(refundStateEnum.refundStatus);
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
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
    @Transactional(rollbackFor = Exception.class)
    public void sellerAgree() {
        ItemRefundLog itemRefundLog = new ItemRefundLog();
        ItemOrderRefund selectedFields = getSelectedFields("refund_id,status");
        itemRefundLog.setFromStatus(selectedFields.getStatus());
        itemRefundLog.setRefundId(refundId);
        itemRefundLog.setToStatus(1);
        selectedFields.setStatus(1);
        itemRefundLog.setImBuyer(false);
        itemRefundLog.setMsg(RefundMsgEnum.SELLER_AGREE.toString());
        itemOrderRefundMapper.updateByPrimaryKeySelective(selectedFields);
        itemRefundLogMapper.insert(itemRefundLog);
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
    public void success() throws PayerException, RefundException {
        RefundVO refundinfo = refundinfo();
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid());
        List<PayedVO> payedVOS = itemOrder.payedInfo();
        for (PayedVO payedVO : payedVOS) {
            if (payedVO.getMoney() >= refundinfo.getHopeMoney()) {
                SpringBeanFactory.getBean(PayerService.class, payedVO.getPayType().getService())
                        .refund(payedVO.getPayId(), refundinfo.getHopeMoney());

                ItemRefundLog refundLog = new ItemRefundLog();
                refundLog.setRefundId(refundinfo.getRefundId());
                refundLog.setFromStatus(refundState().refundStatus);
                refundLog.setToStatus(RefundStateEnum.ENT_REFUND.refundStatus);
                refundLog.setMsg(refundinfo.getReason());
                itemRefundLogMapper.insertSelective(refundLog);

                // 变更退款状态
                refundState(RefundStateEnum.ENT_REFUND);
                return;
            }
        }
        throw new RefundException(String.format(
                "支付记录中单笔数目[%s]不足以支持希望的退款数目[%d]",
                StringUtils.join(BeanMapper.getFieldList(payedVOS, "money", Long.class), ','),
                refundinfo.getHopeMoney()
        ));
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

    /**
     * 获取包含指定字段信息的ItemOrderRefund对象
     * @param fields
     * @return
     */
    private ItemOrderRefund getSelectedFields(String fields) {
        return itemOrderRefundMapper.selectFieldsByPrimaryKey(refundId, FieldUtil.codeFields(fields));
    }
}
