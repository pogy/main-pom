package com.openJar.responses.api;

import com.openJar.beans.JdCategoryAttrValue;
import com.openJar.responses.Response;

import java.util.List;

/**
 * Created By admin on 2017/12/14/16:20
 */
public class JdCategoryAttrValueResponse extends Response {

    private List<JdCategoryAttrValue> jdCategoryAttrValue;

    public List<JdCategoryAttrValue> getJdCategoryAttrValue() {
        return jdCategoryAttrValue;
    }

    public void setJdCategoryAttrValue(List<JdCategoryAttrValue> jdCategoryAttrValue) {
        this.jdCategoryAttrValue = jdCategoryAttrValue;
    }
}
