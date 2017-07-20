package com.shigu.order.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.servicevo.OrderVO;
import com.shigu.order.services.MyOrderService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @类编号
 * @类名称：MyOrderAction
 * @文件路径：com.shigu.order.actions.MyOrderAction
 * @内容摘要：订单列表
 * @编码作者：gzy
 * @创建日期：2017/7/20 10:42
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
@RequestMapping("order/")
public class MyOrderAction {
    @Autowired
    MyOrderService myOrderService;

    /**
     * ====================================================================================
     * @方法名： myOrder
     * @user gzy 2017/7/20 13:00
     * @功能：
     * @param: [session, model, bo]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("myOrder")
    public String myOrder(HttpSession session, Model model, OrderBO bo){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(bo.getPageSize ()==null){
            bo.setPageSize (10);
        }
        List<OrderVO> list=myOrderService.myOrder(bo,ps.getUserId ());

        ShiguPager<OrderVO>  pager =myOrderService.selectCountMyOrder(bo,ps.getUserId ());
                model.addAttribute ("query",bo);//返回查询条件
        model.addAttribute ("orders",list);
        model.addAttribute ("pageOption",pager.selPageOption (bo.getPageSize ()));
        return "buyer/myOrder";

    }


}