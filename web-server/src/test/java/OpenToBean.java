import com.shigu.main4.common.util.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Date;

/**
 * 根据openApi生成bean
 */
public class OpenToBean {

    static String uri="E:/java/main-pom/main4-sdks/main4-app-sdk";

    public static void main(String[] args) throws IOException {
        Document d= Jsoup.connect("http://open.571xz.com/detail_detail.action?cid=78").get();
        Elements as=d.select(".api-list").get(0).select("a");
        for(Element a:as){
            try {
                create("http://open.571xz.com/"+a.attr("href"));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("http://open.571xz.com/"+a.attr("href"));
            }
        }
    }



    public static void create(String url) throws IOException {
        Document d = Jsoup.connect(url).get();
        String requestName = d.select(".open-bg").get(0).html().split(" ")[0].split("\\.")[4];
        String responseName = requestName.replace("Request", "Response");
        File reqFile = new File(uri+"/src/main/java/com/openJar/requests/app/" + requestName + ".java");
        File resFile = new File(uri+"/src/main/java/com/openJar/responses/app/" + responseName + ".java");
        req(d, reqFile, requestName, responseName);
        res(d, resFile, responseName);
    }

    private static void req(Document d, File reqFile, String requestName, String responseName) {
        StringBuilder imp = new StringBuilder("package com.openJar.requests.app;\n");
        imp.append("import com.openJar.enums.HostEnum;\n");
        imp.append("import com.openJar.requests.Request;\n");
        imp.append("import com.openJar.responses.app.").append(responseName).append(";\n");
        StringBuilder t = new StringBuilder();
        t.append("/**\n");
        t.append(" * 类名:").append(requestName).append("\n");
        t.append(" * 类路径:com.openJar.requests.app").append(requestName).append("\n");
        t.append(" * 创建者:自动生成\n");
        t.append(" * 创建时间:").append(DateUtil.dateToString(new Date(),DateUtil.patternA)).append("\n");
        t.append(" * 描述:").append(d.select(".title-intro_h").html().trim()).append("\n");
        t.append(" */\n");
        t.append("public class ").append(requestName).append(" extends Request<").append(responseName).append("> {\n");
        Element param = d.getElementById("content-api-param");
        Elements trs = param.select("tbody tr");
        StringBuilder t2 = new StringBuilder();
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            t.append("\t//").append(tds.get(5).html().trim()).append(tds.get(2).html().trim().equals("必须")?"\t必须":"").append("\n");
            if (tds.get(2).html().trim().equals("必须")) {
                if (!imp.toString().contains("import javax.validation.constraints.NotNull;")) {
                    imp.append("import javax.validation.constraints.NotNull;\n");
                }
                t.append("\t@NotNull(message = \"").append(tds.get(0).html().trim().replace("[]", "")).append(" is null\")\n");
            }
            if (tds.html().contains("Date") && !imp.toString().contains("import java.util.Date;")) {
                imp.append("import java.util.Date;\n");
            }
            if (tds.get(0).html().trim().contains("[]")) {
                String name = tds.get(0).html().trim().replace("[]", "");
                if (tds.get(1).html().trim().equals("Byte")) {
                    t.append("\tprivate byte[] ").append(name).append(";\n");
                    t2.append("\tpublic byte[] get").append(toUpperCase(name)).append("(){\n");
                    t2.append("\t\treturn ").append(name).append(";\n");
                    t2.append("\t}\n\n");
                    t2.append("\tpublic void set").append(toUpperCase(name)).append("(byte[] ").append(name).append("){\n");
                    t2.append("\t\tthis.").append(name).append("=").append(name).append(";\n");
                    t2.append("\t}\n\n");
                } else {
                    t.append("\tprivate List<").append(tds.get(1).html().trim()).append("> ").append(name).append(";\n");
                    t2.append("\tpublic List<").append(tds.get(1).html().trim()).append("> get").append(toUpperCase(name)).append("(){\n");
                    t2.append("\t\treturn ").append(name).append(";\n");
                    t2.append("\t}\n\n");
                    t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim())).append("(List<").append(tds.get(1).html().trim()).append("> ").append(name).append("){\n");
                    t2.append("\t\tthis.").append(name).append("=").append(name).append(";\n");
                    t2.append("\t}\n\n");
                }

            } else {
                t.append("\tprivate ").append(tds.get(1).html().trim()).append(" ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\tpublic ").append(tds.get(1).html().trim()).append(" get").append(toUpperCase(tds.get(0).html().trim())).append("(){\n");
                t2.append("\t\treturn ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
                t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim())).append("(").append(tds.get(1).html().trim()).append(" ").append(tds.get(0).html().trim()).append("){\n");
                t2.append("\t\tthis.").append(tds.get(0).html().trim()).append("=").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
                if(tds.get(0).html().trim().equals("token")){
                    t.append("\tprivate ").append("Long userId;\n");
                    t2.append("\tpublic ").append("Long getUserId(){\n");
                    t2.append("\t\treturn ").append("userId;\n");
                    t2.append("\t}\n\n");
                    t2.append("\tpublic void setUserId(Long userId){\n");
                    t2.append("\t\tthis.userId=userId;\n");
                    t2.append("\t}\n\n");
                }
            }
        }
        t2.append("\tpublic String testApiUrl(){\n");
        t2.append("\t\treturn HostEnum.TEST+\"").append(toLowerCase(requestName.replace("Request", ""))).append(".json\";\n");
        t2.append("\t}\n\n");
        t2.append("\tpublic String restApiUrl(){\n");
        t2.append("\t\treturn HostEnum.REST+\"").append(toLowerCase(requestName.replace("Request", ""))).append(".json\";\n");
        t2.append("\t}\n\n");
        t2.append("}");
        String body = imp.toString() + t + t2;
        print(reqFile, body);
    }

    private static void res(Document d, File resFile, String responseName) throws IOException {
        StringBuilder imp = new StringBuilder("package com.openJar.responses.app;\n");
        imp.append("import com.openJar.responses.Response;\n");
        if (d.getElementById("content-result").html().contains("[]")) {
            imp.append("import java.util.List;\n");
        }
        Element param = d.getElementById("content-result");
        Elements trs = param.select("tbody tr");
        StringBuilder t = new StringBuilder();
        t.append("/**\n");
        t.append(" * 类名:").append(responseName).append("\n");
        t.append(" * 类路径:com.openJar.responses.app").append(responseName).append("\n");
        t.append(" * 创建者:自动生成\n");
        t.append(" * 创建时间:").append(DateUtil.dateToString(new Date(),DateUtil.patternA)).append("\n");
        t.append(" * 描述:").append(d.select(".title-intro_h").html().trim()).append("\n");
        t.append(" */\n");
        t.append("public class ").append(responseName).append(" extends Response {\n");
        StringBuilder t2 = new StringBuilder();
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            t.append("\t//").append(tds.get(4).html().trim()).append(tds.get(2).html().trim().equals("必须")?"\t必须":"").append("\n");
            if (tds.html().contains("Date") && !imp.toString().contains("import java.util.Date;")) {
                imp.append("import java.util.Date;\n");
            }
            String beanName;
            if (tds.get(1).select("a").size() > 0) {
                beanName = createBean(tds.get(1).select("a").attr("href"));
                imp.append("import com.openJar.beans.app.").append(beanName).append(";\n");
            } else {
                beanName = tds.get(1).html().trim();
            }
            if (tds.get(0).html().trim().contains("[]")) {
                t.append("\tprivate List<").append(beanName).append("> ").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\tpublic List<").append(beanName).append("> get").append(toUpperCase(tds.get(0).html().trim().replace("[]", ""))).append("(){\n");
                t2.append("\t\treturn ").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\t}\n\n");
                t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim().replace("[]", ""))).append("(List<").append(beanName).append("> ").append(tds.get(0).html().trim().replace("[]", "")).append("){\n");
                t2.append("\t\tthis.").append(tds.get(0).html().trim().replace("[]", "")).append("=").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\t}\n\n");
            } else {
                t.append("\tprivate ").append(beanName).append(" ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\tpublic ").append(beanName).append(" get").append(toUpperCase(tds.get(0).html().trim())).append("(){\n");
                t2.append("\t\treturn ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
                t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim())).append("(").append(beanName).append(" ").append(tds.get(0).html().trim()).append("){\n");
                t2.append("\t\tthis.").append(tds.get(0).html().trim()).append("=").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
            }
        }
        t.append(t2);
        t.append("}");
        String body = imp.toString() + t;
        print(resFile, body);
    }

    private static String createBean(String url) throws IOException {
        Document d = Jsoup.connect("http://open.571xz.com/" + url).get();
        StringBuilder imp = new StringBuilder();
        imp.append("package com.openJar.beans.app;\n" + "\n" + "import com.openJar.utils.OpenBean;\n" + "import java.io.Serializable;\n");
        if (d.select(".api-table").html().contains("[]")) {
            imp.append("import java.util.List;\n");
        }
        StringBuilder t = new StringBuilder();
        t.append("/**\n");
        t.append(" * 类名:").append(d.select(".title").html().trim()).append("\n");
        t.append(" * 类路径:com.openJar.beans.app").append(d.select(".title").html().trim()).append("\n");
        t.append(" * 创建者:自动生成\n");
        t.append(" * 创建时间:").append(DateUtil.dateToString(new Date(),DateUtil.patternA)).append("\n");
        t.append(" * 描述:").append(d.select(".introduction").html().trim()).append("\n");
        t.append(" */\n");
        t.append("public class ").append(d.select(".title").html().trim()).append(" extends OpenBean implements Serializable {\n");
        Elements trs = d.select(".api-table tbody tr");

        StringBuilder t2 = new StringBuilder();
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            t.append("\t//").append(tds.get(4).html().trim()).append("\n");
            if (tds.html().contains("Date") && !imp.toString().contains("import java.util.Date;")) {
                imp.append("import java.util.Date;\n");
            }
            String beanName;
            if (tds.get(1).select("a").size() > 0) {
                if (!tds.get(1).select("a").attr("href").equals(url)) {
                    beanName = createBean(tds.get(1).select("a").attr("href"));
                } else {
                    beanName = d.select(".title").html().trim();
                }
            } else {
                beanName = tds.get(1).html().trim();
            }
            if (tds.get(0).html().trim().contains("[]")) {
                t.append("\tprivate List<").append(beanName).append("> ").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\tpublic List<").append(beanName).append("> get").append(toUpperCase(tds.get(0).html().trim().replace("[]", ""))).append("(){\n");
                t2.append("\t\treturn ").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\t}\n\n");
                t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim().replace("[]", ""))).append("(List<").append(beanName).append("> ").append(tds.get(0).html().trim().replace("[]", "")).append("){\n");
                t2.append("\t\tthis.").append(tds.get(0).html().trim().replace("[]", "")).append("=").append(tds.get(0).html().trim().replace("[]", "")).append(";\n");
                t2.append("\t}\n\n");
            } else {
                t.append("\tprivate ").append(beanName).append(" ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\tpublic ").append(beanName).append(" get").append(toUpperCase(tds.get(0).html().trim())).append("(){\n");
                t2.append("\t\treturn ").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
                t2.append("\tpublic void set").append(toUpperCase(tds.get(0).html().trim())).append("(").append(beanName).append(" ").append(tds.get(0).html().trim()).append("){\n");
                t2.append("\t\tthis.").append(tds.get(0).html().trim()).append("=").append(tds.get(0).html().trim()).append(";\n");
                t2.append("\t}\n\n");
            }
        }
        t.append(t2);
        t.append("}");
        print(new File(uri+"/src/main/java/com/openJar/beans/app/" + d.select(".title").html().trim() + ".java"), imp.toString() + t);
        return d.select(".title").html().trim();
    }


    private static String toUpperCase(String str) {
        String s1 = (str.charAt(0) + "").toUpperCase();
        return s1 + (str.substring(1, str.length()));
    }

    private static String toLowerCase(String str) {
        String s1 = (str.charAt(0) + "").toLowerCase();
        return s1 + (str.substring(1, str.length()));
    }

    private static void print(File f, String str) {
        try {
            OutputStream out = new FileOutputStream(f);
            BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
            rd.write(str);
            rd.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
