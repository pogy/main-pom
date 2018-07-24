package com.shigu.main4.packages.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 数据包
 * Created by zhaohongbo on 17/2/26.
 */
public class DataPackage implements Serializable{
    /**
     * 数据包记录主键
     */
    private Long dataPackageId;
    /**
     * 数据包链接
     */
    private String dataPackageUrl;
    /**
     * 数据包创建时间
     */
    private String createTime;

    /**
     * 数据包中的商品
     */
    private List<PackageItem> goods;

    public Long getDataPackageId() {
        return dataPackageId;
    }

    public void setDataPackageId(Long dataPackageId) {
        this.dataPackageId = dataPackageId;
    }

    public String getDataPackageUrl() {
        return dataPackageUrl;
    }

    public void setDataPackageUrl(String dataPackageUrl) {
        this.dataPackageUrl = dataPackageUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<PackageItem> getGoods() {
        return goods;
    }

    public void setGoods(List<PackageItem> goods) {
        this.goods = goods;
    }
}
