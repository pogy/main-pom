package com.shigu.main4.item.processes;

import com.shigu.main4.item.bo.PropImgBO;
import com.shigu.main4.item.bo.SubmitedPropsBO;
import com.shigu.main4.item.bo.UptoTbBO;
import com.shigu.main4.item.exceptions.TbApiException;
import com.shigu.main4.item.exceptions.TbException;
import com.shigu.main4.item.vo.ItemVO;
import com.shigu.main4.item.vo.PropsVO;
import com.shigu.main4.item.vo.SessionVO;

import java.util.List;

/**
 * 一键上传服务
 */
public interface TaobaoAddItemProcess {
    /**
     * 添加一个商品基本信息到淘宝
     * @param bo 商品的基本信息
     * @param spv 商品属性
     * @param sellerCids 店内类目信息
     * @param session 用户授权信息
     * @return 上传后的商品信息
     */
    ItemVO addItemBase(UptoTbBO bo, SubmitedPropsBO spv, String[] sellerCids, SessionVO session) throws TbApiException;

    /**
     * 添加一个商品主图
     * @param numIid 商品淘宝numIid
     * @param url 图片链接
     * @param position 位置
     * @param major 是否主图
     * @param session 授权信息
     * @return 结果
     */
    String addOneImg(Long numIid, String url, Long position, boolean major, SessionVO session);

    /**
     * 添加一个属性图
     * @param numIid 淘宝商品numIid
     * @param url 图片链接
     * @param properties 位置
     * @param session 用户授权信息
     * @return 结果
     */
    String addOnePropImg(Long numIid, String url, String properties, SessionVO session);

    /**
     * 填充属性值
     * @param propsVO
     * @param prop
     * @param propImgs
     * @param alias
     * @param inputStr
     * @param inputIds
     * @return
     */
    PropsVO importValue(PropsVO propsVO, String prop, List<PropImgBO> propImgs, String alias, String inputStr, String inputIds) throws TbException;

    /**
     * 更新手机详情
     * @param desc
     * @param numIid
     * @param session
     * @param title
     * @param userId
     * @param nick
     * @return
     */
    String updateWldesc(String desc, Long numIid, String session, String title, Long userId, String nick) throws TbException;
}
