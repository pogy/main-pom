package com.shigu.goodsup.jd.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.TaobaoItemProp;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.TaobaoItemPropExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.TaobaoItemPropMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.goodsup.jd.vo.*;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.tb.finder.vo.PropType;
import com.taobao.api.domain.ItemProp;
import com.taobao.api.domain.PropImg;
import com.taobao.api.domain.PropValue;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 属性操作服务
 * Created by zhaohongbo on 17/1/10.
 */
@Service
public class PropsService {

    private static final Logger log = LoggerFactory.getLogger(PropsService.class);

    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    private TaobaoItemPropMapper taobaoItemPropMapper;
    @Autowired
    EhCacheCacheManager ehCacheManager;
    @Autowired
    NewShowForCdnService newShowForCdnService;

    /**
     * 计算sku
     * @param color 颜色
     * @param sales 其它销售属性
     * @return
     */
    public List<SkuVO> calculateSku(PropertyItemVO color, List<PropertyItemVO> sales,Long itemId) throws CloneNotSupportedException {
        PropertyItemVO colorSelected=null;
        if(color!=null){
            colorSelected= (PropertyItemVO) color.clone();
            List<PropertyValueVO> colorSelectedPV=new ArrayList<>();
            //把已选的循环出来
            for(PropertyValueVO pvv:color.getValues()){
                if(pvv.isSelected()){
                    colorSelectedPV.add(pvv);
                }
            }
            //颜色属性没有选择,无法生成sku
            if(colorSelectedPV.size()==0){
                return null;
            }else{
                colorSelected.setValues(colorSelectedPV);
            }
        }
        //对普通销售属性做筛选
        List<PropertyItemVO> salesselected=new ArrayList<>();
        //有可能没有销售属性
        if(sales!=null)
        for(PropertyItemVO s:sales){
            PropertyItemVO st= (PropertyItemVO) s.clone();
            List<PropertyValueVO> stpvv=new ArrayList<>();
            if (st.getValues() == null) {
                st.setValues(new ArrayList<PropertyValueVO>());
            }
            for(PropertyValueVO pvv:st.getValues()){
                if(pvv.isSelected()){
                    stpvv.add(pvv);
                }
            }
            //如果这个销售属性没选,无法生成SKU
            if(stpvv.size()==0){
                return null;
            }else{
                st.setValues(stpvv);
                salesselected.add(st);
            }
        }
        //如果color没有,sales也没有,那么直接不用算
        if(colorSelected==null&&salesselected.size()==0){
            return null;
        }
        //开始正式计算
        //先判断有没有颜色
        SkuRankVO srv=null;
        if(colorSelected==null){
            srv=calculateSkuRank(salesselected.remove(0),salesselected,false,"");
        }else{
            srv=calculateSkuRank(colorSelected,salesselected,true,"");
        }
        addSingleSkuInfo(srv,itemId);
        //计算表头
        SkuVO head=new SkuVO();
        head.setType(1);
        if(colorSelected!=null){
            head.add(new TdVO(colorSelected.getPid(),colorSelected.getName()));
        }
        for(PropertyItemVO s:salesselected){
            head.add(new TdVO(s.getPid(),s.getName()));
        }
        List<SkuVO> skus=srv.parseToSkuVO();
        //把表头插入
        if(skus!=null){
            skus.add(0,head);
        }
        return skus;
    }
    private void addSingleSkuInfo(SkuRankVO srv, Long itemId){
        NewCdnItem newCdnItem = newShowForCdnService.selItemById(itemId);
        String price= StringUtils.isNotBlank(newCdnItem.getPrice()) ? newCdnItem.getPrice() : newCdnItem
                .getPiPrice();
        Long cprice = MoneyUtil
                .StringToLong(price) - MoneyUtil.StringToLong(newCdnItem.getPiPrice());
        Map<String,SingleSkuVO> skuMap=new HashMap<>();
        for(SingleSkuVO vo:newCdnItem.getSingleSkus()){
            String color= vo.getThisColor();
            String size= vo.getThisSize();
            skuMap.put(color+"_"+size,vo);
        }
        for(TdVO ctd:srv){
            String color=ctd.getValue();
            for(TdVO std:ctd.getSkuRankVO()){
                String size=std.getValue();
                SingleSkuVO singleSkuVO=skuMap.get(color+"_"+size);
                std.setSkuRankVO(new SkuRankVO());
                if(singleSkuVO!=null){
                    String skuPrice=MoneyUtil.dealPrice(MoneyUtil.StringToLong(singleSkuVO.getPriceString())+cprice);
                    std.getSkuRankVO().add(0,new TdVO(std.getPid(),std.getVid(),std.getIds(),skuPrice,true,false));
                    std.getSkuRankVO().add(1,new TdVO(std.getPid(),std.getVid(),std.getIds(),singleSkuVO.getStockNum()>0?"100":"0",false,true));
                }else{
                    std.getSkuRankVO().add(0,new TdVO(std.getPid(),std.getVid(),std.getIds(),price,true,false));
                    std.getSkuRankVO().add(1,new TdVO(std.getPid(),std.getVid(),std.getIds(),"100",false,true));
                }
            }
        }
    }

