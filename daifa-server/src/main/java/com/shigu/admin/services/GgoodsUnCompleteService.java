package com.shigu.admin.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsMapper;
import com.shigu.admin.bo.GgoodsUmCompleteBO;
import com.shigu.admin.vo.GgoodsUmCompleteVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：GgoodsUnCompleteService
 * @文件路径：com.shigu.admin.services.GgoodsUnCompleteService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/1 13:39
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class GgoodsUnCompleteService {
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;

    /**
     * ====================================================================================
     * @方法名： listByPage
     * @user gzy 2017/10/1 14:02
     * @功能：查询列表
     * @param: []
     * @return: java.util.List<com.shigu.admin.vo.GgoodsUmCompleteVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<GgoodsUmCompleteVO> listByPage(GgoodsUmCompleteBO bo) {

        DaifaGgoodsExample example = new DaifaGgoodsExample();
        example.setOrderByClause("create_date asc,seller_id desc,daifa_worker_id asc");
        DaifaGgoodsExample.Criteria ce = example.createCriteria();
        ce.andTakeGoodsStatusEqualTo (0);
        //example.isDistinct ();
        example.setDistinct (true);
        List<GgoodsUmCompleteVO> listVO=new ArrayList<> ();
        //按条件查询本页数据
        List<DaifaGgoods> list= daifaGgoodsMapper.selectFieldsByExample (example, FieldUtil.codeFields ("create_date,daifa_worker,daifa_worker_id,seller_id"));;

        if(list.size ()>0){
            for (DaifaGgoods ggoods: list) {
                //设置成前台可用的页面
                GgoodsUmCompleteVO vo=new GgoodsUmCompleteVO ();
                BeanUtils.copyProperties(ggoods, vo );
                listVO.add (vo);
            }
        }
        //返回前台页面
        return listVO;
    }

    /**
     * ====================================================================================
     * @方法名： update
     * @user gzy 2017/10/1 14:13
     * @功能：拿货完成
     * @param: [bo]
     * @return: java.util.List<java.lang.Long>
     * @exception:
     * ====================================================================================
     *
     */
    public List<Long> update(GgoodsUmCompleteBO bo) throws DaifaException {

        return takeGoodsIssueProcess.completeWithDate (bo.getCreateDate (),bo.getSellerId ());
    }

}
