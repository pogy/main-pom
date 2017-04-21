package com.shigu.sysman.spread.actions;


import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.beans.GoatModel;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.spread.vo.GoatFieldVO;
import com.shigu.sysman.spread.bo.GoatFieldBo;
import com.shigu.sysman.spread.bo.GoatLocationBo;
import com.shigu.sysman.spread.service.GoatFieldService;
import com.shigu.sysman.spread.service.GoatLocationService;
import com.shigu.sysman.spread.vo.GoatFieldVo;
import com.shigu.sysman.spread.vo.GoatLocationVo;
import com.shigu.sysman.spread.vo.GoatModelVo;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 广告位置控制器
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:06
 *
 */
@Controller
public class GoatLocationController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(GoatLocationController.class);

    @Autowired
    private GoatLocationService goatLocationService;


    /**
     * 广告位置管理
     * @param goatLocationBo
     * @return
     */
    @RequestMapping(value = "/sysman/goat/locationList" , method = RequestMethod.GET)
    public String queryList(GoatLocationBo goatLocationBo, HttpServletRequest request){
        if(goatLocationBo == null){
            goatLocationBo = new GoatLocationBo();
        }
        ShiguPager<GoatLocationVo> goatLocationVoShiguPager = goatLocationService.findGoatLocationVoPager(goatLocationBo);
        request.setAttribute("pager", goatLocationVoShiguPager);
        return "sysman/spread/location/location_list";
    }

    /**
     * 新增广告位置VIEW
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addLocationView" , method = RequestMethod.GET)
    public String addGoatLocationView(Long locationId, HttpServletRequest request){



        request.setAttribute("locationId", locationId);
        return null;
    }

    /**
     * 新增广告位置
     * @param goatLocation
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addLocation" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLocation(GoatLocation goatLocation){
        ResponseBase rsp = new ResponseBase();

        if(goatLocation == null){
            rsp.setMsg("新增广告位置发生错误");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(goatLocation.getLocalCode())){
            rsp.setMsg("请输入广告位置CODE");
            return JSONObject.fromObject(rsp);
        }
        if(goatLocation.getType() == null){
            rsp.setMsg("请输入广告类别");
            return JSONObject.fromObject(rsp);
        }
        if(goatLocation.getUnderLine() == null){
            goatLocation.setUnderLine(true);
        }

        goatLocationService.addLocation(goatLocation);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 更新广告位置
     * @param goatLocationId
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeLocationView" , method = RequestMethod.GET)
    public String changeLocationView(Long goatLocationId, HttpServletRequest request){
        GoatLocationBo goatLocationBo = new GoatLocationBo();
        goatLocationBo.setLocationId(goatLocationId);
        GoatLocationVo goatLocationVo = goatLocationService.findGoatLocationByBo(goatLocationBo);
        request.setAttribute("local", goatLocationVo);
        return "sysman/spread/location/change_location";
    }

    /**
     * 更新广告位置
     * @param goatLocation
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeLocation" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeLocation(GoatLocation goatLocation){
        ResponseBase rsp = new ResponseBase();

        if(goatLocation == null || goatLocation.getLocalId() == null){
            rsp.setMsg("新增广告位置发生错误");
            return JSONObject.fromObject(rsp);
        }
//        if(StringUtils.isEmpty(goatLocation.getLocalCode())){
//            rsp.setMsg("请输入广告位置CODE");
//            return JSONObject.fromObject(rsp);
//        }
//        if(goatLocation.getType() == null){
//            rsp.setMsg("请输入广告类别");
//            return JSONObject.fromObject(rsp);
//        }
        if(StringUtils.isEmpty(goatLocation.getLocalAreaCode())){
            rsp.setMsg("位置区域编号不能为空");
            return JSONObject.fromObject(rsp);
        }

        goatLocationService.updateGoatLocation(goatLocation);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }


}