    /**
     * 比如nowdo传入的是颜色列,那么最终返回应该是颜色列之后的所有列,包括颜色列
     * 如果传入的是第二列,那么最终返回应该是第二列以后的所有列
     * 计算本列之后所有列
     * @param nowdo 当前要处理的列
     * @param sales 销售属性
     * @param iscolor 是否颜色
     * @param idsPath 前景id串
     * @return
     */
    public SkuRankVO calculateSkuRank(PropertyItemVO nowdo,List<PropertyItemVO> sales,boolean iscolor,String idsPath){
        //如果没有剩余销售属性了
        int rowspan=1;
        if(sales.size()>0){
            //需要计算rowspan
            for(PropertyItemVO piv:sales){
                rowspan*=piv.getValues().size();
            }
        }
        SkuRankVO srv=new SkuRankVO();
        for(PropertyValueVO pvv:nowdo.getValues()){
            String idkey=null;
            if("".equals(idsPath)){
                idkey=nowdo.getPid()+"-"+pvv.getVid();
            }else{
                idkey=idsPath+"_"+nowdo.getPid()+"-"+pvv.getVid();
            }
            TdVO td=new TdVO();
            td.setRowspan(rowspan);
            td.setValue(pvv.getName());
            td.setVid(pvv.getVid());
            td.setIds(idkey);
            td.setColor(iscolor);
            td.setPid(nowdo.getPid());
            //这个td屁股后面跟的td们
            if(sales.size()>0){
                td.setSkuRankVO(calculateSkuRank(sales.get(0),sales.subList(1,sales.size()),false,idkey));
            }
            srv.add(td);
        }
        return srv;
    }


    /**
     * 把taobaoPropValue转化成vo模式
     * @param tpvlist
     * @return
     */
    public List<PropertyValueVO> parseTaobaoPropValueToVO(List<PropValue> tpvlist){
        if(tpvlist==null){//空的就放过
            return null;
        }
        List<PropertyValueVO> valueVOs=new ArrayList<>();
        for(PropValue tpv:tpvlist){
            PropertyValueVO pvv=new PropertyValueVO();
            pvv.setName(tpv.getName());
            pvv.setOldName(tpv.getName());
            pvv.setVid(tpv.getVid());
            pvv.setFid(tpv.getIsParent()!=null&&tpv.getIsParent()?1:2);
            valueVOs.add(pvv);
        }
        return valueVOs;
    }

    /**
     * 把本地PropValue转化成vo模式
     * @param tpvlist
     * @return
     */
    private List<PropertyValueVO> parseLocalPropValueToVO(List<TaobaoPropValue> tpvlist){
        if(tpvlist==null){//空的就放过
            return null;
        }
        List<PropertyValueVO> valueVOs=new ArrayList<>();
        for(TaobaoPropValue tpv:tpvlist){
            PropertyValueVO pvv=new PropertyValueVO();
            pvv.setName(tpv.getName());
            pvv.setVid(tpv.getVid());
            pvv.setFid(tpv.getIsParent() != null && tpv.getIsParent()==1?1:2);
            valueVOs.add(pvv);
        }
        return valueVOs;
    }

    /**
     * 计算属性元素的类型
     * @param isEnumProp 是否枚举属性。可选值:true(是),false(否)
     *                   (删除的属性不会匹配和返回这个条件)。如果返回true，
     *                   属性值是下拉框选择输入，如果返回false，属性值是用户自行手工输入。
     * @param isItemProp
     * @param isMerial 是否材质
     * @param multi 发布产品或商品时是否可以多选。可选值:true(是),false(否)
     * @param isInputProp 在is_enum_prop是true的前提下，是否是卖家可以自行输入的属性
     *                    （注：如果is_enum_prop返回false，该参数统一返回false）。
     *                    可选值:true(是),false(否) (删除的属性不会匹配和返回这个条件)
     * @return
     */
    public PropType selType(boolean isEnumProp,boolean isItemProp,boolean isMerial,boolean multi,boolean isInputProp){
        if(isMerial){
            return PropType.MATERIAL;
        }
        if(multi){
            return PropType.CHECKBOX;
        }
        if(!isEnumProp||isInputProp&&!isItemProp){
            return PropType.INPUT;
        }
        return PropType.SELECT;
    }

    /**
     * 商品带的属性
     */
    class ItemProValue{

        public ItemProValue() {
        }

        public ItemProValue(Long vid) {
            this.vid = vid;
        }

        public ItemProValue(Long vid, String aliasName) {
            this.vid = vid;
            this.aliasName = aliasName;
        }

        /**
         * 值ID,如果是input的,这个为null
         */
        private Long vid;
        /**
         * 别名
         */
        private String aliasName;

        public Long getVid() {
            return vid;
        }

        public void setVid(Long vid) {
            this.vid = vid;
        }

        public String getAliasName() {
            return aliasName;
        }

        public void setAliasName(String aliasName) {
            this.aliasName = aliasName;
        }
    }

