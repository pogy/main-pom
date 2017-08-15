package com.shigu.daifa.actions;

import com.shigu.daifa.bo.OrderAllocateBO;
import com.shigu.daifa.services.DaifaAllocateService;
import com.shigu.daifa.vo.OrderAllocateVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pc on 2017-08-15.
 * 待分配
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class DaifaAllocateAction {
    private DaifaAllocateService daifaAllocateService;
    @Autowired
    public void setDaifaAllocateService(DaifaAllocateService daifaAllocateService) {
        this.daifaAllocateService = daifaAllocateService;
    }

    /**
     * 待分配列表
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/orderAllocation")
    public String orderAllocation(OrderAllocateBO bo,Model model){
        List<OrderAllocateVO> orderAllocateVOList = daifaAllocateService.orderAllcoation(bo);
        model.addAttribute("childOrders",orderAllocateVOList);
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",bo.getCount()+",10,"+bo.getPage());

        return "daifa/orderAllocation";
    }

    @RequestMapping("daifa/getMarketList")
    @ResponseBody
    public JSONObject getMarketList(){
        JSONObject obj = daifaAllocateService.getMarketList();
        return null;
    }
    public static void main(String[] args) {

    }
}
