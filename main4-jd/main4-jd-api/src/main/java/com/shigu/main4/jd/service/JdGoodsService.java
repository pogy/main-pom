package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdWareAddVO;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:45
 * 京东商品接口
 */
public interface JdGoodsService {

    /**
     * 商品一键上传到京东
     * @param bo
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
     JdWareAddVO upToJd(JdUpBO bo,Long jdUid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 新增和修改商品图片
     */
    Boolean jdImageUpdate(JdImageUpdateBO bo,Long jdUid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 根据cid查询商品是否可上传到京东
     * @param tbCid
     */
    Boolean goodsCanbeUploadedToJd(Long tbCid) ;
}
