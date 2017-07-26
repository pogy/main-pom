package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.tools.OssIO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/26.
 */

@Controller
public class GoodsFileAction {
    private static final Logger logger = Logger.getLogger(GoodsFileAction.class);

    @Autowired
    GoodsFileService goodsFileService;

    @Autowired
    private OssIO ossIO;

    @RequestMapping("goodsFile/getSignInfo")
    public String getPostSign( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long userId = getUserId(request.getSession());
        Map<String, String> infoMap = ossIO.createPostSignInfo(userId);
        JSONObject jsonInfo = JSONObject.fromObject(infoMap);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");

        String callbackFunName = request.getParameter("callback");
        if (callbackFunName==null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(jsonInfo.toString());
        else
            response.getWriter().println(callbackFunName + "( "+jsonInfo.toString()+" )");
        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
        return null;
    }

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

    /**
     * 移动文件
     * @param fileId
     * @param targetFileId
     * @return
     */
    @RequestMapping("goodsFile/moveFile")
    @ResponseBody
    public JSONObject renameFile(String fileId, String targetFileId) {
        goodsFileService.moveFile(fileId, targetFileId);
        return JsonResponseUtil.success();
    }

    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    @RequestMapping("goodsFile/moveFile")
    @ResponseBody
    private Long getUserId(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getUserId();
    }

}
