package com.opentae.data.mall.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class OrderInfos extends ItemOrder {

    private List<SubOrderInfos> subOrderInfos;
    private List<ItemOrderService> itemOrderServices;
    private List<ItemOrderPackage> itemOrderPackages;
    private ItemOrderLogistics itemOrderLogistics;

    public List<SubOrderInfos> getSubOrderInfos() {
        return subOrderInfos;
    }

    public void setSubOrderInfos(List<SubOrderInfos> subOrderInfos) {
        this.subOrderInfos = subOrderInfos;
    }

    public List<ItemOrderService> getItemOrderServices() {
        return itemOrderServices;
    }

    public void setItemOrderServices(List<ItemOrderService> itemOrderServices) {
        this.itemOrderServices = itemOrderServices;
    }

    public List<ItemOrderPackage> getItemOrderPackages() {
        return itemOrderPackages;
    }

    public void setItemOrderPackages(List<ItemOrderPackage> itemOrderPackages) {
        this.itemOrderPackages = itemOrderPackages;
    }

    public ItemOrderLogistics getItemOrderLogistics() {
        return itemOrderLogistics;
    }

    public void setItemOrderLogistics(ItemOrderLogistics itemOrderLogistics) {
        this.itemOrderLogistics = itemOrderLogistics;
    }
}
