package com.shigu.main4.item.newservice.impl;

import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.TaobaoItemProp;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsSingleSkuMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.bo.TaobaoPropValueBO;
import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.bo.news.SingleSkuBO;
import com.shigu.main4.item.dao.SingleSkuDao;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.newservice.NewItemAddOrUpdateService;
import com.shigu.main4.item.services.impl.ItemAddOrUpdateServiceImpl;
import com.shigu.main4.item.tools.GoodsAddToRedis;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.item.vo.news.NewPullSynItemVO;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("newItemAddOrUpdateService")
public class NewItemAddOrUpdateServiceImpl extends ItemAddOrUpdateServiceImpl  implements NewItemAddOrUpdateService {

    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    GoodsAddToRedis goodsAddToRedis;

    @Autowired
    RedisIO redisIO;

    @Autowired
    SingleSkuDao singleSkuDao;

    @Autowired
    ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long systemAddItem(NewPushSynItemBO item) throws ItemModifyException {
        Long itemId = super.addItem(item, true);
        //添加独立sku
        SpringBeanFactory.getBean(ItemSkuModel.class, itemId).push(item.getSingleSkus());
        return itemId;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long userAddItem(NewPushSynItemBO item) throws ItemModifyException {
        Long itemId = super.addItem(item, false);
        //添加独立sku
        SpringBeanFactory.getBean(ItemSkuModel.class, itemId).push(item.getSingleSkus());
        return itemId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int systemUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        int i = super.systemUpdateItem(BeanMapper.map(item,SynItem.class));
        if (item.getSingleSkus() != null&&item.getSingleSkus().size()>0) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
            super.cleanItemCache(item.getGoodsId());
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int officeUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        int i = super.officeUpdateItem(BeanMapper.map(item,SynItem.class));
        if (item.getSingleSkus() != null&&item.getSingleSkus().size()>0) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
            super.cleanItemCache(item.getGoodsId());
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int userUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        ItemSkuModel model=null;
        if(StringUtils.isNotBlank(item.getPiPriceString())){
            List<Long> singlePrices;
            List<SingleSkuBO> singleSkus = item.getSingleSkus();
            if(singleSkus==null||singleSkus.isEmpty()){
                model = SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId());
                List<SingleSkuVO> pull = model.pull();
                List<SingleSkuVO> customPrices = pull.stream().filter(singleSkuVO -> !singleSkuVO.getIsDefaultPrice()).collect(Collectors.toList());
                singlePrices=customPrices.stream().map(singleSkuVO ->MoneyUtil.StringToLong(singleSkuVO.getPriceString())).collect(Collectors.toList());
            }else{
                singlePrices=singleSkus.stream().map(singleSkuBO -> MoneyUtil.StringToLong(singleSkuBO.getPriceString())).collect(Collectors.toList());
            }
            if(singlePrices.size()>0){
                long piprice=MoneyUtil.StringToLong(item.getPiPriceString());
                singlePrices.sort(Comparator.comparingLong(o -> o));
                if(piprice<singlePrices.get(0)||piprice>singlePrices.get(singlePrices.size()-1)){
                    throw new ItemModifyException(
                            "批发价修改失败,批发价必须在sku价格的区间范围之内,当前范围:(" + MoneyUtil.dealPrice(singlePrices.get(0)) + "-" +
                                    MoneyUtil.dealPrice(singlePrices.get(singlePrices.size() - 1)) + ")");
                }
            }
        }
        int i = super.userUpdateItem(BeanMapper.map(item,SynItem.class));
        if (item.getSingleSkus() != null&&item.getSingleSkus().size()>0) {
            model=model==null?SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()):model;
            model.push(item.getSingleSkus());
            super.cleanItemCache(item.getGoodsId());
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int userUpdateItem(NewPushSynItemBO item, Boolean updatePrice) throws ItemModifyException {
        int i = super.userUpdateItem(BeanMapper.map(item,SynItem.class),updatePrice);
        if (item.getSingleSkus() != null&&item.getSingleSkus().size()>0) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
            super.cleanItemCache(item.getGoodsId());
        }
        return i;
    }

    @Override
    public NewPullSynItemVO selItemByGoodsId(Long goodsId, String webSite) {
        SynItem synItem = super.selItemByGoodsId(goodsId, webSite);
        if(synItem!=null){
            NewPullSynItemVO vo=BeanMapper.map(synItem,NewPullSynItemVO.class);
            vo.setSingleSkus(SpringBeanFactory.getBean(ItemSkuModel.class, synItem.getGoodsId()).pull());
//            toPropName(vo);
            return vo;
        }
        return null;
    }

