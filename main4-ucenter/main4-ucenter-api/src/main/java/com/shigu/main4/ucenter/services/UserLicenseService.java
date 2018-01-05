package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.MemberLicenseException;
import com.shigu.main4.ucenter.vo.RealNameApplyInfo;
import com.shigu.main4.ucenter.vo.SafeAbout;


/**
 * 用户权益类接口
 * Created by zhaohongbo on 17/3/1.
 */
public interface UserLicenseService {

    /**
     * 查用户积分
     * @param userId
     * @return
     */
    Long selUserScore(Long userId);

    /**
     * 加分
     * @param userId 用户ID
     * @param addScore 加分,如果减分,传入负值
     */
    void addScore(Long userId,Integer addScore) throws MemberLicenseException;

    /**
     * 实名认证
     * @param userId
     * @param bdUrl
     * @return
     */
    void realNameApply(Long userId,String bdUrl) throws Main4Exception;

    /**
     * 实名认证审核
     * @param userId 用户ID
     * @param toExamine true表示通过,false表示不通过
     * @param reason 不通过原因
     */
    void realName(Long userId,boolean toExamine,String reason) throws Main4Exception;

    /**
     * 最后一次申请的情况
     * @param userId
     * @return
     */
    RealNameApplyInfo lastRealNameApply(Long userId);

    /**
     * 用户密码安全等级检测
     * @param userId 用户ID
     * @param password 密码原文
     * @return 安全评分
     */
    int passwordSafeCheck(Long userId,String password);

    /**
     * 手机绑定
     * 一个账号一个手机
     * @param userId
     * @param phone
     */
    void bindPhone(Long userId,String phone) throws Main4Exception;

    /**
     * 手机绑定 不判断准入
     * @param userId
     * @param phone
     * @throws Main4Exception
     */
    void bindNotUserCanRegist(Long userId, String phone)throws Main4Exception;

    /**
     * 绑定邮箱
     * 暂无限制
     * @param userId
     * @param email
     */
    void bindEmail(Long userId,String email) throws Main4Exception;

    /**
     * 查出用户的权益
     * @param userId
     * @return
     */
    SafeAbout selUserLicenses(Long userId);

    /**
     * 修改密码
     * 需要调用密码评分
     * @param userId
     * @param password
     */
    void changePassword(Long userId,String password) throws Main4Exception;


    /**
     * 根据手机号查询手机权益的userId
     * @param phone
     * @return
     */
    Long findUserIdByPhone(String phone);


    /**
     * 根据userId查询权益手机号
     * @param userId
     * @return
     */
    String findPhoneByUserId(Long userId);

    /**
     * 用户绑定支付宝帐号
     * @param userId
     * @param alipayId
     * @param alipayName
     * @return
     */
    String saveOrUpdateUserAlipayBind(Long userId, String alipayId, String alipayName);

    /**
     *删除绑定支付宝帐号
     * @param userId
     * @param memberAlipayBindId 用户支付宝绑定记录id
     * @return
     */
    boolean cancelMemberAlipayBind(Long userId, Long memberAlipayBindId);

}
