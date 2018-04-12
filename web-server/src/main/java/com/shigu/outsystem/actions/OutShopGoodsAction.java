package com.shigu.outsystem.actions;

import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：OutShopGoodsAction
 * @文件路径：com.shigu.outsystem.actions.OutShopGoodsAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/17 17:02
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class OutShopGoodsAction {
    @Autowired
    private ItemSearchService itemSearchService;


    /**
     * ====================================================================================
     * @方法名： queryOutShopGoods
     * @user gzy 2017/10/17 18:24
     * @功能：外系统登录后取商品数据
     * @param: [key, page, pageSize]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "queryOutShopGoods")
    @ResponseBody
    public JSONObject queryOutShopGoods(String key,Integer page, Integer pageSize) {

        if (StringUtils.isEmpty(key)) {
            return JsonResponseUtil.error("售后id不能空");
        }

        String shopIds=Opt3Des.decryptPlainData (key);
        Long shopId=new Long(shopIds);

        //查询shop
        List<Long> shopIdList=new ArrayList ();
        shopIdList.add (shopId);

        ShiguAggsPager shopGoods=itemSearchService.searchItem (null, "hz", null, null, shopIdList, null, null, null, null, null, SearchOrderBy.NEW, page, pageSize, true);

        //极限词过滤
        shopGoods.getContent().forEach(searchItem -> searchItem.setTitle(KeyWordsUtil.duleKeyWords(searchItem.getTitle())));


        return JSONObject.fromObject (shopGoods);

    }
}
