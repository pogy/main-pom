package com.shigu.interceptors;

import com.openJar.beans.JdToken;
import com.utils.publics.Opt3Des;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Id密度过滤器
 * Created by zhaohongbo on 17/4/17.
 */
public class IdDensityInterceptor extends DensityInterceptor {
    /**
     * ip白名单
     */
    private List<String> ipWhiteList;

    public List<String> getIpWhiteList() {
        return ipWhiteList;
    }

    public void setIpWhiteList(List<String> ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip=request.getRemoteHost();
        if (ipWhiteList != null && ipWhiteList.contains(ip)) {
            return true;
        }
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            return false;
        }
        token = token.replaceAll(" ", "+");
        String data = Opt3Des.decryptPlainData(token);
        JSONObject jsonObject;
        //转换异常，返回
        try {
            jsonObject = JSONObject.fromObject(data);
        } catch (Exception e) {
            return false;
        }
        JdToken jdToken =  (JdToken)JSONObject.toBean(jsonObject,JdToken.class);
        //数据异常，返回
        if (jdToken.getId() == null || jdToken.getCreateTime() == null) {
            return false;
        }

        //token过期，返回
        //token时间差 1小时
        if(System.currentTimeMillis() - 60 * 60 * 10000 - jdToken.getCreateTime().getTime() > 0){
            return false;
        }

        primaryKey="id_"+jdToken.getId();
        return super.preHandle(request, response, handler);
    }

}
