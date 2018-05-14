package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguFlickr;
import com.shigu.main4.vo.FlickrDetails;
import com.shigu.main4.vo.FlickrHomeVo;
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

    Integer countFlickrPicture(@Param("fId") Long fId,@Param("status") Integer status);

    List<FlickrShow> selectFlickrByShop(@Param("shopId") Long shopId,@Param("cId") Long cId,@Param("webSite") String webSite,@Param("status") Integer status,@Param("start") Integer start,@Param("size") Integer size);

    List<FlickrHomeVo> selectFlickrByCategory(@Param("cId") Long cId, @Param("webSite") String webSite, @Param("status") Integer status, @Param("start") Integer start, @Param("size") Integer size);

    FlickrDetails selectFlickrPictureByfId(@Param("fId") Long fId, @Param("status") Integer status);

    Integer countFlickr(@Param("status") Integer status);

   List<String> selectPicTwo(@Param("fId") Long fId, @Param("status") Integer status);
}
