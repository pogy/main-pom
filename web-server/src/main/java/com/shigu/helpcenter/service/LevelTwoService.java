package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.List;

public interface LevelTwoService {
    List<ShiguHelpcenterLevel2> getAll();

    /**
     * 查询所有符合条件（gid）的数据
     * @param gid
     * @return
     */
    List<ShiguHelpcenterLevel2> getLevelTowByGid(int gid);

    /**
     * 通过主键获取该类
     * @param cid
     * @return
     */
    ShiguHelpcenterLevel2 getByPk(int cid);

    /**
     * 通过name字段获取主键
     * @param name
     * @return
     */
    Integer getPkByName(String name);
    String save(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
    String del(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
    String updata(ShiguHelpcenterLevel2 shiguHelpcenterLevel2);
}
