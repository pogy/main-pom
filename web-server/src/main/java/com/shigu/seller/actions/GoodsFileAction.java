package com.shigu.seller.actions;

import com.opentae.data.mall.beans.GoodsFile;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.bo.OnsaleItemBO;
import com.shigu.seller.services.GoodsFileService;

import com.shigu.seller.vo.GoodsFileSearchVO;
import com.shigu.seller.vo.GoodsFileVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.Arith;
import com.shigu.tools.JsonResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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

    @RequestMapping("seller/getAccessInfo")
    public String getPostSign( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> infoMap = goodsFileService.createPostSignInfo(logshop(request.getSession()).getShopId());
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

    @RequestMapping("seller/pictureSpace")
    public String pictureSpace(OnsaleItemBO bo, Model model) {
        model.addAttribute("get",bo);
        return "seller/pictureSpace";
    }

    /**
     * 获取所有商品
     * @return
     */
    @RequestMapping("seller/getGoodslist")
    @ResponseBody
    public JSONObject getGoodslist(Integer page,String keyword,HttpSession session){
        if (page == null) {
            page=1;
        }
        ShopSession shop=logshop(session);
        final int size=10;
        ShiguPager<GoodsFileSearchVO> pager=goodsFileService.searchGoodsForFile(shop.getShopId(),shop.getWebSite(),keyword
        ,page,size);
        return JsonResponseUtil.success().element("pageOption",pager.selPageOption(size))
                .element("goodslist", JSONArray.fromObject(pager.getContent()));
    }

    /**
     * 已关联的商品
     * @param page
     * @param fileId
     * @param session
     * @return
     */
    @RequestMapping("seller/getGlGoodslist")
    @ResponseBody
    public JSONObject getGlGoodslist(Integer page,String fileId,HttpSession session) throws JsonErrException {
        if(org.apache.commons.lang3.StringUtils.isEmpty(fileId)||!goodsFileService.checkFileId(fileId)){
            throw new JsonErrException("key信息异常");
        }
        if (page == null) {
            page=1;
        }
        ShopSession shop=logshop(session);
        final int size=10;
        ShiguPager<GoodsFileSearchVO> pager=goodsFileService.fileRelationFile(shop.getShopId(),fileId,shop.getWebSite(),page,size);
        return JsonResponseUtil.success().element("pageOption",pager.selPageOption(size))
                .element("goodslist", JSONArray.fromObject(pager.getContent()));
    }

    /**
     * 根据文件路径获取关联商品
     */
    @RequestMapping("seller/readGlGoodsJson")
    @ResponseBody
    public JSONObject selGoodsFileByFile(String fileKey,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileKey)) {
            throw new JsonErrException("key信息异常");
        }
        List<ItemShowBlock> goodsFilesList = goodsFileService.selGoodsFileByFile(logshop(session).getShopId(),fileKey);
        return JsonResponseUtil.success().element("goods", goodsFilesList);
    }

    /**
     * 增加关联关系
     * @param fileId
     * @param goodsIds
     * @return
     */
    @RequestMapping("seller/glGoodsJson")
    @ResponseBody
    public JSONObject saveGoodsFile(String fileId, String goodsIds,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }

        ShopSession shop=logshop(session);
        goodsFileService.saveGoodsFile(fileId,shop.getShopId(), goodsIds,shop.getWebSite());
        return JsonResponseUtil.success();
    }

    /**
     * 取消关联关系
     * @param goodsId
     * @return
     */
    @RequestMapping("seller/cacelGlJson")
    @ResponseBody
    public JSONObject delGoodsFile(Long goodsId,String fileId,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        ShopSession shop=logshop(session);
        goodsFileService.delGoodsfile(goodsId,shop.getShopId(),fileId,shop.getWebSite());
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
    public JSONObject renameFile(String fileId, String fileType, String newName,HttpSession session) throws JsonErrException  {
        if (!goodsFileService.checkFileId(fileId) || !goodsFileService.checkFileId(newName)) {
            throw new JsonErrException("key信息异常");
        }
        goodsFileService.rename(logshop(session).getShopId(),fileId, fileType, newName);

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
    public JSONObject moveFile(String fileId, String targetFolderId,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        goodsFileService.moveFile(logshop(session).getShopId(),fileId, targetFolderId);
        return JsonResponseUtil.success();
    }


    /**
     * 创建文件
     * @return
     */
    @RequestMapping("seller/createFolder")
    @ResponseBody
    public JSONObject createFoler(String fileName,HttpSession session) throws JsonErrException {
        String fileId = goodsFileService.createDir(logshop(session).getShopId(), fileName);
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        JSONObject obj= JsonResponseUtil.success();
        obj.element("fileId",fileId);
        obj.element("fileName",fileName);
        obj.element("fileCreateTime", new Date().getTime());
        obj.element("fileSize", "0");
        obj.element("unit","kb");
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
    public JSONObject deleteFile(String fileId, String fileType,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        if(goodsFileService.deleteFile(logshop(session).getShopId(),fileId, fileType)){
            return JsonResponseUtil.success();
        }
        throw new JsonErrException("删除文件失败");
    }

    /**
     * 获取文件列表
     * @param fileId
     * @param fileId
     * @return
     */
    @RequestMapping("seller/getFileList")
    @ResponseBody
    public JSONObject getFileList(String fileId,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        List<GoodsFileVO> files = goodsFileService.selFilesByFileId(logshop(session).getShopId(),fileId);
        JSONObject obj= JsonResponseUtil.success();
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(fileId)&&fileId.contains("/")){
            obj.element("fileId", fileId);
            obj.element("fileName", fileId);
            obj.element("isRoot", false);
        }else{//根目录
            obj.element("fileId", "");
            obj.element("fileName", "");
            obj.element("isRoot", true);
        }
        obj.element("fileList", files);
        return obj;
    }

    /**
     * 获取图片空间容量信息

     * @return
     */
    @RequestMapping("seller/getSizeInfo")
    @ResponseBody
    public JSONObject getSizeInfo( HttpSession session) {
        JSONObject obj= JsonResponseUtil.success();
        Long shopId=logshop(session).getShopId();
        obj.element("totalSize", goodsFileService.shopDataSize(shopId)/1024);
        obj.element("useSize", goodsFileService.getSizeInfo(shopId));
        return obj;
    }

    /**
     * 通知服务器创建文件成功并返回文件信息
     * @return
     */
    @RequestMapping("seller/noticeUploadFile")
    @ResponseBody
    public JSONObject noticeUploadFile(String fileId,HttpSession session) throws JsonErrException {
        if (!goodsFileService.checkFileId(fileId)) {
            throw new JsonErrException("key信息异常");
        }
        GoodsFileVO vo=goodsFileService.uploadFile(logshop(session).getShopId(),fileId);
        return JSONObject.fromObject(vo).element("result","success");
    }

    /**
     * 下载图片中转
     * @return
     */
    @RequestMapping("downfilezip")
    public String downfilezip(String key,Long sid){
        return "redirect:"+goodsFileService.zipUrl(sid,key);
    }

    /**
     * 得到当前登陆的店铺
     * @param session
     * @return
     */
    private ShopSession logshop(HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }


}