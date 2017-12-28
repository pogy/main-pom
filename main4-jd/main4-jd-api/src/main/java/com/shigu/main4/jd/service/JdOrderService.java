package com.shigu.main4.jd.service;

import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdPostTemplateVO;

import java.util.List;

/**
 * Created By admin on 2017/12/26/15:05
 * 订单API
 * 获取商家运费模板
 */
public interface JdOrderService {
    /**
     * 获取商家运费模板
     * @param jdUid
     * @return
     */
    List<JdPostTemplateVO> getPostTemplates(Long jdUid) throws JdUpException, JdAuthFailureException;

    /**
     * 更新商家运费模板
     * @param jdUid
     * @return
     */
    List<JdPostTemplateVO> updatePostTemplates(Long jdUid) throws JdUpException, JdAuthFailureException;
}
