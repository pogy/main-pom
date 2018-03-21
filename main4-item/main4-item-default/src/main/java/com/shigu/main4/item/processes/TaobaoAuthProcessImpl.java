package com.shigu.main4.item.processes;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.shigu.main4.item.exceptions.TbAddSessionException;
import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.vo.SessionVO;
import com.shigu.main4.item.vo.TmcUserVO;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.User;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.UserSellerGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("taobaoAuthProcess")
public class TaobaoAuthProcessImpl implements TaobaoAuthProcess {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoAuthProcessImpl.class);

    @Autowired
    TaobaoSessionMapMapper taobaoSessionMapMapper;

    @Autowired
    TaobaoItemSynProcess taobaoItemSynProcess;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    protected EhCacheCacheManager cacheManager;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    @Override
    public void addSession(Map<?, ?> mapinfo) throws TbAddSessionException {
//        //添加
        TaobaoSessionMap tsm;
        try {
            tsm=parseToMap(mapinfo);
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            logger.error("转化授权map异常",e);
            throw new TbAddSessionException(e.getMessage());
        }
        //写入数据库
        TaobaoSessionMapExample exam=new TaobaoSessionMapExample();
        TaobaoSessionMapExample.Criteria cri=exam.createCriteria();
        cri.andNickEqualTo(tsm.getNick());
        cri.andAppkeyEqualTo(APPKEY);
        if(tsm.getSubTaobaoUserNick()!=null){
            cri.andSubTaobaoUserNickEqualTo(tsm.getSubTaobaoUserNick());
        }else{
            cri.andSubTaobaoUserIdIsNull();
        }
        exam.setStartIndex(0);
        exam.setEndIndex(1);
        List<TaobaoSessionMap> maps=taobaoSessionMapMapper.selectByConditionList(exam);
        if(maps.size()>0){//有记录
            TaobaoSessionMap map=maps.get(0);
            map.setAppkey(APPKEY);
            map.setFreshTime(new Date());
            map.setNick(tsm.getNick());
            map.setSecret(SECRET);
            map.setSession(tsm.getSession());
            map.setUserId(tsm.getUserId());
            //取等级信息
            if(map.getFreshTime().getTime()-System.currentTimeMillis()>259200000l){//3天内
                User u= null;
                try {
                    u = synUserLevel(tsm.getSession());
                } catch (ApiException e) {
                    e.printStackTrace();
                }
                if(u!=null&&u.getSellerCredit()!=null){
                    map.setRemark1(u.getSellerCredit().getLevel()+"");
                    map.setRemark2(u.getSellerCredit().getScore()+"");
                    map.setRemark3(u.getSellerCredit().getTotalNum()+"");
                    map.setRemark4(u.getSellerCredit().getGoodNum()+"");
                }
            }
            map.setExpiresIn(tsm.getExpiresIn());
            map.setR1ExpiresIn(tsm.getR1ExpiresIn());
            map.setR2ExpiresIn(tsm.getR2ExpiresIn());
            map.setW1ExpiresIn(tsm.getW1ExpiresIn());
            map.setW2ExpiresIn(tsm.getW2ExpiresIn());
            map.setReExpiresIn(tsm.getReExpiresIn());
            map.setSubTaobaoUserId(tsm.getSubTaobaoUserId());
            map.setSubTaobaoUserNick(tsm.getSubTaobaoUserNick());
            map.setTokenType(tsm.getTokenType());
            taobaoSessionMapMapper.updateByPrimaryKeySelective(map);
        }else{
            TaobaoSessionMap map=new TaobaoSessionMap();
            map.setAppkey(APPKEY);
            map.setFreshTime(new Date());
            map.setNick(tsm.getNick());
            map.setSecret(SECRET);
            map.setSession(tsm.getSession());
            map.setUserId(tsm.getUserId());
            //取等级信息
            User u= null;
            try {
                u = synUserLevel(tsm.getSession());
            } catch (ApiException e) {
                e.printStackTrace();
            }
            if(u!=null&&u.getSellerCredit()!=null){
                map.setRemark1(u.getSellerCredit().getLevel()+"");
                map.setRemark2(u.getSellerCredit().getScore()+"");
                map.setRemark3(u.getSellerCredit().getTotalNum()+"");
                map.setRemark4(u.getSellerCredit().getGoodNum()+"");
            }
            map.setRefreshToken(tsm.getRefreshToken());
            map.setExpiresIn(tsm.getExpiresIn());
            map.setR1ExpiresIn(tsm.getR1ExpiresIn());
            map.setR2ExpiresIn(tsm.getR2ExpiresIn());
            map.setW1ExpiresIn(tsm.getW1ExpiresIn());
            map.setW2ExpiresIn(tsm.getW2ExpiresIn());
            map.setReExpiresIn(tsm.getReExpiresIn());
            map.setSubTaobaoUserId(tsm.getSubTaobaoUserId());
            map.setSubTaobaoUserNick(tsm.getSubTaobaoUserNick());
            map.setTokenType(tsm.getTokenType());
            taobaoSessionMapMapper.insertSelective(map);
        }
        try {
            reGetItemIfDown(tsm.getNick(),tsm.getSession());
        } catch (Exception e) {
            logger.error("添加推送队列失败",e);
        }
    }

    /**
     * map转化成taobaoSessionMap
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     */
    private TaobaoSessionMap parseToMap(Map<?,?> map) throws UnsupportedEncodingException {
        TaobaoSessionMap tsm = new TaobaoSessionMap();
        tsm.setNick(URLDecoder.decode(map.get("taobao_user_nick").toString(), "UTF-8"));
        tsm.setSession(map.get("access_token").toString());
        tsm.setUserId(Long.parseLong(map.get("taobao_user_id")
                .toString()));
        tsm.setRefreshToken(map.get("refresh_token").toString());
        tsm.setExpiresIn(Long.parseLong(map.get("expires_in")
                .toString()));
        tsm.setR1ExpiresIn(Long.parseLong(map.get("r1_expires_in")
                .toString()));
        tsm.setR2ExpiresIn(Long.parseLong(map.get("r2_expires_in")
                .toString()));
        tsm.setW1ExpiresIn(Long.parseLong(map.get("w1_expires_in")
                .toString()));
        tsm.setW2ExpiresIn(Long.parseLong(map.get("w2_expires_in")
                .toString()));
        tsm.setTokenType(map.get("token_type").toString());
        Object subuid = map.get("sub_taobao_user_id");
        Object subnick = map.get("sub_taobao_user_nick");
        if (subuid != null) {
            tsm.setSubTaobaoUserId(Long.parseLong(subuid.toString()));
        }
        if (subnick != null) {
            tsm.setSubTaobaoUserNick(URLDecoder.decode(
                    subnick.toString(), "UTF-8"));
        }
        return tsm;
    }

    /**
     * 同步用户等级
     */
    private User synUserLevel(String session) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(TOP_SERVER_URL,
                APPKEY, SECRET);
        UserSellerGetRequest req=new UserSellerGetRequest();
        req.setFields("seller_credit");
        UserSellerGetResponse response = client.execute(req , session);
        return response.getUser();
    }

    @Override
    public void reGetItemIfDown(String nick, String session) throws TbItemSynException {
//先查出队列中有没有
        ShiguShopExample shopExample=new ShiguShopExample();
        shopExample.createCriteria().andTbNickEqualTo(nick).andShopStatusEqualTo(0);
        List<ShiguShop> shops=shiguShopMapper.selectByExample(shopExample);
        if(shops.size()>0){
            try {
                taobaoItemSynProcess.addToTmc(nick);
            } catch (Exception e) {
                logger.error("加入tmc失败",e);
            }
        }
        boolean needReGet=false;
        List<String> nicks=new ArrayList<String>();
        nicks.add(nick);
        Map<String, TmcUserVO> map=taobaoItemSynProcess.listTmc(nicks);
        if(map!=null&&map.get(nick)!=null){
            TmcUserVO tmcUser=map.get(nick);
            needReGet=!(tmcUser.getValid());
        }else{
            needReGet=true;
        }
        if(needReGet){//如果需要抓取
            for(ShiguShop shop:shops){
                taobaoItemSynProcess.synOneShopAsyn(shop.getShopId(),nick);
            }
        }
    }

    @Override
    public SessionVO getSession(String appkey, String nick) {
        Cache sessionCache = cacheManager.getCache("taobaoSessionCache");
        SessionVO sessionVO= sessionCache.get(nick,SessionVO.class);
        if(sessionVO==null){
            TaobaoSessionMapExample example=new TaobaoSessionMapExample();
            example.createCriteria().andAppkeyEqualTo(appkey).andNickEqualTo(nick);
            example.setStartIndex(0);
            example.setEndIndex(1);
            example.setOrderByClause("fresh_time desc");
            List<TaobaoSessionMap> list=taobaoSessionMapMapper.selectByConditionList(example);
            if(list.size()>0){
                TaobaoSessionMap tsm=list.get(0);
                if(tsm.getSubTaobaoUserId()!=null){
                    for(TaobaoSessionMap t:list){
                        if(t.getSubTaobaoUserId()==null&&System.currentTimeMillis()-t.getFreshTime().getTime()<86400000L){
                            tsm=t;
                            break;
                        }
                    }
                }
                sessionVO=new SessionVO();
                sessionVO.setAppkey(tsm.getAppkey());
                sessionVO.setSession(tsm.getSession());
                sessionVO.setNick(tsm.getNick());
                sessionVO.setTbUserId(tsm.getUserId());
                sessionCache.put(nick,sessionVO);
            }
        }
        return sessionVO;
    }
}
