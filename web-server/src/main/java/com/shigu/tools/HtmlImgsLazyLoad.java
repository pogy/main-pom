package com.shigu.tools;

import com.shigu.main4.common.tools.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/3/24.
 *
 * 图片标签Lazy化
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class HtmlImgsLazyLoad {

    private static final Pattern IMG_TAG = Pattern.compile("<img[^>]*>");
    private static final String LOADING_IMG = "src=\"http://style.571xz.com/shop_item_temp/css/imgs/loading_s.gif\" data-original=";

    public static String replaceLazyLoad(String desc) {
        Matcher matcher = IMG_TAG.matcher(desc);
        while (matcher.find()) {
            String tag = matcher.group();
            if (!checkIsLazy(tag)) {
                desc = desc.replace(tag, lazying(tag));
            }
        }
        return desc;
    }

    public static String lazying(String imgTag) {
        StringBuilder sb = new StringBuilder();
        boolean hasClass = imgTag.contains(" class=");
        String[] split = imgTag.split("\\s+");
        if (split.length > 0) {
            sb.append(split[0]);
            if (!hasClass) {
                sb.append(" class=\"lazyload\"");
            }
            for (int i = 1; i < split.length; i++) {
                sb.append(" ");
                String s = split[i];
                String[] attr = s.split("=");
                String name = attr[0];
                String value = "";
                if (attr.length > 1){
                    value = attr[1];
                    if (!(value.startsWith("\"") || value.startsWith("'"))) {
                        value = "\"" + value;
                    }
                    if (!(value.endsWith("\"") || value.endsWith(">") || value.endsWith("'"))) {
                        value += "\"";
                    }
                }
                if (name.equals("src")) {
                    sb.append(LOADING_IMG);
                    sb.append(value);
                } else if (name.equals("class")) {
                    sb.append("class=\"lazyload ");
                    if (StringUtils.isNotEmpty(value)) {
                        sb.append(value.substring(1));
                    } else {
                        sb.append("\"");
                    }
                } else {
                    sb.append(s);
                }
            }
            String s = sb.toString();
            if (!(s.endsWith(">") || s.contains(">"))) {
                sb.append(">");
            }
        }
        return sb.toString();
    }

    public static boolean checkIsLazy(String tag) {
        return tag.contains("data-original=\"") || tag.contains("class=\"lazyload");
    }

    /**
     * 过滤HTML只返回内容中的 img 标签<br>直接将真实图片地址赋值到src<br>同时返回内容的img标签只包含 src data-original title 三种属性
     * @param source
     * @return
     */
    public static String replacelazyLoadImg(String source){
        if (StringUtil.isNull(source)){
            return null;
        }
        //只接受图片
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("img").addAttributes("img",  "src","data-original", "title").addProtocols("img", "src", "http", "https");
        String cleanSource = Jsoup.clean(source,whitelist);

        Document cleanOriginnal = Jsoup.parse(cleanSource);

        Elements imgs = cleanOriginnal.select("img");
        StringBuilder  result = new StringBuilder();
        for (Element img : imgs){
            String imgUrl = img.attr("data-original");
            if (imgUrl.toLowerCase().contains("alicdn.com") || imgUrl.toLowerCase().contains("taobaocdn.com")){
                img.attr("src",imgUrl+"_970x970q50s150.jpg_.webp");
            }else{
                img.attr("src",imgUrl+"_970x970.jpg");
            }
            result.append(img.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <img title=\"我是标题\" onclick=\"test()\" width=\"1000px\" class=\"lazyload\"  src=\"https://123.jpg\" data-original=\"https://img.alicdn.com/imgextra/i1/353297098/TB2sgKdbVXXXXaGXpXXXXXXXXXX-353297098.jpg\" />\n" +
                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2aFChbVXXXXX6XpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2aFChbVXXXXX6XpXXXXXXXXXX-353297098.jpg\" />\n" +
                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2nxSgbVXXXXXKXpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2nxSgbVXXXXXKXpXXXXXXXXXX-353297098.jpg\" />\n" +
                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2jqKmbVXXXXc5XXXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2jqKmbVXXXXc5XXXXXXXXXXXX-353297098.jpg\" />\n" +
                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB21uKhbVXXXXalXpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB21uKhbVXXXXalXpXXXXXXXXXX-353297098.jpg\" /\n" +
                " <scripts></scripts" +
                " </body>\n" +
                "</html>";
        System.out.println(replacelazyLoadImg(str));
    }

}
