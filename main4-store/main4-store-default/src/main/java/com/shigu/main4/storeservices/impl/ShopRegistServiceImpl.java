package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.exceptions.ShopExamineException;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.exceptions.TaobaoNickBindException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.storeservices.ShopToEsService;
import com.shigu.main4.vo.*;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ShopGetRequest;
import com.taobao.api.response.ShopGetResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("shopRegistService")
public class ShopRegistServiceImpl extends ShopServiceImpl implements ShopRegistService {

    private static final Logger logger = LoggerFactory.getLogger(ShopRegistServiceImpl.class);

    @Resource(name = "tae_mall_shiguShopApplyMapper")
    private ShiguShopApplyMapper shiguShopApplyMapper;

    @Resource(name = "tae_mall_shiguShopLicenseMapper")
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguSiteMapper")
    private ShiguSiteMapper shiguSiteMapper;

    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    @Autowired
    private ShopFitmentService shopFitmentService;

    @Autowired
    private ShopToEsService shopToEsService;

    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;

    @Value("${taobao.app.key}")
    private String appKey;

    @Autowired
    private TaobaoClient taobaoClient;

    /**
     * 注册用户
     * 1、档口已经被注册的，不能重复注册
     * 2、本用户已经有待审核的，档口号相同的，作为修改信息处理
     *
     * @param shop 申请信息
     *
     * @return 申请表的ID
     */
    @Override
    public long registShop(ShopRegister shop) throws ShopRegistException {
        ShiguShopApply apply = new ShiguShopApply();
        apply.setShopNum(shop.getShopNum());
        apply.setMarketId(shop.getMarketId());
        if (StringUtils.isEmpty(apply.getShopNum()) || shop.getMarketId() == null)
            throw new ShopRegistException("市场或档口号不能为空");
        List<ShiguShopApply> shopApplies = shiguShopApplyMapper.select(apply);

        Long updateApplyId = null;
        loop: for (ShiguShopApply shopApply : shopApplies) {
            //1表示可审核，0表示信息不齐不可审核，2表示审核完毕，不能再审核
            switch (shopApply.getCanExamine()) {
                case 0:
                case 1:
                    logger.debug("更新店铺申请 档口：" + apply.getShopNum());
                    updateApplyId = shopApply.getRuzhuId();// 更新原来的注册信息
                    break loop;
                default:
            }
        }
        apply.setRuzhuId(updateApplyId);
        apply.setCanExamine(shop.isCanExamine()?1:0);//这里写死是不对的
        apply.setEmail(shop.getEmail());
        apply.setFloorId(shop.getFloorId());
        apply.setImQq(shop.getImQq());
        apply.setImWx(shop.getImWx());
        apply.setIp(shop.getIp());
        apply.setMainBus(shop.getMainBus());
        apply.setMarketId(shop.getMarketId());
        apply.setTags(shop.getTags());
        apply.setTbNick(shop.getTbNick());
        apply.setTelephone(shop.getTelephone());
        apply.setUserId(shop.getUserId());
        apply.setWebSite(shop.getWebSite());
        apply.setApplyTime(new Date());
        apply.setImAliww(shop.getImAliww());
        if (StringUtils.isNotEmpty(apply.getTbNick())) {
            TaobaoSessionMapExample map = new TaobaoSessionMapExample();
            map.setStartIndex(0);
            map.setEndIndex(1);
            map.createCriteria().andNickEqualTo(apply.getTbNick()).andAppkeyEqualTo(appKey);
            List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectByConditionList(map);
            if (!taobaoSessionMaps.isEmpty()) {
                TaobaoSessionMap taobaoSessionMap = taobaoSessionMaps.get(0);
                if (taobaoSessionMap.getUserId() != null) {
                    apply.setTbuserId(taobaoSessionMap.getUserId().toString());
                }
            }

            ShopGetRequest req = new ShopGetRequest();
            req.setFields("sid");
            req.setNick(apply.getTbNick());
            try {
                ShopGetResponse response = taobaoClient.execute(req);
                Long taobaoShopId = response.getShop().getSid();
                apply.setTbshopId(taobaoShopId.toString());
                apply.setTbUrl("http://shop" + taobaoShopId +".taobao.com");
            } catch (Exception e) {
                logger.error("淘宝接口失败", e);
            }
        }
        
        if (apply.getRuzhuId() == null)
            shiguShopApplyMapper.insertSelective(apply);
        else
            shiguShopApplyMapper.updateByPrimaryKeySelective(apply);
        return apply.getRuzhuId();
    }

