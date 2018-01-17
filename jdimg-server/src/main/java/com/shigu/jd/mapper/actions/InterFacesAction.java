package com.shigu.jd.mapper.actions;

import com.openJar.beans.JdItemProp;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.interfaces.SelJdItemPropsRequest;
import com.openJar.requests.interfaces.SelJdPropValuesRequest;
import com.openJar.requests.interfaces.SelJdTbBindsRequest;
import com.openJar.requests.interfaces.SelShiguJdCatRequest;
import com.openJar.responses.interfaces.SelJdItemPropsRespone;
import com.openJar.responses.interfaces.SelJdPropValuesResponse;
import com.openJar.responses.interfaces.SelJdTbBindsResponse;
import com.openJar.responses.interfaces.SelShiguJdCatResponse;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.mapper.services.InterFacesService;
import net.sf.json.JSONObject;
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
        SelJdItemPropsRespone res=new SelJdItemPropsRespone();
        List<JdItemProp> list= interFacesService.selJdItemProps(request.getJdCid());
        res.setSuccess(true);
        res.setDatas(list);
        return JSONObject.fromObject(res);
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
        return JSONObject.fromObject(res);
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
        return JSONObject.fromObject(res);
    }

    @RequestMapping("api/selShiguJdcat")
    @ResponseBody
    public JSONObject selShiguJdcat(@Valid SelShiguJdCatRequest request,BindingResult error) throws OtherCustomException {
        if(error.hasErrors()){
            throw new OtherCustomException(error.getAllErrors().get(0).getDefaultMessage());
        }
        SelShiguJdCatResponse res=new SelShiguJdCatResponse();
        res.setSuccess(true);
        res.setData(interFacesService.selShiguJdcat(request.getCid()));
        return JSONObject.fromObject(res);
    }

}
