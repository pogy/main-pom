package com.shigu.photo.process;

import com.shigu.photo.vo.PhotoUserStatisticVO;
import com.shigu.photo.vo.PhotoUserVO;

/**
 * 路径: com.shigu.photo.process.PhotoUserProcess
 * 工程: main-pom
 * 时间: 18-4-25 下午2:43
 * 创建人: wanghaoxiang
 * 描述: 摄影基地用户处理
 */
public interface PhotoUserProcess {

    /**
     * 用户基础信息
     * @param userId
     * @return
     */
    PhotoUserVO userBaseInfo(Long userId);

    /**
     * 作者详细信息，包括统计数据
     * @param userId
     * @return
     */
    PhotoUserStatisticVO authStatisticInfo(Long userId);

    /**
     * 点赞
     * @param userId
     * @param worksId
     */
    void PraiseWork(Long userId, Long worksId);

    /**
     * 取消点赞
     * @param userId
     * @param worksId
     */
    void PraiseWorkCancel(Long userId, Long worksId);

    /**
     * 用户是否已关注作者
     * @param userId 用户id
     * @param authId 作者用户id
     * @return
     */
    boolean isFollowed(Long userId, Long authId);

    /**
     * 用户是否已点赞作品
     * @param userId 用户id
     * @param worksId 作品id
     * @return
     */
    boolean isPraised(Long userId, Long worksId);
}
