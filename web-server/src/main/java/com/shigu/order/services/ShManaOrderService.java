package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.order.vo.SubMyOrderVO;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2017/7/24.
 */
@Service("tae_shManaOrderService")
public class ShManaOrderService {
    @Autowired
    OrderListService orderListService;

    public ShiguPager<ShowOrderVO> selectShList(Integer shStatus,Integer page,Integer size,Long userId) throws ParseException {
        if(page==null){
            page=1;
        }
        ShStatusEnum e=null;
        if(shStatus!=null){
            e=ShStatusEnum.statusOf(shStatus);
        }
        ShiguPager<ShowOrderVO> pager=orderListService.selectCountShManaOrder(e,page,size,userId);
        List<MyOrderVO> vos=new ArrayList<>();
        for(ShowOrderVO show:pager.getContent()){
            MyOrderVO vo=new MyOrderVO();
            vo.setIsTbOrder(show.getIsTbOrder());
            vo.setMainState(show.getMainState().status);
            vo.setOrderId(show.getOrderId());
            vo.setPostPay(PriceConvertUtils.priceToString (show.getPostPrice()));
            vo.setServerPay(PriceConvertUtils.priceToString(show.getServerPrice()));
            vo.setTradePay(PriceConvertUtils.priceToString(show.getServerPrice()+show.getOrderPrice()+show.getPostPrice()));
            vo.setTradeTime(DateUtil.dateToString(show.getPayTime(),DateUtil.patternD));
            vo.setWebSite(show.getWebSite());
            List<SubMyOrderVO> subs=new ArrayList<>();
            for(SubOrderInfoVO so:show.getChildOrders()){
                SubMyOrderVO sub=new SubMyOrderVO();
                sub.setChildOrderId(so.getSubOrderId());
                sub.setColor(so.getColor());
                sub.setGoodsId(so.getGoodsId());
                sub.setGoodsNo(so.getGoodsNo());
                sub.setImgsrc(so.getImgsrc());
                sub.setNum(so.getNum());
                sub.setPrice(PriceConvertUtils.priceToString(so.getPrice()));
                sub.setRefundId(so.getRefundId());
                sub.setShState(so.getShState().afterSaleStatus);
                sub.setShTkNum(so.getShTkNum());
                sub.setSize(so.getSize());
                sub.setTitle(so.getTitle());
                sub.setTkNum(so.getTkNum());
                sub.setTkState(so.getTkState().refundStatus==2?1:0);
                subs.add(sub);
            }
            vo.setChildOrders(subs);
            vos.add(vo);
        }
        ShiguPager<MyOrderVO> v=new ShiguPager<>();
        v.setNumber(pager.getNumber());
        v.setContent(vos);
        v.setTotalCount(pager.getTotalCount());
        v.setTotalPages(pager.getTotalPages());
        return v;
    }
}
