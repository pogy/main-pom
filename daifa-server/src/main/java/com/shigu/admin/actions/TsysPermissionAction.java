package com.shigu.admin.actions;

import com.shigu.admin.bo.TsysPermissionBO;
import com.shigu.admin.services.TsysPermissionService;
import com.shigu.admin.vo.TsysPermissionVO;
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
 *@类名称：TsysPermissionAction.java
 *@文件路径：com.shigu.songhuoyi.actions.TsysPermissionAction
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-09-19 04:12:07
 *@comments:
 *@since 1.0
 *=========================================================
 */
@Controller
public class TsysPermissionAction{
	@Autowired
	TsysPermissionService tsysPermissionService;


	/**
	 *
	 *=========================================================
	 *Mr Gzy自动生成
	 *@方法名：
	 *@功能：
	 *@return:
	 *=========================================================
	 */
	@RequestMapping(value={"admin/tsysPermissionListByPage"},method = {RequestMethod.GET,RequestMethod.POST})
	public String listByPage(TsysPermissionBO bo , Model model)throws ExecutionException, InterruptedException{

		//Session session = SecurityUtils.getSubject().getSession();
		//  AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);

		List<TsysPermissionVO> list = tsysPermissionService.listByPage(bo);

		String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
		model.addAttribute("list", list);
		model.addAttribute("query", bo);
		model.addAttribute("pageOption", pageOption);
		//model.addAttribute("userName", "gzy");
		return "admin/tsysPermissionListByPage";

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
	@RequestMapping("admin/tsysPermissionAdd")
	@ResponseBody
	public JSONObject insert(TsysPermissionBO bo) throws DaifaException {
		int i=tsysPermissionService.insert (bo);
		if(i>0){
			return JsonResponseUtil.success();
		}else{
			return JsonResponseUtil.error ("数据插入错误！");
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
	@RequestMapping("admin/tsysPermissionEdit")
	@ResponseBody
	public JSONObject update(TsysPermissionBO bo) throws DaifaException {

		int i= tsysPermissionService.update (bo);
		if(i>0){
			return JsonResponseUtil.success();
		}else{
			return JsonResponseUtil.error ("数据更新错误！");
		}

	}
}
