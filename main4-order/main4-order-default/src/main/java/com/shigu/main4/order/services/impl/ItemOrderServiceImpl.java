package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.examples.BuyerAddressExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.examples.LogisticsTemplateExample;
import com.opentae.data.mall.examples.OrderStatusRecordExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.NumberUtils;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.enums.MainOrderStatusEnum;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.RefundTypeEnum;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.*;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.model.impl.ItemOrderImpl;
import com.shigu.main4.order.model.impl.SubItemOrderImpl;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.servicevo.RefundInfoVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.KdniaoUtil;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
     * 创建订单
     * @param orderBO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(ItemOrderBO orderBO) throws OrderException {
        // 初始化一个订单
        ItemOrder order = BeanMapper.map(orderBO, ItemOrder.class);
        order.setType(OrderType.XZ.type);
        order.setTotalFee(0L);
        order.setPayedFee(0L);
        order.setRefundFee(0L);
        order.setOrderStatus(OrderStatus.WAIT_BUYER_PAY.status);
        order.setOid(idGenerator(OrderType.XZ));
        itemOrderMapper.insertSelective(order);

        // 获取订单操作接口
        com.shigu.main4.order.model.ItemOrder itemOrder
                = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, order.getOid());

        // c, 添加子订单
        if (orderBO.getSubOrders() == null || orderBO.getSubOrders().isEmpty()) {
            throw new OrderException("订单是空的.");
        }
        List<PidNumBO> pidNumBOS = new ArrayList<>();
        List<SubOrderVO> subOrders = new ArrayList<>();
        for (SubItemOrderBO subItemOrderBO : orderBO.getSubOrders()) {
            ItemProductVO productVO = subItemOrderBO.getProductVO();

            PidNumBO numBO = new PidNumBO();
            pidNumBOS.add(numBO);
            numBO.setPid(productVO.getPid());
            numBO.setNum(subItemOrderBO.getNum());
            numBO.setWeight(productVO.getWeight());

            SubOrderVO vo = new SubOrderVO();
            vo.setNum(subItemOrderBO.getNum());
            vo.setMark(subItemOrderBO.getMark());
            vo.setGoodsId(productVO.getGoodsId());
            ItemSkuVO selectiveSku = productVO.getSelectiveSku();
            vo.setSize(selectiveSku.getSize());
            vo.setColor(selectiveSku.getColor());
            subOrders.add(vo);
        }
        itemOrder.addSubOrder(subOrders);

        // a, 添加服务
        if (orderBO.getServiceIds() != null) {
            for (Long sid : orderBO.getServiceIds()) {
                itemOrder.addService(sid);
            }
        }

        // b, 添加包材
        if (orderBO.getPackages() != null) {
            for (PackageBO packageBO : orderBO.getPackages()) {
                itemOrder.addPackage(packageBO.getMetarialId(), packageBO.getNum());
            }
        }

        // d, 添加物流
        LogisticsBO logistics = orderBO.getLogistics();
        String companyId = logistics.getCompanyId();
        ExpressCompany company = new ExpressCompany();
        company.setEnName(companyId);
        ExpressCompany expressCompany = expressCompanyMapper.selectOne(company);

        BuyerAddress buyerAddress;
        try {
            Long aid = Long.valueOf(logistics.getAddressId());
            buyerAddress = buyerAddressMapper.selectByPrimaryKey(aid);
            String town = StringUtils.isEmpty(buyerAddress.getTownName()) ? "" : buyerAddress.getTownName();
            buyerAddress.setAddress(buyerAddress.getProvName() + buyerAddress.getCityName() + town + buyerAddress.getAddress());
        } catch (NumberFormatException e) {
            BuyerAddressVO buyerAddressVO = redisIO.get("tmp_buyer_address_" + logistics.getAddressId(), BuyerAddressVO.class);
            buyerAddress = BeanMapper.map(buyerAddressVO, BuyerAddress.class);
            buyerAddress.setAddress(buyerAddressVO.getProvince() + buyerAddressVO.getCity() + buyerAddressVO.getTown() + buyerAddressVO.getAddress());
        }
        LogisticsVO logistic = BeanMapper.map(buyerAddress, LogisticsVO.class);
        logistic.setCompanyId(expressCompany.getExpressCompanyId());
        logistic.setAddress(buyerAddress.getAddress());
        logistic.setMoney(calculateLogisticsFee(orderBO.getSenderId(), company.getExpressCompanyId(), buyerAddress.getProvId(), pidNumBOS));
        itemOrder.addLogistics(null, logistic);

        // b, 添加服务
        if (orderBO.getServiceIds() != null) {
            for (Long sid : orderBO.getServiceIds()) {
                itemOrder.addService(sid);
            }
        }

        // c, 添加包材
        if (orderBO.getPackages() != null) {
            for (PackageBO packageBO : orderBO.getPackages()) {
                itemOrder.addPackage(packageBO.getMetarialId(), packageBO.getNum());
            }
        }

        // d, 添加子订单
        if (orderBO.getSubOrders() != null) {
            subOrders = new ArrayList<>();
            for (SubItemOrderBO subItemOrderBO : orderBO.getSubOrders()) {
                SubOrderVO vo = new SubOrderVO();
                vo.setNum(subItemOrderBO.getNum());
                vo.setMark(subItemOrderBO.getMark());
                ItemProductVO productVO = subItemOrderBO.getProductVO();
                vo.setGoodsId(productVO.getGoodsId());
                ItemSkuVO selectiveSku = productVO.getSelectiveSku();
                vo.setSize(selectiveSku.getSize());
                vo.setColor(selectiveSku.getColor());
                subOrders.add(vo);
            }
            itemOrder.addSubOrder(subOrders);
        }
        return order.getOid();
    }

    /**
     * 重算快递费
     * @param senderId 发件机构ID
     * @param companyId 物流公司ID
     * @param provId 省份ID
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
                    NumberUtils.sum(BeanMapper.getFieldList(pids, "num", Integer.class)).intValue(),
                    NumberUtils.sum(BeanMapper.getFieldList(pids, "weight", Integer.class)).longValue()
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
    public void saveBuyerAddress(BuyerAddressVO buyerAddressVO) throws JsonErrException {
        //信息不足
        boolean isInformationInsufficient = buyerAddressVO.getProvId() == null || buyerAddressVO.getCityId() == null ||
                buyerAddressVO.getTownId() == null || StringUtil.isNull(buyerAddressVO.getAddress()) ||
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
        buyerAddressVO.setAddressId(buyerAddress.getAddressId());
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
        String expressName = selLogisticCompanyCode(firstLogisticsVO.getCompanyId());
        String expressId = firstLogisticsVO.getCourierNumber();
        expressInfoVO.setExpressId(expressId);
        expressInfoVO.setExpressName(expressName);
        expressInfoVO.setReceiverAddress(firstLogisticsVO.getAddress());
        expressInfoVO.setReceiverName(firstLogisticsVO.getName());
        expressInfoVO.setReceiverPhone(firstLogisticsVO.getTelephone());
        Integer state = 0;
        try {
            JSONObject jsonResult = JSON.parseObject(kdniaoUtil.getOrderTracesByJson(expressName,expressId));
            if ("true".equals(jsonResult.get("Success") + "")){
                String stateStr = jsonResult.get("State").toString();
                switch (stateStr) {
                    case "2":
                        state = 2;
                        break;
                    case "3":
                        state = 3;
                        break;
                    case "4":
                        state = 4;
                        break;
                    default:
                        state = 1;
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
    /**
     * 查询物流日志
     * @param expressId
     * @return
     */
    @Override
    public List<ExpressLogVO> expressLog(Long expressId) throws Main4Exception, ParseException {
        ItemOrderLogistics itemOrderLogistics = itemOrderLogisticsMapper.selectByPrimaryKey(expressId);
        if (itemOrderLogistics==null){
            throw new Main4Exception("数据库没有对应传入的expressId的数据");
        }
        ExpressCompany expressCompany=null;
        String companyCode = "";
        if (itemOrderLogistics.getCompanyId()!=null){
            companyCode = selLogisticCompanyCode(itemOrderLogistics.getCompanyId());
        }
        String orderTracesByJson = null;
        try {
            orderTracesByJson = kdniaoUtil.getOrderTracesByJson(companyCode, itemOrderLogistics.getCourierNumber());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Main4Exception("调用快递鸟接口抛出的异常");
        }
        ExpressResultVO resultVO = JSON.parseObject(orderTracesByJson, ExpressResultVO.class);
        List<ExpressLogVO> logVOList = new ArrayList<>();
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        if (resultVO.getTraces().size() > 0) {
            for (SingleMsgVO msg : resultVO.getTraces()) {
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
                logVO.setLogDate(new SimpleDateFormat("yyyy-MM-dd").format(time).toString());
                logVO.setLogTime(new SimpleDateFormat("HH:mm:ss").format(time).toString());
                logVOList.add(logVO);
            }
        }
        return logVOList;
    }

    //TODO:获取物流公司对应快递鸟平台公司编码
    private String selLogisticCompanyCode(Long companyId) throws Main4Exception {
        ExpressCompany expressCompany = expressCompanyMapper.selectFieldsByPrimaryKey(companyId,FieldUtil.codeFields("express_company_id,remark2"));
        if (expressCompany == null) {
            throw new  Main4Exception("数据库没有对应的快递公司数据");
        }
        if (expressCompany.getRemark2() == null) {
            throw new  Main4Exception("数据库没有对应的快递公司编码");
        }
        return expressCompany.getRemark2();
    }

    /**
     * 子订单信息
     * @param subOrderId
     * @return
     */
    @Override
    public SubOrderInfoVO suborderInfo(Long subOrderId) {
        //获取信息
        SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrderImpl.class, subOrderId);
        SubItemOrderVO subItemOrderVO = subItemOrder.subOrderInfo();
        SubOrderInfoVO subOrderInfoVO = BeanMapper.map(subItemOrderVO,SubOrderInfoVO.class);
        subOrderInfoVO.setChildOrderId (subOrderId);
        subOrderInfoVO.setOrderId(subItemOrderVO.getOid());
        subOrderInfoVO.setImgsrc (subItemOrderVO.getProduct().getPicUrl());
        subOrderInfoVO.setPrice(PriceConvertUtils.priceToString(subItemOrderVO.getProduct().getPrice()));
        subOrderInfoVO.setTitle(subItemOrderVO.getProduct().getTitle());


        //TODO:退货信息
        //subOrderInfoVO.setRefundId();
        //subOrderInfoVO.setRefundNum();
        //subOrderInfoVO.setShState();
        //subOrderInfoVO.setShTkNum();
        //subOrderInfoVO.setTkState();
        //subOrderInfoVO.setTkNum();
        return subOrderInfoVO;
    }

    /**
     * 主单简要信息
     * 不包含子单
     * @param orderId
     * @return
     */
    @Override
    public OrderInfoVO orderInfo(Long orderId) {
        com.shigu.main4.order.model.ItemOrder itemOrder = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId);
        ItemOrderVO itemOrderVO = itemOrder.orderInfo();

        OrderInfoVO infoVO = new OrderInfoVO();
        infoVO.setOrderId(itemOrderVO.getOrderId());
        /*infoVO.setOrderDealTime(itemOrderVO.getTradeTimed());
        infoVO.setOrderPrice(String.valueOf(itemOrderVO.getTotalFee()/100));
        infoVO.setExpressPrice(itemOrderVO.get);
        infoVO.setServicePrice(itemOrderVO.getServerPay());
        infoVO.setTotalPrice(itemOrderVO.getTradePay());*/
        infoVO.setOrderState(MainOrderStatusEnum.statusOf(itemOrderVO.getOrderStatus().status));
        List<LogisticsVO> logisticsVOS = itemOrder.selLogisticses();
        if (logisticsVOS.size()>0){

            ExpressCompany expressCompany = expressCompanyMapper.selectFieldsByPrimaryKey(logisticsVOS.get(0).getCompanyId(), FieldUtil.codeFields("express_company_id,express_name"));
            if (expressCompany!=null){
                infoVO.setOrderPostType(expressCompany.getExpressName());
            }
        }
        infoVO.setNowTime(new Date());
        return infoVO;
    }

    /**
     * 订单日志
     * @param orderId
     * @return
     */
    @Override
    public List<OrderLogVO> orderLog(Long orderId) {
        OrderStatusRecordExample orderStatusRecordExample=new OrderStatusRecordExample();
        orderStatusRecordExample.createCriteria().andOidEqualTo(orderId);
        orderStatusRecordExample.setOrderByClause("create_time desc");
        List<OrderLogVO>vos=new ArrayList<>();
        List<OrderStatusRecord> orderStatusRecords = orderStatusRecordMapper.selectByExample(orderStatusRecordExample);
        if (orderStatusRecords.size()>0){
            for (OrderStatusRecord o:orderStatusRecords){
                OrderLogVO vo=new OrderLogVO();
                vo.setStateTime(o.getCreateTime());
                vo.setOrderState(MainOrderStatusEnum.statusOf(o.getStatus()));
                vos.add(vo);
            }
        }
        return vos;
    }

    /**
     * 子订单信息,按主单查
     * @param orderId
     * @return
     */
    @Override
    public List<SubOrderInfoVO> suborderInfoByOrderId(Long orderId) {
        com.shigu.main4.order.model.ItemOrder itemOrder = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId);
        List<SubItemOrderVO> subItemOrderVOS = itemOrder.subOrdersInfo();
        List<SubOrderInfoVO> vos=new ArrayList<>();
        for (SubItemOrderVO s:subItemOrderVOS){
            SubOrderInfoVO vo=new SubOrderInfoVO();
            vo.setOrderId(s.getOid());
            vo.setChildOrderId(s.getSoid());
            vo.setGoodsId(s.getGoodsId());
            vo.setImgsrc(s.getProduct().getPicUrl());
            vo.setTitle(s.getProduct().getTitle());
            vo.setColor(s.getColor());
            vo.setSize(s.getSize());
            vo.setGoodsNo(s.getGoodsNo());
            vo.setPrice(String.valueOf(s.getProduct().getPrice()/100));
            vo.setPriceLong(s.getProduct().getPrice());
            vo.setNum(s.getNum());
            ItemOrderRefundExample itemOrderRefundExample=new ItemOrderRefundExample();
            itemOrderRefundExample.createCriteria().andOidEqualTo(s.getOid()).andSoidEqualTo(s.getSoid());
            List<ItemOrderRefund> itemOrderRefunds = itemOrderRefundMapper.selectByExample(itemOrderRefundExample);
            if (itemOrderRefunds.size()>0){

                ItemOrderRefund refund = itemOrderRefunds.get(0);
                //退货数量
                vo.setTkNum(refund.getNumber());
                //售后退款数量
                vo.setShTkNum(refund.getRefundMoney().intValue());
                vo.setSubOrderStatus(s.getSubOrderStatus());
                //退换货id
                vo.setRefundId(refund.getRefundId());
                //TODO 退款信息
                /*//退款数量
                vo.setRefundNum();
                //退款状态
                vo.setTkState(refund.getStatus());
                //售后状态
                vo.setShState();*/
            }
        }
        return vos;
    }

    /**
     * 申请退款
     * @param subOrderId
     * @param number
     * @return 退款编号
     */
    @Override
    public Long refundApply(Long subOrderId, Integer number) {
        return null;
    }

    /**
     * 退款信息查询
     * @param refundId
     * @return
     */
    @Override
    public RefundInfoVO refundInfo(Long refundId) {
        return null;
    }

    /**
     * 退款信息日志
     * @param refundId
     * @return
     */
    @Override
    public List<RefundLogVO> refundLog(Long refundId) {
        return null;
    }
}
