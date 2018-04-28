package com.shigu.photo.service;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.tools.RedisIO;
import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.bo.PhotoUserValidBO;
import com.shigu.photo.process.PhotoImgProcess;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.vo.PhotoAuthWorkUserInfoWebVO;
import com.shigu.photo.vo.PhotoUserStatisticVO;
import com.shigu.services.SendMsgService;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.RedomUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
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
    private SendMsgService sendMsgService;

    @Autowired
    private PhotoImgProcess photoImgProcess;

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
            userInfo.setProfile(totalAuthInfo.getUserInfo());
            userInfo.setWorksCount(totalAuthInfo.getWorksCount());
            authType = selAuthType(totalAuthInfo.getUserType(), totalAuthInfo.getSex());
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
     * @param sex
     * @return
     */
    public static String selAuthType(Integer userType, Integer sex) {
        String authType = "未知";
        if (sex == null) {
            sex = 0;
        }
        switch (userType) {
            case 0:
                authType = "普通用户";
                break;
            //模特
            case 1:
                authType = "模特";
                if (sex == 1) {
                    authType = "男模";
                } else if (sex == 2) {
                    authType = "女模";
                }
                break;
            //摄影机构 2 摄影师 3 摄影公司
            case 2:
                authType = "摄影师";
                break;

            case 3:
                authType = "摄影公司";
                break;
            //摄影场地
            case 4:
                authType = "场地";
                break;
        }
        return authType;
    }

    /**
     * 发送短信验证码
     */
    public void sendValidCodeMsg(Long userId, String telephone) {
        String code = RedomUtil.redomNumber(6);
        //验证码有效期10分钟
        redisIO.putTemp(PHOTO_USER_VALID_MSG_PREFIX + userId + telephone, code, 10 * 60);
    }

    /**
     * 提交身份认证申请
     * @param userId
     * @param validBO
     * @return
     * @throws JsonErrException
     */
    public JSONObject submitUserValid(Long userId, PhotoUserValidBO validBO) throws JsonErrException {
        if (userId == null) {
            return JsonResponseUtil.error("请先登陆");
        }
        if (StringUtils.isBlank(validBO.getMsgCode())
                || StringUtils.isBlank(validBO.getWorkphone())
                || !validBO.getMsgCode().equals(redisIO.get(PHOTO_USER_VALID_MSG_PREFIX + userId + validBO.getWorkphone()))) {
            return JsonResponseUtil.error("验证码错误");
        }
        if (validBO.getRoleStyle() == null|| validBO.getRoleStyle() < 1) {
            return JsonResponseUtil.error("无效的身份");
        }
        PhotoAuthApplyBO bo = new PhotoAuthApplyBO();
        bo.setUserName(validBO.getUsername());
        bo.setAuthPhone(validBO.getWorkphone());
        bo.setAuthType(validBO.getRoleStyle());
        if (StringUtils.isNotBlank(validBO.getWxQrCode())) {
            String wxCodeImg = photoImgProcess.moveImg(validBO.getMsgCode());
            bo.setCodeImg(wxCodeImg);
        }
        if (StringUtils.isNotBlank(validBO.getUserCover())) {
            String showImg = photoImgProcess.moveImg(validBO.getUserCover());
            bo.setShowImg(showImg);
        }
        bo.setMainStyleId(validBO.getStyles());
        photoUserProcess.authApply(userId, bo);
        return JsonResponseUtil.success();
    }

}
