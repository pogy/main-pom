package com.shigu.jd.img.actions;


import com.shigu.exceptions.CustomException;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.jd.img.bo.DownOtherBO;
import com.shigu.jd.img.vo.DownOtherVO;
import com.shigu.jd.tools.JdOssIO;
import com.shigu.jd.tools.RedisUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created By admin on 2017/12/22/13:30
 */
@Controller
@RequestMapping("detailImg")
public class DetailImgController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JdOssIO jdOssIO;


    /**
     * 上传详情图
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public void upload(@Valid DownOtherBO bo, BindingResult br, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if(!addIp(request.getRemoteAddr())){
                return;
            }
        } catch (Exception ignored) {
        }
        //先计算urlkey
        DownOtherVO dov=new DownOtherVO();
        try {
            if(br.hasErrors()){
                dov.setMsg(br.getAllErrors().get(0).getDefaultMessage());
            }else{//无错
                String url = jdOssIO.uploadFile(bo.getUrl());
                dov.setStatus(1);
                dov.setUrl(url);
            }
        } catch (CustomException e) {
//            e.printStackTrace();
            dov.setMsg(e.getMessage());
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

    /**
     * 添加IP到redis
     * 如果有问题,返回false
     * @param ip
     * @return
     */
    private boolean addIp(final String ip){
        Boolean ok= (Boolean) redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            String countStr= RedisUtil.formatKey(redisConnection.get(RedisUtil.parseKey("count_"+ip)));
            Integer count;
            if (countStr == null) {
                count=0;
            }else{
                count=Integer.valueOf(countStr);
            }
            count++;
            redisConnection.setEx(RedisUtil.parseKey("count_"+ip),3600,RedisUtil.parseKey(count.toString()));
            Integer black= (Integer) RedisUtil.formatValue(redisConnection.get(RedisUtil.parseKey("black_"+ip)));
            return black==null&&count<10000;
        });
        //查一下,是否黑名单,如果是,直接返回
        return ok;
    }

}
