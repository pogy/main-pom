package com.shigu.main4.jd.service;


import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdAgingTemplateVO;

import java.util.List;

/**
 * Created By admin on 2017/12/14/17:13
 * 京东阿尔法API
 */
public interface JdAgingtemplService {
    /**
     * 商家时效模板查询接口
     * @param accessToken
     * @return
     * @throws JdException
     */
    List<JdAgingTemplateVO> getAgingtempl(String accessToken) throws  JdUpException;

}
