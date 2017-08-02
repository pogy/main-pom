package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_activeDrawRecordMapper")
@Scope("singleton")
@Lazy(true)
public interface ActiveDrawRecordMapper extends Mapper<ActiveDrawRecord> {

    /** 用户抽奖数据 */
    List<ActiveDrawRecord> selDrawRecordList(@Param("pemId") Long pemId, @Param("userId") Long userId,
                                             @Param("type") String type, @Param("ward") String ward,
                                             @Param("userNick") String userNick, @Param("startRows")Integer startRows,
                                             @Param("endRows")Integer endRows);

    /** 用户抽奖数据数 */
    int selDrawRecordCount(@Param("pemId") Long pemId, @Param("userId") Long userId,
                           @Param("ward") String ward, @Param("userNick") String userNick);


}
