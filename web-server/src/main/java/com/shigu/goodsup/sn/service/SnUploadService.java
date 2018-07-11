package com.shigu.goodsup.sn.service;

import com.openJar.beans.SnGood;
import com.openJar.requests.api.SnItemAddRequest;
import com.openJar.requests.img.SnImgAddRequest;
import com.openJar.responses.api.SnItemAddResponse;
import com.openJar.responses.img.SnImgAddResponse;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.goodsup.sn.bo.SnUploadImgBo;
import com.shigu.goodsup.sn.bo.SnUploadPropBo;
import com.shigu.goodsup.sn.bo.SnUploadSkuBo;
import com.shigu.goodsup.sn.bo.SnUploadTbo;
import com.shigu.tools.XzSdkClient;
import com.suning.api.exception.SuningApiException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SnUploadService {
    @Autowired
    XzJdSdkSend xzJdSdkSend;

    public String upload(String username, SnUploadTbo sbo) throws AuthOverException, CustomException {
        Map<String, String> map = new HashMap<>();
        if (sbo.getPicUrls() != null) {
            int i = 0;
            for (String url : sbo.getPicUrls()) {
                i++;
                SnImgAddRequest snImgAddRequest = new SnImgAddRequest();
                snImgAddRequest.setUsername(username);
                snImgAddRequest.setPicContent(url);
                SnImgAddResponse snImgAddResponse = xzJdSdkSend.send(snImgAddRequest);
                map.put(String.valueOf(i), snImgAddResponse.getAddNPics().get(0).getPicUrl());
            }
        }

        SnItemAddRequest request = new SnItemAddRequest();
        request.setUsername(username);
        SnGood snGood = new SnGood();
        if (map.get("1") != null) {
            snGood.setSupplierImg1Url(map.get("1"));
        }
        if (map.get("2") != null) {
            snGood.setSupplierImg2Url(map.get("2"));
        }
        if (map.get("3") != null) {
            snGood.setSupplierImg3Url(map.get("3"));
        }
        if (map.get("4") != null) {
            snGood.setSupplierImg4Url(map.get("4"));
        }
        if (map.get("5") != null) {
            snGood.setSupplierImg5Url(map.get("5"));
        }
        if (map.get("6") != null) {
            snGood.setSupplierImg6Url(map.get("6"));
        }
        if (map.get("7") != null) {
            snGood.setSupplierImg7Url(map.get("7"));
        }
        if (map.get("8") != null) {
            snGood.setSupplierImg8Url(map.get("8"));
        }
        if (map.get("9") != null) {
            snGood.setSupplierImg9Url(map.get("9"));
        }
        if (map.get("10") != null) {
            snGood.setSupplierImg10Url(map.get("10"));
        }


        snGood.setCategoryCode(sbo.getCid());
        snGood.setCmTitle(sbo.getTitle());
        snGood.setProductName(sbo.getTitle());
        snGood.setSellPoint(sbo.getSellPoint());
        snGood.setPrice(sbo.getPrice());
        snGood.setInvQty(sbo.getNum().toString());
        snGood.setSaleSet(sbo.getApprove_status());
        List<SnGood.Par> pars = new ArrayList<>();
        List<SnGood.ChildItem> childItems = new ArrayList<>();
        if (sbo.getProps() != null) {
            int i = 0;
            for (SnUploadPropBo sb : sbo.getProps()) {
                i++;
                if (i == 1) {
                    snGood.setBrandCode(sb.getParValue());
                    continue;
                }
                SnGood.Par sp = new SnGood.Par();
                sp.setParCode(sb.getParCode());
                sp.setParValue(sb.getParValue());
                pars.add(sp);
            }
        }
        if (sbo.getInputs() != null) {
            for (SnUploadPropBo sb : sbo.getInputs()) {
                SnGood.Par sp = new SnGood.Par();
                sp.setParCode(sb.getParCode());
                sp.setParValue(sb.getParValue());
                pars.add(sp);
            }
        }
        snGood.setPars(pars);
        if (sbo.getSkus() != null) {
            String urls = "";
            for (SnUploadImgBo sib : sbo.getPropImg()) {
                urls = urls + sib.getImg() + ",";


            }
            if (urls.endsWith(",")) {
                urls = urls.substring(0, urls.length() - 1);
            }
            SnImgAddRequest snImgAddRequest = new SnImgAddRequest();
            snImgAddRequest.setUsername(username);
            snImgAddRequest.setPicContent(urls);
            SnImgAddResponse snImgAddResponse = xzJdSdkSend.send(snImgAddRequest);
            for (SnUploadSkuBo ssb : sbo.getSkus()) {
                SnGood.Par par1 = new SnGood.Par();
                par1.setParCode(ssb.getPid());
                par1.setParValue(ssb.getName());
                for (SnUploadSkuBo ssb1 : ssb.getSizes()) {
                    SnGood.ChildItem childItem = new SnGood.ChildItem();
                    childItem.setItemCode(ssb1.getCode());
                    childItem.setInvQty(String.valueOf(ssb1.getNum()));
                    childItem.setPrice(ssb1.getPrice());
                    List<SnGood.Par> pars1 = new ArrayList<>();
                    SnGood.Par par = new SnGood.Par();
                    par.setParCode(ssb1.getPid());
                    par.setParValue(ssb1.getName());
                    pars1.add(par);
                    pars1.add(par1);
                    childItem.setPars(pars1);


                    for(int i =0;i<sbo.getPropImg().size();i++){
                        if(ssb.getName().equals(sbo.getPropImg().get(i).getValue())){
                            childItem.setSupplierImg1Url(snImgAddResponse.getAddNPics().get(i).getPicUrl());
                        }
                    }
                    childItems.add(childItem);
                }

            }
        }

        String html=sbo.getPcContent();
        Document doc = Jsoup.parse(html);
        Elements descImgs = doc.select("img");
        List<String> descImgUrls = descImgs.stream().map(element -> element.attr("src")).filter(StringUtils::isNotEmpty).filter(s -> s.startsWith("http")).collect(Collectors.toList());
        String imgs="";
        for(String s:descImgUrls){
            imgs=imgs+s+",";
        }
        if(imgs.endsWith(",")){
            imgs=imgs.substring(0,imgs.length()-1);
        }
        SnImgAddRequest snImgAddRequest = new SnImgAddRequest();
        snImgAddRequest.setUsername(username);
        snImgAddRequest.setPicContent(imgs);
        SnImgAddResponse snImgAddResponse = xzJdSdkSend.send(snImgAddRequest);
        for(int i =0;i<descImgUrls.size();i++){
            html=html.replace(descImgUrls.get(i),snImgAddResponse.getAddNPics().get(i).getPicUrl());
        }

        snGood.setIntroduction(html);
        snGood.setChildItems(childItems);
        request.setSnGood(snGood);
        SnItemAddResponse response = new SnItemAddResponse();
        response = xzJdSdkSend.send(request);

        return response.getApplyParams().getApplyCode();
    }
}
