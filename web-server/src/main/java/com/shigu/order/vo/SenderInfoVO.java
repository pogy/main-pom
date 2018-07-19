package com.shigu.order.vo;

/**
 * Created by bugzy on 2017/7/17 0017.
 */
public class SenderInfoVO {

    private String id;
    private String text;
    private String checked;

    public SenderInfoVO() {
    }

    public SenderInfoVO(String id, String text, String checked) {
        this.id = id;
        this.text = text;
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChecked() {
        return this.checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
