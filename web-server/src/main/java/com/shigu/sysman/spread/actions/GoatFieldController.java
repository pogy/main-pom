package com.shigu.sysman.spread.actions;


import com.opentae.data.mall.beans.GoatFieldValue;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.sysman.spread.bo.GoatFieldValueBo;
import com.shigu.sysman.spread.service.GoatFieldValueService;
import com.shigu.sysman.spread.vo.GoatFieldValueVo;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 广告数据控制器
 *
 * @author shigu_zjb
 * @date 2017/04/10 13:27
 *
 *
 */
@Controller
public class GoatFieldController {

    private static final Logger logger = Logger.getLogger(GoatFieldController.class);

    @Autowired
    private GoatFieldValueService goatFieldValueService;

    /**
     * 广告数据管理
     * @param goatFieldValueBo
     * @return
     */
    @RequestMapping(value = "/sysman/goat/fieldValueList" , method = RequestMethod.GET)
    public String queryList(GoatFieldValueBo goatFieldValueBo, HttpServletRequest request){
        if(goatFieldValueBo == null){
            goatFieldValueBo = new GoatFieldValueBo();
        }
        ShiguPager<GoatFieldValueVo> goatModelVoShiguPager = goatFieldValueService.findGoatFieldValuePager(goatFieldValueBo);
        request.setAttribute("pager", goatModelVoShiguPager);
        return "";
    }

    /**
     * 新增广告数据VIEW
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addFieldValueView" , method = RequestMethod.GET)
    public String addFieldValueView(HttpServletRequest request){
        return null;
    }

    /**
     * 新增广告数据
     * @param goatFieldValue
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addFieldValue" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addFieldValue(GoatFieldValue goatFieldValue){
        ResponseBase rsp = new ResponseBase();

        if(goatFieldValue == null){
            rsp.setMsg("新增广告数据发生错误");
            return JSONObject.fromObject(rsp);
        }
        if(goatFieldValue.getGoatId() == null){
            rsp.setMsg("请输入广告ID");
            return JSONObject.fromObject(rsp);
        }
        if(goatFieldValue.getFid() == null){
            rsp.setMsg("请输入列ID");
            return JSONObject.fromObject(rsp);
        }

        goatFieldValueService.addFieldValue(goatFieldValue);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 更新广告数据
     * @param vid
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeFieldView" , method = RequestMethod.GET)
    public String changeFieldView(Long vid, HttpServletRequest request){
        GoatFieldValueBo goatFieldValueBo = new GoatFieldValueBo();
        goatFieldValueBo.setVidId(vid);
        GoatFieldValueVo goatFieldValueVo = goatFieldValueService.findGoatFieldValueByBo(goatFieldValueBo);
        request.setAttribute("goatFieldValue", goatFieldValueVo);
        return "";
    }

    /**
     * 更新广告数据
     * @param goatFieldValue
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeFieldValue" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeFieldValue(GoatFieldValue goatFieldValue){
        ResponseBase rsp = new ResponseBase();

        if(goatFieldValue == null || goatFieldValue.getVid() == null){
            rsp.setMsg("新增广告数据发生错误");
            return JSONObject.fromObject(rsp);
        }
        if(goatFieldValue.getGoatId() == null){
            rsp.setMsg("请输入广告ID");
            return JSONObject.fromObject(rsp);
        }
        if(goatFieldValue.getFid() == null){
            rsp.setMsg("请输入列ID");
            return JSONObject.fromObject(rsp);
        }

        goatFieldValueService.updateGoatFieldValue(goatFieldValue);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }

}
