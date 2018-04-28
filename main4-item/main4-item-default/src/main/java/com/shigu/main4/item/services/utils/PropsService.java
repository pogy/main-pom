package com.shigu.main4.item.services.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.item.exceptions.TbException;
import com.shigu.main4.item.vo.*;
import com.taobao.api.ApiException;
import com.taobao.api.domain.ItemProp;
import com.taobao.api.domain.PropImg;
import com.taobao.api.domain.PropValue;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * 属性操作服务
 * Created by zhaohongbo on 17/1/10.
 */
@Service
public class PropsService {

    private static final Logger log = LoggerFactory.getLogger(PropsService.class);

    @Autowired
    TaobaoPropValueMapper taobaoPropValueMallMapper;

    @Autowired
    UpdatePropValueService updatePropValueService;

    @Autowired
    TaobaoUtil taobaoUtil;
    /**
     * 计算页面要显示的属性列
     * @param cid 类目ID
     * @return
     */
//    @Cacheable(value = "yj2prop.cache",key = "#cid")
    public PropsVO selProps(Long cid) throws ApiException, TbException {
        PropsVO propsVO=new PropsVO();
        propsVO.setCid(cid);
        //开始处理品牌
        List<ItemProp> itemPropresponse= taobaoUtil.selItemProp(cid, null);//去接口里面调,有可能等于null
        if(itemPropresponse==null){
            throw new TbException("获取淘宝标准类目失败");
        }
        for(ItemProp tip:itemPropresponse){
            PropertyItemVO piv=new PropertyItemVO();
            piv.setPid(tip.getPid());
            piv.setName(tip.getName());
            piv.setMustHave(tip.getMust());
            piv.setCanAlias(tip.getIsAllowAlias());
            piv.setType(selType(tip.getIsEnumProp(),tip.getIsItemProp(),tip.getIsMaterial(),tip.getMulti(),tip.getIsInputProp()));
            //**********************加值**************************
            if(tip.getPid().equals(20000L)){
                //如果是品牌,取出前20个,其余存数据库(如果数据库没有)
                piv.addPropValueList(parseTaobaoPropValueToVO(tip.getPropValues().subList(0, 20)));
                // 不存库
//                updatePropValueService.updatePropValue(cid, tip.getPid(), tip.getName(), tip.getPropValues());
            }else if(!piv.getType().equals(PropType.INPUT)){//不是输入框的情况下
                piv.addPropValueList(parseTaobaoPropValueToVO(tip.getPropValues()));
            }
            //放入propsVO
            if(tip.getIsColorProp()){
                //如果是颜色
                propsVO.setColor(piv);
            }else if(tip.getIsSaleProp()){
                //如果是销售属性
                propsVO.addSaleProps(piv);
            }else if(tip.getPid()==20000L){
                //如果是品牌
                propsVO.setPingpai(piv);
            }else if("货号".equals(tip.getName())||tip.getPid()==13021751L){
                //如果是货号
                propsVO.setHuohao(piv);
            }else{
                //一般属性
                propsVO.addProperties(piv);
            }
        }
        return propsVO;
    }



