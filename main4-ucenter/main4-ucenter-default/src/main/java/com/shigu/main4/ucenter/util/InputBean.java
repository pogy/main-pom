package com.shigu.main4.ucenter.util;

import java.util.HashMap;
import java.util.Map;

public class InputBean {
    private InputSubBean input;
    private InputSubBean prop;
    private InputSubBean img;
    private InputSubBean sku;


    InputBean(){
        input=new InputSubBean();
        prop=new InputSubBean();
        img=new InputSubBean();
        sku=new InputSubBean();
    }

    public InputSubBean getInput() {
        return this.input;
    }

    public void setInput(InputSubBean input) {
        this.input = input;
    }

    public InputSubBean getProp() {
        return this.prop;
    }

    public void setProp(InputSubBean prop) {
        this.prop = prop;
    }

    public InputSubBean getImg() {
        return this.img;
    }

    public void setImg(InputSubBean img) {
        this.img = img;
    }

    public InputSubBean getSku() {
        return this.sku;
    }

    public void setSku(InputSubBean sku) {
        this.sku = sku;
    }
}