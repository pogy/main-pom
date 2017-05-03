package com.shigu.sysman.shop.actions;

import com.opentae.data.mall.beans.ShiguMarket;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.main4.vo.ShopRegister;
import com.shigu.sysman.shop.service.PuyuanShopRegistService;
import com.shigu.sysman.shop.service.ShiguMarketService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 濮院站店铺入住审核
 * Created by Administrator on 2017/5/3 0003.
 */
@Controller
@RequestMapping("/sysman/pyshop/")
public class PuyuanShopController {
    private static final Logger logger = LoggerFactory.getLogger(PuyuanShopController.class);

    @Autowired
    private ShiguMarketService shiguMarketService;

    @Autowired
    private PuyuanShopRegistService puyuanShopRegistService;

    /**
     * 濮院店铺注册
     * @return 注册页面
     */
    @RequestMapping("openView")
    public String openView(String webSite, Model model) {
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(webSite);
        model.addAttribute("shiguMarketList" ,shiguMarketService.findShiguMarketListo(shiguMarket));
        return "sysman/shop/py_shop_register";
    }

    @RequestMapping("register")
    @ResponseBody
    public JSONObject submit(RegisterUser user, ShopRegister shop) {
        JSONObject result;
        try {
            puyuanShopRegistService.register(user, shop);
            result = JSONObject.fromObject("{'status':'success'}");
        } catch (Main4Exception e) {
            result = JSONObject.fromObject("{'status':'error','msg':'" + e.getMessage() + "'}");
        }
        return result;
    }
}
