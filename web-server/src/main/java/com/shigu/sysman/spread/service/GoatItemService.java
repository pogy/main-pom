package com.shigu.sysman.spread.service;


import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.GoatItem;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.GoatItemExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.GoatItemMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.member.bo.MemberUserBo;
import com.shigu.sysman.member.bo.MemberUserSubBo;
import com.shigu.sysman.member.vo.MemberUserSubVo;
import com.shigu.sysman.spread.bo.GoatFieldBo;
import com.shigu.sysman.spread.bo.GoatFieldValueBo;
import com.shigu.sysman.spread.bo.GoatItemBo;
import com.shigu.sysman.spread.bo.GoatLocationBo;
import com.shigu.sysman.spread.vo.GoatFieldValueVo;
import com.shigu.sysman.spread.vo.GoatFieldVo;
import com.shigu.sysman.spread.vo.GoatItemVo;
import com.shigu.sysman.spread.vo.GoatLocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告位Service
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:16
 *
 */
@Service
public class GoatItemService {

    @Resource(name = "tae_mall_goatItemMapper")
    private GoatItemMapper goatItemMapper;

    @Autowired
    private GoatFieldService goatFieldService;

    @Autowired
    private GoatFieldValueService goatFieldValueService;

    /**
     * 广告位列表
     * @param goatItemBo
     * @return
     */
    public List<GoatItemVo> findGoatItemList(GoatItemBo goatItemBo){
        if(goatItemBo == null){
            goatItemBo = new GoatItemBo();
        }
        GoatItemExample goatItemExample = createGoatItemExample(goatItemBo);
        List<GoatItem> goatItemList = new ArrayList<GoatItem>();
        if (goatItemBo.isPageBoolean()) {
            goatItemList = goatItemMapper.selectByConditionList(goatItemExample);
        } else {
            goatItemList = goatItemMapper.selectByExample(goatItemExample);
        }
        List<GoatItemVo> goatItemVoList = BeanMapper.mapList(goatItemList, GoatItemVo.class);
        return goatItemVoList;
    }

    /**
     * 创建条件example
     * @param goatItemBo
     * @return
     */
    public GoatItemExample createGoatItemExample(GoatItemBo goatItemBo){
        GoatItemExample goatItemExample = new GoatItemExample();
        GoatItemExample.Criteria crt = goatItemExample.createCriteria();
        goatItemExample.setOrderByClause(" sort asc");
        if(goatItemBo.isPageBoolean()){
            // 需要分页
            goatItemExample.setStartIndex(goatItemBo.getStartRow());
            goatItemExample.setEndIndex(goatItemBo.getStartRow() + goatItemBo.getPageSize());
        }
        // 查询条件
        if(goatItemBo.getItemId() != null){
            crt.andGoatIdEqualTo(goatItemBo.getItemId());
        }
        if(goatItemBo.getLocalId() != null){
            crt.andLocalIdEqualTo(goatItemBo.getLocalId());
        }

        return goatItemExample;
    }

    /**
     * 记录数
     * @param goatItemBo
     * @return
     */
    public int countGoatItemByBo(GoatItemBo goatItemBo){
        if(goatItemBo == null){
            goatItemBo = new GoatItemBo();
        }
        GoatItemExample goatItemExample = createGoatItemExample(goatItemBo);
        int count = goatItemMapper.countByExample(goatItemExample);
        return count;
    }

    /**
     * 广告位分页列表
     * @param goatItemBo
     * @return
     */
    public ShiguPager<GoatItemVo> findGoatItemPager(GoatItemBo goatItemBo){
        if (goatItemBo == null) {
            goatItemBo = new GoatItemBo();
        }
        goatItemBo.setPageBoolean(true);
        List<GoatItemVo> GoatItemVoList = findGoatItemList(goatItemBo);
        int count = countGoatItemByBo(goatItemBo);
        ShiguPager<GoatItemVo> shiguPager = new ShiguPager<GoatItemVo>();
        shiguPager.setContent(GoatItemVoList);
        shiguPager.calPages(count, goatItemBo.getPageSize());
        shiguPager.setNumber(goatItemBo.getCurrentPage());
        return shiguPager;
    }

    /**
     * 广告位查询
     * @param goatItemBo
     * @return
     */
    public GoatItemVo findGoatItemByBo(GoatItemBo goatItemBo){
        if(goatItemBo == null){
            return null;
        }
        goatItemBo.setCurrentPage(1);
        goatItemBo.setPageBoolean(true);
        goatItemBo.setPageSize(1);
        List<GoatItemVo> goatItemVoList = findGoatItemList(goatItemBo);
        if(goatItemVoList.size() == 0){
            return null;
        }
        return goatItemVoList.get(0);
    }

    /**
     * 新增广告位
     * @param goatItem
     */
    @Transactional
    public void addItem(GoatItem goatItem, List<GoatFieldValue> fieldValueList){
        if(goatItem == null     || goatItem.getLocalId() == null){
            return;
        }
        goatItemMapper.insertSelective(goatItem);
        for(int i = 0; i < fieldValueList.size(); i++) {
            GoatFieldValue goatFieldValue = fieldValueList.get(i);
            goatFieldValue.setGoatId(goatItem.getGoatId());
            goatFieldValueService.addFieldValue(goatFieldValue);
        }
    }

    /**
     * 更新广告位
     * @param goatItem
     */
    @Transactional
    public void updateItem(GoatItem goatItem , List<GoatFieldValue> fieldValueList){
        if(goatItem == null || goatItem.getGoatId() == null || goatItem.getLocalId() == null){
            return;
        }
        goatItemMapper.updateByPrimaryKeySelective(goatItem);
        for(int i = 0; i < fieldValueList.size(); i++) {
            GoatFieldValue goatFieldValue = fieldValueList.get(i);
            goatFieldValue.setGoatId(goatItem.getGoatId());
            goatFieldValueService.updateGoatFieldValue(goatFieldValue);
        }
    }

    /**
     * 删除广告
     * @param goatId
     */
    public void delItem(Long goatId){
        if(goatId == null){
            return;
        }
        GoatItemBo goatItemBo = new GoatItemBo();
        goatItemBo.setItemId(goatId);
        GoatItemVo goatItem = findGoatItemByBo(goatItemBo);
        if(goatItem == null){
            return;
        }

        GoatFieldValueBo goatFieldValueBo = new GoatFieldValueBo();
        goatFieldValueBo.setGoatId(goatId);
        List<GoatFieldValueVo> goatFieldValueList = goatFieldValueService.findGoatValueList(goatFieldValueBo);
        for (int i = 0; i < goatFieldValueList.size(); i++) {
            goatFieldValueService.delGoatFieldValue(goatFieldValueList.get(i).getVid());
        }
        goatItemMapper.deleteByPrimaryKey(goatId);
    }
}
