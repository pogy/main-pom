package com.shigu.main4.photo.process;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.photo.bo.AuthApplySearchBO;
import com.shigu.main4.photo.bo.PhotoAuthApplyBO;
import com.shigu.main4.photo.bo.PhotoUserInfoEditBO;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.vo.AuthApplyInfoVO;
import com.shigu.main4.photo.vo.PhotoAuthorVO;
import com.shigu.main4.photo.vo.PhotoUserStatisticVO;
import com.shigu.main4.photo.vo.PhotoUserVO;

/**
 * 路径: PhotoUserProcess
 * 工程: main-pom
 * 时间: 18-4-25 下午2:43
 * 创建人: wanghaoxiang
 * 描述: 摄影基地用户处理
 */
public interface PhotoUserProcess {

    /**
     * 用户基础信息
     *
     * @param userId
     * @return
     */
    PhotoUserVO userBaseInfo(Long userId);

    /**
     * 作者详细信息，包括统计数据
     *
     * @param userId
     * @return
     */
    PhotoUserStatisticVO authStatisticInfo(Long userId);

    /**
     * 点赞
     *
     * @param userId
     * @param worksId
     */
    void praiseWork(Long userId, Long worksId);

    /**
     * 取消点赞
     *
     * @param userId
     * @param worksId
     */
    void praiseWorkCancel(Long userId, Long worksId);

    /**
     * 用户是否已关注作者
     *
     * @param userId 用户id
     * @param authId 作者用户id
     * @return
     */
    boolean isFollowed(Long userId, Long authId);

    /**
     * 用户是否已点赞作品
     *
     * @param userId  用户id
     * @param worksId 作品id
     * @return
     */
    boolean isPraised(Long userId, Long worksId);

    /**
     * 申请身份认证
     *
     * @param userId
     * @param bo
     */
    void authApply(Long userId, PhotoAuthApplyBO bo) throws JsonErrException;

    /**
     * 身份认证通过
     *
     * @param userId
     * @param logMessage
     */
    void applyPass(Long userId, String logMessage);

    /**
     * 拒绝身份认证
     *
     * @param userId
     * @param logMessage
     */
    void applyRefuse(Long userId, String logMessage);


    /**
     * 编辑用户信息，为空的字段忽略
     *
     * @param userId
     * @param bo
     */
    void editUserInfo(Long userId, PhotoUserInfoEditBO bo);

    /**
     * 获取作者列表
     * @param bo
     * @return
     */
    ShiguPager<PhotoAuthorVO> selAuthors(PhotoWorksBO bo);

    /**
     * 查询身份认证申请列表
     *
     * @param bo 查询条件
     * @param pageNo 页码
     * @param size 分页大小
     * @return
     */
    ShiguPager<AuthApplyInfoVO> selApplyInfo(AuthApplySearchBO bo, int pageNo, int size);
}
