package com.shigu.spread.actions;

import com.shigu.spread.bo.InvitePageSearchBO;
import com.shigu.spread.services.InviteGoodsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类名：InviteGoodsActivityAction
 * 类路径： com.shigu.spread.actions.InviteGoodsActivityAction
 * 创建者： whx
 * 创建时间： 7/24/18 2:18 PM
 * 项目： main-pom
 * 描述：
 */
@Controller
public class InviteGoodsActivityAction {

    @Autowired
    private InviteGoodsActivityService inviteGoodsActivityService;

    @RequestMapping("inviteGoods")
    public String inviteGoods(InvitePageSearchBO bo, Model model) {
        model.addAttribute("query", bo);
        model.addAttribute("goodslist",inviteGoodsActivityService.getInviteGoodsList(bo));
        return "xzPage/inviteGoods";
    }

}
