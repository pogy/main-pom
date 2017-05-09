package com.shigu.main4.goat.service;

import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.GoatVO;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
public interface GoatDubboService {
    <T extends GoatVO>T selGoatById(Long goatId) throws GoatException;
}
