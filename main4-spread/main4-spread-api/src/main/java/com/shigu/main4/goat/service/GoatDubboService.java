package com.shigu.main4.goat.service;

import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;

import java.util.List;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
public interface GoatDubboService {
    <T extends GoatVO>T selGoatById(Long goatId) throws GoatException;
    <T extends GoatVO> List<T> selGoatByLocalId(Long localId) throws GoatException;

    /**
     * 查询真实上款量与虚假上款量
     * @return 真实上款量与虚假上款量
     */
    ItemUpVO selUp(Long goatId);

    /**
     * 修改虚假上款量
     * @param num 修改后的虚假上款量
     */
    void modifyUp(Long goatId, Integer num);

    /**
     * 查询权重
     * @return 商品的权重
     */
    Double selWeight(Long goatId);

    /**
     * 修改权重
     * @param weight 修改后的权重
     */
    void updateWeight(Long goatId, Double weight);

    /**
     * 发布上线
     */
    void publish(GoatVO vo);

    /**
     * 预发布
     * @param second 多久后发布以秒为单位
     */
    void preparePublish(GoatVO vo, Long second);
}
