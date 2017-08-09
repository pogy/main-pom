package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.vo.ExpressVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @类编号
 * @类名称：ExpressModelImpl
 * @文件路径：com.shigu.main4.daifa.model.ExpressModelImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 17:12
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Repository
@Scope("prototype")
public class ExpressModelImpl implements ExpressModel{

    private Long expressId;
    public ExpressModelImpl(Long expressId){
            this.expressId=expressId;
    }
    @Override
    public ExpressVO callExpress (OrderExpressBO bo) {
        return null;
    }
}
