package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.BuyerAddressExample;
import com.opentae.data.mall.examples.LogisticsTemplateExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.exceptions.BuyerAddressException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.servicevo.RefundInfoVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.KdniaoUtil;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(ItemOrderBO orderBO) {
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

        // a, 添加物流
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
        logistic.setMoney(calculateLogisticsFee(orderBO.getSenderId(), company.getExpressCompanyId(), buyerAddress.getProvId(), null));
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
            List<SubOrderVO> subOrders = new ArrayList<>();
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

    @Override
    public Long calculateLogisticsFee(Long senderId, Long companyId, Long provId, List<PidNumBO> pids) {
        LogisticsTemplateExample templateExample = new LogisticsTemplateExample();
        templateExample.createCriteria().andEnabledEqualTo(true).andSenderIdEqualTo(senderId);
        logisticsTemplateMapper.selectByExample(templateExample);
        return 0L;
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

    @Override
    public ExpressInfoVO expressInfo(Long orderId) {
        return null;
    }

    @Override
    public List<ExpressLogVO> expressLog(Long expressId) throws Main4Exception, ParseException {
        ItemOrderLogistics itemOrderLogistics = itemOrderLogisticsMapper.selectByPrimaryKey(expressId);
        if (itemOrderLogistics==null){
            throw new Main4Exception("数据库没有对应传入的expressId的数据");
        }
        ExpressCompany expressCompany=null;
        if (itemOrderLogistics.getCompanyId()!=null){
            expressCompany = expressCompanyMapper.selectFieldsByPrimaryKey(itemOrderLogistics.getCompanyId(), FieldUtil.codeFields("express_company_id,remark2"));
        }
        if (expressCompany==null){
            throw new Main4Exception("数据库没有对应的快递公司数据");
        }
        String orderTracesByJson = null;
        try {
            orderTracesByJson = kdniaoUtil.getOrderTracesByJson(expressCompany.getRemark2(), itemOrderLogistics.getCourierNumber());
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

    @Override
    public SubOrderInfoVO suborderInfo(Long subOrderId) {
        return null;
    }

    @Override
    public OrderInfoVO orderInfo(Long orderId) {
        return null;
    }

    @Override
    public List<OrderLogVO> orderLog(Long orderId) {
        return null;
    }

    @Override
    public List<SubOrderInfoVO> suborderInfoByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Long refundApply(Long subOrderId, Integer number) {
        return null;
    }

    @Override
    public RefundInfoVO refundInfo(Long refundId) {
        return null;
    }

    @Override
    public List<RefundLogVO> refundLog(Long refundId) {
        return null;
    }
}
