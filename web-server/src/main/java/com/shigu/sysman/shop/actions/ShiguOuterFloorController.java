package com.shigu.sysman.shop.actions;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.sysman.shop.service.ShiguOuterFloorService;
import com.shigu.sysman.shop.service.ShopService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 外部楼层管理/楼层展示
 *
 * @author shigu_zjb
 * @date 2017/03/25 11:17
 *
 */
@Controller
public class ShiguOuterFloorController {

    private static final Logger logger = LoggerFactory.getLogger(ShiguOuterFloorController.class);

    @Autowired
    private ShiguOuterFloorService shiguOuterFloorService;

    /**
     * 楼层展示LIST
     * @param outMarketId
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/list" , method = RequestMethod.GET)
    public String outFloorList(Long outMarketId, String webSite,HttpServletRequest request){
        List<ShiguOuterFloor> shiguOuterFloorList = shiguOuterFloorService.findOuterFloorList(outMarketId);
        request.setAttribute("outerFloorList", shiguOuterFloorList);
        request.setAttribute("ruleId",outMarketId);
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_floor/outer_floor_list";
    }

    /**
     * 新增楼层展示VIEW
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/addOutFloorView" , method = RequestMethod.GET)
    public String addOutFloorView(Long ruleId, String webSite,HttpServletRequest request){
        request.setAttribute("ruleId",ruleId);
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_floor/add_floor";
    }

    /**
     * 楼层添加
     * @param outerFloor
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/addOutFloor" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addOutFloor(ShiguOuterFloor outerFloor,Long ruleId){
        ResponseBase rsp = new ResponseBase();
        if(outerFloor == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerFloor.getShowName())){
            rsp.setMsg("楼层显示名称不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(ruleId == null){
            rsp.setMsg("绑定市场展示ID不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerFloor.getFloorIds())){
            outerFloor.setFloorIds("-1");
        }

        shiguOuterFloorService.addOuterFloor(outerFloor, ruleId);

        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }


    /**
     * 店铺绑定列表
     * @param outFloorId
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/outShopList" , method =  RequestMethod.GET)
    public String outShopList(Long outFloorId, String webSite,HttpServletRequest request){
        List<ShiguShop> shiguShopList = shiguOuterFloorService.getOuterShopList(outFloorId);
        request.setAttribute("shopList", shiguShopList);
        request.setAttribute("webSite",webSite);
        request.setAttribute("outFloorId",outFloorId);
        return "sysman/market/outer_floor/outer_shop_list";
    }

    /**
     * 添加定义店铺
     * @param outFloorId
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/addOutShopView" , method = RequestMethod.GET)
    public String addOutShopView(Long outFloorId, String webSite,HttpServletRequest request){
        request.setAttribute("outFloorId", outFloorId);
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_floor/add_outer_shop";
    }


    /**
     * 新增定义店铺
     * @param outFloorId
     * @param shopId
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/addOutShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addOutShop(Long outFloorId,Long shopId,String shopNum){
        ResponseBase rsp = new ResponseBase();
        if(outFloorId == null){
            rsp.setMsg("楼层ID不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(shopId == null){
            rsp.setMsg("还未选择绑定店铺");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(shopNum)){
            rsp.setMsg("请输入档口号");
            return JSONObject.fromObject(rsp);
        }

        shiguOuterFloorService.addOuterShop(outFloorId,shopId,shopNum);

        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 删除店铺绑定
     * @param outFloorId
     * @param shopIds
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/delOutShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delOutShop(Long outFloorId,String shopIds){
        ResponseBase rsp = new ResponseBase();

        if(outFloorId == null){
            rsp.setMsg("店铺绑定楼层ID不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(shopIds)){
            rsp.setMsg("请选择要删除的店铺");
            return JSONObject.fromObject(rsp);
        }

        String [] ids = shopIds.split(",");
        shiguOuterFloorService.delOuterShop(outFloorId,ids);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 楼层更新VIEW
     * @param outFloorId
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/changeOuterFloorView" , method = RequestMethod.GET)
    public String changeOuterFloorView(Long outFloorId, Long ruleId,String webSite,HttpServletRequest request){
        ShiguOuterFloor shiguOuterFloor = shiguOuterFloorService.findOuterFloorById(outFloorId);
        request.setAttribute("floor",shiguOuterFloor);
        request.setAttribute("ruleId",ruleId);
        request.setAttribute("webSite",webSite);
        return "sysman/market/outer_floor/change_floor";
    }

    /**
     * 修改楼层
     * @param outerFloor
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/changeOuterFloor" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeOuterFloor(ShiguOuterFloor outerFloor, Long ruleId){
        ResponseBase rsp = new ResponseBase();
        if(outerFloor == null || outerFloor.getOuterFloorId() == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerFloor.getShowName())){
            rsp.setMsg("楼层显示名称不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(ruleId == null){
            rsp.setMsg("绑定市场展示ID不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(outerFloor.getFloorIds())){
            outerFloor.setFloorIds("-1");
        }

        shiguOuterFloorService.updateOutFloor(outerFloor);

        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 删除楼层
     * @param ouerFloorIds
     * @param ruleId
     * @return
     */
    @RequestMapping(value = "/sysman/outFloor/delOuterFloor" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delOuterFloor(String ouerFloorIds,Long ruleId){
        ResponseBase rsp = new ResponseBase();
        if(StringUtils.isEmpty(ouerFloorIds)){
            rsp.setStatus("请选择要删除的楼层");
            return JSONObject.fromObject(rsp);
        }
        if(ruleId == null){
            rsp.setMsg("绑定的市场ID不能为空");
            return JSONObject.fromObject(rsp);
        }

        try{
            String [] outFloorsId = ouerFloorIds.split(",");
            shiguOuterFloorService.delOutFloor(outFloorsId,ruleId);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            e.printStackTrace();
            rsp.setMsg(e.getMessage());
        }


        return JSONObject.fromObject(rsp);
    }



}
