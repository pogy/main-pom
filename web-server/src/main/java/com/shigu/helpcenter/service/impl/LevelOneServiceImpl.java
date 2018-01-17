package com.shigu.helpcenter.service.impl;


import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import com.opentae.data.mall.examples.ShiguHelpcenterLevel1Example;
import com.opentae.data.mall.interfaces.ShiguHelpcenterLevel1Mapper;


import com.shigu.helpcenter.service.LevelOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("levelOneService")
public class LevelOneServiceImpl implements LevelOneService {
    @Autowired
    private ShiguHelpcenterLevel1Mapper shiguHelpcenterLevel1Mapper;

    @Override
    public List<ShiguHelpcenterLevel1> getAll() {
        ShiguHelpcenterLevel1Example example = new ShiguHelpcenterLevel1Example();
        example.createCriteria();
        List<ShiguHelpcenterLevel1> shiguHelpcenterLevel1s = shiguHelpcenterLevel1Mapper.selectByExample(example);
        if (shiguHelpcenterLevel1s != null){
            return shiguHelpcenterLevel1s;
        }
        return null;
    }

    @Override
    public ShiguHelpcenterLevel1 getByPk(int gid) {
        ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = shiguHelpcenterLevel1Mapper.selectByPrimaryKey(gid);
        if (shiguHelpcenterLevel1 != null){
            return shiguHelpcenterLevel1;
        }
        return null;
    }

    @Override
    public Integer getPkByName(String name) {
        ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = new ShiguHelpcenterLevel1();
        shiguHelpcenterLevel1.setName(name);
        ShiguHelpcenterLevel1 selectOne = shiguHelpcenterLevel1Mapper.selectOne(shiguHelpcenterLevel1);
        if (selectOne != null){
            return selectOne.getPid();
        }
        return null;
    }
    @Transactional
    @Override
    public String save(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) {
        String msg = "error";
        try {
            shiguHelpcenterLevel1Mapper.save(shiguHelpcenterLevel1);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @Transactional
    @Override
    public String del(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) {
        String msg = "error";
        try {
            shiguHelpcenterLevel1Mapper.del(shiguHelpcenterLevel1);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @Transactional
    @Override
    public String updata(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) {
        String msg = "error";
        try {
            shiguHelpcenterLevel1Mapper.updata(shiguHelpcenterLevel1);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
