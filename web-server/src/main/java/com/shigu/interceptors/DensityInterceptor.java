package com.shigu.interceptors;

import com.shigu.interceptors.vo.DensityVO;
import com.shigu.main4.tools.RedisIO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密度拦截器
 * Created by zhaohongbo on 17/4/18.
 */
public class DensityInterceptor implements HandlerInterceptor {

    /**
     * 最小间隔毫秒数
     */
    private Integer minMillionSecond;
    /**
     * 起步作用次数
     */
    private Integer startNum;

    /**
     * redisIO
     */
    private RedisIO redisIO;

    /**
     * live时间,秒
     */
    private Integer refuseSecond;
    /**
     * 公key
     */
    private String key = "_density_";
    /**
     * 私key
     */
    protected String primaryKey;

    /**
     * 如果有小于最小间隔时间的,返回true
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DensityVO dv = redisIO.get(key + primaryKey, DensityVO.class);
        if (dv == null) {//之前没来过
            redisIO.putTemp(key + primaryKey, new DensityVO(), refuseSecond);
            return true;
        }
        if(new Date().getTime() - dv.getLastTime().getTime() < minMillionSecond){//时限内,+1
            dv.getNumber().addAndGet(1);
        }else{//时限外,清为1
            dv.setNumber(new AtomicInteger(1));
            dv.setLastTime(new Date());
        }
        int number = dv.getNumber().get();
        if (number > startNum) {
            //有问题,屏蔽
            errorResponse(request,response);
            return false;
        } else {
            redisIO.putTemp(key + primaryKey, dv, refuseSecond);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * 错误显示方式
     * @param request
     * @return
     */
    public void errorResponse(HttpServletRequest request,HttpServletResponse response){
        String uri=request.getRequestURI();
        response.setCharacterEncoding("UTF-8");
        String jsonString;
        if(uri!=null&&uri.endsWith(".json")){
            jsonString="{\"result\":\"error\",\"msg\":\"访问过于频繁,请休息一下\"}";
            if (request.getParameter("callback") != null) {
                response.setContentType("application/x-javascript");//jsonp异常响应处理
                jsonString = request.getParameter("callback") + "(" + jsonString + ");";
            } else {
                response.setContentType("application/json");//修复post异常信息未被解析为json
            }
        }else{
            jsonString="访问过于频繁,请休息一下";
        }
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.print(jsonString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getMinMillionSecond() {
        return minMillionSecond;
    }

    public void setMinMillionSecond(Integer minMillionSecond) {
        this.minMillionSecond = minMillionSecond;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public RedisIO getRedisIO() {
        return redisIO;
    }

    public void setRedisIO(RedisIO redisIO) {
        this.redisIO = redisIO;
    }

    public Integer getRefuseSecond() {
        return refuseSecond;
    }

    public void setRefuseSecond(Integer refuseSecond) {
        this.refuseSecond = refuseSecond;
    }


}
