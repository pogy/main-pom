package com.shigu.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @类编号
 * @类名称：SmsClientAccessTool
 * @文件路径：com.shigu.tools.SmsClientAccessTool
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/24 12:59
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SmsClientAccessTool {

    private Logger logger = LoggerFactory.getLogger(SmsClientAccessTool.class);

    private static SmsClientAccessTool smsClientToolInstance;

    /**
     * 采用单列方式来访问操作
     *
     * @return
     */
    public static synchronized SmsClientAccessTool getInstance() {

        if (smsClientToolInstance == null) {
            smsClientToolInstance = new SmsClientAccessTool();
        }
        return smsClientToolInstance;
    }

    /**
     * <p>
     * POST方法
     * </p>
     *
     * @param sendUrl
     *            ：访问URL
     * @param sendParam
     *            ：参数串
     * @param backEncodType
     *            ：返回的编码
     * @return
     */
    public String doAccessHTTPPost(String sendUrl, String sendParam,
                                   String backEncodType) {

        StringBuffer receive = new StringBuffer();
        BufferedWriter wr = null;
        DataOutputStream dos = null;
        try {
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }

            URL url = new URL(sendUrl);
            HttpURLConnection URLConn = (HttpURLConnection) url
                    .openConnection();

            URLConn.setDoOutput(true);
            URLConn.setDoInput(true);
            ((HttpURLConnection) URLConn).setRequestMethod("POST");
            URLConn.setUseCaches(false);
            URLConn.setAllowUserInteraction(true);
            HttpURLConnection.setFollowRedirects(true);
            URLConn.setInstanceFollowRedirects(true);

            URLConn.setRequestProperty("Content-Type",
                                       "application/x-www-form-urlencoded;charset=UTF-8");
            URLConn.setRequestProperty("Content-Length", String
                    .valueOf(sendParam.getBytes().length));

            dos = new DataOutputStream(URLConn.getOutputStream());
            dos.writeBytes(sendParam);

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    URLConn.getInputStream(), backEncodType));
            String line;
            while ((line = rd.readLine()) != null) {
                receive.append(line).append("\r\n");
            }
            rd.close();
        } catch (java.io.IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException e) {
                    if (logger.isErrorEnabled()) {
                        logger.error("关闭流失败",e);
                    }
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    if (logger.isErrorEnabled()) {
                        logger.error("关闭流失败",e);
                    }
                }
            }
        }

        return receive.toString();
    }

    public String doAccessHTTPGet(String sendUrl, String backEncodType) {

        StringBuffer receive = new StringBuffer();
        BufferedReader in = null;
        try {
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }

            URL url = new URL(sendUrl);
            HttpURLConnection URLConn = (HttpURLConnection) url
                    .openConnection();

            URLConn.setDoInput(true);
            URLConn.setDoOutput(true);
            URLConn.connect();
            URLConn.getOutputStream().flush();
            in = new BufferedReader(new InputStreamReader(URLConn
                                                                  .getInputStream(), backEncodType));

            String line;
            while ((line = in.readLine()) != null) {
                receive.append(line).append("\r\n");
            }

        } catch (IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (java.io.IOException ex) {
                    if (logger.isErrorEnabled()) {
                        logger.error("关闭流失败",ex);
                    }
                }
            }
        }

        return receive.toString();
    }
}
