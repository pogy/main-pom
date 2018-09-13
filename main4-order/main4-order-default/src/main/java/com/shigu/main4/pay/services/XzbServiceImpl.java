package com.shigu.main4.pay.services;

import com.openJar.exceptions.OpenException;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.pays.beans.PayAccount;
import com.opentae.data.pays.beans.PayTrade;
import com.opentae.data.pays.beans.PayXzb;
import com.opentae.data.pays.examples.PayTradeExample;
import com.opentae.data.pays.examples.PayXzbExample;
import com.opentae.data.pays.interfaces.PayTradeMapper;
import com.opentae.data.pays.interfaces.PayXzbMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.pay.bo.XzbPayTrade;
import com.shigu.main4.pay.configs.DisposeBean;
import com.shigu.main4.pay.configs.XzbSystemConstant;
import com.shigu.main4.pay.enums.XzbAlipayToCashEdError;
import com.shigu.main4.pay.enums.XzbBaseErrorCodeEnum;
import com.shigu.main4.pay.enums.XzbRchargeAlipayErrorCodeEnum;
import com.shigu.main4.pay.exceptions.XzbBaseException;
import com.shigu.main4.pay.exceptions.XzbLockException;
import com.shigu.main4.pay.requests.*;
import com.shigu.main4.pay.responses.*;
import com.shigu.main4.pay.utils.ApiLockUtil;
import com.shigu.main4.pay.utils.PayLockV2;
import com.shigu.main4.pay.vos.XzbUserPayTradeRecordVO;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类名：XzbServiceImpl
 * 类路径： com.shigu.main4.pay.services.XzbServiceImpl
 * 创建者： whx
 * 创建时间： 8/6/18 3:44 PM
 * 项目： main-pom
 * 描述： 星座包支付服务
 */
public class XzbServiceImpl implements XzbService {

    @Autowired
    private DisposeBean disposeBean;

    @Autowired
    private ApiLockUtil apiLockUtil;

    @Autowired
    private PayXzbMapper payXzbMapper;

    @Autowired
    private PayTradeMapper payTradeMapper;

    @Autowired
    private XzbBaseService xzbBaseService;

    @Autowired
    private XzbTradeService xzbTradeService;

    @Autowired
    private XzbAlipayHandleService xzbAlipayHandleService;

    @Autowired
    private RedisIO redisIO;

    @Override
    public XzbUserBalanceResponse xzbUserBalance(XzbUserBalanceRequest request) {
        PayAccount account = xzbBaseService.selPayAccount(request.getUserId(), null);
        PayXzb payXzb = null;
        if (account != null) {
            PayXzbExample payXzbExample = new PayXzbExample();
            payXzbExample.createCriteria().andAccountIdEqualTo(account.getAccountId());
            List<PayXzb> payXzbs = payXzbMapper.selectFieldsByExample(payXzbExample, FieldUtil.codeFields("money,block_money"));
            if (payXzbs.size()>0) {
               payXzb = payXzbs.get(0);
            }
        }
        XzbUserBalanceResponse resp = new XzbUserBalanceResponse();
        if (payXzb != null) {
            DecimalFormat format = new DecimalFormat("0.00");
            if (payXzb.getMoney() != null) {
                resp.setBalance(format.format(payXzb.getMoney() / 100.00));
            }
            if (payXzb.getBlockMoney() != null) {
                resp.setBlockMoney(format.format(payXzb.getBlockMoney() / 100.00));
            }
            resp.setSuccess(true);
        } else {
            resp.setBody("没找到资金账户");
        }
        return resp;
    }

