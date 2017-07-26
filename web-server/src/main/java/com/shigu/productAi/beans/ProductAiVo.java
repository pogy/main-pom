package com.shigu.productAi.beans;

/**
 * Created by pc on 2017-07-12.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ProductAiVo {
    private String requestId; //本次请求id
    private String imageSetId;//添加的的数据集id
    private String imageSetName;//添加的数据集名称

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getImageSetId() {
        return imageSetId;
    }

    public void setImageSetId(String imageSetId) {
        this.imageSetId = imageSetId;
    }

    public String getImageSetName() {
        return imageSetName;
    }

    public void setImageSetName(String imageSetName) {
        this.imageSetName = imageSetName;
    }
}
