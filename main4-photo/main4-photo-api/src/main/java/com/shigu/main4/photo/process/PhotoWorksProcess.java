package com.shigu.main4.photo.process;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.bo.SynPhotoUploadBO;
import com.shigu.main4.photo.exceptions.PhotoException;
import com.shigu.main4.photo.vo.*;

import java.util.List;

public interface PhotoWorksProcess {
    /**
     * 获取公共风格
     *
     * @param userId 用户ID,传递了该值时,会额外查出用户自定义的风格
     * @return
     */
    List<PhotoStyleVO> selPhotoStyleVos(Long userId);

    /**
     * 获取类目
     *
     * @return
     */
    List<PhotoCatVO> selPhotoCatVos();


    PhotoWorksUpdateVO selPhotoSingel(Long worksId);

    /**
     * 上传作品
     *
     * @param bo
     */
    void uploadWorks(SynPhotoUploadBO bo) throws PhotoException;

    /**
     * 获取作品列表
     *
     * @return
     */
    ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo) throws PhotoException;

    /**
     * 获取作品详情
     *
     * @param worksId 作品id
     * @return
     */
    PhotoWorkDetailVO selPhotoWorkDetail(Long worksId);

    /**
     * 获取单作品点击量
     *
     * @param worksId
     * @return
     */
    PhotoWorksClickVO getClicks(Long worksId);

    /**
     * 增加并获取单作品点击量
     *
     * @param worksId
     * @return
     */
    PhotoWorksClickVO incrementClicks(Long worksId);

    /**
     * 固化点击量
     */
    void fixClicks();



}
