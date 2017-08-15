package com.shigu.daifa.actions;

import com.shigu.daifa.bo.OrderAllocateBO;
import com.shigu.daifa.services.DaifaAllocateService;
import com.shigu.daifa.vo.OrderAllocateVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
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

    /**
     * 获取市场列表
     * @return json
     */
    @RequestMapping("daifa/getMarketList")
    @ResponseBody
    public JSONObject getMarketList(){
        return daifaAllocateService.getMarketList();
    }

    /**
     * 获取楼层列表
     * @param marketId 市场id
     * @return josn
     */
    @RequestMapping("daifa/getFloorList")
    @ResponseBody
    public JSONObject getFloorList(Long marketId){
        return daifaAllocateService.getFloorList(marketId);
    }

    @RequestMapping("daifa/getShopList")
    @ResponseBody
    public JSONObject getShopList(Long floorId){
        return daifaAllocateService.getShopList(floorId);
    }

    /**
     * 分配
     * @param userId 用户id
     * @param type 分配的类型：market、floor、shop、childOrder,即市场、楼层、档口、子订单
     * @param ids 分配的类型下的id的集合
     * @return
     */
    @RequestMapping("daifa/submitAllocation")
    @ResponseBody
    public JSONObject submitAllocation(Long userId,String type,String ids) throws DaifaException {
        return daifaAllocateService.submitAllocation(userId,type,ids);
    }

    public static void main(String[] args) {

    }
}
