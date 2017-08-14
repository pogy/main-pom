package com.shigu.order.vo;

/**
 * Created by Administrator on 2017/7/14.
 */
public class ChildGoodsOrder {
    private Long id;
    private String imgsrc;
    private String title;
    private String goodsCode;
    private String price;
    private String color;
    private String size;
    private String num;
    private String  weight;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc( String imgsrc ) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode( String goodsCode ) {
        this.goodsCode = goodsCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice( String price ) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor( String color ) {
        this.color = color;
    }

    public String getNum() {
        return num;
    }

    public void setNum( String num ) {
        this.num = num;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight( String weight ) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize( String size ) {
        this.size = size;
    }
}
