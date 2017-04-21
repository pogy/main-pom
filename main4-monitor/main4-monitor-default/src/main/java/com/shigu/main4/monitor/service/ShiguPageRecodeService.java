package com.shigu.main4.monitor.service;


import com.alibaba.fastjson.JSON;
import com.opentae.common.beans.Example;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPageRecode;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguPageRecodeExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguPageRecodeMapper;
import com.shigu.main4.monitor.bo.ShiguPageRecodeBo;
import com.shigu.main4.monitor.vo.BrowerRecord;
import com.shigu.main4.monitor.vo.BrowerRecordVo;
import com.shigu.main4.monitor.vo.ClientMsg;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 记录用户的网页浏览记录
 * @author shigu_zjb
 * @date 2017/02/26 14:51
 *
 */
@Service("shiguPageRecodeService")
public class ShiguPageRecodeService {

    private static final Logger logger = LoggerFactory.getLogger(ShiguPageRecodeService.class);

    @Resource(name = "tae_mall_shiguPageRecodeMapper")
    private ShiguPageRecodeMapper shiguPageRecodeMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private EhCacheCacheManager cacheManager;

    /**
     * 列表数据查询
     * @param shiguPageRecodeBo
     * @return
     */
    public List<ShiguPageRecode> findShiguPageRecodeListByBo(ShiguPageRecodeBo shiguPageRecodeBo){
        Example example = makeExample(shiguPageRecodeBo);
        return shiguPageRecodeBo.isPageable()
                ? shiguPageRecodeMapper.selectByConditionList(example)
                : shiguPageRecodeMapper.selectByExample(example);
    }

    public Example makeExample(ShiguPageRecodeBo shiguPageRecodeBo) {
        if(shiguPageRecodeBo == null){
            shiguPageRecodeBo = new ShiguPageRecodeBo();
        }
        ShiguPageRecodeExample example = new ShiguPageRecodeExample();
        if (shiguPageRecodeBo.isPageable()) {
            example.setEndIndex(shiguPageRecodeBo.getPageSize());
            example.setStartIndex((shiguPageRecodeBo.getPageNo() - 1) * shiguPageRecodeBo.getPageSize());
        }
        ShiguPageRecodeExample.Criteria excr = example.createCriteria();
        if(shiguPageRecodeBo.getId() != null){
            excr.andIdEqualTo(shiguPageRecodeBo.getId());
        }
        if(!StringUtils.isEmpty(shiguPageRecodeBo.getWebSite())){
            excr.andWebSiteEqualTo(shiguPageRecodeBo.getWebSite());
        }
        if (shiguPageRecodeBo.getEndInTime() != null) {
            excr.andInTimeLessThan(shiguPageRecodeBo.getEndInTime());
        }
        return example;
    }

    public int countByBo(ShiguPageRecodeBo shiguPageRecodeBo) {
        return shiguPageRecodeMapper.countByExample(makeExample(shiguPageRecodeBo));
    }

    /**
     * 记录用户的网页浏览记录对象查询
     * @param shiguPageRecodeBo
     * @return
     */
    public ShiguPageRecode findShiguPageRecode(ShiguPageRecodeBo shiguPageRecodeBo){
        if(shiguPageRecodeBo == null){
            return null;
        }
        List<ShiguPageRecode> shiguPageRecodeList = findShiguPageRecodeListByBo(shiguPageRecodeBo);
        if(shiguPageRecodeList == null || shiguPageRecodeList.size() == 0){
            return null;
        }
        return shiguPageRecodeList.get(0);
    }

    /**
     * 数据转化
     * @param shiguPageRecode
     * @return
     */
    public BrowerRecordVo getBrowerRecord(ShiguPageRecode shiguPageRecode){
        BrowerRecordVo browerRecord = new BrowerRecordVo();
        ClientMsg clientMsg = new ClientMsg();
        clientMsg.setClientIp(shiguPageRecode.getClientIp());
        clientMsg.setClientBrower(shiguPageRecode.getClientBrower());
        clientMsg.setClientBrowerVersion(shiguPageRecode.getClientBrowerVersion());
        clientMsg.setClientOs(shiguPageRecode.getClientOs());
        browerRecord.setClientMsg(clientMsg);

        String pageUrl = shiguPageRecode.getPageUrl();
        if(!StringUtils.isEmpty(pageUrl)){
            int domainIndex = pageUrl.indexOf("com");
            if(domainIndex != -1){
                String domainstr = pageUrl.substring(0,domainIndex+3);
                domainstr = domainstr.replace("https://","").replace("http://","").replace("//","");
                int websiteEndIndex = domainstr.indexOf(".");
                String webSitestr = domainstr.substring(0,websiteEndIndex);
                switch (webSitestr) {
                    case "gz":
                    case "hz":
                    case "cs":
                    case "bj":
                    case "ss":
                    case "xh":
                    case "bb":
                        break;
                    default:
                        webSitestr = "hz";
                }
                browerRecord.setWebSite(webSitestr);

                String uri = pageUrl.substring(domainIndex+3,pageUrl.length());
                browerRecord.setDomain(domainstr);
                browerRecord.setUri(uri);
                browerRecord.setUrl(pageUrl);

                int domainTypeHtmlIndex = pageUrl.indexOf(".htm");
                if(domainTypeHtmlIndex > 0){
                    String type = pageUrl.substring(domainIndex+4,domainTypeHtmlIndex);
                    String ids = null;
                    int domainIdIndex = pageUrl.indexOf("id=");
                    if(domainIdIndex > 0){
                        int idEndIndex = pageUrl.length();
                        if(pageUrl.contains("&")){
                            idEndIndex = pageUrl.indexOf("&");
                        }
                        try {
                            ids = pageUrl.substring(domainIdIndex + 3, idEndIndex);
                        } catch (StringIndexOutOfBoundsException e) {
                            logger.warn(JSON.toJSONString(shiguPageRecode) + "异常");
                        }
                    }
                    if(StringUtils.equals("item",type)){
                        browerRecord.setType("item");
                        if (ids != null)
                            try {
                                // 获取商品id
                                browerRecord.setItemId(Long.valueOf(ids));
                                //  获取店铺Id
                                browerRecord.setShop(getShopIdByItemId(browerRecord.getItemId(), browerRecord.getWebSite()));
                            } catch (Exception ignored){}
                    }
                    if(StringUtils.equals("shop",type)){
                        browerRecord.setType("shop");
                        if (ids != null)
                            browerRecord.setShop(Long.valueOf(ids));
                    }
                    if(!StringUtils.equals("item",type)&&!StringUtils.equals("shop",type)){
                        browerRecord.setType("other");
                    }
                }
            }
        }
        if(shiguPageRecode.getInTime()!=null){
            browerRecord.setInTime(shiguPageRecode.getInTime());
        }
        if(shiguPageRecode.getOutTime()!=null){
            browerRecord.setOutTime(shiguPageRecode.getOutTime());
        }
        browerRecord.setKeyId(shiguPageRecode.getId().toString());
        browerRecord.setReferer(shiguPageRecode.getFromPageUrl());
        //browerRecord.setUserId(shiguPageRecode.g);
        return browerRecord;
    }

