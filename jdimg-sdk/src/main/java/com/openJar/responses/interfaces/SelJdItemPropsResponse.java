package com.openJar.responses.interfaces;

import com.openJar.beans.JdItemProp;
import com.openJar.responses.Response;

import java.util.List;

public class SelJdItemPropsResponse extends Response{
    private List<JdItemProp> datas;

    public List<JdItemProp> getDatas() {
        return this.datas;
    }

    public void setDatas(List<JdItemProp> datas) {
        this.datas = datas;
    }
}
