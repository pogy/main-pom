package com.shigu.main4.order;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ItemOrderSender;
import com.opentae.data.mall.beans.OrderConstant;
import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.opentae.data.mall.interfaces.OrderConstantMapper;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.OrderConstantVo;
import com.shigu.main4.order.vo.ServiceVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 初始化测试数据
 * Created by bugzy on 2017/6/9 0009.
 */
public class InitTestDate extends BaseTest {

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;

    @Autowired
    private OrderConstantMapper orderConstantMapper;

    @Test
    public void init() {

        // 创建 sender
        ItemOrderSender sender = new ItemOrderSender();
        sender.setSenderName("星帮代发");
        sender.setTopic("XB");
        sender.setType(1);
        itemOrderSenderMapper.insertSelective(sender);

        Long senderId = sender.getSenderId();
        show(senderId);

        // 初始化常量信息
        // 初始化一个服务
        ServiceVO serviceVO = new ServiceVO();
        serviceVO.setId(1L);
        serviceVO.setName("代发服务");
        serviceVO.setPrice(100L);
        serviceVO.setDetail("货品一件代发服务由星帮提供服务。");
        show(initConstants(senderId, OrderConstantService.SERVICE_TYPE, "星帮代发", serviceVO));

        // 初始化一个包材
        MetarialVO metarialVO = new MetarialVO();
        metarialVO.setId(1L);
        metarialVO.setName("霸王飞机盒加厚");
        metarialVO.setPrice(700L);
        metarialVO.setSize("480X680X220MM");
        show(initConstants(senderId, OrderConstantService.PACKAGE_TYPE, "飞机盒", metarialVO));


    }

    private Long initConstants(Long senderId, int type, String name, OrderConstantVo vo) {
        OrderConstant constant = new OrderConstant();
        constant.setType(type);
        constant.setName(name);
        constant.setSenderId(senderId);
        constant.setContext(JSON.toJSONString(vo));
        orderConstantMapper.insertSelective(constant);
        return constant.getId();
    }
}