    /**
     * 1、用户名下店铺（开店状态）数量为0
     * 2、本市场下，档口号唯一
     *
     * 准入条件，适用场景
     * a、店铺审核通过
     * b、开店
     * @param userId 用户ID
     * @param marketId 市场ID
     * @param shopNum 档口号
     * @return 是否准入
     */
    @Override
    public boolean shopCanOpen(Long userId,String nick, Long marketId, String shopNum) throws ShopExamineException {
        if (marketId == null || StringUtils.isEmpty(shopNum)) {
            throw new ShopExamineException("marketId、shopNum参数不能为null");
        }
//如果用户存在,检测用户相关的
        if(userId!=null) {
            MemberUserSub memberUserSub = new MemberUserSub();
            memberUserSub.setAccountType(3);
            memberUserSub.setUserId(userId);
            memberUserSub = memberUserSubMapper.selectOne(memberUserSub);

            if (memberUserSub != null) {
                if (nick != null && !"".equals(nick) && !memberUserSub.getSubUserName().equals(nick)) {//如果是淘宝店开店,用户绑定的淘宝,不能和店的不同
                    throw new TaobaoNickBindException("用户绑定的淘宝账号[" + memberUserSub.getSubUserName() + "]与店铺淘宝账号[" + nick + "]不同,不能开店");
                }
                ShiguShop shop = new ShiguShop();
                shop.setTbNick(memberUserSub.getSubUserName());
                shop.setShopStatus(0);
                shop = shiguShopMapper.selectOne(shop);
                if (shop != null) {
                    throw new TaobaoNickBindException(userId + "的淘宝账号已经绑定给其它账号");
                }
            }
            //检测一下用户有没有开过店
            //检测一下档口号
            ShiguShopExample shiguShopExample = new ShiguShopExample();
            shiguShopExample.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andShopStatusEqualTo(0);//店铺状态正常开店
            if(shiguShopMapper.countByExample(shiguShopExample)>0){
                throw new TaobaoNickBindException("用户已经开过店,一个用户不能同时开两家店");
            }
        }
        //如果昵称不存在,检测昵称有没有被用过
        if(StringUtils.isNotEmpty(nick)){
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andShopStatusEqualTo(0).andTbNickEqualTo(nick);
            if(shiguShopMapper.countByExample(shopExample) > 0){
                throw new TaobaoNickBindException("淘宝账号【"+nick+"】已经开过店,一个淘宝账号只能开一次");
            }
        }
        // 检测档口号有没有被使用
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andMarketIdEqualTo(marketId).andShopNumEqualTo(shopNum).andShopStatusEqualTo(0);
            // 本市场下档口号唯一
            return shiguShopMapper.countByExample(shopExample) == 0;
    }

    /**
     * 淘宝店绑定注册申请信息
     *
     * @param registId 申请表ID
     * @param tbshopId 淘宝店ID
     * @param tbuserId 淘宝用户ID
     * @param tbNick   淘宝用户昵称
     * @param tbUrl    @return 是否完成
     */
    @Override
    public boolean completeRegist(Long registId, Long tbshopId, Long tbuserId, String tbNick, String tbUrl) {
        ShiguShopApply apply = new ShiguShopApply();
        apply.setRuzhuId(registId);
        apply.setCanExamine(1);
        if (tbshopId != null)
            apply.setTbshopId(tbshopId.toString());
        if (tbuserId != null)
            apply.setTbuserId(tbuserId.toString());
        apply.setTbNick(tbNick);
        apply.setTbUrl(tbUrl);
        apply.setApplyTime(new Date());
        return shiguShopApplyMapper.updateByPrimaryKeySelective(apply) == 1;
    }

