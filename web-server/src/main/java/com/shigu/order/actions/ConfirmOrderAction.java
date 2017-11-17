package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.BuyerAddressItemVO;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.services.CartService;
import com.shigu.order.services.ConfirmOrderService;
import com.shigu.order.services.OrderOptionSafeService;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.OrderSubmitVo;
import com.shigu.order.vo.SenderInfoVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhaohongbo on 17/6/23.
 */
@Controller
@RequestMapping("order/")
public class ConfirmOrderAction {

    @Autowired
    private ConfirmOrderService confirmOrderService;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private CartService cartService;

    @Autowired
    ItemOrderService itemOrderService;

    @Autowired
    private OrderOptionSafeService orderOptionSafeService;

    /**
     * 订单确认提交
     * @param request
     */
    @RequestMapping("confirmOrders")
    @ResponseBody
    public JSONObject confirmOrders(HttpServletRequest request, HttpSession session) throws JsonErrException {
        StringBuilder boStr = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            String s;
            while ((s = reader.readLine()) != null) {
                boStr.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long oid = confirmOrderService.confirmOrders(JSON.parseObject(boStr.toString(), ConfirmBO.class),ps.getUserId());
        String payUrl = "/order/payMode.htm?orderId=" + oid;
        return JsonResponseUtil.success().element("redectUrl", payUrl);
    }

    @RequestMapping("confirmOrder")
    public String confirmOrder(ConfirmBO bo, HttpServletRequest request, Model model) throws OrderException {
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code, OrderSubmitVo.class);
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
        List<SenderInfoVO> senderInfoVOList = confirmOrderService.senderListDefault(bo.getSenderId());
        model.addAttribute("sender", senderInfoVOList);
        if (bo.getSenderId() == null) {
            SenderInfoVO senderInfoVO = senderInfoVOList.get(0);
            bo.setSenderId(Long.valueOf(senderInfoVO.getId()));
            senderInfoVO.setChecked(true);
        }

        model.addAttribute("collList", confirmOrderService.collListByUser(userId));//收藏的地址数据

        // 商品信息
        List<CartOrderVO> vos = cartService.packCartProductVo(orderSubmitVo.getProducts()).getOrders();
        // 商品服务信息
        model.addAttribute("serviceRulers", JSON.toJSONString(confirmOrderService.serviceRulePack(vos, bo.getSenderId())));
        model.addAttribute("goodsOrders", vos);
        model.addAttribute("webSite", "hz");//站点
        model.addAttribute("code", bo.getCode());
        model.addAttribute("tbOrderAddressInfo",orderSubmitVo.getTbOrderAddressInfo());
        return "trade/confirmOrder";
    }

    @ResponseBody
    @RequestMapping("getPostRulerByProvId")
    public JSONObject getPostRulerByProvId(Long senderId, Long provId) throws JsonErrException {
        if (senderId == null) {
            return JsonResponseUtil.error("请选择代发机构");
        }
        if (provId == null) {
            return JsonResponseUtil.error("填写收货地址");
        }
        return JsonResponseUtil.success().element("postRulers", confirmOrderService.selPostRules(senderId, provId));
    }

    @ResponseBody
    @RequestMapping("deleteCollJson")
    public JSONObject deleteCollJson(Long id, HttpSession session) {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkByAddressId(ps.getUserId(),id)){
            return JsonResponseUtil.error("只能操作本用户下的地址");
        }
        itemOrderService.rmBuyerAddress(id);
        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping("collectCgneeJson")
    public JSONObject collectCgneeJson(BuyerAddressItemVO buyerAddressItem, HttpServletRequest request) throws JsonErrException {
        if(StringUtils.isEmpty(buyerAddressItem.getName())||StringUtils.isEmpty(buyerAddressItem.getAddress())
                ||StringUtils.isEmpty(buyerAddressItem.getPhone())){
            throw new JsonErrException("地址缺少必要信息");
        }
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
            addressId = itemOrderService.saveBuyerAddress(buyerAddress).toString();
        } else {
            addressId = confirmOrderService.saveTmpBuyerAddress(buyerAddress);
        }

        return JsonResponseUtil.success().element("addressId", addressId);
    }
}
