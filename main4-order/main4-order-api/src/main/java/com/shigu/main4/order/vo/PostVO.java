package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-30/15:27
 * 快递规则，转为JSON字符串 首重价格+(总重-首重)*续重价格
 */
public class PostVO implements Serializable {

    private static final long serialVersionUID = -8911479288781518382L;
    /**
     * id
     */
    private Long id;
    /**快递缩写例申通快递-stkd*/
    private String name;
    /**快递中文名*/
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
