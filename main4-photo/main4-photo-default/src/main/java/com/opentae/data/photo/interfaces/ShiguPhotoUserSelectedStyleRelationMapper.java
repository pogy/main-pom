package com.opentae.data.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.photo.beans.ShiguPhotoUserSelectedStyleRelation;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_photo_shiguPhotoUserSelectedStyleRelationMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoUserSelectedStyleRelationMapper extends Mapper<ShiguPhotoUserSelectedStyleRelation> {
}
