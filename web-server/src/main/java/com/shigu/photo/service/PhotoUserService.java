package com.shigu.photo.service;

import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.photo.bo.PhotoAuthApplyBO;
import com.shigu.main4.photo.bo.PhotoUserInfoEditBO;
import com.shigu.main4.photo.process.PhotoImgProcess;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.vo.PhotoUserStatisticVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.photo.bo.PhotoUserProfileEditBO;
import com.shigu.photo.bo.PhotoUserValidBO;
import com.shigu.photo.vo.*;
import com.shigu.services.SendMsgService;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.RedomUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private OrderProvMapper orderProvMapper;

    @Autowired
    private OrderCityMapper orderCityMapper;

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
            userInfo.setWxQrCode(totalAuthInfo.getCodeImg());
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
        sendMsgService.sendVerificationCode(telephone, code);
        redisIO.putTemp(PHOTO_USER_VALID_MSG_PREFIX + userId + telephone, code, 10 * 60);
    }

    /**
     * 提交身份认证申请
     *
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
        if (validBO.getRoleStyle() == null || validBO.getRoleStyle() < 1) {
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
        ArrayList<Long> styleList = new ArrayList<>();
        String stylesStr = validBO.getStyles();
        if (StringUtils.isNotBlank(stylesStr)) {
            String[] styleIdStrArray = StringUtils.split(stylesStr, ',');
            for (String styleIdStr : styleIdStrArray) {
                try {
                    styleList.add(Long.parseLong(styleIdStr));
                } catch (Exception ignore) {
                }
            }
        }
        bo.setMainStyleIds(styleList);
        photoUserProcess.authApply(userId, bo);
        return JsonResponseUtil.success();
    }

    /**
     * 解析用户地址信息
     *
     * @param baseUserInfo
     * @param areaInfo
     * @return
     */
    public PhotoAuthWorkUserInfoWebVO resolveUserAddrInfo(PhotoAuthWorkUserInfoWebVO baseUserInfo, PhotoAreaVO areaInfo) {
        if (baseUserInfo == null) {
            return null;
        }
        String address = baseUserInfo.getAddress();
        if (StringUtils.isBlank(address)) {
            return baseUserInfo;
        }
        PhotoUserInfoForEditVO vo = BeanMapper.map(baseUserInfo, PhotoUserInfoForEditVO.class);
        if (StringUtils.isNotBlank(address)) {
            String[] addressInfoStrs = address.split("-");
            String provStr = addressInfoStrs[0];
            String cityStr = null;
            if (addressInfoStrs.length > 1) {
                cityStr = addressInfoStrs[1];
            }
            for (PhotoProv photoProv : areaInfo.getProvs()) {
                if (photoProv.getProvText().equals(provStr)) {
                    vo.setProvId(photoProv.getProvId());
                    for (PhotoCity photoCity : photoProv.getCitys()) {
                        if (photoCity.getCityText().equals(cityStr)) {
                            vo.setCityId(photoCity.getCityId());
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return vo;
    }

    /**
     * 获取省市地址数据
     *
     * @return
     */
    public PhotoAreaVO provsAndCitys() {
        OrderCity cityQuery = new OrderCity();
        //市信息
        Map<Long, List<PhotoCity>> provCityVOsMap = orderCityMapper.select(cityQuery).stream()
                .collect(Collectors.groupingBy(OrderCity::getProvId,
                        Collectors.mapping(city -> {
                                    PhotoCity cityVO = new PhotoCity();
                                    cityVO.setCityId(city.getCityId());
                                    cityVO.setCityText(city.getCityName());
                                    return cityVO;
                                }, Collectors.toList()
                        )
                ));
        OrderProv provQuery = new OrderProv();
        //省信息
        List<PhotoProv> provsVOs = orderProvMapper.select(provQuery).stream().map(prov -> {
            PhotoProv provVO = new PhotoProv();
            provVO.setProvId(prov.getProvId());
            provVO.setProvText(prov.getProvName());
            provVO.setCitys(provCityVOsMap.get(prov.getProvId()));
            return provVO;
        }).collect(Collectors.toList());
        PhotoAreaVO areaVO = new PhotoAreaVO();
        areaVO.setProvs(provsVOs);
        return areaVO;
    }

    /**
     * 提交用户编辑信息
     *
     * @param userId
     * @param bo
     * @return
     */
    public JSONObject submitProfileInfo(Long userId, PhotoUserProfileEditBO bo) {
        PhotoUserInfoEditBO editBO = new PhotoUserInfoEditBO();
        // 有变更手机号验证码，进行手机号校验
        if (StringUtils.isNotBlank(bo.getMsgValidate())) {
            if (!bo.getMsgValidate().equals(redisIO.get(PHOTO_USER_VALID_MSG_PREFIX + userId + bo.getTele()))) {
                return JsonResponseUtil.error("验证码错误");
            }
            editBO.setContactPhone(bo.getTele());
        }
        editBO.setSex(bo.getSex());
        editBO.setShowImg(bo.getCover());
        editBO.setCodeImg(bo.getWxQrcode());
        editBO.setUserInfo(bo.getProfile());
        editBO.setAddress(genAddr(bo.getProvId(), bo.getCityId()));
        photoUserProcess.editUserInfo(userId, editBO);
        return JsonResponseUtil.success();
    }

    /**
     * 根据传入的省市生成地址信息
     *
     * @param provId
     * @param cityId
     * @return
     */
    public String genAddr(Long provId, Long cityId) {
        if (provId == null) {
            return null;
        }
        OrderProv prov = orderProvMapper.selectByPrimaryKey(provId);
        if (prov == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(prov.getProvName().trim());
        if (sb.length() == 0) {
            return null;
        }
        if (cityId != null) {
            OrderCity city = orderCityMapper.selectByPrimaryKey(cityId);
            if (city != null) {
                sb.append('-').append(city.getCityName().trim());
            }
        }
        return sb.toString();
    }

    /**
     * 更改用户头像
     *
     * @param userId
     * @param imgSrc
     * @return
     */
    public JSONObject saveHeadPortrait(Long userId, String imgSrc) {
        if (userId == null) {
            return JsonResponseUtil.error("请先登陆");
        }
        if (StringUtils.isBlank(imgSrc)) {
            return JsonResponseUtil.error("请上传头像");
        }
        PhotoUserInfoEditBO bo = new PhotoUserInfoEditBO();
        bo.setHeadImg(imgSrc);
        photoUserProcess.editUserInfo(userId, bo);
        return JsonResponseUtil.success();
    }
}
