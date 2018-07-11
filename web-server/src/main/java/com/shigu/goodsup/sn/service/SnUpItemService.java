package com.shigu.goodsup.sn.service;

import com.openJar.beans.SnShopCategory;
import com.openJar.requests.api.SnFreightTemplateRequest;
import com.openJar.requests.api.SnItemParametersRequest;
import com.openJar.requests.api.SnShopCategoryRequest;
import com.openJar.responses.api.SnFreightTemplateResponse;
import com.openJar.responses.api.SnItemParametersResponse;
import com.openJar.responses.api.SnShopCategoryResponse;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguPropImgsExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.PropsService;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.goodsup.jd.vo.SkuRankVO;
import com.shigu.goodsup.jd.vo.SkuVO;
import com.shigu.goodsup.jd.vo.StoreCatVO;
import com.shigu.goodsup.jd.vo.TdVO;
import com.shigu.goodsup.sn.vo.*;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.tb.finder.vo.PropType;
import com.shigu.tools.KeyWordsUtil;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.item.ItemparametersQueryResponse;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.suning.api.util.StringUtil;
import com.taobao.api.domain.DeliveryTemplate;
import com.taobao.api.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SnUpItemService {

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    XzJdSdkSend xzJdSdkSend;
    @Autowired
    PropsService propsService;
    @Autowired
    ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;
    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    ShiguPropImgsMapper shiguPropImgsMapper;

    public SnPageItem findGoods(Long goodsId) throws CustomException {
        ShiguGoodsTiny shiguGoodsTiny = selTiny(goodsId);
        SnPageItem snPageItem = new SnPageItem();
        snPageItem.setNumIid(shiguGoodsTiny.getNumIid());
        snPageItem.setStoreId(shiguGoodsTiny.getStoreId());
        snPageItem.setWebSite(shiguGoodsTiny.getWebSite());
        snPageItem.setGoodsId(shiguGoodsTiny.getGoodsId());
        snPageItem.setHuohao(shiguGoodsTiny.getGoodsNo());
        snPageItem.setGoodsId(goodsId);
        snPageItem.setPiPrice(shiguGoodsTiny.getPiPriceString());
        if (shiguGoodsTiny.getStoreId() != null) {
            List<Long> storeIds = new ArrayList<>();
            storeIds.add(shiguGoodsTiny.getStoreId());
            List<ShopNumAndMarket> gmi = shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size() > 0) {
                snPageItem.setParentMarketName(gmi.get(0).getMarket());
                snPageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }
        Item item = jdUpItemService.staticGoods(shiguGoodsTiny);
        item.setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
        item.setDesc(KeyWordsUtil.duleKeyWords(item.getDesc()));
        snPageItem.setItem(item);
        if (shiguGoodsTiny.getNumIid() == null) {
            snPageItem.setGoodsType(2);
        } else {
            snPageItem.setGoodsType(1);
        }
        snPageItem.setDataType(2);

        return snPageItem;
    }

    public ShiguGoodsTiny selTiny(Long goodsId) throws CustomException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            throw new CustomException(goodsId + " goodsId生成表没找到");
        }
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null) {
            throw new CustomException(goodsId + " goodsTiny表没找到");
        }
        return shiguGoodsTiny;
    }

    /**
     * 获取运费模板
     *
     * @param username
     * @return
     * @throws AuthOverException
     * @throws CustomException
     */
    public List<SnDeliveryVo> selPostModel(String username) throws AuthOverException, CustomException {
        List<SnDeliveryVo> vs = new ArrayList<>();
        SnFreightTemplateRequest request = new SnFreightTemplateRequest();
        request.setUsername(username);
        SnFreightTemplateResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return vs;
        }
        List<FreighttemplateQueryResponse.QueryFreighttemplate> list = response.getQueryFreighttemplateList();
        if (list == null) {
            return vs;
        } else {
            vs.addAll(list.stream().map(l -> {
                SnDeliveryVo v = new SnDeliveryVo();
                v.setFreightId(l.getFreighttemplateid());
                v.setFreigtName(l.getFreighttemplatename());
                return v;
            }).collect(Collectors.toList()));
            return vs;
        }
    }

    public List<StoreCatVO> selShopCats(String username) throws AuthOverException, CustomException {
        SnShopCategoryRequest request = new SnShopCategoryRequest();
        request.setUsername(username);
        SnShopCategoryResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return new ArrayList<>();
        }
        List<SnShopCategory> shopCategories = response.getSnShopCategories();
        if (shopCategories == null) {
            return null;
        } else {
            Map<Integer, List<SnShopCategory>> map = shopCategories.stream().collect(Collectors.groupingBy(SnShopCategory::getIsFirst));
            return map.get(0).stream().map(shopCategory -> {
                StoreCatVO vo = new StoreCatVO();
                vo.setCatId(Long.valueOf(shopCategory.getCategoryCode()));
                vo.setName(shopCategory.getCategoryName());
                vo.setSubCat(map.get(1).stream().map(shopCategory1 -> {
                    StoreCatVO svo = new StoreCatVO();
                    svo.setName(shopCategory1.getCategoryName());
                    svo.setCatId(Long.valueOf(shopCategory1.getCategoryCode()));
                    return svo;
                }).collect(Collectors.toList()));
                return vo;
            }).collect(Collectors.toList());
        }
    }

    public SnPropsVo selProps(Long goodId, String categoryCode, String username, List<NewbrandQueryResponse.QueryNewbrand> brands) throws AuthOverException, CustomException, CloneNotSupportedException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = new ShiguGoodsIdGenerator();
        shiguGoodsIdGenerator.setGoodId(goodId);
        shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(shiguGoodsIdGenerator);
        if (shiguGoodsIdGenerator == null) {
            throw new CustomException("商品id不存在");
        }
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null) {
            throw new CustomException(goodId + " goodsTiny表没找到");
        }
        ShiguGoodsExtends shiguGoodsExtends = new ShiguGoodsExtends();
        shiguGoodsExtends.setGoodsId(goodId);
        shiguGoodsExtends.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(shiguGoodsExtends);
        if (shiguGoodsExtends == null) {
            throw new CustomException("商品详情不存在");
        }
        ShiguPropImgs shiguPropImgs=new ShiguPropImgs();
        ShiguPropImgsExample shiguPropImgsExample=new ShiguPropImgsExample();
        shiguPropImgsExample.createCriteria().andItemIdEqualTo(goodId);
        List<ShiguPropImgs> list1=shiguPropImgsMapper.selectByExample(shiguPropImgsExample);
        if(list1==null){
            shiguPropImgs=new ShiguPropImgs();
        }else{
            shiguPropImgs=list1.get(0);
        }
        Map<String, String> propMap = new HashMap<>();
        if (shiguGoodsExtends.getPropsName() == null) {
            propMap = null;
        }
        propMap = changeProp(shiguGoodsExtends.getPropsName());
        Map<String,String> propImg=changeColorImg(shiguGoodsExtends.getPropsName(),shiguPropImgs.getPropimgs());


        PropItemVo pivBrand = new PropItemVo();
        pivBrand.setMustHave(true);
        List<PropValueVo> values = new ArrayList<>();
        for(NewbrandQueryResponse.QueryNewbrand brand:brands){
            PropValueVo propertyValueVO = new PropValueVo();
            propertyValueVO.setName(brand.getBrandName());
            propertyValueVO.setSelected(false);
            propertyValueVO.setFid(2);
            propertyValueVO.setSubPropItem(null);
            propertyValueVO.setSnId(brand.getBrandCode());
            values.add(propertyValueVO);
        }
        pivBrand.setValues(values);
        SnItemParametersRequest reqeust = new SnItemParametersRequest();
        reqeust.setUsername(username);
        reqeust.setCategoryCode(categoryCode);
        SnItemParametersResponse response = xzJdSdkSend.send(reqeust);
        List<ItemparametersQueryResponse.ItemparametersQuery> list = response.getItemparametersQueries();
        SnPropsVo pv = new SnPropsVo();
        pv.setPingpai(pivBrand);
        pv.setProperties(fillProp(list, "", shiguGoodsTiny.getGoodsNo(), 0, propMap,propImg));
        pv.setColor(fillProp(list, "common", shiguGoodsTiny.getGoodsNo(), 1, propMap,propImg).get(0));
        pv.setSaleProps(fillProp(list, "common", shiguGoodsTiny.getGoodsNo(), 2, propMap,propImg));
        pv.setSkus(calculateSku(pv.getColor(), pv.getSaleProps()));
        return pv;
    }

    private List<PropItemVo> fillProp(List<ItemparametersQueryResponse.ItemparametersQuery> list, String type, String goodNo, int status, Map<String, String> propMap,Map<String,String> propImg) throws CustomException {
        List<PropItemVo> pv = new ArrayList<>();

        PropItemVo p = new PropItemVo();
        PropItemVo p1 = new PropItemVo();
        for (ItemparametersQueryResponse.ItemparametersQuery itemparametersQuery : list) {
            String snType = itemparametersQuery.getParaTemplateCode();
            if (snType.equals("basic")) {
                continue;
            }
            boolean flag = true;
            if (type.equals("common")) {
                flag = false;
            }
            if (flag && !snType.equals("common")) {
                pv.add(addProp(itemparametersQuery, propMap, 3,goodNo,propImg));
            } else if (snType.equals(type)) {
                if (status == 1) {
                    if (itemparametersQuery.getParName().equals("色卡")) {
                        p = addProp(itemparametersQuery, propMap, 1,goodNo,propImg);
                    }
                    if (itemparametersQuery.getParName().equals("颜色")) {
                        p1 = addProp(itemparametersQuery, propMap, 1,goodNo,propImg);
                    }
                } else if (status == 2) {
                    if (!itemparametersQuery.getParCode().equals("G00000") && !itemparametersQuery.getParCode().equals("G00001") && !itemparametersQuery.getParCode().equals("G00002")) {
                        p = addProp(itemparametersQuery, propMap, 2,goodNo,propImg);
                    }
                    if (itemparametersQuery.getParName().equals("尺码")) {
                        p1 = addProp(itemparametersQuery, propMap, 1,goodNo,propImg);
                    }
                }
            }
        }
//        if (!type.equals("")) {
//            p1.addPropValueList(p.getValues());
//            pv.add(p1);
//        }
        pv.add(p);
        return pv;
    }

    private Map<String, String> changeProp(String propName) {
        if (propName.equals("")) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        String[] props = propName.split(";");
        for (String s : props) {
            String[] prop = s.split(":");
            map.merge(prop[2], prop[3], (a, b) -> a + "," + b);
        }
        return map;
    }

    private Map<String,String> changeColorImg(String propName,String propImgs){
        if(propName.equals("")||propImgs==null||propImgs.equals("")){
            return null;
        }
        Map<String,String> map=new HashMap<>();
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        String[] props=propName.split(";");
        String[] imgs=propImgs.split(";");
        for(String img:imgs){
            String[] urls=img.split("##");
            map.put(urls[0],urls[1]);
        }
        for(String prop:props){
            String[] s=prop.split(":");
            map1.put(s[0]+":"+s[1],s[3]);
        }
        for(String s:map.keySet()){
            if(map1.get(s)!=null){
                map2.put(map1.get(s),map.get(s));
            }
        }
        return map2;
    }

    private PropItemVo addProp(ItemparametersQueryResponse.ItemparametersQuery itemparametersQuery, Map<String, String> propMap, int status,String goodNo,Map<String,String> propImg) {
        if (status == 2) {
            String s = propMap.get("尺码");
            if(s==null){
                s=propMap.get("尺寸");
            }
            propMap = new HashMap<>();
            propMap.put("尺码", s);
        }
        PropItemVo propItemVo = new PropItemVo();
        if (itemparametersQuery.getIsMust().equals("X")) {
            propItemVo.setMustHave(true);
        } else {
            propItemVo.setMustHave(false);
        }
        switch (itemparametersQuery.getParType()) {
            case "1":
                propItemVo.setType(PropType.SELECT);
                break;
            case "2":
                propItemVo.setType(PropType.CHECKBOX);
                break;
            case "3":
                propItemVo.setType(PropType.INPUT);
                break;
        }
        propItemVo.setCanAlias(false);
        propItemVo.setName(itemparametersQuery.getParName());
        List<PropValueVo> propValueVos = new ArrayList<>();
        if(itemparametersQuery.getParName().equals("货号")) {
            PropValueVo p=new PropValueVo();
            p.setName(goodNo);
            propValueVos.add(p);
        }
        List<ItemparametersQueryResponse.ParOption> parOptions = itemparametersQuery.getParOption();
        if (parOptions == null) {
            propItemVo.setValues(null);
        } else {
            fill(propMap, parOptions, propValueVos, propItemVo,status,propImg);
        }
        propItemVo.setSnCode(itemparametersQuery.getParCode());
        propItemVo.setValues(propValueVos);

        return propItemVo;
    }

    private void fill(Map<String, String> propMap, List<ItemparametersQueryResponse.ParOption> parOptions, List<PropValueVo> propValueVos, PropItemVo propItemVo,int status,Map<String,String> propImg) {
        if (propMap == null) {
            for (ItemparametersQueryResponse.ParOption p : parOptions) {
                PropValueVo propValueVo = new PropValueVo();
                propValueVo.setName(p.getParOptionDesc());
                propValueVo.setSnId(p.getParOptionCode());
                propValueVo.setSelected(false);
                propValueVos.add(propValueVo);
            }
        } else {
            String propName = null;
            if (!propMap.containsKey(propItemVo.getName())) {
                for (String key : propMap.keySet()) {
                    if (key.contains(propItemVo.getName())) {
                        propName = propMap.get(key);
                    } else {
                        char[] c = propItemVo.getName().toCharArray();
                        if (c.length >= 2) {
                            for (int i = 0; i < c.length - 2; i++) {
                                if (key.contains(String.valueOf(c[i]) + String.valueOf(c[i + 1]))) {
                                    propName = propMap.get(key);
                                    break;
                                }
                            }
                        }
                        for (char c1 : c) {
                            if (key.contains(String.valueOf(c1))) {
                                propName = propMap.get(key);
                                break;
                            }
                        }
                    }
                }
            } else {
                propName = propMap.get(propItemVo.getName());
            }
            if (propName == null) {
                if (parOptions.size() > 10) {
                    if (parOptions.get(0).getParOptionCode().equals("")) {
                        propName = propMap.get("尺码");
                        String[] ss = propName.split(",");
                        for (String s : ss) {
                            if (StringUtil.isNumeric(s)) {
                                propName = propName.replace(s, s + "码");
                            }
                        }
                        addParOption(parOptions, propValueVos, propName,status,propImg);
                    } else {
                        addParOption(parOptions, propValueVos);
                    }
                } else {
                    addParOption(parOptions, propValueVos);
                    ;
                }
            } else {
                addParOption(parOptions, propValueVos, propName,status,propImg);
            }
        }
    }

    private void addParOption(List<ItemparametersQueryResponse.ParOption> parOptions, List<PropValueVo> propValueVos) {
        for (ItemparametersQueryResponse.ParOption p : parOptions) {
            PropValueVo propValueVo = new PropValueVo();
            propValueVo.setName(p.getParOptionDesc());
            propValueVo.setSnId(p.getParOptionCode());
            propValueVos.add(propValueVo);
        }
    }

    private void addParOption(List<ItemparametersQueryResponse.ParOption> parOptions, List<PropValueVo> propValueVos, String propName,int status,Map<String,String> propImg) {
        String[] s=null;
        if(propImg==null){
            propImg=new HashMap<>();
        }
        for (ItemparametersQueryResponse.ParOption p : parOptions) {
            PropValueVo propValueVo = new PropValueVo();
            propValueVo.setName(p.getParOptionDesc());
            if (!propName.equals("")) {
                s = propName.split(",");
                for (String s1 : s) {
                    if (propValueVo.getName().equals(s1)) {
                        propValueVo.setSelected(true);
                        if(status!=3) {
                            propName = replace(s1, propName);
                        }
                        if(propImg.get(propValueVo.getName())!=null){
                            propValueVo.setImgUrl(propImg.get(propValueVo.getName()));
                        }
                    } else {
                        if (propValueVo.getName().contains(s1)&&status!=2) {
                            propValueVo.setSelected(true);
                            propName = replace(s1, propName);
                        }
                    }
                }
            }

            propValueVo.setSnId(p.getParOptionCode());
            propValueVos.add(propValueVo);
        }
        if(status!=3) {
            if (!propName.equals("")) {
                s = propName.split(",");
                for (int j=s.length-1,n=1;j>=0; j--,n++) {
                   if(!propValueVos.get(propValueVos.size()-n).isSelected()){
                       propValueVos.get(propValueVos.size()-n).setOldName(propValueVos.get(propValueVos.size()-n).getName());
                       propValueVos.get(propValueVos.size()-n).setName(s[j]);
                       propValueVos.get(propValueVos.size()-n).setSelected(true);
                   }
//                    propValueVo.setName(s[j]);
//                    propValueVo.setOldName(parOptions.get(parOptions.size()-n).getParOptionDesc());
//                    if(propImg.get(propValueVo.getName())!=null){
//                        propValueVo.setImgUrl(propImg.get(propValueVo.getName()));
//                    }
//                    propValueVos.add(propValueVo);
                }
            }
        }
        for(PropValueVo propValueVo:propValueVos){
            if(propValueVo.isSelected()){
                propValueVo.setFirstChange(true);
                break;
            }
        }
    }

    private String replace(String s, String propName) {
        String[] ss=propName.split(",");
        StringBuilder ns= new StringBuilder();
        for(int i=0;i<ss.length;i++){
            if(ss[i].equals(s)){
                continue;
            }
            ns.append(ss[i]).append(",");
        }
        propName=ns.toString();
        if(propName.endsWith(",")){
            propName=propName.substring(0,propName.length()-1);
        }
        return propName;
    }

    /**
     * 计算sku
     *
     * @param color 颜色
     * @param sales 其它销售属性
     * @return
     */
    public List<SkuVO> calculateSku(PropItemVo color, List<PropItemVo> sales) throws CloneNotSupportedException {
        PropItemVo colorSelected = null;
        if (color != null) {
            colorSelected = (PropItemVo) color.clone();
            List<PropValueVo> colorSelectedPV = new ArrayList<>();
            //把已选的循环出来
            for (PropValueVo pvv : color.getValues()) {
                if (pvv.isSelected()) {
                    colorSelectedPV.add(pvv);
                }
            }
            //颜色属性没有选择,无法生成sku
            if (colorSelectedPV.size() == 0) {
                return null;
            } else {
                colorSelected.setValues(colorSelectedPV);
            }
        }
        //对普通销售属性做筛选
        List<PropItemVo> salesselected = new ArrayList<>();
        //有可能没有销售属性
        if (sales != null)
            for (PropItemVo s : sales) {
                PropItemVo st = (PropItemVo) s.clone();
                List<PropValueVo> stpvv = new ArrayList<>();
                if (st.getValues() == null) {
                    st.setValues(new ArrayList<PropValueVo>());
                }
                for (PropValueVo pvv : st.getValues()) {
                    if (pvv.isSelected()) {
                        stpvv.add(pvv);
                    }
                }
                //如果这个销售属性没选,无法生成SKU
                if (stpvv.size() == 0) {
                    return null;
                } else {
                    st.setValues(stpvv);
                    salesselected.add(st);
                }
            }
        //如果color没有,sales也没有,那么直接不用算
        if (colorSelected == null && salesselected.size() == 0) {
            return null;
        }
        //开始正式计算
        //先判断有没有颜色
        SkuRankVO srv = null;
        if (colorSelected == null) {
            srv = calculateSkuRank(salesselected.remove(0), salesselected, false, "");
        } else {
            srv = calculateSkuRank(colorSelected, salesselected, true, "");
        }
        //计算表头
        SkuVO head = new SkuVO();
        head.setType(1);
        if (colorSelected != null) {
            head.add(new TdVO(colorSelected.getPid(), colorSelected.getName()));
        }
        for (PropItemVo s : salesselected) {
            head.add(new TdVO(s.getPid(), s.getName()));
        }
        List<SkuVO> skus = srv.parseToSkuVO();
        //把表头插入
        if (skus != null) {
            skus.add(0, head);
        }
        return skus;
    }

    /**
     * 比如nowdo传入的是颜色列,那么最终返回应该是颜色列之后的所有列,包括颜色列
     * 如果传入的是第二列,那么最终返回应该是第二列以后的所有列
     * 计算本列之后所有列
     *
     * @param nowdo   当前要处理的列
     * @param sales   销售属性
     * @param iscolor 是否颜色
     * @param idsPath 前景id串
     * @return
     */
    public SkuRankVO calculateSkuRank(PropItemVo nowdo, List<PropItemVo> sales, boolean iscolor, String idsPath) {
        //如果没有剩余销售属性了
        int rowspan = 1;
        if (sales.size() > 0) {
            //需要计算rowspan
            for (PropItemVo piv : sales) {
                rowspan *= piv.getValues().size();
            }
        }
        SkuRankVO srv = new SkuRankVO();
        for (PropValueVo pvv : nowdo.getValues()) {
            String idkey = null;
            if ("".equals(idsPath)) {
                idkey = nowdo.getPid() + "-" + pvv.getVid();
            } else {
                idkey = idsPath + "_" + nowdo.getPid() + "-" + pvv.getVid();
            }
            TdVO td = new TdVO();
            td.setRowspan(rowspan);
            td.setValue(pvv.getName());
            td.setVid(pvv.getVid());
            td.setIds(idkey);
            td.setColor(iscolor);
            td.setPid(nowdo.getPid());
            //这个td屁股后面跟的td们
            if (sales.size() > 0) {
                td.setSkuRankVO(calculateSkuRank(sales.get(0), sales.subList(1, sales.size()), false, idkey));
            }
            srv.add(td);
        }
        return srv;
    }
}
