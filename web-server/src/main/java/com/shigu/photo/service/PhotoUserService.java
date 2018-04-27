package com.shigu.photo.service;

import com.shigu.main4.tools.RedisIO;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.vo.PhotoAuthWorkUserInfoWebVO;
import com.shigu.photo.vo.PhotoUserStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 路径: com.shigu.photo.service.PhotoUserService
 * 工程: main-pom
 * 时间: 18-4-27 下午7:07
 * 创建人: wanghaoxiang
 * 描述:
 */
@Service
public class PhotoUserService {

    @Autowired
    private PhotoUserProcess photoUserProcess;

    @Autowired
    private RedisIO redisIO;

    // 摄影基地用户认证验证码前缀
    private final String PHOTO_USER_VALID_MSG_PREFIX = "photo_user_valid_msg_";

    public PhotoAuthWorkUserInfoWebVO baseUserInfo(Long userId) {
        if (userId == null) {
            return null;
        }
        PhotoAuthWorkUserInfoWebVO userInfo = new PhotoAuthWorkUserInfoWebVO();
        userInfo.setUserId(userId);
        PhotoUserStatisticVO totalAuthInfo = photoUserProcess.authStatisticInfo(userId);
        String authType = "未知";
        if (totalAuthInfo != null) {
            userInfo.setNick(totalAuthInfo.getUserName());
            userInfo.setImgSrc(totalAuthInfo.getHeadImg());
            userInfo.setTele(totalAuthInfo.getContactPhone());
            userInfo.setAddress(totalAuthInfo.getAddress());
            userInfo.setWxQrImgSrc(totalAuthInfo.getCodeImg());
            userInfo.setWorksCount(totalAuthInfo.getWorksCount());
            authType = selAuthType(totalAuthInfo.getUserType(), totalAuthInfo.getSubUserType());
        }
        userInfo.setTypeName(authType);
        return userInfo;
    }


    /**
     * 作者详细信息
     *
     * @param authorId
     * @param userId
     * @return
     */
    public PhotoAuthWorkUserInfoWebVO totalAuthInfo(Long authorId, Long userId) {
        if (authorId == null) {
            return null;
        }
        PhotoAuthWorkUserInfoWebVO vo = baseUserInfo(authorId);
        if (vo == null) {
            return null;
        }
        vo.setFocusOnIs(false);
        if (userId != null) {
            vo.setFocusOnIs(photoUserProcess.isFollowed(userId, authorId));
        }
        return vo;
    }

    /**
     * 分析用户类型
     *
     * @param userType
     * @param subUserType
     * @return
     */
    public static String selAuthType(Integer userType, Integer subUserType) {
        String authType = "未知";
        if (subUserType == null) {
            subUserType = 0;
        }
        switch (userType) {
            case 0:
                authType = "普通用户";
                break;
            //模特
            case 1:
                authType = "模特";
                if (subUserType == 1) {
                    authType = "男模";
                } else if (subUserType == 2) {
                    authType = "女模";
                }
                break;
            //摄影机构
            case 2:
                if (subUserType == 1) {
                    authType = "摄影师";
                } else if (subUserType == 2) {
                    authType = "摄影公司";
                }
                break;
            //摄影场地
            case 3:
                authType = "场地";
                break;
        }
        return authType;
    }


}
