package com.shigu.jd.img.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

public class ImgThreadOverloadException extends Main4Exception{
    public ImgThreadOverloadException(){
        super("非法请求,图片搬家调用超载");
    }
}
