package com.opentae.data.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.photo.beans.ShiguPhotoUser;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_photo_shiguPhotoUserMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoUserMapper extends Mapper<ShiguPhotoUser> {
    List<ShiguPhotoUser> selectOderByTime(@Param("bo") PhotoWorksBO photoWorksBO, @Param("authIds") List<Long> authIds,@Param("start")int start);
}
