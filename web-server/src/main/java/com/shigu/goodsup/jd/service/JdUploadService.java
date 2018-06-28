package com.shigu.goodsup.jd.service;

import com.openJar.beans.*;
import com.openJar.requests.api.*;
import com.openJar.responses.api.*;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.goodsup.jd.bo.JdUploadPropImgBO;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.tools.XzSdkClient;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.shigu.goodsup.jd.actions.JdGoodsupAction.IMG_CATEGORY;

@Service
public class JdUploadService {
    @Autowired
    XzJdSdkSend xzJdSdkSend;
    @Autowired
    JdCategoryService jdCategoryService;
    @Autowired
    JdImgService jdImgService;
    @Autowired
    JdGoodsUpService jdGoodsUpService;
    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    static List<Integer> cdnIndexs = Arrays.asList(10, 11, 12, 13, 14);

    public SdkJdWareAdd upload(PropsVO prop, JdUploadTmpBO tbo, Long jdUid) throws CustomException, AuthOverException {
        JdWareAddRequest request = new JdWareAddRequest();
        JdUpGoods req = new JdUpGoods();
        req.setCid(tbo.getCid().toString());
        req.setTitle(tbo.getTitle());
        req.setOptionType("onsale".equals(tbo.getApprove_status()) ? "onsale" : "offsale");//默认下架
        req.setItemNum(tbo.getGoodsNo());
        req.setStockNum(tbo.getNum().toString());
        req.setLength(tbo.getLength());
        req.setWide(tbo.getWidth());
        req.setHigh(tbo.getHeight());
        req.setWeight(tbo.getWeight());
        req.setMarketPrice(tbo.getMarketPrice());
        req.setJdPrice(tbo.getPrice());
        req.setSkuProperties(tbo.selSkuProp());
        req.setSkuPrices(tbo.selSkuSale());
        req.setSkuStocks(tbo.selSkuStock());
        req.setAttributes(tbo.selAttrs());
        req.setPropertyAlias(tbo.selAlias(prop.getSaleProps(), prop.getColor()));
        req.setOuterId(tbo.selOuterId());
        req.setInputPids(tbo.selInputPids());
        req.setInputStrs(tbo.selInputValues());
        req.setAdContent(tbo.getSellPoint());
        req.setWrap(null);
        req.setWareBigSmallModel(null);
        req.setWarePackType(null);

        //拼装店内类目
        if (tbo.getSellerCids() != null) {
            JdShopCategoryRequest jdShopCategoryRequest = new JdShopCategoryRequest();
            jdShopCategoryRequest.setJdUid(jdUid);
            JdShopCategoryResponse jdShopCategoryResponse =xzJdSdkSend.send(jdShopCategoryRequest);
            if (!jdShopCategoryResponse.isSuccess()) {
                throw new CustomException( "读取类目失败:" + jdShopCategoryResponse.getException().getErrMsg());
            }
            List<SdkJdShopCategory> jdShopCategoryVOS = jdShopCategoryResponse.getJdShopCategories();
            StringBuilder storeCat = new StringBuilder();
            for (SdkJdShopCategory jdShopCategoryVO : jdShopCategoryVOS) {
                for (Long cid : tbo.getSellerCids()) {
                    if (cid == jdShopCategoryVO.getCid()) {
                        storeCat.append(jdShopCategoryVO.getParentId()).append("-").append(jdShopCategoryVO.getCid()).append(";");
                        break;
                    }
                }
            }
            if (storeCat.length() > 0) {
                storeCat = new StringBuilder(storeCat.substring(0, storeCat.length() - 1));
                req.setShopCategory(storeCat.toString());
            }
        }

        //搬家
        List<String> headImgUrls = tbo.getPicUrls();
        req.setWareImageUrl(headImgUrls.get(0));

        Map<String, String> skuImgUrls = tbo.getPropImg().stream().collect(Collectors.toMap(JdUploadPropImgBO::getImg, jdUploadPropImgBO -> jdUploadPropImgBO.getPid() + ":" + jdUploadPropImgBO.getVid()));

        String html = tbo.getPcContent();
        Document doc = Jsoup.parse(html);
        Elements descImgs = doc.select("img");
        List<String> descImgUrls = descImgs.stream().map(element -> element.attr("src")).filter(StringUtils::isNotEmpty).filter(s -> s.startsWith("http")).collect(Collectors.toList());

        List<String> allImgs = new ArrayList<>();
        allImgs.addAll(headImgUrls);
        allImgs.addAll(skuImgUrls.keySet());
        allImgs.addAll(descImgUrls);

        //创建图片目录
        //查看星座上传图片类目是否存在
        JdImgzoneCategoryRequest jdImgzoneCategoryRequest = new JdImgzoneCategoryRequest();
        jdImgzoneCategoryRequest.setImgCategory(tbo.getGoodsNo());
        jdImgzoneCategoryRequest.setJdUid(jdUid);
        JdImgzoneCategoryResponse jdImgzoneCategoryResponse = xzJdSdkSend.send(jdImgzoneCategoryRequest);
        if (!jdImgzoneCategoryResponse.isSuccess()) {
            throw new CustomException("图片搬家失败:" + jdImgzoneCategoryResponse.getException().getErrMsg());
        }
        List<SdkJdImgzoneCategory> vos = jdImgzoneCategoryResponse.getDatas();
        Long imgCategoryId;
        Long pImgCategoryId;
        if (vos == null || vos.isEmpty()) {
            //查图片主类目
            jdImgzoneCategoryRequest = new JdImgzoneCategoryRequest();
            jdImgzoneCategoryRequest.setImgCategory(IMG_CATEGORY);
            jdImgzoneCategoryRequest.setJdUid(jdUid);
            jdImgzoneCategoryResponse = xzJdSdkSend.send(jdImgzoneCategoryRequest);
            if (!jdImgzoneCategoryResponse.isSuccess()) {
                throw new CustomException("图片搬家失败:" + jdImgzoneCategoryResponse.getException().getErrMsg());
            }
            List<SdkJdImgzoneCategory> pvos = jdImgzoneCategoryResponse.getDatas();
            if (pvos == null || pvos.isEmpty()) {
                JdImgzoneCategoryAddRequest jdImgzoneCategoryAddRequest = new JdImgzoneCategoryAddRequest();
                jdImgzoneCategoryAddRequest.setImgCategory(IMG_CATEGORY);
                jdImgzoneCategoryAddRequest.setJdUid(jdUid);
                JdImgzoneCategoryAddResponse jdImgzoneCategoryAddResponse = xzJdSdkSend.send(jdImgzoneCategoryAddRequest);
                if (!jdImgzoneCategoryAddResponse.isSuccess()) {
                    throw new CustomException("图片搬家失败:" + jdImgzoneCategoryAddResponse.getException().getErrMsg());
                }
                pImgCategoryId = jdImgzoneCategoryAddResponse.getImgZoneId();
            } else {
                pImgCategoryId = pvos.get(0).getCateId();
            }
            JdImgzoneCategoryAddRequest jdImgzoneCategoryAddRequest = new JdImgzoneCategoryAddRequest();
            jdImgzoneCategoryAddRequest.setImgCategory(tbo.getGoodsNo());
            jdImgzoneCategoryAddRequest.setJdUid(jdUid);
            jdImgzoneCategoryAddRequest.setParentCateId(pImgCategoryId);
            JdImgzoneCategoryAddResponse jdImgzoneCategoryAddResponse = xzJdSdkSend.send(jdImgzoneCategoryAddRequest);
            if (!jdImgzoneCategoryAddResponse.isSuccess()) {
                throw new CustomException("图片搬家失败:" + jdImgzoneCategoryAddResponse.getException().getErrMsg());
            }
            imgCategoryId = jdImgzoneCategoryAddResponse.getImgZoneId();
        } else {
            imgCategoryId = vos.get(0).getCateId();
        }

        JdUpImgResponse jdUpImgResponse = jdImgService.addImgs(jdUid, allImgs, imgCategoryId);
        if (!jdUpImgResponse.isSuccess()) {
            throw new CustomException("图片搬家失败:" + jdUpImgResponse.getException().getErrMsg());
        }
        Map<String, JdImgInfo> imgMap = jdUpImgResponse.getJdImgInfos();

        int cdnIndex = cdnIndexs.get((int) (Math.random() * cdnIndexs.size()));
        for (String descImg : descImgUrls) {
            JdImgInfo img = imgMap.get(descImg);
            doc.getElementsByAttributeValue("src", descImg).attr("src", "//img" + cdnIndex + ".360buyimg.com/imgzone/" + img.getPictureUrl());
        }
        html = doc.body().html();
        req.setNotes(html);




        //上传商品
        request.setGoods(req);
        request.setJdUid(jdUid);
        JdWareAddResponse jdWareAddResponse = xzJdSdkSend.send(request);
        if(!jdWareAddResponse.isSuccess()){
            throw new CustomException("商品上传失败:" + jdWareAddResponse.getException().getErrMsg());
        }
        SdkJdWareAdd jdGoods = jdWareAddResponse.getData();
        if (jdGoods == null) {
            throw new CustomException("商品上传失败");
        }

        //获取手机详情
        Document parse = Jsoup.parse(html);
        Elements pDocs=new Elements();
        parse.select("img").forEach(element -> {
            element.attr("src",element.attr("src")+".dpg");
            element.attr("width","750px");
            element.removeAttr("class");
            pDocs.add(element);
        });
        JdWareMobileDescRequest jdWareMobileDescRequest=new JdWareMobileDescRequest();
        jdWareMobileDescRequest.setJdUid(jdUid);
        jdWareMobileDescRequest.setMobileDesc(pDocs.toString());
        jdWareMobileDescRequest.setTitle(tbo.getTitle());
        jdWareMobileDescRequest.setWareId(jdGoods.getGoodsId());
        if (tbo.getPostage_id() != null && tbo.getPostage_id() != -1L) {
            JdTransportWriteUpdateWareTransportIdRequest jdTransportWriteUpdateWareTransportIdRequest = new JdTransportWriteUpdateWareTransportIdRequest();
            jdTransportWriteUpdateWareTransportIdRequest.setJdUid(jdUid);
            jdTransportWriteUpdateWareTransportIdRequest.setWareId(jdGoods.getGoodsId());
            jdTransportWriteUpdateWareTransportIdRequest.setTemplateId(tbo.getPostage_id());
            JdTransportWriteUpdateWareTransportIdResponse jdTransportWriteUpdateWareTransportIdResponse = xzJdSdkSend.send(jdTransportWriteUpdateWareTransportIdRequest);
            if (!jdTransportWriteUpdateWareTransportIdResponse.isSuccess()) {
                throw new CustomException("绑定运费模版失败:" + jdTransportWriteUpdateWareTransportIdResponse.getException().getErrMsg());
            }
            if(!jdTransportWriteUpdateWareTransportIdResponse.isCan()){
                throw new CustomException("绑定运费模版失败");
            }
            jdWareMobileDescRequest.setTransportId(tbo.getPostage_id());
        }
        //修改属性图
        SdkJdImageUpdate b = new SdkJdImageUpdate();
        StringBuilder colors = new StringBuilder();
        StringBuilder images = new StringBuilder();
        StringBuilder zids = new StringBuilder();
        StringBuilder index = new StringBuilder();
        int headIndex = 1;
        for (String himg : headImgUrls) {
            JdImgInfo img = imgMap.get(himg);
            images.append(img.selImgUrl()).append(",");
            zids.append(img.getPictureId()).append(",");
            index.append(headIndex++).append(",");
            colors.append("0000000000").append(",");
        }
        for (JdUploadSkuBO sku : tbo.getSkus()) {
            int i = 1;
            for (JdUploadPropImgBO jdUploadPropImgBO : tbo.getPropImg()) {
                if (Objects.equals(jdUploadPropImgBO.getVid(), sku.getVid())) {
                    JdImgInfo img = imgMap.get(jdUploadPropImgBO.getImg());
                    images.append(img.selImgUrl()).append(",");
                    zids.append(img.getPictureId()).append(",");
                    index.append(i++).append(",");
                    colors.append(sku.getVid()).append(",");
                    break;
                }
            }
            for (String himg : headImgUrls) {
                JdImgInfo img = imgMap.get(himg);
                images.append(img.selImgUrl()).append(",");
                zids.append(img.getPictureId()).append(",");
                index.append(i++).append(",");
                colors.append(sku.getVid()).append(",");
            }
        }
        if (images.length() > 0) {
            images = new StringBuilder(images.substring(0, images.length() - 1));
            zids = new StringBuilder(zids.substring(0, zids.length() - 1));
            index = new StringBuilder(index.substring(0, index.length() - 1));
            colors = new StringBuilder(colors.substring(0, colors.length() - 1));
            b.setColorId(colors.toString());
            b.setGoodsId(jdGoods.getGoodsId());
            b.setImgUrl(images.toString());
            b.setImgZoneId(zids.toString());
            b.setImgIndex(index.toString());
            jdImgService.bindGoodsImgs(b, jdUid);
        }

        MemberUserSubExample example = new MemberUserSubExample();
        example.createCriteria().andSubUserKeyEqualTo(String.valueOf(jdUid));
        MemberUserSub memberUserSub = memberUserSubMapper.selectByExample(example).get(0);

        ItemUpRecordVO vo = new ItemUpRecordVO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setDaiTime(sdf.format(new Date()));
        vo.setFenGoodsName(tbo.getTitle());
        vo.setFenImage(imgMap.get(headImgUrls.get(0)).getPictureUrl());
        vo.setFenPrice(tbo.getPrice());
        vo.setFenNumiid(jdGoods.getGoodsId());
        vo.setFenUserId(memberUserSub.getUserId());
        vo.setFenUserNick(jdUid.toString());
        vo.setFlag("jd");
        vo.setSupperGoodsId(tbo.getMid());
        jdGoodsUpService.saveRecord(vo);

//        JdWareMobileDescResponse send = xzJdSdkSend.send(jdWareMobileDescRequest);
//        if(!send.isSuccess()){
//            throw new CustomException("生成手机详情失败:" + send.getException().getErrMsg());
//        }
        return jdGoods;
    }

    public static void main(String[] args) {
        String str = "<div>" +
                "<a onclick=''>,</a><b ons=''>,</b>" +
                "" +
                "</div>";
        Elements on = Jsoup.parse(str).getElementsByAttributeStarting("on");
        System.out.println(on.toString());
    }
}
