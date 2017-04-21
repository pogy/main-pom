package com.shigu.sysman.shop.actions;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguMarket;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.sysman.shop.bo.ShiguMarketBo;
import com.shigu.sysman.shop.service.ShiguMarketService;
import com.shigu.sysman.shop.vo.ShiguShopVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 楼层CONTROLLER
 *
 * @author shigu_zjb
 * @date 2017/03/09 19:10
 *
 */
@Controller
public class ShiguMarketController {

    @Autowired
    private ShiguMarketService shiguMarketService;

    /**
     * 选择市场
     * @return
     */
    @RequestMapping(value = "/sysman/market/selectList" , method = RequestMethod.GET)
    public String marketList(ShiguMarketBo shiguMarketBo, HttpServletRequest request){
        if(shiguMarketBo == null){
            shiguMarketBo = new ShiguMarketBo();
        }
        // 此处不分页
        ShiguMarket shiguMarket = new ShiguMarket();

        if(shiguMarketBo.getMarketId() != null){
            shiguMarket.setParentMarketId(shiguMarketBo.getMarketId());
        }
        if(shiguMarketBo.getFloorId() != null){
            shiguMarket.setParentMarketId(shiguMarketBo.getFloorId());
        }
        if(shiguMarket.getParentMarketId() == null){
            shiguMarket.setParentMarketId(0L);
        }

        ShiguMarket shiguMarketLiBo = new ShiguMarket();
        shiguMarketLiBo.setParentMarketId(0L);
        shiguMarketLiBo.setWebSite(shiguMarketBo.getWebSite());
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarketLiBo);

        if(shiguMarketBo.getMultiBand()!=null&&shiguMarketBo.getMultiBand()&&shiguMarket.getParentMarketId()==0){
            shiguMarket.setParentMarketId(shiguMarketList.get(0).getMarketId());
        }

        shiguMarket.setWebSite(shiguMarketBo.getWebSite());
        List<ShiguMarket> marketList = shiguMarketService.findShiguMarketListo(shiguMarket);

        request.setAttribute("shiguMarketList" ,shiguMarketList);

        request.setAttribute("marketList", marketList);
        request.setAttribute("bo",shiguMarketBo);
        return "sysman/market/market/select_list";
    }

    /**
     * 楼层list
     * @param marketId
     * @return
     */
    @RequestMapping(value = "/sysman/floor/ajaxlist" , method = RequestMethod.POST)
    @ResponseBody
    public String floorList(Long marketId){
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(marketId);
        List<ShiguMarket> floorList = shiguMarketService.findShiguMarketListo(shiguMarket);
        return JSON.toJSONString(floorList);
    }

}
