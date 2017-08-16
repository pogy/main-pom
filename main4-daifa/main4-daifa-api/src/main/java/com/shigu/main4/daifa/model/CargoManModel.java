package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.exceptions.DaifaException;

import java.util.List;

/**
 * 拿货员
 * 多例,描述了一个拿货员的所有操作
 * 按拿货员ID构造
 * Created by zhaohongbo on 17/8/9.
 */
public interface CargoManModel {
    /**
     * 分配给我
     * @param waitIssueIds 待分配ID
     */
    String takeToMe(List<Long> waitIssueIds) throws DaifaException;

    /**
     * 马上结束拿货
     * 未拿到,直接缺货
     */
    void finishTakeGoods() throws DaifaException;

}
