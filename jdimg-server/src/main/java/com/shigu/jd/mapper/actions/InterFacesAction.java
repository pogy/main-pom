package com.shigu.jd.mapper.actions;

import com.openJar.beans.JdItemProp;
import com.openJar.commons.ResponseUtil;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.interfaces.*;
import com.openJar.responses.interfaces.*;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.mapper.services.InterFacesService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InterFacesAction {
    @Autowired
    InterFacesService interFacesService;

    @RequestMapping("api/selJdItemProps")
    @ResponseBody
    public JSONObject selJdItemProps(@Valid SelJdItemPropsRequest request, BindingResult error) throws OtherCustomException {
        if(error.hasErrors()){
            throw new OtherCustomException(error.getAllErrors().get(0).getDefaultMessage());
        }
        SelJdItemPropsResponse res=new SelJdItemPropsResponse();
        List<JdItemProp> list= interFacesService.selJdItemProps(request.getJdCid());
        res.setSuccess(true);
        res.setDatas(list);
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }
    @RequestMapping("api/selJdPropValues")
    @ResponseBody
    public JSONObject selJdPropValues(@Valid SelJdPropValuesRequest request, BindingResult error) throws OtherCustomException {
        if(error.hasErrors()){
            throw new OtherCustomException(error.getAllErrors().get(0).getDefaultMessage());
        }
        SelJdPropValuesResponse res=new SelJdPropValuesResponse();
        res.setSuccess(true);
        res.setDatas(interFacesService.selJdPropValues(request.getJdCid()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    @RequestMapping("api/selJdTbBind")
    @ResponseBody
    public JSONObject selJdTbBind(@Valid SelJdTbBindsRequest request, BindingResult error) throws OtherCustomException {
        if(error.hasErrors()){
            throw new OtherCustomException(error.getAllErrors().get(0).getDefaultMessage());
        }
        SelJdTbBindsResponse res=new SelJdTbBindsResponse();
        res.setSuccess(true);
        res.setDatas(interFacesService.selJdTbBind(request.getCid()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    @RequestMapping("api/selShiguJdCat")
    @ResponseBody
    public JSONObject selShiguJdcat(@Valid SelShiguJdCatRequest request,BindingResult error) throws OtherCustomException {
        if(error.hasErrors()){
            throw new OtherCustomException(error.getAllErrors().get(0).getDefaultMessage());
        }
        SelShiguJdCatResponse res=new SelShiguJdCatResponse();
        res.setSuccess(true);
        res.setData(interFacesService.selShiguJdcat(request.getCid()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    /**
     * 根据京东登陆名模糊查询
     * @param request
     * @return
     */
    @RequestMapping("api/selJdUidsByFuzzyJdLoginName")
    @ResponseBody
    public JSONObject selJdUidsByFuzzyJdLoginName(SelJdUidsByFuzzyJdLoginNameRequest request, SelJdUidsByFuzzyJdLoginNameResponse response) {
        if (StringUtils.isBlank(request.getJdUserNick())) {
            response.setSuccess(false);
            OpenException openException = new OpenException();
            openException.setErrMsg("昵称不能为空");
            response.setException(openException);
            return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
        }
        List<Long> jdUids = null;
        try {
            jdUids = interFacesService.selJdUidsByFuzzyJdLoginName(request.getJdUserNick());
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
        }

        response.setSuccess(true);
        response.setJdUids(jdUids);
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

}
