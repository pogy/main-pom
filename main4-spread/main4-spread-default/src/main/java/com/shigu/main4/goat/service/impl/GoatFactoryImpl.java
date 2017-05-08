package com.shigu.main4.goat.service.impl;

import com.opentae.data.mall.beans.GoatOneLocation;
import com.opentae.data.mall.examples.GoatOneItemExample;
import com.opentae.data.mall.examples.GoatOneLocationExample;
import com.opentae.data.mall.interfaces.GoatOneLocationMapper;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service
public class GoatFactoryImpl implements GoatFactory{

    @Autowired
    GoatOneLocationMapper goatOneLocationMapper;

    /**
     * 查一个广告位
     * @param code 广告编号
     * @return 广告位对象
     * @throws ActivityException
     */
    @Override
    public GoatLocation getALocation(String code) throws ActivityException {
        GoatOneLocationExample example=new GoatOneLocationExample();
        example.createCriteria().andLocalCodeEqualTo(code).andDisEnabledEqualTo(false);
        example.setStartIndex(0);
        example.setEndIndex(1);
        List<GoatOneLocation> locations=goatOneLocationMapper.selectByConditionList(example);
        if(locations.size()==0){
            throw new ActivityException("获取广告位置["+code+"]失败");
        }
        return getALocationByVo(BeanMapper.map(locations.get(0),GoatLocationVO.class));
    }

    @Override
    public GoatLocation getALocationByVo(GoatLocationVO vo) {
        GoatLocation location=new GoatLocation() {
            @Override
            public <T extends GoatVO> List<T> selGoats() {
                return null;
            }

            @Override
            public <T extends GoatVO> List<T> selPrepareGoats() {
                return null;
            }
        };
        return BeanMapper.map(vo,location);
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) {
        return null;
    }

    @Override
    public <T extends Goat,D extends GoatVO> T selGoatByVo(D goatVO) {

        return null;
    }


}
