package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdTransportWriteUpdateWareTransportIdResponse;

public class JdTransportWriteUpdateWareTransportIdRequest extends Request<JdTransportWriteUpdateWareTransportIdResponse> {
    private Long jdUid;
    private Long wareId;
    private Long templateId;

    public String restApiUrl() {
        return JdImgEnum.REST + "api/jdTransportWriteUpdateWareTransportId.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST + "api/jdTransportWriteUpdateWareTransportId.json";
    }

    public Long getJdUid() {
        return this.jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public Long getWareId() {
        return this.wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Long getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
