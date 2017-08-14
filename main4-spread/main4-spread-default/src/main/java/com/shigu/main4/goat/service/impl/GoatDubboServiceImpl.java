package com.shigu.main4.goat.service.impl;

import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.model.ActivityFactory;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.model.Goat;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.model.GoatFactory;
import com.shigu.main4.goat.vo.GoatIntermVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import com.shigu.main4.goat.vo.TextGoatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告对外服务
 * Created by zhaohongbo on 17/5/9.
 */
@Service("goatDubboService")
public class GoatDubboServiceImpl implements GoatDubboService {
    @Autowired
    GoatFactory goatFactory;

    @Autowired
    ActivityFactory activityFactory;

    @Override
    public <T extends GoatVO> T selGoatById(Long goatId,GoatType type) throws GoatException {
        Goat goat=goatFactory.selGoatById(goatId);
        return (T) BeanMapper.map(goat,type.getGoatVoClass());
    }

    @Override
    public <T extends GoatVO> T selGoatPrepareById(Long goatId, GoatType type) throws GoatException {
        Goat goat=goatFactory.selGoatPrepareById(goatId);
        return (T) BeanMapper.map(goat,type.getGoatVoClass());
    }

    /**
     * 拿到线上的、预定的、排期的
     * @param localId
     * @param type
     * @return
     * @throws GoatException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<GoatIntermVO> selGoatByLocalId(Long localId, GoatType type) throws GoatException, ActivityException {
        GoatLocation location=goatFactory.getAlocation(localId);
        List<GoatVO> goats=location.selGoats();
        List<GoatIntermVO> result=new ArrayList<>();
        GoatIntermVO giv=new GoatIntermVO();
        giv.setType(0);
        giv.setGoats(goats);
        result.add(giv);
        //查预定
        GoatIntermVO prep=new GoatIntermVO();
        prep.setType(1);
        prep.setGoats(location.selPrepareGoats());
        result.add(prep);
        return result;
    }

    @Override
    public <T extends GoatVO> List<T> selGoatsFromLocalCode(String localCode) throws GoatException {
        GoatLocation location = goatFactory.getALocation(localCode);
        return location.selGoats();
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

    @Override
    public void recommon(Long goatId, String recommon) throws GoatException {
        Goat goat=goatFactory.selGoatById(goatId);
        goat.recommon(recommon);
    }

    @Override
    public void moveUp(Long goatId) throws GoatException {
        Goat goat=goatFactory.selGoatById(goatId);
        goat.moveUp();
    }

    @Override
    public void moveDown(Long goatId) throws GoatException {
        Goat goat=goatFactory.selGoatById(goatId);
        goat.moveDown();
    }

}
