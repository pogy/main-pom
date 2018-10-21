package com.shigu.goodsup.shopee.actions;

import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.shopee.services.ShopeePropsService;
import com.shigu.goodsup.shopee.vo.ShopeeShowDataVO;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;

@Controller
public class ShopeePublishAction {
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    ShopeePropsService shopeePropsService;
    private static final Logger logger = LoggerFactory.getLogger(ShopeePublishAction.class);


    @RequestMapping("sp/publish")
    public String publish(Long goodsId, Long cid, Model model) throws CustomException, TbPropException {
        if(cid==null){
            //todo 获取类目列表,并指向到类目选择页
            return "redirect:changeGoodsCate.htm?id="+goodsId;
        }
        Long shopeeId=0L;
        JdPageItem item;
        try {
            item= jdUpItemService.findGoods(goodsId);
            if(item==null){
                model.addAttribute("errmsg","商品不存在");
                return "shopee/uperror";
            }
            //计算标题与卖点的长度
            if(item.getItem().getTitle()!=null){
                item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("获取商品数据异常",e);
            throw new CustomException("商品信息异常");
        }

        ShopeeShowDataVO allData=new ShopeeShowDataVO();
        allData.setItems(item);
        allData.setJdUserId(shopeeId);
//        allData.setDeliveyList(shopeePropsService.selPostModel(shopeeId));
        allData.setProps(shopeePropsService.selProps(goodsId,cid));
//        allData.setStoreCats(jdUpItemService.selShopCats(jdUserId));
        allData.setGoodsCat(shopeePropsService.selCatPath(cid));
        return "shopee/sp";
    }

    @RequestMapping("sp/getCateDatas")
    @ResponseBody
    public JSONObject getCateDatas(Long cid){
        return JsonResponseUtil.success().element("datas",shopeePropsService.selCate(cid));
    }
}
