package com.shigu.goodsup.jd.service;

import com.openJar.beans.JdImgInfo;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.goodsup.jd.bo.JdUploadPropImgBO;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.jd.service.JdShopService;
import com.shigu.main4.jd.vo.JdImgzoneCategoryVO;
import com.shigu.main4.jd.vo.JdShopCategoryVO;
import com.shigu.main4.jd.vo.JdWareAddVO;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
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
    JdShopService jdShopService;
    @Autowired
    JdGoodsService jdGoodsService;
    @Autowired
    JdCategoryService jdCategoryService;
    @Autowired
    JdImgService jdImgService;
    @Autowired
    JdGoodsUpService jdGoodsUpService;
    public void upload(PropsVO prop, JdUploadTmpBO tbo, Long jdUid) throws Main4Exception, JdApiException {
        JdUpBO req=new JdUpBO();
        req.setCid(tbo.getCid().toString());
        req.setShopCategory("店内类目");
        req.setTitle(tbo.getTitle());
        req.setOptionType("onsale".equals(tbo.getApprove_status())?"onsale":"offsale");//默认下架
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
        req.setPropertyAlias(tbo.selAlias(prop.getSaleProps(),prop.getColor()));
        req.setOuterId(tbo.selOuterId());
        req.setInputPids(tbo.selInputPids());
        req.setInputStrs(tbo.selInputValues());
        req.setAdContent(tbo.getSellPoint());
        req.setWareBigSmallModel("");
        req.setWarePackType("");

        //拼装店内类目
        if(tbo.getSellerCids()!=null){
            List<JdShopCategoryVO> jdShopCategoryVOS=jdCategoryService.getJdSellercats(jdUid);
            StringBuilder storeCat= new StringBuilder();
            for(JdShopCategoryVO jdShopCategoryVO:jdShopCategoryVOS){
                for(Long cid:tbo.getSellerCids()){
                    if(cid==jdShopCategoryVO.getCid()){
                        storeCat.append(jdShopCategoryVO.getParentId()).append("-").append(jdShopCategoryVO.getCid()).append(";");
                        break;
                    }
                }
            }
            if(storeCat.length()>0){
                storeCat = new StringBuilder(storeCat.substring(0, storeCat.length() - 1));
                req.setShopCategory(storeCat.toString());
            }
        }

        //搬家
        List<String> headImgUrls=tbo.getPicUrls();
        req.setWareImageUrl(headImgUrls.get(0));

        Map<String,String> skuImgUrls=tbo.getPropImg().stream().collect(Collectors.toMap(JdUploadPropImgBO::getImg,jdUploadPropImgBO -> jdUploadPropImgBO.getPid()+":"+jdUploadPropImgBO.getVid()));

        String html=tbo.getPcContent();
        Document doc = Jsoup.parse(html);
        //处理超链接
        doc.select("a").forEach(element -> {
            if(element.hasAttr("href")){
                element.attr("href","javascript:void(0);");
            }
        });
        Elements descImgs=doc.select("img");
        List<String> descImgUrls=descImgs.stream().map(element -> element.attr("src")).filter(StringUtils::isNotEmpty).collect(Collectors.toList());

        List<String> allImgs=new ArrayList<>();
        allImgs.addAll(headImgUrls);
        allImgs.addAll(skuImgUrls.keySet());
        allImgs.addAll(descImgUrls);

        //创建图片目录
        //查看星座上传图片类目是否存在
        List<JdImgzoneCategoryVO> vos = jdShopService.selImgCategory(jdUid,tbo.getGoodsNo(),null);
        Long imgCategoryId;
        Long pImgCategoryId;
        if (vos == null || vos.isEmpty()) {
            //查图片主类目
            List<JdImgzoneCategoryVO> pvos = jdShopService.selImgCategory(jdUid,IMG_CATEGORY,null);
            if (pvos == null || pvos.isEmpty()) {
                pImgCategoryId = jdShopService.addImgCategory(jdUid, IMG_CATEGORY, null);
            }else {
                pImgCategoryId = pvos.get(0).getCateId();
            }
            imgCategoryId = jdShopService.addImgCategory(jdUid, tbo.getGoodsNo(), pImgCategoryId);
        }else{
            imgCategoryId = vos.get(0).getCateId();
        }

        JdUpImgResponse jdUpImgResponse=jdImgService.addImgs(jdUid,allImgs,imgCategoryId);

        Map<String,JdImgInfo> imgMap=jdUpImgResponse.getJdImgInfos();

        for(String descImg:descImgUrls){
            JdImgInfo img=imgMap.get(descImg);
            doc.getElementsByAttributeValue("src",descImg).attr("src",img.getPictureUrl());
        }
        html=doc.body().html();
        req.setNotes(html);
        //上传商品
        JdWareAddVO jdGoods= jdGoodsService.upToJd(req, jdUid);
        if(tbo.getPostage_id()!=null&&tbo.getPostage_id()!=-1L){
            jdGoodsService.bindPostTemplate(jdUid,jdGoods.getGoodsId(),tbo.getPostage_id());
        }
        //修改属性图
        for(JdUploadSkuBO sku:tbo.getSkus()){
            JdImageUpdateBO b=new JdImageUpdateBO();
            b.setColorId(sku.getVid().toString());
            StringBuilder images= new StringBuilder();
            StringBuilder zids= new StringBuilder();
            for(JdUploadPropImgBO jdUploadPropImgBO:tbo.getPropImg()){
                if(Objects.equals(jdUploadPropImgBO.getVid(), sku.getVid())){
                    JdImgInfo img=imgMap.get(jdUploadPropImgBO.getImg());
                    images.append(img.selImgUrl()).append(",");
                    zids.append(img.getPictureId()).append(",");
                    break;
                }
            }
            for(String himg:headImgUrls){
                JdImgInfo img=imgMap.get(himg);
                images.append(img.selImgUrl()).append(",");
                zids.append(img.getPictureId()).append(",");
            }
            if(images.length()>0){
                images = new StringBuilder(images.substring(0, images.length() - 1));
                zids = new StringBuilder(zids.substring(0, zids.length() - 1));
            }
            b.setGoodsId(jdGoods.getGoodsId());
            b.setImgUrl(images.toString());
            b.setImgZoneId(zids.toString());
            jdImgService.bindGoodsImgs(b,jdUid);
        }
        ItemUpRecordVO vo=new ItemUpRecordVO();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setDaiTime(sdf.format(new Date()));
        vo.setFenGoodsName(tbo.getTitle());
        vo.setFenImage(imgMap.get(headImgUrls.get(0)).getPictureUrl());
        vo.setFenPrice(tbo.getPrice());
        vo.setFenNumiid(jdGoods.getGoodsId());
        vo.setFenUserId(jdUid);
        vo.setFenUserNick(jdUid.toString());
        vo.setFlag("jd");
        vo.setSupperGoodsId(tbo.getMid());
        jdGoodsUpService.saveRecord(vo);
    }
}
