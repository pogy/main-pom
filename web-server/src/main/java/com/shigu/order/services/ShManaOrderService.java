package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
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
        List<ShowOrderVO> list=pager.getContent();
        if(list.size ()>0){
            for(int i=0;i<list.size ();i++){
                list.get (i).setTradePay (PriceConvertUtils.priceToString (list.get(i).getTradePayLong ()));
                list.get(i).setServerPay (PriceConvertUtils.priceToString (list.get(i).getServerPayLong ()));
                list.get (i).setRefundFee (PriceConvertUtils.priceToString (list.get(i).getRefundFeeLong ()));
                list.get (i).setPostPay (PriceConvertUtils.priceToString (list.get(i).getPostPayLong ()));
                list.get (i).setPayedFee (PriceConvertUtils.priceToString (list.get(i).getPayedFeeLong ()));
                List<SubOrderInfoVO> sublist=list.get (i).getChildOrders ();
                List<SubOrderInfoVO> sublist1=new ArrayList<>();
                for(SubOrderInfoVO subVo: list.get (i).getChildOrders ()){
                    subVo.setPrice (PriceConvertUtils.priceToString(subVo.getPriceLong ()));
                    subVo.setSubOrderStatus (subVo.getSubStatusenum ().status);
                    subVo.setShState(subVo.getShStateEnum()==null?0:subVo.getShStateEnum().afterSaleStatus);
                    subVo.setTkState(subVo.getTkStateEnum()==null?0:subVo.getTkStateEnum().refundType);
                    sublist1.add (subVo);
                }
                list.get (i).setChildOrders (sublist1);
                //日期
                list.get (i).setTradeTime (DateParseUtil.parseDate ("YYYY-MM-dd HH:mm:ss",list.get (i).getTradeTimed ()));

            }
        }
        return pager;
    }
}
