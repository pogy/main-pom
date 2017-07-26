package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.seller.services.GoodsFileService;
import com.shigu.seller.vo.GoodsFileVO;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */

@Controller
public class GoodsFileAction {
    private static final Logger logger = Logger.getLogger(GoodsFileAction.class);

    @Autowired
    GoodsFileService goodsFileService;

    /**
     * 根据文件路径获取
     */
    @RequestMapping("goodsFile/fileList")
    @ResponseBody
    public JSONObject selGoodsFileByFile( String fileKey, Model model) {
        List<GoodsFileVO> goodsFilesList = goodsFileService.selGoodsFileByFile(fileKey);
        return JsonResponseUtil.success().element("fileList", goodsFilesList);
    }

    /**
     * 更加goodsId获取
     * @param goodsId
     * @return
     */
    @RequestMapping("goodsFile/selectById")
    @ResponseBody
    public JSONObject selGoodsFileByGoodsId(Long goodsId) {

        GoodsFile goodsFile = goodsFileService.selGoodsFileByGoodsId(goodsId);
        return JsonResponseUtil.success();
    }

    /**
     * 增加关联关系
     * @param fileKey
     * @param goodsId
     * @return
     */
    @RequestMapping("goodsFile/save")
    @ResponseBody
    public JSONObject saveGoodsFile( String fileKey, Long goodsId) {
        goodsFileService.saveGoodsFile(fileKey, goodsId);
        return JsonResponseUtil.success();
    }

    /**
     * 取消关联关系
     * @param fileKey
     * @param goodsId
     * @return
     */
    @RequestMapping("goodsFile/save")
    @ResponseBody
    public JSONObject delGoodsFile( String fileKey, Long goodsId) {
        goodsFileService.delGoodsfile(fileKey, goodsId);
        return JsonResponseUtil.success();
    }

}
