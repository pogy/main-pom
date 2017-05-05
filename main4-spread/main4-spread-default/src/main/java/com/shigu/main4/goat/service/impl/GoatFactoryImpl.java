package com.shigu.main4.goat.service.impl;

import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ImgGoat;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service
public class GoatFactoryImpl implements GoatFactory{


    @Override
    public GoatLocation getALocation(String code) {
        return null;
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
    public <T extends Goat,D extends GoatVO> T selGoatByVo(D goatVO) {
        return null;
    }

}