    @Override
    public NewPullSynItemVO selItemWithSynItem(Long numIid, Long shopId) {
        SynItem synItem = super.selItemWithSynItem(numIid, shopId);
        if(synItem!=null){
            NewPullSynItemVO vo=BeanMapper.map(synItem,NewPullSynItemVO.class);
            vo.setSingleSkus(SpringBeanFactory.getBean(ItemSkuModel.class, synItem.getGoodsId()).pull());
//            toPropName(vo);
            return vo;
        }
        return null;
    }
    @Override
    public List<TaobaoPropValueBO> selColorSizeValues(Long cid) {
        return singleSkuDao.taobaoPropValues(cid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void systemDeleteItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId);
        if(shiguGoodsIdGenerator!=null){
            super.systemDeleteItem(itemId);
            ShiguGoodsSingleSkuExample shiguGoodsSingleSkuExample=new ShiguGoodsSingleSkuExample();
            shiguGoodsSingleSkuExample.createCriteria().andGoodsIdEqualTo(itemId);
            shiguGoodsSingleSkuExample.setWebSite(shiguGoodsIdGenerator.getWebSite());
            shiguGoodsSingleSkuMapper.deleteByExample(shiguGoodsSingleSkuExample);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userDeleteItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId);
        if(shiguGoodsIdGenerator!=null){
            super.userDeleteItem(itemId);
            ShiguGoodsSingleSkuExample shiguGoodsSingleSkuExample=new ShiguGoodsSingleSkuExample();
            shiguGoodsSingleSkuExample.createCriteria().andGoodsIdEqualTo(itemId);
            shiguGoodsSingleSkuExample.setWebSite(shiguGoodsIdGenerator.getWebSite());
            shiguGoodsSingleSkuMapper.deleteByExample(shiguGoodsSingleSkuExample);
        }
    }

    private void toPropName(NewPullSynItemVO vo){
        if(vo.getPropertyAlias()==null||"null".equals(vo.getPropertyAlias())){
            vo.setPropertyAlias("");
        }
        if(vo.getProps()==null||"null".equals(vo.getProps())){
            vo.setProps("");
        }
        if(vo.getPropsName()==null||"null".equals(vo.getPropsName())){
            vo.setPropsName("");
        }

        List<TaobaoItemProp> taobaoItemProps = singleSkuDao.selProps(vo.getCid());
        Map<Long,String> nameMap=taobaoItemProps.stream().collect(Collectors.toMap(TaobaoItemProp::getPid,TaobaoItemProp::getName));

        Set<String> ns=new HashSet<>();
        Set<String> ids=new HashSet<>();
        Set<String> pas=new HashSet<>();
        vo.getSingleSkus().forEach(singleSkuVO -> {
            ns.add(singleSkuVO.getColorPid()+":"+singleSkuVO.getColorVid()+":"+nameMap.get(singleSkuVO.getColorPid())+":"+singleSkuVO.getColorName());
            ns.add(singleSkuVO.getSizePid()+":"+singleSkuVO.getSizeVid()+":"+nameMap.get(singleSkuVO.getSizePid())+":"+singleSkuVO.getSizeName());

            ids.add(singleSkuVO.getColorPid()+":"+singleSkuVO.getColorVid());
            ids.add(singleSkuVO.getSizePid()+":"+singleSkuVO.getSizeVid());

            if(StringUtils.isNotBlank(singleSkuVO.getColorPropertyAlias())){
                pas.add(singleSkuVO.getColorPid()+":"+singleSkuVO.getColorVid()+":"+singleSkuVO.getColorPropertyAlias());
            }
            if(StringUtils.isNotBlank(singleSkuVO.getSizePropertyAlias())){
                pas.add(singleSkuVO.getSizePid()+":"+singleSkuVO.getSizeVid()+":"+singleSkuVO.getSizePropertyAlias());
            }
        });
        List<String> props=new ArrayList<>(Arrays.asList(vo.getProps().split(";")));
        List<String> propNames=new ArrayList<>(Arrays.asList(vo.getPropsName().split(";")));
        List<String> as=new ArrayList<>(Arrays.asList(vo.getPropertyAlias().split(";")));

        propNames.removeIf(s -> StringUtils.isBlank(s)||nameMap.keySet().contains(new Long(s.split(":")[0])));
        props.removeIf(s -> StringUtils.isBlank(s)||nameMap.keySet().contains(new Long(s.split(":")[0])));
        as.removeIf(s -> StringUtils.isBlank(s)||nameMap.keySet().contains(new Long(s.split(":")[0])));

        propNames.addAll(ns);
        props.addAll(ids);
        as.addAll(pas);

        vo.setPropsName(StringUtils.join(propNames,";"));
        vo.setProps(StringUtils.join(props,";"));
        vo.setPropertyAlias(StringUtils.join(as,";"));
        vo.setInputPids("");
        vo.setInputStr("");
    }
}
