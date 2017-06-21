package com.shigu.order.actions;

import com.shigu.order.services.CartService;
import com.shigu.order.vo.CartPageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 进货车
 * Created by bugzy on 2017/6/20 0020.
 */
@Controller
@RequestMapping("order/")
public class CartAction {

    @Autowired
    private CartService cartService;

    @RequestMapping("cart")
    public String cart(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        model.addAttribute("cart", cartService.selMyCart(ps.getUserId()));
        model.addAttribute("webSite", "hz");
        return "trade/cart";
    }
}
