package com.shigu.tools;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 结果处理工具
 * Created by zhaohongbo on 17/3/22.
 */
public class ResultRetUtil {

    /**
     * 返回jsonp请求
     * @param callback
     * @param content
     * @param response
     */
    public static void returnJsonp(String callback,String content,HttpServletResponse response) throws IOException {
        response.setContentType("text/javascript");
        PrintWriter writer = response.getWriter();
        writer.print(callback+"("+content+")");
        writer.flush();
        writer.close();
    }
}
