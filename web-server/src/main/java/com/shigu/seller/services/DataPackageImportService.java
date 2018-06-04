package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.PackageImportGoodsDataService;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tb.finder.services.TbPropsService;
import com.shigu.tb.finder.vo.PropertyItemVO;
import com.shigu.tb.finder.vo.PropertyValueVO;
import com.shigu.tb.finder.vo.PropsVO;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @类编号
 * @类名称：DataPackageImportService
 * @文件路径：com.shigu.seller.services.DataPackageImportService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("dataPackageImportService")
public class DataPackageImportService {

    private static final Logger logger = LoggerFactory.getLogger(DataPackageImportService.class);
    @Autowired
    PackageImportGoodsDataService packageImportGoodsDataService;

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    TbPropsService tbPropsService;

    @Autowired
    OssIO ossIO;

    final String URL_FLAG="/itemImgs/temp/";//临时图片地址标志
    final String URL_NORMAL="/itemImgs/";//正式图片地址

    @Autowired
    ShiguShopMapper shiguShopMapper;

    public List<ShiguGoodsTinyVO> importtempGoods(String packageUrl, Long storeId, String flag)throws Main4Exception{
      return  packageImportGoodsDataService.packageImporttempGoods (packageUrl,  storeId,  flag);
    }

    /**
     * 添加商品到星座网
     * @param shopId
     * @param tiny
     * @throws ItemModifyException
     */
    public void addToXzw(Long shopId,ShiguGoodsTinyVO tiny) throws ItemModifyException {
        SynItem item= BeanMapper.map(tiny,SynItem.class);
        ShiguShop shop=shiguShopMapper.selectByPrimaryKey(shopId);
        item.setShopId(shop.getShopId());
        item.setFloorId(shop.getFloorId());
        item.setMarketId(shop.getMarketId());
        item.setOnsale(true);
        item.setPropsName(parsePropName(tiny.getCid(),tiny.getExtendsGoods().getProps(),
                tiny.getExtendsGoods().getInputPids(),tiny.getExtendsGoods().getInputStr(),tiny.getExtendsGoods().getInputCustomCpv()));
        item.setPropertyAlias(tiny.getExtendsGoods().getPropertyAlias());
        item.setProps(tiny.getExtendsGoods().getProps());
        item.setInputPids(tiny.getExtendsGoods().getInputPids());
        item.setInputStr(tiny.getExtendsGoods().getInputStr());
        String picUrl=tiny.getPicUrl();
        String newPicUrl="";//搬家后的首图
        if (StringUtils.isNotEmpty(picUrl)) {
            newPicUrl=banjia(tiny.getPicUrl());
            item.setPicUrl(newPicUrl);
        }
//        String desc = tiny.getExtendsGoods().getGoodsDesc();
//        String goodsDesc = desc;
//        if (StringUtils.isNotBlank(desc)){
//            Document doc = Jsoup.parseBodyFragment(desc);
//            Elements elements = doc.getElementsByTag("img");
//            if (elements != null && elements.size() > 0){
//                for (int i = 0; i <elements.size() ; i++) {
//                    String imgUrl = elements.get(i).attr("src");
//                    if (StringUtils.isNotBlank(imgUrl)) {
//                        String newImgUrl = banjia(imgUrl);
//                        if (imgUrl.equalsIgnoreCase(newImgUrl) == false){
//                            goodsDesc = goodsDesc.replaceAll(imgUrl,newImgUrl);
//                        }
//                    }
//                }
//            }
//
//        }
        item.setGoodsDesc(tiny.getExtendsGoods().getGoodsDesc());
        List<ShiguPropImg> propImgs=BeanMapper.mapList(tiny.getExtendsGoods().getList_spi(), ShiguPropImg.class);
        for(ShiguPropImg img:propImgs){
            img.setUrl(banjia(img.getUrl()));
        }
        item.setPropImgs(propImgs);
        item.setItemFrom(ItemFrom.PACKAGE);
        item.setGoodsId(null);
        String images=tiny.getExtendsGoods().getImages();
        List<String> imageList=new ArrayList<>();
        if (StringUtils.isNotEmpty(images)) {
            String[] imgarr=images.split(",");
            for(String img:imgarr){
                if (img.equals(picUrl)) {
                    imageList.add(newPicUrl);
                }else {
                    imageList.add(banjia(img));
                }
            }
        }
        item.setImageList(imageList);
        itemAddOrUpdateService.userAddItem(item);
    }