    /**
     * 导入item里面的value
     * @param propsVO 类目属性
     * @param prop 类目属性ID串
     * @param propImgs 属性图
     * @param alias 类目属性别名
     * @param inputStr 自定义字符串
     * @param inputIds 自定义ID串
     * @return
     */
    public PropsVO importValue(PropsVO propsVO, String prop, List<PropImg> propImgs, String alias, String inputStr, String inputIds)
            throws IOException, ClassNotFoundException, ApiException, CloneNotSupportedException {
        //**************先把propsVO克隆一把,以免破坏缓存
        PropsVO psv=propsVO.deepClone();
        //把所有属性key\value化
        Map<Long,PropertyItemVO> map=new HashMap<>();//key为pid
        //把颜色放入
        if(psv.getColor()!=null){
            map.put(psv.getColor().getPid(),psv.getColor());
        }
        //把货号放入
        if(psv.getHuohao()!=null){
            map.put(psv.getHuohao().getPid(),psv.getHuohao());
        }
        //把品牌放入
        if(psv.getPingpai()!=null){
            map.put(psv.getPingpai().getPid(),psv.getPingpai());
        }
        //把一般属性放入
        if(psv.getProperties()!=null){
            for(PropertyItemVO piv:psv.getProperties()){
                map.put(piv.getPid(),piv);
            }
        }
        //把销售属性放入
        if(psv.getSaleProps()!=null){
            for(PropertyItemVO piv:psv.getSaleProps()){
                map.put(piv.getPid(),piv);
            }
        }
        //**************解析***************************
        //把propImgs解析成key-value
        Map<String,String> propUrlMap=new HashMap<>();
        if(propImgs!=null){
            for(PropImg p:propImgs){
                propUrlMap.put(p.getProperties(),p.getUrl());
            }
        }
        //在初级没有匹配到的,可能二级需要。key为pid,value为vid
        TempErProp nonmap=new TempErProp();
        //input可能的选项,因为标准values里不存在
        TempOtProp nonpv=new TempOtProp();
        //先解析props把选项搞上
        if(prop!=null&&!"".equals(prop)){
            String[] proparr=prop.split(";");
            for(String p:proparr){
                String[] parr=p.split(":");
                if(parr.length<2){//不是标准pid:vid格式
                    continue;
                }
                //取得这个属性
                PropertyItemVO piv=map.get(Long.valueOf(parr[0]));
                if(piv==null){//如果属性不存在,有可能是二级属性
                    nonmap.addSelByPidandVid(Long.valueOf(parr[0]),Long.valueOf(parr[1]));
                    continue;
                }
                PropertyValueVO pvv=new PropertyValueVO();
                pvv.setSelected(true);
                pvv.setVid(Long.valueOf(parr[1]));
                pvv.setImgUrl(propUrlMap.get(piv.getPid()+":"+pvv.getVid()));
                int result=piv.addPropValue(pvv);
                if(result==1){
                    nonpv.addByPidandVid(piv.getPid(),pvv.getVid());
                }
            }
        }
        //处理二级类目
        if(nonmap.size()>0){
            //迭代所有二级类目
            Iterator<Long> it=nonmap.keySet().iterator();
            while(it.hasNext()){
                Long pid=it.next();//二级的pid
                //调用淘宝接口,得到二级类目信息
                List<ItemProp> itemPropresponse= taobaoUtil.selItemPropByPid(psv.getCid(),pid);
                if(itemPropresponse==null||itemPropresponse.size()==0){//如果接口里面查不到,忽略
                    log.error("er prop error cid="+psv.getCid()+" pid="+pid);
                    continue;
                }
                //因为是按pid查的,所以如果有,且只有一个
                ItemProp ip=itemPropresponse.get(0);
                Long parentPid=ip.getParentPid();
                //查出他上级
                PropertyItemVO piv=map.get(parentPid);
                //如果在基础级上面,查不到他的父级,舍去,并记日志
                if(piv==null){
                    log.error("er prop error cid="+psv.getCid()+" pid="+pid+" parentPid="+parentPid);
                    continue;
                }
                PropertyValueVO pvv=piv.getPropValueByVid(ip.getParentVid());
                pvv.setSelected(true);
                //创建新的itemvo
                PropertyItemVO ppiv=new PropertyItemVO();
                ppiv.setPid(ip.getPid());
                ppiv.setName(ip.getName());
                ppiv.setMustHave(ip.getMust());
                ppiv.setCanAlias(ip.getIsAllowAlias());
                ppiv.setType(selType(ip.getIsEnumProp(),ip.getIsItemProp(),ip.getIsMaterial(),ip.getMulti(),ip.getIsInputProp()));
                ppiv.addPropValueList(parseTaobaoPropValueToVO(ip.getPropValues()));
                //把选项打上
                List<PropertyValueVO> subpvvs=nonmap.get(pid);
                for(PropertyValueVO pvvo:subpvvs){
                    //填值
                    ppiv.addPropValue(pvvo);
                }
                pvv.setSubPropItem(ppiv);
                //加到总的属性集合中去
                map.put(ppiv.getPid(),ppiv);
            }
        }
        //处理alias
        if(alias!=null&&!"".equals(alias)){
            String[] aliasarr=alias.split(";");
            for(String ai:aliasarr){
                String[] aiarr=ai.split(":");
                if(aiarr.length<3){//不是标准的pid:vid:name格式,需要舍去
                    continue;
                }
                //如果是二级的属性
                Long pid=Long.valueOf(aiarr[0]);//pid
                Long vid=Long.valueOf(aiarr[1]);//vid
                //取得属性
                PropertyItemVO piv=map.get(pid);
                if(piv==null){//说明不在props总串里,略去
                    log.error("cid="+psv.getCid()+"  pid="+pid+" in alias but not in props");
                    continue;
                }
                //从标准类目选项中取
                PropertyValueVO pvv=piv.getPropValueByVid(vid);
                if(pvv==null){//标准类目选项中如果没有,那么不应该是alias,应该是input,所以这里如果真没有,忽略
                    log.error("cid="+psv.getCid()+"  pid="+piv.getPid()+" in alias but have no propvalue");
                    continue;
                }
                pvv.setName(aiarr[2]);
                //把pvv的变化,加到属性中去,这个add,如果有了是更新
                piv.addPropValue(pvv);
            }
        }

        //处理input
        if(inputIds!=null&&!"".equals(inputIds)
                &&inputStr!=null){
            String[] idarr=inputIds.split(",");
            String[] strarr=inputStr.split(",");
            if(idarr.length==strarr.length){//长度不一至的,日志一下,一般这种就是人为修改,改出来的。淘宝来的数据不可能这样
                //按ID,一个个进行设置
                for(int i=0;i<idarr.length;i++){
                    Long pid=Long.valueOf(idarr[i]);
                    PropertyItemVO piv=map.get(pid);
                    if(piv==null){//说明不在props总串里,略去
                        log.error("cid="+psv.getCid()+"  pid="+pid+" in input but not in props");
                        continue;
                    }
                    //如果用户把颜色命名为颜色,就是出现"颜色;颜色;颜色"的情况,需要把后面一个颜色转义
                    String hereStr=strarr[i];
                    if(hereStr.contains(piv.getName()+";"+piv.getName()+";"+piv.getName())){
                        hereStr=hereStr.replace(piv.getName()+";"+piv.getName()+";"+piv.getName(),
                                piv.getName()+";"+piv.getName()+"####;"+piv.getName());
                    }
                    //如果条数大于自定义vid数,那么要替换一下
                    if(nonpv.get(pid)!=null&&hereStr.split(";").length>nonpv.get(pid).size()){
                        hereStr=hereStr.replace(piv.getName()+";","");//把颜色;这种去掉
                    }
                    String[] strs=hereStr.split(";");
                    for(String s:strs){
                        Long vid=nonpv.popOneVid(pid);
                        if(vid==null){
                            continue;
                        }
                        PropertyValueVO ipvv=new PropertyValueVO();
                        ipvv.setVid(vid);
                        ipvv.setSelected(true);
                        ipvv.setName(s.endsWith("####")?s.substring(0,s.length()-4):s);
                        //设置给属性
                        Long upvid=piv.addPropValueReturnId(ipvv);
                        if(!upvid.equals(ipvv.getVid())){
                            nonpv.pushVidFirst(pid,vid);//没成功添加进去
                            nonpv.popOneVid(upvid);
                        }
                    }
                }
            }else{
                log.error("input length error!!! cid="+psv.getCid()+"  inputIds="+inputIds+" inputStrs="+inputStr);
            }
        }
        //单独处理品牌,如果通过上面,品牌没选出,那么找出其它,放在第一个
        if(psv.getPingpai()!=null){
            PropertyItemVO pppiv=psv.getPingpai();
            //先拿出已经选择的项目
            PropertyValueVO ppv=null;
            for(PropertyValueVO p:pppiv.getValues()){
                if(p.isSelected()){
                    ppv=p;
                    break;
                }
            }
            //把品牌最后一个放上
            //包装值
            TaobaoPropValue datatpv=null;//来自数据库的信息补充
            if(ppv==null){//1个都没选,要去找其它
                List<String> otherNames=new ArrayList<>();
                otherNames.add("其它/other");
                otherNames.add("其他/other");
                otherNames.add("其它");
                otherNames.add("其他");
                otherNames.add("other/其它");
                otherNames.add("other/其他");
                TaobaoPropValueExample pvexam=new TaobaoPropValueExample();
                pvexam.createCriteria().andCidEqualTo(psv.getCid()).andPidEqualTo(pppiv.getPid())
                        .andNameIn(otherNames);
                pvexam.setStartIndex(0);
                pvexam.setEndIndex(1);
                List<TaobaoPropValue> pvlist=taobaoPropValueMallMapper.selectByConditionList(pvexam);
                if(pvlist.size()>0){
                    datatpv=pvlist.get(0);
                }
            }else if(ppv.getName()==null){
                //   原来的20个里面,没有真正的值,这种往往没name
                TaobaoPropValueExample pvexam=new TaobaoPropValueExample();
                pvexam.createCriteria().andCidEqualTo(psv.getCid()).andPidEqualTo(pppiv.getPid())
                        .andVidEqualTo(ppv.getVid());
                pvexam.setStartIndex(0);
                pvexam.setEndIndex(1);
                List<TaobaoPropValue> pvlist=taobaoPropValueMallMapper.selectByConditionList(pvexam);
                if(pvlist.size()>0){
                    datatpv=pvlist.get(0);
                }
            }
            //数据库有补充
            if(datatpv!=null){
                PropertyValueVO opvv=new PropertyValueVO();
                opvv.setName(datatpv.getName());
                opvv.setSelected(true);
                opvv.setVid(datatpv.getVid());
                if(pppiv.getValues().size()==22){//如果是新加的,把它放到第2个
                    PropertyValueVO mpvv=pppiv.getValues().remove(pppiv.getValues().size()-1);
                    pppiv.getValues().add(1,mpvv);
                }
                pppiv.addPropValue(opvv);
                List<Long> nonlist=nonpv.get(20000L);//.remove(datatpv.getVid());
                if(nonlist!=null&&nonlist.size()>0){
                    nonlist.remove(datatpv.getVid());
                    if(nonlist.size()==0){
                        nonpv.remove(20000L);
                    }
                }
            }
        }
        //制作SKU显示列表,按页面上每一个tr为一个对象,如果有一项销售属性没有选择,sku没有
        //先拿出已选的颜色,再选出已选的销售属性
        //把销售属性搞出来
        psv.setSkus(calculateSku(psv.getColor(),psv.getSaleProps()));
        //如果通过上面,最终都没有name的,写入日志
        //处理材质成份
        if(psv.getProperties()==null){
            psv.setProperties(new ArrayList<PropertyItemVO>());
        }
        for(PropertyItemVO piv:psv.getProperties()){
            //如果是材质,转一下pv
            if(piv.getType().equals(PropType.MATERIAL)){
                for(PropertyValueVO pvv:piv.getValues()){
                    pvv.calMaterialPecent();//计算出材质成份map
                }
//                piv.addEmpty();
                break;
            }
        }
        if(nonpv.size()>0){
            log.error("cid="+psv.getCid()+"  nonpv="+nonpv+" not have name");
        }
        return psv;
    }

