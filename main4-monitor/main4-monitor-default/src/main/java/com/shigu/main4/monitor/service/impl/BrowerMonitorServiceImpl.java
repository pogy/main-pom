package com.shigu.main4.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.monitor.bo.PageInfoBO;
import com.shigu.main4.monitor.services.BrowerMonitorService;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.monitor.vo.BrowerRecord;
import com.shigu.main4.monitor.vo.ClientMsg;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 浏览记录监控服务
 * @author shigu_zjb
 * @date 2017/2/16 16:42
 *
 */
@Service("browerMonitorService")
public class BrowerMonitorServiceImpl implements BrowerMonitorService{

    private static final Logger logger = LoggerFactory.getLogger(BrowerMonitorServiceImpl.class);

    @Resource(name="starCaculateService")
    private StarCaculateService starCaculateService;

    @Autowired
    RedisIO redisIO;

    /**
     * 进入页面时,记录数据
     * @param client 客户端信息
     * @return
     */
    public String inPage(String type, Long userId, PageInfoBO pageInfo, ClientMsg client) {
        SimpleElaBean bean = new SimpleElaBean();
        try {
            BrowerRecord browerRecord = makeRecord(userId, pageInfo, client);
            bean.setIndex("shigupagerecode");
            bean.setType(type);
            bean.setPk(browerRecord.getKeyId());
            bean.setSource(JSON.toJSONStringWithDateFormat(browerRecord, "yyyy-MM-dd HH:mm:ss"));
//            ElasticRepository elasticRepository = new ElasticRepository();
//            elasticRepository.insert(bean);
            redisIO.rpush("bulk_flow_to_es", bean);
            redisIO.putTemp(bean.getPk(),bean,3600);
            //添加星星计算
            if(("shop".equals(type)||"item".equals(type))&&pageInfo.getShopId()!=null){
                try {
                    starCaculateService.addBrower(pageInfo.getShopId());
                } catch (Exception e) {
                    logger.error("重算星星数失败",e);
                }
            }

            if ("item".equalsIgnoreCase(type)) {
                StringBuilder redisKeySb = new StringBuilder();
                redisKeySb.append(browerRecord.getItemId()).append("_").append(DateUtil.dateToString(browerRecord.getInTime(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
                String redisKey = redisKeySb.toString();
                redisIO.hset("item_flow", redisKey, client.getClientIp());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean.getPk();
    }

    private BrowerRecord makeRecord(Long userId, PageInfoBO pageInfo, ClientMsg client) {
        BrowerRecord browerRecord = new BrowerRecord();
        browerRecord.setClientMsg(client);
        browerRecord.setUrl(pageInfo.getUrl());
        browerRecord.setWebSite(pageInfo.getWebSite());
        browerRecord.setUserId(userId);
        browerRecord.setReferer(pageInfo.getReferer());
        browerRecord.setInTime(new Date());
        browerRecord.setConnectKey(pageInfo.getConnectKey());
        browerRecord.setItemId(pageInfo.getItemId());
        browerRecord.setShop(pageInfo.getShopId());
        if (!StringUtils.isEmpty(pageInfo.getUrl())) {
            int domainIndex = pageInfo.getUrl().indexOf("com");
            if (domainIndex != -1) {
                String domainstr = pageInfo.getUrl().substring(0, domainIndex + 3);
                domainstr = domainstr.replace("https://", "").replace("http://", "").replace("//", "");
                String uri = pageInfo.getUrl().substring(domainIndex + 3, pageInfo.getUrl().length());
                browerRecord.setDomain(domainstr);
                browerRecord.setUri(uri);
                browerRecord.setUrl(pageInfo.getUrl());
                if (StringUtils.isEmpty(pageInfo.getWebSite())) {
                    int websiteEndIndex = domainstr.indexOf(".");
                    String webSitestr = domainstr.substring(0, websiteEndIndex);
                    if (StringUtils.equals("gz", webSitestr) || StringUtils.equals("hz", webSitestr) ||
                            StringUtils.equals("cs", webSitestr) || StringUtils.equals("bj", webSitestr) ||
                            StringUtils.equals("ss", webSitestr) || StringUtils.equals("xh", webSitestr) ||
                            StringUtils.equals("bb", webSitestr)) {
                        browerRecord.setWebSite(webSitestr);
                    } else {
                        browerRecord.setWebSite("hz");
                    }
                }
            }
        }
        browerRecord.setKeyId(UUID.randomUUID().toString().replace("-",""));
        return browerRecord;
    }

    /**
     * 离开页面时记录
     * @param idKey 主键key
     * @return
     */
    public boolean outPage(String idKey) {
        if(idKey==null){
            return false;
        }
        SimpleElaBean seb;
        SearchHit[] hits;
        try {
            SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
            QueryBuilder qb = QueryBuilders.termQuery("keyId", idKey);
            srb.setQuery(qb);
            SearchResponse response = srb.execute().actionGet();

            hits = response.getHits().getHits();
        } catch (Exception e) {
            return false;
        }
        if (hits != null && hits.length > 0){
                SearchHit hit = hits[0];
                seb=new SimpleElaBean();
                seb.setPk(hit.getId());
                seb.setIndex(hit.getIndex());
                seb.setType(hit.getType());
                seb.setSource(hit.getSourceAsString());
            }else{//还在redis
                seb=redisIO.get(idKey,SimpleElaBean.class);
                if(seb==null){
                    return false;
                }
                redisIO.del(idKey);
            }

            BrowerRecord browerRecord = JSON.parseObject(seb.getSource(), BrowerRecord.class);
            if(browerRecord == null){
                return false;
            }
            browerRecord.setOutTime(new Date());
            SimpleElaBean bean = new SimpleElaBean();
            bean.setIndex(seb.getIndex());
            bean.setType(seb.getType());
            bean.setPk(seb.getPk());
            bean.setSource(JSON.toJSONStringWithDateFormat(browerRecord, "yyyy-MM-dd HH:mm:ss"));
        try {
//                ElasticRepository elasticRepository = new ElasticRepository();
//                elasticRepository.insert(bean);
            redisIO.rpush("bulk_flow_to_es", bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
