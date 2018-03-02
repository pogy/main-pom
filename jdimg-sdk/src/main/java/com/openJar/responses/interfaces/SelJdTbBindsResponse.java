package com.openJar.responses.interfaces;

import com.openJar.beans.JdTbBind;
import com.openJar.responses.Response;

import java.util.List;

public class SelJdTbBindsResponse extends Response{
    private List<JdTbBind> datas;

    public List<JdTbBind> getDatas() {
        return this.datas;
    }

    public void setDatas(List<JdTbBind> datas) {
        this.datas = datas;
    }
}
