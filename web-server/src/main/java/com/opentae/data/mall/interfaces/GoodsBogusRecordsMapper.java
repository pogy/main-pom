package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsBogusRecords;
import com.shigu.seller.vo.DataListVO;
import com.shigu.seller.vo.WeekReadDataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsBogusRecordsMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsBogusRecordsMapper extends Mapper<GoodsBogusRecords> {

    List<WeekReadDataVO> qzIndexCount(@Param("shopId") Long shopId, @Param("webSite")String webSite, @Param("num")Integer num);

    List<DataListVO> qzIndexCountForDay(@Param("shopId") Long shopId, @Param("webSite")String webSite, @Param("day")String day);
}
