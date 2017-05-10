package com.shigu.main4.goat.service.impl;

import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
@Service("goatDubboService")
public class GoatDubboServiceImpl implements GoatDubboService {
    @Autowired
    GoatFactory goatFactory;

    @Override
    public <T extends GoatVO> T selGoatById(Long goatId) throws GoatException {
        return goatFactory.selGoatById(goatId);
    }

    @Override
    public <T extends GoatVO> List<T> selGoatByLocalId(Long localId) throws GoatException {
        return null;
    }

    @Override
    public ItemUpVO selUp(Long goatId) {
        return null;
    }

    @Override
    public void modifyUp(Long goatId, Integer num) {

    }

    @Override
    public Double selWeight(Long goatId) {
        return null;
    }

    @Override
    public void updateWeight(Long goatId, Double weight) {

    }

    @Override
    public void publish(GoatVO vo) {

    }

    @Override
    public void preparePublish(GoatVO vo, Long second) {

    }

}
