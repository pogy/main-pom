package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created By admin on 2017/12/24/10:38
 */
public class JdImgInfo extends OpenBean implements Serializable{
    /**
     * 上传成功的图片id
     */
    private String pictureId ;
    /**
     *上传成功的图片url
     * @return
     */
    private String pictureUrl;

    public String selImgUrl(){
        if(pictureUrl==null){
            return null;
        }
        StringBuilder str= new StringBuilder("jfs/");
        String[] strs=pictureUrl.split(str.toString());
        for(int i=0;i<strs.length;i++){
            if(i==0){
                continue;
            }
            str.append(strs[i]);
            if(i!=strs.length-1){
                str.append("jfs/");
            }
        }
        return str.toString();
    }


    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
