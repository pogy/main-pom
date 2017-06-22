package com.shigu.order.actions;

import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.order.services.CartService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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


    /**
     * 单个删除进货车产品
     *
     * @param cid
     * @return
     */
    @RequestMapping("/order/removeChildOrder.json")
    @ResponseBody
    public JSONObject removeChildOrder(Long cid, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeChildOrder(cid);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 批量删除进货车产品
     *
     * @param cids
     * @return
     */
    @RequestMapping("/order/removeChildOrders.json")
    @ResponseBody
    public JSONObject removeChildOrders(List<Long> cids, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeAllOrders(cids);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 修改进货车产品sku
     *
     * @param cid
     * @param color
     * @param size
     * @return
     */
    @RequestMapping("/order/editChildOrderSKu.json")
    public JSONObject editChildOrderSKu(Long cid, String color, String size, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.editChildOrderSKu(cid, color, size);
        return JSONObject.fromObject(rsp);
    }

    @RequestMapping("modCartOrderNum")
    @ResponseBody
    public JSONObject modCartOrderNum(Long cid, Integer num, HttpSession session) throws JsonErrException {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.modCartOrderNum(cid, num);
        return JSONObject.fromObject(rsp);
    }
}
