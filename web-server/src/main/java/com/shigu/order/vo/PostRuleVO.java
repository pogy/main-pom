package com.shigu.order.vo;

/**
 * 发货价格规则
 * Created by bugzy on 2017/7/17 0017.
 */
public class PostRuleVO {

    /**
     * 快递英文名
     */
    private String name;

    /**
     * 快递中文
     */
    private String text;

    /**
     * 起收重量
     */
    private Double startWeight;

    /**
     * 起步价
     */
    private Double startPrice;

    /**
     * 加价单位重量
     */
    private Double addWeight;

    /**
     * 加价单价
     */
    private Double addPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(Double addWeight) {
        this.addWeight = addWeight;
    }

    public Double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Double addPrice) {
        this.addPrice = addPrice;
    }
}
