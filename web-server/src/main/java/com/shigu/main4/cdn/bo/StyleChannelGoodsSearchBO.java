package com.shigu.main4.cdn.bo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.bo.StyleChannelGoodsSearchBO
 * 工程:main-pom
 * 时间:18-1-26下午8:06
 * 创建人:wanghaoxiang
 * 描述：风格频道商品搜索
 */
public class StyleChannelGoodsSearchBO extends StyleChannelSearchBO implements Serializable {


    //pid
    private Long pid;
    //市场id
    private Long mid;
    //类目id
    private Long cid;
    //搜索类目名
    private String searchName;
    //关键词
    private String keyword;
    //排序类型
    private String sort;
    //对应时间内发布的商品，d为天数
    private Integer d;
    //筛选开始价格
    private Double sp;
    //筛选结束价格
    private Double ep;
    //筛选开始时间 数据格式：yy.mm.dd 例如 2014.04.12
    private String st;
    //筛选结束时间 数据格式：yy.mm.dd 例如 2014.04.12
    private String et;
    //分页查询
    private Integer page;
    //当值为1时，开启大图筛选
    private Integer bpic;
    //当值为1时，开启商品视频筛选
    private Integer goodsVideo;

    public Long getPid() {
        if (pid == null) {
            //没有传，默认拉男装的
            pid = 30L;
        }
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Double getSp() {
        return sp;
    }

    public void setSp(Double sp) {
        this.sp = sp;
    }

    public Double getEp() {
        return ep;
    }

    public void setEp(Double ep) {
        this.ep = ep;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public Integer getPage() {
        if (page == null) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getBpic() {
        return bpic;
    }

    public void setBpic(Integer bpic) {
        this.bpic = bpic;
    }

    public Integer getGoodsVideo() {
        return goodsVideo;
    }

    public void setGoodsVideo(Integer goodsVideo) {
        this.goodsVideo = goodsVideo;
    }
}
