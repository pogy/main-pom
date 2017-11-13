package com.shigu.main4.item.services.utils;

import com.aliyun.openservices.log.LogService;
import com.opentae.data.mall.beans.ShiguGoodsModified;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.item.bo.SynOneShopState;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.exceptions.SynException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.tools.OssIO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.shigu.main4.item.services.utils.OuterSynUtil.ModifiedStateEnum.HAS_LOCAL_DOWN;
import static com.shigu.main4.item.services.utils.OuterSynUtil.ModifiedStateEnum.HAS_LOCAL_UP;

/**
 * 类名：OuterSynUtil
 * 类路径：com.shigu.main4.item.services.utils.OuterSynUtil
 * 创建者：王浩翔
 * 创建时间：2017-11-05 11:45
 * 项目：main-pom
 * 描述：
 */
public abstract class OuterSynUtil {
    public static final Logger logger = LoggerFactory.getLogger(OuterSynUtil.class);
    @Autowired
    protected ShiguShopMapper shiguShopMapper;
    @Autowired
    protected ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    protected ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;
    @Autowired
    protected ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
    @Autowired
    protected TaobaoItemPropMapper taobaoItemPropMapper;
    @Autowired
    protected TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    protected OssIO ossIO;
    @Autowired
    protected ItemAddOrUpdateService itemAddOrUpdateService;

    protected static Map<Long,Integer> queryingMap=new HashMap<>();
    public void synOneShop(Long shopId) {
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if (shiguShop != null) {
            //生成本地应同步数据
            SynShopBean synShopBean = new SynShopBean(shiguShop);
            //获取并处理分页同步数据
            execute(synShopBean);
        }
    }
    public void synOneShop(Long shopId, Long otherShopId){
        synOneShop(shopId,otherShopId,null);
    }


    public void synOneShop(Long shopId, Long otherShopId,String startDate) {
        if(queryingMap.get(otherShopId)!=null){
            return;
        }
        queryingMap.put(otherShopId,1);
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if (shiguShop != null) {
            Document shopHtml;
            try {
                shopHtml = JsoupUtil.getHtml(String.format("https://wsy.com/%d", otherShopId));
            } catch (IOException e) {
                return;
            }
            List<Long> commondIds=new ArrayList<>();
            Elements tuijians=shopHtml.select(".edit-recommend");
            if(tuijians.size()>0){
                Elements commondItems=tuijians.get(0).select(".li-i1").select("a");
                for(Element element:commondItems){
                    commondIds.add(new Long(element.attr("href").trim().split("id=")[1]));
                }
            }
            //生成本地应同步数据
            SynShopBean synShopBean = new SynShopBean(shiguShop, otherShopId, commondIds,startDate);
            //获取并处理分页同步数据
            execute(synShopBean);
        }
        queryingMap.remove(otherShopId);
    }

    public void synOneGoods(Long shopId,Long otherShopId,Long otherGoodsId){
        queryingMap.put(otherShopId,1);
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if (shiguShop != null) {
            Document shopHtml;
            try {
                shopHtml = JsoupUtil.getHtml(String.format("https://wsy.com/%d", otherShopId));
            } catch (IOException e) {
                return;
            }
            List<Long> commondIds=new ArrayList<>();
            Elements tuijians=shopHtml.select(".edit-recommend");
            if(tuijians.size()>0){
                Elements commondItems=tuijians.get(0).select(".li-i1").select("a");
                for(Element element:commondItems){
                    commondIds.add(new Long(element.attr("href").trim().split("id=")[1]));
                }
            }
            //生成本地应同步数据
            SynShopBean synShopBean = new SynShopBean(shiguShop, otherShopId, commondIds,null);
            //获取并处理分页同步数据
            goodsExecute(synShopBean,otherGoodsId);
        }
    }

    public Map<Long, ShiguGoodsModified> getModifyMap(List<Long> goodsIds) {
        if (goodsIds == null||goodsIds.size()==0) {
            return new HashMap<>();
        }
        ShiguGoodsModifiedExample shiguGoodsModifiedExample = new ShiguGoodsModifiedExample();
        shiguGoodsModifiedExample.createCriteria().andItemIdIn(goodsIds);
        HashMap<Long, ShiguGoodsModified> resultMap = new HashMap<>();
        for (ShiguGoodsModified modify : shiguGoodsModifiedMapper.selectByExample(shiguGoodsModifiedExample)) {
            resultMap.put(modify.getItemId(),modify);
        }
        return resultMap;
    }

