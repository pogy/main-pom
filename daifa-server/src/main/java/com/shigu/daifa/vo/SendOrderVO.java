package com.shigu.daifa.vo;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class SendOrderVO extends ChildOrderVO{

    private String childServersFee;//子单服务费
    private String childRemark;//子单备注



    public String getChildServersFee() {
        return this.childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public String getChildRemark() {
        return this.childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }
}
