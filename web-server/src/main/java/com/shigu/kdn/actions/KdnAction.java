package com.shigu.kdn.actions;

import com.alibaba.fastjson.JSONObject;
import com.shigu.kdn.config.KuaidiniaoConfig;
import com.shigu.kdn.util.KdniaoUtil;
import com.shigu.kdn.vo.NotifySuccessVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.process.KdnProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by gtx on 2018/8/31 0031.
 *
 * @author gtx
 * @since
 */
@Controller
@RequestMapping("kdn")
public class KdnAction {

    Logger logger = LoggerFactory.getLogger(KdnAction.class);

    @Autowired
    private KdnProcess kdnProcess;
    @Autowired
    private KuaidiniaoConfig kuaidiniaoConfig;

    @RequestMapping(value = "notify",method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded;charset=utf-8")
    @ResponseBody
    public JSONObject updatePostInfo(
            @RequestParam(value = "DataSign",required = true)String dataSign,
            @RequestParam(value = "RequestData",required = true)String requestData,
            @RequestParam(value = "RequestType",required = true)String requestType) {

        NotifySuccessVO vo = new NotifySuccessVO();
        vo.seteBusinessId(kuaidiniaoConfig.geteBusinessID());
        vo.setUpdateTime(DateUtil.dateToString(new Date(),DateUtil.patternD));

        Boolean result = KdniaoUtil.verifySign(requestData, kuaidiniaoConfig.getAppKey(), dataSign);
        if (!result) {
            if (logger.isWarnEnabled()){
                logger.warn("快递鸟推送验签失败 >>> dataSign =  " + dataSign +
                        "  requestData = " + requestData +"  requestType = "+requestType);
            }
            vo.setSuccess(false);
            vo.setReason("验签失败");
            return JSONObject.parseObject(JSONObject.toJSONString(vo));
        }

        //签名通过,业务处理
        //订阅的推送订单数据，可能会有多笔订单，count统计订单数量
        try {
            kdnProcess.updatePostInfoByNotify(requestData);
            vo.setSuccess(true);
        } catch (Exception e) {
            if (logger.isWarnEnabled()) {
                logger.warn("更新快递信息失败 >>> dataSign =  " + dataSign +
                        "  requestData = " + requestData + "  requestType = " + requestType);
            }
            vo.setSuccess(false);
            vo.setReason("数据更新失败");
        }

        return JSONObject.parseObject(JSONObject.toJSONString(vo));
    }

}
