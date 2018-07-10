package com.shigu.goodsup.sn.service;

import com.openJar.beans.SnGood;
import com.openJar.requests.api.SnItemAddRequest;
import com.shigu.goodsup.sn.bo.SnUploadTbo;
import org.springframework.stereotype.Service;

@Service
public class SnUploadService {

    public String upload(String username, SnUploadTbo sbo){
        SnItemAddRequest request=new SnItemAddRequest();
        request.setUsername(username);
        SnGood snGood=new SnGood();
        snGood.setCategoryCode(sbo.getCategoryCode());
        snGood.setCmTitle(sbo.getTitle());
        snGood.setProductName(sbo.getTitle());
        snGood.setSellPoint(sbo.getSellPoint());
        snGood.setPrice(sbo.getPrice());
        snGood.setInvQty(sbo.getNum().toString());
        snGood.setSaleSet(sbo.getApprove_status());

        return "";
    }
}
