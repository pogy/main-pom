package com.shigu.main4.order.services.impl;

import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.alibaba.dubbo.common.logger.Logger;
import com.shigu.main4.tools.RedisIO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 订单常量资源管理 实现
 * Created by bugzy on 2017/6/9 0009.
 */
@Service("orderConstantService")
public class OrderConstantServiceImpl implements OrderConstantService {

    private static final Logger logger = LoggerFactory.getLogger(OrderConstantServiceImpl.class);

    @Autowired
    private OrderConstantMapper orderConstantMapper;

    @Autowired
    private OrderProvMapper orderProvMapper;

    @Autowired
    private OrderCityMapper orderCityMapper;

    @Autowired
    private OrderTownMapper orderTownMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    @Autowired
    private RedisIO redisIO;

    private static String ORDER_EXPRESS_CITY_GROUP = "order_express_city_group";
    private static String ORDER_EXPRESS_CITY_MAP = "order_express_city_map";
    private static String ORDER_EXPRESS_EXPRESS_MAP = "order_express_express_map";
    private static String ORDER_EXPRESS_PROV_GROUP = "order_express_prov_group";
    private static String ORDER_EXPRESS_PROV_MAP = "order_express_prov_map";
    private static String ORDER_EXPRESS_TOWN_MAP = "order_express_town_map";
    private static String ORDER_EXPRESS_UPDATE = "order_express_update";
    private static String ORDER_EXPRESS_MAP_UPDATE_VERSION = "order_express_map_update_version";

    /**
     * 订单常量
     */
    public enum OrderConstantType {
        SERVICE(SERVICE_TYPE, ServiceVO.class),
        PACKAGE(PACKAGE_TYPE, MetarialVO.class);
        private int type;
        private Class<? extends OrderConstantVo> voClazz;
        private Map<Long, List<OrderConstantVo>> orderConstantsMap;
        OrderConstantType(int type, Class<? extends OrderConstantVo> clazz) {
            this.type = type;
            this.voClazz = clazz;
            orderConstantsMap = new HashMap<>();
        }
        static OrderConstantType typeOf(int type) {
            for (OrderConstantType constantType : values()) {
                if (constantType.type == type)
                    return constantType;
            }
            throw new IllegalArgumentException(String.format("OrderConstant type[%d] does not exist.", type));
        }

        void put(Long senderId, OrderConstant constant) {
            orderConstantsMap.computeIfAbsent(senderId, k -> new ArrayList<>())
                    .add(JSON.parseObject(constant.getContext(), voClazz));
        }

        @SuppressWarnings("unchecked")
        <T> T get(Long senderId, Long id) {
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId == null ? -1L : senderId);
            if (orderConstants != null) {
                for (OrderConstantVo orderConstant : orderConstants)
                    if (Objects.equals(orderConstant.getId(), id))
                        return (T) orderConstant;
            }
            return null;
        }

