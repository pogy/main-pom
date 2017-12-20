package com.shigu.main4.goat.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.GoatItemDataExample;
import com.opentae.data.mall.examples.GoatOneItemExample;
import com.opentae.data.mall.examples.GoatOneLocationExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ImgGoat;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.beans.TextGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.*;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service("goatFactory")
public class GoatFactoryImpl implements GoatFactory {

    private static final Logger logger = LoggerFactory.getLogger(GoatFactoryImpl.class);
    @Autowired
    GoatOneLocationMapper goatOneLocationMapper;

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Resource(name = "tae_mall_goatOneItemMapper")
    GoatOneItemMapper goatOneItemMapper;

    @Resource(name = "tae_mall_goatItemDataMapper")
    GoatItemDataMapper goatItemDataMapper;

    @Resource(name="tae_mall_goodsupNorealMapper")
    GoodsupNorealMapper goodsupNorealMapper;

    @Autowired
    RedisIO redisIO;
    @Override
    public GoatLocation getAlocation(Long localId) throws GoatException {
        GoatOneLocation local = goatOneLocationMapper.selectByPrimaryKey(localId);
        if (local == null) {
            throw new GoatException("广告位置ID:" + localId + "不存在");
        }
        GoatLocation location=getALocationByVo(BeanMapper.map(local, GoatLocationVO.class));
        location.setCode(local.getLocalCode());
        return location;
    }

    /**
     * 查一个广告位
     *
     * @param code 广告编号
     * @return 广告位对象
     * @throws GoatException
     */
    @Override
    public GoatLocation getALocation(String code) throws GoatException {
        GoatOneLocationExample example = new GoatOneLocationExample();
        example.createCriteria().andLocalCodeEqualTo(code).andDisEnabledEqualTo(false);
        example.setStartIndex(0);
        example.setEndIndex(1);
        List<GoatOneLocation> locations = goatOneLocationMapper.selectByConditionList(example);
        if (locations.size() == 0) {
            throw new GoatException("获取广告位置[" + code + "]失败");
        }
        return getALocationByVo(BeanMapper.map(locations.get(0), GoatLocationVO.class));
    }

    @Override
    public GoatLocation getALocationByVo(GoatLocationVO vo) {
        GoatLocation location = new GoatLocation() {
            @Override
            public <T extends GoatVO> List<T> selGoats() throws GoatException {
                return selGoatCommon(this, 1);
            }

            @Override
            public <T extends GoatVO> List<T> selPrepareGoats() throws GoatException {
                return selGoatCommon(this, 2);
            }

        };
        return BeanMapper.mapAbstact(vo, location);
    }

