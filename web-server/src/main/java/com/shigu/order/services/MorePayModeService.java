package com.shigu.order.services;

import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.process.PayProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.order.vo.PayModePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 收款台-支付方式选择
 *
 * Created by whx on 2017/7/17 0017.
 * @author bugzy
 */
@Service
public class MorePayModeService {

    @Autowired
    private PaySdkClientService paySdkClientService;

    @Autowired
    private MemberUserMapper memberUserMapper;


    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private PayProcess payProcess;
    @Autowired
    private PayModeService payModeService;
    @Autowired
    private MemberSimpleService memberSimpleService;

    /**
     * 订单信息
     * @param orderId
     * @return
     */
    public ItemOrderVO orderInfo(Long orderId){
        return itemOrderService.orderInfo(orderId);
    }
    /**
     * 获取支付方式页面数据
     * @param orderIds
     * @param userId
     * @return 返回给PayMode页面的信息
     * @throws PayApplyException 支付异常
     */
    public PayModePageVO selPayModePageVO(List<Long> orderIds, Long userId) throws PayApplyException {
        orderIds=payModeService.checkedMyOrder(orderIds,userId);
        checkedIsPay(orderIds);
        PayModePageVO payModePageVO = new PayModePageVO();
        // 没有创建过星座宝账户的用户创建星座宝账户
        memberSimpleService.userBalanceInfo(userId);
        payModePageVO.setAmountPay(selTotalMoney(orderIds));
        payModePageVO.setAlipayUrl("/order/alipay.htm");
        payModePageVO.setCurrentAmount(String.format("%.2f", memberUserMapper.userBalance(userId) * .01));
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        payModePageVO.setNotSetPassword(memberUser.getPayPassword() == null ? "没有支付密码" : null);
        return payModePageVO;
    }

    /**
     * 支付请求
     * @param orderIds 主单id集合
     * @param payType 支付类型
     * @return 支付链接，星座宝没有支付链接
     * @throws PayApplyException 支付申请异常
     */
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(List<Long> orderIds,Long userId, PayType payType) throws PayApplyException {
        orderIds=payModeService.checkedMyOrder(orderIds,userId);
        return payProcess.payApplySome(orderIds,payType);
    }

    public String selTotalMoney(List<Long> orderIds) throws PayApplyException {
        return String.format("%.2f", orderIds.stream().map(this::orderInfo).mapToLong(ItemOrderVO::getTotalFee).sum() * .01);
    }

    private void checkedIsPay(List<Long> orderIds) throws PayApplyException {
        if(orderIds.size()==0){
            throw new PayApplyException("操作过期");
        }
        for(Long orderId:orderIds){
            Long payed = payModeService.checkPayed(orderId);
            if (payed != null) {
                throw new PayApplyException("该笔订单已经支付");
            }
        }
    }
}
