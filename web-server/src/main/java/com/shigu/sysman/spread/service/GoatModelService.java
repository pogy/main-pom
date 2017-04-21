package com.shigu.sysman.spread.service;


import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.beans.GoatModel;
import com.opentae.data.mall.examples.GoatLocationExample;
import com.opentae.data.mall.examples.GoatModelExample;
import com.opentae.data.mall.interfaces.GoatLocationMapper;
import com.opentae.data.mall.interfaces.GoatModelMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.spread.bo.GoatLocationBo;
import com.shigu.sysman.spread.bo.GoatModelBo;
import com.shigu.sysman.spread.vo.GoatLocationVo;
import com.shigu.sysman.spread.vo.GoatModelVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告模板SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:16
 *
 */
@Service
public class GoatModelService {

    @Resource(name = "tae_mall_goatModelMapper")
    private GoatModelMapper goatModelMapper;

    /**
     * 广告模板列表
     * @param goatModelBo
     * @return
     */
    public List<GoatModelVo> findGoatModelList(GoatModelBo goatModelBo){
        if(goatModelBo == null){
            goatModelBo = new GoatModelBo();
        }
        GoatModelExample goatModelExample = createGoatModelExample(goatModelBo);
        List<GoatModel> goatModelList = new ArrayList<GoatModel>();
        if (goatModelBo.isPageBoolean()) {
            goatModelList = goatModelMapper.selectByConditionList(goatModelExample);
        } else {
            goatModelList = goatModelMapper.selectByExample(goatModelExample);
        }
        List<GoatModelVo> goatModelVoList = BeanMapper.mapList(goatModelList, GoatModelVo.class);
        return goatModelVoList;
    }

    /**
     * 创建条件example
     * @param goatModelBo
     * @return
     */
    public GoatModelExample createGoatModelExample(GoatModelBo goatModelBo){
        GoatModelExample goatModelExample = new GoatModelExample();
        GoatModelExample.Criteria crt = goatModelExample.createCriteria();
        if(goatModelBo.isPageBoolean()){
            // 需要分页
            goatModelExample.setStartIndex(goatModelBo.getStartRow());
            goatModelExample.setEndIndex(goatModelBo.getStartRow() + goatModelBo.getPageSize());
        }
        // 查询条件
        if(goatModelBo.getModelId() != null){
            crt.andModelIdEqualTo(goatModelBo.getModelId());
        }
        return goatModelExample;
    }

    /**
     * 记录数
     * @param goatModelBo
     * @return
     */
    public int countGoatModelByBo(GoatModelBo goatModelBo){
        if(goatModelBo == null){
            goatModelBo = new GoatModelBo();
        }
        GoatModelExample goatModelExample = createGoatModelExample(goatModelBo);
        int count = goatModelMapper.countByExample(goatModelExample);
        return count;
    }

    /**
     * 广告模板分页列表
     * @param goatModelBo
     * @return
     */
    public ShiguPager<GoatModelVo> findGoatModelPager(GoatModelBo goatModelBo){
        if (goatModelBo == null) {
            goatModelBo = new GoatModelBo();
        }
        goatModelBo.setPageBoolean(true);
        List<GoatModelVo> goatModelVoList = findGoatModelList(goatModelBo);
        int count = countGoatModelByBo(goatModelBo);
        ShiguPager<GoatModelVo> shiguPager = new ShiguPager<GoatModelVo>();
        shiguPager.setContent(goatModelVoList);
        shiguPager.calPages(count, goatModelBo.getPageSize());
        shiguPager.setNumber(goatModelBo.getCurrentPage());
        return shiguPager;
    }

    /**
     * 广告模板查询
     * @param goatModelBo
     * @return
     */
    public GoatModelVo findGoatModelByBo(GoatModelBo goatModelBo){
        if(goatModelBo == null){
            return null;
        }
        goatModelBo.setCurrentPage(1);
        goatModelBo.setPageBoolean(true);
        goatModelBo.setPageSize(1);
        List<GoatModelVo> goatModelVoList = findGoatModelList(goatModelBo);
        if(goatModelVoList.size() == 0){
            return null;
        }
        return goatModelVoList.get(0);
    }

    /**
     * 新增广告模板
     * @param goatModel
     */
    public void addModel(GoatModel goatModel){
        if(goatModel == null || goatModel.getModelId() == null){
            return;
        }
        goatModelMapper.insertSelective(goatModel);
    }

    /**
     * 更新广告模板
     * @param goatModel
     */
    public void updateGoatModel(GoatModel goatModel){
        if(goatModel == null || goatModel.getModelId() == null){
            return;
        }
        goatModelMapper.updateByPrimaryKeySelective(goatModel);
    }


}
