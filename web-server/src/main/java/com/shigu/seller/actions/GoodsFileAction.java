package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.services.GoodsFileService;
import com.shigu.seller.vo.FindGoodsItemVO;
import com.shigu.seller.vo.GoodsFileVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
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
     * 根据文件路径获取关联商品
     */
    @RequestMapping("goodsFile/readGlGoodsJson")
    @ResponseBody
    public JSONObject selGoodsFileByFile(String fileKey) {
        List<ItemShowBlock> goodsFilesList = goodsFileService.selGoodsFileByFile(fileKey);
        return JsonResponseUtil.success().element("goods", goodsFilesList);
    }

    /**
     * 根据goodsId获取
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
    @RequestMapping("goodsFile/glGoodsJson")
    @ResponseBody
    public JSONObject saveGoodsFile(String fileKey, Long goodsId) {
        goodsFileService.saveGoodsFile(fileKey, goodsId);
        return JsonResponseUtil.success();
    }

    /**
     * 取消关联关系
     * @param goodsId
     * @return
     */
    @RequestMapping("goodsFile/cacelGlJson")
    @ResponseBody
    public JSONObject delGoodsFile(Long goodsId) {
        goodsFileService.delGoodsfile(goodsId);
        return JsonResponseUtil.success();
    }

    /**
     * 重命名
     * @param fileId
     * @param fileType
     * @param newName
     * @return
     */
    @RequestMapping("goodsFile/renameFile")
    @ResponseBody
    public JSONObject renameFile(String fileId, String fileType, String newName) {
        goodsFileService.rename(fileId, fileType, newName);
        return JsonResponseUtil.success();
    }

}
