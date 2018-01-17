package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;

import java.util.List;

public interface LevelOneService {
    List<ShiguHelpcenterLevel1> getAll();
    /**
     * 通过主键获得该类
     * @param gid
     * @return
     */
    ShiguHelpcenterLevel1 getByPk(int gid);
    /**
     *通过name字段获取主键
     * @param name
     * @return
     */
    Integer getPkByName(String name);
    String save(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
    String del(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
    String updata(ShiguHelpcenterLevel1 shiguHelpcenterLevel1);
}
