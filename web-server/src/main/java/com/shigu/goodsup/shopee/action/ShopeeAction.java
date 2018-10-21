package com.shigu.goodsup.shopee.action;

import com.shigu.configBean.MainSiteConfig;
import com.shigu.goodsup.shopee.service.ShopeeService;
import com.shigu.search.actions.PageErrAction;
import com.shigu.upload.shopee.sdk.response.ShopeeGetShopInfoResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类名：ShopeeAction
 * 类路径： com.shigu.goodsup.shopee.action.ShopeeAction
 * 创建者： whx
 * 创建时间： 10/21/18 1:29 PM
 * 项目： main-pom
 * 描述： 虾皮平台一键上传
 */
@Controller
@RequestMapping("shopee/")
public class ShopeeAction {

    @Autowired
    private ShopeeService shopeeService;

    @Autowired
    private MainSiteConfig mainSiteConfig;

    @Autowired
    private PageErrAction pageErrAction;

    @RequestMapping("login")
    public String login(String backUrl) {
        String toUrl = "";
        if (StringUtils.isNotBlank(backUrl)) {
            toUrl = backUrl;
        }
        shopeeService.authorUrl(mainSiteConfig.getMainSiteDomain() + "shopee/callback.htm?backUrl=" + toUrl)
    }

    @RequestMapping("callback")
    public String callback(Long shop_id, String backUrl, Model model) {
        if (shop_id == null) {
            return pageErrAction.pageErr("授权失败", model);
        }
        ShopeeGetShopInfoResponse shopInfo = shopeeService.shopeeShopInfo(shop_id);
        if (!shopInfo.isSuccess()) {
            return pageErrAction.pageErr(shopInfo.getErrorDescription(), model);
        }
        shopInfo.get

    }
}
