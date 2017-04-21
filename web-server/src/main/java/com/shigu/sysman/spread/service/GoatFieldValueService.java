package com.shigu.sysman.spread.service;


import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.examples.GoatFieldValueExample;
import com.opentae.data.mall.interfaces.GoatFieldValueMapper;
import com.opentae.data.mall.interfaces.GoatFieldValueMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.spread.bo.GoatFieldValueBo;
import com.shigu.sysman.spread.bo.GoatFieldValueBo;
import com.shigu.sysman.spread.vo.GoatFieldValueVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告数据SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/10 13:33
 *
 */
@Service
public class GoatFieldValueService {

    @Resource(name = "tae_mall_goatFieldValueMapper")
    private GoatFieldValueMapper goatFieldValueMapper;

    /**
     * 广告数据列表
     * @param goatFieldValueBo
     * @return
     */
    public List<GoatFieldValueVo> findGoatValueList(GoatFieldValueBo goatFieldValueBo){
        if(goatFieldValueBo == null){
            goatFieldValueBo = new GoatFieldValueBo();
        }
        GoatFieldValueExample goatModelExample = createGoatFieldValueExample(goatFieldValueBo);
        List<GoatFieldValue> goatModelList = new ArrayList<GoatFieldValue>();
        if (goatFieldValueBo.isPageBoolean()) {
            goatModelList = goatFieldValueMapper.selectByConditionList(goatModelExample);
        } else {
            goatModelList = goatFieldValueMapper.selectByExample(goatModelExample);
        }
        List<GoatFieldValueVo> goatModelVoList = BeanMapper.mapList(goatModelList, GoatFieldValueVo.class);
        return goatModelVoList;
    }

    /**
     * 创建条件example
     * @param goatFieldValueBo
     * @return
     */
    public GoatFieldValueExample createGoatFieldValueExample(GoatFieldValueBo goatFieldValueBo){
        GoatFieldValueExample goatFieldValueExample = new GoatFieldValueExample();
        GoatFieldValueExample.Criteria crt = goatFieldValueExample.createCriteria();
        if(goatFieldValueBo.isPageBoolean()){
            // 需要分页
            goatFieldValueExample.setStartIndex(goatFieldValueBo.getStartRow());
            goatFieldValueExample.setEndIndex(goatFieldValueBo.getStartRow() + goatFieldValueBo.getPageSize());
        }
        // 查询条件
        if(goatFieldValueBo.getVidId() != null){
            crt.andVidEqualTo(goatFieldValueBo.getVidId());
        }
        if(goatFieldValueBo.getfId() != null){
            crt.andFidEqualTo(goatFieldValueBo.getfId());
        }
        if(goatFieldValueBo.getGoatId() != null){
            crt.andGoatIdEqualTo(goatFieldValueBo.getGoatId());
        }
        return goatFieldValueExample;
    }

    /**
     * 记录数
     * @param goatModelBo
     * @return
     */
    public int countGoatFieldValueByBo(GoatFieldValueBo goatModelBo){
        if(goatModelBo == null){
            goatModelBo = new GoatFieldValueBo();
        }
        GoatFieldValueExample goatModelExample = createGoatFieldValueExample(goatModelBo);
        int count = goatFieldValueMapper.countByExample(goatModelExample);
        return count;
    }

    /**
     * 广告数据分页列表
     * @param goatFieldValueBo
     * @return
     */
    public ShiguPager<GoatFieldValueVo> findGoatFieldValuePager(GoatFieldValueBo goatFieldValueBo){
        if (goatFieldValueBo == null) {
            goatFieldValueBo = new GoatFieldValueBo();
        }
        goatFieldValueBo.setPageBoolean(true);
        List<GoatFieldValueVo> goatModelVoList = findGoatValueList(goatFieldValueBo);
        int count = countGoatFieldValueByBo(goatFieldValueBo);
        ShiguPager<GoatFieldValueVo> shiguPager = new ShiguPager<GoatFieldValueVo>();
        shiguPager.setContent(goatModelVoList);
        shiguPager.calPages(count, goatFieldValueBo.getPageSize());
        shiguPager.setNumber(goatFieldValueBo.getCurrentPage());
        return shiguPager;
    }

    /**
     * 广告数据查询
     * @param goatFieldValueBo
     * @return
     */
    public GoatFieldValueVo findGoatFieldValueByBo(GoatFieldValueBo goatFieldValueBo){
        if(goatFieldValueBo == null){
            return null;
        }
        goatFieldValueBo.setCurrentPage(1);
        goatFieldValueBo.setPageBoolean(true);
        goatFieldValueBo.setPageSize(1);
        List<GoatFieldValueVo> goatFieldValueVoList = findGoatValueList(goatFieldValueBo);
        if(goatFieldValueVoList.size() == 0){
            return null;
        }
        return goatFieldValueVoList.get(0);
    }

    /**
     * 新增广告数据
     * @param goatFieldValue
     */
    public void addFieldValue(GoatFieldValue goatFieldValue){
        if(goatFieldValue == null || goatFieldValue.getGoatId() == null){
            return;
        }
        goatFieldValueMapper.insertSelective(goatFieldValue);
    }

    /**
     * 更新广告数据
     * @param goatFieldValue
     */
    public void updateGoatFieldValue(GoatFieldValue goatFieldValue){
        if(goatFieldValue == null || goatFieldValue.getGoatId() == null){
            return;
        }
        goatFieldValueMapper.updateByPrimaryKeySelective(goatFieldValue);
    }

    /**
     * 删除广告数据
     * @param fieldValueId
     */
    public void delGoatFieldValue(Long fieldValueId){
        if(fieldValueId == null){
            return;
        }
        goatFieldValueMapper.deleteByPrimaryKey(fieldValueId);
    }
}
