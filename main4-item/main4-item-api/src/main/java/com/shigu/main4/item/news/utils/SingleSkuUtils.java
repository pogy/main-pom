package com.shigu.main4.item.news.utils;

import com.aliyun.opensearch.sdk.dependencies.org.apache.commons.lang.StringEscapeUtils;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.bo.TaobaoPropValueBO;
import com.shigu.main4.item.bo.news.SingleSkuBO;
import com.shigu.main4.item.vo.CatColorSizeVO;
import com.shigu.main4.item.vo.SinglePropVO;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SingleSkuUtils {
    public static List<SingleSkuBO> dealProps(String propName, String propertyAlias, List<TaobaoPropValueBO> propValues) {
        propertyAlias = propertyAlias == null ? "" : StringEscapeUtils.unescapeHtml(propertyAlias);
        String[] tas = propertyAlias.split(";");
        StringBuilder propertyAliasBuilder = new StringBuilder();
        for (String a : tas) {
            String[] as = a.split(":");
            //如果单段字符窜分割后,长度为2且两个都是Long型,可以认为是"20549:28389:"这类数据,别名的值为空字符串,该类数据抛弃
            if (as.length == 2 && isLong(as[0]) && isLong(as[1])) {
                continue;
            }
            //如果长度为3,且前两个都是Long型,认为是标准的别名值
            if (as.length == 3 && isLong(as[0]) && isLong(as[1])) {
                propertyAliasBuilder.append(a).append(";");
            } else {
                //剩余的则认为是别名中存在";"导致形成错误的分割,重新进行组合,将分割符转为"&"
                //propertyAlias的长度为0,意味着一开始就是错误的,抛弃
                if (propertyAliasBuilder.length() == 0) {
                    continue;
                }
                //剔除上一个循环添加上的最后一个";"
                propertyAliasBuilder = new StringBuilder(
                        propertyAliasBuilder.substring(0, propertyAliasBuilder.length() - 1) + "&" + a + ";");
            }
        }
        propertyAlias = propertyAliasBuilder.toString();
        propName = propName == null ? "" : StringEscapeUtils.unescapeHtml(propName);
        String[] tps = propName.split(";");
        StringBuilder propNameBuilder = new StringBuilder();
        for (String p : tps) {
            String[] ps = p.split(":");
            //如果长度为4,且前两个都是Long型,认为是标准的别名值
            if (ps.length == 4 && isLong(ps[0]) && isLong(ps[1])) {
                propNameBuilder.append(p).append(";");
            } else {
                //剩余的则认为是别名中存在";"导致形成错误的分割,重新进行组合,将分割符转为"&"
                //propName,意味着一开始就是错误的,抛弃
                if (propNameBuilder.length() == 0) {
                    continue;
                }
                //剔除上一个循环添加上的最后一个";"
                propNameBuilder = new StringBuilder(
                        propNameBuilder.substring(0, propNameBuilder.length() - 1) + "&" + p + ";");
            }
        }
        propName = propNameBuilder.toString();
        List<String> propNames = Arrays.asList(propName.split(";"));
        Map<String, String> propertyAliass = new HashMap<>();

        String[] propertyAliasStrs = propertyAlias.split(";");
        for(String s:propertyAliasStrs){
            if(StringUtils.isNotBlank(s)&& !s.trim().endsWith(":")){
                String[] ps = s.split(":");
                propertyAliass.put(ps[0] + ":" + ps[1], ps[2]);
            }
        }
        List<Long> pids = new ArrayList<>();
        pids.add(-1L);
        CatColorSizeVO catColorSizeVO=new CatColorSizeVO();
        Map<Long, TaobaoPropValueBO> colors = new HashMap<>();
        Map<Long, TaobaoPropValueBO> sizes = new HashMap<>();
        for(TaobaoPropValueBO taobaoPropValue:propValues){
            if (taobaoPropValue.getIsColor()) {
                colors.put(taobaoPropValue.getVid(), taobaoPropValue);
                catColorSizeVO.setColorPid(taobaoPropValue.getPid());
            } else {
                sizes.put(taobaoPropValue.getVid(), taobaoPropValue);
                catColorSizeVO.setSizePid(taobaoPropValue.getPid());
            }
            pids.add(taobaoPropValue.getPid());
        }

        List<SinglePropVO> vos = new ArrayList<>();
        for(String s:propNames){
            if(StringUtils.isNotBlank(s)){
                String[] ps = s.split(":");
                if (ps.length != 4) {
                    continue;
                }
                Long tmpPid = new Long(ps[0]);
                if (!pids.contains(tmpPid)) {
                    continue;
                }
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(tmpPid);
                vo.setVid(new Long(ps[1]));
                vo.setPname(ps[2]);
                String alias = propertyAliass.get(vo.getPid() + ":" + vo.getVid());
                if (alias != null) {
                    if (vo.getPid().equals(catColorSizeVO.getColorPid())) {
                        if (dealValueByName(colors, alias, vo)) {
                            vos.add(vo);
                           continue;
                        }
                        vo.setAliasName(alias);
                    } else {
                        if (dealValueByName(sizes, alias, vo)) {
                            vos.add(vo);
                            continue;
                        }
                        vo.setAliasName(alias);
                    }
                }
                if (tmpPid.equals(catColorSizeVO.getColorPid())) {
                    if (colors.keySet().contains(vo.getVid())) {
                        vo.setVname(ps[3]);
                    } else {
                        if (dealValueByName(colors, ps[3], vo)) {
                            vos.add(vo);
                            continue;
                        }
                        vo.setInputName(ps[3]);
                    }
                    colors.remove(vo.getVid());
                } else {
                    if (sizes.keySet().contains(vo.getVid())) {
                        vo.setVname(ps[3]);
                    } else {
                        if (dealValueByName(sizes, ps[3], vo)) {
                            vos.add(vo);
                            continue;
                        }
                        vo.setInputName(ps[3]);
                    }
                    sizes.remove(vo.getVid());
                }
                vos.add(vo);
            }
        }
        //取出颜色
        List<SinglePropVO> colorVOS = new ArrayList<>();
        for(SinglePropVO singlePropVO:vos){
            if(singlePropVO.getPid().equals(catColorSizeVO.getColorPid())){
                colorVOS.add(singlePropVO);
            }
        }
        //如果不存在颜色,添加一个"图片色"
        if (colorVOS.size() == 0 && catColorSizeVO.getColorPid() != null && colors.size() > 0) {
            try {
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(catColorSizeVO.getColorPid());
                vo.setInputName("图片色");
                colorVOS.add(vo);
            } catch (Exception ignored) {
            }
        }
        //取出尺码
        List<SinglePropVO> sizeVOS = new ArrayList<>();
        for(SinglePropVO singlePropVO:vos){
            if(singlePropVO.getPid().equals(catColorSizeVO.getSizePid())){
                sizeVOS.add(singlePropVO);
            }
        }
        //如果没有尺码,添加一个"均码"
        if (sizeVOS.size() == 0 && catColorSizeVO.getSizePid() != null && sizes.size() > 0) {
            try {
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(catColorSizeVO.getSizePid());
                vo.setInputName("均码");
                sizeVOS.add(vo);
            } catch (Exception ignored) {
            }
        }
        //获取剩余的颜色
        Map<Long, TaobaoPropValueBO> surplusColors = new HashMap<>(colors);
        for(SinglePropVO singlePropVO:colorVOS){
            if (singlePropVO.getInputName() == null) {
                surplusColors.remove(singlePropVO.getVid());
            }
        }
        //获取剩余尺码
        Map<Long, TaobaoPropValueBO> surplusSizes = new HashMap<>(sizes);
        for(SinglePropVO singlePropVO:sizeVOS){
            if (singlePropVO.getInputName() == null) {
                surplusSizes.remove(singlePropVO.getVid());
            }
        }
        //转化自定义颜色
        for(SinglePropVO singlePropVO:colorVOS){
            if (singlePropVO.getInputName() != null) {
                if (surplusColors.size() > 0) {
                    inputDeal(singlePropVO, surplusColors);
                }
            }
        }
        //转化自定义尺码
        for(SinglePropVO singlePropVO:sizeVOS){
            if (singlePropVO.getInputName() != null) {
                if (surplusSizes.size() > 0) {
                    inputDeal(singlePropVO, surplusSizes);
                }
            }
        }
        //转化为写入数据库对象
        List<SingleSkuBO> skuVOS = new ArrayList<>();
        if (colorVOS.size() > 0) {
            for(SinglePropVO c:colorVOS){
                if (sizeVOS.size() > 0) {
                    for(SinglePropVO s:sizeVOS){
                        SingleSkuBO v = new SingleSkuBO();
                        v.setColorVid(c.getVid());
                        v.setColorAlias(c.getAliasName());
                        v.setSizeVid(s.getVid());
                        v.setSizeAlias(s.getAliasName());
                        v.setStockNum(999);
                        skuVOS.add(v);
                    }
                } else {
                    SingleSkuBO v = new SingleSkuBO();
                    v.setColorVid(c.getVid());
                    v.setColorAlias(c.getAliasName());
                    v.setSizeVid(0L);
                    v.setSizeAlias("均码");
                    v.setStockNum(999);
                    skuVOS.add(v);
                }
            }
        } else {
            if (sizeVOS.size() > 0) {
                for(SinglePropVO s:sizeVOS){
                    SingleSkuBO v = new SingleSkuBO();
                    v.setColorVid(0L);
                    v.setColorAlias("图片色");
                    v.setSizeVid(s.getVid());
                    v.setSizeAlias(s.getAliasName());
                    v.setStockNum(999);
                    skuVOS.add(v);
                }
            } else {
                SingleSkuBO v = new SingleSkuBO();
                v.setColorVid(0L);
                v.setColorAlias("图片色");
                v.setSizeVid(0L);
                v.setSizeAlias("均码");
                v.setStockNum(999);
                skuVOS.add(v);
            }

        }

        return skuVOS;
    }

    private static void inputDeal(SinglePropVO singlePropVO, Map<Long, TaobaoPropValueBO> surplus) {
        List<TaobaoPropValueBO> taobaoPropValues = new ArrayList<>();
        for(TaobaoPropValueBO taobaoPropValue1:surplus.values()){
            if(taobaoPropValue1.getName().equals(singlePropVO.getInputName())){
                taobaoPropValues.add(taobaoPropValue1);
            }
        }
        TaobaoPropValueBO taobaoPropValue;
        if (taobaoPropValues.size() == 0) {
            taobaoPropValue = surplus.values().iterator().next();
        } else {
            taobaoPropValue = taobaoPropValues.get(0);
        }
        singlePropVO.setAliasName(singlePropVO.getInputName());
        singlePropVO.setVid(taobaoPropValue.getVid());
        singlePropVO.setVname(taobaoPropValue.getName());
        singlePropVO.setPid(taobaoPropValue.getPid());
        singlePropVO.setPname(taobaoPropValue.getPropName());
        singlePropVO.setInputName(null);
        surplus.remove(taobaoPropValue.getVid());
    }

    /**
     * 尝试用vname匹配属性值,如果匹配上,这直接使用改属性值替换原来的别名或自定义名
     *
     * @param map
     * @param name
     * @param vo
     * @return
     */
    private static boolean dealValueByName(Map<Long, TaobaoPropValueBO> map, String name, SinglePropVO vo) {
        Map<String, TaobaoPropValueBO> names = BeanMapper.list2Map(map.values(), "name", String.class);
        if (names.keySet().contains(name)) {
            TaobaoPropValueBO tv = names.get(name);
            vo.setVid(tv.getVid());
            vo.setVname(tv.getName());
            map.remove(tv.getVid());
            return true;
        }
        return false;
    }
    private static boolean isLong(String str) {
        try {
            new Long(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void callSkus(List<SingleSkuBO> singleSkuBOS, List<TbSku> skus,Long colorPid,Long sizePid){
        if(skus==null||skus.size()==0||singleSkuBOS.size()==0){
            return;
        }
        for(TbSku sku:skus){
            String propertiesName = sku.getPropertiesName();
            String[] pvs = propertiesName.split(";");
            String color=null;
            String size=null;
            String colorVid=null;
            String sizeVid=null;
            for(String pv:pvs){
                String[] props=pv.split(":");
                if(props.length!=4){
                    continue;
                }
                Long pid=new Long(props[0]);
                if(pid.equals(colorPid)){
                    color=props[3];
                    colorVid=props[1];
                }
                if(pid.equals(sizePid)){
                    size=props[3];
                    sizeVid=props[1];
                }
            }
            if(color==null&&colorPid!=null){
                color="图片色";
            }
            if(size==null&&sizePid!=null){
                size="均码";
            }
            //先用vid组合去匹配
            boolean haveVid=false;
            for(SingleSkuBO singleSkuBO:singleSkuBOS){
                if((singleSkuBO.getColorVid()+"_"+singleSkuBO.getSizeVid()).equals(colorVid+"_"+sizeVid)){
                    if("delete".equals(sku.getStatus())){
                        singleSkuBO.setStockNum(0);
                    }else{
                        singleSkuBO.setStockNum(sku.getQuantity().intValue());
                    }
                    singleSkuBO.setPriceString(MoneyUtil.dealPrice(MoneyUtil.StringToLong(sku.getPrice())));
                    haveVid=true;
                    break;
                }
            }
            //如果用vid组合匹配失败,意味着vname可能原来是自定义,但被转化成别名了,于是vid发生改变,这是用vname组合进行匹配
            if(!haveVid){
                for(SingleSkuBO singleSkuBO:singleSkuBOS){
                    if((singleSkuBO.getColorAlias()+"_"+singleSkuBO.getSizeAlias()).equals(color+"_"+size)){
                        if("delete".equals(sku.getStatus())){
                            singleSkuBO.setStockNum(0);
                        }else{
                            singleSkuBO.setStockNum(sku.getQuantity().intValue());
                        }
                        singleSkuBO.setPriceString(MoneyUtil.dealPrice(MoneyUtil.StringToLong(sku.getPrice())));
                        break;
                    }
                }
            }
        }
    }

    public static List<TbSku> calTbSkus(String singSkus){
        List<TbSku> tbSkus=new ArrayList<>();
        if(StringUtils.isNotBlank(singSkus)){
            String[] skuStrs=singSkus.split(";");
            for(String skuStr:skuStrs){
                String[] strs=skuStr.split(":");
                if(strs.length==7){
                    TbSku tbSku=new TbSku();
                    tbSku.setPrice(strs[0]);
                    tbSku.setStatus("normal");
                    tbSku.setQuantity(new Long(strs[1]));
                    tbSku.setPropertiesName(strs[3]+":"+strs[4]+":"+strs[5]+":"+strs[6]);
                    tbSkus.add(tbSku);
                }
                if(strs.length==4&&tbSkus.size()>0){
                    TbSku tbSku=tbSkus.get(tbSkus.size()-1);
                    tbSku.setPropertiesName(tbSku.getPropertiesName()+";"+strs[0]+":"+strs[1]+":"+strs[2]+":"+strs[3]);
                }
            }
        }
        return tbSkus;
    }
}
