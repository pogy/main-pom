package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsBogusUploadRecords;
import com.shigu.seller.vo.DataListVO;
import com.shigu.seller.vo.DownlaodDataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsBogusUploadRecordsMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsBogusUploadRecordsMapper extends Mapper<GoodsBogusUploadRecords> {
    List<DataListVO> qzIndexDownCountGroupDay(@Param("shopId") Long shopId, @Param("webSite")String webSite, @Param("day")String day);

    List<DownlaodDataVO> qzIndexDownCountForDayGroupItem(@Param("shopId") Long shopId, @Param("webSite")String webSite, @Param("day")String day);

    Integer qzIndexDownCountForDay(@Param("shopId") Long shopId, @Param("webSite")String webSite, @Param("day")String day);
}
