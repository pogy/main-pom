package com.shigu.seller.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.bo.FindGoodsSelBO;
import com.shigu.seller.services.FindGoodsService;
import com.shigu.seller.vo.FindGoodsItemVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
     * 查询所有商品
     * @return
     */
    @RequestMapping("allGoodsJson")
    @ResponseBody
    public JSONObject allGoodsJson(FindGoodsSelBO bo, HttpSession session){
        int size=20;
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<FindGoodsItemVO> pager=findGoodsService.selItemsForFindGoods(bo,ps.getLogshop().getShopId(),size);
        JSONObject obj= JsonResponseUtil.success();
        obj.element("items", JSONArray.fromObject(pager.getContent()));
        obj.element("pageOption",pager.selPageOption(size));
        return obj;
    }

    /**
     * 设置商品接口
     * @return
     */
    @RequestMapping("setNewFdGoodsData")
    @ResponseBody
    public JSONObject setNewFdGoodsData(Long id,Long goodsId,HttpSession session){

        return null;
    }
}
