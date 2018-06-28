package com.shigu.sn.api.service;

import com.openJar.beans.SnTokenInfo;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.item.NPicAddRequest;
import com.suning.api.entity.item.NPicAddResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnImgService {

    @Autowired
    SnSdkClient snSdkClient;
    @Autowired
    SnAuthService snAuthService;

    /**
     * 上传图片到苏宁图片空间
     * @param username
     * @param picContent
     * @return
     * @throws SuningApiException
     */
    public NPicAddResponse.AddNPic getSnImg(String username,String picContent) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        NPicAddRequest nPicAddRequest=new NPicAddRequest();
        nPicAddRequest.setPicFileData(picContent.getBytes());
        NPicAddResponse response=snSdkClient.send(nPicAddRequest,snTokenInfo.getAccessToken());
        return response.getSnbody().getAddNPic();
    }
}
