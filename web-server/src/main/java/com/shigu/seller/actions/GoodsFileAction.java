package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
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
import java.util.Date;
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
    public JSONObject moveFile(String fileId, String targetFileId) {
        goodsFileService.moveFile(fileId, targetFileId);
        return JsonResponseUtil.success();
    }

    /**
     * 创建文件
     * @param parentDir
     * @param dir
     * @return
     */
    @RequestMapping("goodsFile/createFoler")
    @ResponseBody
    public JSONObject createFoler(String parentDir, String dir) {
        String fileId = goodsFileService.createDir(parentDir, dir);

        JSONObject obj= JsonResponseUtil.success();
        obj.element("fileId",fileId);
        obj.element("fileName",dir);
        obj.element("fileCreateTime", DateUtil.dateToString(new Date(), DateUtil.patternD));
        return obj;
    }

    /**
     * 删除文件
     * @param fileId
     * @param fileType
     * @return
     */
    @RequestMapping("goodsFile/deleteFile")
    @ResponseBody
    public JSONObject deleteFile(String fileId, String fileType) {
        boolean ret = goodsFileService.deleteFile(fileId, fileType);
        return JsonResponseUtil.success();
    }

    /**
     * 获取文件列表
     * @param fileId
     * @param fileId
     * @return
     */
    @RequestMapping("goodsFile/getFileList")
    @ResponseBody
    public JSONObject getFileList( HttpServletRequest request, String fileId) {
        Long userId = getUserId(request.getSession());
        List<GoodsFileVO> files = goodsFileService.selFilesByFileId(fileId, userId.toString());
        GoodsFileVO file = files.get(0);
        JSONObject obj= JsonResponseUtil.success();
        obj.element("fileId", file.getFileId());
        obj.element("fileName", file.getFilename());
        obj.element("fileList", files.subList(1, files.size()));
        return obj;
    }

    /**
     * 获取用户登录信息
     */
    @RequestMapping("goodsFile/jsonislogin")
    @ResponseBody
    public JSONObject jsonislogin(HttpServletRequest request) {
        PersonalSession ps = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String userNick = "";
        if (ps != null) {
            userNick =  ps.getUserNick();
        }
        JSONObject obj= JsonResponseUtil.success();
        obj.element("userNick",userNick);
        return obj;
    }

    private Long getUserId(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getUserId();
    }

}
