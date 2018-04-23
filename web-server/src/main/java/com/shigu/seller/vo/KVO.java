package com.shigu.seller.vo;

/**
 * Created by wxc on 2016/12/28.
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class KVO {
    private String text;
    private String value;
    private Long pid;
    private Long vid;
    private  Boolean selected;
    private  Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return this.pid + ":" + this.vid;
    }
    public String getName() {
        return this.pid + ":" + this.vid;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }
}
