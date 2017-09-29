package com.shigu.daifa.vo;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaCustomerDataSubVO extends ChildOrderVO{
    private String childServersFee;

    public String getChildServersFee() {
        return this.childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }
}
