package com.shigu.jd.actions;

import com.openJar.exceptions.OpenException;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.requests.api.JdImageWriteUpdateRequest;
import com.openJar.requests.api.JdTransportWriteUpdateWareTransportIdRequest;
import com.openJar.requests.api.JdWareAddRequest;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;
import com.openJar.responses.api.JdImageWriteUpdateResponse;
import com.openJar.responses.api.JdTransportWriteUpdateWareTransportIdResponse;
import com.openJar.responses.api.JdWareAddResponse;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
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
@RequestMapping("api")
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
            GoodsCanbeUploadedToJdResponse response,BindingResult bindingResult) throws OtherCustomException {
        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        GoodsCanbeUploadedToJdResponse res=new GoodsCanbeUploadedToJdResponse();
        res.setSuccess(true);
        res.setCan(jdGoodsService.goodsCanbeUploadedToJd(request.getTbCid()));
        return res;
    }

    /**
     * 上传一件商品
     * @param request
     * @return
     * @throws ImgDownloadException
     * @throws JdApiException
     */
    @RequestMapping("jdWareAdd")
    @ResponseBody
    public JdWareAddResponse jdWareAddResponse(JdWareAddRequest request) throws OtherCustomException, JdAuthOverdueException {
        JdWareAddResponse res=new JdWareAddResponse();
        res.setSuccess(true);
        res.setData(jdGoodsService.upToJd(request.getGoods(),request.getJdUid()));
        return res;
    }
    @RequestMapping("jdTransportWriteUpdateWareTransportId")
    @ResponseBody
    public JdTransportWriteUpdateWareTransportIdResponse jdTransportWriteUpdateWareTransportId(JdTransportWriteUpdateWareTransportIdRequest request) throws JdAuthOverdueException, OtherCustomException {
        JdTransportWriteUpdateWareTransportIdResponse res=new JdTransportWriteUpdateWareTransportIdResponse();
        res.setSuccess(true);
        res.setCan(jdGoodsService.bindPostTemplate(request.getJdUid(),request.getWareId(),request.getTemplateId()));
        return res;
    }
    @RequestMapping("jdImageWriteUpdate")
    @ResponseBody
    public JdImageWriteUpdateResponse jdImageWriteUpdate(JdImageWriteUpdateRequest request) throws JdAuthOverdueException, OtherCustomException {
        jdGoodsService.jdImageUpdate(request.getBo(),request.getJdUid());
        JdImageWriteUpdateResponse res=new JdImageWriteUpdateResponse();
        res.setSuccess(true);
        return res;
    }

}
