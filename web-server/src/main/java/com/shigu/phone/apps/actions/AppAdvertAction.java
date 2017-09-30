package com.shigu.phone.apps.actions;

import com.openJar.beans.app.AppImgBanner;
import com.openJar.beans.app.AppItemSpread;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSpreadRequest;
import com.openJar.requests.app.ItemSpreadRequest;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemSpreadResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.phone.apps.services.AppAdvertService;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.zhb.utils.BeanMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public JSONObject imgSpread(ImgSpreadRequest request){
        ImgSpreadResponse response =null;
        OpenException openException = null;
        if(request.getSpreadCode() == null || request.getWebSite() == null){
            openException = new OpenException();
            openException.setErrMsg("缺少参数");
            response = new ImgSpreadResponse();
            response.setSuccess(false);
            response.setException(openException);
            return JSONObject.fromObject(response);
        }
        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(request.getSpreadCode())){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            openException = new OpenException();
            openException.setErrMsg("缺少错误:spreadCode="+request.getSpreadCode());
            response = new ImgSpreadResponse();
            response.setSuccess(false);
            response.setException(openException);
            return JSONObject.fromObject(response);
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
    public JSONObject itemSpread(ItemSpreadRequest request) {
        ImgSpreadResponse response =null;
        OpenException openException = null;
        if(request.getSpreadCode() == null || request.getWebSite() == null){
            openException = new OpenException();
            openException.setErrMsg("缺少参数");
            response = new ImgSpreadResponse();
            response.setSuccess(false);
            response.setException(openException);
            return JSONObject.fromObject(response);
        }

        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(request.getSpreadCode())){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            openException = new OpenException();
            openException.setErrMsg("缺少错误:spreadCode="+request.getSpreadCode());
            response = new ImgSpreadResponse();
            response.setSuccess(false);
            response.setException(openException);
            return JSONObject.fromObject(response);
        }
        return JSONObject.fromObject(appAdvertService.itemSpread(request.getWebSite(),spread));
    }

}
