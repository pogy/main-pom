package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.vo.PrintPostVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.PackResultVO;
import com.shigu.main4.daifa.vo.PrintExpressVO;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaifaScanAction {
    @Autowired
    PackDeliveryProcess packDeliveryProcess;

    @RequestMapping("daifa/scanBarCode")
    public String scanBarCode(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        model.addAttribute("userIcon","");
        model.addAttribute("userName",daifaUser.getDaifaUserName());
        return "daifa/scanBarCode";
    }
    @RequestMapping("daifa/doScanBarCode")
    @ResponseBody
    public JSONObject doScanBarCode(String barCode) throws DaifaException {
        Long dfOrderId;
        try {
            barCode = barCode.substring(0,barCode.length()-7);
            dfOrderId = new Long(barCode);
        } catch (Exception e) {
            throw new DaifaException("此条码对应的订单编号不存在");
        }
        PackResultVO vo=packDeliveryProcess.packSubOrder(dfOrderId);
        JSONObject obj= JsonResponseUtil.success();
        obj.put("goodsInfo",vo.getGoodsInfo());
        obj.put("sendId",vo.getSendId());
        return obj;
    }
    @RequestMapping("daifa/printSinglePost")
    @ResponseBody
    public JSONObject printSinglePost(Long sendId){
        PrintPostVO vo= BeanMapper.map(packDeliveryProcess.printExpress(sendId),PrintPostVO.class);
        JSONObject obj= JsonResponseUtil.success();
        obj.put("printInfo",vo);
        return obj;
    }
}
