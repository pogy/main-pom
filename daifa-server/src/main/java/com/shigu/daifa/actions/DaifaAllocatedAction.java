package com.shigu.daifa.actions;

import com.opentae.data.daifa.beans.DaifaWorker;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.PrintGoodsTagBO;
import com.shigu.daifa.bo.SelectDaifaGgoodsListBo;
import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.daifa.vo.DaifaAllocatedVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.daifa.vo.PrintGoodsTagVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DaifaAllocatedAction {
    @Autowired
    DaifaAllocatedService daifaAllocatedService;

    /**
     * 已分配列表
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/orderHasAllocation")
    public String selectDaifaGgoodsList(SelectDaifaGgoodsListBo bo, Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if (bo.getPage() == null) {
            bo.setPage(1);
        }
        ShiguPager<DaifaAllocatedVO> pager= daifaAllocatedService.selectDaifaGgoodsList(daifaUser.getDaifaWorkerId(), bo.getOrderId(), bo.getChildOrderId(),
                bo.getStartTime(), bo.getEndTime(), bo.getPage(), 10);
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+10+bo.getPage());
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("userIcon","");
        model.addAttribute("userName",daifaUser.getDaifaUserName());
        return "daifa/orderHasAllocation";
    }

    /**
     * 已拿或缺货
     * @param type
     * @param takeGoodsId
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/setIsGetGoodsJson")
    @ResponseBody
    public JSONObject setIsGetGoodsJson(Integer type,Long takeGoodsId) throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        daifaAllocatedService.takeGoods(daifaUser.getDaifaWorkerId(),takeGoodsId,type);
        return JsonResponseUtil.success();
    }

    /**
     * 代发人员列表
     * @return
     */
    @RequestMapping("daifa/getUserList")
    @ResponseBody
    public JSONObject workerList(){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long sellerId=daifaUser.getDaifaSellerId();
        List<DaifaWorkerVO> vos=daifaAllocatedService.selWorkerList(sellerId);
        JSONObject obj=JsonResponseUtil.success();
        obj.put("userList",vos);
        return obj;
    }

    /**
     * 打印全部商品标签接口
     * @param bo
     * @return
     */
    @RequestMapping("daifa/printGoodsTabJson")
    @ResponseBody
    public JSONObject printGoodsTabJson(PrintGoodsTagBO bo){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION)    ;
        Long sellerId=daifaUser.getDaifaSellerId();

        List<PrintGoodsTagVO> vos=daifaAllocatedService.printGoodsTab(sellerId,bo.getType()==1?null:bo.getIds());
        JSONObject obj=JsonResponseUtil.success();
        obj.put("tabList",vos);
        return obj;
    }
}
