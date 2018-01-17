package com.shigu.jd.img.services;

import com.jd.open.api.sdk.request.imgzone.ImgzonePictureDeleteRequest;
import com.jd.open.api.sdk.request.imgzone.ImgzonePictureQueryRequest;
import com.jd.open.api.sdk.request.imgzone.ImgzonePictureUploadRequest;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureDeleteResponse;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureQueryResponse;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureUploadResponse;
import com.openJar.beans.JdImgInfo;
import com.openJar.commons.MD5Attestation;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdImgDeleteResponse;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.exceptions.JdAuthFailureException;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.service.JdClientService;
import com.shigu.jd.tools.DownImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
     * @throws JdApiException
     */
    public JdUpImgResponse imgUpload (JdUpImgRequest jdUpImgRequest) {
        JdUpImgResponse jdUptoItemImgResponse=new JdUpImgResponse();
        String accessToken = null;
        try {
            accessToken = jdUidToTokenService.getTokenByUid(jdUpImgRequest.getJdUid());
        } catch (JdAuthOverdueException e) {
            jdUptoItemImgResponse.setReturnCode("0");
            jdUptoItemImgResponse.setDesc("图片搬家失败");
            return jdUptoItemImgResponse;
        }
        StringBuilder imgIds = new StringBuilder();
        List<String> imgUrls = jdUpImgRequest.getImgUrls();
        Map<String,JdImgInfo> jdImgInfos = new HashMap<>();
        for (String imgUrl : imgUrls) {
            try {
                String pictureName = MD5Attestation.MD5Encode(imgUrl);
                ImgzonePictureQueryRequest imgzonePictureQueryRequest=new ImgzonePictureQueryRequest();
                imgzonePictureQueryRequest.setPictureName(pictureName);
                ImgzonePictureQueryResponse imgzonePictureQueryResponse = jdClientService.execute(imgzonePictureQueryRequest, accessToken);
                if (imgzonePictureQueryResponse.getTotalNum() > 0) {
                    JdImgInfo jdImgInfo = new JdImgInfo();
                    jdImgInfo.setPictureId(imgzonePictureQueryResponse.getImgList().get(0).getPictureId());
                    jdImgInfo.setPictureUrl(imgzonePictureQueryResponse.getImgList().get(0).getPictureUrl());
                    jdImgInfos.put(imgUrl,jdImgInfo);
                    continue;
                }
                ImgzonePictureUploadRequest request = new ImgzonePictureUploadRequest();
                //下载图片
                byte[] imgData = DownImage.downImgFile(imgUrl);
                //如果大于1M直接失败
                if (imgData.length > 1024 * 1024) {
                    break;
                }
                request.setImageData(imgData);
                request.setPictureCateId(jdUpImgRequest.getPictureCateId());
                request.setPictureName(pictureName);

                ImgzonePictureUploadResponse response = jdClientService.execute(request, accessToken);
                //返回码为1时为操作成功，返回码为0时为操作失败
                if ("0".equals(response.getReturnCode())) {
                    throw new OtherCustomException("图片搬家失败");
                }
                JdImgInfo jdImgInfo = new JdImgInfo();
                jdImgInfo.setPictureId(response.getPictureId());
                jdImgInfo.setPictureUrl(response.getPictureUrl());
                jdImgInfos.put(imgUrl,jdImgInfo);
                imgIds.append(",").append(response.getPictureId());
            } catch (OtherCustomException|JdAuthOverdueException e) {
                try {
                    imgDelete(jdUpImgRequest.getJdUid(),imgIds.toString());
                } catch (JdAuthOverdueException|OtherCustomException ignored) {
                }
                jdUptoItemImgResponse.setReturnCode("0");
                jdUptoItemImgResponse.setDesc("图片搬家失败");
                return jdUptoItemImgResponse;
            }
        }
        jdUptoItemImgResponse.setReturnCode("1");
        jdUptoItemImgResponse.setJdImgInfos(jdImgInfos);
        return jdUptoItemImgResponse;
    }

    /**
     * 删除图片 批量删除时ID间以半角逗号分隔，已被引用的图片不能删除
     * @param jdUid
     * @return
     * @throws JdApiException
     */
    private JdImgDeleteResponse imgDelete(Long jdUid, String imgIds) throws JdAuthOverdueException, OtherCustomException {
        String accessToken = jdUidToTokenService.getTokenByUid(jdUid);
        ImgzonePictureDeleteRequest request = new ImgzonePictureDeleteRequest();
        request.setPictureIds(imgIds);
        ImgzonePictureDeleteResponse response = jdClientService.execute(request, accessToken);
        //返回码1，操作成功；0，操作失败；2，部分操作成功
        if ("0".equals(response.getReturnCode())) {
            throw new OtherCustomException(response.getDesc());
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
