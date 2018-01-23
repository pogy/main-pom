package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.BuyerAddressExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.examples.LogisticsTemplateExample;
import com.opentae.data.mall.examples.OrderStatusRecordExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.utils.KdniaoUtil;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.MainOrderStatusEnum;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 商品订单服务
 * Created by zhaohongbo on 17/6/2.
 */
@Service("itemOrderService")
public class ItemOrderServiceImpl implements ItemOrderService {

    private static final Logger logger = LoggerFactory.getLogger(ItemOrderServiceImpl.class);

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private LogisticsTemplateMapper logisticsTemplateMapper;

    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;

    @Autowired
    private KdniaoUtil kdniaoUtil;

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private OrderStatusRecordMapper orderStatusRecordMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;

    /**
     * oid获取器
     *
     * @param type
     * @return
     */
    @Override
    public Long idGenerator(OrderType type) {
        OrderIdGenerator idGenerator = new OrderIdGenerator();
        idGenerator.setType(type.type);
        orderIdGeneratorMapper.insertSelective(idGenerator);
        return idGenerator.getOid();
    }

    /**
     * 判定是否禁止发快递
     * @param companyId
     * @param townId
     * @return
     */
    public boolean someAreaCantSend(Long companyId,Long townId,Long cityId,Long provId){
         List<CantSendVO> cantSendVOS=redisIO.getList("CANT_SEND_AREAS",CantSendVO.class);
        if (cantSendVOS == null) {
            return false;
        }
         CantSendVO vo=null;
         for(CantSendVO c:cantSendVOS){
             if (c.getCompanyId().equals(companyId)) {
                 vo=c;
                 break;
             }
         }
        if (vo == null) {
            return false;
        }
        //得到地区ID
        if (townId != null&&vo.getAreaIds() != null) {
            for(Long twid:vo.getAreaIds()){
                if (twid.equals(townId)) {
                    return true;
                }
            }
        }
        if (cityId != null&&vo.getCityIds() != null) {
            for(Long tcid:vo.getCityIds()){
                if (tcid.equals(cityId)) {
                    return true;
                }
            }
        }
        if (provId != null&&vo.getProvIds() != null) {
            for(Long tpid:vo.getProvIds()){
                if (tpid.equals(provId)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 创建订单
     *
     * @param orderBO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(ItemOrderBO orderBO) throws OrderException {
        // 初始化一个订单
        ItemOrder order = BeanMapper.map(orderBO, ItemOrder.class);
        order.setOid(idGenerator(OrderType.XZ));
        //判断订单是淘宝订单还是星座订单
        order.setType(StringUtils.isNotBlank(orderBO.getOuterId())?OrderType.TB.type:OrderType.XZ.type);
        order.setTotalFee(0L);
        order.setPayedFee(0L);
        order.setRefundFee(0L);
        order.setOrderStatus(OrderStatus.WAIT_BUYER_PAY.status);
        itemOrderMapper.insertSelective(order);

        // 获取订单操作接口
        com.shigu.main4.order.model.ItemOrder itemOrder
                = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, order.getOid());

        // c, 添加子订单
        if (orderBO.getSubOrders() == null || orderBO.getSubOrders().isEmpty()) {
            throw new OrderException("订单是空的.");
        }
        List<PidNumBO> pidNumBOS = new ArrayList<>();
        List<SubOrderBO> subOrders = new ArrayList<>();
        for (SubItemOrderBO subItemOrderBO : orderBO.getSubOrders()) {
            PidNumBO numBO = new PidNumBO();
            pidNumBOS.add(numBO);
            numBO.setPid(subItemOrderBO.getPid());
            numBO.setNum(subItemOrderBO.getNum());
            numBO.setWeight(subItemOrderBO.getWeight());
            SubOrderBO vo = BeanMapper.map(subItemOrderBO,SubOrderBO.class);
            vo.setNumber(subItemOrderBO.getNum());
            subOrders.add(vo);
        }
        itemOrder.addSubOrder(subOrders,false);

        if(itemOrderSenderMapper.selectByPrimaryKey(orderBO.getSenderId()).getType()==1){//查询一下是否代发用户
            ItemOrderSubExample subExample=new ItemOrderSubExample();
            subExample.createCriteria().andOidEqualTo(order.getOid());
            List<ItemOrderSub> orderSubs=itemOrderSubMapper.selectByExample(subExample);
            for(ItemOrderSub sub:orderSubs){//如果是代发的单子，要加代发费
                itemOrder.addDfService(orderConstantService.selDfService(orderBO.getSenderId(),sub.getMarketId()),
                        sub.getSoid(),sub.getNum(),false);
            }
        }

        // b, 添加包材
//        if (orderBO.getPackages() != null) {
//            for (PackageBO packageBO : orderBO.getPackages()) {
//                itemOrder.addPackage(packageBO.getMetarialId(), packageBO.getNum());
//            }
//        }

        // d, 添加物流
        LogisticsBO logistics = orderBO.getLogistics();
        Long companyId =  Long.parseLong(logistics.getCompanyId());
//        ExpressCompany company = new ExpressCompany();
//        company.setRemark2(companyId);
//        ExpressCompany expressCompany = expressCompanyMapper.selectOne(company);

        BuyerAddress buyerAddress;
        try {
            Long aid = Long.valueOf(logistics.getAddressId());
            buyerAddress = buyerAddressMapper.selectByPrimaryKey(aid);
            buyerAddress.setAddress(buyerAddress.getAddress());
        } catch (NumberFormatException e) {
            BuyerAddressVO buyerAddressVO = redisIO.get("tmp_buyer_address_" + logistics.getAddressId(), BuyerAddressVO.class);
            if (buyerAddressVO == null) {
                throw new OrderException("下单失败，未查询到收货地址");
            }
            buyerAddress = BeanMapper.map(buyerAddressVO, BuyerAddress.class);
            buyerAddress.setAddress(buyerAddressVO.getAddress());
        }
        if (buyerAddress.getTownId()!=null&&someAreaCantSend(companyId,buyerAddress.getTownId(),
                buyerAddress.getCityId(),buyerAddress.getProvId())) {
            throw new OrderException("下单失败，该地区快递暂时无法送达");
        }
        LogisticsVO logistic = BeanMapper.map(buyerAddress, LogisticsVO.class);
        logistic.setCompanyId(companyId);
        logistic.setAddress(buyerAddress.getAddress());
        logistic.setMoney(calculateLogisticsFee(orderBO.getSenderId(), companyId, buyerAddress.getProvId(), pidNumBOS));
        itemOrder.addLogistics(null, logistic,true);//最后一步才重怎么价格
        return order.getOid();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Long> createOrders(List<ItemOrderBO> orderBO) throws OrderException {
        List<Long> oids=new ArrayList<>();
        for(ItemOrderBO bo:orderBO){
            oids.add(createOrder(bo));
        }
        return oids;
    }

    /**
     * 重算快递费
     *
     * @param senderId  发件机构ID
     * @param companyId 物流公司ID
     * @param provId    省份ID
     * @return
     */
    @Override
    public Long calculateLogisticsFee(Long senderId, Long companyId, Long provId, List<PidNumBO> pids) throws OrderException {
        LogisticsTemplateExample templateExample = new LogisticsTemplateExample();
        templateExample.createCriteria().andEnabledEqualTo(true).andSenderIdEqualTo(senderId);
        logisticsTemplateMapper.selectByExample(templateExample);
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, senderId, null);
        try {
            return logisticsTemplate.calculate(
                    provId,
                    companyId,
                    pids.stream().mapToInt(PidNumBO::getNum).sum(),
                    pids.stream().mapToLong(PidNumBO::getWeight).sum()
            );
        } catch (LogisticsRuleException e) {
            throw new OrderException(e.getMessage());
        }
    }

    /**
     * 查询买家有的地址
     *
     * @param userId
     * @return 买家现有地址列表
     */
    @Override
    public List<BuyerAddressVO> selBuyerAddress(Long userId) {
        List<BuyerAddressVO> buyerAddressVOS = new ArrayList<BuyerAddressVO>(5);
        BuyerAddressExample buyerAddressExample = new BuyerAddressExample();
        buyerAddressExample.createCriteria().andUserIdEqualTo(userId);
        List<BuyerAddress> buyerAddresses = buyerAddressMapper.selectByExample(buyerAddressExample);
        BuyerAddressVO buyerAddressVO = null;
        for (BuyerAddress buyerAddress : buyerAddresses) {
            buyerAddressVO = BeanMapper.map(buyerAddress, BuyerAddressVO.class);
            buyerAddressVO.setProvince(buyerAddress.getProvName());
            buyerAddressVO.setCity(buyerAddress.getCityName());
            buyerAddressVO.setTown(buyerAddress.getTownName());
            buyerAddressVOS.add(buyerAddressVO);
        }
        return buyerAddressVOS;
    }

    /**
     * 保存地址，BuyerAddressVO中信息不足则会失败，用户已有超过5条地址则会覆盖最老地址
     *
     * @param buyerAddressVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveBuyerAddress(BuyerAddressVO buyerAddressVO) throws JsonErrException {
        //信息不足
        boolean isInformationInsufficient = buyerAddressVO.getProvId() == null || buyerAddressVO.getCityId() == null ||
                StringUtil.isNull(buyerAddressVO.getAddress()) ||
                buyerAddressVO.getUserId() == null || StringUtil.isNull(buyerAddressVO.getTelephone()) ||
                StringUtil.isNull(buyerAddressVO.getName());
        if (isInformationInsufficient) {
            throw new JsonErrException("买家地址存储失败");
        }
        BuyerAddressExample buyerAddressExample = new BuyerAddressExample();
        buyerAddressExample.createCriteria().andUserIdEqualTo(buyerAddressVO.getUserId());
        buyerAddressExample.setOrderByClause("address_id asc");
        List<Long> userAddressIds = BeanMapper.getFieldList(buyerAddressMapper.selectFieldsByExample(buyerAddressExample, "address_id"),
                "addressId", Long.class);
        while (userAddressIds.size() >= 5) {
            rmBuyerAddress(userAddressIds.get(0));
            userAddressIds.remove(0);
        }
        BuyerAddress buyerAddress = BeanMapper.map(buyerAddressVO, BuyerAddress.class);
        buyerAddress.setAddressId(null);
        buyerAddress.setProvName(buyerAddressVO.getProvince());
        buyerAddress.setCityName(buyerAddressVO.getCity());
        buyerAddress.setTownName(buyerAddressVO.getTown());
        buyerAddressMapper.insert(buyerAddress);
        return buyerAddress.getAddressId();
    }

    /**
     * 删除地址
     *
     * @param addressId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rmBuyerAddress(Long addressId) {
        buyerAddressMapper.deleteByPrimaryKey(addressId);
    }

    /**
     * 查询订单的物流信息
     *
     * @param orderId
     * @return
     */
    @Override
    public ExpressInfoVO expressInfo(Long orderId) throws Main4Exception {
        ExpressInfoVO expressInfoVO = new ExpressInfoVO();
        com.shigu.main4.order.model.ItemOrder itemOrder
                = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId);
        List<LogisticsVO> logisticsVOS = itemOrder.selLogisticses();
        if (logisticsVOS.size() == 0) {
            throw new Main4Exception("没有查到物流信息");
        }
        LogisticsVO firstLogisticsVO = logisticsVOS.get(0);
        ExpressCompany express = selLogisticCompanyCode(firstLogisticsVO.getCompanyId());
        String expressId = firstLogisticsVO.getCourierNumber();
        expressInfoVO.setExpressId(expressId);
        expressInfoVO.setExpressName(express.getExpressName());
        expressInfoVO.setReceiverAddress(firstLogisticsVO.getAddress());
        expressInfoVO.setReceiverName(firstLogisticsVO.getName());
        expressInfoVO.setReceiverPhone(firstLogisticsVO.getTelephone());
        Integer state = 0;
        try {
            JSONObject jsonResult = JSON.parseObject(kdniaoUtil.getOrderTracesByJson(express.getRemark3(), expressId));
            if ("true".equals(jsonResult.get("Success") + "")) {
                String stateStr = jsonResult.get("State").toString();
                switch (stateStr) {
                    case "2":
                        state = 2;
                        break;
                    case "3":
                        state = 4;
                        break;
//                    case "4":
//                        state = 4;
//                        break;
                    default:
                        state = 0;
                        break;
                }
            }
        } catch (Exception e) {
            state = 0;
        }
        expressInfoVO.setExpressCurrentState(state);
        return expressInfoVO;
    }

    /**
     * 根据expressId查询订单物流信息
     * @param expressId
     * @return
     * @throws Main4Exception
     * @throws ParseException
     */
    @Override
    public List<ExpressLogVO> expressLog(Long expressId) throws Main4Exception, ParseException {
        ItemOrderLogistics itemOrderLogistics = itemOrderLogisticsMapper.selectByPrimaryKey(expressId);
        if (itemOrderLogistics == null) {
            throw new Main4Exception("快递信息不存在");
        }
        String companyCode = "";
        if (itemOrderLogistics.getCompanyId() != null) {
            companyCode = selLogisticCompanyCode(itemOrderLogistics.getCompanyId()).getRemark3();
        }
        return expressLog(companyCode, itemOrderLogistics.getCourierNumber());
    }

    public List<ExpressLogVO> expressLog(String companyCode, String courierNumber) throws Main4Exception, ParseException {
        String orderTracesByJson;
        try {
            orderTracesByJson = kdniaoUtil.getOrderTracesByJson(companyCode, courierNumber);
        } catch (Exception e) {
            logger.error("快递查询失败", e);
            throw new Main4Exception("快递查询失败");
        }
        ExpressResultVO resultVO = JSON.parseObject(orderTracesByJson, ExpressResultVO.class);
        List<ExpressLogVO> logVOList = new ArrayList<>();
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        if (resultVO.getTraces() != null && resultVO.getTraces().size() > 0) {
            for (int i=resultVO.getTraces().size()-1;i>=0;i--) {
                SingleMsgVO msg =resultVO.getTraces().get(i);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = format.parse(msg.getAcceptTime());
                cal.setTime(time);
                int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (week_index < 0) {
                    week_index = 0;
                }
                ExpressLogVO logVO = new ExpressLogVO();
                logVO.setLogDesc(msg.getAcceptStation());
                logVO.setLogWeek(weeks[week_index]);
                logVO.setLogDate(new SimpleDateFormat("yyyy-MM-dd").format(time));
                logVO.setLogTime(new SimpleDateFormat("HH:mm:ss").format(time));
                logVOList.add(logVO);
            }
        }
        return logVOList;
    }

    //TODO:获取物流公司对应快递鸟平台公司编码
    private ExpressCompany selLogisticCompanyCode(Long companyId) throws Main4Exception {
        ExpressCompany expressCompany = expressCompanyMapper.selectFieldsByPrimaryKey(companyId, FieldUtil.codeFields("express_company_id,express_name,remark3"));
        if (expressCompany == null) {
            throw new Main4Exception("数据库没有对应的快递公司数据");
        }
        if (expressCompany.getRemark3() == null) {
            throw new Main4Exception("数据库没有对应的快递公司编码");
        }
        return expressCompany;
    }


    /**
     * 订单日志
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderLogVO> orderLog(Long orderId) {
        OrderStatusRecordExample orderStatusRecordExample = new OrderStatusRecordExample();
        orderStatusRecordExample.createCriteria().andOidEqualTo(orderId);
        orderStatusRecordExample.setOrderByClause("create_time desc");
        List<OrderLogVO> vos = new ArrayList<>();
        List<OrderStatusRecord> orderStatusRecords = orderStatusRecordMapper.selectByExample(orderStatusRecordExample);
        if (orderStatusRecords.size() > 0) {
            for (OrderStatusRecord o : orderStatusRecords) {
                OrderLogVO vo = new OrderLogVO();
                vo.setStateTime(o.getCreateTime());
                vo.setOrderState(MainOrderStatusEnum.statusOf(o.getStatus()));
                vos.add(vo);
            }
        }
        return vos;
    }

    @Override
    public ItemOrderVO orderInfo(Long orderId) {
        return SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId).orderInfo();
    }


}
