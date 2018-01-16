package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;

import javax.validation.constraints.NotNull;

/**
 * Created By admin on 2018/1/16/13:23
 */
public class GoodsCanbeUploadedToJdRequest extends Request<GoodsCanbeUploadedToJdResponse> {
    /**
     * 淘宝cid
     */
    @NotNull(message = "非法参数")
    private Long tbCid;

    public GoodsCanbeUploadedToJdRequest() {
    }

    public Long getTbCid() {
        return tbCid;
    }

    public void setTbCid(Long tbCid) {
        this.tbCid = tbCid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"goodsApi/goodsCanbeUploadedToJdRequest.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"goodsApi/goodsCanbeUploadedToJdRequest.json";
    }

}
