package com.opentae.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.photo.beans.ShiguPhotoUserPraise;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_com.opentae.photo_shiguPhotoUserPraiseMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoUserPraiseMapper extends Mapper<ShiguPhotoUserPraise> {
}
