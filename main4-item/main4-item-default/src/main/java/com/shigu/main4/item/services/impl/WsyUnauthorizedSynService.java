package com.shigu.main4.item.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.TaobaoItemPropExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.Jobs;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service("wsyUnauthorizedSynService")
public class WsyUnauthorizedSynService extends OuterSynUtil {
    @Override
    protected void goodsExecute(SynShopBean synBean,Long otherGoodsId) {
        try {
            Map<Long, ?> pagedGoodsInfo = getPagedGoodsInfo(synBean, 0);
            if(pagedGoodsInfo.get(otherGoodsId)==null){
                return;
            }
            List<Long> onSales = Collections.singletonList(otherGoodsId);
            if(synBean.tinyMap.get(otherGoodsId)!=null){
                synUpdateItems(synBean, onSales, pagedGoodsInfo);
            }else{
                synNotOnSaleItems(synBean, onSales, pagedGoodsInfo);
            }
        } catch (SynException e) {
            e.printStackTrace();
        }
    }

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
            cidDoc = JsoupUtil.getHtml(String.format("https://wsy.com/itemlist.htm?id=%d", synShopBean.otherShopId));
            Elements cats = cidDoc.select(".type_section");
            for(Element cat:cats){
                Elements lis = cat.select("li").select("a");
                int i;
                if(lis.get(0).attr("href").contains("pid=")){
                    i=1;
                }else if(lis.get(0).attr("href").contains("cid=")){
                    i=0;
                }else{
                    continue;
                }
                for ( ; i < lis.size(); i++) {
                    Element li = lis.get(i);
                    Long cid=new Long(li.attr("href").split("cid=")[1]);
                    int page=0;
                    while(true){
                        page++;
                        String u=String.format("https://wsy.com/itemlist.htm?id=%d&cid=%d&page=%d",
                                synShopBean.otherShopId,cid, page);
                        if(synShopBean.startDate!=null){
                            u+="&startDate="+synShopBean.startDate;
                        }
                        Document orignalDoc = JsoupUtil.getHtml(u);
                        Element dd=orignalDoc.getElementById("content");
                        if (dd==null||dd.select(".item-c").size() == 0) {
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
    private static byte[] getImageFromNetByUrl(URL url){
        try {
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
    private static String getReUrl(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url)
                .openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        String newUrl=conn.getHeaderField("Location");
        if(newUrl==null||!newUrl.contains("http")){
            return url;
        }
        return newUrl;
    }


    @Override
    protected SynItem getGoodsInfo(Long outGoodsId, SynShopBean synShopBean, Long cid) throws SynException {
        Jobs imgupload=new Jobs(10) {
            @Override
            public void doWork(Object o) throws Exception {
                ImgUploadInfo u= (ImgUploadInfo) o;
                if(!ossIO.fileExist(u.file)){
                    byte[] b=getImageFromNetByUrl(u.url);
                    ossIO.uploadFile(b,u.file);
                }
            }
        };

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
                String picUrl=formatImage(image,shop.getShopId(),imgupload);
                if(i==0){
                    synItem.setPicUrl(picUrl);
                }
                picUrls.add(picUrl);
            }
            synItem.setImageList(picUrls);

            //批发价
            String piPriceString = doc.select(".fs-item-p1").select("em").select("span").html().trim();
            String priceString=StringEscapeUtils.unescapeHtml(doc.select(".fs-item-p1").select("a").select("span").html().trim()).replace("¥","");
            if(StringUtils.isEmpty(priceString)||StringUtils.isEmpty(piPriceString)){
                try {
                    new Double(piPriceString);
                    priceString=piPriceString;
                }catch (Exception e){
                    try{
                        new Double(priceString);
                        piPriceString=priceString;
                    }catch (Exception e1){
                        priceString=null;
                        piPriceString=null;
                    }
                }
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
                    img = formatImage(url,shop.getShopId(),imgupload);
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


            long inpvid=1000000000;
            //颜色
            Map<String,ShiguPropImg> noVmap=new HashMap<>();
            List<Long> hasVids=new ArrayList<>();
            Long hasPid=null;
            List<ShiguPropImg> propImgs=new ArrayList<>();
            Element colorele=doc.getElementById("mr_color");
            if(colorele==null){
                TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
                taobaoItemPropExample.createCriteria().andCidEqualTo(cid)
                        .andIsColorPropEqualTo(1);
                List<TaobaoItemProp> ps=taobaoItemPropMapper.selectByExample(taobaoItemPropExample);
                if(ps.size()>0&&ps.get(0).getMust()==1){
                    hasVids.add(-1L);
                    ShiguPropImg prop=new ShiguPropImg();
                    prop.setUrl(picUrls.get(0));
                    prop.setPid(ps.get(0).getPid());
                    noVmap.put("图片色",prop);
                }
            }else{
                Elements colorDocs=colorele.select("li");
                for(Element element:colorDocs){
                    String color=element.select("span").html().trim();
                    String code=element.select("a").attr("data-code");
                    Long pid=new Long(code.split(":")[0]);
                    hasPid=pid;
                    Long vid=new Long(code.split(":")[1]);
                    String img=element.attr("data-img").replace("_30x30.jpg","");
                    try {
                        img=formatImage(img,shop.getShopId(),imgupload);
                    } catch (IOException e) {
                        img=null;
                    }
                    ShiguPropImg prop=new ShiguPropImg();
                    prop.setUrl(img);
                    prop.setPid(pid);
                    hasVids.add(vid);
                    TaobaoPropValueExample taobaoPropValueExample=new TaobaoPropValueExample();
                    taobaoPropValueExample.createCriteria().andCidEqualTo(cid)
                            .andPidEqualTo(pid)
                            .andVidEqualTo(vid);
                    List<TaobaoPropValue> pvs=taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
                    if(pvs.size()>0){
                        propName.add(code+":"+pvs.get(0).getPropName()+":"+pvs.get(0).getName());
                        props.add(code);
                        if(!pvs.get(0).getName().equals(color)){
                            alias.add(code+":"+color);
                        }
                        prop.setVid(vid);
                        if(prop.getUrl()!=null){
                            propImgs.add(prop);
                        }
                    }else{
                        noVmap.put(color,prop);
                    }
                }
            }
            if(noVmap.size()>0){
                TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
                taobaoItemPropExample.createCriteria().andCidEqualTo(cid)
                        .andIsColorPropEqualTo(1);
                List<TaobaoItemProp> ps=taobaoItemPropMapper.selectByExample(taobaoItemPropExample);
                if(ps.get(0).getIsAllowAlias()==1){
                    TaobaoPropValueExample taobaoPropValueExample=new TaobaoPropValueExample();
                    taobaoPropValueExample.createCriteria().andCidEqualTo(cid)
                            .andPidEqualTo(hasPid)
                            .andVidNotIn(hasVids);
                    List<TaobaoPropValue> pvs=taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
                    noVmap.forEach((color, shiguPropImg) -> {
                        if(pvs.size()==0){
                            return;
                        }
                        TaobaoPropValue pv=pvs.get(0);
                        String code=pv.getPid()+":"+pv.getVid();
                        props.add(code);
                        propName.add(code+":"+pv.getPropName()+":"+pv.getName());
                        alias.add(code+":"+color);
                        if(shiguPropImg.getUrl()!=null){
                            shiguPropImg.setVid(pv.getVid());
                            propImgs.add(shiguPropImg);
                        }
                        pvs.remove(0);
                    });
                }else if(ps.get(0).getIsInputProp()==1){
                    if(!inputPids.contains(hasPid)){
                        inputPids.add(hasPid);
                    }
                    for(String vname:noVmap.keySet()){
                        inpvid=inpvid+1L;
                        props.add(hasPid+":"+ inpvid);
                        propName.add(hasPid+":"+ inpvid+":"+ps.get(0).getName()+":"+vname);
                        ShiguPropImg shiguPropImg=noVmap.get(vname);
                        if(shiguPropImg.getUrl()!=null){
                            shiguPropImg.setVid(inpvid);
                            propImgs.add(shiguPropImg);
                        }
                    }
                    inputStr.add(heb(new ArrayList<>(noVmap.keySet()),";"+ps.get(0).getName()+";"));
                }
            }
            synItem.setPropImgs(propImgs);

            //尺码
            Set<String> sizes=new HashSet<>();
            for(Element e:doc.select(".table-sku").select(".name").select("span")){
                sizes.add(e.html());
            }
            if(sizes.size()==0&&synItem.getPiPriceString()==null){
                throw new SynException(SynException.SynExceptionEnum.SYN_ONE_ITEM_EXCEPTION);
            }
            inpvid=handleProp(cid,null, new ArrayList<>(sizes), alias,props,propName,inputPids,inputStr,true,inpvid);
            if(synItem.getPriceString()==null){
                piPriceString=synItem.getPiPriceString();
                if(piPriceString==null){
                    piPriceString=doc.select(".table-sku .price .value").get(0).html();
                    priceString=piPriceString;
                }
                synItem.setPiPriceString(piPriceString);
                synItem.setPriceString(priceString);
            }

            //销售属性
            Elements propDoc=goodsDoc.select(".item_sx").select("a");
            for(Element element:propDoc){
                String[] pv=element.html().trim().split(":");
                String pname=pv[0];
                String vname=element.attr("title");
                if(pname.contains("尺")&&vname.split(" ").length==sizes.size()){
                    continue;
                }
                if(pname.equals("颜色")||pname.equals("尺码")){
                    continue;
                }
                if(pname.equals("货号")){
                    synItem.setOuterId(vname);
                    synItem.setGoodsNo(vname);
                }
                List<String> vns=new ArrayList<>(Collections.singletonList(vname));
                if(vname.equals("其它/other")){
                    vns.add("other/其它");
                }
                if(vname.equals("尖领（常规）")){
                    vns.add("尖领");
                }
                inpvid=handleProp(cid,pname,vns,alias,props,propName,inputPids,inputStr,false,inpvid);
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
        if(imgupload.running()>0){
            imgupload.join();
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
    private String formatImage(String url,Long shopId,Jobs imgupload) throws IOException {
        if(url.contains("taobaocdn")||url.contains("alicdn")){
            return url;
        }
        String uu=getReUrl(url);
        String fileStr="itemImgs/"+shopId+"/"+ MD5.encrypt(uu)+".jpg";
        imgupload.addJob(new ImgUploadInfo(new URL(uu),fileStr));
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
            if(ps.get(0).getIsInputProp()==1||pname.equals("货号")||isSaleSize){
                if(!inputPids.contains(pid)){
                    inputPids.add(pid);
                }
                for(String vname:vnames){
                    inpVid=inpVid+1L;
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