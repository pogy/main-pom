package com.shigu.tools;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 发送邮件的工具
 * Created by zhaohongbo on 17/3/14.
 */
public class EmailUtil {

    private String from;
    private String host;
    private String username;
    private String password;

    public EmailUtil(String from, String host, String username, String password) {
        this.from = from;
        this.host = host;
        this.username = username;
        this.password = password;
    }

    /**
     * 发送邮件
     * @param title
     * @param content
     * @param emailAddr
     * @return
     * @throws EmailException
     */
    public String send(String title, String content, String[] emailAddr) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setAuthenticator(new DefaultAuthenticator(from, password));
        if(emailAddr != null && emailAddr.length >= 1) {
            for(int aa = 0; aa < emailAddr.length; ++aa) {
                if(aa < 2) {
                    email.addTo(emailAddr[aa]);
                } else {
                    email.addBcc(emailAddr[aa]);
                }
            }
        }

        email.setFrom(from, username);
        email.setSubject(title);
        email.setCharset("UTF-8");
        email.setHtmlMsg("<html>" + content + "</html>");
        email.setTextMsg("Your email client does not support HTML messages");
        String var9 = email.send();
        return var9;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
