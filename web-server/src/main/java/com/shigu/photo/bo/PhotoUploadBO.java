package com.shigu.photo.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PhotoUploadBO {
    @NotEmpty(message = "请选择封面图")
    private String picUtl;
    /**
     * 照片
     */
    @NotEmpty(message = "请上传图片")
    private List<String> images;
    /**
     * 标题
     */
    @Length(min=1,max=19,message = "标题为空或超过长度")
    private String title;
    /**
     * 描述
     */
    @Length(max=200,message = "描述信息不能超过200个字")
    private String content;
    /**
     * 风格ID集合
     */
    @Size(min=1,max=3,message = "请选择1-3个风格")
    private List<Long> styleId;
    /**
     * 类目集合
     */
    @NotNull(message = "请选择一个类目")
    private Long cid;
    /**
     * 0:可保存,1:禁止保存
     */
    @NotNull(message = "请选择是否禁止右键保存")
    private Integer forbidSave;
    /**
     * 0:私聊,1:定价
     */
    @NotNull(message = "请选择价格模式")
    private Integer havePrice;
    /**
     * 自定义价格,如果havePrice为1,则必传
     */
    private String priceString;

    /**
     * 获取 照片
     */
    public List<String> getImages() {
        return this.images;
    }

    /**
     * 设置 照片
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 描述
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置 描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 风格ID集合
     */
    public List<Long> getStyleId() {
        return this.styleId;
    }

    /**
     * 设置 风格ID集合
     */
    public void setStyleId(List<Long> styleId) {
        this.styleId = styleId;
    }

    /**
     * 获取 类目集合
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * 设置 类目集合
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * 获取 0:可保存,1:禁止保存
     */
    public Integer getForbidSave() {
        return this.forbidSave;
    }

    /**
     * 设置 0:可保存,1:禁止保存
     */
    public void setForbidSave(Integer forbidSave) {
        this.forbidSave = forbidSave;
    }

    /**
     * 获取 0:私聊,1:定价
     */
    public Integer getHavePrice() {
        return this.havePrice;
    }

    /**
     * 设置 0:私聊,1:定价
     */
    public void setHavePrice(Integer havePrice) {
        this.havePrice = havePrice;
    }

    /**
     * 获取 自定义价格,如果havePrice为1,则必传
     */
    public String getPriceString() {
        return this.priceString;
    }

    /**
     * 设置 自定义价格,如果havePrice为1,则必传
     */
    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    @NotEmpty(message = "请选择封面图")
    public String getPicUtl() {
        return this.picUtl;
    }

    @NotEmpty(message = "请选择封面图")
    public void setPicUtl(String picUtl) {
        this.picUtl = picUtl;
    }
}
