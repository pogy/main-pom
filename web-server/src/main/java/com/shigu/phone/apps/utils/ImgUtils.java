package com.shigu.phone.apps.utils;

import com.shigu.phone.api.enums.ImgFormatEnum;
import org.springframework.util.StringUtils;

public class ImgUtils {
    public static String headUrl(String aliww){
        return "http://wwc.taobaocdn.com/avatar/getAvatar.do?userNick="+aliww+"&width=100&height=100&type=sns";
    }

    public static String formatImg(String imgstr, ImgFormatEnum eme){
        if(StringUtils.isEmpty(imgstr)){
            return imgstr;
        }
        if(imgstr.contains("taobaocdn")||imgstr.contains("alicdn")){
            return imgstr+eme.getTb();
        }else if(imgstr.contains("imgs.571xz.net")||imgstr.contains("oss-cn-")){
            return imgstr+eme.getOss();
        }else{
            return imgstr;
        }
    }


}
