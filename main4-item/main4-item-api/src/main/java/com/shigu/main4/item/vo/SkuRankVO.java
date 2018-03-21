package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一个纵列的SKU
 * 比如颜色那一列
 * Created by zhaohongbo on 17/1/16.
 */
public class SkuRankVO extends ArrayList<TdVO> implements Serializable{

    private static final long serialVersionUID = 9203473780520810522L;

    /**
     * 转化成一行一对象
     * @return
     */
    public List<SkuVO> parseToSkuVO(){
        List<SkuVO> list=new ArrayList<SkuVO>();
        for(TdVO td:this){
            if(td.getSkuRankVO()!=null&&td.getSkuRankVO().size()>0){
                List<SkuVO> subsku=td.getSkuRankVO().parseToSkuVO();
                for(int i=0;i<subsku.size();i++){
                    SkuVO sku=subsku.get(i);
                    if(i==0){//只有每行的第一个,才会加入上级td。如一个颜色对多个尺码,只有第一行有颜色td
                        sku.add(0,td);
                    }
                    list.add(sku);
                }
            }else{
                SkuVO sv=new SkuVO();
                sv.add(td);
                list.add(sv);
            }
        }
        return list;
    }

}
