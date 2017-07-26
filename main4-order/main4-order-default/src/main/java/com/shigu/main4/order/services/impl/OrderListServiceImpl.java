package com.shigu.main4.order.services.impl;

import com.opentae.data.mall.beans.ItemOrderLogistics;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.enums.*;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressDetailVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderListServiceImpl
 * @文件路径：com.shigu.main4.order.services.impl.OrderListServiceImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/20 11:08
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;


    /**
     * ====================================================================================
     * @方法名：myOrder
     * @功能： 我的订单
     * @param: bo查询条件  bo一定要有所有订单，待付款，已付款，配货中，交易完成，交易关闭的标记
     * @return: 返回订单列表
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public List<ShowOrderVO> myOrder (OrderBO bo,Long userId) {

        List<ShowOrderVO> list=new ArrayList<> ();
        ShowOrderVO ovo=new ShowOrderVO ();

        for(int i=0;i<20;i++) {
            ovo.setMainState (MainOrderStatusEnum.statusOf (1).status);
            String oidString="201707200034"+i;
            Long orderId=new Long(oidString);
            ovo.setOrderId (orderId);
            ovo.setOrderPrice ("2200");
            ovo.setPayedFeeLong(2200L);
            ovo.setPostPayLong(500L);
            ovo.setRefundFeeLong (0L);
            ovo.setServerPayLong (100L);
            if((i/2)==1) {
                ovo.setIsTbOrder (false);
            }else{
                ovo.setIsTbOrder (true);
            }
            ovo.setTradePayLong (2800L);
            ovo.setTradeTimed (new Date ());
            ovo.setWebSire ("hz");
            List<SubOrderInfoVO> listsub=new ArrayList<> ();
            for(int k=0;k<3;k++) {
                SubOrderInfoVO svo=new SubOrderInfoVO();
                int p= i*10+k+1;
                svo.setChildOrderId (new Long(p));
               switch (k){
                   case 0:{
                       svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i4/270913282/TB2LQlAXB7c61BjSZFIXXcZmVXa-270913282.jpg");
                       svo.setColor ("白");
                       svo.setSize ("L");
                       svo.setGoodsId (9522391L);
                       svo.setGoodsNo ("A241 S5-P65");
                       svo.setNum (1);
                       svo.setPriceLong (6500L);
                       svo.setSubStatusenum (SubOrderStatus.statusOf (0));
                       svo.setTitle ("A241 S5-P65 2016秋冬毛线衫男装港风高领毛衣男纯色翻领毛衣");
                       break;
                   }
                   case 1:{
                       svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i3/138989925/TB2rAD4XRAkyKJjy0FeXXadhpXa_!!138989925.jpg");
                       svo.setColor ("蓝");
                       svo.setSize ("XL");
                       svo.setGoodsId (20915911L);
                       svo.setGoodsNo ("A242/WX82/P165");
                       svo.setNum (3);
                       svo.setPriceLong (16500L);
                       svo.setSubStatusenum (SubOrderStatus.statusOf (2));
                       svo.setTitle ("修身滚边设计男士帅气一粒扣西装 WX82/P165白");
                       break;
                   }
                   default:{
                       svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i3/2744642519/TB2H_0CX2AkyKJjy0FfXXaxhpXa_!!2744642519.jpg");
                       svo.setColor ("红");
                       svo.setSize ("XXL");
                       svo.setGoodsId (20918332L);
                       svo.setGoodsNo ("F088");
                       svo.setNum (2);
                       svo.setPriceLong (11000L);
                       svo.setSubStatusenum (SubOrderStatus.statusOf (1));
                       svo.setTitle ("【品质原创质检F088】秋装男夹克男风衣男外套男大码男P110控148");
                       break;
                   }
               }
                svo.setOrderId (orderId);
                listsub.add (svo);


            }
            ovo.setChildOrders (listsub);
            list.add (ovo);
        }
        return list;
    }

    /**
     * ====================================================================================
     * @方法名：分页数据
     * @功能： selectCountMyOrder
     * @param: bo查询条件，userId用户ID
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public ShiguPager<ShowOrderVO> selectCountMyOrder (OrderBO bo, Long userId) {
        ShiguPager<ShowOrderVO> pager=new ShiguPager<ShowOrderVO>();
        //totalCount+","+size+","+number;
        pager.setTotalCount (15);
        pager.setNumber (12);
        return pager;
    }

    /**
     *
     * 查询售后列表
     * @param shStatus
     * @param page
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    //todo
    public ShiguPager<ShowOrderVO> selectCountShManaOrder(ShStatusEnum shStatus, Integer page, Integer pageSize, Long userId) {
        List<ShowOrderVO> list=new ArrayList<> ();
        ShowOrderVO ovo=new ShowOrderVO ();
        for(int i=0;i<20;i++) {
            ovo.setMainState(MainOrderStatusEnum.statusOf(1).status);
            String oidString = "201707200034" + i;
            Long orderId = new Long(oidString);
            ovo.setOrderId(orderId);
            ovo.setOrderPrice("2200");
            ovo.setPayedFeeLong(2200L);
            ovo.setPostPayLong(500L);
            ovo.setRefundFeeLong(0L);
            ovo.setServerPayLong(100L);
            if ((i / 2) == 1) {
                ovo.setIsTbOrder(false);
            } else {
                ovo.setIsTbOrder(true);
            }
            ovo.setTradePayLong(2800L);
            ovo.setTradeTimed(new Date());
            ovo.setWebSire("hz");
            ovo.setMainState(4);
            List<SubOrderInfoVO> listsub = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                SubOrderInfoVO svo = new SubOrderInfoVO();
                int p = i * 10 + k + 1;
                svo.setChildOrderId(new Long(p));
                switch (k) {
                    case 0: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i4/270913282/TB2LQlAXB7c61BjSZFIXXcZmVXa-270913282.jpg");
                        svo.setColor("白");
                        svo.setSize("L");
                        svo.setGoodsId(9522391L);
                        svo.setGoodsNo("A241 S5-P65");
                        svo.setNum(1);
                        svo.setPriceLong(6500L);
                        svo.setSubStatusenum(SubOrderStatus.statusOf(0));
                        svo.setRefundId(1000L);
                        if(shStatus==null){
                            svo.setTkNum(1);
                            svo.setTkStateEnum(RefundTypeEnum.DISPOSE_REFUND);
                        }else{
                            if(shStatus==ShStatusEnum.REFUND){
                                svo.setTkNum(1);
                                svo.setTkStateEnum(RefundTypeEnum.DISPOSE_REFUND);
                            }else{
                                svo.setShTkNum(1);
                                svo.setShStateEnum(AfterSaleStatusEnum.statusOf(1));
                            }
                        }
                        svo.setTitle("A241 S5-P65 2016秋冬毛线衫男装港风高领毛衣男纯色翻领毛衣");
                        break;
                    }
                    case 1: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i3/138989925/TB2rAD4XRAkyKJjy0FeXXadhpXa_!!138989925.jpg");
                        svo.setColor("蓝");
                        svo.setSize("XL");
                        svo.setGoodsId(20915911L);
                        svo.setGoodsNo("A242/WX82/P165");
                        svo.setNum(3);
                        svo.setPriceLong(16500L);
                        svo.setSubStatusenum(SubOrderStatus.statusOf(2));
                        svo.setTitle("修身滚边设计男士帅气一粒扣西装 WX82/P165白");
                        svo.setRefundId(1000L);
                        if(shStatus==null){
                            svo.setTkNum(1);
                            svo.setShTkNum(1);
                            svo.setTkStateEnum(RefundTypeEnum.ENT_REFUND);
                        }else{
                            if(shStatus==ShStatusEnum.REFUND){
                                svo.setTkNum(1);
                                svo.setShTkNum(2);
                                svo.setTkStateEnum(RefundTypeEnum.ENT_REFUND);
                            }else{
                                svo.setShStateEnum(AfterSaleStatusEnum.statusOf(3));
                                svo.setShTkNum(2);
                            }
                        }
                        break;
                    }
                    default: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i3/2744642519/TB2H_0CX2AkyKJjy0FfXXaxhpXa_!!2744642519.jpg");
                        svo.setColor("红");
                        svo.setSize("XXL");
                        svo.setGoodsId(20918332L);
                        svo.setGoodsNo("F088");
                        svo.setNum(2);
                        svo.setPriceLong(11000L);
                        svo.setSubStatusenum(SubOrderStatus.statusOf(1));
                        svo.setTitle("【品质原创质检F088】秋装男夹克男风衣男外套男大码男P110控148");
                        svo.setRefundId(1000L);
                        if(shStatus==null){
                            svo.setShStateEnum(AfterSaleStatusEnum.statusOf(k));
                        }else{
                            if(shStatus==ShStatusEnum.REFUND){
                                svo.setTkStateEnum(RefundTypeEnum.DISPOSE_REFUND);
                            }else{
                                svo.setShStateEnum(AfterSaleStatusEnum.statusOf(k+2));
                            }
                        }
                        break;
                    }
                }
                svo.setOrderId(orderId);
                listsub.add(svo);
            }
            ovo.setChildOrders(listsub);
            list.add(ovo);
        }
        ShiguPager<ShowOrderVO> pager=new ShiguPager<ShowOrderVO>();
        pager.setNumber (page);
        pager.setContent(list);
        pager.calPages(5,pageSize);
        return pager;
    }

    /**
     * ====================================================================================
     * @方法名：removeOrder
     * @功能： 删除订单
     * @param: orderId 订单ID
     * @return: 如果大于0就删除成功
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public int removeOrder (Long orderId) {
        return 1;
    }

    /**
     * ====================================================================================
     * @方法名：取消订单
     * @功能：
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public int cancelOrder (Long orderId) {
        return 1;
    }

    /**
     * ====================================================================================
     * @方法名：selectOrderAddrInfo
     * @功能： 查询订单地址信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override public OrderAddrInfoVO selectOrderAddrInfo (Long orderId) {
        OrderAddrInfoVO addrvo = null;
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        List<LogisticsVO> logisticsVOS = orderModel.selLogisticses();
        if (logisticsVOS.size()>0) {
            addrvo = BeanMapper.map(logisticsVOS.get(0),OrderAddrInfoVO.class);
            addrvo.setPhone(logisticsVOS.get(0).getTelephone());
            addrvo.setOrderId(orderId);
        }
        return addrvo;
    }

    /**
     * ====================================================================================
     * @方法名：selectExpress
     * @功能： 查询订单的快递信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public OrderDetailExpressVO selectExpress (Long orderId) {
        OrderDetailExpressVO vo=new OrderDetailExpressVO();
        vo.setId ("446652085546");
        vo.setName ("中通快递 ");
        List<OrderDetailExpressDetailVO> detail=new ArrayList<> ();
        OrderDetailExpressDetailVO dvo=new OrderDetailExpressDetailVO();
        dvo.setOrderId (orderId);
        dvo.setDate ("2017-07-20");
        dvo.setDesc ("您的订单开始处理");
        dvo.setTime ("13:04:56");
        detail.add (dvo);

        OrderDetailExpressDetailVO dvo1=new OrderDetailExpressDetailVO();
        dvo1.setOrderId (orderId);
        dvo1.setDate ("2017-07-20");
        dvo1.setDesc ("您的订单待配货");
        dvo1.setTime ("15:55:04");
        detail.add (dvo1);

        OrderDetailExpressDetailVO dvo2=new OrderDetailExpressDetailVO();
        dvo2.setOrderId (orderId);
        dvo2.setDate ("2017-07-20");
        dvo2.setDesc ("卖家发货");
        dvo2.setTime ("16:53:28");
        detail.add (dvo2);

        OrderDetailExpressDetailVO dvo3=new OrderDetailExpressDetailVO();
        dvo3.setOrderId (orderId);
        dvo3.setDate ("2017-07-20");
        dvo3.setDesc ("您的包裹已出库");
        dvo3.setTime ("17:58:19");
        detail.add (dvo3);
        vo.setDetail (detail);
        return vo;
    }

    /**
     * ====================================================================================
     * @方法名：selectMyorder
     * @功能： 查询主订单的信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public ShowOrderVO selectMyorder (Long orderId) {
        ShowOrderVO vo=new ShowOrderVO();
        vo.setOrderCreateTimed (new Date());//创建时间
        vo.setTradeTimed (new Date());//付款时间
        vo.setDistributionDated (new Date());//分配时间
        vo.setFinishTimed (new Date ());//完成时间
        vo.setIsTbOrder (true);
        vo.setMainState (1);
        vo.setOrderId (orderId);

        return vo;
    }

    /**
     * ====================================================================================
     * @方法名：selectSubList
     * @功能： 根据主单id查询出子单列表
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public List<SubOrderInfoVO> selectSubList (Long orderId) {
        List<SubOrderInfoVO> listsub=new ArrayList<> ();

        for(int k=0;k<3;k++) {
            SubOrderInfoVO svo=new SubOrderInfoVO();
            int p= 1+k+1;
            svo.setOrderId (orderId);
            svo.setChildOrderId (new Long(p));
            switch (k){
                case 0:{
                    svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i4/270913282/TB2LQlAXB7c61BjSZFIXXcZmVXa-270913282.jpg");
                    svo.setColor ("白");
                    svo.setSize ("L");
                    svo.setGoodsId (9522391L);
                    svo.setGoodsNo ("A241 S5-P65");
                    svo.setNum (1);
                    svo.setPriceLong (6500L);
                    svo.setSubStatusenum (SubOrderStatus.statusOf (0));
                    svo.setTitle ("A241 S5-P65 2016秋冬毛线衫男装港风高领毛衣男纯色翻领毛衣");
                    break;
                }
                case 1:{
                    svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i3/138989925/TB2rAD4XRAkyKJjy0FeXXadhpXa_!!138989925.jpg");
                    svo.setColor ("蓝");
                    svo.setSize ("XL");
                    svo.setGoodsId (20915911L);
                    svo.setGoodsNo ("A242/WX82/P165");
                    svo.setNum (3);
                    svo.setPriceLong (16500L);
                    svo.setSubStatusenum (SubOrderStatus.statusOf (2));
                    svo.setTitle ("修身滚边设计男士帅气一粒扣西装 WX82/P165白");
                    break;
                }
                default:{
                    svo.setImgsrc ("https://img.alicdn.com/bao/uploaded/i3/2744642519/TB2H_0CX2AkyKJjy0FfXXaxhpXa_!!2744642519.jpg");
                    svo.setColor ("红");
                    svo.setSize ("XXL");
                    svo.setGoodsId (20918332L);
                    svo.setGoodsNo ("F088");
                    svo.setNum (2);
                    svo.setPriceLong (11000L);
                    svo.setSubStatusenum (SubOrderStatus.statusOf (1));
                    svo.setTitle ("【品质原创质检F088】秋装男夹克男风衣男外套男大码男P110控148");
                    break;
                }
            }
            svo.setOrderId (orderId);
            listsub.add (svo);


        }


        return listsub;
    }

    /**
     * ====================================================================================
     * @方法名：selectTotal
     * @功能： 根据主单查询总数
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    //todo
    @Override public OrderDetailTotalVO selectTotal (Long orderId) {
        OrderDetailTotalVO vo=new OrderDetailTotalVO();
        vo.setChildOrdersPriceLong (12300L);
        vo.setExpressPriceLong (1200L);
        vo.setOrderTotalPriceLong (15900L);
        vo.setServicePriceLong (500L);

        return vo;
    }

}
