package com.shigu.photo.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PhotoUploadBO {
    @NotEmpty(message = "请选择封面图")
    private String cover;
    /**
     * 照片
     */
    @NotEmpty(message = "请上传图片")
    private List<String> imgs;
    /**
     * 标题
     */
    @Length(min=1,max=19,message = "标题为空或超过长度")
    private String title;
    /**
     * 描述
     */
    @Length(max=200,message = "描述信息不能超过200个字")
    private String desc;
    /**
     * 风格ID集合
     */
    @Size(min=1,max=3,message = "请选择1-3个风格")
    private List<Long> styles;
    /**
     * 类目集合
     */
    @NotNull(message = "请选择一个类目")
    private Long cate;
    /**
     * 0:可保存,1:禁止保存
     */
    @NotNull(message = "请选择是否禁止右键保存")
    private Integer saveType;
    /**
     * 1:私聊
     */
    @NotNull(message = "请选择价格模式")
    private Integer price;


    private Long worksId;

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取 照片
     */
    public List<String> getImgs() {
        return this.imgs;
    }

    /**
     * 设置 照片
     */
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
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
    public String getDesc() {
        return this.desc;
    }

    /**
     * 设置 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取 风格ID集合
     */
    public List<Long> getStyles() {
        return this.styles;
    }

    /**
     * 设置 风格ID集合
     */
    public void setStyles(List<Long> styles) {
        this.styles = styles;
    }

    /**
     * 获取 类目集合
     */
    public Long getCate() {
        return this.cate;
    }

    /**
     * 设置 类目集合
     */
    public void setCate(Long cate) {
        this.cate = cate;
    }

    /**
     * 获取 0:可保存,1:禁止保存
     */
    public Integer getSaveType() {
        return this.saveType;
    }

    /**
     * 设置 0:可保存,1:禁止保存
     */
    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }

    /**
     * 获取 1:私聊
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     * 设置 1:私聊
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }
}
