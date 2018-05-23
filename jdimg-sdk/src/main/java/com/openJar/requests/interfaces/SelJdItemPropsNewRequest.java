package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelJdItemPropsNewResponse;

import javax.validation.constraints.NotNull;

public class SelJdItemPropsNewRequest extends Request<SelJdItemPropsNewResponse>{
    @NotNull(message = "jdCid is null")
    private Long jdCid;
    @NotNull(message = "jdUid is null")
    private Long jdUid;
    public Long getJdCid() {
        return this.jdCid;
    }

    public void setJdCid(Long jdCid) {
        this.jdCid = jdCid;
    }

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/selJdItemPropsNew.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selJdItemPropsNew.json";
    }


}
