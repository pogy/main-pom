package com.shigu.main4.storeservices;

import com.opentae.data.mall.beans.ShiguFlickr;
import com.shigu.main4.bo.FlickrAddBo;
import com.shigu.main4.vo.FlickrDetailsVo;
import com.shigu.main4.vo.FlickrInfoVo;
import com.shigu.main4.vo.FlickrPictureVo;
import com.shigu.main4.vo.FlickrVo;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.storeservices
 * @ClassName: FlickrManageService
 * @Author: sy
 * @CreateDate: 2018/4/28 0028 14:52
 */
public interface FlickrManageService {
    /**
     * 添加一个相册
     * @param name
     * @param storeId
     * @return
     */
    Integer addFlickr(String name,Long cId ,String desc , Long storeId ,String webSite);

    /**
     * 修改一个相册
     * @param name
     * @param fId
     * @return
     */
    Integer updateFlickr(Long fId,String name,Long cId ,String desc);

    /**
     * 删除一个相册
     * @param fId
     * @return
     */
    Integer deleteFlickr(Long fId);

    /**
     * 店铺后台获取所有相册
     * @param storeId
     * @return
     */
    List<FlickrVo> getStroeFlickrbyStoreId(Long storeId);

    /**
     * 获取相册里的所有图片
     * @param fId
     * @return
     */
    List<FlickrPictureVo> getFlickrPictureList(Long fId);

    /**
     * 批量添加相册图片
     * @param fId
     * @param picUrlList
     * @return
     */
    Integer addFlickrPicture(Long fId , List<String> picUrlList);

    /**
     * 删除相册图片
     * @param picId
     * @return
     */
    Integer deleteFlickrPicture(Long picId);

    /**
     * 获取相册编辑信息
     * @param fId
     * @return
     */
    FlickrInfoVo getFlickrEditInfo(Long fId);

    /**
     * 获取图片库类目相册
     * @param cId
     * @return
     */
    List<FlickrVo> getFlickrbyCategory(Long cId);

    /**
     * 获取相册的展示信息
     * @param fId
     * @return
     */
    FlickrDetailsVo getFlickrShow(Long fId);

}
