package com.shigu.photo.model.impl;

import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.photo.beans.PhotoAuthApply;
import com.opentae.data.photo.beans.ShiguPhotoUser;
import com.opentae.data.photo.beans.ShiguPhotoWorks;
import com.opentae.data.photo.interfaces.PhotoAuthApplyMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoUserMapper;
import com.opentae.data.photo.interfaces.ShiguPhotoWorksMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.bo.PhotoUserInfoEditBO;
import com.shigu.photo.model.PhotoUserModel;
import com.shigu.photo.vo.PhotoUserStatisticVO;
import com.shigu.photo.vo.PhotoUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * 路径: com.shigu.photo.model.impl.PhotoUserModelImpl
 * 工程: main-pom
 * 时间: 18-4-25 下午2:54
 * 创建人: wanghaoxiang
 * 描述:
 */
@Component
@Scope("prototype")
public class PhotoUserModelImpl implements PhotoUserModel {

    @Autowired
    private ShiguPhotoUserMapper shiguPhotoUserMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private MemberLicenseMapper memberLicenseMapper;

    @Autowired
    private PhotoAuthApplyMapper photoAuthApplyMapper;

    @Autowired
    private ShiguPhotoWorksMapper shiguPhotoWorksMapper;

    //用户id,必传，非空
    private Long userId;

    private PhotoUserVO userInfo;

    public PhotoUserModelImpl(Long userId) {
        this.userId = userId;
    }

    @PostConstruct
    public void init() {
        ShiguPhotoUser shiguPhotoUser = new ShiguPhotoUser();
        shiguPhotoUser.setUserId(userId);
        shiguPhotoUser = shiguPhotoUserMapper.selectOne(shiguPhotoUser);
        if (shiguPhotoUser == null) {
            shiguPhotoUser = new ShiguPhotoUser();
            shiguPhotoUser.setUserId(userId);
            //默认普通用户，性别未知
            shiguPhotoUser.setUserType(0);
            shiguPhotoUser.setSex(0);
            MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
            if (memberUser != null) {
                shiguPhotoUser.setUserName(memberUser.getLoginPhone());
                shiguPhotoUser.setContactPhone(memberUser.getLoginPhone());
            }
            try {
                shiguPhotoUserMapper.insertSelective(shiguPhotoUser);
                updatePhotoUserType(0);
            } catch (Exception e) {
                // TODO: 18-4-25 log
            }

        }
        userInfo = BeanMapper.map(shiguPhotoUser, PhotoUserVO.class);
    }


    /**
     * 更新用户摄影基地类型
     *
     * @param type,摄影身份认证类型，不能为空，0:普通用户,1:模特,2:摄影师 3.摄影公司,4:场地
     */
    protected void updatePhotoUserType(Integer type) {
        ShiguPhotoUser shiguPhotoUser = new ShiguPhotoUser();
        shiguPhotoUser.setAuthorId(photoUserInfo().getAuthorId());
        shiguPhotoUser.setUserType(type);
        shiguPhotoUserMapper.updateByPrimaryKeySelective(shiguPhotoUser);
        MemberLicense memberLicense = new MemberLicense();
        // 用户摄影基地身份信息
        memberLicense.setUserId(userId);
        memberLicense.setLicenseType(8);
        MemberLicense queryInfo = memberLicenseMapper.selectOne(memberLicense);
        if (queryInfo != null) {
            memberLicense = queryInfo;
        }
        memberLicense.setLicenseFailure(1);
        if (type != null) {
            memberLicense.setContext(type.toString());
        }
        if (memberLicense.getUserLicenseId() == null) {
            memberLicenseMapper.insertSelective(memberLicense);
        } else {
            memberLicenseMapper.updateByPrimaryKeySelective(memberLicense);
        }
    }

    @Override
    public void authApply(PhotoAuthApplyBO bo) throws JsonErrException {
        PhotoAuthApply apply = new PhotoAuthApply();
        apply.setAuthId(getAuthId());
        //查找该用户是否有未处理完成的申请
        apply.setApplyStatus(0);
        if (photoAuthApplyMapper.selectOne(apply) != null) {
            //存在未处理的请求
            throw new JsonErrException("有正在处理中的认证申请，请耐心等待审核结果");
        }
        apply.setUserName(bo.getUserName());
        apply.setAuthType(bo.getAuthType());
        apply.setAuthPhone(bo.getAuthPhone());
        apply.setShowImg(bo.getShowImg());
        apply.setCodeImg(bo.getCodeImg());
        apply.setMainStyleId(bo.getMainStyleId());
        apply.setApplyTime(new Date());
        photoAuthApplyMapper.insertSelective(apply);
    }