    public Long getShopIdByItemId(Long itemId, String website) {
        Cache cache = cacheManager.getCache("goods2shop");
        Long shop = null;
        if (cache != null) {
            shop = cache.get(itemId, Long.class);
            if (shop == null) {
                shop = getShopByItem(itemId, website);
                cache.put(itemId, shop);
            }
        } else {
            return getShopByItem(itemId, website);
        }
        return shop;
    }

    private Long getShopByItem(Long itemId, String website) {
        ShiguGoodsTiny goodsTiny = new ShiguGoodsTiny();
        goodsTiny.setWebSite(website);
        goodsTiny.setGoodsId(itemId);
        goodsTiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(goodsTiny, FieldUtil.codeFields("goods_id,store_id"));
        if (goodsTiny != null) {
            return goodsTiny.getStoreId();
        }
        return null;
    }

    /**
     * 新增记录
     * @param shiguPageRecode
     */
    public void addShiguPageRecode(ShiguPageRecode shiguPageRecode){
        shiguPageRecodeMapper.insertSelective(shiguPageRecode);
    }

    /**
     * 对象数据转换
     * @param browerRecord
     * @return
     */
    public ShiguPageRecode getShiguPageRecodeExchange(BrowerRecord browerRecord ,String url){
        if (browerRecord == null) {
            return null;
        }
        ShiguPageRecode shiguPageRecode = new ShiguPageRecode();
        if (browerRecord.getClientMsg() != null) {
            shiguPageRecode.setClientBrower(browerRecord.getClientMsg().getClientBrower());
            shiguPageRecode.setClientIp(browerRecord.getClientMsg().getClientIp());
            shiguPageRecode.setClientBrowerVersion(browerRecord.getClientMsg().getClientBrowerVersion());
            shiguPageRecode.setClientOs(browerRecord.getClientMsg().getClientOs());
        }
        shiguPageRecode.setWebSite(browerRecord.getWebSite());
        shiguPageRecode.setFromPageUrl(browerRecord.getReferer());
        if (browerRecord.getInTime() != null) {
            Date inDate = browerRecord.getInTime();
            shiguPageRecode.setInTime(inDate);
        }
        if (shiguPageRecode.getOutTime() != null) {
            Date outDate = browerRecord.getOutTime();
            shiguPageRecode.setOutTime(outDate);
        }
        shiguPageRecode.setPageUrl(url);
        return shiguPageRecode;
    }

    /**h
     * 新增监控记录
     *
     * @param browerRecord
     * @param url
     */
    public void addBrowerRecord(BrowerRecord browerRecord, String url) {
        if (browerRecord == null) {
            return;
        }
        ShiguPageRecode shiguPageRecode = getShiguPageRecodeExchange(browerRecord, url);
        addShiguPageRecode(shiguPageRecode);
    }

    /**
     * 新增监控记录
     * @param clientMsg
     * @param url
     */
    public String addClientMsg(ClientMsg clientMsg, String url) {
        if (clientMsg == null) {
            return null;
        }
        BrowerRecord browerRecord = new BrowerRecord();
        browerRecord.setClientMsg(clientMsg);
        ShiguPageRecode shiguPageRecode = getShiguPageRecodeExchange(browerRecord, url);
        shiguPageRecode.setInTime(new Date());
        addShiguPageRecode(shiguPageRecode);
        return shiguPageRecode.getId().toString();
    }

    /**
     * 更新网页监控记录
     * @param shiguPageRecode
     */
    public int updateShiguPageCode(ShiguPageRecode shiguPageRecode){
        if(shiguPageRecode == null || shiguPageRecode.getId() == null){
            return 0;
        }
        int result = shiguPageRecodeMapper.updateByPrimaryKeySelective(shiguPageRecode);
        return result;
    }

    /**
     * 更新网页监控记录的跳出时间
     * @param idKey
     */
    public boolean updateOutTime(Long idKey) {
        if (idKey == null) {
            return false;
        }
        ShiguPageRecode shiguPageRecode = new ShiguPageRecode();
        shiguPageRecode.setOutTime(new Date());
        shiguPageRecode.setId(idKey);
        int result = updateShiguPageCode(shiguPageRecode);
        return result >= 1 ? true : false;
    }
}
