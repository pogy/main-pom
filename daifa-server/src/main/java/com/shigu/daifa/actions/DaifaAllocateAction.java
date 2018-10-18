package com.shigu.daifa.actions;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.OrderAllocateBO;
import com.shigu.daifa.services.DaifaAllocateService;
import com.shigu.daifa.vo.OrderAllocateVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
     * ====================================================================================
     * @方法名： orderAllocation
     * @user gzy 2017/10/13 13:02
     * @功能： 待分配列表
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/orderAllocation")
    public String orderAllocation(OrderAllocateBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<OrderAllocateVO> orderAllocateVOList = daifaAllocateService.orderAllcoation(bo,auth.getDaifaSellerId());
        model.addAttribute("childOrders",orderAllocateVOList);
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",bo.getCount()+",10,"+bo.getPage());
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","orderAllocation.htm");//前台所要的左边菜单
        return "daifa/orderAllocation";
    }

    /**
     * ====================================================================================
     * @方法名： getMarketList
     * @user gzy 2017/10/13 13:02
     * @功能： 获取市场列表
     * @param: []
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/getMarketList")
    @ResponseBody
    public JSONObject getMarketList(){
        return daifaAllocateService.getMarketList();
    }

    /**
     * ====================================================================================
     * @方法名： getFloorList
     * @user gzy 2017/10/13 13:03
     * @功能： 获取楼层列表
     * @param: [marketId] 市场id
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/getFloorList")
    @ResponseBody
    public JSONObject getFloorList(Long marketId){
        return daifaAllocateService.getFloorList(marketId);
    }
    /**
     * ====================================================================================
     * @方法名： getShopList
     * @user gzy 2017/10/13 13:03
     * @功能：
     * @param: [floorId]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/getShopList")
    @ResponseBody
    public JSONObject getShopList(Long floorId){
        return daifaAllocateService.getShopList(floorId);
    }

    /**
     * ====================================================================================
     * @方法名： submitAllocation
     * @user gzy 2017/10/13 13:04
     * @功能： 分配
     * @param: [userId 用户id, type 分配的类型：market、floor、shop、childOrder,即市场、楼层、档口、子订单, ids 分配的类型下的id的集合]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/submitAllocation")
    @ResponseBody
    public synchronized JSONObject submitAllocation(Long userId,String type,String ids) throws DaifaException {

        return daifaAllocateService.submitAllocation(userId,type,ids);
    }

}