    public void updateGoods(Long goodsId, Long outGoodsId,SynShopBean synShopBean,Long cid) throws ItemModifyException, SynException {
        SynItem goodsInfo = getGoodsInfo(outGoodsId,synShopBean,cid);
        goodsInfo.setGoodsId(goodsId);
        itemAddOrUpdateService.systemUpdateItem(goodsInfo);
    }


    protected abstract void goodsExecute(SynShopBean synBean,Long otherGoodsId);

    /**
     * 获取同步数据并进行处理
     *
     * @param synBean
     */
    public void execute(SynShopBean synBean) {
        int pageNo = 0;
        while (true) {
            try {
                //获取分页同步数据
                Map<Long, ?> pagedGoodsInfo = getPagedGoodsInfo(synBean, ++pageNo);
                //将同步到的数据主键添加到同步结果主键集合
                Set<Long> currentSynOuterIds = pagedGoodsInfo.keySet();
                synBean.synOuterIdList.addAll(currentSynOuterIds);
                //更新同步来源在售且本地档口在售商品
                List<Long> onSales = new ArrayList<>(currentSynOuterIds);
                onSales.retainAll(synBean.localOuterIdList);
                synUpdateItems(synBean, onSales, pagedGoodsInfo);
                //更新同步来源在售且本地档口不在售商品
                List<Long> notOnSales = new ArrayList<>(currentSynOuterIds);
                notOnSales.removeAll(onSales);
                synNotOnSaleItems(synBean, notOnSales, pagedGoodsInfo);
            } catch (SynException e) {
                //正常分页信息获取结束
                if (SynException.SynExceptionEnum.END_OF_PAGED_SYN_INFO_EXCEPTION.equals(e.getSynExceptionEnum())) {
                    break;
                }
                //无法获取同步数据，直接结束
                if (SynException.SynExceptionEnum.COULD_NOT_GET_SYN_INFO_EXCEPTION.equals(e.getSynExceptionEnum())) {
                    return;
                }
            }

        }
        //处理同步下架本地未下架数据
        synDownItems(synBean);
        logger.info(synBean.state.toString());
    }




    public class SynShopBean {
        //与外部同步的档口
        public final ShiguShop shop;
        //本次店铺同步数据
        public final SynOneShopState state;
        //商品修改map，key为goodsId
        private Map<Long, ShiguGoodsModified> modifiedMap;
        //商品数据map，key为外部导入商品外部主键
        public Map<Long, ShiguGoodsTiny> tinyMap;
        //本地外部id列表
        private List<Long> localOuterIdList;
        //同步外部id列表
        private List<Long> synOuterIdList;
        //外部档口ID
        public Long otherShopId;

        public List<Long> commonIds;

        public String startDate;

        public SynShopBean(ShiguShop shop) {
            //同步的店铺
            this.shop = shop;
            //本次同步店铺信息
            this.state = new SynOneShopState(shop.getShopId());
            init();
        }

        public SynShopBean(ShiguShop shop, Long otherShopId,List<Long> commonIds,String startDate) {
            //同步的店铺
            this.shop = shop;
            //本次同步店铺信息
            this.state = new SynOneShopState(shop.getShopId());
            //外部档口ID
            this.otherShopId=otherShopId;
            this.commonIds=commonIds;
            this.startDate=startDate;
            init();
        }

        void init() {
            //产生同步外部主键与上架商品的map
            tinyMap = OuterSynUtil.this.getLocalOuterGoodsMap(shop.getShopId(), shop.getWebSite());
            //产生商品修改map
            HashSet<Long> goodsIds = new HashSet<>();
            for (ShiguGoodsTiny tiny : tinyMap.values()) {
                goodsIds.add(tiny.getGoodsId());
            }
            modifiedMap = OuterSynUtil.this.getModifyMap(new ArrayList<Long>(goodsIds));
            //产生本地外部主键集合
            localOuterIdList = new ArrayList<>(tinyMap.keySet());
            //同步产生外部主键集合
            synOuterIdList = new ArrayList<>();
        }
    }

