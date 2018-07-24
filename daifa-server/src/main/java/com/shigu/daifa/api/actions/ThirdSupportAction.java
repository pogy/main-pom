package com.shigu.daifa.api.actions;

import com.openJar.exception.SystemInterfaceException;
import com.openJar.exception.enums.ShortCompleteEnum;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.thirdSupport.*;
import com.openJar.responses.thirdSupport.*;
import com.shigu.component.common.SystemConstant;
import com.shigu.daifa.api.beans.NotCodeSets;
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
 * Created by pc on 2016-07-05.
 */

@Controller
@RequestMapping("/api")
public class ThirdSupportAction {
    @Autowired
    ThirdSupportService thirdSupportService;

    /**
     * 登陆
     *
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("thirdLoin")
    @ResponseBody
    public JSONObject smLogin(ThirdLoinRequest request) throws OpenException {
        ThirdLoinResponse res = thirdSupportService.thirdLogin(request.getLoginName(), request.getPassWord());
        JSONObject obj = JSONObject.fromObject(res);
        obj.put("success", true);
        return obj;
    }

    /**
     * 获取当前用户档口
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("selWorkUserGgoodsTasksStores")
    @ResponseBody
    public JSONObject selWorkUserGgoodsTasksStores(SelWorkUserGgoodsTasksStoresRequest request) throws OpenException {
        int status = zhuanhuaStatus(request.getStatus());
        SelWorkUserGgoodsTasksStoresResponse res = thirdSupportService.selPhoneGgoodsTasksStore(request.getDaifaNahuoId(), status);
        return JSONObject.fromObject(res);
    }

    /**
     * 根据档口Id分配用户商品
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("selWorkUserGgoodsTasksGoods")
    @ResponseBody
    public JSONObject selWorkUserGgoodsTasksGoods(SelWorkUserGgoodsTasksGoodsRequest request) throws OpenException {
        int status = zhuanhuaStatus(request.getStatus());
        List<String> codes = new ArrayList<>();
        if (request.getCodeMore() != null && request.getCodeMore().trim().length() > 0) {
            String[] cm = request.getCodeMore().split(",");
            Collections.addAll(codes, cm);
        }
        SelWorkUserGgoodsTasksGoodsResponse res = thirdSupportService.selPhoneGgoodsTasksGoods(request.getDaifaNahuoId(), request.getStoreId(), status, codes);
        return JSONObject.fromObject(res);
    }

    /**
     * 扫码 根据条码集合获得以拿到的信息（以拿、未拿）
     * @param request
     * @return
     * @throws OpenException
     */
    @RequestMapping("shortCompleteChecked")
    @ResponseBody
    public JSONObject shortCompleteChecked(ShortCompleteCheckedRequest request) throws OpenException {
        ShortCompleteCheckedResponse response = new ShortCompleteCheckedResponse();
        response.setSuccess(true);
//        OpenException exception = new OpenException();
        if (request.getBarCodeMore() == null) {
            response.setSkuList(new ArrayList<>());
            response.setSumNum(0);
            response.setSumPrice(0l);
            response.setSuccess(true);
            return JSONObject.fromObject(response);
        }
        String[] codes = request.getBarCodeMore().split(",");
        Set<Long> setO = new HashSet<Long>();//放orderId;
        for (String codestr : codes) {
            if (codestr.length() <= SystemConstant.EZINT) {
                throw new SystemInterfaceException(ShortCompleteEnum.PARAMERROR.getMsg() + ":" + codestr);
            }
            Long orderId = Long.parseLong(codestr.substring(0, codestr.length() - SystemConstant.EZINT));
            setO.add(orderId);
        }
        List<Long> oids = new ArrayList<Long>();
        oids.addAll(setO);

        response = thirdSupportService.shortCompleteChecked(request.getWorkId(), oids, request.getStatus());
        JSONObject obj = JSONObject.fromObject(response);
        obj.put("success", true);
        return obj;
    }

    /**
     * 根据条码标记成以拿到（）
     * @param request
     * @param result
     * @return
     * @throws OpenException
     */
    @RequestMapping("shortComplete")
    @ResponseBody
    public JSONObject shortComplete(ShortCompleteRequest request, BindingResult result) throws OpenException {
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

        List<NotCodeSets> bos = new ArrayList<>();
        //条码数字集合根据后面的数字标记未拿到原因
        if (request.getNotCodeSets() != null && request.getNotCodeSets().size() > 0) {
            for (String nc : request.getNotCodeSets()) {
                String[] ns = nc.split(":");
                List<Long> upoids = new ArrayList<Long>();
                if (ns.length == 2) {
                    int day;
                    try {
                        day = Integer.parseInt(ns[1]);
                    } catch (Exception e) {
                        continue;
                    }
                    if (day > 0) {
                        String[] cs = ns[0].split(",");
                        for (String c : cs) {
                            try {
                                Long orderId = Long.parseLong(c.substring(0, c.length() - SystemConstant.EZINT));
                                upoids.add(orderId);
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                    NotCodeSets bo = new NotCodeSets();
                    bo.setDay(day);
                    bo.setOrderIds(upoids);
                    bos.add(bo);
                }
            }
        }
        if (bos.size() == 0) {
            bos = null;
        }
        try {
            thirdSupportService.shortComplete(request.getWorkId(), request.getStoreNumId(), request.getStatus(), orderIds, bos);
        } catch (DaifaException e) {
            throw new SystemInterfaceException(e.getMessage());
        }
        ShortCompleteResponse response = new ShortCompleteResponse();
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
