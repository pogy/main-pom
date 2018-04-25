package com.opentae.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.photo.beans.ShiguPhotoWorksStyle;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_com.opentae.photo_shiguPhotoWorksStyleMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoWorksStyleMapper extends Mapper<ShiguPhotoWorksStyle> {
}
