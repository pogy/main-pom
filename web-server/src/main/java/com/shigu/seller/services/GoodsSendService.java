package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.RedisIO;
import com.shigu.seller.vo.*;
import com.shigu.tb.finder.services.TbPropsService;
import com.shigu.tb.finder.vo.PropertyItemVO;
import com.shigu.tb.finder.vo.PropertyValueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品发布服务
 * Created by zhaohongbo on 17/3/15.
 */
@Service
public class GoodsSendService {

    @Autowired
    ShiguTaobaocatMapper shiguTaobaocatMapper;

    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    RedisIO redisIO;
    @Autowired
    TbPropsService tbPropsService;

    /**
     * id串变成propNames
     * @param props
     * @return
     */
    public String parsePropName(Long cid,String props,String inputStr,String inputPids,String alias){
        String pname="";
        if(props!=null){
            String[] propsarr=props.split(";");
            for(String prop:propsarr){
                TaobaoPropValueExample ex=new TaobaoPropValueExample();
                String[] parr=prop.split(":");
                ex.createCriteria().andCidEqualTo(cid).andPidEqualTo(Long.valueOf(parr[0]))
                        .andVidEqualTo(Long.valueOf(parr[1]));
                ex.setStartIndex(0);
                ex.setEndIndex(1);
                List<TaobaoPropValue> tpvs=taobaoPropValueMapper.selectByConditionList(ex);
                if(tpvs.size()>0){
                    pname+=";"+tpvs.get(0).getPid()+":"+tpvs.get(0).getVid()+":"+tpvs.get(0).getPropName()+":"+
                            tpvs.get(0).getName();
                }
            }
        }
//        if (inputPids!=null&&!"".equals(inputPids)) {
//            String[] pids=inputPids.split(",");
//
//        }
        // TODO: 17/3/18 暂时不做inputStr与inputPid与alias的情况
        return pname.toString().startsWith(";")?pname.substring(1): pname.toString();
    }
    /**
     * 查询类目路径
     * @param cid
     * @return
     */
    public String selCatPath(Long cid) throws Main4Exception {
        ShiguTaobaocat cat=shiguTaobaocatMapper.selectByPrimaryKey(cid);
        if(cat==null){
            throw new Main4Exception("cid对应的类目不存在");
        }
        Long parentCid=cat.getParentCid();
        if(parentCid==0){
            return cat.getCname();
        }else{
            return selCatPath(parentCid)+">"+cat.getCname();
        }
    }

    /**
     * 查cid串
     * @param cid
     * @return
     * @throws Main4Exception
     */
    public String selCatIds(Long cid) throws Main4Exception {
        ShiguTaobaocat cat=shiguTaobaocatMapper.selectByPrimaryKey(cid);
        if(cat==null){
            throw new Main4Exception("cid对应的类目不存在");
        }
        Long parentCid=cat.getParentCid();
        if(parentCid==0){
            return cat.getCid().toString();
        }else{
            return selCatIds(parentCid)+","+cat.getCid();
        }
    }

    /**
     * 查类目名
     * @param cid
     * @return
     * @throws Main4Exception
     */
    public String selCnameById(Long cid) throws Main4Exception {
        ShiguTaobaocat cat=shiguTaobaocatMapper.selectByPrimaryKey(cid);
        if(cat==null){
            throw new Main4Exception("cid对应的类目不存在");
        }
        return cat.getCname();
    }

//    /**
//     * 查询店内类目
//     * @param shopId
//     */
//    public void selStorecats(Long shopId){
//        shopForCdnService.selShopCatsById(shopId);
//    }

    /**
     * 转化格式 ,从propertyItemVO到formAttrVO
     * @param itemVO
     * @return
     */
    public FormAttrVO parseTaobaoItemPropVO(PropertyItemVO itemVO){
        if(itemVO==null){
            return null;
        }
        FormAttrVO vo=new FormAttrVO();
        vo.setName(itemVO.getName());
        vo.setNeed(itemVO.isMustHave()?1:0);
        FormItemVO formItem=new FormItemVO();
        vo.setFormitem(formItem);
        formItem.setName(itemVO.getName());
//        formItem.setIsInputProp(itemVO.getType().equals(PropType.INPUT)?"input":"select");
        formItem.setPid(itemVO.getPid());
        List<KVO> kvos=new ArrayList<>();
        if(itemVO.getValues()!=null){
            formItem.setOptions(kvos);
            List<PropertyValueVO> pvvs=itemVO.getValues();
            for(PropertyValueVO pvv:pvvs){
                if(pvv.getVid()==null||pvv.getVid()==-1)continue;
                KVO kvo=new KVO();
                kvo.setPid(itemVO.getPid());
                kvo.setVid(pvv.getVid());
                kvo.setText(pvv.getName());
                kvo.setValue(itemVO.getPid()+":"+pvv.getVid());
                kvos.add(kvo);
            }
        }
        return vo;
    }

    /**
     * 转化淘宝销售属性
     * @param itemVO
     * @param type 1为颜色 0为其它
     * @return
     */
    public SKUVO parseTaobaoSaleVO(PropertyItemVO itemVO,int type){
        if(itemVO==null){
            return null;
        }
        SKUVO vo=new SKUVO();
        vo.setName(itemVO.getName());
        vo.setType(type==1?"colorset":"required");
        List<SKUAttrVO> list=new ArrayList<>();
        vo.setFormitems(list);
        List<PropertyValueVO> pvvs=itemVO.getValues();
        for(PropertyValueVO pvv:pvvs){
            SKUAttrVO s=new SKUAttrVO();
            s.setVid(pvv.getVid());
            s.setPid(itemVO.getPid());
            s.setCnname(pvv.getName());
            list.add(s);
        }
        return vo;
    }
}
