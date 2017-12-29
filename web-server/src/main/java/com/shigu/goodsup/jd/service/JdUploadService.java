package com.shigu.goodsup.jd.service;

import com.jd.open.api.sdk.request.ware.WareAddRequest;
import com.shigu.goodsup.jd.bo.JdUploadPropImgBO;
import com.shigu.goodsup.jd.bo.JdUploadTmpBO;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.taobao.api.domain.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdUploadService {

    public void upload(PropsVO prop, JdUploadTmpBO tbo, JdPageItem item){
        WareAddRequest req=new WareAddRequest();
        req.setCid(tbo.getCid().toString());
        req.setShopCategory("店内类目");
        req.setTitle(tbo.getTitle());
        req.setOptionType("offsale");//默认下架
        req.setItemNum("货号");
        req.setStockNum(tbo.getNum().toString());
        req.setLength(tbo.getLength());
        req.setWide(tbo.getWidth());
        req.setHigh(tbo.getHeight());
        req.setWeight(tbo.getWeight());
        req.setMarketPrice(tbo.getMarketPrice());
        req.setJdPrice(tbo.getPrice());
        req.setWareImage();//todo 图片
        req.setSkuProperties(tbo.selSkuProp());
        req.setSkuPrices(tbo.selSkuSale());
        req.setSkuStocks(tbo.selSkuStock());
        req.setAttributes(tbo.selAttrs());
        req.setPropertyAlias(tbo.selAlias(prop.getSaleProps(),prop.getColor()));
        req.setOuterId(tbo.selOuterId());
        req.setPayFirst("true");
        req.setInputPids(tbo.selInputPids());
        req.setInputStrs(tbo.selInputValues());
        req.setAdContent(tbo.getSellPoint());

        //搬家
        List<String> headImgUrls=tbo.getPicUrls();

        Map<String,String> skuImgUrls=tbo.getPropImg().stream().collect(Collectors.toMap(JdUploadPropImgBO::getImg,jdUploadPropImgBO -> jdUploadPropImgBO.getPid()+":"+jdUploadPropImgBO.getVid()));

        String html=tbo.getPcContent();
        Document doc = Jsoup.parse(html);
        Elements descImgs=doc.select("img");
        List<String> descImgUrls=descImgs.stream().map(element -> element.attr("src")).collect(Collectors.toList());

        List<String> allImgs=new ArrayList<>();
        allImgs.addAll(headImgUrls);
        allImgs.addAll(skuImgUrls.keySet());
        allImgs.addAll(descImgUrls);



        req.setNotes(html);
    }
}
