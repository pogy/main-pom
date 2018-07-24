package com.shigu.search.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.search.bo.NewGoodsBO;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.search.vo.IconCateNav;
import com.shigu.search.vo.StyleCateNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 今日新品
 * Created by zhaohongbo on 17/4/5.
 */
@Service
public class TodayNewGoodsService {
    /**
     * 图标类筛选
     */
    private String iconcatestr="男装|nanzhuang1|656,男鞋|nanxie1|655,女装|nvzhuang1|65c,女鞋|nvxie|65a,童装|tongzhuang1|65d,包包|baobao|654,配饰|maozi|65b,大码|dama|658,情侣|qinglv|659,内衣|neiyi|657";
    private List<String> iconcateIds;
    /**
     * 风格类筛选
     */
    private String stylecatestr="店主风,休闲,运动,情侣,日系,大码,街拍,欧美,英伦,大码,街拍,欧美,休闲,运动,情侣,日系,大码,街拍";
    /**
     * 图标类目
     */
    private List<IconCateNav> iconCateNavs;
    /**
     * 泉州图标类目
     */
    private List<IconCateNav> iconCateNavsQz;
    /**
     * 风格
     */
    private List<StyleCateNav> styleCateNavs;

    @Autowired
    GoodsSelFromEsService goodsSelFromEsService;

    /**
     * 初始化顶类目
     */
    @PostConstruct
    public void init(){
        if(iconCateNavs==null){
            iconCateNavs=new ArrayList<>();
            String[] iconcate=iconcatestr.split(",");
            for(int i=0;i<iconcate.length;i++){
                String icon=iconcate[i];
                String[] iconarr=icon.split("\\|");
                IconCateNav nav=new IconCateNav();
                nav.setId(i+1+"");
                nav.setText(iconarr[0]);
                nav.setName(iconarr[1]);
                nav.setIcon(iconarr[2]);
                iconCateNavs.add(nav);
            }
        }
        if(styleCateNavs==null){
            styleCateNavs=new ArrayList<>();
            String[] stylecate=stylecatestr.split(",");
            for (int i=0;i<stylecate.length;i++){
                StyleCateNav styleCateNav=new StyleCateNav();
                styleCateNav.setId(i+1+"");
                styleCateNav.setText(stylecate[i]);
                styleCateNavs.add(styleCateNav);
            }
        }
        if(iconCateNavsQz==null){
            iconCateNavsQz=new ArrayList<>();
            String[] iconcate=iconcatestr.split(",");
            for(int i=0;i<iconcate.length;i++){
                if(!iconcate[i].contains("鞋")){
                    continue;
                }
                String icon=iconcate[i];
                String[] iconarr=icon.split("\\|");
                IconCateNav nav=new IconCateNav();
                nav.setId(i+1+"");
                nav.setText(iconarr[0]);
                nav.setName(iconarr[1]);
                nav.setIcon(iconarr[2]);
                iconCateNavsQz.add(nav);
            }
        }
        String iconcateIdstr="30,50011740,16,50006843,50008165,50006842,50010404,大码,情侣,1625";
        iconcateIds= Arrays.asList(iconcateIdstr.split(","));
    }

    /**
     * 查真实cid
     * @param cid
     * @return
     */
    public String selRealCid(Long cid){
        if(cid==null||cid<=0||cid>iconcateIds.size()){
            return "30";
        }
        return iconcateIds.get(cid.intValue()-1);
    }

    /**
     * 查今日新品
     * @param bo
     * @return
     */
    public ShiguPager<GoodsInSearch> selGoodsNew(NewGoodsBO bo){
        String realCid = selRealCid(bo.getCid());
        Long realCidnum=null;
        if(realCid.equals("大码")||realCid.equals("情侣")){
            bo.setKeyword(realCid);
        }else{
            realCidnum=Long.valueOf(realCid);
        }
        Calendar cal=Calendar.getInstance();
        Date to=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date from=cal.getTime();
        return goodsSelFromEsService.selGoodsInSearch(bo.getKeyword(),bo.getWebSite(),realCidnum,null,from,to,bo);
    }

    /**
     * 查今日新品
     * @param bo
     * @return
     */
    public ShiguPager<GoodsInSearch> selGoodsNewForCid(NewGoodsBO bo){
        Calendar cal=Calendar.getInstance();
        Date to=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date from=cal.getTime();
        return goodsSelFromEsService.selGoodsInSearch(bo.getKeyword(),bo.getWebSite(),null,null,from,to,bo);
    }


    /**
     * 查搜索顶类目选择
     * @return
     */
    public List<IconCateNav> selIconCateNav(String webSite){
        if("qz".equals(webSite)){
            return iconCateNavsQz;
        }
        return iconCateNavs;
    }

    /**
     * 风格分类
     * @return
     */
    public List<StyleCateNav> selStyleCateNav(){
        return styleCateNavs;
    }

}
