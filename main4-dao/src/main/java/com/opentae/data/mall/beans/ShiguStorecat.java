package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wxc on 2017/2/20.
 * 淘宝店主自定义类目
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguStorecat implements Serializable {

    private static final long serialVersionUID = -8942275348549327105L;

    /** 自定义类目ID */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long scid;

    /** 自定义类目淘宝ID */
    private String taobaoScid;

    /** 类目名 */
    private String scName;

    /** 自定义父类目淘宝ID */
    private String parentTaobaoScid;

    /** 父类目ID */
    private Long parentScid;

    /** 父类目 */
    private String parentScName;

    /** 是否是顶级类目 1:is ; 0: not */
    private Integer isParent;

    /** 店铺ID */
    private Long storeId;

    /**
     * 备用 1-15
     */
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;

    /** 创建 （Do Not Use） */
    private Date created;

    /** ?? （Do Not Use） */
    private Date modified;

    /** ?? */
    private String picUrl;

    /** ??类型 */
    private String type;

    /** 排序序号 */
    private Integer sortOrder;

    /** 最后修改时间 */
    private Date lastModifyTime;

    public Long getScid() {
        return scid;
    }

    public void setScid(Long scid) {
        this.scid = scid;
    }

    public String getTaobaoScid() {
        return taobaoScid;
    }

    public void setTaobaoScid(String taobaoScid) {
        this.taobaoScid = taobaoScid;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getParentTaobaoScid() {
        return parentTaobaoScid;
    }

    public void setParentTaobaoScid(String parentTaobaoScid) {
        this.parentTaobaoScid = parentTaobaoScid;
    }

    public Long getParentScid() {
        return parentScid;
    }

    public void setParentScid(Long parentScid) {
        this.parentScid = parentScid;
    }

    public String getParentScName() {
        return parentScName;
    }

    public void setParentScName(String parentScName) {
        this.parentScName = parentScName;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
