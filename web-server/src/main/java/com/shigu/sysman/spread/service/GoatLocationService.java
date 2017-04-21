package com.shigu.sysman.spread.service;


import com.opentae.data.mall.beans.GoatItem;
import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.examples.GoatItemExample;
import com.opentae.data.mall.examples.GoatLocationExample;
import com.opentae.data.mall.interfaces.GoatItemMapper;
import com.opentae.data.mall.interfaces.GoatLocationMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.spread.bo.GoatItemBo;
import com.shigu.sysman.spread.bo.GoatLocationBo;
import com.shigu.sysman.spread.vo.GoatItemVo;
import com.shigu.sysman.spread.vo.GoatLocationVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告位置置SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:38
 *
 */
@Service
public class GoatLocationService {

    @Resource(name = "tae_mall_goatLocationMapper")
    private GoatLocationMapper goatLocationMapper;

    /**
     * 广告位置列表
     * @param goatLocationBo
     * @return
     */
    public List<GoatLocationVo> findGoatLocaList(GoatLocationBo goatLocationBo){
        if(goatLocationBo == null){
            goatLocationBo = new GoatLocationBo();
        }
        GoatLocationExample goatLocationExample = createGoatLocationExample(goatLocationBo);
        List<GoatLocation> goatLocationList = new ArrayList<GoatLocation>();
        if (goatLocationBo.isPageBoolean()) {
            goatLocationList = goatLocationMapper.selectByConditionList(goatLocationExample);
        } else {
            goatLocationList = goatLocationMapper.selectByExample(goatLocationExample);
        }
        List<GoatLocationVo> goatLocationVoList = BeanMapper.mapList(goatLocationList, GoatLocationVo.class);
        return goatLocationVoList;
    }

    /**
     * 创建条件example
     * @param goatLocationBo
     * @return
     */
    public GoatLocationExample createGoatLocationExample(GoatLocationBo goatLocationBo){
        GoatLocationExample goatLocationExample = new GoatLocationExample();
        GoatLocationExample.Criteria crt = goatLocationExample.createCriteria();
        if(goatLocationBo.isPageBoolean()){
            // 需要分页
            goatLocationExample.setStartIndex(goatLocationBo.getStartRow());
            goatLocationExample.setEndIndex(goatLocationBo.getStartRow() + goatLocationBo.getPageSize());
        }
        // 查询条件
        if(goatLocationBo.getLocationId() != null){
            crt.andLocalIdEqualTo(goatLocationBo.getLocationId());
        }
        if(goatLocationBo.getLocalOther()){
            crt.andLocalCodeNotLike("MAN%");
            crt.andLocalCodeNotLike("WOMAN%");
        }
        if(!StringUtils.isEmpty(goatLocationBo.getLocalCodeLike())){
            crt.andLocalCodeLike(goatLocationBo.getLocalCodeLike() + "%");
        }
        return goatLocationExample;
    }

    /**
     * 记录数
     * @param goatLocationBo
     * @return
     */
    public int countGoatLocationByBo(GoatLocationBo goatLocationBo){
        if(goatLocationBo == null){
            goatLocationBo = new GoatLocationBo();
        }
        GoatLocationExample goatLocationExample = createGoatLocationExample(goatLocationBo);
        int count = goatLocationMapper.countByExample(goatLocationExample);
        return count;
    }

    /**
     * 广告位置分页列表
     * @param goatLocationBo
     * @return
     */
    public ShiguPager<GoatLocationVo> findGoatLocationVoPager(GoatLocationBo goatLocationBo){
        if (goatLocationBo == null) {
            goatLocationBo = new GoatLocationBo();
        }
        goatLocationBo.setPageBoolean(true);
        List<GoatLocationVo> goatLocationVoList = findGoatLocaList(goatLocationBo);
        int count = countGoatLocationByBo(goatLocationBo);
        ShiguPager<GoatLocationVo> shiguPager = new ShiguPager<GoatLocationVo>();
        shiguPager.setContent(goatLocationVoList);
        shiguPager.calPages(count, goatLocationBo.getPageSize());
        shiguPager.setNumber(goatLocationBo.getCurrentPage());
        return shiguPager;
    }

    /**
     * 广告位置查询
     * @param goatLocationBo
     * @return
     */
    public GoatLocationVo findGoatLocationByBo(GoatLocationBo goatLocationBo){
        if(goatLocationBo == null){
            return null;
        }
        goatLocationBo.setCurrentPage(1);
        goatLocationBo.setPageBoolean(true);
        goatLocationBo.setPageSize(1);
        List<GoatLocationVo> goatLocationVoList = findGoatLocaList(goatLocationBo);
        if(goatLocationVoList.size() == 0){
            return null;
        }
        return goatLocationVoList.get(0);
    }

    /**
     * 新增广告位置
     * @param goatLocation
     */
    public void addLocation(GoatLocation goatLocation){
        if(goatLocation == null || goatLocation.getLocalId() == null){
            return;
        }
        goatLocationMapper.insertSelective(goatLocation);
    }

    /**
     * 更新广告位置
     * @param goatLocation
     */
    public void updateGoatLocation(GoatLocation goatLocation){
        if(goatLocation == null || goatLocation.getLocalId() == null){
            return;
        }
        goatLocationMapper.updateByPrimaryKeySelective(goatLocation);
    }

}
