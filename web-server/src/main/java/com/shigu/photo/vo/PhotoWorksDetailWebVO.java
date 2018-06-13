package com.shigu.photo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 路径: com.shigu.photo.vo.PhotoWorksDetailWebVO
 * 工程: main-pom
 * 时间: 18-4-26 下午2:08
 * 创建人: wanghaoxiang
 * 描述: 作品详情页展示作品信息
 */
public class PhotoWorksDetailWebVO implements Serializable {

    //作品标题
    private String title;

    //作品描述
    private String desc;

    //作品封面图片链接
    private String coverImgSrc;

    //价格
    private String price;

    //拍摄风格 例：店主 无头 旅拍 港仔风 港风
    private String style;

    //发布时间
    private String publishedTime;

    //点赞数
    private Integer thumbUpCount;

    //图片列表
    private List<String> imgList;

    //是否允许右键保存 0允许，1禁止
    private Integer saveType;

    //用户是否已点赞 true是 false否
    private Boolean userThumbUpIs;

    //作者userId
    private Long authorId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCoverImgSrc() {
        return coverImgSrc;
    }

    public void setCoverImgSrc(String coverImgSrc) {
        this.coverImgSrc = coverImgSrc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Integer getThumbUpCount() {
        return thumbUpCount;
    }

    public void setThumbUpCount(Integer thumbUpCount) {
        this.thumbUpCount = thumbUpCount;
    }

    public List<String> getImgList() {
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }

    public Boolean getUserThumbUpIs() {
        return userThumbUpIs;
    }

    public void setUserThumbUpIs(Boolean userThumbUpIs) {
        this.userThumbUpIs = userThumbUpIs;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
