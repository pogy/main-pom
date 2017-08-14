package com.shigu.main4.goat.service;

import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.GoatIntermVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import com.shigu.main4.goat.vo.TextGoatVO;

import java.util.List;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
public interface GoatDubboService {

    <T extends GoatVO> T selGoatById(Long goatId,GoatType type) throws GoatException;

    <T extends GoatVO> T selGoatPrepareById(Long goatId,GoatType type) throws GoatException;
    /**
     * 按期次分好
     * 线上
     * 报名线上   ————  预定
     * 报名下期   ————  排期中
     * @param localId
     * @param type
     * @return
     * @throws GoatException
     */
    List<GoatIntermVO> selGoatByLocalId(Long localId, GoatType type) throws GoatException, ActivityException;

    <T extends GoatVO> List<T> selGoatsFromLocalCode(String localCode) throws GoatException;

    /**
     * 查询真实上款量与虚假上款量
     * @return 真实上款量与虚假上款量
     */
    ItemUpVO selUp(Long goatId) throws GoatException;

    /**
     * 修改虚假上款量
     * @param num 修改后的虚假上款量
     */
    void modifyUp(Long goatId, Integer num) throws GoatException;

    /**
     * 查询权重
     * @return 商品的权重
     */
    Double selWeight(Long goatId) throws GoatException;

    /**
     * 修改权重
     * @param weight 修改后的权重
     */
    void updateWeight(Long goatId, Double weight) throws GoatException;

    /**
     * 发布上线
     */
    void publish(GoatVO vo) throws GoatException;

    /**selGoat
     * 预发布
     * @param second 多久后发布以秒为单位
     */
    void preparePublish(GoatVO vo, Long second);

    /**
     * 修改评论
     * @param goatId
     * @param recommon
     */
    void recommon(Long goatId,String recommon) throws GoatException;

    /**
     * 上移
     * @param goatId
     */
    void moveUp(Long goatId) throws GoatException;

    /**
     * 下移
     * @param goatId
     */
    void moveDown(Long goatId) throws GoatException;

}