    public String banjia(String url){
        String targetUrl=url;
        if (StringUtils.isNotBlank(url)&&url.contains(URL_FLAG)) {
            String srcFilePath=url.substring(url.indexOf(URL_FLAG),url.length());
            String targetFilePath=srcFilePath.replace(URL_FLAG,URL_NORMAL);
            if (srcFilePath.length()>0) {
                srcFilePath=srcFilePath.substring(1,srcFilePath.length());
            }
            if (targetFilePath.length()>0) {
                targetFilePath=targetFilePath.substring(1,targetFilePath.length());
            }
            targetUrl=url.replace(URL_FLAG,URL_NORMAL);
            ossIO.moveFile(srcFilePath,targetFilePath);
        }
        return targetUrl;
    }

    /**
     * 查propName
     * @param cid
     * @param props
     * @param inputIds
     * @param inputStr
     * @return
     */
    public String parsePropName(Long cid,String props,String inputIds,String inputStr,String cpvs){
        PropsVO propsVO= null;
        try {
            propsVO = tbPropsService.selProps(cid);
        } catch (Exception e) {
            logger.error("取淘宝类目属性失败",e);
            return "";
        }
        List<PropertyItemVO> allpropItems=new ArrayList<>();
        allpropItems.addAll(propsVO.getProperties());
        if (propsVO.getPingpai() != null) {
            allpropItems.add(propsVO.getPingpai());
        }
        if (propsVO.getHuohao() != null) {
            allpropItems.add(propsVO.getHuohao());
        }
        if (propsVO.getColor() != null) {
            allpropItems.add(propsVO.getColor());
        }
        if (propsVO.getSaleProps() != null) {
            allpropItems.addAll(propsVO.getSaleProps());
        }
        //解析自定义部分
        Map<Long,List<String>> inputMap=new HashMap<>();
        if (StringUtils.isNotEmpty(inputIds)) {
            String[] ids=inputIds.split(",");
            String[] values=inputStr.split(",");
            for(int i=0;i<ids.length;i++){
                Long id=Long.valueOf(ids[i]);
                String value=values[i];
                List<String> valueList=new ArrayList<>(Arrays.asList(value.split(";")));
                inputMap.put(id,valueList);
            }
        }
        //解析cpv部分
        Map<String,String> cpvMap=new HashMap<>();
        if (StringUtils.isNotEmpty(cpvs)) {
            String[] cpvarr=cpvs.split(";");
            for(String cpv:cpvarr){
                String[] carr=cpv.split(":");
                cpvMap.put(carr[0]+":"+carr[1],carr[2]);
            }
        }

        //变成Map
        Map<Long,PropertyItemVO> itemPropMap=allpropItems.stream().collect(Collectors.toMap(PropertyItemVO::getPid,propitem -> propitem));
        String[] proparr=props.split(";");
        StringBuilder propName=new StringBuilder();
        for(String p:proparr){
            Long pid=Long.valueOf(p.split(":")[0]);
            Long vid=Long.valueOf(p.split(":")[1]);
            PropertyItemVO propItem=itemPropMap.get(pid);
            String value=null;
            //得到value
            if (propItem != null&&propItem.getValues()!=null) {
                for(PropertyValueVO pv:propItem.getValues()){
                    if (vid.equals(pv.getVid())) {
                        value=pv.getName();
                        break;
                    }
                }
            }else {
                continue;
            }
            if (value == null) {//查一下自定义区
                List<String> inputValues=inputMap.get(pid);
                if (inputValues != null&&inputValues.size()>0) {
                    value=inputValues.remove(0);
                }

            }
            if (value == null){//查一下cpv
                value=cpvMap.get(pid+":"+vid);
                if (value == null) {
                    continue;
                }
            }
            propName.append(p);
            propName.append(":");
            propName.append(propItem.getName());
            propName.append(":");
            propName.append(value);
            propName.append(";");
        }
        String result=propName.toString();
        return result.endsWith(";")?result.substring(0,result.length()-1):result;
    }

}
