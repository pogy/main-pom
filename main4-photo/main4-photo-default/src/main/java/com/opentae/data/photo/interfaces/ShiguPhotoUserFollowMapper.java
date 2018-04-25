package com.opentae.data.photo.interfaces;

import com.opentae.data.photo.beans.ShiguPhotoUserFollow;
import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_com.opentae.photo_shiguPhotoUserFollowMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoUserFollowMapper extends Mapper<ShiguPhotoUserFollow> {
}
