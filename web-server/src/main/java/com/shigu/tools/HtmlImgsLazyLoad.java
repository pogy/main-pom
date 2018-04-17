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
        Document d=Jsoup.parse(desc);
        Elements es=d.select("img[style*=height]");
        for(Element e:es){
            String style=e.attr("style");
            String[] styles=style.split(";");
            StringBuilder str= new StringBuilder();
            for(String s:styles){
                if(s.startsWith("height")||s.startsWith("margin-top")){
                    continue;
                }
                str.append(s).append(";");
            }
            e.attr("style",str.toString());
        }
        return d.body().html();
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

}
