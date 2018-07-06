package com.shigu.interceptors;

import com.openJar.beans.SnToken;
import com.shigu.component.core.ApiHttpServletRequest;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Id密度过滤器
 * Created by zhaohongbo on 17/4/17.
 */
public class IdDensityInterceptor extends DensityInterceptor {
    /**
     * ip白名单
     */
    private List<String> ipWhiteList;
    /**
     * token验签容错范围 单位秒
     */
    private Long signTime;

    public Long getSignTime() {
        return signTime;
    }

    public void setSignTime(Long signTime) {
        this.signTime = signTime;
    }

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
        String token = request.getParameter("_csrf");
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
        SnToken jdToken =  (SnToken) JSONObject.toBean(jsonObject,SnToken.class);
        //数据异常，返回
        if (jdToken.getUsername() == null || jdToken.getCreateTime() == null) {
            return false;
        }

        //token过期，返回
        //token时间差 1小时
        if(System.currentTimeMillis() - signTime * 10000 - jdToken.getCreateTime().getTime() > 0){
            return false;
        }
        Map<String,String[]> map=new HashMap<>(request.getParameterMap());
        request = new ApiHttpServletRequest(request,map);
        String[] jdUid={jdToken.getUsername()};
        map.put("snUsername", jdUid);
        primaryKey="id_"+jdToken.getUsername();
        return super.preHandle(request, response, handler);
    }

}
