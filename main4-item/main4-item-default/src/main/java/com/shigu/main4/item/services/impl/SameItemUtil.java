package com.shigu.main4.item.services.impl;


import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.item.exceptions.SameItemException;
import com.shigu.main4.item.tools.Similarity;
import com.shigu.main4.item.vo.ItemKus;
import com.shigu.main4.item.vo.NowItemInfo;
import net.sf.json.JSONObject;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.get.*;
import org.elasticsearch.client.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 比较出相似款的方法
 * Created by zhaohongbo on 16/1/26.
 */
@Service("tae_utils_sameItemUtil")
public class SameItemUtil {

    @Resource(name="tae_mall_shiguGoodsTinyMapper")
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    /**
     * 添加新商品时调用
     * @param item 必须要带webSite
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String addItem(NowItemInfo item) throws SameItemException {
        //检测
        if(!checkItem(item)){
            throw new SameItemException("商品参数不全，[item本身, goodsId, created, storeId, title, webSite]不能为空");
        }
        //如果有主键说明是库里来的
        ItemKus items=getItems(item.getCreated(),item.getStoreId(),item.getCid(),item.getItemId(),null,item.getTitle(),item.getPiPrice(),item.getWebSite());
        String flag;
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        if(items.getAitems().size()>0){//A有的话
            if(item.getItemId().equals(items.getAitems().get(0).getGoodsId())){
                return "a";
            }
            sgt.setGoodsLevel("b");
            sgt.setRelationLevelId(items.getAitems().get(0).getGoodsId());
            flag="b";
        }else{//A没有话，自己变成A
            sgt.setGoodsLevel("a");
//            item.setGoodsId(item.getGoodsId());
            sgt.setRelationLevelId(item.getItemId());
            flag="a";
        }
        sgt.setWebSite(item.getWebSite());
        sgt.setGoodsId(item.getItemId());
        shiguGoodsTinyMapper.updateByPrimaryKeySelective(sgt);
        //修改ES里的数据
        changeEs(item.getItemId(),item.getWebSite(),sgt.getRelationLevelId(),flag);
        return flag;
    }

    /**
     * 下架商品时调用
     * @param item
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String removeItem(NowItemInfo item) throws SameItemException {
        if(item.getRelationLevelId()==null||item.getGoodsLevel()==null){//如果一开始就没有RelationLevelId与goodsLevel就不操作,返回
            return null;
        }
        //检测
        if(!checkItem(item)){
            throw new SameItemException("商品参数不全，[item本身, goodsId, created, storeId, title, webSite," +
                    "relationLevelId,goodsLevel]不能为空");
        }
        if(item.getGoodsLevel()==null||"b".equals(item.getGoodsLevel())){
            return null;//不用处理，直接下架就好
        }
        //如果是A类品
        ItemKus items=getItems(item.getCreated(),item.getStoreId(),item.getCid(),item.getItemId(),item.getRelationLevelId(),item.getTitle(),item.getPiPrice(),item.getWebSite());
        if(items.getBitems().size()>0){
            //把1个B转成A
            //现在的A变成B
            ShiguGoodsTiny bsgt=new ShiguGoodsTiny();
            bsgt.setGoodsId(items.getBitems().get(0).getGoodsId());
            bsgt.setGoodsLevel("a");
            bsgt.setWebSite(item.getWebSite());
            shiguGoodsTinyMapper.updateByPrimaryKeySelective(bsgt);
            //修改ES
            changeEs(item.getItemId(),item.getWebSite(),bsgt.getGoodsId(),bsgt.getGoodsLevel());
            ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
            example.setWebSite(item.getWebSite());
            example.createCriteria().andRelationLevelIdEqualTo(item.getRelationLevelId());

            List<ShiguGoodsTiny> goodsB=shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
            if(goodsB.size()>0){
                ShiguGoodsTiny tempsgt=new ShiguGoodsTiny();
                tempsgt.setRelationLevelId(bsgt.getGoodsId());
                shiguGoodsTinyMapper.updateByExampleSelective(tempsgt,example);
                //修改ES
                List<String> goodsIds=new ArrayList<>();
                for(ShiguGoodsTiny g:goodsB){
                    goodsIds.add(g.getGoodsId().toString());
                }
                changeMoreEsRelationId(item.getWebSite(),goodsIds,bsgt.getGoodsId());
            }
            return "a";
        }else{
            return null;
        }
    }

    /**
     * 修改es中多个数据
     * @param webSite
     * @param relationLevelId
     */
    public void changeMoreEsRelationId(String webSite,List<String> goodsIds,Long relationLevelId){
        //先查出淘宝条件的商品,再进行更新
        MultiGetRequestBuilder mgrbuilder=ElasticConfiguration.client.prepareMultiGet();
        String[] arr = new String[0];
        mgrbuilder.add("goods",webSite, goodsIds.toArray(arr));
        BulkRequestBuilder bulkRequest = ElasticConfiguration.client.prepareBulk();
        MultiGetResponse multiGetItemResponses=mgrbuilder.get();
        for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                Map<String,Object> map=response.getSourceAsMap();
                map.put("relation_level_id",relationLevelId);
                bulkRequest.add(ElasticConfiguration.client.prepareUpdate("goods", webSite,
                        map.get("goodsId").toString()).setDoc(JSONObject.fromObject(map)));
            }
        }
        bulkRequest.get();
    }

    /**
     * 修改Es中一个商品的level
     * @param itemId
     * @param relationLevelId
     * @param flag
     */
    public void changeEs(Long itemId,String webSite,Long relationLevelId,String flag){
        Client client = ElasticConfiguration.client;
        GetRequestBuilder request = client.prepareGet("goods", webSite, itemId.toString())
                .setOperationThreaded(false);
        GetResponse response = request.get();
        Map<String,Object> record=response.getSourceAsMap();
        if(record==null)return;
        int flagint=flag.equals("a")?0:1;
        //有变化再去更新
        if(record.get("goods_level")==null||
                !record.get("goods_level").toString().equals(flagint+"")||
                record.get("relation_level_id")==null||
                !record.get("relation_level_id").toString().equals(relationLevelId.toString())){
            record.put("goods_level",flagint);
            record.put("relation_level_id",flagint==0?0:relationLevelId);
            ElasticRepository elasticRepository=new ElasticRepository();

            elasticRepository.updateByKey(new SimpleElaBean("goods",webSite,
                    itemId.toString(), JSONObject.fromObject(record).toString()));
        }
    }

    /**
     * 取8点至次日8点的段内商品
     * @param created 淘宝商品的创建时间
     * @param storeId 店铺ID
     * @param cid   淘宝类目ID
     * @param goodsIdA 商品对应的A类品ID,如果是下架品，必选。上新请不要传
     * @param title 商品标题
     * @return 商品集合
     */
    private ItemKus getItems(Date created,Long storeId,Long cid,Long goodsId,Long goodsIdA,String title,String piprice,String webSite){
        //自动过滤掉不属于相似款的商品
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.setWebSite(webSite);
        ShiguGoodsTinyExample.Criteria cri=example.createCriteria();
        cri.andStoreIdEqualTo(storeId);
        cri.andCidEqualTo(cid);
        if(piprice!=null){
            cri.andPiPriceStringEqualTo(piprice);
        }
        //如果有goodsIdA则说明是下架情况，与created没有关系，直接按relation_level_id查
        if(goodsIdA!=null){
            cri.andRelationLevelIdEqualTo(goodsIdA);
        }else {
            //开始计算时间
        }
        List<ShiguGoodsTiny> list=shiguGoodsTinyMapper.selectByExample(example);
        ItemKus ik=new ItemKus();
//        String ptitle=parseTitle(title);
        for(ShiguGoodsTiny sgt:list){
            if(sgt.getGoodsId().equals(goodsId)){
                ik.setLastModifyTime(sgt.getLastModifyTime());
            }
            if(!isSimilar(title,sgt.getTitle())){//标题不符合
                continue;
            }
            if(sgt.getGoodsLevel()==null){
                ik.getUndefineds().add(sgt);
                continue;
            }
            if(sgt.getGoodsLevel().equals("a")){
                ik.getAitems().add(sgt);
                continue;
            }
            if(sgt.getGoodsLevel().equals("b")){
                ik.getBitems().add(sgt);
            }
        }
        return ik;
    }

    /**
     * 判断两个标题是否相似
     * @param title1
     * @param title2
     * @return
     */
    private boolean isSimilar(String title1,String title2){
        return Similarity.getSimilarity(title1,title2)>0.83;
    }
    /**
     * 标题去除(! * & $ # % @ 数字 空格  字母)
     * @param title
     * @return
     */
    @Deprecated
    private String parseTitle(String title){
        if(title!=null) {
            title = title.replace("!", "").replace("！", "").replace("*", "").replace("&", "").replace("$", "").replace("#", "").replace("%", "").replace(" ", "").replace("@", "");
            title = title.replaceAll("\\d", "").replaceAll("\\w", "");
        }
        return title;
    }
    /**
     * 检测商品是否支持被分类别
     * @param item
     * @return
     */
    private boolean checkItem(NowItemInfo item){
        if(item==null||item.getTitle()==null||item.getCreated()==null||item.getStoreId()==null||item.getItemId()==null||item.getWebSite()==null){
            return false;
        }
        return true;
    }
}
