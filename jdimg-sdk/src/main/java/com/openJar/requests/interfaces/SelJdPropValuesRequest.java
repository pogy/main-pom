package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelJdPropValuesResponse;

import javax.validation.constraints.NotNull;

public class SelJdPropValuesRequest extends Request<SelJdPropValuesResponse>{
    @NotNull(message = "jdCid is null")
    private Long jdCid;

    public Long getJdCid() {
        return jdCid;
    }

    public void setJdCid(Long jdCid) {
        this.jdCid = jdCid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/selJdPropValues.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selJdPropValues.json";
    }
}
