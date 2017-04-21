package com.shigu.zhb.utils;

/**
 * 页面工具
 * Created by Licca on 16/5/13.
 */
public class PageUtil {

    /**
     * 把条数计算成页数
     * @param pageSize
     * @param total
     * @return
     */
    public static int calPage(Integer pageSize,Integer total){
        if(total<=0){
            return 1;
        }
        int page=total/pageSize;
        if(total%pageSize>0){
            page++;
        }
        return page;
    }
}
