package com.shigu.daifa.services;

import com.createExcel.beans.CustomColls;
import com.createExcel.beans.CustomRow;
import com.createExcel.exceptions.IndexRepetitionException;
import com.createExcel.utils.CreateExcel;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaStock;
import com.opentae.data.daifa.beans.DaifaStockRecord;
import com.opentae.data.daifa.custom.beans.SelectTheDayStockRecordIdsCount;
import com.opentae.data.daifa.custom.beans.WorkerStock;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaStockMapper;
import com.opentae.data.daifa.interfaces.DaifaStockRecordMapper;
import com.shigu.admin.vo.PrintExcelVO;
import com.shigu.component.common.SystemConstant;
import com.shigu.daifa.beans.StockRedisBean;
import com.shigu.daifa.bo.DaifaStockBO;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.exceptions.IsOldException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.tools.RedisIO;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.helper.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class DaifaStockService {
    @Autowired
    RedisIO redisIO;
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    DaifaStockMapper daifaStockMapper;
    @Autowired
    DaifaStockRecordMapper daifaStockRecordMapper;
    @Autowired
    DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    SaleAfterProcess saleAfterProcess;

    public List<InOutDaifaStockVO> goodsStorage(Long workerId, boolean isOut){
        String key=isOut?"daifa_worker_outstock_temp_":"daifa_worker_instock_temp_";
        List<StockRedisBean> os=redisIO.getList(key+workerId,StockRedisBean.class);
        if(os==null||os.size()==0){
            return new ArrayList<>();
        }
        return toDaifaStockVO(os);
    }
    public InOutDaifaStockVO barCodeForChildOrderData(String barCode, Long workerId, boolean isOut) throws DaifaException {
        if (barCode.length() <= SystemConstant.EZINT) {
            throw new DaifaException("条码错误");
        }
        Long orderId;
        try {
            orderId = Long.parseLong(barCode.substring(0, barCode.length() - SystemConstant.EZINT));
        } catch (NumberFormatException e) {
            throw new DaifaException("条码错误");
        }
        String key=isOut?"daifa_worker_outstock_temp_":"daifa_worker_instock_temp_";
        List<StockRedisBean> os=redisIO.getList(key+workerId,StockRedisBean.class);
        if(os==null){
            os=new ArrayList<>();
        }
        if(os.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList()).contains(orderId)){
            return null;
        }
        try {
            int inout=saleAfterProcess.selNowStockStatus(orderId);
            if(isOut&&inout!=1){
                throw new DaifaException("该条码对应的商品不是入库状态");
            }else if(!isOut&&inout!=2){
                throw new DaifaException("该条码对应的商品不是出库状态");
            }
        } catch (IsOldException ignored) {
        }

        StockRedisBean sr=new StockRedisBean();
        sr.setOrderId(orderId);
        sr.setTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        os.add(sr);

        List<InOutDaifaStockVO> vos=toDaifaStockVO(os);
        if(vos.size()==0){
            throw new DaifaException("未匹配到订单");
        }else{
            redisIO.put(key+workerId,os);
            return vos.stream().filter(inOutDaifaStockVO -> Objects.equals(inOutDaifaStockVO.getChildOrderId(), orderId)).findFirst().get();
        }
    }

    private List<InOutDaifaStockVO> toDaifaStockVO(List<StockRedisBean> srs){
        if(srs.size()==0){
            return new ArrayList<>();
        }
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(srs.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList()));
        List<DaifaAfterSaleSub> orders=daifaAfterSaleSubMapper.selectByExample(daifaOrderExample);
        Map<Long,StockRedisBean> timeMap= BeanMapper.list2Map(srs,"orderId",Long.class);
        return orders.stream().map(order -> {
            InOutDaifaStockVO vo=new InOutDaifaStockVO();
            vo.setChildOrderId(order.getDfOrderId());
            vo.setGoodsNo(order.getGoodsCode());
            vo.setGoodsProperty(order.getPropStr());
            vo.setPiPrice(order.getSinglePiPrice());
            vo.setPutInTime(timeMap.get(order.getDfOrderId()).getTime());
            return vo;
        }).collect(Collectors.toList());
    }

    public WorkerOutCountVO goodsPutInStorageCount(Long workerId){
        List<WorkerStock> workerOutStock=daifaStockMapper.selectWorkerOutStock(workerId,2);
        List<Long> workerOutOrderIds=workerOutStock.stream().map(WorkerStock::getDfOrderId).collect(Collectors.toList());
        List<StockRedisBean> os=redisIO.getList("daifa_worker_instock_temp_"+workerId,StockRedisBean.class);
        if(os!=null&&os.size()>0){
            List<Long> ids=os.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList());
            workerOutOrderIds.removeIf(ids::contains);
        }
        return workerOutCount(workerOutOrderIds);
    }

    public WorkerOutCountVO workerOutCount(List<Long> workerOutOrderIds){
        List<DaifaAfterSaleSub> subs=new ArrayList<>();
        if(workerOutOrderIds.size()>0){
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andDfOrderIdIn(workerOutOrderIds);
            subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
            List<Long> eoids=selAfterErrorOids(workerOutOrderIds);
            subs.removeIf(daifaAfterSaleSub -> eoids.contains(daifaAfterSaleSub.getDfOrderId()));
        }
        WorkerOutCountVO vo=new WorkerOutCountVO();
        vo.setNum(subs.size());
        vo.setPrice(MoneyUtil.dealPrice(subs.stream()
                .mapToLong(daifaAfterSaleSub -> MoneyUtil.StringToLong(daifaAfterSaleSub.getSinglePiPrice())).sum()));
        return vo;
    }

    public void submitPutInInventory(Long workerId) throws DaifaException {
        List<StockRedisBean> srs=redisIO.getList("daifa_worker_instock_temp_"+workerId,StockRedisBean.class);
        if(srs==null||srs.size()==0){
            throw new DaifaException("无扫描条码");
        }
        List<Long> oids=srs.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList());
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaAfterSaleSub> orders=daifaAfterSaleSubMapper.selectByExample(daifaOrderExample);
        if(orders.size()==0){
            throw new DaifaException("条码不匹配");
        }
        oids=orders.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
        DaifaStockExample daifaStockExample=new DaifaStockExample();
        daifaStockExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaStock> stocks=daifaStockMapper.selectByExample(daifaStockExample);
        if(stocks.size()>0){
            List<Long> stockOids=stocks.stream().map(DaifaStock::getDfOrderId).collect(Collectors.toList());
            List<Long> tmpOids=new ArrayList<>(oids);
            tmpOids.removeIf(stockOids::contains);
            if(tmpOids.size()!=0&&tmpOids.size()!=oids.size()){
                throw new DaifaException("退货入库和退货失败入库不能同时进行");
            }
            //走失败入库路线
            List<WorkerStock> allOutStock=daifaStockMapper.selectWorkerOutStock(null,2);
            List<WorkerStock> workerOutStock=daifaStockMapper.selectWorkerOutStock(workerId,2);
            List<Long> workerOutOrderIds=workerOutStock.stream().map(WorkerStock::getDfOrderId).collect(Collectors.toList());
            List<Long> otherOutOrderIds=allOutStock.stream().map(WorkerStock::getDfOrderId).filter(aLong -> !workerOutOrderIds.contains(aLong)).collect(Collectors.toList());
            List<Long> notIds=new ArrayList<>();
            for(Long oid:stockOids){
                if(otherOutOrderIds.contains(oid)){
                    throw new DaifaException("存在不是自己出库的商品");
                }
                notIds.add(oid);
            }
            List<Long> afterErrorOrderIds=selAfterErrorOids(workerOutOrderIds);
            List<Long> notStockIds=new ArrayList<>();
            List<Long> yesStockIds=new ArrayList<>();
            workerOutStock.forEach(workerStock -> {
                if(notIds.contains(workerStock.getDfOrderId())){
                    notStockIds.add(workerStock.getStockId());
                }else{
                    if(!afterErrorOrderIds.contains(workerStock.getDfOrderId())){
                        yesStockIds.add(workerStock.getStockId());
                    }
                }
            });
            saleAfterProcess.notReturnInStocks(notStockIds,yesStockIds,workerId);
        }else{
            //走退货入库路线
            saleAfterProcess.saleInStocks(oids,"售后库存",workerId);
        }
        afreshPutInInventory(workerId,false);
    }

    public void afreshPutInInventory(Long workerId,boolean isOut){
        String key=isOut?"daifa_worker_outstock_temp_":"daifa_worker_instock_temp_";
        redisIO.del(key+workerId);
    }

    public void toExcel(HttpServletResponse response,String pi,Long workerId,String worker){
        DaifaStockRecordExample daifaStockRecordExample=new DaifaStockRecordExample();
        daifaStockRecordExample.createCriteria().andPiCodeEqualTo(pi).andDaifaWorkerIdEqualTo(workerId);
        daifaStockRecordExample.setOrderByClause("stock_record_id asc");
        List<DaifaStockRecord> rs=daifaStockRecordMapper.selectByExample(daifaStockRecordExample);
        List<WorkerOutStockExcelVO> list=new ArrayList<>();
        Long price=0L;
        if(rs.size()>0){
            List<Long> stockIds=rs.stream().map(DaifaStockRecord::getStockId).collect(Collectors.toList());
            DaifaStockExample daifaStockExample=new DaifaStockExample();
            daifaStockExample.createCriteria().andStockIdIn(stockIds);
            List<DaifaStock> stocks=daifaStockMapper.selectByExample(daifaStockExample);
            Map<Long,DaifaStock> stockMap=BeanMapper.list2Map(stocks,"stockId",Long.class);
            List<Long> oids=stocks.stream().map(DaifaStock::getDfOrderId).collect(Collectors.toList());
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andDfOrderIdIn(oids);
            List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
            Map<Long,DaifaAfterSaleSub> orderMap=BeanMapper.list2Map(subs,"dfOrderId",Long.class);
            for(DaifaStockRecord r:rs){
                DaifaStock s=stockMap.get(r.getStockId());
                DaifaAfterSaleSub o=orderMap.get(s.getDfOrderId());
                WorkerOutStockExcelVO vo=new WorkerOutStockExcelVO();
                vo.setProp(o.getPropStr());
                vo.setGoodsNo(o.getGoodsCode());
                vo.setMarketId(o.getMarketId());
                vo.setPirice(o.getSinglePiPrice());
                vo.setStoreNum(o.getStoreNum());
                vo.setRemark(s.getStockRemark());
                price+=MoneyUtil.StringToLong(o.getSinglePiPrice());
                list.add(vo);
            }
        }
        CustomRow r=new CustomRow();
        List<CustomColls> r1cs=new ArrayList<>();
        CustomColls r1c1=new CustomColls();
        r1c1.setStartIndex(0);
        r1c1.setEndIndex(5);
        r1c1.setValue(DateUtil.dateToString(new Date(),DateUtil.patternA)+" 商品出入库记录");
        r1cs.add(r1c1);
        r.setColls(r1cs);

        CustomRow r2=new CustomRow();
        List<CustomColls> r2cs=new ArrayList<>();
        CustomColls r2c1=new CustomColls();
        r2c1.setStartIndex(0);
        r2c1.setEndIndex(0);
        r2c1.setValue("退货员");
        r2cs.add(r2c1);

        CustomColls r2c2=new CustomColls();
        r2c2.setStartIndex(1);
        r2c2.setEndIndex(1);
        r2c2.setValue(worker);
        r2cs.add(r2c2);

        CustomColls r2c3=new CustomColls();
        r2c3.setStartIndex(2);
        r2c3.setEndIndex(2);
        r2c3.setValue("退货员出库批次");
        r2cs.add(r2c3);

        CustomColls r2c4=new CustomColls();
        r2c4.setStartIndex(3);
        r2c4.setEndIndex(3);
        r2c4.setValue(pi);
        r2cs.add(r2c4);

        CustomColls r2c5=new CustomColls();
        r2c5.setStartIndex(4);
        r2c5.setEndIndex(4);
        r2c5.setValue("对应商品金额(元)");
        r2cs.add(r2c5);

        CustomColls r2c6=new CustomColls();
        r2c6.setStartIndex(5);
        r2c6.setEndIndex(5);
        r2c6.setValue(MoneyUtil.dealPrice(price));
        r2cs.add(r2c6);

        r2.setColls(r2cs);

        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment; filename="+worker+"_"+pi+".xls");
            CreateExcel createExcel=new CreateExcel();
            Workbook workbook= null;
            try {
                workbook = createExcel.createWorkbook(list,r,r2);
            } catch (IndexRepetitionException e) {
                e.printStackTrace();
            }
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void refundAllOutBoundGoods(Long workerId) {
        List<WorkerStock> workerOutStock=daifaStockMapper.selectWorkerOutStock(workerId,2);
        List<Long> workerOutOrderIds=workerOutStock.stream().map(WorkerStock::getDfOrderId).collect(Collectors.toList());
        List<Long> afterErrorOrderIds=selAfterErrorOids(workerOutOrderIds);
        workerOutStock.removeIf(workerStock -> afterErrorOrderIds.contains(workerStock.getDfOrderId()));
        saleAfterProcess.notReturnInStocks(new ArrayList<>(),workerOutStock.stream().map(WorkerStock::getStockId).collect(Collectors.toList()),workerId);
    }

    private List<Long> selAfterErrorOids(List<Long> workerOutOrderIds){
        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andDfOrderIdIn(workerOutOrderIds)
                .andStoreDealStatusEqualTo(2);
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper
                .selectFieldsByExample(daifaAfterSaleSubExample, FieldUtil.codeFields("after_sale_sub_id,df_order_id"));
        return subs.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
    }

    public WorkerOutCountVO goodsOutboundCount(Long workerId){
        List<StockRedisBean> os=redisIO.getList("daifa_worker_outstock_temp_"+workerId,StockRedisBean.class);
        List<Long> ids=new ArrayList<>();
        if(os!=null&&os.size()>0){
            ids=os.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList());
        }
        return workerOutCount(ids);
    }


    public List<ExcelUrlVO> submitOutBound(Long daifaWorkerId,String worker) throws DaifaException {
        List<StockRedisBean> srs=redisIO.getList("daifa_worker_outstock_temp_"+daifaWorkerId,StockRedisBean.class);
        if(srs==null||srs.size()==0){
            throw new DaifaException("无扫描条码");
        }
        List<Long> oids=srs.stream().map(StockRedisBean::getOrderId).collect(Collectors.toList());
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaAfterSaleSub> orders=daifaAfterSaleSubMapper.selectByExample(daifaOrderExample);
        if(orders.size()==0){
            throw new DaifaException("条码不匹配");
        }
        oids=orders.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
        DaifaStockExample daifaStockExample=new DaifaStockExample();
        daifaStockExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaStock> stocks=daifaStockMapper.selectByExample(daifaStockExample);
        List<Long> stockOids=stocks.stream().map(DaifaStock::getDfOrderId).collect(Collectors.toList());
        List<Long> tmpOids=new ArrayList<>(oids);
        tmpOids.removeIf(stockOids::contains);
        if(tmpOids.size()!=0){
            throw new DaifaException("操作失败,部分扫描的商品未入库");
        }
        for(DaifaStock stock:stocks){
            int inOutType=saleAfterProcess.selNowStockStatusByStockId(stock.getStockId());
            if(inOutType!=1){
                throw new DaifaException("操作失败,部分扫描的商品非入库状态");
            }
        }
        String pi=saleAfterProcess.saleOutStocks(stocks.stream().map(DaifaStock::getStockId).collect(Collectors.toList()), daifaWorkerId);
        afreshPutInInventory(daifaWorkerId,true);

        ExcelUrlVO vo=new ExcelUrlVO();
        vo.setBatches(worker+"_"+pi);
        vo.setHref("downWorkerOutStockExcel/"+daifaWorkerId+"_"+pi+".htm");
        return Collections.singletonList(vo);
    }

    public List<ExcelUrlVO> outboundBatches(Long workerId,String worker){
        DaifaStockRecordExample e=new DaifaStockRecordExample();
        e.createCriteria().andDaifaWorkerIdEqualTo(workerId).andInOutTypeEqualTo(2).andPiCodeIsNotNull();
        e.setOrderByClause("stock_record_id desc");
        List<DaifaStockRecord> rs=daifaStockRecordMapper.selectFieldsByExample(e,FieldUtil.codeFields("stock_record_id,pi_code"));
        Set<String> keys=new HashSet<>();
        List<String> piCodes=rs.stream().filter(daifaStockRecord -> {
            if(keys.contains(daifaStockRecord.getPiCode())){
                return false;
            }
            keys.add(daifaStockRecord.getPiCode());
            return true;
        }).map(DaifaStockRecord::getPiCode).collect(Collectors.toList());
        List<ExcelUrlVO> vos=new ArrayList<>();
        for(String piCode:piCodes){
            ExcelUrlVO vo=new ExcelUrlVO();
            vo.setBatches(worker+"_"+piCode);
            vo.setHref("downWorkerOutStockExcel/"+workerId+"_"+piCode+".htm");
            vos.add(vo);
        }
        return vos;
    }

    public ShiguPager<DaifaStockVO> allInventory(DaifaStockBO bo,Long sellerId) {
        DaifaStockExample daifaStockExample = new DaifaStockExample();
        DaifaStockExample.Criteria ce = daifaStockExample.createCriteria().andSellerIdEqualTo(sellerId);
        if (bo.getStartTime() != null) {
            ce.andStartInTimeGreaterThanOrEqualTo(DateUtil.stringToDate(bo.getStartTime(), DateUtil.patternA));
        }
        if (bo.getEndTime() != null) {
            ce.andStartInTimeLessThanOrEqualTo(DateUtil.getIsEndTime(DateUtil.stringToDate(bo.getEndTime(), DateUtil.patternA)));
        }
        if (bo.getChildOrderId() != null) {
            ce.andDfOrderIdEqualTo(bo.getChildOrderId());
        }

        Integer count = daifaStockMapper.countByExample(daifaStockExample);
        List<DaifaStockVO> vos = new ArrayList<>();
        if (count > 0) {
            daifaStockExample.setStartIndex((bo.getPage() - 1) * 10);
            daifaStockExample.setEndIndex(10);
            daifaStockExample.setOrderByClause("stock_id desc");
            List<DaifaStock> stocks = daifaStockMapper.selectByExample(daifaStockExample);
            List<Long> oids = stocks.stream().map(DaifaStock::getDfOrderId).collect(Collectors.toList());
            DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
            List<DaifaOrder> orders = daifaOrderMapper.selectByExample(daifaOrderExample);
            Map<Long, DaifaOrder> map = BeanMapper.list2Map(orders, "dfOrderId", Long.class);

            List<Long> stockIds = stocks.stream().map(DaifaStock::getStockId).collect(Collectors.toList());
            DaifaStockRecordExample daifaStockRecordExample = new DaifaStockRecordExample();
            daifaStockRecordExample.createCriteria().andStockIdIn(stockIds);
            daifaStockRecordExample.setOrderByClause("stock_record_id asc");
            List<DaifaStockRecord> records = daifaStockRecordMapper.selectByExample(daifaStockRecordExample);
            Map<Long, List<DaifaStockRecord>> recordGroup = records.stream().collect(Collectors.groupingBy(DaifaStockRecord::getStockId));

            for (DaifaStock stock : stocks) {
                DaifaStockVO vo = new DaifaStockVO();
                List<DaifaStockRecordVO> rvos = new ArrayList<>();
                for (DaifaStockRecord r : recordGroup.get(stock.getStockId())) {
                    DaifaStockRecordVO rvo = new DaifaStockRecordVO();
                    DaifaOrder o = map.get(stock.getDfOrderId());
                    rvo.setChildOrderId(o.getDfOrderId());
                    rvo.setGoodsNo(o.getGoodsCode());
                    rvo.setGoodsProperty(o.getPropStr());
                    rvo.setPiPrice(o.getSinglePiPrice());
                    rvo.setType(r.getInOutType());
                    rvo.setTime(DateUtil.dateToString(r.getInOutType() == 1 ? r.getInTime() : r.getInOutType() == 2 ? r.getOutTime() : r.getReturnTime(), DateUtil.patternA));
                    rvo.setOpeName(r.getDaifaWorker());
                    rvos.add(rvo);
                }
                vo.setPutInOutRecords(rvos);
                vos.add(vo);
            }
        }
        ShiguPager<DaifaStockVO> pager = new ShiguPager<>();
        pager.setContent(vos);
        pager.setTotalCount(count);
        pager.setNumber(bo.getPage());
        return pager;
    }

    public InventoryVO selInventory(Long sellerId){
        List<WorkerStock> allOutStock=daifaStockMapper.selectWorkerOutStock(null,1);
        String day=DateUtil.dateToString(new Date(),DateUtil.patternB);
        Integer inCount=daifaStockMapper.selectTodayStockCount(sellerId,1,day);
        Integer outCount=daifaStockMapper.selectTodayStockCount(sellerId,2,day);

        InventoryVO vo=new InventoryVO();
        vo.setAllInventoryNum(allOutStock.size());
        vo.setOutBoundNum(outCount);
        vo.setPutInStorageNum(inCount);
        return vo;
    }

    public StorageSearchVO storageSearch(DaifaStockBO bo,Long sellerId,int type){
        String startDay=DateUtil.dateToString(DateUtil.stringToDate(bo.getStartTime(), DateUtil.patternA),DateUtil.patternB);
        String endDay=DateUtil.dateToString(DateUtil.stringToDate(bo.getEndTime(), DateUtil.patternA),DateUtil.patternB);
        SelectTheDayStockRecordIdsCount count=daifaStockMapper.selectTheDayStockRecordIdsCount(sellerId,type,startDay,endDay);
        List<DaifaStockRecordVO> rvos = new ArrayList<>();
        Long price=0L;
        if(count.getNum()>0){
            List<Long> rids=daifaStockMapper.selectTheDayStockRecordIds(sellerId,type,startDay,endDay,(bo.getPage()-1)*10,10);
            DaifaStockRecordExample daifaStockRecordExample = new DaifaStockRecordExample();
            daifaStockRecordExample.createCriteria().andStockRecordIdIn(rids);
            daifaStockRecordExample.setOrderByClause("stock_record_id desc");
            List<DaifaStockRecord> records = daifaStockRecordMapper.selectByExample(daifaStockRecordExample);


            List<Long> stockIds=records.stream().map(DaifaStockRecord::getStockId).collect(Collectors.toList());
            DaifaStockExample daifaStockExample=new DaifaStockExample();
            daifaStockExample.createCriteria().andStockIdIn(stockIds);
            List<DaifaStock> stocks = daifaStockMapper.selectByExample(daifaStockExample);
            Map<Long,DaifaStock> smap=BeanMapper.list2Map(stocks, "stockId", Long.class);
            List<Long> oids = stocks.stream().map(DaifaStock::getDfOrderId).collect(Collectors.toList());
            DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
            List<DaifaOrder> orders = daifaOrderMapper.selectByExample(daifaOrderExample);
            Map<Long, DaifaOrder> map = BeanMapper.list2Map(orders, "dfOrderId", Long.class);
            for (DaifaStockRecord r : records) {
                DaifaStockRecordVO rvo = new DaifaStockRecordVO();
                DaifaOrder o = map.get(smap.get(r.getStockId()).getDfOrderId());
                rvo.setChildOrderId(o.getDfOrderId());
                rvo.setGoodsNo(o.getGoodsCode());
                rvo.setGoodsProperty(o.getPropStr());
                rvo.setPiPrice(o.getSinglePiPrice());
                rvo.setTime(DateUtil.dateToString(r.getInTime(), DateUtil.patternA));
                rvo.setOpeName(r.getDaifaWorker());
                rvos.add(rvo);
                price+=MoneyUtil.StringToLong(o.getSinglePiPrice());
            }
        }

        StorageSearchVO v=new StorageSearchVO();
        v.setNum(count.getNum());
        v.setPrice(MoneyUtil.dealPrice(MoneyUtil.StringToLong(count.getPrice())));
        ShiguPager<DaifaStockRecordVO> pager = new ShiguPager<>();
        pager.setContent(rvos);
        pager.setTotalCount(count.getNum());
        pager.setNumber(bo.getPage());
        v.setPager(pager);
        return v;
    }
}
