package com.shigu.seller.vo;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.Map;

/**
 * 需要freemarker的页面
 * Created by zhaohongbo on 17/4/19.
 */
public class FreemarkerVO {
    protected Map<String,Object> data;

    protected FreeMarkerConfigurer cfg;      //模版配置对象

    private Template template;


    /**
     * 编译出结果
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public String getHtml() throws IOException, TemplateException {
        //在模版上执行插值操作，并输出到制定的输出流中
        Template t=getTemplate();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        t.process(data, new OutputStreamWriter(baos));
        InputStreamReader isr=new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()));
        BufferedReader br=new BufferedReader(isr);
        String str;
        StringBuffer sb=new StringBuffer();
        while ((str=br.readLine())!=null){
            sb.append(str+"\n");
        }
        return sb.toString();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public FreeMarkerConfigurer getCfg() {
        return cfg;
    }

    public void setCfg(FreeMarkerConfigurer cfg) {
        this.cfg = cfg;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
