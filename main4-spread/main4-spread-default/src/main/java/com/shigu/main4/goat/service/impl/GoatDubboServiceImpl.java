package com.shigu.main4.goat.service.impl;

import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.Goat;
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
    public <T extends GoatVO> T selGoatById(Long goatId,GoatType type) throws GoatException {
        Goat goat=goatFactory.selGoatById(goatId);
        return (T) BeanMapper.map(goat,type.getGoatVoClass());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends GoatVO> List<T> selGoatByLocalId(Long localId,GoatType type) throws GoatException {
        List<T> goats=goatFactory.getAlocation(localId).selGoats();
        return (List<T>) BeanMapper.mapList(goats,type.getGoatVoClass());
    }

    @Override
    public ItemUpVO selUp(Long goatId) throws GoatException {
        ItemGoat ig=goatFactory.selGoatById(goatId);
        return ig.selUp();
    }

    @Override
    public void modifyUp(Long goatId, Integer num) throws GoatException {
        ItemGoat ig=goatFactory.selGoatById(goatId);
        ig.modifyUp(num);
    }

    @Override
    public Double selWeight(Long goatId) throws GoatException {
        ItemGoat ig=goatFactory.selGoatById(goatId);
        return ig.selWeight();
    }

    @Override
    public void updateWeight(Long goatId, Double weight) throws GoatException {
        ItemGoat ig=goatFactory.selGoatById(goatId);
        ig.updateWeight(weight);
    }

    @Override
    public void publish(GoatVO vo) throws GoatException {
        Goat goat=goatFactory.selGoatByVo(vo);
        goat.publish();
    }

    @Override
    public void preparePublish(GoatVO vo, Long second) {
        Goat goat=goatFactory.selGoatByVo(vo);
        goat.preparePublish(second);
    }

}
