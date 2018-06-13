package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.LoginRecord;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;

/**
 * 登陆与注册服务类
 * Created by Licca on 17/2/20.
 */
public interface RegisterAndLoginService {
    /**
     * 注册用户
     * 当手机号码已经存在时，返回false
     * @param user
     * @return
     */
    Long registerByPhone(RegisterUser user) throws Main4Exception;

    /**
     * 根据用户id获取用户外部id
     * @param userId
     * @return
     */
    Long selOutUidByUid(Long userId);

    /**
     * 手机号是否允许注册
     * @return
     */
    boolean userCanRegist(String username, LoginFromType loginFromType);

    /**
     * 手机号是否允许注册
     * @return
     */
    boolean userCanRegist(String username,String key, LoginFromType loginFromType);

    /**
     * 按用户名,反查用户ID
     * @param username
     * @param loginFromType
     * @return
     */
    Long selUserIdByName(String username,LoginFromType loginFromType);

    /**
     * 绑定第三方账户
     * 如果手机账号存在，建子表数据，
     * 如果手机账号不存在，建主表手机数据
     * 如果子表对应本手机账号数据不存在，建子表数据
     * 如果子表与主表数据都存在，返回false
     * @param phone 手机号
     * @param tempUser 第三方用户信息
     */
    boolean bind3RdUser(String phone,Rds3TempUser tempUser) throws Main4Exception;

    /**
     * 登陆记录
     * 存es中，所有异常不扔出，只日志
     * @param loginRecord
     */
    void loginRecord(LoginRecord loginRecord);

}
