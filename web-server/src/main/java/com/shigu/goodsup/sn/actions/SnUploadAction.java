package com.shigu.goodsup.sn.actions;

import com.openJar.responses.api.SnItemAddResponse;
import com.openJar.responses.img.SnImgAddResponse;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.sn.bo.SnUploadBo;
import com.shigu.goodsup.sn.bo.SnUploadSkuBo;
import com.shigu.goodsup.sn.bo.SnUploadTbo;
import com.shigu.goodsup.sn.enums.SnTips;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.shigu.goodsup.sn.service.SnUpItemService;
import com.shigu.goodsup.sn.service.SnUploadService;
import com.shigu.goodsup.sn.service.SnUserInfoService;
import com.shigu.goodsup.sn.util.EnumUtil;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.goodsup.sn.vo.SnPropsVo;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
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
import java.util.Date;
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
    @Autowired
    ItemUpRecordService itemUpRecordService;
    @Autowired
    ShowForCdnService showForCdnService;
    @Autowired
    StoreRelationService storeRelationService;
    @Autowired
    ShopBaseService shopBaseService;

    private OssIO ossIO;

    @RequestMapping("sn/index")
    public String upload(HttpSession session, Map<String, Object> map, SnUploadBo bo, String skus,
                         @RequestParam(value = "prop_img[]", required = false) List<String> propImg,
                         @RequestParam(value = "picUrl[]", required = false) List<String> picUrls,
                         @RequestParam(value = "sku_props[]", required = false) List<String> skuProps,
                         @RequestParam(value = "seller_cids[]", required = false) List<Long> sellerCids, HttpServletRequest request) throws UnsupportedEncodingException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String SnUsername = snUserInfoService.getSnUsernameBySubUid(ps.getSubUserId());
        SnUploadTbo sbo = BeanMapper.map(bo, SnUploadTbo.class);
        List<SnUploadSkuBo> sku = (List<SnUploadSkuBo>) JSONArray.toList(JSONArray.fromObject(skus), SnUploadSkuBo.class, new HashMap<String, Class>() {{
            put("sizes", SnUploadSkuBo.class);
        }});
        sbo.setSkus(sku);
        sbo.callProp_img(propImg);
        sbo.callSku_props(skuProps);
        sbo.setPicUrls(picUrls);
        sbo.setSellerCids(sellerCids);
        String errorMsg = null;
        String numIid = null;
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
            SnItemAddResponse response = snUploadService.upload(SnUsername, sbo);
            if (response.getErrmsg() == null) {
                map.put("success", "发布成功");
                numIid = response.getApplyParams().getApplyCode();
            } else {
                errorMsg = response.getErrmsg();
                if (errorMsg.contains("isp.sys.service.unavailable.mcmp")) {
                    errorMsg = "上传失败，请稍后重试。";
                } else if(errorMsg.contains("biz.custom.additem.invalid-biz")){
                    String msg = errorMsg.substring(errorMsg.lastIndexOf(":")+1);
                    SnTips snTips = EnumUtil.getEnumObject(msg, SnTips.class);
                    if(snTips==null){
                        String msg1 = msg.substring(0,msg.indexOf("-"));
                        if(msg1.equals("179")){
                            String num = msg.substring(msg.lastIndexOf("-"));
                            map.put("num",num);
                        }
                        snTips = EnumUtil.getEnumObject(msg1, SnTips.class);
                        errorMsg = snTips.getTip();
                    }else {
                        errorMsg = snTips.getTip();
                    }
                }
            }
        } catch (AuthOverException e) {
            String queryString = request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=8&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                    (queryString == null ? "" : ("?" + queryString)), "utf-8");
        } catch (CustomException e) {
            errorMsg = e.getMessage();
        }

        map.put("numIid", numIid);
        map.put("errorMsg", errorMsg);
        addUploadRecord(bo.getMid(),ps);
        return "suning/parts/success";
    }

    private void addUploadRecord(Long id, PersonalSession personalSession) {
        CdnItem cdnItem = showForCdnService.selItemById(id);
        StoreRelation storeRelation = storeRelationService.selRelationById(cdnItem.getShopId());
        ShopBase shopBase = shopBaseService.shopBaseForUpdate(cdnItem.getShopId());
        ItemUpRecordVO record = new ItemUpRecordVO();
        record.setFenUserId(personalSession.getUserId());
        record.setFenUserNick(personalSession.getUserNick());
        record.setFenPrice(cdnItem.getPiPrice());
        record.setSupperPiPrice(cdnItem.getPiPrice());
        record.setSupperPrice(cdnItem.getPrice());
        record.setStatus(0L);
        record.setFenGoodsName(cdnItem.getTitle());
        record.setSupperGoodsId(id);
        record.setSupperStoreId(cdnItem.getShopId());
        record.setSupperMarketId(cdnItem.getMarketId());
        record.setSupperNumiid(cdnItem.getTbNumIid());
        record.setCid(cdnItem.getCid());
        if (!cdnItem.getImgUrl().isEmpty()) {
            String img = cdnItem.getImgUrl().get(0);
            record.setSupperImage(img);
            record.setFenImage(img);
        }
        record.setFlag(GoodsUploadFlagEnum.SN.getFlag());
        record.setSupperGoodsName(cdnItem.getTitle());
        record.setWebSite(cdnItem.getWebSite());
        record.setDaiTime(DateUtil.dateToString(new Date(), DateUtil.patternD));
        record.setFenNumiid(cdnItem.getTbNumIid());
        if (storeRelation != null) {
            record.setSupperServers("退现金,包换款");
            record.setSupperStorenum(storeRelation.getStoreNum());
            record.setSupperImww(storeRelation.getImWw());
            record.setSupperTelephone(storeRelation.getTelephone());
            record.setSupperTaobaoUrl(shopBase.getTaobaoUrl());
            record.setSupperMarket(storeRelation.getMarketName());
            record.setSupperStoreName(shopBase.getShopName());
            record.setSupperQq(storeRelation.getImQq());
        }
        itemUpRecordService.addItemUpRecord(record);
    }

}
