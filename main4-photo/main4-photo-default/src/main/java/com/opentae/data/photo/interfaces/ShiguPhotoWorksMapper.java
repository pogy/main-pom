package com.opentae.data.photo.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.photo.beans.ShiguPhotoWorks;
import com.shigu.photo.vo.PhotoWorksVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_photo_shiguPhotoWorksMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPhotoWorksMapper extends Mapper<ShiguPhotoWorks> {

    List<PhotoWorksVO> selectShiguPhotoWorks(@Param("styleId")Long styleId,
                                             @Param("userType")Integer userType,
                                             @Param("subUserType")Integer subUserType,
                                             @Param("start")Integer start,
                                             @Param("end")Integer end);

    Integer selectShiguPhotoWorksCount(@Param("styleId")Long styleId,
                                       @Param("userType")Integer userType,
                                       @Param("subUserType")Integer subUserType);
}
