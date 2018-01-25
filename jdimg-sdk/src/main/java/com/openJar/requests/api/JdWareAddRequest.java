package com.openJar.requests.api;

import com.openJar.beans.JdUpGoods;
import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdWareAddResponse;

public class JdWareAddRequest extends Request<JdWareAddResponse> {
    private JdUpGoods goods;
    private Long jdUid;

    public JdUpGoods getGoods() {
        return this.goods;
    }

    public void setGoods(JdUpGoods goods) {
        this.goods = goods;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/jdWareAdd.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/jdWareAdd.json";
    }

    public Long getJdUid() {
        return this.jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }
}
