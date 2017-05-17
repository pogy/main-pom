package com.shigu.interceptors;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 商品访问记录密度过滤器
 * Created by zhaohongbo on 17/4/17.
 */
public class PvDensityInterceptor extends DensityInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip=request.getRemoteHost();
        String url = request.getParameter("url");
        if (StringUtils.isNotEmpty(url) && url.contains("/item.htm")) {
            Long itemId = null;
            String idmore = url.split("id=")[1];
            int ind;
            if ((ind = idmore.indexOf("&")) != -1) {
                idmore = idmore.substring(0, ind);
            }
            try {
                itemId = Long.valueOf(idmore);
            } catch (NumberFormatException ignored) {
            }
            if (itemId != null) {
                primaryKey="pv_item_" + itemId + "_" + ip;
                return super.preHandle(request, response, handler);
            }
        }
        return true;
    }

}
