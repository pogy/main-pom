package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ExpressCompanyMapper;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.services.CartService;
import com.shigu.order.services.ConfirmOrderService;
import com.shigu.order.vo.*;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zhaohongbo on 17/6/23.
 */
@Controller
@RequestMapping("order/")
public class ConfirmOrderAction {

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private ConfirmOrderService confirmOrderService;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private CartService cartService;


    /**
     * 订单确认提交
     * @param bo
     */
    @RequestMapping("confirmOrders")
    @ResponseBody
    public JSONObject confirmOrders(ConfirmBO bo) throws JsonErrException {
        Long oid = confirmOrderService.submit(bo);
        String payUrl = "/order/payMode.htm?oid="+oid;
        return JsonResponseUtil.success().element("redectUrl",payUrl);
    }


    @RequestMapping("confirmOrder")
    public String confirmOrder(ConfirmBO bo, HttpServletRequest request, Model model) throws OrderException {
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code, OrderSubmitVo.class);
        ///////////////////////////////////////////////////////////
        if (orderSubmitVo == null) {
            throw new OrderException("订单超时");
        }
        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }
        if (!Objects.equals(orderSubmitVo.getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        if (bo.getSenderId() == null) {
            bo.setSenderId(1L);
        }

        model.addAttribute("collList", confirmOrderService.collListByUser(userId));//收藏的地址数据

        List<LogisticsCompanyVO> logisticsCompanyVOS = orderConstantService.selLogistics(bo.getSenderId());//快递规则// TODO:快递对省份的支持信息没有
        model.addAttribute("postRulers", JSON.toJSONString(BeanMapper.mapList(logisticsCompanyVOS, PostRuleVO.class)));
        model.addAttribute("postNameMap", JSON.toJSONString(confirmOrderService.postNameMapper()));

        // 商品信息
        CartPageVO vo = cartService.packCartProductVo(orderSubmitVo.getProducts());
        // 商品服务信息
        model.addAttribute("serviceRulers", JSON.toJSONString(confirmOrderService.serviceRulePack(vo.getOrders(), bo.getSenderId())));
        model.addAttribute("goodsOrders", vo.getOrders());
        model.addAttribute("webSite", "hz");//站点
        return "trade/confirmOrder";
    }

    @ResponseBody
    @RequestMapping("collectCgneeJson")
    public JSONObject collectCgneeJson() {
        return JsonResponseUtil.success();
    }
}
