package com.shigu.main4.item.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.TaobaoItemPropExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.SynException;
import com.shigu.main4.item.services.utils.JsoupUtil;
import com.shigu.main4.item.services.utils.MD5;
import com.shigu.main4.item.services.utils.OuterSynUtil;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.*;

@Service("wsyUnauthorizedSynService")
public class WsyUnauthorizedSynService extends OuterSynUtil {

    @Override
    protected Map<Long, ShiguGoodsTiny> getLocalOuterGoodsMap(Long shopId, String webSite) {
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsExcelImpIn(Arrays.asList(ItemFrom.TAOBAO.ordinal(), ItemFrom.PACKAGE.ordinal()));
        HashMap<Long, ShiguGoodsTiny> result = new HashMap<>();
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, FieldUtil.codeFields("goods_id,num_iid"))) {
            result.put(tiny.getNumIid(),tiny);
        }
        return result;
    }

    @Override
    protected Map<Long, ShiguGoodsSoldout> getSynLocalSoldoutMap(List<Long> outerIds, Long shopId, String webSite) {
        if(outerIds.size()==0){
            return new HashMap<>();
        }
        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
        soldoutExample.setWebSite(webSite);
        soldoutExample.createCriteria().andStoreIdEqualTo(shopId).andNumIidIn(outerIds);
        HashMap<Long, ShiguGoodsSoldout> result = new HashMap<>();
        for (ShiguGoodsSoldout soldout : shiguGoodsSoldoutMapper.selectByExample(soldoutExample)) {
            result.put(soldout.getNumIid(),soldout);
        }
        return result;
    }

    @Override
    protected Map<Long, ?> getPagedGoodsInfo(SynShopBean synShopBean, int pageNo) throws SynException {
        if(queryingMap.get(synShopBean.otherShopId)!=1){
            throw new SynException(SynException.SynExceptionEnum.END_OF_PAGED_SYN_INFO_EXCEPTION);
        }
        queryingMap.put(synShopBean.otherShopId,2);
        Map<Long, Long> map=new HashMap<>();
        try {
            Document cidDoc;
            cidDoc = JsoupUtil.getHtml(String.format("https://wsy.com/store/p/%d/search.htm", synShopBean.otherShopId));
            Elements cats = cidDoc.select(".type_section");
            cats.remove(cats.size()-1);
            cats.remove(cats.size()-1);
            for(Element cat:cats){
                Elements lis = cat.select("li").select("a");
                int i;
                if(lis.get(0).attr("href").contains("pid=")){
                    i=1;
                }else{
                    i=0;
                }
                for ( ; i < lis.size(); i++) {
                    Element li = lis.get(i);
                    Long cid=new Long(li.attr("href").split("cid=")[1]);
                    int page=0;
                    while(true){
                        page++;
                        String u=String.format("https://wsy.com/store/p/%d/search.htm?cid=%d&id=%d&alias=search&page=%d",
                                synShopBean.otherShopId,cid,synShopBean.otherShopId, page);
                        Document orignalDoc = JsoupUtil.getHtml(u);
                        if (orignalDoc.getElementById("content").select(".item-c").size() == 0) {
                            //分页数据搜索结束
                            break;
                        }
                        Elements es=orignalDoc.getElementById("content").select(".package");
                        for(Element e:es){
                            map.put(Long.valueOf(e.attr("data-id")),cid);
                        }
                    }
                }
            }
            return map;
        } catch (IOException e) {
            throw new SynException(SynException.SynExceptionEnum.COULD_NOT_GET_SYN_INFO_EXCEPTION);
        }
    }

    @Override
    protected SynItem getGoodsInfo(Long outGoodsId, SynShopBean synShopBean, Long cid) throws SynException {
        SynItem synItem = new SynItem();
        try {
            ShiguShop shop=synShopBean.shop;
            synItem.setShopId(shop.getShopId());
            synItem.setWebSite(shop.getWebSite());
            synItem.setMarketId(shop.getMarketId());
            synItem.setFloorId(shop.getFloorId());
            synItem.setNumIid(outGoodsId);
            synItem.setCid(cid);
            synItem.setNum(999L);
            synItem.setOnsale(synShopBean.commonIds.contains(outGoodsId));
            synItem.setItemFrom(ItemFrom.PACKAGE);

            Document goodsDoc = JsoupUtil.getHtml(String.format("https://wsy.com/item.htm?id=%d", outGoodsId));
            Element doc=goodsDoc.getElementById("detail");

            //标题
            Element titleEle=doc.select(".item-mb").select("a").get(0);
            String detailUrl=titleEle.attr("href").trim();
            if(!detailUrl.contains("taobao")){
                detailUrl=null;
            }
            String title=titleEle.html().trim();
            synItem.setDetailUrl(detailUrl);
            synItem.setTitle(title);

            //上架时间
            String day=doc.select(".item-msg-time").select("span").html().trim();
            Date uoploadTime= DateUtil.stringToDate(day,DateUtil.patternA);
            synItem.setCreated(uoploadTime);
            synItem.setListTime(uoploadTime);
            synItem.setModified(uoploadTime);
            synItem.setDelistTime(uoploadTime);

            //货号
            String goodsNo=doc.select(".item-mb").select("span").get(0).html().trim();
            synItem.setOuterId(goodsNo);
            synItem.setGoodsNo(goodsNo);

            //图片
            Elements images=doc.getElementById("J_UlThumb").select("a");
            List<String> picUrls=new ArrayList<>();
            for(int i=0;i<images.size();i++){
                String image=images.get(i).attr("href");
                String picUrl=formatImage(image,shop.getUserId());
                if(i==0){
                    synItem.setPicUrl(picUrl);
                }
                picUrls.add(picUrl);
            }
            synItem.setImageList(picUrls);

            //批发价
            String piPriceString = doc.select(".fs-item-p1").select("em").select("span").html().trim();
            String priceString=StringEscapeUtils.unescapeHtml(doc.select(".fs-item-p1").select("a").select("span").html().trim()).replace("¥","");
            if(StringUtils.isEmpty(priceString)){
                priceString= MoneyUtil.dealPrice(MoneyUtil.StringToLong(piPriceString)*2);
            }
            synItem.setPiPriceString(piPriceString);
            synItem.setPriceString(priceString);

            //商品详情
            Element desce=goodsDoc.getElementById("J_DivItemDesc2");
            String desc=desce.html();
            desc=StringEscapeUtils.unescapeHtml(desc);
            Document descDoc= Jsoup.parse(desc);
            descDoc.select(".moudleDrag").remove();
            Elements descImgs=descDoc.select("img");
            for(int i=0;i<descImgs.size();i++){
                Element e=descImgs.get(i);
                String url=e.attr("src");

                for(Attribute attribute:e.attributes().asList()){
                    if(!attribute.getKey().equals("align")&&!attribute.getKey().equals("style")){
                        e.removeAttr(attribute.getKey());
                    }
                }
                String img;
                try {
                    img = formatImage(url,shop.getUserId());
                } catch (Exception e1) {
                    descImgs.remove(i);
                    i--;
                    continue;
                }
                e.attr("src",img);
            }
            synItem.setGoodsDesc(descDoc.body().html());

            List<String> alias=new ArrayList<>();
            List<String> props=new ArrayList<>();
            List<String> propName=new ArrayList<>();
            List<Long> inputPids=new ArrayList<>();
            List<String> inputStr=new ArrayList<>();

            //颜色
            Elements colorDocs=doc.getElementById("mr_color").select("li");
            TaobaoItemProp propDate=null;
            List<String> inpColors= new ArrayList<>();
            List<ShiguPropImg> propImgs=new ArrayList<>();
            long inpvid=-1001L;
            for(Element element:colorDocs){
                String color=element.select("span").html().trim();
                String code=element.select("a").attr("data-code");
                Long pid=new Long(code.split(":")[0]);
                Long vid=new Long(code.split(":")[1]);
                String img=element.attr("data-img").replace("_30x30.jpg","");
                try {
                    img=formatImage(img,shop.getUserId());
                } catch (IOException e) {
                    img=null;
                }
                ShiguPropImg prop=new ShiguPropImg();
                prop.setUrl(img);
                prop.setPid(pid);
                prop.setVid(vid);
                props.add(code);
                TaobaoPropValueExample taobaoPropValueExample=new TaobaoPropValueExample();
                taobaoPropValueExample.createCriteria().andCidEqualTo(cid)
                        .andPidEqualTo(pid)
                        .andVidEqualTo(vid);
                List<TaobaoPropValue> pvs=taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
                if(pvs.size()>0){
                    propName.add(code+":"+pvs.get(0).getPropName()+":"+pvs.get(0).getName());
                    if(!pvs.get(0).getName().equals(color)){
                        alias.add(code+":"+color);
                    }
                }else{
                    if(propDate==null){
                        TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
                        taobaoItemPropExample.createCriteria().andCidEqualTo(cid).andPidEqualTo(pid).andIsColorPropEqualTo(1);
                        List<TaobaoItemProp> ps=taobaoItemPropMapper.selectByExample(taobaoItemPropExample);
                        propDate=ps.get(0);
                    }
                    propName.add(code+":"+propDate.getName()+":"+color);
                    if(!inputPids.contains(pid)){
                        inputPids.add(pid);
                    }
                    if(vid<inpvid){
                        inpvid=vid;
                    }
                    inpColors.add(color);
                }
                propImgs.add(prop);
            }
            synItem.setPropImgs(propImgs);
            if(propDate!=null){
                inputStr.add(heb(inpColors,";"+propDate.getName()+";"));
            }


            //尺码
            Set<String> sizes=new HashSet<>();
            for(Element e:doc.select(".table-sku").select(".name").select("span")){
                sizes.add(e.html());
            }
            inpvid=handleProp(cid,null, new ArrayList<>(sizes), alias,props,propName,inputPids,inputStr,true,inpvid);


            //销售属性
            Elements propDoc=goodsDoc.select(".item_sx").select("a");
            for(Element element:propDoc){
                String[] pv=element.html().trim().split(":");
                String pname=pv[0];
                String vname=pv[1];
                if(pname.contains("尺")&&vname.split(" ").length==sizes.size()){
                    continue;
                }
                if(pname.equals("颜色")||pname.equals("尺码")
                        ||pname.equals("基础风格")||pname.equals("细分风格")){
                    continue;
                }
                if(pname.equals("货号")){
                    synItem.setOuterId(vname);
                    synItem.setGoodsNo(vname);
                }
                inpvid=handleProp(cid,pname, new ArrayList<>(Collections.singletonList(vname)), alias,props,propName,inputPids,inputStr,false,inpvid);
            }
            synItem.setProps(heb(props,";"));
            synItem.setPropsName(heb(propName,";"));
            synItem.setPropertyAlias(heb(alias,";"));
            synItem.setInputPids(heb(inputPids,","));
            synItem.setInputStr(heb(inputStr,","));
        } catch (Exception e) {
            e.printStackTrace();
            throw new SynException(SynException.SynExceptionEnum.SYN_ONE_ITEM_EXCEPTION);
        }

        return synItem;
    }

    @Override
    protected boolean checkGoodsSyn(ShiguGoodsTiny goods, Object synGoods) {
        return false;
    }

    @Override
    protected boolean checkLocalModified(ShiguGoodsModified modified, ModifiedStateEnum modifiedState) {
        return false;
    }


    //图片转至oss
    private String formatImage(String url,Long userId) throws IOException {
        if(url.contains("taobaocdn")||url.contains("alicdn")){
            return url;
        }
        String fileStr="itemimgs/"+userId+"/goodsId/"+ MD5.encrypt(url)+".jpg";
        ossIO.uploadFile(new URL(url).openStream(),fileStr);
        return "//imgs.571xz.net/"+fileStr;
    }
    private long handleProp(Long cid,String pname,List<String> vnames,List<String> alias,List<String> props,List<String> propNames,List<Long> inputPids,List<String> inputStr,boolean isSaleSize,long inpVid){
        Long pid;
        TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
        TaobaoItemPropExample.Criteria ce=taobaoItemPropExample.createCriteria().andCidEqualTo(cid);
        if(isSaleSize){
            ce.andNameLike("%尺%").andIsSalePropEqualTo(1);
        }else{
            ce.andNameEqualTo(pname).andIsSalePropEqualTo(0);
        }
        List<TaobaoItemProp> ps=taobaoItemPropMapper.selectByExample(taobaoItemPropExample);
        if(ps.size()==0){
            return inpVid;
        }
        pid=ps.get(0).getPid();
        pname=ps.get(0).getName();

        TaobaoPropValueExample taobaoPropValueExample=new TaobaoPropValueExample();
        taobaoPropValueExample.createCriteria().andPidEqualTo(pid).andNameIn(vnames).andCidEqualTo(cid);
        List<TaobaoPropValue> pvs=taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
        List<String> has=new ArrayList<>();
        for(TaobaoPropValue pv:pvs){
            has.add(pv.getName());
            props.add(pid+":"+pv.getVid());
            propNames.add(pid+":"+pv.getVid()+":"+pv.getPropName()+":"+pv.getName());
        }
        vnames.removeAll(has);
        if(vnames.size()>0){
            if(ps.get(0).getIsAllowAlias()==1){
                TaobaoPropValueExample taobaoPropValueExample1=new TaobaoPropValueExample();
                TaobaoPropValueExample.Criteria ce1=taobaoPropValueExample1.createCriteria().andPidEqualTo(pid).andCidEqualTo(cid);
                if(has.size()>0){
                    ce1.andNameNotIn(has);
                }
                taobaoPropValueExample1.setStartIndex(0);
                taobaoPropValueExample1.setEndIndex(vnames.size());
                List<TaobaoPropValue> otherpvs=taobaoPropValueMapper.selectByConditionList(taobaoPropValueExample1);
                for(TaobaoPropValue ov:otherpvs){
                    if(vnames.size()==0){
                        break;
                    }
                    String vname= vnames.get(0);
                    vnames.remove(0);
                    props.add(pid+":"+ov.getVid());
                    propNames.add(pid+":"+ov.getVid()+":"+ov.getPropName()+":"+ov.getName());
                    alias.add(pid+":"+ov.getVid()+":"+vname);
                }
            }
        }
        if(vnames.size()>0){
            if(ps.get(0).getIsInputProp()==1){
                if(!inputPids.contains(pid)){
                    inputPids.add(pid);
                }
                for(String vname:vnames){
                    inpVid=inpVid-1L;
                    props.add(pid+":"+ inpVid);
                    propNames.add(pid+":"+ inpVid+":"+pname+":"+vname);
                }
                inputStr.add(heb(vnames,";"+pname+";"));
            }
        }
        return inpVid;
    }


    private String heb(List list,String splitStr){
        StringBuilder str= new StringBuilder();
        for(int i=0;i<list.size();i++){
            str.append(list.get(i));
            if(i<list.size()-1){
                str.append(splitStr);
            }
        }
        return str.toString();
    }
}