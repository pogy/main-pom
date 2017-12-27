package com.shigu.jd.img.services;

import com.jd.open.api.sdk.request.imgzone.ImgzonePictureDeleteRequest;
import com.jd.open.api.sdk.request.imgzone.ImgzonePictureUploadRequest;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureDeleteResponse;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureUploadResponse;
import com.openJar.beans.JdImgInfo;
import com.openJar.exceptions.imgs.JdUpException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdImgDeleteResponse;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.exceptions.XzUidToTokenException;
import com.shigu.util.DownImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created By admin on 2017/12/22/13:51
 */
@Service
public class ImgMovingService {

    @Autowired
    private JdClientService jdClientService;

    @Autowired
    private XzUidToTokenService jdUidToTokenService;

    /**
     * 上传一张图片到京东图片空间
     * @param jdUpImgRequest
     * @return
     * @throws JdUpException
     */
    public JdUpImgResponse imgUpload (JdUpImgRequest jdUpImgRequest) throws XzUidToTokenException {
        String accessToken = jdUidToTokenService.getTokenByUid(jdUpImgRequest.getJdUid());
        List<JdImgInfo> jdImgInfos = new ArrayList<>();
        StringBuffer imgIds = new StringBuffer();
        String errMsg = null;
        List<String> imgUrls = jdUpImgRequest.getImgUrls();
        for (String imgUrl : imgUrls) {
            try {
                ImgzonePictureUploadRequest request = new ImgzonePictureUploadRequest();
                //下载图片
                byte[] imgData = DownImage.downImgFile(imgUrl);
                //如果大于1M直接失败
                if (imgData.length > 1024 * 1 * 1024) {
                    break;
                }
                request.setImageData(imgData);
                request.setPictureCateId(jdUpImgRequest.getPictureCateId());

                ImgzonePictureUploadResponse response = jdClientService.execute(request, accessToken);
                //返回码为1时为操作成功，返回码为0时为操作失败
                if ("0".equals(response.getReturnCode())) {
                    break;
                }
                JdImgInfo jdImgInfo = new JdImgInfo();
                jdImgInfo.setPictureId(response.getPictureId());
                jdImgInfo.setPictureUrl(response.getPictureUrl());
                jdImgInfos.add(jdImgInfo);
                imgIds.append(",").append(response.getPictureId());
            } catch (JdUpException|ImgDownloadException e) {
                e.printStackTrace();
                errMsg = e.getMessage();
            }
        }

        JdUpImgResponse jdUptoItemImgResponse = new JdUpImgResponse();
        if(imgUrls.size() != jdImgInfos.size()){
            try {
                imgDelete(jdUpImgRequest.getJdUid(),imgIds.toString());
            } catch (JdUpException e) {
                e.printStackTrace();
            }
            jdUptoItemImgResponse.setReturnCode("0");
            jdUptoItemImgResponse.setDesc(errMsg);
        }

        jdUptoItemImgResponse.setReturnCode("1");
        return jdUptoItemImgResponse;
    }

    /**
     * 删除图片 批量删除时ID间以半角逗号分隔，已被引用的图片不能删除
     * @param jdUid
     * @return
     * @throws JdUpException
     */
    public JdImgDeleteResponse imgDelete (Long jdUid, String imgIds) throws XzUidToTokenException, JdUpException {
        String accessToken = jdUidToTokenService.getTokenByUid(jdUid);
        ImgzonePictureDeleteRequest request = new ImgzonePictureDeleteRequest();
        ImgzonePictureDeleteResponse response = jdClientService.execute(request, accessToken);
        //返回码1，操作成功；0，操作失败；2，部分操作成功
        if ("0".equals(response.getReturnCode())) {
            throw new JdUpException(response.getDesc());
        }
        JdImgDeleteResponse jdImgDeleteResponse = new JdImgDeleteResponse();
        jdImgDeleteResponse.setReturnCode(response.getReturnCode());
        jdImgDeleteResponse.setDesc(response.getDesc());
        jdImgDeleteResponse.setFail(response.getFail());
        jdImgDeleteResponse.setIllegal(response.getIllegal());
        jdImgDeleteResponse.setReferenced(response.getReferenced());
        jdImgDeleteResponse.setSuccessNum(response.getSuccessNum());

        return jdImgDeleteResponse;
    }




}
