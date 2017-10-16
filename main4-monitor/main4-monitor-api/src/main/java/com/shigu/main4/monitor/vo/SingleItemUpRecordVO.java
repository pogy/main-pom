package com.shigu.main4.monitor.vo;

import java.io.Serializable;

/**
 * 商品上传记录数据
 * Created by zhaohongbo on 17/3/13.
 */
public class SingleItemUpRecordVO extends ItemUpRecordVO{
    private String oneKeyId;

    public String getOneKeyId() {
        return this.oneKeyId;
    }

    public void setOneKeyId(String oneKeyId) {
        this.oneKeyId = oneKeyId;
    }
}
