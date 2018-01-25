package com.shigu.main4.ucenter.model.impl;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.Bind3RdsException;
import com.shigu.main4.ucenter.model.BindOuterRdUser;
import com.shigu.session.main4.Rds3TempUser;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/18/13:09
 */
@Service
public class BindJdUser implements BindOuterRdUser {

    /**
     * 是否准入 不准入直接抛出异常
     * @param phone
     * @param tempUser
     * @return
     */
    @Override
    public void admittance(String phone,Rds3TempUser tempUser) throws Main4Exception {

    }

    /**
     * 绑定店铺
     * @param phone
     * @param tempUser
     * @param userId
     */
    @Override
    public void bindShop(String phone,Rds3TempUser tempUser,Long userId) throws Bind3RdsException {

    }
}
