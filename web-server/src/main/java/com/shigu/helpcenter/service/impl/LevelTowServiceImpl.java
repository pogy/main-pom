package com.shigu.helpcenter.service.impl;



import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;
import com.opentae.data.mall.examples.ShiguHelpcenterLevel2Example;
import com.opentae.data.mall.interfaces.ShiguHelpcenterLevel2Mapper;
import com.shigu.helpcenter.service.LevelTwoService;
import com.sun.tools.javah.LLNI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("levelTwoService")
public class LevelTowServiceImpl implements LevelTwoService {

    private static final Logger logger = LoggerFactory.getLogger(LevelTowServiceImpl.class);

    @Autowired
    private ShiguHelpcenterLevel2Mapper shiguHelpcenterLevel2Mapper;

    @Override
    public List<ShiguHelpcenterLevel2> getAll() {
        ShiguHelpcenterLevel2Example example = new ShiguHelpcenterLevel2Example();
        example.createCriteria();
        List<ShiguHelpcenterLevel2> shiguHelpcenterLevel2s = shiguHelpcenterLevel2Mapper.selectByExample(example);
        if (shiguHelpcenterLevel2s != null){
            return shiguHelpcenterLevel2s;
        }
        return null;
    }

    @Override
    public List<ShiguHelpcenterLevel2> getLevelTowByGid(int gid) {
        ShiguHelpcenterLevel2Example example = new ShiguHelpcenterLevel2Example();
        example.createCriteria().andGidEqualTo(gid);
        List<ShiguHelpcenterLevel2> shiguHelpcenterLevel2s = shiguHelpcenterLevel2Mapper.selectByExample(example);
        if (shiguHelpcenterLevel2s != null){
            return shiguHelpcenterLevel2s;
        }
        return null;
    }

    @Override
    public ShiguHelpcenterLevel2 getByPk(int cid) {
        ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = shiguHelpcenterLevel2Mapper.selectByPrimaryKey(cid);
        if (shiguHelpcenterLevel2 != null){
            return shiguHelpcenterLevel2;
        }
        return null;
    }

    @Override
    public Integer getPkByName(String name) {
        ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = new ShiguHelpcenterLevel2();
        shiguHelpcenterLevel2.setName(name);
        ShiguHelpcenterLevel2 selectOne = shiguHelpcenterLevel2Mapper.selectOne(shiguHelpcenterLevel2);
        if (selectOne != null){
            return selectOne.getCid();
        }
        return null;
    }
    @Transactional
    @Override
    public String save(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) {
        String msg = "error";
        try {
            shiguHelpcenterLevel2Mapper.save(shiguHelpcenterLevel2);
            msg = "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return msg;
    }
    @Transactional
    @Override
    public String del(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) {
        String msg = "error";
        try {
            shiguHelpcenterLevel2Mapper.del(shiguHelpcenterLevel2);
            msg = "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return msg;
    }
    @Transactional
    @Override
    public String updata(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) {
        String msg = "error";
        try {
            shiguHelpcenterLevel2Mapper.updata(shiguHelpcenterLevel2);
            msg = "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return msg;
    }

}
