package com.shigu.order.actions;

import com.shigu.main4.order.bo.TbOrderBO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @类编号
 * @类名称：MyTbOrderAction
 * @文件路径：com.shigu.order.actions.MyTbOrderAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 09:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
@RequestMapping("order/")
public class MyTbOrderAction {
    /**
     * ====================================================================================
     * @方法名： myTbOrder
     * @user lys 2017/7/21 09:23
     * @功能： 淘宝订单列表
     * @param: [session, model, bo]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("myTbOrder")
    public String myTbOrder(HttpSession session, Model model, TbOrderBO bo){

        return null;
    }

    //关联订单

    //手动关联
}
