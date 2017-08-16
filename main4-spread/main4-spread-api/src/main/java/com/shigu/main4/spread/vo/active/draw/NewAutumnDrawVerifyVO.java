package com.shigu.main4.spread.vo.active.draw;

/**
 * 类名：NewAutumnDrawVerifyVO
 * 类路径：com.shigu.main4.spread.vo.active.draw.NewAutumnDrawVerifyVO
 * 创建者：王浩翔
 * 创建时间：2017-08-15 9:19
 * 项目：main-pom
 * 描述：秋装新品发布会抽奖资格信息
 */
public class NewAutumnDrawVerifyVO extends DrawVerifyVO {
    /**
     * shigu_temp表记录抽奖资格信息：DRAW_RECORD_FLAG：flag="new_autumn_0811_draw_qualification"
     * key1:userId
     * key2:usedFrequency 已用次数
     * key3:可抽奖总次数
     * key4:上款量
     * key5:已中奖项
     * key6:常量信息
     */
    /**
     * 秋装活动上款记录标记
     */
    public static final String[] UPLOAD_FLAG = {"new_autumn_0811", "new_autumn_0811_closed"};
    /**
     * 秋装活动抽奖记录标记
     */
    public static final String DRAW_RECORD_FLAG = "new_autumn_0811_draw_qualification";
    /**
     * 秋装活动标记
     */
    public static final String NEW_AUTUMN_FLAG = "new_autumn_0811";
    /**
     * 秋装新品发布会中对应用户中奖记录id
     */
    private Long id;
    /**
     * 秋装新品发布会用户对应抽奖次数记录id，记录在数据库表shigu_temp中
     */
    private Long drawVerifyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrawVerifyId() {
        return drawVerifyId;
    }

    public void setDrawVerifyId(Long drawVerifyId) {
        this.drawVerifyId = drawVerifyId;
    }

}