    public class ImgUploadInfo{
        public URL url;
        public String file;
        public ImgUploadInfo(URL url,String file){
            this.file=file;
            this.url=url;
        }
    }



    /**
     * 下架对应同步来源中来源已下架而本地未下架并且本地未修改商品
     *
     * @param synShopBean
     */
    protected void synDownItems(SynShopBean synShopBean) {
        SynOneShopState state = synShopBean.state;
        List<Long> downOuterIds = new ArrayList<>(synShopBean.localOuterIdList);
        downOuterIds.removeAll(synShopBean.synOuterIdList);
        Map<Long, ShiguGoodsTiny> tinyMap = synShopBean.tinyMap;
        Map<Long, ShiguGoodsModified> modifiedMap = synShopBean.modifiedMap;
        if (downOuterIds.size() > 0) {
            for (Long outerId : downOuterIds) {
                Long goodsId = tinyMap.get(outerId).getGoodsId();
                //商品没有做过手动上架
                if (!checkLocalModified(modifiedMap.get(goodsId), HAS_LOCAL_UP)) {
                    try {
                        itemAddOrUpdateService.systemDownItem(goodsId);
                        state.addDown();
                    } catch (ItemModifyException e) {
                        state.addErrorReason(outerId, e.getMessage());
                        logger.error("下架错误", e);
                    }
                } else {
                    //手动上架的不处理
                    state.addUnprocessed(outerId);
                }
            }
        }
    }

    /**
     * 更新同步来源中上架且本地上架商品
     *
     * @param synShopBean
     * @param outerIds      要更新的外部主键
     * @param goodsInfosMap
     */
    protected void synUpdateItems(SynShopBean synShopBean, Collection<Long> outerIds, Map<Long, ?> goodsInfosMap) {
        Map<Long, ShiguGoodsTiny> tinyMap = synShopBean.tinyMap;
        Map<Long, ShiguGoodsModified> modifiedMap = synShopBean.modifiedMap;
        SynOneShopState state = synShopBean.state;

        Jobs jobs=new Jobs(10) {
            @Override
            public void doWork(Object o) throws Exception {
                Long outerId=(Long)o;
                ShiguGoodsTiny tiny = tinyMap.get(outerId);
                //如果本地商品数据与数据来源不同步，尝试进行更新
                if (!checkGoodsSyn(tiny, goodsInfosMap.get(outerId))) {
                    try {
                        updateGoods(tiny.getGoodsId(), outerId,synShopBean, (Long) goodsInfosMap.get(outerId));
                        state.addUpdated();
                    } catch (ItemModifyException | SynException e) {
                        state.addErrorReason(outerId, e.getMessage());
                        logger.error("更新错误", e);
                    }
                } else {
                    state.addUnchanged();
                }
            }
        };

        if (outerIds.size() > 0) {
            for (Long outerId : outerIds) {
                jobs.addJob(outerId);
            }
        }
        jobs.join();
    }

