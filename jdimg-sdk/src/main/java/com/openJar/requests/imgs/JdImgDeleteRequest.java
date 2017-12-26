package com.openJar.requests.imgs;


import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.imgs.JdImgDeleteResponse;


/**
 * 让图片站完成图片上传
 * Created by zhaohongbo on 16/12/20.
 */
public class JdImgDeleteRequest extends Request<JdImgDeleteResponse> {

    private Long jdUid;
    /**
     * 图片ID，批量删除时ID间以半角逗号分隔，已被引用的图片不能删除
     */
    private String pictureIds;

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String getPictureIds() {
        return pictureIds;
    }

    public void setPictureIds(String pictureIds) {
        this.pictureIds = pictureIds;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"deleteImgs.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"deleteImgs.json";
    }


}
