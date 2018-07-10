package com.shigu.goodsup.sn.vo;

import com.shigu.goodsup.jd.vo.PropertyValueVO;

public class PropValueVo extends PropertyValueVO{
    private String snId;

    private boolean firstChange;

    public boolean isFirstChange() {
        return firstChange;
    }

    public void setFirstChange(boolean firstChange) {
        this.firstChange = firstChange;
    }

    public String getSnId() {
        return snId;
    }

    public void setSnId(String snId) {
        this.snId = snId;
    }
}
