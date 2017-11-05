package com.shigu.tools;

import java.net.URLEncoder;
/**
 * @类编号
 * @类名称：SmsClientOverage
 * @文件路径：com.shigu.tools.SmsClientOverage
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/24 13:02
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SmsClientOverage {
    /**
     * <p>
     * <date>2012-03-01</date><br/>
     * <span>余额获取方法1--必须传入必填内容</span><br/>
     * <p>
     * 其一：发送方式，默认为POST<br/>
     * 其二：发送内容编码方式，默认为UTF-8
     * </p>
     * <br/>
     * </p>
     *
     * @param url
     *            ：必填--发送连接地址URL--比如>http://客户端地址:8888/sms.aspx
     * @param userid
     *            ：必填--用户ID，为数字
     * @param account
     *            ：必填--用户帐号
     * @param password
     *            ：必填--用户密码
     * @return 返回余额查询字符串
     */
    public static String queryOverage(String url, String userid,
                                      String account, String password) {

        try {
            StringBuffer sendParam = new StringBuffer();
            sendParam.append("action=overage");
            sendParam.append("&userid=").append(userid);
            sendParam.append("&account=").append(
                    URLEncoder.encode(account, "UTF-8"));
            sendParam.append("&password=").append(
                    URLEncoder.encode(password, "UTF-8"));

            return SmsClientAccessTool.getInstance().doAccessHTTPPost(url,
                                                                      sendParam.toString(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "未发送，异常-->" + e.getMessage();
        }
    }
}
