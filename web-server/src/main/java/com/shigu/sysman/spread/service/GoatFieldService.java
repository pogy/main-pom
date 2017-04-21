package com.shigu.sysman.spread.service;


import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.examples.GoatFieldExample;
import com.opentae.data.mall.interfaces.GoatFieldMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.spread.bo.GoatFieldBo;
import com.shigu.sysman.spread.vo.GoatFieldVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告列SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/10 14:24
 *
 */
@Service
public class GoatFieldService {

    @Resource(name = "tae_mall_goatFieldMapper")
    private GoatFieldMapper goatFieldMapper;

    /**
     * 广告列列表
     * @param goatFieldBo
     * @return
     */
    public List<GoatFieldVo> findGoatFieldList(GoatFieldBo goatFieldBo){
        if(goatFieldBo == null){
            goatFieldBo = new GoatFieldBo();
        }
        GoatFieldExample goatFieldExample = createGoatFieldExample(goatFieldBo);
        List<GoatField> goatFieldlList = new ArrayList<GoatField>();
        if (goatFieldBo.isPageBoolean()) {
            goatFieldlList = goatFieldMapper.selectByConditionList(goatFieldExample);
        } else {
            goatFieldlList = goatFieldMapper.selectByExample(goatFieldExample);
        }
        List<GoatFieldVo> goatFieldVoList = BeanMapper.mapList(goatFieldlList, GoatFieldVo.class);
        return goatFieldVoList;
    }

    /**
     * 创建条件example
     * @param goatFieldBo
     * @return
     */
    public GoatFieldExample createGoatFieldExample(GoatFieldBo goatFieldBo){
        GoatFieldExample goatFieldExample = new GoatFieldExample();
        GoatFieldExample.Criteria crt = goatFieldExample.createCriteria();
        if(goatFieldBo.isPageBoolean()){
            // 需要分页
            goatFieldExample.setStartIndex(goatFieldBo.getStartRow());
            goatFieldExample.setEndIndex(goatFieldBo.getStartRow() + goatFieldBo.getPageSize());
        }
        // 查询条件
        if(goatFieldBo.getLocationId() != null){
            crt.andLocationIdEqualTo(goatFieldBo.getLocationId());
        }
        return goatFieldExample;
    }

    /**
     * 记录数
     * @param goatModelBo
     * @return
     */
    public int countGoatFieldByBo(GoatFieldBo goatModelBo){
        if(goatModelBo == null){
            goatModelBo = new GoatFieldBo();
        }
        GoatFieldExample goatModelExample = createGoatFieldExample(goatModelBo);
        int count = goatFieldMapper.countByExample(goatModelExample);
        return count;
    }

    /**
     * 广告列分页列表
     * @param goatFieldBo
     * @return
     */
    public ShiguPager<GoatFieldVo> findGoatFieldPager(GoatFieldBo goatFieldBo){
        if (goatFieldBo == null) {
            goatFieldBo = new GoatFieldBo();
        }
        goatFieldBo.setPageBoolean(true);
        List<GoatFieldVo> goatModelVoList = findGoatFieldList(goatFieldBo);
        int count = countGoatFieldByBo(goatFieldBo);
        ShiguPager<GoatFieldVo> shiguPager = new ShiguPager<GoatFieldVo>();
        shiguPager.setContent(goatModelVoList);
        shiguPager.calPages(count, goatFieldBo.getPageSize());
        shiguPager.setNumber(goatFieldBo.getCurrentPage());
        return shiguPager;
    }

    /**
     * 广告列查询
     * @param goatFieldBo
     * @return
     */
    public GoatFieldVo findGoatFieldByBo(GoatFieldBo goatFieldBo){
        if(goatFieldBo == null){
            return null;
        }
        goatFieldBo.setCurrentPage(1);
        goatFieldBo.setPageBoolean(true);
        goatFieldBo.setPageSize(1);
        List<GoatFieldVo> goatFieldVoList = findGoatFieldList(goatFieldBo);
        if(goatFieldVoList.size() == 0){
            return null;
        }
        return goatFieldVoList.get(0);
    }

    /**
     * 新增广告列
     * @param goatField
     */
    public void addField(GoatField goatField){
        if(goatField == null || goatField.getLocationId() == null){
            return;
        }
        goatFieldMapper.insertSelective(goatField);
    }

    /**
     * 更新广告列
     * @param goatField
     */
    public void updateGoatField(GoatField goatField){
        if(goatField == null || goatField.getLocationId() == null){
            return;
        }
        goatFieldMapper.updateByPrimaryKeySelective(goatField);
    }

}
