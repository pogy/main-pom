package com.shigu.daifa.api.actions;

import com.openJar.exception.SystemInterfaceException;
import com.openJar.exception.enums.ShortCompleteEnum;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.thirdSupport.*;
import com.openJar.responses.thirdSupport.*;
import com.shigu.component.common.SystemConstant;
import com.shigu.daifa.api.beans.NotCodeSets;
import com.shigu.daifa.api.services.ThirdIssuingService;
import com.shigu.daifa.api.services.ThirdSupportService;
import com.shigu.main4.daifa.exceptions.DaifaException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.daifa.api.actions
 * @ClassName: ThirdIssuingAcion
 * @Author: sy
 * @CreateDate: 2018/7/18 0018 17:05
 */
@Controller
@RequestMapping("/issuingApp")
public class ThirdIssuingAcion {
    @Autowired
    ThirdSupportService thirdSupportService;
    @Autowired
    ThirdIssuingService thirdIssuingService;

    /**
     * 登陆
     *
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("thirdIssuingLogin")
    @ResponseBody
    public JSONObject smLogin(ThirdIssuingLoinRequest request) throws OpenException {
        ThirdLoinResponse res = thirdIssuingService.thirdLogin(request.getLoginName(), request.getPassWord());
        JSONObject obj = JSONObject.fromObject(res);
        if (res.getWorkerId() == null) {
            obj.put("success", false);
            return obj.element("error", false).element("msg", "当前用户已停用");
        }
        obj.put("success", true);
        return obj;
    }

    /**
     *  获取当前用户展示信息（总件数、已拿件数、暂未拿件数、缺货件数）
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("selWorkUserGgoodsTasks")
    @ResponseBody
    public JSONObject selWorkUserGgoodsTasks(SelWorkUserGgoodsTasksRequest request) throws OpenException {
        SelWorkUserGgoodsTasksResponse res = thirdIssuingService.selGgoodsTasksWorkerId(request.getDaifaNahuoId());
        return JSONObject.fromObject(res);
    }

    /**
     * 打开扫描页面（未操作拿货商品列表）
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("selScanGgoods")
    @ResponseBody
    public JSONObject selScanGgoodsAndRefund(SelScanGgoodsRequest request) throws OpenException {
        SelScanGgoodsResponse res = thirdIssuingService.selScanGgoodsList(request.getDaifaNahuoId());
        return JSONObject.fromObject(res);
    }


    /**
     * 根据条码标记成以拿到或缺货（根据status值确定）
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("selTagHaveGgoods")
    @ResponseBody
    public JSONObject selTagHaveGgoods(SelTagHaveGgoodsRequest request) throws OpenException {
        List<Long> orderIds = new ArrayList<>();
        String[] codes = request.getBarCodeMore().split(",");
        Set<Long> setO = new HashSet<>();
        Map<Long, String> codeMap = new HashMap<>();
        for (String codestr : codes) {
            if (codestr.length() <= SystemConstant.EZINT) {
                throw new SystemInterfaceException(ShortCompleteEnum.PARAMERROR.getMsg() + ":" + codestr);
            }
            Long orderId = Long.parseLong(codestr.substring(0, codestr.length() - SystemConstant.EZINT));
            setO.add(orderId);
            codeMap.put(orderId, codestr);
        }
        orderIds.addAll(setO);
        try {
            thirdIssuingService.selTagHaveGgoods(request.getDaifaNahuoId(), request.getStatus(), orderIds,request.getHaveGoodsTime());
        } catch (DaifaException e) {
            throw new SystemInterfaceException(e.getMessage());
        }
        SelTagHaveGgoodsResponse response = new SelTagHaveGgoodsResponse();
        response.setMsg("操作成功");
        response.setSuccess(true);
        return JSONObject.fromObject(response);
    }


    private int zhuanhuaStatus(int st) throws SystemInterfaceException {
        switch (st) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            default: {
                throw new SystemInterfaceException("参数错误");
            }
        }
    }
}
