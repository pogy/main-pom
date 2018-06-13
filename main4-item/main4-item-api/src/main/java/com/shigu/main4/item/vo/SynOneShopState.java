package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.*;

/**
 * Created by wxc on 2017/3/17.
 *
 * 本次同步全店处理结果
 *
 * @author wxc
 * @version tb_site4.0 4.0.0
 * @since tb_site4.0 4.0.0
 */
public class SynOneShopState implements Serializable{

    public SynOneShopState(Long shopId) {
        this.shopId = shopId;
        this.time = new Date();
    }

    /**
     *  店铺
     */
    private long shopId;

    /**
     * 更新商品
     */
    private int updated;

    /**
     * 无变化
     */
    private int unchanged;

    /**
     * 创建商品
     */
    private int created;

    /**
     * 上架商品
     */
    private int up;

    /**
     * 下架商品
     */
    private int down;

    /**
     * 同步时间
     */
    private Date time;

    private boolean sessionInvalid;

    private List<Long> unprocessed = new ArrayList<Long>();

    private Map<Long, String> errorReason = new HashMap<Long, String>();

    public long getShopId() {
        return shopId;
    }

    public int getUpdated() {
        return updated;
    }

    public void addUpdated() {
        this.updated++;
    }

    public int getUnchanged() {
        return unchanged;
    }

    public void addUnchanged() {
        this.unchanged++;
    }

    public int getCreated() {
        return created;
    }

    public void addCreated() {
        this.created++;
    }

    public int getUp() {
        return up;
    }

    public void addUp() {
        this.up++;
    }

    public int getDown() {
        return down;
    }

    public void addDown() {
        this.down++;
    }

    public Date getTime() {
        return time;
    }

    public List<Long> getUnprocessed() {
        return unprocessed;
    }

    public void addUnprocessed(Long unprocessed) {
        this.unprocessed.add(unprocessed);
    }

    public Map<Long, String> getErrorReason() {
        return errorReason;
    }

    public void addErrorReason(Long itemId, String message) {
        this.errorReason.put(itemId, message);
    }

    public boolean isSessionInvalid() {
        return sessionInvalid;
    }

    public void setSessionInvalid() {
        sessionInvalid = true;
    }

    @Override
    public String toString() {
        return "全店同步处理结果: { " +
                "'店铺ID':" + shopId +
                ", '授权':" + (sessionInvalid ? "失效":"正常") +
                ", '更新数':" + updated +
                ", '无修改':" + unchanged +
                ", '创建数':" + created +
                ", '上架数':" + up +
                ", '下架数':" + down +
                ", '同步时间':" + time +
                ", '忽略商品':" + unprocessed +
                ", '出错商品':" + errorReason +
                "}";
    }
}
