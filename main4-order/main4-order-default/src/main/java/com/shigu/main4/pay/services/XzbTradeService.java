package com.shigu.main4.pay.services;



import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguBonusExample;
import com.opentae.data.mall.interfaces.*;
import com.opentae.data.pays.beans.*;
import com.opentae.data.pays.examples.PayTradeExample;
import com.opentae.data.pays.interfaces.*;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.pay.bo.XzbPayTrade;
import com.shigu.main4.pay.configs.DisposeBean;
import com.shigu.main4.pay.configs.XzbSystemConstant;
import com.shigu.main4.pay.dtos.UserFreeCashInfo;
import com.shigu.main4.pay.dtos.UserFreeCashInfoMap;
import com.shigu.main4.pay.enums.XzbBaseErrorCodeEnum;
import com.shigu.main4.pay.enums.XzbPayTradeError;
import com.shigu.main4.pay.enums.XzbRedPackErrorCodeEnum;
import com.shigu.main4.pay.enums.XzbRefundError;
import com.shigu.main4.pay.exceptions.XzbBaseException;
import com.shigu.main4.pay.exceptions.XzbLockException;
import com.shigu.main4.pay.exceptions.XzbPayException;
import com.shigu.main4.pay.requests.XzbAlipayToCashedRequest;
import com.shigu.main4.pay.requests.XzbPayRequest;
import com.shigu.main4.pay.requests.XzbRefundRequest;
import com.shigu.main4.pay.requests.XzbReqPackPayRequest;
import com.shigu.main4.pay.responses.*;
import com.shigu.main4.pay.utils.ApiLockUtil;
import com.shigu.main4.pay.utils.PayLockV2;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类名：XzbTradeService
 * 类路径： com.shigu.main4.pay.services.XzbTradeService
 * 创建者： whx
 * 创建时间： 8/9/18 3:20 PM
 * 项目： main-pom
 * 描述：
 */
@Service
public class XzbTradeService {

    @Autowired
    private DisposeBean disposeBean;

    @Autowired
    private ApiLockUtil apiLockUtil;

    @Autowired
    private XzbBaseService xzbBaseService;

    @Autowired
    private PayXzbMapper payXzbMapper;

    @Autowired
    private PayTradeMapper payTradeMapper;

    @Autowired
    private PayAlipayMapper payAlipayMapper;

    @Autowired
    private PayXzbRecordMapper payXzbRecordMapper;

    @Autowired
    private PayRechargeMapper payRechargeMapper;

    @Autowired
    private PayCashMapper payCashMapper;

    @Autowired
    private InviteOrderRebateRecordMapper inviteOrderRebateRecordMapper;

    @Autowired
    private ShiguOrderCashbackMapper shiguOrderCashbackMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ShiguBonusMapper shiguBonusMapper;

    @Autowired
    private ShiguBonusRecordMapper shiguBonusRecordMapper;

    @Autowired
    private RedisIO redisIO;

    private String inviteRebateRechargePayNoPrefix = "invite_rebate_recharge_prefix_";

    private String orderCashbackRechargePayNoPrefix = "order_feed_back_prefix_";

    @Autowired
    private ItemOrderService itemOrderService;

    /**
     * 添加交易记录
     * @param payTrade
     * @return
     */
    public PayTrade changeTrade(PayTrade payTrade) {
        if (payTrade != null) {
            payTradeMapper.insertSelective(payTrade);
        }
        return payTrade;
    }

    /**
     * 星座宝充值
     * @param accountId
     * @param money
     * @param recordType
     * @param payId
     * @param rechargeId
     */
    public void rechargeMoney(Long accountId, Long money, Integer recordType, Long payId, Long rechargeId) throws XzbBaseException {
        PayXzb payXzb = new PayXzb();
        payXzb.setAccountId(accountId);
        payXzb = payXzbMapper.selectOne(payXzb);
        if(payXzb==null){
            throw new XzbBaseException(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST.getCode(),XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST.getMsg());
        }
        Long fromMoney = payXzb.getMoney();
        payXzb.setMoney(payXzb.getMoney() + money);
        payXzb.setTotalMoney(payXzb.getTotalMoney()+money);
        payXzbMapper.updateByPrimaryKeySelective(payXzb);
        // 变动记录
        PayXzbRecord payXzbRecord = new PayXzbRecord();
        payXzbRecord.setAccountId(accountId);
        payXzbRecord.setMoney(money);
        payXzbRecord.setFromMoney(fromMoney);
        payXzbRecord.setToMoney(payXzb.getMoney());
        payXzbRecord.setRechargeId(rechargeId);
        payXzbRecord.setType(recordType);
        payXzbRecord.setCreateTime(new Date());
        payXzbRecord.setComments(payXzbRecord.toString());
        payXzbRecord.setPayId(payId);
        payXzbRecordMapper.insertSelective(payXzbRecord);
    }

    /**
     * 星座宝支付
     * @param request
     * @return
     */
    public XzbPayResponse xzbPay(XzbPayRequest request) throws XzbBaseException, XzbPayException, XzbLockException {
        if(request.getAccountId()==null&&request.getXzUserId()==null){
            throw new XzbBaseException("未找到对应的资金账户[userId:"+ request.getXzUserId()+",accountId:"+request.getAccountId()+"]");
        }
        PayAccount account=xzbBaseService.selPayAccount(request.getXzUserId(), request.getAccountId());
        if(account==null){
            throw new XzbBaseException("未找到对应的资金账户[userId:"+ request.getXzUserId()+",accountId:"+request.getAccountId()+"]");
        }
        if(account.getAccountType() != 1){
            throw new XzbBaseException(XzbPayTradeError.NOT_XZB.getCode(),XzbPayTradeError.NOT_XZB.getMsg());
        }

        XzbPayTrade trade=request.getTrade();
        //下单关键过程
        Long payId = xzbPay(account, trade);
        XzbPayResponse resp=new XzbPayResponse();
        resp.setSuccess(true);
        resp.setPayId(payId);
        return resp;
    }

