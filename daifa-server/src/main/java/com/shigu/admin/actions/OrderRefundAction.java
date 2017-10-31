package com.shigu.admin.actions;

import com.shigu.admin.bo.OrderRefundBO;
import com.shigu.admin.services.OrderRefundService;
import com.shigu.admin.vo.OrderRefundVO;
import com.shigu.config.DaifaSessionConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderRefundAction
 * @文件路径：com.shigu.admin.actions.OrderRefundAction
 * @内容摘要：退款处理
 * @编码作者：gzy
 * @创建日期：2017/9/12 17:43
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class OrderRefundAction {
    @Autowired
    OrderRefundService orderRefundService;

    @RequestMapping("admin/orderRefundList")
    public String orderRefundList(OrderRefundBO bo, Model model) throws InterruptedException {
        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<OrderRefundVO> list=null;
        if(bo.getDfTradeId ()==null&&bo.getSuborderId ()==null){

            list = new ArrayList<> ();
        }else {
            list = orderRefundService.refundOrderPage(bo);
            bo.setCount (list.size ());
        }
        if(bo.getCount ()==null){
            bo.setCount (1);
        }
        if(bo.getPage ()==null){
            bo.setPage (1+"");
        }

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", list);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);
        return "admin/orderRefundList";

    }
}
