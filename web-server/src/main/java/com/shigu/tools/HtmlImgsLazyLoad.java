package com.shigu.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    private static final String LOADING="http://style.571xz.com/shop_item_temp/css/imgs/loading_s.gif";

    public static String replaceLazyLoad(String desc){
        Document d=Jsoup.parse(desc);
        Elements imgs=d.select("img");
        imgs.forEach(element -> {
            if(!element.hasClass("lazyload")){
                String src=element.attr("src");
                element.attr("data-original",src);
                element.attr("src",LOADING);
                element.addClass("lazyload");
            }
        });
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
}
