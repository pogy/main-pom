package com.shigu.main4.goat.service.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.GoatItemData;
import com.opentae.data.mall.beans.GoatOneItem;
import com.opentae.data.mall.beans.GoatOneLocation;
import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.examples.GoatItemDataExample;
import com.opentae.data.mall.examples.GoatOneItemExample;
import com.opentae.data.mall.examples.GoatOneLocationExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.interfaces.GoatItemDataMapper;
import com.opentae.data.mall.interfaces.GoatOneItemMapper;
import com.opentae.data.mall.interfaces.GoatOneLocationMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ImgGoat;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.beans.TextGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ImgGoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import com.shigu.main4.goat.vo.TextGoatVO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service("goatFactory")
public class GoatFactoryImpl implements GoatFactory {

    @Autowired
    GoatOneLocationMapper goatOneLocationMapper;

    @Resource(name = "tae_mall_goatOneItemMapper")
    GoatOneItemMapper goatOneItemMapper;

    @Resource(name = "tae_mall_goatItemDataMapper")
    GoatItemDataMapper goatItemDataMapper;

    @Resource(name="tae_mall_goodsupNorealMapper")
    GoodsupNorealMapper goodsupNorealMapper;

    @Override
    public GoatLocation getAlocation(Long localId) throws GoatException {
        GoatOneLocation local = goatOneLocationMapper.selectByPrimaryKey(localId);
        if (local == null) {
            throw new GoatException("广告位置ID:" + localId + "不存在");
        }
        return getALocationByVo(BeanMapper.map(local, GoatLocationVO.class));
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
            gidex.createCriteria().andGoatIdIn(gIdlist).andStatusEqualTo(status);
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
            rlist.add((T) unserializeGoat(gid, local));
        }
        return rlist;
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) throws GoatException {
        //查广告
        GoatOneItem goi = goatOneItemMapper.selectByPrimaryKey(goatId);
        if (goi == null) {
            throw new GoatException("广告id:" + goatId + "不存在");
        }
        //查出在线广告数据
        GoatItemDataExample goatItemDataExample = new GoatItemDataExample();
        goatItemDataExample.createCriteria().andGoatIdEqualTo(goatId).andStatusEqualTo(1);
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
        return selGoatByVo(unserializeGoat(gid, getAlocation(goi.getLocalId())));
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

            }

            @Override
            public void preparePublish(Long second) {

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
    private ItemGoat selItemGoat(ItemGoatVO itemGoatVO) {
        ItemGoat goat = new ItemGoat() {
            @Override
            public void publish() {
                publishCommon(this);
            }

            @Override
            public void preparePublish(Long second) {
                preparePublishCommon(this,second);
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
        T t = (T) JSON.parseObject(data.getContext(),
                GoatType.values()[location.getGoatType()].getGoatVoClass());
        BeanMapper.map(data, t);
        BeanMapper.map(location, t);
        return t;
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
    }

    private <T extends GoatVO> void preparePublishCommon(T vo,Long second){
        GoatItemDataExample example=new GoatItemDataExample();
        example.createCriteria().andStatusEqualTo(1).andGoatIdEqualTo(vo.getGoatId());
        GoatItemData gid=new GoatItemData();
        gid.setStatus(0);
        goatItemDataMapper.updateByExampleSelective(gid,example);
        gid=serializeGoat(vo);
        gid.setStatus(2);
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.SECOND,second.intValue());
        gid.setPublishSchdule(cal.getTime());
        goatItemDataMapper.insertSelective(gid);
    }




}
