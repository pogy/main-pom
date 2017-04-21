package com.shigu.sysman.spread.actions;

import com.opentae.data.mall.beans.GoatModel;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.sysman.spread.bo.GoatModelBo;
import com.shigu.sysman.spread.service.GoatModelService;
import com.shigu.sysman.spread.vo.GoatModelVo;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 广告模板控制器
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:12
 *
 */
@Controller
public class GoatModelController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(GoatModelController.class);

    @Autowired
    private GoatModelService goatModelService;

    /**
     * 广告模板管理
     * @param goatModelBo
     * @return
     */
    @RequestMapping(value = "/sysman/goat/modelList" , method = RequestMethod.GET)
    public String queryList(GoatModelBo goatModelBo, HttpServletRequest request){
        if(goatModelBo == null){
            goatModelBo = new GoatModelBo();
        }
        ShiguPager<GoatModelVo> goatModelVoShiguPager = goatModelService.findGoatModelPager(goatModelBo);
        request.setAttribute("pager", goatModelVoShiguPager);
        return "";
    }

    /**
     * 新增广告模板VIEW
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addModelView" , method = RequestMethod.GET)
    public String addGoatModelView(Long locationId, HttpServletRequest request){
        request.setAttribute("locationId", locationId);
        return null;
    }

    /**
     * 新增广告模板
     * @param goatModel
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addGoatModel" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addGoatModel(GoatModel goatModel){
        ResponseBase rsp = new ResponseBase();

        if(goatModel == null){
            rsp.setMsg("新增广告模板发生错误");
            return JSONObject.fromObject(rsp);
        }
        if(goatModel.getLocationId() == null){
            rsp.setMsg("请输入广告位置ID");
            return JSONObject.fromObject(rsp);
        }

        goatModelService.addModel(goatModel);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 更新广告模板
     * @param goatModelId
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeModelView" , method = RequestMethod.GET)
    public String changeModelView(Long goatModelId, HttpServletRequest request){
        GoatModelBo goatModelBo = new GoatModelBo();
        goatModelBo.setModelId(goatModelId);
        GoatModelVo goatModelVo = goatModelService.findGoatModelByBo(goatModelBo);
        request.setAttribute("goatModel", goatModelVo);
        return "";
    }

    /**
     * 更新广告模板
     * @param goatModel
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeModel" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeModel(GoatModel goatModel){
        ResponseBase rsp = new ResponseBase();

        if(goatModel == null || goatModel.getModelId() == null){
            rsp.setMsg("广告模板不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(goatModel.getLocationId() == null){
            rsp.setMsg("请输入广告位置ID");
            return JSONObject.fromObject(rsp);
        }

        goatModelService.updateGoatModel(goatModel);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }

}