    @Override
    public XzbPayResponse xzbPay(XzbPayRequest request) {
        XzbPayResponse resp = new XzbPayResponse();
        XzbPayTrade trade = request.getTrade();
        if (trade == null || StringUtils.isBlank(trade.getOuterId()) || trade.getTotalFee() == null || trade.getTotalFee() <= 0) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("星座宝支付请求参数错误"));
            return resp;
        }
        try {
            resp = xzbTradeService.xzbPay(request);
        } catch (OpenException e) {
            resp.setException(e);
        }
        return resp;
    }

    @Override
    public XzbAlipayRechargeResponse rechargeFromOrderByAlipay(XzbAlipayRechargeRequest request) {
        XzbAlipayRechargeResponse resp = new XzbAlipayRechargeResponse();
        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), request.getAccountId());
        if (account == null) {
            resp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return resp;
        }
        if (StringUtils.isBlank(request.getAlipayNo())) {
            resp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.OUT_TRADE_ID_IS_NULL));
            return resp;
        }
        if (request.getPayAmount() == null) {
            resp.setException(new XzbBaseException(XzbBaseErrorCodeEnum.PAY_AMOUNT_IS_NULL.getCode(), XzbBaseErrorCodeEnum.PAY_AMOUNT_IS_NULL.getMsg()));
            return resp;
        }
        PayLockV2 lock = apiLockUtil.getLock("alipay_" + request.getAlipayNo());
        PayLockV2 companyLock = apiLockUtil.alipayKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        try {
            apiLockUtil.tryLock(companyLock);
            apiLockUtil.tryLock(lock);
            xzbAlipayHandleService.rechargeByAlipay(request.getXzUserId(), request.getAccountId(), request.getAlipayNo(), request.getPayAmount());
            resp.setSuccess(true);
        } catch (XzbLockException e) {
        } catch (XzbBaseException e) {
            resp.setException(e);
        } finally {
            apiLockUtil.destoryLock(lock);
            apiLockUtil.destoryLock(companyLock);
        }
        return resp;
    }

    @Override
    public XzbRefundResponse xzbRefund(XzbRefundRequest request) {
        XzbRefundResponse resp = new XzbRefundResponse();
        if (request.getOutTradeId() == null) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("out_trade_id is null"));
            return resp;
        }
        if (request.getDfGroupId() == null) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("df_group_id is null"));
            return resp;
        }
        if (request.getMoney() == null) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("money is null"));
            return resp;
        }
        if (request.getMoney() <= 0) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("money<0"));
            return resp;
        }
        if (request.getRefundType() == null) {
            resp.setException(xzbBaseService.xzbExceptionByMsg("money<0"));
            return resp;
        }
        try {
            resp = xzbTradeService.xzbRefund(request);
        } catch (OpenException e) {
            resp.setException(e);
        }
        return resp;
    }

    @Override
    public XzbAlipayToCashEdResponse alipayToCashEd(XzbAlipayToCashedRequest request) {
        XzbAlipayToCashEdResponse rsp = new XzbAlipayToCashEdResponse();

        // 数据校验

        if(request == null ){
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.INVALID_ARGUMENT));
            return rsp;
        }

        // 提现金额
        if(request.getCashAmount() == null){
            rsp.setException(new XzbBaseException(XzbAlipayToCashEdError.CASH_AMOUNT_IS_NULL.getCode(),
                    XzbAlipayToCashEdError.CASH_AMOUNT_IS_NULL.getMsg()));
            return rsp;
        }

        if (request.getCashAmount() > disposeBean.getMaxCashMoney()) {
            rsp.setException(new XzbBaseException(XzbAlipayToCashEdError.CASH_AMOUNT_UP_TO_LIMMIT.getCode(),
                    XzbAlipayToCashEdError.CASH_AMOUNT_UP_TO_LIMMIT.getMsg()));
            return rsp;
        }

        if(request.getCashAmount().intValue() <= 0){
            rsp.setException(new XzbBaseException(XzbAlipayToCashEdError.CASH_AMOUNT_FOMCAT_IS_ERROR.getCode(),
                    XzbAlipayToCashEdError.CASH_AMOUNT_FOMCAT_IS_ERROR.getMsg()));
            return rsp;
        }

        // 支付宝账号验证
        if(StringUtils.isEmpty(request.getAlipayUserId())){
            rsp.setException(new XzbBaseException(XzbAlipayToCashEdError.ALIPAY_USER_ID_IS_NULL.getCode(),
                    XzbAlipayToCashEdError.ALIPAY_USER_ID_IS_NULL.getMsg()));
            return rsp;
        }

        // 用户ID
        if (request.getXzUserId() == null && request.getAccountId() == null) {
            rsp.setException(new XzbBaseException(XzbRchargeAlipayErrorCodeEnum.USER_INFO_ID_IS_NULL.getCode(),
                    XzbRchargeAlipayErrorCodeEnum.USER_INFO_ID_IS_NULL.getMsg()));
            return rsp;
        }

        try {
            rsp = xzbTradeService.applyCash(request);
        } catch (OpenException e) {
            rsp.setException(e);
        }
        return rsp;
    }

    @Override
    public XzbUserPayTradeRecordResponse userPayTradeRecord(XzbUserPayTradeRecordRequest request) {
        XzbUserPayTradeRecordResponse rsp = new XzbUserPayTradeRecordResponse();
        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), request.getAccountId());
        if (account == null) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return rsp;
        }
        Long accountId = account.getAccountId();
        PayTradeExample tradeExample = new PayTradeExample();
        tradeExample.setOrderByClause("create_time desc");//结果排序
        if (request.getPageSize() == null)//默认分页
            request.setPageSize(10);
        if (request.getPage() == null)
            request.setPage(1);
        tradeExample.setStartIndex((request.getPage() - 1) * request.getPageSize());//构造limit index, size
        tradeExample.setEndIndex(request.getPageSize());
        PayTradeExample.Criteria criteria = tradeExample.createCriteria();
        if (!StringUtils.isEmpty(request.getOutTradeNo()))//条件查询：外部订单号Like
            criteria.andOutTradeNoLike("%" + request.getOutTradeNo() + "%");
        if (request.getCreateTime() != null) {//创建时间
            criteria.andCreateTimeGreaterThanOrEqualTo(request.getCreateTime());
            if (request.getEndTime() != null){
                criteria.andCreateTimeLessThanOrEqualTo(request.getEndTime());
            } else {
                criteria.andCreateTimeLessThanOrEqualTo(new Date());
            }
        }
        if (request.getDebitType() != null)//扣款种类
            criteria.andDebitTypeEqualTo(request.getDebitType());
        if (request.getType() != null)//交易类型
            criteria.andTypeEqualTo(request.getType());
        if ("out".equals(request.getInout()))//资金流向
            criteria.andFromAccountIdEqualTo(accountId);
        else if ("in".equals(request.getInout()))
            criteria.andToAccountIdEqualTo(accountId);
        else {
            List<PayTradeExample.Criterion> allCriteria = criteria.getAllCriteria();
            List<PayTradeExample.Criterion> pre = new ArrayList<>(allCriteria);
            criteria.andFromAccountIdEqualTo(accountId);
            PayTradeExample.Criteria criteriaOr = tradeExample.or().andToAccountIdEqualTo(accountId);
            criteriaOr.getAllCriteria().addAll(pre);//or 加上之前的条件
        }
        int totalPage = 1;
        int total = payTradeMapper.countByExample(tradeExample);
        int pageSize = request.getPageSize();
        if(total > 0){
            totalPage = total / pageSize;
            if(total % pageSize>0){
                totalPage++;
            }
        }
        rsp.setTotalPages(totalPage);
        rsp.setCurrentPage(request.getPage());
        List<PayTrade> payTrades = payTradeMapper.selectByConditionList(tradeExample);
        List<XzbUserPayTradeRecordVO> jsonPayTradeVos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (PayTrade payTrade : payTrades) {
            XzbUserPayTradeRecordVO vo = BeanMapper.map(payTrade, XzbUserPayTradeRecordVO.class);
            Long toAccountId = payTrade.getToAccountId();
            if (toAccountId != null && toAccountId.equals(accountId)) {
                vo.setInout("in");
            } else {
                vo.setInout("out");
            }
            vo.setCreateTime("");
            if (payTrade.getCreateTime() != null) {
                vo.setCreateTime(sdf.format(payTrade.getCreateTime()));
            }
            vo.setTotalPrice(vo.getPrice());
            if (payTrade.getServiceCharge() != null) {
                vo.setServiceCharge(String.format("%.2f", payTrade.getServiceCharge() * 0.01));
            }
            jsonPayTradeVos.add(vo);
        }
        rsp.setTradeLog(jsonPayTradeVos);
        rsp.setSuccess(true);
        return rsp;
    }

    @Override
    public XzbDisposeLimitResponse userDisposeLimit(XzbUserDisposeLimitRequest request) {
        XzbDisposeLimitResponse rsp = new XzbDisposeLimitResponse();
        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), null);
        if (account == null) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return rsp;
        }
        rsp.setWithdrawUpperLimit(String.format("%.2f", 0.01 * disposeBean.getMaxCashMoney()));
        int maxFreeTimes = disposeBean.getMaxFreeTimes();
        int month = new Date().getMonth();
        Map unprocessedMap = redisIO.get(String.format("%s%d_%d", XzbSystemConstant.USER_CASH_UNPROCESSED_INDEX_PRIFIX, account.getAccountId(), month), Map.class);
        maxFreeTimes -= unprocessedMap == null ? 0 : unprocessedMap.size();
        rsp.setFreeWithdrawNum(maxFreeTimes >= 0 ? maxFreeTimes : 0);
        rsp.setSuccess(true);
        return rsp;
    }

    @Override
    public XzbInviteRechargeResponse inviteRebateRecharge(XzbInviteRechargeRequest request) {
        XzbInviteRechargeResponse rsp = new XzbInviteRechargeResponse();
        if (request.getXzUserId() == null || request.getRebateOrderNo() == null || request.getRebateAmount() == null || request.getRebateAmount() <= 0L) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.INVALID_ARGUMENT));
            return rsp;
        }
        PayAccount payAccount = xzbBaseService.selPayAccount(request.getXzUserId(), null);
        if (payAccount == null) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return rsp;
        }
        try {
            rsp = xzbTradeService.inviteRebateRecharge(request.getXzUserId(), request.getRebateOrderNo(), request.getRebateAmount());
        } catch (OpenException e) {
            rsp.setException(e);
        }
        return rsp;
    }

    @Override
    public XzbOrderCashBackResponse orderCashBack(XzbOrderCashBackRequest request) {
        XzbOrderCashBackResponse rsp = new XzbOrderCashBackResponse();
        if (request.getXzUserId() == null || request.getCashbackOrderNo() == null || request.getCashbackAmount() == null || request.getCashbackAmount()<=0L) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.INVALID_ARGUMENT));
            return rsp;
        }
        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), null);
        if (account == null) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return rsp;
        }
        try {
            xzbTradeService.cashbackRecharge(request.getXzUserId(), request.getCashbackOrderNo(), request.getCashbackAmount());
            rsp.setSuccess(true);
        } catch (OpenException e) {
            rsp.setException(e);
        }
        return rsp;
    }

    @Override
    public XzbRedPackPayResponse redPackPay(XzbReqPackPayRequest request) {

        XzbRedPackPayResponse resp = new XzbRedPackPayResponse();
        if (request.getXzUserId() == null || request.getPayAmount() <= 0 ) {
            return resp;
        }
        resp = xzbTradeService.redPackRecharge(request);
        return resp;
    }
}
