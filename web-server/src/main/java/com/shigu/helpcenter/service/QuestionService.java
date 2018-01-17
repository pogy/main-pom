package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.List;

public interface QuestionService {
    List<ShiguHelpcenterQuestion> getAll();
    List<ShiguHelpcenterQuestion> getTitleByCid(int cid);

    /**
     * 查询所有符合条件（gid，cid）的数据
     * @param gid
     * @param cid
     * @return
     */
    List<ShiguHelpcenterQuestion> getTitleByGidAndCid(int gid,int cid);
    String getAnswerById(int id);
    /**
     * 通过name字段获取主键
     * @param name
     * @return
     */
    Integer getPkByTitle(String name);
    /**
     * 通过主键获取该类
     * @param id
     * @return
     */
    ShiguHelpcenterQuestion getByPk(int id);
    List<ShiguHelpcenterQuestion> search(String keyword);
    String save(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
    String del(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
    String updata(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
}
