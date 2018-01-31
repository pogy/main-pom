package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguNewActiveParticipantsMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguNewActiveParticipantsMapper extends Mapper<ShiguNewActiveParticipants> {

    int increaseUploadNum(@Param("memberId") Long memberId, @Param("activeId") Long activeId);
}
