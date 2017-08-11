package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.vo.PrintTagVO;
import org.springframework.stereotype.Service;

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
@Service("takeGoodsIssueProcess")
public class TakeGoodsIssueProcessImpl implements TakeGoodsIssueProcess{

    @Override
    public String distributionTask (Long wholeId, List<Long> waitIssueIds) {
        return null;
    }

    @Override
    public String distributionTaskWithShop (Long wholeId, Long shopId) {
        return null;
    }

    @Override
    public String distributionTaskWithFloor (Long wholeId, Long floorId) {
        return null;
    }

    @Override
    public String distributionTaskWithMarket (Long wholeId, Long marketId) {
        return null;
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
