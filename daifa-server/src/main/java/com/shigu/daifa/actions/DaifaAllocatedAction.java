package com.shigu.daifa.actions;

import com.opentae.data.daifa.beans.DaifaWorker;
import com.shigu.daifa.bo.SelectDaifaGgoodsListBo;
import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.daifa.vo.DaifaAllocatedVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
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
    @RequestMapping("admin/orderHasAllocation")
    public String selectDaifaGgoodsList(SelectDaifaGgoodsListBo bo, Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        DaifaWorker daifaUser = (DaifaWorker) session.getAttribute("");
        if (bo.getPage() != null) {
            bo.setPage(1);
        }
        ShiguPager<DaifaAllocatedVO> pager= daifaAllocatedService.selectDaifaGgoodsList(daifaUser.getDaifaWorkerId(), bo.getOrderId(), bo.getChildOrderId(),
                bo.getStartTime(), bo.getEndTime(), bo.getPage(), 10);
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+10+bo.getPage());
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("userIcon","");
        model.addAttribute("userName",daifaUser.getDaifaWorker());
        return "admin/orderHasAllocation";
    }

    /**
     * 已拿或缺货
     * @param type
     * @param takeGoodsId
     * @return
     * @throws DaifaException
     */
    @RequestMapping("admin/setIsGetGoodsJson")
    @ResponseBody
    public JSONObject setIsGetGoodsJson(Integer type,Long takeGoodsId) throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        DaifaWorker daifaUser = (DaifaWorker) session.getAttribute("");
        daifaAllocatedService.takeGoods(daifaUser.getDaifaWorkerId(),takeGoodsId,type);
        return JsonResponseUtil.success();
    }

    /**
     * 代发人员列表
     * @return
     */
    @RequestMapping("admin/getUserList")
    @ResponseBody
    public JSONObject workerList(){
        Session session = SecurityUtils.getSubject().getSession();
        DaifaWorker daifaUser = (DaifaWorker) session.getAttribute("");
        Long sellerId=daifaUser.getDaifaSellerId();
        List<DaifaWorkerVO> vos=daifaAllocatedService.selWorkerList(sellerId);
        JSONObject obj=JsonResponseUtil.success();
        obj.put("userList",vos);
        return obj;
    }



}
