package com.shigu.main4.item.bo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提交上来的类目信息
 * Created by zhaohongbo on 17/1/19.
 */
public class SubmitedPropsBO implements Serializable{
    /**
     *  解析出上传用的数据
     * @param cp  cp[]:20518:28315
    cp[]:20518:28316
    cp[]:20518:28317
    cp[]:20518:6145171
    cp[]:20518:115781
     * @param skuProps
     * sku-props[]:13021751:HK06###
    sku-props[]:20000:other/其他###
    sku-props[]:42860829:20307554
    sku-props[]:122276111:20525
    sku-props[]:122216588:9431885
    sku-props[]:122216589:3267927
    sku-props[]:20021:-1
     * @param sku
     * sku[]:1627207-28334_20518-28315#100#110.00#灰色#M
    sku[]:1627207-28334_20518-28316#100#110.00#灰色#L
    sku[]:1627207-28334_20518-28317#100#110.00#灰色#XL
    sku[]:1627207-28334_20518-6145171#100#110.00#灰色#2XL
    sku[]:1627207-28334_20518-115781#100#110.00#灰色#3XL
    sku[]:1627207-28334_20518-3727387#100#110.00#灰色#4XL
    sku[]:1627207-28334_20518-7539404#100#110.00#灰色#5XL
    sku[]:1627207-28341_20518-28315#100#110.00#黑色#M
     * @param sizeColorDefault
     * {'28321':'\u4e73\u767d\u8272','28331':'\u5361\u5176\u8272','129819':'\u5496\u5561\u8272','80557':'\u58a8\
     * \u8272','15409374':'\u59dc\u9ec4\u8272','5138330':'\u5b54\u96c0\u84dd','3707775':'\u5b9d\u84dd\u8272',
     * '20412615':'\u660e\u9ec4\u8272','30155':'\u674f\u8272','132476':'\u67e0\u6aac\u9ec4','6071353':'\u6817\u8272'
     * ,'4950473':'\u6854\u7ea2\u8272','30158':'\u6d45\u68d5\u8272','4104877':'\u6d45\u7d2b\u8272',
     * '28337':'\u6d45\u84dd\u8272','6588790':'\u6df1\u68d5\u8272',
     *
     */
    public SubmitedPropsBO(String[] cp, String[] skuProps, String[] sku, JSONObject sizeColorDefault) {
        //sku系列
        StringBuffer skuPropertiesSb=new StringBuffer();
        StringBuffer skuQuantitiesSb=new StringBuffer();
        StringBuffer skuPricesSb=new StringBuffer();
        StringBuffer skuOuterIdsSb=new StringBuffer();
        //自定义系列
        StringBuffer inputStrSb=new StringBuffer();
        StringBuffer inputPidSb=new StringBuffer();
        //先拼props
        StringBuffer propsb=new StringBuffer();
        StringBuffer aliassb=new StringBuffer();
        //额外加
        StringBuffer cpvSb=new StringBuffer();
        if(cp!=null)
        for(String s:cp){
            propsb.append(s);
            propsb.append(";");
        }
        //从普通属性中取
        if(skuProps!=null)
        for(String sp:skuProps){
            //如果没选,就跳过
            if(sp.endsWith(":-1")){
                continue;
            }
            //如果值是非数字,说明要inputStr
            String pid=sp.substring(0,sp.indexOf(":"));
            String value=sp.substring(sp.indexOf(":")+1);
            //如果value不是数字
            if(!isNumeric(value)){
                inputPidSb.append(pid);
                inputPidSb.append(",");
                inputStrSb.append(value.replace("###",""));
                inputStrSb.append(",");
            }else{
                propsb.append(sp);
                propsb.append(";");
            }
        }
        //从sku里提取sku并判别是否重定义
        if(sku!=null)
        for(String su:sku){
            //分出ID、数量、价格、商家码
            String[] suarr=su.split("#");
            String ids=suarr[0];
            String quantities=suarr[1];
            String price=suarr[2];
            skuPropertiesSb.append(ids.replace("-",":").replace("_",";"));
            skuQuantitiesSb.append(quantities);
            skuPricesSb.append(price);
            //sku商家编码
            if(!su.endsWith("#")){
                skuOuterIdsSb.append(suarr[suarr.length-1]);
            }
            skuPropertiesSb.append(",");
            skuQuantitiesSb.append(",");
            skuPricesSb.append(",");
            skuOuterIdsSb.append(",");
            //处理属性被重写的问题
            String[] idsarr=ids.split("_");
            for(int i=0;i<idsarr.length;i++){
                String is=idsarr[i];
                String[] isarr=is.split("-");
                //如果基础里没有
//                String oldName=sizeColorDefault.getString(isarr[0]);
                try {
                    if(!sizeColorDefault.containsKey(isarr[1])){
                        //如果基础里没有,要加到csv里
                        cpvSb.append(is.replace("-",":")+":"+suarr[3+i]);
                        cpvSb.append(";");
                    }else if(!suarr[3+i].equals(sizeColorDefault.getString(isarr[1]))){
                        aliassb.append(is.replace("-",":")+":"+suarr[3+i]);
                        aliassb.append(";");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("计算csv错误"+sku,e);
                }
            }
        }
        this.inputPids=repairBuffer(inputPidSb,",");
        this.inputStr=repairBuffer(inputStrSb,",");
        this.inputCustomCpv=repairBuffer(cpvSb,";");
        this.propertyAlias=repairBuffer(aliassb,";");
        this.props=repairBuffer(propsb,";");
        this.skuOuterIds=repairBuffer(skuOuterIdsSb,",");
        this.skuPrices=repairBuffer(skuPricesSb,",");
        this.skuProperties=repairBuffer(skuPropertiesSb,",");
        this.skuQuantities=repairBuffer(skuQuantitiesSb,",");
    }

    /**
     * 判断是否数字
     * @param str
     * @return
     */
    private boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * 去分隔返回
     * @param sb
     * @param split
     * @return
     */
    private String repairBuffer(StringBuffer sb,String split){
        String result=sb.toString();
        if(result.endsWith(split)){
            return result.substring(0,result.length()-1);
        }
        return result;
    }
    /**
     *用户自行输入的类目属性ID串，结构："pid1,pid2,pid3"，如："20000"（表示品牌） 注：通常一个类目下用户可输入的关键属性不超过1个。
     */
    private String inputPids;
    /**
     * 用户自行输入的子属性名和属性值，结构:"父属性值;一级子属性名;一级子属性值;二级子属性名;自定义输入值,....",如：“耐克;耐克系列
     * ;科比系列;科比系列;2K5,Nike乔丹鞋;乔丹系列;乔丹鞋系列;乔丹鞋系列;json5”，多个自定义属性用','分割，input_str需要与input_pids
     * 一一对应，注：通常一个类目下用户可输入的关键属性不超过1个。所有属性别名加起来不能超过3999字节。此处不可以使用“其他”、“
     * 其它”和“其她”这三个词。
     */
    private String inputStr;
    /**
     * 商品属性列表。格式:pid:vid;pid:vid。属性的pid调用taobao.itemprops.get取得，属性值的vid用taobao.itempropvalues.
     * 。 如果该类目下面没有属性，可以不用填写。如果有属性，必选属性必填，其他非必选属性可以选择不填写.属性不能超过35对。所有属性
     * 加起来包括分割符不能超过549字节，单个属性没有限制。 如果有属性是可输入的话，则用字段input_str填入属性的值
     */
    private String props;
    /**
     * 属性值别名。如pid:vid:别名;pid1:vid1:别名1 ，其中：pid是属性id vid是属性值id。总长度不超过512字节
     */
    private String propertyAlias;
    /**
     * 更新的sku的属性串，调用taobao.itemprops.get获取。格式:pid1:vid;pid2:vid,多个sku属性之间用逗号分隔。
     * 该字段内的属性需要在props字段同时包含。如果新增商品包含了sku，则此字段一定要传入,字段长度要控制在512个字节以内。
     */
    private String skuProperties;
    /**
     * Sku的数量串，结构如：num1,num2,num3 如：2,3
     */
    private String skuQuantities;
    /**
     * Sku的价格串，结构如：10.00,5.00,… 精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String skuPrices;
    /**
     * Sku的外部id串，结构如：1234,1342,… sku_properties, sku_quantities, sku_prices,
     * sku_outer_ids在输入数据时要一一对应，如果没有sku_outer_ids也要写上这个参数，入参是","
     * (这个是两个sku的示列，逗号数应该是sku个数减1)；该参数最大长度是512个字节
     */
    private String skuOuterIds;
//    private String changeProp;
    /**
     * 针对当前商品的自定义属性值，目前是针对销售属性值自定义的，所以调用方需要把自定义属性值对应的
     * 虚拟属性值ID（负整数，例如例子中的 -1和-2）像标准属性值值的id一样设置到SKU上，如果自定义属
     * 性值有属性值图片，也要设置到属性图片上
     */
    private String inputCustomCpv;

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getSkuProperties() {
        return skuProperties;
    }

    public void setSkuProperties(String skuProperties) {
        this.skuProperties = skuProperties;
    }

    public String getSkuQuantities() {
        return skuQuantities;
    }

    public void setSkuQuantities(String skuQuantities) {
        this.skuQuantities = skuQuantities;
    }

    public String getSkuPrices() {
        return skuPrices;
    }

    public void setSkuPrices(String skuPrices) {
        this.skuPrices = skuPrices;
    }

    public String getSkuOuterIds() {
        return skuOuterIds;
    }

    public void setSkuOuterIds(String skuOuterIds) {
        this.skuOuterIds = skuOuterIds;
    }

    public String getInputCustomCpv() {
        return inputCustomCpv;
    }

    public void setInputCustomCpv(String inputCustomCpv) {
        this.inputCustomCpv = inputCustomCpv;
    }
}
