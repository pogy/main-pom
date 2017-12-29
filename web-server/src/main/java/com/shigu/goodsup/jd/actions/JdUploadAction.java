package com.shigu.goodsup.jd.actions;

import com.shigu.goodsup.jd.bo.JdUploadBO;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.vo.JdVenderBrandPubInfoVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class JdUploadAction {
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    JdCategoryService jdCategoryService;

    @RequestMapping("jd/index")
    public String uploadJd(JdUploadBO bo, String skus,
                               @RequestParam(value = "prop_img[]",required = false)List<String> propImg,
                               @RequestParam(value = "picUrl[]",required = false)List<String> picUrls,
                               @RequestParam(value = "sku_props[]",required = false)List<String> skuProps, HttpServletRequest request,
                               Model model) throws IOException, JdAuthFailureException {
        JdUploadTmpBO tbo= BeanMapper.map(bo,JdUploadTmpBO.class);
        List<JdUploadSkuBO> sku= (List<JdUploadSkuBO>)JSONArray.toList(JSONArray.fromObject(skus),JdUploadSkuBO.class,new HashMap<String,Class>(){{put("sizes",JdUploadSkuBO.class);}});
        tbo.setSkus(sku);
        tbo.callProp_img(propImg);
        tbo.callSku_props(skuProps);
        tbo.setPicUrls(picUrls);

        Long jdUserId=2299600652L;
        List<JdVenderBrandPubInfoVO> allBrand = null;
        try {
            allBrand = jdCategoryService.getAllBrand(jdUserId);
        } catch (JdUpException e) {
            String queryString=request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl="+ URLEncoder.encode(request.getRequestURL().toString()+
                    (queryString==null?"":("?"+queryString)),"utf-8");
        }
        if(allBrand==null){
            model.addAttribute("errmsg", "不是京东商家");
            return "taobao/uperror";
        }
        /********************************取商品********************************/
        JdPageItem item;
        PropsVO prop;
        try {
            item= jdUpItemService.findGoods(bo.getMid());
            if(item==null){
                model.addAttribute("errmsg","商品不存在");
                return "taobao/uperror";
            }
            //计算标题与卖点的长度
            if(item.getItem().getTitle()!=null){
                item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
            }
            if(item.getItem().getSellPoint()!=null){
                item.setSellPointLength(item.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
            }
            prop=jdUpItemService.selProps(bo.getMid(),item.getJdCid(),jdUserId,item.getItem(),allBrand);
        } catch (Exception e) {
            model.addAttribute("errmsg","商品信息异常");
            return "taobao/uperror";
        }




        return null;
    }

}
