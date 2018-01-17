package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.List;

public interface LevelTwoService {
    List<ShiguHelpcenterLevel2> getAll();
    List<ShiguHelpcenterLevel2> getLevelTowByGid(int gid);
    ShiguHelpcenterLevel2 getByPk(int cid);
    Integer getPkByName(String name);
    String save(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
    String del(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
    String updata(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
}