    @Transactional(rollbackFor = Exception.class)
    protected Long xzbPay(PayAccount account, XzbPayTrade trade) throws XzbPayException, XzbBaseException, XzbLockException {
        PayLockV2 orderNolock = apiLockUtil.getLock("xzbPay_" + trade.getOuterId());
        PayLockV2 accountLock = apiLockUtil.xzbKey(account.getAccountId());
        PayLockV2 companyAccountLock = apiLockUtil.xzbKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        try {
            apiLockUtil.tryLock(orderNolock);
            apiLockUtil.tryLock(accountLock);
            apiLockUtil.tryLock(companyAccountLock);
            PayTradeExample payTradeExample = new PayTradeExample();
            PayTradeExample.Criteria cri = payTradeExample.createCriteria();
            cri.andOutTradeNoEqualTo(trade.getOuterId());
            if(trade.getSubOuterId()!=null&&!"".equals(trade.getSubOuterId())){
                cri.andOutSubTradeNoEqualTo(trade.getSubOuterId());
            }else{
                cri.andOutSubTradeNoIsNull();
            }
            payTradeExample.setStartIndex(0);
            payTradeExample.setEndIndex(1);
            List<PayTrade> payTrades = payTradeMapper.selectFieldsByConditionList(payTradeExample, FieldUtil.codeFields("pay_id,price,pov_ids,type,debit_type"));
            if (payTrades.size() > 0) {
                XzbPayException exce=new XzbPayException(XzbPayTradeError.HAS_PAYED);
                PayTrade oldpt=payTrades.get(0);
                exce.setTotalFee(oldpt.getPrice());
                exce.setUseVolumes(oldpt.getPovIds());
                exce.setTradeType(oldpt.getType());
                exce.setTradedebitType(oldpt.getDebitType());
                exce.setPayId(oldpt.getPayId());
                throw exce;
            }
            PayXzb payXzb = new PayXzb();
            payXzb.setAccountId(account.getAccountId());
            payXzb = payXzbMapper.selectOne(payXzb);
            if (payXzb == null) {
                throw new XzbPayException(XzbPayTradeError.NO_YUER);
            }
            if (payXzb.getMoney() < trade.getTotalFee()) {
                throw new XzbPayException(XzbPayTradeError.NO_MUSH_MONEY);
            }
            PayTrade payTrade = new PayTrade();
            payTrade.setDebitType(2);
            payTrade.setFromAccountId(account.getAccountId());
            payTrade.setToAccountId(XzbSystemConstant.COMPANY_ACCOUNT_ID);
            payTrade.setOutTradeNo(trade.getOuterId());
            payTrade.setOutSubTradeNo(trade.getSubOuterId());
            payTrade.setPrice(trade.getTotalFee());
            payTrade.setCreateTime(new Date());
            // 添加交易记录
            changeTrade(payTrade);

            Long payId = payTrade.getPayId();
            // 用户星座宝扣款
            debitMoney(account.getAccountId(), trade.getTotalFee(), XzbSystemConstant.XZB_RECORD_TYPE_PAYMENT, payId);
            // 公司账户资金记录
            rechargeMoney(XzbSystemConstant.COMPANY_ACCOUNT_ID, trade.getTotalFee(), XzbSystemConstant.XZB_RECORD_TYPE_PAYMENT, payId, null);
            return payId;
        } finally {
            apiLockUtil.destoryLock(orderNolock);
            apiLockUtil.destoryLock(accountLock);
            apiLockUtil.destoryLock(companyAccountLock);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public XzbRefundResponse xzbRefund(XzbRefundRequest request) throws XzbLockException, XzbBaseException {
        PayLockV2 refundLock = apiLockUtil.getLock("refund_outTradeId_" + request.getOutTradeId());
        try {
            apiLockUtil.tryLock(refundLock);
            PayTradeExample payTradeExample = new PayTradeExample();
            payTradeExample.createCriteria().andOutTradeNoEqualTo(request.getOutTradeId()).andTypeEqualTo(XzbSystemConstant.PAY_TRADE_TYPE_BUYIN);
            payTradeExample.setStartIndex(0);
            payTradeExample.setEndIndex(1);
            List<PayTrade> payList = payTradeMapper.selectFieldsByConditionList(payTradeExample, FieldUtil.codeFields("price,alipay_no,out_trade_no,out_sub_trade_no,pay_id,pov_ids,debit_type,from_account_id,to_account_id"));
            if (payList.size() == 0) {
                throw new XzbBaseException(XzbRefundError.NO_SUCH_TRADE.getCode(), request.getOutTradeId());
            }
            PayTrade payTrade = payList.get(0);
            PayLockV2 userLock= apiLockUtil.xzbKey(payTrade.getFromAccountId());
            PayLockV2 systemLock=apiLockUtil.xzbKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
            PayLockV2 systemAliLock=apiLockUtil.xzbKey(XzbSystemConstant.COMPANY_ALIPAY_ACCOUNT_ID);
            try {
                apiLockUtil.tryLock(userLock);
                apiLockUtil.tryLock(systemLock);
                apiLockUtil.tryLock(systemAliLock);
                if (payTrade.getDebitType().equals(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_ALIPAY)) {
                    return refundAlipay(request, payTrade);
                }
                if (request.getSubOutTradeId() == null) {
                    return refundXzbTrade(request, payTrade);
                }
                return refundXzbOrder(request, payTrade);
            } finally {
                apiLockUtil.destoryLock(systemAliLock);
                apiLockUtil.destoryLock(systemLock);
                apiLockUtil.destoryLock(userLock);
            }
        } finally {
            apiLockUtil.destoryLock(refundLock);
        }

    }

    protected XzbRefundResponse refundAlipay(XzbRefundRequest req, PayTrade pay) throws XzbBaseException {
        //验证钱够减
        long totalMoney = checkCanRefund(pay, 0l);
        //把钱充值进用户星座宝
        PayRecharge pr=new PayRecharge();
        pr.setPrice(req.getMoney());
        pr.setAccountId(XzbSystemConstant.COMPANY_ACCOUNT_ID.toString());
        pr.setCreateTime(new Date());
        pr.setStatus(1);
        //创建退款交易
        if(req.getSubOutTradeId()==null){//全退
            //加充值记录
            pr.setPrice(totalMoney);
            pr.setAlipayNo(pay.getAlipayNo() + "_" + req.getOutTradeId() + "_-1");
            pr.setType(XzbSystemConstant.RECHARGE_SUCCESS);
            payRechargeMapper.insertSelective(pr);

            PayTrade pt=new PayTrade();
            pt.setType(XzbSystemConstant.PAY_TRADE_TYPE_REFUND);
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_XZB);
            pt.setRechargeId(pr.getRechargeId());
            pt.setPrice(totalMoney);
            pt.setFromAccountId(XzbSystemConstant.COMPANY_ALIPAY_ACCOUNT_ID);
            pt.setToAccountId(pay.getFromAccountId());
            pt.setOutTradeNo(pay.getOutTradeNo());
            pt.setOutSubTradeNo(pay.getOutSubTradeNo());
            pt.setOutComments(req.getRefundReason());
            pt.setCreateTime(new Date());
            pt.setRefundType(req.getRefundType());
            try {
                payTradeMapper.insertSelective(pt);
            } catch (Exception e) {
                throw new XzbBaseException(XzbRefundError.HAS_REFUNDED.getCode(), XzbRefundError.HAS_REFUNDED.getMsg());
            }
            //给用户加钱
            rechargeMoney(pay.getFromAccountId(), pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND, pt.getPayId(), pr.getRechargeId());

        }else{
            //加充值记录
            pr.setPrice(req.getMoney());
            pr.setAlipayNo(pay.getAlipayNo() + "_" + req.getOutTradeId() + "_" + req.getSubOutTradeId());
            pr.setType(XzbSystemConstant.RECHARGE_SUCCESS);
            payRechargeMapper.insertSelective(pr);

            List<String> subs=req.getSubOutTradeId();
            String allSubs=StringUtil.joinList(subs,",");
            PayTrade pt=new PayTrade();
            pt.setType(XzbSystemConstant.PAY_TRADE_TYPE_REFUND);
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_XZB);
            pt.setRechargeId(pr.getRechargeId());
            pt.setPrice(req.getMoney());
            pt.setFromAccountId(XzbSystemConstant.COMPANY_ALIPAY_ACCOUNT_ID);
            pt.setToAccountId(pay.getFromAccountId());
            pt.setOutTradeNo(pay.getOutTradeNo());
            pt.setOutSubTradeNo(allSubs);
            pt.setOutComments(req.getRefundReason());
            pt.setCreateTime(new Date());
            pt.setRefundType(req.getRefundType());
            try {
                payTradeMapper.insertSelective(pt);
            } catch (Exception e) {
                throw new XzbBaseException(XzbRefundError.HAS_REFUNDED.getCode(), XzbRefundError.HAS_REFUNDED.getMsg());
            }
            //给用户加钱
            rechargeMoney(pay.getFromAccountId(), pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND, pt.getPayId(), pr.getRechargeId());
        }
        XzbRefundResponse res=new XzbRefundResponse();
        res.setSuccess(true);
        return res;
    }

