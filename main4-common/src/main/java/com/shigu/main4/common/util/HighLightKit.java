package com.shigu.main4.common.util;

/**
 * Created by wxc on 2017/4/11.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class HighLightKit {

    private String preTag;
    private String postTag;

    private HighLightKit(String preTag, String postTag) {
        this.preTag = preTag;
        this.postTag = postTag;
    }

    public static HighLightKit getInstance(String preTag, String postTag) {
        return new HighLightKit(preTag, postTag);
    }

    public static HighLightKit getDefaultInstance() {
        return getInstance("<font style='color:red;'>", "</font>");
    }

    public String bright(String keyword, String target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (keyword.indexOf(c) != -1) {
                sb.append(preTag);
                sb.append(c);
                sb.append(postTag);
            } else {
                sb.append(c);
            }
        }
        return sb.toString().replace(postTag + preTag, "");
    }

//    public static void main(String[] args) {
//        //System.out.println(HighLightKit.getInstance("(", ")").bright("hao", "haasdha"));
//    }
}
