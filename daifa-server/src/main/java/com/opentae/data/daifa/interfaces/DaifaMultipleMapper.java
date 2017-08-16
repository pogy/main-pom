package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.mapper.MapperProvider;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 *
 * Created by bugzy on 2017/8/1 0001.
 */
@MyBatisRepository("tae_daifa_multipleMapper")
public interface DaifaMultipleMapper extends MultipleMapper {

}
