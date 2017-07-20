package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.util.PriceConvertUtils;
import com.shigu.order.vo.PayModePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by whx on 2017/7/17 0017.
 */
@Service
public class PayModeService {

    @Autowired
    private PaySdkClientService paySdkClientService;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Resource(name = "aliPayerService")
    private PayerService aliPayerService;

    @Resource(name = "wxPayerService")
    private PayerService wxPayerService;

    @Resource(name = "xzPayerService")
    private PayerService xzPayerService;

    /**
     * 获取支付方式页面数据
     * @param orderId
     * @param userId
     * @return 返回给PayMode页面的信息
     * @throws PayApplyException 支付异常
     * @throws JsonErrException 没找到订单对象
     */
    public PayModePageVO selPayModePageVO(String orderId, Long userId) throws PayApplyException, JsonErrException {
        PayModePageVO payModePageVO = new PayModePageVO();
        payModePageVO.setOrderId(orderId);
        ItemOrder itemOrder = selItemOrder(orderId, userId);
        payModePageVO.setWebSite(itemOrder.getWebSite());
        payModePageVO.setTempCode(paySdkClientService.tempcode(userId));
        payModePageVO.setAmountPay(PriceConvertUtils.priceToString(itemOrder.getTotalFee()));
        payModePageVO.setAlipayUrl("/order/alipay.htm");
//        TODO:其他信息
        payModePageVO.setCurrentAmount("0.00");
        //TODO:支付密码
        payModePageVO.setNotSetPassword("是否设置支付密码");
        return payModePageVO;
    }

    /**
     * 获取微信支付二维码
     * @param orderId
     * @param userId
     * @return 微信支付二维码链接
     * @throws PayApplyException 支付异常
     * @throws JsonErrException 没找到订单对象
     */
    public String wxpay(String orderId, Long userId) throws PayApplyException, JsonErrException {
        ItemOrder itemOrder = selItemOrder(orderId,userId);
        return wxPayerService.payApply(itemOrder.getOid(),itemOrder.getTotalFee(),itemOrder.getTitle()).getPayLink();
    }

    //TODO:pwd星座宝支付密码实现
    /**
     * 星座宝支付
     * @param orderId
     * @param pwd 星座宝支付密码
     * @param userId
     * @throws JsonErrException 支付异常
     * @throws PayApplyException 没找到订单对象
     */
    public void xzpay(String orderId, String pwd, Long userId) throws JsonErrException, PayApplyException {
        ItemOrder itemOrder = selItemOrder(orderId, userId);
        xzPayerService.payApply(itemOrder.getOid(),itemOrder.getTotalFee(),itemOrder.getTitle());
    }

    public String alipay(Long orderId) throws PayApplyException {
        com.shigu.main4.order.model.ItemOrder itemOrder = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId);
        ItemOrderVO itemOrderVO = itemOrder.orderInfo();
        return aliPayerService.payApply(orderId,itemOrderVO.getTradePayLong(),itemOrderVO.getTitle()).getPayLink();
    }

    /**
     * 根据订单号和userId获取订单对象找不到对应的订单对象则抛出异常
     * @param orderId 订单号的字符串形式
     * @param userId
     * @return 找到的订单对象
     * @throws JsonErrException 订单记录不存在或userId不符合
     */
    private ItemOrder selItemOrder(String orderId, Long userId) throws JsonErrException {
        ItemOrder itemOrder = itemOrderMapper.selectByPrimaryKey(Long.valueOf(orderId));
        if (itemOrder == null || !Objects.equals(itemOrder.getUserId(), userId)) {
            throw new JsonErrException("没有找到对应订单信息");
        }
        return itemOrder;
    }
}
