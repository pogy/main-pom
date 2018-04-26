package com.shigu.photo.service;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.PhotoWorksSearchBO;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 路径: com.shigu.photo.service.PhotoWorksService
 * 工程: main-pom
 * 时间: 18-4-26 下午1:42
 * 创建人: wanghaoxiang
 * 描述:
 */
@Service
public class PhotoWorksService {


    @Autowired
    private PhotoWorksProcess photoWorksProcess;

    @Autowired
    private PhotoUserProcess photoUserProcess;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    /**
     * 作品详情信息
     *
     * @param worksId
     * @param userId
     * @return
     */
    public PhotoWorksDetailWebVO photoWorksDetail(Long worksId, Long userId) {
        if (worksId == null) {
            return null;
        }
        PhotoWorkDetailVO photoWorkDetailVO = photoWorksProcess.selPhotoWorkDetail(worksId);
        if (photoWorkDetailVO == null) {
            return null;
        }
        // 页面显示作品信息
        PhotoWorksDetailWebVO worksDetail = new PhotoWorksDetailWebVO();
        worksDetail.setTitle(photoWorkDetailVO.getTitle());
        worksDetail.setDesc(photoWorkDetailVO.getContent());
        worksDetail.setCoverImgSrc(photoWorkDetailVO.getPicUrl());
        worksDetail.setPrice(photoWorkDetailVO.getPriceStr());
        worksDetail.setStyle(photoWorkDetailVO.getStylesStr());
        worksDetail.setPublishedTime(sdf.format(photoWorkDetailVO.getCreateTime()));
        worksDetail.setThumbUpCount(photoWorkDetailVO.getPraiseNum());
        worksDetail.setAuthorId(photoWorkDetailVO.getAuthorId());
        String imgsStr = photoWorkDetailVO.getImgs();
        if (StringUtils.isNotBlank(imgsStr)) {
            List<String> imgList = Arrays.asList(imgsStr.split(","));
            worksDetail.setImgList(imgList);
        }
        worksDetail.setUserThumbUpIs(false);
        if (userId != null) {
            worksDetail.setUserThumbUpIs(photoUserProcess.isPraised(userId, worksId));
        }
        return worksDetail;
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
        PhotoAuthWorkUserInfoWebVO authInfo = new PhotoAuthWorkUserInfoWebVO();
        authInfo.setUserId(authorId);
        PhotoUserStatisticVO totalAuthInfo = photoUserProcess.authStatisticInfo(authorId);
        String authType = "未知";
        if (totalAuthInfo != null) {
            authInfo.setNick(totalAuthInfo.getUserName());
            authInfo.setImgSrc(totalAuthInfo.getHeadImg());
            authInfo.setTele(totalAuthInfo.getContactPhone());
            authInfo.setAddress(totalAuthInfo.getAddress());
            authInfo.setWxQrImgSrc(totalAuthInfo.getCodeImg());
            authInfo.setWorksCount(totalAuthInfo.getWorksCount());
            authType=selAuthType(totalAuthInfo.getUserType(),totalAuthInfo.getSubUserType());
        }
        authInfo.setTypeName(authType);
        authInfo.setFocusOnIs(false);
        if (userId != null) {
            authInfo.setFocusOnIs(photoUserProcess.isFollowed(userId, authorId));
        }
        return authInfo;
    }

    public ShiguPager<PhotoWorksSearchVO> selList(PhotoWorksSearchBO query){
        PhotoWorksBO photoWorksBO = query.toPhotoWorksBO();
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(photoWorksBO);
        ShiguPager<PhotoWorksSearchVO> pager=new ShiguPager<>();
        pager.setNumber(pager.getNumber());
        pager.calPages(pager.getTotalCount(),photoWorksBO.getPageSize());
        pager.setContent(photoWorksVOShiguPager.getContent().stream()
            .map(photoWorksVO -> {
                PhotoWorksSearchVO vo=new PhotoWorksSearchVO();
                vo.setId(photoWorksVO.getAuthorId());
                vo.setAddress(photoWorksVO.getAddress());
                vo.setImgsrc(photoWorksVO.getPicUrl());
                vo.setNick(photoWorksVO.getAuthorName());
                vo.setPublishedTime(DateUtil.dateToString(photoWorksVO.getCreateTime(),DateUtil.patternA));
                vo.setTypeName(selAuthType(photoWorksVO.getUserType(),photoWorksVO.getSubUserType()));
                vo.setWorksId(photoWorksVO.getWorksId());
                return vo;
            }).collect(Collectors.toList()));
        return pager;
    }

    private String selAuthType(Integer userType,Integer subUserType){
        String authType = "未知";
        if (subUserType == null) {
            subUserType = 0;
        }
        switch (userType) {
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
