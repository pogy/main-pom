package com.shigu.sysman.goods.actions;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.sysman.goods.bo.ShiguGoodsTinyBo;
import com.shigu.sysman.goods.service.ShiguGoodsTinyService;
import com.shigu.sysman.goods.vo.ShiguGoodsTinyVo;
import com.shigu.sysman.shop.actions.ShiguOuterFloorController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品权重调整
 *
 * @author shigu_zjb
 * @date 2017/04/12 12:23
 *
 */
@Controller
public class ShiguGoodsWhController {

    private static final Logger logger = LoggerFactory.getLogger(ShiguGoodsWhController.class);

    @Autowired
    private ShiguGoodsTinyService shiguGoodsTinyService;

    /**
     * 权重商品
     * @param shiguGoodsTinyBo
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goods/wh_list")
    public String queryList(ShiguGoodsTinyBo shiguGoodsTinyBo, HttpServletRequest request){
        if(shiguGoodsTinyBo == null){
            shiguGoodsTinyBo = new ShiguGoodsTinyBo();
        }
        if(shiguGoodsTinyBo.getGoodsId() == null){
            shiguGoodsTinyBo.setGtSortOrder(999L);
        }
        shiguGoodsTinyBo.setPageSize(56);
        shiguGoodsTinyBo.setWebsite("hz");
        ShiguPager<ShiguGoodsTinyVo> shiguPager = shiguGoodsTinyService.findPagerByBo(shiguGoodsTinyBo);
        request.setAttribute("pager", shiguPager);
        request.setAttribute("bo", shiguGoodsTinyBo);
        return "sysman/goods/wh/goods_whlist";
    }

    /**
     * 更新权重页面
     * @param goodsId
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goods/changeWhView" , method = RequestMethod.GET)
    public String changWhView(Long goodsId, HttpServletRequest request){
        ShiguGoodsTinyVo shiguGoodsTinyVo = shiguGoodsTinyService.findGoodsTinyById(goodsId,"hz");
        request.setAttribute("shiguGoodsTiny", shiguGoodsTinyVo);
        return "sysman/goods/wh/change_wh";
    }

    /**
     * 更新权重
     * @param goodsId
     * @param sortOrder
     * @return
     */
    @RequestMapping(value = "/sysman/goods/changeWh" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeWh(Long goodsId, Double sortOrder){
        ResponseBase rsp = new ResponseBase();

        if(goodsId == null){
            rsp.setMsg("请选择一个商品");
            return JSONObject.fromObject(rsp);
        }
        if(sortOrder == null){
            rsp.setMsg("请输入权重值");
            return JSONObject.fromObject(rsp);
        }

        sortOrder = sortOrder * 1000;

        ShiguGoodsTinyVo shiguGoodsTinyVo = shiguGoodsTinyService.findGoodsTinyById(goodsId,"hz");
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setNumIid(shiguGoodsTinyVo.getNumIid());
        shiguGoodsTiny.setStoreId(shiguGoodsTinyVo.getStoreId());
        shiguGoodsTiny.setSortOrder(sortOrder.longValue());

        try{
            shiguGoodsTinyService.updateGoodsTiny(shiguGoodsTiny);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (ItemModifyException e){
            e.printStackTrace();
            rsp.setMsg(e.getMessage());
        }

        return JSONObject.fromObject(rsp);
    }

}
