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
import com.shigu.main4.order.vo.*;
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

    @Autowired
    ItemOrderService itemOrderService;

    /**
     * 订单确认提交
     * @param bo
     */
    @RequestMapping("confirmOrders")
    @ResponseBody
    public JSONObject confirmOrders(ConfirmBO bo) throws JsonErrException {
        Long oid = confirmOrderService.submit(bo);
        String payUrl = "/order/payMode.htm?orderId="+oid;
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
        List<CartOrderVO> vos = cartService.packCartProductVo(orderSubmitVo.getProducts()).getOrders();
        // 商品服务信息
        model.addAttribute("serviceRulers", JSON.toJSONString(confirmOrderService.serviceRulePack(vos, bo.getSenderId())));
        model.addAttribute("goodsOrders", vos);
        model.addAttribute("sender", confirmOrderService.senderListDefault(bo.getSenderId()));
        model.addAttribute("webSite", "hz");//站点
        return "trade/confirmOrder";
    }

    @ResponseBody
    @RequestMapping("deleteCollJson")
    public JSONObject deleteCollJson(Long id, HttpServletRequest request) {
        itemOrderService.rmBuyerAddress(id);
        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping("collectCgneeJson")
    public JSONObject collectCgneeJson(BuyerAddressItemVO buyerAddressItem, HttpServletRequest request) {

        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }

        BuyerAddressVO buyerAddress = new BuyerAddressVO();
        buyerAddress.setAddress(buyerAddressItem.getAddress());
        buyerAddress.setCityId(buyerAddressItem.getCityId());
        buyerAddress.setName(buyerAddressItem.getName());
        buyerAddress.setProvId(buyerAddressItem.getProvId());
        buyerAddress.setTelephone(buyerAddressItem.getPhone());
        buyerAddress.setTownId(buyerAddressItem.getCountyId());
        buyerAddress.setUserId(userId);

        buyerAddress.setProvince(confirmOrderService.selProvById(buyerAddress.getProvId()));
        buyerAddress.setCity(confirmOrderService.selCityById(buyerAddress.getCityId()));
        buyerAddress.setTown(confirmOrderService.selTownById(buyerAddress.getTownId()));
        String addressId;
        if (buyerAddressItem.getType().equalsIgnoreCase("1")) {//确认并且收藏
            itemOrderService.saveBuyerAddress(buyerAddress);
            addressId = buyerAddress.getAddressId().toString();
        } else {
            addressId = itemOrderService.saveTmpBuyerAddress(buyerAddress);
        }

        return JsonResponseUtil.success().element("addressId", addressId);
    }
}
