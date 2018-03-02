package com.openJar.responses.imgs;

import com.openJar.responses.Response;

import java.util.List;

/**
 * 请求结果
 * Created by zhaohongbo on 16/12/20.
 */
public class JdImgDeleteResponse extends Response{
    private Integer returnCode;
    private String desc ;
    private Integer successNum ;
    private List<String> illegal;
    private List<String> referenced;
    private List<String> fail;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public List<String> getIllegal() {
        return illegal;
    }

    public void setIllegal(List<String> illegal) {
        this.illegal = illegal;
    }

    public List<String> getReferenced() {
        return referenced;
    }

    public void setReferenced(List<String> referenced) {
        this.referenced = referenced;
    }

    public List<String> getFail() {
        return fail;
    }

    public void setFail(List<String> fail) {
        this.fail = fail;
    }
}
