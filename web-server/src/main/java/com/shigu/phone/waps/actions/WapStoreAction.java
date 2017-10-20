package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppMarket;
import com.openJar.beans.app.AppShopCat;
import com.openJar.exceptions.OpenException;
import com.shigu.phone.basevo.OneShopVO;
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import com.shigu.phone.waps.service.WapPhoneStoreService;
import com.shigu.phone.waps.service.WapStoreService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapStoreAction {
    @Autowired
    private WapStoreService wapStoreService;
    @Autowired
    private WapPhoneStoreService wapPhoneStoreService;

    @RequestMapping("queryShopData")
    @ResponseBody
    public JSONObject selOneShopInfo(String webSite,Long shopId ) {
        try {
            OneShopVO oneShopVO = wapStoreService.selOneShopInfo(shopId, webSite, null);
            if (oneShopVO == null) {
                return JsonResponseUtil.error("未查询到数据");
            }
            return JsonResponseUtil
                        .success()
                        .element("shopId",oneShopVO.getShopId())
                        .element("market",oneShopVO.getMarket())
                        .element("shopNum",oneShopVO.getShopNum())
                        .element("telephone",oneShopVO.getTelephone())
                        .element("itemNum",oneShopVO.getItemNum())
                        .element("todayAdd",oneShopVO.getTodayAdd())
                        .element("starNum",oneShopVO.getStarNum())
                        .element("shopHeadUrl",oneShopVO.getShopHeadUrl());
        } catch (OpenException e) {
           return JsonResponseUtil.error(e.getErrMsg());
        }
    }

    @RequestMapping("queryShopCategory")
    @ResponseBody
    public JSONObject ShopCat( String webSite,Long shopId ,Integer index,Integer size){
        if (index == null) {
            index = 1;
        }
        if (size == null) {
            size = 30;
        }
        try {
            List<AppShopCat> appShopCats = wapStoreService.selShopCat(webSite, shopId,index,size);
            return JsonResponseUtil.success().element("cats",appShopCats);
        } catch (OpenException e) {
            return JsonResponseUtil.error("查询失败");
        }
    }

    @RequestMapping("getMarketList")
    @ResponseBody
    public JSONObject selMarketData(Long mid,String webSite)  {
        try {
            AppMarket appMarket = wapStoreService.selMarketData(mid, webSite);
            return JsonResponseUtil.success().element("market",appMarket);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg());
        }
    }

    /**
     * 查询店铺列表
     * @param keyword
     * @param webSite
     * @param index
     * @param size
     * @return
     */
    @RequestMapping("queryShopList")
    @ResponseBody
    public JSONObject shopSearch(String keyword,String webSite,Integer index, Integer size) {
        ShopSearchVO shopSearchVO = wapPhoneStoreService.shopSearch(keyword,webSite,index, size);
        if (shopSearchVO == null) {
            return JsonResponseUtil.error("未查询到数据");
        }
        return JsonResponseUtil.success().element("hasNext",shopSearchVO.getHasNext())
                                         .element("total",shopSearchVO.getTotal())
                                         .element("shops",shopSearchVO.getShops());
    }

    /**
     * 获取收藏夹店铺列表
     * @param session
     * @param index
     * @param size
     * @return
     */
    @RequestMapping("queryShopCollectList")
    @ResponseBody
    public JSONObject queryShopCollectList(HttpSession session,String webSite,Integer index,Integer size) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId si null");
        }
        StoreCollectVO storeCollectVO = wapPhoneStoreService.storeCollect(webSite, ps.getUserId(), index, size);
        if (storeCollectVO == null) {
            return JsonResponseUtil.error("未查询到数据");
        }
        return JsonResponseUtil.success().element("hasNext",storeCollectVO.getHasNext())
                .element("total",storeCollectVO.getTotal())
                .element("shops",storeCollectVO.getShops());
    }

}
