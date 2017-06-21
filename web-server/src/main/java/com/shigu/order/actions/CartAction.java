package com.shigu.order.actions;

import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.order.services.CartService;
import com.shigu.order.vo.CartPageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("submitOrders")
    @ResponseBody
    public JSONObject submit(String childOrderIds, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        String[] split = childOrderIds.split(",");
        List<Long> cids = new ArrayList<>(split.length);
        for (String s : split) {
            try {
                cids.add(Long.valueOf(s));
            } catch (NumberFormatException ignored) {
            }
        }
        rsp.setData(cartService.submitOrders(cids, ps.getUserId()));
        return JSONObject.fromObject(rsp);
    }
}
