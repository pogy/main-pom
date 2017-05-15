package com.shigu.activity.actions;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.shigu.activity.service.ActiveDrawServiceImpl;
import com.shigu.activity.vo.*;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.StringUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 活动
 * Created by zhaohongbo on 17/4/26.
 */
@Controller
public class ActivityAction {

    @Autowired
    private ActiveDrawServiceImpl activeDrawServiceImpl;

    /**
     * 发现好货
     * @param model
     * @return
     */
    @RequestMapping(value = "activity/redbull" , method = RequestMethod.GET)
    public String findGodos(HttpSession session, Model model){
        // 当前期次
        ActiveDrawPemVo drawPem = activeDrawServiceImpl.selNowDrawPem(null);
        // 发现好货商品
        List<ActiveDrawGoodsVo> faGoodsVoList = activeDrawServiceImpl.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_FAGOODS,
                20,
                null);
        // 发现好店
        List<ActiveDrawShopVo> faShopVoList = activeDrawServiceImpl.selShopList(drawPem.getId());
        ActiveDrawStyleVo drawStyleVo = new ActiveDrawStyleVo();
        drawStyleVo.setGoodsList(faGoodsVoList);
        drawStyleVo.setShopList(faShopVoList);

        // 每日发现商品
        List<ActiveDrawGoodsVo> daliyGoodsVoList = activeDrawServiceImpl.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_DAILYFIND,
                60,
                null
                );

        Collections.shuffle(daliyGoodsVoList);

        // 获奖数据
        List<ActiveDrawRecordUserVo> recordUserVoList = activeDrawServiceImpl.selDrawRecordList(null,null, "ben");

        // 用户上一期获奖数据
        List<ActiveDrawRecordUserVo> userVoList = new ArrayList<ActiveDrawRecordUserVo>();
        Object object = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(object != null){
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            ActiveDrawPemVo drawLastPem = activeDrawServiceImpl.selNowDrawPem(drawPem.getStartTime());
            if(drawLastPem != null){
                // 用户上一期获奖数据
                userVoList = activeDrawServiceImpl.selDrawRecordList(drawLastPem.getId(),ps.getUserId(), null);
            }
        }

        if(userVoList == null){
            userVoList = new ArrayList<ActiveDrawRecordUserVo>();
        }

        for (int i = 0; i < userVoList.size(); i++) {
            if(userVoList.get(i).getDrawStatus().intValue() == 1){
                userVoList.get(i).setDrawStatus(2);
            }
        }

        model.addAttribute("lastUserAward", JSON.toJSONString(userVoList));
        model.addAttribute("styleItem", drawStyleVo);
        model.addAttribute("likeGoodsList", daliyGoodsVoList);
        model.addAttribute("awardList", recordUserVoList);
        model.addAttribute("webSite","hz");
        return "activity/styleHuodong";
    }

    /**
     * 用户中奖记录
     * @param session
     * @return
     */
    @RequestMapping(value = "activity/userWard" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userWard(HttpSession session){

        ResponseBase rsp = new ResponseBase();

        Object object = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        if(object == null){
            // 未登录
            rsp.setMsg("用户未登陆");
            return JSONObject.fromObject(rsp);
        }

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        // 当前期次
        ActiveDrawPemVo drawPem = activeDrawServiceImpl.selNowDrawPem(null);
        // 中奖记录
        List<ActiveDrawRecordUserVo> drawRecordList = activeDrawServiceImpl.selDrawNowUserRecord(ps.getUserId());

        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        rsp.setData(drawRecordList);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 查询抽奖
     * @param tqcode
     * @return
     */
    @RequestMapping(value = "activity/qtiqucode" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject qtiqucode(String tqcode){
        JSONObject rspJsonObject = new JSONObject();

        if(StringUtils.isEmpty(tqcode)){
            rspJsonObject.put("status", 1);
            rspJsonObject.put("desc", "请输入有效领取码");
            return rspJsonObject;
        }

        rspJsonObject.put("status", 1);

        try {
            ActiveDrawRecordUserVo activeDrawRecordUserVo = activeDrawServiceImpl.selUserDrawList(tqcode);
            if(activeDrawRecordUserVo == null){
                rspJsonObject.put("desc", "数据有误");
                return rspJsonObject;
            }
            rspJsonObject.put("type", activeDrawRecordUserVo.getWard());
            rspJsonObject.put("q", activeDrawRecordUserVo.getPemId());
            rspJsonObject.put("userId", activeDrawRecordUserVo.getUserId());
            rspJsonObject.put("tqcode", tqcode);
            rspJsonObject.put("status", 0);
        } catch (Main4Exception me) {
            me.printStackTrace();
            rspJsonObject.put("desc", me.getMessage());
        }

        return rspJsonObject;
    }

    /**
     * 领取奖品
     * @param tqcode
     * @param userId
     * @return
     */
    @RequestMapping(value = "activity/qzhongjinag" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject qzhongjinag(String tqcode, Long userId){
        JSONObject rspJsonObject = new JSONObject();
        rspJsonObject.put("status", 1);

        if(StringUtils.isEmpty(tqcode) || userId == null){
            rspJsonObject.put("desc", "请输入有效领取码和用户");
            return rspJsonObject;
        }

        try{
            activeDrawServiceImpl.receUserWard(tqcode, userId);
            rspJsonObject.put("status", 0);
        }catch (Main4Exception e){
            e.printStackTrace();
            rspJsonObject.put("desc", e.getMessage());
        }

        return rspJsonObject;
    }

    /**
     * 领取奖地址
     * @return
     */
    @RequestMapping(value = "activity/receWards" , method = RequestMethod.GET)
    public String receWards(){
        return "activity/fdGdsLqzjb";
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "activity/activeTest" , method = RequestMethod.GET)
    public String activeTest(){

        System.out.println(JSON.toJSONString(activeDrawServiceImpl.selGoodsList(1L,ActiveDrawGoods.TYPE_DAILYFIND,30,null)));

        return null;
    }

}
