package com.shigu.goodsup.sn.actions;

import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.sn.bo.SnUploadBo;
import com.shigu.goodsup.sn.bo.SnUploadSkuBo;
import com.shigu.goodsup.sn.bo.SnUploadTbo;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.shigu.goodsup.sn.service.SnUpItemService;
import com.shigu.goodsup.sn.service.SnUploadService;
import com.shigu.goodsup.sn.service.SnUserInfoService;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.tools.OssIO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.suning.api.util.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
    @Autowired
    SnUploadService snUploadService;

    private OssIO ossIO;

    @RequestMapping("sn/index")
    public String upload(HttpSession session, Map<String,Object> map, SnUploadBo bo,String skus,
                         @RequestParam(value = "prop_img[]", required = false) List<String> propImg,
                         @RequestParam(value = "picUrl[]", required = false) List<String> picUrls,
                         @RequestParam(value = "sku_props[]", required = false) List<String> skuProps,
                         @RequestParam(value = "seller_cids[]",required = false) List<Long> sellerCids,HttpServletRequest request) throws UnsupportedEncodingException{
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String SnUsername=snUserInfoService.getSnUsernameBySubUid(ps.getSubUserId());
        SnUploadTbo sbo = BeanMapper.map(bo,SnUploadTbo.class);
        List<SnUploadSkuBo> sku = (List<SnUploadSkuBo>) JSONArray.toList(JSONArray.fromObject(skus), SnUploadSkuBo.class, new HashMap<String,Class>() {{
            put("sizes", SnUploadSkuBo.class);
        }});
        sbo.setSkus(sku);
        sbo.callProp_img(propImg);
        sbo.callSku_props(skuProps);
        sbo.setPicUrls(picUrls);
        sbo.setSellerCids(sellerCids);
        String errorMsg=null;
        String numIid=null;
        try {
            int total = Integer.valueOf(snCategoryService.getCategory(SnUsername).getTotalSize());
            if (total == 0) {
                throw new CustomException("不是苏宁商家");
            }
            SnPageItem snPageItem = snUpItemService.findGoods(bo.getMid());
            if (snPageItem == null) {
                map.put("errmsg", "商品不存在");
                return "suning/uperror";
            }
            if (snPageItem.getItem().getTitle() != null) {
                snPageItem.setTitleLength(snPageItem.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
            }
            if (snPageItem.getItem().getSellPoint() != null) {
                snPageItem.setSellPointLength(snPageItem.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
            }
            numIid = snUploadService.upload(SnUsername, sbo);
        }catch (AuthOverException e){
            String queryString = request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=8&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                    (queryString == null ? "" : ("?" + queryString)), "utf-8");
        }catch (CustomException e){
            errorMsg=e.getMessage();
        }
        map.put("numIid",numIid);
        map.put("errorMsg",errorMsg);
        return "suning/parts/success";
    }

    @RequestMapping("sn/imgToOss")
    @ResponseBody
    public JSONObject imgOss(String url){

        ossIO.uploadFile();
        return JsonResponseUtil.success().element("canbeUploaded",canbeUploaded);
    }

    public static byte[] getImageFromURL(String urlPath) {
        byte[] data = null;
        InputStream is = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            // conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            is = conn.getInputStream();
            if (conn.getResponseCode() == 200) {
                data = readInputStream(is);
            } else{
                data=null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        }
        return data;
    }

    public static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        try {
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = baos.toByteArray();
        try {
            is.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
