package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class WapPhoneUserService {

    @Autowired
    private BasePhoneUserService basePhoneUserService;
    @Autowired
    private ActiveDrawService activeDrawServiceImpl;
    /**
     * 移动端我的信息
     *
     * @return
     */
    public AboutMeVO aboutMe( Long userId) {
        return basePhoneUserService.aboutMe(userId);
    }

    /**
     * 移动端登录
     */
    public AppUser login( String userName,String password,Integer phoneType,String remoteAddr) throws OpenException {
       return basePhoneUserService.login(userName, password, phoneType, remoteAddr);
    }


    public AppUser msgCodeLogin( String userName,String password,String remoteAddr) throws OpenException {
        return basePhoneUserService.msgCodeLogin(userName,password,remoteAddr);
    }

    /**
     * 得到手机验证码
     */
    public String getPhoneMsg(String telephone,Integer type) throws OpenException {
        return basePhoneUserService.getPhoneMsg(telephone,type);
    }

    /**
     * 修改密码
     *
     * @return
     */
    public void changePassword( String oldPwd,String newPwd,Long userId) throws OpenException {
        basePhoneUserService.changePassword(oldPwd,newPwd,userId);
    }

    //忘记密码
    public void forgetPassword( String telePhone,String msgCode,String newPwd ) throws OpenException {
        basePhoneUserService.forgetPassword(telePhone,msgCode,newPwd);
    }

    /**
     * 移动端用户注册
     * @return
     */
    public AppUser regist( String telePhone,String msgCode,String pwd) throws OpenException {
        return basePhoneUserService.regist(telePhone, msgCode, pwd);
    }

    /**
     * 移动端绑定手机
     * @return
     */
    public BindUserVO bindUser(BindUserBO bo) throws OpenException {
        return basePhoneUserService.bindUser(bo);
    }


    public void imgUpload(Long userId,String file) throws OpenException {
        UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
        userInfoUpdate.setUserId(userId);
        userInfoUpdate.setHeadUrl(file);
        basePhoneUserService.imgUpload(userInfoUpdate);
    }

    public UserInfo selUserInfo(Long userId){
        return basePhoneUserService.selUserInfo(userId);
    }

    /**
     * 获取 OSS 临时授权
     * @return
     */
    public CreatePostSignInfoVO createPostSignInfo() throws OpenException {
       return basePhoneUserService.createPostSignInfo();
    }

    /**
     * 是否需要绑定手机
     * @param userId
     */
    public boolean needBindTelephone(Long userId){
        return basePhoneUserService.needBindTelephone(userId);
    }

    public void bindTelephone(Long userId, Long telephone,Integer msgCode) throws OpenException {
        basePhoneUserService.bindTelephone(userId,telephone,String.valueOf(msgCode));
    }

    /**
     * 中奖结果
     * @throws OpenException
     */
    public List<UserWinningInfo> getUserWinningInfoList(Long userId) throws OpenException {
        List<UserWinningInfo> list=new ArrayList<>();
        UserWinningInfo userWinningInfo=new UserWinningInfo();
        List<Award> awardList=new ArrayList<>();
        


        List<ActiveDrawPemVo> activeDrawPemVos = activeDrawServiceImpl.selDrawPemQueList();
        ActiveDrawPemVo drawPem = activeDrawPemVos.get(0);
        //中奖信息时间
        userWinningInfo.setTime(parseToStartEnd(drawPem.getStartTime()));
        //中奖信息标题
        userWinningInfo.setTitle(drawPem.getTitle());
        //解析json
        JSONObject jsonObject= JSONObject.fromObject(drawPem.getInfo());
        JSONArray awardLists = jsonObject.getJSONObject("awardList").getJSONArray("topAw");

        ActiveDrawPemVo drawLastPem = activeDrawServiceImpl.selNowDrawPem(drawPem.getStartTime());
        List<ActiveDrawRecordUserVo> activeDrawRecordUserVos = activeDrawServiceImpl.selDrawRecordList(drawLastPem.getId(), userId, null);
        for (int i=0;i<awardLists.size();i++){
            Award award=new Award();
            JSONObject jsonObject1 = awardLists.getJSONObject(i);
            award.setIcon((String) jsonObject1.get("imgSrc"));
            award.setText(jsonObject1.get("type")+":"+jsonObject1.get("awardName"));
            if(activeDrawRecordUserVos.size()>0&&activeDrawRecordUserVos!=null){
                for(ActiveDrawRecordUserVo activeDrawRecordUserVo:activeDrawRecordUserVos){
                    //查询中奖信息
                    award.setState(activeDrawRecordUserVo.getDrawStatus());//	中奖状态，取值：1（等待中奖），2（未中奖），3（已中奖）
                    award.setHasReceived(activeDrawRecordUserVo.getReceivesYes());//奖品是否已领取，取值：true（已领取），false（未领取）
                    award.setCode(activeDrawRecordUserVo.getDrawCode());//中奖领取码
                }
            }else{
                award.setState(2);//	中奖状态，取值：1（等待中奖），2（未中奖），3（已中奖）
                award.setHasReceived(false);
                award.setCode(null);
            }

            awardList.add(award);
        }
        userWinningInfo.setAwardList(awardList);
        list.add(userWinningInfo);
        return list;
    }
    /**
     * 发现好货开始结束时间显示
     * @param start
     * @return
     */
    private String parseToStartEnd(Date start) {
        final String dateFitment = "yyyy年MM月dd日";
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        String thisStart = DateUtil.dateToString(cal.getTime(), dateFitment);
        cal.add(Calendar.DATE, 7);
        String thisEnd = DateUtil.dateToString(cal.getTime(), dateFitment);

        return thisStart + " —— " + thisEnd.substring(5);
    }
}