    @Override
    public void applyPass(String logMessage) {
        PhotoAuthApply apply = unResolvedApply();
        if (apply == null) {
            return;
        }
        // 更新用户认证信息
        Long photoUserId = photoUserInfo().getAuthorId();
        ShiguPhotoUser shiguPhotoUser = new ShiguPhotoUser();
        shiguPhotoUser.setAuthorId(photoUserId);
        shiguPhotoUser.setUserName(apply.getUserName());
        shiguPhotoUser.setContactPhone(apply.getAuthPhone());
        shiguPhotoUser.setShowImg(apply.getShowImg());
        shiguPhotoUser.setHeadImg(apply.getShowImg());
        shiguPhotoUser.setCodeImg(apply.getCodeImg());
        shiguPhotoUser.setMainStyleId(apply.getMainStyleId());
        shiguPhotoUserMapper.updateByPrimaryKeySelective(shiguPhotoUser);
        // 更新用户身份标记
        updatePhotoUserType(apply.getAuthType());
        // 更新用户身份认证申请状态
        applyResolve(1,logMessage);
    }

    @Override
    public void applyRefuse(String logMessage) {
        applyResolve(2, logMessage);
    }

    /**
     * 摄影基地身份认证状态变化
     *
     * @param changeToStatu 1.通过 2.拒绝
     * @param logMessage    状态变更日志记录（操作人员，拒绝原因。。)
     */
    protected void applyResolve(int changeToStatu, String logMessage) {
        PhotoAuthApply apply = unResolvedApply();
        if (apply == null) {
            return;
        }
        apply.setApplyStatus(changeToStatu);
        apply.setModifyLog(logMessage);
        apply.setModifyTime(new Date());
        photoAuthApplyMapper.updateByPrimaryKeySelective(apply);
    }

    /**
     * 未处理的身份认证申请,若不存在，则返回null
     *
     * @return
     */
    private PhotoAuthApply unResolvedApply() {
        PhotoAuthApply apply = new PhotoAuthApply();
        apply.setAuthId(getAuthId());
        apply.setApplyStatus(0);
        return photoAuthApplyMapper.selectOne(apply);
    }

    @Override
    public void editUserInfo(PhotoUserInfoEditBO bo) {
        ShiguPhotoUser shiguPhotoUser = new ShiguPhotoUser();
        shiguPhotoUser.setAuthorId(photoUserInfo().getAuthorId());
        shiguPhotoUser.setSex(bo.getSex());
        shiguPhotoUser.setAddress(bo.getAddress());
        if (StringUtils.isNotBlank(bo.getHeadImg())) {
            shiguPhotoUser.setHeadImg(bo.getHeadImg());
        }
        if (StringUtils.isNotBlank(bo.getShowImg())) {
            shiguPhotoUser.setShowImg(bo.getShowImg());
        }
        if (StringUtils.isNotBlank(bo.getCodeImg())) {
            shiguPhotoUser.setCodeImg(bo.getCodeImg());
        }
        shiguPhotoUser.setUserInfo(bo.getUserInfo());
        shiguPhotoUser.setContactPhone(bo.getContactPhone());
        shiguPhotoUserMapper.updateByPrimaryKeySelective(shiguPhotoUser);
    }

    @Override
    public PhotoUserVO photoUserInfo() {
        return userInfo;
    }

    @Override
    public PhotoUserStatisticVO photoUserTotalInfo() {
        PhotoUserStatisticVO totalUserInfo = BeanMapper.map(photoUserInfo(), PhotoUserStatisticVO.class);
        ShiguPhotoWorks authCountQuery = new ShiguPhotoWorks();
        authCountQuery.setAuthorId(getAuthId());
        totalUserInfo.setWorksCount(shiguPhotoWorksMapper.selectCount(authCountQuery));
        return totalUserInfo;
    }

    @Override
    public long getAuthId() {
        return photoUserInfo().getAuthorId();
    }
}