    /**
     * 查询广告位内的广告
     *
     * @param status 1有效，0无效，2预设
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T extends GoatVO> List<T> selGoatCommon(GoatLocation local, Integer status) throws GoatException {
        GoatOneItemExample goiex = new GoatOneItemExample();
        goiex.createCriteria().andLocalIdEqualTo(local.getLocalId()).andDisEnabledEqualTo(false);
        goiex.setOrderByClause("sort asc");
        //1.查询广告位置下的有效广告
        List<GoatOneItem> goilist = goatOneItemMapper.selectByExample(goiex);
        //2.查询这些广告的线上版本数据
        List<Long> gIdlist = BeanMapper.getFieldList(goilist, "goatId", Long.TYPE);
        Map<Long, GoatItemData> dataMap = new HashMap<>();
        if (gIdlist.size() > 0) {
            GoatItemDataExample gidex = new GoatItemDataExample();
            GoatItemDataExample.Criteria cri=gidex.createCriteria().andGoatIdIn(gIdlist).andStatusEqualTo(status);
            List<GoatItemData> gidlist = goatItemDataMapper.selectByExample(gidex);
            dataMap = BeanMapper.list2Map(gidlist, "goatId", Long.TYPE);
        }
        List<T> rlist = new ArrayList<>();
        //3.根据Location中的goatType判断需要包装的返回对象
        for (GoatOneItem oneItem : goilist) {
            GoatItemData gid = dataMap.get(oneItem.getGoatId());
            if (gid == null) {
                gid = new GoatItemData();
                gid.setGoatId(oneItem.getGoatId());
                gid.setContext("{}");
            }
            T t=unserializeGoat(gid, local);
            t.setSort(oneItem.getSort());
            t.setRecommon(oneItem.getRecommon());
            rlist.add(t);
        }
        return rlist;
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) throws GoatException {
        return selGoatByIdAndStatus(goatId,1);
    }

    @Override
    public <T extends Goat> T selGoatPrepareById(Long goatId) throws GoatException {
        return selGoatByIdAndStatus(goatId,2);
    }

    /**
     * 按广告ID和数据状态来查广告位信息
     * @param goatId
     * @param status
     * @param <T>
     * @return
     * @throws GoatException
     */
    private <T extends Goat> T selGoatByIdAndStatus(Long goatId,Integer status) throws GoatException {
        //查广告
        GoatOneItem goi = goatOneItemMapper.selectByPrimaryKey(goatId);
        if (goi == null) {
            throw new GoatException("广告id:" + goatId + "不存在");
        }
        //查出在线广告数据
        GoatItemDataExample goatItemDataExample = new GoatItemDataExample();
        goatItemDataExample.createCriteria().andGoatIdEqualTo(goatId).andStatusEqualTo(status);
        goatItemDataExample.setStartIndex(0);
        goatItemDataExample.setEndIndex(1);
        List<GoatItemData> datas = goatItemDataMapper.selectByConditionList(goatItemDataExample);
        GoatItemData gid;
        if (datas.size() == 1) {
            gid = datas.get(0);
        } else {
            gid = new GoatItemData();
            gid.setGoatId(goatId);
        }
        GoatVO vo=unserializeGoat(gid, getAlocation(goi.getLocalId()));
        vo.setSort(goi.getSort());
        vo.setRecommon(goi.getRecommon());
        return selGoatByVo(vo);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Goat, D extends GoatVO> T selGoatByVo(D goatVO) {
        if (goatVO.getClass().equals(GoatType.ImgGoat.getGoatVoClass())) {
            return (T) selImgGoat((ImgGoatVO) goatVO);
        }
        if (goatVO.getClass().equals(GoatType.TextGoat.getGoatVoClass())) {
            return (T) selTextGoat((TextGoatVO) goatVO);
        }
        if (goatVO.getClass().equals(GoatType.ItemGoat.getGoatVoClass())) {
            return (T) selItemGoat((ItemGoatVO) goatVO);
        }
        return null;
    }

    /**
     * 图片式广告对象制作
     *
     * @param imgGoatVO
     * @return
     */
    private ImgGoat selImgGoat(ImgGoatVO imgGoatVO) {
        ImgGoat goat = new ImgGoat() {
            @Override
            public void publish() {
                publishCommon(this);
            }

            @Override
            public void preparePublish(Long second) {
                preparePublishCommon(this,second);
            }

            @Override
            public void recommon(String recommon) {
                recommonCommon(this.getGoatId(),recommon);
            }

            @Override
            public void moveUp() throws GoatException {
                moveGoatCommon(this,true);
            }

            @Override
            public void moveDown() throws GoatException {
                moveGoatCommon(this,false);
            }
        };
        return BeanMapper.mapAbstact(imgGoatVO, goat);
    }

    /**
     * 商品式广告对象制作
     *
     * @param itemGoatVO
     * @return
     */
    private ItemGoat selItemGoat(final ItemGoatVO itemGoatVO) {
        ItemGoat goat = new ItemGoat() {

            /**
             * 修改广告时更新对应广告位之前商品搜索权重中的had_goat
             */
            private  void modifyLastGoodsForSearch() {
                Date now = new Date();
                Long goatId = itemGoatVO.getGoatId();
                GoatItemData goatItemData = new GoatItemData();
                goatItemData.setGoatId(goatId);
                goatItemData.setStatus(1);
                goatItemData = goatItemDataMapper.selectOne(goatItemData);
                if (goatItemData != null) {
                    Object lastItemIdStr = JSONObject.parseObject(goatItemData.getContext()).get("itemId");
                    if (lastItemIdStr == null || "".equals((lastItemIdStr.toString()).trim())) {
                        return;
                    }
                    Long lastItemId = Long.parseLong(lastItemIdStr.toString());
                    int step = DateUtil.daysOfTwo(goatItemData.getLastPublishTime(),now);
                    step = step>7?7:step;
                    GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
                    goodsCountForsearch.setGoodsId(lastItemId);
                    goodsCountForsearch = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
                    if(goodsCountForsearch != null && goodsCountForsearch.getHadGoat() != null) {
                        step += goodsCountForsearch.getHadGoat();
                        goodsCountForsearch.setHadGoat(step > 20 ? 20 : step);
                        goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearch);
                    }
                }
            }

            @Override
            public void publish()
            {
                modifyLastGoodsForSearch();
                publishCommon(this);
            }

            @Override
            public void preparePublish(Long second) {
                preparePublishCommon(this,second);
            }

            @Override
            public void recommon(String recommon) {
                recommonCommon(this.getGoatId(),recommon);
            }

            @Override
            public void moveUp() throws GoatException {
                moveGoatCommon(this,true);
            }

            @Override
            public void moveDown() throws GoatException {
                moveGoatCommon(this,false);
            }

            @Override
            public ItemUpVO selUp() {
                //查询真实值
                SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
                BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();

                QueryBuilder qb1 = QueryBuilders.termQuery("supperGoodsId", this.getItemId());//可能有微信上传的//所以直接用用户ID
                boleanQueryBuilder.must(qb1);
                srb.setQuery(boleanQueryBuilder);
                srb.setSearchType(SearchType.COUNT);
                SearchResponse response = srb.execute().actionGet();
                Long total = response.getHits().getTotalHits();

                //查询虚假值
                GoodsupNorealExample gnex=new GoodsupNorealExample();
                gnex.createCriteria().andItemIdEqualTo(this.getItemId());
                List<GoodsupNoreal> gunlist=goodsupNorealMapper.selectFieldsByExample(gnex
                        ,FieldUtil.codeFields("add_num "));
                GoodsupNoreal gun=null;
                if(gunlist.size()>0)
                    gun=gunlist.get(0);
                ItemUpVO iUVo=new ItemUpVO();
                iUVo.setRealNum(total==0?null:total);
                iUVo.setUnRealNum(gun==null?null:gun.getAddNum().longValue());
                return iUVo;

            }

            @Override
            public void modifyUp(Integer num) {
                GoodsupNoreal gn=new GoodsupNoreal();
                gn.setItemId(this.getItemId());
                gn=goodsupNorealMapper.selectOne(gn);
                if(gn==null){
                    gn=new GoodsupNoreal();
                    gn.setItemId(this.getItemId());
                    gn.setAddNum(num);
                    goodsupNorealMapper.insertSelective(gn);
                }else{
                    GoodsupNoreal g=new GoodsupNoreal();
                    g.setNorealId(gn.getNorealId());
                    g.setAddNum(gn.getAddNum()+num);
                    goodsupNorealMapper.updateByPrimaryKeySelective(g);
                }
            }

            @Override
            public Double selWeight() {
                return null;
            }

            @Override
            public void updateWeight(Double weight) {

            }
        };
        return BeanMapper.mapAbstact(itemGoatVO, goat);
    }

