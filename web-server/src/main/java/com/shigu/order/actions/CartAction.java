package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.order.bo.AddCartBO;
import com.shigu.order.services.CartService;
import com.shigu.order.vo.CartChildOrderVO;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.CartPageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.ResultRetUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return "order/cart";
    }


    /**
     * 单个删除进货车产品
     *
     * @param childOrderId 子单id
     */
    @RequestMapping("removeChildOrder")
    @ResponseBody
    public JSONObject removeChildOrder(Long childOrderId, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeChildOrder(ps.getUserId(), childOrderId);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 批量删除进货车产品
     *
     * @param childOrderIds 子单id集合
     */
    @RequestMapping("removeAllOrders")
    @ResponseBody
    public JSONObject removeChildOrders(String childOrderIds, HttpSession session) throws JsonErrException {
        List<Long> cids = new ArrayList<>();
        for (String s : childOrderIds.split(",")) {
            cids.add(Long.valueOf(s));
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.removeAllOrders(ps.getUserId(), cids);
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
    public JSONObject editChildOrderSKu(Long childOrderId, String color, String size, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.editChildOrderSKu(ps.getUserId(), childOrderId, color, size);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 修改子单商品数量
     * @param childOrderId 子单id
     * @param num 数量
     */
    @RequestMapping("editChildOrderNum")
    @ResponseBody
    public JSONObject modCartOrderNum(Long childOrderId, Integer num, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        cartService.modCartOrderNum(ps.getUserId(), childOrderId, num);
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


//===================================================20170725张峰=======================================================
    /**
     * 进货车数量jsonp
     * @param session
     * @param response
     * @param callback
     * @return
     * @throws IOException
     */
    @RequestMapping("getOrderNum")
    @ResponseBody
    public String cartCount(HttpSession session, HttpServletResponse response, String callback) throws IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        int count=0;
        if(ps!=null){
            CartPageVO cart=cartService.selMyCart(ps.getUserId());
            count= cart.getOrders().stream().map(o->o.getChildOrders().size()).mapToInt(Integer::intValue).sum();
        }
        ResultRetUtil.returnJsonp(callback,"{'result':'success','orderNum':'"+count+"'}",response);
        return null;
    }

    /**
     * 加入进货车
     * @param session
     * @return
     */
    @RequestMapping("addGoodsToCart")
    @ResponseBody
    public JSONObject addGoodsToCart(HttpSession session, String goodsSku) throws IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            AddCartBO bo= JSON.parseObject(goodsSku,AddCartBO.class);
            cartService.addCartOrder(ps.getUserId(),bo.getGoodsId(),bo.getDatalist());
        } catch (IllegalStateException e) {
            return JsonResponseUtil.error("商品不存在");
        }
        return JsonResponseUtil.success();
    }

}
