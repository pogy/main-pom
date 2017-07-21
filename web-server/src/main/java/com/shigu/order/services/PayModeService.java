package com.shigu.order.services;

import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.opentae.data.mall.interfaces.OrderPayMapper;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.vo.PayModePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by whx on 2017/7/17 0017.
 */
@Service
public class PayModeService {

    @Autowired
    private PaySdkClientService paySdkClientService;

    @Autowired
    private OrderPayApplyMapper orderPayApplyMapper;

    @Autowired
    private OrderPayMapper orderPayMapper;

    /**
     * 获取支付方式页面数据
     * @param orderId
     * @param userId
     * @return 返回给PayMode页面的信息
     * @throws PayApplyException 支付异常
     * @throws JsonErrException 没找到订单对象
     */
    public PayModePageVO selPayModePageVO(Long orderId, Long userId) throws PayApplyException, JsonErrException {
        PayModePageVO payModePageVO = new PayModePageVO();
        payModePageVO.setOrderId(orderId);
        ItemOrderVO itemOrderVO = itemOrder(orderId).orderInfo();
        payModePageVO.setWebSite(itemOrderVO.getWebSite());
        payModePageVO.setTempCode(paySdkClientService.tempcode(userId));
        payModePageVO.setAmountPay(PriceConvertUtils.priceToString(itemOrderVO.getTotalFee()));
        payModePageVO.setAlipayUrl("/order/alipay.htm");
//        TODO:其他信息
        payModePageVO.setCurrentAmount("0.00");
        //TODO:支付密码
        payModePageVO.setNotSetPassword("是否设置支付密码");
        return payModePageVO;
    }

    /**
     * 支付请求
     * @param orderId 主单id
     * @param payType 支付类型
     * @return 支付链接，星座宝没有支付链接
     * @throws PayApplyException 支付申请异常
     */
    public String payApply(Long orderId, PayType payType) throws PayApplyException {
        return itemOrder(orderId).payApply(payType).getPayLink();
    }

    private com.shigu.main4.order.model.ItemOrder itemOrder(Long orderId) {
        return SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId);
    }

    /**\
     * 验证密码，错误则抛出异常
     * @param pwd 密码
     * @param userId 用户
     * @throws JsonErrException
     */
    public void checkPwd(String pwd, Long userId) throws JsonErrException {

    }

    /**
     * 检查支付状态
     * @param orderId 订单id
     * @return
     */
    public boolean checkPayed(Long orderId) {
        OrderPayApply apply = new OrderPayApply();
        apply.setOid(orderId);
        List<OrderPayApply> select = orderPayApplyMapper.select(apply);
        if (select.isEmpty()) {
            return false;
        }
        OrderPayExample payExample = new OrderPayExample();
        payExample.createCriteria().andApplyIdIn(BeanMapper.getFieldList(select, "applyId", Long.class));
        return orderPayMapper.countByExample(payExample) > 0;
    }
}
