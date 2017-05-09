package com.shigu.main4.goat.service.impl;

import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatVO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
public class GoatDubboServiceImpl implements GoatDubboService {
    @Autowired
    GoatFactory goatFactory;

    @Override
    public <T extends GoatVO> T selGoatById(Long goatId) throws GoatException {
        return goatFactory.selGoatById(goatId);
    }
}
