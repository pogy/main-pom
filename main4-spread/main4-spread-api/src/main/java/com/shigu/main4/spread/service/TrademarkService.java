package com.shigu.main4.spread.service;

import com.shigu.main4.spread.bo.TrademarkApplyBO;

/**
 * 类名：TrademarkService
 * 类路径：com.shigu.main4.spread.service.TrademarkService
 * 创建者：王浩翔
 * 创建时间：2017-10-13 17:19
 * 项目：main-pom
 * 描述：
 */
public interface TrademarkService {

    String TRADEMARK_APPLY_FLAG = "trademark_apply_flag_";

    void giveInfoToServer(Long userId,TrademarkApplyBO bo);

}
