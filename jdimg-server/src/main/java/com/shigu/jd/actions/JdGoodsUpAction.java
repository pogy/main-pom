package com.shigu.jd.actions;

import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;
import com.shigu.jd.api.service.JdGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created By admin on 2018/1/16/14:05
 */
@Controller
@RequestMapping("goodsApi")
public class JdGoodsUpAction {

    @Autowired
    private JdGoodsService jdGoodsService;

    /**
     * 根据cid查询商品是否可上传到京东
     * @param request
     * @param response
     * @param bindingResult
     * @return
     */
    @RequestMapping("goodsCanbeUploadedToJdRequest")
    @ResponseBody
    public GoodsCanbeUploadedToJdResponse goodsCanbeUploadedToJdResponse (@Valid GoodsCanbeUploadedToJdRequest request,
            GoodsCanbeUploadedToJdResponse response,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            response.setSuccess(false);
            return response;
        }
        Boolean aBoolean = jdGoodsService.goodsCanbeUploadedToJd(request.getTbCid());
        response.setSuccess(true);
        response.setCan(aBoolean);
        return response;
    }

}
