package com.shigu.seller.vo;

import java.util.List;

/**
 * Created by wxc on 2016/12/27.
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class FormItemVO {
    private int isInputProp;
    private Long pid;
    private String name;
    private String type;
    private String value;
    private List<KVO> options;
    private List<KVO> checkboxs;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<KVO> getCheckboxs() {
        return checkboxs;
    }

    public void setCheckboxs(List<KVO> checkboxs) {
        this.checkboxs = checkboxs;
    }

    public int getIsInputProp() {
        return isInputProp;
    }

    public void setIsInputProp(int isInputProp) {
        this.isInputProp = isInputProp;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return "cp_" + pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return /*this.isInputProp == 1 && */this.options == null || this.options.size() == 0? "input" : "select";
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<KVO> getOptions() {
        return options;
    }

    public void setOptions(List<KVO> options) {
        this.options = options;
    }
}
