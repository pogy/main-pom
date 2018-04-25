package com.shigu.photo.process;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface PhotoImgProcess {

    /**
     * 摄影中心获取图片上传临时token
     * @param userId
     * @return
     */
    Map<String, String> selPhotoToken(Long userId) throws UnsupportedEncodingException;

    /**
     * 将临时文件移动到正式路径
     * @param imgUrl
     * @return
     */
    String moveImg(String imgUrl);
}
