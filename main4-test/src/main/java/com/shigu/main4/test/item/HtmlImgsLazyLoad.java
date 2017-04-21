package com.shigu.main4.test.item;

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
    private static final String LOADING_IMG = "http://style.571xz.com/shop_item_temp/css/imgs/loading_s.gif";

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
            sb.append(" ");

            for (int i = 1; i < split.length; i++) {
                String s = split[i];
                if (s.startsWith("src=")) {
                    sb.append("scr=\"");
                    sb.append(LOADING_IMG);
                    sb.append("\" ");
                    sb.append("data-original=\"");
                    sb.append(s.substring(5, s.length() - 1));
                    sb.append("\"");
                } else if (s.startsWith("class=")) {
                    sb.append("class=\"");
                    sb.append("lazyload ");
                    sb.append(s.substring(7, s.length() - 1));
                    sb.append("\"");
                } else {
                    sb.append(s);
                }
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static boolean checkIsLazy(String tag) {
        return tag.contains("data-original=\"") && tag.contains("class=\"lazyload\"");
    }
}
