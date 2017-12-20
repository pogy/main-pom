package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.ExpressVO;

/**
 * @类编号
 * @类名称：ExpressModel
 * @文件路径：com.shigu.main4.daifa.model.ExpressModel
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 16:42
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface ExpressModel {
    /**
     * ====================================================================================
     * @方法名： 
     * @user gzy 2017/8/9 16:50
     * @功能： 使用快递ID查询到快递鸟账户再用寄件信息调用快递信息的生成
     * @param: bo
     * @return: 返回单个快递单信息
     * @exception: 
     * ====================================================================================
     * 
     */
    ExpressVO callExpress(OrderExpressBO bo)throws DaifaException;
}
