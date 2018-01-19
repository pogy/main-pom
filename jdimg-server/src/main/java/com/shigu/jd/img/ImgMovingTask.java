package com.shigu.jd.img;

import com.jd.open.api.sdk.request.imgzone.ImgzonePictureUploadRequest;
import com.jd.open.api.sdk.response.imgzone.ImgzonePictureUploadResponse;
import com.openJar.beans.JdImgInfo;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.service.JdClientService;
import com.shigu.jd.tools.DownImage;

import java.util.concurrent.Callable;

/**
 * Created By admin on 2018/1/19/10:49
 */
public class ImgMovingTask implements Callable<JdImgInfo> {

    private String imgUrl;

    private String pictureName;

    /**
     * 分类ID
     */
    private Long pictureCateId;

    private JdClientService jdClientService;

    private String accessToken;

    @Override
    public JdImgInfo call() throws Exception {
        ImgzonePictureUploadRequest request = new ImgzonePictureUploadRequest();
        //下载图片
        byte[] imgData = DownImage.downImgFile(imgUrl);
        //如果大于1M直接失败
        if (imgData.length > 1024 * 1024) {
            throw new OtherCustomException("图片搬家失败,图片大小超过京东限制");
        }
        request.setImageData(imgData);
        request.setPictureCateId(pictureCateId);
        request.setPictureName(pictureName);

        ImgzonePictureUploadResponse response = jdClientService.execute(request, accessToken);
        //返回码为1时为操作成功，返回码为0时为操作失败
        if ("0".equals(response.getReturnCode())) {
            throw new OtherCustomException("图片搬家失败");
        }
        JdImgInfo jdImgInfo = new JdImgInfo();
        jdImgInfo.setPictureId(response.getPictureId());
        jdImgInfo.setPictureUrl(response.getPictureUrl());
        return jdImgInfo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Long getPictureCateId() {
        return pictureCateId;
    }

    public void setPictureCateId(Long pictureCateId) {
        this.pictureCateId = pictureCateId;
    }

    public JdClientService getJdClientService() {
        return jdClientService;
    }

    public void setJdClientService(JdClientService jdClientService) {
        this.jdClientService = jdClientService;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
