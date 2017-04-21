package com.shigu.main4.spread.service;

import com.shigu.main4.spread.exceptions.GoatException;
import com.shigu.main4.spread.vo.GoatALocation;

/**
 * 广告位获取服务
 * Created by Licca on 17/4/10.
 */
public interface GoatGetService {
    /**
     * 获取一个广告位的广告位置信息
     * @param code
     * @return
     */
    GoatALocation getAlocation(String code) throws GoatException;

    /**
     * 获取一个广告位的广告数据
     * @param code
     * @return
     */
    GoatALocation getLocationData(String code) throws GoatException;

}
