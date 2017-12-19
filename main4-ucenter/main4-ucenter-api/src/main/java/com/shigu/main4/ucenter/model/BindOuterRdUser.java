package com.shigu.main4.ucenter.model;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.Bind3RdsException;
import com.shigu.session.main4.Rds3TempUser;

/**
 * Created by admin on 2017/12/18.
 *
 * @author admin
 * @description
 * @since
 * 第三方账号绑定
 */
public interface BindOuterRdUser {
    /**
     * 是否准入 不准入直接抛出异常
     * @param phone
     * @param tempUser
     * @return
     */
    void admittance (String phone,Rds3TempUser tempUser) throws Main4Exception;

    /**
     * 绑定店铺
     * @param phone
     * @param tempUser
     * @param userId
     */
    void bindShop(String phone,Rds3TempUser tempUser,Long userId) throws Bind3RdsException;

}
