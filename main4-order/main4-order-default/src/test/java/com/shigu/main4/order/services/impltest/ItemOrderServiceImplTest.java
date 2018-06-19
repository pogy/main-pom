package com.shigu.main4.order.services.impltest;

import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradeGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradeGetResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

/**
 *
 * Created by bugzy on 2017/6/9 0009.
 */
public class ItemOrderServiceImplTest extends BaseTest {

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;


    @Test
    public void tbTradeTest() throws ApiException {
        //68696519672056301
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "21720662", "dc0130db87142f81cb85374baeb2f285");
        TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
        req.setFields("tid,type,status,payment,receiver_name,receiver_state,receiver_city,receiver_address");
        req.setTid(68696519672056301L);
        TradeFullinfoGetResponse rsp = client.execute(req, "62012233596b8ddc8dbc2fb689616acegd5d088dbf899df774940274");
        System.out.println(rsp.getBody());
    }

    @Test
    public void testOrder() {
        ItemProduct bean = SpringBeanFactory.getBean(ItemProduct.class, 20940313L,"白条", "L");
        show(bean.info());
    }
    @Test
//    @Transactional
    public void createOrder() throws Exception {

        ItemOrderBO orbo = new ItemOrderBO();
        orbo.setWebSite("hz");
        orbo.setSenderId(1L);
        Long order = itemOrderService.createOrder(orbo);

        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, order);
        show(itemOrder.orderInfo());
        // 如果订单创建异常，调用订单信息会发生错误
    }

    @Test
    public void selBuyerAddress() {
        itemOrderService.selBuyerAddress(1L);
    }

    @Test
    public void saveBuyerAddress() throws JsonErrException {
        BuyerAddressVO buyerAddressVO = getBuyerAddressVOInstance(1L,1L,"浙江",1L,"杭州",1L,"拱墅",
                "湖州街",1L,"151xxxxxxxx","zip_code","王浩翔");
        try {
            itemOrderService.saveBuyerAddress(buyerAddressVO);
        } catch (JsonErrException e) {
            e.printStackTrace();
        }
        BuyerAddressVO buyerAddressVO1 = getBuyerAddressVOInstance(1L,null,"浙江",1L,"杭州",1L,"拱墅",
                "湖州街",1L,"151xxxxxxxx","zip_code","王浩翔");
        try {
            itemOrderService.saveBuyerAddress(buyerAddressVO1);
        } catch (JsonErrException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rmBuyerAddress() {
        itemOrderService.rmBuyerAddress(8L);
    }

    private BuyerAddressVO getBuyerAddressVOInstance(Long addressId, Long provId, String province, Long cityId, String city, Long townId, String town,
                                                     String address, Long userId, String telephone, String zipCode, String name) {
        BuyerAddressVO buyerAddressVO = new BuyerAddressVO();
        buyerAddressVO.setAddressId(addressId);
        buyerAddressVO.setProvId(provId);
        buyerAddressVO.setProvince(province);
        buyerAddressVO.setCityId(cityId);
        buyerAddressVO.setCity(city);
        buyerAddressVO.setTownId(townId);
        buyerAddressVO.setTown(town);
        buyerAddressVO.setAddress(address);
        buyerAddressVO.setUserId(userId);
        buyerAddressVO.setTelephone(telephone);
        buyerAddressVO.setZipCode(zipCode);
        buyerAddressVO.setName(name);
        return buyerAddressVO;
    }
    @Test
    public void expressLog() throws Main4Exception, ParseException {
        List<ExpressLogVO> logVOList = itemOrderService.expressLog(5L);
        if (logVOList.size()==0){
            System.out.println("没有快递信息");
        }
        for (ExpressLogVO vo:logVOList){
            System.out.println(vo.getLogDate()+"    "+vo.getLogTime()+"   "+vo.getLogWeek());
            System.out.println(vo.getLogDesc());
        }
    }
    @Test
    public void orderLog(){
        List<OrderLogVO> vos = itemOrderService.orderLog(1L);
        for (OrderLogVO vo:vos){
            System.out.println(vo.getStateTime()+"    "+vo.getOrderState());
        }
    }


}