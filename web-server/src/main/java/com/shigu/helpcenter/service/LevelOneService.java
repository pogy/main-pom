package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;

import java.util.List;

public interface LevelOneService {
    List<ShiguHelpcenterLevel1> getAll();
    ShiguHelpcenterLevel1 getByPk(int gid);
    Integer getPkByName(String name);
    String save(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
    String del(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
    String updata(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
}
