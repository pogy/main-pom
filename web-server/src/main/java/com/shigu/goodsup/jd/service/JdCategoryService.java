package com.shigu.goodsup.jd.service;

import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.requests.api.JdVenderBrandPubInfoRequest;
import com.openJar.responses.api.JdVenderBrandPubInfoResponse;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.tools.XzSdkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By admin on 2018/1/16/15:26
 */
@Service
public class JdCategoryService {
    @Autowired
    XzJdSdkSend xzJdSdkSend;

    public List<JdVenderBrandPubInfo> getAllBrand(Long jdUserId){
        JdVenderBrandPubInfoRequest request = new JdVenderBrandPubInfoRequest();
        request.setJdUid(jdUserId);
        JdVenderBrandPubInfoResponse response = null;
        try {
            response = xzJdSdkSend.send(request);
        } catch (Exception e) {
            return null;
        }
        if(!response.isSuccess()){
            return null;
        }
        return response.getJdVenderBrandPubInfos();
    }
}
