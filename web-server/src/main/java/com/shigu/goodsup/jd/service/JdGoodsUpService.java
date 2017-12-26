package com.shigu.goodsup.jd.service;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.goodsup.jd.vo.JdUpRecordVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created By admin on 2017/12/22/20:40
 */
@Service
public class JdGoodsUpService {

    private static final Logger logger = LoggerFactory.getLogger(JdGoodsUpService.class);

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private JdGoodsService jdGoodsService;

    @Autowired
    private UserLicenseService userLicenseService;

    @Autowired
    private ShowForCdnService showForCdnService;

//    @Autowired
//    private StarCaculateService starCaculateService;

    /**
     *查询商品是否可京东上传
     * 根据goodsId获取tbCid,然后去jd_tb_bind表查询,如果查不到,则不能上传
     * @return
     */
    public Boolean goodsCanbeUploadedToJd(Long goodsId) throws JdUpException {
        ShiguGoodsIdGenerator generator;
        // 验证参数，并查询分站存在
        if (goodsId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId)) == null) {
            throw new JdUpException("未查询到分站信息");
        }
        String webSite = generator.getWebSite();
        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            throw new JdUpException("未查询到商品信息");
        }
        Long tbCid = tiny.getCid();
        return jdGoodsService.goodsCanbeUploadedToJd(tbCid);
    }


    /**
     * 查询用户是否已上传过, true: 已经上传过， false ：未上传过
     * @return
     */
    public Boolean hasBeUploaded(Long userId,Long goodsId) {
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigu_jd_goodsup");
        srb.setQuery(QueryBuilders.termQuery("userId",userId));
        srb.setQuery(QueryBuilders.termQuery("goodsId",goodsId));
        srb.setSize(0);
        srb.setFrom(1);
        TermsBuilder termsBuilder = AggregationBuilders.terms("userType");
        srb.addAggregation(termsBuilder);
        SearchResponse searchResponse = srb.execute()
                .actionGet();

        Terms type = searchResponse.getAggregations().get("userType");
        return null;
    }

    /**
     * 添加京东上传记录到ES
     * @return
     */
    public void saveRecord(JdUpRecordVO vo) {
        if (vo.getUserId() == null || vo.getGoodsId() == null) {
            return;
        }
        ShiguGoodsIdGenerator sgig= shiguGoodsIdGeneratorMapper.selectByPrimaryKey(vo.getGoodsId());
        if(sgig==null){
            return;
        }
        CdnItem cdnItem = showForCdnService.selItemById(vo.getGoodsId());
        vo.setWebSite(sgig.getWebSite());
        try {
            userLicenseService.addScore(vo.getUserId(),1);
        } catch (Exception e) {
            logger.error("加积分失败",e);
        }

        SimpleElaBean bean = new SimpleElaBean();
        bean.setIndex("shigu_jd_goodsup");
        bean.setType(sgig.getWebSite());
        bean.setSource(JSON.toJSONString(vo));
        try {
            ElasticRepository elasticRepository = new ElasticRepository();
            elasticRepository.insert(bean);
        } catch (Exception e) {
            logger.error("京东上传记录>>异常>>添加新索引>>data:" + JSON.toJSONString(vo) + " ERROR:" + e.toString());
            e.printStackTrace();
        }
        //添加星星数计算
//        if(cdnItem.getShopId()!=null){
//            try {
//                starCaculateService.addItemUp(cdnItem.getShopId());
//            } catch (Exception e) {
//                logger.error("上传后重算星星数失败",e);
//            }
//        }
    }

}
