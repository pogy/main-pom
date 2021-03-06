package com.shigu.admin.actions;

import com.shigu.admin.bo.GgoodsUmCompleteBO;
import com.shigu.admin.bo.WorkerTakeGoodsBO;
import com.shigu.admin.services.GgoodsUnCompleteService;
import com.shigu.admin.vo.GgoodsUmCompleteVO;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.SelectDaifaGgoodsListBO;
import com.shigu.daifa.services.DaifaAllOrderIndexService;
import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.daifa.vo.DaifaAllocatedVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.DateUtil;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @类编号
 * @类名称：GgoodsUnComplete
 * @文件路径：com.shigu.admin.actions.GgoodsUnComplete
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/1 13:38
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class GgoodsUnCompleteAction {
    @Autowired
    GgoodsUnCompleteService ggoodsUnCompleteService;
    @Autowired
    DaifaAllocatedService daifaAllocatedService;
    @Autowired
    DaifaAllOrderIndexService daifaAllOrderIndexService;
    /**
     * ====================================================================================
     * @方法名： listByPage
     * @user gzy 2017/10/1 14:15
     * @功能：未拿货完成的列表
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/ggoodsUnListByPage")
    public String listByPage(GgoodsUmCompleteBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<GgoodsUmCompleteVO> listVO = ggoodsUnCompleteService.listByPage(bo);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("list", listVO);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);
        return "admin/ggoodsUnListByPage";
    }

    /**
     * ====================================================================================
     * @方法名： update
     * @user gzy 2017/10/1 14:14
     * @功能：未拿货完成
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/ggoodsUnComplete")
    @ResponseBody
    public JSONObject update(GgoodsUmCompleteBO bo) throws DaifaException {

        List<Long> list= ggoodsUnCompleteService.update (bo);
        if(list.size ()>0){
            return JsonResponseUtil.success();
        }else{
            return JsonResponseUtil.error ("修改错误！");
        }

    }

    @RequestMapping("admin/workerTakeGoods")
    public String workerTakeGoods(WorkerTakeGoodsBO bo, Model model){
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",0+","+10+","+1);
        model.addAttribute("childOrders",new ArrayList<>());
        model.addAttribute("workers",ggoodsUnCompleteService.getSellers().stream()
            .map(seller -> daifaAllOrderIndexService.getUserList(seller.getId()))
                .flatMap(Collection::stream).collect(Collectors.toList())
        );
        if(bo.getSearchWorkerId()==null){
            return "admin/workerTakeGoods";
        }
        if(StringUtil.isNull(bo.getStartTime())){
            bo.setStartTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        ShiguPager<DaifaAllocatedVO> pager=ggoodsUnCompleteService.workerTakeGoods(bo.getSearchWorkerId(),bo.getStartTime(),bo.getPage());
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("pageOption",pager.getTotalCount()+","+10+","+bo.getPage());
        return "admin/workerTakeGoods";
    }
}
