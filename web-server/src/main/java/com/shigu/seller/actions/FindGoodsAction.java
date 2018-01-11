package com.shigu.seller.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.seller.bo.FindGoodsSelBO;
import com.shigu.seller.services.FindGoodsService;
import com.shigu.seller.vo.FindGoodsItemVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

/**
 * 发现好货商户中心操作
 * Created by zhaohongbo on 17/5/27.
 */
@Controller
@RequestMapping("seller")
public class FindGoodsAction {

    @Autowired
    FindGoodsService findGoodsService;

    /**
     * 发现好货活动广告设置
     * @return
     */
    @RequestMapping("findGoodsChange")
    public String findGoodsChange(HttpSession session, Model model) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        model.addAttribute("myFindTerms",findGoodsService.termVOs(ps.getLogshop().getShopId()));
        return "seller/findGoodsChange";
    }

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping("allGoodsJson")
    @ResponseBody
    public JSONObject allGoodsJson(FindGoodsSelBO bo, HttpSession session){
        int size=5;
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        ShiguPager<FindGoodsItemVO> pager=findGoodsService.selItemsForFindGoods(bo, logshop.getShopId(), logshop.getWebSite(), size);
        JSONObject obj= JsonResponseUtil.success();
        //极限词过滤
        obj.element("items", JSONArray.fromObject(pager.getContent()
                .stream().peek(findGoodsItemVO -> findGoodsItemVO.setTitle(KeyWordsUtil.duleKeyWords(findGoodsItemVO.getTitle()))).collect(Collectors.toList())));
        obj.element("pageOption",pager.selPageOption(size));
        return obj;
    }

    /**
     * 设置商品接口
     * @return
     */
    @RequestMapping("setNewFdGoodsData")
    @ResponseBody
    public JSONObject setNewFdGoodsData(Long termId,Long id,Long goodsId,HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            findGoodsService.setGoods(termId,id,goodsId,ps.getLogshop().getShopId());
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }
}
