package com.shigu.goodsup.sn.actions;

import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.sn.bo.SnUploadBo;
import com.shigu.goodsup.sn.bo.SnUploadSkuBo;
import com.shigu.goodsup.sn.bo.SnUploadTbo;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.shigu.goodsup.sn.service.SnUpItemService;
import com.shigu.goodsup.sn.service.SnUserInfoService;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SnUploadAction {
    @Autowired
    SnUserInfoService snUserInfoService;
    @Autowired
    SnCategoryService snCategoryService;
    @Autowired
    SnUpItemService snUpItemService;

    @RequestMapping("sn/index")
    public String upload(HttpSession session, Map<String,Object> map, SnUploadBo bo,String skus,
                         @RequestParam(value = "prop_img[]", required = false) List<String> propImg,
                         @RequestParam(value = "picUrl[]", required = false) List<String> picUrls,
                         @RequestParam(value = "sku_props[]", required = false) List<String> skuProps,
                         @RequestParam(value = "seller_cids[]",required = false) List<Long> sellerCids,HttpServletRequest request) throws CustomException{
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String SnUsername=snUserInfoService.getSnUsernameBySubUid(ps.getSubUserId());
        SnUploadTbo sbo = BeanMapper.map(bo,SnUploadTbo.class);
        List<SnUploadSkuBo> sku = (List<SnUploadSkuBo>) JSONArray.toList(JSONArray.fromObject(skus), SnUploadSkuBo.class, new HashMap<String,Class>() {{
            put("sizes", SnUploadSkuBo.class);
        }});
        sbo.setSkus(sku);
        sbo.callProp_img(propImg);
        sbo.setPicUrls(picUrls);
        sbo.setSellerCids(sellerCids);
        int total = Integer.valueOf(snCategoryService.getCategory(SnUsername).getTotalSize());
        if(total==0){
            throw new CustomException("不是苏宁商家");
        }
        SnPageItem snPageItem=snUpItemService.findGoods(bo.getMid());
        if(snPageItem==null){
            map.put("errmsg","商品不存在");
            return "suning/uperror";
        }
        if(snPageItem.getItem().getTitle()!=null){
            snPageItem.setTitleLength(snPageItem.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
        }
        if(snPageItem.getItem().getSellPoint()!=null){
            snPageItem.setSellPointLength(snPageItem.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
        }
        return "suning/part/success";
    }
}
