package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.DaifaStockBO;
import com.shigu.daifa.services.DaifaStockService;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class DaifaStockAction {
    @Autowired
    DaifaStockService daifaStockService;

    /**
     * 商品入库
     * @param model
     * @return
     */
    @RequestMapping("daifa/goodsPutInStorage")
    public String goodsPutInStorage(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<InOutDaifaStockVO> list = daifaStockService.goodsStorage(auth.getDaifaWorkerId(),false);
        model.addAttribute("childOrders",list);
        model.addAttribute("putInStorageNum",list.size());
        WorkerOutCountVO v=daifaStockService.goodsPutInStorageCount(auth.getDaifaWorkerId());
        model.addAttribute("outBoundAllNum",v.getNum());
        model.addAttribute("outBoundAllMoney",v.getPrice());
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","goodsPutInStorage.htm");//前台所要的左边菜单
        return "daifa/goodsPutInStorage";
    }

    /**
     * 入库条码的子单数据
     * @param barCode
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/putInBarCodeForChildOrderData")
    @ResponseBody
    public JSONObject putInBarCodeForChildOrderData(String barCode) throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        InOutDaifaStockVO vo=daifaStockService.barCodeForChildOrderData(barCode,auth.getDaifaWorkerId(),false);
        return JsonResponseUtil.success().element("childOrderItem",vo);
    }

    /**
     * 确认入库
     * @return
     */
    @RequestMapping("daifa/submitPutInInventory")
    @ResponseBody
    public JSONObject submitPutInInventory() throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaStockService.submitPutInInventory(auth.getDaifaWorkerId());
        return JsonResponseUtil.success();
    }

    /**
     * 重新扫描入库
     * @return
     */
    @RequestMapping("daifa/afreshPutInInventory")
    @ResponseBody
    public JSONObject afreshPutInInventory(){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaStockService.afreshPutInInventory(auth.getDaifaWorkerId(),false);
        return JsonResponseUtil.success();
    }

    /**
     * 全部出库商品退货成功
     * @return
     */
    @RequestMapping("daifa/refundAllOutBoundGoods")
    @ResponseBody
    public JSONObject refundAllOutBoundGoods(){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaStockService.refundAllOutBoundGoods(auth.getDaifaWorkerId());
        return JsonResponseUtil.success();
    }













    /**
     * 出库列表
     * @param model
     * @return
     */
    @RequestMapping("daifa/goodsOutbound")
    public String goodsOutbound(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<InOutDaifaStockVO> list = daifaStockService.goodsStorage(auth.getDaifaWorkerId(),true);
        model.addAttribute("childOrders",list);
        WorkerOutCountVO v=daifaStockService.goodsOutboundCount(auth.getDaifaWorkerId());
        model.addAttribute("outBoundChildOrderNum",v.getNum());
        model.addAttribute("outBoundChildOrderGoodsMoney",v.getPrice());
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","goodsOutbound.htm");//前台所要的左边菜单
        return "daifa/goodsOutbound";
    }

    /**
     * 扫描出库
     * @param barCode
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/outBoundBarCodeForChildOrderData")
    @ResponseBody
    public JSONObject outBoundBarCodeForChildOrderData(String barCode) throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        InOutDaifaStockVO vo=daifaStockService.barCodeForChildOrderData(barCode,auth.getDaifaWorkerId(),true);
        WorkerOutCountVO v=daifaStockService.goodsOutboundCount(auth.getDaifaWorkerId());
        return JsonResponseUtil.success().element("childOrderItem",vo)
                .element("outBoundChildOrderNum",v.getNum())
                .element("outBoundChildOrderGoodsMoney",v.getPrice());
    }

    /**
     * 确认出库
     * @return
     */
    @RequestMapping("daifa/submitOutBound")
    @ResponseBody
    public JSONObject submitOutBound() throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<ExcelUrlVO> vos=daifaStockService.submitOutBound(auth.getDaifaWorkerId(),auth.getUserName());
        return JsonResponseUtil.success().element("excelList",vos);
    }

    @RequestMapping("daifa/outboundBatches")
    @ResponseBody
    public JSONObject outboundBatches(){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<ExcelUrlVO> vos=daifaStockService.outboundBatches(auth.getDaifaWorkerId(),auth.getUserName());
        return JsonResponseUtil.success().element("excelList",vos);
    }


    /**
     * 重新扫描出库
     * @return
     */
    @RequestMapping("daifa/afreshOutBound")
    @ResponseBody
    public JSONObject afreshOutBound(){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaStockService.afreshPutInInventory(auth.getDaifaWorkerId(),true);
        return JsonResponseUtil.success();
    }

    @RequestMapping("daifa/downWorkerOutStockExcel/{worker}_{pi}")
    public void downWorkerOutStockExcel(HttpServletResponse response, @PathVariable String pi){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaStockService.toExcel(response,pi,auth.getDaifaWorkerId(),auth.getUserName());
    }


    /**
     * 全部库存
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/allInventory")
    public String allInventory(DaifaStockBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        ShiguPager<DaifaStockVO> pager= daifaStockService.allInventory(bo,auth.getDaifaSellerId());
        InventoryVO v=daifaStockService.selInventory(auth.getDaifaSellerId());
        model.addAttribute("inventory",v);
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","allInventory.htm");//前台所要的左边菜单
        return "daifa/allInventory";
    }

    @RequestMapping("daifa/putInStorageSearch")
    public String putInStorageSearch(DaifaStockBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        String d=DateUtil.dateToString(new Date(),DateUtil.patternA);
        if(bo.getStartTime()==null){
            bo.setStartTime(d);
        }
        if(bo.getEndTime()==null){
            bo.setEndTime(d);
        }
        StorageSearchVO vo= daifaStockService.storageSearch(bo,auth.getDaifaSellerId(),1);
        model.addAttribute("childOrders",vo.getPager().getContent());
        model.addAttribute("pageOption",vo.getPager().selPageOption(10));
        model.addAttribute("allChildOrderGoodsMoney",vo.getPrice());
        model.addAttribute("allChildOrderNum",vo.getNum());
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","putInStorageSearch.htm");//前台所要的左边菜单
        return "daifa/putInStorageSearch";
    }
    @RequestMapping("daifa/outboundSearch")
    public String outboundSearch(DaifaStockBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        String d=DateUtil.dateToString(new Date(),DateUtil.patternA);
        if(bo.getStartTime()==null){
            bo.setStartTime(d);
        }
        if(bo.getEndTime()==null){
            bo.setEndTime(d);
        }
        StorageSearchVO vo= daifaStockService.storageSearch(bo,auth.getDaifaSellerId(),2);
        model.addAttribute("childOrders",vo.getPager().getContent());
        model.addAttribute("pageOption",vo.getPager().selPageOption(10));
        model.addAttribute("allChildOrderGoodsMoney",vo.getPrice());
        model.addAttribute("allChildOrderNum",vo.getNum());
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","outboundSearch.htm");//前台所要的左边菜单
        return "daifa/outboundSearch";
    }
}
