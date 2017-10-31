package com.shigu.phone.apps.actions;

import com.openJar.requests.app.ImgSpreadRequest;
import com.openJar.requests.app.ItemSpreadRequest;
import com.openJar.responses.app.ImgSpreadResponse;
import com.shigu.phone.apps.services.AppAdvertService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.spread.enums.SpreadEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by pc on 2017-08-29.
 *app 广告action
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class AppAdvertAction {
    @Autowired
    AppAdvertService appAdvertService;
    /**
     *  图片式广告数据
     * @param request
     * @return
     */
    @RequestMapping("app/imgSpread")
    @ResponseBody
    public JSONObject imgSpread( @Valid ImgSpreadRequest request, ImgSpreadResponse response, BindingResult bindingResult){
        if(request.getSpreadCode() == null || StringUtils.isEmpty(request.getWebSite())){
            return WrapperUtil.wrapperOpenException("缺少参数",response);
        }
        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(request.getSpreadCode())){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return WrapperUtil.wrapperOpenException("缺少错误:spreadCode="+request.getSpreadCode(),response);
        }
        return JSONObject.fromObject(appAdvertService.imgSpread(spread));
    }

    /**
     *  商品广告数据
     * @param request
     * @return
     */
    @RequestMapping("app/itemSpread")
    @ResponseBody
    public JSONObject itemSpread(@Valid ItemSpreadRequest request,ImgSpreadResponse response, BindingResult bindingResult) {
        if(request.getSpreadCode() == null || StringUtils.isEmpty(request.getWebSite())){
            return WrapperUtil.wrapperOpenException("缺少参数",response);
        }

        SpreadEnum spread=null;

        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(request.getSpreadCode())){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return WrapperUtil.wrapperOpenException("缺少错误:spreadCode="+request.getSpreadCode(),response);
        }
        return JSONObject.fromObject(appAdvertService.itemSpread(request.getWebSite(),spread));
    }

}
