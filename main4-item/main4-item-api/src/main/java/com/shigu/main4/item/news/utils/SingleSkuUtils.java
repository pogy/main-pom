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
        for (String s : propertyAliasStrs) {
            if (StringUtils.isNotBlank(s) && !s.trim().endsWith(":")) {
                String[] ps = s.split(":");
                propertyAliass.put(ps[0] + ":" + ps[1], ps[2]);
            }
        }
        List<Long> pids = new ArrayList<>();
        pids.add(-1L);
        CatColorSizeVO catColorSizeVO = new CatColorSizeVO();
        Map<Long, TaobaoPropValueBO> colors = new HashMap<>();
        Map<Long, TaobaoPropValueBO> sizes = new HashMap<>();
        for (TaobaoPropValueBO taobaoPropValue : propValues) {
            if (taobaoPropValue.getIsColor()) {
                colors.put(taobaoPropValue.getVid(), taobaoPropValue);
                catColorSizeVO.setColorPid(taobaoPropValue.getPid());
            } else {
                sizes.put(taobaoPropValue.getVid(), taobaoPropValue);
                catColorSizeVO.setSizePid(taobaoPropValue.getPid());
            }
            pids.add(taobaoPropValue.getPid());
        }
        Long lastInputVid=-1001L;
        List<SinglePropVO> vos = new ArrayList<>();
        for (String s : propNames) {
            if (StringUtils.isNotBlank(s)) {
                String[] ps = s.split(":");
                if (ps.length != 4) {
                    continue;
                }
                Long tmpPid = new Long(ps[0]);
                Long tmpVid=new Long(ps[1]);
                if(tmpVid<0L){
                    if(tmpVid<lastInputVid){
                        lastInputVid=tmpVid;
                    }
                }
                if (!pids.contains(tmpPid)) {
                    continue;
                }
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(tmpPid);
                vo.setVid(tmpVid);
                vo.setPname(ps[2]);
                String alias = propertyAliass.get(vo.getPid() + ":" + vo.getVid());
                if (alias != null) {
                    vo.setAliasName(alias);
                }
                if (tmpPid.equals(catColorSizeVO.getColorPid())) {
                    if (colors.keySet().contains(vo.getVid())) {
                        vo.setVname(ps[3]);
                    } else {
                        vo.setInputName(ps[3]);
                    }
                    colors.remove(vo.getVid());
                } else {
                    if (sizes.keySet().contains(vo.getVid())) {
                        vo.setVname(ps[3]);
                    } else {
                        vo.setInputName(ps[3]);
                    }
                    sizes.remove(vo.getVid());
                }
                vos.add(vo);
            }
        }
        //取出颜色
        List<SinglePropVO> colorVOS = new ArrayList<>();
        for (SinglePropVO singlePropVO : vos) {
            if (singlePropVO.getPid().equals(catColorSizeVO.getColorPid())) {
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
        for (SinglePropVO singlePropVO : vos) {
            if (singlePropVO.getPid().equals(catColorSizeVO.getSizePid())) {
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
        for (SinglePropVO singlePropVO : colorVOS) {
            if (singlePropVO.getInputName() == null) {
                surplusColors.remove(singlePropVO.getVid());
            }
        }
        //获取剩余尺码
        Map<Long, TaobaoPropValueBO> surplusSizes = new HashMap<>(sizes);
        for (SinglePropVO singlePropVO : sizeVOS) {
            if (singlePropVO.getInputName() == null) {
                surplusSizes.remove(singlePropVO.getVid());
            }
        }
        //转化为写入数据库对象
        List<SingleSkuBO> skuVOS = new ArrayList<>();
        if (colorVOS.size() > 0) {
            for(SinglePropVO c:colorVOS){
                if (sizeVOS.size() > 0) {
                    for(SinglePropVO s:sizeVOS){
                        SingleSkuBO v = new SingleSkuBO();
                        v.setColorPid(c.getPid());
                        v.setColorVid(c.getVid());
                        v.setColorVname(c.getVname());
                        v.setColorAlias(c.getAliasName());
                        v.setColorInput(c.getInputName());
                        v.setSizePid(s.getPid());
                        v.setSizeVid(s.getVid());
                        v.setSizeVname(s.getVname());
                        v.setSizeAlias(s.getAliasName());
                        v.setSizeInput(s.getInputName());
                        v.setStockNum(999);
                        skuVOS.add(v);
                    }
                }else{
                    SingleSkuBO v = new SingleSkuBO();
                    v.setColorPid(c.getPid());
                    v.setColorVid(c.getVid());
                    v.setColorVname(c.getVname());
                    v.setColorAlias(c.getAliasName());
                    v.setColorInput(c.getInputName());
                    v.setStockNum(999);
                    skuVOS.add(v);
                }
            }
        } else {
            if (sizeVOS.size() > 0) {
                for(SinglePropVO s:sizeVOS){
                    SingleSkuBO v = new SingleSkuBO();
                    v.setSizePid(s.getPid());
                    v.setSizeVid(s.getVid());
                    v.setSizeVname(s.getVname());
                    v.setSizeAlias(s.getAliasName());
                    v.setSizeInput(s.getInputName());
                    v.setStockNum(999);
                    skuVOS.add(v);
                }
            }
        }
        return skuVOS;
    }
    private static boolean isLong(String str) {
        try {
            new Long(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void callSkus(List<SingleSkuBO> singleSkuBOS, List<TbSku> skus, Long colorPid, Long sizePid) {
        if (skus == null || skus.size() == 0 || singleSkuBOS.size() == 0) {
            return;
        }
        for (TbSku sku : skus) {
            String propertiesName = sku.getPropertiesName();
            String[] pvs = propertiesName.split(";");
            String colorVid = null;
            String sizeVid = null;
            for (String pv : pvs) {
                String[] props = pv.split(":");
                if (props.length != 4) {
                    continue;
                }
                Long pid = new Long(props[0]);
                if (pid.equals(colorPid)) {
                    colorVid = props[1];
                }
                if (pid.equals(sizePid)) {
                    sizeVid = props[1];
                }
            }
            //先用vid组合去匹配
            for (SingleSkuBO singleSkuBO : singleSkuBOS) {
                if ((singleSkuBO.getColorVid() + "_" + singleSkuBO.getSizeVid()).equals(colorVid + "_" + sizeVid)) {
                    if ("delete".equals(sku.getStatus())) {
                        singleSkuBO.setStockNum(0);
                    } else {
                        singleSkuBO.setStockNum(sku.getQuantity().intValue());
                    }
                    singleSkuBO.setPriceString(MoneyUtil.dealPrice(MoneyUtil.StringToLong(sku.getPrice())));
                    break;
                }
            }
        }
    }

    public static List<TbSku> calTbSkus(String singSkus) {
        List<TbSku> tbSkus = new ArrayList<>();
        if (StringUtils.isNotBlank(singSkus)) {
            String[] skuStrs = singSkus.split(";");
            for (String skuStr : skuStrs) {
                String[] strs = skuStr.split(":");
                if (strs.length == 7) {
                    TbSku tbSku = new TbSku();
                    tbSku.setPrice(strs[0]);
                    tbSku.setStatus("normal");
                    tbSku.setQuantity(new Long(strs[1]));
                    tbSku.setPropertiesName(strs[3] + ":" + strs[4] + ":" + strs[5] + ":" + strs[6]);
                    tbSkus.add(tbSku);
                }
                if (strs.length == 4 && tbSkus.size() > 0) {
                    TbSku tbSku = tbSkus.get(tbSkus.size() - 1);
                    tbSku.setPropertiesName(
                            tbSku.getPropertiesName() + ";" + strs[0] + ":" + strs[1] + ":" + strs[2] + ":" + strs[3]);
                }
            }
        }
        return tbSkus;
    }
}
