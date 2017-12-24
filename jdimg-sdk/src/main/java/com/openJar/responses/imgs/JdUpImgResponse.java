package com.openJar.responses.imgs;

import com.openJar.beans.JdImgInfo;
import com.openJar.responses.Response;

import java.util.List;

/**
 * 商品主图上传
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUpImgResponse extends Response{
    /**
     * 返回码：1，操作成功；0，操作失败
     */
    private String returnCode ;
    /**
     * 返回码为1时为操作成功，返回码为0时为操作失败原因
     */
    private String desc;

    List<JdImgInfo> jdImgInfos;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<JdImgInfo> getJdImgInfos() {
        return jdImgInfos;
    }

    public void setJdImgInfos(List<JdImgInfo> jdImgInfos) {
        this.jdImgInfos = jdImgInfos;
    }
}
