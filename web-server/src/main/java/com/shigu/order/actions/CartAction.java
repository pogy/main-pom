package com.shigu.order.actions;

import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.order.services.CartService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * 单个删除进货车产品
     *
     * @param childOrderId 子单id
     */
    @RequestMapping("removeChildOrder")
    @ResponseBody
    public JSONObject removeChildOrder(Long childOrderId) {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeChildOrder(childOrderId);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 批量删除进货车产品
     *
     * @param childOrderIds 子单id集合
     */
    @RequestMapping("removeAllOrders")
    @ResponseBody
    public JSONObject removeChildOrders(String childOrderIds) throws JsonErrException {
        List<Long> cids = new ArrayList<>();
        for (String s : childOrderIds.split(",")) {
            cids.add(Long.valueOf(s));
        }
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeAllOrders(cids);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 修改进货车产品sku
     *
     * @param childOrderId 子单id
     * @param color 颜色
     * @param size 尺码
     */
    @RequestMapping("editChildOrderSKu")
    @ResponseBody
    public JSONObject editChildOrderSKu(Long childOrderId, String color, String size) throws JsonErrException {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.editChildOrderSKu(childOrderId, color, size);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 修改子单商品数量
     * @param childOrderId 子单id
     * @param num 数量
     */
    @RequestMapping("editChildOrderNum")
    @ResponseBody
    public JSONObject modCartOrderNum(Long childOrderId, Integer num) throws JsonErrException {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.modCartOrderNum(childOrderId, num);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 确认订单信息
     * @param childOrderIds 子单列表
     */
    @RequestMapping("submitOrders")
    @ResponseBody
    public JSONObject submitOrders(String childOrderIds, HttpSession session) throws JsonErrException {
        List<Long> cids = new ArrayList<>();
        for (String s : childOrderIds.split(",")) {
            cids.add(Long.valueOf(s));
        }
        String code = cartService.submitOrders(
                cids,
                ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId()
        );
        return JsonResponseUtil.success().element("code", code);
    }
}
