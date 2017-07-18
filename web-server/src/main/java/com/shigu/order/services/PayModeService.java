package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
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

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    public PayModePageVO selPayModePageVO(String orderId, Long userId) throws Main4Exception {
        PayModePageVO payModePageVO = new PayModePageVO();
        payModePageVO.setOrderId(orderId);
        ItemOrder itemOrder = itemOrderMapper.selectByPrimaryKey(Long.valueOf(orderId));
        payModePageVO.setWebSite(itemOrder.getWebSite());
        payModePageVO.setTempCode(paySdkClientService.tempcode(userId));
        payModePageVO.setAmountPay(PriceConvertUtils.priceToString(itemOrder.getTotalFee()));
        //TODO:其他信息
        payModePageVO.setCurrentAmount("等待新XzPaySDK接口实现");
        payModePageVO.setAlipayUrl("获取alipayUrl");
        payModePageVO.setNotSetPassword("是否设置支付密码");
        return payModePageVO;
    }
}
