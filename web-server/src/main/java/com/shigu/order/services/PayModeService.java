package com.shigu.order.services;

import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.util.PriceConvertUtils;
import com.shigu.order.vo.PayModePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by whx on 2017/7/17 0017.
 */
@Service
public class PayModeService {

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private PaySdkClientService paySdkClientService;

    public PayModePageVO selPayModePageVO(String orderId, Long userId) throws Main4Exception {
        ItemOrderBO itemOrderBO = redisIO.get("order_id_"+orderId, ItemOrderBO.class);
        if (itemOrderBO == null || !Objects.equals(itemOrderBO.getUserId(),userId)) {
            throw new Main4Exception("没有对应订单信息");
        }
        PayModePageVO payModePageVO = new PayModePageVO();
        payModePageVO.setOrderId(orderId);
        payModePageVO.setWebSite(itemOrderBO.getWebSite());
        payModePageVO.setTempCode(paySdkClientService.tempcode(userId));
        long amountPay = 0;
        for (SubItemOrderBO subItemOrderBO: itemOrderBO.getSubOrders()) {
            amountPay += subItemOrderBO.getProductVO().getPrice() * subItemOrderBO.getNum();
        }
        payModePageVO.setAmountPay(PriceConvertUtils.priceToString(amountPay));
        //TODO:其他信息
        payModePageVO.setCurrentAmount("等待新XzPaySDK接口实现");
        payModePageVO.setAlipayUrl("获取alipayUrl");
        payModePageVO.setNotSetPassword("是否设置支付密码");
        return payModePageVO;
    }
}
