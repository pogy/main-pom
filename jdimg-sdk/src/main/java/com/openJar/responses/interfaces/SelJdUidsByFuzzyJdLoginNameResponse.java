package com.openJar.responses.interfaces;

import com.openJar.responses.Response;

import java.util.List;

/**
 * Created by gtx on 2018/5/2.
 * 根据京东登陆名模糊查询
 * @author gtx
 * @description
 * @since
 */
public class SelJdUidsByFuzzyJdLoginNameResponse extends Response {

    private List<Long> jdUids;

    public List<Long> getJdUids() {
        return jdUids;
    }

    public void setJdUids(List<Long> jdUids) {
        this.jdUids = jdUids;
    }
}
