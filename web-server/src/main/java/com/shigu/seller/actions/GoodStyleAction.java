package com.shigu.seller.actions;

import com.shigu.seller.services.GoodStyleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class GoodStyleAction {
    @Autowired
    GoodStyleService goodStyleService;
    /**
     * 获取类目列表
     */
    @RequestMapping("seller/getCategoryList")
    @ResponseBody
    public JSONObject getCategoryList(){
        return JSONObject.fromObject(goodStyleService.getStyle());
    }

    /**
     * 添加商品风格
     */
    @RequestMapping("seller/addGoodsStyle")
    @ResponseBody
    public JSONObject addGoodsStyle(){
        return JSONObject.fromObject(goodStyleService.getStyle());
    }

    /**
     * 修改商品风格
     */
    @RequestMapping("seller/editGoodsStyle")
    @ResponseBody
    public JSONObject editGoodsStyle(){
        return JSONObject.fromObject(goodStyleService.getStyle());
    }
    /**
     * 移动商品风格排序
     */
    @RequestMapping("seller/sortGoodsStyle")
    @ResponseBody
    public JSONObject sortGoodsStyle(){
        return JSONObject.fromObject(goodStyleService.getStyle());
    }


    /**
     * 删除商品风格
     */
    @RequestMapping("seller/deleteGoodsStyle")
    @ResponseBody
    public JSONObject deleteGoodsStyle(){
        return JSONObject.fromObject(goodStyleService.getStyle());
    }
}
