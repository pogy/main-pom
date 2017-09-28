package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemRefundLog;
import com.opentae.data.mall.beans.SubOrderSoidps;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.examples.ItemRefundLogExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.enums.RefundSubInfo;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.order.vo.RefundProcessVO;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 退单
 * Created by zhaohongbo on 17/7/20.
 */
@Service
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

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private SubOrderSoidpsMapper subOrderSoidpsMapper;

    public RefundItemOrderImpl(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * 退单
     *
     * @param apply
     */
    public RefundItemOrderImpl(RefundApplyBO apply, Boolean fromUser) {
        refundApplyBO = apply;
        this.fromUser = fromUser;

    }

    @PostConstruct
    public void init() {
        if (refundApplyBO != null || fromUser != null) {
            apply(refundApplyBO, fromUser);
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
     * 退货日志查询
     *
     * @return
     */
    @Override
    public List<RefundProcessVO> refundLogs() {
        ItemRefundLogExample example = new ItemRefundLogExample();
        example.createCriteria().andRefundIdEqualTo(refundId);
        example.setOrderByClause("create_time desc");
        List<RefundProcessVO> collect = itemRefundLogMapper.selectByExample(example).stream().map(o -> {
            RefundProcessVO vo = new RefundProcessVO();
            vo.setCreateTime(o.getCreateTime());
            vo.setFromStatus(o.getFromStatus());
            vo.setImBuyer(o.getImBuyer());
            vo.setToStatus(o.getToStatus());
            vo.setMsg(o.getMsg());
            return vo;
        }).collect(Collectors.toList());
        return collect;
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
        Boolean userShow=refundStateEnum.refundStatus==RefundStateEnum.DISPOSE_REFUND.refundStatus
                ||refundStateEnum.refundStatus==RefundStateEnum.ENT_REFUND.refundStatus
                ||refundStateEnum.refundStatus==RefundStateEnum.SELLER_REFUND.refundStatus
                ||refundStateEnum.refundStatus==RefundStateEnum.NOT_REFUND.refundStatus
                ||refundStateEnum.refundStatus==RefundStateEnum.SELLER_CACHED.refundStatus
                ||refundStateEnum.refundStatus==RefundStateEnum.SELLER_REPRICE.refundStatus;
        refund.setUserShow(!userShow);
        //卖家受理
        if(refundStateEnum.refundStatus==RefundStateEnum.DISPOSE_REFUND.refundStatus){
            refund.setRefundSubInfo(RefundSubInfo.SELLERACCPET.value);
        }else if(refundStateEnum.refundStatus==RefundStateEnum.SELLER_REPRICE.refundStatus){
            refund.setRefundSubInfo(RefundSubInfo.PRICECHANGE.value);
        }
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
    }

    private void refundStateChangeAndLog(RefundStateEnum state, String log) {
        refundStateChangeAndLog(null, state, log);
    }

    /**
     * 退单记录修改状态 & 记录 修改历史
     *
     * @param refundInfo 当前状态信息，可为null, 为null 会自助查询
     * @param state      修改后状态
     * @param log           记录日志
     */
    @Transactional(rollbackFor = Exception.class)
    public void refundStateChangeAndLog(RefundVO refundInfo, RefundStateEnum state, String log) {
        if (refundInfo == null) {
            refundInfo = refundinfo();
        }
        if (refundInfo.getRefundState() == state) {
            return;
        }
        ItemRefundLog refundLog = new ItemRefundLog();
        refundLog.setRefundId(refundInfo.getRefundId());
        refundLog.setFromStatus(refundInfo.getRefundState().refundStatus);
        refundLog.setToStatus(state.refundStatus);
        refundLog.setMsg(log == null ? state.log : log);
        Boolean imBuyer = state.imBuyer != null ? state.imBuyer
                : RefundStateEnum.SELLER_REPRICE == refundInfo.getRefundState();
        refundLog.setImBuyer(imBuyer);
        itemRefundLogMapper.insertSelective(refundLog);

        // 变更退款状态
        refundState(state);
    }


    /**
     * 退货申请
     *
     * @param applyBO
     * @param fromUser
     * @return
     */
    @Override
    public Long apply(RefundApplyBO applyBO, Boolean fromUser) {
        //是否已存在的系统退款（特殊退款类型，可退多次）
        boolean existedSystemRefund = false;
        ItemOrderRefund itemOrderRefund = null;
        //代发已拿到货退款情况另外处理
        if (applyBO.getType()==5) {
            itemOrderRefund = new ItemOrderRefund();
            itemOrderRefund.setType(applyBO.getType());
            itemOrderRefund.setSoid(applyBO.getSoid());
            itemOrderRefund = itemOrderRefundMapper.selectOne(itemOrderRefund);
            //表中已经存在记录
            if (itemOrderRefund != null) {
                itemOrderRefund.setNumber(itemOrderRefund.getNumber()+applyBO.getNumber());
                //总期望退款数
                itemOrderRefund.setHopeMoney(applyBO.getHopeMoney()+itemOrderRefund.getHopeMoney());
                itemOrderRefund.setReason(applyBO.getReason());
                itemOrderRefund.setUserApply(fromUser);
                //为了使本类型的退款能进行多次
                itemOrderRefundMapper.updateByPrimaryKeySelective(itemOrderRefund);
                existedSystemRefund = true;
            }
        }
        if (!existedSystemRefund) {
            itemOrderRefund = BeanMapper.map(applyBO, ItemOrderRefund.class);
            itemOrderRefund.setUserApply(fromUser);
            itemOrderRefundMapper.insertSelective(itemOrderRefund);
        }
        ItemRefundLog refundLog = new ItemRefundLog();
        refundLog.setRefundId(itemOrderRefund.getRefundId());
        refundLog.setFromStatus(-1);
        refundLog.setToStatus(RefundStateEnum.APPLY_REFUND.refundStatus);
        refundLog.setMsg(itemOrderRefund.getReason());
        refundLog.setImBuyer(fromUser);
        itemRefundLogMapper.insertSelective(refundLog);
        return refundId = itemOrderRefund.getRefundId();
    }

    /**
     * 卖家受理
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sellerAgree() {

        refundStateChangeAndLog(RefundStateEnum.DISPOSE_REFUND, null);
    }

    /**
     * 卖家拒绝受理
     *
     * @param reason
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sellerRefuse(String reason) {
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setRefundId(refundId);
        refund.setFailMsg(reason);
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
        refundStateChangeAndLog(RefundStateEnum.SELLER_REFUND, reason);

    }

    /**
     * 用户已发件
     *
     * @param buyerCourier
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userSended(String buyerCourier) {
        refundStateChangeAndLog(RefundStateEnum.BUYER_SEND, null);
        ItemOrderRefund orderRefund = new ItemOrderRefund();
        orderRefund.setRefundId(refundId);
        orderRefund.setBuyerCourier(buyerCourier);
        orderRefund.setBuyerReturnTime(new Date());
        orderRefund.setRefundSubInfo(RefundSubInfo.BUYERSENDED.value);
        itemOrderRefundMapper.updateByPrimaryKeySelective(orderRefund);
    }

    /**
     * 卖家收到货
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sellerCached() {
        refundStateChangeAndLog(RefundStateEnum.SELLER_CACHED, null);
    }

    /**
     * 卖家议价
     *
     * @param money
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sellerProposal(Long money, String msg) {
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setRefundId(refundId);
        refund.setSellerProposalMoney(money);
        refund.setFailMsg(msg);
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
        refundStateChangeAndLog(RefundStateEnum.SELLER_REPRICE, msg);
    }

    /**
     * 买家附议
     */
    @Override
    public void buyerReprice() throws Main4Exception {
        doRefundMoney(false);
    }

    /**
     * 买家拒绝附议
     */
    @Override
    @Transactional
    public void buyerNoReprice() {
        refundStateChangeAndLog(RefundStateEnum.BUYER_NOREPRICE, null);
    }

    /**
     * 修改期望金额
     *
     * @param money
     */
    @Override
    public void modifyHopeMoney(Long money) {

    }

    /**
     * 退货成功
     */
    @Override
    public void success() throws PayerException, RefundException {
        //验证一下退款状态是否正常
        ItemOrderRefundExample refundExample=new ItemOrderRefundExample();
        refundExample.createCriteria().andRefundIdEqualTo(refundId).andStatusEqualTo(0);
        if(itemOrderRefundMapper.countByExample(refundExample)==0){
            throw new RefundException("重复退款");
        }
        //更新退款费
        //得到退单信息
        doRefundMoney(true);
        RefundVO vo=refundinfo();
        itemOrderMapper.addRefundMoney(vo.getOid(), vo.getHopeMoney());//更新订单中的退款额
        if (vo.getSoid() != null) {
            itemOrderSubMapper.addRefundMoney(vo.getSoid(),vo.getHopeMoney());//更新订单的退款额
        }
    }


    public void changeSuccess() {
        refundStateChangeAndLog(RefundStateEnum.ENT_REFUND, null);
    }

    /**
     * 执行退钱
     *
     * @param buyerWin 买家诉求通过？
     * @throws PayerException  原路径退钱失败
     * @throws RefundException 诉求金额不满足
     */
    @Transactional(rollbackFor = Exception.class)
    public void doRefundMoney(boolean buyerWin) throws PayerException, RefundException {
        RefundVO refundinfo = refundinfo();
        if (refundinfo.getType()==5) {
            throw new RefundException("系统退款不走一般退款流程");
        }

        // 买家赢 使用 hopeMoney, 卖家赢使用 sellerProposalMoney
        Long money = buyerWin ? refundinfo.getHopeMoney() : refundinfo.getSellerProposalMoney();
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid());
        List<PayedVO> payedVOS = itemOrder.payedInfo();
        for (PayedVO payedVO : payedVOS) {
            if (payedVO.getMoney()-payedVO.getRefundMoney() >= money) {
                SpringBeanFactory.getBean(payedVO.getPayType().getService(), PayerService.class)
                        .refund(payedVO.getPayId(), money);
                refundStateChangeAndLog(refundinfo, RefundStateEnum.ENT_REFUND, null);
                ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
                itemOrderRefund.setRefundId(refundId);
                itemOrderRefund.setRefundMoney(money);
                itemOrderRefundMapper.updateByPrimaryKeySelective(itemOrderRefund);
                return;
            }
        }
        throw new RefundException(String.format(
                "支付记录中单笔数目[%s]不足以支持希望的退款数目[%d],退单号[%d]",
                StringUtils.join(BeanMapper.getFieldList(payedVOS, "money", Long.class), ','),
                money,refundId
        ));
    }

    /**
     * 退失败
     *
     * @param reason
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void error(String reason) {
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setRefundId(refundId);
        refund.setFailMsg(reason);
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
        refundStateChangeAndLog(RefundStateEnum.NOT_REFUND, reason);
    }

    public Long getRefundId() {
        return refundId;
    }

    @Override
    public void shopRefuse(Integer num) {
        ItemOrderRefund itemOrderRefund = itemOrderRefundMapper.selectByPrimaryKey(refundId);
        if (itemOrderRefund.getFailNumber() >= num) {
            return;
        }
        //本次售后退货全失败
        boolean allRefundFailIs = itemOrderRefund.getNumber() <= num;
        itemOrderRefund.setFailNumber(allRefundFailIs?itemOrderRefund.getNumber():num);
        itemOrderRefund.setRefundSubInfo(RefundSubInfo.WORKING.value);
        itemOrderRefundMapper.updateByPrimaryKeySelective(itemOrderRefund);
        ItemRefundLog refundLog = new ItemRefundLog();
        refundLog.setRefundId(this.refundId);
        refundLog.setFromStatus(this.refundinfo().getRefundState().refundStatus);
        refundLog.setToStatus(this.refundinfo().getRefundState().refundStatus);
        refundLog.setImBuyer(false);
        refundLog.setCreateTime(new Date());
        refundLog.setMsg("档口退货失败["+num+"]件");
        itemRefundLogMapper.insertSelective(refundLog);
        if (allRefundFailIs) {
            String failMessage = "退货全部失败";
            error(failMessage);
        }

    }

    @Override
    public void refundHasItem(Long psoid, Long money) throws PayerException, RefundException {
        RefundVO refundinfo = refundinfo();
        if (refundinfo.getType()!=5) {
            throw new RefundException("一般退款不经过系统退款流程");
        }
        SubOrderSoidps subOrderSoidps = subOrderSoidpsMapper.selectByPrimaryKey(psoid);
        if (subOrderSoidps.getAlreadyRefund() != null && subOrderSoidps.getAlreadyRefund()) {
            throw new RefundException(String.format("子单%d已经进行过退款", psoid));
        }
        subOrderSoidps.setAlreadyRefund(true);
        subOrderSoidpsMapper.updateByPrimaryKey(subOrderSoidps);
        for (PayedVO payedVO : SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid()).payedInfo()) {
            if (payedVO.getMoney() - payedVO.getRefundMoney() >= money) {
                SpringBeanFactory.getBeanByName(payedVO.getPayType().getService(),PayerService.class).refund(payedVO.getPayId(),money);
                refundStateChangeAndLog(refundinfo, RefundStateEnum.ENT_REFUND, "系统退款成功");
                ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
                itemOrderRefund.setRefundId(refundinfo.getRefundId());
                //退钱数
                itemOrderRefund.setRefundMoney(refundinfo.getRefundMoney()+money);
                //本种类型特殊处理，退成功后用failnum记录退成功数量
                itemOrderRefund.setFailNumber(refundinfo.getFailNumber()+1);
                itemOrderRefundMapper.updateByPrimaryKeySelective(itemOrderRefund);
                itemOrderMapper.addRefundMoney(refundinfo.getOid(),money);
                if (refundinfo.getSoid() != null) {
                    itemOrderSubMapper.addRefundMoney(refundinfo.getSoid(),money);
                }
            }
        }
    }
}
