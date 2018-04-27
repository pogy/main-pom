package com.shigu.photo.process;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.SynPhotoUploadBO;
import com.shigu.photo.vo.*;

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

    /**
     * 上传作品
     *
     * @param bo
     */
    void uploadWorks(SynPhotoUploadBO bo);

    /**
     * 获取作品列表
     *
     * @return
     */
    ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo);

    /**
     * 获取作品详情
     *
     * @param worksId 作品id
     * @return
     */
    PhotoWorkDetailVO selPhotoWorkDetail(Long worksId);

    PhotoWorksClickVO getClicks(Long worksId);

    PhotoWorksClickVO incrementClicks(Long worksId);

    /**
     * 固化点击量
     */
    void fixClicks();
}
