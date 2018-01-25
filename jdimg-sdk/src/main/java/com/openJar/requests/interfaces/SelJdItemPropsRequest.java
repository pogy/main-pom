package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelJdItemPropsResponse;

import javax.validation.constraints.NotNull;

public class SelJdItemPropsRequest extends Request<SelJdItemPropsResponse>{
    @NotNull(message = "jdCid is null")
    private Long jdCid;
    public Long getJdCid() {
        return this.jdCid;
    }

    public void setJdCid(Long jdCid) {
        this.jdCid = jdCid;
    }



    public String restApiUrl() {
        return JdImgEnum.REST+"api/selJdItemProps.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selJdItemProps.json";
    }


}
