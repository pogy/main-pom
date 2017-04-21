package com.opentae.data.mall.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

public class TaobaoPropimg implements Serializable {
    @Transient
    private static final long serialVersionUID = 2883979091849976856L;
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long tbPiId;
    private Long numIid;
    private Long id;
    private String url;
    private String properties;
    private Long position;
    private Date createTime;
    private String remark5;
    private String remark4;
    private String remark3;
    private String remark1;
    private String remark2;

    public TaobaoPropimg() {
    }

    public Long getTbPiId() {
        return this.tbPiId;
    }

    public void setTbPiId(Long tbPiId) {
        this.tbPiId = tbPiId;
    }

    public Long getNumIid() {
        return this.numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProperties() {
        return this.properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Long getPosition() {
        return this.position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark5() {
        return this.remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark4() {
        return this.remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark3() {
        return this.remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark1() {
        return this.remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else {
            TaobaoPropimg tp = (TaobaoPropimg)obj;

            try {
                return tp.getNumIid().equals(this.getNumIid()) && tp.getUrl().equals(this.getUrl()) && tp.getProperties().equals(this.getProperties());
            } catch (Exception var4) {
                return false;
            }
        }
    }
}
