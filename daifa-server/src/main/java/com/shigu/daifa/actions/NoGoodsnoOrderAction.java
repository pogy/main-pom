package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.NoGoodsnoOrderService;
import com.shigu.daifa.vo.NoGoodsnoOrder;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoGoodsnoOrderAction {
    @Autowired
    NoGoodsnoOrderService noGoodsnoOrderService;
    /**
     * ====================================================================================
     * @方法名： noGoodsnoOrder
     * @user gzy 2017/10/13 13:17
     * @功能：无货号订单
     * @param: [page, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/noGoodsnoOrder")
    public String noGoodsnoOrder(Integer page, Model model){

        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(page==null){
            page=1;
        }
        ShiguPager<NoGoodsnoOrder> pager=noGoodsnoOrderService.selNoGoodsnoOrderList(page,daifaUser.getDaifaSellerId());
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("userName",daifaUser.getDaifaUserName ());
        model.addAttribute("menu","noGoodsnoOrder.htm");//前台所要的左边菜单
        return "daifa/noGoodsnoOrder";
    }
    /**
     * ====================================================================================
     * @方法名： setGoodsNo
     * @user gzy 2017/10/13 13:18
     * @功能：设置货号
     * @param: [childOrderId, goodsNo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/setGoodsNo")
    @ResponseBody
    public JSONObject setGoodsNo(Long childOrderId,String goodsNo) throws DaifaException {

        noGoodsnoOrderService.updateGoodsNo(childOrderId,goodsNo);
        return JsonResponseUtil.success();
    }
}