    /**
     * 文字式广告
     *
     * @param textGoatVO
     * @return
     */
    private TextGoat selTextGoat(TextGoatVO textGoatVO) {
        TextGoat goat = new TextGoat() {
            @Override
            public void publish() {
                publishCommon(this);
            }

            @Override
            public void preparePublish(Long second) {
                preparePublishCommon(this,second);
            }

            @Override
            public void recommon(String recommon) {
                recommonCommon(this.getGoatId(),recommon);
            }

            @Override
            public void moveUp() throws GoatException {
                moveGoatCommon(this,true);
            }

            @Override
            public void moveDown() throws GoatException {
                moveGoatCommon(this,false);
            }
        };
        return BeanMapper.mapAbstact(textGoatVO, goat);
    }

    /**
     * 序列化对象数据
     *
     * @param goat 广告数据
     * @param <T>  不同的广告类型
     * @return 数据库存储广告数据
     */
    private <T extends GoatVO> GoatItemData serializeGoat(T goat) {
        GoatItemData gid = BeanMapper.map(goat, GoatItemData.class);
        gid.setContext(JSON.toJSONString(goat));
        return gid;
    }

    /**
     * 反序列化对象数据
     *
     * @param data 数据库存储广告数据
     * @param <T>  不同广告类型
     * @return 广告数据
     */
    private <T extends GoatVO> T unserializeGoat(GoatItemData data, GoatLocation location) {
        if (data.getContext() == null) {
            data.setContext("{}");
        }
        T t = (T) JSON.parseObject(data.getContext(),
                GoatType.values()[location.getGoatType()].getGoatVoClass());
        BeanMapper.map(data, t);
        BeanMapper.map(location, t);
        return t;
    }

