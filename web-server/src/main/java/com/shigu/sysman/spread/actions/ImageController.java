package com.shigu.sysman.spread.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.tools.OssIO;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 图片上传
 * 
 * @author shigu_zjb
 * @date 2017/04/10 15:08
 *
 */
@Controller
public class ImageController extends BackBaseController {

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	OssIO ossIO;

	/**
	 * 文件上传 / 上传到阿里云OSS
	 * 
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/sysman/spread/aliyun_upload" , produces = "text/html;charset=utf-8")
	@ResponseBody
	public void imageUpload(HttpServletRequest request, String domId, HttpServletResponse response) throws IOException {
		logger.info("文件上传>>");
		ResponseBase base = new ResponseBase();

		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			Map.Entry<String, MultipartFile> entity = fileMap.entrySet().iterator().next();
			// 上传文件
			MultipartFile mf = entity.getValue();
			String fileName = mf.getOriginalFilename();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String years = sdf.format(new Date());
			SimpleDateFormat sdfmm = new SimpleDateFormat("MM");
			String mm = sdfmm.format(new Date());
			String filePath = "goat" + "/" + years + "/" + mm + "/";

//			String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

			String originalFilename = mf.getOriginalFilename();
			String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
			Random random = new Random();
			String name = random.nextInt(10000) + System.currentTimeMillis() + substring;

			String imgUrl=ossIO.uploadFile(mf.getBytes(),filePath+name);

			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("phPath", imgUrl);
			dataMap.put("domId",domId);
			base.setData(dataMap);
			base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			base.setStatus(SystemConStant.RESPONSE_STATUS_ERROR);
			base.setMsg(SystemConStant.RESPONSE_MSG_ERROR);
		}
		PrintWriter writer = response.getWriter();
		writer.print(JSON.toJSONString(base));
		writer.flush();
		writer.close();
	}
}