package com.opentae.data.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.photo.beans.ShiguPhotoUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_photo_shiguPhotoUserMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoUserMapper extends Mapper<ShiguPhotoUser> {
}