    /**
     * 按交易退
     * 金额可以小于等于付款交易总额-所有已退金额
     * 小于的情况是邮费可能不退
     * @param req
     * @return
     */
    protected XzbRefundResponse refundXzbTrade(XzbRefundRequest req, PayTrade pay) throws XzbBaseException {
        long totalMoney=checkCanRefund(pay, 0l);
        Long refundMoney=totalMoney;
        PayTrade pt=new PayTrade();
        pt.setType(XzbSystemConstant.PAY_TRADE_TYPE_REFUND);
        if(refundMoney==0l){
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_COUPON);
        }else{
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_XZB);
        }
        pt.setPovIds("");
        pt.setRefundType(req.getRefundType());
        pt.setOutComments(req.getRefundReason());
        pt.setCreateTime(new Date());
        pt.setFromAccountId(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        pt.setToAccountId(pay.getFromAccountId());
        pt.setPrice(refundMoney);
        pt.setOutTradeNo(req.getOutTradeId());
        pt.setOutSubTradeNo("-1");
        try {
            payTradeMapper.insertSelective(pt);//插入退款交易
        } catch (Exception e) {
            throw new XzbBaseException(XzbRefundError.HAS_REFUNDED.getCode(), XzbRefundError.HAS_REFUNDED.getMsg());
        }
        //公司账户减钱
        if(pt.getPrice()>0){
            debitMoney(XzbSystemConstant.COMPANY_ACCOUNT_ID,pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND,pt.getPayId());
            //用户账户加钱
            rechargeMoney(pay.getFromAccountId(),pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND, pt.getPayId(), null);
        }
        XzbRefundResponse res=new XzbRefundResponse();
        res.setSuccess(true);
        return res;
    }

    /**
     * 按子订单退
     * 金额需要小于等于付款交易总额-所有已退金额
     * @param req
     * @return
     */
    protected XzbRefundResponse refundXzbOrder(XzbRefundRequest req,PayTrade pay) throws XzbBaseException {
        checkCanRefund(pay, req.getMoney());
        Long refundMoney=req.getMoney();
        PayTrade pt=new PayTrade();
        pt.setType(XzbSystemConstant.PAY_TRADE_TYPE_REFUND);
        if(refundMoney==0L){
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_COUPON);
        }else{
            pt.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_XZB);
        }
        pt.setPovIds("");
        pt.setRefundType(req.getRefundType());
        pt.setOutComments(req.getRefundReason());
        pt.setCreateTime(new Date());
        pt.setFromAccountId(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        pt.setToAccountId(pay.getFromAccountId());
        pt.setPrice(refundMoney);
        pt.setOutTradeNo(req.getOutTradeId());
        pt.setOutSubTradeNo(StringUtil.joinList(req.getSubOutTradeId(),","));
        try {
            payTradeMapper.insertSelective(pt);//插入退款交易
        } catch (Exception e) {
            throw new XzbBaseException(XzbRefundError.HAS_REFUNDED.getCode(), XzbRefundError.HAS_REFUNDED.getMsg());
        }
        if(pt.getPrice()>0){
            //公司账户减钱
            debitMoney(XzbSystemConstant.COMPANY_ACCOUNT_ID, pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND, pt.getPayId());
            //用户账户加钱
            rechargeMoney(pay.getFromAccountId(), pt.getPrice(), XzbSystemConstant.XZB_RECORD_TYPE_REFUND, pt.getPayId(), null);
        }
        XzbRefundResponse res=new XzbRefundResponse();
        res.setSuccess(true);
        return res;
    }

    /**
     * 检测是否可退
     * 1、查出外部交易号对应的付款交易
     * 2、查出此前所有的退款交易
     * 3、money<=实付金+卷金-所有退款-所有退卷
     * @param pay
     * @param money
     * @return long 可扣的最大钱数
     */
    private long checkCanRefund(PayTrade pay,Long money) throws XzbBaseException {
        Long totalMoney=pay.getPrice();
        //查出所有的退款
        PayTradeExample payexam=new PayTradeExample();
        payexam.createCriteria().andOutTradeNoEqualTo(pay.getOutTradeNo()).andTypeEqualTo(XzbSystemConstant.PAY_TRADE_TYPE_REFUND);
        List<PayTrade> refunds=payTradeMapper.selectFieldsByExample(payexam,FieldUtil.codeFields("price,pay_id,pov_ids"));
        for(PayTrade pt:refunds){
            totalMoney-=pt.getPrice();//把已退款的金额减掉
        }
        if(totalMoney<money){//交易的总额不够退
            throw new XzbBaseException(XzbRefundError.NO_MONEY_TO_REFUND.getCode(),pay.getOutTradeNo());
        }
        return totalMoney;
    }

    /**
     * 支付宝金额添加
     *
     * @param alipayUserId
     * @param money
     */
    public void addMoneyAlipay(String alipayUserId, Long money) {
        PayAlipay alipay = new PayAlipay();
        alipay.setAlipayUserId(alipayUserId);
        alipay = payAlipayMapper.selectOne(alipay);
        alipay.setPrice(alipay.getPrice() + money);
        alipay.setLastModifyTime(new Date());
        payAlipayMapper.updateByPrimaryKey(alipay);
    }

    /**
     * 支付宝金额扣款
     *
     * @param alipayUserId
     * @param money
     */
    public void debitMoneyAlipay(String alipayUserId, Long money) {
        PayAlipay alipay = new PayAlipay();
        alipay.setAlipayUserId(alipayUserId);
        alipay = payAlipayMapper.selectOne(alipay);
        alipay.setPrice(alipay.getPrice() - money);
        alipay.setLastModifyTime(new Date());
        payAlipayMapper.updateByPrimaryKey(alipay);
    }

    /**
     * 星座宝账户扣款
     * @param accountId
     * @param money
     * @param recordType
     * @param payId
     * @throws XzbBaseException
     */
    public void debitMoney(Long accountId, Long money, Integer recordType, Long payId) throws XzbBaseException {
        PayXzb payXzb = new PayXzb();
        payXzb.setAccountId(accountId);
        payXzb = payXzbMapper.selectOne(payXzb);
        if (payXzb == null ) {
            throw new XzbBaseException("未查询到账户信息");
        }
        if(money <= 0){
            throw new XzbBaseException("扣款金额有误，金额需大于零");
        }
        if(payXzb.getMoney() < money){
            throw new XzbBaseException("余额不足");
        }
        Long fromMoney = payXzb.getMoney();
        payXzb.setMoney(payXzb.getMoney() - money);
        payXzb.setTotalMoney(payXzb.getTotalMoney() - money);
        payXzbMapper.updateByPrimaryKeySelective(payXzb);

        // 变动记录
        PayXzbRecord payXzbRecord = new PayXzbRecord();
        payXzbRecord.setAccountId(accountId);
        payXzbRecord.setMoney(money);
        payXzbRecord.setFromMoney(fromMoney);
        payXzbRecord.setToMoney(payXzb.getMoney());
        payXzbRecord.setType(recordType);
        payXzbRecord.setCreateTime(new Date());
        payXzbRecord.setComments(payXzbRecord.toString());
        payXzbRecord.setPayId(payId);
        payXzbRecordMapper.insertSelective(payXzbRecord);
    }

    /**
     * 提现申请
     * @param request
     * @return
     * @throws XzbBaseException
     * @throws XzbLockException
     */
    public XzbAlipayToCashEdResponse applyCash(XzbAlipayToCashedRequest request) throws XzbBaseException, XzbLockException {
        XzbAlipayToCashEdResponse rsp = new XzbAlipayToCashEdResponse();
        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), request.getAccountId());
        if (account == null) {
            rsp.setException(xzbBaseService.xzbExceptionByErrorCode(XzbBaseErrorCodeEnum.USER_INFO_ID_IS_NOT_EXTIST));
            return rsp;
        }

        PayAccount payAccount = xzbBaseService.selPayAccount(request.getXzUserId(), request.getAccountId());
        Long accountId = payAccount.getAccountId();
        Long applyCashAmount = request.getCashAmount();
        PayLockV2 accountCashApplyLock = apiLockUtil.getLock("alipay_cashed_" + account.getAccountId());
        try {
            apiLockUtil.tryLock(accountCashApplyLock);
            // 星座宝冻结金额
            blockMoney(accountId, applyCashAmount);
            Calendar instance = Calendar.getInstance();
            Date now = instance.getTime();
            PayCash payCash = new PayCash();
            payCash.setAccountId(accountId);
            payCash.setXzUserId(request.getXzUserId());
            payCash.setCashRemark("");// 打款备注
            payCash.setCashType(XzbSystemConstant.PAY_CASH_APPLY_STATUS);
            payCash.setCashTime(now);
            payCash.setCashModifyTime(now);
            payCash.setCashStatus(XzbSystemConstant.PAY_CASH_NORMAL_STATUS);
            payCash.setAlipayUserId(request.getAlipayUserId());
            payCash.setAlipayUserName(request.getAlipayRealName());
            //需要根据情况决定是否计算结果
            //用户实际出的手续费值 以分为单位
            long cashToUser = applyCashAmount;
            long poundageToUser = 0L;
            double poundageSet = 0L;
            double extraIncomePoundage = 0L;
            //有手续费状况，计算手续费
            String unprocessedIndex = null;
            UserFreeCashInfoMap unprocessedMap = null;
            //是否使用用户提现免手续费次数
            boolean userCashFreeChanceIs = false;
            if ( null == request.getAccountId()) {
                //已经处理的无手续费提现次数
                unprocessedIndex = String.format("%s%d_%d", XzbSystemConstant.USER_CASH_UNPROCESSED_INDEX_PRIFIX, accountId, now.getMonth());
                unprocessedMap = redisIO.get(unprocessedIndex, UserFreeCashInfoMap.class);
                if (unprocessedMap == null) {
                    unprocessedMap = new UserFreeCashInfoMap();
                }
                if (unprocessedMap.size() < disposeBean.getMaxFreeTimes()) {
                    userCashFreeChanceIs = true;
                } else {
                    BigDecimal applyDecimal = BigDecimal.valueOf(applyCashAmount);
                    //扣除0.6%手续费的实际提现金额计算值
                    BigDecimal cashSet = applyDecimal.multiply(BigDecimal.valueOf(0.994F));
                    cashToUser = cashSet.longValue();
                    poundageToUser = applyCashAmount - cashToUser;
                    BigDecimal poundageSetDecimal = applyDecimal.subtract(cashSet);
                    poundageSet = poundageSetDecimal.doubleValue();
                    extraIncomePoundage = BigDecimal.valueOf(poundageToUser).subtract(poundageSetDecimal).doubleValue();
                }
            }
            payCash.setCashMoney(cashToUser);
            payCash.setCashTotalApply(applyCashAmount);
            payCash.setPoundageSet(String .valueOf(poundageSet));
            payCash.setPoundageToUser(poundageToUser);
            payCash.setExtraIncomePoundage(String.valueOf(extraIncomePoundage));
            payCashMapper.insertSelective(payCash);
            Long payCashIndex = payCash.getCashId();
            String cashRemark = StringUtil.str10To37Str() + payCashIndex;
            payCash.setCashRemark(cashRemark);
            payCashMapper.updateByPrimaryKeySelective(payCash);
            //用户提现使用免费次数,且完成记录写入
            if (userCashFreeChanceIs) {
                UserFreeCashInfo userFreeCashInfo = new UserFreeCashInfo();
                userFreeCashInfo.setCashId(payCash.getCashId());
                userFreeCashInfo.setCashMoney(applyCashAmount);
                unprocessedMap.put(payCash.getCashId().intValue(),userFreeCashInfo);
                //数据存放35天
                redisIO.putFixedTemp(unprocessedIndex,unprocessedMap,3600*24*35);
            }
            rsp.setSuccess(true);
            return rsp;
        } finally {
            apiLockUtil.destoryLock(accountCashApplyLock);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public XzbInviteRechargeResponse inviteRebateRecharge(Long xzUserId, Long orderId, Long rebateAmount) throws XzbBaseException, XzbLockException {
        XzbInviteRechargeResponse rsp = new XzbInviteRechargeResponse();
        InviteOrderRebateRecord record = new InviteOrderRebateRecord();
        record.setOrderId(orderId);
        record = inviteOrderRebateRecordMapper.selectOne(record);
        if (record == null) {
            rsp.setException(new XzbBaseException("该订单无返点信息"));
            return rsp;
        }
        PayAccount account = xzbBaseService.selPayAccount(xzUserId, null);
        if (record.getRebateState() == null || !record.getRebateState().equals(1)) {
            rsp.setException(new XzbBaseException("邀请注册返点校验失败"));
            return rsp;
        }
        if (!orderId.equals(record.getOrderId())) {
            rsp.setException(new XzbBaseException("邀请注册返现失败"));
            return rsp;
        }
        if (!rebateAmount.equals(record.getRebateAmount())) {
            rsp.setException(new XzbBaseException("邀请注册返现金额不匹配"));
            return rsp;
        }
        realInviteRebateRecharge(account.getAccountId(), orderId, rebateAmount);
        itemOrderService.inviteRebateSuccessNotify(orderId);
        rsp.setSuccess(true);
        return rsp;
    }

    protected void realInviteRebateRecharge(Long accountId, Long orderIfd, Long rebateRechargeAmount) throws XzbBaseException, XzbLockException {
        PayLockV2 rebateLock = apiLockUtil.getLock("inviteRebateRecharge_" + orderIfd);
        PayLockV2 accountLock = apiLockUtil.xzbKey(accountId);
        PayLockV2 companyAccountLock = apiLockUtil.xzbKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        try {
            apiLockUtil.tryLock(rebateLock);
            apiLockUtil.tryLock(accountLock);
            apiLockUtil.tryLock(companyAccountLock);
            String inviteRebateRechargeTradeNo = inviteRebateRechargePayNoPrefix + orderIfd;
            PayRecharge payRecharge = new PayRecharge();
            payRecharge.setAlipayNo(inviteRebateRechargeTradeNo);
            if (payRechargeMapper.selectCount(payRecharge) > 0) {
                throw new XzbBaseException("该笔订单已经完成返现>>星座网返现交易号>>" + inviteRebateRechargeTradeNo);
            }
            Date now = new Date();
            payRecharge.setAccountId(accountId.toString());
            payRecharge.setCreateTime(now);
            payRecharge.setPrice(rebateRechargeAmount);
            payRecharge.setType(XzbSystemConstant.PAY_RECHARGE_INVITE_REBATE_TYPE);
            payRecharge.setStatus(XzbSystemConstant.RECHARGE_SUCCESS);
            payRechargeMapper.insertSelective(payRecharge);
            PayTrade payTrade = new PayTrade();
            payTrade.setType(XzbSystemConstant.PAY_TRADE_TYPE_INVITE_REBATE);
            payTrade.setAlipayNo(inviteRebateRechargeTradeNo);
            payTrade.setRechargeId(payRecharge.getRechargeId());
            payTrade.setFromAccountId(accountId);
            payTrade.setToAccountId(accountId);
            payTrade.setPrice(rebateRechargeAmount);
            payTrade.setCreateTime(now);
            payTrade.setOutTradeNo(String .valueOf("invite_rebate_" + payRecharge.getRechargeId()));
            payTrade.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_INVITE_REBATE);
            payTradeMapper.insertSelective(payTrade);
            rechargeMoney(accountId,rebateRechargeAmount, XzbSystemConstant.XZB_RECORD_TYPE_RECHARGE, payTrade.getPayId(), payRecharge.getRechargeId());
        } finally {
            apiLockUtil.destoryLock(companyAccountLock);
            apiLockUtil.destoryLock(accountLock);
            apiLockUtil.destoryLock(rebateLock);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void cashbackRecharge(Long xzUserId, Long orderId, Long cashBackAmount) throws XzbBaseException, XzbLockException {
        PayAccount account = xzbBaseService.selPayAccount(xzUserId, null);
        ShiguOrderCashback shiguOrderCashback = new ShiguOrderCashback();
        shiguOrderCashback.setOId(orderId);
        List<ShiguOrderCashback> shiguOrderCashbacks = shiguOrderCashbackMapper.select(shiguOrderCashback);
        if (shiguOrderCashbacks==null || shiguOrderCashbacks.size()<=0){
            return;
        }
        Long userId = account.getXzUserId();
        ShiguOrderCashback cashback = shiguOrderCashbacks.get(0);
        if (cashback.getEndTime() != null) {
            return;
        }
        ItemOrder itemOrder = itemOrderMapper.selectByPrimaryKey(orderId);
        if (itemOrder == null) {
            return;
        }
        long orderUserId = itemOrder.getUserId();
        if (!userId.equals(orderUserId)) {
            throw new XzbBaseException("返现帐号不匹配");
        }
        // 交易完成时未退款、退货商品总金额
        long tradeAmount = cashback.getCashback() * 100;

        // 返现比例使用返现千分比
        long cashbackRate = 10;
        BigDecimal orderAmountDecimal = BigDecimal.valueOf(tradeAmount);
        long calculateCashbackAmount = orderAmountDecimal.multiply(BigDecimal.valueOf(cashbackRate))
                .divide(BigDecimal.valueOf(1000)).longValue();
        if (!cashBackAmount.equals(calculateCashbackAmount)) {

            throw new XzbBaseException("返现金额异常");
        }

        //实际开始返现充值
        realCashback(account.getAccountId(), orderId, cashBackAmount);

        //返现成功向主站推送返现成功消息
        cashbackSuccessNotify(orderId);
    }

    protected void cashbackSuccessNotify(Long orderId) {
        ShiguOrderCashback shiguOrderCashback = new ShiguOrderCashback();
        shiguOrderCashback.setOId(orderId);
        List<ShiguOrderCashback> shiguOrderCashbacks = shiguOrderCashbackMapper.select(shiguOrderCashback);
        if (shiguOrderCashbacks==null || shiguOrderCashbacks.size()<=0){
            return;
        }
        Long cId = shiguOrderCashbacks.get(0).getCId();
        ShiguOrderCashback success = new ShiguOrderCashback();
        success.setCId(cId);
        success.setEndTime(new Date());
        shiguOrderCashbackMapper.updateByPrimaryKeySelective(success);
    }

    /**
     * 进行返现充值
     *
     * @param accountId
     * @param orderId
     * @param cashbackAmount
     * @throws Exception
     */
    protected void realCashback(Long accountId, Long orderId, Long cashbackAmount) throws XzbBaseException, XzbLockException {
        // 订单返现交易号
        String orderCashbackTradeNo = orderCashbackRechargePayNoPrefix + orderId;
        PayRecharge payRecharge = new PayRecharge();
        payRecharge.setAlipayNo(orderCashbackTradeNo);
        if (payRechargeMapper.selectCount(payRecharge) > 0) {
            throw new XzbBaseException("该笔订单已经完成返现>>星座网返现交易号>>"  + orderCashbackTradeNo);
        }
        PayLockV2 cashBackLock = apiLockUtil.getLock("orderCashBack_" + orderId);
        PayLockV2 accountLock = apiLockUtil.xzbKey(accountId);
        PayLockV2 companyAccountLock = apiLockUtil.xzbKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        try {
            apiLockUtil.tryLock(cashBackLock);
            apiLockUtil.tryLock(accountLock);
            apiLockUtil.tryLock(companyAccountLock);
            payRecharge.setAccountId(accountId.toString());
            payRecharge.setCreateTime(new Date());
            payRecharge.setPrice(cashbackAmount);
            payRecharge.setType(XzbSystemConstant.PAY_RECHARGE_CASHBACK_TYPE);
            payRecharge.setStatus(XzbSystemConstant.RECHARGE_SUCCESS);
            payRechargeMapper.insertSelective(payRecharge);
            PayTrade payTrade = new PayTrade();
            payTrade.setAlipayNo(orderCashbackTradeNo);
            payTrade.setRechargeId(payRecharge.getRechargeId());
            payTrade.setFromAccountId(accountId);
            payTrade.setToAccountId(accountId);
            payTrade.setPrice(cashbackAmount);
            payTrade.setCreateTime(new Date());
            payTrade.setOutTradeNo(String.valueOf(("order_cashback_" + payRecharge.getRechargeId())));
            payTrade.setType(XzbSystemConstant.PAY_TRADE_TYPE_RECHARGE);
            payTrade.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_ORDER_CASHBACK);
            payTradeMapper.insertSelective(payTrade);
            rechargeMoney(accountId, cashbackAmount,
                    XzbSystemConstant.XZB_RECORD_TYPE_RECHARGE, payTrade.getPayId(), payRecharge.getRechargeId());
        } finally {
            apiLockUtil.destoryLock(companyAccountLock);
            apiLockUtil.destoryLock(accountLock);
            apiLockUtil.destoryLock(cashBackLock);
        }
    }


    public XzbRedPackPayResponse redPackRecharge(XzbReqPackPayRequest request) {
        XzbRedPackPayResponse response = new XzbRedPackPayResponse();
        //校验红包总额
        ShiguBonusExample shiguBonusExample = new ShiguBonusExample();
        shiguBonusExample.createCriteria().andUserIdEqualTo(request.getXzUserId()).andStatusEqualTo(1);//1=正常、2=冻结
        List<ShiguBonus> shiguBonuses = shiguBonusMapper.selectByExample(shiguBonusExample);
        if (shiguBonuses == null || shiguBonuses.isEmpty()) {
            response.setException(new XzbBaseException(XzbRedPackErrorCodeEnum.RED_PACK_NONE_BONUS.getCode(),
                    XzbRedPackErrorCodeEnum.RED_PACK_NONE_BONUS.getMsg()));
            return response;
        }

        long totalBalance = 0L;
        Long payAmount = request.getPayAmount();
        for(ShiguBonus item : shiguBonuses){
            if (item == null || item.getBalance() == null || item.getBalance() <= 0 ) {
                continue;
            }
            totalBalance += item.getBalance();
        }
        if (totalBalance != payAmount){
            response.setException(new XzbBaseException(XzbRedPackErrorCodeEnum.RED_PACK_NEQ_BALANCE.getCode(),
                    XzbRedPackErrorCodeEnum.RED_PACK_NEQ_BALANCE.getMsg()));
            return response;
        }

        PayAccount account = xzbBaseService.selPayAccount(request.getXzUserId(), null);
        if (account == null || account.getAccountId() == null) {
            response.setException(new XzbBaseException(XzbRedPackErrorCodeEnum.RED_PACK_NONE_ACCOUNT.getCode(),
                    XzbRedPackErrorCodeEnum.RED_PACK_NONE_ACCOUNT.getMsg()));
            return response;
        }


        /************ 扣红包余额 *********/
        try {
            reduceRedPackMoney(request.getXzUserId(),shiguBonuses);
        } catch (Exception e) {
            response.setException(new XzbBaseException(XzbRedPackErrorCodeEnum.RED_PACK_FAILED_REDUCE.getCode(),
                    XzbRedPackErrorCodeEnum.RED_PACK_FAILED_REDUCE.getMsg()));
            return response;
        }


        /************** 星座账户加钱**************/
        try {
            redPackXzAccountAddMoney(account.getAccountId(),payAmount);
        } catch (Exception e) {

            response.setException(new XzbBaseException(XzbRedPackErrorCodeEnum.RED_PACK_FAILED_ADD.getCode(),
                    XzbRedPackErrorCodeEnum.RED_PACK_FAILED_ADD.getMsg()));
            return response;
        }
        response.setSuccess(true);
        return response;

    }

    protected void reduceRedPackMoney(Long xzUserId,List<ShiguBonus> shiguBonuses) {
        Date createDate = new Date();
        for(ShiguBonus bonus : shiguBonuses){
            if (bonus == null || bonus.getId() == null || bonus.getBalance() <= 0 ) {//排除所有干扰
                continue;
            }
            Long id = bonus.getId();
            ShiguBonus updatedBonus = new ShiguBonus();
            updatedBonus.setId(id);
            updatedBonus.setBalance(0L);
            shiguBonusMapper.updateByPrimaryKeySelective(updatedBonus);

            //添加红包使用记录
            ShiguBonusRecord shiguBonusRecord = new ShiguBonusRecord();
            shiguBonusRecord.setSerialNumber(generateSerialNumber());
            shiguBonusRecord.setFromUserId(xzUserId);
            shiguBonusRecord.setToUserId(xzUserId);
            shiguBonusRecord.setThirdId(bonus.getThirdId());
            shiguBonusRecord.setAmount(bonus.getBalance());
            shiguBonusRecord.setType(2);//类型：1=系统充值，2=用户使用
            shiguBonusRecord.setStatus(1);//状态：1=成功
            shiguBonusRecord.setCreateTime(createDate);
            shiguBonusRecord.setUpdateTime(createDate);
            shiguBonusRecordMapper.insertSelective(shiguBonusRecord);
        }

    }

    public void redPackXzAccountAddMoney(Long accountId,Long payAmount) throws XzbBaseException, XzbLockException {
        Date createDate = new Date();
        PayLockV2 redPackRechargeLock = apiLockUtil.getLock("redPackpay_" + accountId);
        PayLockV2 companyLock = apiLockUtil.redPackPayKey(XzbSystemConstant.COMPANY_ACCOUNT_ID);
        try {
            apiLockUtil.tryLock(redPackRechargeLock);
            apiLockUtil.tryLock(companyLock);
            /************ 创建payRecharge ************/
            PayRecharge payRecharge = new PayRecharge();
            payRecharge.setType(XzbSystemConstant.PAY_RECHARGE_USER_TYPE);
            payRecharge.setAccountId(accountId.toString());
            payRecharge.setCreateTime(createDate);
            payRecharge.setPrice(payAmount);
            payRecharge.setStatus(XzbSystemConstant.RECHARGE_SUCCESS);
            payRechargeMapper.insertSelective(payRecharge);
            // 创建交易记录
            PayTrade payTrade = new PayTrade();
            payTrade.setType(XzbSystemConstant.PAY_TRADE_TYPE_RECHARGE);
            payTrade.setRechargeId(payRecharge.getRechargeId());
            payTrade.setFromAccountId(accountId);
            payTrade.setToAccountId(accountId);
            payTrade.setPrice(payAmount);
            payTrade.setCreateTime(createDate);
            payTrade.setOutTradeNo(String.valueOf((System.nanoTime() + "_" + payRecharge.getRechargeId())));
            payTrade.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_REDPACKCOUPON);
            changeTrade(payTrade);
            /*********** 加用户资金*********/
            PayXzb query = new PayXzb();
            query.setAccountId(accountId);
            List<PayXzb> payXzbs = payXzbMapper.select(query);
            PayXzb payXzb = payXzbs.get(0);
            // 变动记录
            Long fromMoney = payXzb.getMoney();
            PayXzbRecord payXzbRecord = new PayXzbRecord();
            payXzbRecord.setAccountId(payXzb.getAccountId());
            payXzbRecord.setMoney(payAmount);
            payXzbRecord.setFromMoney(fromMoney);
            payXzbRecord.setToMoney(payXzb.getMoney());
            payXzbRecord.setRechargeId(payRecharge.getRechargeId());
            payXzbRecord.setType(XzbSystemConstant.XZB_RECORD_TYPE_RECHARGE);
            payXzbRecord.setCreateTime(createDate);
            payXzbRecord.setPayId(payTrade.getPayId());
            payXzbRecord.setComments(payXzbRecord.toString());
            payXzbRecordMapper.insertSelective(payXzbRecord);
            //充值
            rechargeMoney(accountId,payAmount, XzbSystemConstant.XZB_RECORD_TYPE_RECHARGE, payTrade.getPayId(), payRecharge.getRechargeId());
        } finally {
            apiLockUtil.destoryLock(companyLock);
            apiLockUtil.destoryLock(redPackRechargeLock);
        }
    }

    /**
     * 冻结金额
     * @param accountId
     * @param blockMoney
     * @throws XzbBaseException
     * @throws XzbLockException
     */
    protected void blockMoney(Long accountId, Long blockMoney) throws XzbBaseException, XzbLockException {
        PayLockV2 accountLock = apiLockUtil.xzbKey(accountId);
        PayXzb payXzb = new PayXzb();
        try {
            apiLockUtil.tryLock(accountLock);
            payXzb.setAccountId(accountId);
            payXzb = payXzbMapper.selectOne(payXzb);
            if (payXzb == null ) {
                throw new XzbBaseException("未查询到账户信息");
            }
            if (payXzb.getMoney() < blockMoney) {
                throw new XzbBaseException("余额不足");
            }
            payXzb.setMoney(payXzb.getMoney() - blockMoney);
            payXzb.setBlockMoney(payXzb.getBlockMoney() + blockMoney);
            payXzbMapper.updateByPrimaryKeySelective(payXzb);
        } finally {
            apiLockUtil.destoryLock(accountLock);
        }
    }


    /**
     * 生成红包操作流水号
     * @return
     */
    private String generateSerialNumber() {
        String serialNumber = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + System.nanoTime() % 1000;
        if (serialNumber.length() < 20) {
            for (int i = 0; i < 20 - serialNumber.length(); i++) {
                serialNumber += '0';
            }
        }
        return serialNumber;
    }


}
