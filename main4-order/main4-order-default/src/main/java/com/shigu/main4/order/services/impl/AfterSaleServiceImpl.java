package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import com.shigu.main4.order.zfenums.UserTypeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService{
    @Override
    public SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrder(Long subOrderId) {
        SubAfterSaleSimpleOrderVO vo = new SubAfterSaleSimpleOrderVO();
        vo.setColor("红");
        vo.setGoodsNo("zf号");
        vo.setNum(11);
        vo.setPicUrl("http://www.sinaimg.cn/dy/slidenews/1_img/2015_34/2841_605918_687391.jpg");
        vo.setSize("超大号");
        vo.setSubOrderId(105L);
        vo.setRefundNum(2);
        vo.setPrice(1000L);
        return vo;
    }

    @Override
    public AfterSaleSimpleOrderVO afterSaleSimpleOrder(Long subOrderId) {
        AfterSaleSimpleOrderVO vo = new AfterSaleSimpleOrderVO();
        vo.setEndDate("2017-09-10 11:11:11");
        vo.setExpressPrice(10L);
        vo.setOrderId(105L);
        vo.setOrderPrice(100L);
        vo.setServicePrice(10L);
        vo.setTotalPrice(150L);
        return vo;
    }

    @Override
    public Long returnGoodsApply(Long subOrderId, int refundCount, String refundMoney, String refundReason, String refundDesc) {
        return 110L;
    }

    @Override
    public Long exchangeApply(Long subOrderId, String refundReason, String refundDesc) {
        return null;
    }

    @Override
    public ShStatusEnum queryAfterSaleType(Long refundId) {
       return ShStatusEnum.REFUND;
    }

    @Override
    public AfterSaleStatusVO afterSaleStatus(Long refundId) {
        AfterSaleStatusVO vo = new AfterSaleStatusVO();
        vo.setContent("卧槽");
        vo.setSubOrderId(105L);
        vo.setModifyRefundPrice(1000L);

        return vo;
    }
    @Override
    public AfterSaleInfoVO afterSaleInfo(Long refundId) {
        AfterSaleInfoVO vo = new AfterSaleInfoVO();
        vo.setRefundId(110L);
        vo.setRefundPrice(100L);
        return vo;
    }
    @Override
    public List<RefundLogVO> afterSaleApplication(Long refundId) {
        RefundLogVO vo = new RefundLogVO();
        vo.setHeadImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501154043766&di=db16bdad7bf7f7d9ee99b88af41fa1dd&imgtype=0&src=http%3A%2F%2Fpic22.photophoto.cn%2F20120309%2F0035035981764039_b.jpg");
        vo.setLogDesc("zf要去减肥啦");
        vo.setUserNick("zf");
        vo.setUserType(UserTypeEnum.BUYER);
        vo.setLogTime("2017-15-11 11:11:11");
        List<RefundLogVO> list = new ArrayList<>();
        list.add(vo);
        return list;
    }
    @Override
    public ReturnableAddressVO retrunGoodsAddress(Long refundId) {
        ReturnableAddressVO vo = new ReturnableAddressVO();
        vo.setReceiverAddress("天堂路110");
        vo.setReceiverName("zf");
        vo.setReceiverPhone("110");
        return vo;
    }
    @Override
    public List<ExpressVo> selectExpress() {
        ExpressVo vo = new ExpressVo();
        vo.setExpressId(1L);
        vo.setExpressName("申通");
        ExpressVo vo2 = new ExpressVo();
        vo2.setExpressName("饶星快递");
        vo2.setExpressId(2L);
        List<ExpressVo> list = new ArrayList<>();
        list.add(vo);
        list.add(vo2);
        return list;
    }
    @Override
    public void chooseExpress(Long refundId, Long expressId, String expressCode) {

    }

    @Override
    public ReturnableExpressInfoVO queryExpress(Long refundId) {
        return null;
    }

    @Override
    public void modifyExpress(Long refundId, Long expressId, String expressCode) {

    }

    @Override
    public ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId) {
        ReturnableExpressInfoVO vo = new ReturnableExpressInfoVO();
        vo.setExpressCode("25");
        vo.setExpressName("饶星快递");
        vo.setReturnableExpressTime(new Date().getTime());
        return vo;
    }

    @Override
    public void agreeOrRejectRefundPrice(Long refundId,boolean isAgree) {

    }

    @Override
    public AfterSaleEntVO afterEnt(Long refundId) {
        AfterSaleEntVO vo = new AfterSaleEntVO();
        vo.setAfterSeleEntDate("2017-7-11 11:11:11");
        vo.setPriceGoto("送小姐了");
        vo.setPrice(100L);

        return vo;
    }
}
