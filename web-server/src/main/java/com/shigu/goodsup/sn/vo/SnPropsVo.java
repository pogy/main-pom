package com.shigu.goodsup.sn.vo;

import com.alibaba.fastjson.JSONObject;
import com.shigu.goodsup.sn.vo.PropItemVo;
import com.shigu.goodsup.sn.vo.PropValueVo;
import com.shigu.goodsup.jd.vo.SkuVO;
import com.shigu.tb.finder.util.UnicodeUtil;
import com.shigu.tb.finder.vo.PropType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SnPropsVo implements Serializable{
    private static final long serialVersionUID = -7969611165515125165L;
    /**
     * 普通属性
     * 不包含颜色尺码等销售属性
     */
    private List<PropItemVo> properties;
    /**
     * 品牌
     */
    private PropItemVo pingpai;
    /**
     * 颜色属性
     */
    private PropItemVo color;
    /**
     * 除颜色以外的销售属性
     */
    private List<PropItemVo> saleProps;

    private List<PropItemVo> specification;
    /**
     * 列表SKU信息
     * 如果是null说明没有生成sku
     */
    private List<SkuVO> skus;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 原始的色码json
     */
    private String colorSizeDefault;

    /**
     * 深度克隆
     * @return
     */
    public SnPropsVo deepClone() throws IOException, ClassNotFoundException {
        //将对象写到流里
        ByteArrayOutputStream bo=new ByteArrayOutputStream();
        ObjectOutputStream oo=new ObjectOutputStream(bo);
        oo.writeObject(this);
        //从流里读出来
        ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi=new ObjectInputStream(bi);
        SnPropsVo propsVO=(SnPropsVo) (oi.readObject());
        //把老的色码放好
        propsVO.colorSizeDefault=this.calColorSizeDefault();
        return propsVO;
    }

    /**
     * 得到成份的pid
     * 为了给wsy抓来的页面用
     * @return
     */
    public String getComponentPid(){
        for(PropItemVo piv:properties){
            if(piv.getType().equals(PropType.MATERIAL)){
                return piv.getPid().toString();
            }
        }
        return "";
    }

    /**
     * 得到尺码PID
     * 为了给wsy抓来的页面用
     * @return
     */
    public String getSizePid(){
        if(saleProps!=null){
            for(PropItemVo piv:saleProps){
                if("尺码".equals(piv.getName())||"尺寸".equals(piv.getName())||piv.getPid().equals(20509L)){
                    return piv.getPid().toString();
                }
            }
        }
        return "";
    }

    /**
     * 计算原始色码串
     * 为了给wsy抓来的页面用
     * @return
     */
    public String calColorSizeDefault(){
        JSONObject obj= new JSONObject();
        if(color!=null){
            for(PropValueVo pvv:color.getValues()){
                if(pvv.getVid()!=null&&pvv.getVid()>0&&pvv.getName()!=null)
                    obj.put(pvv.getVid().toString(), UnicodeUtil.string2Unicode(pvv.getName()));
            }
        }
        if(saleProps!=null){
            for(PropItemVo piv:saleProps){
                if(piv.getValues()!=null)
                    for(PropValueVo pvv:piv.getValues()){
                        if(pvv.getVid()!=null&&pvv.getVid()>0&&pvv.getName()!=null)
                            obj.put(pvv.getVid().toString(), UnicodeUtil.string2Unicode(pvv.getName()));
                    }
            }
        }
        return obj.toString().replace("\"","'").replace("\\\\","\\");
    }

    public String getColorSizeDefault() {
        return colorSizeDefault;
    }

    public void setColorSizeDefault(String colorSizeDefault) {
        this.colorSizeDefault = colorSizeDefault;
    }

    public PropItemVo getPingpai() {
        return pingpai;
    }

    public void setPingpai(PropItemVo pingpai) {
        this.pingpai = pingpai;
    }

    /**
     * 添加一个普通属性
     * @param piv
     */
    public void addProperties(PropItemVo piv){
        if(properties==null){
            properties=new ArrayList<PropItemVo>();
        }
        properties.add(piv);
    }

    /**
     * 添加一个除颜色以外的销售属性
     * @param piv
     */
    public void addSaleProps(PropItemVo piv){
        if(saleProps==null){
            saleProps=new ArrayList<PropItemVo>();
        }
        saleProps.add(piv);
    }

    public List<SkuVO> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuVO> skus) {
        this.skus = skus;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public List<PropItemVo> getProperties() {
        return properties;
    }

    public void setProperties(List<PropItemVo> properties) {
        this.properties = properties;
    }

    public PropItemVo getColor() {
        return color;
    }

    public void setColor(PropItemVo color) {
        this.color = color;
    }

    public List<PropItemVo> getSaleProps() {
        return saleProps;
    }

    public void setSaleProps(List<PropItemVo> saleProps) {
        this.saleProps = saleProps;
    }

    public List<PropItemVo> getSpecification() {
        return this.specification;
    }

    public void setSpecification(List<PropItemVo> specification) {
        this.specification = specification;
    }
}
