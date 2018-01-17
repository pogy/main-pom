package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdCategoryAttrValueJosResponse;

import javax.validation.constraints.NotNull;

/**
 * Created By admin on 2018/1/16/15:35
 */
public class JdCategoryAttrValueJosRequest extends Request<JdCategoryAttrValueJosResponse> {
    @NotNull(message = "非法参数")
    private Long jdUid;

    @NotNull(message = "非法参数")
    private Long pid;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/jdCategoryAttrValueJos.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/jdCategoryAttrValueJos.json";
    }
}
