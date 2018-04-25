package com.shigu.photo.process;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.SynPhotoUploadBO;
import com.shigu.photo.vo.PhotoCatVO;
import com.shigu.photo.vo.PhotoStyleVO;
import com.shigu.photo.vo.PhotoWorksVO;

import java.util.List;

public interface PhotoWorksProcess {
    /**
     * 获取公共风格
     * @param userId 用户ID,传递了该值时,会额外查出用户自定义的风格
     * @return
     */
    List<PhotoStyleVO> selPhotoStyleVos(Long userId);

    /**
     * 获取类目
     * @return
     */
    List<PhotoCatVO> selPhotoCatVos();

    /**
     * 上传作品
     * @param bo
     */
    void uploadWorks(SynPhotoUploadBO bo);

    /**
     * 获取作品列表
     * @return
     */
    ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo);
}
