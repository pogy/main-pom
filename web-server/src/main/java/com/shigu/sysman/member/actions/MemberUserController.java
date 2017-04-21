package com.shigu.sysman.member.actions;


import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.sysman.member.bo.MemberUserBo;
import com.shigu.sysman.member.bo.MemberUserSubBo;
import com.shigu.sysman.member.service.MemberUserService;
import com.shigu.sysman.member.service.MemberUserSubService;
import com.shigu.sysman.member.vo.MemberUserSubVo;
import com.shigu.sysman.member.vo.MemberUserVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 * @author shigu_zjb
 * @date 2017/04/03
 *
 */
@Controller
public class MemberUserController {

    @Autowired
    private MemberUserService memberUserService;

    @Autowired
    private MemberUserSubService memberUserSubService;

    /**
     * 用户列表
     * @param memberUserBo
     * @return
     */
    @RequestMapping(value = "/sysman/memberUser/list")
    public String memberUserList(MemberUserBo memberUserBo, HttpServletRequest request){
        if(memberUserBo == null){
            memberUserBo = new MemberUserBo();
        }
        ShiguPager<MemberUserVo> memberUserVoShiguPager = memberUserService.findMemberUserPager(memberUserBo);
        request.setAttribute("pager", memberUserVoShiguPager);
        request.setAttribute("bo",memberUserBo);
        return "sysman/member/member_user_list";
    }


    /**
     * 用户子账号列表
     * @param memberUserSubBo
     * @return
     */
    @RequestMapping(value = "/sysman/memberUser/subList" , method = RequestMethod.GET)
    public String memberUserSubList(MemberUserSubBo memberUserSubBo, HttpServletRequest request){
        if(memberUserSubBo == null){
            memberUserSubBo = new MemberUserSubBo();
        }
        ShiguPager<MemberUserSubVo> userSubVoShiguPager = memberUserSubService.findMemberUserSubPager(memberUserSubBo);
        request.setAttribute("pager", userSubVoShiguPager);
        return "sysman/member/member_user_sub_list";
    }

    /**
     * 删除会员
     * @param userId
     * @return
     */
    @RequestMapping(value = "/sysman/memberUser/deluser" , method = RequestMethod.POST)
    public JSONObject delMemberUser(Long userId){
        ResponseBase rsp = new ResponseBase();

        if(userId == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }



        return null;
    }

    /**
     * 删除会员子账号/解绑
     * @param userSubId
     * @return
     */
    @RequestMapping(value = "/sysman/memberUser/deluserSub" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delMemberUserSub(Long userSubId){
        ResponseBase rsp = new ResponseBase();

        if(userSubId == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }


        return null;
    }

}
