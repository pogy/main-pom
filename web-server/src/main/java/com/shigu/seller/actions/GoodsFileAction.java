package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.main4.common.exceptions.JsonErrException;
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

    @RequestMapping("seller/getAccessInfo")
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
    @RequestMapping("seller/readGlGoodsJson")
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
    @RequestMapping("seller/selectById")
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
    @RequestMapping("seller/glGoodsJson")
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
    @RequestMapping("seller/cacelGlJson")
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
    @RequestMapping("seller/renameFile")
    @ResponseBody
    public JSONObject renameFile(String fileId, String fileType, String newName) {
        goodsFileService.rename(fileId, fileType, newName);
        return JsonResponseUtil.success();
    }

    /**
     * 移动文件
     * @param fileId
     * @param targetFolderId
     * @return
     */
    @RequestMapping("seller/moveFile")
    @ResponseBody
    public JSONObject moveFile(String fileId, String targetFolderId) {
        goodsFileService.moveFile(fileId, targetFolderId);
        return JsonResponseUtil.success();
    }


    /**
     * 删除文件
     * @param fileId
     * @param fileType
     * @return
     */
    @RequestMapping("seller/delFile")
    @ResponseBody
    public JSONObject delFile(String fileId, String fileType) {
        goodsFileService.deleteFile(fileId, fileType);
        return JsonResponseUtil.success();
    }
    /**
     * 创建文件
     * @return
     */
    @RequestMapping("seller/createFolder")
    @ResponseBody
    public JSONObject createFoler(HttpServletRequest request, String fileName) {
        Long userId = getUserId(request.getSession());
        String parentDir = goodsFileService.getHomeDir(userId.toString()) + "zip/";
        String fileId = goodsFileService.createDir(parentDir, fileName);

        JSONObject obj= JsonResponseUtil.success();
        obj.element("fileId",fileId);
        obj.element("fileName",fileName);
        obj.element("fileCreateTime", new Date().getTime());
        obj.element("fileSize", "0kb");
        obj.element("hasLinkGoods", false);
        obj.element("fileType", "folder");
        return obj;
    }

    /**
     * 删除文件
     * @param fileId
     * @param fileType
     * @return
     */
    @RequestMapping("seller/deleteFile")
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
    @RequestMapping("seller/getFileList")
    @ResponseBody
    public JSONObject getFileList( HttpServletRequest request, String fileId) {
        Long userId = getUserId(request.getSession());
        List<GoodsFileVO> files = goodsFileService.selFilesByFileId(fileId, userId.toString());
        JSONObject obj= JsonResponseUtil.success();
        if (files != null && 0 < files.size()) {
            GoodsFileVO file = files.get(0);
            if (file.getIsRoot()) {
                obj.element("fileId", "");
                obj.element("fileName", "");
                obj.element("isRoot", true);
            } else {
                obj.element("fileId", file.getFileId());
                obj.element("fileName", file.getFileName());
                obj.element("isRoot", false);
            }

            obj.element("fileList", files.subList(1, files.size()));
        } else {
            obj.element("fileId", "");
            obj.element("fileName", "");
            obj.element("fileList", "");
        }

        return obj;
    }

    /**
     * 获取图片空间容量信息

     * @return
     */
    @RequestMapping("seller/getSizeInfo")
    @ResponseBody
    public JSONObject getSizeInfo( HttpServletRequest request) {
        Long userId = getUserId(request.getSession());

        JSONObject obj= JsonResponseUtil.success();
        obj.element("totalSize", 1000);
        obj.element("useSize", goodsFileService.getSizeInfo("udf/" + userId.toString() + "/zip/"));
        return obj;
    }

    /**
     * 通知服务器创建文件成功并返回文件信息
     * @return
     */
    @RequestMapping("seller/noticeUploadFile")
    @ResponseBody
    public JSONObject noticeUploadFile(HttpServletRequest request, String fileName, String targetFolderId) throws JsonErrException {
        Long userId = getUserId(request.getSession());

        JSONObject obj= JsonResponseUtil.success();
        String dir = goodsFileService.getHomeDir(userId.toString()) + "temp/" + targetFolderId;
        List<GoodsFileVO> files = goodsFileService.selFilesByFileId(dir + fileName, userId.toString());
        if (0 < files.size()) {
            GoodsFileVO file = files.get(0);
            obj.element("fileId", file.getFileId());
            obj.element("fileType", "picBkg");
            obj.element("fileSize", String.valueOf(file.getFileSize()));
            obj.element("fileCreateTime", file.getFileCreateTime());
            obj.element("hasLinkGoods", false);
        } else {
            throw new JsonErrException("文件上传失败！");
        }

        return obj;


    }


    private Long getUserId(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getUserId();
    }
}
