package com.shigu.main4.order.process;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.ItemOrderLogistics;
import com.opentae.data.mall.beans.KdnSubscibe;
import com.opentae.data.mall.beans.KdnTraceInfo;
import com.opentae.data.mall.examples.ItemOrderLogisticsExample;
import com.opentae.data.mall.examples.KdnSubscibeExample;
import com.opentae.data.mall.examples.KdnTraceInfoExample;
import com.opentae.data.mall.interfaces.ExpressCompanyMapper;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.KdnSubscibeMapper;
import com.opentae.data.mall.interfaces.KdnTraceInfoMapper;
import com.shigu.main4.order.utils.KdniaoUtil;
import com.shigu.main4.order.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by gtx on 2018/8/31 0031.
 *
 * @author gtx
 * @since
 */
@Service("kdnProcess")
public class KdnProcessImpl implements KdnProcess{

    @Autowired
    private KdnSubscibeMapper kdnSubscibeMapper;
    @Autowired
    private KdnTraceInfoMapper kdnTraceInfoMapper;
    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;
    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;
    @Autowired
    private KdniaoUtil kdniaoUtil;

    /**
     * 根据快递鸟的推送更新物流信息
     * @param requestData
     */
    @Override
    @Transactional
    public void updatePostInfoByNotify(String requestData) {
        KdnCallBackExpressTraceInfo callBackExpressTraceInfo = JSONObject.parseObject(requestData, KdnCallBackExpressTraceInfo.class);
        List<KdnCallBackTraceInfo> traceInfos = callBackExpressTraceInfo.getData();

        Map<String, KdnCallBackTraceInfo> traceInfosMap = traceInfos.stream()
                .collect(Collectors.toMap(KdnCallBackTraceInfo::getLogisticCode, Function.identity(), (o1, o2) -> o2));

        KdnSubscibeExample kdnSubscibeExample = new KdnSubscibeExample();
        kdnSubscibeExample.createCriteria().andLogisticCodeIn(new ArrayList<>(traceInfosMap.keySet()));
        List<KdnSubscibe> kdnSubscibes = kdnSubscibeMapper.selectByExample(kdnSubscibeExample);

        Map<String, KdnSubscibe> kdnSubscibesMap = kdnSubscibes.stream()
                .collect(Collectors.toMap(KdnSubscibe::getLogisticCode, Function.identity(), (o1, o2) -> o2));

        Date now = new Date();
        //每次推送 1 - 10 条记录
        List<KdnTraceInfo> kdnTraceInfoList = new ArrayList<>();
        List<String> existLogistCode = new ArrayList<>();
        for (Map.Entry<String, KdnCallBackTraceInfo> item : traceInfosMap.entrySet()){
            KdnSubscibe kdnSubscibe = kdnSubscibesMap.get(item.getKey());
            KdnCallBackTraceInfo traceInfo = item.getValue();
            if (kdnSubscibe == null || !"true".equals(traceInfo.getSuccess())) {
               continue;
            }
            KdnSubscibe updateKdnSubscibe = new KdnSubscibe();
            updateKdnSubscibe.setId(kdnSubscibe.getId());
            updateKdnSubscibe.setLogisticState(Integer.parseInt(traceInfo.getState()));
            updateKdnSubscibe.setGmtCreate(now);
            updateKdnSubscibe.setGmtUpdate(now);

            kdnSubscibeMapper.updateByPrimaryKeySelective(updateKdnSubscibe);

            existLogistCode.add(item.getKey());
            for (KdnCallBackTrace trace : traceInfo.getTraces()){
                KdnTraceInfo kdnTraceInfo = new KdnTraceInfo();
                kdnTraceInfo.setLogisticCode(item.getKey());
                kdnTraceInfo.setAcceptTime(trace.getAcceptTime());
                kdnTraceInfo.setAcceptStation(trace.getAcceptStation());
                kdnTraceInfo.setRemark(trace.getRemark());

                kdnTraceInfoList.add(kdnTraceInfo);
            }
        }

        if (!kdnTraceInfoList.isEmpty()) {
            KdnTraceInfoExample kdnTraceInfoExample = new KdnTraceInfoExample();
            kdnTraceInfoExample.createCriteria().andLogisticCodeIn(existLogistCode);
            kdnTraceInfoMapper.deleteByExample(kdnSubscibeExample);
            kdnSubscibeExample.clear();
            kdnTraceInfoMapper.insertListNoId(kdnTraceInfoList);
        }
    }

    /**
     * 根据订单ID获取物流信息
     * @param oid
     */
    @Override
    public KdnPostInfoVO selPostInfoByOid(Long oid) {
        if (oid == null) {
            return null;
        }
        KdnSubscibe kdnSubscibe = new KdnSubscibe();
        kdnSubscibe.setOid(oid);
        kdnSubscibe = kdnSubscibeMapper.selectOne(kdnSubscibe);
        if (kdnSubscibe != null) {//查到记录则证明已订阅
            return selPostTraces(kdnSubscibe);
        }

        ItemOrderLogistics logistics = selItemOrderLogisticsByOid(oid);
        if (logistics == null) {
            return null;
        }
        ExpressCompany expressCompany = expressCompanyMapper.selectByPrimaryKey(logistics.getCompanyId());
        if (expressCompany == null || StringUtils.isBlank(expressCompany.getRemark3())) {
            return null;
        }
        return selPostTraces(expressCompany,logistics);
    }

