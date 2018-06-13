package com.shigu.main4.item.processes;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.TbOnsaleException;
import com.shigu.main4.item.exceptions.TbPropException;
import com.shigu.main4.item.vo.PropertyItemVO;
import com.shigu.main4.item.vo.PropertyValueVO;
import com.shigu.main4.item.vo.PropsVO;
import com.shigu.main4.item.vo.TbOnsale;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 淘宝商品查询类业务
 */
public interface TaobaoItemSelProcess {

    /**
     * 查询出售中的商品
     * @param shopId 店铺ID
     * @param keyword 关键词
     * @param pageNo 页码
     * @param pageSize 每页最大
     * @return
     */
    ShiguPager<TbOnsale> selTbOnsale(Long shopId, String keyword, int pageNo, int pageSize) throws TbOnsaleException;

    /**
     * 计算交易数
     * @param nick
     * @param numIids
     * @param from
     * @param to
     * @return
     * @throws Main4Exception
     */
    Map<Long, Long> calculateTrade(String nick, List<Long> numIids, Date from, Date to) throws Main4Exception;

    /**
     * 查询商品属性信息
     * @param cid
     * @return
     * @throws TbPropException
     */
    PropsVO selProps(Long cid) throws TbPropException;

    PropertyItemVO selItemVoBySub(Long cid, String path) throws TbPropException;

    List<PropertyValueVO> propselect(Long cid, String key);

    String propmore(Long cid, String value);

}
