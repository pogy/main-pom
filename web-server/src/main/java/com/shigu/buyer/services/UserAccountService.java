package com.shigu.buyer.services;

import com.opentae.data.mall.beans.MemberAlipayBind;
import com.opentae.data.mall.examples.MemberAlipayBindExample;
import com.opentae.data.mall.interfaces.MemberAlipayBindMapper;
import com.shigu.buyer.bo.MemberAlipayBindBO;
import com.shigu.buyer.vo.UserAlipayBindVO;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.process.PayProcess;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户账户功能
 * Created by bugzy on 2017/6/5 0005.
 */
@Service
public class UserAccountService {
    
    @Autowired
    private UserLicenseService userLicenseService;
    
    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Autowired
    private PayProcess payProcess;

    @Autowired
    private MemberAlipayBindMapper memberAlipayBindMapper;

    /**
     * 充值申请
     * @param userId
     * @param money
     * @return
     * @throws PayApplyException
     */
    public PayApplyVO rechargeApply(Long userId,Long money) throws PayApplyException {
        return payProcess.rechargeApply(userId, PayType.ALI,money);
    }

    @Transactional(rollbackFor = Exception.class)
    public void bindAccount(Rds3TempUser rds3TempUser, String telephone, String remoteAddr) throws JsonErrException {
        /*
             * 如果是手机来的,就是星座号绑定手机
             */
        try {
            if (rds3TempUser.getLoginFromType().equals(LoginFromType.PHONE)) {
                if (registerAndLoginService.userCanRegist(telephone, LoginFromType.PHONE)) {
                    userLicenseService.bindPhone(Long.valueOf(rds3TempUser.getSubUserKey()), telephone);
                } else {
                    throw new JsonErrException("该手机号已被使用").addErrMap("ele", "telephone");
                }
                rds3TempUser.setSubUserName(telephone);
            } else {
                registerAndLoginService.bind3RdUser(telephone, rds3TempUser);
            }
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage()).addErrMap("ele", "telephone");
        }
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                rds3TempUser.getSubUserName(), null, false, remoteAddr, "", UserType.MEMBER);
        token.setLoginFromType(rds3TempUser.getLoginFromType());
        token.setSubKey(rds3TempUser.getSubUserKey());
        //星座用户登陆
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
        } catch (LoginAuthException e) {
            throw new JsonErrException(e.getMessage()).addErrMap("ele", "telephone");
        }
    }


    /**
     * 用户绑定支付宝列表
     * @param userId
     * @return
     */
    public List<UserAlipayBindVO> userAlipayBindList(Long userId) {
        MemberAlipayBindExample example = new MemberAlipayBindExample();
        example.createCriteria().andUserIdEqualTo(userId).andIsFailureEqualTo(false);
        List<MemberAlipayBind> alipayBinds = memberAlipayBindMapper.selectByExample(example);
        List<UserAlipayBindVO> alipayBindVOList = new ArrayList<>(alipayBinds.size());
        UserAlipayBindVO vo = null;
        for (MemberAlipayBind alipayBind : alipayBinds) {
            vo = new UserAlipayBindVO();
            vo.setAliAccountId(alipayBind.getId());
            vo.setAliAccount(alipayBind.getAlipayId());
            vo.setUserRealName(alipayBind.getAlipayName());
            alipayBindVOList.add(vo);
        }
        return alipayBindVOList;
    }

    public JSONObject applyAliUserBind(MemberAlipayBindBO bo, Long userId) {
        // TODO: 17-12-14 具体绑定接口调用
        return null;
    }
}
