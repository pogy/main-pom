package com.shigu.main4.cdn.vo;

import com.shigu.main4.vo.CatPolymerization;

import java.util.List;

/**
 * 聚合类目数据重整合
 * Created by zhaohongbo on 17/5/15.
 */
public class CatPolyFormatVO implements Comparable{
    private Long total=0L;
    private CatPolymerization catpoly;

    public CatPolyFormatVO(CatPolymerization catpoly) {
        this.catpoly = catpoly;
        List<CatPolymerization> subpoly=catpoly.getSubPolymerizations();
        if(subpoly==null||subpoly.size()==0){
            total=catpoly.getNumber();
        }else{
            for(CatPolymerization c:subpoly){
                total+=c.getNumber();
            }
        }
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public CatPolymerization getCatpoly() {
        return catpoly;
    }

    public void setCatpoly(CatPolymerization catpoly) {
        this.catpoly = catpoly;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (((CatPolyFormatVO)o).total-this.total);
    }
}
