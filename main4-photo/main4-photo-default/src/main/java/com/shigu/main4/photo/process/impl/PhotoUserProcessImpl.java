package com.shigu.main4.photo.process.impl;

import com.opentae.data.photo.beans.*;
import com.opentae.data.photo.examples.PhotoAuthApplyExample;
import com.opentae.data.photo.examples.ShiguPhotoUserExample;
import com.opentae.data.photo.examples.ShiguPhotoUserSelectedStyleRelationExample;
import com.opentae.data.photo.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.photo.bo.AuthApplySearchBO;
import com.shigu.main4.photo.bo.PhotoAuthApplyBO;
import com.shigu.main4.photo.bo.PhotoUserInfoEditBO;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.model.PhotoUserModel;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.vo.AuthApplyInfoVO;
import com.shigu.main4.photo.vo.PhotoAuthorVO;
import com.shigu.main4.photo.vo.PhotoUserStatisticVO;
import com.shigu.main4.photo.vo.PhotoUserVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 路径: PhotoUserProcessImpl
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
    private PhotoAuthApplyMapper photoAuthApplyMapper;

    @Autowired
    private ShiguPhotoUserMapper shiguPhotoUserMapper;

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

    @Override
    public ShiguPager<AuthApplyInfoVO> selApplyInfo(AuthApplySearchBO bo, int pageNo, int size) {
        if (bo == null) {
            return new ShiguPager<>();
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (size < 1) {
            size = 30;
        }
        ShiguPager<AuthApplyInfoVO> pager = new ShiguPager<>();
        List<AuthApplyInfoVO> vos = new ArrayList<>();
        pager.setContent(vos);
        // 查询的授权状态
        Integer status = bo.getStatus();
        PhotoAuthApplyExample example = new PhotoAuthApplyExample();
        PhotoAuthApplyExample.Criteria criteria = example.createCriteria();
        criteria.andApplyStatusEqualTo(status);
        if (bo.getAuthType() != null) {
            criteria.andAuthTypeEqualTo(bo.getAuthType());
        }
        if (StringUtils.isNotBlank(bo.getConcatPhone())) {
            criteria.andAuthPhoneEqualTo(bo.getConcatPhone());
        }
        if (StringUtils.isNotBlank(bo.getPhotoUserName())) {
            criteria.andUserNameLike("concat('%','" + bo.getPhotoUserName() + "','%')");
        }
        int totalNum = photoAuthApplyMapper.countByExample(example);
        pager.calPages(totalNum, size);
        pager.setNumber(pageNo);
        int startRow = (pageNo - 1) * size;
        example.setStartIndex(startRow);
        example.setEndIndex(size);
        List<PhotoAuthApply> photoAuthApplies = photoAuthApplyMapper.selectByConditionList(example);
        // 摄影基地帐号与主站用户对应,dubbo模块外部只知道主站帐号信息
        Map<Long, Long> authIdUserIdMap = new HashMap<>();
        List<Long> authIds = photoAuthApplies.stream().map(PhotoAuthApply::getAuthId).collect(Collectors.toList());
        if (authIds.size() > 0) {
            ShiguPhotoUserExample userExample = new ShiguPhotoUserExample();
            userExample.createCriteria().andAuthorIdIn(authIds);
            authIdUserIdMap = shiguPhotoUserMapper.selectByExample(userExample).stream().collect(Collectors.toMap(ShiguPhotoUser::getAuthorId, ShiguPhotoUser::getUserId));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (PhotoAuthApply apply : photoAuthApplies) {
            AuthApplyInfoVO vo = new AuthApplyInfoVO();
            vo.setPhotoAuthApplyId(apply.getAuthApplyId());
            vo.setUserId(authIdUserIdMap.get(apply.getAuthId()));
            vo.setPhotoUserName(apply.getUserName());
            vo.setUserType(parseAuthType(apply.getAuthType()));
            vo.setConcatPhone(apply.getAuthPhone());
            vo.setShowImgUrl(apply.getShowImg());
            vo.setCodeImgUrl(apply.getCodeImg());
            vo.setLogMessage(apply.getModifyLog());
            vo.setApplyTime(sdf.format(apply.getApplyTime()));
            if (apply.getModifyTime() != null) {
                vo.setModifyTime(sdf.format(apply.getModifyTime()));
            }
            // 风格的先不管，有需要时再加
            vos.add(vo);
        }
        return pager;
    }

    /**
     * 解析身份类型
     * @param authType
     * @return
     */
    private static String parseAuthType(Integer authType) {
        //用户申请不应该出现这种类型
        String typeName = "一般用户";
        if (authType == null) {
            authType = 0;
        }
        switch (authType) {
            case 1:
                typeName = "模特";
                break;
            case 2:
                typeName = "摄影师";
                break;
            case 3:
                typeName = "摄影公司";
                break;
            case 4:
                typeName = "场地";
                break;
        }
        return typeName;
    }
}
