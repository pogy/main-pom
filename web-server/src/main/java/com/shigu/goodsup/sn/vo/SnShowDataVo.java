package com.shigu.goodsup.sn.vo;

import com.shigu.goodsup.jd.vo.JdShowDataVO;

public class SnShowDataVo extends JdShowDataVO{
    private String username;
    private SnPageItem snPageItem;
    private SnPropsVo propsVo;

    public SnPropsVo getPropsVo() {
        return propsVo;
    }

    public void setPropsVo(SnPropsVo propsVo) {
        this.propsVo = propsVo;
    }

    public SnPageItem getSnPageItem() {
        return snPageItem;
    }

    public void setSnPageItem(SnPageItem snPageItem) {
        this.snPageItem = snPageItem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
