package com.shigu.main4.goat.service.impl;

import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.GoatActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.ActivityFactory;
import com.shigu.main4.activity.vo.GoatSimpleVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatIntermVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        ActivityTerm term=activityFactory.selTermByTime(ActivityType.GOAT_SELL,new Date());
        if (term != null) {
            GoatIntermVO g=parseGoatVOByTermId(term.getTermId(),location);
            if (g != null) {
                result.add(g);
            }
        }
        //查排期中的
        ActivityTerm paiqi=activityFactory.selTermInPaiqi(ActivityType.GOAT_SELL);
        if (paiqi != null) {
            GoatIntermVO g=parseGoatVOByTermId(paiqi.getTermId(),location);
            if (g != null) {
                result.add(g);
            }
        }
        return result;
    }

    private GoatIntermVO parseGoatVOByTermId(Long termId,GoatLocation location) throws GoatException {
//        List<GoatVO> goatsInterms=location.selGoatsByTermId(termId);
//        if (goatsInterms != null) {
//            GoatIntermVO g=new GoatIntermVO();
//            g.setType(1);
//            g.setGoats(goatsInterms);
//            return g;
//        }
        return null;
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