    /**
     * 计算sku
     * @param color 颜色
     * @param sales 其它销售属性
     * @return
     */
    public List<SkuVO> calculateSku(PropertyItemVO color, List<PropertyItemVO> sales) throws CloneNotSupportedException {
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
    public SkuRankVO calculateSkuRank(PropertyItemVO nowdo, List<PropertyItemVO> sales, boolean iscolor, String idsPath){
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
     * 查子集类目
     * @param cid
     * @param path
     * @return
     */
    @Cacheable(value = "yj2subprop.cache",key = "#cid+ 'and'+ #path")
    public PropertyItemVO selItemVoBySub(Long cid, String path) throws ApiException {
        List<ItemProp> itemProps=taobaoUtil.selItemPropByPath(cid,path);
        if(itemProps!=null&&itemProps.size()>0){
            ItemProp ip=itemProps.get(0);
            PropertyItemVO piv=new PropertyItemVO();
            piv.setCanAlias(ip.getIsAllowAlias());
            piv.setName(ip.getName());
            piv.setMustHave(ip.getMust());
            piv.setPid(ip.getPid());
            piv.setType(selType(ip.getIsEnumProp(),ip.getIsItemProp(),ip.getIsMaterial(),ip.getMulti(),
                    ip.getIsInputProp()));
            piv.addPropValueList(parseTaobaoPropValueToVO(ip.getPropValues()));
            return piv;
        }
        return null;
    }

    /**
     * 查一批品牌
     * @param cid
     * @param key
     * @return
     */
    public List<PropertyValueVO> propselect(Long cid, String key){
        if(key==null||"".equals(key)){
            return null;
        }
        key=key.replace("%","\\%");
        TaobaoPropValueExample example=new TaobaoPropValueExample();
        example.createCriteria().andCidEqualTo(cid).andPidEqualTo(20000L).andNameLike("%"+key+"%");
        example.setStartIndex(0);
        example.setEndIndex(20);
        List<TaobaoPropValue> list=taobaoPropValueMallMapper.selectByConditionList(example);
        return parseLocalPropValueToVO(list);
    }
    /**
     * 品牌下更多
     * @param cid
     * @param value
     * @return
     */
    @Cacheable(value = "yj2pingpai.cache",key = "#cid+ 'and'+ #value")
    public JSONObject propmore(Long cid, String value){
        if(value==null||!value.contains(":")){
            return parsePingpai("","");
        }
        //先查出最后一条的tb_vid
        String[] ids=value.split(":");
        Long pid=Long.valueOf(ids[0]);
        Long vid=Long.valueOf(ids[1]);
        TaobaoPropValueExample example=new TaobaoPropValueExample();
        example.createCriteria().andCidEqualTo(cid).andPidEqualTo(pid).andVidEqualTo(vid);
        example.setStartIndex(0);
        example.setEndIndex(1);
//        example.setOrderByClause("tb_vid asc");
        List<TaobaoPropValue> onelist=taobaoPropValueMallMapper.selectFieldsByConditionList(example, FieldUtil
                .codeFields("tb_vid"));
        if(onelist.size()==0){
            return parsePingpai("","");
        }
        Long tbVid=onelist.get(0).getTbVid();
        example.clear();
        example.createCriteria().andCidEqualTo(cid).andPidEqualTo(pid).andTbVidGreaterThan(tbVid);
//        example.setOrderByClause("tb_vid asc");
        example.setStartIndex(0);
        example.setEndIndex(20);
        List<TaobaoPropValue> morelist=taobaoPropValueMallMapper.selectByConditionList(example);
        StringBuffer html=new StringBuffer();
        for(TaobaoPropValue tpv:morelist){
            html.append("<div id='prop_option_"+tpv.getPid()+":"+tpv.getVid()+"' class='kui-option' role='menuitem' " +
                    "data-value='"+tpv.getPid()+":"+tpv.getVid()+"' title='"+tpv.getName()+"'>"+tpv.getName()+"</div>");
        }
        String lastpidvid="";
        //如果更多有内容,取出这次的最后一个
        if(morelist.size()>0){
            TaobaoPropValue last=morelist.get(morelist.size()-1);
            lastpidvid=last.getPid()+":"+last.getVid();
        }
        return parsePingpai(html.toString(),lastpidvid);
    }

    /**
     * 包装品牌更多
     * JSONObject obj=JSONObject.fromObject("{\"status\":1,\"div\":\""+propsService.propmore(cid,value)+"\"," +
     "\"lastVid\":\""+value+"\"}");
     * @param div
     * @param last
     * @return
     */
    private JSONObject parsePingpai(String div,String last){
        JSONObject obj=JSONObject.fromObject("{}");
        if(div==null||div.equals("")){
            obj.element("status",0);
        }else{
            obj.element("status",1);
        }
        obj.element("div",div);
        obj.element("lastVid",last);
        return obj;
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
    public PropType selType(boolean isEnumProp, boolean isItemProp, boolean isMerial, boolean multi, boolean isInputProp){
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
        public PropertyValueVO getByPidandVid(Long pid, Long vid){
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
}
