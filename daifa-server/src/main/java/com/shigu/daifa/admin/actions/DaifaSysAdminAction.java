package com.shigu.daifa.admin.actions;

import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DaifaSysAdminAction {
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    DaifaAllocatedService daifaAllocatedService;
    @RequestMapping("admin/index")
    public String index(){
        return "admin/index";
    }


    @RequestMapping("admin/adminRefund")
    @ResponseBody
    public JSONObject adminRefund(Long tid,String oids,Long refundId) throws DaifaException {
        String[] os=oids.split(",");
        List<Long> oidList=new ArrayList<>();
        for(String oid:os){
            oidList.add(new Long(oid));
        }
        takeGoodsIssueProcess.adminRefund(oidList,tid,refundId,null);
        return JsonResponseUtil.success();
    }
}
