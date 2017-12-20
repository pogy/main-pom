package com.shigu.admin.actions;

import com.shigu.admin.bo.DaifaWorkerBO;
import com.shigu.admin.services.DaifaWorkerService;
import com.shigu.admin.vo.DaifaWorkerVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaWorkerAction.java
 *@文件路径：com.shigu.admin.actions.DaifaWorkerAction
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-10-26 01:54:17
 *@comments:
 *@since 1.0
 *=========================================================
 */
@Controller
public class DaifaWorkerAction{
	@Autowired
	DaifaWorkerService daifaWorkerService;
	

	/**
  * 
  *=========================================================
  *Mr Gzy自动生成
  *@方法名：
  *@功能： 
  *@return:
  *=========================================================
  */
	@RequestMapping(value={"admin/workerListByPage"},method = {RequestMethod.GET,RequestMethod.POST})
	public String listByPage(DaifaWorkerBO bo , Model model)throws ExecutionException, InterruptedException{
	
	//Session session = SecurityUtils.getSubject().getSession();
 	//  AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
 	   
   List<DaifaWorkerVO> list = daifaWorkerService.listByPage(bo);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("lists", list);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        //model.addAttribute("userName", "gzy");
        return "admin/workerListByPage";
   
	}
	
	/**
     * ====================================================================================
     * @ insert
     * @user gzy 2017/9/19 11:36
     * @
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
	@RequestMapping("admin/daifaWorkerAdd")
    @ResponseBody
    public JSONObject insert(DaifaWorkerBO bo) throws DaifaException {
	    bo.setDfGroupId (4L);
	    bo.setWorkerId (5L);
       int i=daifaWorkerService.insert (bo);
       if(i>0){
           return JsonResponseUtil.success();
       }else{
           return JsonResponseUtil.error ("");
       }

    }
	
	
	/**
     * ====================================================================================
     * @ update
     * @user gzy 2017/9/19 11:36
     * @
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/daifaWorkerEdit")
    @ResponseBody
    public JSONObject update(DaifaWorkerBO bo) throws DaifaException {
        bo.setDfGroupId (4L);
        bo.setWorkerId (5L);
        int i= daifaWorkerService.update (bo);
            if(i>0){
                return JsonResponseUtil.success();
            }else{
                return JsonResponseUtil.error ("");
            }

    }
}
