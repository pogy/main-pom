package com.shigu.seller.vo;


/**
 * 广告类别VIEW
 *
 * @author shigu_zjb
 * @date 2017/04/14 14:26
 *
 */
public class SpreadTypeViewVo {

    private Long id;

    private String title;

    private int count;

    private String beginTime;

    private String endTime;

    private String price;

    /**
     * 1代表已经结束,0代表没结束
     */
    private int hdFinish;

    public int getHdFinish() {
        return hdFinish;
    }

    public void setHdFinish(int hdFinish) {
        this.hdFinish = hdFinish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
