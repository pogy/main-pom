package com.shigu.order.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.order.bo.ShManaOrderBo;
import com.shigu.order.services.ShManaOrderService;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.KeyWordsUtil;
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
@RequestMapping("order/")
public class ShManaOrderAction {
    @Autowired
    ShManaOrderService shManaOrderService;

    @RequestMapping("shManaOrder")
    public String shManaOrder(HttpSession session, ShManaOrderBo bo, Model model) throws ParseException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        ShiguPager<MyOrderVO> pager=shManaOrderService.selectShList(bo, userId);
        //极限词过滤
        pager.getContent().forEach(myOrderVO -> {
            if (myOrderVO.getChildOrders() != null) {
                myOrderVO.getChildOrders().forEach(subMyOrderVO -> subMyOrderVO.setTitle(KeyWordsUtil.duleKeyWords(subMyOrderVO.getTitle())));
            }
        });

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+bo.getSize()+","+pager.getNumber());
        return "fxs/shManaOrder";
    }

}
