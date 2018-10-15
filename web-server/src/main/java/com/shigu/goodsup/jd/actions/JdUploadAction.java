package com.shigu.goodsup.jd.actions;

import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.beans.SdkJdWareAdd;
import com.shigu.goodsup.jd.bo.JdUploadBO;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdCategoryService;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.JdUploadService;
import com.shigu.goodsup.jd.service.JdUserInfoService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created By zf on 2017/12/8/15:38
 */
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
    @Autowired
    RedisIO redisIO;
    @Autowired
    ItemUpRecordService itemUpRecordService;
    @Autowired
    ShowForCdnService showForCdnService;
    @Autowired
    StoreRelationService storeRelationService;
    @Autowired
    ShopBaseService shopBaseService;

    @RequestMapping("jd/index")
    public String uploadJd(HttpSession session, JdUploadBO bo, String skus,
                           @RequestParam(value = "prop_img[]", required = false) List<String> propImg,
                           @RequestParam(value = "picUrl[]", required = false) List<String> picUrls,
                           @RequestParam(value = "sku_props[]", required = false) List<String> skuProps,
                           @RequestParam(value = "seller_cids[]",required = false) List<Long> sellerCids,
                           HttpServletRequest request,
                           Model model) throws UnsupportedEncodingException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
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
        List<JdVenderBrandPubInfo> allBrand = null;
        Long numIid=null;
        String errorMsg=null;
        try {
            allBrand = jdCategoryService.getAllBrand(jdUserId);

            if (allBrand == null) {
                throw new CustomException("不是京东商家");
            }
            /********************************取商品********************************/
            JdPageItem item;
            PropsVO prop;
            try {
                item = jdUpItemService.findGoods(bo.getMid());
                if (item == null) {
                    throw new CustomException("商品不存在");
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
                throw new CustomException("商品信息异常");
            }

            SdkJdWareAdd upload = jdUploadService.upload(prop, tbo, jdUserId);
            //淘宝商品地址 https://item.jd.com/${skuId}.html  任意一skuId 都可以访问
            numIid = upload.getJdSkuInfoVOS().get(0).getSkuId();
            if (bo.getPostage_id() == null) {
                redisIO.del("jd_postageId_"+jdUserId.toString());
            }else{
                redisIO.put("jd_postageId_"+jdUserId.toString(),bo.getPostage_id());
            }
        } catch (AuthOverException e) {
            String queryString = request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                    (queryString == null ? "" : ("?" + queryString)), "utf-8");
        } catch (CustomException e) {
            errorMsg=e.getMessage();
        }
        model.addAttribute("errorMsg",errorMsg);
        model.addAttribute("numIid",numIid);
        addUploadRecord(bo.getMid(),ps);
        return "jingdong/parts/success";
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
        record.setFlag(GoodsUploadFlagEnum.JD.getFlag());
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
