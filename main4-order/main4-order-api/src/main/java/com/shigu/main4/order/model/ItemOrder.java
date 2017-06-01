package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.OrderVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.order.vo.SubItemOrderVO;

import java.util.List;

/**
 * 商品订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrder extends Order{
    /**
     * 查询订单物流信息
     * @return 物流信息
     */
    List<LogisticsVO> selLogisticses();

    /**
     * 查订单信息
     * @return
     */
    ItemOrderVO orderInfo();

    /**
     * 查子订单信息
     * @return
     */
    List<SubItemOrderVO> subOrdersInfo();

    /**
     * 添加物流信息
     * @param logistics
     */
    void addLogistics(LogisticsVO logistics);

    /**
     * 修改物流信息
     * @param id 物流信息ID
     * @param logistics 改后的物流信息
     */
    void modifyLogistics(Long id,LogisticsVO logistics);

    /**
     * 添加包材
     * @param metarial 材料
     */
    void addPackage(MetarialVO metarial);

    /**
     * 退包材
     * @param money 退的费用
     */
    void refundPackage(Long id,Long money);

    /**
     * 添加服务数据
     * @param service 服务内容
     */
    void addService(ServiceVO service);//添加服务

    /**
     * 退服务款
     * @param id 服务ID
     * @param money 退的费用
     */
    void refundService(Long id,Long money);//退服务

    /**
     * 全单发货
     */
    void sended(String courierNumber);

    /**
     * 部分发货
     * @param logisticsId
     * @param courierNumber
     */
    void sendPart(Long logisticsId,List<Long> soids,String courierNumber);//部分发货

}
