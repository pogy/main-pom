package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdPostTemplateResponse;

import javax.validation.constraints.NotNull;

/**
 * Created By admin on 2018/1/16/14:44
 */
public class JdPostTemplateRequest extends Request<JdPostTemplateResponse> {
    @NotNull(message = "非法参数")
    private Long jdUid;

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"userApi/jdPostTemplate.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"userApi/jdPostTemplate.json";
    }
}
