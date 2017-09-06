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
        return "daifa/noGoodsnoOrder";
    }
    @RequestMapping("daifa/setGoodsNo")
    @ResponseBody
    public JSONObject setGoodsNo(Long childOrderId,String goodsNo) throws DaifaException {
        noGoodsnoOrderService.updateGoodsNo(childOrderId,goodsNo);
        return JsonResponseUtil.success();
    }
}
