package com.shigu.photo.process.impl;

import com.shigu.main4.tools.OssIO;
import com.shigu.photo.process.PhotoImgProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service("photoImgProcess")
public class PhotoImgProcessImpl implements PhotoImgProcess{
    private static final String URL_FLAG="/photo/temp/";
    private static final String URL_NORMAL="/photo/main/";
    @Autowired
    OssIO ossIO;
    @Override
    public Map<String, String> selPhotoToken(Long userId) throws UnsupportedEncodingException {
        return ossIO.createPostSignInfo("photo/temp/" + userId + "/");
    }

    @Override
    public String moveImg(String imgUrl) {
        String targetUrl=imgUrl;
        if (imgUrl.contains(URL_FLAG)) {
            String srcFilePath=imgUrl.substring(imgUrl.indexOf(URL_FLAG),imgUrl.length());
            String targetFilePath=srcFilePath.replace(URL_FLAG,URL_NORMAL);
            if(srcFilePath.startsWith("/")){
                srcFilePath=srcFilePath.substring(1,srcFilePath.length());
            }
            if(targetFilePath.startsWith("/")){
                targetFilePath=targetFilePath.substring(1,targetFilePath.length());
            }
            targetUrl=imgUrl.replace(URL_FLAG,URL_NORMAL);
            ossIO.moveFile(srcFilePath,targetFilePath);
        }
        return targetUrl;
    }
}
