package com.shigu.main4;

import com.shigu.main4.test.item.HtmlImgsLazyLoad;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by wxc on 2017/3/24.
 *
 * 图片标签lazy化。
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class HtmlLazyTest {

    @Test
    public void testRevers() {
        String source = "<img src=\"https://img.alicdn.com/bao/uploaded/i2/2987681715/TB2mmh.bG8lpuFjy0FpXXaGrpXa_!!2987681715.jpg_220x220.jpg\" style=\"zoom: 1;\">";
        String reverse = HtmlImgsLazyLoad.lazying(source);
        System.out.println(reverse);
    }

    @Test
    public void testLazyHtml() throws IOException {
        URL url = new URL("http://hz.571xz.com/item.htm?id=9999817");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String tmp;
        while ((tmp = br.readLine()) != null) {
            sb.append(tmp);
            sb.append("\n");
        }
        br.close();
        System.out.println(HtmlImgsLazyLoad.replaceLazyLoad(sb.toString()));
    }
}
