package com.shigu.seller.actions;

import com.shigu.main4.cdn.services.SimpleVideoService;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.seller.bo.GoodsVideoLinkBO;
import com.shigu.seller.services.SellerGoodsSimpleModifiedService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 类名：SellerGoodsSimpleModifiedAction
 * 类路径：com.shigu.seller.actions.SellerGoodsSimpleModifiedAction
 * 创建者：王浩翔
 * 创建时间：2017-11-14 15:53
 * 项目：main-pom
 * 描述：出售中的商品简单修改
 */
@Controller
public class SellerGoodsSimpleModifiedAction {

    @Autowired
    SellerGoodsSimpleModifiedService sellerGoodsSimpleModifiedService;
    @Autowired
    SimpleVideoService simpleVideoService;

    @RequestMapping("seller/setGoodsVideo")
    @ResponseBody
    public JSONObject setGoodsVideo(GoodsVideoLinkBO bo, HttpSession session, BindingResult bindingResult) throws JsonErrException {
        if (bindingResult.hasErrors()) {
            return JsonResponseUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        String tbUrl = bo.getGoodsVideoUrl();
        if (!simpleVideoService.isTbUrl(tbUrl)){
            return JsonResponseUtil.error("只支持使用淘宝视频地址的主图视频");
        }
        String videoUrl = bo.getGoodsVideoUrl();
        if (!simpleVideoService.isVideoUrl(videoUrl)) {
            return JsonResponseUtil.error("只支持使用mp4,webm和ogg格式的视频");
        }
        //只有供应商能修改商品视频
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shop = ps.getLogshop();
        sellerGoodsSimpleModifiedService.setGoodsVideo(shop.getShopId(),shop.getWebSite(),bo);
        return JsonResponseUtil.success();
    }
}
