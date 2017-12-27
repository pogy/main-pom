package com.shigu.goodsup.jd.vo;

import com.shigu.main4.jd.vo.JdCategoryVO;
import com.shigu.main4.jd.vo.JdPostTemplateVO;
import com.shigu.main4.jd.vo.JdShopInfoVO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created By admin on 2017/12/15/16:06
 */
public class JdShowDataVO implements Serializable{

    private static final long serialVersionUID = -8117932286540806237L;
    /**
     * 用户京东ID
     */
    private Long jdUserId;
    /**
     * 用户京东昵称
     */
    private String jdNick;
    /**
     * 用户京东店铺信息
     */
    private JdShopInfoVO jdShopInfo;

    /**
     * 店内类目
     */
    private List<JdCategoryVO> jdCategory;
    /**
     * 运费模板
     */
    private List<JdPostTemplateVO> deliveyList;
    /**
     * 此前用过的快递模板ID
     */
    private Long erverDyTemplateId;
    /**
     * 日期列表用
     */
    private List<Date> dateList;
    /**
     *  timestamp+tbUserId+goodsId进行ras
     *  每一次访问产生新的
     */
    private String token;//授权码
    /**
     * 每一次访问的时间点
     */
    private Long timestamp;//时间挫
    /**
     * 手机的验签
     */
    private String mobileSign;
    /**
     * 验签
     */
    private String sign;

    public List<JdCategoryVO> getJdCategory() {
        return jdCategory;
    }

    public void setJdCategory(List<JdCategoryVO> jdCategory) {
        this.jdCategory = jdCategory;
    }

    public Long getErverDyTemplateId() {
        return erverDyTemplateId;
    }

    public void setErverDyTemplateId(Long erverDyTemplateId) {
        this.erverDyTemplateId = erverDyTemplateId;
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(String mobileSign) {
        this.mobileSign = mobileSign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getJdUserId() {
        return jdUserId;
    }

    public void setJdUserId(Long jdUserId) {
        this.jdUserId = jdUserId;
    }

    public String getJdNick() {
        return jdNick;
    }

    public void setJdNick(String jdNick) {
        this.jdNick = jdNick;
    }

    public JdShopInfoVO getJdShopInfo() {
        return jdShopInfo;
    }

    public void setJdShopInfo(JdShopInfoVO jdShopInfo) {
        this.jdShopInfo = jdShopInfo;
    }

    public List<JdPostTemplateVO> getDeliveyList() {
        return deliveyList;
    }

    public void setDeliveyList(List<JdPostTemplateVO> deliveyList) {
        this.deliveyList = deliveyList;
    }
}
