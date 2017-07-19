package com.shigu.main4.order.services.impltest;

import com.opentae.data.mall.beans.ItemOrderSender;
import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
}