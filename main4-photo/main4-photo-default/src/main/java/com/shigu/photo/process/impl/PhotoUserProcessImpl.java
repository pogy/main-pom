package com.shigu.photo.process.impl;

import com.opentae.data.photo.beans.ShiguPhotoUserFollow;
import com.opentae.data.photo.beans.ShiguPhotoUserPraise;
import com.opentae.data.photo.interfaces.ShiguPhotoUserFollowMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoUserPraiseMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.model.PhotoUserModel;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.vo.PhotoUserStatisticVO;
import com.shigu.photo.vo.PhotoUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 路径: com.shigu.photo.process.impl.PhotoUserProcessImpl
 * 工程: main-pom
 * 时间: 18-4-26 下午2:49
 * 创建人: wanghaoxiang
 * 描述:
 */
@Service("photoUserProcess")
public class PhotoUserProcessImpl implements PhotoUserProcess {

    @Autowired
    private ShiguPhotoUserFollowMapper shiguPhotoUserFollowMapper;

    @Autowired
    private ShiguPhotoUserPraiseMapper shiguPhotoUserPraiseMapper;

    /**
     * 基本用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public PhotoUserVO userBaseInfo(Long userId) {
        if (userId == null) {
            return null;
        }
        return getUserModel(userId).photoUserInfo();
    }

    /**
     * 详细作者信息，包括统计值
     *
     * @param userId
     * @return
     */
    @Override
    public PhotoUserStatisticVO authStatisticInfo(Long userId) {
        if (userId == null) {
            return null;
        }
        return getUserModel(userId).photoUserTotalInfo();
    }

    /**
     * 点赞作品
     *
     * @param userId
     * @param worksId
     */
    @Override
    public void praiseWork(Long userId, Long worksId) {
        changeUserPraise(userId, worksId, 1);
    }

    /**
     * 取消点赞
     *
     * @param userId
     * @param worksId
     */
    @Override
    public void praiseWorkCancel(Long userId, Long worksId) {
        changeUserPraise(userId, worksId, 0);
    }

    /**
     * 改变用户点赞状态
     *
     * @param userId  用户id
     * @param worksId 作品id
     * @param status  0无效 1有效
     */
    protected void changeUserPraise(Long userId, Long worksId, Integer status) {
        if (userId == null || worksId == null || status == null) {
            return;
        }
        ShiguPhotoUserPraise praise = new ShiguPhotoUserPraise();
        praise.setUserId(userId);
        praise.setWorksId(worksId);
        ShiguPhotoUserPraise record = shiguPhotoUserPraiseMapper.selectOne(praise);
        if (record != null) {
            // 如果已经是该状态，直接返回
            if (status.equals(record.getStatus())) {
                return;
            }
            praise = record;
        }
        praise.setStatus(status);
        if (praise.getPraiseId() == null) {
            shiguPhotoUserPraiseMapper.insertSelective(praise);
        } else {
            shiguPhotoUserPraiseMapper.updateByPrimaryKeySelective(praise);
        }
    }

    @Override
    public boolean isFollowed(Long userId, Long authId) {
        if (userId == null || authId == null) {
            return false;
        }
        ShiguPhotoUserFollow query = new ShiguPhotoUserFollow();
        query.setUserId(userId);
        query.setFollowUserId(authId);
        query.setStatus(1);
        return shiguPhotoUserFollowMapper.selectCount(query) > 0;
    }

    @Override
    public boolean isPraised(Long userId, Long worksId) {
        if (userId == null || worksId == null) {
            return false;
        }
        ShiguPhotoUserPraise query = new ShiguPhotoUserPraise();
        query.setUserId(userId);
        query.setWorksId(worksId);
        query.setStatus(1);
        return shiguPhotoUserPraiseMapper.selectCount(query) > 0;
    }

    @Override
    public void authApply(Long userId, PhotoAuthApplyBO bo) throws JsonErrException {
        getUserModel(userId).authApply(bo);
    }

    @Override
    public void applyPass(Long userId, String logMessage) {
        getUserModel(userId).applyPass(logMessage);
    }

    @Override
    public void applyRefuse(Long userId, String logMessage) {
        getUserModel(userId).applyRefuse(logMessage);
    }

    /**
     * 获取用户处理对象
     *
     * @param userId
     * @return
     */
    public PhotoUserModel getUserModel(Long userId) {
        // 实际userId为null状态状况下不应该走到这一步，这里可以换成抛出异常
        if (userId == null) {
            return null;
        }
        return SpringBeanFactory.getBean(PhotoUserModel.class, userId);
    }
}
