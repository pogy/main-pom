package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguFlickr;
import com.shigu.main4.vo.FlickrDetails;
import com.shigu.main4.vo.FlickrShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguFlickrMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguFlickrMapper extends Mapper<ShiguFlickr> {

    int countFlickrPicture(@Param("fId") Long fId);

    List<FlickrShow> selectFlickrByCategory(@Param("cId") Long cId,@Param("webSite") String webSite,@Param("status") Integer status);

    FlickrDetails selectFlickrPictureByfId(@Param("fId") Long fId, @Param("status") Integer status);
}
