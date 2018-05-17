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

    /**
     * 查询单个作品,用于编辑
     * @param worksId
     * @return
     */
    PhotoWorksUpdateVO selPhotoSingel(Long worksId);

    /**
     * 上传作品
     *
     * @param bo
     */
    void uploadWorks(SynPhotoUploadBO bo) throws PhotoException;

    /**
     * 删除作品
     * @param worksId
     */
    void removeWorks(Long worksId,Long userId);

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

    /**
     * 获取申请列表
     * @param pageNo
     * @param size
     * @param status 0：未审核 1：审核通过， 2：驳回
     * @return
     */
    ShiguPager<PhotoWorksAuthVO> selWorksAuths(int pageNo, int size,Integer status);

    /**
     * 审核
     * @param worksAuthId
     * @param applyStatus 0：未审核 1：审核通过， 2：驳回
     */
    void useAuth(Long worksAuthId,String msg, int applyStatus);

}
