package com.shigu.order.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.order.bo.ShManaOrderBo;
import com.shigu.order.services.MyOrderService;
import com.shigu.order.services.ShManaOrderService;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * Created by zf on 2017/7/24.
 */
@Controller
@RequestMapping({"order/","member/"})
public class ShManaOrderAction {
    @Autowired
    ShManaOrderService shManaOrderService;

    @RequestMapping("shManaOrder")
    public String shManaOrder(HttpSession session, ShManaOrderBo bo, Model model) throws ParseException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        Integer size=10;
        ShiguPager<MyOrderVO> pager=shManaOrderService.selectShList(bo.getShStatus(),bo.getPage(),size,userId);


        model.addAttribute("orders",pager.getContent());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+size+","+pager.getNumber());
        return "buyer/shManaOrder";
    }

}
