package com.openJar.requests.api;

import com.openJar.beans.SdkJdImageUpdate;
import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdImageWriteUpdateResponse;

public class JdImageWriteUpdateRequest extends Request<JdImageWriteUpdateResponse> {
    private SdkJdImageUpdate bo;
    private Long jdUid;

    public String restApiUrl() {
        return JdImgEnum.REST + "api/jdImageWriteUpdate.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST + "api/jdImageWriteUpdate.json";
    }

    public SdkJdImageUpdate getBo() {
        return this.bo;
    }

    public void setBo(SdkJdImageUpdate bo) {
        this.bo = bo;
    }

    public Long getJdUid() {
        return this.jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }
}
