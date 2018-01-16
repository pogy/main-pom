package com.shigu.goodsup.jd.service;

import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.requests.api.JdVenderBrandPubInfoRequest;
import com.openJar.responses.api.JdVenderBrandPubInfoResponse;
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
    private OpenClientService openClientService;

    public List<JdVenderBrandPubInfo> getAllBrand(Long jdUserId) {
        JdVenderBrandPubInfoRequest request = new JdVenderBrandPubInfoRequest();
        request.setJdUid(jdUserId);
        JdVenderBrandPubInfoResponse response = openClientService.getOpenClient().execute(request);
        if(!response.isSuccess()){
            return null;
        }
        return response.getJdVenderBrandPubInfos();
    }
}
