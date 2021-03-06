package com.shigu.sn.api.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.openJar.beans.SnTokenInfo;
import com.shigu.exception.OtherCustomException;
import com.shigu.sn.api.util.DownImage;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.item.NPicAddRequest;
import com.suning.api.entity.item.NPicAddResponse;
import com.suning.api.entity.item.PicDeleteRequest;
import com.suning.api.entity.item.PicDeleteResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SnImgService {

    @Autowired
    SnSdkClient snSdkClient;
    @Autowired
    SnAuthService snAuthService;


    /**
     * 上传图片到苏宁图片空间
     *
     * @param username
     * @param picContent
     * @return
     * @throws SuningApiException
     */
    public List<NPicAddResponse.AddNPic> getSnImg(String username, String picContent) throws SuningApiException {
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        List<NPicAddResponse.AddNPic> list = new ArrayList<>();
        if(picContent.contains("x-oss-process=image/resize,m_pad,w_800,h_1200")){
            StringBuilder imgIds = new StringBuilder();
            try {
                byte[] imgData = DownImage.downImgFile(picContent);
                NPicAddRequest nPicAddRequest = new NPicAddRequest();
                nPicAddRequest.setPicFileData(imgData);
                NPicAddResponse response = snSdkClient.mulSend(nPicAddRequest, snTokenInfo.getAccessToken());
                imgIds.append(response.getSnbody().getAddNPic().getPicUrl());
                list.add(response.getSnbody().getAddNPic());
            }catch (OtherCustomException e){
                imgDelete(username,imgIds.toString());
            }
        }else {
            StringBuilder imgIds = new StringBuilder();
            String[] urls = picContent.split(",");
            for (String s : urls) {
                try {
                    if(!s.contains("imgs.571xz.net")){
                        continue;
                    }
//                String picName = selName(s);
                    byte[] imgData = DownImage.downImgFile(s);
//                if (imgData.length > 1024 * 1024) {
//                    break;
//                }
                    NPicAddRequest nPicAddRequest = new NPicAddRequest();
                    nPicAddRequest.setPicFileData(imgData);
                    NPicAddResponse response = snSdkClient.mulSend(nPicAddRequest, snTokenInfo.getAccessToken());
                    NPicAddResponse.SnBody snbody = response.getSnbody();
                    if (snbody != null && snbody.getAddNPic() != null) {
                        list.add(snbody.getAddNPic());
                        imgIds.append(",").append(snbody.getAddNPic().getPicUrl());
                    }
                } catch (OtherCustomException e) {
                    imgDelete(username, imgIds.toString());
                    return null;
                }
            }
        }
        return list;

    }

    public String selName(String name) {
        int start = name.indexOf("\\");
        return name.substring(start + 1);
    }

    public void imgDelete(String username, String imgIds) throws SuningApiException {
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        PicDeleteRequest request = new PicDeleteRequest();
        for (String url : imgIds.split(",")) {
            request.setPicUrl(url);
            PicDeleteResponse response = snSdkClient.send(request, snTokenInfo.getAccessToken());
        }

    }
}
