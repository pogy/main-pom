package com.shigu.jd.img.actions;

import com.openJar.commons.MD5Attestation;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.img.UploadImgTask;
import com.shigu.jd.img.WorkerMan;
import com.shigu.jd.img.exceptions.ImgThreadOverloadException;
import com.shigu.jd.img.vo.DownOtherVO;
import com.shigu.jd.tools.DownImage;
import com.shigu.jd.tools.JdOssIO;
import com.shigu.main4.common.util.UUIDGenerator;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By admin on 2017/12/22/13:30
 */
@Controller
@RequestMapping("detailImg")
public class DetailImgController {

    @Autowired
    private JdOssIO jdOssIO;

    public static final String FOLDER = "upload";

    private WorkerMan workerMan = WorkerMan.getInstance();
    /**
     * 上传图片到京东oss
     * @return
     */
    @RequestMapping("uploadByUrl")
    @ResponseBody
    public void uploadByUrl(String url,Long jdUid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        DownOtherVO dov=new DownOtherVO();
        try {
            UploadImgTask task = new UploadImgTask();
            task.setFolder(FOLDER);
            task.setJdOssIO(jdOssIO);
            task.setJdUid(jdUid);
            task.setUrl(url);

            String imgUrl = workerMan.start(task);
            dov.setStatus(1);
            dov.setUrl(imgUrl);
        } catch (ImgThreadOverloadException e){
            dov.setStatus(0);
            dov.setMsg(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            dov.setStatus(0);
            dov.setMsg("上传失败");
        }
        response.setContentType("application/x-javascript");//jsonp异常响应处理
        String jsonString = request.getParameter("callback") + "(" + JSONObject.fromObject(dov) + ")";
        writeResponse(response.getWriter(),jsonString);
    }


    /**
     * 上传图片到京东oss
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public void upxzwimg(@RequestParam(value = "multimagefile1") MultipartFile multimagefile,Long jdUid,HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        DownOtherVO dov=new DownOtherVO();
        try {
            FileInputStream input = (FileInputStream)multimagefile.getInputStream();
            UploadImgTask task = new UploadImgTask();
            task.setFolder(FOLDER);
            task.setJdUid(jdUid);
            task.setJdOssIO(jdOssIO);
            task.setInput(input);

            String imgUrl = workerMan.start(task);
            dov.setStatus(1);
            dov.setUrl(imgUrl);
        } catch (ImgThreadOverloadException e){
            dov.setStatus(0);
            dov.setMsg(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            dov.setStatus(0);
            dov.setMsg("上传失败");
        }

        response.setContentType("application/x-javascript");//jsonp异常响应处理
        String jsonString = request.getParameter("callback") + "(" + JSONObject.fromObject(dov) + ")";
        writeResponse(response.getWriter(),jsonString);
    }

    private void writeResponse(PrintWriter writer, String result){
        writer.print(result);
        writer.flush();
        writer.close();
    }

}
