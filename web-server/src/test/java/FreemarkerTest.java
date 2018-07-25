import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Licca on 17/4/19.
 */
public class FreemarkerTest {
    private Configuration cfg;      //模版配置对象

    public void init() throws Exception {
        //初始化FreeMarker配置
        //创建一个Configuration实例
        cfg = new Configuration();
        //设置FreeMarker的模版文件夹位置
        cfg.setDirectoryForTemplateLoading(new File("/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/web-server/src/main/webapp/WEB-INF/templates/shop_design/"));
    }

    public void process() throws Exception {
        //构造填充数据的Map
        Map map = new HashMap();
        map.put("user", "lavasoft");
        map.put("url", "http://www.baidu.com/");
        map.put("name", "百度");
        //创建模版对象
        Template t = cfg.getTemplate("banner.ftl");
        System.out.println("==============");
        System.out.println(t);
        System.out.println("==============");
        System.out.println(t.getName());

        System.out.println(t.getSourceName());

        //在模版上执行插值操作，并输出到制定的输出流中
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        t.process(map, new OutputStreamWriter(baos));
        InputStreamReader isr=new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()));
        BufferedReader br=new BufferedReader(isr);
        String str;
        while ((str=br.readLine())!=null){
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        FreemarkerTest hf = new FreemarkerTest();
        hf.init();
        hf.process();
    }
}