    /**
     * 临时处理对象
     * 处理二级类目
     */
    class TempErProp extends HashMap<Long,List<PropertyValueVO>>{
        /**
         * 按pid和vid初始化
         * @param pid
         * @param vid
         */
        public void addSelByPidandVid(Long pid,Long vid){
            List<PropertyValueVO> list=this.get(pid);
            //如果之前没有,加一下
            if(list==null){
                list=new ArrayList<>();
                this.put(pid,list);
            }
            PropertyValueVO pvv=new PropertyValueVO();
            pvv.setVid(vid);
            pvv.setSelected(true);
            if(list.contains(pvv)){//之前有了
                list.get(list.indexOf(pvv)).noNullAdd(pvv);//更新一下
            }else{
                list.add(pvv);
            }
        }

        /**
         * 按pid和vid取propertyValueVO
         * @param pid
         * @param vid
         * @return
         */
        public PropertyValueVO getByPidandVid(Long pid,Long vid){
            List<PropertyValueVO> list=this.get(pid);
            if(list==null){
                return null;
            }
            PropertyValueVO pvv=new PropertyValueVO();
            pvv.setVid(vid);
            //如果刚好有,则返回
            if(list.contains(pvv)){
                return list.get(list.indexOf(pvv));
            }
            return null;
        }
    }

    /**
     * 临时处理对象
     * 处理其它类目
     */
    class TempOtProp extends HashMap<Long,List<Long>>{
        /**
         * 按piv和vid初始化
         * @param pid
         * @param vid
         */
        public void addByPidandVid(Long pid,Long vid){
            List<Long> list=this.get(pid);
            if(list==null){
                list=new ArrayList<>();
                this.put(pid,list);
            }
            if(!list.contains(vid)){
                list.add(vid);
            }
        }

        /**
         * 按pid扔出一个vid
         * @return
         */
        public Long popOneVid(Long pid){
            List<Long> list=this.get(pid);
            if(list==null||list.size()==0){
                return null;
            }
            Long vid=list.remove(0);
            if(list.size()==0){//如果移完了,就把list也去掉
                this.remove(pid);
            }
            return vid;
        }

        /**
         * 放回到第一个里面
         * @param pid
         * @param vid
         */
        public void pushVidFirst(Long pid,Long vid){
            List<Long> list=this.get(pid);
            if(list==null){
                list=new ArrayList<>();
                this.put(pid,list);
            }
            list.add(0,vid);
        }
    }

    private List<ItemProp> selItemProp(Long cid){
        TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
        taobaoItemPropExample.createCriteria().andCidEqualTo(cid);
        List<TaobaoItemProp> taobaoItemProps=taobaoItemPropMapper.selectByExample(taobaoItemPropExample);
        TaobaoPropValueExample taobaoPropValueExample=new TaobaoPropValueExample();
        taobaoPropValueExample.createCriteria().andCidEqualTo(cid).andPropNameNotEqualTo("品牌");
        List<TaobaoPropValue> taobaoPropValues=taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
        Map<Long,List<TaobaoPropValue>> longListMap=taobaoPropValues.stream().collect(Collectors.groupingBy(TaobaoPropValue::getPid));
        return taobaoItemProps.stream().map(taobaoItemProp -> {
            ItemProp p=new ItemProp();
            p.setChildTemplate(taobaoItemProp.getChildTemplate());
            p.setCid(taobaoItemProp.getCid());
            p.setIsAllowAlias(taobaoItemProp.getIsAllowAlias()==1);
            p.setIsColorProp(taobaoItemProp.getIsColorProp()==1);
            p.setIsEnumProp(taobaoItemProp.getIsEnumProp()==1);
            p.setIsInputProp(taobaoItemProp.getIsInputProp()==1);
            p.setIsItemProp(taobaoItemProp.getIsItemProp()==1);
            p.setIsKeyProp(taobaoItemProp.getIsKeyProp()==1);
            p.setIsMaterial(false);
            p.setIsSaleProp(taobaoItemProp.getIsSaleProp()==1);
            p.setMulti(taobaoItemProp.getMulti()==1);
            p.setMust(taobaoItemProp.getMust()==1);
            p.setName(taobaoItemProp.getName());
            p.setParentPid(taobaoItemProp.getParentPid());
            p.setParentVid(taobaoItemProp.getParentVid());
            p.setPid(taobaoItemProp.getPid());
            List<TaobaoPropValue> list=longListMap.get(taobaoItemProp.getPid());
            if(list!=null){
                p.setPropValues(list.stream().map(taobaoPropValue -> {
                    PropValue v=new PropValue();
                    v.setCid(p.getCid());
                    v.setIsParent(false);
                    v.setName(taobaoPropValue.getName());
                    v.setNameAlias(taobaoPropValue.getNameAlias());
                    v.setPid(taobaoPropValue.getPid());
                    v.setPropName(taobaoPropValue.getPropName());
                    v.setVid(taobaoPropValue.getVid());
                    return v;
                }).collect(Collectors.toList()));
            }

            return p;
        }).collect(Collectors.toList());
    }
}
