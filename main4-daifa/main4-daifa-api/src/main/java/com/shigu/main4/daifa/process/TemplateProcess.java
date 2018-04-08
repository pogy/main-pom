package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.vo.ExpressCompanyVo;
import com.shigu.main4.daifa.vo.ExpressProv;
import com.shigu.main4.daifa.vo.ShowTempVo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.process
 * @ClassName: TemplateProcess
 * @Author: sy
 * @CreateDate: 2018/4/3 0003 14:45
 */
public interface TemplateProcess {

    /**
     * 插入模版对象
     * @return 模版id
     */
    Long addExpressTemplate();

    /**
     * 插入父规则对象
     * @param templateId 模版id
     * @return 父规则id
     */
    Long addExpressParentRule(Long templateId);

    /**
     * 插入默认规则对象生成运费的列
     * @param templateId 模版id
     * @return 父规则id
     */
    Long addExpressdefaultRule(Long templateId,Integer number,String ruleTile);

    /**
     * 获取城市列表
     * @return 城市集合
     */
    List<ExpressProv> selectProvList();

    /**
     * 插入快递省对象
     * @param templateId 模版id
     * @param parentRuleId 父规则id
     * @param provIds 省份id
     * @return 数据库条数
     */
    Integer insertExpressProv(Long templateId,Long parentRuleId,String provIds);

    /**
     * 删除规则对象
     * @param parentRuleId 父规则id
     * @return 父规则id
     */
    Integer deleteParentRule(Long parentRuleId);

    /**
     * 保存新增模版
     * @param expressTemplate json字符串
     * @return
     */
    Integer saveExpressTemplate(String expressTemplate);

    /**
     * 保存修改模版
     * @param expressTemplate json字符串
     * @return
     */
    Integer EditExpressTemplate(String expressTemplate);

    /**
     * 删除默认规则对象和所属运费列的所有规则
     * @param templateId 模版id
     * @return 父规则id
     */
    Integer deleteExpressdefaultRule(Long templateId,Integer number);

    /**
     * 查询所有快递公司
     * @return 快递列表
     */
    List<ExpressCompanyVo> selectExpressCompany();

    /**
     * 插入默认规则对象生成运费的列
     * @param templateId 模版id
     * @return 父规则id
     */
    Integer templateEnabled(Long templateId,Boolean b);

    /**
     * 查询所有快递模版
     * @return 模版集合
     */
    List<ShowTempVo> selectTemplateAll();

    /**
     * 编辑递模版
     * @param templateId 模版id
     * @return 模版集合
     */
    Map<String,Object> selectEditTemplate(Long templateId);

}
