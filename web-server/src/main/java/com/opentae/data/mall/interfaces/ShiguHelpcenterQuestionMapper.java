package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguHelpcenterQuestionMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguHelpcenterQuestionMapper extends Mapper<ShiguHelpcenterQuestion> {
    List<ShiguHelpcenterQuestion> search(String keyword);
    void del(ShiguHelpcenterQuestion shiguHelpcenterQuestion) throws Exception;
    void save(ShiguHelpcenterQuestion shiguHelpcenterQuestion) throws Exception;
    void updata(ShiguHelpcenterQuestion shiguHelpcenterQuestion) throws Exception;
}
