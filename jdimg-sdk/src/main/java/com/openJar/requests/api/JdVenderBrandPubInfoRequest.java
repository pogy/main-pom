package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdVenderBrandPubInfoResponse;

import javax.validation.constraints.NotNull;

/**
 * Created By admin on 2018/1/16/13:51
 */
public class JdVenderBrandPubInfoRequest extends Request<JdVenderBrandPubInfoResponse> {
    @NotNull(message = "非法参数")
    private Long jdUid;

    public JdVenderBrandPubInfoRequest() {
    }

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/jdVenderBrandPubInfo.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/jdVenderBrandPubInfo.json";
    }
}
