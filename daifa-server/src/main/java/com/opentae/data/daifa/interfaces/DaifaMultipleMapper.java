package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.mapper.MapperProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 *
 * Created by bugzy on 2017/8/1 0001.
 */
@MyBatisRepository("tae_daifa_multipleMapper")
public interface DaifaMultipleMapper {

    /**
     * 多表关联查询
     * @param sgExample
     * @param clazz
     * @param <E>
     * @return
     */
    @SelectProvider(type = MapperProvider.class, method = "dynamicSQL")
    <E> List<E> selectFieldsByMultipleExample(@Param("example") MultipleExample sgExample, @Param("clazz") Class<E> clazz);
}
