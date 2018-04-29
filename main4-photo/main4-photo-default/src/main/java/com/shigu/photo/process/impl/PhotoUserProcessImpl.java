package com.shigu.photo.process.impl;

import com.opentae.data.photo.beans.ShiguPhotoUser;
import com.opentae.data.photo.beans.ShiguPhotoUserFollow;
import com.opentae.data.photo.beans.ShiguPhotoUserPraise;
import com.opentae.data.photo.beans.ShiguPhotoUserSelectedStyleRelation;
import com.opentae.data.photo.examples.ShiguPhotoUserExample;
import com.opentae.data.photo.examples.ShiguPhotoUserSelectedStyleRelationExample;
import com.opentae.data.photo.interfaces.ShiguPhotoUserFollowMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoUserMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoUserPraiseMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoUserSelectedStyleRelationMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.bo.PhotoUserInfoEditBO;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.model.PhotoUserModel;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.vo.PhotoAuthorVO;
import com.shigu.photo.vo.PhotoUserStatisticVO;
import com.shigu.photo.vo.PhotoUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    ShiguPhotoUserMapper shiguPhotoUserMapper;

    @Autowired
    ShiguPhotoUserSelectedStyleRelationMapper shiguPhotoUserSelectedStyleRelationMapper;

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
        long authId = getUserModel(userId).getAuthId();
        ShiguPhotoUserPraise praise = new ShiguPhotoUserPraise();
        praise.setAuthorId(authId);
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
        //用户摄影系统id
        long userPhotoId = getUserModel(userId).getAuthId();
        //作者摄影系统id
        long authPhotoId = getUserModel(authId).getAuthId();
        ShiguPhotoUserFollow query = new ShiguPhotoUserFollow();
        query.setAuthorId(userPhotoId);
        query.setFollowAuthorId(authPhotoId);
        query.setStatus(1);
        return shiguPhotoUserFollowMapper.selectCount(query) > 0;
    }

    @Override
    public boolean isPraised(Long userId, Long worksId) {
        if (userId == null || worksId == null) {
            return false;
        }
        long userPhotoId = getUserModel(userId).getAuthId();
        ShiguPhotoUserPraise query = new ShiguPhotoUserPraise();
        query.setAuthorId(userPhotoId);
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

    @Override
    public void editUserInfo(Long userId, PhotoUserInfoEditBO bo) {
        getUserModel(userId).editUserInfo(bo);
    }

    @Override
    public ShiguPager<PhotoAuthorVO> selAuthors(PhotoWorksBO bo) {
        ShiguPager<PhotoAuthorVO> pager=new ShiguPager<>();
        pager.setContent(new ArrayList<>());
        pager.setNumber(bo.getPage());

        ShiguPhotoUserExample shiguPhotoUserExample=new ShiguPhotoUserExample();
        ShiguPhotoUserExample.Criteria criteria = shiguPhotoUserExample.createCriteria();
        if(bo.getStyleId()!=null){
            ShiguPhotoUserSelectedStyleRelationExample shiguPhotoUserSelectedStyleRelationExample=new ShiguPhotoUserSelectedStyleRelationExample();
            shiguPhotoUserSelectedStyleRelationExample.createCriteria().andEffectedEqualTo(1).andStyleIdEqualTo(bo.getStyleId());
            List<ShiguPhotoUserSelectedStyleRelation> list=shiguPhotoUserSelectedStyleRelationMapper.selectByExample(shiguPhotoUserSelectedStyleRelationExample);
            if(list.size()==0){
                pager.calPages(0,bo.getPageSize());
                return pager;
            }
            criteria.andAuthorIdIn(BeanMapper.getFieldList(list,"authId",Long.class));
        }
        if(bo.getSex()!=null){
            criteria.andSexEqualTo(bo.getSex());
        }
        if(StringUtils.isNotBlank(bo.getTitle())){
            criteria.andUserNameLike("%"+bo.getTitle()+"%");
        }
        if(bo.getUserTypes()!=null&&bo.getUserTypes().size()>0){
            criteria.andUserTypeIn(bo.getUserTypes());
        }
        int count=shiguPhotoUserMapper.countByExample(shiguPhotoUserExample);
        if(count>0){
            shiguPhotoUserExample.setStartIndex((bo.getPage()-1)*bo.getPageSize());
            shiguPhotoUserExample.setEndIndex(bo.getPageSize());
            shiguPhotoUserExample.setOrderByClause("author_id desc");
            List<ShiguPhotoUser> shiguPhotoUsers = shiguPhotoUserMapper.selectByExample(shiguPhotoUserExample);
            List<PhotoAuthorVO> photoAuthorVOS = shiguPhotoUsers.stream().map(shiguPhotoUser -> {
                PhotoAuthorVO vo = new PhotoAuthorVO();
                vo.setAddress(shiguPhotoUser.getAddress());
                vo.setHeadImgSrc(shiguPhotoUser.getHeadImg());
                vo.setImgsrc(shiguPhotoUser.getShowImg());
                vo.setUserId(shiguPhotoUser.getUserId());
                vo.setUserNick(shiguPhotoUser.getUserName());
                return vo;
            }).collect(Collectors.toList());
            pager.setContent(photoAuthorVOS);
        }
        pager.calPages(count,bo.getPageSize());
        return pager;
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
