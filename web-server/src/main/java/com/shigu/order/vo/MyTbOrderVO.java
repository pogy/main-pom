package com.shigu.order.vo;

import com.shigu.main4.common.tools.ShiguPager;

public class MyTbOrderVO<T> extends ShiguPager<T> {
    private int notLinkNum;

    public int getNotLinkNum() {
        return this.notLinkNum;
    }

    public void setNotLinkNum(int notLinkNum) {
        this.notLinkNum = notLinkNum;
    }
}
