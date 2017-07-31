package com.shigu.main4.order.services.impltest;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.services.TaoOrderService;
import com.shigu.main4.order.servicevo.RelationGoodsVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2017/7/27.
 */
public class TaoOrderServiceImplTest extends BaseTest{

    @Autowired
    private TaoOrderService taoOrderService;

    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Test
    public void myTbSessionKey() throws NotFindSessionException {
        String s = taoOrderService.myTbSessionKey(14233L);
    }
    @Test
    public void myTbOrders() throws ParseException, NotFindSessionException {

        TbOrderBO bo=new TbOrderBO();
        bo.setPage(1);
//        bo.setStatus(TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = format.parse("2017-7-12 12:23:22");
        bo.setStartTime(startTime);
        ShiguPager<TbOrderVO> pager = taoOrderService.myTbOrders(bo, taoOrderService.myTbSessionKey(35858L));
        JSONObject jsonObject = JSONObject.fromObject(pager);
        System.out.println(jsonObject);
    }
    @Test
    public void myTbOrders2(){
        TbOrderVO tbOrderVO = taoOrderService.myTbOrder(39848808246968788L, TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS, "6201605eee8d5ZZb82egc317656133967bab008975ec7d4796018733");
        JSONObject jsonObject = JSONObject.fromObject(tbOrderVO);
        System.out.println(jsonObject);
    }
    @Test
    public void glGoodsJson() throws NotFindRelationGoodsException {
        RelationGoodsVO vo = taoOrderService.glGoodsJson(550481689592L);
        JSONObject jsonObject = JSONObject.fromObject(vo);
        System.out.println(jsonObject);
    }
    @Test
    public void glGoodsJson2() throws NotFindRelationGoodsException {
        RelationGoodsVO vo = taoOrderService.glGoodsJson(550481689592L, 20434858L);
        JSONObject jsonObject = JSONObject.fromObject(vo);
        System.out.println(jsonObject);
    }

}
