package com.shigu.main4.ucenter.model.impl;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.Bind3RdsException;
import com.shigu.main4.ucenter.model.BindOuterRdUser;
import com.shigu.session.main4.Rds3TempUser;

/**
 * 类名：BindShopeeUser
 * 类路径： com.shigu.main4.ucenter.model.impl.BindShopeeUser
 * 创建者： whx
 * 创建时间： 10/22/18 4:05 PM
 * 项目： main-pom
 * 描述：
 */
public class BindShopeeUser implements BindOuterRdUser {
    @Override
    public void admittance(String phone, Rds3TempUser tempUser) throws Main4Exception {

    }

    @Override
    public void bindShop(String phone, Rds3TempUser tempUser, Long userId) throws Bind3RdsException {

    }
}