    /**
     * 更新同步来源中上架而本地未上架商品
     * 本地下架，则重新上架，本地不存在，则创建
     *
     * @param synShopBean
     * @param outerIds
     * @param goodsInfosMap
     */
    protected void synNotOnSaleItems(SynShopBean synShopBean, Collection<Long> outerIds, Map<Long, ?> goodsInfosMap) {
        SynOneShopState state = synShopBean.state;
        List<Long> outIds = new ArrayList<>(outerIds);
        Map<Long, ShiguGoodsSoldout> synLocalSoldoutMap = getSynLocalSoldoutMap(outIds, synShopBean.shop.getShopId(), synShopBean.shop.getWebSite());
        if (synLocalSoldoutMap.size() > 0) {
            ShiguGoodsModifiedExample modifiedExample = new ShiguGoodsModifiedExample();
            List<Long> goodsIds = BeanMapper.getFieldList(synLocalSoldoutMap.values(), "goodsId", Long.class);
            modifiedExample.createCriteria().andItemIdIn(goodsIds);
            Map<Long, ShiguGoodsModified> modifiedMap = BeanMapper.list2Map(shiguGoodsModifiedMapper.selectByExample(modifiedExample),"itemId",Long.class);
            ////有需要时可以把已下架的修改数据放入修改表中
            //synShopBean.modifiedMap.putAll(modifiedMap);

            Jobs jobs=new Jobs(10) {
                @Override
                public void doWork(Object o) throws Exception {
                    Map.Entry<Long, ShiguGoodsSoldout> soldoutEntry= (Map.Entry<Long, ShiguGoodsSoldout>) o;
                    Long outerId = soldoutEntry.getKey();
                    Long goodsId = soldoutEntry.getValue().getGoodsId();
                    outIds.remove(outerId);
                    if (!checkLocalModified(modifiedMap.get(goodsId), HAS_LOCAL_DOWN)) {
                        try {
                            itemAddOrUpdateService.systemUpItem(goodsId);
                            state.addUp();
                        } catch (ItemModifyException e) {
                            state.addErrorReason(outerId, e.getMessage());
                            logger.error("上架错误", e);
                        }
                    } else {
                        //手动下架的不处理
                        state.addUnprocessed(outerId);
                    }
                }
            };
            for (Map.Entry<Long, ShiguGoodsSoldout> soldoutEntry : synLocalSoldoutMap.entrySet()) {
                jobs.addJob(soldoutEntry);
            }
            jobs.join();
        }
        Jobs jobs=new Jobs(10) {
            @Override
            public void doWork(Object o) throws Exception {
                SynItem goodsInfo=null;
                Long outId= (Long) o;
                try {
                    goodsInfo = getGoodsInfo(outId,synShopBean, (Long) goodsInfosMap.get(outId));
                    itemAddOrUpdateService.systemAddItem(goodsInfo);
                    state.addCreated();
                } catch (SynException | ItemModifyException e) {
                    state.addErrorReason(outId, e.getMessage());
                    logger.error("商品发布错误", e);
                }
            }
        };

        for (Long outId : outIds) {
            jobs.addJob(outId);
        }
        jobs.join();

    }

    /**
     * 获取对应同步来源本地上架商品
     *
     * @param shopId
     * @param webSite
     * @return
     */
    protected abstract Map<Long, ShiguGoodsTiny> getLocalOuterGoodsMap(Long shopId, String webSite);

    /**
     * 获取档口中同步来源在售，本地下架的商品
     *
     * @param outerIds
     * @param shopId
     * @param webSite
     * @return
     */
    protected abstract Map<Long, ShiguGoodsSoldout> getSynLocalSoldoutMap(List<Long> outerIds, Long shopId, String webSite);

    /**
     * 获取分页同步数据
     * 抛出SynException中SynExceptionEnum值为END_OF_PAGED_SYN_INFO_EXCEPTION时，代表获取分页信息结束，跳出循环
     *
     * @param synShopBean
     * @param pageNo
     * @return
     * @throws SynException
     */
    protected abstract Map<Long, ?> getPagedGoodsInfo(SynShopBean synShopBean, int pageNo) throws SynException;

    /**
     * 获取外部商品信息
     *
     * @param outGoodsId
     * @return
     * @throws IOException
     */
    protected abstract SynItem getGoodsInfo(Long outGoodsId,SynShopBean synShopBean,Long cid) throws SynException;

    /**
     * 检查同步来源是否进行过更新
     *
     * @param goods
     * @param synGoods
     * @return
     */
    protected abstract boolean checkGoodsSyn(ShiguGoodsTiny goods, Object synGoods);

    /**
     * 查看商品是否被手动修改过
     *
     * @param modified
     * @param modifiedState
     * @return
     */
    protected abstract boolean checkLocalModified(ShiguGoodsModified modified, ModifiedStateEnum modifiedState);

    public enum ModifiedStateEnum {
        //HAS_LOCAL_MODIFIED("手动修改过"),
        HAS_LOCAL_UP("手动上架过"),
        HAS_LOCAL_DOWN("手动下架过"),;
        public final String status;

        ModifiedStateEnum(String status) {
            this.status = status;
        }
    }
}