    private void rmCache(String code){
        final String INDEX_PAGE_REDIS_PRE="index_page_redis_pre_";
        //清除缓存,vo.getCode可能没值,需要通过goatId得到
        redisIO.del( INDEX_PAGE_REDIS_PRE + code);
    }

    /**
     * 发布广告
     *
     * @param vo
     */
    private <T extends GoatVO> void publishCommon(T vo) {

        GoatItemDataExample example=new GoatItemDataExample();
        example.createCriteria().andStatusEqualTo(1).andGoatIdEqualTo(vo.getGoatId());
        GoatItemData gid=new GoatItemData();
        gid.setStatus(0);
        goatItemDataMapper.updateByExampleSelective(gid,example);
        gid=serializeGoat(vo);
        goatItemDataMapper.insertSelective(gid);
        try {
            T gvo=selGoatById(vo.getGoatId());
            rmCache(gvo.getCode());
        } catch (GoatException e) {
            logger.error("上线清日志失败",e);
        }
    }

    private <T extends GoatVO> void preparePublishCommon(T vo,Long second){
        GoatItemDataExample example=new GoatItemDataExample();
        example.createCriteria().andStatusEqualTo(2).andGoatIdEqualTo(vo.getGoatId());
        GoatItemData gid=new GoatItemData();
        gid.setStatus(0);
        goatItemDataMapper.updateByExampleSelective(gid,example);
        gid=serializeGoat(vo);
        gid.setStatus(2);
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.SECOND,second.intValue());
        goatItemDataMapper.insertSelective(gid);
    }

    /**
     * 公共广告评论
     * @param goatId
     * @param recommon
     */
    private void recommonCommon(Long goatId,String recommon){
        GoatOneItem goi=new GoatOneItem();
        goi.setGoatId(goatId);
        goi.setRecommon(recommon);
        goatOneItemMapper.updateByPrimaryKeySelective(goi);
    }

    /**
     * 移动广告
     * @param up
     */
    private void moveGoatCommon(GoatVO goat,Boolean up) throws GoatException {
        GoatOneItemExample example=new GoatOneItemExample();
        GoatOneItemExample.Criteria cri=example.createCriteria().andLocalIdEqualTo(goat.getLocalId());
        if(up){
            cri.andSortLessThan(goat.getSort());
            example.setOrderByClause("sort desc");
        }else{
            cri.andSortGreaterThan(goat.getSort());
            example.setOrderByClause("sort asc");
        }
        example.setStartIndex(0);
        example.setEndIndex(1);

        List<GoatOneItem> gois=goatOneItemMapper.selectByConditionList(example);
        GoatOneItem target;
        int pianyi=0;//偏移量
        if(gois.size()==0){//到顶了
            example.clear();
            example.createCriteria().andLocalIdEqualTo(goat.getLocalId());
            if(up){
                example.setOrderByClause("sort desc");
                pianyi=1;
            }else{
                example.setOrderByClause("sort asc");
                pianyi=-1;
            }
            example.setStartIndex(0);
            example.setEndIndex(1);
            gois=goatOneItemMapper.selectByConditionList(example);
            if(gois.size()==0){
                throw new GoatException("广告数据异常");
            }
        }
        target=gois.get(0);
        //交换两个sort
        GoatOneItem goi=new GoatOneItem();
        goi.setGoatId(goat.getGoatId());
        goi.setSort(target.getSort()+pianyi);
        goatOneItemMapper.updateByPrimaryKeySelective(goi);
        if(pianyi==0){
            GoatOneItem goi2=new GoatOneItem();
            goi2.setGoatId(target.getGoatId());
            goi2.setSort(goat.getSort());
            goatOneItemMapper.updateByPrimaryKeySelective(goi2);
        }
        GoatOneLocation location=goatOneLocationMapper.selectByPrimaryKey(goat.getLocalId());
        rmCache(location.getLocalCode());
    }
}
