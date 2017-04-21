package com.shigu.main4.ucenter.services.test.zjb;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.vo.SafeAbout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

/**
 *
 * 用户权益test
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/apache-shiro.xml" )
public class UserLicenseServiceTest {

    @Resource(name = "userLicenseService")
    private UserLicenseService userLicenseService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    /**
     * 实名认证申请
     */
    @Test
    public void realNameApply() {
        Long userId = 1000000808L;
        String bdUrl = "http://www.baidu.com/";

        System.out.println("正常提交实名认证申请信息");
        try{
            userLicenseService.realNameApply(userId, bdUrl);
        }catch (Main4Exception e){
            System.out.println("这里不会走的，走了就有问题");
        }
        System.out.println("重复提交实名认证申请信息测试");
        try{
            userLicenseService.realNameApply(userId, bdUrl);
            System.out.println("这里不会走的，走了就有问题");
        }catch (Main4Exception e){
            System.out.println("正常抛出自定义异常信息>message:" + e.getMessage());
        }
    }

    /**
     * 实名认证审核
     */
    @Test
    public void realName(){
        Long userId = 9968L;
        boolean toExamine = true;
        String reason = "不符合标准";

        System.out.println("不审核通过测试-----------------");
        try{
            userLicenseService.realName(userId,toExamine,reason);
            System.out.println("拒绝实名认证成功");
        }catch (Main4Exception e){
            System.out.println("此处不应该走，走了就有问题");
        }

        System.out.println("重复审核通过测试-----------------");
        try{
            userLicenseService.realName(userId,toExamine,reason);
            System.out.println("此处不应该走，走了就有问题");
        }catch (Main4Exception e){
            System.out.println("抛出找不到实名认证审核>>e:" + e.getMessage());
        }


        System.out.println("正常提交实名认证申请信息");
        try{
            userLicenseService.realNameApply(userId, "http://www.baidu.com");
        }catch (Main4Exception e){
            System.out.println("这里不会走的，走了就有问题");
        }

        System.out.println("审核通过测试-----------------");
        try {
            userLicenseService.realName(userId, true, reason);
            System.out.println("实名认证成功");
        } catch (Main4Exception e) {
            System.out.println("此处不应该走，走了就有问题");
        }

        System.out.println("重复审核通过测试-----------------");
        try {
            userLicenseService.realName(userId, true, reason);
            System.out.println("此处不应该走，走了就有问题");
        } catch (Main4Exception e) {
            System.out.println("抛出找不到找不到实名认证审核申请>>e:" + e.getMessage());
        }
    }

    /**
     * 密码安全分计算
     */
    @Test
    public void passwordSafeCheck(){
        Long userId = 1000000808L;
        String password = "";
        System.out.println("空密码密码安全分测试，应该得分0");
        int score = userLicenseService.passwordSafeCheck(userId,password);
        System.out.println("空密码密码安全分测试实际得分：" + score);

        System.out.println("空密码密码安全分测试，应该得分25");
        password = "11454";
        score = userLicenseService.passwordSafeCheck(userId,password);
        System.out.println("纯数字密码密码安全分测试实际得分：" + score);

        System.out.println("数字+小写字母密码密码安全分测试，应该得分50");
        password = "1234zj";
        score = userLicenseService.passwordSafeCheck(userId,password);
        System.out.println("数字+小写字母密码安全分测试实际得分：" + score);

        System.out.println("数字+小写字母+大写字母密码密码安全分测试，应该得分75");
        password = "154zjZJ";
        score = userLicenseService.passwordSafeCheck(userId,password);
        System.out.println("数字+小写字母+大写字母密码安全分测试实际得分：" + score);

        System.out.println("数字+小写字母+大写字母+长度大于9密码密码安全分测试，应该得分100");
        password = "123454zjZJ";
        score = userLicenseService.passwordSafeCheck(userId,password);
        System.out.println("数字+小写字母+大写字母密码+长度大于9安全分测试实际得分：" + score);
    }

    /**
     * 绑定手机号
     */
    @Test
    public void bindPhone(){
        Long userId = 1000000808L;
        String phone = "13486358344";

        System.out.println("member_user_sub存在手机号测试，需要抛出异常");
        try{
            userLicenseService.bindPhone(userId,phone);
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

        phone = "15270970409";
        System.out.println("正常绑定手机号测试");
        try{
            userLicenseService.bindPhone(userId,phone);
            System.out.println("绑定手机号成功");
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

        userId = 10000008081L;
        phone = "15270970409";
        System.out.println("修改userid，存在手机号绑定测试，需要抛出异常信息");
        try{
            userLicenseService.bindPhone(userId,phone);
            System.out.println("绑定手机号成功，出现异常");
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

        userId = 1000000808L;
        phone = "15270970401";
        System.out.println("修改更新手机号绑定测试，正常修改绑定");
        try{
            userLicenseService.bindPhone(userId,phone);
            System.out.println("修改绑定手机号成功");
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }
    }

    @Test
    public void bandEmail(){
        Long userId = 1000000808L;
        String email = "740971895@qq.com";

        System.out.println("正常更新邮箱权益测试，不会抛出异常信息");
        try{
            userLicenseService.bindEmail(userId, email);
            System.out.println("绑定邮箱成功");
        }catch(Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

        userId = 1000000801L;
        email = "740971895@qq.com";
        System.out.println("换个用户测试，邮箱一样，需要抛出异常信息");
        try{
            userLicenseService.bindEmail(userId, email);
            System.out.println("不应该绑定成功");
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

        userId = 1000000808L;
        email = "74097189511@qq.com";
        System.out.println("用户修改绑定邮箱信息，正常绑定");
        try{
            userLicenseService.bindEmail(userId, email);
            System.out.println("修改绑定成功");
        }catch (Main4Exception e){
            System.out.println("抛出异常信息：" + e.getMessage());
        }

    }

    @Test
    public void changePwd(){
        Long userId = 1000038564L;
        String password = "257ZJBzjb";

        System.out.println("正常修改手机号测试");
        try {
            userLicenseService.changePassword(userId, password);
            System.out.println("正常修改手机号");
        } catch (Main4Exception e) {
            System.out.println("不应该抛出异常信息：" + e.getMessage());
        }

    }

    @Test
    public void selUserLicenses(){
        Long userId = 1000000808L;
        SafeAbout safeAbout = userLicenseService.selUserLicenses(userId);
        System.out.println(JSON.toJSONString(safeAbout));
    }

    @Test
    @Transactional
    public void testBindPhoneWithNameModified() throws Main4Exception {
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(1000038336L);
        // 验证测试数据存在并符合要求
        assertTrue(memberUser != null && memberUser.getUserName().equals("15605885882") && memberUser.getUserNick().equals("15605885882"));

        userLicenseService.bindPhone(1000038336L, "15625555555");

        memberUser = memberUserMapper.selectByPrimaryKey(1000038336L);
        // 验证结果
        assertTrue(memberUser.getUserName().equals("15625555555") && memberUser.getUserNick().equals("15625555555"));
    }
}