    /**
     * 查询用户开店申请
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ShiguPager<ShopApply> selApplysByUserId(Long userId, Integer pageNo, Integer pageSize) {
        ShiguPager<ShopApply> shopApplyShiguPager = new ShiguPager<ShopApply>();
        if(userId == null){
            return shopApplyShiguPager;
        }
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        ShiguShopApplyExample shopApplyExample = new ShiguShopApplyExample();
        shopApplyExample.createCriteria().andUserIdEqualTo(userId).andCanExamineNotEqualTo(0);
        shopApplyExample.setStartIndex(pageSize * (pageNo -1));
        shopApplyExample.setEndIndex(pageSize);
        List<ShiguShopApply> shopApplyList = shiguShopApplyMapper.selectByConditionList(shopApplyExample);
        int count = shiguShopApplyMapper.countByExample(shopApplyExample);
        List<ShopApply> shopApplyzList = new ArrayList<>();
        for(ShiguShopApply ssa:shopApplyList){
            ShopApply sa=BeanMapper.map(ssa,ShopApply.class);
            sa.setStatus(ssa.getApplyStatus());

            ShiguMarket shiguMarket = new ShiguMarket();
            shiguMarket.setMarketId(ssa.getMarketId());
            shiguMarket = shiguMarketMapper.selectOne(shiguMarket);
            if(shiguMarket != null){
                sa.setMarket(shiguMarket.getMarketName());
            }

            shopApplyzList.add(sa);
        }
        shopApplyShiguPager.setContent(shopApplyzList);
        shopApplyShiguPager.setNumber(pageNo);
        shopApplyShiguPager.calPages(count, pageSize);
        return shopApplyShiguPager;
    }

    @Override
    public void delApply(Long userId, Long applyId) throws ShopRegistException {
        ShiguShopApplyExample example=new ShiguShopApplyExample();
        example.createCriteria().andUserIdEqualTo(userId).andRuzhuIdEqualTo(applyId);
        if(shiguShopApplyMapper.deleteByExample(example)==0){
            throw new ShopRegistException("删除开店申请失败");
        }
    }

    /**
     * 申请查询
     * @param userId
     * @param ruzhuId
     * @return
     */
    @Override
    public ShopApplyDetail selDetailById(Long userId, Long ruzhuId) {
        if(userId == null && ruzhuId == null){
            return null;
        }
        ShiguShopApplyExample shopApplyExample = new ShiguShopApplyExample();
        ShiguShopApplyExample.Criteria criteria = shopApplyExample.createCriteria();
        criteria.andCanExamineNotEqualTo(0);
        if(userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if(ruzhuId != null){
            criteria.andRuzhuIdEqualTo(ruzhuId);
        }
        List<ShiguShopApply> shiguShopApplyList = shiguShopApplyMapper.selectByExample(shopApplyExample);
        if(shiguShopApplyList.size() == 0){
            return null;
        }
        ShiguShopApply shiguShopApply = shiguShopApplyList.get(0);
        ShopApplyDetail shopApplyDetail = BeanMapper.map(shiguShopApply, ShopApplyDetail.class);

        // 市场名称
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setMarketId(shopApplyDetail.getMarketId());
        shiguMarket = shiguMarketMapper.selectOne(shiguMarket);
        if(shiguMarket != null){
            shopApplyDetail.setMarket(shiguMarket.getMarketName());
        }
        // 楼层名称
        shiguMarket = new ShiguMarket();
        shiguMarket.setMarketId(shopApplyDetail.getFloorId());
        shiguMarket = shiguMarketMapper.selectOne(shiguMarket);
        if(shiguMarket != null){
            shopApplyDetail.setFloor(shiguMarket.getMarketName());
        }

        String tags = shiguShopApply.getTags();
        if(!StringUtils.isEmpty(tags)){
            String [] szTags = tags.split(",");
            List<ShiguTags> shiguTagsList = new ArrayList<ShiguTags>();
            for(int i = 0;i<szTags.length;i++){
                shiguTagsList.add(ShiguTags.getShiguTags(szTags[i]));
            }
            shopApplyDetail.setTagsList(shiguTagsList);
        }
        shopApplyDetail.setReason(shiguShopApply.getRefuseReason());
        return shopApplyDetail;
    }

    /**
     * 重新提交开店申请
     * @param userId
     * @param ruzhuId
     */
    @Override
    public void resubmitShopApply(Long userId, Long ruzhuId) throws Main4Exception {
        if(userId == null && ruzhuId == null){
            throw new Main4Exception("重新开店申请数据有误");
        }
        ShiguShopApplyExample shopApplyExample = new ShiguShopApplyExample();
        ShiguShopApplyExample.Criteria criteria = shopApplyExample.createCriteria();
        if(userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if(ruzhuId != null){
            criteria.andRuzhuIdEqualTo(ruzhuId);
        }
        List<ShiguShopApply> shiguShopApplyList = shiguShopApplyMapper.selectByExample(shopApplyExample);
        if(shiguShopApplyList.size() == 0){
            throw new Main4Exception("重新开店未找到申请数据");
        }
        ShiguShopApply shiguShopApply = shiguShopApplyList.get(0);
        if(shiguShopApply.getCanExamine() != 1){
            throw new Main4Exception("申请数据资料不全，无法重新开店");
        }
        if(shiguShopApply.getApplyStatus()!=2){
            throw new Main4Exception("重新开店申请状态有误");
        }
        shiguShopApply.setApplyStatus(0);
        shiguShopApplyMapper.updateByPrimaryKeySelective(shiguShopApply);
    }

    /**
     * 审核店铺
     *      请求记录中应至少包含 shopNum、marketId、userId
     *      CanExamine == 1
     *
     * @param registId 申请ID
     *
     * @return 新店铺ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long toExamine(Long registId) throws ShopExamineException {
        return toExamine(registId, null);
    }

    @Override
    public long toExamine(Long registId, String operator) throws ShopExamineException {
        ShiguShopApply shiguShopApply = shiguShopApplyMapper.selectByPrimaryKey(registId);

        //如果申请记录为不可审核的，返回异常
        if (shiguShopApply == null
                || StringUtils.isEmpty(shiguShopApply.getShopNum())
                || shiguShopApply.getMarketId() == null
                || shiguShopApply.getUserId() == null)
            throw new ShopExamineException("申请无效");

        if (shiguShopApply.getCanExamine() == 0)
            throw new ShopExamineException("信息不全，请求无法处理");

        if (shiguShopApply.getCanExamine() == 2)
            throw new ShopExamineException("已经处理过的申请");

        if (!shopCanOpen(shiguShopApply.getUserId(),shiguShopApply.getTbNick(), shiguShopApply.getMarketId(), shiguShopApply.getShopNum()))
            throw new ShopExamineException("该申请不符合准入条件");

        //如果审核瞬间店铺已经存在，返回异常
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.setStartIndex(0);
        shiguShopExample.setEndIndex(1);
        shiguShopExample.createCriteria()
                .andShopNumEqualTo(shiguShopApply.getShopNum())
                .andMarketIdEqualTo(shiguShopApply.getMarketId()).andShopStatusEqualTo(0);
        List<ShiguShop> shiguShops
                = shiguShopMapper.selectFieldsByConditionList(shiguShopExample, FieldUtil.codeFields("shop_id"));
        if (!shiguShops.isEmpty())
            throw new ShopExamineException("店铺已存在");

        // 开始审核流程
        // 1. 创建ShiguShop
        //      mainBus 主营信息、mail、ip、tbshopId、tbuserId
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setUserId(shiguShopApply.getUserId());
        shiguShop.setShopNum(shiguShopApply.getShopNum());
        shiguShop.setTelephone(shiguShopApply.getTelephone());
        shiguShop.setImWx(shiguShopApply.getImWx());
        shiguShop.setImQq(shiguShopApply.getImQq());
        shiguShop.setWebSite(shiguShopApply.getWebSite());
        shiguShop.setMarketId(shiguShopApply.getMarketId());
        shiguShop.setFloorId(shiguShopApply.getFloorId());
        shiguShop.setTbNick(shiguShopApply.getTbNick());
        String tbUrl = shiguShopApply.getTbUrl();

        if (StringUtils.isNotEmpty(shiguShopApply.getTbshopId())) {
            shiguShop.setType(1);
            // shop表增加main_bus,email两个字段，tbshopId用于拼taobaoUrl(如果有的话) http://shop${shopId}.taobao.com
            if (StringUtils.isEmpty(tbUrl)){
                tbUrl = "http://shop${shopId}.taobao.com".replace("${shopId}", shiguShopApply.getTbshopId());
            }
        }else{
            shiguShop.setType(2);
        }
        shiguShop.setTaobaoUrl(tbUrl);
        shiguShop.setMainBus(shiguShopApply.getMainBus());
        shiguShop.setEmail(shiguShopApply.getEmail());
        shiguShop.setDomain(shiguShopApply.getShopNum());
        shiguShop.setShopName(shiguShopApply.getShopNum());
        shiguShop.setSortOrderKey(shiguShopApply.getShopNum());
        shiguShop.setImAliww(shiguShopApply.getImAliww());
        shiguShop.setSynTaobao(shiguShopApply.getTbNick() != null ? 1 : 2);
        shiguShop.setShopStatus(0); //正常
        shiguShop.setCreateDate(new Date());
        shiguShop.setLastModifyTime(new Date());
        shiguShopMapper.insertSelective(shiguShop);
        Long shopId = shiguShop.getShopId();

        //加入ES
        shopToEsService.addToEs(shopId);
        //初始化装修
        try {
            shopFitmentService.initShopFitment(shopId);
        } catch (ShopFitmentException e) {
            logger.error("初始化装修失败",e);
        }

        //把审核申请变成不可审核
        ShiguShopApply apply=new ShiguShopApply();
        apply.setRuzhuId(registId);
        apply.setApplyStatus(1);
        apply.setCanExamine(2);
        if (StringUtils.isNotBlank(operator)) {
            apply.setRefuseReason("开店：" + operator);
        }
        shiguShopApplyMapper.updateByPrimaryKeySelective(apply);
        // 解析退换服务信息
        String tags = shiguShopApply.getTags();
        if (StringUtils.isNotEmpty(tags)) {
            ShiguShopLicense license = new ShiguShopLicense();
            license.setShopId(shopId);
            license.setContext(shiguShopApply.getTags());
            license.setLicenseFailure(0);
            license.setLicenseType(ShopLicenseTypeEnum.TAGS.ordinal());
            shiguShopLicenseMapper.insertSelective(license);
        } else
            logger.info("店铺:" + shiguShopApply.getShopNum() + "没有退换标签");

        //审核通过，按marketId移除市场缓存marketCache 按userId移除用户授权缓存userStoreListCache
        Cache marketCache = cacheManager.getCache("floorCache");
        if (marketCache != null)
            marketCache.evict(shiguShopApply.getFloorId());

        Cache userStoreListCache = cacheManager.getCache("userStoreListCache");
        if (userStoreListCache != null)
            userStoreListCache.evict(shiguShopApply.getUserId());
        return shopId;
    }

    /**
     * 拒绝开店申请
     * @param registId
     * @param reason
     */
    @Override
    public int toRefuse(Long registId, RefuseOpenReason reason) throws ShopExamineException {
        ShiguShopApply shiguShopApply = shiguShopApplyMapper.selectByPrimaryKey(registId);
        if(shiguShopApply==null)
            throw new ShopExamineException("申请无效");
        if (shiguShopApply.getCanExamine() == 0)
            throw new ShopExamineException("信息不全，请求无法处理");

        if (shiguShopApply.getCanExamine() == 2)
            throw new ShopExamineException("已经处理过的申请");
        ShiguShopApply apply=new ShiguShopApply();
        apply.setRuzhuId(registId);
        apply.setCanExamine(2);
        apply.setApplyStatus(2);
        apply.setRefuseReason(reason.toString());
        return shiguShopApplyMapper.updateByPrimaryKeySelective(apply);
    }

    /**
     * 查询所有可入驻的站点
     * @return
     */
    @Override

    public List<SiteForRegist> selSites() {
        Cache webSitesCache = cacheManager.getCache("webSitesCache");

        // yes, I can.
        @SuppressWarnings("unchecked")
        List<SiteForRegist> forRegists = (List<SiteForRegist>) webSitesCache.get("1", List.class);
        if (forRegists == null) {
            ShiguSiteExample siteExample = new ShiguSiteExample();
            siteExample.createCriteria().andRemark1EqualTo("1");
            List<ShiguSite> shiguSites = shiguSiteMapper.selectByExample(siteExample);
            Collections.sort(shiguSites);
            logger.debug("查询数据库 --> 站点列表：\n" + JSON.toJSONString(shiguSites, SerializerFeature.PrettyFormat));
            forRegists = new ArrayList<>(shiguSites.size());
            for (ShiguSite shiguSite : shiguSites) {
                SiteForRegist regist = new SiteForRegist();
                regist.setSiteName(shiguSite.getSiteName());
                regist.setWebSite(shiguSite.getCitySite());
                forRegists.add(regist);
            }

            webSitesCache.put("1", forRegists);
        }
        return forRegists;
    }

    /**
     * 查询可注册的市场
     * @param webSite 分站
     * @return 市场集合
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<MarketForRegist> selMarkets(String webSite) {
        if (StringUtils.isEmpty(webSite))
            return Collections.EMPTY_LIST;
        Cache siteCache = cacheManager.getCache("marketsInSiteCache");
        List<MarketForRegist> list = siteCache.get(webSite, List.class);
        if (list == null) {
            ShiguMarketExample marketExample = new ShiguMarketExample();
            marketExample.setOrderByClause("sort_order");
            marketExample.createCriteria()
                    .andWebSiteEqualTo(webSite)
                    .andIsParentEqualTo(1L)
                    .andCanRegistEqualTo(1);
            List<ShiguMarket> markets
                    = shiguMarketMapper.selectFieldsByExample(marketExample, FieldUtil.codeFields("market_id,market_name"));
            list = new ArrayList<>(markets.size());
            for (ShiguMarket shiguMarket : markets) {
                MarketForRegist forRegist = new MarketForRegist();
                forRegist.setMarketId(shiguMarket.getMarketId());
                forRegist.setMarketName(shiguMarket.getMarketName());
                list.add(forRegist);
            }
            siteCache.put(webSite, list);
        }
        return list;
    }

    @Override
    public List<FloorForRegist> selFloors(Long marketId) {
        if (marketId == null) return Collections.emptyList();
        ShiguMarketExample marketExample = new ShiguMarketExample();
        marketExample.setOrderByClause("sort_order");
        marketExample.createCriteria()
                .andParentMarketIdEqualTo(marketId)
                .andCanRegistEqualTo(1);
        List<ShiguMarket> markets
                = shiguMarketMapper.selectFieldsByExample(marketExample, FieldUtil.codeFields("market_id,market_name"));
        List<FloorForRegist> list = new ArrayList<>(markets.size());
        for (ShiguMarket market : markets) {
            FloorForRegist forRegist = new FloorForRegist();
            forRegist.setFloorId(market.getMarketId());
            forRegist.setFloorName(market.getMarketName());
            list.add(forRegist);
        }
        return list;
    }
}
