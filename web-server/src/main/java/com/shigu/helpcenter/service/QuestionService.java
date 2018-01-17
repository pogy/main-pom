package com.shigu.helpcenter.service;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.List;

public interface QuestionService {
    List<ShiguHelpcenterQuestion> getAll();
    List<ShiguHelpcenterQuestion> getTitleByCid(int cid);
    List<ShiguHelpcenterQuestion> getTitleByGidAndCid(int gid,int cid);
    String getAnswerById(int id);
    Integer getPkByTitle(String name);
    ShiguHelpcenterQuestion getByPk(int id);
    List<ShiguHelpcenterQuestion> search(String keyword);
    String save(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
    String del(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
    String updata(ShiguHelpcenterQuestion shiguHelpcenterQuestion);
}
