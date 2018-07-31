package com.openJar.responses.thirdSupport;

import com.openJar.beans.WorkUserGgoodsTasksScan;
import com.openJar.responses.Response;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.openJar.responses.thirdSupport
 * @ClassName: SelScanGgoodsResponse
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 16:35
 */
public class SelTagHaveGgoodsResponse extends Response {

    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
