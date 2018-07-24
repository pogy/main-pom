package com.shigu.buyer.vo;


import com.shigu.main4.packages.bo.DataPackage;
import com.shigu.main4.packages.bo.PackageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据包中的商品
 * Created by zhaohongbo on 17/3/13.
 */
public class PackageVO {

    /** 第一个商品的商品ID */
    private Long id;
    /**
     * 数据包链接
     */
    private String href;
    /**
     * 数据包ID
     */
    private Long dataPackageId;
    /**
     * 标题
     */
    private String remark10;
    /**
     * 首件商品图
     */
    private String remark9;

    /**
     * 登陆时间
     */
    private String createtime;

    private List<PackageItemVO> goods;

    public PackageVO(DataPackage pageInfo) {
        setHref(pageInfo.getDataPackageUrl());
        setDataPackageId(pageInfo.getDataPackageId());
        setCreatetime(pageInfo.getCreateTime());
        List<PackageItem> list=pageInfo.getGoods();
        goods=new ArrayList<>();
        if(list!=null&&list.size()>0){
            setId(list.get(0).getId());
//            setRemark10(list.get(0).getTitle());
            setRemark9(list.get(0).getPicUrl());
            for(PackageItem pi:list){
                goods.add(new PackageItemVO(pi));
            }
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getDataPackageId() {
        return dataPackageId;
    }

    public void setDataPackageId(Long dataPackageId) {
        this.dataPackageId = dataPackageId;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<PackageItemVO> getGoods() {
        return goods;
    }

    public void setGoods(List<PackageItemVO> goods) {
        this.goods = goods;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }
}
