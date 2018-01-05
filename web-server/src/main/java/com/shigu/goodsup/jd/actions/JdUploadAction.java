package com.shigu.goodsup.jd.actions;

import com.shigu.goodsup.jd.bo.JdUploadBO;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.JdUploadService;
import com.shigu.goodsup.jd.service.JdUserInfoService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.ImgDownloadException;
import com.shigu.main4.jd.exceptions.ImgZoneException;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.vo.JdVenderBrandPubInfoVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

@Controller
public class JdUploadAction {
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    JdCategoryService jdCategoryService;
    @Autowired
    JdUploadService jdUploadService;
    @Autowired
    JdUserInfoService jdUserInfoService;

    @RequestMapping("jd/index")
    public String uploadJd(HttpSession session, JdUploadBO bo, String skus,
                           @RequestParam(value = "prop_img[]", required = false) List<String> propImg,
                           @RequestParam(value = "picUrl[]", required = false) List<String> picUrls,
                           @RequestParam(value = "sku_props[]", required = false) List<String> skuProps,
                           @RequestParam(value = "seller_cids[]",required = false) List<Long> sellerCids,
                           HttpServletRequest request,
                           Model model) throws UnsupportedEncodingException {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if(ps==null){
               throw new JdAuthFailureException();
            }
            /********************************获取京东授权信息*******************************/
            Long jdUserId = new Long(jdUserInfoService.getJdUidBySubUid(ps.getSubUserId()));

            JdUploadTmpBO tbo = BeanMapper.map(bo, JdUploadTmpBO.class);
            List<JdUploadSkuBO> sku = (List<JdUploadSkuBO>) JSONArray.toList(JSONArray.fromObject(skus), JdUploadSkuBO.class, new HashMap<String, Class>() {{
                put("sizes", JdUploadSkuBO.class);
            }});
            tbo.setSkus(sku);
            tbo.callProp_img(propImg);
            tbo.callSku_props(skuProps);
            tbo.setPicUrls(picUrls);
            tbo.setSellerCids(sellerCids);
            List<JdVenderBrandPubInfoVO> allBrand = null;
            allBrand = jdCategoryService.getAllBrand(jdUserId);

            if (allBrand == null) {
                throw new JdApiException("不是京东商家");
            }
            /********************************取商品********************************/
            JdPageItem item;
            PropsVO prop;
            try {
                item = jdUpItemService.findGoods(bo.getMid());
                if (item == null) {
                    throw new JdApiException("商品不存在");
                }
                //计算标题与卖点的长度
                if (item.getItem().getTitle() != null) {
                    item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
                }
                if (item.getItem().getSellPoint() != null) {
                    item.setSellPointLength(item.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
                }
                prop = jdUpItemService.selProps(bo.getMid(), item.getJdCid(), jdUserId, item.getItem(), allBrand);
            } catch (Exception e) {
                throw new JdApiException("商品信息异常");
            }

            try {
                jdUploadService.upload(prop, tbo, jdUserId);
            } catch (ImgZoneException e) {
                throw new JdApiException("图片空间目录创建失败");
            } catch (ImgDownloadException e) {
                throw new JdApiException("主图下载失败");
            } catch (JdNotBindException e) {
                throw new JdApiException("颜色图片生成失败");
            }
            return "jingdong/parts/success";
        } catch (JdApiException e) {
            model.addAttribute("errmsg", e.getMessage());
            return "jingdong/uperror";
        } catch (JdAuthFailureException e) {
            String queryString = request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                    (queryString == null ? "" : ("?" + queryString)), "utf-8");
        }
    }

}
