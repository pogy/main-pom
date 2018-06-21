package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 一行sku对象
 * 相当于一个tr
 * Created by zhaohongbo on 17/1/16.
 */
public class SkuVO extends ArrayList<TdVO> implements Serializable{

    private static final long serialVersionUID = -697162039218874354L;
    /**
     * 如果是1表示表头,如果是0表示表体
     */
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String str="";
        for(TdVO td:this){
            str+=td+"||";
        }
        str+="\n";
        return str;
    }
}