        @SuppressWarnings("unchecked")
        <T extends OrderConstantVo> List<T> all(Long senderId) {
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId);
            if (orderConstants == null)
                orderConstants = Collections.emptyList();
            return (List<T>) orderConstants;
        }
    }

    /**
     * 初始化
     */
    @Override
    @PostConstruct
    public void init() {
        for (OrderConstant constant : orderConstantMapper.select(new OrderConstant())) {
            OrderConstantType.typeOf(constant.getType()).put(constant.getSenderId(), constant);
        }
        initAddress();
    }

    /**
     * 查询服务
     *
     * @param senderId 发送单位ID
     * @return 发送单位所有服务
     */
    @Override
    public List<ServiceVO> selServices(Long senderId) {
        return OrderConstantType.SERVICE.all(senderId);
    }

    /**
     * 按服务ID查服务
     *
     * @param senderId 发送单位ID
     * @param id 服务ID
     * @return 某发送单位的某服务
     */
    @Override
    public ServiceVO selServiceById(Long senderId, Long id) {
        return OrderConstantType.SERVICE.get(senderId, id);
    }

    /**
     * 按marketId获取代发服务
     * @param senderId
     * @param marketId
     * @return
     */
    @Override
    public ServiceVO selDfService(Long senderId, Long marketId) {
        if (marketId == null) {
            return null;
        }
        List<ServiceVO> serviceList = selServices(senderId);
        ServiceVO defaultDfService=null;
        for (ServiceVO item : serviceList) {
            if (Objects.equals(marketId, item.getMarketId())) {
                return item;
            }else if(item.getMarketId()==-1){//市场号为-1是默认的
                defaultDfService=item;
            }
        }
        return defaultDfService;
    }

    /**
     * 查询所有包材
     *
     * @param senderId 发送单位ID
     * @return 发送单位全部包材
     */
    @Override
    public List<MetarialVO> selMetarials(Long senderId) {
        return OrderConstantType.PACKAGE.all(senderId);
    }

    /**
     * 按包材ID查包材
     *
     * @param senderId 发送单位ID
     * @param id 包材ID
     * @return 某发送单位的某包材
     */
    @Override
    public MetarialVO selMetarialById(Long senderId, Long id) {
        return OrderConstantType.PACKAGE.get(senderId, id);
    }


    private Map<Long, List<TownVO>> cityGroup;
    private Map<Long, List<CityVO>> provGroup;
    private Map<Long, ProvinceVO> provMap;
    private Map<Long, CityVO> cityMap;
    private Map<Long, TownVO> townMap;
    private Map<Long, ExpressVo> expressMap;
    private String cityGroupStr;
    private String cityMapStr;
    private String expressMapStr;
    private String provGroupStr;
    private String provMapStr;
    private String townMapStr;
    private static Long updateMapVersion;

    public void initAddress() {
        List<OrderCity> orderCities = orderCityMapper.select(new OrderCity());
        List<OrderTown> orderTowns = orderTownMapper.select(new OrderTown());
        provMap = orderProvMapper.select(new OrderProv()).stream().collect(Collectors.toMap(OrderProv::getProvId, p -> {
            ProvinceVO vo = new ProvinceVO();
            vo.setProvinceId(p.getProvId());
            vo.setProvince(p.getProvName());
            return vo;
        }));

        Function<OrderCity, CityVO> cityTransform = c -> {
            CityVO vo = new CityVO();
            vo.setCityId(c.getCityId());
            vo.setCity(c.getCityName());
            return vo;
        };

        Function<OrderTown, TownVO> townTransform = t -> {
            TownVO vo = new TownVO();
            vo.setTownId(t.getTownId());
            vo.setTown(t.getTownName());
            return vo;
        };

        cityMap = orderCities.stream().collect(Collectors.toMap(OrderCity::getCityId, cityTransform));
        townMap = orderTowns.stream().collect(Collectors.toMap(OrderTown::getTownId, townTransform));

        expressMap = expressCompanyMapper.select(new ExpressCompany()).stream().map(expressCompany -> {
            ExpressVo vo = new ExpressVo();
            vo.setExpressId(expressCompany.getExpressCompanyId());
            vo.setExpressName(expressCompany.getExpressName());
            return vo;
        }).collect(Collectors.toMap(ExpressVo::getExpressId, e -> e));

        cityGroup = orderTowns.stream().collect(Collectors.groupingBy(OrderTown::getCityId))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().map(townTransform).collect(Collectors.toList())));
        provGroup = orderCities.stream().collect(Collectors.groupingBy(OrderCity::getProvId))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().map(cityTransform).collect(Collectors.toList())));

        cityGroupStr = JSON.toJSONString(cityGroup);
        cityMapStr = JSON.toJSONString(cityMap);
        expressMapStr = JSON.toJSONString(expressMap);
        provGroupStr = JSON.toJSONString(provGroup);
        provMapStr = JSON.toJSONString(provMap);
        townMapStr = JSON.toJSONString(townMap);
        redisIO.put(ORDER_EXPRESS_CITY_GROUP,cityGroupStr);
        redisIO.put(ORDER_EXPRESS_CITY_MAP,cityMapStr);
        redisIO.put(ORDER_EXPRESS_EXPRESS_MAP,expressMapStr);
        redisIO.put(ORDER_EXPRESS_PROV_GROUP,provGroupStr);
        redisIO.put(ORDER_EXPRESS_PROV_MAP,provMapStr);
        redisIO.put(ORDER_EXPRESS_TOWN_MAP,townMapStr);
        Boolean b = redisIO.get(ORDER_EXPRESS_UPDATE,Boolean.class);
        if (b != null && b == true){
            updateMapVersion = System.currentTimeMillis();
            redisIO.put(ORDER_EXPRESS_MAP_UPDATE_VERSION,updateMapVersion.toString());
        }else {
            updateMapVersion = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        }
        redisIO.put(ORDER_EXPRESS_UPDATE, "false");
    }

    public List<ExpressVo> selExpresses() {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return new ArrayList<>(expressMap.values());
    }

    public ExpressVo selByExpressId(Long expressId) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return expressMap.get(expressId);
    }

    /**
     * 查询所有省份
     *
     * @return
     */
    @Override
    public List<ProvinceVO> selProvinces() {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return new ArrayList<>(provMap.values());
    }

    /**
     * 按省份ID查城市
     *
     * @param provinceId
     * @return
     */
    @Override
    public List<CityVO> selCitysByPid(Long provinceId) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return provGroup.get(provinceId);
    }



    /**
     * 按城市ID查地区
     *
     * @param cityId
     * @return
     */
    @Override
    public List<TownVO> selTownByCid(Long cityId) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return cityGroup.get(cityId);
    }

    public ProvinceVO selProvByPid(Long pid) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return provMap.get(pid);
    }

    public CityVO selCityByCid(Long cid) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
               updateMap();
               updateMapVersion = version;
        }
        return cityMap.get(cid);
    }

    public TownVO selTownByTid(Long tid) {
        Long version = redisIO.get(ORDER_EXPRESS_MAP_UPDATE_VERSION,Long.class);
        if (version != null && !version.equals(updateMapVersion)){
            updateMap();
            updateMapVersion = version;
        }
        return townMap.get(tid);
    }

    public void updateMap(){
        Map<String, com.alibaba.fastjson.JSONObject> jsonObject;
        expressMapStr = redisIO.get(ORDER_EXPRESS_EXPRESS_MAP,String.class);
        expressMap.clear();
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(expressMapStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            expressMap.put(Long.valueOf(entry.getKey()), JSON.parseObject(JSON.toJSONString(entry.getValue()),ExpressVo.class));
        }

        provMapStr = redisIO.get(ORDER_EXPRESS_PROV_MAP,String.class);
        provMap.clear();
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(provMapStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            provMap.put(Long.valueOf(entry.getKey()), JSON.parseObject(JSON.toJSONString(entry.getValue()),ProvinceVO.class));
        }

        provGroupStr = redisIO.get(ORDER_EXPRESS_PROV_GROUP,String.class);
        provGroup.clear();
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(provGroupStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            provGroup.put(Long.valueOf(entry.getKey()), JSONArray.parseArray(JSON.toJSONString(entry.getValue()),CityVO.class));
        }

        cityGroupStr = redisIO.get(ORDER_EXPRESS_CITY_GROUP,String.class);
        cityGroup.clear();
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(cityGroupStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            cityGroup.put(Long.valueOf(entry.getKey()), JSONArray.parseArray(JSON.toJSONString(entry.getValue()),TownVO.class));
        }

        cityMapStr = redisIO.get(ORDER_EXPRESS_CITY_MAP,String.class);
        cityMap.clear();
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(cityMapStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            cityMap.put(Long.valueOf(entry.getKey()), JSON.parseObject(JSON.toJSONString(entry.getValue()),CityVO.class));
        }

        townMapStr = redisIO.get(ORDER_EXPRESS_TOWN_MAP,String.class);
        jsonObject = new HashMap<>();
        jsonObject.putAll((Map<String,  com.alibaba.fastjson.JSONObject>) JSON.parse(townMapStr));
        for (Map.Entry<String, com.alibaba.fastjson.JSONObject> entry : jsonObject.entrySet()) {
            townMap.put(Long.valueOf(entry.getKey()), JSON.parseObject(JSON.toJSONString(entry.getValue()),TownVO.class));
        }
    }


}
