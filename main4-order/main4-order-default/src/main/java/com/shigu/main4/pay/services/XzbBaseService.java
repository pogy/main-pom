package com.shigu.main4.pay.services;

import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.pays.beans.PayAccount;
import com.opentae.data.pays.beans.PayTrade;
import com.opentae.data.pays.beans.PayXzb;
import com.opentae.data.pays.examples.PayAccountExample;
import com.opentae.data.pays.interfaces.PayAccountMapper;
import com.opentae.data.pays.interfaces.PayTradeMapper;
import com.opentae.data.pays.interfaces.PayXzbMapper;
import com.shigu.main4.pay.enums.XzbBaseErrorCodeEnum;
import com.shigu.main4.pay.exceptions.XzbBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类名：XzbBaseService
 * 类路径： com.shigu.main4.pay.services.XzbBaseService
 * 创建者： whx
 * 创建时间： 8/9/18 2:31 PM
 * 项目： main-pom
 * 描述：
 */
@Service
public class XzbBaseService {

    @Autowired
    private PayXzbMapper payXzbMapper;

    @Autowired
    private PayAccountMapper payAccountMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;



    /**
     * 获取用户账户 选择一个传入
     * @param xzUserId 星座网用户id
     * @param accountId 星座宝账户id
     * @return
     */
    public PayAccount selPayAccount(Long xzUserId, Long accountId) {
        if (accountId != null) {
            return selAccountByAccountId(accountId);
        }
        if (xzUserId != null) {
            return selAccountByXzUserId(xzUserId);
        }
        return null;
    }

    /**
     * 根据星座宝账户id获取星座宝账户信息
     * @param accountId
     * @return
     */
    protected PayAccount selAccountByAccountId(Long accountId) {
        if (accountId != null) {
            return payAccountMapper.selectByPrimaryKey(accountId);
        }
        return null;
    }

    /**
     * 根据星座网用户id获取星座宝账户信息
     * @param xzUserId
     * @return
     */
    protected PayAccount selAccountByXzUserId(Long xzUserId) {
        if (xzUserId != null) {
            PayAccountExample example = new PayAccountExample();
            example.createCriteria().andXzUserIdEqualTo(xzUserId);
            example.setStartIndex(0);
            example.setEndIndex(1);
            List<PayAccount> payAccounts = payAccountMapper.selectByConditionList(example);
            if (payAccounts.size()>0) {
                return payAccounts.get(0);
            } else {
                return newAXzUser(xzUserId);
            }
        }
        return null;
    }

    /**
     * 根据星座网用户id创建星座宝账户
     * @param xzUserId
     * @return
     */
    protected PayAccount newAXzUser(Long xzUserId) {
        MemberUser user = memberUserMapper.selectByPrimaryKey(xzUserId);
        if (user != null) {
            try{
                PayAccount account = new PayAccount();
                account.setXzUserId(user.getUserId());
                account.setXzUserName(user.getUserName());
                account.setGroupId(-1L);
                account.setAccountType(1);
                account.setStatue(1);
                account.setCreateTime(new Date());
                payAccountMapper.insertSelective(account);

                PayXzb payXzb = new PayXzb();
                payXzb.setAccountId(account.getAccountId());
                payXzb.setMoney(0L);
                payXzb.setCreateTime(new Date());
                payXzb.setLastModifyTime(new Date());
                payXzb.setTotalMoney(0L);
                payXzb.setBlockMoney(0L);
                payXzbMapper.insertSelective(payXzb);
                return account;
            } catch (Exception e) {

            }

        }
        return null;
    }


    public XzbBaseException xzbExceptionByMsg(String msg) {
        return new XzbBaseException(msg);
    }

    public XzbBaseException xzbExceptionByErrorCode(XzbBaseErrorCodeEnum errorCodeEnum) {
        return new XzbBaseException(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
    }

}