    /**
     * 根据快递单号获取物流信息
     * @param expressCode
     */
    @Override
    public KdnPostInfoVO selPostInfoByExpressCode(String expressCode) {
        if (StringUtils.isBlank(expressCode)) {
            return null;
        }
        KdnSubscibe kdnSubscibe = new KdnSubscibe();
        kdnSubscibe.setLogisticCode(expressCode);
        kdnSubscibe = kdnSubscibeMapper.selectOne(kdnSubscibe);
        if (kdnSubscibe != null) {//查到记录则证明已订阅
            return selPostTraces(kdnSubscibe);
        }

        ItemOrderLogisticsExample itemOrderLogisticsExample = new ItemOrderLogisticsExample();
        itemOrderLogisticsExample.setStartIndex(0);
        itemOrderLogisticsExample.setEndIndex(1);
        itemOrderLogisticsExample.createCriteria().andCourierNumberEqualTo(expressCode);
        List<ItemOrderLogistics> itemOrderLogistics = itemOrderLogisticsMapper.selectByConditionList(itemOrderLogisticsExample);
        if (itemOrderLogistics == null || itemOrderLogistics.isEmpty()) {
            return null;
        }
        ItemOrderLogistics logistics = itemOrderLogistics.get(0);
        ExpressCompany expressCompany = expressCompanyMapper.selectByPrimaryKey(logistics.getCompanyId());
        if (expressCompany == null || StringUtils.isBlank(expressCompany.getRemark3())) {
            return null;
        }
        return selPostTraces(expressCompany,logistics);
    }

    /**
     * 从数据库获取物流轨迹
     * @param kdnSubscibe
     * @return
     */
    private KdnPostInfoVO selPostTraces (KdnSubscibe kdnSubscibe){
        KdnPostInfoVO vo = new KdnPostInfoVO();
        vo.setOid(kdnSubscibe.getOid());
        vo.setState(kdnSubscibe.getLogisticState());
        vo.setLogisticCode(kdnSubscibe.getLogisticCode());

        ItemOrderLogistics logistics = selItemOrderLogisticsByOid(kdnSubscibe.getOid());
        ExpressCompany expressCompany = expressCompanyMapper.selectByPrimaryKey(logistics.getCompanyId());
        vo.setCompanyName(expressCompany.getExpressName());

        KdnTraceInfoExample example = new KdnTraceInfoExample();
        example.setOrderByClause(" accept_time DESC ");
        example.createCriteria().andLogisticCodeEqualTo(kdnSubscibe.getLogisticCode());
        List<KdnTraceInfo> kdnTraceInfos = kdnTraceInfoMapper.selectByExample(example);

        if (kdnTraceInfos != null && !kdnTraceInfos.isEmpty()) {
            List<KdnPostTraceInfoVO> kdnPostTraceInfoVOS = new ArrayList<>(kdnTraceInfos.size());
            kdnTraceInfos.stream().forEach(item->{
                KdnPostTraceInfoVO kdnPostTraceInfoVO = new KdnPostTraceInfoVO();
                kdnPostTraceInfoVO.setAcceptTime(item.getAcceptTime());
                kdnPostTraceInfoVO.setAcceptStation(item.getAcceptStation());
                kdnPostTraceInfoVO.setRemark(item.getRemark());

                kdnPostTraceInfoVOS.add(kdnPostTraceInfoVO);
            });
            vo.setPostTraceInfoVOS(kdnPostTraceInfoVOS);
        }

        return vo;
    }

    /**
     * 从快递鸟获取物流轨迹
     * @param expressCompany
     * @param logistics
     * @return
     */
    private KdnPostInfoVO selPostTraces (ExpressCompany expressCompany, ItemOrderLogistics logistics){
        KdnPostInfoVO vo = new KdnPostInfoVO();
        vo.setOid(logistics.getOid());
        vo.setState(0);//默认无轨迹
        vo.setLogisticCode(logistics.getCourierNumber());
        vo.setCompanyName(expressCompany.getExpressName());
        try {
            KdnSelVO kdnSelVO = kdniaoUtil.selPostInfo(expressCompany.getRemark3(), logistics.getCourierNumber());
            if (!kdnSelVO.getSuccess()) {
                return vo;
            }
            vo.setState(Integer.parseInt(kdnSelVO.getState()));
            List<KdnCallBackTrace> kdnCallBackTraces = kdnSelVO.getKdnCallBackTraces();
            if (kdnCallBackTraces == null || kdnCallBackTraces.isEmpty()) {
                return vo;
            }
            List<KdnPostTraceInfoVO> postTraceInfoVOS = kdnCallBackTraces.stream().map(item->{
                KdnPostTraceInfoVO kdnPostTraceInfoVO = new KdnPostTraceInfoVO();
                kdnPostTraceInfoVO.setAcceptTime(item.getAcceptTime());
                kdnPostTraceInfoVO.setAcceptStation(item.getAcceptStation());
                kdnPostTraceInfoVO.setRemark(item.getRemark());

                return kdnPostTraceInfoVO;
            }).collect(Collectors.toList());
            Collections.sort(postTraceInfoVOS);
            vo.setPostTraceInfoVOS(postTraceInfoVOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    /**
     *
     * @param oid
     * @return
     */
    private ItemOrderLogistics selItemOrderLogisticsByOid(Long oid){
        ItemOrderLogisticsExample itemOrderLogisticsExample = new ItemOrderLogisticsExample();
        itemOrderLogisticsExample.setStartIndex(0);
        itemOrderLogisticsExample.setEndIndex(1);
        itemOrderLogisticsExample.createCriteria().andOidEqualTo(oid).andCourierNumberIsNotNull();
        List<ItemOrderLogistics> itemOrderLogistics = itemOrderLogisticsMapper.selectByConditionList(itemOrderLogisticsExample);
        if (itemOrderLogistics == null || itemOrderLogistics.isEmpty()) {
            return null;
        }
        return itemOrderLogistics.get(0);
    }


}
