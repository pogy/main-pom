package com.shigu.main4.goat.service.impl;

import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;

import java.util.List;

/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
public class GoatFactoryImpl implements GoatFactory{

    @Override
    public GoatLocation getALocation(String code) {
        return new GoatLocation() {
            @Override
            public List<Goat> selGoats() {
                return null;
            }
        };
    }

    @Override
    public GoatLocation getALocationByVo(GoatLocationVO vo) {
        return null;
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) {
        return null;
    }

    @Override
    public <T extends Goat> T selGoatByVo(GoatVO goatVO) {
        return null;
    }
}
