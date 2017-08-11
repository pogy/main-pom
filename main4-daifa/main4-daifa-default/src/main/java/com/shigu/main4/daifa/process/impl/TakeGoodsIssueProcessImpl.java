package com.shigu.main4.daifa.process;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：TakeGoodsIssueProcessImpl
 * @文件路径：com.shigu.main4.daifa.process.TakeGoodsIssueProcessImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 15:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class TakeGoodsIssueProcessImpl implements TakeGoodsIssueProcess{


    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    @Override
    public String distributionTask (Long wholeId, List<Long> waitIssueIds) throws DaifaException {
        CargoManModel cargoManModel = SpringBeanFactory.getBean(CargoManModel.class, wholeId);
        return cargoManModel.takeToMe(waitIssueIds);
    }

    @Override
    public String distributionTaskWithShop (Long wholeId, Long shopId) throws DaifaException {
        //先根据shopId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andStoreIdEqualTo(shopId)
                .andUseStatusEqualTo(1)//可用
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex, FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public String distributionTaskWithFloor (Long wholeId, Long floorId) throws DaifaException {

        //先根据floorid查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andFloorIdEqualTo(floorId)
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                ,FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public String distributionTaskWithMarket (Long wholeId, Long marketId) throws DaifaException {
          //先根据marketId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andMarketIdEqualTo(marketId)
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                ,FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public List<PrintTagVO> printAllTags () {

        return null;
    }

    @Override
    public List<PrintTagVO> printTags (List<Long> issueIds) {
        


        return null;
    }

    @Override
    public void complete (Long issueId) {

    }

    @Override
    public void uncomplete (Long issueId) {

    }

    @Override
    public void uncompleteAll (Long wholeId, List<Long> issueIds) {

    }
}
