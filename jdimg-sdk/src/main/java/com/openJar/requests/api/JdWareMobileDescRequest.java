package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdWareMobileDescResponse;

public class JdWareMobileDescRequest extends Request<JdWareMobileDescResponse> {
    private Long jdUid;
    private Long wareId;
    private String title;
    private Long transportId;
    private String mobileDesc;

    public String restApiUrl() {
        return JdImgEnum.REST + "api/jdWareMobileDesc.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST + "api/jdWareMobileDesc.json";
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTransportId() {
        return this.transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public String getMobileDesc() {
        return this.mobileDesc;
    }

    public void setMobileDesc(String mobileDesc) {
        this.mobileDesc = mobileDesc;
    }
}
