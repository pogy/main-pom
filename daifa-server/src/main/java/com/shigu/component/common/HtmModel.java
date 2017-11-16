package com.shigu.component.common;

/**
 * Created by wxc on 2016/10/27.
 *
 * @author wxc
 * @version pay_site
 * @since pay_site
 */
public class HtmModel {
    private String type = "page";
    private String module = "daifa8.0";
    private Object data;
    private String ftl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getFtl() {
        return ftl;
    }

    public void setFtl(String ftl) {
        this.ftl = ftl;
    }
}
