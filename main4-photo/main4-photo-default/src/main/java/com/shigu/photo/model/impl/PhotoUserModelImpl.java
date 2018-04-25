package com.shigu.photo.model.impl;

import com.opentae.mall.beans.MemberLicense;
import com.opentae.mall.beans.MemberUser;
import com.opentae.mall.interfaces.MemberLicenseMapper;
import com.opentae.mall.interfaces.MemberUserMapper;
import com.opentae.photo.beans.ShiguPhotoUser;
import com.opentae.photo.interfaces.ShiguPhotoUserMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.bo.PhotoUserInfoEditBO;
import com.shigu.photo.model.PhotoUserModel;
import com.shigu.photo.vo.PhotoUserVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    private ShiguPhotoUserMapper shiguPhotoUserMapper;

    private MemberUserMapper memberUserMapper;

    private MemberLicenseMapper memberLicenseMapper;

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
            }
            try {
                shiguPhotoUserMapper.insertSelective(shiguPhotoUser);
                updatePhotoUserType(0);
            } catch (Exception e){
                // TODO: 18-4-25 log
            }

        }
        userInfo = BeanMapper.map(shiguPhotoUser, PhotoUserVO.class);
    }


    /**
     * 更新用户摄影基地类型
     * @param type,摄影身份认证类型，不能为空，0:普通用户,1:模特,2:摄影机构,3:场地
     */
    protected void updatePhotoUserType(Integer type) {
        ShiguPhotoUser shiguPhotoUser = new ShiguPhotoUser();
        shiguPhotoUser.setPhotoUserId(photoUserInfo().getPhotoUserId());
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
    public void authApply(PhotoAuthApplyBO bo) {

    }

    @Override
    public void applyPass() {

    }

    @Override
    public void applyRefuse() {

    }

    @Override
    public void editUserInfo(PhotoUserInfoEditBO bo) {

    }

    @Override
    public PhotoUserVO photoUserInfo() {
        return userInfo;
    }
}
