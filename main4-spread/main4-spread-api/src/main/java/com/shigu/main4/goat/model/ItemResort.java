package com.shigu.main4.goat.model;

import com.shigu.main4.goat.vo.ItemUpVO;

/**
 * 商品重排服务
 *
 * selUp() //查询真实上款量与虚假上款量
 void modifyUp(Integer num) //修改虚假上款量
 Integer selWeight() //查询权重
 void updateWeight(Integer num)
 * Created by zhaohongbo on 17/5/4.
 */
public interface ItemResort {
    /**
     * 查询真实上款量与虚假上款量
     * @return 真实上款量与虚假上款量
     */
    ItemUpVO selUp();

    /**
     * 修改虚假上款量
     * @param num 修改后的虚假上款量
     */
    void modifyUp(Integer num);

    /**
     * 查询权重
     * @return 商品的权重
     */
    Double selWeight();

    /**
     * 修改权重
     * @param weight 修改后的权重
     */
    void updateWeight(Double weight);
}
