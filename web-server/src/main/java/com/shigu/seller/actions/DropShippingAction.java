package com.shigu.seller.actions;


import com.shigu.helpcenter.vo.Query;
import com.shigu.seller.services.DropShippingOrderServices;
import com.shigu.seller.vo.DfQuery;
import com.shigu.seller.vo.OrderGoodsVo;
import com.shigu.seller.vo.OrdersVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.actions
 * @ClassName: DropShippingAction
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 16:08
 */

@RequestMapping("seller/")
public class DropShippingAction {

    @Autowired
    private DropShippingOrderServices dropShippingOrderServices;

    @RequestMapping("myOrder")
    public String myOrder(DfQuery query , HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<OrdersVo> ordersVos = dropShippingOrderServices.shopDropShippingOrder(ps.getLogshop().getShopId(),query.getOrderId(),query.getGoodsNo());
        model.addAttribute("orders",ordersVos);
        model.addAttribute("query",query);
        return null;
    }

    @RequestMapping("distributionOrder")
    public String distributionOrder(DfQuery query , HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<OrderGoodsVo> orderGoods = dropShippingOrderServices.shopDropShippingGoods(ps.getLogshop().getShopId(),query.getGoodsNo());
        model.addAttribute("orderGoods",orderGoods);
        model.addAttribute("query",query);
        return null;
    }
}
