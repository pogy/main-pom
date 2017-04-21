package com.shigu.sysman.shop.actions;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.sysman.shop.bo.ShiguOuterMarketBo;
import com.shigu.sysman.shop.service.ShiguOutMarketService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 市场展现表
 *
 * @date 2017/3/24 17:47
 *
 */
@Controller
public class ShiguOuterMarketController {

    @Autowired
    private ShiguOutMarketService shiguOutMarketService;

    /**
     * 市场展示列表（不分页）
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/list")
    public String outMarketList(ShiguOuterMarketBo outerMarketBo, HttpServletRequest request){
        if(outerMarketBo == null){
            outerMarketBo = new ShiguOuterMarketBo();
        }
        List<ShiguOuterMarket> outerMarketList = shiguOutMarketService.findUuterMarketList(outerMarketBo);
        request.setAttribute("outerMarketList", outerMarketList);
        request.setAttribute("outerMarketBo",outerMarketBo);
        return "sysman/market/outer_market/outer_market_list";
    }

    /**
     * 添加外部市场页面
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/addView" , method = RequestMethod.GET)
    public String addOutMarketView(String webSite,HttpServletRequest request){
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_market/add_market";
    }

    /**
     * 外部市场
     * @param outerMarket
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/addOutMarket" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addOutMarket(ShiguOuterMarket outerMarket){
        ResponseBase rsp = new ResponseBase();

        if(outerMarket == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerMarket.getMarketName())){
            rsp.setMsg("显示名称不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(outerMarket.getMarketId() == null){
            outerMarket.setMarketId(-1L);
        }
        if(outerMarket.getSortOrder() == null || outerMarket.getSortOrder() <= 0){
            rsp.setMsg("请求排序不能为空且要大于零");
            return JSONObject.fromObject(rsp);
        }

        shiguOutMarketService.addOuterMarket(outerMarket);

        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 修改市场VIEW
     * @param ruleId
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/changeOutMarketView" , method = RequestMethod.GET)
    public String changeOutMarket(Long ruleId, String webSite,HttpServletRequest request){
        ShiguOuterMarket outerMarket = shiguOutMarketService.getOutMarketById(ruleId);
        request.setAttribute("outerMarket", outerMarket);
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_market/change_market";
    }

    /**
     * 修改市场
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/changeOutMarket" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeOutMarket(ShiguOuterMarket outerMarket){
        ResponseBase rsp = new ResponseBase();

        if(outerMarket == null || outerMarket.getRuleId() == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerMarket.getMarketName())){
            rsp.setMsg("显示名称不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(outerMarket.getMarketId() == null){
            outerMarket.setMarketId(-1L);
        }
        if(outerMarket.getSortOrder() == null || outerMarket.getSortOrder() <= 0){
            rsp.setMsg("请求排序不能为空且要大于零");
            return JSONObject.fromObject(rsp);
        }

        shiguOutMarketService.updateOuterMarket(outerMarket);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 市场删除
     * @param marketIds
     * @return
     */
    @RequestMapping(value = "/sysman/outmarket/delOutMarket" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delOutMarket(String marketIds){
        ResponseBase rsp = new ResponseBase();
        if(StringUtils.isEmpty(marketIds)){
            rsp.setMsg("请选择要删除的市场");
            return JSONObject.fromObject(marketIds);
        }
        String [] marketstrIds = marketIds.split(",");

        try{
            shiguOutMarketService.delOuterMarket(marketstrIds);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            e.printStackTrace();
            rsp.setMsg(e.getMessage());
        }

        return JSONObject.fromObject(rsp);
    }


}
